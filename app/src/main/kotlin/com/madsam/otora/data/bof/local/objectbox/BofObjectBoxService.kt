package com.madsam.otora.data.bof.local.objectbox

import android.util.Log
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.data.bof.local.model.*
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.data.bof.ui.model.BofTeamUI
import com.madsam.otora.data.bof.remote.model.BofRangeDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.abs

/**
 * BOF 数据的 ObjectBox 本地存储服务
 */
internal class BofObjectBoxService {
    
    companion object {
        private const val TAG = "BofObjectBoxService"
    }
    
    private val boxStore by lazy { ObjectBoxManager.getBoxStore() }
    private val bofTeamBox by lazy { boxStore.boxFor(BofTeamEntity::class.java) }
    private val bofTeamPointBox by lazy { boxStore.boxFor(BofTeamPointEntity::class.java) }
    private val bofTeamDetailedBox by lazy { boxStore.boxFor(BofTeamDetailedEntity::class.java) }
    private val bofCommentBox by lazy { boxStore.boxFor(BofCommentEntity::class.java) }
    private val bofCommentDetailBox by lazy { boxStore.boxFor(BofCommentDetailEntity::class.java) }
    private val bofRangeBox by lazy { boxStore.boxFor(BofRangeEntity::class.java) }

    /**
     * 根据时间范围获取 BOF Team 数据
     */
    suspend fun getBofttTeamByTime(currentTime: Long, compareTime: Long): List<BofTeamUI> {
        return withContext(Dispatchers.IO) {
            try {
                val startTime = currentTime - 24 * 60 * 60 * 1000
                val startTimeCompare = compareTime - 24 * 60 * 60 * 1000

                val points = bofTeamPointBox.query(
                    BofTeamPointEntity_.time.between(startTime, currentTime)
                ).build().find()
                
                val pointsCompare = bofTeamPointBox.query(
                    BofTeamPointEntity_.time.between(startTimeCompare, compareTime)
                ).build().find()

                if (points.isEmpty()) {
                    return@withContext emptyList<BofTeamUI>()
                }

                val date = CommonUtils.millisToYmd(currentTime).substring(0, 10)
                val teams = bofTeamBox.query(
                    BofTeamEntity_.date.equal(date)
                ).build().find()

                val pointsMap = points.groupBy { it.team }
                val pointsMapCompare = pointsCompare.groupBy { it.team }

                teams.map { team ->
                    val teamPoints = pointsMap[team.team] ?: emptyList()
                    val teamPointsCompare = pointsMapCompare[team.team] ?: emptyList()
                    val closestPoint = teamPoints
                        .filter { it.time <= currentTime }
                        .minByOrNull { abs(it.time - currentTime) }
                    val closestPointCompare = teamPointsCompare
                        .filter { it.time <= compareTime }
                        .minByOrNull { abs(it.time - compareTime) }

                    BofTeamUI(
                        previousRank = 0,
                        currentRank = 0,
                        team = team.team,
                        title1 = team.title1,
                        title2 = team.title2,
                        title3 = team.title3,
                        title4 = team.title4,
                        artist1 = team.artist1,
                        artist2 = team.artist2,
                        artist3 = team.artist3,
                        artist4 = team.artist4,
                        fs1 = team.fs1,
                        fs2 = team.fs2,
                        fs3 = team.fs3,
                        fs4 = team.fs4,
                        impr = closestPoint?.impr ?: 0,
                        total = closestPoint?.total ?: 0.0,
                        median = closestPoint?.median ?: "",
                        total1 = closestPoint?.total1 ?: "",
                        median1 = closestPoint?.median1 ?: "",
                        total2 = closestPoint?.total2 ?: "",
                        median2 = closestPoint?.median2 ?: "",
                        total3 = closestPoint?.total3 ?: "",
                        median3 = closestPoint?.median3 ?: "",
                        total4 = closestPoint?.total4 ?: "",
                        median4 = closestPoint?.median4 ?: "",
                        oldImpr = closestPointCompare?.impr ?: 0,
                        oldTotal = closestPointCompare?.total ?: 0.0,
                        oldMedian = closestPointCompare?.median ?: "",
                        time = CommonUtils.millisToYmd(currentTime).substring(11, 16)
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching team by time: ${e.message}")
                emptyList()
            }
        }
    }
    
    /**
     * 根据日期获取评论数据
     */
    suspend fun getBofttCommentByTime(currentDate: String): List<BofCommentUI> {
        return withContext(Dispatchers.IO) {
            try {
                val comments = bofCommentBox.query(
                    BofCommentEntity_.date.equal(currentDate)
                ).build().find()

                if (comments.isEmpty()) {
                    return@withContext emptyList<BofCommentUI>()
                }
                
                comments.map { entry ->
                    val commentsDetail = bofCommentDetailBox.query(
                        BofCommentDetailEntity_.user.equal(entry.user)
                            .and(BofCommentDetailEntity_.date.equal(currentDate))
                    ).build().find()
                    
                    val vote = commentsDetail.filter { it.type == "vote" }
                    val short = commentsDetail.filter { it.type == "short" }
                    val long = commentsDetail.filter { it.type == "long" }
                    
                    BofCommentUI(
                        user = entry.user,
                        pattern = entry.pattern,
                        country = entry.country,
                        vote = entry.vote,
                        voteTotal = entry.voteTotal,
                        voteAve = entry.voteAve,
                        voteChartData = vote.sortedBy { it.score }.map { it.score },
                        short = entry.short,
                        shortTotal = entry.shortTotal,
                        shortAve = entry.shortAve,
                        shortComment = entry.shortComment,
                        shortChartData = short.sortedBy { it.score }.map { it.score },
                        long = entry.long,
                        longTotal = entry.longTotal,
                        longAve = entry.longAve,
                        longComment = entry.longComment,
                        longChartData = long.sortedBy { it.score }.map { it.score },
                        total = entry.total,
                        totalAve = entry.totalAve
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching comment by time: ${e.message}")
                emptyList()
            }
        }
    }

    /**
     * 获取最新的 Team 数据
     */
    suspend fun getBofttTeamLatest(): List<BofTeamUI> {
        return withContext(Dispatchers.IO) {
            try {
                val currentTime = System.currentTimeMillis()
                val compareTime = currentTime - 24 * 60 * 60 * 1000
                getBofttTeamByTime(currentTime, compareTime)
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching latest team: ${e.message}")
                emptyList()
            }
        }
    }

    /**
     * 获取最新的评论数据
     */
    suspend fun getBofttCommentLatest(): List<BofCommentUI> {
        return withContext(Dispatchers.IO) {
            try {
                getBofttCommentByTime("2025-01-08") //TODO: 从数据库中获取最新评价数据
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching latest comment: ${e.message}")
                emptyList()
            }
        }
    }

    /**
     * 保存 BOF Team 数据
     */
    suspend fun saveBofTeamData(teams: List<BofTeamEntity>) {
        withContext(Dispatchers.IO) {
            try {
                bofTeamBox.put(teams)
                Log.d(TAG, "Saved ${teams.size} BOF teams")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving BOF teams: ${e.message}", e)
            }
        }
    }
    
    /**
     * 保存 BOF Team Point 数据
     */
    suspend fun saveBofTeamPointData(points: List<BofTeamPointEntity>) {
        withContext(Dispatchers.IO) {
            try {
                bofTeamPointBox.put(points)
                Log.d(TAG, "Saved ${points.size} BOF team points")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving BOF team points: ${e.message}", e)
            }
        }
    }
    
    /**
     * 保存 BOF Comment 数据
     */
    suspend fun saveBofCommentData(comments: List<BofCommentEntity>) {
        withContext(Dispatchers.IO) {
            try {
                bofCommentBox.put(comments)
                Log.d(TAG, "Saved ${comments.size} BOF comments")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving BOF comments: ${e.message}", e)
            }
        }
    }
    
    /**
     * 保存 BOF Comment Detail 数据
     */
    suspend fun saveBofCommentDetailData(details: List<BofCommentDetailEntity>) {
        withContext(Dispatchers.IO) {
            try {
                bofCommentDetailBox.put(details)
                Log.d(TAG, "Saved ${details.size} BOF comment details")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving BOF comment details: ${e.message}", e)
            }
        }
    }
    
    /**
     * 保存 BOF Range 数据
     */
    suspend fun saveBofRangeData(ranges: List<BofRangeDTO>) {
        withContext(Dispatchers.IO) {
            try {
                val entities = ranges.map { dto ->
                    BofRangeEntity(
                        path = dto.path,
                        start = dto.start,
                        current = dto.current,
                        shortName = dto.short,
                        fullName = dto.full,
                        isStart = dto.isStart,
                        isEnd = dto.isEnd,
                        singleComment = dto.singleComment,
                        lastUpdated = System.currentTimeMillis()
                    )
                }
                bofRangeBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} BOF ranges")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving BOF ranges: ${e.message}", e)
            }
        }
    }
    
    /**
     * 获取所有 BOF Range 数据
     */
    suspend fun getBofRangeData(): List<BofRangeDTO> {
        return withContext(Dispatchers.IO) {
            try {
                val entities = bofRangeBox.all
                entities.map { entity ->
                    BofRangeDTO(
                        path = entity.path,
                        start = entity.start,
                        current = entity.current,
                        short = entity.shortName,
                        full = entity.fullName,
                        isStart = entity.isStart,
                        isEnd = entity.isEnd,
                        singleComment = entity.singleComment
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching BOF ranges: ${e.message}", e)
                emptyList()
            }
        }
    }

    /**
     * 检查 Range 数据是否需要更新（超过10分钟未更新则需要更新）
     */
    suspend fun shouldUpdateRangeData(): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val latestEntity = bofRangeBox.query()
                    .orderDesc(BofRangeEntity_.lastUpdated)
                    .build()
                    .findFirst()
                
                if (latestEntity == null) {
                    true // 没有数据，需要更新
                } else {
                    val tenMinuteAgo = System.currentTimeMillis() - (10 * 60 * 1000)
                    latestEntity.lastUpdated < tenMinuteAgo
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error checking range update requirement: ${e.message}", e)
                true // 出错时默认需要更新
            }
        }
    }
    
    /**
     * 获取所有可用的比赛类型（基于Range数据）
     */
    suspend fun getAllAvailableCompetitions(): List<BofRangeEntity> {
        return withContext(Dispatchers.IO) {
            try {
                bofRangeBox.query()
                    .orderDesc(BofRangeEntity_.lastUpdated)
                    .build()
                    .find()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting available competitions: ${e.message}", e)
                emptyList()
            }
        }
    }

    /**
     * 保存团队详细数据
     */
    suspend fun saveBofTeamDetailedData(entities: List<BofTeamDetailedEntity>) {
        withContext(Dispatchers.IO) {
            try {
                bofTeamDetailedBox.put(entities)
                Log.d(TAG, "Successfully saved ${entities.size} team detailed entities")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving team detailed data: ${e.message}", e)
                throw e
            }
        }
    }
    
    /**
     * 从API响应保存团队数据
     */
    suspend fun saveBofTeamApiResponse(apiResponse: Map<String, com.madsam.otora.data.bof.remote.model.BofTeamResponse>, path: String) {
        withContext(Dispatchers.IO) {
            try {
                val entities = convertTeamResponseToEntities(apiResponse, path)
                saveBofTeamDetailedData(entities)
                Log.d(TAG, "Successfully saved team API response for path: $path with ${entities.size} teams")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving team API response for path $path: ${e.message}", e)
                throw e
            }
        }
    }
    
    /**
     * 将团队API响应转换为Entity列表
     */
    private fun convertTeamResponseToEntities(
        response: Map<String, com.madsam.otora.data.bof.remote.model.BofTeamResponse>, 
        path: String
    ): List<BofTeamDetailedEntity> {
        val moshi = com.squareup.moshi.Moshi.Builder()
            .addLast(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()
        
        val scoreAdapter = moshi.adapter(List::class.java)
        val teamTimeValueAdapter = moshi.adapter(List::class.java)
        
        return response.map { (teamName, teamData) ->
            BofTeamDetailedEntity().apply {
                this.path = path
                this.teamName = teamName
                this.compositeTeamId = BofTeamDetailedEntity.createCompositeTeamId(path, teamName)
                
                // 存储JSON数据
                this.scoreDataJson = if (teamData.score?.isNotEmpty() == true) scoreAdapter.toJson(teamData.score) else ""
                this.title1Json = if (teamData.title1?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.title1) else ""
                this.title2Json = if (teamData.title2?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.title2) else ""
                this.title3Json = if (teamData.title3?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.title3) else ""
                this.title4Json = if (teamData.title4?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.title4) else ""
                this.artist1Json = if (teamData.artist1?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.artist1) else ""
                this.artist2Json = if (teamData.artist2?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.artist2) else ""
                this.artist3Json = if (teamData.artist3?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.artist3) else ""
                this.artist4Json = if (teamData.artist4?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.artist4) else ""
                this.finalStriker1Json = if (teamData.finalStriker1?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.finalStriker1) else ""
                this.finalStriker2Json = if (teamData.finalStriker2?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.finalStriker2) else ""
                this.finalStriker3Json = if (teamData.finalStriker3?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.finalStriker3) else ""
                this.finalStriker4Json = if (teamData.finalStriker4?.isNotEmpty() == true) teamTimeValueAdapter.toJson(teamData.finalStriker4) else ""
                
                // 设置当前值（最新的值）
                this.currentTitle1 = teamData.title1?.lastOrNull()?.value ?: ""
                this.currentTitle2 = teamData.title2?.lastOrNull()?.value ?: ""
                this.currentTitle3 = teamData.title3?.lastOrNull()?.value ?: ""
                this.currentTitle4 = teamData.title4?.lastOrNull()?.value ?: ""
                this.currentArtist1 = teamData.artist1?.lastOrNull()?.value ?: ""
                this.currentArtist2 = teamData.artist2?.lastOrNull()?.value ?: ""
                this.currentArtist3 = teamData.artist3?.lastOrNull()?.value ?: ""
                this.currentArtist4 = teamData.artist4?.lastOrNull()?.value ?: ""
                this.currentFinalStriker1 = teamData.finalStriker1?.lastOrNull()?.value ?: ""
                this.currentFinalStriker2 = teamData.finalStriker2?.lastOrNull()?.value ?: ""
                this.currentFinalStriker3 = teamData.finalStriker3?.lastOrNull()?.value ?: ""
                this.currentFinalStriker4 = teamData.finalStriker4?.lastOrNull()?.value ?: ""
                
                // 计算时间范围和最新得分
                val timeRange = calculateTeamTimeRange(teamData)
                this.earliestTimestamp = timeRange.first
                this.latestTimestamp = timeRange.second
                
                val latestScore = findLatestTeamScore(teamData)
                this.latestTotalScore = latestScore?.total ?: 0.0
                this.latestAverage = latestScore?.average ?: 0.0
                this.latestImpression = latestScore?.impression ?: 0.0
                
                this.lastUpdated = System.currentTimeMillis()
            }
        }
    }
    
    /**
     * 计算团队数据的时间范围
     */
    private fun calculateTeamTimeRange(teamData: com.madsam.otora.data.bof.remote.model.BofTeamResponse): Pair<Long, Long> {
        var earliest = Long.MAX_VALUE
        var latest = Long.MIN_VALUE
        
        // 解析团队得分数据中的时间
        teamData.score?.forEach { yearData ->
            yearData.months?.forEach { monthData ->
                monthData.days?.forEach { dayData ->
                    dayData.hours?.forEach { hourData ->
                        hourData.minutes?.forEach { minuteData ->
                            val timestamp = createTimestamp(yearData.year, monthData.month, dayData.day, hourData.hour, minuteData.minute)
                            if (timestamp > 0) {
                                if (timestamp < earliest) earliest = timestamp
                                if (timestamp > latest) latest = timestamp
                            }
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
     * 查找团队最新得分
     */
    private fun findLatestTeamScore(teamData: com.madsam.otora.data.bof.remote.model.BofTeamResponse): TeamScoreSnapshot? {
        if (teamData.score?.isEmpty() != false) return null
        
        var latestScore: TeamScoreSnapshot? = null
        var latestTimestamp = Long.MIN_VALUE
        
        teamData.score?.forEach { yearData ->
            yearData.months?.forEach { monthData ->
                monthData.days?.forEach { dayData ->
                    dayData.hours?.forEach { hourData ->
                        hourData.minutes?.forEach { minuteData ->
                            val timestamp = createTimestamp(yearData.year, monthData.month, dayData.day, hourData.hour, minuteData.minute)
                            if (timestamp > latestTimestamp) {
                                latestTimestamp = timestamp
                                val values = minuteData.values
                                if (values != null) {
                                    latestScore = TeamScoreSnapshot(
                                        timestamp = timestamp,
                                        total = values.total,
                                        average = 0.0, // Team数据中没有average，可能需要计算
                                        impression = values.impression,
                                        median = parseDoubleValue(values.median)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return latestScore
    }
    
    /**
     * 创建时间戳
     */
    private fun createTimestamp(year: Int, month: Int, day: Int, hour: Int, minute: Int): Long {
        val calendar = java.util.Calendar.getInstance()
        calendar.set(year, month - 1, day, hour, minute, 0)
        calendar.set(java.util.Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }
    
    /**
     * 解析Any类型为Double值
     */
    private fun parseDoubleValue(value: Any?): Double {
        return when (value) {
            is Double -> value
            is Number -> value.toDouble()
            is String -> value.toDoubleOrNull() ?: 0.0
            else -> 0.0
        }
    }
    
    /**
     * 解析时间字符串
     */
    private fun parseTimeString(timeString: String): Long {
        return try {
            val format = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault())
            format.parse(timeString)?.time ?: 0L
        } catch (e: Exception) {
            try {
                // 尝试其他格式
                val format2 = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm", java.util.Locale.getDefault())
                format2.parse(timeString)?.time ?: 0L
            } catch (e2: Exception) {
                0L
            }
        }
    }
    
    /**
     * 根据路径获取团队详细数据
     */
    suspend fun getBofTeamDetailedData(path: String): List<BofTeamDetailedEntity> {
        return withContext(Dispatchers.IO) {
            try {
                bofTeamDetailedBox.query(
                    BofTeamDetailedEntity_.path.equal(path)
                ).build().find()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting team detailed data for path $path: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    /**
     * 根据路径和团队名称获取特定团队详细数据
     */
    suspend fun getBofTeamDetailedData(path: String, teamName: String): BofTeamDetailedEntity? {
        return withContext(Dispatchers.IO) {
            try {
                val compositeId = BofTeamDetailedEntity.createCompositeTeamId(path, teamName)
                bofTeamDetailedBox.query(
                    BofTeamDetailedEntity_.compositeTeamId.equal(compositeId)
                ).build().findFirst()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting team detailed data for $path/$teamName: ${e.message}", e)
                null
            }
        }
    }
    
    /**
     * 获取指定路径下所有团队的最新得分排行
     */
    suspend fun getTeamRankingByPath(path: String): List<TeamRankingData> {
        return withContext(Dispatchers.IO) {
            try {
                val teams = getBofTeamDetailedData(path)
                teams.map { team ->
                    TeamRankingData(
                        teamName = team.teamName,
                        latestTotalScore = team.latestTotalScore,
                        latestAverage = team.latestAverage,
                        latestImpression = team.latestImpression,
                        lastUpdated = team.lastUpdated
                    )
                }.sortedByDescending { it.latestTotalScore }
                    .mapIndexed { index, team -> team.copy(rank = index + 1) }
            } catch (e: Exception) {
                Log.e(TAG, "Error getting team ranking for path $path: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    /**
     * 删除指定路径的所有团队数据
     */
    suspend fun clearTeamDataByPath(path: String) {
        withContext(Dispatchers.IO) {
            try {
                val teams = bofTeamDetailedBox.query(
                    BofTeamDetailedEntity_.path.equal(path)
                ).build().find()
                bofTeamDetailedBox.remove(teams)
                Log.d(TAG, "Cleared ${teams.size} team entities for path: $path")
            } catch (e: Exception) {
                Log.e(TAG, "Error clearing team data for path $path: ${e.message}", e)
            }
        }
    }
}

/**
 * 团队得分快照数据类
 */
internal data class TeamScoreSnapshot(
    val timestamp: Long,
    val total: Double,
    val average: Double,
    val impression: Double,
    val median: Double
)

/**
 * 团队排行数据类
 */
data class TeamRankingData(
    val teamName: String,
    val latestTotalScore: Double,
    val latestAverage: Double,
    val latestImpression: Double,
    val lastUpdated: Long,
    val rank: Int = 0
)
