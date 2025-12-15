package com.madsam.otora.ui.record.osu.components

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.graphics.toColorInt
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import com.madsam.otora.R
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.theme.BlackAlpha80
import com.madsam.otora.core.theme.OSU_BRIGHT_RED
import com.madsam.otora.data.osu.remote.model.OsuGroupDTO
import com.madsam.otora.data.osu.ui.model.OsuCardUiModel
import com.madsam.otora.ui.components.GroupListItem
import com.madsam.otora.ui.components.PopupTip
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
internal fun Card(
    osuCardData: MutableStateFlow<OsuCardUiModel>,
    osuGroupDTOList: MutableStateFlow<List<OsuGroupDTO>>,
    cardWidthDp: Dp
) {
    val colorScheme = MaterialTheme.colorScheme
    val cardData by osuCardData.collectAsState()
    val groupListData = osuGroupDTOList.collectAsState(initial = emptyList()).value

    Column {
        ConstraintLayout(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colorScheme.surfaceContainerHigh)
        ) {
            val refs = createRefs()
            val (
                coverImage,
                baseBackground,
                avatarImage,
                nameplateName,
                supporterRank,
                title,
                groupList,
                rank,
                country,
                online,
                tournamentBanner,
            ) = refs
            val svgLoader = ImageLoader.Builder(LocalContext.current)
                .components {
                    add(SvgDecoder.Factory())
                    add(GifDecoder.Factory())
                }
                .build()
            val gifLoader = ImageLoader.Builder(LocalContext.current)
                .components {
                    add(SvgDecoder.Factory())
                    add(GifDecoder.Factory())
                }
                .build()
            val inlineContent = mapOf(
                "onlineMark" to InlineTextContent(
                    Placeholder(
                        width = 25.sp,
                        height = 20.sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.TextBottom
                    )
                ) {
                    Icon(
                        painter = rememberVectorPainter(image = Filled.OsuOnline),
                        tint = if (cardData.isOnline) Color(0xFF8DC63F) else Color(0xFF565656),
                        contentDescription = stringResource(id = R.string.online_mark),
                        modifier = Modifier.padding(end = 5.dp)
                    )
                },
                "flag" to InlineTextContent(
                    Placeholder(
                        width = 26.sp,
                        height = 18.sp,
                        placeholderVerticalAlign = PlaceholderVerticalAlign.TextBottom
                    )
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = cardData.flagUrl,
                            imageLoader = svgLoader,
                            contentScale = ContentScale.Fit
                        ),
                        contentDescription = "Flag",
                        modifier = Modifier.padding(end = 2.dp),
                        contentScale = ContentScale.Fit,
                    )
                }
            )
            
            Image(
                painter = rememberAsyncImagePainter(
                    model = cardData.coverUrl,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Cover Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(cardWidthDp)
                    .height(120.dp)
                    .constrainAs(coverImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    )
            )

            Image(
                painter = rememberAsyncImagePainter(
                    model = cardData.tournamentBannerImage2x,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Tournament Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(cardWidthDp)
                    .height(
                        if (cardData.tournamentBannerImage2x.isNotEmpty())
                            cardWidthDp / 50 * 3
                        else 0.dp
                    )
                    .constrainAs(tournamentBanner) {
                        top.linkTo(coverImage.bottom)
                        start.linkTo(coverImage.start)
                        end.linkTo(coverImage.end)
                    }
            )

            Spacer(
                modifier = Modifier
                    .constrainAs(baseBackground) {
                        top.linkTo(tournamentBanner.bottom)
                        start.linkTo(coverImage.start)
                        end.linkTo(coverImage.end)
                    }
                    .width(cardWidthDp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(bottomEnd = 15.dp))
                    .background(colorScheme.surfaceContainer)
            )

            Image(
                painter = rememberAsyncImagePainter(
                    model = cardData.avatarUrl,
                    imageLoader = gifLoader,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Avatar Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(avatarImage) {
                        top.linkTo(tournamentBanner.bottom)
                        start.linkTo(coverImage.start)
                    }
                    .size(130.dp)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 20.dp,
                            bottomEnd = 15.dp
                        )
                    )
            )
            if (cardData.isTitle) {
                Text(
                    text = cardData.title,
                    color = Color(cardData.profileColour.toColorInt()),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .constrainAs(title) {
                            top.linkTo(parent.top, margin = 12.dp)
                            start.linkTo(coverImage.start, margin = 12.dp)
                        }
                        .clip(RoundedCornerShape(6.dp))
                        .background(BlackAlpha80)
                        .padding(
                            horizontal = 5.dp,
                            vertical = 2.dp
                        )
                )
            }
            LazyRow(
                reverseLayout = true,
                modifier = Modifier
                    .constrainAs(groupList) {
                        bottom.linkTo(coverImage.bottom, margin = 8.dp)
                        end.linkTo(coverImage.end, margin = 12.dp)
                    }
                    .wrapContentHeight()
                    .width(cardWidthDp - 12.dp)
            ) {
                items(groupListData.size) { index ->
                    GroupListItem(
                        osuGroupDTO = groupListData[index],
                    )
                }
            }
            val formerUsernameShowPopup = remember { MutableTransitionState(false) }
            Text(
                text = cardData.username,
                color = colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .constrainAs(nameplateName) {
                        top.linkTo(avatarImage.top, margin = 8.dp)
                        start.linkTo(avatarImage.end, margin = 12.dp)
                    }
                    .clickable(
                        onClick = { formerUsernameShowPopup.targetState = true }
                    )
            )
            Text(
                text = buildAnnotatedString {
                    appendInlineContent(
                        "onlineMark",
                        "[${stringResource(id = R.string.online_mark)}]"
                    )
                    append(stringResource(id = if (cardData.isOnline) R.string.online else R.string.offline))
                },
                inlineContent = inlineContent,
                modifier = Modifier
                    .constrainAs(online) {
                        start.linkTo(nameplateName.start)
                        top.linkTo(nameplateName.bottom)
                        bottom.linkTo(baseBackground.bottom)
                    }
                    .padding(start = 5.dp),
                color = colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge
            )
            val supporterShowPopup = remember { MutableTransitionState(false) }
            if (cardData.isSupporter) {
                Box(
                    modifier = Modifier
                        .constrainAs(supporterRank) {
                            top.linkTo(nameplateName.top)
                            bottom.linkTo(nameplateName.bottom)
                            start.linkTo(nameplateName.end, margin = 12.dp)
                        }
                        .clickable(
                            onClick = { supporterShowPopup.targetState = true }
                        )
                        .height(20.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(OSU_BRIGHT_RED)
                ) {
                    Image(
                        painter = rememberVectorPainter(
                            image = when (cardData.supporterRank) {
                                1 -> Filled.Heart1
                                2 -> Filled.Heart2
                                3 -> Filled.Heart3
                                else -> Filled.Heart1
                            }
                        ),
                        colorFilter = ColorFilter.tint(Color.White),
                        contentDescription = "Supporter Rank",
                        modifier = Modifier
                            .height(20.dp)
                            .padding(
                                horizontal = 12.dp,
                                vertical = 4.dp
                            ),
                    )
                }
            }
            val modeGlobalRankShowPopup = remember { MutableTransitionState(false) }
            Text(
                text = cardData.rank,
                color = colorScheme.onSurface,
                style = MaterialTheme.typography.titleLarge,
                letterSpacing = (-0.5).sp,
                modifier = Modifier
                    .constrainAs(rank) {
                        top.linkTo(baseBackground.bottom)
                        bottom.linkTo(avatarImage.bottom)
                        start.linkTo(avatarImage.end, margin = 12.dp)
                    }
                    .clickable(
                        onClick = { modeGlobalRankShowPopup.targetState = true }
                    )
            )
            val modeCountryRankShowPopup = remember { MutableTransitionState(false) }
            Column(
                modifier = Modifier
                    .constrainAs(country) {
                        start.linkTo(rank.end, margin = 15.dp)
                        top.linkTo(baseBackground.bottom)
                        bottom.linkTo(avatarImage.bottom)
                    }
                    .clickable(
                        onClick = { modeCountryRankShowPopup.targetState = true }
                    )
            ) {
                Text(
                    text = buildAnnotatedString {
                        appendInlineContent("flag", "[Flag]")
                        append(cardData.country)
                    },
                    inlineContent = inlineContent,
                    color = colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 18.sp,
                )
                Text(
                    text = cardData.countryRank,
                    color = colorScheme.onSurface,
                    style = MaterialTheme.typography.titleMedium,
                    lineHeight = 20.sp,
                )
            }
            // Popups
            val (
                supporterPopup,
                formerUsernamePopup,
                modeGlobalRankPopup,
                modeCountryRankPopup,
            ) = refs
            if (cardData.isSupporter) {
                PopupTip(
                    "Supporter Rank ${cardData.supporterRank}",
                    OSU_BRIGHT_RED,
                    Modifier.constrainAs(supporterPopup) {
                        top.linkTo(supporterRank.bottom, margin = 4.dp)
                        start.linkTo(supporterRank.start)
                        end.linkTo(supporterRank.end)
                    },
                    supporterShowPopup,
                    Alignment.TopCenter
                )
            }
            if (cardData.formerUsernames.isNotEmpty()) {
                PopupTip(
                    "formerly known as:\n${cardData.formerUsernames}",
                    colorScheme.onSurface,
                    Modifier.constrainAs(formerUsernamePopup) {
                        top.linkTo(nameplateName.bottom, margin = 4.dp)
                        start.linkTo(nameplateName.start)
                    },
                    formerUsernameShowPopup,
                    Alignment.TopStart
                )
            }
            if (cardData.currentMode == "mania") {
                PopupTip(
                    cardData.maniaModeGlobalRank,
                    colorScheme.onSurface,
                    Modifier.constrainAs(modeGlobalRankPopup) {
                        top.linkTo(rank.bottom, margin = 4.dp)
                        start.linkTo(rank.start)
                        end.linkTo(rank.end)
                    },
                    modeGlobalRankShowPopup,
                    Alignment.TopCenter
                )
                PopupTip(
                    cardData.maniaModeCountryRank,
                    colorScheme.onSurface,
                    Modifier.constrainAs(modeCountryRankPopup) {
                        top.linkTo(country.bottom, margin = 4.dp)
                        start.linkTo(country.start)
                        end.linkTo(country.end)
                    },
                    modeCountryRankShowPopup,
                    Alignment.TopCenter
                )
            }
        }
    }
}