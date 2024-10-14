package com.madsam.otora.model.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuBeatmap
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu谱面实体类
 */

data class OsuBeatmap(
    @Json(name = "beatmap_set_id") var beatmapSetId: Long = 0L,
    @Json(name = "difficulty_rating") var difficultyRating: Double = 0.0,
    var id: Long = 0L,
    var mode: String = "",
    var status: String = "",
    @Json(name = "total_length") var totalLength: Long = 0L,
    @Json(name = "user_id") var userId: Long = 0L,
    var version: String = "",
    var accuracy: Double = 0.0,
    var ar: Double = 0.0,
    var bpm: Double = 0.0,
    var convert: Boolean = false,
    @Json(name = "count_circles") var countCircles: Int = 0,
    @Json(name = "count_sliders") var countSliders: Int = 0,
    @Json(name = "count_spinners") var countSpinners: Int = 0,
    var cs: Double = 0.0,
    @Json(name = "deleted_at") var deletedAt: String = "",
    var drain: Double = 0.0,
    @Json(name = "hit_length") var hitLength: Int = 0,
    var isScoreable: Boolean = false,
    @Json(name = "last_updated") var lastUpdated: String = "",
    @Json(name = "mode_int") var modeInt: Int = 0,
    @Json(name = "passcount") var passCount: Int = 0,
    @Json(name = "playcount") var playCount: Int = 0,
    var ranked: Int = 0,
    var url: String = "",
    var checksum: String = ""
)