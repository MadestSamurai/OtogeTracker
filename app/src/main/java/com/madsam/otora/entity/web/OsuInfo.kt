package com.madsam.otora.entity.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuInfo
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu信息实体类
 */

data class OsuInfo(
    var achievements: List<OsuMedalItem> = emptyList(),
    @Json(name = "current_mode") var currentMode: String = "",
    @Json(name = "scores_notice") var scoresNotice: String = "",
    var user: OsuUserExtend = OsuUserExtend()
)
