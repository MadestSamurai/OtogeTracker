package com.madsam.otora.data.osu.ui.model

/**
 * osu!用户信息卡片UI模型
 */
internal data class OsuCardUiModel(
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
    val profileHue: Int? = null,
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
    val tournamentBannerImage2x: String = "",
    val teamId: Int = 0,
    val teamName: String = "",
    val teamShortName: String = "",
    val teamFlagUrl: String = ""
)
