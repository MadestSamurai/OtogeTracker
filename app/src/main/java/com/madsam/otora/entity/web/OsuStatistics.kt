package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuStatistics
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: osu统计数据实体类
 */
data class OsuStatistics(
    var count100: Long = 0,
    var count300: Long = 0,
    var count50: Long = 0,
    var countMiss: Long = 0,
    var level: Level = Level(),
    var globalRank: Int = 0,
    var globalRankExp: Int = 0,
    var pp: Double = 0.0,
    var ppExp: Double = 0.0,
    var rankedScore: Long = 0,
    var hitAccuracy: Double = 0.0,
    var playCount: Int = 0,
    var playTime: Int = 0,
    var totalScore: Long = 0,
    var totalHits: Long = 0,
    var maximumCombo: Int = 0,
    var replaysWatchedByOthers: Int = 0,
    var isRanked: Boolean = false,
    var gradeCounts: GradeCounts = GradeCounts(),
    var countryRank: Int = 0,
    var rank: Rank = Rank(),
    var variants: List<Variant> = emptyList()
) {
    data class Level(
        var current: Long = 0,
        var progress: Long = 0
    )

    data class GradeCounts(
        var ss: Long = 0,
        var ssh: Long = 0,
        var s: Long = 0,
        var sh: Long = 0,
        var a: Long = 0
    )

    data class Rank(
        var country: Int = 0
    )

    data class Variant(
        var mode: String = "",
        var variant: String = "",
        var countryRank: Int = 0,
        var globalRank: Int = 0,
        var pp: Double = 0.0
    )
}