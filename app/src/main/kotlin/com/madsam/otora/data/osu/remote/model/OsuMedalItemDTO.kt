package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuMedalItemDTO(
    @param:Json(name = "icon_url") var iconUrl: String = "",
    var id: Long = 0L,
    var name: String = "",
    var grouping: String = "",
    var ordering: String = "",
    var description: String = "",
    var slug: String = "",
    var mode: String = "",
    var instructions: String = ""
)
