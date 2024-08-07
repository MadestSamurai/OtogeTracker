package com.madsam.otora.entity.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.entity.web.OsuRecentActivity
 * 创建者: MadSamurai
 * 创建时间: 2024/8/7
 * 描述: TODO
 */
data class OsuRecentActivity(
    @Json(name = "created_at") val createdAt: String = "",
    val id: Long = 0,
    val type: String = "",
    val scoreRank: String = "",
    val rank: Int = 0,
    val mode: String = "",
    val beatmap: Beatmap = Beatmap(),
    val beatmapset: Beatmapset = Beatmapset(),
    val user: User = User(),
) {
    data class Beatmap(
        val title: String = "",
        val url: String = "",
    )

    data class Beatmapset(
        val title: String = "",
        val url: String = "",
    )

    data class User(
        val username: String = "",
        val url: String = "",
    )
}