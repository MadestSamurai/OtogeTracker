package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OsuUserPage(
    showOsuDialog: Boolean,
    onDismissDialog: () -> Unit
) {
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

    if (showOsuDialog) {
        AlertDialog(
            onDismissRequest = { onDismissDialog() },
            title = { Text(text = "Enter osu details") },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextField(
                        value = userState.value,
                        onValueChange = { userState.value = it },
                        label = { Text("Enter osu id") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    ExposedDropdownMenuBox(
                        expanded = isClicked.value,
                        onExpandedChange = { isClicked.value = it },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextField(
                            value = modeState.value,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Game Mode") },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isClicked.value)
                            },
                            colors = ExposedDropdownMenuDefaults.textFieldColors(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .menuAnchor(MenuAnchorType.PrimaryNotEditable, true)
                        )

                        ExposedDropdownMenu(
                            expanded = isClicked.value,
                            onDismissRequest = { isClicked.value = false }
                        ) {
                            items.forEach { mode ->
                                DropdownMenuItem(
                                    text = { Text(mode) },
                                    onClick = {
                                        modeState.value = mode
                                        isClicked.value = false
                                    }
                                )
                            }
                        }
                    }

                    Button(
                        onClick = {
                            ShareUtil.putString("userId", userState.value, context)
                            ShareUtil.putString("mode", modeState.value, context)
                            osuViewModel.requestOsuData(userState.value, modeState.value, context)
                            onDismissDialog()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Confirm")
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = { onDismissDialog() }) {
                    Text("Cancel")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .background(color = BRIGHT_RED)
            .verticalScroll(scrollState)
    ) {
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