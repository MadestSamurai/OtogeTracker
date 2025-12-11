package com.madsam.otora.ui.record.chunithm

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
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
 * 使用 SharedTransitionLayout 实现共享元素过渡动画
 */
@OptIn(ExperimentalSharedTransitionApi::class)
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
    
    SharedTransitionLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedContent(
            targetState = selectedSongTitle.value,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            },
            label = "song_detail_transition"
        ) { songTitle ->
            if (songTitle == null) {
                // 曲目列表页
                ChunithmSongListPage(
                    viewModel = viewModel,
                    scrollThreshold = 50f,
                    setIsTabRowVisible = { },
                    onNavigateToSongDetail = { title ->
                        selectedSongTitle.value = title
                    },
                    onNavigateBack = onNavigateBack,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@AnimatedContent
                )
            } else {
                // 曲目详情页
                ChunithmSongDetailPage(
                    songTitle = songTitle,
                    viewModel = viewModel,
                    onNavigateBack = {
                        selectedSongTitle.value = null
                        viewModel.resetPageTitle()
                    },
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@AnimatedContent
                )
            }
        }
    }
}
