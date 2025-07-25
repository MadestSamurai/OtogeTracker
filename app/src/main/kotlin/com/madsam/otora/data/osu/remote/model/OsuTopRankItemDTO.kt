package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuTopRankItemDTO(
    @param:Json(name = "classic_total_score") var classicTotalScore: Long = 0L,
    var ranked: Boolean = false,
    var preserve: Boolean = false,
    var processed: Boolean = false,
    @param:Json(name = "maximum_statistics") var maximumStatistics: MaximumStatistics = MaximumStatistics(),
    var mods: List<Mod> = listOf(),
    var statistics: OsuBeatmapStatisticsDTO = OsuBeatmapStatisticsDTO(),
    @param:Json(name = "beatmap_id") var beatmapId: Int = 0,
    @param:Json(name = "best_id") var bestId: Int = 0,
    var id: Long = 0L,
    var rank: String = "",
    var type: String = "",
    @param:Json(name = "user_id") var userId: Long = 0L,
    var accuracy: Double = 0.0,
    @param:Json(name = "build_id") var buildId: String = "",
    @param:Json(name = "ended_at") var endedAt: String = "",
    @param:Json(name = "has_replay") var hasReplay: Boolean = false,
    @param:Json(name = "is_perfect_combo") var isPerfectCombo: Boolean = false,
    @param:Json(name = "legacy_perfect") var legacyPerfect: Boolean = false,
    @param:Json(name = "legacy_score_id") var legacyScoreId: Long = 0L,
    @param:Json(name = "legacy_total_score") var legacyTotalScore: Long = 0L,
    @param:Json(name = "max_combo") var maxCombo: Long = 0L,
    var passed: Boolean = false,
    var pp: Double = 0.0,
    @param:Json(name = "ruleset_id") var rulesetId: Long = 0L,
    @param:Json(name = "started_at") var startedAt: String = "",
    @param:Json(name = "total_score") var totalScore: Long = 0L,
    var replay: Boolean = false,
    @param:Json(name = "current_user_attributes") var currentUserAttributes: CurrentUserAttributes = CurrentUserAttributes(),
    var beatmap: OsuBeatmapDTO = OsuBeatmapDTO(),
    @param:Json(name = "beatmapset") var beatmapSet: OsuBeatmapSetDTO = OsuBeatmapSetDTO(),
    var user: OsuUserDTO = OsuUserDTO(),
    var weight: Weight = Weight()
) {
    internal data class MaximumStatistics(
        var perfect: Int = 0,
        @param:Json(name = "legacy_combo_increase") var legacyComboIncrease: Int = 0
    )

    internal data class Mod(
        var acronym: String = ""
    )

    internal data class CurrentUserAttributes(
        var pin: String = ""
    )

    internal data class Weight(
        var percentage: Double = 0.0,
        var pp: Double = 0.0
    )
}