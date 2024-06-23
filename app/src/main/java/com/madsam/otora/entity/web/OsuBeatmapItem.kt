package com.madsam.otora.entity.web

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
    var deleteAt: String = "",
    var discussionEnabled: Boolean = false,
    var discussionLocked: Boolean = false,
    var favouriteCount: Int = 0,
    var hasFavourited: Boolean = false,
    var hype: Hype = Hype(),
    var id: Long = 0L,
    var isScoreable: Boolean = false,
    var lastUpdated: String = "",
    var legacyThreadUrl: String = "",
    var nominationSummary: NominationSummary = NominationSummary(),
    var nsfw: Boolean = false,
    var offset: Int = 0,
    var playCount: Int = 0,
    var previewUrl: String = "",
    var source: String = "",
    var spotlight: Boolean = false,
    var status: String = "",
    var submittedDate: String = "",
    var tags: String = "",
    var title: String = "",
    var titleUnicode: String = "",
    var trackId: Long = 0L,
    var userId: Long = 0L,
    var video: Boolean = false
) {
    data class Availability(
        var downloadDisabled: Boolean = false,
        var moreInformation: String = ""
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