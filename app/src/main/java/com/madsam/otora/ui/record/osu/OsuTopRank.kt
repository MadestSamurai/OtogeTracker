package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.consts.Colors
import com.madsam.otora.consts.OsuDiffColor
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
    Surface(
        Modifier
            .width(itemWidth)
            .padding(8.dp),
        RoundedCornerShape(6.dp),
        Colors.DARK_RED_DEEP
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(8.dp)
                .background(Colors.DARK_RED_DEEP)
        ) {
            val (
                cover,
                background,
                diff,
                rank,
                title,
                score,
                acc,
                pp
            ) = createRefs()
            Image(
                painter = rememberAsyncImagePainter(
                    model = item["bg2x"] ?: "",
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Cover",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(background) {
                        top.linkTo(parent.top)
                        start.linkTo(cover.start, 80.dp)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .height(100.dp)
                    .alpha(0.15f)
            )
            Surface(
                Modifier
                    .constrainAs(cover) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .width(100.dp)
                    .height(100.dp),
                RoundedCornerShape(6.dp),
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = item["cover2x"] ?: "",
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = "Cover",
                    contentScale = ContentScale.Crop
                )
            }
            val inlineContent = mapOf(
                "icon" to InlineTextContent(
                    Placeholder(
                        width = 14.sp,
                        height = 14.sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = OsuDiffColor.mapValueToTextColor(item["difficultyRating"]?.toFloat() ?: 0f),
                    )
                }
            )
            Text(
                text = buildAnnotatedString {
                    appendInlineContent("icon", "[icon]")
                    append(item["difficultyRating"] ?: "")
                },
                inlineContent = inlineContent,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = OsuDiffColor.mapValueToTextColor(item["difficultyRating"]?.toFloat() ?: 0f),
                modifier = Modifier
                    .constrainAs(diff) {
                        top.linkTo(parent.top, 4.dp)
                        start.linkTo(cover.start, 4.dp)
                    }
                    .background(
                        color = OsuDiffColor.mapValueToColor(item["difficultyRating"]?.toFloat() ?: 0f),
                        shape = RoundedCornerShape(100.dp)
                    )
                    .padding(
                        start = 8.dp,
                        end = 8.dp,
                        top = 3.dp,
                        bottom = 3.dp
                    )
            )
            Text(text = item["beatmapSetTitle"] ?: "",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top, 4.dp)
                        start.linkTo(cover.end, 8.dp)
                    }
            )
            Text(text = item["artist"] ?: "",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 14.sp,
                modifier = Modifier
                    .constrainAs(score) {
                        top.linkTo(title.bottom, 4.dp)
                        start.linkTo(cover.end, 8.dp)
                    }
            )
            Text(text = item["beatmapSubTitle"] ?: "",
                color = Colors.OSU_BRIGHT_YELLOW,
                fontSize = 14.sp,
                modifier = Modifier
                    .constrainAs(acc) {
                        top.linkTo(score.bottom, 4.dp)
                        start.linkTo(cover.end, 8.dp)
                    }
            )
            Text(text = ("mapped by ${item["creator"]}"),
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 14.sp,
                modifier = Modifier
                    .constrainAs(pp) {
                        top.linkTo(acc.bottom, 4.dp)
                        start.linkTo(cover.end, 8.dp)
                    }
            )
        }
    }
}