package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuCardDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuCountryAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val countryAdapter: JsonAdapter<OsuCardDTO.Country> = moshi.adapter(OsuCardDTO.Country::class.java)

    @FromJson
    fun fromJson(reader: JsonReader): OsuCardDTO.Country {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<OsuCardDTO.Country>()
            OsuCardDTO.Country()
        } else {
            countryAdapter.fromJson(reader) ?: OsuCardDTO.Country()
        }
    }
}