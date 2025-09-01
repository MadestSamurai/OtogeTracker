package com.madsam.otora.data.bof.remote.api

import com.madsam.otora.data.bof.remote.model.BofCommentSingleResponse
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import com.madsam.otora.data.bof.remote.model.BofWorkData
import com.madsam.otora.data.bof.remote.model.BofTeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface BofAPI {
    @GET("bof/range.json")
    fun getBofRangeData(): Call<List<BofRangeResponse>>

    @GET("bof/{path}/work.json")
    fun getBofWorkData(
        @Path("path") path: String
    ): Call<Map<String, BofWorkData>>

    @GET("bof/{path}/team.json")
    fun getBofTeamData(
        @Path("path") path: String
    ): Call<List<BofTeamResponse>>

    @GET("bof/{path}/comment.json")
    fun getBofCommentData(
        @Path("path") path: String
    ): Call<List<BofCommentSingleResponse>>
}