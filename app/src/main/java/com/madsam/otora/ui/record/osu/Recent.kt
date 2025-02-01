package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.consts.DARK_RED_DEEP
import com.madsam.otora.consts.DARK_RED_DEEPER
import com.madsam.otora.consts.DARK_RED_TEXT_LIGHT
import com.madsam.otora.consts.OSU_ARROW_YELLOW
import com.madsam.otora.consts.OSU_BRIGHT_YELLOW
import com.madsam.otora.consts.OSU_HEART_RED
import com.madsam.otora.consts.OSU_ROTATE_GREEN
import com.madsam.otora.model.osu.ui.OsuRecentUI
import com.madsam.otora.ui.icon.Filled
import com.madsam.otora.utils.CommonUtils
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.osu.OsuRecent
 * 创建者: MadSamurai
 * 创建时间: 2024/8/7
 * 描述: 最近活动
 */

@Composable
fun Recent(
    recentActivityList: MutableStateFlow<List<OsuRecentUI>>
) {
    val activities = recentActivityList.collectAsState(initial = emptyList()).value
    if (activities.isEmpty()) return
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    Surface(
        Modifier
            .width(screenWidthDp)
            .padding(
                start = 16.dp,
                top = 12.dp,
                end = 16.dp
            ),
        RoundedCornerShape(20.dp),
        DARK_RED_DEEP
    ) {
        Column {
            Text(
                text = "Recent",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = DARK_RED_TEXT_LIGHT,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .padding(8.dp)
                    .height(200.dp)
            ) {
                val cardWidthDp = screenWidthDp - 32.dp

                items(activities) { activity ->
                    val textFormat =
                        buildAnnotatedString {
                            appendInlineContent("icon", "[${activity.type}]")
                            when (activity.type) {
                                "rank" -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append("achieved #${activity.rank} on ")
                                    }
                                    appendInlineContent("mode", "[${activity.mode}]")
                                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                                        append(activity.beatmapTitle)
                                    }
                                }

                                "rankLost" -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append("lost first place on ")
                                    }
                                    appendInlineContent("mode", "[${activity.mode}]")
                                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                                        append(activity.beatmapTitle)
                                    }
                                }

                                "beatmapsetUpload" -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append("submitted a new beatmap ")
                                    }
                                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                                        append(activity.beatmapSetTitle)
                                    }
                                }

                                "beatmapsetUpdate" -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append("updated a beatmap ")
                                    }
                                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                                        append(activity.beatmapSetTitle)
                                    }
                                }

                                "userSupportGift" -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append("received the gift of osu!supporter")
                                    }
                                }

                                "userSupportAgain" -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append("support osu! again")
                                    }
                                }

                                "beatmapsetRevive" -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
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
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append(" has been ${activity.approval}")
                                    }
                                }

                                "achievement" -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append("achieved ")
                                    }
                                    withStyle(style = SpanStyle(color = OSU_BRIGHT_YELLOW)) {
                                        append(activity.achievement)
                                    }
                                }

                                else -> {
                                    withStyle(style = SpanStyle(color = DARK_RED_TEXT_LIGHT)) {
                                        append("achieved #${activity.rank} on ${activity.beatmapTitle}")
                                    }
                                }
                            }
                        }
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(DARK_RED_DEEPER)
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
                                            painter = rememberVectorPainter(image = when (activity.scoreRank) {
                                                "XH" -> Filled.OsuSsh
                                                "X" -> Filled.OsuSh
                                                "SH" -> Filled.OsuSs
                                                "S" -> Filled.OsuS
                                                "A" -> Filled.OsuA
                                                "B" -> Filled.OsuB
                                                "C" -> Filled.OsuC
                                                "D" -> Filled.OsuD
                                                else -> Filled.OsuF
                                            }),
                                            contentDescription = "Osu Mode",
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
                                                "qualified" -> OSU_HEART_RED
                                                "approved" -> OSU_HEART_RED
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
                            text = CommonUtils.dateCodeToRecent(
                                activity.createdAt
                            ),
                            fontSize = 12.sp,
                            lineHeight = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(end = 8.dp, bottom = 4.dp)
                                .align(End)
                        )
                    }
                }
            }
        }
    }
}