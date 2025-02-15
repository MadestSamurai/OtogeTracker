package com.madsam.otora.ui.record.viewmodel

import android.content.Context
import android.view.View
import androidx.compose.ui.unit.dp
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.consts.FlagsAlphabet
import com.madsam.otora.glance.SmallWidget
import com.madsam.otora.model.osu.ui.OsuBadgeUI
import com.madsam.otora.model.osu.ui.OsuCardUI
import com.madsam.otora.model.osu.ui.OsuGlanceUI
import com.madsam.otora.model.osu.ui.OsuLevelUI
import com.madsam.otora.model.osu.ui.OsuPlayUI
import com.madsam.otora.model.osu.ui.OsuRecentUI
import com.madsam.otora.model.osu.ui.OsuSocialUI
import com.madsam.otora.model.osu.ui.OsuTopRankUI
import com.madsam.otora.model.osu.web.OsuCardList
import com.madsam.otora.model.osu.web.OsuGroup
import com.madsam.otora.model.osu.web.OsuInfo
import com.madsam.otora.model.osu.web.OsuRecentActivity
import com.madsam.otora.model.osu.web.OsuTopRankItem
import com.madsam.otora.service.OsuDataRequestService
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.CommonUtils.formatNumberThousand
import com.madsam.otora.utils.CommonUtils.formatPercent
import com.madsam.otora.utils.ScreenUtil.getSafeInsetLeftDp
import com.madsam.otora.utils.ScreenUtil.getSafeInsetRightDp
import com.madsam.otora.utils.ShareUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * 项目名: OtogeTracker
 * 文件名: RecordViewModel
 * 创建者: MadSamurai
 * 创建时间:2023/3/11 17:56
 * 描述: Osu视图模型
 */

class OsuViewModel(
    userId: String,
    mode: String,
    context: Context
) : ViewModel() {
    val cardUI = MutableStateFlow(OsuCardUI())
    val badgeUI = MutableStateFlow<List<OsuBadgeUI>>(emptyList())
    val groupListUI = MutableStateFlow<List<OsuGroup>>(emptyList())
    val rankGraphUI = MutableStateFlow<List<Int>>(emptyList())
    val playUI = MutableStateFlow(OsuPlayUI())
    val levelUI = MutableStateFlow(OsuLevelUI())
    val topRankUI = MutableStateFlow(OsuTopRankUI())
    val socialUI = MutableStateFlow(OsuSocialUI())
    val recentBrief = MutableStateFlow<List<OsuRecentUI>>(emptyList())
    val recentUI = MutableStateFlow<List<OsuRecentUI>>(emptyList())
    val pinnedUI = MutableStateFlow<List<OsuTopRankUI>>(emptyList())
    val firstUI = MutableStateFlow<List<OsuTopRankUI>>(emptyList())
    val bestUI = MutableStateFlow<List<OsuTopRankUI>>(emptyList())

    private val glanceUI = MutableStateFlow(OsuGlanceUI())

    val leftPadding = MutableStateFlow(0.dp)
    val rightPadding = MutableStateFlow(0.dp)

    init {
        loadData(userId, mode, context)
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO)

    fun updatePadding(view: View) {
        leftPadding.update { getSafeInsetLeftDp(view) }
        rightPadding.update { getSafeInsetRightDp(view) }
    }

    fun loadData(userId: String, mode: String, context: Context) {
        val osuDataRequestService = OsuDataRequestService()
        osuDataRequestService.getOsuMedals(
            { osuInfo: OsuInfo -> fetchMedals(osuInfo, context) }, userId, mode
        )
        osuDataRequestService.getOsuCard(
            { osuCardList: OsuCardList -> fetchCard(osuCardList) }, userId
        )
        osuDataRequestService.getOsuRecentActivity({ osuRecentActivity: List<OsuRecentActivity> ->
            fetchRecentActivity(osuRecentActivity)
        }, userId)
        osuDataRequestService.getOsuPinnedMap({ osuPinnedMap: List<OsuTopRankItem> ->
            fetchPinnedMap(osuPinnedMap)
        }, userId, mode)
        osuDataRequestService.getOsuFirstMap({ osuFirstMap: List<OsuTopRankItem> ->
            fetchFirstMap(osuFirstMap)
        }, userId, mode)
        osuDataRequestService.getOsuBestMap({ osuBestMap: List<OsuTopRankItem> ->
            fetchBestMap(osuBestMap)
        }, userId, mode)
//        osuDataRequestService.getOsuBeatmap({ osuUserBeatmap: OsuUserBeatmap -> setOsuUserBeatmap(osuUserBeatmap) }, userId, mode)
//        osuDataRequestService.getOsuHistorical({ osuHistorical: OsuHistorical -> setOsuHistorical(osuHistorical) }, userId, mode)
    }

    private fun fetchCard(osuCardList: OsuCardList) {
        if (osuCardList.users.isEmpty()) return

        val osuCard = osuCardList.users[0]
        cardUI.update {
            it.copy(
                username = osuCard.username,
                country = osuCard.country.name,
                flagUrl = FlagsAlphabet.getFlagAlphabet(osuCard.country.code),
                avatarUrl = osuCard.avatarUrl,
                coverUrl = osuCard.cover.url,
                customCoverUrl = osuCard.cover.customUrl,
                isOnline = osuCard.isOnline,
                isBot = osuCard.isBot,
                isDeleted = osuCard.isDeleted,
                profileColour = osuCard.profileColour.ifEmpty { "#F5F5F5" }
            )
        }
        groupListUI.value = osuCard.groups
    }

    private fun fetchRecentActivity(osuRecentActivityList: List<OsuRecentActivity>) {
        recentUI.update {
            osuRecentActivityList.map { activity ->
                OsuRecentUI(
                    username = activity.user.username,
                    type = activity.type,
                    rank = activity.rank.toString(),
                    scoreRank = activity.scoreRank,
                    beatmapTitle = activity.beatmap.title,
                    beatmapSetTitle = activity.beatmapset.title,
                    createdAt = activity.createdAt,
                    mode = activity.mode,
                    achievement = activity.achievement.name,
                    modeAchievement = activity.achievement.mode,
                    achievementIcon = activity.achievement.iconUrl,
                    approval = activity.approval
                )
            }
        }
        recentBrief.update {
            osuRecentActivityList.take(3).map { activity ->
                OsuRecentUI(
                    username = activity.user.username,
                    type = activity.type,
                    rank = activity.rank.toString(),
                    scoreRank = activity.scoreRank,
                    beatmapTitle = activity.beatmap.title,
                    beatmapSetTitle = activity.beatmapset.title,
                    createdAt = activity.createdAt,
                    mode = activity.mode,
                    achievement = activity.achievement.name,
                    modeAchievement = activity.achievement.mode,
                    achievementIcon = activity.achievement.iconUrl,
                    approval = activity.approval
                )
            }
        }
    }

    private fun fetchTopRankItem(item: OsuTopRankItem): OsuTopRankUI {
        val stats = item.statistics
        val accuracy = if (item.beatmap.mode == "mania") {
            ((stats.perfect + stats.great) + stats.good*2/3.0 + stats.ok/3.0 + stats.meh/6.0) /
                    item.maximumStatistics.perfect.toDouble()
        } else {
            item.accuracy
        }
        return OsuTopRankUI(
            cover2x = item.beatmapSet.covers.list2x,
            bg2x = item.beatmapSet.covers.card2x,
            beatmapSetTitle = item.beatmapSet.title,
            beatmapSetTitleUnicode = item.beatmapSet.titleUnicode,
            beatmapSubTitle = item.beatmap.version,
            artist = item.beatmapSet.artist,
            artistUnicode = item.beatmapSet.artistUnicode,
            creator = item.beatmapSet.creator,
            mode = item.beatmap.mode,
            difficultyRating = item.beatmap.difficultyRating,
            pp = item.pp,
            accuracy = formatPercent(accuracy),
            accuracyV2 = formatPercent(item.accuracy),
            rank = item.rank,
            date = item.endedAt,
            maxCombo = item.maxCombo,
            score = item.legacyTotalScore,
            scoreV2 = item.totalScore,
            mods = item.mods.map { it.acronym },
            weight = item.weight.percentage,
            weightPP = item.weight.pp,
            beatmapId = item.beatmap.id,
            beatmapSetId = item.beatmapSet.id,
            status = item.beatmapSet.status
        )
    }

    private fun fetchPinnedMap(osuPinnedMap: List<OsuTopRankItem>) {
        pinnedUI.update {
            osuPinnedMap.map { fetchTopRankItem(it) }
        }
    }

    private fun fetchFirstMap(osuFirstMap: List<OsuTopRankItem>) {
        firstUI.update {
            osuFirstMap.map { fetchTopRankItem(it) }
        }
    }

    private fun fetchBestMap(osuBestMap: List<OsuTopRankItem>) {
        bestUI.update {
            osuBestMap.map { fetchTopRankItem(it) }
        }
    }

    private fun fetchMedals(osuInfo: OsuInfo, context: Context) {
        cardUI.update {
            it.copy(
                isTitle = osuInfo.user.title.isNotEmpty(),
                title = osuInfo.user.title.ifEmpty { "" },
                currentMode = osuInfo.currentMode,
                isSupporter = osuInfo.user.isSupporter,
                supporterRank = osuInfo.user.supportLevel,
                rank = "#${osuInfo.user.statistics.globalRank}",
                countryRank = "#${osuInfo.user.statistics.countryRank}",
                formerUsernames = osuInfo.user.previousUsernames.joinToString(", "),
                maniaModeGlobalRank = if (osuInfo.currentMode == "mania") {
                    "4K: #${osuInfo.user.statistics.variants[0].globalRank}\n" +
                            "7K: #${osuInfo.user.statistics.variants[1].globalRank}"
                } else "",
                maniaModeCountryRank = if (osuInfo.currentMode == "mania") {
                    "4K: #${osuInfo.user.statistics.variants[0].countryRank}\n" +
                            "7K: #${osuInfo.user.statistics.variants[1].countryRank}"
                } else "",
                tournamentBannerImage2x = osuInfo.user.activeTournamentBanner.image2x
            )
        }

        rankGraphUI.value = osuInfo.user.rankHistory.data
        topRankUI.value = OsuTopRankUI(
            rank = osuInfo.user.rankHighest.rank.toString(),
            date = osuInfo.user.rankHighest.updatedAt
        )
        val playTime = if (osuInfo.user.statistics.playTime != 0) {
            CommonUtils.secondToDHMS(osuInfo.user.statistics.playTime.toLong())
        } else {
            "0,0,0,0"
        }

        playUI.update {
            it.copy(
                sshCount = osuInfo.user.statistics.gradeCounts.ssh,
                ssCount = osuInfo.user.statistics.gradeCounts.ss,
                shCount = osuInfo.user.statistics.gradeCounts.sh,
                sCount = osuInfo.user.statistics.gradeCounts.s,
                aCount = osuInfo.user.statistics.gradeCounts.a,
                medalCount = osuInfo.user.userAchievements.size,
                pp = osuInfo.user.statistics.pp,
                playTime = playTime,
                rankedScore = formatNumberThousand(osuInfo.user.statistics.rankedScore),
                hitAccuracy = formatPercent(osuInfo.user.statistics.hitAccuracy),
                playCount = formatNumberThousand(osuInfo.user.statistics.playCount.toLong()),
                totalScore = formatNumberThousand(osuInfo.user.statistics.totalScore),
                totalHits = formatNumberThousand(osuInfo.user.statistics.totalHits),
                maximumCombo = formatNumberThousand(osuInfo.user.statistics.maximumCombo.toLong()),
                replaysWatchedByOthers = formatNumberThousand(osuInfo.user.statistics.replaysWatchedByOthers.toLong()),
                followerCount = formatNumberThousand(osuInfo.user.followerCount.toLong()),
                mappingFollowerCount = formatNumberThousand(osuInfo.user.mappingFollowerCount.toLong()),
                postCount = formatNumberThousand(osuInfo.user.postCount.toLong()),
                commentsCount = formatNumberThousand(osuInfo.user.commentsCount.toLong())
            )
        }

        badgeUI.update {
            osuInfo.user.badges.map { badge ->
                OsuBadgeUI(
                    awardedAt = badge.awardedAt,
                    description = badge.description,
                    image2xUrl = badge.image2xUrl.ifEmpty { badge.imageUrl },
                    url = badge.url
                )
            }
        }

        levelUI.update {
            it.copy(
                level = osuInfo.user.statistics.level.current,
                levelProgress = osuInfo.user.statistics.level.progress
            )
        }

        socialUI.update {
            it.copy(
                discord = osuInfo.user.discord,
                twitter = osuInfo.user.twitter,
                website = osuInfo.user.website,
                location = osuInfo.user.location,
                interests = osuInfo.user.interests,
                occupation = osuInfo.user.occupation,
                joinDate = osuInfo.user.joinDate,
                lastVisit = osuInfo.user.lastVisit,
                playStyle = osuInfo.user.playstyle.joinToString(", ")
            )
        }

        glanceUI.update {
            it.copy(
                username = osuInfo.user.username,
                pp = osuInfo.user.statistics.pp,
            )
        }

        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val osuGlanceJson = moshi.adapter(OsuGlanceUI::class.java).toJson(glanceUI.value)
        ShareUtil.putString("osuGlance", osuGlanceJson, context)
        serviceScope.launch {
            val manager = GlanceAppWidgetManager(context)
            val widget = SmallWidget()
            val glanceIds = manager.getGlanceIds(widget.javaClass)
            glanceIds.forEach { glanceId ->
                widget.update(context, glanceId)
            }
        }
    }
}

class OsuViewModelFactory(
    private val userId: String,
    private val mode: String,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OsuViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OsuViewModel(userId, mode, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
