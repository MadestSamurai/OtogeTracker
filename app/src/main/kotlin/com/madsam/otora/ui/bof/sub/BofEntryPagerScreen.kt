package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.bof.components.BofEntryCaptureDialog
import com.madsam.otora.ui.common.ColumnWidthType
import com.madsam.otora.ui.common.RankingTable
import com.madsam.otora.ui.common.RankingTableConfig
import kotlinx.coroutines.flow.update

@Composable
internal fun BofEntryPagerScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    snackbarHostState: SnackbarHostState,
    narrowMode: Int = 0,
    searchText: String = "",
    scrollThreshold: Float = 50f,
    setIsTabRowVisible: (Boolean) -> Unit = {},
    showCaptureDialog: Boolean = false,
    onCaptureDialogDismiss: () -> Unit = {},
    listStateTotal: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    listStateAvg: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    listStateMedian: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    listStateDiff: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    listStateComposite: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState()
) {
    val selectedSubTabIndex by bofScreenState.selectedSubTab.collectAsStateWithLifecycle()
    val context = LocalContext.current

    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    
    // 创建Pager状态，页面数量为5（Total, Avg, Median, Diff, Composite）
    val pagerState = rememberPagerState(
        pageCount = { 5 },
        initialPage = selectedSubTabIndex
    )
    
    // 使用snapshotFlow更安全地处理状态同步
    LaunchedEffect(selectedSubTabIndex) {
        // 当Tab被点击时，滚动Pager到对应页面
        if (pagerState.currentPage != selectedSubTabIndex) {
            pagerState.animateScrollToPage(selectedSubTabIndex)
        }
    }
    
    LaunchedEffect(pagerState) {
        // 使用snapshotFlow监听Pager状态变化
        snapshotFlow { pagerState.currentPage }.collect { currentPage ->
            // 只在Pager滚动结束后更新Tab状态，避免Tab点击时的动画被中断
            if (selectedSubTabIndex != currentPage && !pagerState.isScrollInProgress) {
                bofScreenState.selectedSubTab.update { currentPage }
            }
        }
    }
    
    // 监听settled状态，确保手势滑动后Tab能及时更新
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.isScrollInProgress }.collect { isScrolling ->
            // 滚动结束时，确保Tab状态与Pager同步
            if (!isScrolling && pagerState.currentPage != selectedSubTabIndex) {
                bofScreenState.selectedSubTab.update { pagerState.currentPage }
            }
        }
    }
    
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
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
            )
            .nestedScroll(object : NestedScrollConnection {
                private var totalScroll = 0f

                override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                    // 只在垂直滑动时处理TabRow显示/隐藏
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
    ) { page ->
        // 只有当前页面才响应截图对话框
        val shouldShowCaptureDialog = showCaptureDialog && page == pagerState.currentPage
        
        when (page) {
            0 -> EntryPageContent(
                title = "总分排行榜",
                subtitle = "BOF 总分排行榜",
                scoreColumnName = "分数条",
                extraColumnName = "评价",
                avgColumnName = "均分",
                medianColumnName = "中位",
                scoreWidthType = ColumnWidthType.THREE_DIGIT_INT,
                extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                avgWidthType = ColumnWidthType.TWO_DECIMAL,
                medianWidthType = ColumnWidthType.ONE_DECIMAL,
                enableNarrowToggle = true,
                maxItems = 600,
                ranking = vm.totalRankingData.collectAsStateWithLifecycle().value,
                isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                narrowMode = narrowMode,
                vm = vm,
                context = context,
                snackbarHostState = snackbarHostState,
                dataConverter = { it.toRankingItem() },
                showCaptureDialog = shouldShowCaptureDialog,
                onCaptureDialogDismiss = onCaptureDialogDismiss,
                listState = listStateTotal,
                searchText = searchText
            )
            
            1 -> {
                // Avg页面需要处理最低评价数过滤
                LaunchedEffect(Unit) {
                    vm.updateAverageMinImpression(1)
                }
                
                EntryPageContent(
                    title = "平均分排行榜",
                    subtitle = "BOF 平均分排行榜",
                    scoreColumnName = "均分",
                    extraColumnName = "评价",
                    avgColumnName = null,
                    medianColumnName = null,
                    scoreWidthType = ColumnWidthType.TWO_DECIMAL,
                    extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                    avgWidthType = ColumnWidthType.TWO_DECIMAL,
                    medianWidthType = ColumnWidthType.ONE_DECIMAL,
                    enableNarrowToggle = false,
                    maxItems = 600,
                    ranking = vm.avgRankingData.collectAsStateWithLifecycle().value,
                    isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                    errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                    narrowMode = narrowMode,
                    vm = vm,
                    context = context,
                    snackbarHostState = snackbarHostState,
                    dataConverter = { it.toAverageRankingItem() },
                    showCaptureDialog = shouldShowCaptureDialog,
                    onCaptureDialogDismiss = onCaptureDialogDismiss,
                    listState = listStateAvg,
                    searchText = searchText
                )
            }
            
            2 -> {
                // Median页面需要处理最低评价数过滤
                LaunchedEffect(Unit) {
                    vm.updateMedianMinImpression(1)
                }
                
                EntryPageContent(
                    title = "中位数排行榜",
                    subtitle = "BOF 中位数排行榜",
                    scoreColumnName = "中位",
                    extraColumnName = "评价",
                    avgColumnName = null,
                    medianColumnName = null,
                    scoreWidthType = ColumnWidthType.ONE_DECIMAL,
                    extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                    avgWidthType = ColumnWidthType.TWO_DECIMAL,
                    medianWidthType = ColumnWidthType.ONE_DECIMAL,
                    enableNarrowToggle = false,
                    maxItems = 600,
                    ranking = vm.medianRankingData.collectAsStateWithLifecycle().value,
                    isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                    errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                    narrowMode = narrowMode,
                    vm = vm,
                    context = context,
                    snackbarHostState = snackbarHostState,
                    dataConverter = { it.toMedianRankingItem() },
                    showCaptureDialog = shouldShowCaptureDialog,
                    onCaptureDialogDismiss = onCaptureDialogDismiss,
                    listState = listStateMedian,
                    searchText = searchText
                )
            }
            
            3 -> {
                // Diff页面需要确保数据已加载
                LaunchedEffect(Unit) {
                    vm.generateDifferenceRanking()
                }
                
                EntryPageContent(
                    title = "差值排行榜",
                    subtitle = "BOF 差值排行榜",
                    scoreColumnName = "差值",
                    extraColumnName = "评价",
                    avgColumnName = null,
                    medianColumnName = null,
                    scoreWidthType = ColumnWidthType.TWO_DECIMAL,
                    extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                    avgWidthType = ColumnWidthType.TWO_DECIMAL,
                    medianWidthType = ColumnWidthType.ONE_DECIMAL,
                    enableNarrowToggle = false,
                    maxItems = 600,
                    ranking = vm.diffRankingData.collectAsStateWithLifecycle().value,
                    isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                    errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                    narrowMode = narrowMode,
                    vm = vm,
                    context = context,
                    snackbarHostState = snackbarHostState,
                    dataConverter = { it.toDifferenceRankingItem() },
                    showCaptureDialog = shouldShowCaptureDialog,
                    onCaptureDialogDismiss = onCaptureDialogDismiss,
                    listState = listStateDiff,
                    searchText = searchText
                )
            }
            
            4 -> {
                // Composite页面需要处理最低评价数过滤
                val minImpression by vm.compositeMinImpression.collectAsStateWithLifecycle()
                LaunchedEffect(Unit) {
                    vm.updateCompositeMinImpression(1)
                    vm.generateCompositeRanking()
                }
                
                EntryPageContent(
                    title = "综合分数排行榜",
                    subtitle = "BOF 综合分数排行榜 (评价≥${minImpression})",
                    scoreColumnName = "综合",
                    extraColumnName = "评价",
                    avgColumnName = null,
                    medianColumnName = null,
                    scoreWidthType = ColumnWidthType.TWO_DECIMAL,
                    extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                    avgWidthType = ColumnWidthType.TWO_DECIMAL,
                    medianWidthType = ColumnWidthType.ONE_DECIMAL,
                    enableNarrowToggle = false,
                    maxItems = 600,
                    ranking = vm.compositeRankingData.collectAsStateWithLifecycle().value,
                    isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                    errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                    narrowMode = narrowMode,
                    vm = vm,
                    context = context,
                    snackbarHostState = snackbarHostState,
                    dataConverter = { it.toCompositeRankingItem() },
                    showCaptureDialog = shouldShowCaptureDialog,
                    onCaptureDialogDismiss = onCaptureDialogDismiss,
                    listState = listStateComposite,
                    searchText = searchText
                )
            }
        }
    }
}

@Composable
private fun <T> EntryPageContent(
    title: String,
    subtitle: String,
    scoreColumnName: String,
    extraColumnName: String,
    avgColumnName: String?,
    medianColumnName: String?,
    scoreWidthType: ColumnWidthType,
    extraWidthType: ColumnWidthType,
    avgWidthType: ColumnWidthType,
    medianWidthType: ColumnWidthType,
    enableNarrowToggle: Boolean,
    maxItems: Int,
    ranking: List<T>,
    isLoading: Boolean,
    errorMessage: String,
    narrowMode: Int,
    vm: BofViewModel,
    context: android.content.Context,
    snackbarHostState: SnackbarHostState,
    dataConverter: (T) -> com.madsam.otora.ui.common.RankingItem,
    showCaptureDialog: Boolean = false,
    onCaptureDialogDismiss: () -> Unit = {},
    listState: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    searchText: String = ""
) {
    val showDialogState = remember { mutableStateOf(false) }
    
    // 只有当 showCaptureDialog 从 false 变为 true 时才打开对话框
    LaunchedEffect(showCaptureDialog) {
        if (showCaptureDialog && !showDialogState.value) {
            showDialogState.value = true
        }
    }
    
    // 监听对话框关闭，通知父组件
    LaunchedEffect(showDialogState.value) {
        if (!showDialogState.value && showCaptureDialog) {
            onCaptureDialogDismiss()
        }
    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            errorMessage.isNotEmpty() -> {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "加载失败",
                        fontFamily = sarasaBold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.error
                    )
                    Text(
                        text = errorMessage,
                        fontFamily = sarasaRegular,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Button(
                        onClick = { vm.loadRankingData() },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("重试")
                    }
                }
            }
            
            ranking.isEmpty() -> {
                Text(
                    text = "暂无数据\n请选择时间范围或调整过滤条件",
                    fontFamily = sarasaRegular,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            else -> {
                val rankingItems = ranking.map(dataConverter)
                val tableConfig = RankingTableConfig(
                    title = title,
                    subtitle = "$subtitle (${ranking.size} 作品) | ${vm.getSelectedTimeString()}",
                    scoreColumnName = scoreColumnName,
                    extraColumnName = extraColumnName,
                    avgColumnName = avgColumnName,
                    medianColumnName = medianColumnName,
                    scoreWidthType = scoreWidthType,
                    extraWidthType = extraWidthType,
                    avgWidthType = avgWidthType,
                    medianWidthType = medianWidthType,
                    enableNarrowToggle = enableNarrowToggle,
                    maxItems = maxItems
                )
                
                RankingTable(
                    items = rankingItems,
                    config = tableConfig,
                    narrowMode = narrowMode,
                    listState = listState,
                    searchText = searchText
                )
                
                // 截图对话框
                BofEntryCaptureDialog(
                    showDialog = showDialogState,
                    context = context,
                    snackbarHostState = snackbarHostState,
                    items = rankingItems,
                    config = tableConfig
                )
            }
        }
    }
}
