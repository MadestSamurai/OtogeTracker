package com.madsam.otora.service

import android.util.Log
import com.madsam.otora.callback.ICallback
import com.madsam.otora.entity.bof.BofEntry
import com.madsam.otora.web.Api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.service.BofDataRequestService
 * 创建者: MadSamurai
 * 创建时间: 2024/10/13
 * 描述: TODO
 */
class BofDataRequestService {
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

    private fun requestBofttData(
        callback: ICallback<List<BofEntry>>,
        date: String
    ) {
        try {
            val bofCall = api.getBofttData(date)
            val response = bofCall.execute()
            if (response.isSuccessful) {
                val bofEntryList = response.body()
                if (bofEntryList != null) {
                    callback(bofEntryList)
                } else Log.e(TAG, "Response body is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException: ${e.message}")
        }
    }

    fun getBofttData(
        callback: ICallback<List<BofEntry>>
    ) {
        serviceScope.launch { requestBofttData(callback, "2024-10-13") }
    }
}