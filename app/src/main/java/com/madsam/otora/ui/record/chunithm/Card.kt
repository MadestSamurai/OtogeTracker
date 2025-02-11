package com.madsam.otora.ui.record.chunithm

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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.ui.theme.Red500
import com.madsam.otora.ui.theme.Red700
import com.madsam.otora.ui.theme.Beige500
import com.madsam.otora.ui.theme.Beige400
import com.madsam.otora.ui.theme.GradientBrush.GoldGradientBg
import com.madsam.otora.ui.theme.GradientBrush.PlatinumGradientBg
import com.madsam.otora.ui.theme.GradientBrush.RainbowGradientBg
import com.madsam.otora.ui.theme.GradientBrush.SilverGradientBg
import com.madsam.otora.ui.theme.GradientBrush.WhiteGradientBg
import com.madsam.otora.ui.theme.OSU_LEVEL_GOLD_1
import com.madsam.otora.model.chuni.ui.ChuniCardUI
import com.madsam.otora.ui.icon.Filled
import com.madsam.otora.utils.CommonUtils.getRatingBrush
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun Card(
    chuniCardUI: MutableStateFlow<ChuniCardUI>
) {
    val cardData by chuniCardUI.collectAsState()
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.Transparent,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        val surfaceWidthDp = screenWidthDp - 24.dp
        ConstraintLayout(
            modifier = Modifier
                .background(Red700)
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
                playData
            ) = createRefs()

            Text(
                text = cardData.honorText,
                modifier = Modifier
                    .constrainAs(honor) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .width(surfaceWidthDp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        when (cardData.honorBase) {
                            "silver" -> SilverGradientBg
                            "gold" -> GoldGradientBg
                            "platina" -> PlatinumGradientBg
                            "rainbow" -> RainbowGradientBg
                            else -> WhiteGradientBg
                        }
                    ),
                textAlign = TextAlign.Center,
                color = Color.Black,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
            )

            Image(
                painter = rememberAsyncImagePainter(cardData.roleImageUrl),
                contentDescription = "Cover Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(charaImage) {
                        top.linkTo(honor.bottom)
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
                        top.linkTo(honor.bottom)
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
                fontWeight = FontWeight.Bold
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
                fontWeight = FontWeight.Bold,
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
                fontWeight = FontWeight.Bold,
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
                        top.linkTo(honor.bottom)
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
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("RATING ")
                    }
                    withStyle(
                        style = SpanStyle(
                            brush = getRatingBrush(cardData.rating),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(cardData.rating)
                    }
                    append(" (MAX ")
                    withStyle(
                        style = SpanStyle(
                            color = Beige500,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(cardData.ratingMax)
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
                                fontWeight = FontWeight.Normal
                            )
                        ) { append("OVERPOWER ") }
                        append(cardData.overpower)
                    },
                    color = Beige400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Beige500,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Normal
                            )
                        ) { append("LAST PLAY ") }
                        append(cardData.lastPlay)
                    },
                    color = Beige400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Beige500,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Normal
                            )
                        ) { append("PLAY COUNT ") }
                        append(cardData.playCount)
                    },
                    color = Beige400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Beige500,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Normal
                            )
                        ) { append("POINTS ") }
                        append("${cardData.point}/${cardData.totalPoint}")
                    },
                    color = Beige400,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}