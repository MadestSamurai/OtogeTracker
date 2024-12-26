package com.madsam.otora.model.chuni.web.zetaraku

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.chuni.web.zetaraku.ChuniDatas
 * 创建者: MadSamurai
 * 创建时间: 2024/11/15
 * 描述: Chunithm数据(Zetaraku API)
 */
data class ZetarakuDatas(
    @Json(name = "songs") var songs: List<ChuniSong> = listOf(),
    @Json(name = "categories") var categories: List<Category> = listOf(),
    @Json(name = "versions") var versions: List<Version> = listOf(),
    @Json(name = "types") var types: List<Type> = listOf(),
    @Json(name = "difficulties") var difficulties: List<Difficulty> = listOf(),
    @Json(name = "regions") var regions: List<Region> = listOf(),
    @Json(name = "updateTime") var updateTime: String = ""
) {
    data class Category(
        @Json(name = "category") var category: String = ""
    )

    data class Version(
        @Json(name = "version") var version: String = "",
        @Json(name = "abbr") var abbr: String = ""
    )

    data class Type(
        @Json(name = "type") var type: String = "",
        @Json(name = "name") var name: String = "",
        @Json(name = "abbr") var abbr: String = ""
    )

    data class Difficulty(
        @Json(name = "difficulty") var difficulty: String = "",
        @Json(name = "name") var name: String = "",
        @Json(name = "color") var color: String = ""
    )

    data class Region(
        @Json(name = "region") var region: String = "",
        @Json(name = "name") var name: String = ""
    )

    data class ChuniSong (
        @Json(name = "songId") var songId: String = "",
        @Json(name = "category") var category: String = "",
        @Json(name = "title") var title: String = "",
        @Json(name = "artist") var artist: String = "",
        @Json(name = "bpm") var bpm: Double = 0.0,
        @Json(name = "imageName") var imageName: String = "",
        @Json(name = "version") var version: String = "",
        @Json(name = "releaseDate") var releaseDate: String = "",
        @Json(name = "isNew") var isNew: Boolean = false,
        @Json(name = "isLocked") var isLocked: Boolean = false,
        @Json(name = "comment") var comment: String = "",
        @Json(name = "sheets") var sheets: List<ChuniSongSheet> = listOf()
    ) {
        data class ChuniSongSheet(
            @Json(name = "type") var type: String = "",
            @Json(name = "difficulty") var difficulty: String = "",
            @Json(name = "level") var level: String = "",
            @Json(name = "levelValue") var levelValue: Double = 0.0,
            @Json(name = "internalLevel") var internalLevel: String = "",
            @Json(name = "internalLevelValue") var internalLevelValue: Double = 0.0,
            @Json(name = "noteDesigner") var noteDesigner: String = "",
            @Json(name = "noteCounts") var noteCounts: NoteCounts = NoteCounts(),
            @Json(name = "regions") var regions: Regions = Regions(),
            @Json(name = "isSpecial") var isSpecial: Boolean = false
        ) {
            data class NoteCounts(
                @Json(name = "tap") var tap: Int = 0,
                @Json(name = "hold") var hold: Int = 0,
                @Json(name = "slide") var slide: Int = 0,
                @Json(name = "air") var air: Int = 0,
                @Json(name = "flick") var flick: Int = 0,
                @Json(name = "total") var total: Int = 0
            )

            data class Regions(
                @Json(name = "jp") var jp: Boolean = false,
                @Json(name = "intl") var intl: Boolean = false
            )
        }
    }
}

