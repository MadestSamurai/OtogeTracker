package com.madsam.otora.ui.bof.sub

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.Clock
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.data.bof.local.repository.BofRepository
import com.madsam.otora.data.bof.local.repository.WorkRanking
import com.madsam.otora.ui.common.ColumnWidthType
import com.madsam.otora.ui.common.RankingTable
import com.madsam.otora.ui.common.RankingTableConfig
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BofTTTestScreen(
    repository: BofRepository,
    modifier: Modifier = Modifier,
    onTabRowVisibilityChange: (Boolean) -> Unit = {}
) {
    var ranking by remember { mutableStateOf<List<WorkRanking>>(emptyList()) }
    var worksCount by remember { mutableStateOf(0L) }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    
    // 屏幕宽度检测和切换状态
    val configuration = androidx.compose.ui.platform.LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val isNarrowScreen = screenWidthDp < 600 // 小于600dp认为是窄屏
    // 0: 只显示分数条, 1: 只显示三列
    var narrowMode by remember { mutableStateOf(0) }
    
    // 日期时间状态
    var selectedTimestamp by remember { mutableStateOf(System.currentTimeMillis()) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }
    
    val dateFormat = remember { SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()) }
    
    // 获取排行榜数据的函数
    val loadRanking = { timestamp: Long ->
        isLoading = true
        errorMessage = null
        try {
            worksCount = repository.getWorksCount()
            ranking = repository.getRankingAtTime(timestamp)
        } catch (e: Exception) {
            errorMessage = "获取数据失败: ${e.message}"
        } finally {
            isLoading = false
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 标题
        Text(
            text = "BOFTT数据库测试",
            fontSize = 24.sp,
            fontFamily = sarasaBold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 统计信息
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("数据统计", fontFamily = sarasaBold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("总作品数: $worksCount")
                Text("当前排行榜: ${ranking.size} 个作品")
                Text("查询时间: ${dateFormat.format(Date(selectedTimestamp))}")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 日期时间选择区域
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("时间选择", fontFamily = sarasaBold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // 日期选择按钮
                    OutlinedButton(
                        onClick = { showDatePicker = true },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(selectedTimestamp)))
                    }
                    
                    // 时间选择按钮
                    OutlinedButton(
                        onClick = { showTimePicker = true },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            imageVector = Fa.Clock,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(selectedTimestamp)))
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // 快捷时间按钮
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextButton(
                        onClick = { 
                            selectedTimestamp = System.currentTimeMillis()
                            loadRanking(selectedTimestamp)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("现在", fontSize = 12.sp)
                    }
                    TextButton(
                        onClick = { 
                            selectedTimestamp = System.currentTimeMillis() - 24 * 60 * 60 * 1000
                            loadRanking(selectedTimestamp)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("昨天", fontSize = 12.sp)
                    }
                    TextButton(
                        onClick = { 
                            selectedTimestamp = System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000
                            loadRanking(selectedTimestamp)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("一周前", fontSize = 12.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 操作按钮
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { loadRanking(selectedTimestamp) },
                enabled = !isLoading,
                modifier = Modifier.weight(1f)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("查询排行榜")
                }
            }

            if (isNarrowScreen) {
                OutlinedButton(
                    onClick = { narrowMode = (narrowMode + 1) % 2 },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        when (narrowMode) {
                            0 -> "只看评价/均分/中位值"
                            else -> "只看分数条"
                        }
                    )
                }
            }

            OutlinedButton(
                onClick = {
                    repository.clearAll()
                    worksCount = 0
                    ranking = emptyList()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("清空数据")
            }
        }

        // 错误信息
        errorMessage?.let { error ->
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = error,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 排行榜列表
        if (ranking.isNotEmpty()) {
            val config = RankingTableConfig(
                title = "总分排行榜",
                subtitle = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date(selectedTimestamp)) + " (${ranking.size} 作品)",
                scoreColumnName = "分数条",
                extraColumnName = "评价数",
                avgColumnName = "均分", 
                medianColumnName = "中位值",
                scoreWidthType = ColumnWidthType.THREE_DIGIT_INT,
                extraWidthType = ColumnWidthType.THREE_DIGIT_INT,
                avgWidthType = ColumnWidthType.TWO_DECIMAL,
                medianWidthType = ColumnWidthType.ONE_DECIMAL,
                enableNarrowToggle = true,
                maxItems = 500
            )
            
            RankingTable(
                items = ranking.map { it.toRankingItem() },
                config = config,
                narrowMode = narrowMode
            )
        } else if (!isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "暂无数据\n请先下载数据，然后选择时间查询排行榜",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }

    // 日期选择器 (使用简化版本，实际项目中可以使用Material3的DatePicker)
    if (showDatePicker) {
        DatePickerDialog(
            currentTimestamp = selectedTimestamp,
            onDateSelected = { newTimestamp ->
                selectedTimestamp = newTimestamp
                showDatePicker = false
                loadRanking(selectedTimestamp)
            },
            onDismiss = { showDatePicker = false }
        )
    }

    // 时间选择器
    if (showTimePicker) {
        TimePickerDialog(
            currentTimestamp = selectedTimestamp,
            onTimeSelected = { newTimestamp ->
                selectedTimestamp = newTimestamp
                showTimePicker = false
                loadRanking(selectedTimestamp)
            },
            onDismiss = { showTimePicker = false }
        )
    }
}

@Composable
private fun DatePickerDialog(
    currentTimestamp: Long,
    onDateSelected: (Long) -> Unit,
    onDismiss: () -> Unit
) {
    val calendar = Calendar.getInstance().apply { timeInMillis = currentTimestamp }
    var selectedYear by remember { mutableStateOf(calendar.get(Calendar.YEAR)) }
    var selectedMonth by remember { mutableStateOf(calendar.get(Calendar.MONTH)) }
    var selectedDay by remember { mutableStateOf(calendar.get(Calendar.DAY_OF_MONTH)) }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("选择日期") },
        text = {
            Column {
                Text("年: $selectedYear")
                Slider(
                    value = selectedYear.toFloat(),
                    onValueChange = { selectedYear = it.toInt() },
                    valueRange = 2024f..2025f,
                    steps = 0
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text("月: ${selectedMonth + 1}")
                Slider(
                    value = selectedMonth.toFloat(),
                    onValueChange = { selectedMonth = it.toInt() },
                    valueRange = 0f..11f,
                    steps = 10
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text("日: $selectedDay")
                Slider(
                    value = selectedDay.toFloat(),
                    onValueChange = { selectedDay = it.toInt() },
                    valueRange = 1f..31f,
                    steps = 29
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                val newCalendar = Calendar.getInstance()
                newCalendar.set(selectedYear, selectedMonth, selectedDay,
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND))
                onDateSelected(newCalendar.timeInMillis)
            }) {
                Text("确定")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}

@Composable
private fun TimePickerDialog(
    currentTimestamp: Long,
    onTimeSelected: (Long) -> Unit,
    onDismiss: () -> Unit
) {
    val calendar = Calendar.getInstance().apply { timeInMillis = currentTimestamp }
    var selectedHour by remember { mutableStateOf(calendar.get(Calendar.HOUR_OF_DAY)) }
    var selectedMinute by remember { mutableStateOf(calendar.get(Calendar.MINUTE)) }
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("选择时间") },
        text = {
            Column {
                Text("小时: $selectedHour")
                Slider(
                    value = selectedHour.toFloat(),
                    onValueChange = { selectedHour = it.toInt() },
                    valueRange = 0f..23f,
                    steps = 22
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text("分钟: $selectedMinute")
                Slider(
                    value = selectedMinute.toFloat(),
                    onValueChange = { selectedMinute = it.toInt() },
                    valueRange = 0f..59f,
                    steps = 58
                )
            }
        },
        confirmButton = {
            TextButton(onClick = {
                val newCalendar = Calendar.getInstance()
                newCalendar.timeInMillis = currentTimestamp
                newCalendar.set(Calendar.HOUR_OF_DAY, selectedHour)
                newCalendar.set(Calendar.MINUTE, selectedMinute)
                newCalendar.set(Calendar.SECOND, 0)
                onTimeSelected(newCalendar.timeInMillis)
            }) {
                Text("确定")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("取消")
            }
        }
    )
}
