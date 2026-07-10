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
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.TrendingDown
import androidx.compose.material.icons.automirrored.rounded.TrendingUp
import androidx.compose.material.icons.rounded.CalendarToday
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.SwapHoriz
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.madsam.otora.BofScreenState
import com.madsam.otora.R
import com.madsam.otora.core.utils.DateTimeUtils
import com.madsam.otora.data.bof.remote.api.BofRequestService
import com.madsam.otora.data.bof.remote.model.BofRangeResponse
import com.madsam.otora.ui.bof.components.DateTimeRangePicker
import com.madsam.otora.ui.bof.sub.BofCommentPagerScreen
import com.madsam.otora.ui.bof.sub.BofEntryPagerScreen
import com.madsam.otora.ui.bof.sub.BofTeamPagerScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

private const val TAG = "BofScreen"

// Material icons use different internal path bounds, so toolbar sizes are optically balanced.
private val BofToolbarIconSize = 22.dp
private val BofToolbarWideIconSize = 26.dp
private val BofToolbarCameraIconSize = 24.dp
private val BofToolbarCalendarOpticalOffset = (-1).dp
private val BofToolbarSecondaryIconSize = 18.dp

// Material 3 Motion 规范的缓动曲线
// https://m3.material.io/styles/motion/easing-and-duration/tokens-specs
// Standard easing - 更温和，适合小到中等尺寸的UI元素
private val StandardDecelerate = CubicBezierEasing(0f, 0f, 0f, 1f) // 线性开始，减速结束

@Composable
private fun BofModeSwitcher(
    sectionLabel: String,
    subtitle: String,
    modeLabels: List<String>,
    pagerState: PagerState,
    onModeSelected: (Int) -> Unit,
    onNavigateBack: () -> Unit
) {
    val scope = rememberCoroutineScope()
    var expanded by remember(sectionLabel) { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars)
            .background(BofRankingColors.Background)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(50))
                .background(BofRankingColors.BackContainer)
                .clickable { onNavigateBack() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                contentDescription = stringResource(R.string.settings_back),
                tint = BofRankingColors.OnBackContainer,
                modifier = Modifier.size(20.dp)
            )
        }

        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .height(84.dp),
            contentAlignment = Alignment.Center
        ) {
            val density = LocalDensity.current
            val longestLabelLength = modeLabels.maxOfOrNull { it.length } ?: 5
            val labelBasedWidth = (longestLabelLength * 12 + 40).dp
            val maxItemWidth = if (maxWidth < 300.dp) 128.dp else 156.dp
            val carouselItemWidth = when {
                labelBasedWidth < 96.dp -> 96.dp
                labelBasedWidth > maxItemWidth -> maxItemWidth
                else -> labelBasedWidth
            }
            val itemStridePx = with(density) { (carouselItemWidth + 4.dp).toPx() }
            val currentPage = pagerState.currentPage.coerceIn(
                0,
                (modeLabels.size - 1).coerceAtLeast(0)
            )

            modeLabels.forEachIndexed { page, label ->
                if ((page - currentPage).absoluteValue <= 2) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(carouselItemWidth)
                            .height(48.dp)
                            .graphicsLayer {
                                val relativePosition =
                                    (page - pagerState.currentPage) -
                                        pagerState.currentPageOffsetFraction
                                val focus = (1f - relativePosition.absoluteValue).coerceIn(0f, 1f)
                                translationX = relativePosition * itemStridePx
                                translationY = if (subtitle.isBlank()) 0f else -12.dp.toPx()
                                alpha = if (relativePosition.absoluteValue <= 1.65f) {
                                    0.28f + focus * 0.72f
                                } else {
                                    0f
                                }
                                val scale = 0.76f + focus * 0.24f
                                scaleX = scale
                                scaleY = scale
                            }
                            .clickable {
                                if (
                                    page == pagerState.currentPage &&
                                    !pagerState.isScrollInProgress
                                ) {
                                    expanded = true
                                } else {
                                    scope.launch {
                                        pagerState.animateScrollToPage(page)
                                        onModeSelected(page)
                                    }
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = label,
                            color = BofRankingColors.Text,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            if (subtitle.isNotBlank()) {
                Text(
                    text = subtitle,
                    color = BofRankingColors.Text.copy(alpha = 0.62f),
                    fontSize = 11.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 8.dp)
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                containerColor = BofRankingColors.Header
            ) {
                modeLabels.forEachIndexed { index, label ->
                    DropdownMenuItem(
                        text = { Text(text = label, color = BofRankingColors.Text) },
                        onClick = {
                            expanded = false
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                                onModeSelected(index)
                            }
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BofScreen(
    bofScreenState: BofScreenState,
    onNavigateBack: () -> Unit = {}
) {
    Log.d(TAG, "BofScreen Compose started")

    val snackbarHostState = remember { SnackbarHostState() }

    // 拦截系统返回事件（包括边缘侧滑返回）
    BackHandler {
        onNavigateBack()
    }

    val bofRequestService = BofRequestService()
    val vm: BofViewModel = viewModel(factory = BofViewModelFactory(bofScreenState))

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
    val selectedTeamSubTabIndex = bofScreenState.selectedTeamSubTab.asStateFlow().collectAsState().value
    val selectedCommentSubTabIndex = bofScreenState.selectedCommentSubTab.asStateFlow().collectAsState().value
    val selectedCurrentDate = bofScreenState.selectedCurrentDate.collectAsState().value
    val selectedCurrentTime = bofScreenState.selectedCurrentTime.collectAsState().value
    val selectedCompareDate = bofScreenState.selectedCompareDate.collectAsState().value
    val selectedCompareTime = bofScreenState.selectedCompareTime.collectAsState().value
    val selectedTimeStrNoComp by vm.selectedTimeStrNoComp.collectAsState()
    val entryModePagerState = rememberPagerState(
        initialPage = selectedSubTabIndex.coerceIn(0, 4),
        pageCount = { 5 }
    )
    val teamModePagerState = rememberPagerState(
        initialPage = selectedTeamSubTabIndex.coerceIn(0, 1),
        pageCount = { 2 }
    )
    val commentModePagerState = rememberPagerState(
        initialPage = selectedCommentSubTabIndex.coerceIn(0, 1),
        pageCount = { 2 }
    )
    val safeSectionIndex = selectedTabIndex.coerceIn(0, 2)
    val sectionLabel = when (safeSectionIndex) {
        0 -> stringResource(R.string.bof_section_entry)
        1 -> stringResource(R.string.bof_section_team)
        else -> stringResource(R.string.bof_section_comment)
    }
    val modeLabels = when (safeSectionIndex) {
        0 -> listOf(
            stringResource(R.string.bof_mode_total),
            stringResource(R.string.bof_mode_average),
            stringResource(R.string.bof_mode_median),
            stringResource(R.string.bof_mode_difference),
            stringResource(R.string.bof_mode_composite)
        )
        1 -> listOf(
            stringResource(R.string.bof_mode_total),
            stringResource(R.string.bof_mode_difference)
        )
        else -> listOf(
            stringResource(R.string.bof_mode_total),
            stringResource(R.string.bof_mode_difference)
        )
    }
    val activeModePagerState = when (safeSectionIndex) {
        0 -> entryModePagerState
        1 -> teamModePagerState
        else -> commentModePagerState
    }
    val timeLabel = stringResource(R.string.bof_time_label)
    val currentTimeLabel = stringResource(R.string.bof_time_current)
    val compareTimeLabel = stringResource(R.string.bof_time_compare)
    val singleDayLabel = stringResource(R.string.bof_time_single_day)
    val notStartedTitle = stringResource(R.string.bof_not_started_title)
    val selectEventLabel = stringResource(R.string.bof_select_event)
    val switchPositiveDiffDescription = stringResource(R.string.bof_action_switch_positive_diff)
    val switchReverseDiffDescription = stringResource(R.string.bof_action_switch_reverse_diff)
    val switchToDetailDescription = stringResource(R.string.bof_action_switch_to_detail)
    val switchToScoreDescription = stringResource(R.string.bof_action_switch_to_score)
    val screenshotDescription = stringResource(R.string.bof_action_screenshot)
    val dateTimeDescription = stringResource(R.string.bof_action_date_time)
    val searchDescription = stringResource(R.string.bof_action_search)
    val clearSearchDescription = stringResource(R.string.bof_action_clear)
    val previousMatchDescription = stringResource(R.string.bof_action_previous_match)
    val nextMatchDescription = stringResource(R.string.bof_action_next_match)
    val searchPlaceholder = stringResource(R.string.bof_search_placeholder)
    val roundedCurrentTime = remember(selectedCurrentTime) {
        DateTimeUtils.roundDownToNearestFiveMinutes(selectedCurrentTime)
    }
    val roundedCompareTime = remember(selectedCompareTime) {
        DateTimeUtils.roundDownToNearestFiveMinutes(selectedCompareTime)
    }
    val commentDate = selectedRange?.commentDate.orEmpty()
    val commentTimeText = selectedTimeStrNoComp.ifEmpty {
        "$selectedCurrentDate $roundedCurrentTime"
    }
    val headerSubtitle = when {
        selectedRange?.isStart != true -> selectedRange?.full.orEmpty()
        safeSectionIndex == 2 &&
            selectedRange?.singleComment == true &&
            commentDate.isNotEmpty() ->
            "$timeLabel $commentDate ($singleDayLabel)"
        safeSectionIndex == 2 ->
            "$timeLabel $commentTimeText"
        else ->
            "$currentTimeLabel $selectedCurrentDate $roundedCurrentTime\n" +
                "$compareTimeLabel $selectedCompareDate $roundedCompareTime"
    }

    fun selectBofMode(index: Int) {
        val safeIndex = index.coerceIn(0, modeLabels.lastIndex)
        when (safeSectionIndex) {
            0 -> bofScreenState.selectedSubTab.update { safeIndex }
            1 -> bofScreenState.selectedTeamSubTab.update { safeIndex }
            else -> bofScreenState.selectedCommentSubTab.update { safeIndex }
        }
    }

    // 使用 ViewModel 的 searchText
    val searchText = vm.searchText.collectAsState()

    // 为每个页面创建 LazyListState
    val listStateTotal = rememberLazyListState()
    val listStateAvg = rememberLazyListState()
    val listStateMedian = rememberLazyListState()
    val listStateDiff = rememberLazyListState()
    val listStateComposite = rememberLazyListState()
    val listStateTeam = rememberLazyListState()
    val listStateTeamDiff = rememberLazyListState()
    val listStateComment = rememberLazyListState()
    val listStateCommentDiff = rememberLazyListState()

    // 监听搜索结果，自动滚动到匹配项
    val currentMatchIndex = vm.currentMatchIndex.collectAsState()
    val matchedIndices = vm.matchedIndices.collectAsState()

    // 日期时间范围选择器的显示状态
    val showDateTimeRangePicker = remember { MutableStateFlow(false) }
    val showDateTimeRangePickerState = showDateTimeRangePicker.collectAsState()
    val scrollThreshold = 50f

    var entryInfoMode by remember { mutableIntStateOf(0) }
    var teamInfoMode by remember { mutableIntStateOf(0) }
    var commentInfoMode by remember { mutableIntStateOf(0) }

    // 截图对话框状态
    var showEntryCaptureDialog by remember { mutableStateOf(false) }
    var showTeamCaptureDialog by remember { mutableStateOf(false) }
    var showCommentCaptureDialog by remember { mutableStateOf(false) }

    fun selectTime() {
        showDateTimeRangePicker.update { true }
    }

    // 监听 selectedRange 和时间变化，自动加载数据
    LaunchedEffect(
        selectedRange,
        selectedCurrentDate,
        selectedCurrentTime,
        selectedCompareDate,
        selectedCompareTime
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

    if (showDateTimeRangePickerState.value) {
        DateTimeRangePicker(
            bofScreenState = bofScreenState,
            rangeData = rangeData,
            onDismissRequest = {
                showDateTimeRangePicker.update { false }
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

    Log.d(TAG, "Starting UI render")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BofRankingColors.Background)
        ) {
            // 顶部导航栏：左侧返回按钮 + 右侧主Tab
            BofModeSwitcher(
                sectionLabel = sectionLabel,
                subtitle = headerSubtitle,
                modeLabels = modeLabels,
                pagerState = activeModePagerState,
                onModeSelected = ::selectBofMode,
                onNavigateBack = onNavigateBack
            )

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
                            text = notStartedTitle,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = BofRankingColors.Text,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = selectedRange?.full ?: selectEventLabel,
                            fontSize = 16.sp,
                            color = BofRankingColors.TextSecondary,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        selectedRange?.start?.let { startTime ->
                            Text(
                                text = stringResource(R.string.bof_start_time_format, startTime),
                                fontSize = 14.sp,
                                color = BofRankingColors.TextSecondary,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            } else {
                // 活动已开始时显示正常内容
                Box(modifier = Modifier.weight(1f)) {
                    when (safeSectionIndex) {
                        0 -> BofEntryPagerScreen(
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
                            listStateComposite = listStateComposite,
                            providedPagerState = entryModePagerState
                        )

                        1 -> BofTeamPagerScreen(
                            vm = vm,
                            bofScreenState = bofScreenState,
                            snackbarHostState = snackbarHostState,
                            teamInfoMode = teamInfoMode,
                            scrollThreshold = scrollThreshold,
                            setIsTabRowVisible = { },
                            showCaptureDialog = showTeamCaptureDialog,
                            onCaptureDialogDismiss = { showTeamCaptureDialog = false },
                            listStateTotal = listStateTeam,
                            listStateDiff = listStateTeamDiff,
                            providedPagerState = teamModePagerState
                        )

                        else -> {
                            val selectedTimeStrNoComp by vm.selectedTimeStrNoComp.collectAsState()
                            val currentRange = bofScreenState.selectedRange.collectAsState().value
                            val title = if (currentRange?.singleComment == true && currentRange.commentDate.isNotEmpty()) {
                                stringResource(R.string.bof_comment_title_final)
                            } else {
                                stringResource(R.string.bof_comment_title)
                            }
                            val subtitle = if (currentRange?.singleComment == true && currentRange.commentDate.isNotEmpty()) {
                                stringResource(R.string.bof_time_value, currentRange.commentDate)
                            } else {
                                stringResource(R.string.bof_time_value, selectedTimeStrNoComp)
                            }

                            BofCommentPagerScreen(
                                vm = vm,
                                bofScreenState = bofScreenState,
                                title = title,
                                subtitle = subtitle,
                                commentDisplayMode = commentInfoMode,
                                scrollThreshold = scrollThreshold,
                                setIsTabRowVisible = { },
                                showCaptureDialog = showCommentCaptureDialog,
                                onCaptureDialogDismiss = {
                                    showCommentCaptureDialog = false
                                },
                                listStateTotal = listStateComment,
                                listStateDiff = listStateCommentDiff,
                                providedPagerState = commentModePagerState
                            )
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
                        .background(BofRankingColors.ToolbarContainer)
                        .animateContentSize(animationSpec = tween(250))
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val isSearching = searchText.value.isNotEmpty()
                    val showInfoToggle = when (selectedTabIndex) {
                        0 -> selectedSubTabIndex == 0
                        1 -> selectedTeamSubTabIndex == 0
                        2 -> selectedCommentSubTabIndex == 0
                        else -> false
                    }
                    val currentInfoMode = when (selectedTabIndex) {
                        0 -> entryInfoMode
                        1 -> teamInfoMode
                        2 -> commentInfoMode
                        else -> 0
                    }
                    
                    // Entry 差值切换按钮
                    val showReverseDiff by bofScreenState.showReverseDiff.collectAsState()
                    // Team 差值切换按钮
                    val showTeamReverseDiff by bofScreenState.showTeamReverseDiff.collectAsState()
                    // Comment 差值切换按钮
                    val showCommentReverseDiff by bofScreenState.showCommentReverseDiff.collectAsState()
                    
                    // 差值切换按钮（在 Entry/Team/Comment 的 Diff 子页面显示）
                    val showDiffToggle = when (selectedTabIndex) {
                        0 -> selectedSubTabIndex == 3 // Entry 的 Diff 页面
                        1 -> selectedTeamSubTabIndex == 1 // Team 的 Diff 页面
                        2 -> selectedCommentSubTabIndex == 1 // Comment 的 Diff 页面
                        else -> false
                    }
                    
                    val currentShowReverse = when (selectedTabIndex) {
                        0 -> showReverseDiff
                        1 -> showTeamReverseDiff
                        2 -> showCommentReverseDiff
                        else -> false
                    }
                    
                    AnimatedVisibility(
                        visible = !isSearching && showDiffToggle,
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
                                        0 -> bofScreenState.showReverseDiff.update { !it }
                                        1 -> bofScreenState.showTeamReverseDiff.update { !it }
                                        2 -> bofScreenState.showCommentReverseDiff.update { !it }
                                    }
                                },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = if (currentShowReverse) {
                                        Icons.AutoMirrored.Rounded.TrendingUp
                                    } else {
                                        Icons.AutoMirrored.Rounded.TrendingDown
                                    },
                                    contentDescription = if (currentShowReverse) {
                                        switchPositiveDiffDescription
                                    } else {
                                        switchReverseDiffDescription
                                    },
                                    tint = BofRankingColors.Text,
                                    modifier = Modifier.size(BofToolbarIconSize)
                                )
                            }
                        }
                    }

                    // 显示模式切换按钮（带动画）
                    // 注意：为了配合搜索框的扩展/收缩动画，按钮的进入和退出都使用 StandardDecelerate
                    AnimatedVisibility(
                        visible = !isSearching && showInfoToggle,
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
                                        0 -> entryInfoMode = (entryInfoMode + 1) % 2
                                        1 -> teamInfoMode = (teamInfoMode + 1) % 2
                                        2 -> commentInfoMode = (commentInfoMode + 1) % 2
                                    }
                                },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.SwapHoriz,
                                    contentDescription = if (currentInfoMode == 0) {
                                        switchToDetailDescription
                                    } else {
                                        switchToScoreDescription
                                    },
                                    tint = BofRankingColors.Text,
                                    modifier = Modifier.size(BofToolbarWideIconSize)
                                )
                            }
                        }
                    }

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
                                    imageVector = Icons.Rounded.PhotoCamera,
                                    contentDescription = screenshotDescription,
                                    tint = BofRankingColors.Text,
                                    modifier = Modifier.size(BofToolbarCameraIconSize)
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
                                    imageVector = Icons.Rounded.CalendarToday,
                                    contentDescription = dateTimeDescription,
                                    tint = BofRankingColors.Text,
                                    modifier = Modifier
                                        .size(BofToolbarIconSize)
                                        .offset(y = BofToolbarCalendarOpticalOffset)
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
                            color = BofRankingColors.OnPrimaryContainer,
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
                        cursorBrush = SolidColor(BofRankingColors.OnPrimaryContainer),
                        decorationBox = { innerTextField ->
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(BofRankingColors.PrimaryContainer, RoundedCornerShape(24.dp))
                                    .padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Leading icon
                                Icon(
                                    imageVector = Icons.Rounded.Search,
                                    contentDescription = searchDescription,
                                    tint = BofRankingColors.OnPrimaryContainer,
                                    modifier = Modifier.size(BofToolbarIconSize)
                                )
                                
                                Spacer(modifier = Modifier.width(12.dp))
                                
                                // Text field with placeholder
                                Box(
                                    modifier = Modifier.weight(1f),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    if (searchText.value.isEmpty()) {
                                        Text(
                                            text = searchPlaceholder,
                                            color = BofRankingColors.OnPrimaryContainer.copy(alpha = 0.72f),
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
                                            imageVector = Icons.Rounded.Close,
                                            contentDescription = clearSearchDescription,
                                            tint = BofRankingColors.OnPrimaryContainer,
                                            modifier = Modifier.size(BofToolbarSecondaryIconSize)
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
                                        imageVector = Icons.Rounded.KeyboardArrowUp,
                                        contentDescription = previousMatchDescription,
                                        tint = BofRankingColors.Text,
                                        modifier = Modifier.size(BofToolbarSecondaryIconSize)
                                    )
                                }
                                IconButton(
                                    onClick = { vm.scrollToNext() },
                                    modifier = Modifier.size(24.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.KeyboardArrowDown,
                                        contentDescription = nextMatchDescription,
                                        tint = BofRankingColors.Text,
                                        modifier = Modifier.size(BofToolbarSecondaryIconSize)
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
