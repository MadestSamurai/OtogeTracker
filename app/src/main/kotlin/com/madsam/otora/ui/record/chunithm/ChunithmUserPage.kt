package com.madsam.otora.ui.record.chunithm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Transparent
import com.madsam.otora.ui.components.CustomTabRow
import com.madsam.otora.ui.record.ChunithmScreenState
import com.madsam.otora.ui.record.chunithm.dialogs.CookieDialog
import com.madsam.otora.ui.record.chunithm.dialogs.TopRankDialog
import com.madsam.otora.ui.record.chunithm.pages.ChunithmMainPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmSongListPage
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Composable
internal fun ChunithmUserPage(
    viewModel: ChunithmViewModel,
    chuniScreenState: ChunithmScreenState,
    snackbarHostState: SnackbarHostState,
    showDialog: Boolean,
    onDismissDialog: () -> Unit
) {
    val selectedTabIndex by chuniScreenState.selectedTab.collectAsState()
    val scrollThreshold = 50f

    var isTabRowVisible by remember { mutableStateOf(true) }
    var showTopRankDialog by remember { mutableStateOf(false) }
    val tabTitles = listOf("Home", "Song List")

    val pagerState = rememberPagerState { tabTitles.size }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    if (showDialog) {
        CookieDialog(
            context = context,
            snackbarHostState = snackbarHostState,
            onResult = { success ->
                if (success) {
                    scope.launch {
                        viewModel.fetchUserData(context)
                        viewModel.loadData(context)
                        snackbarHostState.showSnackbar("Cookies Saved")
                    }
                }
                onDismissDialog()
            },
            onDismiss = onDismissDialog
        )
    }

    LaunchedEffect(pagerState.currentPage) {
        if (selectedTabIndex != pagerState.currentPage) {
            chuniScreenState.selectedTab.update { pagerState.currentPage }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageSpacing = 0.dp,
        ) { page ->
            when (page) {
                0 -> ChunithmMainPage(
                    viewModel = viewModel,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = { isTabRowVisible = it },
                    onNavigateToTopRating = { showTopRankDialog = true }
                )

                1 -> ChunithmSongListPage(
                    viewModel = viewModel,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = { isTabRowVisible = it },
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp) // 40dp tab + 3dp padding + 3dp padding
                    .padding(start = 12.dp, end = 12.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .background(Transparent)
                        .weight(1f)
                        .wrapContentWidth(Alignment.Start),
                ) {
                    AnimatedVisibility(
                        visible = isTabRowVisible,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        // 左侧TabRow占满剩余空间
                        CustomTabRow(
                            selectedTabIndex = selectedTabIndex,
                            containerColor = Red500
                        ) {
                            tabTitles.forEachIndexed { index, title ->
                                Tab(
                                    selected = selectedTabIndex == index,
                                    onClick = {
                                        if (selectedTabIndex != index) {
                                            chuniScreenState.selectedTab.update { index }
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

                // 右侧圆形按钮紧贴右边
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(50))
                        .background(Red500)
                        .clickable {
                            if (selectedTabIndex == 0) {
                                // 主页，刷新
                                scope.launch {
                                    viewModel.loadData(context)
                                    snackbarHostState.showSnackbar("已刷新")
                                }
                            } else if (selectedTabIndex == 1) {
                                // 歌曲列表页，回到顶部
                                scope.launch {
                                    viewModel.scrollSongListToTop()
                                    snackbarHostState.showSnackbar("已回到顶部")
                                }
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Crossfade(
                        targetState = selectedTabIndex,
                        animationSpec = tween(durationMillis = 300),
                        label = "icon_crossfade"
                    ) { tabIndex ->
                        Icon(
                            painter = rememberVectorPainter(
                                image = if (tabIndex == 0) Filled.ArrowRotate else Filled.ArrowUp
                            ),
                            contentDescription = if (tabIndex == 0) "Refresh" else "Scroll to Top",
                            tint = Beige500,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }

    // TopRank Dialog
    if (showTopRankDialog) {
        TopRankDialog(
            chunithmTopRankUiModel = viewModel.chunithmTopRankUiModel,
            snackbarHostState = snackbarHostState,
            onDismiss = { showTopRankDialog = false }
        )
    }
}
