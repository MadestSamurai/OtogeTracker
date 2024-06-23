package com.madsam.otora.web

import com.madsam.otora.entity.web.OsuCard
import com.madsam.otora.entity.web.OsuHistorical
import com.madsam.otora.entity.web.OsuTopRanks
import com.madsam.otora.entity.web.OsuUserBeatmap
import retrofit2.Call
import retrofit2.http.GET
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
    @GET("users/{user}/card")
    fun getOsuCard(@Path("user") user: String?): Call<OsuCard>

    @GET("users/{user}/extra-pages/top_ranks")
    fun getOsuTopRanks(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<OsuTopRanks>

    @GET("users/{user}/extra-pages/historical")
    fun getOsuHistorical(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<OsuHistorical>

    @GET("users/{user}/extra-pages/recent_activity")
    fun getOsuRecentActivity(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<String>

    @GET("users/{user}/extra-pages/beatmaps")
    fun getOsuBeatmaps(
        @Path("user") user: String,
        @Query("mode") mode: String
    ): Call<OsuUserBeatmap>

    @GET("users/{user}/extra-pages/kudosu")
    fun getOsuKudosu(@Path("user") user: String, @Query("mode") mode: String): Call<String>
}
