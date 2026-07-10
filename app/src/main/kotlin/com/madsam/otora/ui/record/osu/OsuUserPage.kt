package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.madsam.otora.R
import com.madsam.otora.ui.record.osu.components.BadgeList
import com.madsam.otora.ui.record.osu.components.Card
import com.madsam.otora.ui.record.osu.components.Level
import com.madsam.otora.ui.record.osu.components.PlayData
import com.madsam.otora.ui.record.osu.components.RankGraph
import com.madsam.otora.ui.record.osu.components.Recent
import com.madsam.otora.ui.record.osu.components.SocialCard
import com.madsam.otora.ui.record.osu.components.TopRank
import com.madsam.otora.ui.record.osu.dialogs.RecentDialog
import com.madsam.otora.ui.record.osu.dialogs.TopRankDialog

@Composable
internal fun OsuUserPage(
    viewModel: OsuViewModel,
    isPageVisible: Boolean = true,
    includeBottomSystemBarPadding: Boolean = false,
    avoidStartDisplayCutout: Boolean = true,
    avoidEndDisplayCutout: Boolean = true
) {
    val colorScheme = MaterialTheme.colorScheme
    val context = LocalContext.current
    var showFullRecentDialog by remember { mutableStateOf(false) }
    var showTopRankDialog by remember { mutableStateOf("") }

    val layoutDirection = LocalLayoutDirection.current
    val displayCutoutPadding = WindowInsets.displayCutout.asPaddingValues()
    val lifecycleOwner = LocalLifecycleOwner.current
    // 监听Activity的生命周期，从其他Activity返回时重新加载数据
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME && isPageVisible) {
                viewModel.loadData(context)
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    // 页面首次显示或切换到此页面时加载数据
    LaunchedEffect(isPageVisible) {
        if (isPageVisible) {
            viewModel.loadData(context)
        }
    }
    
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val baseHorizontalPadding = 16.dp
        val startCutoutPadding = if (avoidStartDisplayCutout) {
            displayCutoutPadding.calculateStartPadding(layoutDirection)
        } else {
            0.dp
        }
        val endCutoutPadding = if (avoidEndDisplayCutout) {
            displayCutoutPadding.calculateEndPadding(layoutDirection)
        } else {
            0.dp
        }
        val startContentPadding = baseHorizontalPadding + startCutoutPadding
        val endContentPadding = baseHorizontalPadding + endCutoutPadding
        val contentWidthDp =
            (maxWidth - startContentPadding - endContentPadding).coerceAtLeast(0.dp)

        LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .padding(start = startContentPadding, end = endContentPadding)
            .nestedScroll(object : NestedScrollConnection {
                private var totalScroll = 0f

                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                    totalScroll += available.y
                    // 移除了TabRow的滚动控制逻辑，因为不再需要
                    return Offset.Zero
                }
            })
    ) {
        item(key = "card_data") { 
            Card(
                viewModel.cardUI,
                viewModel.groupListUI,
                contentWidthDp
            ) 
        }
        item(key = "badge_list") { 
            BadgeList(
                viewModel.badgeUI,
                contentWidthDp
            ) 
        }
        item(key = "rank_graph") {
            RankGraph(
                viewModel.rankGraphUI,
                viewModel.topRankUI,
                viewModel.cardUI,
                contentWidthDp
            )
            Level(
                osuLevelData = viewModel.levelUI,
                modifier = Modifier.width(contentWidthDp)
            )
        }
        item(key = "play_data") { 
            PlayData(
                osuPlayData = viewModel.playUI,
                modifier = Modifier.width(contentWidthDp)
            ) 
        }
        item(key = "social") { 
            SocialCard(
                viewModel.socialUI,
                contentWidthDp
            ) 
        }
        item(key = "recent") { 
            Recent(
                viewModel.recentBrief,
                contentWidthDp
            ) { showFullRecentDialog = true } 
        }
        item(key = "top_rank") {
            TopRank(
                viewModel.pinnedBrief,
                viewModel.bestBrief,
                viewModel.firstBrief,
                { showTopRankDialog = "pinned" },
                { showTopRankDialog = "best" },
                { showTopRankDialog = "first" },
                contentWidthDp
            )
        }
        
        // 底部安全区域，让用户滑动到底部时有额外的空间
        item(key = "bottom_spacer") {
            Spacer(
                modifier = Modifier
                    .windowInsetsPadding(
                        if (includeBottomSystemBarPadding) {
                            WindowInsets.navigationBars.only(WindowInsetsSides.Bottom)
                        } else {
                            WindowInsets(0, 0, 0, 0)
                        }
                    )
            )
        }
    }
    }

    if (showFullRecentDialog) {
        RecentDialog(
            recentActivityList = viewModel.recentUI,
            onDismiss = { showFullRecentDialog = false }
        )
    }
    when (showTopRankDialog) {
        "pinned" -> {
            TopRankDialog(
                title = stringResource(R.string.osu_section_pinned),
                topRankList = viewModel.pinnedUI,
                onDismiss = { showTopRankDialog = "" }
            )
        }

        "best" -> {
            TopRankDialog(
                title = stringResource(R.string.osu_section_best),
                topRankList = viewModel.bestUI,
                onDismiss = { showTopRankDialog = "" }
            )
        }

        "first" -> {
            TopRankDialog(
                title = stringResource(R.string.osu_section_first),
                topRankList = viewModel.firstUI,
                onDismiss = { showTopRankDialog = "" }
            )
        }
    }
}
