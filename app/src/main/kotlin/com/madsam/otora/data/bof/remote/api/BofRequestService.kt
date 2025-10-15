package com.madsam.otora.data.bof.remote.api

import android.util.Log
import com.madsam.otora.data.bof.local.objectbox.BofObjectBoxService
import com.madsam.otora.data.BOF_URL
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class BofRequestService() {
    companion object {
        private const val TAG = "BofRequestService"
    }

    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BOF_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private val api = retrofit.create(BofAPI::class.java)

    private val bofObjectBoxService = BofObjectBoxService()

    private suspend fun getBofRangeData(): List<BofRangeResponse>? {
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

    // 公共方法获取 range 数据
    suspend fun getBofRangeDataPublic(): List<BofRangeResponse>? {
        return getBofRangeData()
    }
}