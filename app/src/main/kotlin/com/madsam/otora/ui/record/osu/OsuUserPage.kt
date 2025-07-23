package com.madsam.otora.ui.record.osu

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.ui.components.CustomTabRow
import com.madsam.otora.ui.record.OsuScreenState
import com.madsam.otora.ui.record.osu.dialogs.SettingsDialog
import com.madsam.otora.ui.record.osu.pages.Comment
import com.madsam.otora.ui.record.osu.pages.Main
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Composable
internal fun OsuUserPage(
    showOsuDialog: Boolean,
    viewModel: OsuViewModel,
    osuScreenState: OsuScreenState,
    onDismissDialog: () -> Unit
) {
    val selectedTabIndex by osuScreenState.selectedTab.collectAsState()
    val scrollThreshold = 50f

    var isTabRowVisible by remember { mutableStateOf(true) }
    val tabTitles = listOf("Home", "Comment")

    val pagerState = rememberPagerState { tabTitles.size }

    // 使用和 MainActivity 相同的判断标准来确定是否使用 NavigationRail
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    val screenWidth = with(density) { windowInfo.containerSize.width.toDp() }
    val screenHeight = with(density) { windowInfo.containerSize.height.toDp() }
    val useNavigationRail = screenWidth > screenHeight || screenWidth > 600.dp

    SettingsDialog(
        showDialog = showOsuDialog,
        onDismiss = onDismissDialog,
        viewModel = viewModel
    )

    LaunchedEffect(pagerState.currentPage) {
        if (selectedTabIndex != pagerState.currentPage) {
            osuScreenState.selectedTab.update { pagerState.currentPage }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            pageSpacing = 0.dp,
        ) { page ->
            when (page) {
                0 -> Main (
                    viewModel = viewModel,
                    scrollThreshold = scrollThreshold,
                ) { isTabRowVisible = it }
                1 -> Comment()
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .windowInsetsPadding(
                    if (useNavigationRail) {
                        // 使用 NavigationRail 时，需处理底部导航栏
                        WindowInsets.navigationBars.only(WindowInsetsSides.Bottom)
                    } else {
                        // 不需要额外处理时，返回空 Insets
                        WindowInsets(0, 0, 0, 0)
                    }
                )
        ) {
            val scope = rememberCoroutineScope()
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
                    tabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = {
                                if (selectedTabIndex != index) {
                                    osuScreenState.selectedTab.update { index }
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