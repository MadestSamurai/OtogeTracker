package com.madsam.otora.data.bof.remote.api

import android.content.Context
import android.util.Log
import com.madsam.otora.data.bof.local.model.BofCommentDetailEntity
import com.madsam.otora.data.bof.local.model.BofCommentEntity
import com.madsam.otora.data.bof.local.model.BofTeamEntity
import com.madsam.otora.data.bof.local.model.BofTeamPointEntity
import com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.ShareUtil
import com.madsam.otora.data.BASE_URL
import com.madsam.otora.data.bof.remote.model.BofRangeDTO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
import java.time.LocalDate
import java.util.concurrent.Executors

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
    
    private val bofObjectBoxService = BofObjectBoxService()

    private suspend fun requestBofTeamData(date: String) {
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

        try {
            val teamsToSave = mutableListOf<BofTeamEntity>()
            val teamPointsToSave = mutableListOf<BofTeamPointEntity>()
            
            bofTeamList.forEach { team ->
                val entity = BofTeamEntity(
                    teamId = "${date}_${team.team}",
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
                teamsToSave.add(entity)
                
                team.total.forEach { point ->
                    val timeInMillis = CommonUtils.ymdToMillis(date, point.time)
                    val pointEntity = BofTeamPointEntity(
                        pointId = "${timeInMillis}_${team.team}",
                        time = timeInMillis,
                        team = team.team,
                        total = point.value,
                        median = team.median.find { it.time == point.time }?.value
                            ?: team.median.lastOrNull { it.time < point.time }?.value ?: "",
                        impr = team.impr.find { it.time == point.time }?.value
                            ?: team.impr.lastOrNull { it.time < point.time }?.value ?: 0,
                        total1 = team.total1.find { it.time == point.time }?.value
                            ?: team.total1.lastOrNull { it.time < point.time }?.value ?: "",
                        median1 = team.median1.find { it.time == point.time }?.value
                            ?: team.median1.lastOrNull { it.time < point.time }?.value ?: "",
                        total2 = team.total2.find { it.time == point.time }?.value
                            ?: team.total2.lastOrNull { it.time < point.time }?.value ?: "",
                        median2 = team.median2.find { it.time == point.time }?.value
                            ?: team.median2.lastOrNull { it.time < point.time }?.value ?: "",
                        total3 = team.total3.find { it.time == point.time }?.value
                            ?: team.total3.lastOrNull { it.time < point.time }?.value ?: "",
                        median3 = team.median3.find { it.time == point.time }?.value
                            ?: team.median3.lastOrNull { it.time < point.time }?.value ?: "",
                        total4 = team.total4.find { it.time == point.time }?.value
                            ?: team.total4.lastOrNull { it.time < point.time }?.value ?: "",
                        median4 = team.median4.find { it.time == point.time }?.value
                            ?: team.median4.lastOrNull { it.time < point.time }?.value ?: ""
                    )
                    teamPointsToSave.add(pointEntity)
                }
            }
            
            // 保存到 ObjectBox
            bofObjectBoxService.saveBofTeamData(teamsToSave)
            bofObjectBoxService.saveBofTeamPointData(teamPointsToSave)
            
        } catch (e: IOException) {
            Log.e(TAG, "IOException while saving BOF team data: ${e.message}", e)
        }
    }

    private suspend fun requestBofCommentData(date: String) {
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

        try {
            val commentsToSave = mutableListOf<BofCommentEntity>()
            val detailsToSave = mutableListOf<BofCommentDetailEntity>()
            
            bofCommentList.forEach { comment ->
                val entity = BofCommentEntity(
                    commentId = "${date}_${comment.user}${if (comment.pattern != null) "_${comment.pattern}" else ""}",
                    date = date,
                    user = comment.user,
                    pattern = if (comment.pattern != null) comment.pattern.toString() else "",
                    country = comment.country,
                    vote = comment.vote,
                    voteTotal = comment.voteTotal,
                    voteAve = comment.voteAve,
                    short = comment.short,
                    shortTotal = comment.shortTotal,
                    shortAve = comment.shortAve,
                    shortComment = comment.shortComment,
                    long = comment.long,
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
            
            // 保存到 ObjectBox
            bofObjectBoxService.saveBofCommentData(commentsToSave)
            bofObjectBoxService.saveBofCommentDetailData(detailsToSave)
            
        } catch (e: IOException) {
            Log.e(TAG, "IOException while saving BOF comment data: ${e.message}", e)
        }
    }

    private val processedTeamDates = mutableSetOf<String>()

    private suspend fun getBofRangeData(): List<BofRangeDTO>? {
        // 首先检查数据库中是否有数据，以及是否需要更新
        val shouldUpdate = bofObjectBoxService.shouldUpdateRangeData()
        
        if (!shouldUpdate) {
            // 如果不需要更新，直接从数据库获取
            val cachedData = bofObjectBoxService.getBofRangeData()
            if (cachedData.isNotEmpty()) {
                Log.d(TAG, "Using cached range data from database")
                return cachedData
            }
        }
        
        // 从网络获取最新数据
        val rangeCall = api.getBofRangeData()
        val response = try {
            rangeCall.execute()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get range data from network: ${e.message}")
            // 网络失败时，尝试返回数据库中的旧数据
            val cachedData = bofObjectBoxService.getBofRangeData()
            return if (cachedData.isNotEmpty()) {
                Log.d(TAG, "Using fallback cached range data from database")
                cachedData
            } else {
                null
            }
        }
        
        if (!response.isSuccessful) {
            Log.e(TAG, "Range data response is not successful: code=${response.code()}, message=${response.message()}")
            // 网络失败时，尝试返回数据库中的旧数据
            val cachedData = bofObjectBoxService.getBofRangeData()
            return if (cachedData.isNotEmpty()) {
                Log.d(TAG, "Using fallback cached range data from database")
                cachedData
            } else {
                null
            }
        }
        
        val rangeData = response.body()
        if (rangeData == null) {
            Log.e(TAG, "Range data response body is null")
            // 网络失败时，尝试返回数据库中的旧数据
            val cachedData = bofObjectBoxService.getBofRangeData()
            return if (cachedData.isNotEmpty()) {
                Log.d(TAG, "Using fallback cached range data from database")
                cachedData
            } else {
                null
            }
        }
        
        // 保存到数据库
        bofObjectBoxService.saveBofRangeData(rangeData)
        Log.d(TAG, "Saved fresh range data to database")
        return rangeData
    }

    fun requestBofTeamData(dateTime: LocalDate, competitionType: String = "tt", onComplete: () -> Unit) {
        serviceScope.launch(dispatcher) {
            // 获取范围数据
            val rangeData = getBofRangeData()
            val competitionRange = rangeData?.find { it.path == competitionType }
            
            if (competitionRange == null) {
                Log.w(TAG, "No '$competitionType' range found in range data, using fallback date")
                // 如果没有获取到范围数据，使用默认值
                requestBofTeamDataWithRange(dateTime, LocalDate.parse("2024-10-16"), onComplete)
                return@launch
            }
            
            // 检查比赛是否已开始
            if (!competitionRange.isStart) {
                Log.i(TAG, "BOF:${competitionType.uppercase()} has not started yet, skipping data request")
                onComplete()
                return@launch
            }
            
            val startDate = try {
                LocalDate.parse(competitionRange.start)
            } catch (_: Exception) {
                Log.e(TAG, "Failed to parse start date: ${competitionRange.start}, using fallback")
                LocalDate.parse("2024-10-16")
            }
            
            val endDate = try {
                LocalDate.parse(competitionRange.current)
            } catch (_: Exception) {
                Log.e(TAG, "Failed to parse end date: ${competitionRange.current}, using current date")
                dateTime
            }
            
            // 使用范围内的结束日期，而不是传入的日期
            val actualEndDate = if (dateTime.isAfter(endDate)) endDate else dateTime
            
            Log.d(TAG, "Using team date range: start=${startDate}, end=${actualEndDate}")
            requestBofTeamDataWithRange(actualEndDate, startDate, onComplete)
        }
    }
    
    private fun requestBofTeamDataWithRange(dateTime: LocalDate, startDate: LocalDate, onComplete: () -> Unit) {
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
                        requestBofTeamData(dateToRequest)
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

    fun requestBofCommentData(dateTime: LocalDate, competitionType: String = "tt", onComplete: () -> Unit) {
        serviceScope.launch(dispatcher) {
            // 获取范围数据并检查比赛状态
            val rangeData = getBofRangeData()
            val competitionRange = rangeData?.find { it.path == competitionType }
            
            if (competitionRange == null) {
                Log.w(TAG, "No '$competitionType' range found in range data, proceeding with fallback")
                requestBofCommentData("2025-01-08") //TODO: 2025-01-08
                onComplete()
                return@launch
            }
            
            // 检查比赛是否已开始
            if (!competitionRange.isStart) {
                Log.i(TAG, "BOF:${competitionType.uppercase()} has not started yet, skipping comment data request")
                onComplete()
                return@launch
            }
            
            requestBofCommentData("2025-01-08") //TODO: 2025-01-08
            onComplete()
        }
    }
    
    // 向后兼容的便利函数
    @Deprecated("Use requestBofTeamData with competitionType parameter", ReplaceWith("requestBofTeamData(dateTime, \"tt\", onComplete)"))
    fun requestBofttTeamData(dateTime: LocalDate, onComplete: () -> Unit) {
        requestBofTeamData(dateTime, "tt", onComplete)
    }
    
    @Deprecated("Use requestBofCommentData with competitionType parameter", ReplaceWith("requestBofCommentData(dateTime, \"tt\", onComplete)"))
    fun requestBofttCommentData(dateTime: LocalDate, onComplete: () -> Unit) {
        requestBofCommentData(dateTime, "tt", onComplete)
    }
    
    // 公共方法获取 range 数据
    suspend fun getBofRangeDataPublic(): List<BofRangeDTO>? {
        return getBofRangeData()
    }
}
