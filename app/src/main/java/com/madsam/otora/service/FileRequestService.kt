package com.madsam.otora.service

import android.content.Context
import android.net.Uri
import com.madsam.otora.ui.record.RecordUpdateViewModel
import com.madsam.otora.utils.ShareUtil
import java.io.BufferedReader
import java.io.InputStreamReader

enum class FilePickerSource {
    HOME_BUTTON, BUTTON2 // Add more identifiers as needed
}

class FileRequestService {
    fun readFileContent(context: Context, fileUri: Uri): String {
        val stringBuilder = StringBuilder()
        context.contentResolver.openInputStream(fileUri)?.use { inputStream ->
            InputStreamReader(inputStream).use { inputStreamReader ->
                BufferedReader(inputStreamReader).use { reader ->
                    var line: String? = reader.readLine()
                    while (line != null) {
                        stringBuilder.append(line)
                        line = reader.readLine()
                    }
                }
            }
        }
        return stringBuilder.toString()
    }

    fun fileAnalyser(fileContent: String, source: FilePickerSource, context: Context, recordUpdateViewModel: RecordUpdateViewModel){
        when (source) {
            FilePickerSource.HOME_BUTTON -> {
                // Handle the file picked from the home button
                println("File Content: $fileContent")
                // Store in SharedPreferences
                ShareUtil.putString("analysedText", fileContent.slice(0..100), context)
                recordUpdateViewModel.filePicked.value = true
            }
            FilePickerSource.BUTTON2 -> {
                // Handle the file picked from the second button
            }
        }
    }
}