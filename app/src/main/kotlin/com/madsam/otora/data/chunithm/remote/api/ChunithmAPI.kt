package com.madsam.otora.data.chunithm.remote.api

import com.madsam.otora.data.chunithm.remote.model.ChuniMergedDataDTO
import retrofit2.Call
import retrofit2.http.GET

internal interface ChunithmAPI {
    @GET("chuni/data.json")
    fun getChunithmMergedData(): Call<ChuniMergedDataDTO>
}