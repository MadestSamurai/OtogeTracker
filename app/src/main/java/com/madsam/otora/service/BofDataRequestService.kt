package com.madsam.otora.service

import android.content.Context
import android.util.Log
import com.madsam.otora.database.DatabaseProvider
import com.madsam.otora.entity.bof.BofEntryEntity
import com.madsam.otora.entity.bof.BofPointEntity
import com.madsam.otora.entity.bof.BofTeamEntity
import com.madsam.otora.entity.bof.BofTeamPointEntity
import com.madsam.otora.model.bof.web.BofEntry
import com.madsam.otora.model.bof.ui.BofEntryShow
import com.madsam.otora.model.bof.web.BofTeam
import com.madsam.otora.model.bof.ui.BofTeamShow
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ShareUtil
import com.madsam.otora.web.Api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.time.LocalDate
import kotlin.math.abs

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.service.BofDataRequestService
 * 创建者: MadSamurai
 * 创建时间: 2024/10/13
 * 描述: BOF数据请求服务
 */
class BofDataRequestService(private val context: Context) {
    companion object {
        const val TAG = "BofDataRequestService"
    }
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://blog.madsam.work/")
        .addConverterFactory(MoshiConverterFactory.create(moshi)) // Moshi
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // RxJava
        .build()

    private val api = retrofit.create(Api::class.java)
    private val db = DatabaseProvider.getDatabase(context)
    private val serviceScope = CoroutineScope(Dispatchers.IO)

    // Request BOF data from the server
    private fun requestBofttEntryData(
        date: String
    ) {
        try {
            val bofCall = api.getBofttData(date)
            val response = bofCall.execute()
            if (response.isSuccessful) {
                val bofEntryList = response.body()
                if (bofEntryList != null) {
                    // Insert data into database
                    bofEntryList.forEach { entry ->
                        val entity = BofEntryEntity(
                            no = entry.no,
                            team = entry.team,
                            artist = entry.artist,
                            genre = entry.genre,
                            title = entry.title,
                            regist = entry.regist,
                            update = entry.update
                        )
                        db.bofEntryDao().insertOrUpdate(entity)
                        storePoints(entry, date)
                    }
                } else Log.e(TAG, "Response body is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        }
    }
    private fun requestBofttTeamData(
        date: String
    ) {
        try {
            val bofTeamCall = api.getBofttTeamData(date)
            val response = bofTeamCall.execute()
            if (response.isSuccessful) {
                val bofTeamList = response.body()
                if (bofTeamList != null) {
                    // Insert data into database
                    bofTeamList.forEach { team ->
                        /** XXX: Bad performance because of hash generation,
                         *  but data is quite small (less than 300 records per day) so it's fine.
                         *  Check if data is already in the database and make id incremental
                         *  is a better solution but I'm too lazy to do that.
                         */
                        val id = CommonUtils.generateHash(team.team)
                        val entity = BofTeamEntity(
                            id = id,
                            date = date,
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
                            fs4 = team.fs4
                        )
                        db.bofTeamDao().insertOrUpdate(entity)
                        team.id = id
                        storePoints(team, date)
                    }
                } else Log.e(TAG, "Response body is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        }
    }

    // Store data points in the database
    private fun storePoints(entry: BofEntry, date: String) {
        val pointsToInsert = mutableListOf<BofPointEntity>()
        entry.total.forEach { point ->
            val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
            val pointEntity = BofPointEntity(
                no = entry.no,
                time = timeInMillis,
                total = point.value,
                impr = entry.impr.find { it.time == point.time }?.value ?: entry.impr.lastOrNull { it.time < point.time }?.value ?: 0,
                median = entry.median.find { it.time == point.time }?.value ?: entry.median.lastOrNull { it.time < point.time }?.value ?: 0.0,
                avg = entry.avg.find { it.time == point.time }?.value ?: entry.avg.lastOrNull { it.time < point.time }?.value ?: 0.0
            )
            pointsToInsert.add(pointEntity)
        }
        db.bofPointDao().insertAll(pointsToInsert)
    }
    private fun storePoints(entry: BofTeam, date: String) {
        val pointsToInsert = mutableListOf<BofTeamPointEntity>()
        entry.total.forEach { point ->
            val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
            val pointEntity = BofTeamPointEntity(
                id = entry.id,
                time = timeInMillis,
                total = point.value,
                median = entry.median.find { it.time == point.time }?.value ?: entry.median.lastOrNull { it.time < point.time }?.value ?: "",
                impr = entry.impr.find { it.time == point.time }?.value ?: entry.impr.lastOrNull { it.time < point.time }?.value ?: 0,
                total1 = entry.total1.find { it.time == point.time }?.value ?: entry.total1.lastOrNull { it.time < point.time }?.value ?: "",
                median1 = entry.median1.find { it.time == point.time }?.value ?: entry.median1.lastOrNull { it.time < point.time }?.value ?: "",
                total2 = entry.total2.find { it.time == point.time }?.value ?: entry.total2.lastOrNull { it.time < point.time }?.value ?: "",
                median2 = entry.median2.find { it.time == point.time }?.value ?: entry.median2.lastOrNull { it.time < point.time }?.value ?: "",
                total3 = entry.total3.find { it.time == point.time }?.value ?: entry.total3.lastOrNull { it.time < point.time }?.value ?: "",
                median3 = entry.median3.find { it.time == point.time }?.value ?: entry.median3.lastOrNull { it.time < point.time }?.value ?: "",
                total4 = entry.total4.find { it.time == point.time }?.value ?: entry.total4.lastOrNull { it.time < point.time }?.value ?: "",
                median4 = entry.median4.find { it.time == point.time }?.value ?: entry.median4.lastOrNull { it.time < point.time }?.value ?: ""
            )
            pointsToInsert.add(pointEntity)
        }
        db.bofTeamPointDao().insertAll(pointsToInsert)
    }

    // Get BOF data from the server
    fun getBofttData(dateTime: LocalDate) {
        serviceScope.launch {
            val startDate = LocalDate.parse("2024-10-16")
            var currentDate = dateTime
            while (currentDate.isAfter(startDate)) {
                if (!ShareUtil.findStringArray("dates", currentDate.toString(), context)) {
                    requestBofttEntryData(currentDate.toString())
                    if (currentDate.isBefore(dateTime))
                        ShareUtil.insertStringArray("dates", currentDate.toString(), context)
                }
                currentDate = currentDate.minusDays(1)
            }
        }
    }
    fun getBofttTeamData(dateTime: LocalDate) {
        serviceScope.launch {
            val endDate = dateTime
            val startDate = LocalDate.parse("2024-10-16")
            var currentDate = endDate
            while (currentDate.isAfter(startDate)) {
                if (!ShareUtil.findStringArray("datesTeam", currentDate.toString(), context)) {
                    requestBofttTeamData(currentDate.toString())
                    if (currentDate.isBefore(dateTime))
                        ShareUtil.insertStringArray("datesTeam", currentDate.toString(), context)
                }
                currentDate = currentDate.minusDays(1)
            }
        }
    }

    // Get BOF data from the database
    suspend fun getBofttEntryByTime(time: Long): List<BofEntryShow> {
        return withContext(Dispatchers.IO) {
            try {
                val startTime = time - 48 * 60 * 60 * 1000 // 48 hours in milliseconds
                val oldTimeLimit = time - 24 * 60 * 60 * 1000 // 24 hours in milliseconds
                val points = db.bofPointDao().getPointsByRange(startTime, time)
                if (points.isNotEmpty()) {
                    val entryIds = points.map { it.no }.distinct()
                    val entries = db.bofEntryDao().getEntriesByIds(entryIds)

                    entries.map { entry ->
                        val entryPoints = points.filter { it.no == entry.no }
                        val closestPoint = entryPoints
                            .filter { it.time <= time }
                            .minByOrNull { abs(it.time - time) }
                        val oldClosestPoint = entryPoints
                            .filter { it.time <= oldTimeLimit }
                            .minByOrNull { abs(it.time - oldTimeLimit) }
                        BofEntryShow(
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
                            oldImpr = oldClosestPoint?.impr ?: 0,
                            oldTotal = oldClosestPoint?.total ?: 0,
                            oldMedian = oldClosestPoint?.median ?: 0.0,
                            oldAvg = oldClosestPoint?.avg ?: 0.0,
                            time = CommonUtils.millisToYmd(time).substring(11, 16)
                        )
                    }
                } else {
                    emptyList()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching entry by time: ${e.message}")
                emptyList()
            }
        }
    }
    suspend fun getBofttTeamByTime(time: Long): List<BofTeamShow> {
        return withContext(Dispatchers.IO) {
            try {
                val startTime = time - 48 * 60 * 60 * 1000 // 48 hours in milliseconds
                val oldTimeLimit = time - 24 * 60 * 60 * 1000 // 24 hours in milliseconds
                val points = db.bofTeamPointDao().getPointsByRange(startTime, time)
                if (points.isNotEmpty()) {
                    val teams = db.bofTeamDao().getTeamsByDate(CommonUtils.millisToYmd(time).substring(0, 10))

                    teams.map { team ->
                        val teamPoints = points.filter { it.id == team.id }
                        val closestPoint = teamPoints
                            .filter { it.time <= time }
                            .minByOrNull { abs(it.time - time) }
                        val oldClosestPoint = teamPoints
                            .filter { it.time <= oldTimeLimit }
                            .minByOrNull { abs(it.time - oldTimeLimit) }
                        BofTeamShow(
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
                            oldImpr = oldClosestPoint?.impr ?: 0,
                            oldTotal = oldClosestPoint?.total ?: 0.0,
                            oldMedian = oldClosestPoint?.median ?: "",
                            time = CommonUtils.millisToYmd(time).substring(11, 16)
                        )
                    }
                } else {
                    emptyList()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching team by time: ${e.message}")
                emptyList()
            }
        }
    }

    // Get BOF data from the database
    suspend fun getBofttEntryLatest(): List<BofEntryShow> {
        return withContext(Dispatchers.IO) {
            try {
                val currentTime = System.currentTimeMillis()
                getBofttEntryByTime(currentTime)
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching latest entry: ${e.message}")
                emptyList()
            }
        }
    }
    suspend fun getBofttTeamLatest(): List<BofTeamShow> {
        return withContext(Dispatchers.IO) {
            try {
                val currentTime = System.currentTimeMillis()
                getBofttTeamByTime(currentTime)
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching latest team: ${e.message}")
                emptyList()
            }
        }
    }
}