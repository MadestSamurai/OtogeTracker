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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.consts.BRIGHT_RED
import com.madsam.otora.ui.record.osu.BadgeList
import com.madsam.otora.ui.record.osu.Card
import com.madsam.otora.ui.record.osu.Level
import com.madsam.otora.ui.record.osu.PlayData
import com.madsam.otora.ui.record.osu.RankGraph
import com.madsam.otora.ui.record.osu.Recent
import com.madsam.otora.ui.record.osu.SocialCard
import com.madsam.otora.ui.record.osu.TopRank
import com.madsam.otora.ui.record.viewmodel.OsuViewModel
import com.madsam.otora.ui.record.viewmodel.OsuViewModelFactory
import com.madsam.otora.utils.ShareUtil

@Composable
fun OsuUserPage() {
    val context = LocalContext.current

    val osuViewModel: OsuViewModel = viewModel(factory = OsuViewModelFactory(
        userId = ShareUtil.getString("userId", context) ?: "2",
        mode = ShareUtil.getString("mode", context) ?: "osu",
        context = context
    ))
    val userState = remember { mutableStateOf("") }
    val modeState = remember { mutableStateOf("osu") }
    val items = listOf("mania", "osu", "taiko", "fruits")
    val isClicked = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(color = BRIGHT_RED)
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
                    osuViewModel.requestOsuData(userState.value, modeState.value, context)
                },
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text("Confirm")
            }
        }
        Card(osuViewModel.osuCardData, osuViewModel.osuGroupList)
        BadgeList(osuViewModel.osuBadgeList)
        RankGraph(osuViewModel.osuRankGraphData, osuViewModel.osuRankHighestData)
        Level(osuViewModel.osuLevelData)
        PlayData(osuViewModel.osuPlayData)
        SocialCard(osuViewModel.osuSocialCardData)
        Recent(osuViewModel.osuRecentActivityData)
        TopRank(osuViewModel.osuPinnedMapData, osuViewModel.osuBestMapData, osuViewModel.osuFirstMapData)
    }
}