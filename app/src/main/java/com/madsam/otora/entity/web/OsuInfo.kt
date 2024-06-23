package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuInfo
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu信息实体类
 */

data class OsuInfo(
    var achievements: List<OsuMedalItem> = emptyList(),
    var currentMode: String = "",
    var scoresNotice: String = "",
    var user: OsuUserExtend = OsuUserExtend()
)
