package com.madsam.otora.data.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal class SafeIntPairAdapter {
    @FromJson
    @Suppress("unused")
    fun fromJson(reader: JsonReader): Pair<Int, Int> {
        var first = 0
        var second = 0

        reader.beginArray()
        if (reader.hasNext()) {
            first = reader.nextInt()
        }
        if (reader.hasNext()) {
            second = reader.nextInt()
        }
        reader.endArray()

        return Pair(first, second)
    }

    @ToJson
    @Suppress("unused")
    fun toJson(writer: JsonWriter, value: Pair<Int, Int>) {
        writer.beginArray()
        writer.value(value.first)
        writer.value(value.second)
        writer.endArray()
    }
}