package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.common.ColumnWidthType
import com.madsam.otora.ui.common.RankingTable
import com.madsam.otora.ui.common.RankingTableConfig
import kotlinx.coroutines.flow.update

@Composable
internal fun BofEntryPagerScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    narrowMode: Int = 0,
    searchText: String = "",
    scrollThreshold: Float = 50f,
    setIsTabRowVisible: (Boolean) -> Unit = {}
) {
    val selectedSubTabIndex by bofScreenState.selectedSubTab.collectAsStateWithLifecycle()
    
    // 创建Pager状态，页面数量为5（Total, Avg, Median, Diff, Composite）
    val pagerState = rememberPagerState(
        pageCount = { 5 },
        initialPage = selectedSubTabIndex
    )
    
    // 使用snapshotFlow更安全地处理状态同步
    LaunchedEffect(selectedSubTabIndex) {
        // 只有当Tab状态与Pager状态不同步时才滚动
        if (pagerState.currentPage != selectedSubTabIndex && !pagerState.isScrollInProgress) {
            pagerState.animateScrollToPage(selectedSubTabIndex)
        }
    }
    
    LaunchedEffect(pagerState) {
        // 使用snapshotFlow监听Pager状态变化，避免在动画过程中频繁更新
        snapshotFlow { pagerState.currentPage }
            .collect { currentPage ->
                if (selectedSubTabIndex != currentPage && !pagerState.isScrollInProgress) {
                    bofScreenState.selectedSubTab.update { currentPage }
                }
            }
    }
    
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
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
                maxItems = 500,
                ranking = vm.totalRankingData.collectAsStateWithLifecycle().value,
                isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                narrowMode = narrowMode,
                vm = vm,
                dataConverter = { it.toRankingItem() }
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
                    maxItems = 500,
                    ranking = vm.avgRankingData.collectAsStateWithLifecycle().value,
                    isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                    errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                    narrowMode = narrowMode,
                    vm = vm,
                    dataConverter = { it.toAverageRankingItem() }
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
                    maxItems = 500,
                    ranking = vm.medianRankingData.collectAsStateWithLifecycle().value,
                    isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                    errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                    narrowMode = narrowMode,
                    vm = vm,
                    dataConverter = { it.toMedianRankingItem() }
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
                    maxItems = 500,
                    ranking = vm.diffRankingData.collectAsStateWithLifecycle().value,
                    isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                    errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                    narrowMode = narrowMode,
                    vm = vm,
                    dataConverter = { it.toDifferenceRankingItem() }
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
                    maxItems = 500,
                    ranking = vm.compositeRankingData.collectAsStateWithLifecycle().value,
                    isLoading = vm.isLoading.collectAsStateWithLifecycle().value,
                    errorMessage = vm.errorMessage.collectAsStateWithLifecycle().value,
                    narrowMode = narrowMode,
                    vm = vm,
                    dataConverter = { it.toCompositeRankingItem() }
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
    dataConverter: (T) -> com.madsam.otora.ui.common.RankingItem
) {
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
                        onClick = { vm.loadRankingDataWithStreamedParsing() },
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
                RankingTable(
                    items = ranking.map(dataConverter),
                    config = RankingTableConfig(
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
                    ),
                    narrowMode = narrowMode
                )
            }
        }
    }
}
