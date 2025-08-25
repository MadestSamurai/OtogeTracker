package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.madsam.otora.BofScreenState
import com.madsam.otora.ui.bof.BofViewModel
import kotlinx.coroutines.flow.update

@Composable
internal fun BofEntryPagerScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    narrowMode: Int = 0,
    searchText: String = ""
) {
    val selectedSubTabIndex by bofScreenState.selectedSubTab.collectAsStateWithLifecycle()
    
    // 创建Pager状态，页面数量为5（Total, Avg, Median, Diff, Composite）
    val pagerState = rememberPagerState(pageCount = { 5 })
    
    // 同步Pager状态和selectedSubTabIndex
    LaunchedEffect(selectedSubTabIndex) {
        if (pagerState.currentPage != selectedSubTabIndex) {
            pagerState.animateScrollToPage(selectedSubTabIndex)
        }
    }
    
    LaunchedEffect(pagerState.currentPage) {
        if (selectedSubTabIndex != pagerState.currentPage) {
            bofScreenState.selectedSubTab.update { pagerState.currentPage }
        }
    }
    
    // 处理搜索逻辑
    LaunchedEffect(searchText, selectedSubTabIndex) {
        if (searchText.isNotEmpty()) {
            when (selectedSubTabIndex) {
                0 -> vm.findItemIndex(searchText, vm.totalData.value, 0)
                1 -> vm.findItemIndex(searchText, vm.avgData.value, 1)
                2 -> vm.findItemIndex(searchText, vm.medianData.value, 2)
                3 -> vm.findItemIndex(searchText, vm.diffData.value, 3)
                4 -> {
                    // Composite页面暂时跳过搜索，因为使用的是不同的数据格式
                    // TODO: 为排行数据格式实现专门的搜索方法
                }
            }
        }
    }
    
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        when (page) {
            0 -> BofTotalNewScreen(
                vm = vm,
                bofScreenState = bofScreenState,
                narrowMode = narrowMode
            )
            1 -> BofAvgNewScreen(
                vm = vm,
                bofScreenState = bofScreenState,
                narrowMode = narrowMode
            )
            2 -> BofMedianNewScreen(
                vm = vm,
                bofScreenState = bofScreenState,
                narrowMode = narrowMode
            )
            3 -> BofDiffNewScreen(
                vm = vm,
                bofScreenState = bofScreenState,
                narrowMode = narrowMode
            )
            4 -> BofCompositeNewScreen(
                vm = vm,
                bofScreenState = bofScreenState,
                narrowMode = narrowMode
            )
        }
    }
}
