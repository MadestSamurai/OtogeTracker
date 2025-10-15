package com.madsam.otora.data.bof.remote.api

import com.madsam.otora.data.bof.remote.model.BofCommentSingleResponse
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import com.madsam.otora.data.bof.remote.model.BofWorkData
import com.madsam.otora.data.bof.remote.model.BofTeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface BofAPI {
    @GET("range.json")
    fun getBofRangeData(): Call<List<BofRangeResponse>>

    @GET("{path}/work.json")
    fun getBofWorkData(
        @Path("path") path: String
    ): Call<Map<String, BofWorkData>>

    @GET("{path}/team.json")
    fun getBofTeamData(
        @Path("path") path: String
    ): Call<List<BofTeamResponse>>

    @GET("{path}/comment.json")
    fun getBofCommentData(
        @Path("path") path: String
    ): Call<List<BofCommentSingleResponse>>
}