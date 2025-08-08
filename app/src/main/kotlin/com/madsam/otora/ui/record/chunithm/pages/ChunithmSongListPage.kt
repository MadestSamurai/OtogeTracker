package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.interTightBold
import com.madsam.otora.core.theme.interTightRegular
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.ChunithmSongCard
import com.madsam.otora.ui.record.chunithm.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ChunithmSongListPage(
    viewModel: ChunithmViewModel,
    scrollThreshold: Float,
    setIsTabRowVisible: (Boolean) -> Unit,
    onNavigateToSongDetail: (String) -> Unit
) {
    val context = LocalContext.current
    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }

    // 监听特定状态变化来实时更新数据
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    LaunchedEffect(isRefreshing) {
        // 当刷新状态变化且刷新完成时重新加载数据
        if (!isRefreshing) {
            viewModel.loadAllSongsData()
        }
    }

    // 初始数据加载
    LaunchedEffect(Unit) {
        viewModel.loadAllSongsData()
    }
    val state = rememberPullToRefreshState()

    val searchText by viewModel.searchText.collectAsState()
    val songList by viewModel.chuniSongs.collectAsState()

    val lazyListState = rememberLazyListState()

    // 监听回到顶部事件
    val scrollToTopEvent by viewModel.scrollSongListToTopEvent.collectAsState()
    LaunchedEffect(scrollToTopEvent) {
        if (scrollToTopEvent) {
            lazyListState.animateScrollToItem(0)
            viewModel.resetScrollToTopEvent()
        }
    }

    val selectedGenres = remember { mutableStateOf(setOf<String>()) }
    val selectedVersions = remember { mutableStateOf(setOf<String>()) }
    val selectedDifficulties = remember { mutableStateOf(setOf<String>()) }

    // 初始化时将所有选项设为选中状态
    LaunchedEffect(songList) {
        if (songList.isNotEmpty()) {
            selectedGenres.value = songList.map { it.genre }.distinct().toSet()
            selectedVersions.value = songList.map { it.version }.distinct().toSet()
            selectedDifficulties.value = setOf("basic", "advanced", "expert", "master", "ultima")
        }
    }

    // 添加展开/收起筛选的状态
    val isFilterExpanded = remember { mutableStateOf(false) }
    
    // 添加排序相关状态
    val isSortExpanded = remember { mutableStateOf(false) }
    val selectedSortOption = remember { mutableStateOf("default") }
    val isAscendingOrder = remember { mutableStateOf(true) } // 默认正序

    // 使用整数范围（乘以10），避免浮点数精度问题
    val internalLevelRange = remember { mutableStateOf(10..157) } // 1.0 to 15.7
    val filterInternalLevelRange = remember { mutableStateOf(10..157) }
    val cnLevelRange = remember { mutableStateOf(10..154) } // 1.0 to 15.4
    val filterCnLevelRange = remember { mutableStateOf(10..154) }

    val filteredSongList by remember(searchText, songList, selectedGenres.value, selectedVersions.value,
        selectedDifficulties.value, filterInternalLevelRange.value, filterCnLevelRange.value, selectedSortOption.value, isAscendingOrder.value) {
        derivedStateOf {
            val filtered = songList.filter { song ->
                // 如果任何一个筛选器是空集合（全不选），则不显示任何内容
                if (selectedGenres.value.isEmpty() || selectedVersions.value.isEmpty() || selectedDifficulties.value.isEmpty()) {
                    return@filter false
                }

                // Basic property filtering logic
                val basicMatch = (searchText.isEmpty() || song.title.contains(searchText, ignoreCase = true)) &&
                        selectedGenres.value.contains(song.genre) &&
                        selectedVersions.value.contains(song.version)

                if (!basicMatch) return@filter false

                // If filterCnLevelRange is set to a very loose range (0..1000), it means the CN filter is disabled
                val isCnFilterDisabled = filterCnLevelRange.value.start <= 1 && filterCnLevelRange.value.endInclusive >= 999

                song.sheets.any { sheet ->
                    // 将整数范围转换回小数进行比较
                    val jpLevelMatch = sheet.internalLevelValueJp >= (filterInternalLevelRange.value.start / 10.0) &&
                                     sheet.internalLevelValueJp <= (filterInternalLevelRange.value.endInclusive / 10.0)

                    // Match succeeds if either CN filter is disabled, or the sheet's CN value is within the filter range
                    val cnLevelMatch = isCnFilterDisabled ||
                            (sheet.levelValueCn >= (filterCnLevelRange.value.start / 10.0) &&
                             sheet.levelValueCn <= (filterCnLevelRange.value.endInclusive / 10.0))

                    // 难度筛选 - 必须包含选中的难度
                    val difficultyMatch = selectedDifficulties.value.contains(sheet.difficulty)

                    jpLevelMatch && cnLevelMatch && difficultyMatch
                }
            }
            
            // 排序逻辑
            val sorted = when (selectedSortOption.value) {
                "default" -> filtered // 保持数据库原始顺序
                "title" -> filtered.sortedBy { it.title }
                "artist" -> filtered.sortedBy { it.artist }
                "basic_cn" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "basic" }?.levelValueCn ?: 0.0 
                }
                "advanced_cn" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "advanced" }?.levelValueCn ?: 0.0 
                }
                "expert_cn" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "expert" }?.levelValueCn ?: 0.0 
                }
                "master_cn" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "master" }?.levelValueCn ?: 0.0 
                }
                "ultima_cn" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "ultima" }?.levelValueCn ?: 0.0 
                }
                "basic_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "basic" }?.internalLevelValueJp ?: 0.0 
                }
                "advanced_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "advanced" }?.internalLevelValueJp ?: 0.0 
                }
                "expert_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "expert" }?.internalLevelValueJp ?: 0.0 
                }
                "master_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "master" }?.internalLevelValueJp ?: 0.0 
                }
                "ultima_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "ultima" }?.internalLevelValueJp ?: 0.0 
                }
                else -> filtered // 默认情况也保持原始顺序
            }
            
            // 应用正序/倒序
            if (selectedSortOption.value != "default" && !isAscendingOrder.value) {
                sorted.reversed()
            } else {
                sorted
            }
        }
    }

    val cardWidthDp = screenWidthDp - 24.dp

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = { viewModel.refreshSongData(context) },
        modifier = Modifier
            .background(Red300)
            .fillMaxHeight(),
        state = state,
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.TopCenter),
                isRefreshing = isRefreshing,
                containerColor = Red300,
                color = Beige500,
                state = state
            )
        },
    ) {
        // 主内容区域 - 搜索栏和歌曲列表
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            // 搜索栏
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SearchBar(
                        searchText = searchText,
                        onSearchTextChanged = viewModel::updateSearchText,
                        modifier = Modifier.weight(1f)
                    )

                    androidx.compose.material3.IconButton(
                        onClick = { isFilterExpanded.value = !isFilterExpanded.value },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        androidx.compose.material3.Icon(
                            imageVector = if (isFilterExpanded.value)
                                Filled.ArrowUp
                            else
                                Filled.ArrowDown,
                            contentDescription = if (isFilterExpanded.value) "收起筛选" else "展开筛选",
                            tint = Beige500
                        )
                    }

                    androidx.compose.material3.IconButton(
                        onClick = { isSortExpanded.value = !isSortExpanded.value },
                        modifier = Modifier.padding(start = 4.dp)
                    ) {
                        androidx.compose.material3.Icon(
                            imageVector = if (isSortExpanded.value)
                                Filled.ArrowUp
                            else
                                Filled.ArrowDown,
                            contentDescription = if (isSortExpanded.value) "收起排序" else "展开排序",
                            tint = Beige500
                        )
                    }
                }
            }

            // 歌曲列表
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .nestedScroll(object : NestedScrollConnection {
                        private var totalScroll = 0f

                        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                            totalScroll += available.y
                            if (totalScroll < -scrollThreshold) {
                                setIsTabRowVisible(false)
                                totalScroll = 0f
                            } else if (totalScroll > scrollThreshold) {
                                setIsTabRowVisible(true)
                                totalScroll = 0f
                            }
                            return Offset.Zero
                        }
                    }),
                state = lazyListState
            ) {
                val duplicateTitles = filteredSongList
                    .groupBy { it.title }
                    .filter { it.value.size > 1 }
                    .keys
                items(filteredSongList.size) { index ->
                    if (duplicateTitles.contains(filteredSongList[index].title) && filteredSongList[index].genre == "WORLD'S END") {
                        return@items
                    }
                    ChunithmSongCard(
                        item = filteredSongList[index],
                        itemWidth = cardWidthDp,
                        highlightText = searchText,
                        viewModel = viewModel,
                        onClick = { song ->
                            onNavigateToSongDetail(song.title)
                        }
                    )
                    if (index != filteredSongList.size - 1) {
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }

        // 浮动筛选栏
        AnimatedVisibility(
            visible = isFilterExpanded.value,
            enter = expandVertically(),
            exit = shrinkVertically(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp) // 调整为更精确的搜索栏高度
                .zIndex(1f) // 确保浮在上层
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Red300) // 背景色，确保不透明
            ) {
                // Genre 筛选行
                val genres = songList.map { it.genre }.distinct()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val allSelected = selectedGenres.value.size == genres.size
                    val toggleText = if (allSelected) "全不选" else "全选"
                    Box(
                        modifier = Modifier
                            .height(32.dp)
                            .background(
                                if (allSelected) Red300 else Red500,
                                RoundedCornerShape(12.dp)
                            )
                            .clickable {
                                selectedGenres.value = if (allSelected) emptySet() else genres.toSet()
                            }
                            .padding(horizontal = 18.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = toggleText,
                            fontSize = 13.sp,
                            fontFamily = interTightBold,
                            color = Beige500,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    LazyRow(
                        modifier = Modifier.weight(1f)
                    ) {
                        items(genres.size) { index ->
                            val genre = genres[index]
                            val isSelected = selectedGenres.value.contains(genre)
                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .height(32.dp)
                                    .background(
                                        if (isSelected) Red500 else Red300,
                                        RoundedCornerShape(12.dp)
                                    )
                                    .clickable {
                                        selectedGenres.value = if (isSelected) {
                                            selectedGenres.value - genre
                                        } else {
                                            selectedGenres.value + genre
                                        }
                                    }
                                    .padding(horizontal = 12.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = genre,
                                    color = Beige500,
                                    fontSize = 13.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }

                // Version 筛选行
                val versions = songList.map { it.version }.distinct()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val allSelected = selectedVersions.value.size == versions.size
                    val toggleText = if (allSelected) "全不选" else "全选"
                    Box(
                        modifier = Modifier
                            .height(32.dp)
                            .background(
                                if (allSelected) Red300 else Red500,
                                RoundedCornerShape(12.dp)
                            )
                            .clickable {
                                selectedVersions.value = if (allSelected) emptySet() else versions.toSet()
                            }
                            .padding(horizontal = 18.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = toggleText,
                            fontSize = 13.sp,
                            fontFamily = interTightBold,
                            color = Beige500,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    LazyRow(
                        modifier = Modifier.weight(1f)
                    ) {
                        items(versions.size) { index ->
                            val version = versions[index]
                            val isSelected = selectedVersions.value.contains(version)
                            Box(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .height(32.dp)
                                    .background(
                                        if (isSelected) Red500 else Red300,
                                        RoundedCornerShape(12.dp)
                                    )
                                    .clickable {
                                        selectedVersions.value = if (isSelected) {
                                            selectedVersions.value - version
                                        } else {
                                            selectedVersions.value + version
                                        }
                                    }
                                    .padding(horizontal = 12.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = version,
                                    color = Beige500,
                                    fontSize = 13.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }

                // 难度筛选按钮
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val difficulties = listOf("basic", "advanced", "expert", "master", "ultima")
                    val difficultyLabels = listOf("BASIC", "ADVANCED", "EXPERT", "MASTER", "ULTIMA")
                    val difficultyColors = listOf(
                        CHUNI_DIFF_BASIC,
                        CHUNI_DIFF_ADVANCED,
                        CHUNI_DIFF_EXPERT,
                        CHUNI_DIFF_MASTER,
                        CHUNI_DIFF_ULTIMA_1
                    )

                    difficulties.forEachIndexed { index, difficulty ->
                        val isSelected = selectedDifficulties.value.contains(difficulty)
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(24.dp)
                                .background(
                                    if (isSelected) difficultyColors[index] else Red300,
                                    RoundedCornerShape(6.dp)
                                )
                                .run {
                                    if (difficulty == "ultima" && isSelected) {
                                        border(
                                            width = 1.dp,
                                            color = CHUNI_DIFF_ULTIMA_2,
                                            shape = RoundedCornerShape(6.dp)
                                        )
                                    } else this
                                }
                                .clickable {
                                    selectedDifficulties.value = if (isSelected) {
                                        selectedDifficulties.value - difficulty
                                    } else {
                                        selectedDifficulties.value + difficulty
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = difficultyLabels[index],
                                color = if (isSelected) White1000 else Beige500,
                                fontSize = 12.sp,
                                fontFamily = interTightBold,
                                textAlign = TextAlign.Center,
                                letterSpacing = if (difficulty == "advanced") (-0.5).sp else 0.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Visible
                            )
                        }
                    }
                }

                // JP Value range filter
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .background(Red300.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "JP Value Filter: ${(internalLevelRange.value.start / 10.0).round(1)} - ${(internalLevelRange.value.endInclusive / 10.0).round(1)}",
                            color = Beige500,
                            modifier = Modifier.weight(1f)
                        )

                        // 不可见的占位符，保持与CN Filter行高一致
                        Box(modifier = Modifier.padding(start = 8.dp)) {
                            Switch(
                                checked = false,
                                onCheckedChange = { },
                                modifier = Modifier.alpha(0f), // 完全透明
                                enabled = false
                            )
                        }
                    }
                    RangeSlider(
                        value = internalLevelRange.value.start.toFloat()..internalLevelRange.value.endInclusive.toFloat(),
                        onValueChange = { range ->
                            // 使用 kotlin.math.round 确保精确的整数转换
                            val startInt = kotlin.math.round(range.start).toInt()
                            val endInt = kotlin.math.round(range.endInclusive).toInt()
                            val intRange = startInt..endInt
                            internalLevelRange.value = intRange
                            filterInternalLevelRange.value = intRange // 立即更新筛选范围
                        },
                        valueRange = 10f..157f,
                        steps = 147, // 157 - 10 = 147 steps
                        colors = androidx.compose.material3.SliderDefaults.colors(
                            thumbColor = Beige500,
                            activeTrackColor = Red500,
                            inactiveTrackColor = Red300,
                            activeTickColor = androidx.compose.ui.graphics.Color.Transparent,
                            inactiveTickColor = androidx.compose.ui.graphics.Color.Transparent
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp)
                            .pointerInput(Unit) {
                                detectDragGestures { change, _ ->
                                    change.consume()
                                }
                            },
                    )
                }

                // CN Value range filter
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                        .background(Red300.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                        .padding(8.dp)
                ) {
                    val isCnFilterEnabled = remember { mutableStateOf(true) }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "CN Value Filter: ${(cnLevelRange.value.start / 10.0).round(1)} - ${(cnLevelRange.value.endInclusive / 10.0).round(1)}",
                            color = Beige500,
                            modifier = Modifier.weight(1f)
                        )

                        Switch(
                            checked = isCnFilterEnabled.value,
                            onCheckedChange = { enabled ->
                                isCnFilterEnabled.value = enabled
                                filterCnLevelRange.value = if (enabled) cnLevelRange.value else 0..1000
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Beige500,
                                checkedTrackColor = Red500,
                                uncheckedThumbColor = Red300,
                                uncheckedTrackColor = Beige500.copy(alpha = 0.5f)
                            )
                        )
                    }

                    RangeSlider(
                        value = cnLevelRange.value.start.toFloat()..cnLevelRange.value.endInclusive.toFloat(),
                        onValueChange = { range ->
                            val startInt = kotlin.math.round(range.start).toInt()
                            val endInt = kotlin.math.round(range.endInclusive).toInt()
                            val intRange = startInt..endInt
                            cnLevelRange.value = intRange
                            // 立即更新筛选范围（如果CN filter启用）
                            if (isCnFilterEnabled.value) {
                                filterCnLevelRange.value = intRange
                            }
                        },
                        valueRange = 10f..154f,
                        steps = 144, // 154 - 10 = 144 steps
                        enabled = isCnFilterEnabled.value,
                        colors = androidx.compose.material3.SliderDefaults.colors(
                            thumbColor = Beige500,
                            activeTrackColor = Red500,
                            inactiveTrackColor = Red300,
                            disabledThumbColor = Red300,
                            disabledActiveTrackColor = Red300.copy(alpha = 0.5f),
                            disabledInactiveTrackColor = Red300.copy(alpha = 0.3f),
                            activeTickColor = androidx.compose.ui.graphics.Color.Transparent,
                            inactiveTickColor = androidx.compose.ui.graphics.Color.Transparent,
                            disabledActiveTickColor = androidx.compose.ui.graphics.Color.Transparent,
                            disabledInactiveTickColor = androidx.compose.ui.graphics.Color.Transparent
                        ),
                        modifier = Modifier.padding(horizontal = 8.dp)
                            .pointerInput(Unit) {
                                detectDragGestures { change, _ ->
                                    change.consume()
                                }
                            },
                    )
                }
            }
        }

        // 浮动排序栏
        AnimatedVisibility(
            visible = isSortExpanded.value,
            enter = expandVertically(),
            exit = shrinkVertically(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp) // 调整为更精确的搜索栏高度
                .zIndex(2f) // 确保浮在筛选栏上层
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Red300) // 背景色，确保不透明
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "排序选项",
                    color = Beige500,
                    fontSize = 16.sp,
                    fontFamily = interTightBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                // 正序/倒序切换按钮
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(28.dp)
                            .background(
                                if (isAscendingOrder.value) Red500 else Red300,
                                RoundedCornerShape(10.dp)
                            )
                            .clickable {
                                isAscendingOrder.value = true
                            }
                            .padding(horizontal = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "正序 ↑",
                            color = Beige500,
                            fontSize = 12.sp,
                            fontFamily = if (isAscendingOrder.value) interTightBold else interTightRegular,
                            textAlign = TextAlign.Center
                        )
                    }
                    
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(28.dp)
                            .background(
                                if (!isAscendingOrder.value) Red500 else Red300,
                                RoundedCornerShape(10.dp)
                            )
                            .clickable {
                                isAscendingOrder.value = false
                            }
                            .padding(horizontal = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "倒序 ↓",
                            color = Beige500,
                            fontSize = 12.sp,
                            fontFamily = if (isAscendingOrder.value) interTightBold else interTightRegular,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                
                // 基本排序选项
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val basicSortOptions = listOf(
                        "default" to "默认顺序",
                        "title" to "标题",
                        "artist" to "艺术家"
                    )
                    
                    basicSortOptions.forEach { (value, label) ->
                        val isSelected = selectedSortOption.value == value
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(32.dp)
                                .background(
                                    if (isSelected) Red500 else Red300,
                                    RoundedCornerShape(12.dp)
                                )
                                .clickable {
                                    selectedSortOption.value = value
                                    isSortExpanded.value = false
                                }
                                .padding(horizontal = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = label,
                                color = Beige500,
                                fontSize = 13.sp,
                                fontFamily = if (isAscendingOrder.value) interTightBold else interTightRegular,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // CN Value排序选项
                Text(
                    text = "按CN Value排序",
                    color = Beige500,
                    fontSize = 14.sp,
                    fontFamily = interTightBold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    val cnSortOptions = listOf(
                        "basic_cn" to "BAS",
                        "advanced_cn" to "ADV", 
                        "expert_cn" to "EXP",
                        "master_cn" to "MAS",
                        "ultima_cn" to "ULT"
                    )
                    
                    cnSortOptions.forEach { (value, label) ->
                        val isSelected = selectedSortOption.value == value
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(28.dp)
                                .background(
                                    if (isSelected) Red500 else Red300,
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    selectedSortOption.value = value
                                    isSortExpanded.value = false
                                }
                                .padding(horizontal = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = label,
                                color = Beige500,
                                fontSize = 11.sp,
                                fontFamily = if (isAscendingOrder.value) interTightBold else interTightRegular,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // JP Value排序选项
                Text(
                    text = "按JP Value排序",
                    color = Beige500,
                    fontSize = 14.sp,
                    fontFamily = interTightBold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    val jpSortOptions = listOf(
                        "basic_jp" to "BAS",
                        "advanced_jp" to "ADV",
                        "expert_jp" to "EXP", 
                        "master_jp" to "MAS",
                        "ultima_jp" to "ULT"
                    )
                    
                    jpSortOptions.forEach { (value, label) ->
                        val isSelected = selectedSortOption.value == value
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(28.dp)
                                .background(
                                    if (isSelected) Red500 else Red300,
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    selectedSortOption.value = value
                                    isSortExpanded.value = false
                                }
                                .padding(horizontal = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = label,
                                color = Beige500,
                                fontSize = 11.sp,
                                fontFamily = if (isAscendingOrder.value) interTightBold else interTightRegular,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}