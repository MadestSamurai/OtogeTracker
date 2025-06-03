package com.madsam.otora.data.bof.local.api

import android.util.Log
import com.madsam.otora.data.bof.local.model.BofCommentDetailEntity
import com.madsam.otora.data.bof.local.model.BofCommentEntity
import com.madsam.otora.data.bof.local.model.BofEntryEntity
import com.madsam.otora.data.bof.local.model.BofPointEntity
import com.madsam.otora.data.bof.local.model.BofTeamEntity
import com.madsam.otora.data.bof.local.model.BofTeamPointEntity
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.data.bof.ui.model.BofEntryUI
import com.madsam.otora.data.bof.ui.model.BofTeamUI
import com.madsam.otora.core.utils.CommonUtils
import io.github.xilinjia.krdb.Realm
import io.github.xilinjia.krdb.RealmConfiguration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.collections.filter
import kotlin.math.abs

internal class BofLocalService {
    companion object {
        private const val TAG = "BofLocalService"
    }

    private val realmConfig = RealmConfiguration.Builder(
        schema = setOf(
            BofEntryEntity::class,
            BofPointEntity::class,
            BofTeamEntity::class,
            BofTeamPointEntity::class,
            BofCommentEntity::class,
            BofCommentDetailEntity::class
        )
    )
        .name("otoge-tracker-bof.realm")
        .schemaVersion(1)
        .build()

    suspend fun getBofttEntryByTime(currentTime: Long, compareTime: Long): List<BofEntryUI> {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val startTime = currentTime - 24 * 60 * 60 * 1000
                val startTimeCompare = compareTime - 24 * 60 * 60 * 1000
                val points = realm.query(
                    clazz = BofPointEntity::class,
                    query = "time >= $0 AND time <= $1",
                    startTime, currentTime
                ).find()
                val pointsCompare = realm.query(
                    clazz = BofPointEntity::class,
                    query = "time >= $0 AND time <= $1",
                    startTimeCompare, compareTime
                ).find()

                if (points.isEmpty()) {
                    realm.close()
                    return@withContext emptyList<BofEntryUI>()
                }

                val date = CommonUtils.millisToYmd(currentTime).substring(0, 10)
                val entries = realm.query(
                    clazz = BofEntryEntity::class,
                    query = "date == $0",
                    date
                ).find()

                val pointsMap = points.groupBy { it.no }
                val pointsMapCompare = pointsCompare.groupBy { it.no }

                entries.map { entry ->
                    val entryPoints = pointsMap[entry.no] ?: emptyList()
                    val entryPointsCompare = pointsMapCompare[entry.no] ?: emptyList()
                    val closestPoint = entryPoints
                        .filter { it.time <= currentTime }
                        .minByOrNull { abs(it.time - currentTime) }
                    val closestPointCompare = entryPointsCompare
                        .filter { it.time <= compareTime }
                        .minByOrNull { abs(it.time - compareTime) }

                    BofEntryUI(
                        previousRank = 0,
                        currentRank = 0,
                        team = entry.team,
                        artist = entry.artist,
                        genre = entry.genre,
                        title = entry.title,
                        regist = entry.regist,
                        update = entry.update,
                        impr = closestPoint?.impr ?: 0,
                        total = closestPoint?.total ?: 0,
                        median = closestPoint?.median ?: 0.0,
                        avg = closestPoint?.avg ?: 0.0,
                        oldImpr = closestPointCompare?.impr ?: 0,
                        oldTotal = closestPointCompare?.total ?: 0,
                        oldMedian = closestPointCompare?.median ?: 0.0,
                        oldAvg = closestPointCompare?.avg ?: 0.0,
                        time = CommonUtils.millisToYmd(currentTime).substring(11, 16)
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching entry by time: ${e.message}")
                emptyList()
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getBofttTeamByTime(currentTime: Long, compareTime: Long): List<BofTeamUI> {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val startTime = currentTime - 24 * 60 * 60 * 1000
                val startTimeCompare = compareTime - 24 * 60 * 60 * 1000

                val points = realm.query(
                    clazz = BofTeamPointEntity::class,
                    query = "time >= $0 AND time <= $1",
                    startTime, currentTime
                ).find()
                val pointsCompare = realm.query(
                    clazz = BofTeamPointEntity::class,
                    query = "time >= $0 AND time <= $1",
                    startTimeCompare, compareTime
                ).find()

                if (points.isEmpty()) {
                    realm.close()
                    return@withContext emptyList<BofTeamUI>()
                }

                val date = CommonUtils.millisToYmd(currentTime).substring(0, 10)
                val teams = realm.query(
                    clazz = BofTeamEntity::class,
                    query = "date == $0",
                    date
                ).find()

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
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getBofttCommentByTime(currentDate: String): List<BofCommentUI> {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val comments = realm.query(
                    clazz = BofCommentEntity::class,
                    query = "date == $0",
                    currentDate
                ).find()

                if (comments.isEmpty()) {
                    realm.close()
                    return@withContext emptyList<BofCommentUI>()
                }
                comments.map { entry ->
                    val commentsDetail = realm.query(
                        clazz = BofCommentDetailEntity::class,
                        query = "user == $0 AND date == $1",
                        entry.user, currentDate
                    ).find()
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
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getBofttEntryLatest(): List<BofEntryUI> {
        return withContext(Dispatchers.IO) {
            try {
                val currentTime = System.currentTimeMillis()
                val compareTime = currentTime - 24 * 60 * 60 * 1000
                getBofttEntryByTime(currentTime, compareTime)
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching latest entry: ${e.message}")
                emptyList()
            }
        }
    }

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
}