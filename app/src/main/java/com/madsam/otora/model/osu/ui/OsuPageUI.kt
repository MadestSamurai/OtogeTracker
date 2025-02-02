package com.madsam.otora.model.osu.ui

data class OsuCardUI(
    val username: String = "",
    val country: String = "",
    val flagUrl: String = "",
    val avatarUrl: String = "",
    val coverUrl: String = "",
    val customCoverUrl: String = "",
    val isOnline: Boolean = false,
    val isBot: Boolean = false,
    val isDeleted: Boolean = false,
    val profileColour: String = "#F5F5F5",
    val isTitle: Boolean = false,
    val title: String = "",
    val currentMode: String = "",
    val isSupporter: Boolean = false,
    val supporterRank: Int = 0,
    val rank: String = "",
    val countryRank: String = "",
    val formerUsernames: String = "",
    val maniaModeGlobalRank: String = "",
    val maniaModeCountryRank: String = "",
    val tournamentBannerImage2x: String = ""
)

data class OsuPlayUI(
    val sshCount: Long = 0,
    val ssCount: Long = 0,
    val shCount: Long = 0,
    val sCount: Long = 0,
    val aCount: Long = 0,
    val medalCount: Int = 0,
    val pp: Double = 0.0,
    val playTime: String = "",
    val rankedScore: String = "",
    val hitAccuracy: String = "",
    val playCount: String = "",
    val totalScore: String = "",
    val totalHits: String = "",
    val maximumCombo: String = "",
    val replaysWatchedByOthers: String = "",
    val followerCount: String = "",
    val mappingFollowerCount: String = "",
    val postCount: String = "",
    val commentsCount: String = ""
)

data class OsuBadgeUI(
    val awardedAt: String = "",
    val description: String = "",
    val image2xUrl: String = "",
    val url: String = ""
)

data class OsuLevelUI(
    val level: Long = 0,
    val levelProgress: Long = 0
)

data class OsuSocialUI(
    val discord: String = "",
    val twitter: String = "",
    val website: String = "",
    val location: String = "",
    val interests: String = "",
    val occupation: String = "",
    val joinDate: String = "",
    val lastVisit: String = "",
    val playStyle: String = ""
)

data class OsuTopRankUI(
    val cover2x: String = "",
    val bg2x: String = "",
    val beatmapSetTitle: String = "",
    val beatmapSetTitleUnicode: String = "",
    val beatmapSubTitle: String = "",
    val artist: String = "",
    val artistUnicode: String = "",
    val creator: String = "",
    val difficultyRating: Double = 0.0,
    val pp: Double = 0.0,
    val accuracy: String = "",
    val rank: String = "",
    val date: String = "",
    val maxCombo: Long = 0,
    val score: Long = 0,
    val totalScore: String = "",
    val weight: Double = 0.0,
    val weightPP: Double = 0.0,
    val mods: List<String> = listOf(),
    val beatmapId: Long = 0,
    val beatmapSetId: Long = 0,
    val status: String = ""
)

data class OsuRecentUI(
    val username: String = "",
    val type: String = "",
    val rank: String = "",
    val scoreRank: String = "",
    val beatmapTitle: String = "",
    val beatmapSetTitle: String = "",
    val createdAt: String = "",
    val mode: String = "",
    val achievement: String = "",
    val modeAchievement: String = "",
    val achievementIcon: String = "",
    val approval: String = ""
)