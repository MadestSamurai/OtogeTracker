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
internal fun BofAvgNewScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    narrowMode: Int = 0
) {
    // 收集状态
    val ranking by vm.avgRankingData.collectAsStateWithLifecycle()
    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
    val errorMessage by vm.errorMessage.collectAsStateWithLifecycle()
    
    // 使用固定的最低评价数过滤
    val minImpression = 1
    
    // 监听最低评价数变化，更新ViewModel中的过滤条件
    LaunchedEffect(minImpression) {
        vm.updateAverageMinImpression(minImpression)
    }
    
    // 内容区域
    Box(
        modifier = Modifier.fillMaxSize()
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
                    fontFamily = sarasaRegular,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            
            else -> {
                RankingTable(
                    items = ranking.map { it.toAverageRankingItem() },
                    config = RankingTableConfig(
                        title = "平均分排行榜",
                        subtitle = "BOF 平均分排行榜 (${ranking.size} 作品，评价≥${minImpression}) | ${vm.getSelectedTimeString()}",
                        scoreColumnName = "均分",
                        extraColumnName = "评价",
                        avgColumnName = null, // 不显示额外的平均分列
                        medianColumnName = null, // 不显示中位数列
                        scoreWidthType = ColumnWidthType.TWO_DECIMAL, // 平均分用两位小数
                        extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                        avgWidthType = ColumnWidthType.TWO_DECIMAL,
                        medianWidthType = ColumnWidthType.ONE_DECIMAL,
                        enableNarrowToggle = false,
                        maxItems = 500
                    ),
                    narrowMode = narrowMode
                )
            }
        }
    }
}
