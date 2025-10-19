package com.madsam.otora.data.bof.local.repository

import android.util.Log
import com.madsam.otora.data.bof.local.model.BofTeamEntity
import com.madsam.otora.data.bof.local.model.BofWorkEntity
import com.madsam.otora.data.bof.local.model.BofWorkEntity_
import com.madsam.otora.data.bof.local.model.BofTeamEntity_
import com.madsam.otora.data.bof.local.model.BofWorkScoreHistoryEntity
import com.madsam.otora.data.bof.local.model.BofWorkScoreHistoryEntity_
import com.madsam.otora.data.bof.local.model.BofWorkTitleHistoryEntity
import com.madsam.otora.data.bof.local.model.BofWorkTitleHistoryEntity_
import com.madsam.otora.data.bof.local.model.BofWorkArtistHistoryEntity
import com.madsam.otora.data.bof.local.model.BofWorkArtistHistoryEntity_
import com.madsam.otora.data.bof.local.model.BofTeamScoreHistoryEntity
import com.madsam.otora.data.bof.local.model.BofTeamScoreHistoryEntity_
import com.madsam.otora.data.bof.local.model.BofTeamTitleHistoryEntity
import com.madsam.otora.data.bof.local.model.BofTeamTitleHistoryEntity_
import com.madsam.otora.data.bof.local.model.BofTeamArtistHistoryEntity
import com.madsam.otora.data.bof.local.model.BofTeamArtistHistoryEntity_
import com.madsam.otora.data.bof.local.model.BofTeamFinalStrikerHistoryEntity
import com.madsam.otora.data.bof.local.model.BofTeamFinalStrikerHistoryEntity_
import com.madsam.otora.data.bof.remote.model.*
import com.madsam.otora.ui.common.RankingItem
import io.objectbox.Box
import java.util.*

private const val TAG = "BofRepository"

/**
 * 统一的BOF仓库
 * 使用独立的时序数据表，专注于高效查询作品和团队排行榜数据
 */
internal class BofRepository(
    private val bofWorkBox: Box<BofWorkEntity>,
    private val scoreHistoryBox: Box<BofWorkScoreHistoryEntity>,
    private val titleHistoryBox: Box<BofWorkTitleHistoryEntity>,
    private val artistHistoryBox: Box<BofWorkArtistHistoryEntity>,
    private val teamScoreHistoryBox: Box<BofTeamScoreHistoryEntity>,
    private val teamTitleHistoryBox: Box<BofTeamTitleHistoryEntity>,
    private val teamArtistHistoryBox: Box<BofTeamArtistHistoryEntity>,
    private val teamFinalStrikerHistoryBox: Box<BofTeamFinalStrikerHistoryEntity>
) {

    /**
     * 使用独立时序表，查询速度极快，一次性返回全部数据
     * 支持两个时间点的对比数据
     */
    suspend fun getRankingAtTime(
        currentTimestamp: Long,
        compareTimestamp: Long? = null,
        path: String,
        onBatchReady: suspend (List<WorkRanking>) -> Unit
    ) = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        val startTime = System.currentTimeMillis()

        val allWorks = bofWorkBox.query(BofWorkEntity_.path.equal(path)).build().find()

        // 如果有对比时间戳，先计算对比时间点的完整排行榜
        val compareRankingMap = mutableMapOf<String, WorkRanking>()
        if (compareTimestamp != null) {

            // 一次性处理所有对比数据
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
            
            // 分配排名（同分同排名）
            var currentRank = 1
            var previousScore: Int? = null
            val rankedCompareResults = compareResults.mapIndexed { index, work ->
                if (previousScore != null && work.score != previousScore) {
                    currentRank = index + 1
                }
                previousScore = work.score
                work.copy(rank = currentRank)
            }

            rankedCompareResults.forEach { work ->
                compareRankingMap[work.workId] = work
            }
        }

        // 一次性处理当前时间点的全部数据
        val currentStart = System.currentTimeMillis()
        
        val allCurrentResults = allWorks.mapNotNull { entity ->
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

        val currentEnd = System.currentTimeMillis()
        Log.d(TAG, "Current data processed in ${currentEnd - currentStart}ms, got ${allCurrentResults.size} works")

        // 排序并分配排名，计算排名变化（同分同排名）
        val sortedResults = allCurrentResults.sortedByDescending { it.score }
        var currentRank = 1
        var previousScore: Int? = null
        val finalResults = sortedResults.mapIndexed { index, work ->
            // 如果分数与前一个不同，更新排名为当前位置+1
            if (previousScore != null && work.score != previousScore) {
                currentRank = index + 1
            }
            previousScore = work.score
            
            val rankChange = if (work.compareRank != null) {
                work.compareRank - currentRank // 对比排名 - 当前排名，正数表示排名上升
            } else null

            work.copy(
                rank = currentRank,
                rankChange = rankChange
            )
        }

        val endTime = System.currentTimeMillis()
        Log.d(TAG, "getRankingAtTime completed in ${endTime - startTime}ms, total ${finalResults.size} works")
        
        // 在回调前确保在正确的调度器上
        onBatchReady(finalResults)
    }

    /**
     * 从API响应保存BOF数据到新的数据库结构
     */
    fun saveBofApiResponse(apiResponse: BofWorkResponse, path: String) {
        val startTime = System.currentTimeMillis()
        Log.d(TAG, "Starting to save BOF API response for path: $path")

        // 先删除该 path 的所有旧历史数据
        Log.d(TAG, "Removing old work history data for path: $path")
        val oldScoreCount = scoreHistoryBox.query(
            BofWorkScoreHistoryEntity_.path.equal(path)
        ).build().remove()
        Log.d(TAG, "Removed $oldScoreCount old work score history records")
        
        val oldTitleCount = titleHistoryBox.query(
            BofWorkTitleHistoryEntity_.path.equal(path)
        ).build().remove()
        Log.d(TAG, "Removed $oldTitleCount old work title history records")
        
        val oldArtistCount = artistHistoryBox.query(
            BofWorkArtistHistoryEntity_.path.equal(path)
        ).build().remove()
        Log.d(TAG, "Removed $oldArtistCount old work artist history records")

        val works = apiResponse.getWorksAsList()

        // 准备数据列表
        val workEntities = mutableListOf<BofWorkEntity>()
        val scoreHistoryEntities = mutableListOf<BofWorkScoreHistoryEntity>()
        val titleHistoryEntities = mutableListOf<BofWorkTitleHistoryEntity>()
        val artistHistoryEntities = mutableListOf<BofWorkArtistHistoryEntity>()

        // 转换每个作品
        works.forEach { work ->
            // 1. 创建主作品实体
            val workEntity = convertToWorkEntity(work, path)
            workEntities.add(workEntity)

            val compositeWorkId = workEntity.compositeWorkId

            // 2. 解析并保存分数历史
            work.score?.forEach { yearData ->
                yearData.months.forEach { monthData ->
                    monthData.days.forEach { dayData ->
                        dayData.hours.forEach { hourData ->
                            hourData.minutes.forEach { minuteData ->
                                val timestamp = BofWorkScoreHistoryEntity.createTimestamp(
                                    yearData.year, monthData.month, dayData.day,
                                    hourData.hour, minuteData.minute
                                )

                                val scoreEntity = BofWorkScoreHistoryEntity(
                                    compositeWorkId = compositeWorkId,
                                    path = path,
                                    timestamp = timestamp,
                                    year = yearData.year,
                                    month = monthData.month,
                                    day = dayData.day,
                                    hour = hourData.hour,
                                    minute = minuteData.minute,
                                    impression = minuteData.values.impression,
                                    total = minuteData.values.total,
                                    median = minuteData.values.median,
                                    average = minuteData.values.average
                                )
                                scoreHistoryEntities.add(scoreEntity)
                            }
                        }
                    }
                }
            }

            // 3. 解析并保存标题历史
            work.title?.forEach { titleItem ->
                val timestamp = BofWorkTitleHistoryEntity.parseTimestamp(titleItem.time)
                val titleEntity = BofWorkTitleHistoryEntity(
                    compositeWorkId = compositeWorkId,
                    path = path,
                    timestamp = timestamp,
                    timeString = titleItem.time,
                    title = titleItem.value
                )
                titleHistoryEntities.add(titleEntity)
            }

            // 4. 解析并保存艺术家历史
            work.artist?.forEach { artistItem ->
                val timestamp = BofWorkArtistHistoryEntity.parseTimestamp(artistItem.time)
                val artistEntity = BofWorkArtistHistoryEntity(
                    compositeWorkId = compositeWorkId,
                    path = path,
                    timestamp = timestamp,
                    timeString = artistItem.time,
                    artist = artistItem.value
                )
                artistHistoryEntities.add(artistEntity)
            }
        }

        // 批量保存到数据库
        Log.d(TAG, "Saving ${workEntities.size} works")
        bofWorkBox.put(workEntities)

        Log.d(TAG, "Saving ${scoreHistoryEntities.size} score history records")
        scoreHistoryBox.put(scoreHistoryEntities)

        Log.d(TAG, "Saving ${titleHistoryEntities.size} title history records")
        titleHistoryBox.put(titleHistoryEntities)

        Log.d(TAG, "Saving ${artistHistoryEntities.size} artist history records")
        artistHistoryBox.put(artistHistoryEntities)

        val endTime = System.currentTimeMillis()
        Log.d(TAG, "BOF API response saved in ${endTime - startTime}ms")
    }

    /**
     * 获取所有作品数量
     */
    fun getWorksCount(path: String = "tt"): Long =
        bofWorkBox.query(BofWorkEntity_.path.equal(path)).build().count()

    /**
     * 获取团队数据数量
     */
    fun getTeamCount(path: String): Long {
        return try {
            val objectBoxService = com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService()
            kotlinx.coroutines.runBlocking {
                objectBoxService.getBofTeamData(path).size.toLong()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error getting team count for path $path: ${e.message}", e)
            0L
        }
    }

    /**
     * 从新的分数历史表中查找指定时间点的得分数据
     */
    private fun getScoreAtTime(entity: BofWorkEntity, targetTimestamp: Long): BofTTScoreSnapshot? {
        try {
            // 使用 ObjectBox 查询，找到小于等于目标时间的最近记录
            val scoreHistory = scoreHistoryBox.query(
                BofWorkScoreHistoryEntity_.compositeWorkId.equal(entity.compositeWorkId)
                    .and(BofWorkScoreHistoryEntity_.timestamp.lessOrEqual(targetTimestamp))
            ).orderDesc(BofWorkScoreHistoryEntity_.timestamp)
                .build()
                .findFirst()

            return if (scoreHistory != null) {
                BofTTScoreSnapshot(
                    timestamp = scoreHistory.timestamp,
                    year = scoreHistory.year,
                    month = scoreHistory.month,
                    day = scoreHistory.day,
                    hour = scoreHistory.hour,
                    minute = scoreHistory.minute,
                    totalScore = scoreHistory.total,
                    average = scoreHistory.average,
                    median = scoreHistory.median,
                    impression = scoreHistory.impression
                )
            } else null
        } catch (e: Exception) {
            Log.e(TAG, "Error getting score at time for ${entity.compositeWorkId}: ${e.message}", e)
            return null
        }
    }

    /**
     * 从新的标题历史表中查找指定时间点的标题
     */
    private fun getTitleAtTime(entity: BofWorkEntity, targetTimestamp: Long): String {
        try {
            val titleHistory = titleHistoryBox.query(
                BofWorkTitleHistoryEntity_.compositeWorkId.equal(entity.compositeWorkId)
                    .and(BofWorkTitleHistoryEntity_.timestamp.lessOrEqual(targetTimestamp))
            ).orderDesc(BofWorkTitleHistoryEntity_.timestamp)
                .build()
                .findFirst()

            return titleHistory?.title ?: entity.currentTitle
        } catch (e: Exception) {
            Log.e(TAG, "Error getting title at time for ${entity.compositeWorkId}: ${e.message}", e)
            return entity.currentTitle
        }
    }

    /**
     * 从新的艺术家历史表中查找指定时间点的艺术家
     */
    private fun getArtistAtTime(entity: BofWorkEntity, targetTimestamp: Long): String {
        try {
            val artistHistory = artistHistoryBox.query(
                BofWorkArtistHistoryEntity_.compositeWorkId.equal(entity.compositeWorkId)
                    .and(BofWorkArtistHistoryEntity_.timestamp.lessOrEqual(targetTimestamp))
            ).orderDesc(BofWorkArtistHistoryEntity_.timestamp)
                .build()
                .findFirst()

            return artistHistory?.artist ?: entity.currentArtist
        } catch (e: Exception) {
            Log.e(
                TAG,
                "Error getting artist at time for ${entity.compositeWorkId}: ${e.message}",
                e
            )
            return entity.currentArtist
        }
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
     * 将 API 数据转换为 WorkEntity（不再保存 JSON，只保存基本信息和索引）
     */
    private fun convertToWorkEntity(work: BofWorkData, path: String = "tt"): BofWorkEntity {
        val entity = BofWorkEntity()

        entity.path = path
        entity.originalWorkId = work.id
        entity.compositeWorkId = BofWorkEntity.createCompositeWorkId(path, work.id)
        entity.currentTitle = work.title?.lastOrNull()?.value ?: ""
        entity.currentArtist = work.artist?.lastOrNull()?.value ?: ""
        entity.team = work.team ?: ""
        entity.genre = work.genre ?: ""

        // 计算时间范围和最新得分（用于快速筛选和排序）
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

    /**
     * 优化版：使用独立时序表查询团队排名，一次性返回全部数据
     * 支持时间对比功能
     */
    suspend fun getTeamRankingAtTimeStreamed(
        currentTimestamp: Long,
        compareTimestamp: Long? = null,
        path: String = "tt",
        onBatchReady: suspend (List<com.madsam.otora.ui.bof.TeamRankingItem>) -> Unit
    ) = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        Log.d(
            TAG,
            "getTeamRankingAtTimeStreamed called with currentTimestamp: $currentTimestamp, compareTimestamp: $compareTimestamp, path: $path"
        )

        val startTime = System.currentTimeMillis()

        // 直接从ObjectBox获取团队数据
        val boxStore = com.madsam.otora.core.database.ObjectBoxManager.getBoxStore()
        val teamBox = boxStore.boxFor(BofTeamEntity::class.java)
        val allTeams = teamBox.query(BofTeamEntity_.path.equal(path)).build().find()

        Log.d(TAG, "Processing ${allTeams.size} teams for path: $path")

        val compareRankingMap = mutableMapOf<String, com.madsam.otora.ui.bof.TeamRankingItem>()

        // 步骤1: 如果有对比时间戳，先处理对比数据
        if (compareTimestamp != null) {
            Log.d(TAG, "Calculating compare ranking for teams at timestamp: $compareTimestamp")
            val compareStart = System.currentTimeMillis()
            
            val compareResults = allTeams.mapNotNull { entity ->
                val compareScoreSnapshot = getTeamScoreAtTime(entity, compareTimestamp)
                if (compareScoreSnapshot != null) {
                    com.madsam.otora.ui.bof.TeamRankingItem(
                        teamName = entity.teamName,
                        totalScore = compareScoreSnapshot.total,
                        impressionCount = compareScoreSnapshot.impression,
                        medianScore = compareScoreSnapshot.median,
                        score1 = compareScoreSnapshot.score1,
                        score2 = compareScoreSnapshot.score2,
                        score3 = compareScoreSnapshot.score3,
                        score4 = compareScoreSnapshot.score4,
                        title1 = getTeamTitleAtTime(entity, 1, compareTimestamp),
                        artist1 = getTeamArtistAtTime(entity, 1, compareTimestamp),
                        finalStriker1 = getTeamFinalStrikerAtTime(entity, 1, compareTimestamp),
                        title2 = getTeamTitleAtTime(entity, 2, compareTimestamp),
                        artist2 = getTeamArtistAtTime(entity, 2, compareTimestamp),
                        finalStriker2 = getTeamFinalStrikerAtTime(entity, 2, compareTimestamp),
                        title3 = getTeamTitleAtTime(entity, 3, compareTimestamp),
                        artist3 = getTeamArtistAtTime(entity, 3, compareTimestamp),
                        finalStriker3 = getTeamFinalStrikerAtTime(entity, 3, compareTimestamp),
                        title4 = getTeamTitleAtTime(entity, 4, compareTimestamp),
                        artist4 = getTeamArtistAtTime(entity, 4, compareTimestamp),
                        finalStriker4 = getTeamFinalStrikerAtTime(entity, 4, compareTimestamp),
                        lastUpdated = compareTimestamp
                    )
                } else null
            }.sortedByDescending { it.totalScore }
            
            // 分配排名（同分同排名）
            var currentRank = 1
            var previousScore: Double? = null
            val rankedCompareResults = compareResults.mapIndexed { index, item ->
                if (previousScore != null && item.totalScore != previousScore) {
                    currentRank = index + 1
                }
                previousScore = item.totalScore
                item.copy(rank = currentRank)
            }

            rankedCompareResults.forEach { item ->
                compareRankingMap[item.teamName] = item
            }
            
            val compareEnd = System.currentTimeMillis()
            Log.d(TAG, "Compare ranking calculated in ${compareEnd - compareStart}ms, got ${compareResults.size} teams")
        }

        // 步骤2: 一次性处理当前时间点的全部数据（使用索引查询已经很快）
        val currentStart = System.currentTimeMillis()
        
        val currentResults = allTeams.mapNotNull { entity ->
            val scoreSnapshot = getTeamScoreAtTime(entity, currentTimestamp)
            if (scoreSnapshot != null) {
                val compareData = compareRankingMap[entity.teamName]
                com.madsam.otora.ui.bof.TeamRankingItem(
                    teamName = entity.teamName,
                    totalScore = scoreSnapshot.total,
                    impressionCount = scoreSnapshot.impression,
                    medianScore = scoreSnapshot.median,
                    score1 = scoreSnapshot.score1,
                    score2 = scoreSnapshot.score2,
                    score3 = scoreSnapshot.score3,
                    score4 = scoreSnapshot.score4,
                    title1 = getTeamTitleAtTime(entity, 1, currentTimestamp),
                    artist1 = getTeamArtistAtTime(entity, 1, currentTimestamp),
                    finalStriker1 = getTeamFinalStrikerAtTime(entity, 1, currentTimestamp),
                    title2 = getTeamTitleAtTime(entity, 2, currentTimestamp),
                    artist2 = getTeamArtistAtTime(entity, 2, currentTimestamp),
                    finalStriker2 = getTeamFinalStrikerAtTime(entity, 2, currentTimestamp),
                    title3 = getTeamTitleAtTime(entity, 3, currentTimestamp),
                    artist3 = getTeamArtistAtTime(entity, 3, currentTimestamp),
                    finalStriker3 = getTeamFinalStrikerAtTime(entity, 3, currentTimestamp),
                    title4 = getTeamTitleAtTime(entity, 4, currentTimestamp),
                    artist4 = getTeamArtistAtTime(entity, 4, currentTimestamp),
                    finalStriker4 = getTeamFinalStrikerAtTime(entity, 4, currentTimestamp),
                    lastUpdated = currentTimestamp,
                    // 对比数据
                    compareTotalScore = compareData?.totalScore,
                    compareImpressionCount = compareData?.impressionCount,
                    compareMedianScore = compareData?.medianScore,
                    compareScore1 = compareData?.score1,
                    compareScore2 = compareData?.score2,
                    compareScore3 = compareData?.score3,
                    compareScore4 = compareData?.score4,
                    compareRank = compareData?.rank
                )
            } else null
        }

        val currentEnd = System.currentTimeMillis()
        Log.d(TAG, "Current team data processed in ${currentEnd - currentStart}ms, got ${currentResults.size} teams")

        // 按总分排序并分配排名和排名变化（同分同排名）
        val sortedResults = currentResults.sortedByDescending { it.totalScore }
        var currentRank = 1
        var previousScore: Double? = null
        val finalResults = sortedResults.mapIndexed { index, item ->
            // 如果总分与前一个不同，更新排名为当前位置+1
            if (previousScore != null && item.totalScore != previousScore) {
                currentRank = index + 1
            }
            previousScore = item.totalScore
            
            val rankChange = if (item.compareRank != null) {
                item.compareRank - currentRank // 对比排名 - 当前排名，正数表示排名上升
            } else null

            item.copy(
                rank = currentRank,
                rankChange = rankChange
            )
        }

        val endTime = System.currentTimeMillis()
        Log.d(TAG, "getTeamRankingAtTimeStreamed completed in ${endTime - startTime}ms, total ${finalResults.size} teams")

        // 在回调前确保在正确的调度器上
        onBatchReady(finalResults)
    }

    /**
     * 使用新的时序表获取团队指定时间点的得分数据
     */
    private fun getTeamScoreAtTime(
        entity: BofTeamEntity,
        targetTimestamp: Long
    ): TeamScoreSnapshot? {
        try {
            // 使用 ObjectBox 查询，找到小于等于目标时间的最近记录
            val scoreHistory = teamScoreHistoryBox.query(
                BofTeamScoreHistoryEntity_.compositeTeamId.equal(entity.compositeTeamId)
                    .and(BofTeamScoreHistoryEntity_.timestamp.lessOrEqual(targetTimestamp))
            ).orderDesc(BofTeamScoreHistoryEntity_.timestamp)
                .build()
                .findFirst()

            return if (scoreHistory != null) {
                TeamScoreSnapshot(
                    timestamp = scoreHistory.timestamp,
                    total = scoreHistory.total,
                    impression = scoreHistory.impression,
                    median = scoreHistory.median,
                    score1 = scoreHistory.total1,
                    score2 = scoreHistory.total2,
                    score3 = scoreHistory.total3,
                    score4 = scoreHistory.total4
                )
            } else null
        } catch (e: Exception) {
            Log.e(TAG, "Error getting team score at time for ${entity.teamName}: ${e.message}", e)
            return null
        }
    }

    /**
     * 使用新的时序表获取团队指定时间点的作品标题
     */
    private fun getTeamTitleAtTime(
        entity: BofTeamEntity,
        workSlot: Int,
        targetTimestamp: Long
    ): String {
        return try {
            val titleHistory = teamTitleHistoryBox.query(
                BofTeamTitleHistoryEntity_.compositeTeamId.equal(entity.compositeTeamId)
                    .and(BofTeamTitleHistoryEntity_.workSlot.equal(workSlot))
                    .and(BofTeamTitleHistoryEntity_.timestamp.lessOrEqual(targetTimestamp))
            ).orderDesc(BofTeamTitleHistoryEntity_.timestamp)
                .build()
                .findFirst()
            
            titleHistory?.title ?: ""
        } catch (e: Exception) {
            Log.e(TAG, "Error getting team title at time for ${entity.teamName} workSlot $workSlot: ${e.message}", e)
            ""
        }
    }

    /**
     * 使用新的时序表获取团队指定时间点的作品艺术家
     */
    private fun getTeamArtistAtTime(
        entity: BofTeamEntity,
        workSlot: Int,
        targetTimestamp: Long
    ): String {
        return try {
            val artistHistory = teamArtistHistoryBox.query(
                BofTeamArtistHistoryEntity_.compositeTeamId.equal(entity.compositeTeamId)
                    .and(BofTeamArtistHistoryEntity_.workSlot.equal(workSlot))
                    .and(BofTeamArtistHistoryEntity_.timestamp.lessOrEqual(targetTimestamp))
            ).orderDesc(BofTeamArtistHistoryEntity_.timestamp)
                .build()
                .findFirst()
            
            artistHistory?.artist ?: ""
        } catch (e: Exception) {
            Log.e(TAG, "Error getting team artist at time for ${entity.teamName} workSlot $workSlot: ${e.message}", e)
            ""
        }
    }

    /**
     * 使用新的时序表获取团队指定时间点的最终打击者
     */
    private fun getTeamFinalStrikerAtTime(
        entity: BofTeamEntity,
        workSlot: Int,
        targetTimestamp: Long
    ): String {
        return try {
            val finalStrikerHistory = teamFinalStrikerHistoryBox.query(
                BofTeamFinalStrikerHistoryEntity_.compositeTeamId.equal(entity.compositeTeamId)
                    .and(BofTeamFinalStrikerHistoryEntity_.workSlot.equal(workSlot))
                    .and(BofTeamFinalStrikerHistoryEntity_.timestamp.lessOrEqual(targetTimestamp))
            ).orderDesc(BofTeamFinalStrikerHistoryEntity_.timestamp)
                .build()
                .findFirst()
            
            finalStrikerHistory?.finalStriker ?: ""
        } catch (e: Exception) {
            Log.e(TAG, "Error getting team final striker at time for ${entity.teamName} workSlot $workSlot: ${e.message}", e)
            ""
        }
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
    fun toRankingItem(): RankingItem = object : RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.score
        override val extraData: Number? =
            if (this@WorkRanking.impression > 0) this@WorkRanking.impression else null
        override val avgScore: Double? =
            if (this@WorkRanking.average > 0) this@WorkRanking.average else null
        override val medianScore: Double? =
            if (this@WorkRanking.median > 0) this@WorkRanking.median else null
        override val rankChange: Int? = this@WorkRanking.rankChange
        override val compareRank: Int? = this@WorkRanking.compareRank
        override val compareScore: Number? = this@WorkRanking.compareScore
    }

    // 专门用于平均分排行的适配器 - 将平均分作为主要分数显示
    fun toAverageRankingItem(): RankingItem = object : RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.average // 将平均分作为主要分数
        override val extraData: Number? =
            if (this@WorkRanking.impression > 0) this@WorkRanking.impression else null
        override val avgScore: Double? = null // 不显示额外的平均分列
        override val medianScore: Double? = null // 不显示中位数列
        override val rankChange: Int? = this@WorkRanking.rankChange
        override val compareRank: Int? = this@WorkRanking.compareRank
        override val compareScore: Number? = this@WorkRanking.compareAverage // 对比平均分
    }

    // 专门用于中位数排行的适配器 - 将中位数作为主要分数显示
    fun toMedianRankingItem(): RankingItem = object : RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.median // 将中位数作为主要分数
        override val extraData: Number? =
            if (this@WorkRanking.impression > 0) this@WorkRanking.impression else null
        override val avgScore: Double? = null // 不显示额外的平均分列
        override val medianScore: Double? = null // 不显示额外的中位数列
        override val rankChange: Int? = this@WorkRanking.rankChange
        override val compareRank: Int? = this@WorkRanking.compareRank
        override val compareScore: Number? = this@WorkRanking.compareMedian // 对比中位数
    }

    // 专门用于差值排行的适配器 - 将分数差值作为主要分数显示
    fun toDifferenceRankingItem(): RankingItem = object : RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.score // 分数差值作为主要分数
        override val extraData: Number? =
            if (this@WorkRanking.impression != 0) this@WorkRanking.impression else null // 评价数差值，允许负数
        override val avgScore: Double? = null // 不显示额外的平均分列
        override val medianScore: Double? = null // 不显示额外的中位数列
        override val rankChange: Int? = null // 差值排行不显示排名变化
        override val compareRank: Int? = null // 不显示对比排名
        override val compareScore: Number? = null // 不显示对比分数
    }

    // 专门用于综合分数排行的适配器 - 将综合分数作为主要分数显示，同时显示原始平均分和中位数
    fun toCompositeRankingItem(): RankingItem = object : RankingItem {
        override val rank: Int = this@WorkRanking.rank
        override val title: String = this@WorkRanking.title
        override val artist: String = this@WorkRanking.artist
        override val score: Number = this@WorkRanking.compositeScore
            ?: this@WorkRanking.score // 使用Double类型的综合分数，如果没有则回退到Int分数
        override val extraData: Number? =
            if (this@WorkRanking.impression > 0) this@WorkRanking.impression else null
        override val avgScore: Double? =
            if (this@WorkRanking.average > 0) this@WorkRanking.average else null // 显示原始平均分
        override val medianScore: Double? =
            if (this@WorkRanking.median > 0) this@WorkRanking.median else null // 显示原始中位数
        override val rankChange: Int? = this@WorkRanking.rankChange
        override val compareRank: Int? = this@WorkRanking.compareRank
        override val compareScore: Number? = this@WorkRanking.compareCompositeScore
            ?: this@WorkRanking.compareScore // 使用Double类型的对比综合分数
    }
}

/**
 * 团队得分快照数据类
 */
data class TeamScoreSnapshot(
    val timestamp: Long,
    val total: Double,
    val impression: Double,
    val median: Double,
    val score1: Double, // 作品1分数
    val score2: Double, // 作品2分数
    val score3: Double, // 作品3分数
    val score4: Double  // 作品4分数
)
