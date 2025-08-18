package com.madsam.otora.ui.record.osu.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.data.osu.ui.model.OsuPlayUiModel
import com.madsam.otora.ui.components.ImageWithText
import com.madsam.otora.ui.components.TitleText
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun PlayData(
    osuPlayData: MutableStateFlow<OsuPlayUiModel>,
    modifier: Modifier = Modifier
) {
    val playData by osuPlayData.collectAsState()
    
    val iconTextColor = Beige400

    Column(
        modifier = modifier
            .padding(bottom = 4.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Red700)
            .fillMaxWidth()
    ) {
        // 五个标志图标区域
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Red500)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val imageWithTextData = listOf(
                Triple(Filled.OsuSsh, "SSH", playData.sshCount.toString()),
                Triple(Filled.OsuSs, "SS", playData.ssCount.toString()),
                Triple(Filled.OsuSh, "SH", playData.shCount.toString()),
                Triple(Filled.OsuS, "S", playData.sCount.toString()),
                Triple(Filled.OsuA, "A", playData.aCount.toString())
            )

            imageWithTextData.forEach { (imageRes, contentDescription, text) ->
                ImageWithText(
                    painter = rememberVectorPainter(image = imageRes),
                    contentDescription = contentDescription,
                    text = text,
                    textColor = iconTextColor,
                    modifier = Modifier,
                    iconModifier = Modifier.width(64.dp).height(32.dp),
                    textModifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        // 数据卡片区域
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            var shown by remember { mutableStateOf(false) }
            val rowData = listOf(
                "Ranked Score" to "rankedScore",
                "Total Score" to "totalScore",
                "Play Count" to "playCount",
                "Total Hits" to "totalHits",
                "Hit Accuracy" to "hitAccuracy",
                "Max Combo" to "maximumCombo",
                "Medals" to "medalCount",
                "Replays Watched" to "replaysWatchedByOthers",
                "Followers" to "followerCount",
                "Mapping Followers" to "mappingFollowerCount",
                "Posts" to "postCount",
                "Comments" to "commentsCount"
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                val playTimeStr = playData.playTime.split(",").let {
                    if (it.size < 4) List(4) { "0" } else it
                }
                val dayHourLabels = listOf("D", "H")
                val monthSecondLabels = listOf("M", "S")
                TitleText(
                    textTitle = "Play Time",
                    text = buildAnnotatedString {
                        val styles = listOf(
                            MaterialTheme.typography.titleLarge to playTimeStr[0],
                            MaterialTheme.typography.bodySmall to "${dayHourLabels[0]} ",
                            MaterialTheme.typography.titleLarge to playTimeStr[1],
                            MaterialTheme.typography.bodySmall to "${dayHourLabels[1]} ",
                            MaterialTheme.typography.titleSmall to playTimeStr[2],
                            MaterialTheme.typography.bodySmall to "${monthSecondLabels[0]} ",
                            MaterialTheme.typography.titleSmall to playTimeStr[3],
                            MaterialTheme.typography.bodySmall to monthSecondLabels[1]
                        )
                        styles.forEach { (style, text) ->
                            withStyle(style = style.toSpanStyle()) {
                                append(text)
                            }
                        }
                    },
                    color = iconTextColor,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(1f)
                )
                val ppSplit = (if (playData.pp == 0.0) "0.00" else "%.2f".format(playData.pp)).split(".")
                TitleText(
                    textTitle = "PP",
                    text = buildAnnotatedString {
                        withStyle(
                            style = MaterialTheme.typography.titleLarge.toSpanStyle()
                        ) {
                            append(ppSplit[0])
                        }
                        withStyle(
                            style = MaterialTheme.typography.bodySmall.toSpanStyle()
                        ) {
                            append(".${ppSplit[1]}")
                        }
                    },
                    color = iconTextColor,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(1f)
                )
            }
            rowData.chunked(2).forEach { pair ->
                AnimatedVisibility(
                    visible = shown,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    ) {
                        pair.forEach { (title, key) ->
                            val text = bigNumberTextFormat(
                                when (key) {
                                    "rankedScore" -> playData.rankedScore
                                    "totalScore" -> playData.totalScore
                                    "playCount" -> playData.playCount
                                    "totalHits" -> playData.totalHits
                                    "hitAccuracy" -> playData.hitAccuracy
                                    "maximumCombo" -> playData.maximumCombo
                                    "medalCount" -> playData.medalCount.toString()
                                    "replaysWatchedByOthers" -> playData.replaysWatchedByOthers
                                    "followerCount" -> playData.followerCount
                                    "mappingFollowerCount" -> playData.mappingFollowerCount
                                    "postCount" -> playData.postCount
                                    "commentsCount" -> playData.commentsCount
                                    else -> "0.0"
                                }
                            )
                            TitleText(
                                textTitle = title,
                                text = text,
                                color = iconTextColor,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .weight(1f)
                            )
                        }
                    }
                }
            }
            val placeholderHeight = 15.sp
            val density = LocalDensity.current
            val inlineContent = mapOf(
                "icon" to InlineTextContent(
                    Placeholder(
                        width = 25.sp,
                        height = placeholderHeight,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                    )
                ) {
                    Image(
                        painter = rememberVectorPainter(image = if (shown) Filled.ChevronUp else Filled.ChevronDown),
                        colorFilter = ColorFilter.tint(Beige400),
                        contentDescription = "Show More",
                        modifier = Modifier.size(with(density) { placeholderHeight.toDp() })
                    )
                }
            )
            Text(
                text = buildAnnotatedString {
                    appendInlineContent("icon")
                    withStyle(
                        style = MaterialTheme.typography.titleMedium.toSpanStyle()
                    ) {
                        append(if (shown) "Show Less Play Data" else "Show More Play Data")
                    }
                },
                color = Beige400,
                inlineContent = inlineContent,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Red500)
                    .clickable {
                        shown = !shown
                    }
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun bigNumberTextFormat(value: String): AnnotatedString {
    val split = value.split(",")
    val text = if (split.size > 2) {
        val splitSize = split.size - 2
        val firstPart = split.dropLast(splitSize).joinToString(",")
        buildAnnotatedString {
            withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle()) {
                append(firstPart)
            }
            withStyle(style = MaterialTheme.typography.bodySmall.toSpanStyle()) {
                append(",${split.takeLast(splitSize).joinToString(",")}")
            }
        }
    } else {
        buildAnnotatedString {
            withStyle(style = MaterialTheme.typography.titleLarge.toSpanStyle()) {
                append(split.joinToString(","))
            }
        }
    }
    return text
}