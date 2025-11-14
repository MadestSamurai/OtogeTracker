package com.madsam.otora.ui.record.chunithm

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.madsam.otora.core.utils.CalcUtils.calcChuniRank
import com.madsam.otora.core.utils.CalcUtils.calcChuniRating
import com.madsam.otora.core.utils.NumberFormatUtils.bigNumberToInt

import com.madsam.otora.data.chunithm.local.datastore.ChunithmPenguinDataStore
import com.madsam.otora.data.chunithm.local.datastore.ChunithmUserDataStore
import com.madsam.otora.data.chunithm.local.datastore.ChunithmUserExtDataStore
import com.madsam.otora.data.chunithm.local.model.ChunithmRatingEntity
import com.madsam.otora.data.chunithm.local.objectbox.ChunithmObjectBoxService
import com.madsam.otora.data.chunithm.remote.model.ChunithmFriendDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLoginBonusDTO
import com.madsam.otora.data.chunithm.remote.model.DailyReward
import com.madsam.otora.data.chunithm.remote.model.MonthlyReward
import com.madsam.otora.data.chunithm.remote.model.WeekdayBonus
import com.madsam.otora.data.chunithm.ui.model.ChunithmAvatarUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmCardUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmFriendUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayDataUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayRecordUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmScoreUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmSongUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmTopRankUiModel
import com.madsam.otora.data.chunithm.ui.model.PlayDataCategoryStats
import com.madsam.otora.data.chunithm.ui.model.PlayDataCategoryType
import com.madsam.otora.data.chunithm.ui.model.PlayDataCategory
import com.madsam.otora.ui.record.chunithm.components.SheetScoreInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ChunithmViewModel() : ViewModel() {
    val chunithmCardUiModel = MutableStateFlow(ChunithmCardUiModel())
    val chunithmAvatarUiModel = MutableStateFlow(ChunithmAvatarUiModel())

    val chunithmPlayDataUiModel = MutableStateFlow(ChunithmPlayDataUiModel())
    val chuniFriendDataUI = MutableStateFlow(listOf<ChunithmFriendUiModel>())

    val chunithmTopRankUiModel = MutableStateFlow(ChunithmTopRankUiModel())
    
    // 分类统计数据（统一使用 PlayDataCategoryStats）
    private val _difficultyStats = MutableStateFlow<List<PlayDataCategoryStats>>(emptyList())
    val difficultyStats: StateFlow<List<PlayDataCategoryStats>> = _difficultyStats.asStateFlow()
    
    private val _genreStats = MutableStateFlow<List<PlayDataCategoryStats>>(emptyList())
    val genreStats: StateFlow<List<PlayDataCategoryStats>> = _genreStats.asStateFlow()
    
    private val _versionStats = MutableStateFlow<List<PlayDataCategoryStats>>(emptyList())
    val versionStats: StateFlow<List<PlayDataCategoryStats>> = _versionStats.asStateFlow()
    
    private val _levelStats = MutableStateFlow<List<PlayDataCategoryStats>>(emptyList())
    val levelStats: StateFlow<List<PlayDataCategoryStats>> = _levelStats.asStateFlow()
    
    // 登录奖励数据
    private val _chunithmLoginBonus = MutableStateFlow<ChuniLoginBonusDTO?>(null)
    val chunithmLoginBonus = _chunithmLoginBonus.asStateFlow()
    
    // 地图数据
    val chunithmMapDataUI = MutableStateFlow(listOf<com.madsam.otora.ui.record.chunithm.components.ChunithmMapUiModel>())

    private val _chuniSongs = MutableStateFlow<List<ChunithmSongUiModel>>(emptyList())
    val chuniSongs = _chuniSongs.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    // 页面标题状态
    private val _pageTitle = MutableStateFlow("CHUNITHM")
    val pageTitle = _pageTitle.asStateFlow()

    // 控制是否显示返回按钮（而不是菜单按钮）
    private val _showBackButton = MutableStateFlow(false)
    val showBackButton = _showBackButton.asStateFlow()

    // 返回回调
    private var onBackCallback: (() -> Unit)? = null

    private val _filteredSongs = MutableStateFlow<List<ChunithmSongUiModel>>(emptyList())

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    // 滚动到顶部事件
    private val _scrollSongListToTopEvent = MutableStateFlow(false)
    val scrollSongListToTopEvent = _scrollSongListToTopEvent.asStateFlow()

    // 分数缓存 - 预加载机制
    private val _allScoresCache = MutableStateFlow<Map<String, Map<String, ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel>>>(emptyMap())
    val allScoresCache: StateFlow<Map<String, Map<String, ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel>>> = _allScoresCache.asStateFlow()
    private var scoresCacheLoaded = false

    // 角色数据
    private val _characters = MutableStateFlow<List<com.madsam.otora.data.chunithm.local.model.ChunithmCharacterEntity>>(emptyList())
    val characters: StateFlow<List<com.madsam.otora.data.chunithm.local.model.ChunithmCharacterEntity>> = _characters.asStateFlow()

    private val _isCharactersLoading = MutableStateFlow(false)
    val isCharactersLoading: StateFlow<Boolean> = _isCharactersLoading.asStateFlow()
    
    // Avatar 部件数据
    private val _avatarItems = MutableStateFlow<List<com.madsam.otora.data.chunithm.local.model.ChunithmAvatarItemEntity>>(emptyList())
    val avatarItems: StateFlow<List<com.madsam.otora.data.chunithm.local.model.ChunithmAvatarItemEntity>> = _avatarItems.asStateFlow()
    
    private val _selectedAvatarCategory = MutableStateFlow("face")
    val selectedAvatarCategory: StateFlow<String> = _selectedAvatarCategory.asStateFlow()
    
    private val _isAvatarItemsLoading = MutableStateFlow(false)
    val isAvatarItemsLoading: StateFlow<Boolean> = _isAvatarItemsLoading.asStateFlow()
    
    // Avatar 部件统计信息
    data class AvatarCategoryStats(
        val category: String,
        val count: Int,
        val previewItems: List<com.madsam.otora.data.chunithm.local.model.ChunithmAvatarItemEntity>
    )
    
    private val _avatarCategoryStats = MutableStateFlow<Map<String, AvatarCategoryStats>>(emptyMap())
    val avatarCategoryStats: StateFlow<Map<String, AvatarCategoryStats>> = _avatarCategoryStats.asStateFlow()

    fun loadData(context: Context) {
        loadCardFromLocal(context)
        loadAvatarFromLocal(context)
        loadPlayDataFromLocal()
        loadFriendDataFromLocal()
        loadTopRankDataFromLocal()
        loadMapDataFromLocal()
        loadLoginBonusFromLocal()
        loadCharacters()
        loadAvatarCategoryStats()
        preloadAllScores()
        loadCategoryStats()
    }

    fun refreshUserData(context: Context) {
        viewModelScope.launch {
            _isRefreshing.value = true
            try {
                // 添加一个小延迟确保UI更新
                delay(50)
                loadData(context)
                // 添加一个最小延迟确保用户能看到刷新动画
                delay(300)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isRefreshing.value = false
            }
        }
    }

    fun refreshSongData() {
        viewModelScope.launch {
            _isRefreshing.value = true
            try {
                // 添加一个小延迟确保UI更新
                delay(50)
                // 重新加载分数缓存
                preloadAllScores()
                // 添加一个最小延迟确保用户能看到刷新动画
                delay(300)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isRefreshing.value = false
            }
        }
    }

    private fun loadCardFromLocal(context: Context) {
        Log.d("ChunithmViewModel", "loadCardFromLocal called")
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Starting to load user data from DataStore...")
                // 从 DataStore 读取用户数据
                val userDataStore = ChunithmUserDataStore(context)
                val chuniUserDTO = userDataStore.getUserData()
                Log.d("ChunithmViewModel", "DataStore returned: ${chuniUserDTO != null}")
                
                // 从 DataStore 读取扩展数据
                val userExtDataStore = ChunithmUserExtDataStore(context)
                val chuniUserExt = userExtDataStore.getUserExtData()
                Log.d("ChunithmViewModel", "UserExt loaded from DataStore: ${chuniUserExt != null}")
                
                if (chuniUserDTO == null || chuniUserExt == null) {
                    Log.w("ChunithmViewModel", "User data or UserExt not found in DataStore")
                    return@launch
                }
                
                chunithmCardUiModel.update { ChunithmCardUiModel(chuniUserDTO, chuniUserExt) }
                Log.d("ChunithmViewModel", "Card data loaded from DataStore successfully")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading card data: ${e.message}", e)
            }
        }
    }

    private fun loadAvatarFromLocal(context: Context) {
        viewModelScope.launch {
            try {
                val penguinDataStore = ChunithmPenguinDataStore(context)
                val chuniPenguinDTO = penguinDataStore.getPenguinData()
                if (chuniPenguinDTO == null) {
                    Log.w("ChunithmViewModel", "Penguin data not found in DataStore")
                    return@launch
                }
                chunithmAvatarUiModel.update { ChunithmAvatarUiModel(chuniPenguinDTO) }
                Log.d("ChunithmViewModel", "Avatar data loaded from DataStore successfully")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading avatar data: ${e.message}", e)
            }
        }
    }

    private fun loadPlayDataFromLocal() {
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Loading play data from database...")
                val chunithmLocalService = ChunithmObjectBoxService()

                for (diff in 0..4) {
                    val playRecordUiModel = chunithmLocalService.getPlayRecordUiModel(diff.toString())
                    
                    if (playRecordUiModel != null) {
                        // 使用Map来存储每个歌曲+难度的最高分数
                        val bestScores = mutableMapOf<String, Long>()

                        playRecordUiModel.scores.forEach { score ->
                            val scoreKey = "${score.title}_${score.diff}" // 创建唯一键
                            val currentBest = bestScores[scoreKey] ?: 0L
                            // 只保留最高分数
                            if (score.score > currentBest) {
                                bestScores[scoreKey] = score.score.toLong()
                            }
                        }
                        
                        // 计算总分（所有最高分的和）
                        val totalScore: Long = bestScores.values.sum()
                        
                        val playData = ChunithmPlayDataUiModel.ChunithmPlayDataItemUI().apply {
                            this.scoreTotal = totalScore
                            this.totalSongs = playRecordUiModel.totalSongs
                            this.rateSSSp = playRecordUiModel.rateSSSp
                            this.rateSSS = playRecordUiModel.rateSSS
                            this.rateSSp = playRecordUiModel.rateSSp
                            this.rateSS = playRecordUiModel.rateSS
                            this.rateSp = playRecordUiModel.rateSp
                            this.rateS = playRecordUiModel.rateS
                            this.rateFC = playRecordUiModel.rateFC
                            this.rateAJ = playRecordUiModel.rateAJ
                            this.rateAJC = playRecordUiModel.rateAJC
                            this.rateFChain = playRecordUiModel.rateFChain
                            this.rateFChainP = playRecordUiModel.rateFChainP
                            this.rateClear = playRecordUiModel.rateClear
                            this.rateHard = playRecordUiModel.rateHard
                            this.rateBrave = playRecordUiModel.rateBrave
                            this.rateAbs = playRecordUiModel.rateAbs
                            this.rateCatas = playRecordUiModel.rateCatas
                        }
                        
                        when (diff) {
                            0 -> {
                                chunithmPlayDataUiModel.update { it.copy(basicPlayData = playData) }
                            }
                            1 -> {
                                chunithmPlayDataUiModel.update { it.copy(advancedPlayData = playData) }
                            }
                            2 -> {
                                chunithmPlayDataUiModel.update { it.copy(expertPlayData = playData) }
                            }
                            3 -> {
                                chunithmPlayDataUiModel.update { it.copy(masterPlayData = playData) }
                            }
                            4 -> {
                                chunithmPlayDataUiModel.update { it.copy(ultimaPlayData = playData) }
                            }
                        }
                        
                    } else {
                        Log.w("ChunithmViewModel", "No play record found for difficulty: $diff")
                    }
                }
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Failed to load play data from database: ${e.message}", e)
            }
        }
    }

    private fun loadFriendDataFromLocal() {
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Loading friend data from database...")
                val chunithmLocalService = ChunithmObjectBoxService()
                
                val friendListData = chunithmLocalService.getFriendListData()
                val friendList = friendListData.map { entity ->
                    ChunithmFriendUiModel(ChunithmFriendDTO(
                        friendCode = entity.friendCode,
                        friendName = entity.friendName,
                        profileBackground = entity.profileBackground,
                        reborn = entity.reborn,
                        level = entity.level,
                        rating = entity.rating,
                        overpower = entity.overpower,
                        lastPlay = entity.lastPlay,
                        roleImageUrl = entity.roleImageUrl,
                        roleBase = entity.roleBase,
                        honor1 = entity.honor1,
                        honor2 = entity.honor2,
                        honor3 = entity.honor3,
                        honorBase1 = entity.honorBase1,
                        honorBase2 = entity.honorBase2,
                        honorBase3 = entity.honorBase3,
                        isFavorite = entity.isFavorite,
                        isScored = entity.isScored,
                        classEmblemBase = entity.classEmblemBase,
                        classEmblemTop = entity.classEmblemTop
                    ))
                }
                
                chuniFriendDataUI.update { friendList }
                Log.d("ChunithmViewModel", "Loaded ${friendList.size} friends from database")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Failed to load friend data from database: ${e.message}", e)
            }
        }
    }

    private fun loadTopRankDataFromLocal() {
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Loading rating data from ObjectBox...")
                val chunithmLocalService = ChunithmObjectBoxService()
                val topRank = ChunithmTopRankUiModel()
                
                // 加载 Best Rating 数据
                val bestListData = chunithmLocalService.getRatingData(ChunithmRatingEntity.TYPE_BEST)
                Log.d("ChunithmViewModel", "Loaded ${bestListData.size} best records from ObjectBox")
                
                if (bestListData.isNotEmpty()) {
                    val bestList = mutableListOf<ChunithmScoreUiModel>()
                    for (best in bestListData) {
                        val songData = chunithmLocalService.getChunithmSongData(best.title)
                        val diff = when (best.diff) {
                            "0" -> "basic"
                            "1" -> "advanced"
                            "2" -> "expert"
                            "3" -> "master"
                            "4" -> "ultima"
                            else -> "master"
                        }
                        val songSheetData = chunithmLocalService.getChunithmSongSheetData(best.title, diff)
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
                    Log.d("ChunithmViewModel", "Best30 average: ${topRank.best30}")
                }
                
                // 加载 Recent Rating 数据
                val recentListData = chunithmLocalService.getRatingData(ChunithmRatingEntity.TYPE_RECENT)
                Log.d("ChunithmViewModel", "Loaded ${recentListData.size} recent records from ObjectBox")
                
                if (recentListData.isNotEmpty()) {
                    val recentList = mutableListOf<ChunithmScoreUiModel>()
                    for (recent in recentListData) {
                        val songData = chunithmLocalService.getChunithmSongData(recent.title)
                        val diff = when (recent.diff) {
                            "0" -> "basic"
                            "1" -> "advanced"
                            "2" -> "expert"
                            "3" -> "master"
                            "4" -> "ultima"
                            else -> "master"
                        }
                        val songSheetData = chunithmLocalService.getChunithmSongSheetData(recent.title, diff)
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
                    topRank.newList = recentList
                    topRank.new20 = recentList.map { it.rating }.average()
                    Log.d("ChunithmViewModel", "Recent20 average: ${topRank.new20}")
                }
                
                // 加载 Suggest Rating 数据
                val suggestListData = chunithmLocalService.getRatingData(ChunithmRatingEntity.TYPE_SUGGEST)
                Log.d("ChunithmViewModel", "Loaded ${suggestListData.size} suggest records from ObjectBox")
                
                if (suggestListData.isNotEmpty()) {
                    val suggestList = mutableListOf<ChunithmScoreUiModel>()
                    for (suggest in suggestListData) {
                        val songData = chunithmLocalService.getChunithmSongData(suggest.title)
                        val diff = when (suggest.diff) {
                            "0" -> "basic"
                            "1" -> "advanced"
                            "2" -> "expert"
                            "3" -> "master"
                            "4" -> "ultima"
                            else -> "master"
                        }
                        val songSheetData = chunithmLocalService.getChunithmSongSheetData(suggest.title, diff)
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
                    Log.d("ChunithmViewModel", "Suggest10 average: ${topRank.suggest10}")
                }
                
                chunithmTopRankUiModel.update { topRank }
                Log.d("ChunithmViewModel", "Rating data loaded successfully from ObjectBox")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading rating data from ObjectBox", e)
            }
        }
    }

    private fun loadMapDataFromLocal() {
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Loading map data from ObjectBox...")
                val chunithmLocalService = ChunithmObjectBoxService()
                
                // 直接获取所有格子数据
                val allAreas = chunithmLocalService.getAllMapAreas()
                
                if (allAreas.isNotEmpty()) {
                    val mapUiList = mutableListOf<com.madsam.otora.ui.record.chunithm.components.ChunithmMapUiModel>()
                    
                    // 按 (地图名称, 页码) 分组
                    val groupedByMapAndPage = allAreas.groupBy { it.mapName to it.pageNumber }
                    
                    // 为每个 (地图-页码) 组合创建一个 UI Model
                    groupedByMapAndPage.forEach { (key, areasInPage) ->
                        val (mapName, pageNumber) = key
                        val areaUiList = areasInPage
                            .sortedBy { it.position }
                            .map { areaEntity ->
                                com.madsam.otora.ui.record.chunithm.components.MapAreaUiModel(
                                    position = areaEntity.position,
                                    imageUrl = areaEntity.imageUrl,
                                    remain = areaEntity.remain,
                                    skillSeed = areaEntity.skillSeed,
                                    isEmpty = areaEntity.isEmpty
                                )
                            }
                        
                        // 计算这一页的完成度
                        val nonEmptyAreas = areaUiList.filter { !it.isEmpty }
                        val completedInPage = nonEmptyAreas.count { it.remain == 0 }
                        val totalInPage = nonEmptyAreas.size
                        val progressInPage = if (totalInPage > 0) {
                            (completedInPage.toDouble() / totalInPage * 100)
                        } else 0.0
                        
                        // 获取 totalPages（同一页的所有格子的 totalPages 都相同，取第一个）
                        val totalPages = areasInPage.firstOrNull()?.totalPages ?: 0
                        
                        mapUiList.add(
                            com.madsam.otora.ui.record.chunithm.components.ChunithmMapUiModel(
                                mapName = mapName,
                                currentPage = pageNumber,
                                totalPages = totalPages,
                                completedAreas = completedInPage,
                                totalAreas = totalInPage,
                                progressPercentage = progressInPage,
                                areas = areaUiList
                            )
                        )
                    }
                    
                    chunithmMapDataUI.update { mapUiList }
                    Log.d("ChunithmViewModel", "Loaded ${mapUiList.size} map pages from ObjectBox")
                } else {
                    Log.d("ChunithmViewModel", "No map data found in ObjectBox")
                }
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading map data from ObjectBox", e)
            }
        }
    }

    private fun loadLoginBonusFromLocal() {
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Loading login bonus data from ObjectBox...")
                val objectBoxService = ChunithmObjectBoxService()
                
                // 获取主数据
                val mainData = objectBoxService.getLoginBonusData()
                if (mainData != null) {
                    // 获取各类奖励列表
                    val monthlyRewards = objectBoxService.getMonthlyRewards().map { entity ->
                        MonthlyReward(
                            day = entity.day,
                            imageUrl = entity.imageUrl,
                            rewardName = entity.rewardName,
                            isCompleted = entity.isCompleted
                        )
                    }
                    
                    val dailyRewards = objectBoxService.getDailyRewards().map { entity ->
                        DailyReward(
                            day = entity.day,
                            imageUrl = entity.imageUrl,
                            rewardName = entity.rewardName,
                            isReceived = entity.isReceived,
                            isNext = entity.isNext
                        )
                    }
                    
                    val weekdayBonuses = objectBoxService.getWeekdayBonuses().map { entity ->
                        WeekdayBonus(
                            weekday = entity.weekday,
                            iconUrl = entity.iconUrl,
                            description = entity.description,
                            isToday = false  // 不从数据库读取，使用时调用isTodayBonus()动态判断
                        )
                    }
                    
                    // 组装 DTO
                    val bonus = ChuniLoginBonusDTO(
                        currentMonth = mainData.currentMonthDays,
                        monthlyDays = mainData.currentMonthDays,
                        totalDays = 0, // 暂时不使用这个字段
                        monthlyRewards = monthlyRewards,
                        dailyLoginDay = mainData.dailyStreakDay,
                        dailyRewards = dailyRewards,
                        weekdayBonuses = weekdayBonuses
                    )
                    
                    _chunithmLoginBonus.value = bonus
                    Log.d("ChunithmViewModel", "Login bonus data loaded from ObjectBox: $bonus")
                } else {
                    _chunithmLoginBonus.value = null
                    Log.d("ChunithmViewModel", "No login bonus data found in ObjectBox")
                }
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading login bonus data: ${e.message}", e)
            }
        }
    }

    // 加载角色数据
    fun loadCharacters() {
        viewModelScope.launch {
            _isCharactersLoading.value = true
            try {
                Log.d("ChunithmViewModel", "Loading characters from ObjectBox...")
                val chunithmLocalService = ChunithmObjectBoxService()
                val allCharacters = chunithmLocalService.getAllCharacters()
                _characters.value = allCharacters
                Log.d("ChunithmViewModel", "Loaded ${allCharacters.size} characters from ObjectBox")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading characters from ObjectBox", e)
            } finally {
                _isCharactersLoading.value = false
            }
        }
    }

    // 获取当前使用的角色
    fun getCurrentCharacter(): com.madsam.otora.data.chunithm.local.model.ChunithmCharacterEntity? {
        return _characters.value.find { it.isCurrentlyUsed }
    }
    
    // ==================== Avatar 部件相关方法 ====================
    
    /**
     * 加载指定类型的 Avatar 部件
     * @param category 部件类型（face, head, wear, item, back, front）
     */
    fun loadAvatarItems(category: String) {
        viewModelScope.launch {
            _isAvatarItemsLoading.value = true
            _selectedAvatarCategory.value = category
            try {
                Log.d("ChunithmViewModel", "Loading avatar items for category: $category")
                val chunithmLocalService = ChunithmObjectBoxService()
                val items = chunithmLocalService.getAvatarItemsByCategory(category)
                _avatarItems.value = items
                Log.d("ChunithmViewModel", "Loaded ${items.size} avatar items for category $category")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading avatar items", e)
            } finally {
                _isAvatarItemsLoading.value = false
            }
        }
    }
    
    /**
     * 切换 Avatar 部件类型
     */
    fun selectAvatarCategory(category: String) {
        if (category != _selectedAvatarCategory.value) {
            loadAvatarItems(category)
        }
    }
    
    /**
     * 获取所有 Avatar 部件
     */
    fun loadAllAvatarItems() {
        viewModelScope.launch {
            _isAvatarItemsLoading.value = true
            try {
                Log.d("ChunithmViewModel", "Loading all avatar items")
                val chunithmLocalService = ChunithmObjectBoxService()
                val items = chunithmLocalService.getAllAvatarItems()
                _avatarItems.value = items
                Log.d("ChunithmViewModel", "Loaded ${items.size} total avatar items")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading all avatar items", e)
            } finally {
                _isAvatarItemsLoading.value = false
            }
        }
    }
    
    /**
     * 加载 Avatar 部件统计信息（每个类型的数量和预览）
     */
    fun loadAvatarCategoryStats() {
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Loading avatar category stats")
                val chunithmLocalService = ChunithmObjectBoxService()
                val categories = listOf("face", "head", "wear", "item", "back", "front")
                
                val statsMap = mutableMapOf<String, AvatarCategoryStats>()
                categories.forEach { category ->
                    // 过滤掉名为"ノーマル"的装饰
                    val items = chunithmLocalService.getAvatarItemsByCategory(category)
                        .filter { it.name != "ノーマル" }
                    
                    // 随机取6个作为预览（优先显示当前使用的）
                    val currentlyUsed = items.filter { it.isCurrentlyUsed }
                    val notUsed = items.filter { !it.isCurrentlyUsed }.shuffled()
                    val previewItems = (currentlyUsed + notUsed).take(6)
                    
                    statsMap[category] = AvatarCategoryStats(
                        category = category,
                        count = items.size,
                        previewItems = previewItems
                    )
                }
                
                _avatarCategoryStats.value = statsMap
                Log.d("ChunithmViewModel", "Loaded avatar stats for ${statsMap.size} categories")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error loading avatar category stats", e)
            }
        }
    }

    internal fun loadAllSongsData() {
        val chunithmLocalService = ChunithmObjectBoxService()
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

    fun scrollSongListToTop() {
        _scrollSongListToTopEvent.value = true
    }

    fun updatePageTitle(title: String) {
        _pageTitle.value = title
        _showBackButton.value = true
    }

    fun resetPageTitle() {
        _pageTitle.value = "CHUNITHM"
        _showBackButton.value = false
    }

    fun setOnBackCallback(callback: () -> Unit) {
        onBackCallback = callback
    }

    fun triggerBack() {
        resetPageTitle()
        onBackCallback?.invoke()
    }

    fun resetScrollToTopEvent() {
        _scrollSongListToTopEvent.value = false
    }

    private fun preloadAllScores() {
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Starting preload of all scores...")
                val chunithmLocalService = ChunithmObjectBoxService()
                
                val allScores = chunithmLocalService.getAllScoresMap()
                _allScoresCache.value = allScores
                scoresCacheLoaded = true
                Log.d("ChunithmViewModel", "Preloaded scores for ${allScores.size} songs")
                
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Failed to preload scores: ${e.message}", e)
            }
        }
    }

    fun getScoreFromCache(title: String, diff: String): ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel? {
        return _allScoresCache.value[title]?.get(diff)
    }

    fun getScoresMapForSong(title: String): Map<String, ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel> {
        return _allScoresCache.value[title] ?: emptyMap()
    }

    fun getSheetScoreInfoMapForSong(title: String): Map<String, SheetScoreInfo> {
        // 确保缓存已加载
        if (!scoresCacheLoaded) {
            Log.d("ChunithmViewModel", "Scores cache not loaded yet, returning empty map for $title")
            return emptyMap()
        }
        
        val songScoresMap = _allScoresCache.value[title] ?: return emptyMap()
        
        Log.d("ChunithmViewModel", "Found ${songScoresMap.size} scores for song: $title")
        
        return songScoresMap.mapValues { (difficulty, scoreData) ->
            Log.d("ChunithmViewModel", "Converting score for $title-$difficulty: score=${scoreData.score}")
            SheetScoreInfo(
                score = scoreData.score,
                rank = scoreData.rank,
                clear = scoreData.clear,
                combo = scoreData.combo,
                chain = scoreData.chain
            )
        }
    }

    suspend fun getLatestScoreForSong(title: String, diff: String): ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel? {
        // Try to get from cache first
        if (scoresCacheLoaded) {
            val cachedScore = getScoreFromCache(title, diff)
            if (cachedScore != null) {
                Log.d("ChunithmViewModel", "Found score in cache: $cachedScore")
                return cachedScore
            } else {
                Log.d("ChunithmViewModel", "No score found in cache for $title - $diff")
                return null
            }
        }
        
        // Fallback to individual query if cache not loaded
        Log.d("ChunithmViewModel", "Cache not loaded, falling back to individual query")
        val chunithmLocalService = ChunithmObjectBoxService()
        
        val result = chunithmLocalService.getLatestScoreForSong(title, diff)
        Log.d("ChunithmViewModel", "getLatestScoreForSong result: $result")
        return result
    }

    /**
     * 获取歌曲的友人成绩排行数据
     * @param title 歌曲标题
     * @param diff 难度 (0-4)
     * @return 包含自己和友人成绩的排行列表，按分数降序排列
     */
    suspend fun getFriendScoreRanking(title: String, diff: String): List<FriendScoreRankingItem> {
        val chunithmLocalService = ChunithmObjectBoxService()
        val friendList = chunithmLocalService.getFriendListData()
        val myScore = getLatestScoreForSong(title, diff)
        
        // 将小写难度转换为数据库使用的首字母大写格式
        val difficulty = when (diff) {
            "0" -> "Basic"
            "1" -> "Advanced"
            "2" -> "Expert"
            "3" -> "Master"
            "4" -> "Ultima"
            else -> throw IllegalArgumentException("Invalid difficulty: $diff")
        }
        
        val rankingList = mutableListOf<FriendScoreRankingItem>()
        
        // 添加自己的成绩
        if (myScore != null && myScore.score > 0) {
            rankingList.add(
                FriendScoreRankingItem(
                    friendName = "我",
                    friendCode = "",
                    score = myScore.score,
                    combo = myScore.combo,
                    isMyScore = true
                )
            )
        }
        
        // 添加友人成绩
        for (friend in friendList.filter { it.isFavorite }) {
            val friendScores = chunithmLocalService.getFriendScoreData(friend.friendCode, difficulty)
            val friendScore = friendScores.find { it.title == title }
            if (friendScore != null && friendScore.score > 0) {
                rankingList.add(
                    FriendScoreRankingItem(
                        friendName = friend.friendName,
                        friendCode = friend.friendCode,
                        score = friendScore.score,
                        combo = friendScore.combo,
                        isMyScore = false
                    )
                )
            }
        }
        
        // 按分数降序排列并添加排名
        return rankingList
            .sortedByDescending { it.score }
            .mapIndexed { index, item ->
                item.copy(rank = index + 1)
            }
    }
    
    /**
     * 加载分类统计数据（Difficulty、Genre、Version、Level）
     */
    private fun loadCategoryStats() {
        viewModelScope.launch {
            try {
                Log.d("ChunithmViewModel", "Loading category stats...")
                val chunithmLocalService = ChunithmObjectBoxService()
                
                // 加载 Difficulty 统计
                _difficultyStats.value = calculateDifficultyStats(chunithmLocalService)
                
                // 加载 Genre 统计
                _genreStats.value = calculateGenreStats(chunithmLocalService)
                
                // 加载 Version 统计
                _versionStats.value = calculateVersionStats(chunithmLocalService)
                
                // 加载 Level 统计
                _levelStats.value = calculateLevelStats(chunithmLocalService)
                
                Log.d("ChunithmViewModel", "Category stats loaded: ${_difficultyStats.value.size} difficulties, ${_genreStats.value.size} genres, ${_versionStats.value.size} versions, ${_levelStats.value.size} levels")
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Failed to load category stats: ${e.message}", e)
            }
        }
    }
    
    private suspend fun calculateDifficultyStats(service: ChunithmObjectBoxService): List<PlayDataCategoryStats> {
        return kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            try {
                val difficulties = service.getAllDifficulties()
                val allScores = service.getAllPersonalBestScores()
                val allSheets = service.getAllSheets()
                
                // 难度映射：0=basic, 1=advanced, 2=expert, 3=master, 4=ultima
                val diffMap = mapOf(
                    "basic" to "0",
                    "advanced" to "1",
                    "expert" to "2",
                    "master" to "3",
                    "ultima" to "4"
                )
                
                difficulties.map { difficultyEntity ->
                    val diffKey = difficultyEntity.difficulty
                    val diffNumber = diffMap[diffKey] ?: "0"
                    
                    // 该难度下的所有谱面（只统计国服谱面）
                    val sheetsInDiff = allSheets.filter { it.difficulty == diffKey && it.cn }
                    
                    // 该难度下的所有成绩
                    val scoresInDiff = allScores.filter { it.diff == diffNumber }
                    
                    // 累积计数：>= 该等级的数量（用于UI减法处理）
                    fun countRankOrAbove(target: Int) = scoresInDiff.count { it.rank >= target }
                    // Clear 类型也需要累积计数（CATASTROPHY > ABSOLUTE+ > ABSOLUTE > HARD > CLEAR）
                    val clearLevels = mapOf("clear" to 1, "hard" to 2, "absolute" to 3, "absolute+" to 4, "catastrophy" to 5)
                    fun countClearOrAbove(clearType: String): Int {
                        val targetLevel = clearLevels[clearType] ?: 0
                        return scoresInDiff.count { (clearLevels[it.clear] ?: 0) >= targetLevel }
                    }
                    fun countCombo(comboType: String) = scoresInDiff.count { it.combo == comboType }
                    fun countChain(chainType: String) = scoresInDiff.count { it.chain == chainType }
                    
                    PlayDataCategoryStats(
                        category = PlayDataCategory(
                            type = PlayDataCategoryType.DIFFICULTY,
                            name = difficultyEntity.name,
                            key = diffKey,
                            color = when (diffKey) {
                                "basic" -> com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
                                "advanced" -> com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
                                "expert" -> com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
                                "master" -> com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
                                "ultima" -> com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
                                else -> com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
                            }
                        ),
                        scoreTotal = scoresInDiff.sumOf { it.score.toLong() },
                        totalSongs = sheetsInDiff.size,
                        rateSSSp = countRankOrAbove(13),
                        rateSSS = countRankOrAbove(12),
                        rateSSp = countRankOrAbove(11),
                        rateSS = countRankOrAbove(10),
                        rateSp = countRankOrAbove(9),
                        rateS = countRankOrAbove(8),
                        rateClear = countClearOrAbove("clear"),
                        rateHard = countClearOrAbove("hard"),
                        rateBrave = countClearOrAbove("absolute"),
                        rateAbs = countClearOrAbove("absolute+"),
                        rateCatas = countClearOrAbove("catastrophy"),
                        rateFC = countCombo("fullcombo"),
                        rateAJ = countCombo("alljustice"),
                        rateAJC = countCombo("alljusticecritical"),
                        rateFChain = countChain("fullchain"),
                        rateFChainP = countChain("fullchain2")
                    )
                }
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error calculating difficulty stats: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    private suspend fun calculateGenreStats(service: ChunithmObjectBoxService): List<PlayDataCategoryStats> {
        return kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            try {
                val allSongs = service.getAllSongs()
                val allSheets = service.getAllSheets()
                val allScores = service.getAllPersonalBestScores()
                val categories = service.getAllCategories()
                
                categories.map { categoryEntity ->
                    val genreKey = categoryEntity.category
                    val songsInGenre = allSongs.filter { it.genre == genreKey }
                    // 获取该类型下所有歌曲的所有谱面（考虑多个难度，只统计国服谱面）
                    val songTitles = songsInGenre.map { it.title }.toSet()
                    val sheetsInGenre = allSheets.filter { it.title in songTitles && it.cn }
                    val scoresInGenre = allScores.filter { it.title in songTitles }
                    
                    // 累积计数：>= 该等级的数量（用于UI减法处理）
                    fun countRankOrAbove(target: Int) = scoresInGenre.count { it.rank >= target }
                    // Clear 类型也需要累积计数
                    val clearLevels = mapOf("clear" to 1, "hard" to 2, "absolute" to 3, "absolute+" to 4, "catastrophy" to 5)
                    fun countClearOrAbove(clearType: String): Int {
                        val targetLevel = clearLevels[clearType] ?: 0
                        return scoresInGenre.count { (clearLevels[it.clear] ?: 0) >= targetLevel }
                    }
                    fun countCombo(comboType: String) = scoresInGenre.count { it.combo == comboType }
                    fun countChain(chainType: String) = scoresInGenre.count { it.chain == chainType }
                    
                    PlayDataCategoryStats(
                        category = PlayDataCategory(
                            type = PlayDataCategoryType.GENRE,
                            name = genreKey,
                            key = genreKey
                        ),
                        scoreTotal = scoresInGenre.sumOf { it.score.toLong() },
                        totalSongs = sheetsInGenre.size,
                        rateSSSp = countRankOrAbove(13),
                        rateSSS = countRankOrAbove(12),
                        rateSSp = countRankOrAbove(11),
                        rateSS = countRankOrAbove(10),
                        rateSp = countRankOrAbove(9),
                        rateS = countRankOrAbove(8),
                        rateClear = countClearOrAbove("clear"),
                        rateHard = countClearOrAbove("hard"),
                        rateBrave = countClearOrAbove("absolute"),
                        rateAbs = countClearOrAbove("absolute+"),
                        rateCatas = countClearOrAbove("catastrophy"),
                        rateFC = countCombo("fullcombo"),
                        rateAJ = countCombo("alljustice"),
                        rateAJC = countCombo("alljusticecritical"),
                        rateFChain = countChain("fullchain"),
                        rateFChainP = countChain("fullchain2")
                    )
                }
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error calculating genre stats: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    private suspend fun calculateVersionStats(service: ChunithmObjectBoxService): List<PlayDataCategoryStats> {
        return kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            try {
                val allSongs = service.getAllSongs()
                val allSheets = service.getAllSheets()
                val allScores = service.getAllPersonalBestScores()
                val versions = service.getAllVersions()
                
                versions.map { versionEntity ->
                    val versionKey = versionEntity.version
                    val songsInVersion = allSongs.filter { it.version == versionKey }
                    // 获取该版本下所有歌曲的所有谱面（考虑多个难度，只统计国服谱面）
                    val songTitles = songsInVersion.map { it.title }.toSet()
                    val sheetsInVersion = allSheets.filter { it.title in songTitles && it.cn }
                    val scoresInVersion = allScores.filter { it.title in songTitles }
                    
                    // 累积计数：>= 该等级的数量（用于UI减法处理）
                    fun countRankOrAbove(target: Int) = scoresInVersion.count { it.rank >= target }
                    // Clear 类型也需要累积计数
                    val clearLevels = mapOf("clear" to 1, "hard" to 2, "absolute" to 3, "absolute+" to 4, "catastrophy" to 5)
                    fun countClearOrAbove(clearType: String): Int {
                        val targetLevel = clearLevels[clearType] ?: 0
                        return scoresInVersion.count { (clearLevels[it.clear] ?: 0) >= targetLevel }
                    }
                    fun countCombo(comboType: String) = scoresInVersion.count { it.combo == comboType }
                    fun countChain(chainType: String) = scoresInVersion.count { it.chain == chainType }
                    
                    PlayDataCategoryStats(
                        category = PlayDataCategory(
                            type = PlayDataCategoryType.VERSION,
                            name = versionEntity.abbr,
                            key = versionKey
                        ),
                        scoreTotal = scoresInVersion.sumOf { it.score.toLong() },
                        totalSongs = sheetsInVersion.size,
                        rateSSSp = countRankOrAbove(13),
                        rateSSS = countRankOrAbove(12),
                        rateSSp = countRankOrAbove(11),
                        rateSS = countRankOrAbove(10),
                        rateSp = countRankOrAbove(9),
                        rateS = countRankOrAbove(8),
                        rateClear = countClearOrAbove("clear"),
                        rateHard = countClearOrAbove("hard"),
                        rateBrave = countClearOrAbove("absolute"),
                        rateAbs = countClearOrAbove("absolute+"),
                        rateCatas = countClearOrAbove("catastrophy"),
                        rateFC = countCombo("fullcombo"),
                        rateAJ = countCombo("alljustice"),
                        rateAJC = countCombo("alljusticecritical"),
                        rateFChain = countChain("fullchain"),
                        rateFChainP = countChain("fullchain2")
                    )
                }
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error calculating version stats: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    private suspend fun calculateLevelStats(service: ChunithmObjectBoxService): List<PlayDataCategoryStats> {
        return kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            try {
                val allSheets = service.getAllSheets()
                val allScores = service.getAllPersonalBestScores()
                
                // 定义 Level 范围（分界线为.5，如14.0-14.4是14，14.5-14.9是14+）
                val levelRanges = listOf(
                    "1-5" to (1.0 to 5.9),
                    "6-10" to (6.0 to 10.9),
                    "11-12" to (11.0 to 12.4),
                    "12+" to (12.5 to 12.9),
                    "13" to (13.0 to 13.4),
                    "13+" to (13.5 to 13.9),
                    "14" to (14.0 to 14.4),
                    "14+" to (14.5 to 14.9),
                    "15" to (15.0 to 15.4),
                    "15+" to (15.5 to 15.9)
                )
                
                levelRanges.map { (levelName, range) ->
                    val (minLevel, maxLevel) = range
                    // 只统计国服谱面
                    val sheetsInRange = allSheets.filter { 
                        it.levelValueJp in minLevel..maxLevel && it.cn
                    }
                    val sheetKeys = sheetsInRange.map { "${it.title}_${it.difficulty}" }.toSet()
                    val scoresInRange = allScores.filter { 
                        val diffMap = mapOf("0" to "basic", "1" to "advanced", "2" to "expert", "3" to "master", "4" to "ultima")
                        val scoreDiff = diffMap[it.diff] ?: it.diff
                        "${it.title}_$scoreDiff" in sheetKeys
                    }
                    
                    // 累积计数：>= 该等级的数量（用于UI减法处理）
                    fun countRankOrAbove(target: Int) = scoresInRange.count { it.rank >= target }
                    // Clear 类型也需要累积计数
                    val clearLevels = mapOf("clear" to 1, "hard" to 2, "absolute" to 3, "absolute+" to 4, "catastrophy" to 5)
                    fun countClearOrAbove(clearType: String): Int {
                        val targetLevel = clearLevels[clearType] ?: 0
                        return scoresInRange.count { (clearLevels[it.clear] ?: 0) >= targetLevel }
                    }
                    fun countCombo(comboType: String) = scoresInRange.count { it.combo == comboType }
                    fun countChain(chainType: String) = scoresInRange.count { it.chain == chainType }
                    
                    PlayDataCategoryStats(
                        category = PlayDataCategory(
                            type = PlayDataCategoryType.LEVEL,
                            name = levelName,
                            key = "$minLevel-$maxLevel"
                        ),
                        scoreTotal = scoresInRange.sumOf { it.score.toLong() },
                        totalSongs = sheetsInRange.size,
                        rateSSSp = countRankOrAbove(13),
                        rateSSS = countRankOrAbove(12),
                        rateSSp = countRankOrAbove(11),
                        rateSS = countRankOrAbove(10),
                        rateSp = countRankOrAbove(9),
                        rateS = countRankOrAbove(8),
                        rateClear = countClearOrAbove("clear"),
                        rateHard = countClearOrAbove("hard"),
                        rateBrave = countClearOrAbove("absolute"),
                        rateAbs = countClearOrAbove("absolute+"),
                        rateCatas = countClearOrAbove("catastrophy"),
                        rateFC = countCombo("fullcombo"),
                        rateAJ = countCombo("alljustice"),
                        rateAJC = countCombo("alljusticecritical"),
                        rateFChain = countChain("fullchain"),
                        rateFChainP = countChain("fullchain2")
                    )
                }
            } catch (e: Exception) {
                Log.e("ChunithmViewModel", "Error calculating level stats: ${e.message}", e)
                emptyList()
            }
        }
    }

    /**
     * 友人成绩排行项目数据类
     */
    data class FriendScoreRankingItem(
        val rank: Int = 0,
        val friendName: String = "",
        val friendCode: String = "",
        val score: Int = 0,
        val combo: String = "",
        val isMyScore: Boolean = false
    )
}

class ChuniViewModelFactory(
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChunithmViewModel::class.java)) {
            return ChunithmViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}