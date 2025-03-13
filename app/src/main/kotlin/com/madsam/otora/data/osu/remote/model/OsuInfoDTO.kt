package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuInfoDTO(
    var achievements: List<OsuMedalItemDTO> = emptyList(),
    @Json(name = "current_mode") var currentMode: String = "",
    @Json(name = "scores_notice") var scoresNotice: String = "",
    var user: OsuUserExtendDTO = OsuUserExtendDTO()
)
