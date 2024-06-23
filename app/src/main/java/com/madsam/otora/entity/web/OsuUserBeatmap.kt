package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuUserBeatmap
 * 创建者: MadSamurai
 * 创建时间: 2024/3/11
 * 描述: Osu用户谱面实体类
 */

data class OsuUserBeatmap(
    var favourite: OsuBeatmapRecord = OsuBeatmapRecord(),
    var graveyard: OsuBeatmapRecord = OsuBeatmapRecord(),
    var guest: OsuBeatmapRecord = OsuBeatmapRecord(),
    var loved: OsuBeatmapRecord = OsuBeatmapRecord(),
    var nominated: OsuBeatmapRecord = OsuBeatmapRecord(),
    var pending: OsuBeatmapRecord = OsuBeatmapRecord(),
    var ranked: OsuBeatmapRecord = OsuBeatmapRecord()
)
