package com.madsam.otora.data.bof.remote.api

import android.content.Context
import android.util.Log
import com.madsam.otora.data.bof.local.model.BofCommentDetailEntity
import com.madsam.otora.data.bof.local.model.BofCommentEntity
import com.madsam.otora.data.bof.local.model.BofEntryEntity
import com.madsam.otora.data.bof.local.model.BofPointEntity
import com.madsam.otora.data.bof.local.model.BofTeamEntity
import com.madsam.otora.data.bof.local.model.BofTeamPointEntity
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ShareUtil
import com.madsam.otora.data.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.xilinjia.krdb.Realm
import io.github.xilinjia.krdb.RealmConfiguration
import io.github.xilinjia.krdb.UpdatePolicy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.net.SocketTimeoutException
import java.time.LocalDate
import java.util.concurrent.Executors
import kotlin.collections.forEach

class BofRequestService(private val context: Context) {
    companion object {
        private const val TAG = "BofRequestService"
    }

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private val api = retrofit.create(BofAPI::class.java)
    private val serviceScope = CoroutineScope(Dispatchers.IO)
    private val dispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()
    private val semaphore = Semaphore(4)

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

    private suspend fun requestBofttEntryData(date: String, onComplete: () -> Unit) {
        val bofCall = api.getBofttData(date)
        val response = try {
            bofCall.execute()
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, "Socket timeout exception: ${e.message}")
            return
        }

        if (!response.isSuccessful) {
            Log.e(TAG, "Response is not successful: code=${response.code()}, message=${response.message()}, url=${response.raw().request.url}")

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
                    this.copyToRealm(entity, UpdatePolicy.ALL)
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
                        this.copyToRealm(pointEntity, UpdatePolicy.ALL)
                    }
                }
            }
            onComplete()
        } catch (e: IOException) {
            Log.e(TAG, "IOException while saving BOF entry data: ${e.message}", e)
        } finally {
            realm.close()
        }
    }

    private suspend fun requestBofttTeamData(date: String) {
        val bofTeamCall = api.getBofttTeamData(date)
        val response = bofTeamCall.execute()
        if (!response.isSuccessful) {
            Log.e(TAG, "Response is not successful: code=${response.code()}, message=${response.message()}, url=${response.raw().request.url}")
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
                    this.copyToRealm(entity, UpdatePolicy.ALL)
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
                        this.copyToRealm(pointEntity, UpdatePolicy.ALL)
                    }
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException while saving BOF team data: ${e.message}", e)
        } finally {
            realm.close()
        }
    }

    private suspend fun requestBofttCommentData(date: String) {
        val bofCommentCall = api.getBofttComment(date)
        val response = bofCommentCall.execute()
        if (!response.isSuccessful) {
            Log.e(TAG, "Response is not successful: code=${response.code()}, message=${response.message()}, url=${response.raw().request.url}")
            return
        }

        val bofCommentList = response.body()
        if (bofCommentList == null) {
            Log.e(TAG, "Response body is null")
            return
        }

        val realm = Realm.open(realmConfig)
        try {
            realm.write {
                bofCommentList.forEach { comment ->
                    val entity = BofCommentEntity().apply {
                        id = "${date}_${comment.user}${if (comment.pattern != null) "_${comment.pattern}" else ""}"
                        this.date = date
                        user = comment.user
                        pattern = if (comment.pattern != null) comment.pattern.toString() else ""
                        country = comment.country
                        vote = comment.vote
                        voteTotal = comment.voteTotal
                        voteAve = comment.voteAve
                        short = comment.short
                        shortTotal = comment.shortTotal
                        shortAve = comment.shortAve
                        shortComment = comment.shortComment
                        long = comment.long
                        longTotal = comment.longTotal
                        longAve = comment.longAve
                        longComment = comment.longComment
                        total = comment.total
                        totalAve = comment.totalAve
                    }
                    this.copyToRealm(entity, UpdatePolicy.ALL)
                    val details = listOf(comment.voteDetail, comment.shortDetail, comment.longDetail)

                    details.forEach { detailList ->
                        if (detailList.isNotEmpty()) {
                            detailList.forEach { detail ->
                                val detailEntity = BofCommentDetailEntity().apply {
                                    id = "${detail.evalNumber}_${detail.workNumber}"
                                    user = comment.user
                                    score = detail.score
                                    code = detail.evalNumber
                                    country = detail.evalPosition
                                    workNumber = detail.workNumber
                                    this.date = date
                                    type = when (detailList) {
                                        comment.voteDetail -> "vote"
                                        comment.shortDetail -> "short"
                                        else -> "long"
                                    }
                                }
                                this.copyToRealm(detailEntity, UpdatePolicy.ALL)
                            }
                        }
                    }
                }
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException while saving BOF comment data: ${e.message}", e)
        } finally {
            realm.close()
        }
    }

    // 用于跟踪已处理的日期，避免重复存储到 SharedPreferences
    private val processedDates = mutableSetOf<String>()
    private val processedTeamDates = mutableSetOf<String>()
    
    // 缓存范围数据
    private var cachedRangeData: List<com.madsam.otora.data.bof.remote.model.BofRangeDTO>? = null

    private fun getBofRangeData(): List<com.madsam.otora.data.bof.remote.model.BofRangeDTO>? {
        // 如果已有缓存，直接返回
        cachedRangeData?.let { return it }
        
        val rangeCall = api.getBofRangeData()
        val response = try {
            rangeCall.execute()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get range data: ${e.message}")
            return null
        }
        
        if (!response.isSuccessful) {
            Log.e(TAG, "Range data response is not successful: code=${response.code()}, message=${response.message()}")
            return null
        }
        
        val rangeData = response.body()
        if (rangeData == null) {
            Log.e(TAG, "Range data response body is null")
            return null
        }
        
        // 缓存数据
        cachedRangeData = rangeData
        return rangeData
    }

    fun requestBofttData(dateTime: LocalDate, onComplete: () -> Unit) {
        serviceScope.launch(dispatcher) {
            // 获取范围数据
            val rangeData = getBofRangeData()
            val ttRange = rangeData?.find { it.name == "tt" }
            
            if (ttRange == null) {
                Log.w(TAG, "No 'tt' range found in range data, using fallback date")
                // 如果没有获取到范围数据，使用默认值
                requestBofttDataWithRange(dateTime, LocalDate.parse("2024-10-16"), onComplete)
                return@launch
            }
            
            val startDate = try {
                LocalDate.parse(ttRange.start)
            } catch (_: Exception) {
                Log.e(TAG, "Failed to parse start date: ${ttRange.start}, using fallback")
                LocalDate.parse("2024-10-16")
            }
            
            val endDate = try {
                LocalDate.parse(ttRange.end)
            } catch (_: Exception) {
                Log.e(TAG, "Failed to parse end date: ${ttRange.end}, using current date")
                dateTime
            }
            
            // 使用范围内的结束日期，而不是传入的日期
            val actualEndDate = if (dateTime.isAfter(endDate)) endDate else dateTime
            
            Log.d(TAG, "Using date range: start=${startDate}, end=${actualEndDate}")
            requestBofttDataWithRange(actualEndDate, startDate, onComplete)
        }
    }
    
    private fun requestBofttDataWithRange(dateTime: LocalDate, startDate: LocalDate, onComplete: () -> Unit) {
        val datesToRequest = mutableListOf<String>()
        
        // 收集需要请求的日期
        var currentDate = dateTime
        while (currentDate.isAfter(startDate)) {
            val dateToRequest = currentDate.toString()
            if (!ShareUtil.findStringArray("dates", dateToRequest, context) && 
                !processedDates.contains(dateToRequest)) {
                datesToRequest.add(dateToRequest)
            }
            currentDate = currentDate.minusDays(1)
        }
        
        if (datesToRequest.isEmpty()) {
            onComplete()
            return
        }
        
        // 使用计数器跟踪完成状态
        var completedCount = 0
        val totalCount = datesToRequest.size
        
        datesToRequest.forEach { dateToRequest ->
            serviceScope.launch(dispatcher) {
                semaphore.withPermit {
                    try {
                        requestBofttEntryData(dateToRequest) {
                            // 标记为已处理，避免重复请求
                            processedDates.add(dateToRequest)
                            // 异步存储到 SharedPreferences
                            ShareUtil.insertStringArray("dates", dateToRequest, context)
                            
                            // 检查是否所有请求都完成
                            synchronized(this@BofRequestService) {
                                completedCount++
                                if (completedCount == totalCount) {
                                    onComplete()
                                }
                            }
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Failed to request entry data for $dateToRequest: ${e.message}")
                        // 即使失败也要更新计数器
                        synchronized(this@BofRequestService) {
                            completedCount++
                            if (completedCount == totalCount) {
                                onComplete()
                            }
                        }
                    }
                }
            }
        }
    }

    
    fun requestBofttTeamData(dateTime: LocalDate, onComplete: () -> Unit) {
        serviceScope.launch(dispatcher) {
            // 获取范围数据
            val rangeData = getBofRangeData()
            val ttRange = rangeData?.find { it.name == "tt" }
            
            if (ttRange == null) {
                Log.w(TAG, "No 'tt' range found in range data, using fallback date")
                // 如果没有获取到范围数据，使用默认值
                requestBofttTeamDataWithRange(dateTime, LocalDate.parse("2024-10-16"), onComplete)
                return@launch
            }
            
            val startDate = try {
                LocalDate.parse(ttRange.start)
            } catch (_: Exception) {
                Log.e(TAG, "Failed to parse start date: ${ttRange.start}, using fallback")
                LocalDate.parse("2024-10-16")
            }
            
            val endDate = try {
                LocalDate.parse(ttRange.end)
            } catch (_: Exception) {
                Log.e(TAG, "Failed to parse end date: ${ttRange.end}, using current date")
                dateTime
            }
            
            // 使用范围内的结束日期，而不是传入的日期
            val actualEndDate = if (dateTime.isAfter(endDate)) endDate else dateTime
            
            Log.d(TAG, "Using team date range: start=${startDate}, end=${actualEndDate}")
            requestBofttTeamDataWithRange(actualEndDate, startDate, onComplete)
        }
    }
    
    private fun requestBofttTeamDataWithRange(dateTime: LocalDate, startDate: LocalDate, onComplete: () -> Unit) {
        val datesToRequest = mutableListOf<String>()
        
        // 收集需要请求的日期
        var currentDate = dateTime
        while (currentDate.isAfter(startDate)) {
            val dateToRequest = currentDate.toString()
            if (!ShareUtil.findStringArray("datesTeam", dateToRequest, context) && 
                !processedTeamDates.contains(dateToRequest)) {
                datesToRequest.add(dateToRequest)
            }
            currentDate = currentDate.minusDays(1)
        }
        
        if (datesToRequest.isEmpty()) {
            onComplete()
            return
        }
        
        // 使用计数器跟踪完成状态
        var completedCount = 0
        val totalCount = datesToRequest.size
        
        datesToRequest.forEach { dateToRequest ->
            serviceScope.launch(dispatcher) {
                semaphore.withPermit {
                    try {
                        requestBofttTeamData(dateToRequest)
                        // 标记为已处理，避免重复请求
                        processedTeamDates.add(dateToRequest)
                        // 异步存储到 SharedPreferences
                        ShareUtil.insertStringArray("datesTeam", dateToRequest, context)
                    } catch (e: Exception) {
                        Log.e(TAG, "Failed to request team data for $dateToRequest: ${e.message}")
                    }
                    
                    // 检查是否所有请求都完成
                    synchronized(this@BofRequestService) {
                        completedCount++
                        if (completedCount == totalCount) {
                            onComplete()
                        }
                    }
                }
            }
        }
    }

    fun requestBofttCommentData(dateTime: LocalDate, onComplete: () -> Unit) {
        serviceScope.launch(dispatcher) {
            requestBofttCommentData("2025-01-08") //TODO: 2025-01-08
            onComplete()
        }
    }
}