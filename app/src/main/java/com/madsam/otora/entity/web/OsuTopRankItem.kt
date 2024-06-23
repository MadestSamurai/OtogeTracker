package com.madsam.otora.entity.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuTopRankItem
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu最好排名成绩元素实体类
 */

data class OsuTopRankItem(
    var ranked: Boolean = false,
    var preserve: Boolean = false,
    var maximumStatistics: MaximumStatistics = MaximumStatistics(),
    var mods: List<Mod> = listOf(),
    var statistics: OsuBeatmapStatistics = OsuBeatmapStatistics(),
    var beatmapId: Int = 0,
    var bestId: Int = 0,
    var id: Long = 0L,
    var rank: String = "",
    var type: String = "",
    var userId: Long = 0L,
    var accuracy: Double = 0.0,
    var buildId: String = "",
    var endedAt: String = "",
    var hasReplay: Boolean = false,
    var isPerfectCombo: Boolean = false,
    var legacyPerfect: Boolean = false,
    var legacyScoreId: Long = 0L,
    var legacyTotalScore: Long = 0L,
    var maxCombo: Long = 0L,
    var passed: Boolean = false,
    var pp: Double = 0.0,
    var rulesetId: Long = 0L,
    var startedAt: String = "",
    var totalScore: Long = 0L,
    var replay: Boolean = false,
    var currentUserAttributes: CurrentUserAttributes = CurrentUserAttributes(),
    var beatmap: OsuBeatmap = OsuBeatmap(),
    @Json(name = "beatmapset")
    var beatmapSet: OsuBeatmapSet = OsuBeatmapSet(),
    var user: OsuUser = OsuUser(),
    var weight: Weight = Weight()
) {
    data class MaximumStatistics(
        var perfect: Int = 0,
        var legacyComboIncrease: Int = 0
    )

    data class Mod(
        var acronym: String = ""
    )

    data class CurrentUserAttributes(
        var pin: String = ""
    )

    data class Weight(
        var percentage: Double = 0.0,
        var pp: Double = 0.0
    )
}