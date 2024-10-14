package com.madsam.otora.model.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.cards.OsuCard
 * 创建者: MadSamurai
 * 创建时间: 2024/3/6
 * 描述: Osu信息卡实体类
 */
data class OsuCard(
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
    var username: String = "",
    var country: Country = Country(),
    var cover: Cover = Cover(),
    var groups: List<OsuGroup> = emptyList()
) {
    data class Country(
        var code: String = "",
        var name: String = ""
    )

    data class Cover(
        @Json(name = "custom_url") var customUrl: String = "",
        var url: String = "",
        var id: String = ""
    )
}