package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.madsam.otora.consts.Colors
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.osu.OsuRecent
 * 创建者: MadSamurai
 * 创建时间: 2024/8/7
 * 描述: TODO
 */

@Composable
fun OsuRecent(
    recentActivityList: MutableStateFlow<List<Map<String, String>>>
) {
    val recentActivities = recentActivityList.collectAsState(initial = emptyList()).value
    Surface(
        Modifier
            .padding(
                bottom = 12.dp
            )
            .fillMaxWidth(),
        RoundedCornerShape(20.dp),
        Colors.DARK_RED_DEEP
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .height(200.dp)
        ) {
            items(recentActivities.size) { index ->
                Text(
                    text = recentActivities[index]["content"] ?: "",
                    color = Color.White,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}