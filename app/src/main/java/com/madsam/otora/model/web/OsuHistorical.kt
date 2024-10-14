package com.madsam.otora.model.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuHistorical
 * 创建者: MadSamurai
 * 创建时间: 2024/3/11
 * 描述: Osu历史数据实体类
 */

data class OsuHistorical(
    @Json(name = "beatmap_playcounts") var beatmapPlaycounts: OsuHistoricalRecord = OsuHistoricalRecord(),
    @Json(name = "monthly_playcounts") var monthlyPlaycounts: List<OsuDateCount> = listOf(),
    var recent: OsuHistoricalRecord = OsuHistoricalRecord(),
    @Json(name = "replays_watched_counts") var replaysWatchedCounts: List<OsuDateCount> = listOf()
) {
    data class OsuDateCount(
        @Json(name = "start_date") var startDate: String = "",
        var count: Int = 0
    )
}