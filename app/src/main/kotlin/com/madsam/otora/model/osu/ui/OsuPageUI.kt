package com.madsam.otora.model.osu.ui

/**
 * 通用简略列表项UI模型
 * 用于处理需要分页加载或部分加载的列表数据
 * @param T 列表中的数据类型
 * @property items 当前已加载的列表数据
 * @property isComplete 标识列表是否已全部加载完成
 */
data class BriefUI<T>(
    val items: List<T> = emptyList(),
    val isComplete: Boolean = false
)

/**
 * osu!用户信息卡片UI模型
 * @property username 用户名
 * @property country 国家
 * @property flagUrl 国旗URL
 * @property avatarUrl 头像URL
 * @property coverUrl 封面URL
 * @property customCoverUrl 自定义封面URL
 * @property isOnline 是否在线
 * @property isBot 是否为机器人
 * @property isDeleted 是否已删除
 * @property profileColour 个人资料颜色
 * @property isTitle 是否有称号
 * @property title 称号
 * @property currentMode 当前模式
 * @property isSupporter 是否为支持者
 * @property supporterRank 支持者等级
 * @property rank 排名
 * @property countryRank 国家排名
 * @property formerUsernames 以前的用户名
 * @property maniaModeGlobalRank mania模式全球排名
 * @property maniaModeCountryRank mania模式国家排名
 * @property tournamentBannerImage2x 赛事横幅2倍图像
 */
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

/**
 * osu!用户游玩信息UI模型
 * @property sshCount SS+次数
 * @property ssCount SS次数
 * @property shCount S+次数
 * @property sCount S次数
 * @property aCount A次数
 * @property medalCount 奖牌数量
 * @property pp PP值
 * @property playTime 游戏时间
 * @property rankedScore 排名分数
 * @property hitAccuracy 命中准确性
 * @property playCount 游玩次数
 * @property totalScore 总分数
 * @property totalHits 总命中数
 * @property maximumCombo 最大连击
 * @property replaysWatchedByOthers 其他人观看的录像数量
 * @property followerCount 关注者数量
 * @property mappingFollowerCount 地图制作关注者数量
 * @property postCount 发帖数量
 * @property commentsCount 评论数量
 */
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
    val scoreId: Long = 0,
    val cover2x: String = "",
    val bg2x: String = "",
    val beatmapSetTitle: String = "",
    val beatmapSetTitleUnicode: String = "",
    val beatmapSubTitle: String = "",
    val artist: String = "",
    val artistUnicode: String = "",
    val creator: String = "",
    val mode: String = "",
    val difficultyRating: Double = 0.0,
    val pp: Double = 0.0,
    val accuracy: String = "",
    val accuracyV2: String = "",
    val rank: String = "",
    val date: String = "",
    val maxCombo: Long = 0,
    val score: Long = 0,
    val scoreV2 : Long = 0,
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