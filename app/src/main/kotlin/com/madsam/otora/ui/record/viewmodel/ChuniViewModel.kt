package com.madsam.otora.ui.record.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.madsam.otora.model.chuni.net.ChuniFriend
import com.madsam.otora.model.chuni.net.ChuniGenre
import com.madsam.otora.model.chuni.net.ChuniPenguin
import com.madsam.otora.model.chuni.net.ChuniPlayRecord
import com.madsam.otora.model.chuni.net.ChuniScore
import com.madsam.otora.model.chuni.net.ChuniUser
import com.madsam.otora.model.chuni.net.ChuniUserExtend
import com.madsam.otora.model.chuni.ui.ChuniAvatarUI
import com.madsam.otora.model.chuni.ui.ChuniCardUI
import com.madsam.otora.model.chuni.ui.ChuniFriendUI
import com.madsam.otora.model.chuni.ui.ChuniPlayDataUI
import com.madsam.otora.model.chuni.ui.ChuniScoreUI
import com.madsam.otora.model.chuni.ui.ChuniTopRankUI
import com.madsam.otora.service.ChuniDataRequestService
import com.madsam.otora.service.IntPairAdapter
import com.madsam.otora.utils.CalcUtils.calcChuniRank
import com.madsam.otora.utils.CalcUtils.calcChuniRating
import com.madsam.otora.utils.CommonUtils.bigNumberToInt
import com.madsam.otora.utils.JsonUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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
    val chuniFriendDataUI = MutableStateFlow(listOf<ChuniFriendUI>())

    val chuniTopRankUI = MutableStateFlow(ChuniTopRankUI())

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
        loadFriendDataFromLocal(context)
        loadTopRankDataFromLocal(context)
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
            .add(IntPairAdapter())
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val diffArray = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
        for (diff in diffArray) {
            val playRecordJsonAdapter = moshi.adapter(ChuniPlayRecord::class.java)
            val playRecordJson =
                JsonUtil.readJsonFromFile(context, "chuniPlayRecord$diff.json") ?: continue
            val playRecord = playRecordJsonAdapter.fromJson(playRecordJson) ?: ChuniPlayRecord()
            val playDataList = playRecord.genreList
            var totalScore = 0L
            for (score in playDataList) {
                for (fullScore in score.fullScoreList) {
                    if (fullScore.score.isEmpty()) continue
                    totalScore += bigNumberToInt(fullScore.score)
                }
            }
            val playData = ChuniPlayDataUI.ChuniPlayDataItemUI().apply {
                this.scoreTotal = totalScore
                this.rateSSSp = playRecord.rateSSSp
                this.rateSSS = playRecord.rateSSS
                this.rateSSp = playRecord.rateSSp
                this.rateSS = playRecord.rateSS
                this.rateSp = playRecord.rateSp
                this.rateS = playRecord.rateS
                this.rateFC = playRecord.rateFC
                this.rateAJ = playRecord.rateAJ
                this.rateAJC = playRecord.rateAJC
                this.rateFChain = playRecord.rateFChain
                this.rateFChainP = playRecord.rateFChainP
                this.rateClear = playRecord.rateClear
                this.rateHard = playRecord.rateHard
                this.rateAbs = playRecord.rateAbs
                this.rateAbsP = playRecord.rateAbsP
                this.rateCatas = playRecord.rateCatas
            }
            when (diff) {
                "Basic" -> {
                    chuniBasicRecord.update { playDataList }
                    chuniPlayDataUI.update { it.copy(basicPlayData = playData) }
                }

                "Advanced" -> {
                    chuniAdvancedRecord.update { playDataList }
                    chuniPlayDataUI.update { it.copy(advancedPlayData = playData) }
                }

                "Expert" -> {
                    chuniExpertRecord.update { playDataList }
                    chuniPlayDataUI.update { it.copy(expertPlayData = playData) }
                }

                "Master" -> {
                    chuniMasterRecord.update { playDataList }
                    chuniPlayDataUI.update { it.copy(masterPlayData = playData) }
                }

                "Ultima" -> {
                    chuniUltimaRecord.update { playDataList }
                    chuniPlayDataUI.update { it.copy(ultimaPlayData = playData) }
                }
            }
        }
    }

    private fun loadFriendDataFromLocal(context: Context) {
        val json = JsonUtil.readJsonFromFile(context, "chuniFriend.json")
        if (json.isNullOrEmpty()) return

        val type = Types.newParameterizedType(List::class.java, ChuniFriend::class.java)

        val friendList = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
            .adapter<List<ChuniFriend>>(type)
            .fromJson(json)
            ?.map { ChuniFriendUI(it) }
            ?: emptyList()

        chuniFriendDataUI.update { friendList }
    }

    private fun loadTopRankDataFromLocal(context: Context) {
        viewModelScope.launch {
            val chuniDataRequestService = ChuniDataRequestService(context)
            val topRank = ChuniTopRankUI()
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
            val ratingBestListType =
                Types.newParameterizedType(List::class.java, ChuniScore::class.java)
            val ratingBestJsonAdapter = moshi.adapter<List<ChuniScore>>(ratingBestListType)
            val ratingBestJson = JsonUtil.readJsonFromFile(context, "chuniRatingBest.json")
            if (ratingBestJson != null) {
                val bestListData = ratingBestJsonAdapter.fromJson(ratingBestJson) ?: listOf()
                val bestList = mutableListOf<ChuniScoreUI>()
                for (best in bestListData) {
                    val songData = chuniDataRequestService.getChuniSongData(best.title)
                    val diff = when (best.diff) {
                        "0" -> "basic"
                        "1" -> "advanced"
                        "2" -> "expert"
                        "3" -> "master"
                        "4" -> "ultima"
                        else -> "master"
                    }
                    val songSheetData = chuniDataRequestService.getChuniSongSheetData(best.title, diff)
                    bestList.add(
                        ChuniScoreUI(
                            title = songData.title,
                            artist = songData.artist,
                            noteDesigner = songSheetData.noteDesigner,
                            genre = songData.genre,
                            diff = diff,
                            level = songSheetData.levelCn,
                            levelValue = songSheetData.levelValueCn,
                            score = best.highScore,
                            rank = calcChuniRank(bigNumberToInt(best.highScore)),
                            rating = calcChuniRating(bigNumberToInt(best.highScore), songSheetData.levelValueCn),
                            jacket = songData.imageName,
                            tap = songSheetData.tap,
                            hold = songSheetData.hold,
                            slide = songSheetData.slide,
                            air = songSheetData.air,
                            flick = songSheetData.flick,
                            total = songSheetData.total
                        )
                    )
                }
                topRank.bestList = bestList
                topRank.best30 = bestList.map { it.rating }.average()
            }
            val ratingRecentListType = Types.newParameterizedType(List::class.java, ChuniScore::class.java)
            val ratingRecentJsonAdapter = moshi.adapter<List<ChuniScore>>(ratingRecentListType)
            val ratingRecentJson = JsonUtil.readJsonFromFile(context, "chuniRatingRecent.json")
            if (ratingRecentJson != null) {
                val recentListData = ratingRecentJsonAdapter.fromJson(ratingRecentJson) ?: listOf()
                val recentList = mutableListOf<ChuniScoreUI>()
                for (recent in recentListData) {
                    val songData = chuniDataRequestService.getChuniSongData(recent.title)
                    val diff = when (recent.diff) {
                        "0" -> "basic"
                        "1" -> "advanced"
                        "2" -> "expert"
                        "3" -> "master"
                        "4" -> "ultima"
                        else -> "master"
                    }
                    val songSheetData = chuniDataRequestService.getChuniSongSheetData(recent.title, diff)
                    recentList.add(
                        ChuniScoreUI(
                            title = songData.title,
                            artist = songData.artist,
                            noteDesigner = songSheetData.noteDesigner,
                            genre = songData.genre,
                            diff = diff,
                            level = songSheetData.levelCn,
                            levelValue = songSheetData.levelValueCn,
                            score = recent.highScore,
                            rank = calcChuniRank(bigNumberToInt(recent.highScore)),
                            rating = calcChuniRating(bigNumberToInt(recent.highScore), songSheetData.levelValueCn),
                            jacket = songData.imageName,
                            tap = songSheetData.tap,
                            hold = songSheetData.hold,
                            slide = songSheetData.slide,
                            air = songSheetData.air,
                            flick = songSheetData.flick,
                            total = songSheetData.total
                        )
                    )
                }
                topRank.recentList = recentList
                topRank.recent10 = recentList.map { it.rating }.average()
            }
            val ratingSuggestListType = Types.newParameterizedType(List::class.java, ChuniScore::class.java)
            val ratingSuggestJsonAdapter = moshi.adapter<List<ChuniScore>>(ratingSuggestListType)
            val ratingSuggestJson = JsonUtil.readJsonFromFile(context, "chuniRatingNext.json")
            if (ratingSuggestJson != null) {
                val suggestListData = ratingSuggestJsonAdapter.fromJson(ratingSuggestJson) ?: listOf()
                val suggestList = mutableListOf<ChuniScoreUI>()
                for (suggest in suggestListData) {
                    val songData = chuniDataRequestService.getChuniSongData(suggest.title)
                    val diff = when (suggest.diff) {
                        "0" -> "basic"
                        "1" -> "advanced"
                        "2" -> "expert"
                        "3" -> "master"
                        "4" -> "ultima"
                        else -> "master"
                    }
                    val songSheetData = chuniDataRequestService.getChuniSongSheetData(suggest.title, diff)
                    suggestList.add(
                        ChuniScoreUI(
                            title = songData.title,
                            artist = songData.artist,
                            noteDesigner = songSheetData.noteDesigner,
                            genre = songData.genre,
                            diff = diff,
                            level = songSheetData.levelCn,
                            levelValue = songSheetData.levelValueCn,
                            score = suggest.highScore,
                            rank = calcChuniRank(bigNumberToInt(suggest.highScore)),
                            rating = calcChuniRating(bigNumberToInt(suggest.highScore), songSheetData.levelValueCn),
                            jacket = songData.imageName,
                            tap = songSheetData.tap,
                            hold = songSheetData.hold,
                            slide = songSheetData.slide,
                            air = songSheetData.air,
                            flick = songSheetData.flick,
                            total = songSheetData.total
                        )
                    )
                }
                topRank.suggestList = suggestList
                topRank.suggest10 = suggestList.map { it.rating }.average()
            }
            chuniTopRankUI.update { topRank }
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