package com.madsam.otora.ui.bof

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.madsam.otora.service.BofDataRequestService
import com.madsam.otora.ui.bof.sub.BofAvgScreen
import com.madsam.otora.ui.bof.sub.BofDiffScreen
import com.madsam.otora.ui.bof.sub.BofMedianScreen
import com.madsam.otora.ui.bof.sub.BofTeamScreen
import com.madsam.otora.ui.bof.sub.BofTotalScreen
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
    val tabs = listOf(Screen.Page1, Screen.Page2, Screen.Page3, Screen.Page4, Screen.Page5)
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()
    var expanded = remember { mutableStateOf(false) }
    val dateTime = LocalDate.now()
    var selectedDate by remember { mutableStateOf(dateTime) }
    var selectedTime by remember { mutableStateOf("-1") }
    val bofDataRequestService = BofDataRequestService(context)

    fun selectTime() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(context, { _, year, month, dayOfMonth ->
            selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
            TimePickerDialog(context, { _, hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    fun refreshData() {
        coroutineScope.launch {
            bofDataRequestService.getBofttData(dateTime)
            bofDataRequestService.getBofttTeamData(dateTime)
        }
    }

    Column {
        Row {
            Button(onClick = { expanded.value = true }) {
                Text(text = tabs[pagerState.currentPage].route)
            }
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                tabs.filterIndexed { index, _ -> index != pagerState.currentPage }
                    .forEachIndexed { index, screen ->
                        DropdownMenuItem(
                            onClick = {
                                coroutineScope.launch {
                                    val targetIndex = tabs.indexOf(screen)
                                    pagerState.animateScrollToPage(targetIndex)
                                }
                                expanded.value = false
                            },
                            text = {
                                Text(text = screen.route)
                            }
                        )
                    }
            }
            Button(onClick = { selectTime() }) {
                Text(text = "Select Date and Time")
            }
            Button(onClick = { refreshData() }) {
                Text(text = "Refresh Data")
            }
        }
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false
        ) { page ->
            when (tabs[page]) {
                is Screen.Page1 -> BofTotalScreen(selectedDate, selectedTime)
                is Screen.Page2 -> BofAvgScreen(selectedDate, selectedTime)
                is Screen.Page3 -> BofMedianScreen(selectedDate, selectedTime)
                is Screen.Page4 -> BofDiffScreen(selectedDate, selectedTime)
                is Screen.Page5 -> BofTeamScreen(selectedDate, selectedTime)
            }
        }
    }
}

sealed class Screen(val route: String) {
    data object Page1 : Screen("Total")
    data object Page2 : Screen("Avg")
    data object Page3 : Screen("Median")
    data object Page4 : Screen("Diff")
    data object Page5 : Screen("Team")
}