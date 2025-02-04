package com.madsam.otora.ui.record

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext  // 正确导入
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.fonts.sarasaFont
import com.madsam.otora.ui.record.chunithm.TopRating
import com.madsam.otora.ui.record.sub.ChunithmUserPage
import com.madsam.otora.ui.record.sub.MaimaiUserPage
import com.madsam.otora.ui.record.sub.OsuUserPage
import com.madsam.otora.ui.record.viewmodel.ChuniViewModel
import com.madsam.otora.ui.record.viewmodel.ChuniViewModelFactory
import com.madsam.otora.ui.record.viewmodel.OsuViewModel
import com.madsam.otora.ui.record.viewmodel.OsuViewModelFactory
import com.madsam.otora.utils.ShareUtil
import kotlinx.coroutines.launch

@Composable
fun RecordScreen(
    snackbarHostState : SnackbarHostState
) {
    val tabs = listOf(Screen.Page1, Screen.Page2, Screen.Page3, Screen.Page4)
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    var showOsuDialog by remember { mutableStateOf(false) }
    var showMaimaiDialog by remember { mutableStateOf(false) }
    var showChunithmDialog by remember { mutableStateOf(false) }
    var showChunithmTopRating by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
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

            val osuViewModel: OsuViewModel = viewModel(factory = OsuViewModelFactory(
                userId = ShareUtil.getString("userId", context) ?: "2",
                mode = ShareUtil.getString("mode", context) ?: "osu",
                context = context
            ))
            val chuniViewModel: ChuniViewModel = viewModel(factory = ChuniViewModelFactory(context))

            HorizontalPager(state = pagerState) { page ->
                when (tabs[page]) {
                    is Screen.Page1 -> OsuUserPage(
                        showOsuDialog,
                        osuViewModel,
                        onDismissDialog = { showOsuDialog = false }
                    )
                    is Screen.Page2 -> MaimaiUserPage(
                        showMaimaiDialog,
                        onDismissDialog = { showMaimaiDialog = false }
                    )
                    is Screen.Page3 -> {
                        AnimatedVisibility(
                            visible = showChunithmTopRating,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            TopRating(onBack = { showChunithmTopRating = false })
                        }
                        AnimatedVisibility(
                            visible = !showChunithmTopRating,
                            enter = fadeIn(),
                            exit = fadeOut()
                        ) {
                            ChunithmUserPage(
                                chuniViewModel,
                                onNavigateToTopRating = { showChunithmTopRating = true },
                                snackbarHostState = snackbarHostState,
                                showDialog = showChunithmDialog,
                                onDismissDialog = { showChunithmDialog = false }
                            )
                        }
                    }
                    is Screen.Page4 -> TestPage4()
                }
            }
        }

        // Floating Action Button
        when (pagerState.currentPage) {
            0 -> {
                FloatingActionButton(
                    onClick = { showOsuDialog = true },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
            1 -> {
                FloatingActionButton(
                    onClick = { showMaimaiDialog = true },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
            }

            2 -> {
                FloatingActionButton(
                    onClick = { showChunithmDialog = true },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Icon(Icons.Default.Share, contentDescription = "Share")
                }
            }

            3 -> {
                FloatingActionButton(
                    onClick = { /* Action for Page 4 */ },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

@Composable
fun TestPage4() {
    Text(text = "TestPage4",
        modifier = Modifier.fillMaxSize(),
        fontFamily = sarasaFont,
        fontSize = 20.sp
    )
}

sealed class Screen(val route: String) {
    data object Page1 : Screen("Osu")
    data object Page2 : Screen("Maimai")
    data object Page3 : Screen("Chunithm")
    data object Page4 : Screen("Page4")
}