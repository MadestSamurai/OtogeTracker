package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuHistoricalBeatmap
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu历史谱面实体类
 */

data class OsuHistoricalRecord(
    var count: Int = 0,
    var items: List<OsuHistoricalItem> = listOf(),
    var pagination: OsuPagination = OsuPagination()
)
