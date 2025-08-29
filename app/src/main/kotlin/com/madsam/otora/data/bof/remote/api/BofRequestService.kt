package com.madsam.otora.data.bof.remote.api

import android.util.Log
import com.madsam.otora.data.bof.local.model.BofCommentDetailEntity
import com.madsam.otora.data.bof.local.model.BofCommentEntity
import com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService
import com.madsam.otora.data.BASE_URL
import com.madsam.otora.data.bof.remote.model.BofRangeDTO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.time.LocalDate
import java.util.concurrent.Executors

class BofRequestService() {
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

    private val bofObjectBoxService = BofObjectBoxService()

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
    @Deprecated("Use requestBofCommentData with competitionType parameter", ReplaceWith("requestBofCommentData(dateTime, \"tt\", onComplete)"))
    fun requestBofttCommentData(dateTime: LocalDate, onComplete: () -> Unit) {
        requestBofCommentData(dateTime, "tt", onComplete)
    }
    
    // 公共方法获取 range 数据
    suspend fun getBofRangeDataPublic(): List<BofRangeDTO>? {
        return getBofRangeData()
    }
}