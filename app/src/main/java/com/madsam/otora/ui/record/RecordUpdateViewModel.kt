package com.madsam.otora.ui.record

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel



class RecordUpdateViewModel : ViewModel() {
    val filePicked = mutableStateOf(false)

    fun updatePickedFile() {
        filePicked.value = true
    }
}