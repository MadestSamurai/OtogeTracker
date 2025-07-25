package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json

internal data class BofRangeDTO(
    @param:Json(name = "name") var name: String = "",
    @param:Json(name = "start") var start: String = "",
    @param:Json(name = "end") var end: String = ""
)