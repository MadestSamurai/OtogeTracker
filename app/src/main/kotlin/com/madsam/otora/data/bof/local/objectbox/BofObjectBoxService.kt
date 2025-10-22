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
    
    // 时序评论数据相关 Box
    private val bofCommentTimeSeriesBox by lazy { boxStore.boxFor(BofCommentTimeSeriesEntity::class.java) }
    private val bofCommentStatsHistoryBox by lazy { boxStore.boxFor(BofCommentStatsHistoryEntity::class.java) }
    private val bofCommentTextHistoryBox by lazy { boxStore.boxFor(BofCommentTextHistoryEntity::class.java) }
    private val bofCommentDetailTimeSeriesBox by lazy { boxStore.boxFor(BofCommentDetailTimeSeriesEntity::class.java) }

    /**
     * 根据日期获取评论数据
     */
    suspend fun getCommentByTime(currentDate: String): List<BofCommentUI> {
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
                
                // 先删除该 path 的所有旧历史数据
                Log.d(TAG, "Removing old team history data for path: $path")
                val oldScoreCount = teamScoreHistoryBox.query(
                    BofTeamScoreHistoryEntity_.path.equal(path)
                ).build().remove()
                Log.d(TAG, "Removed $oldScoreCount old team score history records")
                
                val oldTitleCount = teamTitleHistoryBox.query(
                    BofTeamTitleHistoryEntity_.path.equal(path)
                ).build().remove()
                Log.d(TAG, "Removed $oldTitleCount old team title history records")
                
                val oldArtistCount = teamArtistHistoryBox.query(
                    BofTeamArtistHistoryEntity_.path.equal(path)
                ).build().remove()
                Log.d(TAG, "Removed $oldArtistCount old team artist history records")
                
                val oldFinalStrikerCount = teamFinalStrikerHistoryBox.query(
                    BofTeamFinalStrikerHistoryEntity_.path.equal(path)
                ).build().remove()
                Log.d(TAG, "Removed $oldFinalStrikerCount old team final striker history records")
                
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
                                                average = 0.0, // Team 数据没有 average 字段
                                                // 保存各作品分数
                                                total1 = parseDoubleValue(values.total1),
                                                total2 = parseDoubleValue(values.total2),
                                                total3 = parseDoubleValue(values.total3),
                                                total4 = parseDoubleValue(values.total4),
                                                // 保存各作品中位数
                                                median1 = parseDoubleValue(values.median1),
                                                median2 = parseDoubleValue(values.median2),
                                                median3 = parseDoubleValue(values.median3),
                                                median4 = parseDoubleValue(values.median4)
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
    
    /**
     * 保存时序评论数据到数据库
     */
    suspend fun saveBofCommentTimeSeriesApiResponse(
        commentMap: Map<String, com.madsam.otora.data.bof.remote.model.BofUserCommentData>,
        path: String
    ) {
        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Starting to save time series comment data for path: $path")
                val startTime = System.currentTimeMillis()
                
                // 先删除该 path 的所有旧数据
                Log.d(TAG, "Removing old time series comment data for path: $path")
                val oldUserCount = bofCommentTimeSeriesBox.query(
                    BofCommentTimeSeriesEntity_.path.equal(path)
                ).build().remove()
                Log.d(TAG, "Removed $oldUserCount old user records")
                
                val oldStatsCount = bofCommentStatsHistoryBox.query(
                    BofCommentStatsHistoryEntity_.path.equal(path)
                ).build().remove()
                Log.d(TAG, "Removed $oldStatsCount old stats history records")
                
                val oldTextCount = bofCommentTextHistoryBox.query(
                    BofCommentTextHistoryEntity_.path.equal(path)
                ).build().remove()
                Log.d(TAG, "Removed $oldTextCount old text history records")
                
                val oldDetailCount = bofCommentDetailTimeSeriesBox.query(
                    BofCommentDetailTimeSeriesEntity_.path.equal(path)
                ).build().remove()
                Log.d(TAG, "Removed $oldDetailCount old detail records")
                
                // 准备数据列表
                val userEntities = mutableListOf<BofCommentTimeSeriesEntity>()
                val statsHistoryEntities = mutableListOf<BofCommentStatsHistoryEntity>()
                val textHistoryEntities = mutableListOf<BofCommentTextHistoryEntity>()
                val detailEntities = mutableListOf<BofCommentDetailTimeSeriesEntity>()
                
                // 遍历每个用户
                commentMap.forEach { (username, userData) ->
                    // 1. 解析并保存统计历史（Stats 树形结构扁平化）
                    userData.stats?.forEach { yearNode ->
                        yearNode.children?.forEach { monthNode ->
                            monthNode.children?.forEach { dayNode ->
                                dayNode.children?.forEach { hourNode ->
                                    hourNode.children?.forEach { minuteNode ->
                                        val timestamp = BofCommentStatsHistoryEntity.createTimestamp(
                                            yearNode.year,
                                            monthNode.month,
                                            dayNode.day,
                                            hourNode.hour,
                                            minuteNode.minute
                                        )
                                        
                                        val values = minuteNode.values
                                        if (values != null) {
                                            val statsEntity = BofCommentStatsHistoryEntity(
                                                username = username,
                                                path = path,
                                                timestamp = timestamp,
                                                year = yearNode.year,
                                                month = monthNode.month,
                                                day = dayNode.day,
                                                hour = hourNode.hour,
                                                minute = minuteNode.minute,
                                                voteCount = values.vote,
                                                voteTotal = values.voteTotal,
                                                shortCount = values.short,
                                                shortTotal = values.shortTotal,
                                                shortComment = values.shortComment,
                                                longCount = values.long,
                                                longTotal = values.longTotal,
                                                longComment = values.longComment,
                                                total = values.total
                                            )
                                            statsHistoryEntities.add(statsEntity)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                    // 2. 解析并保存文本字段历史（user, pattern, country）
                    userData.user?.forEach { record ->
                        val textEntity = BofCommentTextHistoryEntity(
                            username = username,
                            path = path,
                            fieldType = BofCommentTextHistoryEntity.FIELD_TYPE_USER,
                            timestamp = BofCommentTextHistoryEntity.parseTimestamp(record.time),
                            timeString = record.time,
                            value = record.value
                        )
                        textHistoryEntities.add(textEntity)
                    }
                    
                    userData.pattern?.forEach { record ->
                        val textEntity = BofCommentTextHistoryEntity(
                            username = username,
                            path = path,
                            fieldType = BofCommentTextHistoryEntity.FIELD_TYPE_PATTERN,
                            timestamp = BofCommentTextHistoryEntity.parseTimestamp(record.time),
                            timeString = record.time,
                            value = record.value
                        )
                        textHistoryEntities.add(textEntity)
                    }
                    
                    userData.country?.forEach { record ->
                        val textEntity = BofCommentTextHistoryEntity(
                            username = username,
                            path = path,
                            fieldType = BofCommentTextHistoryEntity.FIELD_TYPE_COUNTRY,
                            timestamp = BofCommentTextHistoryEntity.parseTimestamp(record.time),
                            timeString = record.time,
                            value = record.value
                        )
                        textHistoryEntities.add(textEntity)
                    }
                    
                    // 3. 解析并保存详细评价记录
                    userData.voteDetail?.forEach { detail ->
                        val detailEntity = BofCommentDetailTimeSeriesEntity(
                            username = username,
                            path = path,
                            type = BofCommentDetailTimeSeriesEntity.TYPE_VOTE,
                            workId = detail.workId,
                            timestamp = BofCommentDetailTimeSeriesEntity.parseTimestamp(detail.date),
                            dateString = detail.date,
                            score = detail.score
                        )
                        detailEntities.add(detailEntity)
                    }
                    
                    userData.shortDetail?.forEach { detail ->
                        val detailEntity = BofCommentDetailTimeSeriesEntity(
                            username = username,
                            path = path,
                            type = BofCommentDetailTimeSeriesEntity.TYPE_SHORT,
                            workId = detail.workId,
                            timestamp = BofCommentDetailTimeSeriesEntity.parseTimestamp(detail.date),
                            dateString = detail.date,
                            score = detail.score
                        )
                        detailEntities.add(detailEntity)
                    }
                    
                    userData.longDetail?.forEach { detail ->
                        val detailEntity = BofCommentDetailTimeSeriesEntity(
                            username = username,
                            path = path,
                            type = BofCommentDetailTimeSeriesEntity.TYPE_LONG,
                            workId = detail.workId,
                            timestamp = BofCommentDetailTimeSeriesEntity.parseTimestamp(detail.date),
                            dateString = detail.date,
                            score = detail.score
                        )
                        detailEntities.add(detailEntity)
                    }
                    
                    // 4. 创建用户主实体
                    val latestStats = findLatestCommentStats(statsHistoryEntities.filter { it.username == username })
                    val timeRange = calculateCommentTimeRange(statsHistoryEntities.filter { it.username == username })
                    
                    val currentUser = userData.user?.lastOrNull()?.value ?: username
                    val currentPattern = userData.pattern?.lastOrNull()?.value ?: ""
                    val currentCountry = userData.country?.lastOrNull()?.value ?: ""
                    
                    // 将 id_code 列表转换为 JSON 字符串
                    val idCodesJson = com.squareup.moshi.Moshi.Builder().build()
                        .adapter<List<String>>(List::class.java)
                        .toJson(userData.idCode ?: emptyList())
                    
                    val userEntity = BofCommentTimeSeriesEntity(
                        username = username,
                        path = path,
                        currentUser = currentUser,
                        currentPattern = currentPattern,
                        currentCountry = currentCountry,
                        idCodesJson = idCodesJson,
                        latestVote = latestStats?.voteCount ?: 0,
                        latestVoteTotal = latestStats?.voteTotal ?: 0,
                        latestShort = latestStats?.shortCount ?: 0,
                        latestShortTotal = latestStats?.shortTotal ?: 0,
                        latestShortComment = latestStats?.shortComment ?: 0,
                        latestLong = latestStats?.longCount ?: 0,
                        latestLongTotal = latestStats?.longTotal ?: 0,
                        latestLongComment = latestStats?.longComment ?: 0,
                        latestTotal = latestStats?.total ?: 0,
                        earliestTimestamp = timeRange.first,
                        latestTimestamp = timeRange.second,
                        lastUpdated = System.currentTimeMillis()
                    )
                    userEntities.add(userEntity)
                }
                
                // 批量保存到数据库
                Log.d(TAG, "Saving ${userEntities.size} users")
                bofCommentTimeSeriesBox.put(userEntities)
                
                Log.d(TAG, "Saving ${statsHistoryEntities.size} stats history records")
                bofCommentStatsHistoryBox.put(statsHistoryEntities)
                
                Log.d(TAG, "Saving ${textHistoryEntities.size} text history records")
                bofCommentTextHistoryBox.put(textHistoryEntities)
                
                Log.d(TAG, "Saving ${detailEntities.size} detail records")
                bofCommentDetailTimeSeriesBox.put(detailEntities)
                
                val endTime = System.currentTimeMillis()
                Log.d(TAG, "Time series comment data saved in ${endTime - startTime}ms")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving time series comment data for path $path: ${e.message}", e)
                throw e
            }
        }
    }
    
    /**
     * 查找最新的评论统计数据
     */
    private fun findLatestCommentStats(stats: List<BofCommentStatsHistoryEntity>): BofCommentStatsHistoryEntity? {
        return stats.maxByOrNull { it.timestamp }
    }
    
    /**
     * 计算评论数据的时间范围
     */
    private fun calculateCommentTimeRange(stats: List<BofCommentStatsHistoryEntity>): Pair<Long, Long> {
        if (stats.isEmpty()) return 0L to 0L
        
        val timestamps = stats.map { it.timestamp }
        return timestamps.minOrNull()!! to timestamps.maxOrNull()!!
    }
    
    /**
     * 获取时序评论数据的统计数量
     */
    suspend fun getCommentTimeSeriesCount(path: String): Long {
        return withContext(Dispatchers.IO) {
            try {
                bofCommentTimeSeriesBox.query(
                    BofCommentTimeSeriesEntity_.path.equal(path)
                ).build().count()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting time series comment count for path $path: ${e.message}", e)
                0L
            }
        }
    }

    /**
     * 获取时序评论数据并转换为 UI 模型
     * @param path 比赛路径
     * @param timestamp 指定的时间戳（毫秒），如果为 null 则获取最新数据
     */
    suspend fun getCommentTimeSeriesAsUI(
        path: String,
        timestamp: Long? = null
    ): List<BofCommentUI> {
        return withContext(Dispatchers.IO) {
            try {
                // 获取所有用户
                val users = bofCommentTimeSeriesBox.query(
                    BofCommentTimeSeriesEntity_.path.equal(path)
                ).build().find()
                
                if (users.isEmpty()) {
                    return@withContext emptyList()
                }
                
                // 对每个用户，获取指定时间点的统计数据
                val commentUIList = users.mapNotNull { user ->
                    // 获取统计历史
                    val statsHistory = bofCommentStatsHistoryBox.query(
                        BofCommentStatsHistoryEntity_.path.equal(path)
                            .and(BofCommentStatsHistoryEntity_.username.equal(user.username))
                    ).order(BofCommentStatsHistoryEntity_.timestamp).build().find()
                    
                    if (statsHistory.isEmpty()) {
                        return@mapNotNull null
                    }
                    
                    // 找到指定时间点或最近的统计数据
                    val targetStats = if (timestamp != null) {
                        // 找到小于等于指定时间戳的最后一条记录
                        statsHistory.lastOrNull { it.timestamp <= timestamp }
                    } else {
                        // 获取最新的数据
                        statsHistory.lastOrNull()
                    }
                    
                    if (targetStats == null) {
                        return@mapNotNull null
                    }
                    
                    // 获取详细评价记录，用于生成图表数据
                    val voteDetails = bofCommentDetailTimeSeriesBox.query(
                        BofCommentDetailTimeSeriesEntity_.path.equal(path)
                            .and(BofCommentDetailTimeSeriesEntity_.username.equal(user.username))
                            .and(BofCommentDetailTimeSeriesEntity_.type.equal(BofCommentDetailTimeSeriesEntity.TYPE_VOTE))
                    ).build().find()
                    
                    val shortDetails = bofCommentDetailTimeSeriesBox.query(
                        BofCommentDetailTimeSeriesEntity_.path.equal(path)
                            .and(BofCommentDetailTimeSeriesEntity_.username.equal(user.username))
                            .and(BofCommentDetailTimeSeriesEntity_.type.equal(BofCommentDetailTimeSeriesEntity.TYPE_SHORT))
                    ).build().find()
                    
                    val longDetails = bofCommentDetailTimeSeriesBox.query(
                        BofCommentDetailTimeSeriesEntity_.path.equal(path)
                            .and(BofCommentDetailTimeSeriesEntity_.username.equal(user.username))
                            .and(BofCommentDetailTimeSeriesEntity_.type.equal(BofCommentDetailTimeSeriesEntity.TYPE_LONG))
                    ).build().find()
                    
                    // 过滤到指定时间点之前的有效评价
                    val effectiveVotes = if (timestamp != null) {
                        voteDetails.filter { it.timestamp <= timestamp && BofCommentDetailTimeSeriesEntity.isValidScore(it.score) }
                    } else {
                        voteDetails.filter { BofCommentDetailTimeSeriesEntity.isValidScore(it.score) }
                    }
                    
                    val effectiveShorts = if (timestamp != null) {
                        shortDetails.filter { it.timestamp <= timestamp && BofCommentDetailTimeSeriesEntity.isValidScore(it.score) }
                    } else {
                        shortDetails.filter { BofCommentDetailTimeSeriesEntity.isValidScore(it.score) }
                    }
                    
                    val effectiveLongs = if (timestamp != null) {
                        longDetails.filter { it.timestamp <= timestamp && BofCommentDetailTimeSeriesEntity.isValidScore(it.score) }
                    } else {
                        longDetails.filter { BofCommentDetailTimeSeriesEntity.isValidScore(it.score) }
                    }
                    
                    // 生成图表数据（按分数排序）
                    val voteChartData = effectiveVotes
                        .groupBy { it.workId }
                        .mapValues { it.value.maxByOrNull { detail -> detail.timestamp } }
                        .values
                        .mapNotNull { it?.score }
                        .sorted()
                    
                    val shortChartData = effectiveShorts
                        .groupBy { it.workId }
                        .mapValues { it.value.maxByOrNull { detail -> detail.timestamp } }
                        .values
                        .mapNotNull { it?.score }
                        .sorted()
                    
                    val longChartData = effectiveLongs
                        .groupBy { it.workId }
                        .mapValues { it.value.maxByOrNull { detail -> detail.timestamp } }
                        .values
                        .mapNotNull { it?.score }
                        .sorted()
                    
                    // 计算平均分
                    val voteAve = if (targetStats.voteCount > 0) {
                        targetStats.voteTotal.toDouble() / targetStats.voteCount
                    } else {
                        0.0
                    }
                    
                    val shortAve = if (targetStats.shortCount > 0) {
                        targetStats.shortTotal.toDouble() / targetStats.shortCount
                    } else {
                        0.0
                    }
                    
                    val longAve = if (targetStats.longCount > 0) {
                        targetStats.longTotal.toDouble() / targetStats.longCount
                    } else {
                        0.0
                    }
                    
                    val totalAve = if (targetStats.total > 0) {
                        (targetStats.voteTotal + targetStats.shortTotal + targetStats.longTotal).toDouble() / targetStats.total
                    } else {
                        0.0
                    }
                    
                    // 创建 BofCommentUI 对象
                    BofCommentUI(
                        index = 0, // 排名将在外部设置
                        user = user.currentUser,
                        pattern = user.currentPattern,
                        country = user.currentCountry,
                        vote = targetStats.voteCount,
                        voteTotal = targetStats.voteTotal,
                        voteAve = voteAve,
                        voteChartData = voteChartData,
                        short = targetStats.shortCount,
                        shortTotal = targetStats.shortTotal,
                        shortAve = shortAve,
                        shortComment = targetStats.shortComment,
                        shortChartData = shortChartData,
                        long = targetStats.longCount,
                        longTotal = targetStats.longTotal,
                        longAve = longAve,
                        longComment = targetStats.longComment,
                        longChartData = longChartData,
                        total = targetStats.total,
                        totalAve = totalAve
                    )
                }
                
                commentUIList
            } catch (e: Exception) {
                Log.e(TAG, "Error getting comment time series as UI: ${e.message}", e)
                emptyList()
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