package com.madsam.otora.data.bof.remote.model

import com.squareup.moshi.Json

data class BofRangeResponse(
    @param:Json(name = "path") var path: String = "",
    @param:Json(name = "start") var start: String = "",
    @param:Json(name = "current") var current: String = "",
    @param:Json(name = "short") var short: String = "",
    @param:Json(name = "full") var full: String = "",
    @param:Json(name = "isStart") var isStart: Boolean = false,
    @param:Json(name = "isEnd") var isEnd: Boolean = false,
    @param:Json(name = "singleComment") var singleComment: Boolean = false,
    @param:Json(name = "commentDate") var commentDate: String = ""
)