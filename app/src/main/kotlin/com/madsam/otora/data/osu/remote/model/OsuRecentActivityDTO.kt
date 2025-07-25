package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuRecentActivityDTO(
    @param:Json(name = "created_at") val createdAt: String = "",
    val id: Long = 0,
    val type: String = "",
    val scoreRank: String = "",
    val rank: Int = 0,
    val mode: String = "",
    val beatmap: Beatmap = Beatmap(),
    val beatmapset: Beatmapset = Beatmapset(),
    val achievement: OsuMedalItemDTO = OsuMedalItemDTO(),
    val approval: String = "",
    val user: User = User(),
) {
    internal data class Beatmap(
        val title: String = "",
        val url: String = "",
    )

    internal data class Beatmapset(
        val title: String = "",
        val url: String = "",
    )

    internal data class User(
        val username: String = "",
        val url: String = "",
    )
}