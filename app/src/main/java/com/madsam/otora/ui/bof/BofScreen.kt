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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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
import kotlinx.coroutines.flow.asStateFlow
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

    val bofDataRequestService = BofDataRequestService(context)

    val vm: BofViewModel = viewModel(factory = BofViewModelFactory(context))

    val selectedTabIndex = vm.selectedTab.asStateFlow().collectAsState().value
    val searchText = remember { mutableStateOf("") }

    val listState = rememberLazyListState()
    val currentIndex = vm.currentIndex.asStateFlow().collectAsState().value
    val scrollList = vm.scrollToIndexList.asStateFlow().collectAsState().value

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

    LaunchedEffect(scrollList, currentIndex) {
        if (currentIndex < scrollList.size)
            listState.scrollToItem(scrollList[currentIndex]+1)
        else
            listState.scrollToItem(0)
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
                val focusManager = LocalFocusManager.current
                val keyboardController = LocalSoftwareKeyboardController.current
                TextField(
                    value = searchText.value,
                    onValueChange = {
                        searchText.value = it
                        vm.findItemIndex(it, vm.totalData.value)
                    },
                    textStyle = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal),
                    placeholder = { Text("Search", color = Color.White, fontSize = 18.sp) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_magnify),
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                            keyboardController?.hide()
                        }
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        disabledTextColor = Color.White,
                        errorTextColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent,
                        focusedPlaceholderColor = Color.White,
                        unfocusedPlaceholderColor = Color.White,
                        disabledPlaceholderColor = Color.White,
                        errorPlaceholderColor = Color.White,
                        focusedLeadingIconColor = Color.White,
                        unfocusedLeadingIconColor = Color.White,
                        disabledLeadingIconColor = Color.White,
                        errorLeadingIconColor = Color.White,
                        cursorColor = Color.White,
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                if (searchText.value.isNotEmpty()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_up),
                        contentDescription = "Previous",
                        tint = Color.White,
                        modifier = Modifier.padding(16.dp)
                            .size(25.dp)
                            .clickable(onClick = { vm.scrollToPrevious() })
                            .align(Alignment.CenterVertically)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "Next",
                        tint = Color.White,
                        modifier = Modifier.padding(16.dp)
                            .size(25.dp)
                            .clickable(onClick = { vm.scrollToNext() })
                            .align(Alignment.CenterVertically)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
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
            }
            NavHost(navController = navController, startDestination = "Total", modifier = Modifier.weight(1f)) {
                composable("Total") { BofTotalScreen(vm, snackbarHostState, listState) }
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
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth(),
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            if (selectedTabIndex != index) {
                                vm.selectedTab.update { index }
                                navController.navigate(title)
                            }
                        },
                        text = { Text(
                            text = title,
                            color = if (selectedTabIndex == index) Color.Black else Color.Gray,
                        ) }
                    )
                }
            }
        }
    }
}