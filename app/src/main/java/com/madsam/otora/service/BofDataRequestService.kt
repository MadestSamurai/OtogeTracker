package com.madsam.otora.service

import android.content.Context
import android.util.Log
import com.madsam.otora.entity.BofEntryEntity
import com.madsam.otora.entity.BofPointEntity
import com.madsam.otora.entity.BofTeamEntity
import com.madsam.otora.entity.BofTeamPointEntity
import com.madsam.otora.model.bof.ui.BofEntryShow
import com.madsam.otora.model.bof.ui.BofTeamShow
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ShareUtil
import com.madsam.otora.web.Api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.net.SocketTimeoutException
import java.time.LocalDate
import java.util.concurrent.Executors
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
    private val serviceScope = CoroutineScope(Dispatchers.IO)
    private val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
    private val semaphore = Semaphore(4)

    private val realmConfig = RealmConfiguration.Builder(
        schema = setOf(
            BofEntryEntity::class,
            BofPointEntity::class,
            BofTeamEntity::class,
            BofTeamPointEntity::class
        )
    )
        .name("otoge-tracker-bof.realm")
        .schemaVersion(1)
        .build()

    // Request BOF data from the server
    private suspend fun requestBofttEntryData(date: String) {
        println("Requesting data for $date")
        val bofCall = api.getBofttData(date)
        val response = try {
            bofCall.execute()
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, "Exception: ${e.message}")
            return
        }

        if (!response.isSuccessful) {
            Log.e(TAG, "Response is not successful")
            return
        }

        val bofEntryList = response.body()
        if (bofEntryList == null) {
            Log.e(TAG, "Response body is null")
            return
        }

        val realm = Realm.open(realmConfig)
        try {
            realm.write {
                bofEntryList.forEach { entry ->
                    val entity = BofEntryEntity().apply {
                        id = "${date}_${entry.no}"
                        no = entry.no
                        team = entry.team
                        this.date = date
                        artist = entry.artist
                        genre = entry.genre
                        title = entry.title
                        regist = entry.regist
                        update = entry.update
                    }
                    this.copyToRealm(entity)
                    entry.total.forEach { point ->
                        val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
                        val pointEntity = BofPointEntity().apply {
                            id = "${timeInMillis}_${entry.no}"
                            no = entry.no
                            time = timeInMillis
                            total = point.value
                            impr = entry.impr.find { it.time == point.time }?.value
                                ?: entry.impr.lastOrNull { it.time < point.time }?.value ?: 0
                            median = entry.median.find { it.time == point.time }?.value
                                ?: entry.median.lastOrNull { it.time < point.time }?.value ?: 0.0
                            avg = entry.avg.find { it.time == point.time }?.value
                                ?: entry.avg.lastOrNull { it.time < point.time }?.value ?: 0.0
                        }
                        this.copyToRealm(pointEntity)
                    }
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        } finally {
            realm.close()
        }
    }

    private suspend fun requestBofttTeamData(date: String) {
        val bofTeamCall = api.getBofttTeamData(date)
        val response = bofTeamCall.execute()
        if (!response.isSuccessful) {
            Log.e(TAG, "Response is not successful")
            return
        }

        val bofTeamList = response.body()
        if (bofTeamList == null) {
            Log.e(TAG, "Response body is null")
            return
        }

        val realm = Realm.open(realmConfig)
        try {
            realm.write {
                bofTeamList.forEach { team ->
                    val entity = BofTeamEntity().apply {
                        this.id = "${date}_${team.team}"
                        this.date = date
                        this.team = team.team
                        this.title1 = team.title1
                        this.title2 = team.title2
                        this.title3 = team.title3
                        this.title4 = team.title4
                        this.artist1 = team.artist1
                        this.artist2 = team.artist2
                        this.artist3 = team.artist3
                        this.artist4 = team.artist4
                        this.fs1 = team.fs1
                        this.fs2 = team.fs2
                        this.fs3 = team.fs3
                        this.fs4 = team.fs4
                    }
                    this.copyToRealm(entity)
                    team.total.forEach { point ->
                        val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
                        val pointEntity = BofTeamPointEntity().apply {
                            id = "${timeInMillis}_${team.team}"
                            time = timeInMillis
                            this.team = team.team
                            total = point.value
                            median = team.median.find { it.time == point.time }?.value
                                ?: team.median.lastOrNull { it.time < point.time }?.value ?: ""
                            impr = team.impr.find { it.time == point.time }?.value
                                ?: team.impr.lastOrNull { it.time < point.time }?.value ?: 0
                            total1 = team.total1.find { it.time == point.time }?.value
                                ?: team.total1.lastOrNull { it.time < point.time }?.value ?: ""
                            median1 = team.median1.find { it.time == point.time }?.value
                                ?: team.median1.lastOrNull { it.time < point.time }?.value ?: ""
                            total2 = team.total2.find { it.time == point.time }?.value
                                ?: team.total2.lastOrNull { it.time < point.time }?.value ?: ""
                            median2 = team.median2.find { it.time == point.time }?.value
                                ?: team.median2.lastOrNull { it.time < point.time }?.value ?: ""
                            total3 = team.total3.find { it.time == point.time }?.value
                                ?: team.total3.lastOrNull { it.time < point.time }?.value ?: ""
                            median3 = team.median3.find { it.time == point.time }?.value
                                ?: team.median3.lastOrNull { it.time < point.time }?.value ?: ""
                            total4 = team.total4.find { it.time == point.time }?.value
                                ?: team.total4.lastOrNull { it.time < point.time }?.value ?: ""
                            median4 = team.median4.find { it.time == point.time }?.value
                                ?: team.median4.lastOrNull { it.time < point.time }?.value ?: ""
                        }
                        this.copyToRealm(pointEntity)
                    }
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        } finally {
            realm.close()
        }
    }

    // Get BOF data from the server
    fun getBofttData(dateTime: LocalDate, onComplete: () -> Unit) {
        val startDate = LocalDate.parse("2024-10-16")
        var currentDate = dateTime
        while (currentDate.isAfter(startDate)) {
            val dateToRequest = currentDate.toString()
            if (!ShareUtil.findStringArray("dates", dateToRequest, context)) {
                serviceScope.launch(dispatcher) {
                    semaphore.withPermit {
                        requestBofttEntryData(dateToRequest)
                        if (currentDate.isBefore(dateTime)) {
                            ShareUtil.insertStringArray("dates", dateToRequest, context)
                        }
                        onComplete()
                    }
                }
            }
            currentDate = currentDate.minusDays(1)
        }
    }

    fun getBofttTeamData(dateTime: LocalDate, onComplete: () -> Unit) {
        val startDate = LocalDate.parse("2024-10-16")
        var currentDate = dateTime
        while (currentDate.isAfter(startDate)) {
            val dateToRequest = currentDate.toString()
            if (!ShareUtil.findStringArray("datesTeam", dateToRequest, context)) {
                serviceScope.launch(dispatcher) {
                    semaphore.withPermit {
                        requestBofttTeamData(dateToRequest)
                        if (currentDate.isBefore(dateTime)) {
                            ShareUtil.insertStringArray("datesTeam", dateToRequest, context)
                        }
                        onComplete()
                    }
                }
            }
            currentDate = currentDate.minusDays(1)
        }
    }

    // Get BOF data from the database
    suspend fun getBofttEntryByTime(time: Long): List<BofEntryShow> {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val startTime = time - 48 * 60 * 60 * 1000 // 48 hours in milliseconds
                val oldTimeLimit = time - 24 * 60 * 60 * 1000 // 24 hours in milliseconds

                // Fetch points within the time range
                val points = realm.query<BofPointEntity>(
                    clazz = BofPointEntity::class,
                    query = "time >= $0 AND time <= $1",
                    startTime, time
                ).find()

                if (points.isEmpty()) {
                    realm.close()
                    return@withContext emptyList<BofEntryShow>()
                }

                // Fetch entries for the given date
                val date = CommonUtils.millisToYmd(time).substring(0, 10)
                val entries = realm.query<BofEntryEntity>(
                    clazz = BofEntryEntity::class,
                    query = "date == $0",
                    date
                ).find()

                // Create a map of entryId to points for quick access
                val pointsMap = points.groupBy { it.no }

                entries.map { entry ->
                    val entryPoints = pointsMap[entry.no] ?: emptyList()
                    val closestPoint = entryPoints
                        .filter { it.time <= time }
                        .minByOrNull { abs(it.time - time) }
                    val oldClosestPoint = entryPoints
                        .filter { it.time <= oldTimeLimit }
                        .minByOrNull { abs(it.time - oldTimeLimit) }

                    BofEntryShow(
                        oldIndex = 0,
                        index = 0,
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
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching entry by time: ${e.message}")
                emptyList()
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getBofttTeamByTime(time: Long): List<BofTeamShow> {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val startTime = time - 48 * 60 * 60 * 1000 // 48 hours in milliseconds
                val oldTimeLimit = time - 24 * 60 * 60 * 1000 // 24 hours in milliseconds

                // Fetch points within the time range
                val points = realm.query<BofTeamPointEntity>(
                    clazz = BofTeamPointEntity::class,
                    query = "time >= $0 AND time <= $1",
                    startTime, time
                ).find()

                if (points.isEmpty()) {
                    realm.close()
                    return@withContext emptyList<BofTeamShow>()
                }

                // Fetch teams for the given date
                val date = CommonUtils.millisToYmd(time).substring(0, 10)
                val teams = realm.query<BofTeamEntity>(
                    clazz = BofTeamEntity::class,
                    query = "date == $0",
                    date
                ).find()

                // Create a map of teamId to points for quick access
                val pointsMap = points.groupBy { it.team }

                teams.map { team ->
                    val teamPoints = pointsMap[team.team] ?: emptyList()
                    val closestPoint = teamPoints
                        .filter { it.time <= time }
                        .minByOrNull { abs(it.time - time) }
                    val oldClosestPoint = teamPoints
                        .filter { it.time <= oldTimeLimit }
                        .minByOrNull { abs(it.time - oldTimeLimit) }

                    BofTeamShow(
                        oldIndex = 0,
                        index = 0,
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
            } catch (e: Exception) {
                Log.e(TAG, "Error fetching team by time: ${e.message}")
                emptyList()
            } finally {
                realm.close()
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