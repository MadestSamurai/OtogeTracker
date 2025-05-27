package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.ChunithmSongCard
import com.madsam.otora.ui.record.chunithm.components.SearchBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun ChunithmSongListPage(
    viewModel: ChunithmViewModel,
    scrollThreshold: Float,
    setIsTabRowVisible: (Boolean) -> Unit,
) {
    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }

    LaunchedEffect(Unit) {
        viewModel.loadAllSongsData()
    }

    val searchText by viewModel.searchText.collectAsState()
    val songList by viewModel.chuniSongs.collectAsState()

    val lazyListState = rememberLazyListState()

    // 当前匹配项总数
    var totalMatches by remember { mutableIntStateOf(0) }

    // 计算匹配项总数
    LaunchedEffect(songList) {
        totalMatches = songList.size
    }

    // 保存选中的 genre
    val selectedGenres = remember { mutableStateOf(setOf<String>()) }

    // 保存选中的 version
    val selectedVersions = remember { mutableStateOf(setOf<String>()) }

    // 添加协程作用域用于防抖
    val coroutineScope = rememberCoroutineScope()

    // UI显示用的范围状态
    val internalLevelRange = remember {
        mutableStateOf(1.0f..15.8f)
    }

    // 实际筛选用的范围状态
    val filterInternalLevelRange = remember {
        mutableStateOf(1.0f..15.8f)
    }

    // UI显示用的范围状态
    val cnLevelRange = remember {
        mutableStateOf(1.0f..15.5f)
    }

    // 实际筛选用的范围状态
    val filterCnLevelRange = remember {
        mutableStateOf(1.0f..15.5f)
    }

    val cardWidthDp = screenWidthDp - 24.dp
    Column(
        modifier = Modifier
            .background(Red300)
            .fillMaxHeight()
    ) {
        // 添加搜索栏和导航控件
        Box(modifier = Modifier.fillMaxWidth()) {
            SearchBar(
                searchText = searchText,
                onSearchTextChanged = viewModel::updateSearchText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            )
        }

        // 添加 genre 过滤栏
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            val genres = songList.map { it.genre }.distinct()
            items(genres.size) { index ->
                val genre = genres[index]
                val isSelected = selectedGenres.value.contains(genre)
                Text(
                    text = genre,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .background(
                            if (isSelected) Red500 else Red300,
                            RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .clickable {
                            selectedGenres.value = if (isSelected) {
                                selectedGenres.value - genre
                            } else {
                                selectedGenres.value + genre
                            }
                        },
                    color = Beige500
                )
            }
        }

        // 添加 version 过滤栏
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            val versions = songList.map { it.version }.distinct()
            items(versions.size) { index ->
                val version = versions[index]
                val isSelected = selectedVersions.value.contains(version)
                Text(
                    text = version,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .background(
                            if (isSelected) Red500 else Red300,
                            RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .clickable {
                            selectedVersions.value = if (isSelected) {
                                selectedVersions.value - version
                            } else {
                                selectedVersions.value + version
                            }
                        },
                    color = Beige500
                )
            }
        }

        // 添加内部定级范围筛选器
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .background(Red300.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            Text(
                text = "内部定级范围: ${internalLevelRange.value.start.toFloat().round(1)} - ${internalLevelRange.value.endInclusive.toFloat().round(1)}",
                color = Beige500,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            RangeSlider(
                value = internalLevelRange.value,
                onValueChange = { range ->
                    internalLevelRange.value = range
                    coroutineScope.launch {
                        delay(300) // 300毫秒防抖
                        filterInternalLevelRange.value = range
                    }
                },
                valueRange = 1.0f..15.8f,
                steps = 0,
                modifier = Modifier.padding(horizontal = 8.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, _ ->
                            change.consume()
                        }
                    },
            )
        }

        // 添加国服定级范围筛选器
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .background(Red300.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            Text(
                text = "国服定级范围: ${cnLevelRange.value.start.toFloat().round(1)} - ${cnLevelRange.value.endInclusive.toFloat().round(1)}",
                color = Beige500,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            RangeSlider(
                value = cnLevelRange.value,
                onValueChange = { range ->
                    cnLevelRange.value = range
                    coroutineScope.launch {
                        delay(300) // 300毫秒防抖
                        filterCnLevelRange.value = range
                    }
                },
                valueRange = 1.0f..15.5f,
                steps = 0,
                modifier = Modifier.padding(horizontal = 8.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, _ ->
                            change.consume()
                        }
                    },
            )
        }

        // 修改筛选逻辑，使用防抖后的筛选值
        val filteredSongList by remember(searchText, songList, selectedGenres.value, selectedVersions.value,
            filterInternalLevelRange.value, filterCnLevelRange.value) {
            derivedStateOf {
                songList.filter { song ->
                    // 基本属性筛选逻辑...
                    val basicMatch = (searchText.isEmpty() || song.title.contains(searchText, ignoreCase = true)) &&
                            (selectedGenres.value.isEmpty() || selectedGenres.value.contains(song.genre)) &&
                            (selectedVersions.value.isEmpty() || selectedVersions.value.contains(song.version))

                    if (!basicMatch) return@filter false

                    song.sheets.any { sheet ->
                        sheet.internalLevelValueJp in filterInternalLevelRange.value.start.toDouble()..filterInternalLevelRange.value.endInclusive.toDouble() &&
                                sheet.levelValueCn in filterCnLevelRange.value.start.toDouble()..filterCnLevelRange.value.endInclusive.toDouble()
                    }
                }
            }
        }

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
                    highlightText = searchText
                )
                if (index != filteredSongList.size - 1) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

// 添加用于保留一位小数的扩展函数
private fun Float.round(decimals: Int): Float {
    var multiplier = 1.0f
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}