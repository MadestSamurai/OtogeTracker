package com.madsam.otora.ui.record

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel



class RecordUpdateViewModel : ViewModel() {
    private val filePicked = mutableStateOf(false)

    fun updatePickedFile() {
        filePicked.value = true
    }
    fun resetPickedFile() {
        filePicked.value = false
    }
    fun isFilePicked(): Boolean {
        return filePicked.value
    }
}