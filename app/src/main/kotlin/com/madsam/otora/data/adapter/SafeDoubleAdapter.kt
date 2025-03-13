package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader

internal class SafeDoubleAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): Double {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Double>()
            0.0
        } else {
            reader.nextDouble()
        }
    }
}