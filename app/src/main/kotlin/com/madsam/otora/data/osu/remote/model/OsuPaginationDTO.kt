package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuPaginationDTO(
    @Json(name = "has_more") var hasMore: Boolean = false
)
