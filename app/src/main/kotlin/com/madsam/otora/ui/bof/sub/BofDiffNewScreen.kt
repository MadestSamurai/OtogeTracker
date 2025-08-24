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
internal fun BofDiffNewScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    narrowMode: Int = 0,
    modifier: Modifier = Modifier
) {
    // 收集状态
    val ranking by vm.diffRankingData.collectAsStateWithLifecycle()
    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
    val errorMessage by vm.errorMessage.collectAsStateWithLifecycle()
    
    // 加载数据
    LaunchedEffect(
        bofScreenState.selectedCurrentDate.collectAsState().value,
        bofScreenState.selectedCurrentTime.collectAsState().value,
        bofScreenState.selectedCompareDate.collectAsState().value,
        bofScreenState.selectedCompareTime.collectAsState().value
    ) {
        vm.loadDifferenceRankingData()
    }
    
    // 内容区域
    Box(
        modifier = modifier.fillMaxSize()
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
                        onClick = { vm.loadDifferenceRankingData() },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("重试")
                    }
                }
            }
            
            ranking.isEmpty() -> {
                Text(
                    text = "暂无数据\n请选择不同的时间进行对比",
                    fontFamily = sarasaRegular,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            else -> {
                RankingTable(
                    items = ranking.map { it.toDifferenceRankingItem() },
                    config = RankingTableConfig(
                        title = "分数差值排行榜",
                        subtitle = "BOF 分数差值排行榜 (${ranking.size} 作品) | ${vm.getSelectedTimeString()}",
                        scoreColumnName = "分差",
                        extraColumnName = "评价差",
                        avgColumnName = null, // 不显示额外的平均分列
                        medianColumnName = null, // 不显示中位数列
                        scoreWidthType = ColumnWidthType.THREE_DIGIT_INT, // 分数差值用三位整数
                        extraWidthType = ColumnWidthType.THREE_DIGIT_INT, // 评价差值用三位整数
                        avgWidthType = ColumnWidthType.TWO_DECIMAL,
                        medianWidthType = ColumnWidthType.ONE_DECIMAL,
                        enableNarrowToggle = false,
                        maxItems = 500,
                        allowNegativeScore = true // 允许显示负数分数差值
                    ),
                    narrowMode = narrowMode,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
