package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

internal class SafeBooleanAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): Boolean {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Boolean>()
            false
        } else {
            reader.nextBoolean()
        }
    }
}