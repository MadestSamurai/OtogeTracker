package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

internal class SafeLongAdapter {
    @FromJson
    fun fromJson(reader: JsonReader): Long {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Long>()
            0
        } else {
            reader.nextLong()
        }
    }
}