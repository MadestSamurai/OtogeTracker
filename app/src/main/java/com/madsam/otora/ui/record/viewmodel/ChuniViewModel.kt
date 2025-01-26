package com.madsam.otora.ui.record.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.model.chuni.net.ChuniCard
import com.madsam.otora.service.ChuniDataRequestService
import com.madsam.otora.utils.JsonUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.viewmodel.ChuniViewModel
 * 创建者: MadSamurai
 * 创建时间: 2024/12/14
 * 描述: Chunithm视图模型
 */
class ChuniViewModel : ViewModel() {
    fun requestChuniSongData(context: Context, onComplete: () -> Unit) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getChuniSongsData()
        onComplete()
    }

    fun requestChuniUserData(context: Context, onComplete: () -> Unit) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getUserData()
        onComplete()
    }

    fun getChuniCardFromShare(context: Context): ChuniCard {
        val json = JsonUtil.readJsonFromFile(context, "chuniCard.json")
        if (json.isNullOrEmpty()) {
            println("JSON is empty or null")
            return ChuniCard()
        }
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniCard::class.java).fromJson(json) ?: ChuniCard()
    }
}

class ChuniViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChuniViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ChuniViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}