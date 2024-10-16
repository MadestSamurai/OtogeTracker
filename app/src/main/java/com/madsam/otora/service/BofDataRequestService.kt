package com.madsam.otora.service

import android.content.Context
import android.util.Log
import com.madsam.otora.database.DatabaseProvider
import com.madsam.otora.entity.bof.BofEntryEntity
import com.madsam.otora.entity.bof.BofPointEntity
import com.madsam.otora.model.bof.BofEntry
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
    private val serviceScope = CoroutineScope(Dispatchers.IO)
    private val db = DatabaseProvider.getDatabase(context)

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
        while (currentTime <= endTime) {
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
            // Check if the time is 23:55
            if (point.time.startsWith("23:55")) {
                isLastEntryOfDay = true
            }
        }
        // Perform batch insert and update
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
            val startDate = getLastDate() ?: "2024-10-13"
            println("startDate: $startDate")
            var currentDate = LocalDate.parse(startDate)
            val endDate = LocalDate.now()

            while (!currentDate.isAfter(endDate)) {
                requestBofttEntryData(currentDate.toString())
                currentDate = currentDate.plusDays(1)
            }
        }
    }

    suspend fun getBofEntriesFromDatabase(): List<BofEntryEntity> {
        return withContext(Dispatchers.IO) {
            DatabaseProvider.getDatabase(context).bofEntryDao().getAll()
        }
    }
}