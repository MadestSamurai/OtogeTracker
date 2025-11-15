package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.AvatarLayout
import com.madsam.otora.ui.record.chunithm.components.Card
import com.madsam.otora.ui.record.chunithm.components.ChunithmFriendList
import com.madsam.otora.ui.record.chunithm.components.LoginBonusTracker
import com.madsam.otora.ui.record.chunithm.components.MapCard
import com.madsam.otora.ui.record.chunithm.components.PlayDataList
import com.madsam.otora.ui.record.chunithm.components.TopRank

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ChunithmMainPage(
    viewModel: ChunithmViewModel,
    scrollThreshold: Float,
    setIsTabRowVisible: (Boolean) -> Unit,
    onNavigateToTopRating: () -> Unit,
    onShowSongList: () -> Unit = {},
) {
    val context = LocalContext.current
    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    
    // 计算屏幕宽度和内容宽度
    val density = LocalDensity.current
    val layoutDirection = LocalLayoutDirection.current
    val windowInfo = LocalWindowInfo.current
    val screenWidthDp = with(density) {
        windowInfo.containerSize.width.toDp()
    }
    
    // 计算 Cutout 占用的宽度
    val cutoutWidthDp = with(density) {
        val cutoutInsets = WindowInsets.displayCutout
        // 计算左右两侧的 cutout 总宽度
        cutoutInsets.getLeft(density, layoutDirection).toDp() +
        cutoutInsets.getRight(density, layoutDirection).toDp()
    }
    
    // 计算可用内容宽度
    val contentWidthDp = if (useNavigationRail) {
        // NavigationRail 宽度 + 水平 padding + cutout 宽度
        screenWidthDp - 80.dp - 24.dp - cutoutWidthDp
    } else {
        // 只减去水平 padding + cutout 宽度
        screenWidthDp - 24.dp - cutoutWidthDp
    }

    val isRefreshing by viewModel.isRefreshing.collectAsState()
    val state = rememberPullToRefreshState()

    // 监听生命周期，在页面可见时重新加载数据
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                // 页面恢复可见时重新加载数据
                viewModel.loadData(context)
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = { viewModel.refreshUserData(context) },
        modifier = Modifier.fillMaxSize(),
        state = state,
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing,
                containerColor = Red300,
                color = Beige500,
                state = state
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .background(color = Red300)
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .windowInsetsPadding(WindowInsets.navigationBars.only(WindowInsetsSides.Bottom))
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
            item {
                Card(
                    viewModel.chunithmCardUiModel,
                    contentWidthDp
                )
            }
            item {
                val loginBonus by viewModel.chunithmLoginBonus.collectAsState()
                LoginBonusTracker(loginBonus = loginBonus)
            }
            item {
                Box(
                    modifier = Modifier.clickable {
                        onNavigateToTopRating()
                    }
                ) {
                    TopRank(
                        viewModel.chunithmTopRankUiModel,
                        contentWidthDp
                    )
                }
            }
            item {
                ChunithmFriendList(
                    chuniFriendListUI = viewModel.chuniFriendDataUI,
                    cardWidth = contentWidthDp,
                    showOnlyScored = true
                )
            }
            item {
                PlayDataList(
                    width = contentWidthDp,
                    difficultyStats = viewModel.difficultyStats,
                    genreStats = viewModel.genreStats,
                    versionStats = viewModel.versionStats,
                    levelStats = viewModel.levelStats,
                    onNavigateToSongList = { onShowSongList() }
                )
            }
            item {
                AvatarLayout(
                    chunithmAvatarUiModel = viewModel.chunithmAvatarUiModel,
                    viewModel = viewModel,
                    onCategoryClick = { category ->
                        // 导航到装饰列表页面并预选该分类
                        viewModel.selectAvatarCategory(category)
                        // TODO: 添加导航逻辑到 ChunithmAvatarListPage
                    }
                )
            }
            item {
                MapCard(
                    mapDataFlow = viewModel.chunithmMapDataUI,
                    width = contentWidthDp
                )
            }
            
            // 底部安全区域，让用户滑动到底部时有额外的空间
            item(key = "bottom_spacer") {
                androidx.compose.foundation.layout.Spacer(
                    modifier = Modifier
                        .windowInsetsPadding(
                            if (useNavigationRail) {
                                WindowInsets.navigationBars.only(WindowInsetsSides.Bottom)
                            } else {
                                WindowInsets(0, 0, 0, 0)
                            }
                        )
                )
            }
        }
    }
}