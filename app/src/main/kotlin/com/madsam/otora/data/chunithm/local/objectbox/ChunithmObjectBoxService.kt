package com.madsam.otora.data.chunithm.local.objectbox

import android.util.Log
import com.madsam.otora.core.database.ObjectBoxManager
import com.madsam.otora.data.chunithm.local.model.ChunithmAvatarItemEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmAvatarItemEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmCategoryEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmCharacterEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmCharacterEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmDailyRewardEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmDailyRewardEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmDifficultyEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmFriendEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmFriendEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmFriendScoreEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmFriendScoreEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmFullScoreEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmFullScoreEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmLoginBonusEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmMapAreaEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmMapAreaEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmMapEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmMapEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmMonthlyRewardEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmMonthlyRewardEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmPlayLogEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmPlayLogEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmPlayRecordEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmPlayRecordEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmRatingEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmRatingEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmRegionEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmSheetsEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmSheetsEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmSongsEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmSongsEntity_
import com.madsam.otora.data.chunithm.local.model.ChunithmTypeEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmVersionEntity
import com.madsam.otora.data.chunithm.local.model.ChunithmWeekdayBonusEntity
import com.madsam.otora.data.chunithm.remote.model.ChunithmFriendDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmFullScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmMapDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmPlayRecordDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmDataDTO
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayRecordUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmSheetUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmSongUiModel
import io.objectbox.Box
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class ChunithmObjectBoxService {
    
    companion object {
        private const val TAG = "ChunithmObjectBoxService"
    }
    
    private val boxStore = ObjectBoxManager.getBoxStore()
    
    // 获取各种Box实例
    private val scoreBox: Box<ChunithmFullScoreEntity> = boxStore.boxFor(ChunithmFullScoreEntity::class.java)
    private val playRecordBox: Box<ChunithmPlayRecordEntity> = boxStore.boxFor(ChunithmPlayRecordEntity::class.java)
    private val playLogBox: Box<ChunithmPlayLogEntity> = boxStore.boxFor(ChunithmPlayLogEntity::class.java)
    private val friendScoreBox: Box<ChunithmFriendScoreEntity> = boxStore.boxFor(ChunithmFriendScoreEntity::class.java)
    private val songsBox: Box<ChunithmSongsEntity> = boxStore.boxFor(ChunithmSongsEntity::class.java)
    private val sheetsBox: Box<ChunithmSheetsEntity> = boxStore.boxFor(ChunithmSheetsEntity::class.java)
    private val friendBox: Box<ChunithmFriendEntity> = boxStore.boxFor(ChunithmFriendEntity::class.java)
    private val ratingBox: Box<ChunithmRatingEntity> = boxStore.boxFor(ChunithmRatingEntity::class.java)
    private val mapBox: Box<ChunithmMapEntity> = boxStore.boxFor(ChunithmMapEntity::class.java)
    private val mapAreaBox: Box<ChunithmMapAreaEntity> = boxStore.boxFor(ChunithmMapAreaEntity::class.java)
    private val characterBox: Box<ChunithmCharacterEntity> = boxStore.boxFor(ChunithmCharacterEntity::class.java)
    private val loginBonusBox: Box<ChunithmLoginBonusEntity> = boxStore.boxFor(ChunithmLoginBonusEntity::class.java)
    private val monthlyRewardBox: Box<ChunithmMonthlyRewardEntity> = boxStore.boxFor(ChunithmMonthlyRewardEntity::class.java)
    private val dailyRewardBox: Box<ChunithmDailyRewardEntity> = boxStore.boxFor(ChunithmDailyRewardEntity::class.java)
    private val weekdayBonusBox: Box<ChunithmWeekdayBonusEntity> = boxStore.boxFor(ChunithmWeekdayBonusEntity::class.java)
    private val avatarItemBox: Box<ChunithmAvatarItemEntity> = boxStore.boxFor(ChunithmAvatarItemEntity::class.java)
    
    // 元数据 Box
    private val categoryBox: Box<ChunithmCategoryEntity> = boxStore.boxFor(ChunithmCategoryEntity::class.java)
    private val versionBox: Box<ChunithmVersionEntity> = boxStore.boxFor(ChunithmVersionEntity::class.java)
    private val typeBox: Box<ChunithmTypeEntity> = boxStore.boxFor(ChunithmTypeEntity::class.java)
    private val difficultyBox: Box<ChunithmDifficultyEntity> = boxStore.boxFor(ChunithmDifficultyEntity::class.java)
    private val regionBox: Box<ChunithmRegionEntity> = boxStore.boxFor(ChunithmRegionEntity::class.java)
    
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
                        date = score.date,
                        trackNumber = score.trackNumber,
                        genreName = score.genreName
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
                        date = scoreEntity.date,
                        trackNumber = scoreEntity.trackNumber,
                        genreName = scoreEntity.genreName
                    )
                    
                    if (!scoresMap.containsKey(scoreEntity.title)) {
                        scoresMap[scoreEntity.title] = mutableMapOf()
                    }
                    scoresMap[scoreEntity.title]!![scoreEntity.diff] = scoreUiModel
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
    suspend fun getScoreHistoryForSong(title: String, diff: String): List<ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel> {
        Log.d(TAG, "getScoreHistoryForSong called: title='$title', difficulty='$diff'")
        
        return withContext(Dispatchers.IO) {
            try {
                val historyRecords = scoreBox.query(
                    ChunithmFullScoreEntity_.title.equal(title)
                        .and(ChunithmFullScoreEntity_.diff.equal(diff))
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
                        date = scoreEntity.date,
                        trackNumber = scoreEntity.trackNumber,
                        genreName = scoreEntity.genreName
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
    suspend fun getPlayRecordUiModel(diff: String): ChunithmPlayRecordUiModel? {
        val difficulty = when(diff) {
            "0" -> "Basic"
            "1" -> "Advanced"
            "2" -> "Expert"
            "3" -> "Master"
            "4" -> "Ultima"
            else -> diff
        }
        return withContext(Dispatchers.IO) {
            try {
                val playRecord = playRecordBox.query(
                    ChunithmPlayRecordEntity_.difficulty.equal(difficulty)
                ).build().findFirst()
                
                playRecord?.let { record ->
                    val scores = scoreBox.query(
                        ChunithmFullScoreEntity_.diff.equal(diff)
                            .and(ChunithmFullScoreEntity_.isPersonalBest.equal(true))
                    ).build().find()
                    
                    ChunithmPlayRecordUiModel(
                        difficulty = record.id.toString(),
                        totalSongs = record.rateSSSpTotal, // 使用任意一个Total字段作为总数
                        rateSSSp = record.rateSSSpCount,
                        rateSSS = record.rateSSSCount,
                        rateSSp = record.rateSSPCount,
                        rateSS = record.rateSSCount,
                        rateSp = record.rateSpCount,
                        rateS = record.rateSCount,
                        rateClear = record.rateClearCount,
                        rateFC = record.rateFCCount,
                        rateAJ = record.rateAJCount,
                        rateAJC = record.rateAJCCount,
                        rateFChain = record.rateFChainCount,
                        rateFChainP = record.rateFChainPCount,
                        rateHard = record.rateHardCount,
                        rateBrave = record.rateBraveCount,
                        rateAbs = record.rateAbsCount,
                        rateCatas = record.rateCatasCount,
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
                                date = scoreEntity.date,
                                trackNumber = scoreEntity.trackNumber,
                                genreName = scoreEntity.genreName
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
    suspend fun getFriendListData(): List<ChunithmFriendDTO> {
        return withContext(Dispatchers.IO) {
            try {
                friendBox.all.map { entity ->
                    ChunithmFriendDTO(
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
     * 获取某个难度的所有成绩
     */
    suspend fun getFullScoresByDifficulty(difficulty: String): List<ChunithmFullScoreEntity> {
        return withContext(Dispatchers.IO) {
            try {
                scoreBox.query(
                    ChunithmFullScoreEntity_.diff.equal(difficulty)
                        .and(ChunithmFullScoreEntity_.isPersonalBest.equal(true))
                ).build().find()
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get full scores by difficulty: ${e.message}", e)
                emptyList()
            }
        }
    }

    /**
     * 根据友人代码获取特定友人数据
     */
    suspend fun getFriendData(friendCode: String): ChunithmFriendDTO? {
        return withContext(Dispatchers.IO) {
            try {
                val entity = friendBox.query(
                    ChunithmFriendEntity_.friendCode.equal(friendCode)
                ).build().findFirst()
                
                entity?.let {
                    ChunithmFriendDTO(
                        friendCode = it.friendCode,
                        friendName = it.friendName,
                        profileBackground = it.profileBackground,
                        reborn = it.reborn,
                        level = it.level,
                        rating = it.rating,
                        overpower = it.overpower,
                        lastPlay = it.lastPlay,
                        roleImageUrl = it.roleImageUrl,
                        roleBase = it.roleBase,
                        honor1 = it.honor1,
                        honor2 = it.honor2,
                        honor3 = it.honor3,
                        honorBase1 = it.honorBase1,
                        honorBase2 = it.honorBase2,
                        honorBase3 = it.honorBase3,
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

    suspend fun savePlayRecordData(playRecordData: ChunithmPlayRecordDTO, diff: String) {
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
                    rateSSSpCount = playRecordData.rateSSSp
                    rateSSSpTotal = playRecordData.totalSongs
                    
                    rateSSSCount = playRecordData.rateSSS
                    rateSSSTotal = playRecordData.totalSongs
                    
                    rateSSPCount = playRecordData.rateSSp
                    rateSSPTotal = playRecordData.totalSongs
                    
                    rateSSCount = playRecordData.rateSS
                    rateSSTotal = playRecordData.totalSongs
                    
                    rateSpCount = playRecordData.rateSp
                    rateSpTotal = playRecordData.totalSongs
                    
                    rateSCount = playRecordData.rateS
                    rateSTotal = playRecordData.totalSongs
                    
                    // Clear statistics
                    rateClearCount = playRecordData.rateClear
                    rateClearTotal = playRecordData.totalSongs
                    
                    rateFCCount = playRecordData.rateFC
                    rateFCTotal = playRecordData.totalSongs
                    
                    rateAJCount = playRecordData.rateAJ
                    rateAJTotal = playRecordData.totalSongs
                    
                    rateAJCCount = playRecordData.rateAJC
                    rateAJCTotal = playRecordData.totalSongs
                    
                    rateFChainCount = playRecordData.rateFChain
                    rateFChainTotal = playRecordData.totalSongs
                    
                    rateFChainPCount = playRecordData.rateFChainP
                    rateFChainPTotal = playRecordData.totalSongs
                    
                    // Difficulty statistics
                    rateHardCount = playRecordData.rateHard
                    rateHardTotal = playRecordData.totalSongs
                    
                    rateBraveCount = playRecordData.rateBrave
                    rateBraveTotal = playRecordData.totalSongs
                    
                    rateAbsCount = playRecordData.rateAbs
                    rateAbsTotal = playRecordData.totalSongs
                    
                    rateCatasCount = playRecordData.rateCatas
                    rateCatasTotal = playRecordData.totalSongs
                    
                    lastUpdated = currentTime
                }
                playRecordBox.put(playRecordEntity)
                
                // Save genre and score data with intelligent historical tracking
                val updatedOldBests = mutableListOf<ChunithmFullScoreEntity>()
                val newBestScores = mutableListOf<ChunithmFullScoreEntity>()
                
                playRecordData.genreList.forEach { genre ->
                    genre.fullScoreList.forEach { score ->
                        val newScore = score.score.replace(",", "").toIntOrNull() ?: 0
                        
                        // Find the current personal best for this song+difficulty
                        val currentBest = scoreBox.query(
                            ChunithmFullScoreEntity_.songId.equal(score.id)
                                .and(ChunithmFullScoreEntity_.diff.equal(score.diff))
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
                                updatedOldBests.add(oldBest)
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
                                date = score.date
                                trackNumber = score.trackNumber
                                genreName = genre.name
                                recordedAt = currentTime
                                isPersonalBest = true  // This is now the current personal best
                            }
                            newBestScores.add(scoreEntity)
                        }
                    }
                }
                
                // Batch update all old personal bests (mark as no longer current)
                if (updatedOldBests.isNotEmpty()) {
                    scoreBox.put(updatedOldBests)
                }
                
                // Batch save all new personal bests
                if (newBestScores.isNotEmpty()) {
                    scoreBox.put(newBestScores)
                }
                
                Log.i(TAG, "Successfully saved play record data for difficulty: $diff")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save play record data: ${e.message}", e)
            }
        }
    }

    suspend fun saveFriendListData(friendListData: List<ChunithmFriendDTO>) {
        withContext(Dispatchers.IO) {
            try {
                friendBox.removeAll()
                
                // Batch create entities
                val friendEntities = friendListData.map { friendDto ->
                    ChunithmFriendEntity().apply {
                        friendCode = friendDto.friendCode
                        friendName = friendDto.friendName
                        profileBackground = friendDto.profileBackground
                        reborn = friendDto.reborn
                        level = friendDto.level
                        rating = friendDto.rating
                        overpower = friendDto.overpower
                        lastPlay = friendDto.lastPlay
                        roleImageUrl = friendDto.roleImageUrl
                        roleBase = friendDto.roleBase
                        honor1 = friendDto.honor1
                        honor2 = friendDto.honor2
                        honor3 = friendDto.honor3
                        honorBase1 = friendDto.honorBase1
                        honorBase2 = friendDto.honorBase2
                        honorBase3 = friendDto.honorBase3
                        isFavorite = friendDto.isFavorite
                        isScored = friendDto.isScored
                        classEmblemBase = friendDto.classEmblemBase
                        classEmblemTop = friendDto.classEmblemTop
                    }
                }
                
                // Batch save all friends at once
                friendBox.put(friendEntities)
                Log.d(TAG, "Successfully batch saved ${friendEntities.size} friends to ObjectBox")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save friend list data: ${e.message}", e)
            }
        }
    }

    suspend fun saveFriendScoreData(friendScoreData: List<ChunithmFullScoreDTO>, friendCode: String, diffName: String) {
        withContext(Dispatchers.IO) {
            try {
                // Remove existing scores for this friend and difficulty
                val existingScores = friendScoreBox.query(
                    ChunithmFriendScoreEntity_.friendCode.equal(friendCode)
                        .and(ChunithmFriendScoreEntity_.difficulty.equal(diffName))
                ).build().find()
                friendScoreBox.remove(existingScores)

                val currentTime = System.currentTimeMillis().toString()
                
                // Batch create entities
                val friendScoreEntities = friendScoreData.mapNotNull { scoreDto ->
                    try {
                        ChunithmFriendScoreEntity().apply {
                            this.friendCode = friendCode
                            title = scoreDto.title
                            score = scoreDto.score.replace(",", "").toIntOrNull() ?: 0
                            combo = scoreDto.combo // 只保存友人成绩页面中有意义的字段
                            difficulty = diffName
                            recordedAt = currentTime
                            uniqueKey = "${friendCode}_${scoreDto.title}_${diffName}"
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Failed to create entity for (${scoreDto.title}): ${e.message}", e)
                        null
                    }
                }
                
                // Batch save all entities at once
                friendScoreBox.put(friendScoreEntities)
                Log.i(TAG, "Successfully batch saved ${friendScoreEntities.size} friend scores for $friendCode ($diffName)")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save friend score data: ${e.message}", e)
            }
        }
    }

    suspend fun saveMergedSongsData(mergedData: ChunithmDataDTO) {
        withContext(Dispatchers.IO) {
            try {
                // 1. 保存元数据
                saveCategories(mergedData.categories)
                saveVersions(mergedData.versions)
                saveTypes(mergedData.types)
                saveDifficulties(mergedData.difficulties)
                saveRegions(mergedData.regions)
                
                // 2. 保存歌曲和谱面数据
                songsBox.removeAll()
                sheetsBox.removeAll()

                val songEntities = mutableListOf<ChunithmSongsEntity>()
                val sheetEntities = mutableListOf<ChunithmSheetsEntity>()

                mergedData.songs.forEach { mergedSong ->
                    val songEntity = createSongEntityFromMerged(mergedSong)
                    songEntities.add(songEntity)
                    mergedSong.sheets.forEach { mergedSheet ->
                        val sheetEntity = createSheetEntityFromMerged(mergedSong, mergedSheet)
                        sheetEntities.add(sheetEntity)
                    }
                }

                songsBox.put(songEntities)
                sheetsBox.put(sheetEntities)
                
                Log.i(TAG, "Successfully batch saved ${songEntities.size} songs and ${sheetEntities.size} sheets")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save merged songs data: ${e.message}", e)
            }
        }
    }

    private fun createSongEntityFromMerged(mergedSong: ChunithmDataDTO.ChunithmSong): ChunithmSongsEntity {
        return ChunithmSongsEntity().apply {
            genre = mergedSong.category
            title = mergedSong.title
            artist = mergedSong.artist
            bpm = mergedSong.bpm
            imageName = mergedSong.imageName
            version = mergedSong.version
            releaseDate = mergedSong.releaseDate
            isNew = mergedSong.isNew
            isLocked = mergedSong.isLocked
            map = mergedSong.map
            aliases = mergedSong.aliases
        }
    }

    private fun createSheetEntityFromMerged(
        mergedSong: ChunithmDataDTO.ChunithmSong,
        mergedSheet: ChunithmDataDTO.ChunithmSong.ChunithmSheet
    ): ChunithmSheetsEntity {
        return ChunithmSheetsEntity().apply {
            title = mergedSong.title
            type = mergedSheet.type
            difficulty = mergedSheet.difficulty
            levelJp = mergedSheet.level
            levelValueJp = mergedSheet.levelValue
            levelCn = mergedSheet.levelCn
            levelValueCn = mergedSheet.levelValueCn
            noteDesigner = mergedSheet.noteDesigner
            tap = mergedSheet.noteCounts.tap
            hold = mergedSheet.noteCounts.hold
            slide = mergedSheet.noteCounts.slide
            air = mergedSheet.noteCounts.air
            flick = mergedSheet.noteCounts.flick
            total = mergedSheet.noteCounts.total
            jp = mergedSheet.regions.jp
            intl = mergedSheet.regions.intl
            cn = mergedSheet.regions.cn
            isSpecial = mergedSheet.isSpecial
        }
    }
    
    // ==================== Rating 数据相关方法 ====================
    
    /**
     * 保存 Rating 数据（Best/Recent/Suggest）
     * 会先清空对应类型的旧数据，然后保存新数据
     * @param scores Rating 数据列表
     * @param ratingType 类型：best/recent/suggest
     */
    suspend fun saveRatingData(scores: List<ChunithmScoreDTO>, ratingType: String) {
        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Saving $ratingType rating data, count: ${scores.size}")
                
                // 先删除该类型的旧数据
                val deletedCount = ratingBox.query(
                    ChunithmRatingEntity_.ratingType.equal(ratingType)
                ).build().remove()
                Log.d(TAG, "Deleted $deletedCount old $ratingType records")
                
                // 保存新数据
                val currentTime = System.currentTimeMillis()
                val entities = scores.map { score ->
                    ChunithmRatingEntity().apply {
                        songId = score.id
                        title = score.title
                        genre = score.genre
                        diff = score.diff
                        token = score.token
                        highScore = score.highScore
                        this.ratingType = ratingType
                        createdAt = currentTime
                        updatedAt = currentTime
                    }
                }
                
                ratingBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} $ratingType records successfully")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving $ratingType rating data", e)
                throw e
            }
        }
    }
    
    /**
     * 获取指定类型的 Rating 数据
     * @param ratingType 类型：best/recent/suggest
     * @return Rating 数据列表
     */
    suspend fun getRatingData(ratingType: String): List<ChunithmScoreDTO> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading $ratingType rating data")
                
                val entities = ratingBox.query(
                    ChunithmRatingEntity_.ratingType.equal(ratingType)
                ).build()
                    .find()
                    .sortedByDescending { it.createdAt } // 按创建时间倒序
                
                Log.d(TAG, "Loaded ${entities.size} $ratingType records")
                
                entities.map { entity ->
                    ChunithmScoreDTO(
                        id = entity.songId,
                        title = entity.title,
                        genre = entity.genre,
                        diff = entity.diff,
                        token = entity.token,
                        highScore = entity.highScore
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error loading $ratingType rating data", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取所有 Rating 数据（包含类型信息）
     * @return Map<类型, 数据列表>
     */
    suspend fun getAllRatingData(): Map<String, List<ChunithmScoreDTO>> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading all rating data")
                
                val allEntities = ratingBox.all
                val grouped = allEntities.groupBy { it.ratingType }
                
                Log.d(TAG, "Loaded rating data: ${grouped.mapValues { it.value.size }}")
                
                grouped.mapValues { (_, entities) ->
                    entities
                        .sortedByDescending { it.createdAt }
                        .map { entity ->
                            ChunithmScoreDTO(
                                id = entity.songId,
                                title = entity.title,
                                genre = entity.genre,
                                diff = entity.diff,
                                token = entity.token,
                                highScore = entity.highScore
                            )
                        }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error loading all rating data", e)
                emptyMap()
            }
        }
    }

    /**
     * 获取 Rating 数据的最后更新时间
     * @param ratingType 类型：best/recent/suggest
     * @return 最后更新时间戳（毫秒），如果没有数据返回 0
     */
    suspend fun getRatingDataLastUpdateTime(ratingType: String): Long {
        return withContext(Dispatchers.IO) {
            try {
                val latestEntity = ratingBox.query(
                    ChunithmRatingEntity_.ratingType.equal(ratingType)
                ).build()
                    .find()
                    .maxByOrNull { it.updatedAt }
                
                latestEntity?.updatedAt ?: 0L
            } catch (e: Exception) {
                Log.e(TAG, "Error getting last update time for $ratingType", e)
                0L
            }
        }
    }
    
    // ==================== PlayLog 游玩历史相关方法 ====================
    
    /**
     * 保存游玩历史记录
     * 每次刷新时会追加新的记录，不会删除旧记录
     * @param playLogs 游玩历史列表
     */
    suspend fun savePlayLogs(playLogs: List<ChunithmFullScoreDTO>) {
        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Saving play logs, count: ${playLogs.size}")
                
                val currentTime = System.currentTimeMillis()
                val entities = playLogs.map { log ->
                    ChunithmPlayLogEntity().apply {
                        songId = log.id
                        title = log.title
                        genre = log.genre
                        diff = log.diff
                        token = log.token
                        score = log.score
                        clear = log.clear
                        combo = log.combo
                        chain = log.chain
                        rank = log.rank
                        playDate = log.date
                        trackNumber = log.trackNumber
                        createdAt = currentTime
                        syncedAt = currentTime
                    }
                }
                
                // 追加新记录（不删除旧记录）
                playLogBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} play log records successfully")
                Log.d(TAG, "Total play logs in database: ${playLogBox.count()}")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving play logs", e)
                throw e
            }
        }
    }
    
    /**
     * 获取所有游玩历史记录
     * @param limit 限制返回数量，默认不限制
     * @return 游玩历史列表，按同步时间倒序排序
     */
    suspend fun getAllPlayLogs(limit: Int? = null): List<ChunithmFullScoreDTO> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading play logs${limit?.let { ", limit: $it" } ?: ""}")
                
                val query = playLogBox.query().order(ChunithmPlayLogEntity_.syncedAt)
                val entities = if (limit != null) {
                    query.build().find(0, limit.toLong())
                } else {
                    query.build().find()
                }.reversed() // 倒序：最新的在前
                
                Log.d(TAG, "Loaded ${entities.size} play log records")
                
                entities.map { entity ->
                    ChunithmFullScoreDTO(
                        id = entity.songId,
                        title = entity.title,
                        genre = entity.genre,
                        diff = entity.diff,
                        token = entity.token,
                        score = entity.score,
                        clear = entity.clear,
                        combo = entity.combo,
                        chain = entity.chain,
                        rank = entity.rank,
                        date = entity.playDate,
                        trackNumber = entity.trackNumber
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error loading play logs", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取指定曲目的游玩历史
     * @param title 曲名
     * @param difficulty 难度（可选）
     * @return 该曲目的游玩历史列表
     */
    suspend fun getPlayLogsByTitle(title: String, difficulty: String? = null): List<ChunithmFullScoreDTO> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading play logs for title: $title${difficulty?.let { ", difficulty: $it" } ?: ""}")
                
                val query = if (difficulty != null) {
                    playLogBox.query(
                        ChunithmPlayLogEntity_.title.equal(title)
                            .and(ChunithmPlayLogEntity_.diff.equal(difficulty))
                    )
                } else {
                    playLogBox.query(ChunithmPlayLogEntity_.title.equal(title))
                }
                
                val entities = query.order(ChunithmPlayLogEntity_.syncedAt)
                    .build()
                    .find()
                    .reversed() // 最新的在前
                
                Log.d(TAG, "Found ${entities.size} play log records")
                
                entities.map { entity ->
                    ChunithmFullScoreDTO(
                        id = entity.songId,
                        title = entity.title,
                        genre = entity.genre,
                        diff = entity.diff,
                        token = entity.token,
                        score = entity.score,
                        clear = entity.clear,
                        combo = entity.combo,
                        chain = entity.chain,
                        rank = entity.rank,
                        date = entity.playDate,
                        trackNumber = entity.trackNumber
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error loading play logs by title", e)
                emptyList()
            }
        }
    }

    /**
     * 获取游玩历史记录总数
     */
    suspend fun getPlayLogCount(): Long {
        return withContext(Dispatchers.IO) {
            try {
                playLogBox.count()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting play log count", e)
                0L
            }
        }
    }
    
    /**
     * 获取最后同步时间
     * @return 最后同步时间戳（毫秒），如果没有数据返回 0
     */
    suspend fun getPlayLogLastSyncTime(): Long {
        return withContext(Dispatchers.IO) {
            try {
                val latestEntity = playLogBox.query()
                    .orderDesc(ChunithmPlayLogEntity_.syncedAt)
                    .build()
                    .findFirst()
                
                latestEntity?.syncedAt ?: 0L
            } catch (e: Exception) {
                Log.e(TAG, "Error getting last sync time for play logs", e)
                0L
            }
        }
    }
    
    // ==================== 地图数据相关方法 ====================
    
    /**
     * 保存地图数据
     * 会先删除该地图的旧数据，然后保存新数据
     * @param mapDataList 地图数据列表（可能包含同一地图的多页数据）
     */
    suspend fun saveMapData(mapDataList: List<ChunithmMapDTO>) {
        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Saving map data, count: ${mapDataList.size}")
                
                val currentTime = System.currentTimeMillis()
                
                // 每个 DTO 代表一个地图的一页数据，独立保存
                mapDataList.forEach { mapData ->
                    val mapName = mapData.title
                    val pageNumber = mapData.currentPage
                    
                    Log.d(TAG, "Saving map: $mapName, page: $pageNumber/${mapData.totalPages}")
                    
                    // 删除该地图该页的旧数据
                    mapAreaBox.query(
                        ChunithmMapAreaEntity_.mapName.equal(mapName)
                            .and(ChunithmMapAreaEntity_.pageNumber.equal(pageNumber))
                    ).build().remove()
                    
                    // 保存该页的格子数据
                    val pageAreas = mutableListOf<ChunithmMapAreaEntity>()
                    mapData.areas.forEachIndexed { index, area ->
                        // 判断格子是否为空
                        val isEmpty = area.imageUrl.isNullOrBlank() && 
                                     area.remain == 0 && 
                                     area.skillSeed.isNullOrBlank()
                        
                        pageAreas.add(
                            ChunithmMapAreaEntity().apply {
                                this.mapName = mapName
                                this.pageNumber = pageNumber
                                this.totalPages = mapData.totalPages
                                this.position = index
                                this.imageUrl = area.imageUrl ?: ""
                                this.remain = area.remain
                                this.skillSeed = area.skillSeed ?: ""
                                this.isEmpty = isEmpty
                                this.syncedAt = currentTime
                            }
                        )
                    }
                    
                    mapAreaBox.put(pageAreas)
                    Log.d(TAG, "Saved map '$mapName' page $pageNumber with ${pageAreas.size} areas")
                }
                
                Log.d(TAG, "Map data saved successfully")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving map data", e)
                throw e
            }
        }
    }

    // ==================== 角色数据相关方法 ====================
    
    /**
     * 保存角色数据
     * @param characters 角色列表
     * @param replaceAll 是否替换所有数据（默认true）
     */
    suspend fun saveCharacterData(characters: List<ChunithmCharacterEntity>, replaceAll: Boolean = true) {
        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Saving character data, count: ${characters.size}, replaceAll: $replaceAll")
                
                if (replaceAll) {
                    // 清空旧数据
                    characterBox.removeAll()
                }
                
                // 保存新数据
                characterBox.put(characters)
                
                Log.d(TAG, "Character data saved successfully")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving character data", e)
                throw e
            }
        }
    }
    
    /**
     * 获取所有角色
     * @return 角色列表（按等级降序，名称升序）
     */
    suspend fun getAllCharacters(): List<ChunithmCharacterEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading all characters")
                val characters = characterBox.all
                    .sortedWith(compareByDescending<ChunithmCharacterEntity> { it.level }
                        .thenBy { it.name })
                Log.d(TAG, "Loaded ${characters.size} characters")
                characters
            } catch (e: Exception) {
                Log.e(TAG, "Error loading characters", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取当前使用的角色
     * @return 当前角色，如果没有返回 null
     */
    suspend fun getCurrentCharacter(): ChunithmCharacterEntity? {
        return withContext(Dispatchers.IO) {
            try {
                characterBox.query(ChunithmCharacterEntity_.isCurrentlyUsed.equal(true))
                    .build()
                    .findFirst()
            } catch (e: Exception) {
                Log.e(TAG, "Error loading current character", e)
                null
            }
        }
    }
    
    /**
     * 按边框类型获取角色
     * @param frameType 边框类型
     * @return 角色列表
     */
    suspend fun getCharactersByFrameType(frameType: String): List<ChunithmCharacterEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading characters by frame type: $frameType")
                val characters = characterBox.query(ChunithmCharacterEntity_.frameType.equal(frameType))
                    .build()
                    .find()
                    .sortedWith(compareByDescending<ChunithmCharacterEntity> { it.level }
                        .thenBy { it.name })
                Log.d(TAG, "Found ${characters.size} characters with frame type: $frameType")
                characters
            } catch (e: Exception) {
                Log.e(TAG, "Error loading characters by frame type", e)
                emptyList()
            }
        }
    }
    
    /**
     * 按名称搜索角色
     * @param keyword 关键词
     * @return 角色列表
     */
    suspend fun searchCharactersByName(keyword: String): List<ChunithmCharacterEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Searching characters by keyword: $keyword")
                val characters = characterBox.query(ChunithmCharacterEntity_.name.contains(keyword))
                    .build()
                    .find()
                    .sortedWith(compareByDescending<ChunithmCharacterEntity> { it.level }
                        .thenBy { it.name })
                Log.d(TAG, "Found ${characters.size} characters matching keyword")
                characters
            } catch (e: Exception) {
                Log.e(TAG, "Error searching characters", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取满级角色
     * @return 满级角色列表
     */
    suspend fun getMaxLevelCharacters(): List<ChunithmCharacterEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading max level characters")
                val characters = characterBox.query(ChunithmCharacterEntity_.isMaxLevel.equal(true))
                    .build()
                    .find()
                    .sortedBy { it.name }
                Log.d(TAG, "Found ${characters.size} max level characters")
                characters
            } catch (e: Exception) {
                Log.e(TAG, "Error loading max level characters", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取拥有技能种子的角色
     * @return 角色列表
     */
    suspend fun getCharactersWithSkillSeed(): List<ChunithmCharacterEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading characters with skill seed")
                val characters = characterBox.query(ChunithmCharacterEntity_.skillSeedText.notEqual(""))
                    .build()
                    .find()
                    .sortedWith(compareByDescending<ChunithmCharacterEntity> { it.level }
                        .thenBy { it.name })
                Log.d(TAG, "Found ${characters.size} characters with skill seed")
                characters
            } catch (e: Exception) {
                Log.e(TAG, "Error loading characters with skill seed", e)
                emptyList()
            }
        }
    }
    
    /**
     * 清空所有角色数据
     */
    suspend fun clearAllCharacterData() {
        withContext(Dispatchers.IO) {
            try {
                val count = characterBox.count()
                characterBox.removeAll()
                Log.d(TAG, "Cleared all character data: $count characters")
            } catch (e: Exception) {
                Log.e(TAG, "Error clearing character data", e)
                throw e
            }
        }
    }
    
    /**
     * 获取角色总数
     */
    suspend fun getCharacterCount(): Long {
        return withContext(Dispatchers.IO) {
            try {
                characterBox.count()
            } catch (e: Exception) {
                Log.e(TAG, "Error getting character count", e)
                0L
            }
        }
    }
    
    /**
     * 获取角色最后同步时间
     */
    suspend fun getCharacterLastSyncTime(): Long {
        return withContext(Dispatchers.IO) {
            try {
                characterBox.all.maxOfOrNull { it.syncedAt } ?: 0L
            } catch (e: Exception) {
                Log.e(TAG, "Error getting character last sync time", e)
                0L
            }
        }
    }
    
    // ==================== 地图相关操作 ====================
    
    /**
     * 获取所有地图
     * @return 地图列表（按更新时间降序）
     */
    suspend fun getAllMaps(): List<ChunithmMapEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading all maps")
                val maps = mapBox.all.sortedByDescending { it.updatedAt }
                Log.d(TAG, "Loaded ${maps.size} maps")
                maps
            } catch (e: Exception) {
                Log.e(TAG, "Error loading maps", e)
                emptyList()
            }
        }
    }
    
    /**
     * 根据地图名称获取地图
     * @param mapName 地图名称
     * @return 地图实体，如果不存在返回 null
     */
    suspend fun getMapByName(mapName: String): ChunithmMapEntity? {
        return withContext(Dispatchers.IO) {
            try {
                mapBox.query(ChunithmMapEntity_.mapName.equal(mapName))
                    .build()
                    .findFirst()
            } catch (e: Exception) {
                Log.e(TAG, "Error loading map by name: $mapName", e)
                null
            }
        }
    }
    
    /**
     * 获取指定地图的所有格子数据
     * @param mapName 地图名称
     * @return 格子列表（按页码和位置排序）
     */
    suspend fun getMapAreas(mapName: String): List<ChunithmMapAreaEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading areas for map: $mapName")
                val areas = mapAreaBox.query(ChunithmMapAreaEntity_.mapName.equal(mapName))
                    .build()
                    .find()
                    .sortedWith(compareBy<ChunithmMapAreaEntity> { it.pageNumber }
                        .thenBy { it.position })
                Log.d(TAG, "Loaded ${areas.size} areas for map: $mapName")
                areas
            } catch (e: Exception) {
                Log.e(TAG, "Error loading map areas for: $mapName", e)
                emptyList()
            }
        }
    }
    
    /**
     * 保存或更新地图数据
     * @param mapEntity 地图实体
     */
    suspend fun saveOrUpdateMap(mapEntity: ChunithmMapEntity) {
        withContext(Dispatchers.IO) {
            try {
                val existingMap = getMapByName(mapEntity.mapName)
                if (existingMap != null) {
                    mapEntity.id = existingMap.id
                    mapEntity.createdAt = existingMap.createdAt
                }
                mapEntity.updatedAt = System.currentTimeMillis()
                mapBox.put(mapEntity)
                Log.d(TAG, "Saved map: ${mapEntity.mapName}")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving map", e)
                throw e
            }
        }
    }
    
    /**
     * 获取所有地图格子数据
     * @return 所有格子列表
     */
    suspend fun getAllMapAreas(): List<ChunithmMapAreaEntity> {
        return withContext(Dispatchers.IO) {
            try {
                mapAreaBox.all
            } catch (e: Exception) {
                Log.e(TAG, "Error loading all map areas", e)
                emptyList()
            }
        }
    }
    
    /**
     * 批量保存地图格子数据
     * @param areas 格子列表
     */
    suspend fun saveMapAreas(areas: List<ChunithmMapAreaEntity>) {
        withContext(Dispatchers.IO) {
            try {
                areas.forEach { it.syncedAt = System.currentTimeMillis() }
                mapAreaBox.put(areas)
                Log.d(TAG, "Saved ${areas.size} map areas")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving map areas", e)
                throw e
            }
        }
    }
    
    // ============ 登录奖励相关方法 ============
    
    /**
     * 保存登录奖励数据
     */
    suspend fun saveLoginBonusData(
        currentMonthDays: Int,
        dailyStreakDay: Int,
        monthlyRewards: List<com.madsam.otora.data.chunithm.remote.model.MonthlyReward>,
        dailyRewards: List<com.madsam.otora.data.chunithm.remote.model.DailyReward>,
        weekdayBonuses: List<com.madsam.otora.data.chunithm.remote.model.WeekdayBonus>
    ) {
        withContext(Dispatchers.IO) {
            try {
                val currentTime = System.currentTimeMillis()
                
                // 保存主实体（只保留一条记录）
                val mainEntity = loginBonusBox.all.firstOrNull() ?: ChunithmLoginBonusEntity()
                mainEntity.apply {
                    this.currentMonthDays = currentMonthDays
                    this.dailyStreakDay = dailyStreakDay
                    this.lastUpdated = currentTime
                }
                loginBonusBox.put(mainEntity)
                
                // 保存月度奖励（先清空再保存）
                monthlyRewardBox.removeAll()
                val monthlyEntities = monthlyRewards.map { reward ->
                    ChunithmMonthlyRewardEntity(
                        day = reward.day,
                        imageUrl = reward.imageUrl,
                        rewardName = reward.rewardName,
                        isCompleted = reward.isCompleted,
                        lastUpdated = currentTime
                    )
                }
                monthlyRewardBox.put(monthlyEntities)
                
                // 保存每日奖励（先清空再保存）
                dailyRewardBox.removeAll()
                val dailyEntities = dailyRewards.map { reward ->
                    ChunithmDailyRewardEntity(
                        day = reward.day,
                        imageUrl = reward.imageUrl,
                        rewardName = reward.rewardName,
                        isReceived = reward.isReceived,
                        isNext = reward.isNext,
                        lastUpdated = currentTime
                    )
                }
                dailyRewardBox.put(dailyEntities)
                
                // 保存每周加成（先清空再保存，不存储isToday）
                weekdayBonusBox.removeAll()
                val weekdayEntities = weekdayBonuses.map { bonus ->
                    ChunithmWeekdayBonusEntity(
                        weekday = bonus.weekday,
                        iconUrl = bonus.iconUrl,
                        description = bonus.description,
                        lastUpdated = currentTime
                    )
                }
                weekdayBonusBox.put(weekdayEntities)
                
                Log.d(TAG, "Saved login bonus data: month=$currentMonthDays, daily=$dailyStreakDay")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving login bonus data", e)
                throw e
            }
        }
    }
    
    /**
     * 获取登录奖励主数据
     */
    suspend fun getLoginBonusData(): ChunithmLoginBonusEntity? {
        return withContext(Dispatchers.IO) {
            try {
                loginBonusBox.all.firstOrNull()
            } catch (e: Exception) {
                Log.e(TAG, "Error loading login bonus data", e)
                null
            }
        }
    }
    
    /**
     * 获取月度奖励列表（按天数排序）
     */
    suspend fun getMonthlyRewards(): List<ChunithmMonthlyRewardEntity> {
        return withContext(Dispatchers.IO) {
            try {
                monthlyRewardBox.query()
                    .order(ChunithmMonthlyRewardEntity_.day)
                    .build()
                    .find()
            } catch (e: Exception) {
                Log.e(TAG, "Error loading monthly rewards", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取每日奖励列表（按天数排序）
     */
    suspend fun getDailyRewards(): List<ChunithmDailyRewardEntity> {
        return withContext(Dispatchers.IO) {
            try {
                dailyRewardBox.query()
                    .order(ChunithmDailyRewardEntity_.day)
                    .build()
                    .find()
            } catch (e: Exception) {
                Log.e(TAG, "Error loading daily rewards", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取每周加成列表
     */
    suspend fun getWeekdayBonuses(): List<ChunithmWeekdayBonusEntity> {
        return withContext(Dispatchers.IO) {
            try {
                weekdayBonusBox.all
            } catch (e: Exception) {
                Log.e(TAG, "Error loading weekday bonuses", e)
                emptyList()
            }
        }
    }
    
    // ==================== Avatar 自定义部件相关方法 ====================
    
    /**
     * 保存 Avatar 部件数据
     * @param items Avatar 部件列表
     * @param category 部件类型（face, head, wear, item, back, front），如果提供则只清空该类型的数据
     */
    suspend fun saveAvatarItems(items: List<ChunithmAvatarItemEntity>, category: String? = null) {
        withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Saving avatar items, count: ${items.size}, category: $category")
                
                if (category != null) {
                    // 只清空指定类型的数据
                    val oldItems = avatarItemBox.query(
                        ChunithmAvatarItemEntity_.category.equal(category)
                    ).build().find()
                    avatarItemBox.remove(oldItems)
                } else {
                    // 清空所有数据
                    avatarItemBox.removeAll()
                }
                
                // 保存新数据
                avatarItemBox.put(items)
                
                Log.d(TAG, "Avatar items saved successfully")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving avatar items", e)
                throw e
            }
        }
    }
    
    /**
     * 获取指定类型的所有 Avatar 部件
     * @param category 部件类型（face, head, wear, item, back, front）
     * @return Avatar 部件列表
     */
    suspend fun getAvatarItemsByCategory(category: String): List<ChunithmAvatarItemEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading avatar items for category: $category")
                val items = avatarItemBox.query(
                    ChunithmAvatarItemEntity_.category.equal(category)
                ).build().find()
                Log.d(TAG, "Loaded ${items.size} avatar items")
                items
            } catch (e: Exception) {
                Log.e(TAG, "Error loading avatar items", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取所有 Avatar 部件
     * @return Avatar 部件列表（按类型和名称排序）
     */
    suspend fun getAllAvatarItems(): List<ChunithmAvatarItemEntity> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Loading all avatar items")
                val items = avatarItemBox.all
                    .sortedWith(compareBy<ChunithmAvatarItemEntity> { it.category }
                        .thenBy { it.name })
                Log.d(TAG, "Loaded ${items.size} avatar items")
                items
            } catch (e: Exception) {
                Log.e(TAG, "Error loading all avatar items", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取当前使用的 Avatar 部件
     * @param category 部件类型（可选），如果不提供则返回所有正在使用的部件
     * @return 当前使用的 Avatar 部件列表
     */
    suspend fun getCurrentAvatarItems(category: String? = null): List<ChunithmAvatarItemEntity> {
        return withContext(Dispatchers.IO) {
            try {
                val query = if (category != null) {
                    avatarItemBox.query(
                        ChunithmAvatarItemEntity_.category.equal(category)
                            .and(ChunithmAvatarItemEntity_.isCurrentlyUsed.equal(true))
                    )
                } else {
                    avatarItemBox.query(
                        ChunithmAvatarItemEntity_.isCurrentlyUsed.equal(true)
                    )
                }
                query.build().find()
            } catch (e: Exception) {
                Log.e(TAG, "Error loading current avatar items", e)
                emptyList()
            }
        }
    }
    
    // ==================== 元数据相关方法 ====================
    
    /**
     * 保存 Categories 元数据
     */
    suspend fun saveCategories(categories: List<ChunithmDataDTO.Category>) {
        withContext(Dispatchers.IO) {
            try {
                val entities = categories.map { category ->
                    ChunithmCategoryEntity().apply {
                        this.category = category.category
                    }
                }
                categoryBox.removeAll()
                categoryBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} categories")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving categories", e)
            }
        }
    }
    
    /**
     * 获取所有 Categories
     */
    suspend fun getAllCategories(): List<ChunithmCategoryEntity> {
        return withContext(Dispatchers.IO) {
            try {
                categoryBox.all
            } catch (e: Exception) {
                Log.e(TAG, "Error loading categories", e)
                emptyList()
            }
        }
    }
    
    /**
     * 保存 Versions 元数据
     */
    suspend fun saveVersions(versions: List<ChunithmDataDTO.Version>) {
        withContext(Dispatchers.IO) {
            try {
                val entities = versions.map { version ->
                    ChunithmVersionEntity().apply {
                        this.version = version.version
                        this.abbr = version.abbr
                        this.releaseDate = version.releaseDate
                    }
                }
                versionBox.removeAll()
                versionBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} versions")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving versions", e)
            }
        }
    }
    
    /**
     * 获取所有 Versions（按发布日期倒序）
     */
    suspend fun getAllVersions(): List<ChunithmVersionEntity> {
        return withContext(Dispatchers.IO) {
            try {
                versionBox.all.sortedBy { it.releaseDate }
            } catch (e: Exception) {
                Log.e(TAG, "Error loading versions", e)
                emptyList()
            }
        }
    }
    
    /**
     * 保存 Types 元数据
     */
    suspend fun saveTypes(types: List<ChunithmDataDTO.Type>) {
        withContext(Dispatchers.IO) {
            try {
                val entities = types.map { type ->
                    ChunithmTypeEntity().apply {
                        this.type = type.type
                        this.name = type.name
                        this.abbr = type.abbr
                    }
                }
                typeBox.removeAll()
                typeBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} types")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving types", e)
            }
        }
    }
    
    /**
     * 获取所有 Types
     */
    suspend fun getAllTypes(): List<ChunithmTypeEntity> {
        return withContext(Dispatchers.IO) {
            try {
                typeBox.all
            } catch (e: Exception) {
                Log.e(TAG, "Error loading types", e)
                emptyList()
            }
        }
    }
    
    /**
     * 保存 Difficulties 元数据
     */
    suspend fun saveDifficulties(difficulties: List<ChunithmDataDTO.Difficulty>) {
        withContext(Dispatchers.IO) {
            try {
                val entities = difficulties.map { difficulty ->
                    ChunithmDifficultyEntity().apply {
                        this.difficulty = difficulty.difficulty
                        this.name = difficulty.name
                        this.color = difficulty.color
                    }
                }
                difficultyBox.removeAll()
                difficultyBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} difficulties")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving difficulties", e)
            }
        }
    }
    
    /**
     * 获取所有 Difficulties
     */
    suspend fun getAllDifficulties(): List<ChunithmDifficultyEntity> {
        return withContext(Dispatchers.IO) {
            try {
                difficultyBox.all
            } catch (e: Exception) {
                Log.e(TAG, "Error loading difficulties", e)
                emptyList()
            }
        }
    }
    
    /**
     * 保存 Regions 元数据
     */
    suspend fun saveRegions(regions: List<ChunithmDataDTO.Region>) {
        withContext(Dispatchers.IO) {
            try {
                val entities = regions.map { region ->
                    ChunithmRegionEntity().apply {
                        this.region = region.region
                        this.name = region.name
                    }
                }
                regionBox.removeAll()
                regionBox.put(entities)
                Log.d(TAG, "Saved ${entities.size} regions")
            } catch (e: Exception) {
                Log.e(TAG, "Error saving regions", e)
            }
        }
    }
    
    /**
     * 获取所有 Regions
     */
    suspend fun getAllRegions(): List<ChunithmRegionEntity> {
        return withContext(Dispatchers.IO) {
            try {
                regionBox.all
            } catch (e: Exception) {
                Log.e(TAG, "Error loading regions", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取所有个人最佳成绩
     */
    suspend fun getAllPersonalBestScores(): List<ChunithmFullScoreEntity> {
        return withContext(Dispatchers.IO) {
            try {
                scoreBox.query(
                    ChunithmFullScoreEntity_.isPersonalBest.equal(true)
                ).build().find()
            } catch (e: Exception) {
                Log.e(TAG, "Error loading personal best scores", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取所有歌曲实体
     */
    suspend fun getAllSongs(): List<ChunithmSongsEntity> {
        return withContext(Dispatchers.IO) {
            try {
                songsBox.all
            } catch (e: Exception) {
                Log.e(TAG, "Error loading songs", e)
                emptyList()
            }
        }
    }
    
    /**
     * 获取所有谱面实体
     */
    suspend fun getAllSheets(): List<ChunithmSheetsEntity> {
        return withContext(Dispatchers.IO) {
            try {
                sheetsBox.all
            } catch (e: Exception) {
                Log.e(TAG, "Error loading sheets", e)
                emptyList()
            }
        }
    }
}
