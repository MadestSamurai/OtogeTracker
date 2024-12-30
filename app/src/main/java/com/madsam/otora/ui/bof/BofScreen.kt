package com.madsam.otora.ui.bof

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.R
import com.madsam.otora.components.CustomTabRow
import com.madsam.otora.consts.Purple700
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
fun BofScreen(snackbarHostState: SnackbarHostState) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val dateTime = LocalDate.now()
    var selectedTabIndex = remember { mutableStateOf(0) }

    val bofDataRequestService = BofDataRequestService(context)

    val vm: BofViewModel = viewModel(factory = BofViewModelFactory(context))

    fun selectTime() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                vm.selectedDate.update { LocalDate.of(year, month + 1, dayOfMonth) }
                TimePickerDialog(context, { _, hourOfDay, minute ->
                    vm.selectedTime.update { String.format("%02d:%02d", hourOfDay, minute) }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
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

    val tabTitles = listOf("Total", "Avg", "Median", "Diff", "Team")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            Row(
                Modifier.background(Purple700)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "BOF Pages",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = "Date&Time",
                    tint = Color.White,
                    modifier = Modifier.padding(16.dp)
                        .size(25.dp)
                        .clickable(onClick = { selectTime() })
                        .align(Alignment.CenterVertically)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_rotate_arrow),
                    contentDescription = "Refresh",
                    tint = Color.White,
                    modifier = Modifier.padding(16.dp)
                        .size(25.dp)
                        .clickable(onClick = { refreshData() })
                        .align(Alignment.CenterVertically)
                )
            }
            NavHost(navController = navController, startDestination = "Total", modifier = Modifier.weight(1f)) {
                composable("Total") { BofTotalScreen(vm, snackbarHostState) }
                composable("Avg") { BofAvgScreen(vm) }
                composable("Median") { BofMedianScreen(vm) }
                composable("Diff") { BofDiffScreen(vm) }
                composable("Team") { BofTeamScreen(vm) }
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(8.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color.White)
        ) {
            CustomTabRow(
                selectedTabIndex = selectedTabIndex.value,
                modifier = Modifier.fillMaxWidth(),
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex.value == index,
                        onClick = {
                            selectedTabIndex.value = index
                            navController.navigate(title)
                        },
                        text = { Text(
                            text = title,
                            color = if (selectedTabIndex.value == index) Color.Black else Color.Gray,
                        ) }
                    )
                }
            }
        }
    }
}