package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuGroupDTO(
    var colour: String = "",
    @Json(name = "has_listing") var hasListing: Boolean = false,
    @Json(name = "has_playmodes") var hasPlaymodes: Boolean = false,
    var id: Int = 0,
    var identifier: String = "",
    @Json(name = "is_probationary") var isProbationary: Boolean = false,
    var name: String = "",
    @Json(name = "short_name") var shortName: String = "",
    var playmodes: List<String> = emptyList()
)