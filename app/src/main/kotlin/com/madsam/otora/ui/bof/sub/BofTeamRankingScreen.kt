package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.BG_DARK_GRAY
import com.madsam.otora.core.theme.RANKING_RED
import com.madsam.otora.core.theme.RANKING_YELLOW
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.bof.TeamRankingItem

@Composable
internal fun BofTeamRankingScreen(
    bofScreenState: BofScreenState,
    vm: BofViewModel = viewModel()
) {
    val teamRankingData by vm.teamRankingData.collectAsState()
    val isLoading by vm.isTeamRankingLoading.collectAsState()
    val errorMessage by vm.teamRankingError.collectAsState()
    val selectedRange by bofScreenState.selectedRange.collectAsState()
    
    val listState = rememberLazyListState()
    
    // 在比赛选择变化时重新加载数据
    LaunchedEffect(selectedRange) {
        selectedRange?.let { range ->
            vm.loadTeamRankingData(range.path)
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
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
                                selectedRange?.let { range ->
                                    vm.loadTeamRankingData(range.path)
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
                TeamRankingTable(
                    teams = teamRankingData,
                    listState = listState
                )
            }
        }
    }
}

@Composable
private fun TeamRankingTable(
    teams: List<TeamRankingItem>,
    listState: androidx.compose.foundation.lazy.LazyListState
) {
    val maxScore = teams.maxOfOrNull { it.totalScore } ?: 1.0
    
    Column {
        // 表格标题
        Text(
            text = "团队总分排行榜",
            fontFamily = sarasaBold,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(vertical = 8.dp)
        )

        // 表格头部
        TeamTableHeader()

        // 数据列表
        LazyColumn(
            state = listState,
            modifier = Modifier.clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
        ) {
            itemsIndexed(teams) { index, team ->
                TeamRankingRow(
                    team = team,
                    index = index,
                    maxScore = maxScore
                )
            }
        }
    }
}

@Composable
private fun TeamTableHeader() {
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
            modifier = Modifier.width(60.dp)
        )
        
        Text(
            text = "团队",
            fontFamily = sarasaBold,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.weight(0.4f)
        )
        
        Text(
            text = "总分",
            fontFamily = sarasaBold,
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.3f)
        )
        
        Text(
            text = "平均分",
            fontFamily = sarasaBold,
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier.width(70.dp)
        )
        
        Text(
            text = "评价数",
            fontFamily = sarasaBold,
            fontSize = 14.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier.width(60.dp)
        )
    }
}

@Composable
private fun TeamRankingRow(
    team: TeamRankingItem,
    index: Int,
    maxScore: Double
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val scoreRatio = if (maxScore > 0) team.totalScore / maxScore else 0.0

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(4.dp)
    ) {
        // 主要排名行
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 排名列（包含排名变化指示器）
            TeamRankColumn(team = team)
            
            // 团队名称列
            Text(
                text = team.teamName,
                fontFamily = sarasaBold,
                fontSize = 16.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(0.4f)
                    .padding(horizontal = 4.dp)
            )
            
            // 总分条形图列
            TeamScoreBar(
                score = team.totalScore,
                scoreRatio = scoreRatio.toFloat(),
                modifier = Modifier.weight(0.3f)
            )
            
            // 平均分列
            Text(
                text = team.getFormattedAverageScore(),
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier.width(70.dp)
            )
            
            // 评价数列
            Text(
                text = team.getFormattedImpressionCount(),
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier.width(60.dp)
            )
        }
        
        // 团队作品详情
        TeamWorksDetail(team = team)
    }
}

@Composable
private fun TeamRankColumn(team: TeamRankingItem) {
    Column(
        modifier = Modifier
            .width(60.dp)
            .padding(horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 排名变化指示器
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val change = team.rankChange
            when {
                change != null && change > 0 -> {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "排名上升",
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
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "排名下降",
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
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "排名持平",
                        tint = Color.Gray,
                        modifier = Modifier.size(12.dp)
                    )
                }
                team.isNewTeam -> {
                    Text(
                        text = "NEW",
                        fontFamily = sarasaRegular,
                        fontSize = 10.sp,
                        color = RANKING_YELLOW
                    )
                }
            }
        }
        
        // 当前排名
        Text(
            text = team.rank.toString(),
            fontFamily = sarasaBold,
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun TeamScoreBar(
    score: Double,
    scoreRatio: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(horizontal = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .background(
                    color = Color.Gray.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(12.dp)
                )
        )
        
        Box(
            modifier = Modifier
                .fillMaxWidth(scoreRatio.coerceAtMost(1f))
                .height(24.dp)
                .background(
                    color = RANKING_RED,
                    shape = RoundedCornerShape(12.dp)
                )
        )
        
        Text(
            text = "%.2f".format(score),
            fontFamily = sarasaBold,
            fontSize = 13.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
        )
    }
}

@Composable
private fun TeamWorksDetail(team: TeamRankingItem) {
    val works = listOf(
        Triple(team.title1, team.artist1, team.finalStriker1),
        Triple(team.title2, team.artist2, team.finalStriker2),
        Triple(team.title3, team.artist3, team.finalStriker3),
        Triple(team.title4, team.artist4, team.finalStriker4)
    ).filter { it.first.isNotEmpty() }
    
    if (works.isEmpty()) return
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 64.dp, top = 4.dp)
    ) {
        works.forEach { (title, artist, finalStriker) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 2.dp)
            ) {
                // Final Striker 星标
                if (finalStriker == "1") {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Final Striker",
                        tint = RANKING_YELLOW,
                        modifier = Modifier.size(14.dp)
                    )
                } else {
                    Spacer(modifier = Modifier.size(14.dp))
                }
                
                Spacer(modifier = Modifier.width(4.dp))
                
                // 作品信息
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
        }
    }
}
