package com.madsam.otora.ui.bof

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madsam.otora.BofScreenState
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.`Arrow-left`
import com.madsam.otora.core.icon.fa.Calendar
import com.madsam.otora.core.icon.fa.Camera
import com.madsam.otora.core.icon.fa.`Magnifying-glass`
import com.madsam.otora.core.icon.fa.Xmark
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red800
import com.madsam.otora.data.bof.remote.api.BofRequestService
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import com.madsam.otora.ui.bof.components.DateTimeRangePicker
import com.madsam.otora.ui.bof.sub.BofCommentScreen
import com.madsam.otora.ui.bof.sub.BofEntryPagerScreen
import com.madsam.otora.ui.bof.sub.BofTeamRankingScreen
import com.madsam.otora.ui.components.CustomScrollableTabRow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

private const val TAG = "BofScreen"

// Material 3 Motion 规范的缓动曲线
// https://m3.material.io/styles/motion/easing-and-duration/tokens-specs
// Standard easing - 更温和，适合小到中等尺寸的UI元素
private val StandardDecelerate = CubicBezierEasing(0f, 0f, 0f, 1f) // 进入动画：线性开始，减速结束
private val StandardAccelerate = CubicBezierEasing(0.3f, 0f, 1f, 1f) // 退出动画：加速开始，线性结束

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BofScreen(
    bofScreenState: BofScreenState,
    onNavigateBack: () -> Unit = {}
) {
    Log.d(TAG, "BofScreen Compose started")
    
    // BofScreen 内部创建自己的 SnackbarHostState
    val snackbarHostState = remember { SnackbarHostState() }

    // 拦截系统返回事件（包括边缘侧滑返回）
    BackHandler {
        onNavigateBack()
    }

    // BofScreen 内部创建自己的 NavController
    val navController = rememberNavController()

    Log.d(TAG, "Creating BofRequestService")
    val bofRequestService = BofRequestService()

    Log.d(TAG, "Creating BofViewModel")
    val vm: BofViewModel = viewModel(factory = BofViewModelFactory(bofScreenState))
    Log.d(TAG, "BofViewModel created")

    // Range 数据状态
    var rangeData by remember { mutableStateOf<List<BofRangeResponse>>(emptyList()) }
    // 统一使用 bofScreenState.selectedRange，不再使用本地状态
    val selectedRange by bofScreenState.selectedRange.collectAsState()

    // 获取 range 数据
    LaunchedEffect(Unit) {
        try {
            val ranges = bofRequestService.getBofRangeDataPublic()
            if (ranges != null) {
                // 按日期倒序排序（最新的在前）
                rangeData = ranges.sortedByDescending { it.start }
                // 默认选择第一个可用的 range（只在首次或为空时设置）
                if (bofScreenState.selectedRange.value == null) {
                    val defaultRange = rangeData.firstOrNull { it.isStart }
                    bofScreenState.selectedRange.value = defaultRange
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to load range data: ${e.message}")
        }
    }

    val selectedTabIndex = bofScreenState.selectedTab.asStateFlow().collectAsState().value
    val selectedSubTabIndex = bofScreenState.selectedSubTab.asStateFlow().collectAsState().value

    // 使用 ViewModel 的 searchText
    val searchText = vm.searchText.collectAsState()

    // 为每个页面创建 LazyListState
    val listStateTotal = rememberLazyListState()
    val listStateAvg = rememberLazyListState()
    val listStateMedian = rememberLazyListState()
    val listStateDiff = rememberLazyListState()
    val listStateComposite = rememberLazyListState()
    val listStateTeam = rememberLazyListState()
    val listStateComment = rememberLazyListState()

    // 监听搜索结果，自动滚动到匹配项
    val currentMatchIndex = vm.currentMatchIndex.collectAsState()
    val matchedIndices = vm.matchedIndices.collectAsState()

    var showDateTimeRangePicker by remember { mutableStateOf(false) }
    val scrollThreshold = 50f

    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    val screenWidthDp = with(density) {
        windowInfo.containerSize.width.toDp()
    }
    var entryInfoMode by remember { mutableIntStateOf(0) }
    var teamInfoMode by remember { mutableIntStateOf(0) }
    var commentInfoMode by remember { mutableIntStateOf(0) }

    // 截图对话框状态
    var showEntryCaptureDialog by remember { mutableStateOf(false) }
    var showTeamCaptureDialog by remember { mutableStateOf(false) }
    var showCommentCaptureDialog by remember { mutableStateOf(false) }

    fun selectTime() {
        showDateTimeRangePicker = true
    }

    // 监听 selectedRange 和时间变化，自动加载数据
    LaunchedEffect(
        selectedRange,
        bofScreenState.selectedCurrentDate.collectAsState().value,
        bofScreenState.selectedCurrentTime.collectAsState().value,
        bofScreenState.selectedCompareDate.collectAsState().value,
        bofScreenState.selectedCompareTime.collectAsState().value
    ) {
        // 只有当 selectedRange 不为空时才加载数据
        selectedRange?.let { range ->
            vm.loadRankingData()

            if (range.isStart) {
                vm.loadTeamRankingData(range.path)
                vm.requestCommentData()
            }
        }
    }

    if (showDateTimeRangePicker) {
        DateTimeRangePicker(
            bofScreenState = bofScreenState,
            rangeData = rangeData,
            onDismissRequest = {
                showDateTimeRangePicker = false
            }
        )
    }

    // 监听 tab 切换，重新执行搜索
    LaunchedEffect(selectedTabIndex, selectedSubTabIndex) {
        val query = searchText.value
        if (query.isNotEmpty() && selectedRange?.isStart == true) {
            Log.d(
                "BofScreen",
                "Tab switched, re-executing search: mainTab=$selectedTabIndex, subTab=$selectedSubTabIndex"
            )
            when (selectedTabIndex) {
                0 -> {
                    // Entry 页面 - 根据 sub tab 搜索对应的排行榜
                    vm.search(query, selectedSubTabIndex) // 0=总分, 1=平均, 2=中位数, 3=差值, 4=综合
                }

                1 -> {
                    // Team 页面 - tabIndex = 5
                    vm.search(query, 5)
                }

                2 -> {
                    // Comment 页面 - tabIndex = 6
                    vm.search(query, 6)
                }
            }
        }
    }

    LaunchedEffect(
        selectedTabIndex,
        selectedSubTabIndex,
        currentMatchIndex.value,
        matchedIndices.value
    ) {
        // 计算当前应该滚动到的索引
        val scrollIndex = if (matchedIndices.value.isNotEmpty() &&
            currentMatchIndex.value >= 0 &&
            currentMatchIndex.value < matchedIndices.value.size
        ) {
            matchedIndices.value[currentMatchIndex.value]
        } else {
            -1
        }

        // 只有当有匹配项时才滚动
        if (scrollIndex >= 0) {
            Log.d(
                "BofScreen",
                "Scrolling to index: $scrollIndex, mainTab: $selectedTabIndex, subTab: $selectedSubTabIndex, match: ${currentMatchIndex.value}/${matchedIndices.value.size}"
            )

            when (selectedTabIndex) {
                0 -> { // Entry 页面，根据子页面选择不同的 listState
                    when (selectedSubTabIndex) {
                        0 -> listStateTotal.animateScrollToItem(scrollIndex)
                        1 -> listStateAvg.animateScrollToItem(scrollIndex)
                        2 -> listStateMedian.animateScrollToItem(scrollIndex)
                        3 -> listStateDiff.animateScrollToItem(scrollIndex)
                        4 -> listStateComposite.animateScrollToItem(scrollIndex)
                    }
                    Log.d(
                        "BofScreen",
                        "Entry subTab $selectedSubTabIndex scrolled to: $scrollIndex"
                    )
                }

                1 -> { // Team 页面
                    listStateTeam.animateScrollToItem(scrollIndex)
                    Log.d("BofScreen", "Team scrolled to: $scrollIndex")
                }

                2 -> { // Comment 页面
                    listStateComment.animateScrollToItem(scrollIndex)
                    Log.d("BofScreen", "Comment scrolled to: $scrollIndex")
                }
            }
        } else {
            Log.d(
                "BofScreen",
                "No scroll - scrollIndex: $scrollIndex, matches: ${matchedIndices.value.size}"
            )
        }
    }

    val tabTitles = mapOf(
        "Entry" to listOf("Total", "Avg", "Median", "Diff", "Composite"),
        "Team" to emptyList(),
        "Comment" to emptyList()
    )

    val mainTabTitles = tabTitles.keys.toList()

    Log.d(TAG, "Starting UI render")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            // 顶部导航栏：左侧返回按钮 + 右侧主Tab
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.statusBars)
                    .background(Color.Black)
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 左侧圆形返回按钮
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Red500)
                        .clickable {
                            onNavigateBack()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Fa.`Arrow-left`,
                        contentDescription = "Back",
                        tint = Beige400,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // 右侧主Tab栏
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(24.dp))
                ) {
                    val contentWidthDp = screenWidthDp - 24.dp - 48.dp - 12.dp // 减去左侧按钮和间距

                    CustomScrollableTabRow(
                        selectedTabIndex = selectedTabIndex,
                        containerColor = Red500,
                        containerWidthDp = contentWidthDp,
                        tabs = { _ ->
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
                                    modifier = Modifier.height(48.dp)
                                )
                            }
                        }
                    )
                }
            }

            // 检查活动是否开始
            if (selectedRange?.isStart != true) {
                // 活动未开始时显示提示信息
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "活动尚未开始",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Beige400,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = selectedRange?.full ?: "请选择一个活动",
                            fontSize = 16.sp,
                            color = Beige600,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        selectedRange?.start?.let { startTime ->
                            Text(
                                text = "开始时间: $startTime",
                                fontSize = 14.sp,
                                color = Beige600,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            } else {
                // 活动已开始时显示正常内容
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
                                    snackbarHostState = snackbarHostState,
                                    narrowMode = entryInfoMode,
                                    searchText = searchText.value,
                                    scrollThreshold = scrollThreshold,
                                    setIsTabRowVisible = { },
                                    showCaptureDialog = showEntryCaptureDialog,
                                    onCaptureDialogDismiss = { showEntryCaptureDialog = false },
                                    listStateTotal = listStateTotal,
                                    listStateAvg = listStateAvg,
                                    listStateMedian = listStateMedian,
                                    listStateDiff = listStateDiff,
                                    listStateComposite = listStateComposite
                                )

                                "Team" -> BofTeamRankingScreen(
                                    bofScreenState = bofScreenState,
                                    vm = vm,
                                    snackbarHostState = snackbarHostState,
                                    teamInfoMode = teamInfoMode,
                                    scrollThreshold = scrollThreshold,
                                    setIsTabRowVisible = { },
                                    showCaptureDialog = showTeamCaptureDialog,
                                    onCaptureDialogDismiss = { showTeamCaptureDialog = false }
                                )

                                "Comment" -> {
                                    val commentData by vm.commentData.collectAsState()
                                    val selectedTimeStrNoComp by vm.selectedTimeStrNoComp.collectAsState()
                                    val selectedRange =
                                        bofScreenState.selectedRange.collectAsState().value
                                    var title = "评价排行榜"
                                    var subtitle = "时间: $selectedTimeStrNoComp"

                                    if (selectedRange?.singleComment == true && selectedRange.commentDate.isNotEmpty()) {
                                        title = "最终评价排行榜"
                                        subtitle = "时间: ${selectedRange.commentDate} (仅单日)"
                                    }

                                    BofCommentScreen(
                                        commentData = commentData,
                                        title = title,
                                        subtitle = subtitle,
                                        commentDisplayMode = commentInfoMode,
                                        scrollThreshold = scrollThreshold,
                                        setIsTabRowVisible = { },
                                        showCaptureDialog = showCommentCaptureDialog,
                                        onCaptureDialogDismiss = {
                                            showCommentCaptureDialog = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // 底部工具栏（仅在活动开始时显示）
        if (selectedRange?.isStart == true) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .windowInsetsPadding(
                        WindowInsets.navigationBars.union(WindowInsets.ime)
                            .only(WindowInsetsSides.Bottom)
                    )
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(28.dp))
                        .background(Red500)
                        .animateContentSize(animationSpec = tween(250))
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val isSearching = searchText.value.isNotEmpty()

                    // 截图按钮（带动画）
                    // 注意：为了配合搜索框的扩展/收缩动画，按钮的进入和退出都使用 StandardDecelerate
                    AnimatedVisibility(
                        visible = !isSearching && (selectedTabIndex == 0 || selectedTabIndex == 1 || selectedTabIndex == 2),
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            )
                        ) + expandHorizontally(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            ),
                            expandFrom = Alignment.Start
                        ) + scaleIn(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            ),
                            initialScale = 0.8f
                        ),
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            )
                        ) + shrinkHorizontally(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            ),
                            shrinkTowards = Alignment.Start
                        ) + scaleOut(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            ),
                            targetScale = 0.8f
                        )
                    ) {
                        Box(modifier = Modifier.padding(end = 8.dp)) {
                            IconButton(
                                onClick = {
                                    when (selectedTabIndex) {
                                        0 -> showEntryCaptureDialog = true
                                        1 -> showTeamCaptureDialog = true
                                        2 -> showCommentCaptureDialog = true
                                    }
                                },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = Fa.Camera,
                                    contentDescription = "Screenshot",
                                    tint = Beige400,
                                    modifier = Modifier.height(24.dp)
                                )
                            }
                        }
                    }

                    // 日期时间选择按钮（带动画）
                    // 注意：为了配合搜索框的扩展/收缩动画，按钮的进入和退出都使用 StandardDecelerate
                    AnimatedVisibility(
                        visible = !isSearching,
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            )
                        ) + expandHorizontally(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            ),
                            expandFrom = Alignment.Start
                        ) + scaleIn(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            ),
                            initialScale = 0.8f
                        ),
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            )
                        ) + shrinkHorizontally(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            ),
                            shrinkTowards = Alignment.Start
                        ) + scaleOut(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = StandardDecelerate
                            ),
                            targetScale = 0.8f
                        )
                    ) {
                        Box(modifier = Modifier.padding(end = 8.dp)) {
                            IconButton(
                                onClick = { selectTime() },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = Fa.Calendar,
                                    contentDescription = "Date&Time",
                                    tint = Beige400,
                                    modifier = Modifier.height(24.dp)
                                )
                            }
                        }
                    }

                    // 搜索框 - 使用 BasicTextField 自定义布局以精确控制 48dp 高度
                    val focusManager = LocalFocusManager.current
                    val keyboardController = LocalSoftwareKeyboardController.current

                    BasicTextField(
                        value = searchText.value,
                        onValueChange = { query ->
                            // 只有在活动开始时才处理搜索
                            if (selectedRange?.isStart == true) {
                                when (selectedTabIndex) {
                                    0 -> vm.search(query, selectedSubTabIndex)
                                    1 -> vm.search(query, 5)
                                    2 -> vm.search(query, 6)
                                }
                            } else {
                                vm.search("", 0)
                            }
                        },
                        modifier = Modifier
                            .weight(1f, fill = true)
                            .height(48.dp)
                            .animateContentSize(
                                animationSpec = tween(
                                    durationMillis = 300,
                                    easing = StandardDecelerate
                                )
                            ),
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Beige400,
                            lineHeight = 20.sp
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                                keyboardController?.hide()
                            }
                        ),
                        singleLine = true,
                        cursorBrush = SolidColor(Beige400),
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Red800, RoundedCornerShape(24.dp))
                                    .padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Leading icon
                                Icon(
                                    painter = rememberVectorPainter(image = Fa.`Magnifying-glass`),
                                    contentDescription = "Search",
                                    tint = Beige400,
                                    modifier = Modifier.size(20.dp)
                                )
                                
                                Spacer(modifier = Modifier.width(12.dp))
                                
                                // Text field with placeholder
                                Box(
                                    modifier = Modifier.weight(1f),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    if (searchText.value.isEmpty()) {
                                        Text(
                                            text = "搜索...",
                                            color = Beige600,
                                            fontSize = 14.sp,
                                            lineHeight = 20.sp
                                        )
                                    }
                                    innerTextField()
                                }
                                
                                // Trailing clear button
                                if (searchText.value.isNotEmpty()) {
                                    Spacer(modifier = Modifier.width(8.dp))
                                    IconButton(
                                        onClick = {
                                            vm.search("", 0)
                                            focusManager.clearFocus()
                                        },
                                        modifier = Modifier.size(32.dp)
                                    ) {
                                        Icon(
                                            painter = rememberVectorPainter(image = Fa.Xmark),
                                            contentDescription = "Clear",
                                            tint = Beige400,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }
                            }
                        }
                    )

                    // 搜索导航按钮（带动画）
                    // 注意：为了配合搜索框的扩展/收缩动画，按钮的进入和退出都使用 StandardDecelerate
                    AnimatedVisibility(
                        visible = isSearching && matchedIndices.value.isNotEmpty(),
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 200,
                                easing = StandardDecelerate
                            )
                        ) + expandHorizontally(
                            animationSpec = tween(
                                durationMillis = 200,
                                easing = StandardDecelerate
                            ),
                            expandFrom = Alignment.End
                        ) + slideInHorizontally(
                            initialOffsetX = { it / 2 },
                            animationSpec = tween(
                                durationMillis = 200,
                                easing = StandardDecelerate
                            )
                        ),
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 200,
                                easing = StandardDecelerate
                            )
                        ) + shrinkHorizontally(
                            animationSpec = tween(
                                durationMillis = 200,
                                easing = StandardDecelerate
                            ),
                            shrinkTowards = Alignment.End
                        ) + slideOutHorizontally(
                            targetOffsetX = { it / 2 },
                            animationSpec = tween(
                                durationMillis = 200,
                                easing = StandardDecelerate
                            )
                        )
                    ) {
                        Box(modifier = Modifier.padding(start = 8.dp)) {
                            Column(
                                modifier = Modifier.size(48.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                IconButton(
                                    onClick = { vm.scrollToPrevious() },
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Icon(
                                        painter = rememberVectorPainter(image = Filled.ChevronUp),
                                        contentDescription = "上一个",
                                        tint = Beige400,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                                IconButton(
                                    onClick = { vm.scrollToNext() },
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Icon(
                                        painter = rememberVectorPainter(image = Filled.ChevronDown),
                                        contentDescription = "下一个",
                                        tint = Beige400,
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
