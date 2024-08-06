package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.web.OsuRecentActivityList
 * 创建者: MadSamurai
 * 创建时间: 2024/8/7
 * 描述: TODO
 */
data class OsuRecentActivityList(
    val data: List<OsuRecentActivity> = emptyList(),
    val pagination: OsuPagination = OsuPagination()
)
