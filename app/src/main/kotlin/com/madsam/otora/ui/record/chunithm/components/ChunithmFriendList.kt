package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
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
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.utils.CommonUtils.getRatingBrush
import com.madsam.otora.core.utils.ndp
import com.madsam.otora.data.chunithm.ui.model.ChunithmFriendUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun ChunithmFriendList(
    chuniFriendListUI: MutableStateFlow<List<ChunithmFriendUiModel>>,
    cardWidth: Dp,
    showOnlyScored: Boolean = false,
    showPinnedLabel: Boolean = false
) {
    val friendList by chuniFriendListUI.collectAsState()

    val filteredList = if (showOnlyScored) {
        friendList.filter { it.isScored }
    } else {
        friendList.filter { !it.isScored }
    }

    if (filteredList.isEmpty()) return

    Column(
        modifier = Modifier
            .width(cardWidth)
            .padding(vertical = 12.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Red700)
            .padding(vertical = 4.dp)
    ) {
        // 置顶标签
        if (showPinnedLabel) {
            Text(
                text = "已登录分数 (置顶)",
                color = Beige500,
                fontSize = 14.sp,
                fontFamily = sarasaBold,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
        
        for (chuniFriend in filteredList) {
            FriendCard(chuniFriend, cardWidth - 12.dp)
        }
    }
}

@Composable
internal fun FriendCard(
    chuniFriend: ChunithmFriendUiModel,
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
                honor1,
                honor2,
                honor3,
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

            // Honor 1
            if (chuniFriend.honor1.isNotBlank()) {
                Text(
                    text = chuniFriend.honor1,
                    modifier = Modifier
                        .constrainAs(honor1) {
                            top.linkTo(parent.top)
                            start.linkTo(charaImage.end)
                        }
                        .width((width - 100.dp) / 3 - 3.dp)
                        .padding(top = 5.dp, end = 1.5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            when (chuniFriend.honorBase1) {
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
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                )
            }

            // Honor 2
            if (chuniFriend.honor2.isNotBlank()) {
                Text(
                    text = chuniFriend.honor2,
                    modifier = Modifier
                        .constrainAs(honor2) {
                            top.linkTo(parent.top)
                            start.linkTo(honor1.end)
                        }
                        .width((width - 100.dp) / 3 - 3.dp)
                        .padding(start = 1.5.dp, top = 5.dp, end = 1.5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            when (chuniFriend.honorBase2) {
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
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                )
            }

            // Honor 3
            if (chuniFriend.honor3.isNotBlank()) {
                Text(
                    text = chuniFriend.honor3,
                    modifier = Modifier
                        .constrainAs(honor3) {
                            top.linkTo(parent.top)
                            start.linkTo(honor2.end)
                            end.linkTo(parent.end)
                        }
                        .width((width - 100.dp) / 3 - 3.dp)
                        .padding(start = 1.5.dp, top = 5.dp, end = 5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            when (chuniFriend.honorBase3) {
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
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                )
            }

            if (chuniFriend.reborn > 0) {
                Image(
                    painter = rememberVectorPainter(image = Filled.Star),
                    colorFilter = ColorFilter.tint(OSU_LEVEL_GOLD_1),
                    contentDescription = "Reborn",
                    modifier = Modifier
                        .constrainAs(rebornBase) {
                            top.linkTo(honor1.bottom)
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
                    fontFamily = sarasaBold
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
                            top.linkTo(honor1.bottom, margin = 6.dp)
                            start.linkTo(charaImage.end)
                        }
                    }
            )

            Text(
                text = chuniFriend.level.toString(),
                color = Beige400,
                fontSize = 18.sp,
                fontFamily = sarasaBold,
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
                fontFamily = sarasaBold,
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
                        top.linkTo(honor1.bottom)
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
                            fontFamily = sarasaRegular
                        )
                    ) {
                        append("RATING ")
                    }
                    withStyle(
                        style = SpanStyle(
                            brush = getRatingBrush(chuniFriend.rating),
                            fontSize = 16.sp,
                            fontFamily = sarasaBold
                        )
                    ) {
                        append(chuniFriend.rating)
                    }
                    append(" (MAX ")
                    withStyle(
                        style = SpanStyle(
                            color = Beige500,
                            fontSize = 12.sp,
                            fontFamily = sarasaBold
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
                            fontFamily = sarasaRegular
                        )
                    ) {
                        append("OVERPOWER ")
                    }
                    append(chuniFriend.overpower)
                },
                color = Beige400,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                fontFamily = sarasaBold,
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
                            fontFamily = sarasaRegular
                        )
                    ) {
                        append("LAST PLAY ")
                    }
                    append(chuniFriend.lastPlay)
                },
                color = Beige400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = sarasaBold,
                modifier = Modifier
                    .constrainAs(lastPlay) {
                        top.linkTo(overpower.bottom)
                        start.linkTo(charaImage.end)
                    }
            )
        }
    }
}