package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuHistorical
 * 创建者: MadSamurai
 * 创建时间: 2024/3/11
 * 描述: Osu历史数据实体类
 */

data class OsuHistorical(
    var beatmapPlaycounts: OsuHistoricalRecord = OsuHistoricalRecord(),
    var monthlyPlaycounts: List<OsuDateCount> = listOf(),
    var recent: OsuHistoricalRecord = OsuHistoricalRecord(),
    var replaysWatchedCounts: List<OsuDateCount> = listOf()
) {
    data class OsuDateCount(
        var startDate: String = "",
        var count: Int = 0
    )
}