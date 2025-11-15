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
import com.madsam.otora.core.utils.BrushUtils.getRatingBrush
import com.madsam.otora.data.chunithm.ui.model.ChunithmCardUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun Card(
    chunithmCardUiModel: MutableStateFlow<ChunithmCardUiModel>,
    cardWidthDp: Dp
) {
    val cardData by chunithmCardUiModel.collectAsState()
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.Transparent,
        modifier = Modifier
            .padding(vertical = 12.dp)
            .width(cardWidthDp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(
                    when (cardData.profileBackground) {
                        "silver" -> RANKING_BLUE
                        "gold" -> OSU_LEVEL_GOLD_1
                        "platina" -> OSU_LEVEL_PLATINUM_1
                        else -> Red700
                    }
                )
        ) {
            val (
                honorColumn,
                charaImage,
                reborn,
                rebornBase,
                lvText,
                lv,
                username,
                classEmblemBase,
                classEmblem,
                rating,
                playData
            ) = createRefs()

            // 构建 honor 列表
            val honors = listOfNotNull(
                if (cardData.honor1.isNotBlank()) 
                    Pair(cardData.honor1, cardData.honorBase1) 
                else null,
                if (cardData.honor2.isNotBlank()) 
                    Pair(cardData.honor2, cardData.honorBase2) 
                else null,
                if (cardData.honor3.isNotBlank()) 
                    Pair(cardData.honor3, cardData.honorBase3) 
                else null
            )

            // 动态渲染 honor 列表
            Column(
                modifier = Modifier
                    .constrainAs(honorColumn) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(charaImage.top)
                    }
                    .fillMaxWidth()
                    .padding(start = 5.dp, top = 4.dp, end = 5.dp, bottom = 4.dp)
            ) {
                honors.forEachIndexed { index, (honorText, honorBase) ->
                    Text(
                        text = honorText,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = if (index == 0) 0.dp else 2.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(
                                when (honorBase) {
                                    "silver" -> SilverGradientBg
                                    "gold" -> GoldGradientBg
                                    "platina" -> PlatinumGradientBg
                                    "rainbow" -> RainbowGradientBg
                                    else -> WhiteGradientBg
                                }
                            )
                            .basicMarquee(spacing = MarqueeSpacing(15.dp)),
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = sarasaBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Image(
                painter = rememberAsyncImagePainter(cardData.roleImageUrl),
                contentDescription = "Cover Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(charaImage) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(111.dp)
                    .padding(start = 5.dp, bottom = 5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        when (cardData.roleBase) {
                            "silver" -> SilverGradientBg
                            "gold" -> GoldGradientBg
                            "platina" -> PlatinumGradientBg
                            "rainbow" -> RainbowGradientBg
                            else -> WhiteGradientBg
                        }
                    )
            )

            if (cardData.reborn > 0) {
                Image(
                    painter = rememberVectorPainter(image = Filled.Star),
                    colorFilter = ColorFilter.tint(OSU_LEVEL_GOLD_1),
                    contentDescription = "Reborn",
                    modifier = Modifier
                        .constrainAs(rebornBase) {
                            top.linkTo(honorColumn.bottom)
                            start.linkTo(charaImage.end, margin = 5.dp)
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
                    text = cardData.reborn.toString(),
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
                        start.linkTo(charaImage.end, margin = 5.dp)
                        if (cardData.reborn > 0) {
                            top.linkTo(rebornBase.bottom)
                        } else {
                            top.linkTo(honorColumn.bottom, margin = 8.dp)
                        }
                    }
            )

            Text(
                text = cardData.level.toString(),
                color = Beige400,
                fontSize = 18.sp,
                fontFamily = sarasaBold,
                modifier = Modifier
                    .constrainAs(lv) {
                        top.linkTo(
                            if (cardData.reborn > 0) rebornBase.top
                            else lvText.top
                        )
                        bottom.linkTo(lvText.bottom)
                        start.linkTo(lvText.end, margin = 2.dp)
                    }
            )

            Text(
                text = cardData.nameIn,
                color = Beige400,
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontFamily = sarasaBold,
                modifier = Modifier
                    .constrainAs(username) {
                        top.linkTo(
                            if (cardData.reborn > 0) rebornBase.top
                            else lvText.top
                        )
                        bottom.linkTo(lvText.bottom)
                        start.linkTo(lv.end)
                    }
                    .padding(start = 8.dp)
            )

            Image(
                painter = rememberAsyncImagePainter(cardData.classEmblemBase),
                contentDescription = "Class Emblem",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .constrainAs(classEmblemBase) {
                        top.linkTo(honorColumn.bottom)
                        end.linkTo(parent.end)
                    }
                    .width(60.dp)
                    .height(30.dp)
            )

            Image(
                painter = rememberAsyncImagePainter(cardData.classEmblemTop),
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
                            brush = getRatingBrush(cardData.rating),
                            fontSize = 16.sp,
                            fontFamily = sarasaBold
                        )
                    ) {
                        append(cardData.rating)
                    }
                },
                color = Beige500,
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(rating) {
                        top.linkTo(username.bottom)
                        start.linkTo(charaImage.end)
                    }
                    .padding(start = 5.dp, top = 2.dp)
            )

            Column(
                modifier = Modifier
                    .constrainAs(playData) {
                        top.linkTo(rating.bottom)
                        start.linkTo(charaImage.end, 5.dp)
                    }
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Beige500,
                                fontSize = 11.sp,
                                fontFamily = sarasaRegular
                            )
                        ) { append("OVERPOWER ") }
                        append(cardData.overpower)
                    },
                    color = Beige400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontFamily = sarasaBold,
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Beige500,
                                fontSize = 11.sp,
                                fontFamily = sarasaRegular
                            )
                        ) { append("LAST PLAY ") }
                        append(cardData.lastPlay)
                    },
                    color = Beige400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontFamily = sarasaBold,
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Beige500,
                                fontSize = 11.sp,
                                fontFamily = sarasaRegular
                            )
                        ) { append("PLAY COUNT ") }
                        append(cardData.playCount)
                    },
                    color = Beige400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontFamily = sarasaBold,
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Beige500,
                                fontSize = 11.sp,
                                fontFamily = sarasaRegular
                            )
                        ) { append("POINTS ") }
                        append("${cardData.point}/${cardData.totalPoint}")
                    },
                    color = Beige400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontFamily = sarasaBold,
                )
            }
        }
    }
}