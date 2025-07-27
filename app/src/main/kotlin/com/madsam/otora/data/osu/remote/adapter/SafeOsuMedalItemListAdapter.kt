package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeLongAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuMedalItemDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuMedalItemListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeLongAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val osuMedalItemDTOAdapter: JsonAdapter<OsuMedalItemDTO> = moshi.adapter(OsuMedalItemDTO::class.java)

    @FromJson
    fun fromJson(reader: JsonReader): List<OsuMedalItemDTO> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuMedalItemDTO>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuMedalItemDTO>()
            reader.beginArray()
            while (reader.hasNext()) {
                val osuMedalItem = osuMedalItemDTOAdapter.fromJson(reader)
                if (osuMedalItem != null) {
                    list.add(osuMedalItem)
                }
            }
            reader.endArray()
            list
        }
    }
}