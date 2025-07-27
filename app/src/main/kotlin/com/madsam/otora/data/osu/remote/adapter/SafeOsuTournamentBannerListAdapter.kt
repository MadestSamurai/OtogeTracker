package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeLongAdapter
import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuUserExtendDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuTournamentBannerListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .add(SafeLongAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val activeTournamentBannerAdapter: JsonAdapter<OsuUserExtendDTO.ActiveTournamentBanner> = moshi.adapter(OsuUserExtendDTO.ActiveTournamentBanner::class.java)

    @FromJson
    fun fromJson(reader: JsonReader): List<OsuUserExtendDTO.ActiveTournamentBanner> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuUserExtendDTO.ActiveTournamentBanner>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuUserExtendDTO.ActiveTournamentBanner>()
            reader.beginArray()
            while (reader.hasNext()) {
                val activeTournamentBanner = activeTournamentBannerAdapter.fromJson(reader)
                if (activeTournamentBanner != null) {
                    list.add(activeTournamentBanner)
                }
            }
            reader.endArray()
            list
        }
    }
}