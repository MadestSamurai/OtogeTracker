package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.ChunithmFilterComponent
import com.madsam.otora.ui.record.chunithm.components.ChunithmSongCard
import com.madsam.otora.ui.record.chunithm.components.ChunithmSortComponent
import com.madsam.otora.ui.record.chunithm.components.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ChunithmSongListPage(
    viewModel: ChunithmViewModel,
    scrollThreshold: Float,
    setIsTabRowVisible: (Boolean) -> Unit,
    onNavigateToSongDetail: (String) -> Unit
) {
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
    val includeWE = remember(key1 = "includeWE") { mutableStateOf(true) }

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
        selectedDifficulties.value, filterInternalLevelRange.value, filterCnLevelRange.value, includeWE.value, selectedSortOption.value, isAscendingOrder.value) {
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
                    // WE难度特殊处理：如果开启WE开关且这是WE难度（levelValueJp = 0 或 > 100），跳过JP和CN定数范围过滤
                    val isWEDifficulty = sheet.type == "we"
                    
                    val jpLevelMatch = if (includeWE.value && isWEDifficulty) {
                        true  // WE难度总是匹配JP定数筛选
                    } else {
                        // 将整数范围转换回小数进行比较
                        sheet.levelValueJp >= (filterInternalLevelRange.value.start / 10.0) &&
                        sheet.levelValueJp <= (filterInternalLevelRange.value.endInclusive / 10.0)
                    }

                    // WE难度也跳过CN筛选
                    val cnLevelMatch = if (includeWE.value && isWEDifficulty) {
                        true  // WE难度总是匹配CN定数筛选
                    } else {
                        // Match succeeds if either CN filter is disabled, or the sheet's CN value is within the filter range
                        isCnFilterDisabled ||
                        (sheet.levelValueCn >= (filterCnLevelRange.value.start / 10.0) &&
                         sheet.levelValueCn <= (filterCnLevelRange.value.endInclusive / 10.0))
                    }

                    // 难度筛选 - 必须包含选中的难度
                    val difficultyMatch = if (includeWE.value && isWEDifficulty) {
                        true
                    } else {
                        selectedDifficulties.value.contains(sheet.difficulty)
                    }

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
                    song.sheets.find { it.difficulty == "basic" }?.levelValueJp ?: 0.0
                }
                "advanced_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "advanced" }?.levelValueJp ?: 0.0
                }
                "expert_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "expert" }?.levelValueJp ?: 0.0
                }
                "master_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "master" }?.levelValueJp ?: 0.0
                }
                "ultima_jp" -> filtered.sortedBy { song -> 
                    song.sheets.find { it.difficulty == "ultima" }?.levelValueJp ?: 0.0
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
        onRefresh = { viewModel.refreshSongData() },
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
        ChunithmFilterComponent(
            isFilterExpanded = isFilterExpanded.value,
            genres = songList.map { it.genre }.distinct(),
            versions = songList.map { it.version }.distinct(),
            selectedGenres = selectedGenres,
            selectedVersions = selectedVersions,
            selectedDifficulties = selectedDifficulties,
            internalLevelRange = internalLevelRange,
            filterInternalLevelRange = filterInternalLevelRange,
            cnLevelRange = cnLevelRange,
            filterCnLevelRange = filterCnLevelRange,
            includeWE = includeWE,
            modifier = Modifier.padding(top = 64.dp)
        )

        // 浮动排序栏
        ChunithmSortComponent(
            isSortExpanded = isSortExpanded.value,
            selectedSortOption = selectedSortOption,
            isAscendingOrder = isAscendingOrder,
            onSortOptionSelected = { isSortExpanded.value = false },
            modifier = Modifier.padding(top = 64.dp)
        )
    }
}