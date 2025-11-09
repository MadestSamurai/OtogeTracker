package com.madsam.otora.ui.bof.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Black333
import com.madsam.otora.core.theme.PurpleTheme
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red800
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import com.vsnappy1.datepicker.DatePicker
import com.vsnappy1.datepicker.data.DefaultDatePickerConfig
import com.vsnappy1.datepicker.data.model.DatePickerDate
import com.vsnappy1.datepicker.data.model.SelectionLimiter
import com.vsnappy1.datepicker.ui.model.DatePickerConfiguration
import com.vsnappy1.timepicker.TimePicker
import com.vsnappy1.timepicker.data.model.TimePickerTime
import com.vsnappy1.timepicker.enums.MinuteGap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.util.Locale

@Composable
fun DateTimeRangePicker(
    bofScreenState: BofScreenState,
    rangeData: List<BofRangeResponse>,
    onDismissRequest: () -> Unit
) {
    val showCompareDatePicker = remember { MutableStateFlow(false) }
    val showCompareDatePickerState = showCompareDatePicker.collectAsState()
    val showCurrentDatePicker = remember { MutableStateFlow(false) }
    val showCurrentDatePickerState = showCurrentDatePicker.collectAsState()
    var showRangeDropdown by remember { mutableStateOf(false) }

    // 从 BofScreenState 获取当前选中的 Range
    val selectedRange by bofScreenState.selectedRange.collectAsState()
    
    // 解析 Range 的开始和结束日期
    val (fromDate, toDate) = remember(selectedRange) {
        try {
            if (selectedRange != null) {
                // 解析 start 日期字符串 (格式: "YYYY-MM-DD")
                val startParts = selectedRange!!.start.split("-")
                val startYear = startParts[0].toInt()
                val startMonth = startParts[1].toInt() - 1 // DatePicker month 是 0-based
                val startDay = startParts[2].toInt()
                
                // 对于正在进行的活动(isStart=true, isEnd=false)，只考虑起点
                // 对于已结束的活动，使用current作为终点
                val endDate = if (selectedRange!!.isStart && !selectedRange!!.isEnd) {
                    // 正在进行中：使用start作为起点，不限制终点（使用当前日期）
                    val today = LocalDate.now()
                    DatePickerDate(today.year, today.monthValue - 1, today.dayOfMonth)
                } else {
                    // 已结束或未开始：使用current作为终点
                    val currentParts = selectedRange!!.current.split("-")
                    val currentYear = currentParts[0].toInt()
                    val currentMonth = currentParts[1].toInt() - 1 // DatePicker month 是 0-based
                    val currentDay = currentParts[2].toInt()
                    DatePickerDate(currentYear, currentMonth, currentDay)
                }
                
                DatePickerDate(startYear, startMonth, startDay) to endDate
            } else {
                // 如果没有选中 Range，使用默认值
                DatePickerDate(2024, 9, 18) to DatePickerDate(2025, 0, 8)
            }
        } catch (e: Exception) {
            // 解析失败时使用默认值
            Log.e("DateTimeRangePicker", "Failed to parse date range: ${e.message}", e)
            DatePickerDate(2024, 9, 18) to DatePickerDate(2025, 0, 8)
        }
    }

    // 从 bofScreenState 读取当前选择的日期和时间作为初始值
    val currentSelectedDate = bofScreenState.selectedCurrentDate.collectAsState().value
    val currentSelectedTime = bofScreenState.selectedCurrentTime.collectAsState().value
    val compareSelectedDate = bofScreenState.selectedCompareDate.collectAsState().value
    val compareSelectedTime = bofScreenState.selectedCompareTime.collectAsState().value
    
    // 初始化状态
    var currentDateState by remember { 
        mutableStateOf(DatePickerDate(
            currentSelectedDate.year,
            currentSelectedDate.monthValue - 1,
            currentSelectedDate.dayOfMonth
        ))
    }
    var currentTimeState by remember {
        val timeParts = currentSelectedTime.split(":")
        mutableStateOf(TimePickerTime(
            timeParts.getOrNull(0)?.toIntOrNull() ?: 0,
            timeParts.getOrNull(1)?.toIntOrNull() ?: 0
        ))
    }

    var compareDateState by remember { 
        mutableStateOf(DatePickerDate(
            compareSelectedDate.year,
            compareSelectedDate.monthValue - 1,
            compareSelectedDate.dayOfMonth
        ))
    }
    var compareTimeState by remember {
        val timeParts = compareSelectedTime.split(":")
        mutableStateOf(TimePickerTime(
            timeParts.getOrNull(0)?.toIntOrNull() ?: 0,
            timeParts.getOrNull(1)?.toIntOrNull() ?: 0
        ))
    }

    var currentDateText by remember { mutableStateOf(currentSelectedDate) }
    var currentTimeText by remember { mutableStateOf(currentSelectedTime) }
    var compareDateText by remember { mutableStateOf(compareSelectedDate) }
    var compareTimeText by remember { mutableStateOf(compareSelectedTime) }

    if (showCurrentDatePickerState.value) {
        AlertDialog(
            onDismissRequest = { showCurrentDatePicker.update { false } },
            dismissButton = {
                TextButton(onClick = { showCurrentDatePicker.update { false } }) {
                    Text("Cancel")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    currentDateText = LocalDate.of(
                        currentDateState.year,
                        currentDateState.month+1,
                        currentDateState.day
                    )
                    currentTimeText = String.format(
                        Locale.getDefault(), "%02d:%02d",
                        currentTimeState.hour, currentTimeState.minute
                    )
                    showCurrentDatePicker.update { false }
                }) {
                    Text("OK")
                }
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
            ),
            modifier = Modifier.fillMaxWidth(0.95f),
            text = {
                Row {
                    DatePicker(
                        onDateSelected = { year, month, day ->
                            if (year * (month+1) * day != 0)
                                currentDateState = DatePickerDate(year, month, day)
                        },
                        date = currentDateState,
                        selectionLimiter = SelectionLimiter(
                            fromDate = fromDate,
                            toDate = toDate
                        ),
                        configuration = DatePickerConfiguration.Builder()
                            .headerTextStyle(TextStyle.Default.copy(fontSize = 20.sp))
                            .headerHeight(50.dp)
                            .sundayTextColor(PurpleTheme)
                            .dateTextStyle(DefaultDatePickerConfig.dateTextStyle.copy(color = Black333))
                            .selectedDateTextStyle(textStyle = TextStyle(White1000))
                            .selectedDateBackgroundColor(PurpleTheme)
                            .build(),
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .fillMaxWidth(0.7f)
                            .scale(0.9f)
                    )
                    Column (
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .scale(0.9f)
                    ) {
                        Row (
                            modifier = Modifier
                                .height(50.dp)
                                .align(Alignment.CenterHorizontally)
                        ){
                            Text(
                                text = "Time",
                                style = TextStyle.Default.copy(fontSize = 20.sp),
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                        TimePicker(
                            onTimeSelected = { hour, minute ->
                                currentTimeState = TimePickerTime(hour, minute)

                            },
                            minuteGap = MinuteGap.FIVE,
                            time = currentTimeState
                        )
                    }
                }
            }
        )
    }

    if (showCompareDatePickerState.value) {
        AlertDialog(
            onDismissRequest = { showCompareDatePicker.update { false } },
            dismissButton = {
                TextButton(onClick = { showCompareDatePicker.update { false } }) {
                    Text("Cancel")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    compareDateText = LocalDate.of(
                        compareDateState.year,
                        compareDateState.month+1,
                        compareDateState.day
                    )
                    compareTimeText = String.format(
                        Locale.getDefault(), "%02d:%02d",
                        compareTimeState.hour, compareTimeState.minute
                    )
                    showCompareDatePicker.update { false }
                }) {
                    Text("OK")
                }
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
            ),
            modifier = Modifier.fillMaxWidth(0.95f),
            text = {
                Row {
                    DatePicker(
                        onDateSelected = { year, month, day ->
                            if (year * (month+1) * day != 0)
                                compareDateState = DatePickerDate(year, month, day)
                        },
                        date = compareDateState,
                        selectionLimiter = SelectionLimiter(
                            fromDate = fromDate,
                            toDate = toDate
                        ),
                        configuration = DatePickerConfiguration.Builder()
                            .headerTextStyle(TextStyle.Default.copy(fontSize = 20.sp))
                            .headerHeight(50.dp)
                            .sundayTextColor(PurpleTheme)
                            .dateTextStyle(DefaultDatePickerConfig.dateTextStyle.copy(color = Black333))
                            .selectedDateTextStyle(textStyle = TextStyle(White1000))
                            .selectedDateBackgroundColor(PurpleTheme)
                            .build(),
                        modifier = Modifier
                            .padding(end = 6.dp)
                            .fillMaxWidth(0.7f)
                            .scale(0.9f)
                    )
                    Column (
                        modifier = Modifier
                            .padding(top = 4.dp)
                            .scale(0.9f)
                    ) {
                        Row (
                            modifier = Modifier
                                .height(50.dp)
                                .align(Alignment.CenterHorizontally)
                        ){
                            Text(
                                text = "Time",
                                style = TextStyle.Default.copy(fontSize = 20.sp),
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                        TimePicker(
                            onTimeSelected = { hour, minute ->
                                compareTimeState = TimePickerTime(hour, minute)

                            },
                            minuteGap = MinuteGap.FIVE,
                            time = compareTimeState
                        )
                    }
                }
            }
        )
    }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = "Select Date&Time") },
        text = {
            Column {
                // 竞赛选择下拉框
                Text(
                    text = "Competition:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Black333,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Red500)
                        .clickable { showRangeDropdown = !showRangeDropdown }
                        .padding(horizontal = 12.dp, vertical = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = selectedRange?.short ?: "Select Competition",
                                color = Beige400,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                            if (selectedRange != null) {
                                Text(
                                    text = "${selectedRange!!.start} - ${selectedRange!!.current}",
                                    color = Beige600,
                                    fontSize = 11.sp
                                )
                                if (!selectedRange!!.isStart) {
                                    Text(
                                        text = "Not Started",
                                        color = Red800,
                                        fontSize = 10.sp
                                    )
                                }
                            }
                        }
                        Icon(
                            imageVector = Filled.ChevronDown,
                            contentDescription = "Dropdown",
                            tint = Beige400,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    
                    DropdownMenu(
                        expanded = showRangeDropdown,
                        onDismissRequest = { showRangeDropdown = false },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        rangeData.forEach { range ->
                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(
                                            text = range.short,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Medium
                                        )
                                        Text(
                                            text = "${range.start} - ${range.current}",
                                            fontSize = 11.sp,
                                            color = Color.Gray
                                        )
                                        if (!range.isStart) {
                                            Text(
                                                text = "Not Started",
                                                fontSize = 10.sp,
                                                color = Color.Red
                                            )
                                        }
                                    }
                                },
                                onClick = {
                                    bofScreenState.selectedRange.value = range
                                    showRangeDropdown = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row {
                    Text("Current: $currentDateText - $currentTimeText")
                }
                Button(onClick = { showCurrentDatePicker.update { true } }) {
                    Text(text = "Select Date&Time")
                }
                Row {
                    Text("Compare: $compareDateText - $compareTimeText")
                }
                Button(onClick = { showCompareDatePicker.update { true } }) {
                    Text(text = "Select Compare Date&Time")
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                bofScreenState.selectedCurrentDate.update { currentDateText }
                bofScreenState.selectedCurrentTime.update { currentTimeText }
                bofScreenState.selectedCompareDate.update { compareDateText }
                bofScreenState.selectedCompareTime.update { compareTimeText }
                onDismissRequest()
            }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            Button(onClick = onDismissRequest) {
                Text(text = "Cancel")
            }
        }
    )
}