package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuStatisticsDTO(
    @Json(name = "count_100") var count100: Long = 0,
    @Json(name = "count_300") var count300: Long = 0,
    @Json(name = "count_50") var count50: Long = 0,
    @Json(name = "count_miss") var countMiss: Long = 0,
    var level: Level = Level(),
    @Json(name = "global_rank") var globalRank: Int = 0,
    @Json(name = "global_rank_exp") var globalRankExp: Int = 0,
    var pp: Double = 0.0,
    @Json(name = "pp_exp") var ppExp: Double = 0.0,
    @Json(name = "ranked_score") var rankedScore: Long = 0,
    @Json(name = "hit_accuracy") var hitAccuracy: Double = 0.0,
    @Json(name = "play_count") var playCount: Int = 0,
    @Json(name = "play_time") var playTime: Int = 0,
    @Json(name = "total_score") var totalScore: Long = 0,
    @Json(name = "total_hits") var totalHits: Long = 0,
    @Json(name = "maximum_combo") var maximumCombo: Int = 0,
    @Json(name = "replays_watched_by_others") var replaysWatchedByOthers: Int = 0,
    @Json(name = "is_ranked") var isRanked: Boolean = false,
    @Json(name = "grade_counts") var gradeCounts: GradeCounts = GradeCounts(),
    @Json(name = "country_rank") var countryRank: Int = 0,
    var rank: Rank = Rank(),
    var variants: List<Variant> = emptyList()
) {
    internal data class Level(
        var current: Long = 0,
        var progress: Long = 0
    )

    internal data class GradeCounts(
        var ss: Long = 0,
        var ssh: Long = 0,
        var s: Long = 0,
        var sh: Long = 0,
        var a: Long = 0
    )

    internal data class Rank(
        @Json(name = "country") var country: Int = 0
    )

    internal data class Variant(
        var mode: String = "",
        var variant: String = "",
        @Json(name = "country_rank") var countryRank: Int = 0,
        @Json(name = "global_rank") var globalRank: Int = 0,
        var pp: Double = 0.0
    )
}