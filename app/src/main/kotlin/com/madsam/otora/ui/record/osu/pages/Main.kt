package com.madsam.otora.ui.record.osu.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.utils.ScreenUtil.isLandscape
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
    val configuration = LocalConfiguration.current
    val view = LocalView.current
    val leftPadding by viewModel.leftPadding.collectAsState()
    val rightPadding by viewModel.rightPadding.collectAsState()

    var showFullRecentDialog by remember { mutableStateOf(false) }
    var showTopRankDialog by remember { mutableStateOf("") }

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