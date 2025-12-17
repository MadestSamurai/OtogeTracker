package com.madsam.otora.ui.record.osu

import android.content.Context
import android.util.Log
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.core.utils.DateTimeUtils.secondToDHMS
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
import com.madsam.otora.core.utils.NumberFormatUtils.formatThousand
import com.madsam.otora.core.utils.NumberFormatUtils.formatPercent
import com.madsam.otora.data.osu.local.datastore.OsuConfigDataStore
import com.madsam.otora.data.osu.local.objectbox.OsuObjectBoxService
import com.madsam.otora.data.osu.ui.model.OsuBriefUiModel
import com.madsam.otora.glance.data.GlanceWidgetDataStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class OsuViewModel() : ViewModel() {
    
    companion object {
        private const val TAG = "OsuViewModel"
    }
    
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
    private val objectBoxService = OsuObjectBoxService()
    
    // 保存当前用户ID用于持久化
    private var currentUserId: Long = 0
    private var currentMode: String = "osu"

    fun loadData(context: Context) {
        serviceScope.launch {
            val osuConfigDataStore = OsuConfigDataStore(context)
            val (userId, mode) = osuConfigDataStore.getConfig()
            val userIdOrDefault = userId.ifBlank { "2" }
            currentUserId = userIdOrDefault.toLongOrNull() ?: 2L
            currentMode = mode.ifBlank { "osu" }
            
            // 先从缓存加载数据
            loadFromCache()
            
            // 然后请求网络数据
            val osuRequestService = OsuRequestService()
            osuRequestService.getOsuMedals(
                { osuInfoDTO: OsuInfoDTO -> fetchMedals(osuInfoDTO, context) }, userIdOrDefault, mode
            )
            osuRequestService.getOsuCard(
                { osuCardListDTO: OsuCardListDTO -> fetchCard(osuCardListDTO) }, userIdOrDefault
            )
            osuRequestService.getOsuRecentActivity({ osuRecentActivityDTO: List<OsuRecentActivityDTO> ->
                fetchRecentActivity(osuRecentActivityDTO)
            }, userIdOrDefault)
            osuRequestService.getOsuPinnedMap({ osuPinnedMap: List<OsuTopRankItemDTO> ->
                fetchPinnedMap(osuPinnedMap)
            }, userIdOrDefault, mode)
            osuRequestService.getOsuFirstMap({ osuFirstMap: List<OsuTopRankItemDTO> ->
                fetchFirstMap(osuFirstMap)
            }, userIdOrDefault, mode)
            osuRequestService.getOsuBestMap({ osuBestMap: List<OsuTopRankItemDTO> ->
                fetchBestMap(osuBestMap)
            }, userIdOrDefault, mode)
        }
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
                profileColour = osuCard.profileColour.ifEmpty { "#F5F5F5" },
                teamId = osuCard.team?.id ?: 0,
                teamName = osuCard.team?.name ?: "",
                teamShortName = osuCard.team?.shortName ?: "",
                teamFlagUrl = osuCard.team?.flagUrl ?: ""
                // 注意：profileHue 由 fetchMedals 设置，这里不要覆盖
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
        
        // 保存最近活动到 ObjectBox
        serviceScope.launch {
            try {
                objectBoxService.saveRecentActivities(currentUserId, osuRecentActivityDTOList)
                Log.d(TAG, "Recent activities saved to ObjectBox")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save recent activities: ${e.message}", e)
            }
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
        
        // 保存 Pinned 成绩到 ObjectBox
        serviceScope.launch {
            try {
                objectBoxService.saveScores(currentUserId, osuPinnedMap, "pinned")
                Log.d(TAG, "Pinned scores saved to ObjectBox")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save pinned scores: ${e.message}", e)
            }
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
        
        // 保存 First 成绩到 ObjectBox
        serviceScope.launch {
            try {
                objectBoxService.saveScores(currentUserId, osuFirstMap, "first")
                Log.d(TAG, "First place scores saved to ObjectBox")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save first place scores: ${e.message}", e)
            }
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
        
        // 保存 BP 成绩到 ObjectBox
        serviceScope.launch {
            try {
                objectBoxService.saveScores(currentUserId, osuBestMap, "best")
                Log.d(TAG, "Best scores saved to ObjectBox")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save best scores: ${e.message}", e)
            }
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
                mania4kGlobalRank = if (osuInfoDTO.currentMode == "mania") {
                    val variant = osuInfoDTO.user.statistics.variants.find { it.variant == "4k" }
                    if (variant != null) "#${variant.globalRank}" else ""
                } else "",
                mania4kCountryRank = if (osuInfoDTO.currentMode == "mania") {
                    val variant = osuInfoDTO.user.statistics.variants.find { it.variant == "4k" }
                    if (variant != null) "#${variant.countryRank}" else ""
                } else "",
                mania7kGlobalRank = if (osuInfoDTO.currentMode == "mania") {
                    val variant = osuInfoDTO.user.statistics.variants.find { it.variant == "7k" }
                    if (variant != null) "#${variant.globalRank}" else ""
                } else "",
                mania7kCountryRank = if (osuInfoDTO.currentMode == "mania") {
                    val variant = osuInfoDTO.user.statistics.variants.find { it.variant == "7k" }
                    if (variant != null) "#${variant.countryRank}" else ""
                } else "",
                tournamentBannerImage2x = osuInfoDTO.user.activeTournamentBanner.image2x,
                // 从 UserExtend 获取 profile_hue（用户自定义色相）
                profileHue = osuInfoDTO.user.profileHue
            )
        }

        rankGraphUI.value = osuInfoDTO.user.rankHistory.data
        topRankUI.value = OsuTopRankUiModel(
            rank = osuInfoDTO.user.rankHighest.rank.toString(),
            date = osuInfoDTO.user.rankHighest.updatedAt
        )
        val playTime = if (osuInfoDTO.user.statistics.playTime != 0) {
            secondToDHMS(osuInfoDTO.user.statistics.playTime.toLong())
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
                rankedScore = formatThousand(osuInfoDTO.user.statistics.rankedScore),
                hitAccuracy = formatPercent(osuInfoDTO.user.statistics.hitAccuracy),
                playCount = formatThousand(osuInfoDTO.user.statistics.playCount.toLong()),
                totalScore = formatThousand(osuInfoDTO.user.statistics.totalScore),
                totalHits = formatThousand(osuInfoDTO.user.statistics.totalHits),
                maximumCombo = formatThousand(osuInfoDTO.user.statistics.maximumCombo.toLong()),
                replaysWatchedByOthers = formatThousand(osuInfoDTO.user.statistics.replaysWatchedByOthers.toLong()),
                followerCount = formatThousand(osuInfoDTO.user.followerCount.toLong()),
                mappingFollowerCount = formatThousand(osuInfoDTO.user.mappingFollowerCount.toLong()),
                postCount = formatThousand(osuInfoDTO.user.postCount.toLong()),
                commentsCount = formatThousand(osuInfoDTO.user.commentsCount.toLong())
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
        GlanceWidgetDataStore.saveOsuWidgetData(context, osuGlanceJson)
        serviceScope.launch {
            val manager = GlanceAppWidgetManager(context)
            val widget = SmallWidget()
            val glanceIds = manager.getGlanceIds(widget.javaClass)
            glanceIds.forEach { glanceId ->
                widget.update(context, glanceId)
            }
        }
        
        // 保存用户数据到 ObjectBox（按天存储）
        serviceScope.launch {
            try {
                objectBoxService.saveUserData(currentUserId, osuInfoDTO)
                Log.d(TAG, "User data saved to ObjectBox")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to save user data: ${e.message}", e)
            }
        }
    }
    
    /**
     * 从缓存加载数据
     */
    private suspend fun loadFromCache() {
        try {
            // 加载用户数据
            val cachedUser = objectBoxService.getLatestUserData(currentUserId)
            if (cachedUser != null) {
                Log.d(TAG, "Loading cached user data for userId=$currentUserId")
                
                cardUI.update {
                    it.copy(
                        username = cachedUser.username,
                        country = cachedUser.country,
                        flagUrl = OsuFlagAlphabet.getFlagAlphabet(cachedUser.countryCode),
                        avatarUrl = cachedUser.avatarUrl,
                        coverUrl = cachedUser.coverUrl,
                        customCoverUrl = cachedUser.customCoverUrl,
                        isOnline = cachedUser.isOnline,
                        isBot = cachedUser.isBot,
                        isDeleted = cachedUser.isDeleted,
                        profileColour = cachedUser.profileColour.ifEmpty { "#F5F5F5" },
                        profileHue = if (cachedUser.profileHue >= 0) cachedUser.profileHue else null,
                        isTitle = cachedUser.title.isNotEmpty(),
                        title = cachedUser.title,
                        currentMode = cachedUser.currentMode,
                        isSupporter = cachedUser.isSupporter,
                        supporterRank = cachedUser.supportLevel,
                        rank = "#${cachedUser.globalRank}",
                        countryRank = "#${cachedUser.countryRank}",
                        formerUsernames = cachedUser.formerUsernames,
                        tournamentBannerImage2x = cachedUser.tournamentBannerUrl,
                        teamId = cachedUser.teamId,
                        teamName = cachedUser.teamName,
                        teamShortName = cachedUser.teamShortName,
                        teamFlagUrl = cachedUser.teamFlagUrl,
                        
                        // Mania Variants
                        mania4kGlobalRank = if (cachedUser.mania4kGlobalRank > 0) "#${cachedUser.mania4kGlobalRank}" else "",
                        mania4kCountryRank = if (cachedUser.mania4kCountryRank > 0) "#${cachedUser.mania4kCountryRank}" else "",
                        mania7kGlobalRank = if (cachedUser.mania7kGlobalRank > 0) "#${cachedUser.mania7kGlobalRank}" else "",
                        mania7kCountryRank = if (cachedUser.mania7kCountryRank > 0) "#${cachedUser.mania7kCountryRank}" else ""
                    )
                }
                
                topRankUI.value = OsuTopRankUiModel(
                    rank = cachedUser.highestRank.toString(),
                    date = cachedUser.highestRankDate
                )
                
                val playTime = if (cachedUser.playTime != 0) {
                    secondToDHMS(cachedUser.playTime.toLong())
                } else {
                    "0,0,0,0"
                }
                
                playUI.update {
                    it.copy(
                        sshCount = cachedUser.gradeSsh.toLong(),
                        ssCount = cachedUser.gradeSs.toLong(),
                        shCount = cachedUser.gradeSh.toLong(),
                        sCount = cachedUser.gradeS.toLong(),
                        aCount = cachedUser.gradeA.toLong(),
                        medalCount = cachedUser.medalCount,
                        pp = cachedUser.pp,
                        playTime = playTime,
                        rankedScore = formatThousand(cachedUser.rankedScore),
                        hitAccuracy = formatPercent(cachedUser.accuracy),
                        playCount = formatThousand(cachedUser.playCount.toLong()),
                        totalScore = formatThousand(cachedUser.totalScore),
                        totalHits = formatThousand(cachedUser.totalHits),
                        maximumCombo = formatThousand(cachedUser.maxCombo.toLong()),
                        followerCount = formatThousand(cachedUser.followerCount.toLong())
                    )
                }
                
                levelUI.update {
                    it.copy(
                        level = cachedUser.levelCurrent.toLong(),
                        levelProgress = cachedUser.levelProgress.toLong()
                    )
                }
            }
            
            // 加载排名历史
            val cachedRankHistory = objectBoxService.getRankHistory(currentUserId, currentMode)
            if (cachedRankHistory != null) {
                rankGraphUI.value = cachedRankHistory.getRankList()
            }
            
            // 加载徽章
            val cachedBadges = objectBoxService.getBadges(currentUserId)
            if (cachedBadges.isNotEmpty()) {
                badgeUI.update {
                    cachedBadges.map { badge ->
                        OsuBadgeUiModel(
                            awardedAt = badge.awardedAt,
                            description = badge.description,
                            image2xUrl = badge.image2xUrl.ifEmpty { badge.imageUrl },
                            url = badge.url
                        )
                    }
                }
            }
            
            // 加载 BP 成绩
            val cachedScores = objectBoxService.getScores(currentUserId, "best")
            if (cachedScores.isNotEmpty()) {
                val scoreUiModels = cachedScores.map { score ->
                    OsuTopRankUiModel(
                        scoreId = score.odScoreId,
                        cover2x = score.beatmapCoverUrl,
                        beatmapSetTitle = score.beatmapTitle,
                        beatmapSubTitle = score.beatmapVersion,
                        artist = score.beatmapArtist,
                        mode = score.beatmapMode,
                        difficultyRating = score.beatmapDifficulty,
                        pp = score.pp,
                        accuracy = formatPercent(score.accuracy),
                        rank = score.rank,
                        date = score.playedAt,
                        maxCombo = score.maxCombo.toLong(),
                        score = score.score,
                        mods = score.mods.split(",").filter { it.isNotBlank() },
                        weight = score.ppWeight,
                        weightPP = score.ppWeight * score.pp / 100.0,
                        beatmapId = score.beatmapId,
                        beatmapSetId = score.beatmapSetId,
                        status = score.beatmapStatus
                    )
                }
                bestUI.update { scoreUiModels }
                bestBrief.update {
                    OsuBriefUiModel(
                        items = scoreUiModels.take(2),
                        isComplete = scoreUiModels.size <= 2
                    )
                }
            }
            
            // 加载最近活动
            val cachedActivities = objectBoxService.getRecentActivities(currentUserId)
            if (cachedActivities.isNotEmpty()) {
                val activityUiModels = cachedActivities.map { activity ->
                    OsuRecentUiModel(
                        type = activity.type,
                        rank = activity.rank.toString(),
                        scoreRank = activity.scoreRank,
                        beatmapTitle = activity.beatmapTitle,
                        beatmapSetTitle = activity.beatmapsetTitle,
                        createdAt = activity.createdAt,
                        mode = activity.mode,
                        achievement = activity.achievementName,
                        modeAchievement = "",
                        achievementIcon = activity.achievementIconUrl
                    )
                }
                recentUI.update { activityUiModels }
                recentBrief.update {
                    OsuBriefUiModel(
                        items = activityUiModels.take(3),
                        isComplete = activityUiModels.size <= 3
                    )
                }
            }
            
            // 加载 Pinned 成绩
            val cachedPinnedScores = objectBoxService.getScores(currentUserId, "pinned")
            if (cachedPinnedScores.isNotEmpty()) {
                val pinnedUiModels = cachedPinnedScores.map { score ->
                    OsuTopRankUiModel(
                        scoreId = score.odScoreId,
                        cover2x = score.beatmapCoverUrl,
                        beatmapSetTitle = score.beatmapTitle,
                        beatmapSubTitle = score.beatmapVersion,
                        artist = score.beatmapArtist,
                        mode = score.beatmapMode,
                        difficultyRating = score.beatmapDifficulty,
                        pp = score.pp,
                        accuracy = formatPercent(score.accuracy),
                        rank = score.rank,
                        date = score.playedAt,
                        maxCombo = score.maxCombo.toLong(),
                        score = score.score,
                        mods = score.mods.split(",").filter { it.isNotBlank() },
                        weight = score.ppWeight,
                        weightPP = score.ppWeight * score.pp / 100.0,
                        beatmapId = score.beatmapId,
                        beatmapSetId = score.beatmapSetId,
                        status = score.beatmapStatus
                    )
                }
                pinnedUI.update { pinnedUiModels }
                pinnedBrief.update {
                    OsuBriefUiModel(
                        items = pinnedUiModels.take(2),
                        isComplete = pinnedUiModels.size <= 2
                    )
                }
            }
            
            // 加载 First Place 成绩
            val cachedFirstScores = objectBoxService.getScores(currentUserId, "first")
            if (cachedFirstScores.isNotEmpty()) {
                val firstUiModels = cachedFirstScores.map { score ->
                    OsuTopRankUiModel(
                        scoreId = score.odScoreId,
                        cover2x = score.beatmapCoverUrl,
                        beatmapSetTitle = score.beatmapTitle,
                        beatmapSubTitle = score.beatmapVersion,
                        artist = score.beatmapArtist,
                        mode = score.beatmapMode,
                        difficultyRating = score.beatmapDifficulty,
                        pp = score.pp,
                        accuracy = formatPercent(score.accuracy),
                        rank = score.rank,
                        date = score.playedAt,
                        maxCombo = score.maxCombo.toLong(),
                        score = score.score,
                        mods = score.mods.split(",").filter { it.isNotBlank() },
                        weight = score.ppWeight,
                        weightPP = score.ppWeight * score.pp / 100.0,
                        beatmapId = score.beatmapId,
                        beatmapSetId = score.beatmapSetId,
                        status = score.beatmapStatus
                    )
                }
                firstUI.update { firstUiModels }
                firstBrief.update {
                    OsuBriefUiModel(
                        items = firstUiModels.take(2),
                        isComplete = firstUiModels.size <= 2
                    )
                }
            }
            
            Log.d(TAG, "Cache loaded successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to load from cache: ${e.message}", e)
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
