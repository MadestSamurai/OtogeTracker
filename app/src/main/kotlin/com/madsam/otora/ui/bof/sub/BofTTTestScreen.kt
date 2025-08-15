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
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.fa.Clock
import com.madsam.otora.core.theme.BG_DARK_GRAY
import com.madsam.otora.core.theme.RANKING_RED
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.data.bof.local.repository.BofRepository
import com.madsam.otora.data.bof.local.repository.WorkRanking
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
    var showDetailedView by remember { mutableStateOf(!isNarrowScreen) }
    
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
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 统计信息
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text("数据统计", fontWeight = FontWeight.Medium, fontSize = 18.sp)
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
                Text("时间选择", fontWeight = FontWeight.Medium, fontSize = 18.sp)
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
                    onClick = { showDetailedView = !showDetailedView },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(if (showDetailedView) "简化显示" else "详细显示")
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
            // 测量Text组件的精确宽度
            var impressionWidth by remember { mutableStateOf(50.dp) }
            var avgScoreWidth by remember { mutableStateOf(60.dp) }
            var medianScoreWidth by remember { mutableStateOf(60.dp) }
            
            val density = LocalDensity.current
            
            // 隐藏的测量容器
            Box(modifier = Modifier
                .size(0.dp)
                .requiredHeight(100.dp)
                .requiredWidth(500.dp)
            ) {
                // 测量评价数宽度
                Text(
                    text = "000",
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        impressionWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp // 加点padding
                        }
                    }
                )
                // 测量均分宽度
                Text(
                    text = "000.00",
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        avgScoreWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
                // 测量中位数宽度
                Text(
                    text = "000.00",
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        medianScoreWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
            }
            
            Column {
                // 表格标题
                Text(
                    text = "时间点排行榜",
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(vertical = 8.dp)
                )

                Text(
                    text = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date(selectedTimestamp)) + " (${ranking.size} 作品)",
                    fontFamily = sarasaRegular,
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                )

                // 表格头部
                Row(
                    modifier = Modifier
                        .background(BG_DARK_GRAY)
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                ) {
                    Text(
                        text = "排名",
                        fontFamily = sarasaRegular,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(50.dp)
                    )
                    Text(
                        text = "",
                        modifier = Modifier.weight(0.4f) // 作品信息区域占40%
                    )
                    Text(
                        text = "分数条",
                        fontFamily = sarasaRegular,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(if (isNarrowScreen && !showDetailedView) 1f else 0.6f) // 窄屏简化模式占更多空间
                    )
                    if (!isNarrowScreen || showDetailedView) {
                        Text(
                            text = "评价数",
                            fontFamily = sarasaRegular,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(impressionWidth)
                        )
                        Text(
                            text = "均分",
                            fontFamily = sarasaRegular,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(avgScoreWidth)
                        )
                        Text(
                            text = "中位值",
                            fontFamily = sarasaRegular,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(medianScoreWidth)
                        )
                    }
                }

                // 数据列表
                LazyColumn(
                    modifier = Modifier
                        .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                ) {
                    itemsIndexed(ranking.take(50)) { index, work ->
                        RankingTableRow(
                            work = work,
                            index = index,
                            maxScore = ranking.maxOfOrNull { it.score.toDouble() } ?: 1.0,
                            isNarrowScreen = isNarrowScreen,
                            showDetailedView = showDetailedView,
                            impressionWidth = impressionWidth,
                            avgScoreWidth = avgScoreWidth,
                            medianScoreWidth = medianScoreWidth
                        )
                    }
                    
                    if (ranking.size > 50) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(if (50 % 2 == 0) BG_DARK_GRAY else Color.Black)
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "还有 ${ranking.size - 50} 个作品...",
                                    fontFamily = sarasaRegular,
                                    color = TEXT_GRAY,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
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
private fun RankingTableRow(
    work: WorkRanking, 
    index: Int, 
    maxScore: Double, 
    isNarrowScreen: Boolean, 
    showDetailedView: Boolean,
    impressionWidth: Dp,
    avgScoreWidth: Dp,
    medianScoreWidth: Dp
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    
    // 计算分数条的宽度比例
    val scoreRatio = if (maxScore > 0) work.score.toDouble() / maxScore else 0.0
    
    // 根据排名确定颜色 - 排名文字统一使用白色
    val rankColor = Color.White

    // 直接使用 WorkRanking 的字段
    val avgScore = work.average
    val medianScore = work.median

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 排名列（固定宽度）
        Text(
            text = work.rank.toString(),
            fontFamily = sarasaRegular,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = rankColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(50.dp)
                .padding(vertical = 4.dp)
        )

        // 作品信息列（占60%宽度，右对齐）
        Column(
            modifier = Modifier
                .weight(0.6f)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = work.title,
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = work.artist,
                fontFamily = sarasaRegular,
                fontSize = 12.sp,
                color = TEXT_GRAY,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // 分数条列（根据屏幕模式调整宽度）
        Box(
            modifier = Modifier
                .weight(if (isNarrowScreen && !showDetailedView) 1f else 0.4f)
                .padding(horizontal = 4.dp)
                .height(20.dp)
        ) {
            // 在窄屏简化模式下，根据其他三列的实际测量宽度来调整分数条宽度
            val adjustedScoreRatio = if (isNarrowScreen && !showDetailedView) {
                // 使用实际测量的宽度：impressionWidth + avgScoreWidth + medianScoreWidth
                // 根据这些实际宽度调整分数条的显示比例
                scoreRatio * 0.85f // 预留一些空间以确保布局稳定
            } else {
                scoreRatio
            }

            Box {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth(adjustedScoreRatio.toFloat().coerceAtMost(1f))
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
                    text = work.score.toString(),
                    fontFamily = sarasaRegular,
                    fontWeight = FontWeight.Bold,
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

        // 条件显示详细信息列
        if (!isNarrowScreen || showDetailedView) {
            // 评价数列（固定宽度，基于"000"宽度计算）
            Text(
                text = if (work.impression > 0) work.impression.toString() else "---",
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(impressionWidth)
                    .padding(vertical = 4.dp)
            )

            // 均分列（固定宽度，显示a值）
            Text(
                text = if (avgScore > 0) String.format("%.1f", avgScore) else "---",
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(avgScoreWidth)
                    .background(
                        if (avgScore > 0) 
                            Color(red = (avgScore / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                        else 
                            Color.Transparent
                    )
                    .padding(vertical = 4.dp)
            )

            // 中位值列（固定宽度，显示m值）
            Text(
                text = if (medianScore > 0) String.format("%.1f", medianScore) else "---",
                fontFamily = sarasaRegular,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(medianScoreWidth)
                    .background(
                        if (medianScore > 0) 
                            Color(red = (medianScore / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                        else 
                            Color.Transparent
                    )
                    .padding(vertical = 4.dp)
            )
        }
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
