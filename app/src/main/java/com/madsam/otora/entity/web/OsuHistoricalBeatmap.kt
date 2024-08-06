package com.madsam.otora.entity.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuHistoricalBeatmap
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu历史谱面实体类
 */

data class OsuHistoricalBeatmap(
    @Json(name = "beatmapset_id") var beatmapsetId: Long = 0L,
    @Json(name = "difficulty_rating") var difficultyRating: Double = 0.0,
    var id: Long = 0L,
    var mode: String = "",
    var status: String = "",
    @Json(name = "total_length") var totalLength: Long = 0L,
    @Json(name = "user_id") var userId: Long = 0L,
    var version: String = ""
)