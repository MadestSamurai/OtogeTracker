package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuTopRankRecord
 * 创建者: MadSamurai
 * 创建时间: 2024/3/11
 * 描述: Osu最好排名记录实体类
 */

data class OsuTopRankRecord(
    var count: Int = 0,
    var items: List<OsuTopRankItem> = listOf(),
    var pagination: OsuPagination = OsuPagination()
)
