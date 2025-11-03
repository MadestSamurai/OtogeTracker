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
import com.madsam.otora.data.chunithm.remote.model.ChuniFriendDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniFullScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChunithmDataDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniPlayRecordDTO
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
                        rateAbs = record.rateAbsCount,
                        rateAbsP = record.rateAbsPCount,
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
                    
                    rateAbsCount = playRecordData.rateAbs
                    rateAbsTotal = playRecordData.totalSongs
                    
                    rateAbsPCount = playRecordData.rateAbsP
                    rateAbsPTotal = playRecordData.totalSongs
                    
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

    suspend fun saveFriendListData(friendListData: List<ChuniFriendDTO>) {
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
}
