package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
fun TopRank(
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
                end = 16.dp,
                bottom = 12.dp,
                top = 12.dp
            ),
        RoundedCornerShape(20.dp),
        Colors.DARK_RED_DEEP
    ) {
        val cardWidth = screenWidthDp - 32.dp
        Column {
            if (pinned.isEmpty() && top.isEmpty() && first.isEmpty()) {
                Text(
                    text = "No play records",
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                return@Column
            }
            if (pinned.isEmpty()) {
                Text(
                    text = "No pinned maps",
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                OsuTopRankItemContent(pinned, "Pinned", cardWidth)
            }
            if (top.isEmpty()) {
                Text(
                    text = "No top maps",
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                OsuTopRankItemContent(top, "Top", cardWidth)
            }
            if (first.isEmpty()) {
                Text(
                    text = "No first maps",
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                OsuTopRankItemContent(first, "First", cardWidth)
            }
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
        Color.Transparent
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Colors.DARK_RED_DEEP)
        ) {
            val (
                cover,
                background,
                diff,
                rank
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
                    .width(itemWidth - 80.dp)
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
                Color.Transparent
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
                        painter = painterResource(id = com.madsam.otora.R.drawable.ic_star),
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
                    .padding(horizontal = 8.dp)
            )
            Column(
                modifier = Modifier
                    .constrainAs(rank) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(text = item["beatmapSetTitleUnicode"] ?: "",
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 124.dp)
                )
                Text(text = item["artist"] ?: "",
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 124.dp)
                )
                Text(text = item["beatmapSubTitle"] ?: "",
                    color = Colors.OSU_BRIGHT_YELLOW,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 124.dp)
                )
                Text(text = ("mapped by ${item["creator"]}"),
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 124.dp)
                )
            }
        }
    }
}