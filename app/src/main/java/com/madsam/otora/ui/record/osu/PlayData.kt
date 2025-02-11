package com.madsam.otora.ui.record.osu

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.components.ImageWithText
import com.madsam.otora.components.TitleText
import com.madsam.otora.ui.theme.Red500
import com.madsam.otora.ui.theme.Red700
import com.madsam.otora.ui.theme.Red800
import com.madsam.otora.ui.theme.Beige400
import com.madsam.otora.model.osu.ui.OsuPlayUI
import com.madsam.otora.ui.icon.Filled
import com.madsam.otora.utils.CommonUtils
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun PlayData(
    osuPlayData: MutableStateFlow<OsuPlayUI>,
) {
    val playData by osuPlayData.collectAsState()
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    val cardWidthDp = screenWidthDp - 24.dp

    ConstraintLayout(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Red700)
            .width(cardWidthDp)
    ) {
        val refs = createRefs()
        val (
            judgeBackground,
            sshIcon, ssIcon, shIcon, sIcon, aIcon,
            playDataCard
        ) = refs

        createHorizontalChain(sshIcon, ssIcon, shIcon, sIcon, aIcon)

        val iconModifier = Modifier
            .padding(top = 16.dp)
            .width(64.dp)
            .height(32.dp)

        val iconTextSize = 16.sp
        val iconTextColor = Beige400
        val iconTextModifier = Modifier.padding(top = 4.dp)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Red500)
                .constrainAs(judgeBackground) {
                    top.linkTo(parent.top)
                }
        )

        val imageWithTextData = listOf(
            Triple(Filled.OsuSsh, "SSH", playData.sshCount.toString()),
            Triple(Filled.OsuSs, "SS", playData.ssCount.toString()),
            Triple(Filled.OsuSh, "SH", playData.shCount.toString()),
            Triple(Filled.OsuS, "S", playData.sCount.toString()),
            Triple(Filled.OsuA, "A", playData.aCount.toString())
        )

        imageWithTextData.forEachIndexed { index, data ->
            val (imageRes, contentDescription, text) = data
            ImageWithText(
                painter = rememberVectorPainter(image = imageRes),
                contentDescription = contentDescription,
                text = text,
                textSize = iconTextSize,
                textColor = iconTextColor,
                modifier = Modifier
                    .constrainAs(
                        when (index) {
                            0 -> sshIcon
                            1 -> ssIcon
                            2 -> shIcon
                            3 -> sIcon
                            else -> aIcon
                        }
                    ) {
                        top.linkTo(parent.top)
                    },
                iconModifier = iconModifier,
                textModifier = iconTextModifier
            )
        }

        val titleSize = 16.sp
        val textSize = 20.sp
        val textWidth = cardWidthDp / 2 - 15.dp

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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(playDataCard) {
                    top.linkTo(judgeBackground.bottom, margin = 10.dp)
                }
        ) {
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
                            SpanStyle(fontSize = textSize, fontWeight = FontWeight.Bold) to (playTimeStr[0]),
                            SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal) to "${dayHourLabels[0]} ",
                            SpanStyle(fontSize = textSize, fontWeight = FontWeight.Bold) to (playTimeStr[1]),
                            SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal) to "${dayHourLabels[1]} ",
                            SpanStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold) to (playTimeStr[2]),
                            SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal) to "${monthSecondLabels[0]} ",
                            SpanStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold) to (playTimeStr[3]),
                            SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal) to monthSecondLabels[1]
                        )
                        styles.forEach { (style, text) ->
                            withStyle(style = style) {
                                append(text)
                            }
                        }
                    },
                    titleSize = titleSize,
                    titleTextSize = textSize,
                    color = iconTextColor,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(textWidth)
                )
                val ppSplit = (if (playData.pp == 0.0) "0.00" else "%.2f".format(playData.pp)).split(".")
                TitleText(
                    textTitle = "PP",
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = textSize,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(ppSplit[0])
                        }
                        withStyle(
                            style = SpanStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append(".${ppSplit[1]}")
                        }
                    },
                    titleSize = titleSize,
                    titleTextSize = textSize,
                    color = iconTextColor,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(textWidth)
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
                            val text = CommonUtils.bigNumberTextFormat(
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
                                },
                                textSize
                            )
                            TitleText(
                                textTitle = title,
                                text = text,
                                titleSize = titleSize,
                                titleTextSize = textSize,
                                color = iconTextColor,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .width(textWidth)
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
                        style = SpanStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(if (shown) "Show Less Play Data" else "Show More Play Data")
                    }
                },
                fontSize = 18.sp,
                color = Beige400,
                inlineContent = inlineContent,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Red800)
                    .clickable {
                        shown = !shown
                    }
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}