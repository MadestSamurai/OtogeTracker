package com.madsam.otora.data.bof.local.objectbox

import android.util.Log
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.data.bof.local.model.*
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * BOF 数据的 ObjectBox 本地存储服务
 */
internal class BofObjectBoxService {
    
    companion object {
        private const val TAG = "BofObjectBoxService"
    }
    
    private val boxStore by lazy { ObjectBoxManager.getBoxStore() }
    private val bofTeamBox by lazy { boxStore.boxFor(BofTeamEntity::class.java) }
    private val teamScoreHistoryBox by lazy { boxStore.boxFor(BofTeamScoreHistoryEntity::class.java) }
    private val teamTitleHistoryBox by lazy { boxStore.boxFor(BofTeamTitleHistoryEntity::class.java) }
    private val teamArtistHistoryBox by lazy { boxStore.boxFor(BofTeamArtistHistoryEntity::class.java) }
    private val teamFinalStrikerHistoryBox by lazy { boxStore.boxFor(BofTeamFinalStrikerHistoryEntity::class.java) }
    private val bofCommentBox by lazy { boxStore.boxFor(BofCommentEntity::class.java) }
    private val bofCommentDetailBox by lazy { boxStore.boxFor(BofCommentDetailEntity::class.java) }
    private val bofRangeBox by lazy { boxStore.boxFor(BofRangeEntity::class.java) }

    /**
     * 根据日期获取评论数据
     */
    suspend fun getBofCommentByTime(currentDate: String): List<BofCommentUI> {
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
                        vote = entry.voteCount,
                        voteTotal = entry.voteTotal,
                        voteAve = entry.voteAve,
                        voteChartData = vote.sortedBy { it.score }.map { it.score },
                        short = entry.shortCount,
                        shortTotal = entry.shortTotal,
                        shortAve = entry.shortAve,
                        shortComment = entry.shortComment,
                        shortChartData = short.sortedBy { it.score }.map { it.score },
                        long = entry.longCount,
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
     * 获取最新的评论数据
     */
    suspend fun getBofttCommentLatest(): List<BofCommentUI> {
        return withContext(Dispatchers.IO) {
            try {
                val allComments = bofCommentBox.all
                
                if (allComments.isEmpty()) {
                    return@withContext emptyList()
                }
                
                // Find the most recent date
                val latestDate = allComments.maxByOrNull { it.date }?.date
                
                if (latestDate != null) {
                    return@withContext getBofCommentByTime(latestDate)
                } else {
                    return@withContext emptyList()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error in getBofCommentLatest: ${e.message}")
                emptyList()
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
    suspend fun saveBofRangeData(ranges: List<BofRangeResponse>) {
        withContext(Dispatchers.IO) {
            try {
                // 先清除所有旧数据，避免 null 字段问题
                bofRangeBox.removeAll()
                
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
                        commentDate = dto.commentDate.ifEmpty { "" },
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
    suspend fun getBofRangeData(): List<BofRangeResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val entities = bofRangeBox.all
                entities.map { entity ->
                    BofRangeResponse(
                        path = entity.path,
                        start = entity.start,
                        current = entity.current,
                        short = entity.shortName,
                        full = entity.fullName,
                        isStart = entity.isStart,
                        isEnd = entity.isEnd,
                        singleComment = entity.singleComment,
                        commentDate = entity.commentDate
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
     * 从API响应保存团队数据到新的数据库结构
     */
    suspend fun saveBofTeamApiResponse(apiResponse: Map<String, com.madsam.otora.data.bof.remote.model.BofTeamResponse>, path: String) {
        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Starting to save team API response for path: $path")
                val startTime = System.currentTimeMillis()
                
                // 准备数据列表
                val teamEntities = mutableListOf<BofTeamEntity>()
                val scoreHistoryEntities = mutableListOf<BofTeamScoreHistoryEntity>()
                val titleHistoryEntities = mutableListOf<BofTeamTitleHistoryEntity>()
                val artistHistoryEntities = mutableListOf<BofTeamArtistHistoryEntity>()
                val finalStrikerHistoryEntities = mutableListOf<BofTeamFinalStrikerHistoryEntity>()
                
                apiResponse.forEach { (teamName, teamData) ->
                    val compositeTeamId = BofTeamEntity.createCompositeTeamId(path, teamName)
                    
                    // 1. 创建团队主实体
                    val teamEntity = BofTeamEntity().apply {
                        this.path = path
                        this.teamName = teamName
                        this.compositeTeamId = compositeTeamId
                        
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
                        this.latestMedian = latestScore?.median ?: 0.0
                        this.latestImpression = latestScore?.impression ?: 0.0
                        
                        // 获取最新的各作品分数
                        val latestValues = getLatestTeamValues(teamData)
                        this.latestScore1 = parseDoubleValue(latestValues?.total1)
                        this.latestScore2 = parseDoubleValue(latestValues?.total2)
                        this.latestScore3 = parseDoubleValue(latestValues?.total3)
                        this.latestScore4 = parseDoubleValue(latestValues?.total4)
                        
                        this.lastUpdated = System.currentTimeMillis()
                    }
                    teamEntities.add(teamEntity)
                    
                    // 2. 解析并保存分数历史
                    teamData.score?.forEach { yearData ->
                        yearData.months?.forEach { monthData ->
                            monthData.days?.forEach { dayData ->
                                dayData.hours?.forEach { hourData ->
                                    hourData.minutes?.forEach { minuteData ->
                                        val timestamp = BofTeamScoreHistoryEntity.createTimestamp(
                                            yearData.year, monthData.month, dayData.day,
                                            hourData.hour, minuteData.minute
                                        )
                                        
                                        val values = minuteData.values
                                        if (values != null) {
                                            val scoreEntity = BofTeamScoreHistoryEntity(
                                                compositeTeamId = compositeTeamId,
                                                path = path,
                                                timestamp = timestamp,
                                                year = yearData.year,
                                                month = monthData.month,
                                                day = dayData.day,
                                                hour = hourData.hour,
                                                minute = minuteData.minute,
                                                impression = values.impression,
                                                total = values.total,
                                                median = parseDoubleValue(values.median),
                                                average = 0.0 // Team 数据没有 average 字段
                                            )
                                            scoreHistoryEntities.add(scoreEntity)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                    // 3. 解析并保存 Title 历史（workSlot 1-4）
                    listOf(
                        1 to teamData.title1,
                        2 to teamData.title2,
                        3 to teamData.title3,
                        4 to teamData.title4
                    ).forEach { (workSlot, titleList) ->
                        titleList?.forEach { titleItem ->
                            val timestamp = BofTeamTitleHistoryEntity.parseTimestamp(titleItem.time)
                            val titleEntity = BofTeamTitleHistoryEntity(
                                compositeTeamId = compositeTeamId,
                                path = path,
                                workSlot = workSlot,
                                timestamp = timestamp,
                                timeString = titleItem.time,
                                title = titleItem.value
                            )
                            titleHistoryEntities.add(titleEntity)
                        }
                    }
                    
                    // 4. 解析并保存 Artist 历史（workSlot 1-4）
                    listOf(
                        1 to teamData.artist1,
                        2 to teamData.artist2,
                        3 to teamData.artist3,
                        4 to teamData.artist4
                    ).forEach { (workSlot, artistList) ->
                        artistList?.forEach { artistItem ->
                            val timestamp = BofTeamArtistHistoryEntity.parseTimestamp(artistItem.time)
                            val artistEntity = BofTeamArtistHistoryEntity(
                                compositeTeamId = compositeTeamId,
                                path = path,
                                workSlot = workSlot,
                                timestamp = timestamp,
                                timeString = artistItem.time,
                                artist = artistItem.value
                            )
                            artistHistoryEntities.add(artistEntity)
                        }
                    }
                    
                    // 5. 解析并保存 FinalStriker 历史（workSlot 1-4）
                    listOf(
                        1 to teamData.finalStriker1,
                        2 to teamData.finalStriker2,
                        3 to teamData.finalStriker3,
                        4 to teamData.finalStriker4
                    ).forEach { (workSlot, finalStrikerList) ->
                        finalStrikerList?.forEach { finalStrikerItem ->
                            val timestamp = BofTeamFinalStrikerHistoryEntity.parseTimestamp(finalStrikerItem.time)
                            val finalStrikerEntity = BofTeamFinalStrikerHistoryEntity(
                                compositeTeamId = compositeTeamId,
                                path = path,
                                workSlot = workSlot,
                                timestamp = timestamp,
                                timeString = finalStrikerItem.time,
                                finalStriker = finalStrikerItem.value
                            )
                            finalStrikerHistoryEntities.add(finalStrikerEntity)
                        }
                    }
                }
                
                // 批量保存到数据库
                Log.d(TAG, "Saving ${teamEntities.size} teams")
                bofTeamBox.put(teamEntities)
                
                Log.d(TAG, "Saving ${scoreHistoryEntities.size} team score history records")
                teamScoreHistoryBox.put(scoreHistoryEntities)
                
                Log.d(TAG, "Saving ${titleHistoryEntities.size} team title history records")
                teamTitleHistoryBox.put(titleHistoryEntities)
                
                Log.d(TAG, "Saving ${artistHistoryEntities.size} team artist history records")
                teamArtistHistoryBox.put(artistHistoryEntities)
                
                Log.d(TAG, "Saving ${finalStrikerHistoryEntities.size} team final striker history records")
                teamFinalStrikerHistoryBox.put(finalStrikerHistoryEntities)
                
                val endTime = System.currentTimeMillis()
                Log.d(TAG, "Team API response saved in ${endTime - startTime}ms")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving team API response for path $path: ${e.message}", e)
                throw e
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
     * 获取团队最新的Values数据
     */
    private fun getLatestTeamValues(teamData: com.madsam.otora.data.bof.remote.model.BofTeamResponse): com.madsam.otora.data.bof.remote.model.TeamValues? {
        if (teamData.score?.isEmpty() != false) return null
        
        var latestValues: com.madsam.otora.data.bof.remote.model.TeamValues? = null
        var latestTimestamp = Long.MIN_VALUE
        
        teamData.score?.forEach { yearData ->
            yearData.months?.forEach { monthData ->
                monthData.days?.forEach { dayData ->
                    dayData.hours?.forEach { hourData ->
                        hourData.minutes?.forEach { minuteData ->
                            val timestamp = createTimestamp(yearData.year, monthData.month, dayData.day, hourData.hour, minuteData.minute)
                            if (timestamp > latestTimestamp) {
                                latestTimestamp = timestamp
                                latestValues = minuteData.values
                            }
                        }
                    }
                }
            }
        }
        
        return latestValues
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
     * 根据路径获取团队详细数据
     */
    suspend fun getBofTeamData(path: String): List<BofTeamEntity> {
        return withContext(Dispatchers.IO) {
            try {
                bofTeamBox.query(
                    BofTeamEntity_.path.equal(path)
                ).build().find()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting team data for path $path: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    /**
     * 保存评论API响应数据
     */
    suspend fun saveBofCommentApiResponse(commentList: List<com.madsam.otora.data.bof.remote.model.BofCommentSingleResponse>, date: String) {
        withContext(Dispatchers.IO) {
            try {
                // 先删除相同日期的旧评论数据
                val oldComments = bofCommentBox.query(
                    BofCommentEntity_.date.equal(date)
                ).build().find()
                
                if (oldComments.isNotEmpty()) {
                    bofCommentBox.remove(oldComments)
                    Log.d(TAG, "Removed ${oldComments.size} old comments for date $date")
                }
                
                // 删除相同日期的旧评论详情数据
                val oldDetails = bofCommentDetailBox.query(
                    BofCommentDetailEntity_.date.equal(date)
                ).build().find()
                
                if (oldDetails.isNotEmpty()) {
                    bofCommentDetailBox.remove(oldDetails)
                    Log.d(TAG, "Removed ${oldDetails.size} old comment details for date $date")
                }
                
                val commentsToSave = mutableListOf<BofCommentEntity>()
                val detailsToSave = mutableListOf<BofCommentDetailEntity>()
                
                commentList.forEach { comment ->
                    val entity = BofCommentEntity(
                        commentId = "${date}_${comment.user}${if (comment.pattern != null) "_${comment.pattern}" else ""}",
                        date = date,
                        user = comment.user,
                        pattern = if (comment.pattern != null) comment.pattern.toString() else "",
                        country = comment.country,
                        voteCount = comment.vote,
                        voteTotal = comment.voteTotal,
                        voteAve = comment.voteAve,
                        shortCount = comment.short,
                        shortTotal = comment.shortTotal,
                        shortAve = comment.shortAve,
                        shortComment = comment.shortComment,
                        longCount = comment.long,
                        longTotal = comment.longTotal,
                        longAve = comment.longAve,
                        longComment = comment.longComment,
                        total = comment.total,
                        totalAve = comment.totalAve
                    )
                    commentsToSave.add(entity)
                    
                    val details = listOf(comment.voteDetail, comment.shortDetail, comment.longDetail)

                    details.forEach { detailList ->
                        if (detailList.isNotEmpty()) {
                            detailList.forEach { detail ->
                                val detailEntity = BofCommentDetailEntity(
                                    detailId = "${detail.evalNumber}_${detail.workNumber}",
                                    user = comment.user,
                                    score = detail.score,
                                    code = detail.evalNumber,
                                    country = detail.evalPosition,
                                    workNumber = detail.workNumber,
                                    date = date,
                                    type = when (detailList) {
                                        comment.voteDetail -> "vote"
                                        comment.shortDetail -> "short"
                                        else -> "long"
                                    }
                                )
                                detailsToSave.add(detailEntity)
                            }
                        }
                    }
                }
                
                // 保存到ObjectBox
                saveBofCommentData(commentsToSave)
                saveBofCommentDetailData(detailsToSave)
                
                Log.d(TAG, "Saved ${commentsToSave.size} comments and ${detailsToSave.size} comment details for date $date")
                
            } catch (e: Exception) {
                Log.e(TAG, "Error saving comment API response for date $date: ${e.message}", e)
                throw e
            }
        }
    }
    
    /**
     * 获取指定日期的评论数量
     */
    suspend fun getCommentCount(date: String): Long {
        return withContext(Dispatchers.IO) {
            try {
                bofCommentBox.query(
                    BofCommentEntity_.date.equal(date)
                ).build().count()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting comment count for date $date: ${e.message}", e)
                0L
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
    val impression: Double,
    val median: Double
)