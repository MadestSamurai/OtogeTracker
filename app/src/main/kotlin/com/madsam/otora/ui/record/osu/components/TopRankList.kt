package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.OSU_ARROW_YELLOW
import com.madsam.otora.core.theme.OSU_HEART_RED
import com.madsam.otora.core.theme.Yellow1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaSemiBold
import com.madsam.otora.core.utils.DateTimeUtils.dateCodeToRecent
import com.madsam.otora.core.utils.NumberFormatUtils.formatThousand
import com.madsam.otora.data.osu.ui.model.OsuBriefUiModel
import com.madsam.otora.data.osu.ui.model.OsuTopRankUiModel
import com.madsam.otora.ui.record.osu.constant.OsuDifficultyColor

@Composable
internal fun TopRankList(
    items: OsuBriefUiModel<OsuTopRankUiModel>,
    title: String,
    cardWidth: Dp,
    onMoreClick: () -> Unit = {}
) {
    val colorScheme = MaterialTheme.colorScheme
    val list = items.items
    Column(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = colorScheme.onPrimary,
                modifier = Modifier
                    .background(
                        color = colorScheme.primary,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )
            if (items.isComplete) return@Row
            TextButton(
                onClick = onMoreClick,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .defaultMinSize(1.dp, 1.dp)
                    .height(24.dp)
            ) {
                Text(
                    text = "More",
                    color = colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        val itemWidth = cardWidth - 16.dp
        list.forEach {
            TopRankCard(it, itemWidth)
            if (list.indexOf(it) < list.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
internal fun TopRankCard(
    item: OsuTopRankUiModel,
    itemWidth: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    Column(
        modifier = Modifier
            .width(itemWidth)
            .clip(RoundedCornerShape(6.dp))
            .background(colorScheme.surfaceContainer)
    ) {
        Box(
            modifier = Modifier.height(100.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = item.bg2x,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .alpha(0.15f)
                    .clip(RoundedCornerShape(6.dp))
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Cover image with difficulty overlay
                Box {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = item.cover2x,
                            contentScale = ContentScale.Crop
                        ),
                        contentDescription = "Cover",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(100.dp)
                            .height(100.dp)
                            .clip(RoundedCornerShape(6.dp))
                    )

                    // Difficulty badge
                    DifficultyBadge(
                        difficultyRating = item.difficultyRating,
                        modifier = Modifier.align(Alignment.TopStart)
                    )
                }

                // Content area
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .padding(start = 8.dp, end = 4.dp)
                ) {
                    // Title and subtitle
                    TitleSection(
                        title = item.beatmapSetTitleUnicode,
                        subtitle = item.beatmapSubTitle,
                        itemWidth = itemWidth
                    )

                    // Score section
                    ScoreSection(
                        item = item,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    // Mods and date
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        ModsSection(
                            mods = item.mods,
                            modifier = Modifier.weight(1f, fill = false)
                        )

                        Text(
                            text = dateCodeToRecent(item.date),
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }

        // PP行在底部 - graveyard状态不显示
        if (item.status != "graveyard" && item.status != "pending") {
            PPBottomRow(item = item)
        }
    }
}

@Composable
private fun DifficultyBadge(
    difficultyRating: Double,
    modifier: Modifier = Modifier
) {
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
                tint = OsuDifficultyColor.mapValueToTextColor(difficultyRating.toFloat()),
                modifier = Modifier.padding(end = 2.dp)
            )
        }
    )

    Text(
        text = buildAnnotatedString {
            appendInlineContent("star", "[star]")
            append(difficultyRating.toString())
        },
        inlineContent = inlineContent,
        fontSize = 14.sp,
        fontFamily = sarasaBold,
        color = OsuDifficultyColor.mapValueToTextColor(difficultyRating.toFloat()),
        modifier = modifier
            .background(
                color = OsuDifficultyColor.mapValueToColor(difficultyRating.toFloat()),
                shape = RoundedCornerShape(bottomEnd = 10.dp)
            )
            .padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 6.dp)
            .alpha(0.7f)
    )
}

@Composable
private fun TitleSection(
    title: String,
    subtitle: String,
    itemWidth: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    Text(
        text = title,
        color = colorScheme.onSurface,
        fontSize = 16.sp,
        fontFamily = sarasaSemiBold,
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
        text = subtitle,
        color = colorScheme.secondary,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        modifier = Modifier.width(itemWidth - 108.dp)
    )
}

@Composable
private fun ScoreSection(
    item: OsuTopRankUiModel,
    modifier: Modifier = Modifier
) {
    val colorScheme = MaterialTheme.colorScheme
    val inlineContent = mapOf(
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

    val score = if ("CL" in item.mods) item.score else item.scoreV2

    Text(
        text = buildAnnotatedString {
            if (item.mode == "osu" || item.mode == "fruits") {
                withStyle(
                    style = MaterialTheme.typography.titleMedium.toSpanStyle()
                ) {
                    append(item.accuracy)
                }
                appendInlineContent("rank", "[rank]")
                if (score != 0L) {
                    withStyle(
                        style = MaterialTheme.typography.bodySmall.toSpanStyle()
                    ) {
                        append(formatThousand(score))
                    }
                }
            }
            if (item.mode == "mania" || item.mode == "taiko") {
                withStyle(
                    style = MaterialTheme.typography.titleMedium.toSpanStyle()
                ) {
                    append(formatThousand(item.score))
                }
                if (item.accuracy != "0.00%") {
                    appendInlineContent("rank", "[rank]")
                    withStyle(
                        style = MaterialTheme.typography.bodySmall.toSpanStyle()
                    ) {
                        append(item.accuracy)
                    }
                }
            }
        },
        color = colorScheme.onSurface,
        letterSpacing = (-0.5).sp,
        inlineContent = inlineContent,
        maxLines = 1,
        overflow = TextOverflow.Clip,
        modifier = modifier
    )
}

@Composable
private fun ModsSection(
    mods: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start
    ) {
        for ((index, mod) in mods.withIndex()) {
            Text(
                text = mod,
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(end = if (index < mods.size - 1) 4.dp else 0.dp)
                    .background(
                        color = Color.Black.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
    }
}

@Composable
private fun PPBottomRow(
    item: OsuTopRankUiModel
) {
    val colorScheme = MaterialTheme.colorScheme
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // PP信息
        when (item.status) {
            "qualified", "approved" -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.Tick),
                        contentDescription = "Qualified",
                        tint = OSU_ARROW_YELLOW,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "Qualified",
                        fontSize = 12.sp,
                        color = OSU_ARROW_YELLOW,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            "loved" -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.Heart1),
                        contentDescription = "Loved",
                        tint = OSU_HEART_RED,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "Loved",
                        fontSize = 12.sp,
                        color = OSU_HEART_RED,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            "ranked" -> {
                Row {
                    Text(
                        text = "${item.pp.format(2)}pp",
                        fontSize = 14.sp,
                        fontFamily = sarasaBold,
                        color = colorScheme.primary
                    )
                    if (item.weightPP != 0.0) {
                        Text(
                            text = "${item.weightPP.format(2)}pp(" +
                                    "${item.weight.format(2)}%)",
                            color = colorScheme.secondary,
                            fontSize = 10.sp,
                            maxLines = 1,
                            modifier = Modifier
                                .align(Alignment.Bottom)
                                .padding(start = 4.dp)
                        )
                    }
                }
            }
        }
    }
}

// 扩展函数用于格式化数字
private fun Double.format(decimals: Int): String {
    return String.format("%.${decimals}f", this)
}