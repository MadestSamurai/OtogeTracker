package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuCardDTO(
    @param:Json(name = "avatar_url") var avatarUrl: String = "",
    @param:Json(name = "country_code") var countryCode: String = "",
    @param:Json(name = "default_group") var defaultGroup: String = "",
    var id: Long = 0L,
    @param:Json(name = "is_active") var isActive: Boolean = false,
    @param:Json(name = "is_bot") var isBot: Boolean = false,
    @param:Json(name = "is_deleted") var isDeleted: Boolean = false,
    @param:Json(name = "is_online") var isOnline: Boolean = false,
    @param:Json(name = "is_supporter") var isSupporter: Boolean = false,
    @param:Json(name = "last_visit") var lastVisit: String = "",
    @param:Json(name = "pm_friends_only") var pmFriendsOnly: Boolean = false,
    @param:Json(name = "profile_colour") var profileColour: String = "",
    @param:Json(name = "profile_hue") var profileHue: Int? = null,
    var username: String = "",
    var country: Country = Country(),
    var cover: Cover = Cover(),
    var groups: List<OsuGroupDTO> = emptyList()
) {
    internal data class Country(
        var code: String = "",
        var name: String = ""
    )

    internal data class Cover(
        @param:Json(name = "custom_url") var customUrl: String = "",
        var url: String = "",
        var id: String = ""
    )
}