package com.madsam.otora.data.osu.ui.model

/**
 * osu!最近游玩UI模型
 */
internal data class OsuRecentUiModel(
    val username: String = "",
    val type: String = "",
    val rank: String = "",
    val scoreRank: String = "",
    val beatmapTitle: String = "",
    val beatmapSetTitle: String = "",
    val createdAt: String = "",
    val mode: String = "",
    val achievement: String = "",
    val modeAchievement: String = "",
    val achievementIcon: String = "",
    val approval: String = ""
)