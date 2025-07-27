package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

internal class SafeStringAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): String {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<String>()
            ""
        } else {
            reader.nextString()
        }
    }
}