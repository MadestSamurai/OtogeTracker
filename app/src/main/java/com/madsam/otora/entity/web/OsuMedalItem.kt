package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuMedalItem
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu成就实体类
 */

data class OsuMedalItem(
    var iconUrl: String = "",
    var id: Long = 0L,
    var name: String = "",
    var grouping: String = "",
    var ordering: String = "",
    var description: String = "",
    var mode: String = "",
    var instructions: String = ""
)
