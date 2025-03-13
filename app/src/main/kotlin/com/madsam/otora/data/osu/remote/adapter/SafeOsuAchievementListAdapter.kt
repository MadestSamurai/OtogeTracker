package com.madsam.otora.data.osu.remote.adapter

import com.madsam.otora.data.adapter.SafeStringAdapter
import com.madsam.otora.data.osu.remote.model.OsuUserExtendDTO
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

internal class SafeOsuAchievementListAdapter {
    private val moshi: Moshi = Moshi.Builder()
        .add(SafeStringAdapter())
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val userAchievementAdapter: JsonAdapter<OsuUserExtendDTO.UserAchievement> = moshi.adapter(OsuUserExtendDTO.UserAchievement::class.java)

    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<OsuUserExtendDTO.UserAchievement> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<OsuUserExtendDTO.UserAchievement>>()
            emptyList()
        } else {
            val list = mutableListOf<OsuUserExtendDTO.UserAchievement>()
            reader.beginArray()
            while (reader.hasNext()) {
                val userAchievement = userAchievementAdapter.fromJson(reader)
                if (userAchievement != null) {
                    list.add(userAchievement)
                }
            }
            reader.endArray()
            list
        }
    }
}