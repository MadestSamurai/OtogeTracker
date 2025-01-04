package com.madsam.otora.components

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
import com.madsam.otora.ui.bof.BofViewModel
import com.madsam.otora.utils.CommonUtils.convertMillisToDate
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.util.Locale

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.components.DateTimeRangePicker
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
    var showStartDatePicker by remember { mutableStateOf(false) }
    var showStartTimePicker by remember { mutableStateOf(false) }
    var showEndDatePicker by remember { mutableStateOf(false) }
    var showEndTimePicker by remember { mutableStateOf(false) }

    val startDatePickerState = rememberDatePickerState()
    val endDatePickerState = rememberDatePickerState()
    val startTimePickerState = rememberTimePickerState()
    val endTimePickerState = rememberTimePickerState()

    var startDateText by remember { mutableStateOf(LocalDate.now()) }
    var startTimeText by remember { mutableStateOf("00:00:00") }
    var endDateText by remember { mutableStateOf(LocalDate.now()) }
    var endTimeText by remember { mutableStateOf("00:00:00") }


    if (showStartDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showStartDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    startDateText = startDatePickerState.selectedDateMillis?.let {
                        convertMillisToDate(it)
                    } ?: LocalDate.now()
                    showStartDatePicker = false
                    showStartTimePicker = true
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showStartDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = startDatePickerState)
        }
    }

    if (showStartTimePicker) {
        AlertDialog(
            onDismissRequest = { showStartTimePicker = false },
            dismissButton = {
                TextButton(onClick = { showStartTimePicker = false }) {
                    Text("Dismiss")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    startTimeText = String.format(
                        Locale.getDefault(), "%02d:%02d", startTimePickerState.hour, startTimePickerState.minute
                    )
                    showStartTimePicker = false
                    showEndDatePicker = true
                }) {
                    Text("OK")
                }
            },
            text = {
                TimePicker(
                    state = startTimePickerState
                )
            }
        )
    }

    if (showEndDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showEndTimePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    endDateText = endDatePickerState.selectedDateMillis?.let {
                        convertMillisToDate(it)
                    } ?: LocalDate.now()
                    showEndDatePicker = false
                    showEndTimePicker = true
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEndDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = endDatePickerState)
        }
    }

    if (showEndTimePicker) {
        AlertDialog(
            onDismissRequest = { showEndTimePicker = false },
            dismissButton = {
                TextButton(onClick = { showEndTimePicker = false }) {
                    Text("Dismiss")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    endTimeText = String.format(
                        Locale.getDefault(), "%02d:%02d", endTimePickerState.hour, endTimePickerState.minute
                    )
                    showEndTimePicker = false
                }) {
                    Text("OK")
                }
            },
            text = {
                TimePicker(
                    state = endTimePickerState
                )
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
                    Text("Start Date: $startDateText")
                }
                Row {
                    Text("Start Time: $startTimeText")
                }
                Row {
                    Text("End Date: $endDateText")
                }
                Row {
                    Text("End Time: $endTimeText")
                }
                Button(onClick = { showStartDatePicker = true }) {
                    Text(text = "Select Date Time Range")
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                vm.selectedStartDate.update { startDateText }
                vm.selectedStartTime.update { startTimeText }
                vm.selectedEndDate.update { endDateText }
                vm.selectedEndTime.update { endTimeText }
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