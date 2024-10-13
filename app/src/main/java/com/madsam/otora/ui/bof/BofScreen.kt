package com.madsam.otora.ui.bof

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.madsam.otora.entity.bof.BofEntry
import com.madsam.otora.service.BofDataRequestService

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/7
 * 描述: TODO
 */
@Composable
fun BofScreen() {
    val context = LocalContext.current
    val bofDataRequestService = BofDataRequestService()
    val bofEntryData = remember { mutableStateOf(emptyList<BofEntry>()) }
    bofDataRequestService.getBofttData { bofEntryList ->
        bofEntryData.value = bofEntryList
    }

    Column {
        Text(
            text = "BOF Screen",
        )
        Text(text = if (bofEntryData.value.isEmpty()) "null" else bofEntryData.value[0].toString(),
            modifier = Modifier.fillMaxSize()
        )
    }
}