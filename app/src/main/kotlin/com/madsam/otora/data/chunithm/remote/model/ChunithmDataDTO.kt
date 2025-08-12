package com.madsam.otora.data.chunithm.remote.model

import com.squareup.moshi.Json

internal data class ChunithmDataDTO(
    @param:Json(name = "songs") var songs: List<ChunithmSong> = listOf(),
    @param:Json(name = "categories") var categories: List<Category> = listOf(),
    @param:Json(name = "versions") var versions: List<Version> = listOf(),
    @param:Json(name = "types") var types: List<Type> = listOf(),
    @param:Json(name = "difficulties") var difficulties: List<Difficulty> = listOf(),
    @param:Json(name = "regions") var regions: List<Region> = listOf(),
    @param:Json(name = "updateTime") var updateTime: String = ""
) {
    internal data class Category(
        @param:Json(name = "category") var category: String = ""
    )

    internal data class Version(
        @param:Json(name = "version") var version: String = "",
        @param:Json(name = "abbr") var abbr: String = ""
    )

    internal data class Type(
        @param:Json(name = "type") var type: String = "",
        @param:Json(name = "name") var name: String = "",
        @param:Json(name = "abbr") var abbr: String = ""
    )

    internal data class Difficulty(
        @param:Json(name = "difficulty") var difficulty: String = "",
        @param:Json(name = "name") var name: String = "",
        @param:Json(name = "color") var color: String = ""
    )

    internal data class Region(
        @param:Json(name = "region") var region: String = "",
        @param:Json(name = "name") var name: String = ""
    )

    internal data class ChunithmSong(
        @param:Json(name = "category") var category: String = "",
        @param:Json(name = "title") var title: String = "",
        @param:Json(name = "artist") var artist: String = "",
        @param:Json(name = "bpm") var bpm: Double = 0.0,
        @param:Json(name = "imageName") var imageName: String = "",
        @param:Json(name = "version") var version: String = "",
        @param:Json(name = "releaseDate") var releaseDate: String = "",
        @param:Json(name = "isNew") var isNew: Boolean = false,
        @param:Json(name = "isLocked") var isLocked: Boolean = false,
        @param:Json(name = "sheets") var sheets: List<ChunithmSheet> = listOf(),
        @param:Json(name = "map") var map: String = "",
        @param:Json(name = "aliases") var aliases: String = ""
    ) {
        internal data class ChunithmSheet(
            @param:Json(name = "type") var type: String = "",
            @param:Json(name = "difficulty") var difficulty: String = "",
            @param:Json(name = "level") var level: String = "",
            @param:Json(name = "levelValue") var levelValue: Double = 0.0,
            @param:Json(name = "levelCn") var levelCn: String = "",
            @param:Json(name = "levelValueCn") var levelValueCn: Double = 0.0,
            @param:Json(name = "noteDesigner") var noteDesigner: String = "",
            @param:Json(name = "noteCounts") var noteCounts: NoteCounts = NoteCounts(),
            @param:Json(name = "regions") var regions: Regions = Regions(),
            @param:Json(name = "isSpecial") var isSpecial: Boolean = false
        ) {
            internal data class NoteCounts(
                @param:Json(name = "tap") var tap: Int = 0,
                @param:Json(name = "hold") var hold: Int = 0,
                @param:Json(name = "slide") var slide: Int = 0,
                @param:Json(name = "air") var air: Int = 0,
                @param:Json(name = "flick") var flick: Int = 0,
                @param:Json(name = "total") var total: Int = 0
            )

            internal data class Regions(
                @param:Json(name = "jp") var jp: Boolean = false,
                @param:Json(name = "intl") var intl: Boolean = false,
                @param:Json(name = "cn") var cn: Boolean = false
            )
        }
    }
}
