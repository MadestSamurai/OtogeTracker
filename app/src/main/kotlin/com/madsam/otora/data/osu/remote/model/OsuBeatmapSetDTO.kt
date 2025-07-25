package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuBeatmapSetDTO(
    var artist: String = "",
    @param:Json(name = "artist_unicode") var artistUnicode: String = "",
    var covers: OsuCoversDTO = OsuCoversDTO(),
    var creator: String = "",
    @param:Json(name = "favourite_count") var favouriteCount: Int = 0,
    var hype: Hype = Hype(),
    var id: Long = 0L,
    var nsfw: Boolean = false,
    @param:Json(name = "play_count") var playCount: Int = 0,
    @param:Json(name = "preview_url") var previewUrl: String = "",
    var source: String = "",
    var spotlight: Boolean = false,
    var status: String = "",
    var title: String = "",
    @param:Json(name = "title_unicode") var titleUnicode: String = "",
    @param:Json(name = "track_id") var trackId: Long = 0L,
    @param:Json(name = "user_id") var userId: Long = 0L,
    var video: Boolean = false
) {
    internal data class Hype(
        var current: Int = 0,
        var required: Int = 0
    )
}