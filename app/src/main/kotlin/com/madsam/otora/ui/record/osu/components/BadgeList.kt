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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.data.osu.ui.model.OsuBadgeUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Composable
internal fun BadgeList(
    osuBadgeList: MutableStateFlow<List<OsuBadgeUiModel>>
) {
    val badgeListData by osuBadgeList.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }
    if (badgeListData.isNotEmpty()) {
        val cardWidthDp = screenWidthDp - 24.dp
        Surface(
            Modifier
                .padding(bottom = 12.dp)
                .width(cardWidthDp),
            RoundedCornerShape(20.dp),
            Red700
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
                        contentDescription = "Previous",
                        tint = White1000,
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
                                .clip(RoundedCornerShape(6.dp))
                                .height(32.dp)
                                .width(68.dp)
                        )
                    }
                }
                if (badgeListData.size > imageCount) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.ChevronRight),
                        contentDescription = "Next",
                        tint = White1000,
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
}