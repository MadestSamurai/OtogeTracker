package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuUserExtendDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuRankHighestAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeIntAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val rankHighestAdapter: JsonAdapter<OsuUserExtendDTO.RankHighest> = moshi.adapter(OsuUserExtendDTO.RankHighest::class.java)

    @FromJson
    fun fromJson(reader: JsonReader): OsuUserExtendDTO.RankHighest {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<OsuUserExtendDTO.RankHighest>()
            OsuUserExtendDTO.RankHighest()
        } else {
            rankHighestAdapter.fromJson(reader) ?: OsuUserExtendDTO.RankHighest()
        }
    }
}