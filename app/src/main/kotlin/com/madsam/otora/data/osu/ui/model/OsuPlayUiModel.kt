package com.madsam.otora.data.osu.ui.model

/**
 * osu!用户游玩信息UI模型
 */
internal data class OsuPlayUiModel(
    val sshCount: Long = 0,
    val ssCount: Long = 0,
    val shCount: Long = 0,
    val sCount: Long = 0,
    val aCount: Long = 0,
    val medalCount: Int = 0,
    val pp: Double = 0.0,
    val playTime: String = "",
    val rankedScore: String = "",
    val hitAccuracy: String = "",
    val playCount: String = "",
    val totalScore: String = "",
    val totalHits: String = "",
    val maximumCombo: String = "",
    val replaysWatchedByOthers: String = "",
    val followerCount: String = "",
    val mappingFollowerCount: String = "",
    val postCount: String = "",
    val commentsCount: String = ""
)
