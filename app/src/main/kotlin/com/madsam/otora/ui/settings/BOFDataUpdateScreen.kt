package com.madsam.otora.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.RANKING_GREEN
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.theme.sarasaSemiBold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BOFDataUpdateScreen(
    onNavigateBack: () -> Unit,
    viewModel: BOFDataUpdateViewModel = viewModel(factory = BOFDataUpdateViewModelFactory())
) {
    val uiState by viewModel.uiState.collectAsState()
    
    // 页面加载时获取统计信息
    LaunchedEffect(Unit) {
        viewModel.getDataStatistics()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Red300)
    ) {
        // 顶栏
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "BOF 数据更新",
                    fontFamily = sarasaBold,
                    color = Beige400
                )
            },
            navigationIcon = {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "返回",
                        tint = Beige400,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { viewModel.loadAvailableCompetitions() },
                    enabled = !uiState.isLoadingCompetitions
                ) {
                    if (uiState.isLoadingCompetitions) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp,
                            color = Beige400
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "刷新比赛列表",
                            tint = Beige400,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Red500,
                titleContentColor = Beige400,
                navigationIconContentColor = Beige400
            )
        )
        
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 页面说明
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Red500),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "BOF 活动数据",
                            color = White1000,
                            fontSize = 18.sp,
                            fontFamily = sarasaBold,
                            textAlign = TextAlign.Center
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "BOF (BMS of Fighters) 是音游界的知名活动。\n根据数据库中的比赛信息显示可更新的数据列表。",
                            color = White1000.copy(alpha = 0.7f),
                            fontSize = 14.sp,
                            fontFamily = sarasaRegular,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            
            // 状态信息显示
            uiState.message?.let { message ->
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = if (uiState.isError) Red300 else RANKING_GREEN.copy(alpha = 0.1f)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = null,
                                tint = if (uiState.isError) White1000 else RANKING_GREEN,
                                modifier = Modifier.size(20.dp)
                            )
                            
                            Spacer(modifier = Modifier.width(8.dp))
                            
                            Text(
                                text = message,
                                color = if (uiState.isError) White1000 else White1000,
                                fontSize = 14.sp,
                                fontFamily = sarasaRegular
                            )
                        }
                    }
                }
            }
            
            // 统计按钮
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    OutlinedButton(
                        onClick = { 
                            viewModel.clearMessage()
                            viewModel.getDataStatistics() 
                        },
                        modifier = Modifier.weight(1f),
                        enabled = !uiState.isLoading,
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Beige400
                        )
                    ) {
                        Text(
                            "查看统计",
                            fontFamily = sarasaSemiBold,
                            fontSize = 14.sp
                        )
                    }
                    
                    OutlinedButton(
                        onClick = { 
                            viewModel.clearMessage()
                            viewModel.loadAvailableCompetitions()
                        },
                        modifier = Modifier.weight(1f),
                        enabled = !uiState.isLoadingCompetitions,
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Beige400
                        )
                    ) {
                        Text(
                            "刷新列表",
                            fontFamily = sarasaSemiBold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            
            // 比赛列表
            if (uiState.availableCompetitions.isNotEmpty()) {
                item {
                    Text(
                        text = "可用比赛 (${uiState.availableCompetitions.size})",
                        color = Beige400,
                        fontSize = 16.sp,
                        fontFamily = sarasaSemiBold,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
                
                items(uiState.availableCompetitions) { competition ->
                    CompetitionUpdateItem(
                        competition = competition,
                        onUpdateClick = { 
                            viewModel.clearMessage()
                            viewModel.downloadBofData(competition.path, competition.shortName)
                        },
                        isGlobalLoading = uiState.isLoading
                    )
                }
            } else if (!uiState.isLoadingCompetitions) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Red500),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "暂无可用比赛",
                                color = White1000.copy(alpha = 0.7f),
                                fontSize = 16.sp,
                                fontFamily = sarasaSemiBold,
                                textAlign = TextAlign.Center
                            )
                            
                            Spacer(modifier = Modifier.height(8.dp))
                            
                            Text(
                                text = "请先确保数据库中有 Range 数据，或者刷新比赛列表",
                                color = White1000.copy(alpha = 0.5f),
                                fontSize = 14.sp,
                                fontFamily = sarasaRegular,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CompetitionUpdateItem(
    competition: CompetitionUpdateItem,
    onUpdateClick: () -> Unit,
    isGlobalLoading: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Red500),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // 比赛标题行
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = competition.shortName,
                            color = White1000,
                            fontSize = 16.sp,
                            fontFamily = sarasaBold
                        )
                        
                        if (competition.isStart && !competition.isEnd) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "进行中",
                                color = RANKING_GREEN,
                                fontSize = 12.sp,
                                fontFamily = sarasaSemiBold,
                                modifier = Modifier
                                    .background(
                                        RANKING_GREEN.copy(alpha = 0.2f),
                                        RoundedCornerShape(4.dp)
                                    )
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                    
                    Text(
                        text = competition.fullName,
                        color = White1000.copy(alpha = 0.7f),
                        fontSize = 14.sp,
                        fontFamily = sarasaRegular
                    )
                }
                
                Button(
                    onClick = onUpdateClick,
                    enabled = !isGlobalLoading && !competition.isUpdating && competition.isStart,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (competition.isStart) Beige400 else White1000.copy(alpha = 0.3f),
                        contentColor = if (competition.isStart) Red500 else White1000.copy(alpha = 0.7f),
                        disabledContainerColor = White1000.copy(alpha = 0.3f),
                        disabledContentColor = White1000.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    if (competition.isUpdating) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(16.dp),
                            strokeWidth = 2.dp,
                            color = if (competition.isStart) Red500 else White1000.copy(alpha = 0.7f)
                        )
                    } else {
                        Text(
                            if (competition.isStart) "更新" else "未开始",
                            fontFamily = sarasaSemiBold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            
            // 数据统计行
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = if (competition.hasData) {
                        val dataParts = mutableListOf<String>()
                        if (competition.workCount > 0) dataParts.add("${competition.workCount}作品")
                        if (competition.teamCount > 0) dataParts.add("${competition.teamCount}团队")
                        "数据: ${dataParts.joinToString(" | ")}"
                    } else {
                        "无数据"
                    },
                    color = if (competition.hasData) Beige400 else White1000.copy(alpha = 0.5f),
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
                
                Text(
                    text = "更新: ${competition.lastUpdated}",
                    color = White1000.copy(alpha = 0.5f),
                    fontSize = 12.sp,
                    fontFamily = sarasaRegular
                )
            }
        }
    }
}
