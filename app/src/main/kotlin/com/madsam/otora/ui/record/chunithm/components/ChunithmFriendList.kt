package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.GradientBrush
import com.madsam.otora.core.theme.TierColors
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.data.chunithm.ui.model.ChunithmFriendUiModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun ChunithmFriendList(
    chuniFriendListUI: MutableStateFlow<List<ChunithmFriendUiModel>>,
    cardWidth: Dp,
    showOnlyScored: Boolean = false
) {
    val colorScheme = MaterialTheme.colorScheme
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
            .padding(bottom = 12.dp)
    ) {
        // 标题栏（与其他组件保持一致的样式）
        if (showOnlyScored) {
            Text(
                text = "置顶好友",
                fontSize = 16.sp,
                fontFamily = plexBold,
                color = colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }
        
        // 好友卡片列表
        for (chuniFriend in filteredList) {
            FriendCard(chuniFriend, colorScheme)
        }
    }
}

@Composable
internal fun FriendCard(
    chuniFriend: ChunithmFriendUiModel,
    colorScheme: androidx.compose.material3.ColorScheme
) {
    val isDark = isSystemInDarkTheme()

    fun getHonorBrush(base: String) = when (base) {
        "silver" -> if (isDark) GradientBrush.TierSilverGradientDark else GradientBrush.TierSilverGradient
        "gold" -> if (isDark) GradientBrush.TierGoldGradientDark else GradientBrush.TierGoldGradient
        "platina" -> if (isDark) GradientBrush.TierPlatinumGradientDark else GradientBrush.TierPlatinumGradient
        "rainbow" -> if (isDark) GradientBrush.TierRainbowGradientDark else GradientBrush.TierRainbowGradient
        else -> if (isDark) GradientBrush.TierWhiteGradientDark else GradientBrush.TierWhiteGradient
    }

    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color.Transparent,
        modifier = Modifier
            .padding(bottom = 4.dp)
            .fillMaxWidth()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(colorScheme.surfaceContainerHigh)
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
                overpower
            ) = createRefs()

            // 构建 honor 列表
            val honors = listOfNotNull(
                if (chuniFriend.honor1.isNotBlank()) 
                    Pair(chuniFriend.honor1, chuniFriend.honorBase1) 
                else null,
                if (chuniFriend.honor2.isNotBlank()) 
                    Pair(chuniFriend.honor2, chuniFriend.honorBase2) 
                else null,
                if (chuniFriend.honor3.isNotBlank()) 
                    Pair(chuniFriend.honor3, chuniFriend.honorBase3) 
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
                    .padding(start = 5.dp, top = 5.dp, end = 5.dp, bottom = 5.dp)
            ) {
                honors.forEachIndexed { index, (honorText, honorBase) ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = if (index == 0) 0.dp else 2.dp)
                            .height(20.dp)
                            .background(
                                brush = getHonorBrush(honorBase),
                                shape = RoundedCornerShape(5.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = honorText,
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(unbounded = true)
                                .basicMarquee(spacing = MarqueeSpacing(15.dp)),
                            textAlign = TextAlign.Center,
                            color = if (isDark) Color.White else Color.Black,
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            fontFamily = plexBold,
                            style = TextStyle(
                                platformStyle = PlatformTextStyle(
                                    includeFontPadding = true
                                )
                            ),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            Image(
                painter = rememberAsyncImagePainter(chuniFriend.roleImageUrl),
                contentDescription = "Cover Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(charaImage) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(82.dp)
                    .padding(start = 5.dp, bottom = 5.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(getHonorBrush(chuniFriend.roleBase))
            )

            if (chuniFriend.reborn > 0) {
                // 星星始终显示为金色（使用金色 Honor 背景的 Container 颜色），文字始终为深色以保持对比度
                val rebornColor = TierColors.GoldContainerLight
                Image(
                    painter = rememberVectorPainter(image = Filled.Star),
                    colorFilter = ColorFilter.tint(rebornColor),
                    contentDescription = "Reborn",
                    modifier = Modifier
                        .constrainAs(rebornBase) {
                            start.linkTo(charaImage.end, margin = 5.dp)
                            top.linkTo(honorColumn.bottom)
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
                    color = Color.Black,
                    fontSize = 12.sp,
                    fontFamily = plexBold
                )
            }

            Text(
                text = "Lv.",
                color = colorScheme.onSurface,
                fontSize = 12.sp,
                modifier = Modifier
                    .constrainAs(lvText) {
                        start.linkTo(charaImage.end, margin = 5.dp)
                        if (chuniFriend.reborn > 0) {
                            top.linkTo(rebornBase.bottom)
                        } else {
                            top.linkTo(honorColumn.bottom, margin = 8.dp)
                        }
                    }
            )

            Text(
                text = chuniFriend.level.toString(),
                color = colorScheme.onSurface,
                fontSize = 18.sp,
                fontFamily = plexBold,
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
                color = colorScheme.onSurface,
                fontSize = 18.sp,
                lineHeight = 22.sp,
                fontFamily = plexBold,
                modifier = Modifier
                    .constrainAs(username) {
                        top.linkTo(
                            if (chuniFriend.reborn > 0) rebornBase.top
                            else lvText.top
                        )
                        bottom.linkTo(lvText.bottom)
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
                        top.linkTo(honorColumn.bottom)
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

            LabeledRatingText(
                rating = chuniFriend.rating,
                label = "RATING",
                labelFontSize = 14.sp,
                ratingFontSize = 16.sp,
                modifier = Modifier
                    .constrainAs(rating) {
                        top.linkTo(username.bottom)
                        start.linkTo(charaImage.end)
                    }
                    .padding(start = 5.dp, top = 2.dp)
            )

            Column(
                modifier = Modifier
                    .constrainAs(overpower) {
                        top.linkTo(rating.bottom)
                        start.linkTo(charaImage.end, margin = 5.dp)
                    }
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = colorScheme.primary,
                                fontSize = 11.sp,
                                fontFamily = plexRegular
                            )
                        ) {
                            append("OVERPOWER ")
                        }
                        append(chuniFriend.overpower)
                    },
                    color = colorScheme.onSurface,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontFamily = plexBold,
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = colorScheme.primary,
                                fontSize = 11.sp,
                                fontFamily = plexRegular
                            )
                        ) {
                            append("LAST PLAY ")
                        }
                        append(chuniFriend.lastPlay)
                    },
                    color = colorScheme.onSurface,
                    fontSize = 12.sp,
                    lineHeight = 14.sp,
                    fontFamily = plexBold,
                )
            }
        }
    }
}