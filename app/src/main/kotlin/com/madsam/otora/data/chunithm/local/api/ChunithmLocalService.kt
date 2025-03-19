package com.madsam.otora.data.chunithm.local.api

import android.util.Log
import com.madsam.otora.data.chunithm.local.model.ChuniSheetsEntity
import com.madsam.otora.data.chunithm.local.model.ChuniSongsEntity
import com.madsam.otora.data.chunithm.remote.model.ChuniAliasesDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniJpDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLxnsDTO
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
        )
    )
        .name("otoge-tracker-chuni.realm")
        .schemaVersion(1)
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
                val songData = songs.map {
                    val sheet = realm.query(
                        clazz = ChuniSheetsEntity::class,
                        query = "title == $0",
                        it.title
                    ).find()
                    val sheetData = sheet.map {
                        ChunithmSheetUiModel(
                            title = it.title,
                            type = it.type,
                            difficulty = it.difficulty,
                            levelJp = it.levelJp,
                            levelValueJp = it.levelValueJp,
                            internalLevelJp = it.internalLevelJp,
                            internalLevelValueJp = it.internalLevelValueJp,
                            levelCn = it.levelCn,
                            levelValueCn = it.levelValueCn,
                            noteDesigner = it.noteDesigner,
                            tap = it.tap,
                            hold = it.hold,
                            slide = it.slide,
                            air = it.air,
                            flick = it.flick,
                            total = it.total,
                            jp = it.jp,
                            intl = it.intl,
                            cn = it.cn,
                            isSpecial = it.isSpecial
                        )
                    }
                    ChunithmSongUiModel(
                        genre = it.genre,
                        title = it.title,
                        artist = it.artist,
                        bpm = it.bpm,
                        imageName = it.imageName,
                        version = it.version,
                        releaseDate = it.releaseDate,
                        isNew = it.isNew,
                        isLocked = it.isLocked,
                        comment = it.comment,
                        cnId = it.cnId,
                        map = it.map,
                        aliases = it.aliases,
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
}