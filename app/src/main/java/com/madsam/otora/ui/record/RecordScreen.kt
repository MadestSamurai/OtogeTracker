package com.madsam.otora.ui.record

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.madsam.otora.ui.record.sub.OsuUserPage
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecordScreen() {
    val tabs =
        listOf(Screen.Page1, Screen.Page2, Screen.Page3, Screen.Page4)
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

        HorizontalPager(state = pagerState) { page ->
            when (tabs[page]) {
                is Screen.Page1 -> OsuUserPage()
                is Screen.Page2 -> TestPage2()
                is Screen.Page3 -> TestPage3()
                is Screen.Page4 -> TestPage4()
            }
        }
    }
}

@Composable
fun TestPage2() {
    Text(text = "TestPage2")
}

@Composable
fun TestPage3() {
    Text(text = "TestPage3")
}

@Composable
fun TestPage4() {
    Text(text = "TestPage4")
}

sealed class Screen(val route: String) {
    data object Page1 : Screen("Osu Page")
    data object Page2 : Screen("Page2")
    data object Page3 : Screen("Page3")
    data object Page4 : Screen("Page4")
}