package com.madsam.otora.model.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuGroup
 * 创建者: MadSamurai
 * 创建时间: 2024/6/13
 * 描述: Osu社区小组实体类
 */
data class OsuGroup(
    var colour: String = "",
    @Json(name = "has_listing") var hasListing: Boolean = false,
    @Json(name = "has_playmodes") var hasPlaymodes: Boolean = false,
    var id: Int = 0,
    var identifier: String = "",
    @Json(name = "is_probationary") var isProbationary: Boolean = false,
    var name: String = "",
    @Json(name = "short_name") var shortName: String = "",
    var playmodes: List<String> = emptyList()
)