package com.madsam.otora.data.chunithm.local.objectbox

import android.util.Log
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.data.chunithm.local.model.ChunithmFriendEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmFriendEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmFriendScoreEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmFriendScoreEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmFullScoreEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmFullScoreEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmPlayRecordEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmPlayRecordEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmSheetsEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmSheetsEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmSongsEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmSongsEntity_
import com.madsam.otora.data.chunithm.remote.model.ChuniAliasesDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniFriendDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniFullScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniJpDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLxnsDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniPlayRecordDTO
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayRecordUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmSheetUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmSongUiModel
import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * ObjectBox版本的Chunithm本地数据服务
 * 与原有的ChunithmLocalService提供相同的接口
 */
internal class ChunithmObjectBoxService {
    
    companion object {
        private const val TAG = "ChunithmObjectBoxService"
    }
    
    private val boxStore = ObjectBoxManager.getBoxStore()
    
    // 获取各种Box实例
    private val scoreBox: Box<ChunithmFullScoreEntity> = boxStore.boxFor(ChunithmFullScoreEntity::class.java)
    private val playRecordBox: Box<ChunithmPlayRecordEntity> = boxStore.boxFor(ChunithmPlayRecordEntity::class.java)
    private val friendScoreBox: Box<ChunithmFriendScoreEntity> = boxStore.boxFor(ChunithmFriendScoreEntity::class.java)
    private val songsBox: Box<ChunithmSongsEntity> = boxStore.boxFor(ChunithmSongsEntity::class.java)
    private val sheetsBox: Box<ChunithmSheetsEntity> = boxStore.boxFor(ChunithmSheetsEntity::class.java)
    private val friendBox: Box<ChunithmFriendEntity> = boxStore.boxFor(ChunithmFriendEntity::class.java)
    
    /**
     * 获取歌曲的最新成绩
     */
    suspend fun getLatestScoreForSong(title: String, difficulty: String): ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel? {
        Log.d(TAG, "getLatestScoreForSong called: title='$title', difficulty='$difficulty'")
        
        return withContext(Dispatchers.IO) {
            try {
                // 将难度字符串转换为数字
                val difficultyNumber = when (difficulty.lowercase()) {
                    "basic" -> "0"
                    "advanced" -> "1"
                    "expert" -> "2"
                    "master" -> "3"
                    "ultima" -> "4"
                    else -> difficulty
                }
                
                val latestScore = scoreBox.query(
                    ChunithmFullScoreEntity_.title.equal(title)
                        .and(ChunithmFullScoreEntity_.diff.equal(difficultyNumber))
                        .and(ChunithmFullScoreEntity_.isPersonalBest.equal(true))
                ).build().findFirst()
                
                latestScore?.let { score ->
                    ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel(
                        songId = score.songId,
                        title = score.title,
                        diff = score.diff,
                        score = score.score,
                        genre = score.genre,
                        clear = score.clear,
                        combo = score.combo,
                        chain = score.chain,
                        rank = score.rank,
                        jacket = score.jacket,
                        date = score.date,
                        trackNumber = score.trackNumber,
                        genreName = score.genreName,
                        difficulty = score.difficulty
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get latest score: ${e.message}", e)
                null
            }
        }
    }
    
    /**
     * 批量获取所有成绩数据的映射
     */
    suspend fun getAllScoresMap(): Map<String, Map<String, ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel>> {
        Log.d(TAG, "getAllScoresMap called - batch loading all scores")
        return withContext(Dispatchers.IO) {
            try {
                val allScores = scoreBox.query(
                    ChunithmFullScoreEntity_.isPersonalBest.equal(true)
                ).build().find()
                
                Log.d(TAG, "Loaded ${allScores.size} personal best scores from ObjectBox")
                
                val scoresMap = mutableMapOf<String, MutableMap<String, ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel>>()
                
                allScores.forEach { scoreEntity ->
                    val scoreUiModel = ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel(
                        songId = scoreEntity.songId,
                        title = scoreEntity.title,
                        diff = scoreEntity.diff,
                        score = scoreEntity.score,
                        genre = scoreEntity.genre,
                        clear = scoreEntity.clear,
                        combo = scoreEntity.combo,
                        chain = scoreEntity.chain,
                        rank = scoreEntity.rank,
                        jacket = scoreEntity.jacket,
                        date = scoreEntity.date,
                        trackNumber = scoreEntity.trackNumber,
                        genreName = scoreEntity.genreName,
                        difficulty = scoreEntity.difficulty
                    )
                    
                    // 转换数字难度为字符串
                    val difficultyString = when (scoreEntity.diff) {
                        "0" -> "basic"
                        "1" -> "advanced"
                        "2" -> "expert"
                        "3" -> "master"
                        "4" -> "ultima"
                        else -> scoreEntity.diff
                    }
                    
                    if (!scoresMap.containsKey(scoreEntity.title)) {
                        scoresMap[scoreEntity.title] = mutableMapOf()
                    }
                    scoresMap[scoreEntity.title]!![difficultyString] = scoreUiModel
                }
                
                scoresMap.mapValues { it.value.toMap() }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get all scores: ${e.message}", e)
                emptyMap()
            }
        }
    }
    
    /**
     * 获取歌曲数据
     */
    suspend fun getChunithmSongData(title: String): ChunithmSongsEntity {
        return withContext(Dispatchers.IO) {
            try {
                songsBox.query(
                    ChunithmSongsEntity_.title.equal(title)
                ).build().findFirst() ?: ChunithmSongsEntity()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get song data: ${e.message}", e)
                ChunithmSongsEntity()
            }
        }
    }
    
    /**
     * 获取歌曲谱面数据
     */
    suspend fun getChunithmSongSheetData(title: String, difficulty: String): ChunithmSheetsEntity {
        return withContext(Dispatchers.IO) {
            try {
                sheetsBox.query(
                    ChunithmSheetsEntity_.title.equal(title)
                        .and(ChunithmSheetsEntity_.difficulty.equal(difficulty))
                ).build().findFirst() ?: ChunithmSheetsEntity()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get sheet data: ${e.message}", e)
                ChunithmSheetsEntity()
            }
        }
    }
    
    /**
     * 获取歌曲的成绩历史
     */
    suspend fun getScoreHistoryForSong(title: String, difficulty: String): List<ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel> {
        Log.d(TAG, "getScoreHistoryForSong called: title='$title', difficulty='$difficulty'")
        
        return withContext(Dispatchers.IO) {
            try {
                val difficultyNumber = when (difficulty.lowercase()) {
                    "basic" -> "0"
                    "advanced" -> "1"
                    "expert" -> "2"
                    "master" -> "3"
                    "ultima" -> "4"
                    else -> difficulty
                }
                
                val historyRecords = scoreBox.query(
                    ChunithmFullScoreEntity_.title.equal(title)
                        .and(ChunithmFullScoreEntity_.diff.equal(difficultyNumber))
                ).build().find()
                
                historyRecords.map { scoreEntity ->
                    ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel(
                        songId = scoreEntity.songId,
                        title = scoreEntity.title,
                        diff = scoreEntity.diff,
                        score = scoreEntity.score,
                        genre = scoreEntity.genre,
                        clear = scoreEntity.clear,
                        combo = scoreEntity.combo,
                        chain = scoreEntity.chain,
                        rank = scoreEntity.rank,
                        jacket = scoreEntity.jacket,
                        date = scoreEntity.date,
                        trackNumber = scoreEntity.trackNumber,
                        genreName = scoreEntity.genreName,
                        difficulty = scoreEntity.difficulty
                    )
                }.sortedBy { it.date } // 按日期排序
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get score history: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取游戏记录UI模型
     */
    suspend fun getPlayRecordUiModel(difficulty: String): ChunithmPlayRecordUiModel? {
        return withContext(Dispatchers.IO) {
            try {
                val playRecord = playRecordBox.query(
                    ChunithmPlayRecordEntity_.difficulty.equal(difficulty)
                ).build().findFirst()
                
                playRecord?.let { record ->
                    val scores = scoreBox.query(
                        ChunithmFullScoreEntity_.difficulty.equal(difficulty)
                            .and(ChunithmFullScoreEntity_.isPersonalBest.equal(true))
                    ).build().find()
                    
                    ChunithmPlayRecordUiModel(
                        difficulty = record.id.toString(),
                        rateSSSp = Pair(record.rateSSSpCount, record.rateSSSpTotal),
                        rateSSS = Pair(record.rateSSSCount, record.rateSSSTotal),
                        rateSSp = Pair(record.rateSSPCount, record.rateSSPTotal),
                        rateSS = Pair(record.rateSSCount, record.rateSSTotal),
                        rateSp = Pair(record.rateSpCount, record.rateSpTotal),
                        rateS = Pair(record.rateSCount, record.rateSTotal),
                        rateClear = Pair(record.rateClearCount, record.rateClearTotal),
                        rateFC = Pair(record.rateFCCount, record.rateFCTotal),
                        rateAJ = Pair(record.rateAJCount, record.rateAJTotal),
                        rateAJC = Pair(record.rateAJCCount, record.rateAJCTotal),
                        rateFChain = Pair(record.rateFChainCount, record.rateFChainTotal),
                        rateFChainP = Pair(record.rateFChainPCount, record.rateFChainPTotal),
                        rateHard = Pair(record.rateHardCount, record.rateHardTotal),
                        rateAbs = Pair(record.rateAbsCount, record.rateAbsTotal),
                        rateAbsP = Pair(record.rateAbsPCount, record.rateAbsPTotal),
                        rateCatas = Pair(record.rateCatasCount, record.rateCatasTotal),
                        lastUpdated = record.lastUpdated,
                        scores = scores.map { scoreEntity ->
                            ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel(
                                songId = scoreEntity.songId,
                                title = scoreEntity.title,
                                diff = scoreEntity.diff,
                                score = scoreEntity.score,
                                genre = scoreEntity.genre,
                                clear = scoreEntity.clear,
                                combo = scoreEntity.combo,
                                chain = scoreEntity.chain,
                                rank = scoreEntity.rank,
                                jacket = scoreEntity.jacket,
                                date = scoreEntity.date,
                                trackNumber = scoreEntity.trackNumber,
                                genreName = scoreEntity.genreName,
                                difficulty = scoreEntity.difficulty
                            )
                        }
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get play record UI model: ${e.message}", e)
                null
            }
        }
    }
    
    /**
     * 获取友人列表数据
     */
    suspend fun getFriendListData(): List<ChuniFriendDTO> {
        return withContext(Dispatchers.IO) {
            try {
                friendBox.all.map { entity ->
                    ChuniFriendDTO(
                        friendCode = entity.friendCode,
                        friendName = entity.friendName,
                        profileBackground = entity.profileBackground,
                        reborn = entity.reborn,
                        level = entity.level,
                        rating = entity.rating,
                        ratingMax = entity.ratingMax,
                        overpower = entity.overpower,
                        lastPlay = entity.lastPlay,
                        roleImageUrl = entity.roleImageUrl,
                        roleBase = entity.roleBase,
                        honorText = entity.honorText,
                        honorBase = entity.honorBase,
                        isFavorite = entity.isFavorite,
                        isScored = entity.isScored,
                        classEmblemBase = entity.classEmblemBase,
                        classEmblemTop = entity.classEmblemTop
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get friend list: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取所有歌曲数据
     */
    suspend fun getAllSongData(): List<ChunithmSongUiModel> {
        return withContext(Dispatchers.IO) {
            try {
                val songs = songsBox.all
                songs.map { song ->
                    // 获取这首歌的所有谱面数据
                    val sheets = sheetsBox.query(
                        ChunithmSheetsEntity_.title.equal(song.title)
                    ).build().find()
                    
                    val sheetData = sheets.map { sheetEntity ->
                        ChunithmSheetUiModel(
                            title = sheetEntity.title,
                            type = sheetEntity.type,
                            difficulty = sheetEntity.difficulty,
                            levelJp = sheetEntity.levelJp,
                            levelValueJp = sheetEntity.levelValueJp,
                            internalLevelJp = sheetEntity.internalLevelJp,
                            internalLevelValueJp = sheetEntity.internalLevelValueJp,
                            levelCn = sheetEntity.levelCn,
                            levelValueCn = sheetEntity.levelValueCn,
                            noteDesigner = sheetEntity.noteDesigner,
                            tap = sheetEntity.tap,
                            hold = sheetEntity.hold,
                            slide = sheetEntity.slide,
                            air = sheetEntity.air,
                            flick = sheetEntity.flick,
                            total = sheetEntity.total,
                            jp = sheetEntity.jp,
                            intl = sheetEntity.intl,
                            cn = sheetEntity.cn,
                            isSpecial = sheetEntity.isSpecial
                        )
                    }
                    
                    ChunithmSongUiModel(
                        genre = song.genre,
                        title = song.title,
                        artist = song.artist,
                        bpm = song.bpm,
                        imageName = song.imageName,
                        version = song.version,
                        releaseDate = song.releaseDate,
                        isNew = song.isNew,
                        isLocked = song.isLocked,
                        comment = song.comment,
                        cnId = song.cnId,
                        map = song.map,
                        aliases = song.aliases,
                        sheets = sheetData
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get all song data: ${e.message}", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取友人分数对比数据
     */
    suspend fun getFriendScoreData(friendCode: String, difficulty: String): List<ChunithmFriendScoreEntity> {
        return withContext(Dispatchers.IO) {
            try {
                friendScoreBox.query(
                    ChunithmFriendScoreEntity_.friendCode.equal(friendCode)
                        .and(ChunithmFriendScoreEntity_.difficulty.equal(difficulty))
                ).build().find()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get friend score data: ${e.message}", e)
                emptyList()
            }
        }
    }

    /**
     * 获取游戏记录数据
     */
    suspend fun getPlayRecordData(difficulty: String): ChunithmPlayRecordEntity? {
        return withContext(Dispatchers.IO) {
            try {
                playRecordBox.query(
                    ChunithmPlayRecordEntity_.difficulty.equal(difficulty)
                ).build().findFirst()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get play record data: ${e.message}", e)
                null
            }
        }
    }

    /**
     * 获取某个难度的所有成绩
     */
    suspend fun getFullScoresByDifficulty(difficulty: String): List<ChunithmFullScoreEntity> {
        return withContext(Dispatchers.IO) {
            try {
                scoreBox.query(
                    ChunithmFullScoreEntity_.difficulty.equal(difficulty)
                        .and(ChunithmFullScoreEntity_.isPersonalBest.equal(true))
                ).build().find()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get full scores by difficulty: ${e.message}", e)
                emptyList()
            }
        }
    }

    /**
     * 获取所有友人的分数对比数据（用于好友页面展示）
     */
    suspend fun getAllFriendsScoreData(): Map<String, Map<String, List<ChunithmFriendScoreEntity>>> {
        return withContext(Dispatchers.IO) {
            try {
                val entities = friendScoreBox.all
                val result = mutableMapOf<String, MutableMap<String, MutableList<ChunithmFriendScoreEntity>>>()
                
                entities.forEach { entity ->
                    val friendCode = entity.friendCode
                    val difficulty = entity.difficulty
                    
                    if (!result.containsKey(friendCode)) {
                        result[friendCode] = mutableMapOf()
                    }
                    if (!result[friendCode]!!.containsKey(difficulty)) {
                        result[friendCode]!![difficulty] = mutableListOf()
                    }
                    
                    result[friendCode]!![difficulty]!!.add(entity)
                }
                
                result.mapValues { it.value.mapValues { diffEntry -> diffEntry.value.toList() }.toMap() }.toMap()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get all friends score data: ${e.message}", e)
                emptyMap()
            }
        }
    }

    /**
     * 根据友人代码获取特定友人数据
     */
    suspend fun getFriendData(friendCode: String): ChuniFriendDTO? {
        return withContext(Dispatchers.IO) {
            try {
                val entity = friendBox.query(
                    ChunithmFriendEntity_.friendCode.equal(friendCode)
                ).build().findFirst()
                
                entity?.let {
                    ChuniFriendDTO(
                        friendCode = it.friendCode,
                        friendName = it.friendName,
                        profileBackground = it.profileBackground,
                        reborn = it.reborn,
                        level = it.level,
                        rating = it.rating,
                        ratingMax = it.ratingMax,
                        overpower = it.overpower,
                        lastPlay = it.lastPlay,
                        roleImageUrl = it.roleImageUrl,
                        roleBase = it.roleBase,
                        honorText = it.honorText,
                        honorBase = it.honorBase,
                        isFavorite = it.isFavorite,
                        isScored = it.isScored,
                        classEmblemBase = it.classEmblemBase,
                        classEmblemTop = it.classEmblemTop
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get friend data for $friendCode: ${e.message}", e)
                null
            }
        }
    }

    suspend fun savePlayRecordData(playRecordData: ChuniPlayRecordDTO, diff: String) {
        withContext(Dispatchers.IO) {
            try {
                val currentTime = System.currentTimeMillis().toString()
                
                // Save play record statistics
                val existingRecord = playRecordBox.query(
                    ChunithmPlayRecordEntity_.difficulty.equal(diff)
                ).build().findFirst()
                
                val playRecordEntity = (existingRecord ?: ChunithmPlayRecordEntity()).apply {
                    difficulty = diff
                    
                    // Rating statistics
                    playRecordData.rateSSSp.let {
                        rateSSSpCount = it.first
                        rateSSSpTotal = it.second
                    }
                    playRecordData.rateSSS.let {
                        rateSSSCount = it.first
                        rateSSSTotal = it.second
                    }
                    playRecordData.rateSSp.let {
                        rateSSPCount = it.first
                        rateSSPTotal = it.second
                    }
                    playRecordData.rateSS.let {
                        rateSSCount = it.first
                        rateSSTotal = it.second
                    }
                    playRecordData.rateSp.let {
                        rateSpCount = it.first
                        rateSpTotal = it.second
                    }
                    playRecordData.rateS.let {
                        rateSCount = it.first
                        rateSTotal = it.second
                    }
                    
                    // Clear statistics
                    playRecordData.rateClear.let {
                        rateClearCount = it.first
                        rateClearTotal = it.second
                    }
                    playRecordData.rateFC.let {
                        rateFCCount = it.first
                        rateFCTotal = it.second
                    }
                    playRecordData.rateAJ.let {
                        rateAJCount = it.first
                        rateAJTotal = it.second
                    }
                    playRecordData.rateAJC.let {
                        rateAJCCount = it.first
                        rateAJCTotal = it.second
                    }
                    playRecordData.rateFChain.let {
                        rateFChainCount = it.first
                        rateFChainTotal = it.second
                    }
                    playRecordData.rateFChainP.let {
                        rateFChainPCount = it.first
                        rateFChainPTotal = it.second
                    }
                    
                    // Difficulty statistics
                    playRecordData.rateHard.let {
                        rateHardCount = it.first
                        rateHardTotal = it.second
                    }
                    playRecordData.rateAbs.let {
                        rateAbsCount = it.first
                        rateAbsTotal = it.second
                    }
                    playRecordData.rateAbsP.let {
                        rateAbsPCount = it.first
                        rateAbsPTotal = it.second
                    }
                    playRecordData.rateCatas.let {
                        rateCatasCount = it.first
                        rateCatasTotal = it.second
                    }
                    
                    lastUpdated = currentTime
                }
                playRecordBox.put(playRecordEntity)
                
                // Save genre and score data with intelligent historical tracking
                playRecordData.genreList.forEach { genre ->
                    genre.fullScoreList.forEach { score ->
                        val newScore = score.score.replace(",", "").toIntOrNull() ?: 0
                        
                        // Find the current personal best for this song+difficulty
                        val currentBest = scoreBox.query(
                            ChunithmFullScoreEntity_.songId.equal(score.id.toLong())
                                .and(ChunithmFullScoreEntity_.diff.equal(score.diff))
                                .and(ChunithmFullScoreEntity_.difficulty.equal(diff))
                                .and(ChunithmFullScoreEntity_.isPersonalBest.equal(true))
                        ).build().findFirst()
                        
                        // Determine if we should save this record
                        val shouldSaveRecord = if (currentBest == null) {
                            // No previous record - always save
                            true
                        } else {
                            // Save if any of these conditions are met:
                            newScore > currentBest.score ||  // Better score
                            currentBest.clear != score.clear ||  // Clear status improved
                            currentBest.combo != score.combo ||  // Combo status improved
                            currentBest.chain != score.chain ||  // Chain status improved
                            currentBest.rank != score.rank  // Rank improved
                        }
                        
                        if (shouldSaveRecord) {
                            // Mark old personal best as no longer current
                            currentBest?.let { oldBest ->
                                oldBest.isPersonalBest = false
                                scoreBox.put(oldBest)
                            }
                            
                            // Create new record with timestamp-based ID for uniqueness
                            val scoreEntity = ChunithmFullScoreEntity().apply {
                                songId = score.id
                                title = score.title
                                this.diff = score.diff
                                this.score = newScore
                                this.genre = score.genre
                                token = score.token
                                clear = score.clear
                                combo = score.combo
                                chain = score.chain
                                rank = score.rank
                                jacket = score.jacket
                                date = score.date
                                trackNumber = score.trackNumber
                                genreName = genre.name
                                difficulty = diff
                                recordedAt = currentTime
                                isPersonalBest = true  // This is now the current personal best
                            }
                            scoreBox.put(scoreEntity)
                        }
                    }
                }
                
                Log.i(TAG, "Successfully saved play record data for difficulty: $diff")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save play record data: ${e.message}", e)
            }
        }
    }

    suspend fun saveFriendListData(friendListData: List<ChuniFriendDTO>) {
        withContext(Dispatchers.IO) {
            try {
                // Clear existing friend list
                friendBox.removeAll()
                
                val currentTime = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault())
                    .format(java.util.Date())
                
                for (friendDto in friendListData) {
                    val entity = ChunithmFriendEntity().apply {
                        friendCode = friendDto.friendCode
                        friendName = friendDto.friendName
                        profileBackground = friendDto.profileBackground
                        reborn = friendDto.reborn
                        level = friendDto.level
                        rating = friendDto.rating
                        ratingMax = friendDto.ratingMax
                        overpower = friendDto.overpower
                        lastPlay = friendDto.lastPlay
                        roleImageUrl = friendDto.roleImageUrl
                        roleBase = friendDto.roleBase
                        honorText = friendDto.honorText
                        honorBase = friendDto.honorBase
                        isFavorite = friendDto.isFavorite
                        isScored = friendDto.isScored
                        classEmblemBase = friendDto.classEmblemBase
                        classEmblemTop = friendDto.classEmblemTop
                    }
                    friendBox.put(entity)
                }
                Log.d(TAG, "Successfully saved ${friendListData.size} friends to ObjectBox")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save friend list data: ${e.message}", e)
            }
        }
    }

    suspend fun saveFriendScoreData(friendScoreData: List<ChuniFullScoreDTO>, friendCode: String, diffName: String) {
        withContext(Dispatchers.IO) {
            try {
                // Remove existing scores for this friend and difficulty
                val existingScores = friendScoreBox.query(
                    ChunithmFriendScoreEntity_.friendCode.equal(friendCode)
                        .and(ChunithmFriendScoreEntity_.difficulty.equal(diffName))
                ).build().find()
                friendScoreBox.remove(existingScores)

                val currentTime = System.currentTimeMillis().toString()
                var savedCount = 0
                
                for (scoreDto in friendScoreData) {
                    try {
                        // 使用友人代码+曲名+难度作为唯一标识
                        val entity = ChunithmFriendScoreEntity().apply {
                            this.friendCode = friendCode
                            title = scoreDto.title
                            score = scoreDto.score.replace(",", "").toIntOrNull() ?: 0
                            combo = scoreDto.combo // 只保存友人成绩页面中有意义的字段
                            difficulty = diffName
                            recordedAt = currentTime
                            uniqueKey = "${friendCode}_${scoreDto.title}_${diffName}"
                        }
                        friendScoreBox.put(entity)
                        savedCount++
                    } catch (e: Exception) {
                        Log.e(TAG, "Failed to save individual record (${scoreDto.title}): ${e.message}", e)
                    }
                }
                Log.i(TAG, "Successfully saved $savedCount friend scores for $friendCode ($diffName)")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save friend score data: ${e.message}", e)
            }
        }
    }

    suspend fun saveJPAndLxnsSongsData(chunithmJpDTO: ChuniJpDTO, chunithmLxnsDTO: ChuniLxnsDTO, chunithmAliasesDTO: ChuniAliasesDTO) {
        withContext(Dispatchers.IO) {
            try {
                // Clear existing songs and sheets
                songsBox.removeAll()
                sheetsBox.removeAll()

                // 处理 Lxns 和别名数据映射
                val chunithmSongsLMapI = mutableMapOf<Int, ChuniLxnsDTO.ChuniSong>()
                for (song in chunithmLxnsDTO.songs) {
                    val chunithmSong = ChuniLxnsDTO.ChuniSong().apply {
                        id = song.id
                        genre = song.genre
                        title = song.title
                        artist = song.artist
                        bpm = song.bpm
                        map = song.map
                        version = song.version
                        difficulties = song.difficulties
                    }
                    chunithmSongsLMapI[song.id] = chunithmSong
                }
                
                val chunithmAliasMapI = mutableMapOf<Int, ChuniAliasesDTO.ChuniAlias>()
                for (alias in chunithmAliasesDTO.aliases) {
                    val chunithmAliasData = ChuniAliasesDTO.ChuniAlias().apply {
                        id = alias.id
                        aliases = alias.aliases
                    }
                    chunithmAliasMapI[alias.id] = chunithmAliasData
                }
                
                // 为 Lxns 数据添加别名
                for (song in chunithmLxnsDTO.songs) {
                    val chunithmSong = chunithmSongsLMapI[song.id]
                    val chunithmAliasData = chunithmAliasMapI[song.id]
                    if (chunithmSong != null && chunithmAliasData != null) {
                        chunithmSong.aliases = chunithmAliasData.aliases.joinToString(",")
                    }
                    song.aliases = chunithmSong?.aliases ?: ""
                }

                // 处理 JP 歌曲映射
                val chunithmSongsZMap = mutableMapOf<String, ChuniJpDTO.ChuniSong>()
                for (song in chunithmJpDTO.songs) {
                    val chunithmSong = ChuniJpDTO.ChuniSong().apply {
                        songId = song.songId
                        category = song.category
                        title = song.title
                        artist = song.artist
                        bpm = song.bpm
                        imageName = song.imageName
                        version = song.version
                        releaseDate = song.releaseDate
                        isNew = song.isNew
                        isLocked = song.isLocked
                        comment = song.comment
                        sheets = song.sheets
                    }
                    chunithmSongsZMap[song.songId] = chunithmSong
                }

                // 处理 Lxns 歌曲按标题映射
                val chunithmSongsLMapT = mutableMapOf<String, ChuniLxnsDTO.ChuniSong>()
                for (song in chunithmLxnsDTO.songs) {
                    if (song.difficulties.size == 1) {
                        song.title = "(WE) ${song.title}"
                    }
                    val chunithmSong = ChuniLxnsDTO.ChuniSong().apply {
                        id = song.id
                        genre = song.genre
                        title = song.title
                        artist = song.artist
                        bpm = song.bpm
                        map = song.map
                        version = song.version
                        difficulties = song.difficulties
                        aliases = song.aliases
                    }
                    chunithmSongsLMapT[song.title] = chunithmSong
                }

                // 保存歌曲数据
                for (song in chunithmJpDTO.songs) {
                    val chuniSongZ = chunithmSongsZMap[song.songId]
                    val chuniSongL = chunithmSongsLMapT[song.songId]
                    if (chuniSongZ == null) {
                        Log.e(TAG, "Failed to get the song data from ChuniJp")
                        continue
                    }

                    val chuniSongData = ChunithmSongsEntity().apply {
                        songId = chuniSongZ.songId
                        genre = chuniSongZ.category
                        title = chuniSongZ.title
                        artist = chuniSongZ.artist
                        bpm = chuniSongZ.bpm
                        imageName = chuniSongZ.imageName
                        version = chuniSongZ.version
                        releaseDate = chuniSongZ.releaseDate
                        isNew = chuniSongZ.isNew
                        isLocked = chuniSongZ.isLocked
                        comment = chuniSongZ.comment
                        cnId = chuniSongL?.id ?: -1
                        map = chuniSongL?.map ?: "-"
                        aliases = chuniSongL?.aliases ?: ""
                    }
                    songsBox.put(chuniSongData)

                    // 保存谱面数据
                    for (sheet in chuniSongZ.sheets) {
                        val chuniSheetL = if (chuniSongL == null) {
                            null
                        } else {
                            val difficultyIndex = when (sheet.difficulty) {
                                "basic" -> 0
                                "advanced" -> 1
                                "expert" -> 2
                                "master" -> 3
                                "ultima" -> 4
                                "we" -> 0
                                else -> 0
                            }
                            chuniSongL.difficulties.getOrNull(difficultyIndex) ?: run {
                                if (sheet.difficulty == "ultima") {
                                    Log.i(TAG, "No Ultima data found for ${chuniSongL.title}")
                                }
                                null
                            }
                        }

                        // 正确判断CN地区的存在性
                        val cnExists = if (chuniSongL == null) {
                            false // 如果CN数据本身不存在，则该曲目在CN不存在
                        } else {
                            when (sheet.difficulty) {
                                "basic", "advanced", "expert", "master" -> {
                                    // 基础四难度：只要CN数据存在，这些难度就存在
                                    true
                                }
                                "ultima" -> {
                                    // ULTIMA难度：需要检查CN数据中是否真的有ULTIMA难度
                                    chuniSheetL != null
                                }
                                "we" -> {
                                    // World's End：需要检查CN数据中是否有对应的WE难度
                                    chuniSheetL != null
                                }
                                else -> chuniSheetL != null
                            }
                        }

                        val chuniSheetData = ChunithmSheetsEntity().apply {
                            title = chuniSongZ.title
                            type = sheet.type
                            difficulty = sheet.difficulty
                            levelJp = sheet.level
                            levelValueJp = sheet.levelValue
                            internalLevelJp = sheet.internalLevel
                            internalLevelValueJp = sheet.internalLevelValue
                            levelCn = chuniSheetL?.level ?: ""
                            levelValueCn = chuniSheetL?.levelValue ?: 0.0
                            noteDesigner = chuniSheetL?.noteDesigner ?: sheet.noteDesigner
                            tap = sheet.noteCounts.tap
                            hold = sheet.noteCounts.hold
                            slide = sheet.noteCounts.slide
                            air = sheet.noteCounts.air
                            flick = sheet.noteCounts.flick
                            total = sheet.noteCounts.total
                            jp = sheet.regions.jp
                            intl = sheet.regions.intl
                            cn = cnExists
                            isSpecial = sheet.isSpecial
                        }
                        sheetsBox.put(chuniSheetData)
                    }
                }
                
                Log.i(TAG, "Successfully saved ${chunithmJpDTO.songs.size} JP songs with complete CN integration")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save songs data: ${e.message}", e)
            }
        }
    }
}
