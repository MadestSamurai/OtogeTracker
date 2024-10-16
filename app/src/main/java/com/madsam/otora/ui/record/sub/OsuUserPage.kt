package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.madsam.otora.consts.Colors
import com.madsam.otora.ui.record.RecordViewModel
import com.madsam.otora.ui.record.osu.BadgeList
import com.madsam.otora.ui.record.osu.Card
import com.madsam.otora.ui.record.osu.Level
import com.madsam.otora.ui.record.osu.PlayData
import com.madsam.otora.ui.record.osu.RankGraph
import com.madsam.otora.ui.record.osu.Recent
import com.madsam.otora.ui.record.osu.SocialCard
import com.madsam.otora.ui.record.osu.TopRank
import com.madsam.otora.utils.ShareUtil

@Composable
fun OsuUserPage(recordViewModel: RecordViewModel) {
    val context = LocalContext.current
    val userState = remember { mutableStateOf("") }
    val modeState = remember { mutableStateOf("osu") }
    val items = listOf("mania", "osu", "taiko", "fruits")
    val isClicked = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(color = Colors.BRIGHT_RED)
            .verticalScroll(scrollState)
    ) {
        TextField(
            value = userState.value,
            onValueChange = { userState.value = it },
            label = { Text("Enter osu id") },
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            Column {
                Button(
                    onClick = { isClicked.value = !isClicked.value },
                    content = {
                        Text(modeState.value)
                    },
                    //TODO make button like a text field
                )
                DropdownMenu(
                    expanded = isClicked.value,
                    onDismissRequest = { isClicked.value = false },
                    content = {
                        items.forEach {
                            DropdownMenuItem(
                                onClick = {
                                    modeState.value = it
                                    isClicked.value = false
                                },
                                text = { Text(it) }
                            )
                        }
                    }
                )
            }
            Button(
                onClick = {
                    ShareUtil.putString("userId", userState.value, context)
                    ShareUtil.putString("mode", modeState.value, context)
                    recordViewModel.requestOsuData(userState.value, modeState.value, context)
                },
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text("Confirm")
            }
        }
        Card(recordViewModel.osuCardData, recordViewModel.osuGroupList)
        BadgeList(recordViewModel.osuBadgeList)
        RankGraph(recordViewModel.osuRankGraphData, recordViewModel.osuRankHighestData)
        Level(recordViewModel.osuLevelData)
        PlayData(recordViewModel.osuPlayData)
        SocialCard(recordViewModel.osuSocialCardData)
        Recent(recordViewModel.osuRecentActivityData)
        TopRank(recordViewModel.osuPinnedMapData, recordViewModel.osuBestMapData, recordViewModel.osuFirstMapData)
    }
}