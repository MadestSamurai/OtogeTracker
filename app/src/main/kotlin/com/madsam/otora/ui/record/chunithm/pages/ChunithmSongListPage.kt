package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.ChunithmSongCard
import com.madsam.otora.ui.record.chunithm.components.SearchBar
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
    val scope = rememberCoroutineScope()

    // 当前匹配项索引和匹配项总数
    var currentMatchIndex by remember { mutableIntStateOf(0) }
    var totalMatches by remember { mutableIntStateOf(0) }

    // 计算匹配项总数
    LaunchedEffect(songList) {
        totalMatches = songList.size
    }

    // 当搜索文本改变时，重置索引
    LaunchedEffect(searchText) {
        currentMatchIndex = 10  //TODO: 搜索跳转功能还有问题
    }

    val cardWidthDp = screenWidthDp - 24.dp
    Column(
        modifier = Modifier
            .background(Red300)
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

            // 只有当有搜索结果时才显示导航按钮
            if (searchText.isNotEmpty() && totalMatches > 0) {
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 60.dp) // 预留删除按钮的空间
                ) {
                    // 向上导航按钮
                    IconButton(
                        onClick = {
                            if (totalMatches > 0) {
                                currentMatchIndex = (currentMatchIndex - 1 + totalMatches) % totalMatches
                                scope.launch {
                                    lazyListState.animateScrollToItem(currentMatchIndex)
                                }
                            }
                        }
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.ArrowWindUp),
                            contentDescription = "向上",
                            tint = Color.White
                        )
                    }

                    // 向下导航按钮
                    IconButton(
                        onClick = {
                            if (totalMatches > 0) {
                                currentMatchIndex = (currentMatchIndex + 1) % totalMatches
                                scope.launch {
                                    lazyListState.animateScrollToItem(currentMatchIndex)
                                }
                            }
                        }
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.ArrowWindDown),
                            contentDescription = "向下",
                            tint = Color.White
                        )
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
            state = rememberLazyListState()
        ) {
            items(songList.size) { index ->
                if (songList[index].genre == "WORLD'S END") {
                    return@items
                }
                ChunithmSongCard(
                    item = songList[index],
                    itemWidth = cardWidthDp,
                    highlightText = searchText
                )
                if (index != songList.size - 1) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}