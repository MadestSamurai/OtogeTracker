package com.madsam.otora.service

import android.util.Log
import com.madsam.otora.callback.ICallback
import com.madsam.otora.entity.web.OsuCard
import com.madsam.otora.entity.web.OsuHistorical
import com.madsam.otora.entity.web.OsuInfo
import com.madsam.otora.entity.web.OsuRecentActivity
import com.madsam.otora.entity.web.OsuTopRankItem
import com.madsam.otora.entity.web.OsuUserBeatmap
import com.madsam.otora.utils.CommonUtils
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
 * 文件名: OsuDataRequestService
 * 创建者: MadSamurai
 * 创建时间: 2024/3/4
 * 描述: Osu数据请求服务类
 */
class OsuDataRequestService {
    /** The reason I am not using CamelCase adapter for moshi:
    * When you annotate a field with @Json(name = ),
    * the camel mapping will be done before the annotation is processed,
    * causing the annotation works incorrectly.
    * And to solve this, making the @CamelCase for every field is also not a good idea.
    * So just annotate every field with @Json(name = ) is the best way.
    */
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
        .add(NullToDefaultRankHighestAdapter())
        .add(NullToDefaultHypeAdapter())
        .add(NullToDefaultRankHistoryAdapter())
        .add(NullToDefaultActiveTournamentBannerListAdapter())
        .add(NullToDefaultBadgeListAdapter())
        .add(NullToDefaultVariantListAdapter())
        .add(NullToDefaultUserAchievementListAdapter())
        .add(NullToDefaultRecentActivityListAdapter())
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
                } else Log.e(TAG, "com.madsam.otora.ui.record.cards.OsuCard is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuCardThread")
        }
    }

    private fun requestOsuPinnedMap(
        callback: ICallback<List<OsuTopRankItem>>,
        userId: String,
        mode: String
    ) {
        try {
            val osuPinnedMapCall = api.getOsuPinnedMap(userId, mode)
            val response = osuPinnedMapCall.execute()
            if (response.isSuccessful) {
                val osuPinnedMap = response.body()
                if (osuPinnedMap != null) {
                    callback(osuPinnedMap)
                    println("osuPinned:$osuPinnedMap")
                } else Log.e(TAG, "OsuPinnedMap is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuPinnedMapThread")
        }
    }

    private fun requestOsuBestMap(
        callback: ICallback<List<OsuTopRankItem>>,
        userId: String,
        mode: String
    ) {
        try {
            val osuBestMapCall = api.getOsuBestMap(userId, mode)
            val response = osuBestMapCall.execute()
            if (response.isSuccessful) {
                val osuBestMap = response.body()
                if (osuBestMap != null) {
                    callback(osuBestMap)
                    println("osuBest:$osuBestMap")
                } else Log.e(TAG, "OsuBestMap is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuBestMapThread")
        }
    }

    private fun requestOsuFirstMap(
        callback: ICallback<List<OsuTopRankItem>>,
        userId: String,
        mode: String
    ) {
        try {
            val osuFirstMapCall = api.getOsuFirstMap(userId, mode)
            val response = osuFirstMapCall.execute()
            if (response.isSuccessful) {
                val osuFirstMap = response.body()
                if (osuFirstMap != null) {
                    callback(osuFirstMap)
                    println("osuFirst:$osuFirstMap")
                } else Log.e(TAG, "OsuFirstMap is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuFirstMapThread")
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

    private fun requestOsuRecentActivity(
        callback: ICallback<List<OsuRecentActivity>>,
        userId: String
    ) {
        try {
            val osuRecentActivityCall = api.getOsuRecentActivity(userId)
            val response = osuRecentActivityCall.execute()
            if (response.isSuccessful) {
                val osuRecentActivity = response.body()
                if (osuRecentActivity != null) {
                    callback(osuRecentActivity)
                    println("osuRecent:$osuRecentActivity")
                } else Log.e(TAG, "OsuRecentActivity is null")
            } else {
                Log.e(TAG, "Response is not successful")
            }
        } catch (e: IOException) {
            Log.e(TAG, "IOException occurred in OsuRecentActivityThread")
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
            val doc = Jsoup.connect(CommonUtils.encodeURL("https://osu.ppy.sh/users/$userId/$mode")).get()
            val medals = doc.selectFirst("div.js-react--profile-page.osu-layout.osu-layout--full")
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

    fun getOsuRecentActivity(callback: ICallback<List<OsuRecentActivity>>, userId: String, ) {
        serviceScope.launch { requestOsuRecentActivity(callback, userId) }
    }

    fun getOsuPinnedMap(callback: ICallback<List<OsuTopRankItem>>, userId: String, mode: String) {
        serviceScope.launch { requestOsuPinnedMap(callback, userId, mode) }
    }

    fun getOsuBestMap(callback: ICallback<List<OsuTopRankItem>>, userId: String, mode: String) {
        serviceScope.launch { requestOsuBestMap(callback, userId, mode) }
    }

    fun getOsuFirstMap(callback: ICallback<List<OsuTopRankItem>>, userId: String, mode: String) {
        serviceScope.launch { requestOsuFirstMap(callback, userId, mode) }
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
