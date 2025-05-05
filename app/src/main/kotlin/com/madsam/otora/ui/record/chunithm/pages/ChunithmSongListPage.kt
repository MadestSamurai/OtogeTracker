package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.ChunithmSongCard
import com.madsam.otora.ui.record.chunithm.components.SearchBar

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

        // 筛选后的目标项列表
        val filteredSongList by remember(searchText, songList, selectedGenres.value, selectedVersions.value) {
            derivedStateOf {
                songList.filter { song ->
                    (searchText.isEmpty() || song.title.contains(searchText, ignoreCase = true)) &&
                            (selectedGenres.value.isEmpty() || selectedGenres.value.contains(song.genre)) &&
                            (selectedVersions.value.isEmpty() || selectedVersions.value.contains(song.version))
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