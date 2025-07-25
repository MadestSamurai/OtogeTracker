package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuBeatmapDTO(
    @param:Json(name = "beatmap_set_id") var beatmapSetId: Long = 0L,
    @param:Json(name = "difficulty_rating") var difficultyRating: Double = 0.0,
    var id: Long = 0L,
    var mode: String = "",
    var status: String = "",
    @param:Json(name = "total_length") var totalLength: Long = 0L,
    @param:Json(name = "user_id") var userId: Long = 0L,
    var version: String = "",
    var accuracy: Double = 0.0,
    var ar: Double = 0.0,
    var bpm: Double = 0.0,
    var convert: Boolean = false,
    @param:Json(name = "count_circles") var countCircles: Int = 0,
    @param:Json(name = "count_sliders") var countSliders: Int = 0,
    @param:Json(name = "count_spinners") var countSpinners: Int = 0,
    var cs: Double = 0.0,
    @param:Json(name = "deleted_at") var deletedAt: String = "",
    var drain: Double = 0.0,
    @param:Json(name = "hit_length") var hitLength: Int = 0,
    var isScoreable: Boolean = false,
    @param:Json(name = "last_updated") var lastUpdated: String = "",
    @param:Json(name = "mode_int") var modeInt: Int = 0,
    @param:Json(name = "passcount") var passCount: Int = 0,
    @param:Json(name = "playcount") var playCount: Int = 0,
    var ranked: Int = 0,
    var url: String = "",
    var checksum: String = ""
)