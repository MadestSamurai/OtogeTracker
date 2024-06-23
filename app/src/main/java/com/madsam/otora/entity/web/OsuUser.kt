package com.madsam.otora.entity.web

/**
 * 项目名: OtogeTracker
 * 文件名: OsuUse
 * 创建者: MadSamurai
 * 创建时间: 2024/3/7
 * 描述: Osu用户实体类
 */

data class OsuUser(
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
    var username: String = ""
)