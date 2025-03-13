package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeBooleanAdapter
import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.adapter.SafeStringListAdapter
import com.madsam.otora.data.osu.remote.model.OsuGroupDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuGroupListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeBooleanAdapter())
        .add(SafeIntAdapter())
        .add(SafeStringListAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val osuGroupDTOAdapter: JsonAdapter<OsuGroupDTO> = moshi.adapter(OsuGroupDTO::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuGroupDTO> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuGroupDTO>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuGroupDTO>()
            reader.beginArray()
            while (reader.hasNext()) {
                val osuGroup = osuGroupDTOAdapter.fromJson(reader)
                if (osuGroup != null) {
                    list.add(osuGroup)
                }
            }
            reader.endArray()
            list
        }
    }
}