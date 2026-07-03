package com.madsam.otora.ui.record.chunithm.pages

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.core.theme.plexSemi
import com.madsam.otora.core.utils.CalcUtils
import com.madsam.otora.core.utils.CalcUtils.numberToChuniRank
import com.madsam.otora.data.chunithm.ui.model.ChunithmSheetUiModel
import com.madsam.otora.ui.BASE_URL
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.SheetScoreInfo

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun ChunithmSongDetailPage(
    songTitle: String,
    viewModel: ChunithmViewModel,
    onNavigateBack: () -> Unit,
    sharedTransitionScope: SharedTransitionScope? = null,
    animatedContentScope: AnimatedContentScope? = null
) {
    val colorScheme = MaterialTheme.colorScheme
    // 对URL编码的标题进行解码
    val decodedTitle = java.net.URLDecoder.decode(songTitle, "UTF-8")
    
    // 共享元素key
    val coverKey = "song_cover_$decodedTitle"
    val titleKey = "song_title_$decodedTitle"
    val cardKey = "song_card_$decodedTitle"
    
    val songList by viewModel.chuniSongs.collectAsState()
    val song = songList.find { it.title == decodedTitle }

    // 更新页面标题
    LaunchedEffect(decodedTitle) {
        viewModel.updatePageTitle(decodedTitle)
    }

    // 拦截系统返回事件
    BackHandler {
        viewModel.resetPageTitle()
        onNavigateBack()
    }

    if (song == null) {
        // 如果找不到歌曲，显示错误页面
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorScheme.surface)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "歌曲未找到",
                color = colorScheme.primary,
                fontSize = 18.sp,
                fontFamily = plexBold
            )
        }
        return
    }

    // 页面容器 - 使用 Box 来叠加标题栏
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .let { modifier ->
                if (sharedTransitionScope != null && animatedContentScope != null) {
                    with(sharedTransitionScope) {
                        modifier.sharedBounds(
                            sharedContentState = rememberSharedContentState(key = cardKey),
                            animatedVisibilityScope = animatedContentScope,
                            resizeMode = SharedTransitionScope.ResizeMode.scaleToBounds()
                        )
                    }
                } else modifier
            }
    ) {
        // 主内容区域
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 顶部间距（为标题栏留出空间）
            item {
                Spacer(
                    modifier = Modifier
                        .windowInsetsPadding(WindowInsets.statusBars)
                        .height(56.dp)
                )
            }
            
            // 封面和基本信息
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainer),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            // 封面图片 - 共享元素
                            Image(
                                painter = rememberAsyncImagePainter(
                                    model = "$BASE_URL/chuni/img/${song.imageName}",
                                    contentScale = ContentScale.Crop
                                ),
                                contentDescription = "封面",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .let { modifier ->
                                        if (sharedTransitionScope != null && animatedContentScope != null) {
                                            with(sharedTransitionScope) {
                                                modifier.sharedElement(
                                                    sharedContentState = rememberSharedContentState(key = coverKey),
                                                    animatedVisibilityScope = animatedContentScope,
                                                    clipInOverlayDuringTransition = OverlayClip(RoundedCornerShape(12.dp))
                                                )
                                            }
                                        } else modifier
                                    }
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            // 基本信息
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = song.title,
                                    color = White1000,
                                    fontSize = 18.sp,
                                    fontFamily = plexBold,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                InfoRow("艺术家", song.artist)
                                InfoRow("版本", song.version)
                                InfoRow("类型", song.genre)
                                if (song.bpm > 0) {
                                    InfoRow("BPM", song.bpm.toString())
                                }
                            }
                        }
                    }
                }
            }

            // 详细难度信息（包含成绩）
            val scoresMap = viewModel.getSheetScoreInfoMapForSong(song.title)
            items(song.sheets.size) { index ->
                SongSheetDetailCard(
                    sheet = song.sheets[index],
                    scoreInfo = scoresMap[song.sheets[index].difficulty],
                    songTitle = song.title,
                    viewModel = viewModel
                )
            }
            
            // 底部间距
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        
        // 标题栏 - 覆盖在内容上方
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .height(56.dp)
                .background(colorScheme.surface.copy(alpha = 0.95f))
                .padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 返回按钮
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable {
                        viewModel.resetPageTitle()
                        onNavigateBack()
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = rememberVectorPainter(image = Icons.AutoMirrored.Filled.ArrowBack),
                    contentDescription = "返回",
                    tint = colorScheme.onSurface,
                    modifier = Modifier.size(24.dp)
                )
            }
            
            // 标题
            Text(
                text = decodedTitle,
                color = colorScheme.onSurface,
                fontSize = 18.sp,
                fontFamily = plexBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    val colorScheme = MaterialTheme.colorScheme
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label:",
            color = colorScheme.onSurface,
            fontSize = 14.sp,
            fontFamily = plexSemi,
            modifier = Modifier.weight(0.4f)
        )
        Text(
            text = value,
            color = White1000,
            fontSize = 14.sp,
            modifier = Modifier.weight(0.6f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun SongSheetDetailCard(
    sheet: ChunithmSheetUiModel,
    scoreInfo: SheetScoreInfo?,
    songTitle: String,
    viewModel: ChunithmViewModel
) {
    val colorScheme = MaterialTheme.colorScheme
    val difficultyColor = when (sheet.difficulty) {
        "basic" -> CHUNI_DIFF_BASIC
        "advanced" -> CHUNI_DIFF_ADVANCED
        "expert" -> CHUNI_DIFF_EXPERT
        "master" -> CHUNI_DIFF_MASTER
        "ultima" -> CHUNI_DIFF_ULTIMA_1
        else -> colorScheme.surface
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = difficultyColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // 难度标题行
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = sheet.difficulty.uppercase(),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = plexBold
                )
                Text(
                    text = "Lv. ${sheet.levelCn}",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = plexBold
                )
            }
            
            if (sheet.difficulty == "ultima") {
                Spacer(modifier = Modifier.height(1.dp))
                androidx.compose.foundation.Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                ) {
                    drawRect(CHUNI_DIFF_ULTIMA_2)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // 难度数值信息
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    if (sheet.levelCn.isNotEmpty()) {
                        Text(
                            text = "CN: ${sheet.levelCn}",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = plexBold
                        )
                        Text(
                            text = "定数: ${sheet.levelValueCn}",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (sheet.levelJp.isNotEmpty()) {
                        Text(
                            text = "JP: ${sheet.levelJp}",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = plexBold
                        )
                        Text(
                            text = "定数: ${sheet.levelValueJp}",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                }
                
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Total: ${sheet.total}",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = plexBold
                    )
                    if (sheet.noteDesigner.isNotEmpty()) {
                        Text(
                            text = "谱面: ${sheet.noteDesigner}",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                }
            }
            
            // 成绩信息
            if (scoreInfo != null && scoreInfo.score > 0) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "成绩信息",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = plexBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "分数: ${scoreInfo.score}",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontFamily = plexBold
                        )
                        if (scoreInfo.rank >= 0) {
                            Text(
                                text = "评级: ${numberToChuniRank(scoreInfo.rank)}",
                                color = Color.White.copy(alpha = 0.8f),
                                fontSize = 14.sp
                            )
                        }
                    }
                    
                    Row {
                        if (scoreInfo.clear.isNotEmpty()) {
                            Text(
                                text = CalcUtils.clearToChuniClear(scoreInfo.clear),
                                fontSize = 12.sp,
                                fontFamily = plexBold,
                                color = Color.White,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color.Black.copy(alpha = 0.5f))
                                    .padding(vertical = 4.dp, horizontal = 8.dp)
                            )
                        }
                        if (scoreInfo.combo.isNotEmpty()) {
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = CalcUtils.comboToChuniCombo(scoreInfo.combo),
                                fontSize = 12.sp,
                                fontFamily = plexBold,
                                color = Color.White,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color.Black.copy(alpha = 0.5f))
                                    .padding(vertical = 4.dp, horizontal = 8.dp)
                            )
                        }
                        if (scoreInfo.chain.isNotEmpty()) {
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = CalcUtils.chainToChuniChain(scoreInfo.chain),
                                fontSize = 12.sp,
                                fontFamily = plexBold,
                                color = Color.White,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color.Black.copy(alpha = 0.5f))
                                    .padding(vertical = 4.dp, horizontal = 8.dp)
                            )
                        }
                    }
                }
            }
            
            // 音符统计
            if (sheet.total > 0) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "音符统计",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = plexBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    NoteTypeItem("TAP", sheet.tap)
                    NoteTypeItem("HOLD", sheet.hold)
                    NoteTypeItem("SLIDE", sheet.slide)
                    NoteTypeItem("AIR", sheet.air)
                    NoteTypeItem("FLICK", sheet.flick)
                }
            }

            val diff = when (sheet.difficulty) {
                "basic" -> "0"
                "advanced" -> "1"
                "expert" -> "2"
                "master" -> "3"
                "ultima" -> "4"
                else -> "-1"
            }
            // 友人成绩排行
            FriendScoreRanking(
                songTitle = songTitle,
                diff = diff,
                viewModel = viewModel
            )
        }
    }
}

@Composable
private fun NoteTypeItem(type: String, count: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = type,
            color = White1000.copy(alpha = 0.7f),
            fontSize = 12.sp,
            fontFamily = plexBold
        )
        Text(
            text = count.toString(),
            color = White1000,
            fontSize = 16.sp,
            fontFamily = plexBold
        )
    }
}

@Composable
private fun FriendScoreRanking(
    songTitle: String,
    diff: String,
    viewModel: ChunithmViewModel
) {
    var isExpanded by remember { mutableStateOf(false) }
    var rankingList by remember { mutableStateOf<List<ChunithmViewModel.FriendScoreRankingItem>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    
    // 加载排行数据
    LaunchedEffect(songTitle, diff) {
        isLoading = true
        try {
            rankingList = viewModel.getFriendScoreRanking(songTitle, diff)
        } catch (e: Exception) {
            Log.e("FriendScoreRanking", "Failed to load friend score ranking: ${e.message}")
        } finally {
            isLoading = false
        }
    }
    
    if (isLoading || rankingList.isEmpty()) return
    
    Spacer(modifier = Modifier.height(16.dp))
    
    // 黑色半透明背景卡片
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            ),
        colors = CardDefaults.cardColors(containerColor = Color.Black.copy(alpha = 0.3f)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // 标题和展开按钮
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "友人成绩排行",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = plexBold,
                    modifier = Modifier.padding(start = 6.dp)
                )
                
                // 展开/收起按钮
                if (rankingList.size > 1) {
                    TextButton(
                        onClick = { isExpanded = !isExpanded },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.White.copy(alpha = 0.8f)
                        ),
                        modifier = Modifier.height(32.dp)
                    ) {
                        Text(
                            text = if (isExpanded) "收起" else "展开完整列表",
                            fontSize = 12.sp
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // 用户自己的排名
            val userRanking = rankingList.find { it.isMyScore }
            
            // 分离排名：比用户高的分数和比用户低的分数
            val higherRankings = if (userRanking != null) {
                rankingList.filter { !it.isMyScore && it.rank < userRanking.rank }
            } else {
                emptyList()
            }
            
            val lowerRankings = if (userRanking != null) {
                rankingList.filter { !it.isMyScore && it.rank > userRanking.rank }
            } else {
                rankingList.filter { !it.isMyScore }
            }
            
            // 比用户分数高的排名（上方展开）
            AnimatedVisibility(
                visible = isExpanded && higherRankings.isNotEmpty(),
                enter = expandVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ),
                exit = shrinkVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
            ) {
                Column {
                    for (item in higherRankings) {
                        FriendScoreRankingItem(item)
                        if (item != higherRankings.last()) {
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                    if (userRanking != null) {
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
            
            // 用户自己的排名（始终显示在中间）
            if (userRanking != null) {
                FriendScoreRankingItem(userRanking)
            }
            
            // 比用户分数低的排名（下方展开）
            AnimatedVisibility(
                visible = isExpanded && lowerRankings.isNotEmpty(),
                enter = expandVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ),
                exit = shrinkVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
            ) {
                Column {
                    if (userRanking != null) {
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                    for (item in lowerRankings) {
                        FriendScoreRankingItem(item)
                        if (item != lowerRankings.last()) {
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun FriendScoreRankingItem(item: ChunithmViewModel.FriendScoreRankingItem) {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(
                if (item.isMyScore) Color.White.copy(alpha = 0.15f)
                else Color.White.copy(alpha = 0.08f)
            )
            .padding(horizontal = 6.dp, vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 排名和用户名
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "#${item.rank}",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = plexBold,
                    modifier = Modifier.width(32.dp)
                )
                Text(
                    text = item.friendName,
                    color = if (item.isMyScore) Color.White else Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    fontFamily = if (item.isMyScore) plexBold else plexRegular,
                    modifier = Modifier.weight(1f)
                )
            }
            
            // 分数和标记
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.score.toString(),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = plexBold,
                    modifier = Modifier.width(90.dp), // 增加分数显示宽度
                    textAlign = TextAlign.End
                )
                
                // Combo标记
                if (item.combo.isNotEmpty()) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = CalcUtils.comboToChuniCombo(item.combo),
                        fontSize = 10.sp,
                        fontFamily = plexBold,
                        color = Color.White,
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Black.copy(alpha = 0.5f))
                            .padding(vertical = 2.dp, horizontal = 6.dp)
                    )
                }
            }
        }
    }
}
