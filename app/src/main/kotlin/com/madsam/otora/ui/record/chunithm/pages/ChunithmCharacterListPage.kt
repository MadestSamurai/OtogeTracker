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
import androidx.compose.foundation.layout.width
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
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.data.chunithm.local.model.ChunithmCharacterEntity
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel

@Composable
internal fun ChunithmCharacterListPage(
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
        CharacterListContent(
            viewModel = viewModel,
            onDismiss = onDismiss
        )
    }
}

@Composable
private fun CharacterListContent(
    viewModel: ChunithmViewModel,
    onDismiss: () -> Unit
) {
    val characters by viewModel.characters.collectAsState()
    val isLoading by viewModel.isCharactersLoading.collectAsState()
    
    LaunchedEffect(Unit) {
        viewModel.loadCharacters()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
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
                    .background(Red500)
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
                            .background(Red300, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Filled.ChevronLeft,
                            contentDescription = "返回",
                            tint = Beige400,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                
                // 标题
                Text(
                    text = "角色收集",
                    color = White1000,
                    fontSize = 20.sp,
                    fontFamily = sarasaBold,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
                
                // 统计信息
                Text(
                    text = "${characters.size} 个角色",
                    color = White1000.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    fontFamily = sarasaRegular,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

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
                
                characters.isEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "暂无角色数据",
                                color = White1000,
                                fontSize = 18.sp,
                                fontFamily = sarasaBold
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
                    CharacterGrid(characters = characters)
                }
            }
        }
    }
}

@Composable
private fun CharacterGrid(characters: List<ChunithmCharacterEntity>) {
    val gridState = rememberLazyGridState()
    
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 160.dp),
        state = gridState,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(vertical = 12.dp)
    ) {
        items(characters) { character ->
            CharacterCard(character = character)
        }
    }
}

@Composable
private fun CharacterCard(character: ChunithmCharacterEntity) {
    val frameColor = getFrameColor(character.frameType)
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        colors = CardDefaults.cardColors(containerColor = Red500),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // 角色图片区域
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            ) {
                // 角色图片
                AsyncImage(
                    model = character.imageUrl,
                    contentDescription = character.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .border(2.dp, frameColor, RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                
                // 当前使用标记
                if (character.isCurrentlyUsed) {
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
                            fontFamily = sarasaBold
                        )
                    }
                }
                
                // 满级标记
                if (character.isMaxLevel) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(4.dp)
                            .background(
                                color = Color(0xFFFFD700),
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "MAX",
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontFamily = sarasaBold
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // 角色名称
            Text(
                text = character.name,
                color = White1000,
                fontSize = 14.sp,
                fontFamily = sarasaSemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            
            // 等级信息
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Lv.${character.level}",
                    color = White1000.copy(alpha = 0.8f),
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
                
                if (!character.isMaxLevel && character.expBarWidth > 0) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(4.dp)
                            .background(
                                color = Color.White.copy(alpha = 0.2f),
                                shape = RoundedCornerShape(2.dp)
                            )
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(character.expBarWidth / 100f)
                                .height(4.dp)
                                .background(
                                    color = Color(0xFF4CAF50),
                                    shape = RoundedCornerShape(2.dp)
                                )
                        )
                    }
                }
            }
        }
    }
}

private fun getFrameColor(frameType: String): Color {
    return when (frameType) {
        ChunithmCharacterEntity.FRAME_NORMAL -> Color(0xFF9E9E9E) // 灰色
        ChunithmCharacterEntity.FRAME_COPPER -> Color(0xFFCD7F32) // 铜色
        ChunithmCharacterEntity.FRAME_SILVER -> Color(0xFFC0C0C0) // 银色
        ChunithmCharacterEntity.FRAME_GOLD -> Color(0xFFFFD700) // 金色
        ChunithmCharacterEntity.FRAME_PLATINA -> Color(0xFFE5E4E2) // 白金色
        else -> Color(0xFF9E9E9E)
    }
}
