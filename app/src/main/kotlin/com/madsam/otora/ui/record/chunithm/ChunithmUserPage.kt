package com.madsam.otora.ui.record.chunithm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.madsam.otora.ui.components.CustomTabRow
import com.madsam.otora.ui.record.ChunithmScreenState
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.ui.record.chunithm.dialogs.CookieDialog
import com.madsam.otora.ui.record.chunithm.pages.ChunithmMainPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmSongListPage
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Composable
internal fun ChunithmUserPage(
    viewModel: ChunithmViewModel,
    chuniScreenState: ChunithmScreenState,
    onNavigateToTopRating: () -> Unit,
    snackbarHostState: SnackbarHostState,
    showDialog: Boolean,
    onDismissDialog: () -> Unit
) {
    val selectedTabIndex by chuniScreenState.selectedTab.collectAsState()
    val scrollThreshold = 50f

    var isTabRowVisible by remember { mutableStateOf(true) }
    val tabTitles = listOf("Home", "Song List")

    val pagerState = rememberPagerState { tabTitles.size }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

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
                    onNavigateToTopRating = onNavigateToTopRating
                )

                1 -> ChunithmSongListPage(
                    viewModel = viewModel,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = { isTabRowVisible = it },
                )
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            AnimatedVisibility(
                visible = isTabRowVisible,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.CenterHorizontally)
            ) {
                CustomTabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier.padding(3.dp),
                    containerColor = Red500
                ) {
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
            }
        }
    }
}

