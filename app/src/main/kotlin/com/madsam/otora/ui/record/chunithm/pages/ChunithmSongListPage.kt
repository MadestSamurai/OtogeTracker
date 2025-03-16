package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel

@Composable
internal fun ChunithmSongListPage(
    viewModel: ChunithmViewModel,
) {
    LaunchedEffect(Unit) {
        viewModel.loadAllSongsData()
    }
    val songList by viewModel.chuniSongs.collectAsState()
    LazyColumn {
        items(songList.size) { index ->
            Column {
                Text(text = songList[index].title)
                Text(text = songList[index].artist)
            }
        }
    }
}