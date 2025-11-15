package com.madsam.otora.ui.record.chunithm

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.ui.record.chunithm.pages.ChunithmSongDetailPage
import com.madsam.otora.ui.record.chunithm.pages.ChunithmSongListPage

/**
 * 曲目列表独立模块 - 包含列表页和详情页覆盖层
 * 完全独立的模块，内部创建自己的 ViewModel
 */
@Composable
fun ChunithmSongListScreen(
    onNavigateBack: () -> Unit
) {
    // 内部创建 ViewModel，完全独立
    val viewModel: ChunithmViewModel = viewModel()
    val selectedSongTitle = remember { mutableStateOf<String?>(null) }
    
    // 处理返回按钮
    BackHandler(enabled = true) {
        if (selectedSongTitle.value != null) {
            // 如果详情页打开，先关闭详情页
            selectedSongTitle.value = null
            viewModel.resetPageTitle()
        } else {
            // 否则关闭整个模块
            onNavigateBack()
        }
    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        // 曲目列表页
        ChunithmSongListPage(
            viewModel = viewModel,
            scrollThreshold = 50f,
            setIsTabRowVisible = { },
            onNavigateToSongDetail = { songTitle ->
                selectedSongTitle.value = songTitle
            },
            onNavigateBack = onNavigateBack
        )
        
        // 曲目详情覆盖层
        AnimatedVisibility(
            visible = selectedSongTitle.value != null,
            enter = slideInHorizontally(initialOffsetX = { it }) + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = { it }) + fadeOut()
        ) {
            selectedSongTitle.value?.let { songTitle ->
                ChunithmSongDetailPage(
                    songTitle = songTitle,
                    viewModel = viewModel,
                    onNavigateBack = {
                        selectedSongTitle.value = null
                        viewModel.resetPageTitle()
                    }
                )
            }
        }
    }
}
