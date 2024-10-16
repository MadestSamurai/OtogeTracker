package com.madsam.otora.ui.bof

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.madsam.otora.model.bof.BofEntryShow
import com.madsam.otora.service.BofDataRequestService
import kotlinx.coroutines.launch

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
    val bofDataRequestService = BofDataRequestService(context)
    val todayLatestData = remember { mutableStateOf<List<BofEntryShow>>(emptyList()) }
    val coroutineScope = rememberCoroutineScope()

    fun refreshData() {
        coroutineScope.launch {
            bofDataRequestService.getBofttData()
        }
    }

    LaunchedEffect(Unit) {
        todayLatestData.value = bofDataRequestService.getBofttEntryByTime()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "BOF Screen")
        Button(onClick = { refreshData() }, modifier = Modifier.padding(16.dp)) {
            Text(text = "Refresh Data")
        }
        LazyColumn {
            items(todayLatestData.value) { entry ->
                BofEntryRow(entry)
            }
        }
    }
}

@Composable
fun BofEntryRow(entry: BofEntryShow) {
    Row(modifier = Modifier.padding(8.dp)) {
        Text(text = entry.title, modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.artist, modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.impr.toString(), modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.total.toString(), modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.median.toString(), modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.avg.toString(), modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.oldImpr.toString(), modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.oldTotal.toString(), modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.oldMedian.toString(), modifier = Modifier.padding(end = 8.dp))
        Text(text = entry.oldAvg.toString(), modifier = Modifier.padding(end = 8.dp))
    }
}