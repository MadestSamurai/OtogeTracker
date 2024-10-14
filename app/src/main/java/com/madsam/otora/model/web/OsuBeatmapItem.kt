package com.madsam.otora.model.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuBeatmapItem
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu谱面元素实体类
 */

data class OsuBeatmapItem(
    var artist: String = "",
    var artistUnicode: String = "",
    var availability: Availability = Availability(),
    var beatmaps: List<OsuBeatmap> = listOf(),
    var bpm: Double = 0.0,
    var creator: String = "",
    @Json(name = "delete_at") var deleteAt: String = "",
    @Json(name = "discussion_enabled") var discussionEnabled: Boolean = false,
    @Json(name = "discussion_locked") var discussionLocked: Boolean = false,
    @Json(name = "favourite_count") var favouriteCount: Int = 0,
    @Json(name = "has_favourited") var hasFavourited: Boolean = false,
    var hype: Hype = Hype(),
    var id: Long = 0L,
    @Json(name = "is_scoreable") var isScoreable: Boolean = false,
    @Json(name = "last_updated") var lastUpdated: String = "",
    @Json(name = "legacy_thread_url") var legacyThreadUrl: String = "",
    var nominationSummary: NominationSummary = NominationSummary(),
    var nsfw: Boolean = false,
    var offset: Int = 0,
    @Json(name = "play_count") var playCount: Int = 0,
    @Json(name = "preview_url") var previewUrl: String = "",
    var source: String = "",
    var spotlight: Boolean = false,
    var status: String = "",
    @Json(name = "submitted_date") var submittedDate: String = "",
    var tags: String = "",
    var title: String = "",
    var titleUnicode: String = "",
    @Json(name = "track_id") var trackId: Long = 0L,
    @Json(name = "user_id") var userId: Long = 0L,
    var video: Boolean = false
) {
    data class Availability(
        @Json(name = "download_disabled") var downloadDisabled: Boolean = false,
        @Json(name = "more_information") var moreInformation: String = ""
    )

    data class Hype(
        var current: Int = 0,
        var required: Int = 0
    )

    data class NominationSummary(
        var current: Int = 0,
        var required: Int = 0
    )
}