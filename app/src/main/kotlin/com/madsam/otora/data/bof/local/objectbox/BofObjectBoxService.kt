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
                        short = dto.short,
                        full = dto.full,
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
                        short = entity.short,
                        full = entity.full,
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
     * 检查 Range 数据是否需要更新（超过1小时）
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
                    val oneHourAgo = System.currentTimeMillis() - (60 * 60 * 1000)
                    latestEntity.lastUpdated < oneHourAgo
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error checking range update requirement: ${e.message}", e)
                true // 出错时默认需要更新
            }
        }
    }
}
