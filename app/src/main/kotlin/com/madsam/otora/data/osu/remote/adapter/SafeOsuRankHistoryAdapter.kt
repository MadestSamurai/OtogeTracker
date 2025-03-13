package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeIntListAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuUserExtendDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuRankHistoryAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeIntAdapter())
        .add(SafeIntListAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val rankHistoryAdapter: JsonAdapter<OsuUserExtendDTO.RankHistory> = moshi.adapter(OsuUserExtendDTO.RankHistory::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): OsuUserExtendDTO.RankHistory {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<OsuUserExtendDTO.RankHistory>()
            OsuUserExtendDTO.RankHistory()
        } else {
            rankHistoryAdapter.fromJson(reader) ?: OsuUserExtendDTO.RankHistory()
        }
    }
}