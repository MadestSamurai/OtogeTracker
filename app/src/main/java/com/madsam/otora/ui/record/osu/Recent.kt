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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.consts.Colors
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
    recentActivityList: MutableStateFlow<List<Map<String, String>>>
) {
    val recentActivities = recentActivityList.collectAsState(initial = emptyList()).value
    if (recentActivities.isEmpty() || recentActivities[0].isEmpty()) {
        return
    }
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
        Column {
            Text(
                text = "Recent",
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
                val cardWidthDp = screenWidthDp - 32.dp

                items(recentActivities) { recentActivity ->
                    val textFormat =
                        buildAnnotatedString {
                            appendInlineContent("icon", "[${recentActivity["type"]}]")
                            when (recentActivity["type"]) {
                                "rank" -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("achieved #${recentActivity["rank"]} on ")
                                    }
                                    appendInlineContent("mode", "[${recentActivity["mode"]}]")
                                    withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                        append(recentActivity["beatmapTitle"])
                                    }
                                }

                                "rankLost" -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("lost first place on ")
                                    }
                                    appendInlineContent("mode", "[${recentActivity["mode"]}]")
                                    withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                        append(recentActivity["beatmapTitle"])
                                    }
                                }

                                "beatmapsetUpload" -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("submitted a new beatmap ")
                                    }
                                    withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                        append(recentActivity["beatmapSetTitle"])
                                    }
                                }

                                "beatmapsetUpdate" -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("updated a beatmap ")
                                    }
                                    withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                        append(recentActivity["beatmapSetTitle"])
                                    }
                                }

                                "userSupportGift" -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("received the gift of osu!supporter")
                                    }
                                }

                                "userSupportAgain" -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("support osu! again")
                                    }
                                }

                                "beatmapsetRevive" -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("revived a beatmap ")
                                    }
                                    withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                        append(recentActivity["beatmapSetTitle"])
                                    }
                                }

                                "beatmapsetApprove" -> {
                                    withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                        append(recentActivity["beatmapSetTitle"])
                                    }
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append(" has been ${recentActivity["approval"]}")
                                    }
                                }

                                "achievement" -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("achieved ")
                                    }
                                    withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                        append(recentActivity["achievement"])
                                    }
                                }

                                else -> {
                                    withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                        append("achieved #${recentActivity["rank"]} on ${recentActivity["beatmapTitle"]}")
                                    }
                                }
                            }
                        }
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Colors.DARK_RED_DEEPER)
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
                                    painter = painterResource(
                                        id = when (recentActivity["mode"]) {
                                            "mania" -> com.madsam.otora.R.drawable.ic_osumode_mania
                                            "osu" -> com.madsam.otora.R.drawable.ic_osumode_std
                                            "taiko" -> com.madsam.otora.R.drawable.ic_osumode_taiko
                                            "fruits" -> com.madsam.otora.R.drawable.ic_osumode_ctb
                                            else -> com.madsam.otora.R.drawable.ic_osumode_std
                                        }
                                    ),
                                    contentDescription = "Osu Mode",
                                    tint = Color.White,
                                    modifier = Modifier.padding(end = 2.dp)
                                )
                            },
                            "icon" to InlineTextContent(
                                Placeholder(
                                    width = when (recentActivity["type"]) {
                                        "rank" -> 28.sp
                                        "achievement" -> 24.sp
                                        else -> 18.sp
                                    },
                                    height = when (recentActivity["type"]) {
                                        "achievement" -> 20.sp
                                        else -> 14.sp
                                    },
                                    placeholderVerticalAlign = when (recentActivity["type"]) {
                                        "achievement" -> PlaceholderVerticalAlign.TextTop
                                        else -> PlaceholderVerticalAlign.TextBottom
                                    }
                                )
                            ) {
                                when (recentActivity["type"]) {
                                    "rank" -> {
                                        Image(
                                            painter = painterResource(id = when (recentActivity["scoreRank"]) {
                                                "SSH" -> com.madsam.otora.R.drawable.ic_osu_ssh
                                                "SS" -> com.madsam.otora.R.drawable.ic_osu_ss
                                                "SH" -> com.madsam.otora.R.drawable.ic_osu_sh
                                                "S" -> com.madsam.otora.R.drawable.ic_osu_s
                                                "A" -> com.madsam.otora.R.drawable.ic_osu_a
                                                "B" -> com.madsam.otora.R.drawable.ic_osu_b
                                                "C" -> com.madsam.otora.R.drawable.ic_osu_c
                                                "D" -> com.madsam.otora.R.drawable.ic_osu_d
                                                else -> com.madsam.otora.R.drawable.ic_osu_f
                                            }),
                                            contentDescription = "Osu Mode",
                                            contentScale = ContentScale.Fit,
                                            modifier = Modifier.padding(end = 4.dp)
                                        )
                                    }

                                    "rankLost" -> {
                                        Image(
                                            painter = painterResource(id = com.madsam.otora.R.drawable.ic_double_down),
                                            contentDescription = "Osu Mode",
                                            colorFilter = ColorFilter.tint(Color.White),
                                            modifier = Modifier.padding(end = 4.dp)
                                        )
                                    }

                                    "beatmapsetUpload", "beatmapsetUpdate" -> {
                                        Image(
                                            painter =
                                            painterResource(
                                                id = when (recentActivity["type"]) {
                                                    "beatmapsetUpload" -> com.madsam.otora.R.drawable.ic_up_arrow
                                                    "beatmapsetUpdate" -> com.madsam.otora.R.drawable.ic_rotate_arrow
                                                    else -> com.madsam.otora.R.drawable.ic_up_arrow
                                                }
                                            ),
                                            contentDescription = "Beatmap Upload",
                                            colorFilter = when (recentActivity["type"]) {
                                                "beatmapsetUpload" -> ColorFilter.tint(Colors.OSU_ARROW_YELLOW)
                                                "beatmapsetUpdate" -> ColorFilter.tint(Colors.OSU_ROTATE_GREEN)
                                                else -> ColorFilter.tint(Color.White)
                                            },
                                            modifier = Modifier.padding(end = 4.dp)
                                        )
                                    }

                                    "userSupportGift" -> {
                                        Image(
                                            painter = painterResource(id = com.madsam.otora.R.drawable.ic_gift),
                                            contentDescription = "Osu Mode",
                                            colorFilter = ColorFilter.tint(Colors.OSU_HEART_RED),
                                            modifier = Modifier.padding(end = 4.dp)
                                        )
                                    }

                                    "userSupportAgain" -> {
                                        Image(
                                            painter = painterResource(id = com.madsam.otora.R.drawable.ic_support_1),
                                            contentDescription = "Osu Mode",
                                            colorFilter = ColorFilter.tint(Colors.OSU_HEART_RED),
                                            modifier = Modifier.padding(end = 4.dp)
                                        )
                                    }

                                    "beatmapsetApprove" -> {
                                        Image(
                                            painter = painterResource(id = com.madsam.otora.R.drawable.ic_tick),
                                            contentDescription = "Osu Mode",
                                            colorFilter = ColorFilter.tint(Colors.OSU_HEART_RED),
                                            modifier = Modifier.padding(end = 4.dp)
                                        )
                                    }

                                    "beatmapsetRevive" -> {
                                        Image(
                                            painter = painterResource(id = com.madsam.otora.R.drawable.ic_trash_arrow_up),
                                            contentDescription = "Osu Mode",
                                            colorFilter = ColorFilter.tint(Color.White),
                                            modifier = Modifier.padding(end = 4.dp)
                                        )
                                    }

                                    "achievement" -> {
                                        Image(
                                            painter = rememberAsyncImagePainter(
                                                model = recentActivity["achievementIcon"] ?: "",
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
                            color = Color.White,
                            modifier = Modifier
                                .width(textWidth)
                                .padding(start = 8.dp, top = 4.dp, end = 8.dp)
                        )
                        Text(
                            text = CommonUtils.dateCodeToRecent(
                                recentActivity["createdAt"] ?: "1970-01-01T00:00:00+00:00"
                            ),
                            fontSize = 12.sp,
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