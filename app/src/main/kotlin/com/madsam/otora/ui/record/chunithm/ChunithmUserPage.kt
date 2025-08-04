package com.madsam.otora.ui.record.chunithm

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.ui.components.CustomScrollableTabRow
import com.madsam.otora.ui.record.ChunithmScreenState
import com.madsam.otora.ui.record.chunithm.dialogs.CookieDialog
import com.madsam.otora.ui.record.chunithm.dialogs.TopRankDialog
import com.madsam.otora.ui.record.chunithm.pages.ChunithmCollectionPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmFriendsPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmMainPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmSongListPage
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
internal fun ChunithmUserPage(
    viewModel: ChunithmViewModel,
    chuniScreenState: ChunithmScreenState,
    snackbarHostState: SnackbarHostState,
    showDialog: Boolean,
    onDismissDialog: () -> Unit,
    navController: NavController
) {
    val selectedTabIndex by chuniScreenState.selectedTab.collectAsState()
    val scrollThreshold = 50f

    var isTabRowVisible by remember { mutableStateOf(true) }
    var showTopRankDialog by remember { mutableStateOf(false) }
    val tabTitles = listOf("Home", "Song List", "Friends", "Collection")

    val pagerState = rememberPagerState { tabTitles.size }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()

    // 计算屏幕宽度和内容宽度（参考 ChunithmMainPage 的实现）
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
                    onNavigateToSongDetail = { songTitle ->
                        // 对歌曲标题进行URL编码以处理特殊字符
                        val encodedTitle = URLEncoder.encode(songTitle, StandardCharsets.UTF_8.toString())
                        navController.navigate("chunithm_song_detail/$encodedTitle")
                    }
                )

                2 -> ChunithmFriendsPage(
                    viewModel = viewModel,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = { isTabRowVisible = it },
                )

                3 -> ChunithmCollectionPage(
                    viewModel = viewModel,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = { isTabRowVisible = it },
                )
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp) // 40dp tab + 3dp padding + 3dp padding
                    .padding(start = 12.dp, end = 12.dp, bottom = 5.dp)
                    .windowInsetsPadding(
                        WindowInsets.displayCutout.only(
                            if (useNavigationRail) {
                                // 使用 NavigationRail 时，左侧已由 Rail 处理，只处理右侧
                                WindowInsetsSides.End
                            } else {
                                // 使用 BottomNavigation 时，处理左侧和右侧
                                WindowInsetsSides.Start + WindowInsetsSides.End
                            }
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // 左侧可滚动TabRow，基于计算的内容宽度设置最大宽度
                    androidx.compose.animation.AnimatedVisibility(
                        visible = isTabRowVisible,
                        enter = fadeIn(animationSpec = tween(300)),
                        exit = fadeOut(animationSpec = tween(300)),
                        modifier = Modifier
                            .wrapContentWidth() // 只占用实际需要的宽度
                            .widthIn(max = contentWidthDp - 48.dp) // 基于内容宽度减去按钮宽度和间隙
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        CustomScrollableTabRow(
                            selectedTabIndex = selectedTabIndex,
                            containerColor = Red500,
                            tabs = { selectedIndex ->
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
                        )
                    }

                    // 右侧圆形按钮，绝对定位在右边
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterEnd)
                            .clip(RoundedCornerShape(50))
                            .background(Red500)
                            .clickable {
                                when (selectedTabIndex) {
                                    0 -> {
                                        // 主页，刷新
                                        scope.launch {
                                            viewModel.loadData(context)
                                            snackbarHostState.showSnackbar("已刷新")
                                        }
                                    }
                                    1 -> {
                                        // 歌曲列表页，回到顶部
                                        scope.launch {
                                            viewModel.scrollSongListToTop()
                                            snackbarHostState.showSnackbar("已回到顶部")
                                        }
                                    }
                                    2 -> {
                                        // 好友页面，刷新好友数据
                                        scope.launch {
                                            viewModel.refreshUserData(context)
                                            snackbarHostState.showSnackbar("好友数据已刷新")
                                        }
                                    }
                                    3 -> {
                                        // 藏品页面，刷新藏品数据
                                        scope.launch {
                                            viewModel.loadData(context)
                                            snackbarHostState.showSnackbar("藏品数据已刷新")
                                        }
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
                                    image = when (tabIndex) {
                                        0 -> Filled.ArrowRotate  // Home: 刷新图标
                                        1 -> Filled.ArrowUp      // Song List: 向上箭头
                                        2 -> Filled.ArrowRotate  // Friends: 刷新图标
                                        3 -> Filled.ArrowRotate  // Collection: 刷新图标
                                        else -> Filled.ArrowRotate
                                    }
                                ),
                                contentDescription = when (tabIndex) {
                                    0 -> "Refresh"
                                    1 -> "Scroll to Top"
                                    2 -> "Refresh Friends"
                                    3 -> "Refresh Collection"
                                    else -> "Refresh"
                                },
                                tint = Beige500,
                                modifier = Modifier.size(16.dp)
                            )
                        }
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
