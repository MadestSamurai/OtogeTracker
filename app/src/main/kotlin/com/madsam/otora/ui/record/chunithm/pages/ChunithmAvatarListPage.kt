package com.madsam.otora.ui.record.chunithm.pages

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import androidx.compose.material3.MaterialTheme
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.core.theme.plexSemi
import com.madsam.otora.data.chunithm.local.model.ChunithmAvatarItemEntity
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel

@Composable
internal fun ChunithmAvatarListPage(
    viewModel: ChunithmViewModel,
    visible: Boolean,
    onDismiss: () -> Unit
) {
    // 拦截系统返回事件
    BackHandler(enabled = visible) {
        onDismiss()
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(400)
        ) + fadeIn(animationSpec = tween(400)),
        exit = slideOutHorizontally(
            targetOffsetX = { it },
            animationSpec = tween(400)
        ) + fadeOut(animationSpec = tween(400))
    ) {
        AvatarListContent(
            viewModel = viewModel,
            onDismiss = onDismiss
        )
    }
}

@Composable
private fun AvatarListContent(
    viewModel: ChunithmViewModel,
    onDismiss: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val avatarItems by viewModel.avatarItems.collectAsState()
    val selectedCategory by viewModel.selectedAvatarCategory.collectAsState()
    val isLoading by viewModel.isAvatarItemsLoading.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.loadAvatarItems("face")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .windowInsetsPadding(
                WindowInsets.displayCutout.only(
                    WindowInsetsSides.Horizontal
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // 顶部工具栏
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorScheme.surfaceContainer)
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 返回按钮
                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier.size(40.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(colorScheme.surface, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Filled.ChevronLeft,
                            contentDescription = "返回",
                            tint = colorScheme.onSurface,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                
                // 标题
                Text(
                    text = "Avatar 自定义",
                    color = White1000,
                    fontSize = 20.sp,
                    fontFamily = plexBold,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
                
                // 统计信息
                Text(
                    text = "${avatarItems.size} 个部件",
                    color = White1000.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    fontFamily = plexRegular,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
            
            // 分类筛选
            CategoryFilterRow(
                selectedCategory = selectedCategory,
                onCategorySelected = { viewModel.selectAvatarCategory(it) }
            )

            // 内容区域
            when {
                isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = White1000)
                    }
                }
                
                avatarItems.isEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "暂无部件数据",
                                color = White1000,
                                fontSize = 18.sp,
                                fontFamily = plexBold
                            )
                            Text(
                                text = "请先同步游戏数据",
                                color = TEXT_GRAY,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
                
                else -> {
                    AvatarItemGrid(items = avatarItems)
                }
            }
        }
    }
}

@Composable
private fun CategoryFilterRow(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    val categories = listOf(
        "face" to "面孔",
        "head" to "头部",
        "wear" to "服装",
        "item" to "道具",
        "back" to "背部",
        "front" to "前部"
    )
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.surfaceContainer)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categories.forEach { (category, label) ->
            FilterChip(
                selected = selectedCategory == category,
                onClick = { onCategorySelected(category) },
                label = {
                    Text(
                        text = label,
                        fontSize = 12.sp,
                        fontFamily = plexRegular
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = colorScheme.surface,
                    labelColor = White1000.copy(alpha = 0.6f),
                    selectedContainerColor = colorScheme.onSurface,
                    selectedLabelColor = Color.Black
                )
            )
        }
    }
}

@Composable
private fun AvatarItemGrid(items: List<ChunithmAvatarItemEntity>) {
    val gridState = rememberLazyGridState()
    
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        state = gridState,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(vertical = 12.dp)
    ) {
        items(items) { item ->
            AvatarItemCard(item = item)
        }
    }
}

@Composable
private fun AvatarItemCard(item: ChunithmAvatarItemEntity) {
    val colorScheme = MaterialTheme.colorScheme
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // 部件图片区域
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            ) {
                // 部件图片
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = item.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White.copy(alpha = 0.1f))
                        .border(1.dp, White1000.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit
                )
                
                // 当前使用标记
                if (item.isCurrentlyUsed) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(4.dp)
                            .background(
                                color = Color(0xFF4CAF50),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "使用中",
                            color = White1000,
                            fontSize = 10.sp,
                            fontFamily = plexBold
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // 部件名称
            Text(
                text = item.name,
                color = White1000,
                fontSize = 13.sp,
                fontFamily = plexSemi,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.weight(1f))
            
            // 部件ID（调试用）
            if (item.itemId.isNotEmpty()) {
                Text(
                    text = "ID: ${item.itemId}",
                    color = TEXT_GRAY,
                    fontSize = 10.sp,
                    fontFamily = plexRegular
                )
            }
        }
    }
}
