package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuUserDTO(
    @Json(name = "avatar_url") var avatarUrl: String = "",
    @Json(name = "country_code") var countryCode: String = "",
    @Json(name = "default_group") var defaultGroup: String = "",
    var id: Long = 0L,
    @Json(name = "is_active") var isActive: Boolean = false,
    @Json(name = "is_bot") var isBot: Boolean = false,
    @Json(name = "is_deleted") var isDeleted: Boolean = false,
    @Json(name = "is_online") var isOnline: Boolean = false,
    @Json(name = "is_supporter") var isSupporter: Boolean = false,
    @Json(name = "last_visit") var lastVisit: String = "",
    @Json(name = "pm_friends_only") var pmFriendsOnly: Boolean = false,
    @Json(name = "profile_colour") var profileColour: String = "",
    var username: String = ""
)