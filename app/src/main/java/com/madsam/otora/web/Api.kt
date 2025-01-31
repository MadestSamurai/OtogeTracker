package com.madsam.otora.web

import com.madsam.otora.model.bof.web.BofComment
import com.madsam.otora.model.bof.web.BofEntry
import com.madsam.otora.model.bof.web.BofTeam
import com.madsam.otora.model.chuni.web.lxns.ChuniAliases
import com.madsam.otora.model.chuni.web.lxns.LxnsData
import com.madsam.otora.model.chuni.web.jp.ChuniJpData
import com.madsam.otora.model.osu.web.OsuCardList
import com.madsam.otora.model.osu.web.OsuHistorical
import com.madsam.otora.model.osu.web.OsuRecentActivity
import com.madsam.otora.model.osu.web.OsuTopRankItem
import com.madsam.otora.model.osu.web.OsuUserBeatmap
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

    // Bof API
    @GET("bof/tt/work/{date}.json")
    fun getBofttData(
        @Path("date") date: String
    ): Call<List<BofEntry>>

    @GET("bof/tt/team/{date}.json")
    fun getBofttTeamData(
        @Path("date") date: String
    ): Call<List<BofTeam>>

    @GET("bof/tt/comment/user{date}.json")
    fun getBofttComment(
        @Path("date") date: String
    ): Call<List<BofComment>>

    // Chunithm API
    @GET("chuni/jp.json")
    fun getChunithmSongsJp(): Call<ChuniJpData>

    @GET("chunithm/song/list")
    fun getChunithmSongsLxns(): Call<LxnsData>

    @GET("chunithm/alias/list")
    fun getChunithmAliasList(): Call<ChuniAliases>
}
