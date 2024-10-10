package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.web.OsuCardList
 * 创建者: MadSamurai
 * 创建时间: 2024/10/10
 * 描述: Osu信息卡列表实体类
 */
data class OsuCardList(
    var users: List<OsuCard> = emptyList()
)
