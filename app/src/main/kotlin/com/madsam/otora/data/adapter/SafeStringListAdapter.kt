package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

internal class SafeStringListAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): List<String> {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<List<String>>()
            emptyList()
        } else {
            val list = mutableListOf<String>()
            reader.beginArray()
            while (reader.hasNext()) {
                when (reader.peek()) {
                    JsonReader.Token.STRING -> list.add(reader.nextString())
                    JsonReader.Token.BEGIN_OBJECT -> {
                        // Skip objects (e.g., for account_history which returns objects instead of strings)
                        reader.skipValue()
                    }
                    else -> reader.skipValue()
                }
            }
            reader.endArray()
            list
        }
    }
}
