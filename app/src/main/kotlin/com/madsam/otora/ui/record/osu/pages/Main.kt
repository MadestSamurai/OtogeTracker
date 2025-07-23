package com.madsam.otora.ui.record.osu.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.ui.record.osu.OsuViewModel
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
internal fun Main(
    viewModel: OsuViewModel,
    scrollThreshold: Float,
    setIsTabRowVisible: (Boolean) -> Unit
) {
    var showFullRecentDialog by remember { mutableStateOf(false) }
    var showTopRankDialog by remember { mutableStateOf("") }
    
    // 使用和 MainActivity 相同的判断标准来确定是否使用 NavigationRail
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    val screenWidth = with(density) { windowInfo.containerSize.width.toDp() }
    val screenHeight = with(density) { windowInfo.containerSize.height.toDp() }
    val useNavigationRail = screenWidth > screenHeight || screenWidth > 600.dp
    
    LazyColumn(
        modifier = Modifier
            .background(Red300)
            .padding(horizontal = 12.dp)
            .windowInsetsPadding(
                WindowInsets.displayCutout.only(
                    if (useNavigationRail) {
                        // 使用 NavigationRail 时，左侧已由 Rail 处理，只处理右侧
                        WindowInsetsSides.End
                    } else {
                        // 使用 BottomNavigation 时，底部已由 BottomBar 处理，只处理左侧和右侧
                        WindowInsetsSides.Start + WindowInsetsSides.End
                    }
                )
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
            Recent(viewModel.recentBrief) { showFullRecentDialog = true }
        }
        item(key = "top_rank") {
            TopRank(
                viewModel.pinnedBrief,
                viewModel.bestBrief,
                viewModel.firstBrief,
                { showTopRankDialog = "pinned" },
                { showTopRankDialog = "best" },
                { showTopRankDialog = "first" }
            )
        }
        
        // 底部安全区域，让用户滑动到底部时有额外的空间
        item(key = "bottom_spacer") {
            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier
                    .windowInsetsPadding(
                        if (useNavigationRail) {
                            // 使用 NavigationRail 时，需处理底部导航栏
                            WindowInsets.navigationBars.only(WindowInsetsSides.Bottom)
                        } else {
                            // 不需要额外处理时，返回空 Insets
                            WindowInsets(0, 0, 0, 0)
                        }
                    )
            )
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
                title = "Pinned",
                topRankList = viewModel.pinnedUI,
                onDismiss = { showTopRankDialog = "" }
            )
            println("pinned dialog")
        }

        "best" -> {
            TopRankDialog(
                title = "Best",
                topRankList = viewModel.bestUI,
                onDismiss = { showTopRankDialog = "" }
            )
        }

        "first" -> {
            TopRankDialog(
                title = "First",
                topRankList = viewModel.firstUI,
                onDismiss = { showTopRankDialog = "" }
            )
        }
    }
}