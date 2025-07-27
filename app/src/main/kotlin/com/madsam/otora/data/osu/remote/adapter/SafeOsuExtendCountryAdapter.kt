package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuUserExtendDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuExtendCountryAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val countryAdapter: JsonAdapter<OsuUserExtendDTO.Country> = moshi.adapter(OsuUserExtendDTO.Country::class.java)

    @FromJson
    fun fromJson(reader: JsonReader): OsuUserExtendDTO.Country {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<OsuUserExtendDTO.Country>()
            OsuUserExtendDTO.Country()
        } else {
            countryAdapter.fromJson(reader) ?: OsuUserExtendDTO.Country()
        }
    }
}