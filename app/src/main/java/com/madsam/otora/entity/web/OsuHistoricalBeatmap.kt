package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuHistoricalBeatmap
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu历史谱面实体类
 */

data class OsuHistoricalBeatmap(
    var beatmapsetId: Long = 0L,
    var difficultyRating: Double = 0.0,
    var id: Long = 0L,
    var mode: String = "",
    var status: String = "",
    var totalLength: Long = 0L,
    var userId: Long = 0L,
    var version: String = ""
)
