package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeBooleanAdapter
import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuRecentActivityDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuRecentActivityListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeIntAdapter())
        .add(SafeBooleanAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val recentActivityAdapter: JsonAdapter<OsuRecentActivityDTO> = moshi.adapter(OsuRecentActivityDTO::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuRecentActivityDTO> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuRecentActivityDTO>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuRecentActivityDTO>()
            reader.beginArray()
            while (reader.hasNext()) {
                val recentActivity = recentActivityAdapter.fromJson(reader)
                if (recentActivity != null) {
                    list.add(recentActivity)
                }
            }
            reader.endArray()
            list
        }
    }
}