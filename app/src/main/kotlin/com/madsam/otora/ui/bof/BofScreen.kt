package com.madsam.otora.ui.bof

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.data.bof.remote.api.BofRequestService
import com.madsam.otora.ui.bof.components.DateTimeRangePicker
import com.madsam.otora.ui.bof.sub.BofAvgNewScreen
import com.madsam.otora.ui.bof.sub.BofCommentScreen
import com.madsam.otora.ui.bof.sub.BofDiffScreen
import com.madsam.otora.ui.bof.sub.BofMedianNewScreen
import com.madsam.otora.ui.bof.sub.BofTTTestScreen
import com.madsam.otora.ui.bof.sub.BofTeamScreen
import com.madsam.otora.ui.bof.sub.BofTotalNewScreen
import com.madsam.otora.ui.components.CustomScrollableTabRow
import com.madsam.otora.ui.components.CustomTabRow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

private const val TAG = "BofScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BofScreen(
    snackbarHostState: SnackbarHostState,
    navController: NavHostController,
    bofScreenState: BofScreenState
) {
    Log.d(TAG, "BofScreen Compose started")
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val dateTime = LocalDate.now()

    Log.d(TAG, "Creating BofRequestService")
    val bofRequestService = BofRequestService(context)

    Log.d(TAG, "Creating BofViewModel")
    val vm: BofViewModel = viewModel(factory = BofViewModelFactory(bofScreenState))
    Log.d(TAG, "BofViewModel created")

    var isTabRowVisible by remember { mutableStateOf(true) }
    val selectedTabIndex = bofScreenState.selectedTab.asStateFlow().collectAsState().value
    val selectedSubTabIndex = bofScreenState.selectedSubTab.asStateFlow().collectAsState().value
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
    val scrollThreshold = 50f

    // Narrow mode state management
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    var narrowMode by remember { mutableIntStateOf(0) }

    fun selectTime() {
        showDateTimeRangePicker = true
    }

    fun refreshData() {
        bofRequestService.requestBofttData(dateTime) {
            coroutineScope.launch {
                vm.requestTotalData()
            }
        }
        bofRequestService.requestBofttTeamData(dateTime) {
            coroutineScope.launch {
                vm.requestTotalData()
            }
        }
        bofRequestService.requestBofttCommentData(dateTime) {
            coroutineScope.launch {
                vm.requestTotalData()
            }
        }
    }

    // 流式JSON解析加载
    LaunchedEffect(Unit) {
        vm.loadRankingDataWithStreamedParsing()
    }

    if (showDateTimeRangePicker) {
        DateTimeRangePicker(
            bofScreenState = bofScreenState,
            onDismissRequest = { 
                showDateTimeRangePicker = false
                vm.loadRankingDataWithStreamedParsing()
            }
        )
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
        "Entry" to listOf("Total", "Avg", "Median", "Diff", "Test"),
        "Team" to listOf(" "),
        "Comment" to listOf(" ")
    )

    val mainTabTitles = tabTitles.keys.toList()
    val subTabTitles = tabTitles[mainTabTitles[selectedTabIndex]] ?: emptyList()

    Log.d(TAG, "Starting UI render")
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            TopAppBar(
                title = {
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
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
                        placeholder = { Text("Search", color = Beige400, fontSize = 16.sp) },
                        leadingIcon = {
                            Icon(
                                painter = rememberVectorPainter(image = Filled.Magnify),
                                contentDescription = "Search Icon",
                                tint = Beige400,
                                modifier = Modifier.size(16.dp)
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
                            focusedTextColor = Beige400,
                            unfocusedTextColor = Beige400,
                            disabledTextColor = Beige400,
                            errorTextColor = Beige400,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            errorContainerColor = Color.Transparent,
                            focusedPlaceholderColor = Beige400,
                            unfocusedPlaceholderColor = Beige400,
                            disabledPlaceholderColor = Beige400,
                            errorPlaceholderColor = Beige400,
                            focusedLeadingIconColor = Beige400,
                            unfocusedLeadingIconColor = Beige400,
                            disabledLeadingIconColor = Beige400,
                            errorLeadingIconColor = Beige400,
                            cursorColor = Beige400,
                        )
                    )
                },
                actions = {
                    if (searchText.value.isNotEmpty()) {
                        IconButton(onClick = { vm.scrollToPrevious(selectedTabIndex) }) {
                            Icon(
                                painter = rememberVectorPainter(image = Filled.ChevronUp),
                                contentDescription = "Previous",
                                tint = Beige400
                            )
                        }
                        IconButton(onClick = { vm.scrollToNext(selectedTabIndex) }) {
                            Icon(
                                painter = rememberVectorPainter(image = Filled.ChevronDown),
                                contentDescription = "Next",
                                tint = Beige400
                            )
                        }
                    } else {
                        IconButton(onClick = { selectTime() }) {
                            Icon(
                                painter = rememberVectorPainter(image = Filled.Calendar),
                                contentDescription = "Date&Time",
                                tint = Beige400
                            )
                        }
                        IconButton(onClick = { refreshData() }) {
                            Icon(
                                painter = rememberVectorPainter(image = Filled.ArrowRotate),
                                contentDescription = "Refresh",
                                tint = Beige400
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Red500,
                    titleContentColor = Beige400,
                    actionIconContentColor = Beige400
                )
            )
            NavHost(
                navController = navController,
                startDestination = "${mainTabTitles[selectedTabIndex]}/${
                    subTabTitles.getOrNull(selectedSubTabIndex) ?: ""
                }",
                modifier = Modifier.weight(1f)
            ) {
                tabTitles.forEach { (mainTab, subTabs) ->
                    subTabs.forEach { subTab ->
                        composable("$mainTab/$subTab") {
                            when (mainTab) {
                                "Entry" -> when (subTab) {
                                    "Total" -> BofTotalNewScreen(
                                        vm = vm,
                                        bofScreenState = bofScreenState,
                                        narrowMode = narrowMode
                                    )

                                    "Avg" -> BofAvgNewScreen(
                                        vm = vm,
                                        bofScreenState = bofScreenState,
                                        narrowMode = narrowMode,
                                        modifier = Modifier.fillMaxSize()
                                    )

                                    "Median" -> BofMedianNewScreen(
                                        vm = vm,
                                        bofScreenState = bofScreenState,
                                        narrowMode = narrowMode,
                                        modifier = Modifier.fillMaxSize()
                                    )

                                    "Diff" -> BofDiffScreen(
                                        vm,
                                        snackbarHostState,
                                        listStateDiff,
                                        scrollThreshold,
                                        bofScreenState
                                    ) { isTabRowVisible = it }

                                    "Test" -> BofTTTestScreen(
                                        repository = vm.bofRepository,
                                        modifier = Modifier.fillMaxSize()
                                    ) { isTabRowVisible = it }
                                }

                                "Team" -> when (subTab) {
                                    " " -> BofTeamScreen(
                                        vm,
                                        snackbarHostState,
                                        listStateTeam,
                                        scrollThreshold,
                                        bofScreenState
                                    ) { isTabRowVisible = it }
                                }

                                "Comment" -> when (subTab) {
                                    " " -> BofCommentScreen(
                                        vm,
                                        snackbarHostState,
                                        listStateComment,
                                        scrollThreshold,
                                        bofScreenState
                                    ) { isTabRowVisible = it }
                                }
                            }
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            // 子Tab栏（如果有多个子Tab）
            AnimatedVisibility(
                visible = isTabRowVisible && subTabTitles.size > 1,
                enter = fadeIn(animationSpec = tween(300)),
                exit = fadeOut(animationSpec = tween(300)),
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 3.dp)
                    .clip(RoundedCornerShape(20.dp))
            ) {
                CustomTabRow(
                    selectedTabIndex = selectedSubTabIndex,
                    containerColor = Red500
                ) {
                    subTabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedSubTabIndex == index,
                            onClick = {
                                if (selectedSubTabIndex != index) {
                                    bofScreenState.selectedSubTab.update { index }
                                    navController.navigate("${mainTabTitles[selectedTabIndex]}/$title")
                                }
                            },
                            text = {
                                Text(
                                    text = title,
                                    color = if (selectedSubTabIndex == index) Beige500 else Beige600
                                )
                            },
                            modifier = Modifier.height(35.dp)
                        )
                    }
                }
            }
            
            // 主Tab栏 - 左侧可滚动TabRow + 右侧圆形按钮
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp) // 40dp tab + 3dp padding + 3dp padding
                    .padding(start = 12.dp, end = 12.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 计算屏幕宽度和内容宽度
                val contentWidthDp = screenWidthDp.dp - 24.dp // 减去水平padding
                
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // 左侧可滚动TabRow
                    androidx.compose.animation.AnimatedVisibility(
                        visible = isTabRowVisible,
                        enter = fadeIn(animationSpec = tween(300)),
                        exit = fadeOut(animationSpec = tween(300)),
                        modifier = Modifier
                            .wrapContentWidth()
                            .widthIn(max = contentWidthDp - 48.dp) // 减去按钮宽度和间隙
                            .clip(RoundedCornerShape(20.dp))
                    ) {
                        CustomScrollableTabRow(
                            selectedTabIndex = selectedTabIndex,
                            containerColor = Red500,
                            containerWidthDp = contentWidthDp - 48.dp,
                            tabs = { selectedIndex ->
                                mainTabTitles.forEachIndexed { index, title ->
                                    Tab(
                                        selected = selectedTabIndex == index,
                                        onClick = {
                                            if (selectedTabIndex != index) {
                                                bofScreenState.selectedTab.update { index }
                                                bofScreenState.selectedSubTab.update { 0 }
                                                val defaultSubTab = when (title) {
                                                    "Entry" -> "Total"
                                                    "Team", "Comment" -> " "
                                                    else -> ""
                                                }
                                                navController.navigate("$title/$defaultSubTab")
                                            }
                                        },
                                        text = {
                                            Text(
                                                text = title,
                                                color = if (selectedTabIndex == index) Beige500 else Beige600
                                            )
                                        },
                                        modifier = Modifier.height(40.dp)
                                    )
                                }
                            }
                        )
                    }

                    // 右侧圆形按钮
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.CenterEnd)
                            .clip(RoundedCornerShape(50))
                            .background(Red500)
                            .clickable {
                                when (selectedTabIndex) {
                                    0 -> {
                                        // Entry页面，切换narrow模式
                                        narrowMode = if (narrowMode == 0) 1 else 0
                                    }
                                    1 -> {
                                        // Team页面，刷新团队数据
                                        coroutineScope.launch {
                                            refreshData()
                                            snackbarHostState.showSnackbar("团队数据已刷新")
                                        }
                                    }
                                    2 -> {
                                        // Comment页面，刷新评论数据
                                        coroutineScope.launch {
                                            refreshData()
                                            snackbarHostState.showSnackbar("评论数据已刷新")
                                        }
                                    }
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Crossfade(
                            targetState = selectedTabIndex,
                            animationSpec = tween(durationMillis = 300),
                            label = "icon_crossfade"
                        ) { tabIndex ->
                            Icon(
                                painter = rememberVectorPainter(
                                    image = when (tabIndex) {
                                        0 -> Filled.SwitchArrow  // Entry: 窄屏切换图标
                                        1 -> Filled.ArrowRotate  // Team: 刷新图标
                                        2 -> Filled.ArrowRotate  // Comment: 刷新图标
                                        else -> Filled.ArrowRotate
                                    }
                                ),
                                contentDescription = when (tabIndex) {
                                    0 -> if (narrowMode == 1) "Switch to Wide Mode" else "Switch to Narrow Mode"
                                    1 -> "Refresh Team Data"
                                    2 -> "Refresh Comment Data"
                                    else -> "Refresh"
                                },
                                tint = Beige500,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
