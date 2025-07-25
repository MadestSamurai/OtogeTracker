package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuHistoricalDTO(
    @param:Json(name = "beatmap_playcounts") var beatmapPlaycounts: OsuHistoricalRecordDTO = OsuHistoricalRecordDTO(),
    @param:Json(name = "monthly_playcounts") var monthlyPlaycounts: List<OsuDateCount> = listOf(),
    var recent: OsuHistoricalRecordDTO = OsuHistoricalRecordDTO(),
    @param:Json(name = "replays_watched_counts") var replaysWatchedCounts: List<OsuDateCount> = listOf()
) {
    internal data class OsuDateCount(
        @param:Json(name = "start_date") var startDate: String = "",
        var count: Int = 0
    )
}