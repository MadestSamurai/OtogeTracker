package com.madsam.otora.data.chunithm.local.api

import android.util.Log
import com.madsam.otora.data.chunithm.local.model.ChuniSheetsEntity
import com.madsam.otora.data.chunithm.local.model.ChuniSongsEntity
import com.madsam.otora.data.chunithm.local.model.ChuniPlayRecordEntity
import com.madsam.otora.data.chunithm.local.model.ChuniFullScoreEntity
import com.madsam.otora.data.chunithm.remote.model.ChuniAliasesDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniJpDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLxnsDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniPlayRecordDTO
import com.madsam.otora.data.chunithm.ui.model.ChunithmSheetUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmSongUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmPlayRecordUiModel
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
        )
    )
        .name("otoge-tracker-chuni.realm")
        .schemaVersion(2)
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
                            rateSSSp_count = it.first
                            rateSSSp_total = it.second
                        }
                        playRecordDTO.rateSSS.let {
                            rateSSS_count = it.first
                            rateSSS_total = it.second
                        }
                        playRecordDTO.rateSSp.let {
                            rateSSp_count = it.first
                            rateSSp_total = it.second
                        }
                        playRecordDTO.rateSS.let {
                            rateSS_count = it.first
                            rateSS_total = it.second
                        }
                        playRecordDTO.rateSp.let {
                            rateSp_count = it.first
                            rateSp_total = it.second
                        }
                        playRecordDTO.rateS.let {
                            rateS_count = it.first
                            rateS_total = it.second
                        }
                        
                        // Clear statistics
                        playRecordDTO.rateClear.let {
                            rateClear_count = it.first
                            rateClear_total = it.second
                        }
                        playRecordDTO.rateFC.let {
                            rateFC_count = it.first
                            rateFC_total = it.second
                        }
                        playRecordDTO.rateAJ.let {
                            rateAJ_count = it.first
                            rateAJ_total = it.second
                        }
                        playRecordDTO.rateAJC.let {
                            rateAJC_count = it.first
                            rateAJC_total = it.second
                        }
                        playRecordDTO.rateFChain.let {
                            rateFChain_count = it.first
                            rateFChain_total = it.second
                        }
                        playRecordDTO.rateFChainP.let {
                            rateFChainP_count = it.first
                            rateFChainP_total = it.second
                        }
                        
                        // Difficulty statistics
                        playRecordDTO.rateHard.let {
                            rateHard_count = it.first
                            rateHard_total = it.second
                        }
                        playRecordDTO.rateAbs.let {
                            rateAbs_count = it.first
                            rateAbs_total = it.second
                        }
                        playRecordDTO.rateAbsP.let {
                            rateAbsP_count = it.first
                            rateAbsP_total = it.second
                        }
                        playRecordDTO.rateCatas.let {
                            rateCatas_count = it.first
                            rateCatas_total = it.second
                        }
                        
                        lastUpdated = currentTime
                    }
                    this.copyToRealm(playRecordEntity, UpdatePolicy.ALL)
                    
                    // Save genre and score data
                    playRecordDTO.genreList.forEach { genre ->
                        genre.fullScoreList.forEach { score ->
                            val scoreEntity = ChuniFullScoreEntity().apply {
                                id = "${score.id}_${score.diff}_${difficulty}_${currentTime}"
                                songId = score.id
                                title = score.title
                                diff = score.diff
                                // Convert comma-separated string to integer
                                this.score = score.score.replace(",", "").toIntOrNull() ?: 0
                                this.genre = score.genre
                                token = score.token
                                isClear = score.isClear
                                isFullCombo = score.isFullCombo
                                isAllJustice = score.isAllJustice
                                isAJC = score.isAJC
                                isFullChain = score.isFullChain
                                isFullChain2 = score.isFullChain2
                                rank = score.rank
                                jacket = score.jacket
                                date = score.date
                                trackNumber = score.trackNumber
                                genreName = genre.name
                                this.difficulty = difficulty
                                lastUpdated = currentTime
                            }
                            this.copyToRealm(scoreEntity, UpdatePolicy.ALL)
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
                        rateSSSp_count = it.rateSSSp_count
                        rateSSSp_total = it.rateSSSp_total
                        rateSSS_count = it.rateSSS_count
                        rateSSS_total = it.rateSSS_total
                        rateSSp_count = it.rateSSp_count
                        rateSSp_total = it.rateSSp_total
                        rateSS_count = it.rateSS_count
                        rateSS_total = it.rateSS_total
                        rateSp_count = it.rateSp_count
                        rateSp_total = it.rateSp_total
                        rateS_count = it.rateS_count
                        rateS_total = it.rateS_total
                        rateClear_count = it.rateClear_count
                        rateClear_total = it.rateClear_total
                        rateFC_count = it.rateFC_count
                        rateFC_total = it.rateFC_total
                        rateAJ_count = it.rateAJ_count
                        rateAJ_total = it.rateAJ_total
                        rateAJC_count = it.rateAJC_count
                        rateAJC_total = it.rateAJC_total
                        rateFChain_count = it.rateFChain_count
                        rateFChain_total = it.rateFChain_total
                        rateFChainP_count = it.rateFChainP_count
                        rateFChainP_total = it.rateFChainP_total
                        rateHard_count = it.rateHard_count
                        rateHard_total = it.rateHard_total
                        rateAbs_count = it.rateAbs_count
                        rateAbs_total = it.rateAbs_total
                        rateAbsP_count = it.rateAbsP_count
                        rateAbsP_total = it.rateAbsP_total
                        rateCatas_count = it.rateCatas_count
                        rateCatas_total = it.rateCatas_total
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
                    query = "difficulty == $0",
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
                        isClear = scoreEntity.isClear
                        isFullCombo = scoreEntity.isFullCombo
                        isAllJustice = scoreEntity.isAllJustice
                        isAJC = scoreEntity.isAJC
                        isFullChain = scoreEntity.isFullChain
                        isFullChain2 = scoreEntity.isFullChain2
                        rank = scoreEntity.rank
                        jacket = scoreEntity.jacket
                        date = scoreEntity.date
                        trackNumber = scoreEntity.trackNumber
                        genreName = scoreEntity.genreName
                        this.difficulty = scoreEntity.difficulty
                        lastUpdated = scoreEntity.lastUpdated
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
                    rateSSSp = Pair(record.rateSSSp_count, record.rateSSSp_total),
                    rateSSS = Pair(record.rateSSS_count, record.rateSSS_total),
                    rateSSp = Pair(record.rateSSp_count, record.rateSSp_total),
                    rateSS = Pair(record.rateSS_count, record.rateSS_total),
                    rateSp = Pair(record.rateSp_count, record.rateSp_total),
                    rateS = Pair(record.rateS_count, record.rateS_total),
                    rateClear = Pair(record.rateClear_count, record.rateClear_total),
                    rateFC = Pair(record.rateFC_count, record.rateFC_total),
                    rateAJ = Pair(record.rateAJ_count, record.rateAJ_total),
                    rateAJC = Pair(record.rateAJC_count, record.rateAJC_total),
                    rateFChain = Pair(record.rateFChain_count, record.rateFChain_total),
                    rateFChainP = Pair(record.rateFChainP_count, record.rateFChainP_total),
                    rateHard = Pair(record.rateHard_count, record.rateHard_total),
                    rateAbs = Pair(record.rateAbs_count, record.rateAbs_total),
                    rateAbsP = Pair(record.rateAbsP_count, record.rateAbsP_total),
                    rateCatas = Pair(record.rateCatas_count, record.rateCatas_total),
                    lastUpdated = record.lastUpdated,
                    scores = scores.map { scoreEntity ->
                        ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel(
                            songId = scoreEntity.songId,
                            title = scoreEntity.title,
                            diff = scoreEntity.diff,
                            score = scoreEntity.score,
                            genre = scoreEntity.genre,
                            isClear = scoreEntity.isClear,
                            isFullCombo = scoreEntity.isFullCombo,
                            isAllJustice = scoreEntity.isAllJustice,
                            isAJC = scoreEntity.isAJC,
                            isFullChain = scoreEntity.isFullChain,
                            isFullChain2 = scoreEntity.isFullChain2,
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
                    query = "title == $0 AND diff == $1",
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
                    isClear = latestScore.isClear,
                    isFullCombo = latestScore.isFullCombo,
                    isAllJustice = latestScore.isAllJustice,
                    isAJC = latestScore.isAJC,
                    isFullChain = latestScore.isFullChain,
                    isFullChain2 = latestScore.isFullChain2,
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
                val allScores = realm.query(clazz = ChuniFullScoreEntity::class).find()
                Log.d(TAG, "Loaded ${allScores.size} total scores from database")
                
                val scoresMap = mutableMapOf<String, MutableMap<String, ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel>>()
                
                allScores.forEach { scoreEntity ->
                    val scoreUiModel = ChunithmPlayRecordUiModel.ChunithmFullScoreUiModel(
                        songId = scoreEntity.songId,
                        title = scoreEntity.title,
                        diff = scoreEntity.diff,
                        score = scoreEntity.score,
                        genre = scoreEntity.genre,
                        isClear = scoreEntity.isClear,
                        isFullCombo = scoreEntity.isFullCombo,
                        isAllJustice = scoreEntity.isAllJustice,
                        isAJC = scoreEntity.isAJC,
                        isFullChain = scoreEntity.isFullChain,
                        isFullChain2 = scoreEntity.isFullChain2,
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
}