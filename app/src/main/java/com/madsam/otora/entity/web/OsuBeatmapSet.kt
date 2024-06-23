package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuBeatmapSet
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu谱面集实体类
 */

data class OsuBeatmapSet(
    var artist: String = "",
    var artistUnicode: String = "",
    var covers: OsuCovers = OsuCovers(),
    var creator: String = "",
    var favouriteCount: Int = 0,
    var hype: String = "",
    var id: Long = 0L,
    var nsfw: Boolean = false,
    var playCount: Int = 0,
    var previewUrl: String = "",
    var source: String = "",
    var spotlight: Boolean = false,
    var status: String = "",
    var title: String = "",
    var titleUnicode: String = "",
    var trackId: Long = 0L,
    var userId: Long = 0L,
    var video: Boolean = false
)