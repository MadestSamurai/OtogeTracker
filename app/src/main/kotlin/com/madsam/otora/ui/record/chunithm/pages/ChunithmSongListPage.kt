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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel
import com.madsam.otora.ui.record.chunithm.components.ChunithmSongCard

@Composable
internal fun ChunithmSongListPage(
    viewModel: ChunithmViewModel,
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp

    LaunchedEffect(Unit) {
        viewModel.loadAllSongsData()
    }
    val songList by viewModel.chuniSongs.collectAsState()

    val cardWidthDp = screenWidthDp - 24.dp
    LazyColumn(
        modifier = Modifier
            .background(Red300)
            .padding(12.dp),
        state = rememberLazyListState()
    ) {
        items(songList.size) { index ->
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