package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuHistoricalItem
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu历史谱面元素实体类
 */

data class OsuHistoricalItem(
    var beatmapId: Long = 0L,
    var count: Long = 0L,
    var beatmap: OsuHistoricalBeatmap = OsuHistoricalBeatmap(),
    var beatmapset: OsuBeatmapSet = OsuBeatmapSet()
)
