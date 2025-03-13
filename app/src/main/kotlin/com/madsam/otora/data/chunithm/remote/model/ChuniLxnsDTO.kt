package com.madsam.otora.data.chunithm.remote.model

import com.squareup.moshi.Json

internal data class ChuniLxnsDTO(
    var songs: List<ChuniSong> = listOf(),
    var genres: List<Genre> = listOf(),
    var versions: List<Version> = listOf(),
) {
    internal data class Genre(
        var id: Int = 0,
        var genre: String = ""
    )

    internal data class Version(
        var id: Int = 0,
        var title: String = "",
        var version: Int = 0
    )

    internal data class ChuniSong(
        var id: Int = 0,
        var title: String = "",
        var artist: String = "",
        var genre: String = "",
        var bpm: Int = 0,
        var map: String = "",
        var version: Int = 0,
        var difficulties: List<Difficulty> = listOf(),
        var aliases: String = ""
    ) {
        internal data class Difficulty(
            var difficulty: Int = 0,
            var level: String = "",
            @Json(name = "level_value") var levelValue: Double = 0.0,
            @Json(name = "note_designer") var noteDesigner: String = "",
            var version: Int = 0,
            @Json(name = "origin_id") var originId: Int = 0,
            var kanji: String = "",
            var star: Int = 0
        )
    }
}