package com.madsam.otora.ui.record.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.model.chuni.net.ChuniGenre
import com.madsam.otora.model.chuni.net.ChuniPenguin
import com.madsam.otora.model.chuni.net.ChuniUser
import com.madsam.otora.model.chuni.net.ChuniUserExtend
import com.madsam.otora.model.chuni.ui.ChuniAvatarUI
import com.madsam.otora.model.chuni.ui.ChuniCardUI
import com.madsam.otora.model.chuni.ui.ChuniPlayDataUI
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

    val chuniPlayDataUI = MutableStateFlow(ChuniPlayDataUI())
    val chuniBasicRecord = MutableStateFlow(listOf<ChuniGenre>())
    val chuniAdvancedRecord = MutableStateFlow(listOf<ChuniGenre>())
    val chuniExpertRecord = MutableStateFlow(listOf<ChuniGenre>())
    val chuniMasterRecord = MutableStateFlow(listOf<ChuniGenre>())
    val chuniUltimaRecord = MutableStateFlow(listOf<ChuniGenre>())

    init {
        loadData(context)
    }

    fun loadData(context: Context) {
        loadCardFromLocal(context)
        loadAvatarFromLocal(context)
        loadPlayDataFromLocal(context)
    }

    fun fetchSongData(context: Context) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getChuniSongsData()
    }

    fun fetchUserData(context: Context) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getUserData()
        loadCardFromLocal(context)
    }

    private fun loadCardFromLocal(context: Context) {
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

    private fun loadAvatarFromLocal(context: Context) {
        val json = JsonUtil.readJsonFromFile(context, "chuniPenguin.json")
        if (json.isNullOrEmpty()) return
        val chuniPenguin = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniPenguin::class.java).fromJson(json) ?: ChuniPenguin()
        chuniAvatarUI.update { ChuniAvatarUI(chuniPenguin) }
    }

    private fun loadPlayDataFromLocal(context: Context) {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val diffArray = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
        for (diff in diffArray) {
            val playRecordListType =
                Types.newParameterizedType(List::class.java, ChuniGenre::class.java)
            val playRecordJsonAdapter = moshi.adapter<List<ChuniGenre>>(playRecordListType)
            val playRecordJson = JsonUtil.readJsonFromFile(context, "chuniPlayRecord$diff.json")
            if (playRecordJson != null) {
                val playRecordList = playRecordJsonAdapter.fromJson(playRecordJson)
                if (playRecordList != null) {
                    var totalScore = 0L
                    for (score in playRecordList) {
                        for (fullScore in score.fullScoreList) {
                            if (fullScore.score.isEmpty()) continue
                            totalScore += CommonUtils.bigNumberToInt(fullScore.score)
                        }
                    }
                    when (diff) {
                        "Basic" -> {
                            chuniBasicRecord.update { playRecordList }
                            val playData = ChuniPlayDataUI.ChuniPlayDataItemUI()
                            playData.scoreTotal = totalScore
                            chuniPlayDataUI.update {
                                it.copy(basicPlayData = playData)
                            }
                        }

                        "Advanced" -> {
                            chuniAdvancedRecord.update { playRecordList }
                            val playData = ChuniPlayDataUI.ChuniPlayDataItemUI()
                            playData.scoreTotal = totalScore
                            chuniPlayDataUI.update {
                                it.copy(advancedPlayData = playData)
                            }
                        }

                        "Expert" -> {
                            chuniExpertRecord.update { playRecordList }
                            val playData = ChuniPlayDataUI.ChuniPlayDataItemUI()
                            playData.scoreTotal = totalScore
                            chuniPlayDataUI.update {
                                it.copy(expertPlayData = playData)
                            }
                        }

                        "Master" -> {
                            chuniMasterRecord.update { playRecordList }
                            val playData = ChuniPlayDataUI.ChuniPlayDataItemUI()
                            playData.scoreTotal = totalScore
                            chuniPlayDataUI.update {
                                it.copy(masterPlayData = playData)
                            }
                        }

                        "Ultima" -> {
                            chuniUltimaRecord.update { playRecordList }
                            val playData = ChuniPlayDataUI.ChuniPlayDataItemUI()
                            playData.scoreTotal = totalScore
                            chuniPlayDataUI.update {
                                it.copy(ultimaPlayData = playData)
                            }
                        }
                    }
                }
            }
        }
    }
}

class ChuniViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChuniViewModel::class.java)) {
            return ChuniViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}