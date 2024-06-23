package com.madsam.otora.ui.record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madsam.otora.consts.FlagsAlphabet
import com.madsam.otora.entity.web.OsuCard
import com.madsam.otora.entity.web.OsuGroup
import com.madsam.otora.entity.web.OsuInfo
import com.madsam.otora.service.DataRequestService
import com.madsam.otora.utils.CommonUtils
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * 项目名: OtogeTracker
 * 文件名: RecordViewModel
 * 创建者: MadSamurai
 * 创建时间:2023/3/11 17:56
 * 描述: 记录页面ViewModel
 */

class RecordViewModel(
    userId: String,
    mode: String
) : ViewModel() {
    val osuCardData = MutableStateFlow<Map<String, String>>(emptyMap())
    val osuGroupList = MutableStateFlow<List<OsuGroup>>(emptyList())
    val osuRankGraphData = MutableStateFlow<List<Int>>(emptyList())
    val osuPlayData = MutableStateFlow<Map<String, String>>(emptyMap())
    val osuInfoData = MutableStateFlow<Map<String, String>>(emptyMap())

    init {
        requestOsuData(userId, mode)
    }

    private fun requestOsuData(userId: String, mode: String) {
        val dataRequestService = DataRequestService()
        dataRequestService.getOsuCard({ osuCard: OsuCard -> setOsuCard(osuCard) }, userId)
//        dataRequestService.getOsuTopRanks({ osuTopRanks: OsuTopRanks -> setOsuTopRanks(osuTopRanks) }, userId, mode)
//        dataRequestService.getOsuBeatmap({ osuUserBeatmap: OsuUserBeatmap -> setOsuUserBeatmap(osuUserBeatmap) }, userId, mode)
//        dataRequestService.getOsuHistorical({ osuHistorical: OsuHistorical -> setOsuHistorical(osuHistorical) }, userId, mode)
        dataRequestService.getOsuMedals({ osuInfo: OsuInfo -> setOsuMedals(osuInfo) }, userId, mode)
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
            "profileColour" to osuCard.profileColour
        )
        osuGroupList.value = osuCard.groups
    }

    private fun setOsuMedals(osuInfo: OsuInfo) {
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
            "isSupporter" to if (osuInfo.user.isSupporter) "true" else "false",
            "supporterRank" to osuInfo.user.supportLevel.toString(),
            "rank" to "#" + osuInfo.user.statistics.globalRank.toString(),
            "countryRank" to "#" + osuInfo.user.statistics.countryRank.toString()
        )

        osuRankGraphData.value = osuInfo.user.rankHistory.data

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

            "totalKudosu" to osuInfo.user.kudosu.total.toString(),
            "ppExp" to osuInfo.user.statistics.ppExp.toString(),
            "accuracy" to osuInfo.user.statistics.hitAccuracy.toString(),
            "level" to osuInfo.user.statistics.level.toString()
        )
        println("replaysWatchedByOthers: ${osuInfo.user.statistics.replaysWatchedByOthers}")
        println("mappingFollowerCount: ${osuInfo.user.mappingFollowerCount}")
    }
}

class RecordViewModelFactory(private val userId: String, private val mode: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecordViewModel(userId, mode) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
