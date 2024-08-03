package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                sshIcon,
                ssIcon,
                shIcon,
                sIcon,
                aIcon,
                playDataCard,
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

            ImageWithText(
                painter = painterResource(id = R.drawable.ic_osu_ssh),
                contentDescription = "SSH",
                text = playData["sshCount"] ?: "0",
                textSize = iconTextSize,
                textColor = iconTextColor,
                modifier = Modifier
                    .constrainAs(sshIcon) {
                        top.linkTo(parent.top)
                    },
                iconModifier = iconModifier,
                textModifier = iconTextModifier
            )

            ImageWithText(
                painter = painterResource(id = R.drawable.ic_osu_ss),
                contentDescription = "SS",
                text = playData["ssCount"] ?: "0",
                textSize = iconTextSize,
                textColor = iconTextColor,
                modifier = Modifier
                    .constrainAs(ssIcon) {
                        top.linkTo(parent.top)
                    },
                iconModifier = iconModifier,
                textModifier = iconTextModifier
            )

            ImageWithText(
                painter = painterResource(id = R.drawable.ic_osu_sh),
                contentDescription = "SH",
                text = playData["shCount"] ?: "0",
                textSize = iconTextSize,
                textColor = iconTextColor,
                modifier = Modifier
                    .constrainAs(shIcon) {
                        top.linkTo(parent.top)
                    },
                iconModifier = iconModifier,
                textModifier = iconTextModifier
            )

            ImageWithText(
                painter = painterResource(id = R.drawable.ic_osu_s),
                contentDescription = "S",
                text = playData["sCount"] ?: "0",
                textSize = iconTextSize,
                textColor = iconTextColor,
                modifier = Modifier
                    .constrainAs(sIcon) {
                        top.linkTo(parent.top)
                    },
                iconModifier = iconModifier,
                textModifier = iconTextModifier
            )

            ImageWithText(
                painter = painterResource(id = R.drawable.ic_osu_a),
                contentDescription = "A",
                text = playData["aCount"] ?: "0",
                textSize = iconTextSize,
                textColor = iconTextColor,
                modifier = Modifier
                    .constrainAs(aIcon) {
                        top.linkTo(parent.top)
                    },
                iconModifier = iconModifier,
                textModifier = iconTextModifier
            )

            val titleSize = 16.sp
            val textSize = 20.sp
            val textWidth = cardWidthDp / 2 - 24.dp

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
                            withStyle(style = SpanStyle(fontSize = textSize, fontWeight = FontWeight.Bold)) {
                                append(playTimeStr?.get(0) ?: "0")
                            }
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                                append("${dayHourLabels[0]} ")
                            }
                            withStyle(style = SpanStyle(fontSize = textSize, fontWeight = FontWeight.Bold)) {
                                append(playTimeStr?.get(1) ?: "0")
                            }
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                                append("${dayHourLabels[1]} ")
                            }
                            withStyle(style = SpanStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)) {
                                append(playTimeStr?.get(2) ?: "0")
                            }
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                                append("${monthSecondLabels[0]} ")
                            }
                            withStyle(style = SpanStyle(fontSize = 13.sp, fontWeight = FontWeight.Bold)) {
                                append(playTimeStr?.get(3) ?: "0")
                            }
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
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
                            withStyle(style = SpanStyle(fontSize = textSize, fontWeight = FontWeight.Bold)) {
                                append(ppSplit?.get(0) ?: "0")
                            }
                            withStyle(style = SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )  {
                    val rankedScoreText = CommonUtils.bigNumberTextFormat(playData["rankedScore"]?:"0", textSize)
                    TitleText(
                        textTitle = "Ranked Score",
                        text = rankedScoreText,
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                    val totalScoreText = CommonUtils.bigNumberTextFormat(playData["totalScore"]?:"0", textSize)
                    TitleText(
                        textTitle = "Total Score",
                        text = totalScoreText,
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    TitleText(
                        textTitle = "Play Count",
                        text = playData["playCount"] ?: "0",
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                    val totalHitsText =
                        CommonUtils.bigNumberTextFormat(playData["totalHits"] ?: "0", textSize)
                    TitleText(
                        textTitle = "Total Hits",
                        text = totalHitsText,
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    TitleText(
                        textTitle = "Hit Accuracy",
                        text = playData["hitAccuracy"] ?: "0",
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                    val maximumComboText = CommonUtils.bigNumberTextFormat(playData["maximumCombo"]?:"0", textSize)
                    TitleText(
                        textTitle = "Max Combo",
                        text = maximumComboText,
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    TitleText(
                        textTitle = "Medals",
                        text = playData["medalCount"] ?: "0",
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                    val replayWatchedText = CommonUtils.bigNumberTextFormat(
                        playData["replaysWatchedByOthers"] ?: "0",
                        textSize
                    )
                    TitleText(
                        textTitle = "Replays Watched",
                        text = replayWatchedText,
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    TitleText(
                        textTitle = "Followers",
                        text = playData["followerCount"] ?: "0",
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                    TitleText(
                        textTitle = "Mapping Followers",
                        text = playData["mappingFollowerCount"] ?: "0",
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    TitleText(
                        textTitle = "Posts",
                        text = playData["postCount"] ?: "0",
                        titleSize = titleSize,
                        titleTextSize = textSize,
                        color = iconTextColor,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(textWidth)
                    )
                    TitleText(
                        textTitle = "Comments",
                        text = playData["commentsCount"] ?: "0",
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
}