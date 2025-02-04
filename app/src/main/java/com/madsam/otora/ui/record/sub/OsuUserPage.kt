package com.madsam.otora.ui.record.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
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
import com.madsam.otora.utils.ScreenUtil.isLandscape
import com.madsam.otora.utils.ShareUtil
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun OsuUserPage(
    showOsuDialog: Boolean,
    viewModel: OsuViewModel,
    onDismissDialog: () -> Unit
) {
    OsuSettingsDialog(
        showDialog = showOsuDialog,
        onDismiss = onDismissDialog,
        viewModel = viewModel
    )

    val configuration = LocalConfiguration.current
    val view = LocalView.current
    val leftPadding = viewModel.leftPadding.asStateFlow().collectAsState().value
    val rightPadding = viewModel.rightPadding.asStateFlow().collectAsState().value

    LaunchedEffect(configuration) {
        viewModel.updatePadding(view)
    }

    LazyColumn(
        modifier = Modifier
            .background(color = BRIGHT_RED)
            .padding(
                start = 12.dp + if (isLandscape(configuration)) leftPadding else 0.dp,
                end = 12.dp + if (isLandscape(configuration)) rightPadding else 0.dp
            )
    ) {
        item(key = "card_data") {
            Card(viewModel.cardUI, viewModel.groupListUI)
        }
        item(key = "badge_list") {
            BadgeList(viewModel.badgeUI)
        }
        item(key = "rank_graph") {
            RankGraph(viewModel.rankGraphUI, viewModel.topRankUI)
            Level(viewModel.levelUI)
        }
        item(key = "play_data") {
            PlayData(viewModel.playUI)
        }
        item(key = "social") {
            SocialCard(viewModel.socialUI)
        }
        item(key = "recent") {
            Recent(viewModel.recentUI)
        }
        item(key = "top_rank") {
            TopRank(viewModel.pinnedUI, viewModel.bestUI, viewModel.firstUI)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OsuSettingsDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    viewModel: OsuViewModel
) {
    if (!showDialog) return

    val context = LocalContext.current
    val userState = remember { mutableStateOf("") }
    val modeState = remember { mutableStateOf("osu") }
    val isClicked = remember { mutableStateOf(false) }
    val items = remember { listOf("mania", "osu", "taiko", "fruits") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Enter osu details") },
        text = {
            Column {
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
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isClicked.value) },
                        modifier = Modifier
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
                        viewModel.loadData(userState.value, modeState.value, context)
                        onDismiss()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Confirm")
                }
            }
        },
        confirmButton = {},
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}