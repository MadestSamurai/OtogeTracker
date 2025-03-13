package com.madsam.otora.ui.bof.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.theme.Black333
import com.madsam.otora.core.theme.PurpleTheme
import com.madsam.otora.core.theme.White1000
import com.vsnappy1.datepicker.DatePicker
import com.vsnappy1.datepicker.data.DefaultDatePickerConfig
import com.vsnappy1.datepicker.data.model.DatePickerDate
import com.vsnappy1.datepicker.data.model.SelectionLimiter
import com.vsnappy1.datepicker.ui.model.DatePickerConfiguration
import com.vsnappy1.timepicker.TimePicker
import com.vsnappy1.timepicker.data.model.TimePickerTime
import com.vsnappy1.timepicker.enums.MinuteGap
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.util.Locale

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.DateTimeRangePicker
 * 创建者: MadSamurai
 * 创建时间: 2025/1/4
 * 描述: 日期时间范围选择器
 */

@Composable
fun DateTimeRangePicker(
    bofScreenState: BofScreenState,
    onDismissRequest: () -> Unit
) {
    var showCompareDatePicker by remember { mutableStateOf(false) }
    var showCurrentDatePicker by remember { mutableStateOf(false) }

    var currentDateState by remember { mutableStateOf(DatePickerDate(2025, 0, 8)) }
    var currentTimeState by remember { mutableStateOf(TimePickerTime(0, 0)) }
    var compareDateState by remember { mutableStateOf(DatePickerDate(2025, 0, 8)) }
    var compareTimeState by remember { mutableStateOf(TimePickerTime(0, 0)) }

    var currentDateText by remember { mutableStateOf(LocalDate.now()) }
    var currentTimeText by remember { mutableStateOf("00:00") }
    var compareDateText by remember { mutableStateOf(LocalDate.now()) }
    var compareTimeText by remember { mutableStateOf("00:00") }


    if (showCurrentDatePicker) {
        AlertDialog(
            onDismissRequest = { showCurrentDatePicker = false },
            dismissButton = {
                TextButton(onClick = { showCurrentDatePicker = false }) {
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
                    showCurrentDatePicker = false
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
                            fromDate = DatePickerDate(2024, 9, 18),
                            toDate = DatePickerDate(2025, 0, 8)
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

    if (showCompareDatePicker) {
        AlertDialog(
            onDismissRequest = { showCompareDatePicker = false },
            dismissButton = {
                TextButton(onClick = { showCompareDatePicker = false }) {
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
                    showCompareDatePicker = false
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
                            fromDate = DatePickerDate(2024, 9, 18),
                            toDate = DatePickerDate(2025, 0, 8)
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
                Row {
                    Text("Current: $currentDateText - $currentTimeText")
                }
                Button(onClick = { showCurrentDatePicker = true }) {
                    Text(text = "Select Date&Time")
                }
                Row {
                    Text("Compare: $compareDateText - $compareTimeText")
                }
                Button(onClick = { showCompareDatePicker = true }) {
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