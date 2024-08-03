package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
 * 描述: TODO
 */
@Composable
fun OsuSocialCard(
    osuSocialCard: MutableStateFlow<Map<String, String>>,
) {
    val osuSocialCardData = osuSocialCard.collectAsState(initial = emptyMap()).value
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
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Colors.DARK_RED_DEEP)
        ) {
            val (
                playInfo,
                links,
                location,
                interests,
                occupation,
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
                            append(CommonUtils.dateCodeToYMDHMSU(osuSocialCardData["joinDate"] ?: "1970-01-01T00:00:00+00:00"))
                        }
                    },
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
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
                            append(CommonUtils.dateCodeToRecent(osuSocialCardData["lastVisit"] ?: "1970-01-01T00:00:00+00:00"))
                        }
                    },
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp)
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = androidx.compose.ui.text.SpanStyle(
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append("Play with ")
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
                        .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 8.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(links) {
                        top.linkTo(playInfo.bottom)
                        start.linkTo(parent.start)
                    }
            ) {
                if (osuSocialCardData["twitter"] != null) {
                    Surface(
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                            .fillMaxWidth()
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = com.madsam.otora.R.drawable.ic_star),
                                contentDescription = "Twitter",
                                modifier = Modifier
                                    .padding(top = 12.dp, start = 12.dp, bottom = 12.dp)
                            )
                            Text(
                                text = "@${osuSocialCardData["twitter"]!!}",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(12.dp)
                            )
                        }
                    }
                }
                if ((osuSocialCardData["discord"]?:"").isNotEmpty()) {
                    Surface(
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                            .fillMaxWidth()
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = com.madsam.otora.R.drawable.ic_star),
                                contentDescription = "Discord",
                                modifier = Modifier
                                    .padding(top = 12.dp, start = 12.dp, bottom = 12.dp)
                            )
                            Text(
                                text = osuSocialCardData["discord"]!!,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(12.dp)
                            )
                        }
                    }
                }
                if (osuSocialCardData["website"] != null) {
                    Surface(
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 6.dp)
                            .fillMaxWidth()
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = com.madsam.otora.R.drawable.ic_star),
                                contentDescription = "Website",
                                modifier = Modifier
                                    .padding(top = 12.dp, start = 12.dp, bottom = 12.dp)
                            )
                            Text(
                                text = osuSocialCardData["website"]!!,
                                fontSize = 18.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(12.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}