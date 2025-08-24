package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.madsam.otora.BofScreenState
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.common.ColumnWidthType
import com.madsam.otora.ui.common.RankingTable
import com.madsam.otora.ui.common.RankingTableConfig

/**
 * 综合分数排行页面 - 使用新的架构和RankingTable组件
 * 综合分数 = 总分 * 7% + 中位数 * 80% + 平均分 * 13%
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BofCompositeNewScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    narrowMode: Int = 0,
    modifier: Modifier = Modifier
) {
    // 收集状态
    val ranking by vm.compositeRankingData.collectAsStateWithLifecycle()
    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
    val minImpression by vm.compositeMinImpression.collectAsStateWithLifecycle()
    val errorMessage by vm.errorMessage.collectAsStateWithLifecycle()
    
    // 初始化数据加载
    LaunchedEffect(Unit) {
        vm.generateCompositeRanking()
    }
    
    Box(modifier = modifier.fillMaxSize()) {
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
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.error
                    )
                    Text(
                        text = errorMessage,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Button(
                        onClick = { vm.loadRankingDataWithStreamedParsing() },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("重试")
                    }
                }
            }
            
            ranking.isEmpty() -> {
                Text(
                    text = "暂无数据\n请调整过滤条件或选择其他时间",
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            else -> {
                RankingTable(
                    items = ranking.map { it.toCompositeRankingItem() },
                    config = RankingTableConfig(
                        title = "综合分数排行榜",
                        subtitle = "BOF 综合分数排行榜 (${ranking.size} 作品，评价≥${minImpression}) | ${vm.getSelectedTimeString()}",
                        scoreColumnName = "综合",
                        extraColumnName = "评价",
                        avgColumnName = "平均", // 显示平均分列
                        medianColumnName = "中位数", // 显示中位数列
                        scoreWidthType = ColumnWidthType.TWO_DECIMAL,
                        extraWidthType = ColumnWidthType.TWO_DECIMAL,
                        avgWidthType = ColumnWidthType.TWO_DECIMAL,
                        medianWidthType = ColumnWidthType.ONE_DECIMAL,
                        enableNarrowToggle = true,
                        allowNegativeScore = false,
                        maxItems = 500
                    )
                )
            }
        }
    }
}
