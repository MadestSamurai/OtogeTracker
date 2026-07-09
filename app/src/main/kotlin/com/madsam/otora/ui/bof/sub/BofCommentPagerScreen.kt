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
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.madsam.otora.BofScreenState
import com.madsam.otora.R
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.ui.bof.BofViewModel
import kotlinx.coroutines.flow.update

@Composable
internal fun BofCommentPagerScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    title: String,
    subtitle: String,
    commentDisplayMode: Int = 0,
    scrollThreshold: Float = 50f,
    setIsTabRowVisible: (Boolean) -> Unit = {},
    showCaptureDialog: Boolean = false,
    onCaptureDialogDismiss: () -> Unit = {},
    listStateTotal: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    listStateDiff: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    providedPagerState: PagerState? = null
) {
    val selectedCommentSubTabIndex by bofScreenState.selectedCommentSubTab.collectAsStateWithLifecycle()
    val diffIncreaseTitle = stringResource(R.string.bof_comment_diff_increase_title)
    val diffDecreaseTitle = stringResource(R.string.bof_comment_diff_decrease_title)
    
    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    
    // 创建Pager状态，页面数量为2（Total, Diff）
    val internalPagerState = rememberPagerState(
        pageCount = { 2 },
        initialPage = selectedCommentSubTabIndex
    )
    val pagerState = providedPagerState ?: internalPagerState
    
    // 使用snapshotFlow更安全地处理状态同步
    LaunchedEffect(selectedCommentSubTabIndex) {
        if (pagerState.currentPage != selectedCommentSubTabIndex) {
            pagerState.animateScrollToPage(selectedCommentSubTabIndex)
        }
    }
    
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { currentPage ->
            if (selectedCommentSubTabIndex != currentPage && !pagerState.isScrollInProgress) {
                bofScreenState.selectedCommentSubTab.update { currentPage }
            }
        }
    }
    
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.isScrollInProgress }.collect { isScrolling ->
            if (!isScrolling && pagerState.currentPage != selectedCommentSubTabIndex) {
                bofScreenState.selectedCommentSubTab.update { pagerState.currentPage }
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
        
        when (page) {
            0 -> {
                // 总榜页面 - 在分支内收集数据
                val commentData by vm.commentData.collectAsStateWithLifecycle()
                
                BofCommentScreen(
                    commentData = commentData,
                    title = title,
                    subtitle = subtitle,
                    commentDisplayMode = commentDisplayMode,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = setIsTabRowVisible,
                    showCaptureDialog = shouldShowCaptureDialog,
                    onCaptureDialogDismiss = onCaptureDialogDismiss
                )
            }
            
            1 -> {
                // Diff页面 - 在分支内收集数据和状态（完全对齐 Entry 的实现）
                LaunchedEffect(Unit) {
                    vm.generateCommentDifferenceRanking()
                }
                
                val showCommentReverseDiff by bofScreenState.showCommentReverseDiff.collectAsStateWithLifecycle()
                val commentDiffData by vm.commentDiffData.collectAsStateWithLifecycle()
                val commentReverseDiffData by vm.commentReverseDiffData.collectAsStateWithLifecycle()
                
                // 根据状态选择数据
                val currentCommentData = if (showCommentReverseDiff) commentReverseDiffData else commentDiffData
                
                // 修改标题显示差值信息（与 Entry 保持一致的文案）
                val diffTitle = if (showCommentReverseDiff) diffDecreaseTitle else diffIncreaseTitle
                
                BofCommentDiffScreen(
                    commentData = currentCommentData,
                    title = diffTitle,
                    subtitle = subtitle,
                    isReverse = showCommentReverseDiff,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = setIsTabRowVisible,
                    showCaptureDialog = shouldShowCaptureDialog,
                    onCaptureDialogDismiss = onCaptureDialogDismiss
                )
            }
        }
    }
}
