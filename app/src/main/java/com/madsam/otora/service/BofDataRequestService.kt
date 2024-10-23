package com.madsam.otora.service

import android.content.Context
import android.util.Log
import com.madsam.otora.database.DatabaseProvider
import com.madsam.otora.entity.bof.BofEntryEntity
import com.madsam.otora.entity.bof.BofPointEntity
import com.madsam.otora.entity.bof.BofTeamEntity
import com.madsam.otora.entity.bof.BofTeamPointEntity
import com.madsam.otora.model.bof.BofEntry
import com.madsam.otora.model.bof.BofEntryShow
import com.madsam.otora.model.bof.BofTeam
import com.madsam.otora.model.bof.BofTeamShow
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

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.service.BofDataRequestService
 * 创建者: MadSamurai
 * 创建时间: 2024/10/13
 * 描述: TODO
 */
class BofDataRequestService(private val context: Context) {
    companion object {
        const val TAG = "BofDataRequestService"
        const val LAST_DATE_KEY = "lastDate"
        const val LAST_DATE_KEY_TEAM = "lastDateTeam"
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
                        val entity = BofTeamEntity(
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
                        val no = db.bofTeamDao().insertOrUpdate(entity)
                        team.no = no
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

    // Fill in missing data points for the day
    private fun fillMissingDataPoints(entry: BofEntry, date: String) {
        val startTime = CommonUtils.ymdToMillis(date, "00:00:00")
        val endTime = CommonUtils.ymdToMillis(date, "23:55:00")
        val interval = 5 * 60 * 1000 // 5 minutes in milliseconds

        val filledImpr = mutableListOf<BofEntry.PointInt>()
        val filledTotal = mutableListOf<BofEntry.PointInt>()
        val filledMedian = mutableListOf<BofEntry.PointDouble>()
        val filledAvg = mutableListOf<BofEntry.PointDouble>()

        var currentTime = startTime
        val now = System.currentTimeMillis()

        while (currentTime <= endTime) {
            // Stop filling if the current time exceeds the current system time and the date is today
            if (date == LocalDate.now().toString() && currentTime > now) {
                break
            }

            val timeString = CommonUtils.millisToYmd(currentTime).substring(11, 16) // Extract HH:mm

            val impr = entry.impr.find { it.time.startsWith(timeString) } ?: entry.impr.lastOrNull { it.time < timeString }
            val total = entry.total.find { it.time.startsWith(timeString) } ?: entry.total.lastOrNull { it.time < timeString }
            val median = entry.median.find { it.time.startsWith(timeString) } ?: entry.median.lastOrNull { it.time < timeString }
            val avg = entry.avg.find { it.time.startsWith(timeString) } ?: entry.avg.lastOrNull { it.time < timeString }

            impr?.let { filledImpr.add(it.copy(time = timeString)) }
            total?.let { filledTotal.add(it.copy(time = timeString)) }
            median?.let { filledMedian.add(it.copy(time = timeString)) }
            avg?.let { filledAvg.add(it.copy(time = timeString)) }

            currentTime += interval
        }
        entry.impr = filledImpr
        entry.total = filledTotal
        entry.median = filledMedian
        entry.avg = filledAvg
    }
    private fun fillMissingDataPoints(entry: BofTeam, date: String) {
        val startTime = CommonUtils.ymdToMillis(date, "00:00:00")
        val endTime = CommonUtils.ymdToMillis(date, "23:55:00")
        val interval = 5 * 60 * 1000 // 5 minutes in milliseconds

        val filledTotal = mutableListOf<BofTeam.PointDouble>()
        val filledMedian = mutableListOf<BofTeam.PointString>()
        val filledImpr = mutableListOf<BofTeam.PointInt>()
        val filledTotal1 = mutableListOf<BofTeam.PointString>()
        val filledMedian1 = mutableListOf<BofTeam.PointString>()
        val filledTotal2 = mutableListOf<BofTeam.PointString>()
        val filledMedian2 = mutableListOf<BofTeam.PointString>()
        val filledTotal3 = mutableListOf<BofTeam.PointString>()
        val filledMedian3 = mutableListOf<BofTeam.PointString>()
        val filledTotal4 = mutableListOf<BofTeam.PointString>()
        val filledMedian4 = mutableListOf<BofTeam.PointString>()

        var currentTime = startTime
        val now = System.currentTimeMillis()

        while (currentTime <= endTime) {
            // Stop filling if the current time exceeds the current system time and the date is today
            if (date == LocalDate.now().toString() && currentTime > now) {
                break
            }

            val timeString = CommonUtils.millisToYmd(currentTime).substring(11, 16) // Extract HH:mm

            val total = entry.total.find { it.time.startsWith(timeString) }
                ?: entry.total.lastOrNull { it.time < timeString }
            val median = entry.median.find { it.time.startsWith(timeString) }
                ?: entry.median.lastOrNull { it.time < timeString }
            val impr = entry.impr.find { it.time.startsWith(timeString) }
                ?: entry.impr.lastOrNull { it.time < timeString }
            val total1 = entry.total1.find { it.time.startsWith(timeString) }
                ?: entry.total1.lastOrNull { it.time < timeString }
            val median1 = entry.median1.find { it.time.startsWith(timeString) }
                ?: entry.median1.lastOrNull { it.time < timeString }
            val total2 = entry.total2.find { it.time.startsWith(timeString) }
                ?: entry.total2.lastOrNull { it.time < timeString }
            val median2 = entry.median2.find { it.time.startsWith(timeString) }
                ?: entry.median2.lastOrNull { it.time < timeString }
            val total3 = entry.total3.find { it.time.startsWith(timeString) }
                ?: entry.total3.lastOrNull { it.time < timeString }
            val median3 = entry.median3.find { it.time.startsWith(timeString) }
                ?: entry.median3.lastOrNull { it.time < timeString }
            val total4 = entry.total4.find { it.time.startsWith(timeString) }
                ?: entry.total4.lastOrNull { it.time < timeString }
            val median4 = entry.median4.find { it.time.startsWith(timeString) }
                ?: entry.median4.lastOrNull { it.time < timeString }

            total?.let { filledTotal.add(it.copy(time = timeString)) }
            median?.let { filledMedian.add(median.copy(time = timeString)) }
            impr?.let { filledImpr.add(impr.copy(time = timeString)) }
            total1?.let { filledTotal1.add(total1.copy(time = timeString)) }
            median1?.let { filledMedian1.add(median1.copy(time = timeString)) }
            total2?.let { filledTotal2.add(total2.copy(time = timeString)) }
            median2?.let { filledMedian2.add(median2.copy(time = timeString)) }
            total3?.let { filledTotal3.add(total3.copy(time = timeString)) }
            median3?.let { filledMedian3.add(median3.copy(time = timeString)) }
            total4?.let { filledTotal4.add(total4.copy(time = timeString)) }
            median4?.let { filledMedian4.add(median4.copy(time = timeString)) }

            currentTime += interval
        }
        entry.total = filledTotal
        entry.median = filledMedian
        entry.impr = filledImpr
        entry.total1 = filledTotal1
        entry.median1 = filledMedian1
        entry.total2 = filledTotal2
        entry.median2 = filledMedian2
        entry.total3 = filledTotal3
        entry.median3 = filledMedian3
        entry.total4 = filledTotal4
        entry.median4 = filledMedian4
    }

    // Store data points in the database
    private fun storePoints(entry: BofEntry, date: String) {
        fillMissingDataPoints(entry, date)
        var isLastEntryOfDay = false

        val pointsToInsert = mutableListOf<BofPointEntity>()

        entry.impr.forEach { point ->
            val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
            val startInMillis = CommonUtils.ymdToMillis("2024-10-13", "00:00:00")

            val pointEntity = BofPointEntity(
                timeAndEntry = ((timeInMillis - startInMillis)/10).toInt() + entry.no,
                impr = point.value,
                total = entry.total.find { it.time == point.time }?.value ?: 0,
                median = entry.median.find { it.time == point.time }?.value ?: 0.0,
                avg = entry.avg.find { it.time == point.time }?.value ?: 0.0,
            )
            pointsToInsert.add(pointEntity)
            if (point.time.startsWith("23:55")) {
                isLastEntryOfDay = true
            }
        }
        db.bofPointDao().insertAll(pointsToInsert)

        if (isLastEntryOfDay) {
            saveLastDate(date)
        }
    }
    private fun storePoints(entry: BofTeam, date: String) {
        fillMissingDataPoints(entry, date)
        var isLastEntryOfDay = false

        val pointsToInsert = mutableListOf<BofTeamPointEntity>()

        entry.total.forEach { point ->
            val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
            val startInMillis = CommonUtils.ymdToMillis("2024-10-13", "00:00:00")

            val pointEntity = BofTeamPointEntity(
                timeAndEntry = ((timeInMillis - startInMillis)/10).toInt() + entry.no,
                total = point.value,
                median = entry.median.find { it.time == point.time }?.value ?: "",
                impr = entry.impr.find { it.time == point.time }?.value ?: 0,
                total1 = entry.total1.find { it.time == point.time }?.value ?: "",
                median1 = entry.median1.find { it.time == point.time }?.value ?: "",
                total2 = entry.total2.find { it.time == point.time }?.value ?: "",
                median2 = entry.median2.find { it.time == point.time }?.value ?: "",
                total3 = entry.total3.find { it.time == point.time }?.value ?: "",
                median3 = entry.median3.find { it.time == point.time }?.value ?: "",
                total4 = entry.total4.find { it.time == point.time }?.value ?: "",
                median4 = entry.median4.find { it.time == point.time }?.value ?: ""
            )
            pointsToInsert.add(pointEntity)
            if (point.time.startsWith("23:55")) {
                isLastEntryOfDay = true
            }
        }
        db.bofTeamPointDao().insertAll(pointsToInsert)

        if (isLastEntryOfDay) {
            saveLastDate(date)
        }
    }

    // Save the last date that data was fetched
    private fun saveLastDate(date: String) {
        ShareUtil.putString(LAST_DATE_KEY, date, context)
    }
    private fun saveLastDateTeam(date: String) {
        ShareUtil.putString(LAST_DATE_KEY_TEAM, date, context)
    }

    // Get the last date that data was fetched
    private fun getLastDate(): String? {
        return ShareUtil.getString(LAST_DATE_KEY, context)
    }
    private fun getLastDateTeam(): String? {
        return ShareUtil.getString(LAST_DATE_KEY_TEAM, context)
    }

    // Get BOF data from the server
    fun getBofttData(dateTime: LocalDate) {
        serviceScope.launch {
            requestBofttEntryData(dateTime.toString())

            val yesterday = dateTime.minusDays(1)
            val lastDate = getLastDate()
            if (lastDate == null || LocalDate.parse(lastDate).isBefore(yesterday)) {
                requestBofttEntryData(yesterday.toString())
            }

            var currentDate = lastDate?.let { LocalDate.parse(it) } ?: LocalDate.parse("2024-10-13")

            while (!currentDate.isAfter(yesterday)) {
                requestBofttEntryData(currentDate.toString())
                currentDate = currentDate.plusDays(1)
            }
        }
    }
    fun getBofttTeamData(dateTime: LocalDate) {
        serviceScope.launch {
            requestBofttTeamData(dateTime.toString())

            val yesterday = dateTime.minusDays(1)
            val lastDate = getLastDateTeam()
            if (lastDate == null || LocalDate.parse(lastDate).isBefore(yesterday)) {
                requestBofttTeamData(yesterday.toString())
            }

            var currentDate = lastDate?.let { LocalDate.parse(it) } ?: LocalDate.parse("2024-10-13")

            while (!currentDate.isAfter(yesterday)) {
                requestBofttTeamData(currentDate.toString())
                currentDate = currentDate.plusDays(1)
            }
        }
    }

    // Get BOF data from the database
    suspend fun getBofttEntryByTime(time: Int): List<BofEntryShow> {
        return withContext(Dispatchers.IO) {
            try {
                val points = db.bofPointDao().getPointsByRange(time.toInt(), (time + 999).toInt())
                if (points.isNotEmpty()) {
                    val entryIds = points.map { it.timeAndEntry % 10000 }
                    val entries = db.bofEntryDao().getEntriesByIds(entryIds)

                    // Calculate the previous day's id based on the provided time
                    val startInMillis = CommonUtils.ymdToMillis("2024-10-13", "00:00:00")
                    val providedTimeMillis = startInMillis + time * 10
                    val previousDayMillis = providedTimeMillis - 24 * 60 * 60 * 1000
                    val previousDayId = ((previousDayMillis - startInMillis) / 10).toInt()
                    val previousDayPoints = db.bofPointDao().getPointsByRange(previousDayId, previousDayId + 999)

                    entries.map { entry ->
                        val point = points.find { it.timeAndEntry % 10000 == entry.no }
                        val previousDayPoint = previousDayPoints.find { it.timeAndEntry % 10000 == entry.no }
                        BofEntryShow(
                            no = entry.no,
                            team = entry.team,
                            artist = entry.artist,
                            genre = entry.genre,
                            title = entry.title,
                            regist = entry.regist,
                            update = entry.update,
                            impr = point?.impr ?: 0,
                            total = point?.total ?: 0,
                            median = point?.median ?: 0.0,
                            avg = point?.avg ?: 0.0,
                            oldImpr = previousDayPoint?.impr ?: 0,
                            oldTotal = previousDayPoint?.total ?: 0,
                            oldMedian = previousDayPoint?.median ?: 0.0,
                            oldAvg = previousDayPoint?.avg ?: 0.0,
                            time = CommonUtils.millisToYmd(providedTimeMillis).substring(11, 16)
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
    suspend fun getBofttTeamByTime(time: Int): List<BofTeamShow> {
        return withContext(Dispatchers.IO) {
            try {
                val points =
                    db.bofTeamPointDao().getPointsByRange(time.toInt(), (time + 999).toInt())
                if (points.isNotEmpty()) {
                    val teamIds = points.map { it.timeAndEntry % 10000 }
                    val teams = db.bofTeamDao().getTeamsByIds(teamIds)

                    // Calculate the previous day's id based on the provided time
                    val startInMillis = CommonUtils.ymdToMillis("2024-10-13", "00:00:00")
                    val providedTimeMillis = startInMillis + time * 10
                    val previousDayMillis = providedTimeMillis - 24 * 60 * 60 * 1000
                    val previousDayId = ((previousDayMillis - startInMillis) / 10).toInt()
                    val previousDayPoints =
                        db.bofTeamPointDao().getPointsByRange(previousDayId, previousDayId + 999)

                    teams.map { team ->
                        val point = points.find { it.timeAndEntry % 10000 == team.no }
                        val previousDayPoint =
                            previousDayPoints.find { it.timeAndEntry % 10000 == team.no }
                        BofTeamShow(
                            no = team.no,
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
                            total = point?.total ?: 0.0,
                            median = point?.median ?: "",
                            impr = point?.impr ?: 0,
                            total1 = point?.total1 ?: "",
                            median1 = point?.median1 ?: "",
                            total2 = point?.total2 ?: "",
                            median2 = point?.median2 ?: "",
                            total3 = point?.total3 ?: "",
                            median3 = point?.median3 ?: "",
                            total4 = point?.total4 ?: "",
                            median4 = point?.median4 ?: "",
                            oldTotal = previousDayPoint?.total ?: 0.0,
                            oldMedian = previousDayPoint?.median ?: "",
                            oldImpr = previousDayPoint?.impr ?: 0,
                            time = CommonUtils.millisToYmd(providedTimeMillis).substring(11, 16)
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
                val maxId = db.bofPointDao().getMaxId()
                val time = maxId / 10000 * 10000
                getBofttEntryByTime(time)
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching latest entry: ${e.message}")
                emptyList()
            }
        }
    }
    suspend fun getBofttTeamLatest(): List<BofTeamShow> {
        return withContext(Dispatchers.IO) {
            try {
                val maxId = db.bofTeamPointDao().getMaxId()
                val time = maxId / 10000 * 10000
                getBofttTeamByTime(time)
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching latest team: ${e.message}")
                emptyList()
            }
        }
    }
}