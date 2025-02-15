package com.madsam.otora.ui.record.sub

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.madsam.otora.components.CustomTabRow
import com.madsam.otora.model.osu.ui.OsuRecentUI
import com.madsam.otora.model.osu.ui.OsuTopRankUI
import com.madsam.otora.ui.record.OsuScreenState
import com.madsam.otora.ui.record.osu.BadgeList
import com.madsam.otora.ui.record.osu.Card
import com.madsam.otora.ui.record.osu.Level
import com.madsam.otora.ui.record.osu.OsuRecentItem
import com.madsam.otora.ui.record.osu.OsuTopRankItemCard
import com.madsam.otora.ui.record.osu.PlayData
import com.madsam.otora.ui.record.osu.RankGraph
import com.madsam.otora.ui.record.osu.Recent
import com.madsam.otora.ui.record.osu.SocialCard
import com.madsam.otora.ui.record.osu.TopRank
import com.madsam.otora.ui.record.viewmodel.OsuViewModel
import com.madsam.otora.ui.theme.Beige400
import com.madsam.otora.ui.theme.Beige500
import com.madsam.otora.ui.theme.Beige600
import com.madsam.otora.ui.theme.Red300
import com.madsam.otora.ui.theme.Red500
import com.madsam.otora.ui.theme.Red700
import com.madsam.otora.utils.ScreenUtil.isLandscape
import com.madsam.otora.utils.ShareUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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
    val selectedTabIndex by osuScreenState.selectedTab.collectAsState()
    val selectedSubTabIndex by osuScreenState.selectedSubTab.collectAsState()
    val scrollThreshold = 50f

    var isTabRowVisible by remember { mutableStateOf(true) }
    val tabTitles = mapOf(
        "Home" to listOf(""),
        "TopRank" to listOf("Pinned", "Top", "First"),
        "Comment" to listOf("")
    )

    val mainTabTitles = tabTitles.keys.toList()
    val subTabTitles = tabTitles[mainTabTitles[selectedTabIndex]] ?: emptyList()

    val pagerState = rememberPagerState { mainTabTitles.size }

    // 处理滑动导致的页面切换
    LaunchedEffect(pagerState.currentPage) {
        if (selectedTabIndex != pagerState.currentPage) {
            osuScreenState.selectedTab.update { pagerState.currentPage }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            // 添加页面切换回调
            pageSpacing = 0.dp,
        ) { page ->
            when (page) {
                0 -> MainPage(
                    viewModel = viewModel,
                    scrollThreshold = scrollThreshold,
                ) { isTabRowVisible = it }

                1 -> TopRankPage(
                    viewModel = viewModel,
                    scrollThreshold = scrollThreshold,
                    osuScreenState = osuScreenState
                ) { isTabRowVisible = it }

                2 -> CommentPage()
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            val scope = rememberCoroutineScope()
            // 子标签栏
            AnimatedVisibility(
                visible = isTabRowVisible && subTabTitles.size > 1,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.CenterHorizontally)
            ) {
                CustomTabRow(
                    selectedTabIndex = selectedSubTabIndex,
                    modifier = Modifier
                        .padding(3.dp),
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
                    .align(Alignment.CenterHorizontally)
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
                                    scope.launch {
                                        pagerState.animateScrollToPage(index)
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

@Composable
private fun MainPage(
    viewModel: OsuViewModel,
    scrollThreshold: Float,
    setIsTabRowVisible: (Boolean) -> Unit
) {
    val configuration = LocalConfiguration.current
    val view = LocalView.current
    val leftPadding by viewModel.leftPadding.collectAsState()
    val rightPadding by viewModel.rightPadding.collectAsState()

    var showFullRecentDialog by remember { mutableStateOf(false) }

    LaunchedEffect(configuration) {
        viewModel.updatePadding(view)
    }
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
                        setIsTabRowVisible(false)
                        totalScroll = 0f
                    } else if (totalScroll > scrollThreshold) {
                        setIsTabRowVisible(true)
                        totalScroll = 0f
                    }
                    return Offset.Zero
                }
            })
    ) {
        item(key = "card_data") { Card(viewModel.cardUI, viewModel.groupListUI) }
        item(key = "badge_list") { BadgeList(viewModel.badgeUI) }
        item(key = "rank_graph") {
            RankGraph(viewModel.rankGraphUI, viewModel.topRankUI)
            Level(viewModel.levelUI)
        }
        item(key = "play_data") { PlayData(viewModel.playUI) }
        item(key = "social") { SocialCard(viewModel.socialUI) }
        item(key = "recent") {
            Recent(
                recentActivityList = viewModel.recentBrief,
                onMoreClick = { showFullRecentDialog = true }
            )
        }
        item(key = "top_rank") { TopRank(viewModel.pinnedUI, viewModel.bestUI, viewModel.firstUI) }
    }

    // Add the Recent dialog
    if (showFullRecentDialog) {
        RecentDialog(
            recentActivityList = viewModel.recentUI,
            onDismiss = { showFullRecentDialog = false }
        )
    }
}

@Composable
private fun RecentDialog(
    recentActivityList: MutableStateFlow<List<OsuRecentUI>>,
    onDismiss: () -> Unit
) {
    val activities by recentActivityList.collectAsState()
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    val cardWidthDp = screenWidthDp - 24.dp

    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.7f)
            .padding(horizontal = 8.dp),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Recent Activities",
                    fontWeight = FontWeight.Bold,
                    color = Beige400
                )
                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Beige400
                    )
                }
            }
        },
        text = {
            LazyColumn(
                modifier = Modifier.clip(RoundedCornerShape(6.dp))
            ) {
                items(
                    count = activities.size,
                    key = { index -> activities[index].createdAt }
                ) { index ->
                    OsuRecentItem(
                        activities[index],
                        cardWidthDp
                    )
                }
            }
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        ),
        confirmButton = { }, // 移除底部按钮
        containerColor = Red700,
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
private fun TopRankPage(
    viewModel: OsuViewModel,
    scrollThreshold: Float,
    osuScreenState: OsuScreenState,
    setIsTabRowVisible: (Boolean) -> Unit
) {
    val selectedSubTabIndex by osuScreenState.selectedSubTab.collectAsState()
    val configuration = LocalConfiguration.current
    val view = LocalView.current
    val leftPadding by viewModel.leftPadding.collectAsState()
    val rightPadding by viewModel.rightPadding.collectAsState()

    LaunchedEffect(configuration) {
        viewModel.updatePadding(view)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
            .padding(
                start = 12.dp + if (isLandscape(configuration)) leftPadding else 0.dp,
                end = 12.dp + if (isLandscape(configuration)) rightPadding else 0.dp
            )
    ) {
        when (selectedSubTabIndex) {
            0 -> RankListPage(maps = viewModel.pinnedUI, title = "Pinned")
            1 -> RankListPage(maps = viewModel.bestUI, title = "Top")
            2 -> RankListPage(maps = viewModel.firstUI, title = "First")
        }
    }
}

@Composable
private fun RankListPage(
    maps: MutableStateFlow<List<OsuTopRankUI>>,
    title: String
) {
    val data by maps.collectAsState()
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp

    Column(
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Beige400,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (data.isEmpty()) {
            Text(
                text = "No $title records",
                color = Beige400,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            LazyColumn {
                items(
                    count = data.size,
                    key = { index -> data[index].beatmapId }
                ) { index ->
                    OsuTopRankItemCard(
                        item = data[index],
                        itemWidth = screenWidthDp - 16.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun CommentPage() {
    // Implement your Comment page
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