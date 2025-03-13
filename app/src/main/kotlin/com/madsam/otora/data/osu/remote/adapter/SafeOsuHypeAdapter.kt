package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeIntAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuBeatmapSetDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuHypeAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeIntAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val hypeAdapter: JsonAdapter<OsuBeatmapSetDTO.Hype> = moshi.adapter(OsuBeatmapSetDTO.Hype::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): OsuBeatmapSetDTO.Hype {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<OsuBeatmapSetDTO.Hype>()
            OsuBeatmapSetDTO.Hype()
        } else {
            hypeAdapter.fromJson(reader) ?: OsuBeatmapSetDTO.Hype()
        }
    }
}