package com.madsam.otora.data.chunithm.local.api

import android.util.Log
import com.madsam.otora.data.chunithm.local.model.ChuniFriendEntity
import com.madsam.otora.data.chunithm.local.model.ChuniFriendScoreEntity
import com.madsam.otora.data.chunithm.local.model.ChuniFullScoreEntity
import com.madsam.otora.data.chunithm.local.model.ChuniPlayRecordEntity
import com.madsam.otora.data.chunithm.local.model.ChuniSheetsEntity
import com.madsam.otora.data.chunithm.local.model.ChuniSongsEntity
import com.madsam.otora.data.chunithm.remote.model.ChuniAliasesDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniFriendDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniFullScoreDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniJpDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLxnsDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniPlayRecordDTO
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayRecordUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmSheetUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmSongUiModel
import io.github.xilinjia.krdb.Realm
import io.github.xilinjia.krdb.RealmConfiguration
import io.github.xilinjia.krdb.UpdatePolicy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


internal class ChunithmLocalService {
    companion object {
        private const val TAG = "ChunithmLocalService"
    }

    private val realmConfig = RealmConfiguration.Builder(
        schema = setOf(
            ChuniSongsEntity::class,
            ChuniSheetsEntity::class,
            ChuniPlayRecordEntity::class,
            ChuniFullScoreEntity::class,
            ChuniFriendEntity::class,
            ChuniFriendScoreEntity::class,
        )
    )
        .name("otoge-tracker-chuni.realm")
        .schemaVersion(7) // Incremented for friend entity tracking
        .build()

    suspend fun saveJPAndLxnsSongsData(
        chuniJpDTO: ChuniJpDTO,
        chuniLxnsDTO: ChuniLxnsDTO,
        chuniAliasesDTO: ChuniAliasesDTO
    ) {
        val chuniSongsLMapI = mutableMapOf<Int, ChuniLxnsDTO.ChuniSong>()
        for (song in chuniLxnsDTO.songs) {
            val chuniSong = ChuniLxnsDTO.ChuniSong().apply {
                id = song.id
                genre = song.genre
                title = song.title
                artist = song.artist
                bpm = song.bpm
                map = song.map
                version = song.version
                difficulties = song.difficulties
            }
            chuniSongsLMapI[song.id] = chuniSong
        }
        val chuniAliasMapI = mutableMapOf<Int, ChuniAliasesDTO.ChuniAlias>()
        for (alias in chuniAliasesDTO.aliases) {
            val chuniAliasData = ChuniAliasesDTO.ChuniAlias().apply {
                id = alias.id
                aliases = alias.aliases
            }
            chuniAliasMapI[alias.id] = chuniAliasData
        }
        for (song in chuniLxnsDTO.songs) {
            val chuniSong = chuniSongsLMapI[song.id]
            val chuniAliasData = chuniAliasMapI[song.id]
            if (chuniSong != null && chuniAliasData != null) {
                chuniSong.aliases = chuniAliasData.aliases.joinToString(",")
            }
            song.aliases = chuniSong?.aliases ?: ""
        }

        val chuniSongsZMap = mutableMapOf<String, ChuniJpDTO.ChuniSong>()
        for (song in chuniJpDTO.songs) {
            val chuniSong = ChuniJpDTO.ChuniSong().apply {
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
            chuniSongsZMap[song.songId] = chuniSong
        }
        val chuniSongsLMapT = mutableMapOf<String, ChuniLxnsDTO.ChuniSong>()
        for (song in chuniLxnsDTO.songs) {
            if (song.difficulties.size == 1) {
                song.title = "(WE) ${song.title}"
            }
            val chuniSong = ChuniLxnsDTO.ChuniSong().apply {
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
            chuniSongsLMapT[song.title] = chuniSong
        }

        val realm = Realm.open(realmConfig)
        realm.write {
            for (song in chuniJpDTO.songs) {
                val chuniSongZ = chuniSongsZMap[song.songId]
                val chuniSongL = chuniSongsLMapT[song.songId]
                if (chuniSongZ == null) {
                    Log.e(TAG, "Failed to get the song data from ChuniJp")
                    continue
                }
                val chuniSongData = ChuniSongsEntity().apply {
                    id = chuniSongZ.songId
                    genre = chuniSongZ.category
                    this.title = chuniSongZ.title
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
                this.copyToRealm(chuniSongData, UpdatePolicy.ALL)

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
                        chuniSongL.difficulties.getOrNull(difficultyIndex)?.also {
                            if (sheet.difficulty == "ultima") {
                                Log.i(TAG, "No Ultima data found of ${chuniSongL.title}")
                            }
                        } ?: ChuniLxnsDTO.ChuniSong.Difficulty()
                    }
                    val chuniSheetData = ChuniSheetsEntity().apply {
                        id = "${chuniSongZ.songId}_${sheet.difficulty}"
                        title = chuniSongZ.title
                        type = sheet.type
                        difficulty = sheet.difficulty
                        levelJp = sheet.level
                        levelValueJp = sheet.levelValue
                        internalLevelJp = sheet.internalLevel
                        internalLevelValueJp = sheet.internalLevelValue
                        levelCn = chuniSheetL?.level ?: ""
                        levelValueCn = chuniSheetL?.levelValue ?: 0.0
                        noteDesigner =
                            chuniSheetL?.noteDesigner ?: sheet.noteDesigner
                        tap = sheet.noteCounts.tap
                        hold = sheet.noteCounts.hold
                        slide = sheet.noteCounts.slide
                        air = sheet.noteCounts.air
                        flick = sheet.noteCounts.flick
                        total = sheet.noteCounts.total
                        jp = sheet.regions.jp
                        intl = sheet.regions.intl
                        cn = chuniSheetL != null
                        isSpecial = sheet.isSpecial
                        version = chuniSheetL?.version ?: -1
                        originId = chuniSheetL?.originId ?: -1
                        kanji = chuniSheetL?.kanji ?: "-"
                        star = chuniSheetL?.star ?: 0
                    }
                    this.copyToRealm(chuniSheetData, UpdatePolicy.ALL)
                }
            }
        }
        realm.close()
    }

    suspend fun getChuniSongData(title: String): ChuniSongsEntity {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val song = realm.query(
                    clazz = ChuniSongsEntity::class,
                    query = "id == $0",
                    title
                ).find().first()
                val songData = ChuniSongsEntity().apply {
                    id = song.id
                    genre = song.genre
                    this.title = song.title
                    artist = song.artist
                    bpm = song.bpm
                    imageName = song.imageName
                    version = song.version
                    releaseDate = song.releaseDate
                    isNew = song.isNew
                    isLocked = song.isLocked
                    comment = song.comment
                }
                songData
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get the song data: ${e.message}")
                ChuniSongsEntity()
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getChuniSongSheetData(title: String, diff: String): ChuniSheetsEntity {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val sheet = realm.query(
                    clazz = ChuniSheetsEntity::class,
                    query = "id == $0",
                    "${title}_${diff}"
                ).find().first()
                val sheetData = ChuniSheetsEntity().apply {
                    id = sheet.id
                    this.title = sheet.title
                    type = sheet.type
                    difficulty = sheet.difficulty
                    levelJp = sheet.levelJp
                    levelValueJp = sheet.levelValueJp
                    internalLevelJp = sheet.internalLevelJp
                    internalLevelValueJp = sheet.internalLevelValueJp
                    levelCn = sheet.levelCn
                    levelValueCn = sheet.levelValueCn
                    noteDesigner = sheet.noteDesigner
                    tap = sheet.tap
                    hold = sheet.hold
                    slide = sheet.slide
                    air = sheet.air
                    flick = sheet.flick
                    total = sheet.total
                    jp = sheet.jp
                    intl = sheet.intl
                    isSpecial = sheet.isSpecial
                }
                sheetData
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get the sheet data: ${e.message}")
                ChuniSheetsEntity()
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getAllSongData(): List<ChunithmSongUiModel> {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val songs = realm.query(
                    clazz = ChuniSongsEntity::class
                ).find()
                val songData = songs.map { song ->
                    val sheet = realm.query(
                        clazz = ChuniSheetsEntity::class,
                        query = "title == $0",
                        song.title
                    ).find()
                    val sheetData = sheet.map { sheetEntity ->
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
                songData
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get the song data: ${e.message}")
                emptyList()
            } finally {
                realm.close()
            }
        }
    }

    suspend fun savePlayRecordData(playRecordDTO: ChuniPlayRecordDTO, difficulty: String) {
        withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                realm.write {
                    val currentTime = System.currentTimeMillis().toString()
                    
                    // Save play record statistics
                    val playRecordEntity = ChuniPlayRecordEntity().apply {
                        id = difficulty
                        
                        // Rating statistics
                        playRecordDTO.rateSSSp.let {
                            rateSSSpCount = it.first
                            rateSSSpTotal = it.second
                        }
                        playRecordDTO.rateSSS.let {
                            rateSSSCount = it.first
                            rateSSSTotal = it.second
                        }
                        playRecordDTO.rateSSp.let {
                            rateSSPCount = it.first
                            rateSSPTotal = it.second
                        }
                        playRecordDTO.rateSS.let {
                            rateSSCount = it.first
                            rateSSTotal = it.second
                        }
                        playRecordDTO.rateSp.let {
                            rateSpCount = it.first
                            rateSpTotal = it.second
                        }
                        playRecordDTO.rateS.let {
                            rateSCount = it.first
                            rateSTotal = it.second
                        }
                        
                        // Clear statistics
                        playRecordDTO.rateClear.let {
                            rateClearCount = it.first
                            rateClearTotal = it.second
                        }
                        playRecordDTO.rateFC.let {
                            rateFCCount = it.first
                            rateFCTotal = it.second
                        }
                        playRecordDTO.rateAJ.let {
                            rateAJCount = it.first
                            rateAJTotal = it.second
                        }
                        playRecordDTO.rateAJC.let {
                            rateAJCCount = it.first
                            rateAJCTotal = it.second
                        }
                        playRecordDTO.rateFChain.let {
                            rateFChainCount = it.first
                            rateFChainTotal = it.second
                        }
                        playRecordDTO.rateFChainP.let {
                            rateFChainPCount = it.first
                            rateFChainPTotal = it.second
                        }
                        
                        // Difficulty statistics
                        playRecordDTO.rateHard.let {
                            rateHardCount = it.first
                            rateHardTotal = it.second
                        }
                        playRecordDTO.rateAbs.let {
                            rateAbsCount = it.first
                            rateAbsTotal = it.second
                        }
                        playRecordDTO.rateAbsP.let {
                            rateAbsPCount = it.first
                            rateAbsPTotal = it.second
                        }
                        playRecordDTO.rateCatas.let {
                            rateCatasCount = it.first
                            rateCatasTotal = it.second
                        }
                        
                        lastUpdated = currentTime
                    }
                    this.copyToRealm(playRecordEntity, UpdatePolicy.ALL)
                    
                    // Save genre and score data with intelligent historical tracking
                    playRecordDTO.genreList.forEach { genre ->
                        genre.fullScoreList.forEach { score ->
                            val newScore = score.score.replace(",", "").toIntOrNull() ?: 0
                            
                            // Find the current personal best for this song+difficulty
                            val currentBest = realm.query(
                                clazz = ChuniFullScoreEntity::class,
                                query = "songId == $0 AND diff == $1 AND difficulty == $2 AND isPersonalBest == true",
                                score.id, score.diff, difficulty
                            ).find().firstOrNull()
                            
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
                                }
                                
                                // Create new record with timestamp-based ID for uniqueness
                                val recordId = "${score.id}_${score.diff}_${difficulty}_${currentTime}"
                                val scoreEntity = ChuniFullScoreEntity().apply {
                                    id = recordId
                                    songId = score.id
                                    title = score.title
                                    diff = score.diff
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
                                    this.difficulty = difficulty
                                    recordedAt = currentTime
                                    isPersonalBest = true  // This is now the current personal best
                                }
                                this.copyToRealm(scoreEntity, UpdatePolicy.ALL)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save play record data: ${e.message}")
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getPlayRecordData(difficulty: String): ChuniPlayRecordEntity? {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val record = realm.query(
                    clazz = ChuniPlayRecordEntity::class,
                    query = "id == $0",
                    difficulty
                ).find().firstOrNull()
                
                record?.let {
                    ChuniPlayRecordEntity().apply {
                        id = it.id
                        rateSSSpCount = it.rateSSSpCount
                        rateSSSpTotal = it.rateSSSpTotal
                        rateSSSCount = it.rateSSSCount
                        rateSSSTotal = it.rateSSSTotal
                        rateSSPCount = it.rateSSPCount
                        rateSSPTotal = it.rateSSPTotal
                        rateSSCount = it.rateSSCount
                        rateSSTotal = it.rateSSTotal
                        rateSpCount = it.rateSpCount
                        rateSpTotal = it.rateSpTotal
                        rateSCount = it.rateSCount
                        rateSTotal = it.rateSTotal
                        rateClearCount = it.rateClearCount
                        rateClearTotal = it.rateClearTotal
                        rateFCCount = it.rateFCCount
                        rateFCTotal = it.rateFCTotal
                        rateAJCount = it.rateAJCount
                        rateAJTotal = it.rateAJTotal
                        rateAJCCount = it.rateAJCCount
                        rateAJCTotal = it.rateAJCTotal
                        rateFChainCount = it.rateFChainCount
                        rateFChainTotal = it.rateFChainTotal
                        rateFChainPCount = it.rateFChainPCount
                        rateFChainPTotal = it.rateFChainPTotal
                        rateHardCount = it.rateHardCount
                        rateHardTotal = it.rateHardTotal
                        rateAbsCount = it.rateAbsCount
                        rateAbsTotal = it.rateAbsTotal
                        rateAbsPCount = it.rateAbsPCount
                        rateAbsPTotal = it.rateAbsPTotal
                        rateCatasCount = it.rateCatasCount
                        rateCatasTotal = it.rateCatasTotal
                        lastUpdated = it.lastUpdated
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get play record data: ${e.message}")
                null
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getFullScoresByDifficulty(difficulty: String): List<ChuniFullScoreEntity> {
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val scores = realm.query(
                    clazz = ChuniFullScoreEntity::class,
                    query = "difficulty == $0 AND isPersonalBest == true",
                    difficulty
                ).find()
                
                scores.map { scoreEntity ->
                    ChuniFullScoreEntity().apply {
                        id = scoreEntity.id
                        songId = scoreEntity.songId
                        title = scoreEntity.title
                        diff = scoreEntity.diff
                        this.score = scoreEntity.score
                        genre = scoreEntity.genre
                        token = scoreEntity.token
                        clear = scoreEntity.clear
                        combo = scoreEntity.combo
                        chain = scoreEntity.chain
                        rank = scoreEntity.rank
                        jacket = scoreEntity.jacket
                        date = scoreEntity.date
                        trackNumber = scoreEntity.trackNumber
                        genreName = scoreEntity.genreName
                        this.difficulty = scoreEntity.difficulty
                        recordedAt = scoreEntity.recordedAt
                        isPersonalBest = scoreEntity.isPersonalBest
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get full scores: ${e.message}")
                emptyList()
            } finally {
                realm.close()
            }
        }
    }
    
    suspend fun getPlayRecordUiModel(difficulty: String): ChunithmPlayRecordUiModel? {
        return withContext(Dispatchers.IO) {
            val playRecord = getPlayRecordData(difficulty)
            val scores = getFullScoresByDifficulty(difficulty)
            
            playRecord?.let { record ->
                ChunithmPlayRecordUiModel(
                    difficulty = record.id,
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
        }
    }

    suspend fun getScoreHistoryForSong(title: String, difficulty: String): List<ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel> {
        Log.d(TAG, "getScoreHistoryForSong called: title='$title', difficulty='$difficulty'")
        
        // Map difficulty string to number
        val difficultyNumber = when (difficulty.lowercase()) {
            "basic" -> "0"
            "advanced" -> "1"
            "expert" -> "2"
            "master" -> "3"
            "ultima" -> "4"
            else -> {
                Log.w(TAG, "Unknown difficulty: $difficulty, using as-is")
                difficulty
            }
        }
        
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val historyRecords = realm.query(
                    clazz = ChuniFullScoreEntity::class,
                    query = "title == $0 AND diff == $1 ORDER BY recordedAt ASC",
                    title,
                    difficultyNumber
                ).find()

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
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get score history: ${e.message}", e)
                emptyList()
            } finally {
                realm.close()
            }
        }
    }

    suspend fun getLatestScoreForSong(title: String, difficulty: String): ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel? {
        Log.d(TAG, "getLatestScoreForSong called: title='$title', difficulty='$difficulty'")
        
        // Map difficulty string to number
        val difficultyNumber = when (difficulty.lowercase()) {
            "basic" -> "0"
            "advanced" -> "1"
            "expert" -> "2"
            "master" -> "3"
            "ultima" -> "4"
            else -> {
                Log.w(TAG, "Unknown difficulty: $difficulty, using as-is")
                difficulty
            }
        }
        Log.d(TAG, "Mapped difficulty '$difficulty' to '$difficultyNumber'")
        
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                Log.d(TAG, "Realm opened successfully")
                val latestScore = realm.query(
                    clazz = ChuniFullScoreEntity::class,
                    query = "title == $0 AND diff == $1 AND isPersonalBest == true",
                    title,
                    difficultyNumber
                ).find().firstOrNull()

                Log.d(TAG, "Query executed. Found score: $latestScore")
                
                if (latestScore == null) {
                    Log.d(TAG, "No score found for title='$title', diff='$difficultyNumber'")
                    // Let's also check what scores exist in the database
                    val allScores = realm.query(clazz = ChuniFullScoreEntity::class).find()
                    Log.d(TAG, "Total scores in database: ${allScores.size}")
                    if (allScores.isNotEmpty()) {
                        Log.d(TAG, "Sample scores:")
                        allScores.take(5).forEach { score ->
                            Log.d(TAG, "  - title='${score.title}', diff='${score.diff}', score=${score.score}")
                        }
                    }
                    return@withContext null
                }

                val result = ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel(
                    songId = latestScore.songId,
                    title = latestScore.title,
                    diff = latestScore.diff,
                    score = latestScore.score,
                    genre = latestScore.genre,
                    clear = latestScore.clear,
                    combo = latestScore.combo,
                    chain = latestScore.chain,
                    rank = latestScore.rank,
                    jacket = latestScore.jacket,
                    date = latestScore.date,
                    trackNumber = latestScore.trackNumber,
                    genreName = latestScore.genreName,
                    difficulty = latestScore.difficulty
                )
                Log.d(TAG, "Created result: $result")
                result
            } catch (e: Exception) {
                Log.e(TAG, "Failed to get latest score for song: ${e.message}", e)
                null
            } finally {
                realm.close()
                Log.d(TAG, "Realm closed")
            }
        }
    }

    suspend fun getAllScoresMap(): Map<String, Map<String, ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel>> {
        Log.d(TAG, "getAllScoresMap called - batch loading all scores")
        return withContext(Dispatchers.IO) {
            val realm = Realm.open(realmConfig)
            try {
                val allScores = realm.query(
                    clazz = ChuniFullScoreEntity::class,
                    query = "isPersonalBest == true"
                ).find()
                Log.d(TAG, "Loaded ${allScores.size} personal best scores from database")
                
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
                    
                    // Convert numeric difficulty back to string for UI
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
            } finally {
                realm.close()
                Log.d(TAG, "Realm closed after batch loading")
            }
        }
    }

    /**
     * 保存友人分数对比数据到数据库
     */
    suspend fun saveFriendScoreData(
        friendScoreList: List<ChuniFullScoreDTO>,
        friendCode: String,
        difficulty: String
    ) = withContext(Dispatchers.IO) {
        val realm = Realm.open(realmConfig)
        Log.d(TAG, "=== Starting saveFriendScoreData for friend $friendCode, difficulty $difficulty ===")
        Log.d(TAG, "Input: ${friendScoreList.size} score records to save")
        
        try {
            val currentTime = System.currentTimeMillis().toString()
            
            realm.write {
                Log.d(TAG, "Entered realm.write block")
                
                // 使用新的主键策略：friendCode_title_difficulty，直接保存/更新，无需删除旧数据
                var savedCount = 0
                var updatedCount = 0
                
                friendScoreList.forEachIndexed { index, scoreDTO ->
                    try {
                        // 使用友人代码+曲名+难度作为唯一主键
                        val entityId = "${friendCode}_${scoreDTO.title}_${difficulty}"
                        
                        // 检查是否已存在记录
                        val existingEntity = this.query(ChuniFriendScoreEntity::class, "id == $0", entityId).find().firstOrNull()
                        
                        val entity = (existingEntity ?: ChuniFriendScoreEntity()).apply {
                            id = entityId
                            this.friendCode = friendCode
                            title = scoreDTO.title
                            score = scoreDTO.score.replace(",", "").toIntOrNull() ?: 0
                            // 只保存友人成绩页面中有意义的字段
                            combo = scoreDTO.combo // 只有combo标记在友人页面是有意义的
                            this.difficulty = difficulty
                            recordedAt = currentTime
                        }
                        
                        // 详细日志第一条和最后几条记录
                        if (index < 3 || index >= friendScoreList.size - 3) {
                            val action = if (existingEntity != null) "Updating" else "Creating"
                            Log.d(TAG, "$action record $index: id=$entityId, title=${scoreDTO.title}, score=${scoreDTO.score}")
                        }
                        
                        if (existingEntity != null) {
                            updatedCount++
                        } else {
                            copyToRealm(entity, UpdatePolicy.ALL)
                            savedCount++
                        }
                        
                    } catch (e: Exception) {
                        Log.e(TAG, "Failed to save individual record $index (${scoreDTO.title}): ${e.message}", e)
                    }
                }
                Log.d(TAG, "Successfully created $savedCount new records and updated $updatedCount existing records out of ${friendScoreList.size} total records")
            }
            
            // 验证保存结果
            val verificationRecords = realm.query(ChuniFriendScoreEntity::class, "friendCode == $0 AND difficulty == $1", friendCode, difficulty).find()
            Log.d(TAG, "Verification: Found ${verificationRecords.size} records in database after save")
            
            Log.d(TAG, "=== Successfully completed saveFriendScoreData ===")
        } catch (e: Exception) {
            Log.e(TAG, "=== Failed to save friend score data: ${e.message} ===", e)
            throw e // 重新抛出异常以便上层处理
        } finally {
            realm.close()
            Log.d(TAG, "Realm connection closed")
        }
    }

    /**
     * 获取友人分数对比数据
     */
    suspend fun getFriendScoreData(friendCode: String, difficulty: String): List<ChuniFriendScoreEntity> = withContext(Dispatchers.IO) {
        val realm = Realm.open(realmConfig)
        try {
            val entities = realm.query(ChuniFriendScoreEntity::class, "friendCode == $0 AND difficulty == $1", friendCode, difficulty).find()
            entities.map { entity ->
                ChuniFriendScoreEntity().apply {
                    id = entity.id
                    this.friendCode = entity.friendCode
                    title = entity.title
                    score = entity.score
                    combo = entity.combo // 只保留combo字段
                    this.difficulty = entity.difficulty
                    recordedAt = entity.recordedAt
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get friend score data: ${e.message}", e)
            emptyList()
        } finally {
            realm.close()
        }
    }

    /**
     * 获取所有友人的分数对比数据（用于好友页面展示）
     */
    suspend fun getAllFriendsScoreData(): Map<String, Map<String, List<ChuniFriendScoreEntity>>> = withContext(Dispatchers.IO) {
        val realm = Realm.open(realmConfig)
        try {
            val entities = realm.query(ChuniFriendScoreEntity::class).find()
            val result = mutableMapOf<String, MutableMap<String, MutableList<ChuniFriendScoreEntity>>>()
            
            entities.forEach { entity ->
                val friendCode = entity.friendCode
                val difficulty = entity.difficulty
                
                if (!result.containsKey(friendCode)) {
                    result[friendCode] = mutableMapOf()
                }
                if (!result[friendCode]!!.containsKey(difficulty)) {
                    result[friendCode]!![difficulty] = mutableListOf()
                }
                
                val copy = ChuniFriendScoreEntity().apply {
                    id = entity.id
                    this.friendCode = entity.friendCode
                    title = entity.title
                    score = entity.score
                    combo = entity.combo // 只保留combo字段
                    this.difficulty = entity.difficulty
                    recordedAt = entity.recordedAt
                }
                result[friendCode]!![difficulty]!!.add(copy)
            }
            
            result.mapValues { it.value.mapValues { diffEntry -> diffEntry.value.toList() }.toMap() }.toMap()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get all friends score data: ${e.message}", e)
            emptyMap()
        } finally {
            realm.close()
        }
    }

    /**
     * 保存友人列表数据到数据库
     */
    suspend fun saveFriendListData(friendList: List<ChuniFriendDTO>) {
        val realm = Realm.open(realmConfig)
        
        try {
            realm.write {
                val currentTime = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault())
                    .format(java.util.Date())
                
                for (friend in friendList) {
                    val entity = ChuniFriendEntity().apply {
                        friendCode = friend.friendCode
                        friendName = friend.friendName
                        profileBackground = friend.profileBackground
                        reborn = friend.reborn
                        level = friend.level
                        rating = friend.rating
                        ratingMax = friend.ratingMax
                        overpower = friend.overpower
                        lastPlay = friend.lastPlay
                        roleImageUrl = friend.roleImageUrl
                        roleBase = friend.roleBase
                        honorText = friend.honorText
                        honorBase = friend.honorBase
                        isFavorite = friend.isFavorite
                        isScored = friend.isScored
                        classEmblemBase = friend.classEmblemBase
                        classEmblemTop = friend.classEmblemTop
                        lastUpdated = currentTime
                    }
                    copyToRealm(entity, UpdatePolicy.ALL)
                }
            }
            Log.d(TAG, "Successfully saved ${friendList.size} friends to database")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to save friend list data: ${e.message}", e)
        } finally {
            realm.close()
        }
    }

    /**
     * 从数据库获取友人列表数据
     */
    suspend fun getFriendListData(): List<ChuniFriendDTO> = withContext(Dispatchers.IO) {
        val realm = Realm.open(realmConfig)
        
        try {
            val entities = realm.query(ChuniFriendEntity::class).find()
            entities.map { entity ->
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
            Log.e(TAG, "Failed to get friend list data: ${e.message}", e)
            emptyList()
        } finally {
            realm.close()
        }
    }

    /**
     * 根据友人代码获取特定友人数据
     */
    suspend fun getFriendData(friendCode: String): ChuniFriendDTO? = withContext(Dispatchers.IO) {
        val realm = Realm.open(realmConfig)
        
        try {
            val entity = realm.query(ChuniFriendEntity::class, "friendCode == $0", friendCode).first().find()
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
        } finally {
            realm.close()
        }
    }
}