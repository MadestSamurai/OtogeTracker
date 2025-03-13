package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuHistoricalDTO(
    @Json(name = "beatmap_playcounts") var beatmapPlaycounts: OsuHistoricalRecordDTO = OsuHistoricalRecordDTO(),
    @Json(name = "monthly_playcounts") var monthlyPlaycounts: List<OsuDateCount> = listOf(),
    var recent: OsuHistoricalRecordDTO = OsuHistoricalRecordDTO(),
    @Json(name = "replays_watched_counts") var replaysWatchedCounts: List<OsuDateCount> = listOf()
) {
    internal data class OsuDateCount(
        @Json(name = "start_date") var startDate: String = "",
        var count: Int = 0
    )
}