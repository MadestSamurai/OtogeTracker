package com.madsam.otora.ui.bof

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.R
import com.madsam.otora.consts.Colors
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
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val dateTime = LocalDate.now()
    var selectedScreen =  remember { mutableStateOf("Total") }

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

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            selectedScreen.value = backStackEntry.destination.route ?: "Total"
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(240.dp),
            ) {
                Text("BOF Pages",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp),
                )
                HorizontalDivider()
                LazyColumn {
                    listOf("Total", "Avg", "Median", "Diff", "Team").forEach { screen ->
                        item {
                            NavigationDrawerItem(
                                icon = { },
                                label = { Text(screen, fontSize = 16.sp) },
                                onClick = {
                                    selectedScreen.value = screen
                                    navController.navigate(screen)
                                    coroutineScope.launch { drawerState.close() }
                                },
                                selected = selectedScreen.value == screen
                            )
                        }
                    }
                }
            }
        },
    ) {
        Column {
            Row(
                Modifier.background(Colors.Purple700)
                    .fillMaxWidth()
            ) {
                val inlineContent = mapOf(
                    "Menu" to InlineTextContent(
                        Placeholder(
                            width = 25.sp,
                            height = 25.sp,
                            placeholderVerticalAlign = PlaceholderVerticalAlign.TextBottom
                        )
                    ) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.ic_ranking_24dp
                            ),
                            tint = Color.White,
                            contentDescription = stringResource(id = R.string.online_mark),
                            modifier = Modifier.padding(end = 5.dp)
                        )
                    },
                )
                Text(
                    text = buildAnnotatedString {
                        appendInlineContent(
                            "Menu",
                            "Menu"
                        )
                        append(selectedScreen.value)
                    },
                    inlineContent = inlineContent,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                        .clickable(onClick = { coroutineScope.launch { drawerState.open() } })
                        .align(Alignment.CenterVertically)
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
            NavHost(navController = navController, startDestination = "Total") {
                composable("Total") { BofTotalScreen(vm, snackbarHostState) }
                composable("Avg") { BofAvgScreen(vm) }
                composable("Median") { BofMedianScreen(vm) }
                composable("Diff") { BofDiffScreen(vm) }
                composable("Team") { BofTeamScreen(vm) }
            }
        }
    }
}