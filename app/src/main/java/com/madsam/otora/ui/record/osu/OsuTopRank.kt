package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.consts.Colors
import com.madsam.otora.entity.web.OsuTopRankItem
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.osu.OsuTopRank
 * 创建者: MadSamurai
 * 创建时间: 2024/8/10
 * 描述: Osu顶级排名
 */

@Composable
fun OsuTopRank(
    pinnedMaps : MutableStateFlow<List<Map<String, String>>>,
    topMaps : MutableStateFlow<List<Map<String, String>>>,
    firstMaps : MutableStateFlow<List<Map<String, String>>>
) {
    val pinned = pinnedMaps.collectAsState(initial = emptyList()).value
    val top = topMaps.collectAsState(initial = emptyList()).value
    val first = firstMaps.collectAsState(initial = emptyList()).value

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp

    Surface(
        Modifier
            .width(screenWidthDp)
            .padding(
                start = 16.dp,
                top = 12.dp,
                end = 16.dp,
                bottom = 12.dp
            ),
        RoundedCornerShape(20.dp),
        Colors.DARK_RED_DEEP
    ) {
        val cardWidth = screenWidthDp - 32.dp
        Column {
            OsuTopRankItemContent(pinned, "Pinned", cardWidth)
            OsuTopRankItemContent(top, "Top", cardWidth)
            OsuTopRankItemContent(first, "First", cardWidth)
        }
    }
}

@Composable
fun OsuTopRankItemContent(
    items: List<Map<String, String>>,
    title: String,
    cardWidth: Dp
) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Colors.DARK_RED_TEXT_LIGHT,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
        )
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .height(200.dp)
        ) {
            val itemWidth = cardWidth - 16.dp
            items.forEach {
                item {
                    OsuTopRankItemCard(it, itemWidth)
                }
            }
        }
    }
}

@Composable
fun OsuTopRankItemCard(
    item: Map<String, String>,
    itemWidth: Dp
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(8.dp)
            .background(Colors.DARK_RED_DEEP)
    ) {
        val (rank, title, score, acc, pp) = createRefs()
        Text(
            text = item["rank"]!!,
            color = Colors.DARK_RED_TEXT_LIGHT,
            fontSize = 24.sp,
            modifier = Modifier
                .constrainAs(rank) {
                    top.linkTo(parent.top, 8.dp)
                    start.linkTo(parent.start, 8.dp)
                }
        )
    }
}