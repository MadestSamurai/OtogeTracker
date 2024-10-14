package com.madsam.otora.model.web

import com.squareup.moshi.Json

/**
 * 项目名: OtogeTracker
 * 文件名: OsuUserExtend
 * 创建者: MadSamurai
 * 创建时间: 2024/3/14
 * 描述: Osu用户扩展实体类
 */

data class OsuUserExtend(
        @Json(name = "avatar_url") var avatarUrl: String = "",
        @Json(name = "country_code") var countryCode: String = "",
        @Json(name = "default_group") var defaultGroup: String = "",
        @Json(name = "is_active") var isActive: Boolean = false,
        @Json(name = "is_bot") var isBot: Boolean = false,
        @Json(name = "is_deleted") var isDeleted: Boolean = false,
        @Json(name = "is_online") var isOnline: Boolean = false,
        @Json(name = "is_supporter") var isSupporter: Boolean = false,
        @Json(name = "last_visit") var lastVisit: String = "",
        @Json(name = "pm_friends_only") var pmFriendsOnly: Boolean = false,
        @Json(name = "profile_colour") var profileColour: String = "",
        var username: String = "",
        @Json(name = "cover_url") var coverUrl: String = "",
        var discord: String = "",
        var interests: String = "",
        @Json(name = "join_date") var joinDate: String = "",
        var location: String = "",
        @Json(name = "max_blocks") var maxBlocks: String = "",
        @Json(name = "max_friends") var maxFriends: String = "",
        var occupation: String = "",
        var playmode: String = "",
        var playstyle: List<String> = emptyList(),
        @Json(name = "post_count") var postCount: Int = 0,
        @Json(name = "profile_order") var profileOrder: List<String> = emptyList(),
        var title: String = "",
        @Json(name = "title_url") var titleUrl: String = "",
        var twitter: String = "",
        var website: String = "",
        var country: Country = Country(),
        var cover: Cover = Cover(),
        @Json(name = "is_admin") var isAdmin: Boolean = false,
        @Json(name = "is_bng") var isBng: Boolean = false,
        @Json(name = "is_full_bn") var isFullBn: Boolean = false,
        @Json(name = "is_gmt") var isGmt: Boolean = false,
        @Json(name = "is_limited_bn") var isLimitedBn: Boolean = false,
        @Json(name = "is_nat") var isNat: Boolean = false,
        @Json(name = "is_restricted") var isRestricted: Boolean = false,
        @Json(name = "is_silenced") var isSilenced: Boolean = false,
        var kudosu: Kudosu = Kudosu(),
        @Json(name = "account_history") var accountHistory: List<String> = emptyList(),
        @Json(name = "active_tournament_banner") var activeTournamentBanner: ActiveTournamentBanner = ActiveTournamentBanner(),
        @Json(name = "active_tournament_banners") var activeTournamentBanners: List<ActiveTournamentBanner> = emptyList(),
        var badges: List<Badge> = emptyList(),
        @Json(name = "comments_count") var commentsCount: Int = 0,
        @Json(name = "follower_count") var followerCount: Int = 0,
        var groups: List<OsuGroup> = emptyList(),
        @Json(name = "mapping_follower_count") var mappingFollowerCount: Int = 0,
        @Json(name = "pending_beatmapset_count") var pendingBeatmapsetCount: Int = 0,
        @Json(name = "previous_usernames") var previousUsernames: List<String> = emptyList(),
        @Json(name = "rank_highest") var rankHighest: RankHighest = RankHighest(),
        var statistics: OsuStatistics = OsuStatistics(),
        @Json(name = "support_level") var supportLevel: Int = 0,
        @Json(name = "user_achievements") var userAchievements: List<UserAchievement> = emptyList(),
        @Json(name = "rank_history") var rankHistory: RankHistory = RankHistory(),
        @Json(name = "unranked_beatmapset_count") var unrankedBeatmapsetCount: Int = 0
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

        data class Kudosu(
                var total: Int = 0,
                var available: Int = 0
        )

        data class ActiveTournamentBanner(
                var id: Long = 0,
                @Json(name = "tournament_id") var tournamentId: Long = 0,
                var image: String = "",
                @Json(name = "image@2x") var image2x: String = ""
        )

        data class Badge(
                @Json(name = "awarded_at") var awardedAt: String = "",
                var description: String = "",
                @Json(name = "image@2x_url") var image2xUrl: String = "",
                @Json(name = "image_url") var imageUrl: String = "",
                var url: String = ""
        )

        data class RankHighest(
                var rank: Int = 0,
                @Json(name = "updated_at") var updatedAt: String = ""
        )

        data class UserAchievement(
                @Json(name = "achieved_at") var achievedAt: String = "",
                @Json(name = "achievement_id") var achievementId: String = ""
        )

        data class RankHistory(
                var mode: String = "",
                var data: List<Int> = emptyList()
        )
}