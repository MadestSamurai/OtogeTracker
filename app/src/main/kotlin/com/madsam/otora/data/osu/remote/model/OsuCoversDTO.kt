package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuCoversDTO(
    var cover: String = "",
    @Json(name = "cover@2x") var cover2x: String = "",
    var card: String = "",
    @Json(name = "card@2x") var card2x: String = "",
    var list: String = "",
    @Json(name = "list@2x") var list2x: String = "",
    @Json(name = "slimcover") var slimCover: String = "",
    @Json(name = "slimcover@2x") var slimCover2x: String = ""
)