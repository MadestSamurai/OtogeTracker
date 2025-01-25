package com.madsam.otora.ui.bof

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.madsam.otora.service.request.BofDataRequestService
import com.madsam.otora.ui.bof.sub.BofAvgScreen
import com.madsam.otora.ui.bof.sub.BofCommentScreen
import com.madsam.otora.ui.bof.sub.BofDiffScreen
import com.madsam.otora.ui.bof.sub.BofMedianScreen
import com.madsam.otora.ui.bof.sub.BofTeamScreen
import com.madsam.otora.ui.bof.sub.BofTotalScreen
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.bof.sub.BofScreen
 * 创建者: MadSamurai
 * 创建时间: 2024/10/19
 * 描述: BOF数据展示界面
 */

@Composable
fun BofScreen(snackbarHostState: SnackbarHostState) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val dateTime = LocalDate.now()

    val bofDataRequestService = BofDataRequestService(context)

    val vm: BofViewModel = viewModel(factory = BofViewModelFactory())

    val selectedTabIndex = vm.selectedTab.asStateFlow().collectAsState().value
    val selectedSubTabIndex = vm.selectedSubTab.asStateFlow().collectAsState().value
    val searchText = remember { mutableStateOf("") }

    val listStateTotal = rememberLazyListState()
    val listStateAvg = rememberLazyListState()
    val listStateMedian = rememberLazyListState()
    val listStateDiff = rememberLazyListState()
    val listStateTeam = rememberLazyListState()
    val listStateComment = rememberLazyListState()

    val currentIndexTotal = vm.currentIndexTotal.asStateFlow().collectAsState().value
    val scrollListTotal = vm.scrollToIndexListTotal.asStateFlow().collectAsState().value
    val currentIndexAvg = vm.currentIndexAvg.asStateFlow().collectAsState().value
    val scrollListAvg = vm.scrollToIndexListAvg.asStateFlow().collectAsState().value
    val currentIndexMedian = vm.currentIndexMedian.asStateFlow().collectAsState().value
    val scrollListMedian = vm.scrollToIndexListMedian.asStateFlow().collectAsState().value
    val currentIndexDiff = vm.currentIndexDiff.asStateFlow().collectAsState().value
    val scrollListDiff = vm.scrollToIndexListDiff.asStateFlow().collectAsState().value
    val currentIndexTeam = vm.currentIndexTeam.asStateFlow().collectAsState().value
    val scrollListTeam = vm.scrollToIndexListTeam.asStateFlow().collectAsState().value
    val currentIndexComment = vm.currentIndexComment.asStateFlow().collectAsState().value
    val scrollListComment = vm.scrollToIndexListComment.asStateFlow().collectAsState().value

    var showDateTimeRangePicker by remember { mutableStateOf(false) }
    var isTabRowVisible by remember { mutableStateOf(true) }

    val scrollThreshold = 50f

    fun selectTime() {
        showDateTimeRangePicker = true
    }

    if (showDateTimeRangePicker) {
        DateTimeRangePicker(
            vm = vm,
            onDismissRequest = { showDateTimeRangePicker = false }
        )
    }

    fun refreshData() {
        bofDataRequestService.requestBofttData(dateTime) {
            coroutineScope.launch {
                vm.requestTotalData()
            }
        }
        bofDataRequestService.requestBofttTeamData(dateTime) {
            coroutineScope.launch {
                vm.requestTotalData()
            }
        }
        bofDataRequestService.requestBofttCommentData(dateTime) {
            coroutineScope.launch {
                vm.requestTotalData()
            }
        }
    }

    LaunchedEffect(
        selectedTabIndex,
        currentIndexTotal, scrollListTotal,
        currentIndexAvg, scrollListAvg,
        currentIndexMedian, scrollListMedian,
        currentIndexDiff, scrollListDiff,
        currentIndexTeam, scrollListTeam
    ) {
        when (selectedTabIndex) {
            0 -> {
                if (currentIndexTotal < scrollListTotal.size)
                    listStateTotal.scrollToItem(scrollListTotal[currentIndexTotal] + 1)
                else
                    listStateTotal.scrollToItem(0)
            }

            1 -> {
                if (currentIndexAvg < scrollListAvg.size)
                    listStateAvg.scrollToItem(scrollListAvg[currentIndexAvg] + 1)
                else
                    listStateAvg.scrollToItem(0)
            }

            2 -> {
                if (currentIndexMedian < scrollListMedian.size)
                    listStateMedian.scrollToItem(scrollListMedian[currentIndexMedian] + 1)
                else
                    listStateMedian.scrollToItem(0)
            }

            3 -> {
                if (currentIndexDiff < scrollListDiff.size)
                    listStateDiff.scrollToItem(scrollListDiff[currentIndexDiff] + 1)
                else
                    listStateDiff.scrollToItem(0)
            }

            4 -> {
                if (currentIndexTeam < scrollListTeam.size)
                    listStateTeam.scrollToItem(scrollListTeam[currentIndexTeam] + 1)
                else
                    listStateTeam.scrollToItem(0)
            }
        }
    }

    val tabTitles = mapOf(
        "Entry" to listOf("Total", "Avg", "Median", "Diff"),
        "Team" to listOf("Total"),
        "Comment" to listOf("Total")
    )

    val mainTabTitles = tabTitles.keys.toList()
    val subTabTitles = tabTitles[mainTabTitles[selectedTabIndex]] ?: emptyList()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            Row(
                Modifier
                    .background(Purple700)
                    .fillMaxWidth()
            ) {
                val focusManager = LocalFocusManager.current
                val keyboardController = LocalSoftwareKeyboardController.current
                TextField(
                    value = searchText.value,
                    onValueChange = {
                        searchText.value = it
                        when (selectedTabIndex) {
                            0 -> vm.findItemIndex(it, vm.totalData.value, selectedTabIndex)
                            1 -> vm.findItemIndex(it, vm.avgData.value, selectedTabIndex)
                            2 -> vm.findItemIndex(it, vm.medianData.value, selectedTabIndex)
                            3 -> vm.findItemIndex(it, vm.diffData.value, selectedTabIndex)
                            4 -> vm.findTeamItemIndex(it, vm.teamData.value)
                        }
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
                        modifier = Modifier
                            .padding(16.dp)
                            .size(25.dp)
                            .clickable(onClick = { vm.scrollToPrevious(selectedTabIndex) })
                            .align(Alignment.CenterVertically)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "Next",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(25.dp)
                            .clickable(onClick = { vm.scrollToNext(selectedTabIndex) })
                            .align(Alignment.CenterVertically)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = "Date&Time",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(25.dp)
                            .clickable(onClick = { selectTime() })
                            .align(Alignment.CenterVertically)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rotate_arrow),
                        contentDescription = "Refresh",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(25.dp)
                            .clickable(onClick = { refreshData() })
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            NavHost(
                navController = navController,
                startDestination = "${mainTabTitles[selectedTabIndex]}/${subTabTitles.getOrNull(selectedSubTabIndex) ?: ""}",
                modifier = Modifier.weight(1f)
            ) {
                tabTitles.forEach { (mainTab, subTabs) ->
                    subTabs.forEach { subTab ->
                        composable("$mainTab/$subTab") {
                            when (mainTab) {
                                "Entry" -> when (subTab) {
                                    "Total" -> BofTotalScreen(vm, snackbarHostState, listStateTotal, scrollThreshold) { isTabRowVisible = it }
                                    "Avg" -> BofAvgScreen(vm, snackbarHostState, listStateAvg)
                                    "Median" -> BofMedianScreen(vm, snackbarHostState, listStateMedian)
                                    "Diff" -> BofDiffScreen(vm, snackbarHostState, listStateDiff)
                                }
                                "Team" -> when (subTab) {
                                    "Total" -> BofTeamScreen(vm, snackbarHostState, listStateTeam)
                                }
                                "Comment" -> when (subTab) {
                                    "Total" -> BofCommentScreen(vm, snackbarHostState, listStateComment)
                                }
                            }
                        }
                    }
                }
            }
        }
        AnimatedVisibility(
            visible = isTabRowVisible,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Column {
                CustomTabRow(
                    selectedTabIndex = selectedSubTabIndex,
                    modifier = Modifier
                        .padding(3.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.White)
                ) {
                    subTabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedSubTabIndex == index,
                            onClick = {
                                if (selectedSubTabIndex != index) {
                                    vm.selectedSubTab.update { index }
                                    navController.navigate("${mainTabTitles[selectedTabIndex]}/$title")
                                }
                            },
                            text = {
                                Text(
                                    text = title,
                                    color = if (selectedSubTabIndex == index) Color.Black else Color.Gray
                                )
                            },
                            modifier = Modifier.height(35.dp)
                        )
                    }
                }
                CustomTabRow(
                    selectedTabIndex = selectedTabIndex,
                    modifier = Modifier
                        .padding(3.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.White),
                ) {
                    mainTabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = {
                                if (selectedTabIndex != index) {
                                    vm.selectedTab.update { index }
                                    vm.selectedSubTab.update { 0 } // Reset sub-tab index
                                    navController.navigate("${title}/${subTabTitles.firstOrNull() ?: ""}")
                                }
                            },
                            text = {
                                Text(
                                    text = title,
                                    color = if (selectedTabIndex == index) Color.Black else Color.Gray,
                                )
                            },
                            modifier = Modifier.height(40.dp)
                        )
                    }
                }
            }
        }
    }
}