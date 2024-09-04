package com.madsam.otora.entity.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuBeatmapSet
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu谱面集实体类
 */

data class OsuBeatmapSet(
    var artist: String = "",
    @Json(name = "artist_unicode") var artistUnicode: String = "",
    var covers: OsuCovers = OsuCovers(),
    var creator: String = "",
    @Json(name = "favourite_count") var favouriteCount: Int = 0,
    var hype: Hype = Hype(),
    var id: Long = 0L,
    var nsfw: Boolean = false,
    @Json(name = "play_count") var playCount: Int = 0,
    @Json(name = "preview_url") var previewUrl: String = "",
    var source: String = "",
    var spotlight: Boolean = false,
    var status: String = "",
    var title: String = "",
    @Json(name = "title_unicode") var titleUnicode: String = "",
    @Json(name = "track_id") var trackId: Long = 0L,
    @Json(name = "user_id") var userId: Long = 0L,
    var video: Boolean = false
) {
    data class Hype(
        var current: Int = 0,
        var required: Int = 0
    )
}