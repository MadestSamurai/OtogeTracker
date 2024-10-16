package com.madsam.otora.ui.record

import android.content.Context
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.consts.FlagsAlphabet
import com.madsam.otora.model.chuni.ChuniCard
import com.madsam.otora.model.web.OsuCardList
import com.madsam.otora.model.web.OsuGroup
import com.madsam.otora.model.web.OsuInfo
import com.madsam.otora.model.web.OsuRecentActivity
import com.madsam.otora.model.web.OsuTopRankItem
import com.madsam.otora.glance.SmallWidget
import com.madsam.otora.service.ChuniDataRequestService
import com.madsam.otora.service.OsuDataRequestService
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.ShareUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * 项目名: OtogeTracker
 * 文件名: RecordViewModel
 * 创建者: MadSamurai
 * 创建时间:2023/3/11 17:56
 * 描述: 记录页面ViewModel
 */

class RecordViewModel(
    userId: String,
    mode: String,
    context: Context
) : ViewModel() {
    // Osu
    val osuCardData = MutableStateFlow<Map<String, String>>(emptyMap())
    val osuBadgeList = MutableStateFlow<List<Map<String, String>>>(emptyList())
    private val osuGlanceData = MutableStateFlow<Map<String, String>>(emptyMap())
    val osuGroupList = MutableStateFlow<List<OsuGroup>>(emptyList())
    val osuRankGraphData = MutableStateFlow<List<Int>>(emptyList())
    val osuPlayData = MutableStateFlow<Map<String, String>>(emptyMap())
    val osuLevelData = MutableStateFlow<Map<String, String>>(emptyMap())
    val osuRankHighestData = MutableStateFlow<Map<String, String>>(emptyMap())
    val osuSocialCardData = MutableStateFlow<Map<String, String>>(emptyMap())

    val osuRecentActivityData = MutableStateFlow<List<Map<String, String>>>(emptyList())

    val osuPinnedMapData = MutableStateFlow<List<Map<String, String>>>(emptyList())
    val osuFirstMapData = MutableStateFlow<List<Map<String, String>>>(emptyList())
    val osuBestMapData = MutableStateFlow<List<Map<String, String>>>(emptyList())

    init {
        requestOsuData(userId, mode, context)
    }

    private val serviceScope = CoroutineScope(Dispatchers.IO)

    fun requestOsuData(userId: String, mode: String, context: Context) {
        val osuDataRequestService = OsuDataRequestService()
        osuDataRequestService.getOsuMedals({ osuInfo: OsuInfo -> setOsuMedals(osuInfo, context) }, userId, mode)
        osuDataRequestService.getOsuCard({ osuCardList: OsuCardList -> setOsuCard(osuCardList) }, userId)
        osuDataRequestService.getOsuRecentActivity({ osuRecentActivity: List<OsuRecentActivity> -> setOsuRecentActivity(osuRecentActivity) }, userId)
        osuDataRequestService.getOsuPinnedMap({ osuPinnedMap: List<OsuTopRankItem> -> setOsuPinnedMap(osuPinnedMap) }, userId, mode)
        osuDataRequestService.getOsuFirstMap({ osuFirstMap: List<OsuTopRankItem> -> setOsuFirstMap(osuFirstMap) }, userId, mode)
        osuDataRequestService.getOsuBestMap({ osuBestMap: List<OsuTopRankItem> -> setOsuBestMap(osuBestMap) }, userId, mode)
//        osuDataRequestService.getOsuBeatmap({ osuUserBeatmap: OsuUserBeatmap -> setOsuUserBeatmap(osuUserBeatmap) }, userId, mode)
//        osuDataRequestService.getOsuHistorical({ osuHistorical: OsuHistorical -> setOsuHistorical(osuHistorical) }, userId, mode)
    }

    fun requestChuniData(context: Context) {
        val chuniDataRequestService = ChuniDataRequestService(context)
        chuniDataRequestService.getUserData()
    }

    private fun setOsuCard(osuCardList: OsuCardList) {
        if (osuCardList.users.isEmpty()) {
            return
        }
        val osuCard = osuCardList.users[0]
        osuCardData.value += mapOf(
            "username" to osuCard.username,
            "country" to osuCard.country.name,
            "flagUrl" to FlagsAlphabet.getFlagAlphabet(osuCard.country.code),
            "avatarUrl" to osuCard.avatarUrl,
            "coverUrl" to osuCard.cover.url,
            "customCoverUrl" to osuCard.cover.customUrl,
            "isOnline" to if (osuCard.isOnline) "true" else "false",
            "isBot" to if (osuCard.isBot) "true" else "false",
            "isDeleted" to if (osuCard.isDeleted) "true" else "false",
            "profileColour" to osuCard.profileColour.ifEmpty { "#F5F5F5" }
        )
        osuGroupList.value = osuCard.groups
    }

    private fun setOsuRecentActivity(osuRecentActivityList: List<OsuRecentActivity>) {
        osuRecentActivityData.value = osuRecentActivityList.map { activity ->
            mapOf(
                "username" to activity.user.username,
                "type" to activity.type,
                "rank" to activity.rank.toString(),
                "scoreRank" to activity.scoreRank,
                "beatmapTitle" to activity.beatmap.title,
                "beatmapSetTitle" to activity.beatmapset.title,
                "createdAt" to activity.createdAt,
                "mode" to activity.mode,
                "achievement" to activity.achievement.name,
                "modeAchievement" to activity.achievement.mode,
                "achievementIcon" to activity.achievement.iconUrl,
                "approval" to activity.approval,
            )
        }
    }

    private fun mapOsuTopRankItem(item: OsuTopRankItem): Map<String, String> {
        return mapOf(
            "cover2x" to item.beatmapSet.covers.list2x,
            "bg2x" to item.beatmapSet.covers.card2x,
            "beatmapSetTitle" to item.beatmapSet.title,
            "beatmapSetTitleUnicode" to item.beatmapSet.titleUnicode,
            "beatmapSubTitle" to item.beatmap.version,
            "artist" to item.beatmapSet.artist,
            "artistUnicode" to item.beatmapSet.artistUnicode,
            "creator" to item.beatmapSet.creator,
            "difficultyRating" to item.beatmap.difficultyRating.toString(),
            "pp" to item.pp.toString(),
            "accuracy" to CommonUtils.formatPercent(item.accuracy),
            "rank" to item.rank,
            "date" to item.endedAt,
            "maxCombo" to item.maxCombo.toString(),
            "score" to item.legacyTotalScore.toString(),
            "mods" to item.mods.joinToString(", "),
            "totalScore" to CommonUtils.formatNumberThousand(item.totalScore),
            "weight" to item.weight.percentage.toString(),
            "weightPP" to item.weight.pp.toString(),
            "beatmapId" to item.beatmap.id.toString(),
            "beatmapSetId" to item.beatmapSet.id.toString(),
            "status" to item.beatmapSet.status,
        )
    }
    private fun setOsuPinnedMap(osuPinnedMap: List<OsuTopRankItem>) {
        osuPinnedMapData.value = osuPinnedMap.map { mapOsuTopRankItem(it) }
    }
    private fun setOsuFirstMap(osuFirstMap: List<OsuTopRankItem>) {
        osuFirstMapData.value = osuFirstMap.map { mapOsuTopRankItem(it) }
    }
    private fun setOsuBestMap(osuBestMap: List<OsuTopRankItem>) {
        osuBestMapData.value = osuBestMap.map { mapOsuTopRankItem(it) }
    }

    private fun setOsuMedals(osuInfo: OsuInfo, context: Context) {
        // check if title is null or empty
        if (osuInfo.user.title.isEmpty()) {
            osuCardData.value += mapOf(
                "isTitle" to "false"
            )
        } else {
            osuCardData.value += mapOf(
                "isTitle" to "true",
                "title" to osuInfo.user.title
            )
        }
        osuCardData.value += mapOf(
            "currentMode" to osuInfo.currentMode,
            "isSupporter" to if (osuInfo.user.isSupporter) "true" else "false",
            "supporterRank" to osuInfo.user.supportLevel.toString(),
            "rank" to "#" + osuInfo.user.statistics.globalRank.toString(),
            "countryRank" to "#${osuInfo.user.statistics.countryRank}",
            "formerUsernames" to osuInfo.user.previousUsernames.joinToString(", ")
        )
        if (osuInfo.currentMode == "mania") {
            osuCardData.value += mapOf(
                "maniaModeGlobalRank" to "4K: #${osuInfo.user.statistics.variants[0].globalRank}\n" +
                        "7K: #${osuInfo.user.statistics.variants[1].globalRank}",
                "maniaModeCountryRank" to "4K: #${osuInfo.user.statistics.variants[0].countryRank}\n" +
                        "7K: #${osuInfo.user.statistics.variants[1].countryRank}"
            )
        }
        osuCardData.value += mapOf(
            "tournamentBannerImage2x" to osuInfo.user.activeTournamentBanner.image2x
        )

        osuRankGraphData.value = osuInfo.user.rankHistory.data
        osuRankHighestData.value = mapOf(
            "rank" to osuInfo.user.rankHighest.rank.toString(),
            "date" to osuInfo.user.rankHighest.updatedAt
        )
        val playTime = if (osuInfo.user.statistics.playTime != 0) {
            CommonUtils.secondToDHMS(osuInfo.user.statistics.playTime.toLong())
        } else {
            "0,0,0,0"
        }

        osuPlayData.value = mapOf(
            "sshCount" to osuInfo.user.statistics.gradeCounts.ssh.toString(),
            "ssCount" to osuInfo.user.statistics.gradeCounts.ss.toString(),
            "shCount" to osuInfo.user.statistics.gradeCounts.sh.toString(),
            "sCount" to osuInfo.user.statistics.gradeCounts.s.toString(),
            "aCount" to osuInfo.user.statistics.gradeCounts.a.toString(),

            "medalCount" to osuInfo.user.userAchievements.size.toString(),
            "pp" to osuInfo.user.statistics.pp.toString(),
            "playTime" to playTime,

            "rankedScore" to CommonUtils.formatNumberThousand(osuInfo.user.statistics.rankedScore),
            "hitAccuracy" to CommonUtils.formatPercent(osuInfo.user.statistics.hitAccuracy),
            "playCount" to CommonUtils.formatNumberThousand(osuInfo.user.statistics.playCount.toLong()),
            "totalScore" to CommonUtils.formatNumberThousand(osuInfo.user.statistics.totalScore),
            "totalHits" to CommonUtils.formatNumberThousand(osuInfo.user.statistics.totalHits),
            "maximumCombo" to CommonUtils.formatNumberThousand(osuInfo.user.statistics.maximumCombo.toLong()),
            "replaysWatchedByOthers" to CommonUtils.formatNumberThousand(osuInfo.user.statistics.replaysWatchedByOthers.toLong()),
            "followerCount" to CommonUtils.formatNumberThousand(osuInfo.user.followerCount.toLong()),
            "mappingFollowerCount" to CommonUtils.formatNumberThousand(osuInfo.user.mappingFollowerCount.toLong()),
            "postCount" to CommonUtils.formatNumberThousand(osuInfo.user.postCount.toLong()),
            "commentsCount" to CommonUtils.formatNumberThousand(osuInfo.user.commentsCount.toLong()),
        )
        osuBadgeList.value = osuInfo.user.badges.map { badge ->
            mapOf(
                "awardedAt" to badge.awardedAt,
                "description" to badge.description,
                "image2xUrl" to badge.image2xUrl.ifEmpty {
                    badge.imageUrl
                },
                "url" to badge.url
            )
        }

        osuLevelData.value = mapOf(
            "level" to osuInfo.user.statistics.level.current.toString(),
            "levelProgress" to osuInfo.user.statistics.level.progress.toString()
        )

        osuSocialCardData.value = mapOf(
            "discord" to osuInfo.user.discord,
            "twitter" to osuInfo.user.twitter,
            "website" to osuInfo.user.website,
            "location" to osuInfo.user.location,
            "interests" to osuInfo.user.interests,
            "occupation" to osuInfo.user.occupation,
            "joinDate" to osuInfo.user.joinDate,
            "lastVisit" to osuInfo.user.lastVisit,
            "playStyle" to osuInfo.user.playstyle.joinToString(", ")
        )

        osuGlanceData.value = mapOf(
            "username" to osuInfo.user.username,
            "pp" to osuInfo.user.statistics.pp.toString(),
        )
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val osuGlanceJson = moshi.adapter(Map::class.java).toJson(osuGlanceData.value)
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

    // Chunithm
    fun getChuniCardFromShare(context: Context): ChuniCard {
        val json = ShareUtil.getString("chuniCard", context) ?: "null"
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build().adapter(ChuniCard::class.java).fromJson(json) ?: ChuniCard()
    }
}

class RecordViewModelFactory(
    private val userId: String,
    private val mode: String,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecordViewModel(userId, mode, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
