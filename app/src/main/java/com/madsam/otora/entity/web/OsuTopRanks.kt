package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuTopRanks
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu最好排名实体类
 */

data class OsuTopRanks(
    var best: OsuTopRankRecord = OsuTopRankRecord(),
    var firsts: OsuTopRankRecord = OsuTopRankRecord(),
    var pinned: OsuTopRankRecord = OsuTopRankRecord()
)
