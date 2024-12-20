package com.madsam.otora.ui.bof

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.service.BofDataRequestService
import com.madsam.otora.ui.bof.sub.BofAvgScreen
import com.madsam.otora.ui.bof.sub.BofDiffScreen
import com.madsam.otora.ui.bof.sub.BofMedianScreen
import com.madsam.otora.ui.bof.sub.BofTeamScreen
import com.madsam.otora.ui.bof.sub.BofTotalScreen
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Calendar

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/19
 * 描述: BOF数据展示界面
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BofScreen() {
    val context = LocalContext.current
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    var expanded = remember { mutableStateOf(false) }
    val dateTime = LocalDate.now()

    val bofDataRequestService = BofDataRequestService(context)

    val vm : BofViewModel = viewModel(factory = BofViewModelFactory(context))

    fun selectTime() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(context, { _, year, month, dayOfMonth ->
            vm.selectedDate.update { LocalDate.of(year, month + 1, dayOfMonth) }
            TimePickerDialog(context, { _, hourOfDay, minute ->
                vm.selectedTime.update { String.format("%02d:%02d", hourOfDay, minute) }
                vm.generateSelectedTimeStr()
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    fun refreshData() {
        bofDataRequestService.getBofttData(dateTime) {
            coroutineScope.launch {
                vm.requestTotalData()
            }
        }
        bofDataRequestService.getBofttTeamData(dateTime) {
            coroutineScope.launch {
                vm.requestTotalData()
            }
        }
    }

    Column {
        Row {
            Button(onClick = { expanded.value = true }) {
                Text(text = "Select Page")
            }
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                listOf("Total", "Avg", "Median", "Diff", "Team").forEach { screen ->
                    DropdownMenuItem(
                        onClick = {
                            navController.navigate(screen)
                            expanded.value = false
                        },
                        text = {
                            Text(text = screen)
                        }
                    )
                }
            }
            Button(onClick = { selectTime() }) {
                Text(text = "Select Date&Time")
            }
            Button(onClick = { refreshData() }) {
                Text(text = "Refresh Data")
            }
        }
        NavHost(navController = navController, startDestination = "Total") {
            composable("Total") { BofTotalScreen(vm) }
            composable("Avg") { BofAvgScreen(vm) }
            composable("Median") { BofMedianScreen(vm) }
            composable("Diff") { BofDiffScreen(vm) }
            composable("Team") { BofTeamScreen(vm) }
        }
    }
}