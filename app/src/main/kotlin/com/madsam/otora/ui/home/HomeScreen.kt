package com.madsam.otora.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.ui.bof.BofScreen

@Composable
fun HomeScreen(
    snackbarHostState: SnackbarHostState,
    onNavigationBarVisibilityChange: (Boolean) -> Unit = {}
) {
    var showBofScreen by remember { mutableStateOf(false) }
    val bofScreenState = remember { BofScreenState() }
    
    // 通知外层导航栏可见性变化
    LaunchedEffect(showBofScreen) {
        onNavigationBarVisibilityChange(!showBofScreen)
    }
    
    Box(modifier = Modifier.fillMaxSize()) {
        // 主页内容
        HomeMainContent(
            onNavigateToBOF = { showBofScreen = true }
        )
        
        // BOF页面覆盖层（带动画）
        AnimatedVisibility(
            visible = showBofScreen,
            enter = slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(400)
            ) + fadeIn(animationSpec = tween(400)),
            exit = slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(400)
            ) + fadeOut(animationSpec = tween(400))
        ) {
            BofScreen(
                snackbarHostState = snackbarHostState,
                bofScreenState = bofScreenState,
                onNavigateBack = { showBofScreen = false }
            )
        }
    }
}

@Composable
private fun HomeMainContent(
    onNavigateToBOF: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 欢迎文本
            Text(
                text = "OtogeTracker",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = sarasaBold,
                color = Beige500
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // BOF 功能卡片
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Red500),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Best of Friends",
                        fontSize = 24.sp,
                        fontFamily = sarasaBold,
                        color = White1000
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "查看和管理好友排行榜",
                        fontSize = 14.sp,
                        color = Beige500
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = onNavigateToBOF,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Red300
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "进入 BOF",
                            fontFamily = sarasaBold,
                            color = Beige500
                        )
                    }
                }
            }
        }
    }
}
