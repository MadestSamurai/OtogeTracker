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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
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
import com.madsam.otora.core.theme.Red800
import com.madsam.otora.data.bof.remote.api.BofRequestService
import com.madsam.otora.data.bof.remote.model.BofRangeDTO
import com.madsam.otora.ui.bof.components.DateTimeRangePicker
import com.madsam.otora.ui.bof.sub.BofCommentScreen
import com.madsam.otora.ui.bof.sub.BofEntryPagerScreen
import com.madsam.otora.ui.bof.sub.BofTeamScreen
import com.madsam.otora.ui.components.CustomScrollableTabRow
import com.madsam.otora.ui.components.CustomTabRow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate

private const val TAG = "BofScreen"

/**
 * 判断是否应该显示操作按钮
 * @param selectedTabIndex 当前选中的主Tab索引
 * @return true表示应该显示按钮
 */
private fun shouldShowActionButton(selectedTabIndex: Int): Boolean {
    return when (selectedTabIndex) {
        0 -> true  // Entry页面：显示narrow模式切换按钮
        1 -> true  // Team页面：显示刷新按钮  
        2 -> true  // Comment页面：显示刷新按钮
        else -> false
    }
}

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

    // 抽屉状态
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    
    // Range 数据状态
    var rangeData by remember { mutableStateOf<List<BofRangeDTO>>(emptyList()) }
    var selectedRange by remember { mutableStateOf<BofRangeDTO?>(null) }
    
    // 获取 range 数据
    LaunchedEffect(Unit) {
        try {
            val ranges = bofRequestService.getBofRangeDataPublic()
            if (ranges != null) {
                rangeData = ranges
                // 默认选择第一个可用的 range
                selectedRange = ranges.firstOrNull { it.isStart }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to load range data: ${e.message}")
        }
    }

    var isTabRowVisible by remember { mutableStateOf(true) }
    val selectedTabIndex = bofScreenState.selectedTab.asStateFlow().collectAsState().value
    val selectedSubTabIndex = bofScreenState.selectedSubTab.asStateFlow().collectAsState().value
    val searchText = remember { mutableStateOf("") }

    val listStateTeam = rememberLazyListState()
    val listStateComment = rememberLazyListState()

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
        val competitionType = selectedRange?.path ?: "tt"
        bofRequestService.requestBofTeamData(dateTime, competitionType) {
        }
        bofRequestService.requestBofCommentData(dateTime, competitionType) {
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
        currentIndexTeam, scrollListTeam,
        currentIndexComment, scrollListComment
    ) {
        when (selectedTabIndex) {
            1 -> {
                if (currentIndexTeam < scrollListTeam.size)
                    listStateTeam.scrollToItem(scrollListTeam[currentIndexTeam] + 1)
                else
                    listStateTeam.scrollToItem(0)
            }

            2 -> {
                if (currentIndexComment < scrollListComment.size)
                    listStateComment.scrollToItem(scrollListComment[currentIndexComment] + 1)
                else
                    listStateComment.scrollToItem(0)
            }
        }
    }

    val tabTitles = mapOf(
        "Entry" to listOf("Total", "Avg", "Median", "Diff", "Composite"),
        "Team" to emptyList<String>(),
        "Comment" to emptyList<String>()
    )

    val mainTabTitles = tabTitles.keys.toList()
    val subTabTitles = tabTitles[mainTabTitles[selectedTabIndex]] ?: emptyList()

    Log.d(TAG, "Starting UI render")
    
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(280.dp),
                drawerContainerColor = Red500,
                drawerContentColor = Beige400
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                
                // 显示 Range 数据列表
                if (rangeData.isNotEmpty()) {
                    Text(
                        text = "BOF Competitions",
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        color = Beige500,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    
                    rangeData.forEach { range ->
                        NavigationDrawerItem(
                            label = { 
                                Column {
                                    Text(
                                        text = if (range.full.isNotEmpty()) range.full else range.short,
                                        color = if (selectedRange?.path == range.path) Beige500 else Beige600,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                    if (range.short.isNotEmpty() && range.full.isNotEmpty()) {
                                        Text(
                                            text = range.short,
                                            color = if (selectedRange?.path == range.path) Beige500.copy(alpha = 0.8f) else Beige600.copy(alpha = 0.8f),
                                            fontSize = 12.sp
                                        )
                                    }
                                    Text(
                                        text = "${range.start} - ${range.current}",
                                        color = if (selectedRange?.path == range.path) Beige500.copy(alpha = 0.7f) else Beige600.copy(alpha = 0.7f),
                                        fontSize = 11.sp
                                    )
                                    if (!range.isStart) {
                                        Text(
                                            text = "Not Started",
                                            color = Red800,
                                            fontSize = 10.sp
                                        )
                                    }
                                }
                            },
                            selected = selectedRange?.path == range.path,
                            onClick = {
                                selectedRange = range
                                // 根据选择的比赛类型刷新数据
                                refreshData()
                                coroutineScope.launch { 
                                    drawerState.close()
                                    snackbarHostState.showSnackbar("已切换到 ${if (range.full.isNotEmpty()) range.full else range.short}")
                                }
                            },
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = Red800,
                                unselectedContainerColor = Red500,
                                selectedIconColor = Beige500,
                                unselectedIconColor = Beige600,
                                selectedTextColor = Beige500,
                                unselectedTextColor = Beige600
                            )
                        )
                    }
                } else {
                    Text(
                        text = "Loading competitions...",
                        modifier = Modifier.padding(16.dp),
                        color = Beige600
                    )
                }
                
                Spacer(modifier = Modifier.weight(1f))
                
                // 底部功能按钮
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Calendar),
                            contentDescription = "Date Range",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Date Range") },
                    selected = false,
                    onClick = {
                        showDateTimeRangePicker = true
                        coroutineScope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(horizontal = 12.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Red800,
                        unselectedContainerColor = Red500,
                        selectedIconColor = Beige500,
                        unselectedIconColor = Beige600,
                        selectedTextColor = Beige500,
                        unselectedTextColor = Beige600
                    )
                )
                
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.ArrowRotate),
                            contentDescription = "Refresh",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    label = { Text("Refresh Data") },
                    selected = false,
                    onClick = {
                        refreshData()
                        coroutineScope.launch { 
                            drawerState.close()
                            snackbarHostState.showSnackbar("数据已刷新")
                        }
                    },
                    modifier = Modifier.padding(horizontal = 12.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = Red800,
                        unselectedContainerColor = Red500,
                        selectedIconColor = Beige500,
                        unselectedIconColor = Beige600,
                        selectedTextColor = Beige500,
                        unselectedTextColor = Beige600
                    )
                )
                
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    ) {
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
                                0 -> {
                                    // Entry页面的搜索由BofEntryPagerScreen处理
                                }
                                1 -> vm.findTeamItemIndex(it, vm.teamData.value)
                                // Comment页面暂时使用相同的搜索逻辑，后续可以添加专门的方法
                                2 -> {} // 可以后续添加评论搜索
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
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch { drawerState.open() }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Beige400,
                            modifier = Modifier.size(24.dp)
                        )
                    }
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
                startDestination = mainTabTitles[selectedTabIndex],
                modifier = Modifier.weight(1f)
            ) {
                mainTabTitles.forEach { mainTab ->
                    composable(mainTab) {
                        when (mainTab) {
                            "Entry" -> BofEntryPagerScreen(
                                vm = vm,
                                bofScreenState = bofScreenState,
                                narrowMode = narrowMode,
                                searchText = searchText.value,
                                scrollThreshold = scrollThreshold,
                                setIsTabRowVisible = { isTabRowVisible = it }
                            )

                            "Team" -> BofTeamScreen(
                                vm,
                                snackbarHostState,
                                listStateTeam,
                                scrollThreshold,
                                bofScreenState
                            ) { isTabRowVisible = it }

                            "Comment" -> BofCommentScreen(
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
                                    // 不需要导航，因为Pager会自动响应状态变化
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
                                                navController.navigate(title)
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

                    // 右侧圆形按钮 - 根据页面类型选择性显示
                    if (shouldShowActionButton(selectedTabIndex)) {
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
    }
}
