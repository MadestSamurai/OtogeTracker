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
import androidx.compose.ui.platform.LocalConfiguration
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.ui.bof.components.DateTimeRangePicker
import com.madsam.otora.ui.common.RankingTable
import com.madsam.otora.ui.common.RankingTableConfig
import com.madsam.otora.ui.common.ColumnWidthType
import kotlinx.coroutines.flow.asStateFlow

@Composable
internal fun BofTotalNewScreen(
    vm: BofViewModel,
    bofScreenState: BofScreenState,
    modifier: Modifier = Modifier
) {
    // 收集状态
    val ranking by vm.totalRankingData.collectAsStateWithLifecycle()
    val isLoading by vm.isLoading.collectAsStateWithLifecycle()
    val errorMessage by vm.errorMessage.collectAsStateWithLifecycle()
    val selectedTimeStr by vm.selectedTimeStr.asStateFlow().collectAsState()
    
    // 日期选择器状态
    var showDatePicker by remember { mutableStateOf(false) }
    
    // 窄屏模式状态 (0: 显示分数条, 1: 显示评价数/平均分/中位值)
    var narrowMode by remember { mutableStateOf(0) }
    
    // 屏幕宽度检测
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val isNarrowScreen = screenWidthDp < 600 // 小于600dp认为是窄屏
    
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // 顶部时间选择区域
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "选择时间范围",
                        fontFamily = sarasaBold,
                        fontSize = 16.sp
                    )
                    
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // 窄屏切换按钮
                        if (isNarrowScreen) {
                            OutlinedButton(
                                onClick = { narrowMode = (narrowMode + 1) % 2 }
                            ) {
                                Text(
                                    text = when (narrowMode) {
                                        0 -> "只看评价/均分/中位值"
                                        else -> "只看分数条"
                                    },
                                    fontFamily = sarasaRegular,
                                    fontSize = 12.sp
                                )
                            }
                        }
                        
                        // 时间选择按钮
                        Button(
                            onClick = { showDatePicker = true }
                        ) {
                            Text(
                                text = "选择时间",
                                fontFamily = sarasaRegular
                            )
                        }
                    }
                }
                
                if (selectedTimeStr.isNotEmpty()) {
                    Text(
                        text = "当前时间: $selectedTimeStr",
                        fontFamily = sarasaRegular,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
        
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
                            subtitle = "BOF 总分排行榜 (${ranking.size} 作品)",
                            scoreColumnName = "分数条",
                            extraColumnName = "评价",
                            avgColumnName = "均分",
                            medianColumnName = "中位",
                            scoreWidthType = ColumnWidthType.THREE_DIGIT_INT,
                            extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                            avgWidthType = ColumnWidthType.TWO_DECIMAL,
                            medianWidthType = ColumnWidthType.ONE_DECIMAL,
                            enableNarrowToggle = true, // 启用窄屏切换功能
                            maxItems = 500
                        ),
                        narrowMode = narrowMode, // 传入外部控制的状态
                        // 外部按钮和内部逻辑的状态同步
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
    
    // 日期选择器弹窗
    if (showDatePicker) {
        DateTimeRangePicker(
            bofScreenState = bofScreenState,
            onDismissRequest = { 
                showDatePicker = false
                vm.loadRankingData()
            }
        )
    }
}
