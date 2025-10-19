package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.`Arrow-down`
import com.madsam.otora.core.icon.fa.`Arrow-right`
import com.madsam.otora.core.icon.fa.`Arrow-up`
import com.madsam.otora.core.icon.fa.Star
import com.madsam.otora.core.theme.BG_DARK_GRAY
import com.madsam.otora.core.theme.RANKING_BLUE
import com.madsam.otora.core.theme.RANKING_RED
import com.madsam.otora.core.theme.RANKING_YELLOW
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.bof.TeamRankingItem
import com.madsam.otora.ui.bof.components.BofTeamCaptureDialog

@Composable
internal fun BofTeamRankingScreen(
    bofScreenState: BofScreenState,
    vm: BofViewModel = viewModel(),
    snackbarHostState: SnackbarHostState,
    teamInfoMode: Int = 0,
    scrollThreshold: Float = 50f,
    setIsTabRowVisible: (Boolean) -> Unit = {},
    showCaptureDialog: Boolean = false,
    onCaptureDialogDismiss: () -> Unit = {}
) {
    val teamRankingData by vm.teamRankingData.collectAsState()
    val isLoading by vm.isTeamRankingLoading.collectAsState()
    val errorMessage by vm.teamRankingError.collectAsState()
    val selectedRange by bofScreenState.selectedRange.collectAsState()
    
    val context = LocalContext.current
    val listState = rememberLazyListState()
    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .windowInsetsPadding(
                WindowInsets.displayCutout.only(
                    if (useNavigationRail) {
                        // 使用 NavigationRail 时，左侧已由 Rail 处理，只处理右侧
                        WindowInsetsSides.End
                    } else {
                        // 使用 BottomNavigation 时，处理左侧和右侧
                        WindowInsetsSides.Start + WindowInsetsSides.End
                    }
                )
            )
    ) {
        when {
            isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = RANKING_RED)
                }
            }
            
            errorMessage.isNotEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "加载失败",
                            fontFamily = sarasaBold,
                            fontSize = 18.sp,
                            color = RANKING_RED
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = errorMessage,
                            fontFamily = sarasaRegular,
                            fontSize = 14.sp,
                            color = TEXT_GRAY,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { 
                                // 通过重新设置相同的selectedRange来触发数据重新加载
                                selectedRange?.let { range ->
                                    bofScreenState.selectedRange.value = range
                                }
                            }
                        ) {
                            Text("重试")
                        }
                    }
                }
            }
            
            teamRankingData.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "暂无团队数据",
                            fontFamily = sarasaBold,
                            fontSize = 18.sp,
                            color = TEXT_GRAY
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "请等待数据更新或检查网络连接",
                            fontFamily = sarasaRegular,
                            fontSize = 14.sp,
                            color = TEXT_GRAY
                        )
                    }
                }
            }
            
            else -> {
                // 团队排行数据展示
                TeamRankingTable(
                    teams = teamRankingData,
                    listState = listState,
                    teamInfoMode = teamInfoMode,
                    scrollThreshold = scrollThreshold,
                    setIsTabRowVisible = setIsTabRowVisible,
                    vm = vm
                )
                
                // 截图对话框
                val showDialogState = remember(showCaptureDialog) { mutableStateOf(showCaptureDialog) }
                LaunchedEffect(showCaptureDialog) {
                    showDialogState.value = showCaptureDialog
                }
                LaunchedEffect(showDialogState.value) {
                    if (!showDialogState.value && showCaptureDialog) {
                        onCaptureDialogDismiss()
                    }
                }
                
                BofTeamCaptureDialog(
                    showDialog = showDialogState,
                    context = context,
                    snackbarHostState = snackbarHostState,
                    teams = teamRankingData,
                    subtitle = "团队总分排行榜 (${teamRankingData.size} 团队) | ${vm.getSelectedTimeString()}"
                )
            }
        }
    }
}

@Composable
private fun TeamRankingTable(
    teams: List<TeamRankingItem>,
    listState: androidx.compose.foundation.lazy.LazyListState,
    teamInfoMode: Int,
    scrollThreshold: Float = 50f,
    setIsTabRowVisible: (Boolean) -> Unit = {},
    vm: BofViewModel
) {
    // 屏幕宽度检测（参考RankingTable）
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    val screenWidthDp = with(density) {
        windowInfo.containerSize.width.toDp()
    }
    
    val isNarrowScreen = screenWidthDp.value < 600
    
    // 宽度测量（类似RankingTable）
    var extraWidth by remember { mutableStateOf(50.dp) } // 评价数列宽度
    var medianWidth by remember { mutableStateOf(60.dp) } // 中位数列宽度
    
    // 计算分数条宽度（对应中位数+评价数的宽度）
    val scoreBarWidth = medianWidth + extraWidth
    
    val maxScore = teams.maxOfOrNull { it.totalScore } ?: 1.0
    
    Column {
        // 隐藏的测量容器（照搬RankingTable逻辑）
        Box(modifier = Modifier
            .size(0.dp)
            .requiredWidth(500.dp)
            .requiredHeight(100.dp)
        ) {
            // 测量评价数列宽度（四位整数）
            Text(
                text = "0000", // 四位整数测量
                fontFamily = sarasaRegular,
                fontSize = 14.sp,
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    extraWidth = with(density) {
                        coordinates.size.width.toDp() + 24.dp
                    }
                }
            )
            // 测量中位数列宽度（000.00格式）
            Text(
                text = "000.00", // 带两位小数测量
                fontFamily = sarasaRegular,
                fontSize = 14.sp,
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    medianWidth = with(density) {
                        coordinates.size.width.toDp() + 24.dp
                    }
                }
            )
        }
        
        // 表格标题和副标题
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 主标题
            Text(
                text = "团队总分排行榜",
                fontFamily = sarasaBold,
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            
            // 副标题
            Text(
                text = "团队总分排行榜 (${teams.size} 团队) | ${vm.getSelectedTimeString()}",
                fontFamily = sarasaRegular,
                fontSize = 12.sp,
                color = TEXT_GRAY,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        // 表格头部
        TeamTableHeader(
            teamInfoMode = teamInfoMode,
            isNarrowScreen = isNarrowScreen,
            extraWidth = extraWidth,
            medianWidth = medianWidth
        )

        // 数据列表
        LazyColumn(
            state = listState,
            modifier = Modifier
                .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                .nestedScroll(object : NestedScrollConnection {
                    private var totalScroll = 0f

                    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                        // 只在垂直滑动时处理TabRow显示/隐藏
                        totalScroll += available.y
                        if (totalScroll < -scrollThreshold) {
                            setIsTabRowVisible(false)
                            totalScroll = 0f
                        } else if (totalScroll > scrollThreshold) {
                            setIsTabRowVisible(true)
                            totalScroll = 0f
                        }
                        return Offset.Zero
                    }
                })
        ) {
            itemsIndexed(teams) { index, team ->
                TeamRankingRow(
                    team = team,
                    index = index,
                    maxScore = maxScore,
                    teamInfoMode = teamInfoMode,
                    isNarrowScreen = isNarrowScreen,
                    extraWidth = extraWidth,
                    medianWidth = medianWidth,
                    scoreBarWidth = scoreBarWidth
                )
            }
        }
    }
}

@Composable
internal fun TeamTableHeader(
    teamInfoMode: Int,
    isNarrowScreen: Boolean,
    extraWidth: Dp,
    medianWidth: Dp
) {
    Row(
        modifier = Modifier
            .background(BG_DARK_GRAY)
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "排名",
            fontFamily = sarasaBold,
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(50.dp) // 照搬RankingTable的排名列宽度
        )
        
        Text(
            text = "团队",
            fontFamily = sarasaBold,
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier.weight(0.6f) // 照搬RankingTable的作品信息列权重
        )
        
        // 根据屏幕宽度决定显示内容
        if (isNarrowScreen) {
            // 窄屏模式：根据teamInfoMode切换显示
            when (teamInfoMode) {
                0 -> {
                    // 只显示分数条
                    Text(
                        text = "总分",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(medianWidth + extraWidth)
                    )
                }
                1 -> {
                    // 显示中位数和评价数
                    Text(
                        text = "中位数",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(medianWidth)
                    )
                    Text(
                        text = "评价数",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(extraWidth)
                    )
                }
            }
        } else {
            // 宽屏模式：始终显示所有列
            Text(
                text = "总分",
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(0.4f)
            )
            Text(
                text = "中位数",
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier.width(medianWidth)
            )
            Text(
                text = "评价数",
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier.width(extraWidth)
            )
        }
    }
}

@Composable
internal fun TeamRankingRow(
    team: TeamRankingItem,
    index: Int,
    maxScore: Double,
    teamInfoMode: Int,
    isNarrowScreen: Boolean,
    extraWidth: Dp,
    medianWidth: Dp,
    scoreBarWidth: Dp
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val scoreRatio = if (maxScore > 0) team.totalScore / maxScore else 0.0
    val rankColor = Color.White

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
    ) {
        // 团队主要信息行（完全照搬RankingTable的行设计）
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 排名列 - 完全照搬RankingTable的排名列设计
            Column(
                modifier = Modifier
                    .width(50.dp)
                    .padding(vertical = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 上方：排名变化指示器和变化量
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // 排名变化指示器（照搬RankingTable逻辑）
                    val change = team.rankChange
                    when {
                        change != null && change > 0 -> {
                            Icon(
                                imageVector = Fa.`Arrow-up`,
                                contentDescription = "Rank Up",
                                tint = Color.Green,
                                modifier = Modifier.size(12.dp)
                            )
                            Text(
                                text = change.toString(),
                                fontFamily = sarasaRegular,
                                fontSize = 10.sp,
                                color = Color.Green
                            )
                        }
                        change != null && change < 0 -> {
                            Icon(
                                imageVector = Fa.`Arrow-down`,
                                contentDescription = "Rank Down",
                                tint = Color.Red,
                                modifier = Modifier.size(12.dp)
                            )
                            Text(
                                text = (-change).toString(),
                                fontFamily = sarasaRegular,
                                fontSize = 10.sp,
                                color = Color.Red
                            )
                        }
                        change != null -> {
                            Icon(
                                imageVector = Fa.`Arrow-right`,
                                contentDescription = "Rank Same",
                                tint = Color.Gray,
                                modifier = Modifier.size(12.dp)
                            )
                        }
                        else -> {}
                    }
                }
                
                // 下方：当前排名
                Text(
                    text = team.rank.toString(),
                    fontFamily = sarasaBold,
                    fontSize = 16.sp,
                    color = rankColor,
                    textAlign = TextAlign.Center
                )
            }

            // 团队信息列（照搬RankingTable的作品信息列设计，但只显示团队名称）
            Text(
                text = team.teamName,
                fontFamily = sarasaBold,
                fontSize = 16.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .weight(0.6f)
                    .padding(horizontal = 8.dp)
            )

            // 根据屏幕宽度决定显示内容
            if (isNarrowScreen) {
                // 窄屏模式：根据teamInfoMode切换显示
                when (teamInfoMode) {
                    0 -> {
                        // 只显示分数条
                        Column(
                            modifier = Modifier
                                .width(scoreBarWidth)
                                .padding(top = 1.dp)
                        ) {
                            // 主分数条
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(20.dp)
                                    .padding(horizontal = 2.dp)
                            ) {
                                Box {
                                    Spacer(
                                        modifier = Modifier
                                            .fillMaxWidth(scoreRatio.toFloat().coerceAtMost(1f))
                                            .height(20.dp)
                                            .background(
                                                color = RANKING_RED,
                                                shape = RoundedCornerShape(
                                                    topEnd = 10.dp,
                                                    bottomEnd = 10.dp
                                                )
                                            )
                                    )
                                    Text(
                                        text = "%.2f".format(team.totalScore),
                                        fontFamily = sarasaBold,
                                        fontSize = 14.sp,
                                        color = Color.White,
                                        overflow = TextOverflow.Visible,
                                        maxLines = 1,
                                        modifier = Modifier
                                            .align(Alignment.CenterEnd)
                                            .padding(end = 4.dp)
                                    )
                                }
                            }
                            
                            // 对比分数条（如果有对比数据）
                            team.compareTotalScore?.let { compareScore ->
                                val compareRatio = if (maxScore > 0) compareScore / maxScore else 0.0
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(13.dp)
                                        .padding(horizontal = 2.dp)
                                ) {
                                    Box {
                                        Spacer(
                                            modifier = Modifier
                                                .fillMaxWidth(compareRatio.toFloat().coerceAtMost(1f))
                                                .height(13.dp)
                                                .background(
                                                    color = RANKING_BLUE,
                                                    shape = RoundedCornerShape(
                                                        topEnd = 7.dp,
                                                        bottomEnd = 7.dp
                                                    )
                                                )
                                        )
                                        Text(
                                            text = "%.1f".format(compareScore),
                                            fontFamily = sarasaRegular,
                                            fontSize = 11.sp,
                                            color = Color.White.copy(alpha = 0.8f),
                                            overflow = TextOverflow.Visible,
                                            maxLines = 1,
                                            modifier = Modifier
                                                .align(Alignment.CenterEnd)
                                                .padding(end = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                    1 -> {
                        // 显示中位数和评价数
                        Box(
                            modifier = Modifier
                                .width(medianWidth)
                                .fillMaxHeight()
                                .background(
                                    if (team.medianScore > 0)
                                        Color(red = (team.medianScore / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                                    else
                                        Color.Transparent
                                )
                                .padding(horizontal = 4.dp),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(
                                text = "%.2f".format(team.medianScore),
                                fontFamily = sarasaBold,
                                fontSize = 16.sp,
                                color = Color.White,
                                textAlign = TextAlign.End
                            )
                        }
                        Text(
                            text = team.getFormattedImpressionCount(),
                            fontFamily = sarasaBold,
                            fontSize = 16.sp,
                            color = Color.White,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .width(extraWidth)
                                .padding(horizontal = 4.dp)
                        )
                    }
                }
            } else {
                // 宽屏模式：始终显示所有列
                // 总分条
                Column(
                    modifier = Modifier
                        .weight(0.4f)
                        .padding(top = 1.dp, start = 2.dp)
                ) {
                    // 主分数条
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .padding(horizontal = 2.dp)
                    ) {
                        Box {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth(scoreRatio.toFloat().coerceAtMost(1f))
                                    .height(20.dp)
                                    .background(
                                        color = RANKING_RED,
                                        shape = RoundedCornerShape(
                                            topEnd = 10.dp,
                                            bottomEnd = 10.dp
                                        )
                                    )
                            )
                            Text(
                                text = "%.2f".format(team.totalScore),
                                fontFamily = sarasaBold,
                                fontSize = 14.sp,
                                color = Color.White,
                                overflow = TextOverflow.Visible,
                                maxLines = 1,
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .padding(end = 4.dp)
                            )
                        }
                    }
                    
                    // 对比分数条（如果有对比数据）
                    team.compareTotalScore?.let { compareScore ->
                        val compareRatio = if (maxScore > 0) compareScore / maxScore else 0.0
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(13.dp)
                                .padding(horizontal = 2.dp)
                        ) {
                            Box {
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth(compareRatio.toFloat().coerceAtMost(1f))
                                        .height(13.dp)
                                        .background(
                                            color = RANKING_BLUE,
                                            shape = RoundedCornerShape(
                                                topEnd = 7.dp,
                                                bottomEnd = 7.dp
                                            )
                                        )
                                )
                                Text(
                                    text = "%.1f".format(compareScore),
                                    fontFamily = sarasaRegular,
                                    fontSize = 11.sp,
                                    color = Color.White.copy(alpha = 0.8f),
                                    overflow = TextOverflow.Visible,
                                    maxLines = 1,
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .padding(end = 2.dp)
                                )
                            }
                        }
                    }
                }
                
                // 中位数列
                Box(
                    modifier = Modifier
                        .width(medianWidth)
                        .fillMaxHeight()
                        .background(
                            if (team.medianScore > 0)
                                Color(red = (team.medianScore / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                            else
                                Color.Transparent
                        )
                        .padding(horizontal = 4.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "%.2f".format(team.medianScore),
                        fontFamily = sarasaBold,
                        fontSize = 16.sp,
                        color = Color.White,
                        textAlign = TextAlign.End
                    )
                }
                
                // 评价数列
                Text(
                    text = team.getFormattedImpressionCount(),
                    fontFamily = sarasaBold,
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .width(extraWidth)
                        .padding(horizontal = 4.dp)
                )
            }
        }
        
        // 团队作品详情行（始终显示）
        TeamWorksDetail(team = team)
    }
}

@Composable
private fun TeamWorksDetail(team: TeamRankingItem) {
    val works = listOf(
        Triple(team.title1, team.artist1, Triple(team.finalStriker1, team.score1, 1)),
        Triple(team.title2, team.artist2, Triple(team.finalStriker2, team.score2, 2)),
        Triple(team.title3, team.artist3, Triple(team.finalStriker3, team.score3, 3)),
        Triple(team.title4, team.artist4, Triple(team.finalStriker4, team.score4, 4))
    ).filter { it.first.isNotEmpty() }
    
    if (works.isEmpty()) return
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp)
    ) {
        works.forEach { (title, artist, workData) ->
            val (finalStriker, workScore, _) = workData
            TeamWorkRow(
                title = title,
                artist = artist,
                finalStriker = finalStriker,
                workScore = workScore
            )
        }
    }
}

@Composable
private fun TeamWorkRow(
    title: String,
    artist: String,
    finalStriker: String,
    workScore: Double
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 1.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 左侧：作品信息
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Final Striker 星标
            if (finalStriker == "1") {
                Icon(
                    imageVector = Fa.Star,
                    contentDescription = "Final Striker",
                    tint = RANKING_YELLOW,
                    modifier = Modifier.size(14.dp)
                )
            } else {
                Spacer(modifier = Modifier.size(14.dp))
            }
            
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "$title - $artist",
                fontFamily = sarasaRegular,
                fontSize = 12.sp,
                color = TEXT_GRAY,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
        }

        Text(
            text = "%.2f".format(workScore),
            fontFamily = sarasaBold,
            fontSize = 12.sp,
            color = TEXT_GRAY,
            textAlign = TextAlign.End,
            modifier = Modifier.width(70.dp)
        )
    }
}
