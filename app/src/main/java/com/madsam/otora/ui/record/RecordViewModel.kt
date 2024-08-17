package com.madsam.otora.ui.record

import android.content.Context
import android.util.Log
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList
import androidx.compose.runtime.mutableStateOf
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.consts.FlagsAlphabet
import com.madsam.otora.entity.chuni.ChuniCard
import com.madsam.otora.entity.web.OsuCard
import com.madsam.otora.entity.web.OsuGroup
import com.madsam.otora.entity.web.OsuInfo
import com.madsam.otora.entity.web.OsuRecentActivity
import com.madsam.otora.entity.web.OsuTopRankItem
import com.madsam.otora.glance.SmallWidget
import com.madsam.otora.service.DataRequestService
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
        val dataRequestService = DataRequestService()
        dataRequestService.getOsuCard({ osuCard: OsuCard -> setOsuCard(osuCard) }, userId)
        dataRequestService.getOsuRecentActivity({ osuRecentActivity: List<OsuRecentActivity> -> setOsuRecentActivity(osuRecentActivity) }, userId)
        dataRequestService.getOsuPinnedMap({ osuPinnedMap: List<OsuTopRankItem> -> setOsuPinnedMap(osuPinnedMap) }, userId, mode)
        dataRequestService.getOsuFirstMap({ osuFirstMap: List<OsuTopRankItem> -> setOsuFirstMap(osuFirstMap) }, userId, mode)
        dataRequestService.getOsuBestMap({ osuBestMap: List<OsuTopRankItem> -> setOsuBestMap(osuBestMap) }, userId, mode)
//        dataRequestService.getOsuBeatmap({ osuUserBeatmap: OsuUserBeatmap -> setOsuUserBeatmap(osuUserBeatmap) }, userId, mode)
//        dataRequestService.getOsuHistorical({ osuHistorical: OsuHistorical -> setOsuHistorical(osuHistorical) }, userId, mode)
        dataRequestService.getOsuMedals(
            { osuInfo: OsuInfo -> setOsuMedals(osuInfo, context) },
            userId,
            mode
        )
    }

    private fun setOsuCard(osuCard: OsuCard) {
        osuCardData.value = mapOf(
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
                "beatmapTitle" to activity.beatmap.title,
                "beatmapSetTitle" to activity.beatmapset.title,
                "createdAt" to activity.createdAt,
                "mode" to activity.mode
            )
        }
    }

    private fun setOsuPinnedMap(osuPinnedMap: List<OsuTopRankItem>) {
        osuPinnedMapData.value = osuPinnedMap.map { pinnedMap ->
            mapOf(
                "cover2x" to pinnedMap.beatmapSet.covers.cover2x,
                "beatmapSetTitle" to pinnedMap.beatmapSet.title,
                "beatmapSetTitleUnicode" to pinnedMap.beatmapSet.titleUnicode,
                "beatmapSubTitle" to pinnedMap.beatmap.version,
                "artist" to pinnedMap.beatmapSet.artist,
                "artistUnicode" to pinnedMap.beatmapSet.artistUnicode,
                "creator" to pinnedMap.beatmapSet.creator,
                "pp" to pinnedMap.pp.toString(),
                "accuracy" to CommonUtils.formatPercent(pinnedMap.accuracy),
                "rank" to pinnedMap.rank,
                "maxCombo" to pinnedMap.maxCombo.toString(),
                "mods" to pinnedMap.mods.joinToString(", "),
                "totalScore" to CommonUtils.formatNumberThousand(pinnedMap.totalScore),
                "weight" to pinnedMap.weight.percentage.toString(),
                "weightPP" to pinnedMap.weight.pp.toString(),
                "beatmapId" to pinnedMap.beatmap.id.toString(),
                "beatmapSetId" to pinnedMap.beatmapSet.id.toString()
            )
        }
    }

    private fun setOsuFirstMap(osuFirstMap: List<OsuTopRankItem>) {
        osuFirstMapData.value = osuFirstMap.map { firstMap ->
            mapOf(
                "cover2x" to firstMap.beatmapSet.covers.cover2x,
                "beatmapSetTitle" to firstMap.beatmapSet.title,
                "beatmapSetTitleUnicode" to firstMap.beatmapSet.titleUnicode,
                "beatmapSubTitle" to firstMap.beatmap.version,
                "artist" to firstMap.beatmapSet.artist,
                "artistUnicode" to firstMap.beatmapSet.artistUnicode,
                "creator" to firstMap.beatmapSet.creator,
                "pp" to firstMap.pp.toString(),
                "accuracy" to CommonUtils.formatPercent(firstMap.accuracy),
                "rank" to firstMap.rank,
                "maxCombo" to firstMap.maxCombo.toString(),
                "mods" to firstMap.mods.joinToString(", "),
                "totalScore" to CommonUtils.formatNumberThousand(firstMap.totalScore),
                "weight" to firstMap.weight.percentage.toString(),
                "weightPP" to firstMap.weight.pp.toString(),
                "beatmapId" to firstMap.beatmap.id.toString(),
                "beatmapSetId" to firstMap.beatmapSet.id.toString()
            )
        }
    }

    private fun setOsuBestMap(osuBestMap: List<OsuTopRankItem>) {
        osuBestMapData.value = osuBestMap.map { bestMap ->
            mapOf(
                "cover2x" to bestMap.beatmapSet.covers.cover2x,
                "beatmapSetTitle" to bestMap.beatmapSet.title,
                "beatmapSetTitleUnicode" to bestMap.beatmapSet.titleUnicode,
                "beatmapSubTitle" to bestMap.beatmap.version,
                "artist" to bestMap.beatmapSet.artist,
                "artistUnicode" to bestMap.beatmapSet.artistUnicode,
                "creator" to bestMap.beatmapSet.creator,
                "difficultyRating" to bestMap.beatmap.difficultyRating.toString(),
                "previewUrl" to bestMap.beatmapSet.previewUrl,
                "pp" to bestMap.pp.toString(),
                "accuracy" to CommonUtils.formatPercent(bestMap.accuracy),
                "rank" to bestMap.rank,
                "date" to bestMap.endedAt,
                "maxCombo" to bestMap.maxCombo.toString(),
                "score" to bestMap.legacyTotalScore.toString(),
                "mods" to bestMap.mods.joinToString(", "),
                "totalScore" to CommonUtils.formatNumberThousand(bestMap.totalScore),
                "weight" to bestMap.weight.percentage.toString(),
                "weightPP" to bestMap.weight.pp.toString(),
                "beatmapId" to bestMap.beatmap.id.toString(),
                "beatmapSetId" to bestMap.beatmapSet.id.toString(),
                "status" to bestMap.beatmapSet.status,
            )
        }
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

        var playTime = ""
        if (osuInfo.user.statistics.playTime != 0) {
            playTime = CommonUtils.secondToDHMS(osuInfo.user.statistics.playTime.toLong())
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
    private val filePicked = mutableStateOf(false)

    fun updatePickedFile() {
        filePicked.value = true
    }

    fun resetPickedFile() {
        filePicked.value = false
    }

    fun isFilePicked(): Boolean {
        return filePicked.value
    }

    fun getChuniCardFromShare(context: Context): ChuniCard {
        val json = ShareUtil.getString("analysedText", context) ?: "null"
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
