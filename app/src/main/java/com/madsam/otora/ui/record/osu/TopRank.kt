package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.ui.theme.BlackAlpha50
import com.madsam.otora.ui.theme.Red700
import com.madsam.otora.ui.theme.Beige400
import com.madsam.otora.ui.theme.OSU_BRIGHT_YELLOW
import com.madsam.otora.ui.theme.OSU_HEART_RED
import com.madsam.otora.consts.OsuDiffColor
import com.madsam.otora.model.osu.ui.OsuTopRankUI
import com.madsam.otora.ui.icon.Filled
import com.madsam.otora.utils.CommonUtils.dateCodeToRecent
import com.madsam.otora.utils.CommonUtils.formatNumberThousand
import com.madsam.otora.utils.CommonUtils.truncateToTwoDecimalPlaces
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.osu.OsuTopRank
 * 创建者: MadSamurai
 * 创建时间: 2024/8/10
 * 描述: Osu顶级排名
 */

@Composable
fun TopRank(
    pinnedMaps: MutableStateFlow<List<OsuTopRankUI>>,
    topMaps: MutableStateFlow<List<OsuTopRankUI>>,
    firstMaps: MutableStateFlow<List<OsuTopRankUI>>
) {
    val pinnedData by pinnedMaps.collectAsState()
    val topData by topMaps.collectAsState()
    val firstData by firstMaps.collectAsState()

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    val cardWidth = screenWidthDp - 24.dp

    Surface(
        Modifier
            .width(screenWidthDp)
            .padding(vertical = 12.dp),
        RoundedCornerShape(20.dp),
        Red700
    ) {
        Column(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            if (pinnedData.isEmpty() && topData.isEmpty() && firstData.isEmpty()) {
                Text(
                    text = "No play records",
                    color = Beige400,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                return@Column
            }
            if (pinnedData.isNotEmpty()) {
                OsuTopRankItemContent(pinnedData, "Pinned", cardWidth)
            }
            if (topData.isNotEmpty()) {
                OsuTopRankItemContent(topData, "Top", cardWidth)
            }
            if (firstData.isNotEmpty()) {
                OsuTopRankItemContent(firstData, "First", cardWidth)
            }
        }
    }
}

@Composable
fun OsuTopRankItemContent(
    items: List<OsuTopRankUI>,
    title: String,
    cardWidth: Dp
) {
    Column {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Beige400,
            modifier = Modifier
                .padding(start = 16.dp, bottom = 16.dp)
        )
        LazyColumn(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(6.dp))
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
    item: OsuTopRankUI,
    itemWidth: Dp
) {
    Surface(
        Modifier
            .width(itemWidth)
            .padding(bottom = 10.dp),
        RoundedCornerShape(6.dp),
        Transparent
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Red700)
        ) {
            val (
                cover,
                background,
                diff,
                title,
                pp,
                date,
                mods
            ) = createRefs()
            Image(
                painter = rememberAsyncImagePainter(
                    model = item.bg2x,
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
                    .background(Transparent)
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
                Transparent
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = item.cover2x,
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = "Cover",
                    contentScale = ContentScale.Crop
                )
            }
            val inlineContent = mapOf(
                "star" to InlineTextContent(
                    Placeholder(
                        width = 16.sp,
                        height = 14.sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                    )
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.Star),
                        contentDescription = "Star",
                        tint = OsuDiffColor.mapValueToTextColor(
                            item.difficultyRating.toFloat()
                        ),
                        modifier = Modifier.padding(end = 2.dp)
                    )
                },
                "rank" to InlineTextContent(
                    Placeholder(
                        width = 28.sp,
                        height = 12.sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                    )
                ) {
                    Image(
                        painter = rememberVectorPainter(
                            image = when (item.rank) {
                                "XH" -> Filled.OsuSsh
                                "X" -> Filled.OsuSs
                                "SH" -> Filled.OsuSh
                                "S" -> Filled.OsuS
                                "A" -> Filled.OsuA
                                "B" -> Filled.OsuB
                                "C" -> Filled.OsuC
                                "D" -> Filled.OsuD
                                else -> Filled.OsuF
                            }
                        ),
                        contentDescription = "Rank",
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )
                }
            )
            Text(
                text = buildAnnotatedString {
                    appendInlineContent("star", "[star]")
                    append(item.difficultyRating.toString())
                },
                inlineContent = inlineContent,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = OsuDiffColor.mapValueToTextColor(item.difficultyRating.toFloat()),
                modifier = Modifier
                    .constrainAs(diff) {
                        top.linkTo(parent.top)
                        start.linkTo(cover.start)
                    }
                    .background(
                        color = OsuDiffColor.mapValueToColor(
                            item.difficultyRating.toFloat()
                        ),
                        shape = RoundedCornerShape(bottomEnd = 10.dp)
                    )
                    .padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 6.dp)
                    .alpha(0.7f)
            )
            Column(
                modifier = Modifier
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        start.linkTo(cover.end, 8.dp)
                    }
            ) {
                Text(
                    text = item.beatmapSetTitleUnicode,
                    color = Beige400,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    lineHeight = 23.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 108.dp)
                        .padding(top = 4.dp)
                        .requiredHeight(23.dp)
                        .clip(RectangleShape)
                )
                Text(
                    text = item.beatmapSubTitle,
                    color = OSU_BRIGHT_YELLOW,
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier
                        .width(itemWidth - 108.dp)
                )
                val score = if ("CL" in item.mods) {
                    item.score
                } else {
                    item.scoreV2
                }
                Text(
                    text = buildAnnotatedString {
                        if (item.mode == "osu" || item.mode == "fruits") {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(item.accuracy)
                            }
                            appendInlineContent("rank", "[rank]")
                            if (score != 0L) {
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                ) {
                                    append(formatNumberThousand(score))
                                }
                            }
                        }
                        if (item.mode == "mania" || item.mode == "taiko") {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(formatNumberThousand(item.score))
                            }
                            if (item.accuracy != "0.00%") {
                                appendInlineContent("rank", "[rank]")
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                ) {
                                    append(item.accuracy)
                                }
                            }
                        }
                    },
                    color = Beige400,
                    inlineContent = inlineContent,
                    maxLines = 1,
                    overflow = TextOverflow.Clip,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Row(
                modifier = Modifier
                    .constrainAs(mods) {
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                        start.linkTo(cover.end, margin = 8.dp)
                    },
                horizontalArrangement = Arrangement.Start
            ) {
                val itemCount = item.mods.size.toDouble()
                val overlap = if (itemCount > 1) {
                    ((itemCount * 25 - 100) / (itemCount - 1)).coerceAtLeast(0.0)
                } else 0.0

                for ((index, mod) in item.mods.withIndex()) {
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier.offset(
                            x = (-overlap * index).dp
                        )
                    ) {
                        val modLink = when (mod) {
                            "EZ" -> "easy@2x.62c646c1"
                            "NF" -> "no-fail@2x.e98cfc89"
                            "HT" -> "half@2x.bb7209f6"
                            "SD" -> "sudden-death@2x.47398678"
                            "PF" -> "perfect@2x.1ff7b8b7"
                            "DT" -> "double-time@2x.b3be23db"
                            "NC" -> "nightcore@2x.620515b2"
                            "FI" -> "fader@2x.03843f9a"
                            "HR" -> "hard-rock@2x.864d6584"
                            "HD" -> "hidden@2x.b3bc1d15"
                            "FL" -> "flashlight@2x.82d961b3"
                            "MR" -> "mirror@2x.3f255fca"
                            "SO" -> "spun-out@2x.35e2a417"
                            "TD" -> "touchdevice@2x.aa2bb626"
                            "CL" -> "classic@2x.3176486d"
                            else -> "no-mod@2x.548bb033"
                        }
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = "https://osu.ppy.sh/assets/images/mod_${modLink}.png",
                                contentScale = ContentScale.Crop
                            ),
                            contentDescription = "Mods",
                            modifier = Modifier
                                .width(25.dp)
                                .height(20.dp)
                        )
                    }
                }
            }
            Text(
                text = dateCodeToRecent(item.date),
                fontSize = 10.sp,
                lineHeight = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .constrainAs(date) {
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                        end.linkTo(pp.start, margin = 4.dp)
                    }
            )
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .constrainAs(pp) {
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                        end.linkTo(parent.end, margin = 4.dp)
                    }
                    .clip(RoundedCornerShape(4.dp))
                    .background(BlackAlpha50)
                    .padding(6.dp)
            ) {
                if (item.status == "loved") {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.Heart1),
                        contentDescription = "Loved",
                        tint = OSU_HEART_RED,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                }
                if (item.status == "graveyard" || item.status == "pending") {
                    Text(
                        text = " - ",
                        color = Beige400,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        lineHeight = 20.sp
                    )
                }
                if (item.status == "ranked") {
                    Text(
                        text = String.format(Locale.US, "%.2fpp", item.pp),
                        color = Beige400,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        lineHeight = 20.sp
                    )
                    if (item.weightPP == 0.0) return@Column
                    Text(
                        text = "${truncateToTwoDecimalPlaces(item.weightPP)}pp(" +
                                "${truncateToTwoDecimalPlaces(item.weight)}%)",
                        color = OSU_BRIGHT_YELLOW,
                        fontSize = 10.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Clip,
                    )
                }
            }
        }
    }
}