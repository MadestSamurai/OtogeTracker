package com.madsam.otora.ui.bof

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.madsam.otora.ui.bof.sub.BofAvgScreen
import com.madsam.otora.ui.bof.sub.BofDiffScreen
import com.madsam.otora.ui.bof.sub.BofMedianScreen
import com.madsam.otora.ui.bof.sub.BofTeamScreen
import com.madsam.otora.ui.bof.sub.BofTotalScreen
import kotlinx.coroutines.launch

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/19
 * 描述: BOF数据展示界面
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BofScreen() {
    val tabs =
        listOf(Screen.Page1, Screen.Page2, Screen.Page3, Screen.Page4, Screen.Page5)
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            tabs.forEachIndexed { index, screen ->
                Tab(
                    text = { Text(text = screen.route) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false
        ) { page ->
            when (tabs[page]) {
                is Screen.Page1 -> BofTotalScreen()
                is Screen.Page2 -> BofAvgScreen()
                is Screen.Page3 -> BofMedianScreen()
                is Screen.Page4 -> BofDiffScreen()
                is Screen.Page5 -> BofTeamScreen()
            }
        }
    }
}

sealed class Screen(val route: String) {
    data object Page1 : Screen("Total")
    data object Page2 : Screen("Avg")
    data object Page3 : Screen("Median")
    data object Page4 : Screen("Diff")
    data object Page5 : Screen("Team")
}