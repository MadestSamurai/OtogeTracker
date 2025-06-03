package com.madsam.otora.ui.record.chunithm.pages

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.Alignment
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

    var totalMatches by remember { mutableIntStateOf(0) }

    LaunchedEffect(songList) {
        totalMatches = songList.size
    }

    val selectedGenres = remember { mutableStateOf(setOf<String>()) }
    val selectedVersions = remember { mutableStateOf(setOf<String>()) }

    val coroutineScope = rememberCoroutineScope()

    val internalLevelRange = remember { mutableStateOf(1.0f..15.7f) }
    val filterInternalLevelRange = remember { mutableStateOf(1.0f..15.7f) }
    val cnLevelRange = remember { mutableStateOf(1.0f..15.4f) }
    val filterCnLevelRange = remember { mutableStateOf(1.0f..15.4f) }

    val cardWidthDp = screenWidthDp - 24.dp
    Column(
        modifier = Modifier
            .background(Red300)
            .fillMaxHeight()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            SearchBar(
                searchText = searchText,
                onSearchTextChanged = viewModel::updateSearchText,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            )
        }

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

        // JP Value range filter
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .background(Red300.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            Text(
                text = "JP Value Filter: ${internalLevelRange.value.start.toFloat().round(1)} - ${internalLevelRange.value.endInclusive.toFloat().round(1)}",
                color = Beige500,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            RangeSlider(
                value = internalLevelRange.value,
                onValueChange = { range ->
                    internalLevelRange.value = range
                    coroutineScope.launch {
                        delay(300) // 300ms debounce
                        filterInternalLevelRange.value = range
                    }
                },
                valueRange = 1.0f..15.7f,
                steps = 0,
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
                .padding(horizontal = 12.dp, vertical = 4.dp)
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
                    text = "CN Value Filter: ${cnLevelRange.value.start.toFloat().round(1)} - ${cnLevelRange.value.endInclusive.toFloat().round(1)}",
                    color = Beige500,
                    modifier = Modifier.weight(1f)
                )

                Switch(
                    checked = isCnFilterEnabled.value,
                    onCheckedChange = { enabled ->
                        isCnFilterEnabled.value = enabled
                        filterCnLevelRange.value = if (enabled) cnLevelRange.value else 0f..100f
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
                value = cnLevelRange.value,
                onValueChange = { range ->
                    cnLevelRange.value = range
                    coroutineScope.launch {
                        delay(300) // 300ms debounce
                        // update filter range only if CN filter is enabled
                        if (isCnFilterEnabled.value) {
                            filterCnLevelRange.value = range
                        }
                    }
                },
                valueRange = 1.0f..15.4f,
                steps = 0,
                enabled = isCnFilterEnabled.value,
                modifier = Modifier.padding(horizontal = 8.dp)
                    .pointerInput(Unit) {
                        detectDragGestures { change, _ ->
                            change.consume()
                        }
                    },
            )
        }

        val filteredSongList by remember(searchText, songList, selectedGenres.value, selectedVersions.value,
            filterInternalLevelRange.value, filterCnLevelRange.value) {
            derivedStateOf {
                songList.filter { song ->
                    // Basic property filtering logic
                    val basicMatch = (searchText.isEmpty() || song.title.contains(searchText, ignoreCase = true)) &&
                            (selectedGenres.value.isEmpty() || selectedGenres.value.contains(song.genre)) &&
                            (selectedVersions.value.isEmpty() || selectedVersions.value.contains(song.version))

                    if (!basicMatch) return@filter false

                    // If filterCnLevelRange is set to a very loose range (0f..100f), it means the CN filter is disabled
                    val isCnFilterDisabled = filterCnLevelRange.value.start <= 0.1f && filterCnLevelRange.value.endInclusive >= 99f

                    song.sheets.any { sheet ->
                        val jpLevelMatch = sheet.internalLevelValueJp in filterInternalLevelRange.value.start.toDouble()..filterInternalLevelRange.value.endInclusive.toDouble()

                        // Match succeeds if either CN filter is disabled, or the sheet's CN value is within the filter range
                        val cnLevelMatch = isCnFilterDisabled ||
                                sheet.levelValueCn in filterCnLevelRange.value.start.toDouble()..filterCnLevelRange.value.endInclusive.toDouble()

                        jpLevelMatch && cnLevelMatch
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

private fun Float.round(decimals: Int): Float {
    var multiplier = 1.0f
    repeat(decimals) { multiplier *= 10 }
    return kotlin.math.round(this * multiplier) / multiplier
}