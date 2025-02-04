package com.madsam.otora.ui.record.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.model.chuni.net.ChuniGenre
import com.madsam.otora.model.chuni.net.ChuniUser
import com.madsam.otora.model.chuni.net.ChuniPenguin
import com.madsam.otora.model.chuni.net.ChuniUserExtend
import com.madsam.otora.model.chuni.ui.ChuniAvatarUI
import com.madsam.otora.model.chuni.ui.ChuniCardUI
import com.madsam.otora.service.ChuniDataRequestService
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.JsonUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
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
    val chuniCardUI = MutableStateFlow(ChuniCardUI())
    val chuniAvatarUI = MutableStateFlow(ChuniAvatarUI())

    val chuniMasterRecord = MutableStateFlow(listOf<ChuniGenre>())
    val totalMasterScore = MutableStateFlow(0)

    init {
        loadData(context)
    }

    fun loadData(context: Context) {
        getCardFromLocal(context)
        getAvatarFromLocal(context)
        getMasterFromLocal(context)
    }

    fun fetchSongData(context: Context) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getChuniSongsData()
    }

    fun fetchUserData(context: Context) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getUserData()
        getCardFromLocal(context)
    }

    private fun getCardFromLocal(context: Context) {
        val jsonUser = JsonUtil.readJsonFromFile(context, "chuniUser.json")
        val jsonUserExt = JsonUtil.readJsonFromFile(context, "chuniUserExt.json")
        if (jsonUser.isNullOrEmpty() || jsonUserExt.isNullOrEmpty()) return
        val chuniUser = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniUser::class.java).fromJson(jsonUser) ?: ChuniUser()
        val chuniUserExt = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniUserExtend::class.java).fromJson(jsonUserExt) ?: ChuniUserExtend()
        chuniCardUI.update { ChuniCardUI(chuniUser, chuniUserExt) }
    }

    private fun getAvatarFromLocal(context: Context) {
        val json = JsonUtil.readJsonFromFile(context, "chuniPenguin.json")
        if (json.isNullOrEmpty()) return
        val chuniPenguin = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniPenguin::class.java).fromJson(json) ?: ChuniPenguin()
        chuniAvatarUI.update { ChuniAvatarUI(chuniPenguin) }
    }

    private fun getMasterFromLocal(context: Context){
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val masterRecordListType = Types.newParameterizedType(List::class.java, ChuniGenre::class.java)
        val masterRecordJsonAdapter = moshi.adapter<List<ChuniGenre>>(masterRecordListType)
        val masterRecordJson = JsonUtil.readJsonFromFile(context, "chuniPlayRecordMaster.json")
        if (masterRecordJson != null) {
            chuniMasterRecord.update { masterRecordJsonAdapter.fromJson(masterRecordJson) ?: listOf() }
        }
        var totalScore = 0
        for (masterScore in chuniMasterRecord.value) {
            for (fullScore in masterScore.fullScoreList) {
                totalScore += CommonUtils.bigNumberToInt(fullScore.score)
            }
        }
        totalMasterScore.update { totalScore }
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