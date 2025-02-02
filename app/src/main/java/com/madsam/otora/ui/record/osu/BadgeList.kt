package com.madsam.otora.ui.record.osu

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.consts.DARK_RED_DEEP
import com.madsam.otora.consts.White1000
import com.madsam.otora.model.osu.ui.OsuBadgeUI
import com.madsam.otora.ui.icon.Filled
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.osu.BadgeList
 * 创建者: MadSamurai
 * 创建时间: 2024/9/4
 * 描述: Osu徽章列表
 */

@Composable
fun BadgeList(
    osuBadgeList: MutableStateFlow<List<OsuBadgeUI>>
) {
    val badgeListData = osuBadgeList.collectAsState(initial = emptyList()).value
    val coroutineScope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    if (badgeListData.isNotEmpty()) {
        val cardWidthDp = screenWidthDp - 32.dp
        Surface(
            Modifier
                .padding(
                    start = 16.dp,
                    bottom = 12.dp
                )
                .width(cardWidthDp),
            RoundedCornerShape(20.dp),
            DARK_RED_DEEP
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