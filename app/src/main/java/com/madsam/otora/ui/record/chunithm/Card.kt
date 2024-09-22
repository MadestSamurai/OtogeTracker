package com.madsam.otora.ui.record.chunithm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import com.madsam.otora.consts.Colors
import com.madsam.otora.entity.chuni.ChuniCard
import com.madsam.otora.utils.CommonUtils

@Composable
fun Card(
    chuniCard: ChuniCard,
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.Transparent,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        val surfaceWidthDp = screenWidthDp - 32.dp
        ConstraintLayout(
            modifier = Modifier
                .background(Colors.DARK_RED_DEEP)
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
            val imageLoader = ImageLoader.Builder(LocalContext.current)
                .components {
                    add(SvgDecoder.Factory())
                    add(GifDecoder.Factory())
                }
                .build()

            Box(
                modifier = Modifier
                    .constrainAs(charaImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(120.dp)
                    .clip(
                        RoundedCornerShape(
                            topEnd = 5.dp,
                            bottomEnd = 5.dp
                        )
                    )
                    .background(
                        when (chuniCard.charaBase) {
                            "silver" -> Colors.OSU_LEVEL_SILVER_1
                            else -> {
                                Colors.DARKER_RED
                            }
                        }
                    )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = chuniCard.charaInfo,
                        imageLoader = imageLoader
                    ),
                    contentDescription = "Cover Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Box(
                modifier = Modifier
                    .constrainAs(honor) {
                        top.linkTo(parent.top)
                        start.linkTo(charaImage.end)
                        end.linkTo(parent.end)
                    }
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        when (chuniCard.honorBase) {
                            "silver" -> Colors.OSU_LEVEL_SILVER_1
                            "gold" -> Colors.OSU_LEVEL_GOLD_1
                            "platina" -> Colors.OSU_LEVEL_PLATINUM_1
                            else -> {
                                Colors.DARKER_RED
                            }
                        }
                    )
            ) {
                Text(
                    text = chuniCard.honorText,
                    modifier = Modifier
                        .width(surfaceWidthDp - 130.dp)
                        .padding(2.dp),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                )
            }

            Image(
                painter = painterResource(id = com.madsam.otora.R.drawable.ic_star),
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
                text = chuniCard.reborn.toString(),
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Lv.",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(lvText) {
                        top.linkTo(rebornBase.top, margin = 12.dp)
                        start.linkTo(rebornBase.start)
                    }
            )

            Text(
                text = chuniCard.lv.toString(),
                color = Colors.DARK_RED_TEXT_LIGHT,
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
                text = chuniCard.nameIn,
                color = Colors.DARK_RED_TEXT_LIGHT,
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
                painter = rememberAsyncImagePainter(
                    model = "https://chunithm.wahlap.com/mobile/images/classemblem_base_0${chuniCard.classEmblemBase}.png",
                    imageLoader = imageLoader
                ),
                contentDescription = "Class Emblem",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .constrainAs(classEmblemBase) {
                        top.linkTo(username.top)
                        bottom.linkTo(username.bottom)
                        end.linkTo(parent.end)
                    }
                    .height(30.dp)

            )

            Image(
                painter = rememberAsyncImagePainter(
                    model = "https://chunithm.wahlap.com/mobile/images/classemblem_medal_0${chuniCard.classEmblemTop}.png",
                    imageLoader = imageLoader
                ),
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
                            color = Colors.DARK_RED_TEXT,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("RATING ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = CommonUtils.getRatingBrush(chuniCard.rating),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(chuniCard.rating)
                    }
                    append(" (MAX ")
                    withStyle(
                        style = SpanStyle(
                            color = Colors.DARK_RED_TEXT,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(chuniCard.ratingMax)
                    }
                    append(")")
                },
                color = Colors.DARK_RED_TEXT,
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(rating) {
                        top.linkTo(username.bottom)
                        start.linkTo(charaImage.end)
                    }
                    .padding(start = 5.dp, top = 2.dp)
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Colors.DARK_RED_TEXT,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("OVERPOWER ")
                    }
                    append(chuniCard.overpower)
                },
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(overpower) {
                        top.linkTo(rating.bottom)
                        start.linkTo(charaImage.end)
                    }
                    .padding(start = 5.dp)
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Colors.DARK_RED_TEXT,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append("LAST PLAY ")
                    }
                    append(chuniCard.lastPlay)
                },
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(lastPlay) {
                        top.linkTo(overpower.bottom)
                        start.linkTo(charaImage.end)
                    }
                    .padding(start = 5.dp)
            )
        }
    }
}