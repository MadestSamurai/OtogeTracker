package com.madsam.otora.web

import com.madsam.otora.entity.web.OsuCardList
import com.madsam.otora.entity.web.OsuHistorical
import com.madsam.otora.entity.web.OsuRecentActivity
import com.madsam.otora.entity.web.OsuTopRankItem
import com.madsam.otora.entity.web.OsuUserBeatmap
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 项目名: MusiCord
 * 文件名: Api
 * 创建者: MadSamurai
 * 创建时间:2023/4/22 15:12
 * 描述: 网络请求接口
 */
interface Api {
    //osu API
    @GET("users/lookup")
    fun getOsuCard(@Query("ids[]") user: String): Call<OsuCardList>

    @GET("users/{user}/scores/pinned?limit=100")
    fun getOsuPinnedMap(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<List<OsuTopRankItem>>

    @GET("users/{user}/scores/best?limit=100")
    fun getOsuBestMap(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<List<OsuTopRankItem>>

    @GET("users/{user}/scores/firsts?limit=100")
    fun getOsuFirstMap(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<List<OsuTopRankItem>>

    @GET("users/{user}/extra-pages/historical")
    fun getOsuHistorical(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<OsuHistorical>

    @GET("users/{user}/recent_activity?limit=100")
    fun getOsuRecentActivity(
        @Path("user") user: String
    ): Call<List<OsuRecentActivity>>

    @GET("users/{user}/extra-pages/beatmaps")
    fun getOsuBeatmaps(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<OsuUserBeatmap>

    @GET("users/{user}/extra-pages/kudosu")
    fun getOsuKudosu(@Path("user") user: String, @Query("mode") mode: String): Call<String>

    // Chunithm API
    @GET("home")
    fun getChunithmHome(@Header("User-Agent")userAgent: String): Call<String>
}
