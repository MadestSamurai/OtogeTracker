package com.madsam.otora.data.osu.remote.api

import android.util.Log
import com.madsam.otora.core.utils.StringUtils
import com.madsam.otora.data.OSU_URL
import com.madsam.otora.data.adapter.SafeBooleanAdapter
import com.madsam.otora.data.adapter.SafeDoubleAdapter
import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeIntListAdapter
import com.madsam.otora.data.adapter.SafeLongAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.adapter.SafeStringListAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuAchievementListAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuBadgeListAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuCountryAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuExtendCountryAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuGroupListAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuHypeAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuMedalItemListAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuRankHighestAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuRankHistoryAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuRecentActivityListAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuTournamentBannerAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuTournamentBannerListAdapter
import com.madsam.otora.data.osu.remote.adapter.SafeOsuVariantListAdapter
import com.madsam.otora.data.osu.remote.model.OsuCardListDTO
import com.madsam.otora.data.osu.remote.model.OsuHistoricalDTO
import com.madsam.otora.data.osu.remote.model.OsuInfoDTO
import com.madsam.otora.data.osu.remote.model.OsuRecentActivityDTO
import com.madsam.otora.data.osu.remote.model.OsuTopRankItemDTO
import com.madsam.otora.data.osu.remote.model.OsuUserBeatmapDTO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.fleeksoft.ksoup.Ksoup
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class OsuRequestService {
    companion object {
        private const val TAG = "DataRequestService"
    }

    /** The reason I am not using CamelCase adapter for moshi:
    * When you annotate a field with @Json(name = ),
    * the camel mapping will be done before the annotation is processed,
    * causing the annotation works incorrectly.
    * And to solve this, making the @CamelCase for every field is also not a good idea.
    * So just annotate every field with @Json(name = ) is the best way.
    */
    private val moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeLongAdapter())
        .add(SafeIntAdapter())
        .add(SafeDoubleAdapter())
        .add(SafeBooleanAdapter())
        .add(SafeStringListAdapter())
        .add(SafeIntListAdapter())
        .add(SafeOsuGroupListAdapter())
        .add(SafeOsuMedalItemListAdapter())
        .add(SafeOsuTournamentBannerAdapter())
        .add(SafeOsuCountryAdapter())
        .add(SafeOsuExtendCountryAdapter())
        .add(SafeOsuRankHighestAdapter())
        .add(SafeOsuHypeAdapter())
        .add(SafeOsuRankHistoryAdapter())
        .add(SafeOsuTournamentBannerListAdapter())
        .add(SafeOsuBadgeListAdapter())
        .add(SafeOsuVariantListAdapter())
        .add(SafeOsuAchievementListAdapter())
        .add(SafeOsuRecentActivityListAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(OSU_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    private val api = retrofit.create(OsuAPI::class.java)
    private val httpClient = OkHttpClient.Builder().build()
    private val serviceScope = CoroutineScope(Dispatchers.IO)

    internal fun getOsuCard(callback: (OsuCardListDTO) -> Unit, userId: String) {
        serviceScope.launch {
            try {
                val osuCardCall = api.getOsuCard(userId)
                val response = osuCardCall.execute()
                if (response.isSuccessful) {
                    val osuCard = response.body()
                    if (osuCard != null) {
                        callback(osuCard)
                    } else Log.e(TAG, "com.madsam.otora.ui.record.cards.OsuCard is null")
                } else {
                    Log.e(TAG, "Response is not successful in OsuCardThread")
                }
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuCardThread: $e")
            }
        }
    }

    internal fun getOsuRecentActivity(callback: (List<OsuRecentActivityDTO>) -> Unit, userId: String) {
        serviceScope.launch {
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
                    Log.e(TAG, "Response is not successful in OsuRecentActivityThread")
                }
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuRecentActivityThread: $e")
            }
        }
    }

    internal fun getOsuPinnedMap(callback: (List<OsuTopRankItemDTO>) -> Unit, userId: String, mode: String) {
        serviceScope.launch {
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
                    Log.e(TAG, "Response is not successful in OsuPinnedMapThread")
                }
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuPinnedMapThread: $e")
            }
        }
    }

    internal fun getOsuBestMap(callback: (List<OsuTopRankItemDTO>) -> Unit, userId: String, mode: String) {
        serviceScope.launch {
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
                    Log.e(TAG, "Response is not successful in OsuBestMapThread")
                }
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuBestMapThread: $e")
            }
        }
    }

    internal fun getOsuFirstMap(callback: (List<OsuTopRankItemDTO>) -> Unit, userId: String, mode: String) {
        serviceScope.launch {
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
                    Log.e(TAG, "Response is not successful in OsuFirstMapThread")
                }
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuFirstMapThread: $e")
            }
        }
    }

    internal fun getOsuBeatmap(callback: (OsuUserBeatmapDTO) -> Unit, userId: String, mode: String) {
        serviceScope.launch {
            try {
                val osuBeatmapCall = api.getOsuBeatmaps(userId, mode)
                val response = osuBeatmapCall.execute()
                if (response.isSuccessful) {
                    val osuBeatmap = response.body()
                    if (osuBeatmap != null) {
                        callback(osuBeatmap)
                    } else Log.e(TAG, "OsuBeatmap is null")
                } else {
                    Log.e(TAG, "Response is not successful in OsuBeatmapThread")
                }
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuBeatmapThread: $e")
            }
        }
    }

    internal fun getOsuHistorical(callback: (OsuHistoricalDTO) -> Unit, userId: String, mode: String) {
        serviceScope.launch {
            try {
                val osuHistoricalCall = api.getOsuHistorical(userId, mode)
                val response = osuHistoricalCall.execute()
                if (response.isSuccessful) {
                    val osuHistorical = response.body()
                    if (osuHistorical != null) {
                        callback(osuHistorical)
                    } else Log.e(TAG, "OsuHistorical is null")
                } else {
                    Log.e(TAG, "Response is not successful in OsuHistoricalThread")
                }
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuHistoricalThread: $e")
            }
        }
    }

    internal fun getOsuMedals(callback: (OsuInfoDTO) -> Unit, userId: String, mode: String) {
        serviceScope.launch {
            try {
                val url = StringUtils.encodeURL("https://osu.ppy.sh/users/$userId/$mode")
                val html = withContext(Dispatchers.IO) {
                    val request = Request.Builder().url(url).build()
                    val response = httpClient.newCall(request).execute()
                    response.body.string()
                }

                val doc = Ksoup.parse(html)
                val medals = doc.selectFirst("div.js-react.u-contents")
                val medalsJson = medals?.attr("data-initial-data") ?: ""
                val osuInfoDTO = moshi.adapter(OsuInfoDTO::class.java).fromJson(medalsJson)
                if (osuInfoDTO != null) {
                    callback(osuInfoDTO)
                } else Log.e(TAG, "OsuInfo is null")
            } catch (e: IOException) {
                Log.e(TAG, "IOException occurred in OsuMedalsThread: $e")
            }
        }
    }
}
