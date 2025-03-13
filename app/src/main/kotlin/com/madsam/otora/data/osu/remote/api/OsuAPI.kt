package com.madsam.otora.data.osu.remote.api

import com.madsam.otora.data.osu.remote.model.OsuCardListDTO
import com.madsam.otora.data.osu.remote.model.OsuHistoricalDTO
import com.madsam.otora.data.osu.remote.model.OsuRecentActivityDTO
import com.madsam.otora.data.osu.remote.model.OsuTopRankItemDTO
import com.madsam.otora.data.osu.remote.model.OsuUserBeatmapDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface OsuAPI {
    @GET("users/lookup")
    fun getOsuCard(@Query("ids[]") user: String): Call<OsuCardListDTO>

    @GET("users/{user}/scores/pinned?limit=100")
    fun getOsuPinnedMap(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<List<OsuTopRankItemDTO>>

    @GET("users/{user}/scores/best?limit=100")
    fun getOsuBestMap(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<List<OsuTopRankItemDTO>>

    @GET("users/{user}/scores/firsts?limit=100")
    fun getOsuFirstMap(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<List<OsuTopRankItemDTO>>

    @GET("users/{user}/extra-pages/historical")
    fun getOsuHistorical(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<OsuHistoricalDTO>

    @GET("users/{user}/recent_activity?limit=100")
    fun getOsuRecentActivity(
        @Path("user") user: String
    ): Call<List<OsuRecentActivityDTO>>

    @GET("users/{user}/extra-pages/beatmaps")
    fun getOsuBeatmaps(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<OsuUserBeatmapDTO>

    @GET("users/{user}/extra-pages/kudosu")
    fun getOsuKudosu(@Path("user") user: String, @Query("mode") mode: String): Call<String>
}