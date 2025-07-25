package com.madsam.otora.data.bof.remote.api

import com.madsam.otora.data.bof.remote.model.BofCommentDTO
import com.madsam.otora.data.bof.remote.model.BofEntryDTO
import com.madsam.otora.data.bof.remote.model.BofRangeDTO
import com.madsam.otora.data.bof.remote.model.BofTeamDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface BofAPI {
    @GET("bof/tt/work/{date}.json")
    fun getBofttData(
        @Path("date") date: String
    ): Call<List<BofEntryDTO>>

    @GET("bof/tt/team/{date}.json")
    fun getBofttTeamData(
        @Path("date") date: String
    ): Call<List<BofTeamDTO>>

    @GET("bof/tt/comment/user{date}.json")
    fun getBofttComment(
        @Path("date") date: String
    ): Call<List<BofCommentDTO>>

    @GET("bof/range.json")
    fun getBofRangeData(): Call<List<BofRangeDTO>>
}