package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

internal class SafeStringListAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): List<String> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<String>>()
            emptyList()
        } else {
            val list = mutableListOf<String>()
            reader.beginArray()
            while (reader.hasNext()) {
                list.add(reader.nextString())
            }
            reader.endArray()
            list
        }
    }
}
