package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.data.chunithm.ui.model.ChunithmAvatarUiModel
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun AvatarLayout(
    chunithmAvatarUiModel: MutableStateFlow<ChunithmAvatarUiModel>,
    viewModel: ChunithmViewModel,
    onCategoryClick: ((String) -> Unit)? = null
) {
    val colorScheme = MaterialTheme.colorScheme
    val avatarData by chunithmAvatarUiModel.collectAsState()
    val avatarStats by viewModel.avatarCategoryStats.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        // 标题栏
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "角色装扮",
                fontSize = 16.sp,
                fontFamily = plexBold,
                color = colorScheme.primary,
                modifier = Modifier.weight(1f)
            )
            
            // 详细按钮
            Text(
                text = "详细",
                color = colorScheme.onSurface,
                fontSize = 14.sp,
                fontFamily = plexBold,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(colorScheme.surfaceContainerHigh)
                    .clickable { /* TODO: 跳转到装扮详情 */ }
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
        }

        // Avatar 和装饰统计区域
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
        // 左侧：Avatar显示
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .scaledLayout(0.8f) // width: 224, height: 286
                .width(280.dp)
                .background(colorScheme.surfaceContainerHigh)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 272.dp, height = 358.dp)
            ) {
                // Avatar Back
                Image(
                    painter = rememberAsyncImagePainter(avatarData.back),
                    contentDescription = "Avatar Back",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .size(272.dp, 294.dp)
                        .offset(y = 25.dp)
                        .zIndex(100f)
                )

                // Left Foot
                Box(
                    modifier = Modifier
                        .size(width = 42.dp, height = 52.dp)
                        .offset(x = 84.dp, y = 280.dp)
                        .clipToBounds()
                        .zIndex(101f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.footL),
                        contentDescription = "Avatar Skinfoot Left",
                        modifier = Modifier
                            .offset(x = 43.dp, y = (-102).dp)
                            .requiredSize(128.dp, 256.dp)
                    )
                }

                // Right Foot
                Box(
                    modifier = Modifier
                        .size(width = 42.dp, height = 52.dp)
                        .offset(x = 147.dp, y = 280.dp)
                        .clipToBounds()
                        .zIndex(102f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.footR),
                        contentDescription = "Avatar Skinfoot Right",
                        modifier = Modifier
                            .offset(x = 1.dp, y = (-102).dp)
                            .requiredSize(128.dp, 256.dp)
                    )
                }

                // Skin (avatar_skin)
                Box(
                    modifier = Modifier
                        .size(width = 128.dp, height = 204.dp)
                        .offset(x = 72.dp, y = 93.dp)
                        .clipToBounds()
                        .zIndex(104f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.skin),
                        contentDescription = "Avatar Skin",
                        modifier = Modifier
                            .offset(x = 0.dp, y = 26.dp)
                            .requiredSize(128.dp, 256.dp)
                    )
                }

                // Wear (avatar_wear)
                Box(
                    modifier = Modifier
                        .size(width = 258.dp, height = 218.dp)
                        .offset(x = 7.dp, y = 106.dp)
                        .clipToBounds()
                        .zIndex(105f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.wear),
                        contentDescription = "Avatar Wear",
                        modifier = Modifier.requiredSize(258.dp, 218.dp)
                    )
                }

                // Face (avatar_face)
                Box(
                    modifier = Modifier
                        .size(width = 58.dp, height = 64.dp)
                        .offset(x = 107.dp, y = 100.dp)
                        .clipToBounds()
                        .zIndex(106f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.face),
                        contentDescription = "Avatar Face",
                        modifier = Modifier.requiredSize(58.dp, 64.dp)
                    )
                }

                // Face Cover (avatar_faceCover)
                Box(
                    modifier = Modifier
                        .size(width = 116.dp, height = 104.dp)
                        .offset(x = 78.dp, y = 96.dp)
                        .clipToBounds()
                        .zIndex(107f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.faceCover),
                        contentDescription = "Avatar Face Cover",
                        modifier = Modifier.requiredSize(116.dp, 104.dp)
                    )
                }

                // Head (avatar_head)
                Box(
                    modifier = Modifier
                        .size(width = 200.dp, height = 150.dp)
                        .offset(x = 37.dp, y = 28.dp)
                        .clipToBounds()
                        .zIndex(108f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.head),
                        contentDescription = "Avatar Head",
                        modifier = Modifier.requiredSize(200.dp, 150.dp)
                    )
                }

                // Right Hand (avatar_hand_r)
                Box(
                    modifier = Modifier
                        .size(width = 36.dp, height = 72.dp)
                        .offset(x = 52.dp, y = 178.dp)
                        .clipToBounds()
                        .zIndex(109f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.handR),
                        contentDescription = "Avatar Right Hand",
                        modifier = Modifier.requiredSize(36.dp, 72.dp)
                    )
                }

                // Left Hand (avatar_hand_l)
                Box(
                    modifier = Modifier
                        .size(width = 36.dp, height = 72.dp)
                        .offset(x = 184.dp, y = 178.dp)
                        .clipToBounds()
                        .zIndex(109f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.handL),
                        contentDescription = "Avatar Left Hand",
                        modifier = Modifier.requiredSize(36.dp, 72.dp)
                    )
                }

                // Right Item (avatar_item_r)
                Box(
                    modifier = Modifier
                        .size(width = 100.dp, height = 272.dp)
                        .offset(x = 9.dp, y = 50.dp)
                        .graphicsLayer { rotationZ = -5f }
                        .clipToBounds()
                        .zIndex(109f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.itemR),
                        contentDescription = "Avatar Right Item",
                        modifier = Modifier
                            .offset(x = 50.dp)
                            .requiredSize(200.dp, 272.dp)
                    )
                }

                // Left Item (avatar_item_l)
                Box(
                    modifier = Modifier
                        .size(width = 100.dp, height = 272.dp)
                        .offset(x = 163.dp, y = 50.dp)
                        .graphicsLayer { rotationZ = 5f }
                        .clipToBounds()
                        .zIndex(110f)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(avatarData.itemL),
                        contentDescription = "Avatar Left Item",
                        modifier = Modifier
                            .offset(x = (-50).dp)
                            .requiredSize(200.dp, 272.dp)
                    )
                }
            }
        }
        
        // 右侧：装饰统计区域（三行两列）
        Column(
            modifier = Modifier
                .height(286.dp)  // 三行90dp + 两个8dp间距 = 286dp
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val categories = listOf(
                "face" to "面孔",
                "head" to "头部",
                "wear" to "服装",
                "item" to "道具",
                "back" to "背部",
                "front" to "前部"
            )
            
            // 三行两列布局
            for (row in 0..2) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    for (col in 0..1) {
                        val index = row * 2 + col
                        val (category, label) = categories[index]
                        val stats = avatarStats[category]

                        AvatarCategoryCard(
                            label = label,
                            count = stats?.count ?: 0,
                            previewItems = stats?.previewItems ?: emptyList(),
                            onClick = { onCategoryClick?.invoke(category) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
        }
    }
}

@Composable
private fun AvatarCategoryCard(
    label: String,
    count: Int,
    previewItems: List<com.madsam.otora.data.chunithm.local.model.ChunithmAvatarItemEntity>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    Box(
        modifier = modifier
            .height(90.dp)  // 设置固定高度为90dp
            .clip(RoundedCornerShape(8.dp))
            .background(colorScheme.surfaceContainerHigh)
            .clickable(onClick = onClick)
            .padding(6.dp)  // 减少内边距
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 标题和数量
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = label,
                    color = colorScheme.onSurface,
                    fontSize = 12.sp,
                    fontFamily = plexBold
                )
                
                Text(
                    text = "$count",
                    color = colorScheme.onSurface,
                    fontSize = 11.sp,
                    fontFamily = plexBold
                )
            }
            
            // 预览图片（两行，每行3个，共6个）
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                // 第一行（前3个）
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    previewItems.take(3).forEach { item ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(4.dp))
                                .border(
                                    width = if (item.isCurrentlyUsed) 2.dp else 1.dp,
                                    color = if (item.isCurrentlyUsed) colorScheme.onSurface else colorScheme.surfaceContainer,
                                    shape = RoundedCornerShape(4.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = item.imageUrl,
                                contentDescription = item.name,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                    
                    // 填充第一行空白位置
                    repeat(3 - minOf(3, previewItems.size)) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                        )
                    }
                }
                
                // 第二行（后3个）
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    previewItems.drop(3).take(3).forEach { item ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .clip(RoundedCornerShape(4.dp))
                                .border(
                                    width = if (item.isCurrentlyUsed) 2.dp else 1.dp,
                                    color = if (item.isCurrentlyUsed) colorScheme.onSurface else colorScheme.surfaceContainer,
                                    shape = RoundedCornerShape(4.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = item.imageUrl,
                                contentDescription = item.name,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                    
                    // 填充第二行空白位置
                    repeat(3 - maxOf(0, previewItems.size - 3)) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                        )
                    }
                }
            }
        }
    }
}

fun Modifier.scaledLayout(scale: Float): Modifier = this
    .graphicsLayer(scaleX = scale, scaleY = scale, transformOrigin = TransformOrigin(0f, 0f))
    .layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val scaledWidth = (placeable.width * scale).toInt()
        val scaledHeight = (placeable.height * scale).toInt()
        layout(scaledWidth, scaledHeight) {
            placeable.placeRelative(0, 0)
        }
    }