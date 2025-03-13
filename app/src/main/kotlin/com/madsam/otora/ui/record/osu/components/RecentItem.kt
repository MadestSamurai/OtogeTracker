package com.madsam.otora.ui.record.osu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.OSU_ARROW_YELLOW
import com.madsam.otora.core.theme.OSU_BRIGHT_YELLOW
import com.madsam.otora.core.theme.OSU_HEART_RED
import com.madsam.otora.core.theme.OSU_ROTATE_GREEN
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.utils.CommonUtils.dateCodeToRecent
import com.madsam.otora.data.osu.ui.model.OsuRecentUiModel

@Composable
internal fun RecentItem(
    activity: OsuRecentUiModel,
    cardWidthDp: Dp
) {
    val textFormat =
        buildAnnotatedString {
            appendInlineContent("icon", "[${activity.type}]")
            when (activity.type) {
                "rank" -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("achieved #${activity.rank} on ")
                    }
                    appendInlineContent("mode", "[${activity.mode}]")
                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                        append(activity.beatmapTitle)
                    }
                }

                "rankLost" -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("lost first place on ")
                    }
                    appendInlineContent("mode", "[${activity.mode}]")
                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                        append(activity.beatmapTitle)
                    }
                }

                "beatmapsetUpload" -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("submitted a new beatmap ")
                    }
                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                        append(activity.beatmapSetTitle)
                    }
                }

                "beatmapsetUpdate" -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("updated a beatmap ")
                    }
                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                        append(activity.beatmapSetTitle)
                    }
                }

                "userSupportGift" -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("received the gift of osu!supporter")
                    }
                }

                "userSupportAgain" -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("support osu! again")
                    }
                }

                "beatmapsetRevive" -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("revived a beatmap ")
                    }
                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                        append(activity.beatmapSetTitle)
                    }
                }

                "beatmapsetApprove" -> {
                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                        append(activity.beatmapSetTitle)
                    }
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append(" has been ${activity.approval}")
                    }
                }

                "achievement" -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("achieved ")
                    }
                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                        append(activity.achievement)
                    }
                }

                else -> {
                    withStyle(style = SpanStyle(color = Beige400)) {
                        append("achieved #${activity.rank} on ${activity.beatmapTitle}")
                    }
                }
            }
        }
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Red500)
            .padding(2.dp)
    ) {
        val textWidth = cardWidthDp - 8.dp
        val inlineContent = mapOf(
            "mode" to InlineTextContent(
                Placeholder(
                    width = 16.sp,
                    height = 14.sp,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.TextBottom
                )
            ) {
                Icon(
                    painter = rememberVectorPainter(
                        image = when (activity.mode) {
                            "mania" -> Filled.OsumodeMania
                            "osu" -> Filled.OsumodeStd
                            "taiko" -> Filled.OsumodeTaiko
                            "fruits" -> Filled.OsumodeCtb
                            else -> Filled.OsumodeStd
                        }
                    ),
                    contentDescription = "Osu Mode",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 2.dp)
                )
            },
            "icon" to InlineTextContent(
                Placeholder(
                    width = when (activity.type) {
                        "rank" -> 28.sp
                        "achievement" -> 24.sp
                        else -> 18.sp
                    },
                    height = when (activity.type) {
                        "achievement" -> 20.sp
                        else -> 14.sp
                    },
                    placeholderVerticalAlign = when (activity.type) {
                        "achievement" -> PlaceholderVerticalAlign.TextTop
                        else -> PlaceholderVerticalAlign.TextBottom
                    }
                )
            ) {
                when (activity.type) {
                    "rank" -> {
                        Image(
                            painter = rememberVectorPainter(
                                image = when (activity.scoreRank) {
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
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "rankLost" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.DoubleDown),
                            contentDescription = "Osu Mode",
                            tint = Color.White,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "beatmapsetUpload", "beatmapsetUpdate" -> {
                        Icon(
                            painter = rememberVectorPainter(
                                image = when (activity.type) {
                                    "beatmapsetUpload" -> Filled.ArrowUp
                                    "beatmapsetUpdate" -> Filled.ArrowRotate
                                    else -> Filled.ArrowUp
                                }
                            ),
                            contentDescription = "Beatmap Upload",
                            tint = when (activity.type) {
                                "beatmapsetUpload" -> OSU_ARROW_YELLOW
                                "beatmapsetUpdate" -> OSU_ROTATE_GREEN
                                else -> Color.White
                            },
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "userSupportGift" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Gift),
                            contentDescription = "Osu Mode",
                            tint = OSU_HEART_RED,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "userSupportAgain" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Heart1),
                            contentDescription = "Osu Mode",
                            tint = OSU_HEART_RED,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "beatmapsetApprove" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.Tick),
                            contentDescription = "Osu Mode",
                            tint = when (activity.approval) {
                                "qualified" -> OSU_ARROW_YELLOW
                                "approved" -> OSU_ROTATE_GREEN
                                "loved" -> OSU_HEART_RED
                                else -> Color.White
                            },
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "beatmapsetRevive" -> {
                        Icon(
                            painter = rememberVectorPainter(image = Filled.TrashArrowUp),
                            contentDescription = "Osu Mode",
                            tint = Color.White,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }

                    "achievement" -> {
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = activity.achievementIcon,
                                contentScale = ContentScale.Fit
                            ),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Achievement Icon",
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }
                }
            }
        )
        Text(
            text = textFormat,
            inlineContent = inlineContent,
            fontSize = 14.sp,
            lineHeight = 16.sp,
            color = Color.White,
            modifier = Modifier
                .width(textWidth)
                .padding(start = 8.dp, top = 4.dp, end = 8.dp)
        )
        Text(
            text = dateCodeToRecent(activity.createdAt),
            fontSize = 12.sp,
            lineHeight = 14.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(end = 8.dp, bottom = 4.dp)
                .align(End)
        )
    }
}