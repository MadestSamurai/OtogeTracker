package com.madsam.otora.ui.record.osu

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.R
import com.madsam.otora.component.ImageWithText
import com.madsam.otora.component.TitleText
import com.madsam.otora.consts.Colors
import com.madsam.otora.utils.CommonUtils
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun OsuPlayData(
    osuPlayData: MutableStateFlow<Map<String, String>>,
) {
    val playData = osuPlayData.collectAsState(initial = emptyMap()).value
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    Surface(
        shape = RoundedCornerShape(
            topStart = 6.dp,
            topEnd = 6.dp,
            bottomStart = 6.dp,
            bottomEnd = 6.dp
        ),
        color = Color.Transparent,
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 4.dp
            )
            .fillMaxWidth()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Colors.DARK_RED_DEEP)
        ) {
            val cardWidthDp = screenWidthDp - 32.dp
            val refs = createRefs()
            val (
                judgeBackground,
                sshIcon, ssIcon, shIcon, sIcon, aIcon,
                playDataCard
            ) = refs

            createHorizontalChain(sshIcon, ssIcon, shIcon, sIcon, aIcon)

            val iconModifier = Modifier
                .padding(top = 16.dp)
                .height(26.dp)

            val iconTextSize = 16.sp
            val iconTextColor = Colors.DARK_RED_TEXT_LIGHT
            val iconTextModifier = Modifier.padding(top = 4.dp)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Colors.DARK_RED)
                    .constrainAs(judgeBackground) {
                        top.linkTo(parent.top)
                    }
            )

            val imageWithTextData = listOf(
                Triple(R.drawable.ic_osu_ssh, "SSH", playData["sshCount"] ?: "0"),
                Triple(R.drawable.ic_osu_ss, "SS", playData["ssCount"] ?: "0"),
                Triple(R.drawable.ic_osu_sh, "SH", playData["shCount"] ?: "0"),
                Triple(R.drawable.ic_osu_s, "S", playData["sCount"] ?: "0"),
                Triple(R.drawable.ic_osu_a, "A", playData["aCount"] ?: "0")
            )

            imageWithTextData.forEachIndexed { index, data ->
                val (imageRes, contentDescription, text) = data
                ImageWithText(
                    painter = painterResource(id = imageRes),
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
            val textWidth = cardWidthDp / 2 - 24.dp

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
                        top.linkTo(judgeBackground.bottom, margin = 15.dp)
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    val playTimeStr = playData["playTime"]?.split(",")
                    val dayHourLabels = listOf("D", "H")
                    val monthSecondLabels = listOf("M", "S")
                    TitleText(
                        textTitle = "Play Time",
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = textSize,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(playTimeStr?.get(0) ?: "0")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append("${dayHourLabels[0]} ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = textSize,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(playTimeStr?.get(1) ?: "0")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append("${dayHourLabels[1]} ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(playTimeStr?.get(2) ?: "0")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append("${monthSecondLabels[0]} ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(playTimeStr?.get(3) ?: "0")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append(monthSecondLabels[1])
                            }
                        },
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                    val ppSplit = playData["pp"]?.split(".")
                    TitleText(
                        textTitle = "PP",
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = textSize,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(ppSplit?.get(0) ?: "0")
                            }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append(".${ppSplit?.get(1) ?: "00"}")
                            }
                        },
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
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
                                    playData[key] ?: "0",
                                    textSize
                                )
                                TitleText(
                                    textTitle = title,
                                    text = text,
                                    titleSize = titleSize,
                                    titleTextSize = textSize,
                                    color = iconTextColor,
                                    modifier = Modifier
                                        .padding(start = 16.dp)
                                        .width(textWidth)
                                )
                            }
                        }
                    }
                }
                Button(
                    onClick = {
                        shown = !shown
                    },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Colors.DARK_RED_DEEPER),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = if (shown) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down),
                        colorFilter = ColorFilter.tint(Colors.DARK_RED_TEXT_LIGHT),
                        contentDescription = "Show More",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(24.dp)
                    )
                    Text(
                        text = if (shown) "Show Less Play Data" else "Show More Play Data",
                        fontSize = 18.sp,
                        color = Colors.DARK_RED_TEXT_LIGHT
                    )
                }
            }
        }
    }
}