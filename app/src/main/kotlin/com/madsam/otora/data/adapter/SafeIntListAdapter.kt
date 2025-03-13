package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

internal class SafeIntListAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<Int> {
        val result = mutableListOf<Int>()
        reader.beginArray()
        while (reader.hasNext()) {
            result.add(reader.nextInt())
        }
        reader.endArray()
        return result
    }
}