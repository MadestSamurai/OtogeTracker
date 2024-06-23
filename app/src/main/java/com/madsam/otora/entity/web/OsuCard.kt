package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.cards.OsuCard
 * 创建者: MadSamurai
 * 创建时间: 2024/3/6
 * 描述: Osu信息卡实体类
 */
data class OsuCard(
    var avatarUrl: String = "",
    var countryCode: String = "",
    var defaultGroup: String = "",
    var id: Long = 0L,
    var isActive: Boolean = false,
    var isBot: Boolean = false,
    var isDeleted: Boolean = false,
    var isOnline: Boolean = false,
    var isSupporter: Boolean = false,
    var lastVisit: String = "",
    var pmFriendsOnly: Boolean = false,
    var profileColour: String = "",
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
        var customUrl: String = "",
        var url: String = "",
        var id: String = ""
    )
}