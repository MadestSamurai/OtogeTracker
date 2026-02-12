package com.madsam.otora.ui.home

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.plexBold

@Composable
fun HomeScreen(
    snackbarHostState: SnackbarHostState,
    onShowBofScreen: () -> Unit
) {
    // 主页内容
    HomeMainContent(
        onNavigateToBOF = onShowBofScreen
    )
}

@Composable
private fun HomeMainContent(
    onNavigateToBOF: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
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
                fontFamily = plexBold,
                color = colorScheme.primary
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // BOF 功能卡片
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
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
                        fontFamily = plexBold,
                        color = colorScheme.onSurface
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "查看和管理好友排行榜",
                        fontSize = 14.sp,
                        color = colorScheme.onSurfaceVariant
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = onNavigateToBOF,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorScheme.primaryContainer
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "进入 BOF",
                            fontFamily = plexBold,
                            color = colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}
