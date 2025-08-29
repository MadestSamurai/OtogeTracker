package com.madsam.otora.data.bof.local.repository

import android.util.Log
import com.madsam.otora.data.bof.local.model.BofWorkEntity
import com.madsam.otora.data.bof.local.model.BofWorkEntity_
import com.madsam.otora.data.bof.remote.model.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.objectbox.Box
import java.util.*

private const val TAG = "BofRepository"

/**
 * 统一的BOFTT仓库
 * 使用层次化二分查找算法，专注于高效查询作品四项数据排行榜
 */
internal class BofRepository(
    private val bofWorkBox: Box<BofWorkEntity>
) {
    
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
        
    private val scoreYearsAdapter: JsonAdapter<List<BofScoreYear>> =
        moshi.adapter(Types.newParameterizedType(List::class.java, BofScoreYear::class.java))
        
    private val metadataAdapter: JsonAdapter<List<BofMetadataItem>> =
        moshi.adapter(Types.newParameterizedType(List::class.java, BofMetadataItem::class.java))

    /**
     * 流式分段处理 - 边解析边返回结果，避免JSON解析阻塞
     * 支持两个时间点的对比数据
     */
    suspend fun getRankingAtTimeStreamedWithComparison(
        currentTimestamp: Long,
        compareTimestamp: Long? = null,
        path: String = "tt",
        batchSize: Int = 20,
        onBatchReady: suspend (List<WorkRanking>) -> Unit
    ) {
        Log.d(TAG, "getRankingAtTimeStreamedWithComparison called with currentTimestamp: $currentTimestamp, compareTimestamp: $compareTimestamp, path: $path, batchSize: $batchSize")
        val startTime = System.currentTimeMillis()
        
        val allWorks = bofWorkBox.query(BofWorkEntity_.path.equal(path)).build().find()
        Log.d(TAG, "Starting streamed processing of ${allWorks.size} works with comparison for path: $path")
        
        val allCurrentResults = mutableListOf<WorkRanking>()
        val compareRankingMap = mutableMapOf<String, WorkRanking>() // workId -> WorkRanking
        
        // 如果有对比时间戳，先计算对比时间点的完整排行榜
        if (compareTimestamp != null) {
            Log.d(TAG, "Calculating compare ranking for timestamp: $compareTimestamp")
            val compareStart = System.currentTimeMillis()
            
            val compareResults = allWorks.mapNotNull { entity ->
                val scoreSnapshot = getScoreAtTime(entity, compareTimestamp)
                if (scoreSnapshot != null) {
                    WorkRanking(
                        workId = entity.compositeWorkId,
                        title = getTitleAtTime(entity, compareTimestamp),
                        artist = getArtistAtTime(entity, compareTimestamp),
                        score = scoreSnapshot.totalScore,
                        average = scoreSnapshot.average,
                        median = scoreSnapshot.median,
                        impression = scoreSnapshot.impression
                    )
                } else null
            }.sortedByDescending { it.score }
                .mapIndexed { index, work -> work.copy(rank = index + 1) }
            
            compareResults.forEach { work ->
                compareRankingMap[work.workId] = work
            }
            
            val compareEnd = System.currentTimeMillis()
            Log.d(TAG, "Compare ranking calculated in ${compareEnd - compareStart}ms, got ${compareResults.size} works")
        }
        
        var processedCount = 0
        
        // 分批处理当前时间点的数据
        allWorks.chunked(batchSize).forEach { batch ->
            val batchStart = System.currentTimeMillis()
            
            val batchResults = batch.mapNotNull { entity ->
                val scoreSnapshot = getScoreAtTime(entity, currentTimestamp)
                if (scoreSnapshot != null) {
                    val compareData = compareRankingMap[entity.compositeWorkId]
                    WorkRanking(
                        workId = entity.compositeWorkId,
                        title = getTitleAtTime(entity, currentTimestamp),
                        artist = getArtistAtTime(entity, currentTimestamp),
                        score = scoreSnapshot.totalScore,
                        average = scoreSnapshot.average,
                        median = scoreSnapshot.median,
                        impression = scoreSnapshot.impression,
                        // 对比数据
                        compareScore = compareData?.score,
                        compareAverage = compareData?.average,
                        compareMedian = compareData?.median,
                        compareImpression = compareData?.impression,
                        compareRank = compareData?.rank
                    )
                } else null
            }
            
            allCurrentResults.addAll(batchResults)
            processedCount += batch.size
            
            // 重新排序整体结果并分配排名，同时计算排名变化
            val currentSorted = allCurrentResults.sortedByDescending { it.score }
                .mapIndexed { index, work -> 
                    val rankChange = if (work.compareRank != null) {
                        work.compareRank - (index + 1) // 对比排名 - 当前排名，正数表示排名上升
                    } else null
                    
                    work.copy(
                        rank = index + 1,
                        rankChange = rankChange
                    )
                }
            
            val batchEnd = System.currentTimeMillis()
            Log.d(TAG, "Streamed batch ${processedCount}/${allWorks.size} completed in ${batchEnd - batchStart}ms")
            
            // 立即回调当前结果，让UI可以逐步显示
            onBatchReady(currentSorted)
            
            // 短暂让出线程，避免阻塞UI
            kotlinx.coroutines.delay(10)
        }
        
        val endTime = System.currentTimeMillis()
        Log.d(TAG, "getRankingAtTimeStreamedWithComparison completed in ${endTime - startTime}ms")
    }
    
    /**
     * 从API响应保存BOF数据
     */
    fun saveBofApiResponse(apiResponse: BofWorkResponse, path: String) {
        val works = apiResponse.getWorksAsList()
        val compactEntities = works.map { work -> convertToCompactEntity(work, path) }
        insertWorks(compactEntities)
    }

    /**
     * 批量插入或更新作品数据
     */
    fun insertWorks(works: List<BofWorkEntity>) {
        bofWorkBox.put(works)
    }
    
    /**
     * 获取所有作品数量
     */
    fun getWorksCount(path: String = "tt"): Long = bofWorkBox.query(BofWorkEntity_.path.equal(path)).build().count()
    
    /**
     * 获取团队数据数量
     */
    fun getTeamCount(path: String): Long {
        return try {
            val objectBoxService = com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService()
            kotlinx.coroutines.runBlocking {
                objectBoxService.getBofTeamDetailedData(path).size.toLong()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error getting team count for path $path: ${e.message}", e)
            0L
        }
    }
    
    /**
     * 获取指定比赛路径的所有团队数据
     */
    suspend fun getTeamDataByPath(path: String): List<com.madsam.otora.data.bof.local.model.BofTeamDetailedEntity> {
        return try {
            val objectBoxService = com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService()
            objectBoxService.getBofTeamDetailedData(path)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting team data for path $path: ${e.message}", e)
            emptyList()
        }
    }
    
    /**
     * 获取指定团队的详细数据
     */
    suspend fun getTeamDetailedData(path: String, teamName: String): com.madsam.otora.data.bof.local.model.BofTeamDetailedEntity? {
        return try {
            val objectBoxService = com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService()
            objectBoxService.getBofTeamDetailedData(path, teamName)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting team detailed data for $path/$teamName: ${e.message}", e)
            null
        }
    }

    /**
     * 层次化查找指定时间点的得分数据
     */
    private fun getScoreAtTime(entity: BofWorkEntity, targetTimestamp: Long): BofTTScoreSnapshot? {
        if (entity.scoreDataJson.isEmpty()) return null
        
        try {
            val scoreYears = scoreYearsAdapter.fromJson(entity.scoreDataJson) ?: return null
            return findScoreByHierarchicalSearch(scoreYears, targetTimestamp)
        } catch (e: Exception) {
            return null
        }
    }
    
    /**
     * 层次化查找指定时间点的标题
     */
    private fun getTitleAtTime(entity: BofWorkEntity, targetTimestamp: Long): String {
        if (entity.titleHistoryJson.isEmpty()) return entity.currentTitle
        
        try {
            val titleHistory = metadataAdapter.fromJson(entity.titleHistoryJson) ?: return entity.currentTitle
            return findMetadataByHierarchicalSearch(titleHistory, targetTimestamp) ?: entity.currentTitle
        } catch (e: Exception) {
            return entity.currentTitle
        }
    }
    
    /**
     * 层次化查找指定时间点的艺术家
     */
    private fun getArtistAtTime(entity: BofWorkEntity, targetTimestamp: Long): String {
        if (entity.artistHistoryJson.isEmpty()) return entity.currentArtist
        
        try {
            val artistHistory = metadataAdapter.fromJson(entity.artistHistoryJson) ?: return entity.currentArtist
            return findMetadataByHierarchicalSearch(artistHistory, targetTimestamp) ?: entity.currentArtist
        } catch (e: Exception) {
            return entity.currentArtist
        }
    }
    
    /**
     * 核心算法：层次化二分查找得分记录
     * 直接在 Year -> Month -> Day -> Hour -> Minute 结构上查找
     */
    private fun findScoreByHierarchicalSearch(
        scoreYears: List<BofScoreYear>,
        targetTimestamp: Long
    ): BofTTScoreSnapshot? {
        
        // 解析目标时间
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = targetTimestamp
        val targetYear = calendar.get(Calendar.YEAR)
        val targetMonth = calendar.get(Calendar.MONTH) + 1
        val targetDay = calendar.get(Calendar.DAY_OF_MONTH)
        val targetHour = calendar.get(Calendar.HOUR_OF_DAY)
        val targetMinute = calendar.get(Calendar.MINUTE)
        
        var bestMatch: BofTTScoreSnapshot? = null
        var bestTimestamp = Long.MIN_VALUE
        
        // 1. 遍历年份（升序）
        val sortedYears = scoreYears.sortedBy { it.year }
        for (yearData in sortedYears) {
            if (yearData.year > targetYear) break
            
            // 2. 遍历月份（升序）
            val sortedMonths = yearData.months.sortedBy { it.month }
            for (monthData in sortedMonths) {
                if (yearData.year == targetYear && monthData.month > targetMonth) break
                
                // 3. 遍历日期（升序）
                val sortedDays = monthData.days.sortedBy { it.day }
                for (dayData in sortedDays) {
                    if (yearData.year == targetYear && monthData.month == targetMonth && dayData.day > targetDay) break
                    
                    // 4. 遍历小时（升序）
                    val sortedHours = dayData.hours.sortedBy { it.hour }
                    for (hourData in sortedHours) {
                        if (yearData.year == targetYear && monthData.month == targetMonth &&
                            dayData.day == targetDay && hourData.hour > targetHour) break
                        
                        // 5. 遍历分钟（升序，二分查找优化）
                        val sortedMinutes = hourData.minutes.sortedBy { it.minute }
                        val validMinutes = if (yearData.year == targetYear && monthData.month == targetMonth &&
                                            dayData.day == targetDay && hourData.hour == targetHour) {
                            // 如果是目标时间的精确时分，使用二分查找
                            val minuteIndex = binarySearchMinute(sortedMinutes, targetMinute)
                            if (minuteIndex >= 0) sortedMinutes.subList(0, minuteIndex + 1) else emptyList()
                        } else {
                            // 否则取所有分钟
                            sortedMinutes
                        }
                        
                        // 找到这个小时内的最佳匹配
                        for (minuteData in validMinutes) {
                            val currentTimestamp = createTimestamp(
                                yearData.year, monthData.month, dayData.day, hourData.hour, minuteData.minute
                            )
                            
                            if (currentTimestamp <= targetTimestamp && currentTimestamp > bestTimestamp) {
                                bestTimestamp = currentTimestamp
                                bestMatch = BofTTScoreSnapshot(
                                    timestamp = currentTimestamp,
                                    year = yearData.year,
                                    month = monthData.month,
                                    day = dayData.day,
                                    hour = hourData.hour,
                                    minute = minuteData.minute,
                                    totalScore = minuteData.values.total,
                                    average = minuteData.values.average,
                                    median = minuteData.values.median,
                                    impression = minuteData.values.impression
                                )
                            }
                        }
                    }
                }
            }
        }
        
        return bestMatch
    }
    
    /**
     * 层次化查找元数据记录
     */
    private fun findMetadataByHierarchicalSearch(
        metadataList: List<BofMetadataItem>,
        targetTimestamp: Long
    ): String? {
        if (metadataList.isEmpty()) return null
        
        // 转换并排序
        val timestampedItems = metadataList.map { item ->
            TimestampedMetadata(parseTimeString(item.time), item.value)
        }.sortedBy { it.timestamp }
        
        if (targetTimestamp < timestampedItems[0].timestamp) return null
        if (targetTimestamp >= timestampedItems.last().timestamp) {
            return timestampedItems.last().value
        }
        
        // 二分查找最佳匹配
        var left = 0
        var right = timestampedItems.size - 1
        var result = timestampedItems[0]
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            val midItem = timestampedItems[mid]
            
            if (midItem.timestamp <= targetTimestamp) {
                result = midItem
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return result.value
    }
    
    /**
     * 分钟级别的二分查找
     */
    private fun binarySearchMinute(minutes: List<BofScoreMinute>, targetMinute: Int): Int {
        var left = 0
        var right = minutes.size - 1
        var result = -1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (minutes[mid].minute <= targetMinute) {
                result = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return result
    }
    
    /**
     * 创建时间戳
     */
    private fun createTimestamp(year: Int, month: Int, day: Int, hour: Int, minute: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.set(year, month - 1, day, hour, minute, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }
    
    /**
     * 解析时间字符串
     */
    private fun parseTimeString(timeString: String): Long {
        return try {
            val format = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            format.parse(timeString)?.time ?: 0L
        } catch (e: Exception) {
            0L
        }
    }
    
    /**
     * 将BofTTWork转换为紧凑Entity
     */
    private fun convertToCompactEntity(work: BofWorkData, path: String = "tt"): BofWorkEntity {
        val entity = BofWorkEntity()
        
        entity.path = path
        entity.originalWorkId = work.id
        entity.compositeWorkId = BofWorkEntity.createCompositeWorkId(path, work.id)
        entity.currentTitle = work.title?.lastOrNull()?.value ?: ""
        entity.currentArtist = work.artist?.lastOrNull()?.value ?: ""
        entity.team = work.team ?: ""
        entity.genre = work.genre ?: ""
        
        // 直接存储原始JSON结构
        val scoreAdapter = moshi.adapter(List::class.java)
        entity.scoreDataJson = if (work.score != null) scoreAdapter.toJson(work.score) else ""
        entity.titleHistoryJson = if (work.title != null) moshi.adapter(List::class.java).toJson(work.title) else ""
        entity.artistHistoryJson = if (work.artist != null) moshi.adapter(List::class.java).toJson(work.artist) else ""
        
        // 计算时间范围和最新得分
        val timeRange = calculateTimeRange(work)
        entity.earliestTimestamp = timeRange.first
        entity.latestTimestamp = timeRange.second
        
        val latestScore = findLatestScore(work)
        entity.latestTotalScore = latestScore?.totalScore ?: 0
        entity.latestAverage = latestScore?.average ?: 0.0
        
        entity.lastUpdated = System.currentTimeMillis()
        
        return entity
    }
    
    /**
     * 计算时间范围
     */
    private fun calculateTimeRange(work: BofWorkData): Pair<Long, Long> {
        var earliest = Long.MAX_VALUE
        var latest = Long.MIN_VALUE
        
        work.score?.forEach { yearData ->
            yearData.months.forEach { monthData ->
                monthData.days.forEach { dayData ->
                    dayData.hours.forEach { hourData ->
                        hourData.minutes.forEach { minuteData ->
                            val timestamp = createTimestamp(
                                yearData.year, monthData.month, dayData.day,
                                hourData.hour, minuteData.minute
                            )
                            if (timestamp < earliest) earliest = timestamp
                            if (timestamp > latest) latest = timestamp
                        }
                    }
                }
            }
        }
        
        return if (earliest == Long.MAX_VALUE) {
            0L to 0L
        } else {
            earliest to latest
        }
    }
    
    /**
     * 查找最新得分
     */
    private fun findLatestScore(work: BofWorkData): BofTTScoreSnapshot? {
        var latestScore: BofTTScoreSnapshot? = null
        var latestTimestamp = Long.MIN_VALUE
        
        work.score?.forEach { yearData ->
            yearData.months.forEach { monthData ->
                monthData.days.forEach { dayData ->
                    dayData.hours.forEach { hourData ->
                        hourData.minutes.forEach { minuteData ->
                            val timestamp = createTimestamp(
                                yearData.year, monthData.month, dayData.day,
                                hourData.hour, minuteData.minute
                            )
                            if (timestamp > latestTimestamp) {
                                latestTimestamp = timestamp
                                latestScore = BofTTScoreSnapshot(
                                    timestamp = timestamp,
                                    year = yearData.year,
                                    month = monthData.month,
                                    day = dayData.day,
                                    hour = hourData.hour,
                                    minute = minuteData.minute,
                                    totalScore = minuteData.values.total,
                                    average = minuteData.values.average,
                                    median = minuteData.values.median,
                                    impression = minuteData.values.impression
                                )
                            }
                        }
                    }
                }
            }
        }
        
        return latestScore
    }
}

/**
 * 得分快照数据类
 */
internal data class BofTTScoreSnapshot(
    val timestamp: Long,
    val year: Int,
    val month: Int,
    val day: Int,
    val hour: Int,
    val minute: Int,
    val totalScore: Int,
    val average: Double,
    val median: Double,
    val impression: Int
)

/**
 * 作品排行数据类
 * @param workId 作品ID
 * @param title 作品标题（该时间点的标题）
 * @param artist 艺术家（该时间点的艺术家）
 * @param score 总分（用于排序）
 * @param average 平均分
 * @param median 中位值
 * @param impression 评价数
 * @param rank 排名（1开始，按总分降序）
 */
data class WorkRanking(
    val workId: String,
    val title: String,
    val artist: String,
    val score: Int,
    val average: Double,
    val median: Double,
    val impression: Int,
    val rank: Int = 0,
    // 综合分数 (Double类型保留小数)
    val compositeScore: Double? = null,
    // 对比数据 (来自第二个时间点)
    val compareScore: Int? = null,
    val compareAverage: Double? = null,
    val compareMedian: Double? = null,
    val compareImpression: Int? = null,
    val compareRank: Int? = null,
    val compareCompositeScore: Double? = null, // 对比综合分数
    // 变化量
    val rankChange: Int? = null // 正数表示排名上升，负数表示排名下降
) {
    // 实现 RankingItem 接口的适配器
    fun toRankingItem(): com.madsam.otora.ui.common.RankingItem = object : com.madsam.otora.ui.common.RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.score
        override val extraData: Number? = if (this@WorkRanking.impression > 0) this@WorkRanking.impression else null
        override val avgScore: Double? = if (this@WorkRanking.average > 0) this@WorkRanking.average else null
        override val medianScore: Double? = if (this@WorkRanking.median > 0) this@WorkRanking.median else null
        override val rankChange: Int? = this@WorkRanking.rankChange
        override val compareRank: Int? = this@WorkRanking.compareRank
        override val compareScore: Number? = this@WorkRanking.compareScore
    }
    
    // 专门用于平均分排行的适配器 - 将平均分作为主要分数显示
    fun toAverageRankingItem(): com.madsam.otora.ui.common.RankingItem = object : com.madsam.otora.ui.common.RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.average // 将平均分作为主要分数
        override val extraData: Number? = if (this@WorkRanking.impression > 0) this@WorkRanking.impression else null
        override val avgScore: Double? = null // 不显示额外的平均分列
        override val medianScore: Double? = null // 不显示中位数列
        override val rankChange: Int? = this@WorkRanking.rankChange
        override val compareRank: Int? = this@WorkRanking.compareRank
        override val compareScore: Number? = this@WorkRanking.compareAverage // 对比平均分
    }
    
    // 专门用于中位数排行的适配器 - 将中位数作为主要分数显示
    fun toMedianRankingItem(): com.madsam.otora.ui.common.RankingItem = object : com.madsam.otora.ui.common.RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.median // 将中位数作为主要分数
        override val extraData: Number? = if (this@WorkRanking.impression > 0) this@WorkRanking.impression else null
        override val avgScore: Double? = null // 不显示额外的平均分列
        override val medianScore: Double? = null // 不显示额外的中位数列
        override val rankChange: Int? = this@WorkRanking.rankChange
        override val compareRank: Int? = this@WorkRanking.compareRank
        override val compareScore: Number? = this@WorkRanking.compareMedian // 对比中位数
    }
    
    // 专门用于差值排行的适配器 - 将分数差值作为主要分数显示
    fun toDifferenceRankingItem(): com.madsam.otora.ui.common.RankingItem = object : com.madsam.otora.ui.common.RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.score // 分数差值作为主要分数
        override val extraData: Number? = if (this@WorkRanking.impression != 0) this@WorkRanking.impression else null // 评价数差值，允许负数
        override val avgScore: Double? = null // 不显示额外的平均分列
        override val medianScore: Double? = null // 不显示额外的中位数列
        override val rankChange: Int? = null // 差值排行不显示排名变化
        override val compareRank: Int? = null // 不显示对比排名
        override val compareScore: Number? = null // 不显示对比分数
    }
    
    // 专门用于综合分数排行的适配器 - 将综合分数作为主要分数显示，同时显示原始平均分和中位数
    fun toCompositeRankingItem(): com.madsam.otora.ui.common.RankingItem = object : com.madsam.otora.ui.common.RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.compositeScore ?: this@WorkRanking.score // 使用Double类型的综合分数，如果没有则回退到Int分数
        override val extraData: Number? = if (this@WorkRanking.impression > 0) this@WorkRanking.impression else null
        override val avgScore: Double? = if (this@WorkRanking.average > 0) this@WorkRanking.average else null // 显示原始平均分
        override val medianScore: Double? = if (this@WorkRanking.median > 0) this@WorkRanking.median else null // 显示原始中位数
        override val rankChange: Int? = this@WorkRanking.rankChange
        override val compareRank: Int? = this@WorkRanking.compareRank
        override val compareScore: Number? = this@WorkRanking.compareCompositeScore ?: this@WorkRanking.compareScore // 使用Double类型的对比综合分数
    }
}

/**
 * 带时间戳的元数据
 */
private data class TimestampedMetadata(
    val timestamp: Long,
    val value: String
)
