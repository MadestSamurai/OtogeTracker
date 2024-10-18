package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.consts.Colors
import com.madsam.otora.utils.CommonUtils
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
    osuSocialCard: MutableStateFlow<Map<String, String>>,
) {
    val osuSocialCardData = osuSocialCard.collectAsState(initial = emptyMap()).value
    ConstraintLayout(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
            .clip(
                RoundedCornerShape(
                    topStart = 6.dp,
                    topEnd = 6.dp,
                    bottomStart = 20.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(Colors.DARK_RED_DEEP)
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
                                osuSocialCardData["joinDate"] ?: "1970-01-01T00:00:00+00:00"
                            )
                        )
                    }
                },
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Colors.DARK_RED_TEXT_LIGHT,
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
                            CommonUtils.dateCodeToRecent(
                                osuSocialCardData["lastVisit"] ?: "1970-01-01T00:00:00+00:00"
                            )
                        )
                    }
                },
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Colors.DARK_RED_TEXT_LIGHT,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            if ((osuSocialCardData["location"] ?: "").isNotEmpty()) {
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
                            append(osuSocialCardData["location"] ?: "???")
                        }
                    },
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
            if ((osuSocialCardData["playStyle"] ?: "").isNotEmpty()) {
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
                            append(osuSocialCardData["playStyle"] ?: "???")
                        }
                    },
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Colors.DARK_RED_TEXT_LIGHT,
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
            if ((osuSocialCardData["twitter"] ?: "").isNotEmpty()) {
                Surface(
                    color = Colors.OSU_X_BG,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = com.madsam.otora.R.drawable.ic_x_logo),
                            contentDescription = "Twitter",
                            colorFilter = ColorFilter.tint(Colors.OSU_X_TEXT),
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 18.dp, top = 12.dp, bottom = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "@${osuSocialCardData["twitter"]!!}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Colors.OSU_X_TEXT,
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
            if ((osuSocialCardData["discord"] ?: "").isNotEmpty()) {
                Surface(
                    color = Colors.OSU_DISCORD_BG,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = com.madsam.otora.R.drawable.ic_discord),
                            contentDescription = "Discord",
                            colorFilter = ColorFilter.tint(Colors.OSU_DISCORD_TEXT),
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 18.dp, top = 12.dp, bottom = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = osuSocialCardData["discord"]!!,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Colors.OSU_DISCORD_TEXT,
                            modifier = Modifier
                                .padding(start = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }
            if ((osuSocialCardData["website"] ?: "").isNotEmpty()) {
                Surface(
                    color = Colors.OSU_BRIGHT_RED,
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = com.madsam.otora.R.drawable.ic_link),
                            contentDescription = "Website",
                            colorFilter = ColorFilter.tint(Color.White),
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 18.dp, top = 12.dp, bottom = 12.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = osuSocialCardData["website"]!!,
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