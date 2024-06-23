package com.madsam.otora.entity.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuCover
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu封面实体类
 */

data class OsuCovers(
    var cover: String = "",

    @Json(name = "cover@2x")
    var cover2x: String = "",
    var card: String = "",

    @Json(name = "card@2x")
    var card2x: String = "",
    var list: String = "",

    @Json(name = "list@2x")
    var list2x: String = "",

    @Json(name = "slimcover")
    var slimCover: String = "",

    @Json(name = "slimcover@2x")
    var slimCover2x: String = ""
)