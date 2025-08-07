package com.madsam.otora.ui.record.osu

import android.content.Context
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.ui.record.osu.constant.OsuFlagAlphabet
import com.madsam.otora.glance.SmallWidget
import com.madsam.otora.data.osu.ui.model.OsuBadgeUiModel
import com.madsam.otora.data.osu.ui.model.OsuCardUiModel
import com.madsam.otora.data.osu.ui.model.OsuGlanceUiModel
import com.madsam.otora.data.osu.ui.model.OsuLevelUiModel
import com.madsam.otora.data.osu.ui.model.OsuPlayUiModel
import com.madsam.otora.data.osu.ui.model.OsuRecentUiModel
import com.madsam.otora.data.osu.ui.model.OsuSocialUiModel
import com.madsam.otora.data.osu.ui.model.OsuTopRankUiModel
import com.madsam.otora.data.osu.remote.model.OsuCardListDTO
import com.madsam.otora.data.osu.remote.model.OsuGroupDTO
import com.madsam.otora.data.osu.remote.model.OsuInfoDTO
import com.madsam.otora.data.osu.remote.model.OsuRecentActivityDTO
import com.madsam.otora.data.osu.remote.model.OsuTopRankItemDTO
import com.madsam.otora.data.osu.remote.api.OsuRequestService
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.CommonUtils.formatNumberThousand
import com.madsam.otora.core.utils.CommonUtils.formatPercent
import com.madsam.otora.core.utils.ShareUtil
import com.madsam.otora.data.osu.ui.model.OsuBriefUiModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class OsuViewModel() : ViewModel() {
    val cardUI = MutableStateFlow(OsuCardUiModel())
    val badgeUI = MutableStateFlow<List<OsuBadgeUiModel>>(emptyList())
    val groupListUI = MutableStateFlow<List<OsuGroupDTO>>(emptyList())
    val rankGraphUI = MutableStateFlow<List<Int>>(emptyList())
    val playUI = MutableStateFlow(OsuPlayUiModel())
    val levelUI = MutableStateFlow(OsuLevelUiModel())
    val topRankUI = MutableStateFlow(OsuTopRankUiModel())
    val socialUI = MutableStateFlow(OsuSocialUiModel())
    val recentBrief = MutableStateFlow<OsuBriefUiModel<OsuRecentUiModel>>(OsuBriefUiModel())
    val recentUI = MutableStateFlow<List<OsuRecentUiModel>>(emptyList())
    val pinnedBrief = MutableStateFlow<OsuBriefUiModel<OsuTopRankUiModel>>(OsuBriefUiModel())
    val pinnedUI = MutableStateFlow<List<OsuTopRankUiModel>>(emptyList())
    val firstBrief = MutableStateFlow<OsuBriefUiModel<OsuTopRankUiModel>>(OsuBriefUiModel())
    val firstUI = MutableStateFlow<List<OsuTopRankUiModel>>(emptyList())
    val bestBrief = MutableStateFlow<OsuBriefUiModel<OsuTopRankUiModel>>(OsuBriefUiModel())
    val bestUI = MutableStateFlow<List<OsuTopRankUiModel>>(emptyList())

    private val glanceUI = MutableStateFlow(OsuGlanceUiModel())

    private val serviceScope = CoroutineScope(Dispatchers.IO)

    fun loadData(context: Context) {
        val osuRequestService = OsuRequestService()
        val userId = ShareUtil.getString("userId", context) ?: "2"
        val mode = ShareUtil.getString("mode", context) ?: "osu"
        osuRequestService.getOsuMedals(
            { osuInfoDTO: OsuInfoDTO -> fetchMedals(osuInfoDTO, context) }, userId, mode
        )
        osuRequestService.getOsuCard(
            { osuCardListDTO: OsuCardListDTO -> fetchCard(osuCardListDTO) }, userId
        )
        osuRequestService.getOsuRecentActivity({ osuRecentActivityDTO: List<OsuRecentActivityDTO> ->
            fetchRecentActivity(osuRecentActivityDTO)
        }, userId)
        osuRequestService.getOsuPinnedMap({ osuPinnedMap: List<OsuTopRankItemDTO> ->
            fetchPinnedMap(osuPinnedMap)
        }, userId, mode)
        osuRequestService.getOsuFirstMap({ osuFirstMap: List<OsuTopRankItemDTO> ->
            fetchFirstMap(osuFirstMap)
        }, userId, mode)
        osuRequestService.getOsuBestMap({ osuBestMap: List<OsuTopRankItemDTO> ->
            fetchBestMap(osuBestMap)
        }, userId, mode)
//        osuDataRequestService.getOsuBeatmap({ osuUserBeatmap: OsuUserBeatmap -> setOsuUserBeatmap(osuUserBeatmap) }, userId, mode)
//        osuDataRequestService.getOsuHistorical({ osuHistorical: OsuHistorical -> setOsuHistorical(osuHistorical) }, userId, mode)
    }

    private fun fetchCard(osuCardListDTO: OsuCardListDTO) {
        if (osuCardListDTO.users.isEmpty()) return

        val osuCard = osuCardListDTO.users[0]
        cardUI.update {
            it.copy(
                username = osuCard.username,
                country = osuCard.country.name,
                flagUrl = OsuFlagAlphabet.getFlagAlphabet(osuCard.country.code),
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

    private fun fetchRecentActivity(osuRecentActivityDTOList: List<OsuRecentActivityDTO>) {
        recentUI.update {
            osuRecentActivityDTOList.map { activity ->
                OsuRecentUiModel(
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
            OsuBriefUiModel(
                items = osuRecentActivityDTOList.take(3).map { activity ->
                    OsuRecentUiModel(
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
                },
                isComplete = osuRecentActivityDTOList.size <= 3
            )
        }
    }

    private fun fetchTopRankItem(item: OsuTopRankItemDTO): OsuTopRankUiModel {
        val stats = item.statistics
        val accuracy = if (item.beatmap.mode == "mania") {
            ((stats.perfect + stats.great) + stats.good *2/3.0 + stats.ok /3.0 + stats.meh /6.0) /
                    item.maximumStatistics.perfect.toDouble()
        } else {
            item.accuracy
        }
        return OsuTopRankUiModel(
            scoreId = item.id,
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

    private fun fetchPinnedMap(osuPinnedMap: List<OsuTopRankItemDTO>) {
        pinnedUI.update {
            osuPinnedMap.map { fetchTopRankItem(it) }
        }
        pinnedBrief.update {
            OsuBriefUiModel(
                items = osuPinnedMap.take(2).map { fetchTopRankItem(it) },
                isComplete = osuPinnedMap.size <= 2
            )
        }
    }

    private fun fetchFirstMap(osuFirstMap: List<OsuTopRankItemDTO>) {
        firstUI.update {
            osuFirstMap.map { fetchTopRankItem(it) }
        }
        firstBrief.update {
            OsuBriefUiModel(
                items = osuFirstMap.take(2).map { fetchTopRankItem(it) },
                isComplete = osuFirstMap.size <= 2
            )
        }
    }

    private fun fetchBestMap(osuBestMap: List<OsuTopRankItemDTO>) {
        bestUI.update {
            osuBestMap.map { fetchTopRankItem(it) }
        }
        bestBrief.update {
            OsuBriefUiModel(
                items = osuBestMap.take(2).map { fetchTopRankItem(it) },
                isComplete = osuBestMap.size <= 2
            )
        }
    }

    private fun fetchMedals(osuInfoDTO: OsuInfoDTO, context: Context) {
        cardUI.update {
            it.copy(
                isTitle = osuInfoDTO.user.title.isNotEmpty(),
                title = osuInfoDTO.user.title.ifEmpty { "" },
                currentMode = osuInfoDTO.currentMode,
                isSupporter = osuInfoDTO.user.isSupporter,
                supporterRank = osuInfoDTO.user.supportLevel,
                rank = "#${osuInfoDTO.user.statistics.globalRank}",
                countryRank = "#${osuInfoDTO.user.statistics.countryRank}",
                formerUsernames = osuInfoDTO.user.previousUsernames.joinToString(", "),
                maniaModeGlobalRank = if (osuInfoDTO.currentMode == "mania") {
                    "4K: #${osuInfoDTO.user.statistics.variants[0].globalRank}\n" +
                            "7K: #${osuInfoDTO.user.statistics.variants[1].globalRank}"
                } else "",
                maniaModeCountryRank = if (osuInfoDTO.currentMode == "mania") {
                    "4K: #${osuInfoDTO.user.statistics.countryRank}\n" +
                            "7K: #${osuInfoDTO.user.statistics.countryRank}"
                } else "",
                tournamentBannerImage2x = osuInfoDTO.user.activeTournamentBanner.image2x
            )
        }

        rankGraphUI.value = osuInfoDTO.user.rankHistory.data
        topRankUI.value = OsuTopRankUiModel(
            rank = osuInfoDTO.user.rankHighest.rank.toString(),
            date = osuInfoDTO.user.rankHighest.updatedAt
        )
        val playTime = if (osuInfoDTO.user.statistics.playTime != 0) {
            CommonUtils.secondToDHMS(osuInfoDTO.user.statistics.playTime.toLong())
        } else {
            "0,0,0,0"
        }

        playUI.update {
            it.copy(
                sshCount = osuInfoDTO.user.statistics.gradeCounts.ssh,
                ssCount = osuInfoDTO.user.statistics.gradeCounts.ss,
                shCount = osuInfoDTO.user.statistics.gradeCounts.sh,
                sCount = osuInfoDTO.user.statistics.gradeCounts.s,
                aCount = osuInfoDTO.user.statistics.gradeCounts.a,
                medalCount = osuInfoDTO.user.userAchievements.size,
                pp = osuInfoDTO.user.statistics.pp,
                playTime = playTime,
                rankedScore = formatNumberThousand(osuInfoDTO.user.statistics.rankedScore),
                hitAccuracy = formatPercent(osuInfoDTO.user.statistics.hitAccuracy),
                playCount = formatNumberThousand(osuInfoDTO.user.statistics.playCount.toLong()),
                totalScore = formatNumberThousand(osuInfoDTO.user.statistics.totalScore),
                totalHits = formatNumberThousand(osuInfoDTO.user.statistics.totalHits),
                maximumCombo = formatNumberThousand(osuInfoDTO.user.statistics.maximumCombo.toLong()),
                replaysWatchedByOthers = formatNumberThousand(osuInfoDTO.user.statistics.replaysWatchedByOthers.toLong()),
                followerCount = formatNumberThousand(osuInfoDTO.user.followerCount.toLong()),
                mappingFollowerCount = formatNumberThousand(osuInfoDTO.user.mappingFollowerCount.toLong()),
                postCount = formatNumberThousand(osuInfoDTO.user.postCount.toLong()),
                commentsCount = formatNumberThousand(osuInfoDTO.user.commentsCount.toLong())
            )
        }

        badgeUI.update {
            osuInfoDTO.user.badges.map { badge ->
                OsuBadgeUiModel(
                    awardedAt = badge.awardedAt,
                    description = badge.description,
                    image2xUrl = badge.image2xUrl.ifEmpty { badge.imageUrl },
                    url = badge.url
                )
            }
        }

        levelUI.update {
            it.copy(
                level = osuInfoDTO.user.statistics.level.current,
                levelProgress = osuInfoDTO.user.statistics.level.progress
            )
        }

        socialUI.update {
            it.copy(
                discord = osuInfoDTO.user.discord,
                twitter = osuInfoDTO.user.twitter,
                website = osuInfoDTO.user.website,
                location = osuInfoDTO.user.location,
                interests = osuInfoDTO.user.interests,
                occupation = osuInfoDTO.user.occupation,
                joinDate = osuInfoDTO.user.joinDate,
                lastVisit = osuInfoDTO.user.lastVisit,
                playStyle = osuInfoDTO.user.playstyle.joinToString(", ")
            )
        }

        glanceUI.update {
            it.copy(
                username = osuInfoDTO.user.username,
                pp = osuInfoDTO.user.statistics.pp,
            )
        }

        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val osuGlanceJson = moshi.adapter(OsuGlanceUiModel::class.java).toJson(glanceUI.value)
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

class OsuViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OsuViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OsuViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
