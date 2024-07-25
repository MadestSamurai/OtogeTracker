package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.madsam.otora.consts.Colors
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.ui.record.osu.OsuCard
import com.madsam.otora.ui.record.osu.OsuLevel
import com.madsam.otora.ui.record.osu.OsuPlayData
import com.madsam.otora.ui.record.osu.OsuRankGraph
import com.madsam.otora.utils.ShareUtil

@Composable
fun OsuUserPage(recordViewModel: RecordViewModel) {
    val context = LocalContext.current
    // State for managing text input
    val textState = remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .background(color = Colors.BRIGHT_RED)
    ) {
        item { // Text field for input
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text("Enter text") },
                modifier = Modifier.fillMaxWidth()
            )

            // Confirmation button
            Button(onClick = {
                ShareUtil.putString("userId", textState.value, context)
            }) {
                Text("Confirm")
            }
        }
        item {
            OsuCard(osuCardData = recordViewModel.osuCardData, osuGroupList = recordViewModel.osuGroupList)
        }
        item {
            OsuRankGraph(osuRankGraphData = recordViewModel.osuRankGraphData, osuRankHighestData = recordViewModel.osuRankHighestData)
        }
        item {
            OsuLevel(osuLevelData = recordViewModel.osuLevelData)
        }
        item {
            OsuPlayData(osuPlayData = recordViewModel.osuPlayData)
        }
    }
}