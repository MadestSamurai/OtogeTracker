package com.madsam.otora.service

import android.util.Log
import com.madsam.otora.callback.ICallback
import com.madsam.otora.entity.web.OsuCard
import com.madsam.otora.entity.web.OsuHistorical
import com.madsam.otora.entity.web.OsuInfo
import com.madsam.otora.entity.web.OsuTopRanks
import com.madsam.otora.entity.web.OsuUserBeatmap
import com.madsam.otora.utils.SafeSoupUtil.safeAttr
import com.madsam.otora.web.Api
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

/**
 * 项目名: OtogeTracker
 * 文件名: DataRequestService
 * 创建者: MadSamurai
 * 创建时间: 2024/3/4
 * 描述: 数据请求服务类
 */
class DataRequestService {

    private val moshi = Moshi.Builder()
        .add(NullToDefaultStringAdapter())
        .add(NullToDefaultLongAdapter())
        .add(NullToDefaultIntAdapter())
        .add(NullToDefaultDoubleAdapter())
        .add(NullToDefaultBooleanAdapter())
        .add(NullToEmptyStringListAdapter())
        .add(NullToEmptyIntListAdapter())
        .add(NullToDefaultGroupListAdapter())
        .add(NullToDefaultMedalItemListAdapter())
        .add(NullToDefaultActiveTournamentBannerAdapter())
        .add(NullToDefaultCountryAdapter())
        .add(NullToDefaultCountryExtendAdapter())
        .add(NullToDefaultActiveTournamentBannerListAdapter())
        .add(NullToDefaultBadgeListAdapter())
        .add(NullToDefaultVariantListAdapter())
        .add(NullToDefaultUserAchievementListAdapter())
        .add(CamelCaseJsonAdapterFactory())
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://osu.ppy.sh/") // OSU Url
        .addConverterFactory(MoshiConverterFactory.create(moshi)) // Moshi
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // RxJava
        .build()
    private val api = retrofit.create(Api::class.java)

    private val serviceScope = CoroutineScope(Dispatchers.IO)

    private fun requestOsuCard(callback: ICallback<OsuCard>, userId: String) {
        try {
            val osuCardCall = api.getOsuCard(userId)
            val response = osuCardCall.execute()
            if (response.isSuccessful) {
                val osuCard = response.body()
                if (osuCard != null) {
                    callback(osuCard)
                    println(osuCard.toString())
                } else Log.e(TAG, "com.madsam.otora.ui.record.cards.OsuCard is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuCardThread")
        }
    }

    private fun requestOsuTopRank(callback: ICallback<OsuTopRanks>, userId: String, mode: String) {
        try {
            val osuTopRankCall = api.getOsuTopRanks(userId, mode)
            val response = osuTopRankCall.execute()
            if (response.isSuccessful) {
                val osuTopRank = response.body()
                if (osuTopRank != null) {
                    callback(osuTopRank)
                } else Log.e(TAG, "OsuTopRank is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuTopRankThread")
        }
    }

    private fun requestOsuBeatmap(
        callback: ICallback<OsuUserBeatmap>,
        userId: String,
        mode: String
    ) {
        try {
            val osuBeatmapCall = api.getOsuBeatmaps(userId, mode)
            val response = osuBeatmapCall.execute()
            if (response.isSuccessful) {
                val osuBeatmap = response.body()
                if (osuBeatmap != null) {
                    callback(osuBeatmap)
                } else Log.e(TAG, "OsuBeatmap is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuBeatmapThread")
        }
    }

    private fun requestOsuHistorical(
        callback: ICallback<OsuHistorical>,
        userId: String,
        mode: String
    ) {
        try {
            val osuHistoricalCall = api.getOsuHistorical(userId, mode)
            val response = osuHistoricalCall.execute()
            if (response.isSuccessful) {
                val osuHistorical = response.body()
                if (osuHistorical != null) {
                    callback(osuHistorical)
                } else Log.e(TAG, "OsuHistorical is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuHistoricalThread")
        }
    }

    private fun requestOsuMedals(callback: ICallback<OsuInfo>, userId: String, mode: String) {
        try {
            val doc = Jsoup.connect("https://osu.ppy.sh/users/$userId/$mode").get()
            val medals =
                doc.selectFirst("div.js-react--profile-page.osu-layout.osu-layout--full")
            val medalsJson = medals.safeAttr("data-initial-data")
            val osuInfo = moshi.adapter(OsuInfo::class.java).fromJson(medalsJson)
            if (osuInfo != null) {
                callback(osuInfo)
            } else Log.e(TAG, "OsuInfo is null")
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuMedalsThread")
        }
    }

    fun getOsuCard(callback: ICallback<OsuCard>, userId: String) {
        serviceScope.launch { requestOsuCard(callback, userId) }
    }

    fun getOsuTopRanks(callback: ICallback<OsuTopRanks>, userId: String, mode: String) {
        serviceScope.launch { requestOsuTopRank(callback, userId, mode) }
    }

    fun getOsuBeatmap(callback: ICallback<OsuUserBeatmap>, userId: String, mode: String) {
        serviceScope.launch { requestOsuBeatmap(callback, userId, mode) }
    }

    fun getOsuHistorical(callback: ICallback<OsuHistorical>, userId: String, mode: String) {
        serviceScope.launch { requestOsuHistorical(callback, userId, mode) }
    }

    fun getOsuMedals(callback: ICallback<OsuInfo>, userId: String, mode: String) {
        serviceScope.launch { requestOsuMedals(callback, userId, mode) }
    }

    companion object {
        private const val TAG = "DataRequestService"
    }
}
