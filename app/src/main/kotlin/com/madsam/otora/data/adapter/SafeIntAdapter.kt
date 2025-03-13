package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

internal class SafeIntAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): Int {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Int>()
            0
        } else {
            reader.nextInt()
        }
    }
}