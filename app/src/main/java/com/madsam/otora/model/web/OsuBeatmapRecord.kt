package com.madsam.otora.model.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuBeatmapRecord
 * 创建者: MadSamurai
 * 创建时间: 2024/3/11
 * 描述: Osu谱面记录实体类
 */

data class OsuBeatmapRecord(
    var count: Int = 0,
    var items: List<OsuBeatmapItem> = listOf(),
    var pagination: OsuPagination = OsuPagination()
)
