package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun OsuRecent(
    recentActivityList: MutableStateFlow<List<Map<String, String>>>
) {
    val recentActivities = recentActivityList.collectAsState(initial = emptyList()).value
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
                val CardWidthDp = screenWidthDp - 32.dp
                items(recentActivities) { recentActivity ->
                    val textFormat = when (recentActivity["type"]) {
                        "rank" -> {
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                    append("achieved #${recentActivity["rank"]} on ")
                                }
                                withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                    append(recentActivity["beatmapTitle"])
                                }
                            }
                        }

                        "rankLost" -> {
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                    append("lost first place on ")
                                }
                                withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                    append(recentActivity["beatmapTitle"])
                                }
                            }
                        }

                        "beatmapsetUpload" -> {
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                    append("submitted a new beatmap ")
                                }
                                withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                    append(recentActivity["beatmapSetTitle"])
                                }
                            }
                        }

                        "beatmapsetUpdate" -> {
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                    append("updated a beatmap ")
                                }
                                withStyle(style = SpanStyle(color = Colors.OSU_BRIGHT_YELLOW)) {
                                    append(recentActivity["beatmapSetTitle"])
                                }
                            }
                        }

                        "userSupportGift" -> {
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                    append("received the gift of osu!supporter")
                                }
                            }
                        }

                        else -> {
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Colors.DARK_RED_TEXT_LIGHT)) {
                                    append("achieved #${recentActivity["rank"]} on ${recentActivity["beatmapTitle"]}")
                                }
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Colors.DARK_RED_DEEPER)
                            .padding(vertical = 2.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .align(CenterVertically)
                        ) {
                            when (recentActivity["type"]) {
                                "rank", "rankLost" -> {
                                    val id = if (recentActivity["type"] == "rank") {
                                        when (recentActivity["scoreRank"]) {
                                            "SSH" -> com.madsam.otora.R.drawable.ic_osu_ssh
                                            "SS" -> com.madsam.otora.R.drawable.ic_osu_ss
                                            "SH" -> com.madsam.otora.R.drawable.ic_osu_sh
                                            "S" -> com.madsam.otora.R.drawable.ic_osu_s
                                            "A" -> com.madsam.otora.R.drawable.ic_osu_a
                                            else -> com.madsam.otora.R.drawable.ic_osu_a
                                        }
                                    } else {
                                        com.madsam.otora.R.drawable.ic_arrow_down
                                    }
                                    Image(
                                        painter = painterResource(id = id),
                                        contentDescription = "Osu Mode",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp, vertical = 4.dp)
                                            .width(20.dp)
                                            .align(CenterHorizontally)
                                    )
                                    Image(
                                        painter =
                                        painterResource(
                                            id = when (recentActivity["mode"]) {
                                                "mania" -> com.madsam.otora.R.drawable.ic_osumode_mania
                                                "osu" -> com.madsam.otora.R.drawable.ic_osumode_std
                                                "taiko" -> com.madsam.otora.R.drawable.ic_osumode_taiko
                                                "fruits" -> com.madsam.otora.R.drawable.ic_osumode_ctb
                                                else -> com.madsam.otora.R.drawable.ic_osumode_std
                                            }
                                        ),
                                        contentDescription = "Osu Mode",
                                        colorFilter = ColorFilter.tint(Color.White),
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .width(20.dp)
                                            .align(CenterHorizontally)
                                    )
                                }

                                "beatmapsetUpload", "beatmapsetUpdate" -> {
                                    Image(
                                        painter =
                                        painterResource(
                                            id = when (recentActivity["type"]) {
                                                "beatmapsetUpload" -> com.madsam.otora.R.drawable.ic_arrow_up
                                                "beatmapsetUpdate" -> com.madsam.otora.R.drawable.ic_arrow_up_2
                                                else -> com.madsam.otora.R.drawable.ic_arrow_up
                                            }
                                        ),
                                        contentDescription = "Beatmap Upload",
                                        colorFilter = ColorFilter.tint(Color.White),
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .size(20.dp)
                                            .align(CenterHorizontally)
                                    )
                                }

                                "userSupportGift" -> {
                                    Image(
                                        painter = painterResource(id = com.madsam.otora.R.drawable.supporter_rank1),
                                        contentDescription = "Osu Mode",
                                        modifier = Modifier
                                            .padding(horizontal = 8.dp)
                                            .size(20.dp)
                                            .align(CenterHorizontally)
                                    )
                                }
                            }
                        }
                        val textWidth = CardWidthDp - 8.dp - 56.dp
                        Text(
                            text = textFormat,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier
                                .width(textWidth - 80.dp)
                                .padding(8.dp)
                                .align(CenterVertically)
                        )
                        Text(
                            text = CommonUtils.dateCodeToRecent(
                                recentActivity["createdAt"] ?: "1970-01-01T00:00:00+00:00"
                            ),
                            fontSize = 10.sp,
                            textAlign = TextAlign.End,
                            color = Color.Gray,
                            modifier = Modifier
                                .width(80.dp)
                                .padding(bottom = 8.dp, end = 8.dp)
                                .align(Bottom)
                        )
                    }
                }
            }
        }
    }
}