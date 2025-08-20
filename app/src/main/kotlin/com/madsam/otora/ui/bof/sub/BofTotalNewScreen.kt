package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.common.RankingTable
import com.madsam.otora.ui.common.RankingTableConfig
import com.madsam.otora.ui.common.ColumnWidthType

@Composable
internal fun BofTotalNewScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    narrowMode: Int = 0
) {
    // 收集状态
    val ranking by vm.totalRankingData.collectAsStateWithLifecycle()
    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
    val errorMessage by vm.errorMessage.collectAsStateWithLifecycle()
    
    // 监听时间变化，异步刷新数据
    LaunchedEffect(bofScreenState.selectedCurrentDate.collectAsState().value, 
                   bofScreenState.selectedCurrentTime.collectAsState().value) {
        vm.loadRankingDataAsync()
    }
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 内容区域
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                errorMessage.isNotEmpty() -> {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "加载失败",
                            fontFamily = sarasaBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.error
                        )
                        Text(
                            text = errorMessage,
                            fontFamily = sarasaRegular,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Button(
                            onClick = { vm.refreshData() },
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Text("重试")
                        }
                    }
                }
                
                ranking.isEmpty() -> {
                    Text(
                        text = "暂无数据\n请选择时间范围",
                        fontFamily = sarasaRegular,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                else -> {
                    RankingTable(
                        items = ranking.toRankingItems(),
                        config = RankingTableConfig(
                            title = "总分排行榜",
                            subtitle = "BOF 总分排行榜 (${ranking.size} 作品) | ${vm.getSelectedTimeString()}",
                            scoreColumnName = "分数条",
                            extraColumnName = "评价",
                            avgColumnName = "均分",
                            medianColumnName = "中位",
                            scoreWidthType = ColumnWidthType.THREE_DIGIT_INT,
                            extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                            avgWidthType = ColumnWidthType.TWO_DECIMAL,
                            medianWidthType = ColumnWidthType.ONE_DECIMAL,
                            enableNarrowToggle = true,
                            maxItems = 500
                        ),
                        narrowMode = narrowMode, // 传入外部控制的状态
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
