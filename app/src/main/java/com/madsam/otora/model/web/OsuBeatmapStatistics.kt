package com.madsam.otora.model.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuBeatmapStatistics
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu谱面判定数据实体类
 */

data class OsuBeatmapStatistics(
    var ok: Int = 0,
    var meh: Int = 0,
    var good: Int = 0,
    var miss: Int = 0,
    var great: Int = 0,
    var perfect: Int = 0
)