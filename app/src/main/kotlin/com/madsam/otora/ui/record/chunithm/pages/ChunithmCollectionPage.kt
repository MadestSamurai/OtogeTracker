package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
internal fun ChunithmCollectionPage(
    viewModel: ChunithmViewModel,
    scrollThreshold: Float,
    setIsTabRowVisible: (Boolean) -> Unit,
) {
    val listState = rememberLazyListState()

    // 监听滚动状态，控制底部TabRow的显示
    LaunchedEffect(listState) {
        var lastScrollOffset = 0
        snapshotFlow { listState.firstVisibleItemScrollOffset }
            .distinctUntilChanged()
            .collect { scrollOffset ->
                val isScrollingDown = scrollOffset > lastScrollOffset
                val shouldHideTabRow = isScrollingDown && scrollOffset > scrollThreshold
                setIsTabRowVisible(!shouldHideTabRow)
                lastScrollOffset = scrollOffset
            }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 页面标题
            item {
                Text(
                    text = "藏品收集",
                    color = White1000,
                    fontSize = 24.sp,
                    fontFamily = sarasaBold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            // 称号收集卡片
            item {
                CollectionCard(
                    title = "称号收集",
                    description = "收集各种游戏称号",
                    collectedCount = 0,
                    totalCount = 0
                )
            }

            // 角色收集卡片
            item {
                CollectionCard(
                    title = "角色收集",
                    description = "收集游戏中的角色",
                    collectedCount = 0,
                    totalCount = 0
                )
            }

            // 道具收集卡片
            item {
                CollectionCard(
                    title = "道具收集",
                    description = "收集各种游戏道具",
                    collectedCount = 0,
                    totalCount = 0
                )
            }

            // 技能收集卡片
            item {
                CollectionCard(
                    title = "技能收集",
                    description = "收集游戏技能",
                    collectedCount = 0,
                    totalCount = 0
                )
            }

            // 添加底部间距，避免被TabRow遮挡
            item {
                Box(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
private fun CollectionCard(
    title: String,
    description: String,
    collectedCount: Int,
    totalCount: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Red500),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = title,
                color = White1000,
                fontSize = 20.sp,
                fontFamily = sarasaBold
            )
            
            Text(
                text = description,
                color = White1000.copy(alpha = 0.8f),
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
            
            Text(
                text = if (totalCount > 0) "$collectedCount / $totalCount" else "即将推出",
                color = White1000.copy(alpha = 0.9f),
                fontSize = 16.sp,
                fontFamily = sarasaSemiBold,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}
