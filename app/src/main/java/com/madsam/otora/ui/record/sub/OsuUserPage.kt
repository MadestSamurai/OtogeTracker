package com.madsam.otora.ui.record.sub

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import com.madsam.otora.components.CustomTabRow
import com.madsam.otora.ui.record.OsuScreenState
import com.madsam.otora.ui.record.osu.BadgeList
import com.madsam.otora.ui.record.osu.Card
import com.madsam.otora.ui.record.osu.Level
import com.madsam.otora.ui.record.osu.PlayData
import com.madsam.otora.ui.record.osu.RankGraph
import com.madsam.otora.ui.record.osu.Recent
import com.madsam.otora.ui.record.osu.SocialCard
import com.madsam.otora.ui.record.osu.TopRank
import com.madsam.otora.ui.record.viewmodel.OsuViewModel
import com.madsam.otora.ui.theme.Beige500
import com.madsam.otora.ui.theme.Beige600
import com.madsam.otora.ui.theme.Red300
import com.madsam.otora.ui.theme.Red500
import com.madsam.otora.utils.ScreenUtil.isLandscape
import com.madsam.otora.utils.ShareUtil
import kotlinx.coroutines.flow.update

@Composable
fun OsuUserPage(
    showOsuDialog: Boolean,
    viewModel: OsuViewModel,
    osuScreenState: OsuScreenState,
    onDismissDialog: () -> Unit
) {
    OsuSettingsDialog(
        showDialog = showOsuDialog,
        onDismiss = onDismissDialog,
        viewModel = viewModel
    )

    val configuration = LocalConfiguration.current
    val view = LocalView.current
    val leftPadding by viewModel.leftPadding.collectAsState()
    val rightPadding by viewModel.rightPadding.collectAsState()

    var isTabRowVisible by remember { mutableStateOf(true) }
    val selectedTabIndex by osuScreenState.selectedTab.collectAsState()
    val selectedSubTabIndex by osuScreenState.selectedSubTab.collectAsState()

    val scrollThreshold = 50f

    LaunchedEffect(configuration) {
        viewModel.updatePadding(view)
    }

    Box {
        LazyColumn(
            modifier = Modifier
                .background(Red300)
                .padding(
                    start = 12.dp + if (isLandscape(configuration)) leftPadding else 0.dp,
                    end = 12.dp + if (isLandscape(configuration)) rightPadding else 0.dp
                )
                .nestedScroll(object : NestedScrollConnection {
                    private var totalScroll = 0f

                    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                        totalScroll += available.y
                        if (totalScroll < -scrollThreshold) {
                            isTabRowVisible = false
                            totalScroll = 0f
                        } else if (totalScroll > scrollThreshold) {
                            isTabRowVisible = true
                            totalScroll = 0f
                        }
                        return Offset.Zero
                    }
                })
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

        val tabTitles = mapOf(
            "Home" to listOf(""),
            "TopRank" to listOf("Pinned", "Top", "First"),
            "Comment" to listOf("")
        )

        val mainTabTitles = tabTitles.keys.toList()
        val subTabTitles = tabTitles[mainTabTitles[selectedTabIndex]] ?: emptyList()

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            // 子标签栏
            AnimatedVisibility(
                visible = isTabRowVisible && subTabTitles.size > 1,
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
            ) {
                CustomTabRow(
                    selectedTabIndex = selectedSubTabIndex,
                    modifier = Modifier.padding(3.dp),
                    containerColor = Red500
                ) {
                    subTabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedSubTabIndex == index,
                            onClick = {
                                if (selectedSubTabIndex != index) {
                                    osuScreenState.selectedSubTab.update { index }
                                }
                            },
                            text = {
                                Text(
                                    text = title,
                                    color = if (selectedSubTabIndex == index) Beige500 else Beige600
                                )
                            },
                            modifier = Modifier.height(35.dp)
                        )
                    }
                }
            }
            // 主标签栏
            AnimatedVisibility(
                visible = isTabRowVisible,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                CustomTabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.padding(3.dp),
                    containerColor = Red500
                ) {
                    mainTabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = {
                                if (selectedTabIndex != index) {
                                    osuScreenState.selectedTab.update { index }
                                    // 只有在有子标签时才重置子标签索引
                                    val subTabs = tabTitles[mainTabTitles[index]] ?: emptyList()
                                    if (subTabs.isNotEmpty()) {
                                        osuScreenState.selectedSubTab.update { 0 }
                                    }
                                }
                            },
                            text = {
                                Text(
                                    text = title,
                                    color = if (selectedTabIndex == index) Beige500 else Beige600,
                                )
                            },
                            modifier = Modifier.height(40.dp)
                        )
                    }
                }
            }
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
        confirmButton = { },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}