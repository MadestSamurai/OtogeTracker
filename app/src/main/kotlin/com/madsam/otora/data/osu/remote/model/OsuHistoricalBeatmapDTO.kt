package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuHistoricalBeatmapDTO(
    @Json(name = "beatmapset_id") var beatmapsetId: Long = 0L,
    @Json(name = "difficulty_rating") var difficultyRating: Double = 0.0,
    var id: Long = 0L,
    var mode: String = "",
    var status: String = "",
    @Json(name = "total_length") var totalLength: Long = 0L,
    @Json(name = "user_id") var userId: Long = 0L,
    var version: String = ""
)