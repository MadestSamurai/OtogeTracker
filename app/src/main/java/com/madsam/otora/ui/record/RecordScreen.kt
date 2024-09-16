package com.madsam.otora.ui.record

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.ui.record.sub.ChunithmUserPage
import com.madsam.otora.ui.record.sub.MaimaiUserPage
import com.madsam.otora.ui.record.sub.OsuUserPage
import com.madsam.otora.utils.ShareUtil
import kotlinx.coroutines.launch

@Composable
fun RecordScreen() {
    val context = LocalContext.current
    val tabs =
        listOf(Screen.Page1, Screen.Page2, Screen.Page3, Screen.Page4)
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()
    val recordViewModel: RecordViewModel = viewModel(factory = RecordViewModelFactory(
        userId = ShareUtil.getString("userId", context) ?: "peppy",
        mode = ShareUtil.getString("mode", context) ?: "osu",
        context = context
    ))

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
                is Screen.Page1 -> OsuUserPage(recordViewModel)
                is Screen.Page2 -> MaimaiUserPage()
                is Screen.Page3 -> ChunithmUserPage(recordViewModel)
                is Screen.Page4 -> TestPage4()
            }
        }
    }
}

@Composable
fun TestPage4() {
    Text(text = "TestPage4",
        modifier = Modifier.fillMaxSize()
    )
}

sealed class Screen(val route: String) {
    data object Page1 : Screen("Osu")
    data object Page2 : Screen("Maimai")
    data object Page3 : Screen("Chunithm")
    data object Page4 : Screen("Page4")
}