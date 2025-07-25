package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuHistoricalItemDTO(
    @param:Json(name = "beatmap_id") var beatmapId: Long = 0L,
    var count: Long = 0L,
    var beatmap: OsuHistoricalBeatmapDTO = OsuHistoricalBeatmapDTO(),
    var beatmapset: OsuBeatmapSetDTO = OsuBeatmapSetDTO()
)