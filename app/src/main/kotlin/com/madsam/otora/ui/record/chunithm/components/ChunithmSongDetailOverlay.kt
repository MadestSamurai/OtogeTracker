package com.madsam.otora.ui.record.chunithm.components

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.pages.ChunithmSongDetailPage
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 歌曲详情覆盖层组件
 * 从底部滑入，覆盖在列表页面上
 */
@OptIn(DelicateCoroutinesApi::class)
@Composable
internal fun ChunithmSongDetailOverlay(
    songTitle: String,
    viewModel: ChunithmViewModel,
    onDismiss: () -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }
    
    // 启动时触发动画
    LaunchedEffect(Unit) {
        delay(50) // 短暂延迟确保组件已挂载
        isVisible = true
    }
    
    // 拦截返回键 - 必须放在最外层
    BackHandler(enabled = isVisible) {
        isVisible = false
        // 等待动画完成后再调用 onDismiss
        kotlinx.coroutines.GlobalScope.launch {
            delay(300)
            onDismiss()
        }
    }
    
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(200)) + 
                slideInVertically(
                    initialOffsetY = { it },
                    animationSpec = tween(300)
                ),
        exit = fadeOut(animationSpec = tween(200)) + 
               slideOutVertically(
                   targetOffsetY = { it },
                   animationSpec = tween(300)
               )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        isVisible = false
                        kotlinx.coroutines.GlobalScope.launch {
                            delay(300)
                            onDismiss()
                        }
                    }
                )
        ) {
            // 详情页内容容器
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { /* 阻止点击事件穿透 */ }
                    )
            ) {
                ChunithmSongDetailPage(
                    songTitle = songTitle,
                    viewModel = viewModel,
                    onNavigateBack = {
                        isVisible = false
                        kotlinx.coroutines.GlobalScope.launch {
                            delay(300)
                            onDismiss()
                        }
                    }
                )
            }
        }
    }
}
