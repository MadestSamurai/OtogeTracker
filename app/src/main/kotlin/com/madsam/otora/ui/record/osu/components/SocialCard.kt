package com.madsam.otora.ui.record.osu.components

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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.OSU_BRIGHT_RED
import com.madsam.otora.core.theme.OSU_DISCORD_BG
import com.madsam.otora.core.theme.OSU_DISCORD_TEXT
import com.madsam.otora.core.theme.OSU_X_BG
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.interTightRegular
import com.madsam.otora.core.theme.interTightSemiBold
import com.madsam.otora.core.utils.CommonUtils
import com.madsam.otora.core.utils.CommonUtils.dateCodeToRecent
import com.madsam.otora.data.osu.ui.model.OsuSocialUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun SocialCard(
    osuSocialCard: MutableStateFlow<OsuSocialUiModel>,
    cardWidthDp: Dp
) {
    val data by osuSocialCard.collectAsState()

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
                    append("Joined ")
                    withStyle(
                        style = SpanStyle(
                            fontFamily = interTightSemiBold
                        )
                    ) {
                        append(
                            CommonUtils.dateCodeToYMDHMSU(
                                data.joinDate
                            )
                        )
                    }
                },
                fontFamily = interTightRegular,
                fontSize = 16.sp,
                color = Beige400,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
            )
            Text(
                text = buildAnnotatedString {
                    append("Last seen ")
                    withStyle(
                        style = SpanStyle(
                            fontFamily = interTightSemiBold
                        )
                    ) {
                        append(
                            dateCodeToRecent(data.lastVisit)
                        )
                    }
                },
                fontFamily = interTightRegular,
                fontSize = 16.sp,
                color = Beige400,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            if (data.location.isNotEmpty()) {
                Text(
                    text = buildAnnotatedString {
                        append("From ")
                        withStyle(
                            style = SpanStyle(
                                fontFamily = interTightSemiBold
                            )
                        ) {
                            append(data.location)
                        }
                    },
                    fontFamily = interTightRegular,
                    fontSize = 16.sp,
                    color = Beige400,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
            if (data.playStyle.isNotEmpty()) {
                Text(
                    text = buildAnnotatedString {
                        append("Plays with ")
                        withStyle(
                            style = SpanStyle(
                                fontFamily = interTightSemiBold
                            )
                        ) {
                            append(data.playStyle)
                        }
                    },
                    fontFamily = interTightRegular,
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
                            fontFamily = interTightSemiBold,
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
                            fontFamily = interTightSemiBold,
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
