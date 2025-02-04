package com.madsam.otora.ui.record.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.model.chuni.net.ChuniCard
import com.madsam.otora.model.chuni.net.ChuniPenguin
import com.madsam.otora.service.ChuniDataRequestService
import com.madsam.otora.utils.JsonUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.viewmodel.ChuniViewModel
 * 创建者: MadSamurai
 * 创建时间: 2024/12/14
 * 描述: Chunithm视图模型
 */
class ChuniViewModel(
    context: Context
) : ViewModel() {
    val chuniCard = MutableStateFlow(ChuniCard())
    val chuniAvatar = MutableStateFlow(ChuniPenguin())

    init {
        requiredChuniData(context)
    }

    private fun requiredChuniData(context: Context) {
        getChuniCardFromShare(context)
        getChuniAvatarFromShare(context)
    }

    fun requestChuniSongData(context: Context) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getChuniSongsData()
    }

    fun requestChuniUserData(context: Context) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getUserData()
        getChuniCardFromShare(context)
    }

    private fun getChuniCardFromShare(context: Context) {
        val json = JsonUtil.readJsonFromFile(context, "chuniCard.json")
        if (json.isNullOrEmpty()) return
        chuniCard.update { Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniCard::class.java).fromJson(json) ?: ChuniCard()
        }
    }

    private fun getChuniAvatarFromShare(context: Context) {
        val json = JsonUtil.readJsonFromFile(context, "chuniPenguin.json")
        if (json.isNullOrEmpty()) return
        chuniAvatar.update { Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniPenguin::class.java).fromJson(json) ?: ChuniPenguin()
        }
    }
}

class ChuniViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChuniViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ChuniViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}