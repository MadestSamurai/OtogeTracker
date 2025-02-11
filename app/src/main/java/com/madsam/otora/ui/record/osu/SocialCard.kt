package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.ui.theme.Red700
import com.madsam.otora.ui.theme.Beige400
import com.madsam.otora.ui.theme.OSU_BRIGHT_RED
import com.madsam.otora.ui.theme.OSU_DISCORD_BG
import com.madsam.otora.ui.theme.OSU_DISCORD_TEXT
import com.madsam.otora.ui.theme.OSU_X_BG
import com.madsam.otora.ui.theme.White1000
import com.madsam.otora.model.osu.ui.OsuSocialUI
import com.madsam.otora.ui.icon.Filled
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.CommonUtils.dateCodeToRecent
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.osu.OsuSocialCard
 * 创建者: MadSamurai
 * 创建时间: 2024/8/3
 * 描述: osu!社交卡片
 */

@Composable
fun SocialCard(
    osuSocialCard: MutableStateFlow<OsuSocialUI>,
) {
    val data by osuSocialCard.collectAsState()

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    val cardWidthDp = screenWidthDp - 24.dp

    ConstraintLayout(
        modifier = Modifier
            .width(cardWidthDp)
            .clip(
                RoundedCornerShape(
                    topStart = 6.dp,
                    topEnd = 6.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(Red700)
    ) {
        val (
            playInfo,
            links
        ) = createRefs()
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .constrainAs(playInfo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = androidx.compose.ui.text.SpanStyle(
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("Joined ")
                    }
                    withStyle(
                        style = androidx.compose.ui.text.SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(
                            CommonUtils.dateCodeToYMDHMSU(
                                data.joinDate
                            )
                        )
                    }
                },
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Beige400,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = androidx.compose.ui.text.SpanStyle(
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("Last seen ")
                    }
                    withStyle(
                        style = androidx.compose.ui.text.SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(
                            dateCodeToRecent(data.lastVisit)
                        )
                    }
                },
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Beige400,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            if (data.location.isNotEmpty()) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = androidx.compose.ui.text.SpanStyle(
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append("From ")
                        }
                        withStyle(
                            style = androidx.compose.ui.text.SpanStyle(
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(data.location)
                        }
                    },
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Beige400,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
            if (data.playStyle.isNotEmpty()) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = androidx.compose.ui.text.SpanStyle(
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append("Plays with ")
                        }
                        withStyle(
                            style = androidx.compose.ui.text.SpanStyle(
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append(data.playStyle)
                        }
                    },
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Beige400,
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 4.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(links) {
                    top.linkTo(playInfo.bottom)
                    start.linkTo(parent.start)
                }
                .padding(bottom = 16.dp)
        ) {
            if (data.twitter.isNotEmpty()) {
                Surface(
                    color = OSU_X_BG,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Image(
                            painter = rememberVectorPainter(image = Filled.XLogo),
                            contentDescription = "Twitter",
                            colorFilter = ColorFilter.tint(White1000),
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 18.dp, top = 12.dp, bottom = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "@${data.twitter}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = White1000,
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
            if (data.discord.isNotEmpty()) {
                Surface(
                    color = OSU_DISCORD_BG,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Image(
                            painter = rememberVectorPainter(image = Filled.Discord),
                            contentDescription = "Discord",
                            colorFilter = ColorFilter.tint(OSU_DISCORD_TEXT),
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 18.dp, top = 12.dp, bottom = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = data.discord,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = OSU_DISCORD_TEXT,
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
            if (data.website.isNotEmpty()) {
                Surface(
                    color = OSU_BRIGHT_RED,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Image(
                            painter = rememberVectorPainter(image = Filled.Link),
                            contentDescription = "Website",
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 18.dp, top = 12.dp, bottom = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = data.website,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
        }
    }
}