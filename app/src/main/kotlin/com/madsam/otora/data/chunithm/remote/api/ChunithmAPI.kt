package com.madsam.otora.data.chunithm.remote.api

import com.madsam.otora.data.chunithm.remote.model.ChuniAliasesDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniJpDTO
import com.madsam.otora.data.chunithm.remote.model.ChuniLxnsDTO
import retrofit2.Call
import retrofit2.http.GET

internal interface ChunithmAPI {
    @GET("chuni/jp.json")
    fun getChunithmSongsJp(): Call<ChuniJpDTO>

    @GET("chunithm/song/list")
    fun getChunithmSongsLxns(): Call<ChuniLxnsDTO>

    @GET("chunithm/alias/list")
    fun getChunithmAliasList(): Call<ChuniAliasesDTO>
}