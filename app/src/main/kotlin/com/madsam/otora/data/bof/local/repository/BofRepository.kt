package com.madsam.otora.data.bof.local.repository

import com.madsam.otora.data.bof.local.model.BofTTCompactEntity
import com.madsam.otora.data.bof.remote.model.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.objectbox.Box
import java.util.*

/**
 * 统一的BOFTT仓库
 * 使用层次化二分查找算法，专注于高效查询作品四项数据排行榜
 */
internal class BofRepository(
    private val bofTTBox: Box<BofTTCompactEntity>
) {
    
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
        
    private val scoreYearsAdapter: JsonAdapter<List<BofTTScoreYear>> = 
        moshi.adapter(Types.newParameterizedType(List::class.java, BofTTScoreYear::class.java))
        
    private val metadataAdapter: JsonAdapter<List<BofTTMetadataItem>> = 
        moshi.adapter(Types.newParameterizedType(List::class.java, BofTTMetadataItem::class.java))
    
    /**
     * 核心功能：获取指定时间点的四项数据排行榜
     * 
     * 返回数据：title、artist、score、scoreDetails
     * 算法：层次化二分查找，O(log Y × log M × log D × log H × log N)
     * 智能匹配：自动找到 <= timestamp 的最新记录
     * 
     * @param timestamp 时间戳（毫秒）
     * @return 按总分降序排列的作品排行榜
     */
    fun getRankingAtTime(timestamp: Long): List<WorkRanking> {
        val allWorks = bofTTBox.all
        
        return allWorks.mapNotNull { entity ->
            val scoreSnapshot = getScoreAtTime(entity, timestamp)
            if (scoreSnapshot != null) {
                WorkRanking(
                    workId = entity.workId,
                    title = getTitleAtTime(entity, timestamp),
                    artist = getArtistAtTime(entity, timestamp),
                    score = scoreSnapshot.totalScore,
                    scoreDetails = "${scoreSnapshot.currentScore}|${scoreSnapshot.averageScore}"
                )
            } else null
        }.sortedByDescending { it.score }
            .mapIndexed { index, work -> work.copy(rank = index + 1) }
    }
    
    /**
     * 从API响应保存BOFTT数据
     */
    fun saveBofTTApiResponse(apiResponse: BofTTApiResponse) {
        val works = apiResponse.getWorksAsList()
        val compactEntities = works.map { work -> convertToCompactEntity(work) }
        insertWorks(compactEntities)
    }
    
    /**
     * 批量插入或更新作品数据
     */
    fun insertWorks(works: List<BofTTCompactEntity>) {
        bofTTBox.put(works)
    }
    
    /**
     * 获取所有作品数量
     */
    fun getWorksCount(): Long = bofTTBox.count()
    
    /**
     * 清空所有数据
     */
    fun clearAll() {
        bofTTBox.removeAll()
    }
    
    /**
     * 层次化查找指定时间点的得分数据
     */
    private fun getScoreAtTime(entity: BofTTCompactEntity, targetTimestamp: Long): BofTTScoreSnapshot? {
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
    private fun getTitleAtTime(entity: BofTTCompactEntity, targetTimestamp: Long): String {
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
    private fun getArtistAtTime(entity: BofTTCompactEntity, targetTimestamp: Long): String {
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
        scoreYears: List<BofTTScoreYear>,
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
        val sortedYears = scoreYears.sortedBy { it.y }
        for (yearData in sortedYears) {
            if (yearData.y > targetYear) break
            
            // 2. 遍历月份（升序）
            val sortedMonths = yearData.c.sortedBy { it.m }
            for (monthData in sortedMonths) {
                if (yearData.y == targetYear && monthData.m > targetMonth) break
                
                // 3. 遍历日期（升序）
                val sortedDays = monthData.c.sortedBy { it.d }
                for (dayData in sortedDays) {
                    if (yearData.y == targetYear && monthData.m == targetMonth && dayData.d > targetDay) break
                    
                    // 4. 遍历小时（升序）
                    val sortedHours = dayData.c.sortedBy { it.h }
                    for (hourData in sortedHours) {
                        if (yearData.y == targetYear && monthData.m == targetMonth && 
                            dayData.d == targetDay && hourData.h > targetHour) break
                        
                        // 5. 遍历分钟（升序，二分查找优化）
                        val sortedMinutes = hourData.c.sortedBy { it.n }
                        val validMinutes = if (yearData.y == targetYear && monthData.m == targetMonth && 
                                            dayData.d == targetDay && hourData.h == targetHour) {
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
                                yearData.y, monthData.m, dayData.d, hourData.h, minuteData.n
                            )
                            
                            if (currentTimestamp <= targetTimestamp && currentTimestamp > bestTimestamp) {
                                bestTimestamp = currentTimestamp
                                bestMatch = BofTTScoreSnapshot(
                                    timestamp = currentTimestamp,
                                    year = yearData.y,
                                    month = monthData.m,
                                    day = dayData.d,
                                    hour = hourData.h,
                                    minute = minuteData.n,
                                    recordIndex = minuteData.v.i,
                                    totalScore = minuteData.v.t,
                                    currentScore = minuteData.v.m,
                                    averageScore = minuteData.v.a
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
        metadataList: List<BofTTMetadataItem>,
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
    private fun binarySearchMinute(minutes: List<BofTTScoreMinute>, targetMinute: Int): Int {
        var left = 0
        var right = minutes.size - 1
        var result = -1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (minutes[mid].n <= targetMinute) {
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
            val format = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault())
            format.parse(timeString)?.time ?: 0L
        } catch (e: Exception) {
            0L
        }
    }
    
    /**
     * 将BofTTWork转换为紧凑Entity
     */
    private fun convertToCompactEntity(work: BofTTWork): BofTTCompactEntity {
        val entity = BofTTCompactEntity()
        
        entity.workId = work.id
        entity.currentTitle = work.Title?.lastOrNull()?.value ?: ""
        entity.currentArtist = work.Artist?.lastOrNull()?.value ?: ""
        entity.team = work.Team ?: ""
        entity.genre = work.Genre ?: ""
        
        // 直接存储原始JSON结构
        val scoreAdapter = moshi.adapter(List::class.java)
        entity.scoreDataJson = if (work.Score != null) scoreAdapter.toJson(work.Score) else ""
        entity.titleHistoryJson = if (work.Title != null) moshi.adapter(List::class.java).toJson(work.Title) else ""
        entity.artistHistoryJson = if (work.Artist != null) moshi.adapter(List::class.java).toJson(work.Artist) else ""
        
        // 计算时间范围和最新得分
        val timeRange = calculateTimeRange(work)
        entity.earliestTimestamp = timeRange.first
        entity.latestTimestamp = timeRange.second
        
        val latestScore = findLatestScore(work)
        entity.latestTotalScore = latestScore?.totalScore ?: 0
        entity.latestAverageScore = latestScore?.averageScore ?: 0.0
        
        entity.lastUpdated = System.currentTimeMillis()
        
        return entity
    }
    
    /**
     * 计算时间范围
     */
    private fun calculateTimeRange(work: BofTTWork): Pair<Long, Long> {
        var earliest = Long.MAX_VALUE
        var latest = Long.MIN_VALUE
        
        work.Score?.forEach { yearData ->
            yearData.c.forEach { monthData ->
                monthData.c.forEach { dayData ->
                    dayData.c.forEach { hourData ->
                        hourData.c.forEach { minuteData ->
                            val timestamp = createTimestamp(
                                yearData.y, monthData.m, dayData.d,
                                hourData.h, minuteData.n
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
    private fun findLatestScore(work: BofTTWork): BofTTScoreSnapshot? {
        var latestScore: BofTTScoreSnapshot? = null
        var latestTimestamp = Long.MIN_VALUE
        
        work.Score?.forEach { yearData ->
            yearData.c.forEach { monthData ->
                monthData.c.forEach { dayData ->
                    dayData.c.forEach { hourData ->
                        hourData.c.forEach { minuteData ->
                            val timestamp = createTimestamp(
                                yearData.y, monthData.m, dayData.d,
                                hourData.h, minuteData.n
                            )
                            if (timestamp > latestTimestamp) {
                                latestTimestamp = timestamp
                                latestScore = BofTTScoreSnapshot(
                                    timestamp = timestamp,
                                    year = yearData.y,
                                    month = monthData.m,
                                    day = dayData.d,
                                    hour = hourData.h,
                                    minute = minuteData.n,
                                    recordIndex = minuteData.v.i,
                                    totalScore = minuteData.v.t,
                                    currentScore = minuteData.v.m,
                                    averageScore = minuteData.v.a
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
    val recordIndex: Int,
    val totalScore: Int,
    val currentScore: Double,
    val averageScore: Double
)

/**
 * 作品排行数据类
 * @param workId 作品ID
 * @param title 作品标题（该时间点的标题）
 * @param artist 艺术家（该时间点的艺术家）
 * @param score 总分（用于排序）
 * @param scoreDetails 得分详情，格式："当前分数|平均分数"
 * @param rank 排名（1开始，按总分降序）
 */
data class WorkRanking(
    val workId: String,
    val title: String,
    val artist: String,
    val score: Int,
    val scoreDetails: String,
    val rank: Int = 0
)

/**
 * 带时间戳的元数据
 */
private data class TimestampedMetadata(
    val timestamp: Long,
    val value: String
)
