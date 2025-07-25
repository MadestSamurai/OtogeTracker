package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuBeatmapItemDTO(
    var artist: String = "",
    var artistUnicode: String = "",
    var availability: Availability = Availability(),
    var beatmaps: List<OsuBeatmapDTO> = listOf(),
    var bpm: Double = 0.0,
    var creator: String = "",
    @param:Json(name = "delete_at") var deleteAt: String = "",
    @param:Json(name = "discussion_enabled") var discussionEnabled: Boolean = false,
    @param:Json(name = "discussion_locked") var discussionLocked: Boolean = false,
    @param:Json(name = "favourite_count") var favouriteCount: Int = 0,
    @param:Json(name = "has_favourited") var hasFavourited: Boolean = false,
    var hype: Hype = Hype(),
    var id: Long = 0L,
    @param:Json(name = "is_scoreable") var isScoreable: Boolean = false,
    @param:Json(name = "last_updated") var lastUpdated: String = "",
    @param:Json(name = "legacy_thread_url") var legacyThreadUrl: String = "",
    var nominationSummary: NominationSummary = NominationSummary(),
    var nsfw: Boolean = false,
    var offset: Int = 0,
    @param:Json(name = "play_count") var playCount: Int = 0,
    @param:Json(name = "preview_url") var previewUrl: String = "",
    var source: String = "",
    var spotlight: Boolean = false,
    var status: String = "",
    @param:Json(name = "submitted_date") var submittedDate: String = "",
    var tags: String = "",
    var title: String = "",
    var titleUnicode: String = "",
    @param:Json(name = "track_id") var trackId: Long = 0L,
    @param:Json(name = "user_id") var userId: Long = 0L,
    var video: Boolean = false
) {
    internal data class Availability(
        @param:Json(name = "download_disabled") var downloadDisabled: Boolean = false,
        @param:Json(name = "more_information") var moreInformation: String = ""
    )

    internal data class Hype(
        var current: Int = 0,
        var required: Int = 0
    )

    internal data class NominationSummary(
        var current: Int = 0,
        var required: Int = 0
    )
}