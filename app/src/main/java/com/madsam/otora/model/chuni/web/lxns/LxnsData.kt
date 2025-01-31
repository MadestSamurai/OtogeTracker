package com.madsam.otora.model.chuni.web.lxns

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.chuni.web.lxns.ChuniDatas
 * 创建者: MadSamurai
 * 创建时间: 2024/12/26
 * 描述: Chunithm数据(LXNS API)
 */
data class LxnsData(
    var songs: List<ChuniSong> = listOf(),
    var genres: List<Genre> = listOf(),
    var versions: List<Version> = listOf(),
) {
    data class Genre(
        var id: Int = 0,
        var genre: String = ""
    )

    data class Version(
        var id: Int = 0,
        var title: String = "",
        var version: Int = 0
    )

    data class ChuniSong(
        @Json(name = "id") var id: Int = 0,
        @Json(name = "title") var title: String = "",
        @Json(name = "artist") var artist: String = "",
        @Json(name = "genre") var genre: String = "",
        @Json(name = "bpm") var bpm: Int = 0,
        @Json(name = "map") var map: String = "",
        @Json(name = "version") var version: Int = 0,
        @Json(name = "difficulties") var difficulties: List<Difficulty> = listOf(),
        var aliases: String = ""
    ) {
        data class Difficulty(
            @Json(name = "difficulty") var difficulty: Int = 0,
            @Json(name = "level") var level: String = "",
            @Json(name = "level_value") var levelValue: Double = 0.0,
            @Json(name = "note_designer") var noteDesigner: String = "",
            @Json(name = "version") var version: Int = 0,
            @Json(name = "origin_id") var originId: Int = 0,
            @Json(name = "kanji") var kanji: String = "",
            @Json(name = "star") var star: Int = 0
        )
    }
}