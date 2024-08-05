package com.madsam.otora.entity.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuUserExtend
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu用户扩展实体类
 */

data class OsuUserExtend(
        var avatarUrl: String = "",
        var countryCode: String = "",
        var defaultGroup: String = "",
        var id: Long = 0,
        var isActive: Boolean = false,
        var isBot: Boolean = false,
        var isDeleted: Boolean = false,
        var isOnline: Boolean = false,
        var isSupporter: Boolean = false,
        var lastVisit: String = "",
        var pmFriendsOnly: Boolean = false,
        var profileColour: String = "",
        var username: String = "",
        var coverUrl: String = "",
        var discord: String = "",
        var interests: String = "",
        var joinDate: String = "",
        var location: String = "",
        var maxBlocks: String = "",
        var maxFriends: String = "",
        var occupation: String = "",
        var playmode: String = "",
        var playstyle: List<String> = emptyList(),
        var postCount: Int = 0,
        var profileOrder: List<String> = emptyList(),
        var title: String = "",
        var titleUrl: String = "",
        var twitter: String = "",
        var website: String = "",
        var country: Country = Country(),
        var cover: Cover = Cover(),
        var isAdmin: Boolean = false,
        var isBng: Boolean = false,
        var isFullBn: Boolean = false,
        var isGmt: Boolean = false,
        var isLimitedBn: Boolean = false,
        var isNat: Boolean = false,
        var isRestricted: Boolean = false,
        var isSilenced: Boolean = false,
        var kudosu: Kudosu = Kudosu(),
        var accountHistory: List<String> = emptyList(),
        var activeTournamentBanner: ActiveTournamentBanner = ActiveTournamentBanner(),
        var activeTournamentBanners: List<ActiveTournamentBanner> = emptyList(),
        var badges: List<Badge> = emptyList(),
        var commentsCount: Int = 0,
        var followerCount: Int = 0,
        var groups: List<OsuGroup> = emptyList(),
        var mappingFollowerCount: Int = 0,
        var pendingBeatmapsetCount: Int = 0,
        var previousUsernames: List<String> = emptyList(),
        var rankHighest: RankHighest = RankHighest(),
        var statistics: OsuStatistics = OsuStatistics(),
        var supportLevel: Int = 0,
        var userAchievements: List<UserAchievement> = emptyList(),
        var rankHistory: RankHistory = RankHistory(),
        var unrankedBeatmapsetCount: Int = 0
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

    data class Kudosu(
            var total: Int = 0,
            var available: Int = 0
    )

    data class ActiveTournamentBanner(
            var id: Long = 0,
            var tournamentId: Long = 0,
            var image: String = "",
            @Json(name = "image@2x") var image2x: String = ""
    )

    data class Badge(
            var awardedAt: String = "",
            var description: String = "",
            @Json(name = "image@2x_url") var image2xUrl: String = "",
            var imageUrl: String = "",
            var url: String = ""
    )

    data class RankHighest(
            var rank: Int = 0,
            var updatedAt: String = ""
    )

    data class UserAchievement(
            var achievedAt: String = "",
            var achievementId: String = ""
    )

    data class RankHistory(
            var mode: String = "",
            var data: List<Int> = emptyList()
    )
}
