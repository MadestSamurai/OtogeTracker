package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
                playData
            ) = createRefs()

            // Honor 1
            if (cardData.honor1.isNotBlank()) {
                Text(
                    text = cardData.honor1,
                    modifier = Modifier
                        .constrainAs(honor1) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth()
                        .padding(start = 5.dp, top = 5.dp, end = 5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            when (cardData.honorBase1) {
                                "silver" -> SilverGradientBg
                                "gold" -> GoldGradientBg
                                "platina" -> PlatinumGradientBg
                                "rainbow" -> RainbowGradientBg
                                else -> WhiteGradientBg
                            }
                        ),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Honor 2
            if (cardData.honor2.isNotBlank()) {
                Text(
                    text = cardData.honor2,
                    modifier = Modifier
                        .constrainAs(honor2) {
                            top.linkTo(honor1.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth()
                        .padding(start = 5.dp, top = 2.dp, end = 5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            when (cardData.honorBase2) {
                                "silver" -> SilverGradientBg
                                "gold" -> GoldGradientBg
                                "platina" -> PlatinumGradientBg
                                "rainbow" -> RainbowGradientBg
                                else -> WhiteGradientBg
                            }
                        ),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Honor 3
            if (cardData.honor3.isNotBlank()) {
                Text(
                    text = cardData.honor3,
                    modifier = Modifier
                        .constrainAs(honor3) {
                            top.linkTo(honor2.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth()
                        .padding(start = 5.dp, top = 2.dp, end = 5.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            when (cardData.honorBase3) {
                                "silver" -> SilverGradientBg
                                "gold" -> GoldGradientBg
                                "platina" -> PlatinumGradientBg
                                "rainbow" -> RainbowGradientBg
                                else -> WhiteGradientBg
                            }
                        ),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Image(
                painter = rememberAsyncImagePainter(cardData.roleImageUrl),
                contentDescription = "Cover Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(charaImage) {
                        top.linkTo(honor3.bottom, margin = 5.dp)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(110.dp)
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

            Image(
                painter = rememberVectorPainter(image = Filled.Star),
                colorFilter = ColorFilter.tint(OSU_LEVEL_GOLD_1),
                contentDescription = "Reborn",
                modifier = Modifier
                    .constrainAs(rebornBase) {
                        top.linkTo(honor3.bottom, margin = 5.dp)
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

            Text(
                text = "Lv.",
                color = Beige400,
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(lvText) {
                        top.linkTo(rebornBase.top, margin = 12.dp)
                        start.linkTo(rebornBase.start)
                    }
            )

            Text(
                text = cardData.level.toString(),
                color = Beige400,
                fontSize = 18.sp,
                fontFamily = sarasaBold,
                modifier = Modifier
                    .constrainAs(lv) {
                        top.linkTo(rebornBase.top)
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
                        top.linkTo(rebornBase.top)
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
                        top.linkTo(honor3.bottom, margin = 5.dp)
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