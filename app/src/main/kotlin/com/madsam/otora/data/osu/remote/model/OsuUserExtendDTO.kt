package com.madsam.otora.data.osu.remote.model

import com.squareup.moshi.Json

internal data class OsuUserExtendDTO(
    @param:Json(name = "avatar_url") var avatarUrl: String = "",
    @param:Json(name = "country_code") var countryCode: String = "",
    @param:Json(name = "default_group") var defaultGroup: String = "",
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
    @param:Json(name = "cover_url") var coverUrl: String = "",
    var discord: String = "",
    var interests: String = "",
    @param:Json(name = "join_date") var joinDate: String = "",
    var location: String = "",
    @param:Json(name = "max_blocks") var maxBlocks: String = "",
    @param:Json(name = "max_friends") var maxFriends: String = "",
    var occupation: String = "",
    var playmode: String = "",
    var playstyle: List<String> = emptyList(),
    @param:Json(name = "post_count") var postCount: Int = 0,
    @param:Json(name = "profile_order") var profileOrder: List<String> = emptyList(),
    var title: String = "",
    @param:Json(name = "title_url") var titleUrl: String = "",
    var twitter: String = "",
    var website: String = "",
    var country: Country = Country(),
    var cover: Cover = Cover(),
    @param:Json(name = "is_admin") var isAdmin: Boolean = false,
    @param:Json(name = "is_bng") var isBng: Boolean = false,
    @param:Json(name = "is_full_bn") var isFullBn: Boolean = false,
    @param:Json(name = "is_gmt") var isGmt: Boolean = false,
    @param:Json(name = "is_limited_bn") var isLimitedBn: Boolean = false,
    @param:Json(name = "is_nat") var isNat: Boolean = false,
    @param:Json(name = "is_restricted") var isRestricted: Boolean = false,
    @param:Json(name = "is_silenced") var isSilenced: Boolean = false,
    var kudosu: Kudosu = Kudosu(),
    @param:Json(name = "account_history") var accountHistory: List<String> = emptyList(),
    @param:Json(name = "active_tournament_banner") var activeTournamentBanner: ActiveTournamentBanner = ActiveTournamentBanner(),
    @param:Json(name = "active_tournament_banners") var activeTournamentBanners: List<ActiveTournamentBanner> = emptyList(),
    var badges: List<Badge> = emptyList(),
    @param:Json(name = "comments_count") var commentsCount: Int = 0,
    @param:Json(name = "follower_count") var followerCount: Int = 0,
    var groups: List<OsuGroupDTO> = emptyList(),
    @param:Json(name = "mapping_follower_count") var mappingFollowerCount: Int = 0,
    @param:Json(name = "pending_beatmapset_count") var pendingBeatmapsetCount: Int = 0,
    @param:Json(name = "previous_usernames") var previousUsernames: List<String> = emptyList(),
    @param:Json(name = "rank_highest") var rankHighest: RankHighest = RankHighest(),
    var statistics: OsuStatisticsDTO = OsuStatisticsDTO(),
    @param:Json(name = "support_level") var supportLevel: Int = 0,
    @param:Json(name = "user_achievements") var userAchievements: List<UserAchievement> = emptyList(),
    @param:Json(name = "rank_history") var rankHistory: RankHistory = RankHistory(),
    @param:Json(name = "unranked_beatmapset_count") var unrankedBeatmapsetCount: Int = 0
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

    internal data class Kudosu(
        var total: Int = 0,
        var available: Int = 0
    )

    internal data class ActiveTournamentBanner(
        var id: Long = 0,
        @param:Json(name = "tournament_id") var tournamentId: Long = 0,
        var image: String = "",
        @param:Json(name = "image@2x") var image2x: String = ""
    )

    internal data class Badge(
        @param:Json(name = "awarded_at") var awardedAt: String = "",
        var description: String = "",
        @param:Json(name = "image@2x_url") var image2xUrl: String = "",
        @param:Json(name = "image_url") var imageUrl: String = "",
        var url: String = ""
    )

    internal data class RankHighest(
        var rank: Int = 0,
        @param:Json(name = "updated_at") var updatedAt: String = ""
    )

    internal data class UserAchievement(
        @param:Json(name = "achieved_at") var achievedAt: String = "",
        @param:Json(name = "achievement_id") var achievementId: String = ""
    )

    internal data class RankHistory(
        var mode: String = "",
        var data: List<Int> = listOf()
    )
}