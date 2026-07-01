package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.ui.bof.BofViewModel
import kotlinx.coroutines.flow.update

@Composable
internal fun BofTeamPagerScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    snackbarHostState: SnackbarHostState,
    teamInfoMode: Int = 0,
    scrollThreshold: Float = 50f,
    setIsTabRowVisible: (Boolean) -> Unit = {},
    showCaptureDialog: Boolean = false,
    onCaptureDialogDismiss: () -> Unit = {},
    listStateTotal: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    listStateDiff: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    providedPagerState: PagerState? = null
) {
    val selectedTeamSubTabIndex by bofScreenState.selectedTeamSubTab.collectAsStateWithLifecycle()
    
    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    
    // 创建Pager状态，页面数量为2（Total, Diff）
    val internalPagerState = rememberPagerState(
        pageCount = { 2 },
        initialPage = selectedTeamSubTabIndex
    )
    val pagerState = providedPagerState ?: internalPagerState
    
    // 使用snapshotFlow更安全地处理状态同步
    LaunchedEffect(selectedTeamSubTabIndex) {
        if (pagerState.currentPage != selectedTeamSubTabIndex) {
            pagerState.animateScrollToPage(selectedTeamSubTabIndex)
        }
    }
    
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { currentPage ->
            if (selectedTeamSubTabIndex != currentPage && !pagerState.isScrollInProgress) {
                bofScreenState.selectedTeamSubTab.update { currentPage }
            }
        }
    }
    
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.isScrollInProgress }.collect { isScrolling ->
            if (!isScrolling && pagerState.currentPage != selectedTeamSubTabIndex) {
                bofScreenState.selectedTeamSubTab.update { pagerState.currentPage }
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
                        WindowInsetsSides.End
                    } else {
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
        val shouldShowCaptureDialog = showCaptureDialog && page == pagerState.currentPage
        
        // 页面标题列表（参考 Entry 的设计）
        val pageNames = listOf("总榜", "差值")
        val previousPageTitle = if (page > 0) pageNames[page - 1] else null
        val nextPageTitle = if (page < pageNames.size - 1) pageNames[page + 1] else null
        
        when (page) {
            0 -> {
                // 总榜页面 - 在 when 分支内收集状态（完全对齐 Entry）
                val teamRankingData by vm.teamRankingData.collectAsStateWithLifecycle()
                val isLoading by vm.isTeamRankingLoading.collectAsStateWithLifecycle()
                val errorMessage by vm.teamRankingError.collectAsStateWithLifecycle()
                val selectedRange by bofScreenState.selectedRange.collectAsStateWithLifecycle()
                
                BofTeamTotalScreen(
                    teamRankingData = teamRankingData,
                    isLoading = isLoading,
                    errorMessage = errorMessage,
                    selectedRange = selectedRange,
                    bofScreenState = bofScreenState,
                    vm = vm,
                    snackbarHostState = snackbarHostState,
                    teamInfoMode = teamInfoMode,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = setIsTabRowVisible,
                    showCaptureDialog = shouldShowCaptureDialog,
                    onCaptureDialogDismiss = onCaptureDialogDismiss,
                    listState = listStateTotal
                )
            }
            
            1 -> {
                // Diff页面 - 在 when 分支内收集状态并选择数据（完全对齐 Entry）
                LaunchedEffect(Unit) {
                    vm.generateTeamDifferenceRanking()
                }
                
                // 收集所有状态
                val showTeamReverseDiff by bofScreenState.showTeamReverseDiff.collectAsStateWithLifecycle()
                val teamDiffRanking by vm.teamDiffRankingData.collectAsStateWithLifecycle()
                val teamReverseDiffRanking by vm.teamReverseDiffRankingData.collectAsStateWithLifecycle()
                val isLoading by vm.isTeamRankingLoading.collectAsStateWithLifecycle()
                
                // 选择数据 - 这是一个稳定的值，不是状态流
                val currentRanking = if (showTeamReverseDiff) teamReverseDiffRanking else teamDiffRanking
                
                // 传递稳定值给组件
                BofTeamDiffScreen(
                    teamRankingData = currentRanking,
                    isLoading = isLoading,
                    isReverse = showTeamReverseDiff,
                    vm = vm,
                    snackbarHostState = snackbarHostState,
                    teamInfoMode = teamInfoMode,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = setIsTabRowVisible,
                    showCaptureDialog = shouldShowCaptureDialog,
                    onCaptureDialogDismiss = onCaptureDialogDismiss,
                    listState = listStateDiff
                )
            }
        }
    }
}
