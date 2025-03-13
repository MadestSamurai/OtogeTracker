package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeDoubleAdapter
import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuStatisticsDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuVariantListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeIntAdapter())
        .add(SafeDoubleAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val variantAdapter: JsonAdapter<OsuStatisticsDTO.Variant> = moshi.adapter(OsuStatisticsDTO.Variant::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuStatisticsDTO.Variant> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuStatisticsDTO.Variant>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuStatisticsDTO.Variant>()
            reader.beginArray()
            while (reader.hasNext()) {
                val variant = variantAdapter.fromJson(reader)
                if (variant != null) {
                    list.add(variant)
                }
            }
            reader.endArray()
            list
        }
    }
}