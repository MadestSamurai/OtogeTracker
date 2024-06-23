package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuGroup
 * 创建者: MadSamurai
 * 创建时间: 2024/6/13
 * 描述: Osu社区小组实体类
 */
data class OsuGroup(
    var colour: String = "",
    var hasListing: Boolean = false,
    var hasPlaymodes: Boolean = false,
    var id: Int = 0,
    var identifier: String = "",
    var isProbationary: Boolean = false,
    var name: String = "",
    var shortName: String = "",
    var playmodes: List<String> = emptyList()
)