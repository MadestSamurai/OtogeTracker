package com.madsam.otora.activity

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.activity.MainViewModel
 * 创建者: MadSamurai
 * 创建时间: 2024/7/25
 * 描述: 主ViewModel
 */
class MainViewModel: ViewModel(){
    // Chunithm
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