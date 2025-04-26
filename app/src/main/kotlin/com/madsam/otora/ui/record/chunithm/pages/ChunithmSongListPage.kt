package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.ChunithmSongCard

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
    val songList by viewModel.chuniSongs.collectAsState()

    val cardWidthDp = screenWidthDp - 24.dp
    LazyColumn(
        modifier = Modifier
            .background(Red300)
            .padding(12.dp)
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
                itemWidth = cardWidthDp
            )
            if (index != songList.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}