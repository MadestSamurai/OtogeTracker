package com.madsam.otora.data.osu.remote.model

internal data class OsuBeatmapStatisticsDTO(
    var ok: Int = 0,
    var meh: Int = 0,
    var good: Int = 0,
    var miss: Int = 0,
    var great: Int = 0,
    var perfect: Int = 0
)