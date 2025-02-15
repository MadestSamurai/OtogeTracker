package com.madsam.otora.utils

import android.content.Context
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

object JsonUtil {
    fun saveJsonToFile(context: Context, fileName: String, json: String): Boolean {
        return try {
            val file = File(context.filesDir, fileName)
            FileOutputStream(file).use { outputStream ->
                outputStream.write(json.toByteArray())
            }
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    fun readJsonFromFile(context: Context, fileName: String): String? {
        val file = File(context.filesDir, fileName)
        if (!file.exists()) {
            println("File not found: $fileName")
            return null
        }
        return try {
            FileInputStream(file).use { inputStream ->
                inputStream.bufferedReader().use { it.readText() }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}