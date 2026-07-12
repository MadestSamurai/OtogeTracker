package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.R
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.data.osu.ui.model.OsuBadgeUiModel
import com.madsam.otora.ui.record.osu.dialogs.BadgeDetailSheet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Composable
internal fun BadgeList(
    osuBadgeList: MutableStateFlow<List<OsuBadgeUiModel>>,
    cardWidthDp: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    val badgeListData by osuBadgeList.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    var selectedBadge by remember { mutableStateOf<OsuBadgeUiModel?>(null) }
    if (badgeListData.isNotEmpty()) {
        Surface(
            Modifier
                .padding(bottom = 16.dp)
                .width(cardWidthDp),
            RoundedCornerShape(16.dp),
            colorScheme.surfaceContainer
        ) {
            var listWidthDp = cardWidthDp - 16.dp - 40.dp
            val imageCount = (listWidthDp / (68.dp + 12.dp)).toInt()
            var imagePadding = (listWidthDp / imageCount) - 68.dp
            val listState = rememberLazyListState()
            if (badgeListData.size <= imageCount) {
                listWidthDp = cardWidthDp - 16.dp
                imagePadding = (listWidthDp / imageCount) - 68.dp
            }
            Row(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                if (badgeListData.size > imageCount) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.ChevronLeft),
                        contentDescription = stringResource(R.string.osu_action_previous),
                        tint = colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .padding(start = 13.dp, end = 5.dp)
                            .width(10.dp)
                            .height(30.dp)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                coroutineScope.launch {
                                    val currentIndex = listState.firstVisibleItemIndex
                                    if (currentIndex > 0) {
                                        listState.animateScrollToItem(currentIndex - 1)
                                    }
                                    if (currentIndex == 0) {
                                        listState.animateScrollToItem(0)
                                    }
                                }
                            }
                    )
                }
                LazyRow(
                    state = listState,
                    modifier = Modifier.weight(1f)
                ) {
                    items(badgeListData) { badge ->
                        Image(
                            painter = rememberAsyncImagePainter(model = badge.image2xUrl),
                            contentScale = ContentScale.FillHeight,
                            contentDescription = badge.description,
                            modifier = Modifier
                                .padding(horizontal = imagePadding / 2)
                                .height(32.dp)
                                .width(68.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .clickable { selectedBadge = badge }
                        )
                    }
                }
                if (badgeListData.size > imageCount) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.ChevronRight),
                        contentDescription = stringResource(R.string.osu_action_next),
                        tint = colorScheme.onSurfaceVariant,
                        modifier = Modifier
                            .padding(start = 5.dp, end = 13.dp)
                            .width(10.dp)
                            .height(30.dp)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                coroutineScope.launch {
                                    val currentIndex = listState.firstVisibleItemIndex
                                    if (currentIndex < badgeListData.size - 1) {
                                        listState.animateScrollToItem(currentIndex + 1)
                                    }
                                }
                            }
                    )
                }
            }
        }
    }

    selectedBadge?.let { badge ->
        BadgeDetailSheet(
            badge = badge,
            onDismiss = { selectedBadge = null }
        )
    }
}
