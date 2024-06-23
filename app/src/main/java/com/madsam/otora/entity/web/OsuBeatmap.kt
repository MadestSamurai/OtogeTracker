package com.madsam.otora.entity.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuBeatmap
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu谱面实体类
 */

data class OsuBeatmap(
    var beatmapSetId: Long = 0L,
    var difficultyRating: Double = 0.0,
    var id: Long = 0L,
    var mode: String = "",
    var status: String = "",
    var totalLength: Long = 0L,
    var userId: Long = 0L,
    var version: String = "",
    var accuracy: Double = 0.0,
    var ar: Double = 0.0,
    var bpm: Double = 0.0,
    var convert: Boolean = false,
    var countCircles: Int = 0,
    var countSliders: Int = 0,
    var countSpinners: Int = 0,
    var cs: Double = 0.0,
    var deletedAt: String = "",
    var drain: Double = 0.0,
    var hitLength: Int = 0,
    var isScoreable: Boolean = false,
    var lastUpdated: String = "",
    var modeInt: Int = 0,

    @Json(name = "passcount")
    var passCount: Int = 0,

    @Json(name = "playcount")
    var playCount: Int = 0,
    var ranked: Int = 0,
    var url: String = "",
    var checksum: String = ""
)