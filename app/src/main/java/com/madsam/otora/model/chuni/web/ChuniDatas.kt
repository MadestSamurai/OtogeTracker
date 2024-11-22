package com.madsam.otora.model.chuni.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.model.chuni.web.ChuniDatas
 * 创建者: MadSamurai
 * 创建时间: 2024/11/15
 * 描述: TODO
 */
data class ChuniDatas(
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
}

