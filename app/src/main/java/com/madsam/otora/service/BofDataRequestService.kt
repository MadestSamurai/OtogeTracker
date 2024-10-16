package com.madsam.otora.service

import android.content.Context
import android.util.Log
import com.madsam.otora.database.DatabaseProvider
import com.madsam.otora.entity.bof.BofEntryEntity
import com.madsam.otora.entity.bof.BofPointEntity
import com.madsam.otora.model.bof.BofEntry
import com.madsam.otora.model.bof.BofEntryShow
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

    private fun saveLastDate(date: String) {
        ShareUtil.putString(LAST_DATE_KEY, date, context)
    }

    private fun getLastDate(): String? {
        return ShareUtil.getString(LAST_DATE_KEY, context)
    }

    fun getBofttData() {
        serviceScope.launch {
            val today = LocalDate.now()
            requestBofttEntryData(today.toString())

            val yesterday = today.minusDays(1)
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

    suspend fun getBofttEntryByTime(): List<BofEntryShow> {
        return withContext(Dispatchers.IO) {
            try {
                val maxId = db.bofPointDao().getMaxId()
                val time = maxId / 10000 * 10000
                val points = db.bofPointDao().getPointsByRange(time, time + 999)
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
                            oldAvg = previousDayPoint?.avg ?: 0.0
                        )
                    }
                } else {
                    emptyList()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching entry by id: ${e.message}")
                emptyList()
            }
        }
    }
}