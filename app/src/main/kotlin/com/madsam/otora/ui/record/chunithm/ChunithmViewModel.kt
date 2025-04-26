package com.madsam.otora.ui.record.chunithm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.madsam.otora.data.chunithm.local.api.ChunithmLocalService
import com.madsam.otora.data.chunithm.remote.model.ChuniFriendDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniGenreDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniPenguinDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniPlayRecordDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniUserDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniUserExtendDTO
import com.madsam.otora.data.chunithm.ui.model.ChunithmAvatarUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmCardUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmFriendUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayDataUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmScoreUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmTopRankUiModel
import com.madsam.otora.data.chunithm.remote.api.ChunithmRequestService
import com.madsam.otora.data.adapter.SafeIntPairAdapter
import com.madsam.otora.core.utils.CalcUtils.calcChuniRank
import com.madsam.otora.core.utils.CalcUtils.calcChuniRating
import com.madsam.otora.core.utils.CommonUtils.bigNumberToInt
import com.madsam.otora.core.utils.JsonUtil
import com.madsam.otora.data.chunithm.ui.model.ChunithmSongUiModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ChunithmViewModel(
    context: Context
) : ViewModel() {
    val chunithmCardUiModel = MutableStateFlow(ChunithmCardUiModel())
    val chunithmAvatarUiModel = MutableStateFlow(ChunithmAvatarUiModel())

    val chunithmPlayDataUiModel = MutableStateFlow(ChunithmPlayDataUiModel())
    val chuniFriendDataUI = MutableStateFlow(listOf<ChunithmFriendUiModel>())

    val chunithmTopRankUiModel = MutableStateFlow(ChunithmTopRankUiModel())

    private val chuniBasicRecord = MutableStateFlow(listOf<ChuniGenreDTO>())
    private val chuniAdvancedRecord = MutableStateFlow(listOf<ChuniGenreDTO>())
    private val chuniExpertRecord = MutableStateFlow(listOf<ChuniGenreDTO>())
    private val chuniMasterRecord = MutableStateFlow(listOf<ChuniGenreDTO>())
    private val chuniUltimaRecord = MutableStateFlow(listOf<ChuniGenreDTO>())

    private val _chuniSongs = MutableStateFlow<List<ChunithmSongUiModel>>(emptyList())
    val chuniSongs = _chuniSongs.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _filteredSongs = MutableStateFlow<List<ChunithmSongUiModel>>(emptyList())
    val filteredSongs = _filteredSongs.asStateFlow()

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
        val chunithmRequestService = ChunithmRequestService(context)
        chunithmRequestService.getChuniSongsData()
    }

    fun fetchUserData(context: Context) {
        val chunithmRequestService = ChunithmRequestService(context)
        chunithmRequestService.getUserData()
        loadCardFromLocal(context)
    }

    private fun loadCardFromLocal(context: Context) {
        val jsonUser = JsonUtil.readJsonFromFile(context, "chuniUser.json")
        val jsonUserExt = JsonUtil.readJsonFromFile(context, "chuniUserExt.json")
        if (jsonUser.isNullOrEmpty() || jsonUserExt.isNullOrEmpty()) return
        val chuniUserDTO = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniUserDTO::class.java).fromJson(jsonUser) ?: ChuniUserDTO()
        val chuniUserExt = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniUserExtendDTO::class.java).fromJson(jsonUserExt) ?: ChuniUserExtendDTO()
        chunithmCardUiModel.update { ChunithmCardUiModel(chuniUserDTO, chuniUserExt) }
    }

    private fun loadAvatarFromLocal(context: Context) {
        val json = JsonUtil.readJsonFromFile(context, "chuniPenguin.json")
        if (json.isNullOrEmpty()) return
        val chuniPenguinDTO = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniPenguinDTO::class.java).fromJson(json) ?: ChuniPenguinDTO()
        chunithmAvatarUiModel.update { ChunithmAvatarUiModel(chuniPenguinDTO) }
    }

    private fun loadPlayDataFromLocal(context: Context) {
        val moshi = Moshi.Builder()
            .add(SafeIntPairAdapter())
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val diffArray = arrayOf("Basic", "Advanced", "Expert", "Master", "Ultima")
        for (diff in diffArray) {
            val playRecordJsonAdapter = moshi.adapter(ChuniPlayRecordDTO::class.java)
            val playRecordJson =
                JsonUtil.readJsonFromFile(context, "chuniPlayRecord$diff.json") ?: continue
            val playRecord = playRecordJsonAdapter.fromJson(playRecordJson) ?: ChuniPlayRecordDTO()
            val playDataList = playRecord.genreList
            var totalScore = 0L
            for (score in playDataList) {
                for (fullScore in score.fullScoreList) {
                    if (fullScore.score.isEmpty()) continue
                    totalScore += bigNumberToInt(fullScore.score)
                }
            }
            val playData = ChunithmPlayDataUiModel.ChuniPlayDataItemUI().apply {
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
                    chunithmPlayDataUiModel.update { it.copy(basicPlayData = playData) }
                }

                "Advanced" -> {
                    chuniAdvancedRecord.update { playDataList }
                    chunithmPlayDataUiModel.update { it.copy(advancedPlayData = playData) }
                }

                "Expert" -> {
                    chuniExpertRecord.update { playDataList }
                    chunithmPlayDataUiModel.update { it.copy(expertPlayData = playData) }
                }

                "Master" -> {
                    chuniMasterRecord.update { playDataList }
                    chunithmPlayDataUiModel.update { it.copy(masterPlayData = playData) }
                }

                "Ultima" -> {
                    chuniUltimaRecord.update { playDataList }
                    chunithmPlayDataUiModel.update { it.copy(ultimaPlayData = playData) }
                }
            }
        }
    }

    private fun loadFriendDataFromLocal(context: Context) {
        val json = JsonUtil.readJsonFromFile(context, "chuniFriend.json")
        if (json.isNullOrEmpty()) return

        val type = Types.newParameterizedType(List::class.java, ChuniFriendDTO::class.java)

        val friendList = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
            .adapter<List<ChuniFriendDTO>>(type)
            .fromJson(json)
            ?.map { ChunithmFriendUiModel(it) }
            ?: emptyList()

        chuniFriendDataUI.update { friendList }
    }

    private fun loadTopRankDataFromLocal(context: Context) {
        viewModelScope.launch {
            val chunithmLocalService = ChunithmLocalService()
            val topRank = ChunithmTopRankUiModel()
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
            val ratingBestListType =
                Types.newParameterizedType(List::class.java, ChuniScoreDTO::class.java)
            val ratingBestJsonAdapter = moshi.adapter<List<ChuniScoreDTO>>(ratingBestListType)
            val ratingBestJson = JsonUtil.readJsonFromFile(context, "chuniRatingBest.json")
            if (ratingBestJson != null) {
                val bestListData = ratingBestJsonAdapter.fromJson(ratingBestJson) ?: listOf()
                val bestList = mutableListOf<ChunithmScoreUiModel>()
                for (best in bestListData) {
                    val songData = chunithmLocalService.getChuniSongData(best.title)
                    val diff = when (best.diff) {
                        "0" -> "basic"
                        "1" -> "advanced"
                        "2" -> "expert"
                        "3" -> "master"
                        "4" -> "ultima"
                        else -> "master"
                    }
                    val songSheetData = chunithmLocalService.getChuniSongSheetData(best.title, diff)
                    bestList.add(
                        ChunithmScoreUiModel(
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
            val ratingRecentListType = Types.newParameterizedType(List::class.java, ChuniScoreDTO::class.java)
            val ratingRecentJsonAdapter = moshi.adapter<List<ChuniScoreDTO>>(ratingRecentListType)
            val ratingRecentJson = JsonUtil.readJsonFromFile(context, "chuniRatingRecent.json")
            if (ratingRecentJson != null) {
                val recentListData = ratingRecentJsonAdapter.fromJson(ratingRecentJson) ?: listOf()
                val recentList = mutableListOf<ChunithmScoreUiModel>()
                for (recent in recentListData) {
                    val songData = chunithmLocalService.getChuniSongData(recent.title)
                    val diff = when (recent.diff) {
                        "0" -> "basic"
                        "1" -> "advanced"
                        "2" -> "expert"
                        "3" -> "master"
                        "4" -> "ultima"
                        else -> "master"
                    }
                    val songSheetData = chunithmLocalService.getChuniSongSheetData(recent.title, diff)
                    recentList.add(
                        ChunithmScoreUiModel(
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
            val ratingSuggestListType = Types.newParameterizedType(List::class.java, ChuniScoreDTO::class.java)
            val ratingSuggestJsonAdapter = moshi.adapter<List<ChuniScoreDTO>>(ratingSuggestListType)
            val ratingSuggestJson = JsonUtil.readJsonFromFile(context, "chuniRatingNext.json")
            if (ratingSuggestJson != null) {
                val suggestListData = ratingSuggestJsonAdapter.fromJson(ratingSuggestJson) ?: listOf()
                val suggestList = mutableListOf<ChunithmScoreUiModel>()
                for (suggest in suggestListData) {
                    val songData = chunithmLocalService.getChuniSongData(suggest.title)
                    val diff = when (suggest.diff) {
                        "0" -> "basic"
                        "1" -> "advanced"
                        "2" -> "expert"
                        "3" -> "master"
                        "4" -> "ultima"
                        else -> "master"
                    }
                    val songSheetData = chunithmLocalService.getChuniSongSheetData(suggest.title, diff)
                    suggestList.add(
                        ChunithmScoreUiModel(
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
            chunithmTopRankUiModel.update { topRank }
        }
    }

    internal fun loadAllSongsData() {
        val chunithmLocalService = ChunithmLocalService()
        viewModelScope.launch {
            val allSongs = chunithmLocalService.getAllSongData()
            _chuniSongs.update { allSongs }
            _filteredSongs.value = _chuniSongs.value
        }
    }

    fun updateSearchText(text: String) {
        _searchText.value = text
        filterSongs()
    }

    private fun filterSongs() {
        val query = _searchText.value.trim()
        if (query.isEmpty()) {
            _filteredSongs.value = _chuniSongs.value
            return
        }

        _filteredSongs.value = _chuniSongs.value.filter { song ->
            song.title.contains(query, ignoreCase = true) ||
                    song.artist.contains(query, ignoreCase = true)
        }
    }
}

class ChuniViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChunithmViewModel::class.java)) {
            return ChunithmViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}