package com.madsam.otora.ui.bof

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.madsam.otora.utils.CommonUtils.convertMillisToDate
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimeRangePicker(
    vm: BofViewModel,
    onDismissRequest: () -> Unit
) {
    var showCompareDatePicker by remember { mutableStateOf(false) }
    var showCompareTimePicker by remember { mutableStateOf(false) }
    var showCurrentDatePicker by remember { mutableStateOf(false) }
    var showCurrentTimePicker by remember { mutableStateOf(false) }

    val compareDatePickerState = rememberDatePickerState()
    val currentDatePickerState = rememberDatePickerState()
    val compareTimePickerState = rememberTimePickerState()
    val currentTimePickerState = rememberTimePickerState()

    var compareDateText by remember { mutableStateOf(LocalDate.now()) }
    var compareTimeText by remember { mutableStateOf("00:00:00") }
    var currentDateText by remember { mutableStateOf(LocalDate.now()) }
    var currentTimeText by remember { mutableStateOf("00:00:00") }

    if (showCurrentDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showCurrentTimePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    currentDateText = currentDatePickerState.selectedDateMillis?.let {
                        convertMillisToDate(it)
                    } ?: LocalDate.now()
                    showCurrentDatePicker = false
                    showCurrentTimePicker = true
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showCurrentDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = currentDatePickerState)
        }
    }

    if (showCurrentTimePicker) {
        AlertDialog(
            onDismissRequest = { showCurrentTimePicker = false },
            dismissButton = {
                TextButton(onClick = { showCurrentTimePicker = false }) {
                    Text("Dismiss")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    currentTimeText = String.format(
                        Locale.getDefault(), "%02d:%02d", currentTimePickerState.hour, currentTimePickerState.minute
                    )
                    showCurrentTimePicker = false
                    showCompareDatePicker = true
                }) {
                    Text("OK")
                }
            },
            text = {
                TimePicker(state = currentTimePickerState)
            }
        )
    }

    if (showCompareDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showCompareDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    compareDateText = compareDatePickerState.selectedDateMillis?.let {
                        convertMillisToDate(it)
                    } ?: LocalDate.now()
                    showCompareDatePicker = false
                    showCompareTimePicker = true
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showCompareDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = compareDatePickerState)
        }
    }

    if (showCompareTimePicker) {
        AlertDialog(
            onDismissRequest = { showCompareTimePicker = false },
            dismissButton = {
                TextButton(onClick = { showCompareTimePicker = false }) {
                    Text("Dismiss")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    compareTimeText = String.format(
                        Locale.getDefault(), "%02d:%02d", compareTimePickerState.hour, compareTimePickerState.minute
                    )
                    showCompareTimePicker = false
                }) {
                    Text("OK")
                }
            },
            text = {
                TimePicker(state = compareTimePickerState)
            }
        )
    }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text(text = "Capture Content") },
        modifier = Modifier.height(300.dp),
        text = {
            Column {
                Row {
                    Text("Current Date: $currentDateText")
                }
                Row {
                    Text("Current Time: $currentTimeText")
                }
                Row {
                    Text("Compare Date: $compareDateText")
                }
                Row {
                    Text("Compare Time: $compareTimeText")
                }
                Button(onClick = { showCurrentDatePicker = true }) {
                    Text(text = "Select Date Time Range")
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                vm.selectedCurrentDate.update { currentDateText }
                vm.selectedCurrentTime.update { currentTimeText }
                vm.selectedCompareDate.update { compareDateText }
                vm.selectedCompareTime.update { compareTimeText }
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