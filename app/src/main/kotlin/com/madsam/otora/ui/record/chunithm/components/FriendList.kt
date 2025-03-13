package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.data.chunithm.ui.model.ChuniFriendUI
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.GradientBrush.GoldGradientBg
import com.madsam.otora.core.theme.GradientBrush.PlatinumGradientBg
import com.madsam.otora.core.theme.GradientBrush.RainbowGradientBg
import com.madsam.otora.core.theme.GradientBrush.SilverGradientBg
import com.madsam.otora.core.theme.GradientBrush.WhiteGradientBg
import com.madsam.otora.core.theme.OSU_LEVEL_GOLD_1
import com.madsam.otora.core.theme.OSU_LEVEL_PLATINUM_1
import com.madsam.otora.core.theme.RANKING_BLUE
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.utils.CommonUtils.getRatingBrush
import com.madsam.otora.core.utils.ndp
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun FriendList(
    chuniFriendListUI: MutableStateFlow<List<ChuniFriendUI>>
) {
    val friendList by chuniFriendListUI.collectAsState()
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    val cardWidth = screenWidthDp - 24.dp

    // 只显示登录用户评分的好友
    val scoredList = friendList.filter { it.isScored }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Red700)
            .padding(vertical = 4.dp)
    ) {
        for (chuniFriend in scoredList) {
            FriendCard(chuniFriend, cardWidth - 12.dp)
        }
    }
}

@Composable
internal fun FriendCard(
    chuniFriend: ChuniFriendUI,
    width: Dp
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.Transparent,
        modifier = Modifier
            .padding(horizontal = 6.dp, vertical = 2.dp)
            .fillMaxWidth()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(
                    when (chuniFriend.profileBackground) {
                        "silver" -> RANKING_BLUE
                        "gold" -> OSU_LEVEL_GOLD_1
                        "platina" -> OSU_LEVEL_PLATINUM_1
                        else -> Red500
                    }
                )
        ) {
            val (
                charaImage,
                honor,
                reborn,
                rebornBase,
                lvText,
                lv,
                username,
                classEmblemBase,
                classEmblem,
                rating,
                overpower,
                lastPlay,
            ) = createRefs()

            Image(
                painter = rememberAsyncImagePainter(chuniFriend.roleImageUrl),
                contentDescription = "Cover Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(charaImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(100.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        when (chuniFriend.roleBase) {
                            "silver" -> SilverGradientBg
                            "gold" -> GoldGradientBg
                            "platina" -> PlatinumGradientBg
                            "rainbow" -> RainbowGradientBg
                            else -> WhiteGradientBg
                        }
                    )
            )

            Text(
                text = chuniFriend.honorText,
                modifier = Modifier
                    .constrainAs(honor) {
                        top.linkTo(parent.top)
                        start.linkTo(charaImage.end)
                        end.linkTo(parent.end)
                    }
                    .width(width - 100.dp)
                    .padding(top = 5.dp, end = 5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        when (chuniFriend.honorBase) {
                            "silver" -> SilverGradientBg
                            "gold" -> GoldGradientBg
                            "platina" -> PlatinumGradientBg
                            "rainbow" -> RainbowGradientBg
                            else -> WhiteGradientBg
                        }
                    )
                    .basicMarquee(spacing = MarqueeSpacing(15.ndp())),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            if (chuniFriend.reborn > 0) {
                Image(
                    painter = rememberVectorPainter(image = Filled.Star),
                    colorFilter = ColorFilter.tint(OSU_LEVEL_GOLD_1),
                    contentDescription = "Reborn",
                    modifier = Modifier
                        .constrainAs(rebornBase) {
                            top.linkTo(honor.bottom)
                            start.linkTo(charaImage.end)
                        }
                        .size(16.dp)
                )

                Text(
                    modifier = Modifier
                        .constrainAs(reborn) {
                            top.linkTo(rebornBase.top)
                            start.linkTo(rebornBase.start)
                            bottom.linkTo(rebornBase.bottom)
                            end.linkTo(rebornBase.end)
                        },
                    text = chuniFriend.reborn.toString(),
                    color = Red500,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Lv.",
                color = Beige400,
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(lvText) {
                        if (chuniFriend.reborn > 0) {
                            top.linkTo(rebornBase.top, margin = 12.dp)
                            start.linkTo(rebornBase.start)
                        } else {
                            top.linkTo(honor.bottom, margin = 6.dp)
                            start.linkTo(charaImage.end)
                        }
                    }
            )

            Text(
                text = chuniFriend.level.toString(),
                color = Beige400,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(lv) {
                        top.linkTo(
                            if (chuniFriend.reborn > 0) rebornBase.top
                            else lvText.top
                        )
                        bottom.linkTo(lvText.bottom)
                        start.linkTo(lvText.end, margin = 2.dp)
                    }
            )

            Text(
                text = chuniFriend.friendName,
                color = Beige400,
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(username) {
                        top.linkTo(lv.top)
                        bottom.linkTo(lv.bottom)
                        start.linkTo(lv.end)
                    }
                    .padding(start = 8.dp)
            )

            Image(
                painter = rememberAsyncImagePainter(chuniFriend.classEmblemBase),
                contentDescription = "Class Emblem",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .constrainAs(classEmblemBase) {
                        top.linkTo(honor.bottom)
                        end.linkTo(parent.end)
                    }
                    .width(60.dp)
                    .height(30.dp)
            )

            Image(
                painter = rememberAsyncImagePainter(chuniFriend.classEmblemTop),
                contentDescription = "Class Emblem",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .constrainAs(classEmblem) {
                        start.linkTo(classEmblemBase.start)
                        end.linkTo(classEmblemBase.end)
                        top.linkTo(classEmblemBase.top)
                        bottom.linkTo(classEmblemBase.bottom)
                    }
                    .height(30.dp)
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Beige500,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("RATING ")
                    }
                    withStyle(
                        style = SpanStyle(
                            brush = getRatingBrush(chuniFriend.rating),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(chuniFriend.rating)
                    }
                    append(" (MAX ")
                    withStyle(
                        style = SpanStyle(
                            color = Beige500,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(chuniFriend.ratingMax)
                    }
                    append(")")
                },
                color = Beige500,
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(rating) {
                        top.linkTo(username.bottom)
                        start.linkTo(charaImage.end)
                    }
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Beige500,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("OVERPOWER ")
                    }
                    append(chuniFriend.overpower)
                },
                color = Beige400,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(overpower) {
                        top.linkTo(rating.bottom)
                        start.linkTo(charaImage.end)
                    }
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Beige500,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("LAST PLAY ")
                    }
                    append(chuniFriend.lastPlay)
                },
                color = Beige400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(lastPlay) {
                        top.linkTo(overpower.bottom)
                        start.linkTo(charaImage.end)
                    }
            )
        }
    }
}