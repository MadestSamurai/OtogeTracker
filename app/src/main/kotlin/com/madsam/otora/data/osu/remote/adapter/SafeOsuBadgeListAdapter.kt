package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuUserExtendDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuBadgeListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val badgeAdapter: JsonAdapter<OsuUserExtendDTO.Badge> = moshi.adapter(OsuUserExtendDTO.Badge::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuUserExtendDTO.Badge> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuUserExtendDTO.Badge>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuUserExtendDTO.Badge>()
            reader.beginArray()
            while (reader.hasNext()) {
                val badge = badgeAdapter.fromJson(reader)
                if (badge != null) {
                    list.add(badge)
                }
            }
            reader.endArray()
            list
        }
    }
}