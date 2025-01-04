package com.madsam.otora.ui.record.osu

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import com.madsam.otora.R
import com.madsam.otora.components.GroupListItem
import com.madsam.otora.components.PopupTip
import com.madsam.otora.consts.BG_HALF_TRANS_BLACK
import com.madsam.otora.consts.DARK_RED
import com.madsam.otora.consts.DARK_RED_DEEP
import com.madsam.otora.consts.DARK_RED_TEXT
import com.madsam.otora.consts.DARK_RED_TEXT_LIGHT
import com.madsam.otora.consts.OSU_BRIGHT_RED
import com.madsam.otora.model.osu.web.OsuGroup
import com.madsam.otora.utils.ImageUtils.saveBitmapToFile
import com.madsam.otora.utils.ImageUtils.saveImageToGallery
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.File

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Card(
    osuCardData: MutableStateFlow<Map<String, String>>,
    osuGroupList: MutableStateFlow<List<OsuGroup>>,
) {
    val cardData = osuCardData.collectAsState(initial = emptyMap()).value
    val groupListData = osuGroupList.collectAsState(initial = emptyList()).value
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp

    val captureController = rememberCaptureController()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column {
        ConstraintLayout(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    bottom = 12.dp
                )
                .capturable(captureController)
                .clip(RoundedCornerShape(20.dp))
                .background(DARK_RED_DEEP)
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
                    Image(
                        painter = painterResource(
                            id =
                            if (cardData["isOnline"] == "true") R.drawable.ic_osu_online else R.drawable.ic_osu_offline
                        ),
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
                            model = cardData["flagUrl"],
                            imageLoader = svgLoader,
                            contentScale = ContentScale.Fit
                        ),
                        contentDescription = "Flag",
                        modifier = Modifier.padding(end = 2.dp),
                        contentScale = ContentScale.Fit,
                    )
                }
            )
            val cardWidthDp = screenWidthDp - 32.dp
            Box(
                modifier = Modifier
                    .width(cardWidthDp)
                    .constrainAs(coverImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .height(120.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = cardData["coverUrl"],
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = "Cover Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Image(
                painter = rememberAsyncImagePainter(
                    model = cardData["tournamentBannerImage2x"],
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Tournament Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(cardWidthDp)
                    .height(
                        if ((cardData["tournamentBannerImage2x"]
                                ?: "").isNotEmpty()
                        ) cardWidthDp / 50 * 3 else 0.dp
                    )
                    .constrainAs(tournamentBanner) {
                        top.linkTo(coverImage.bottom)
                        start.linkTo(coverImage.start)
                        end.linkTo(coverImage.end)
                    }
            )
            Box(
                modifier = Modifier
                    .constrainAs(baseBackground) {
                        top.linkTo(tournamentBanner.bottom)
                        start.linkTo(coverImage.start)
                        end.linkTo(coverImage.end)
                    }
                    .width(cardWidthDp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(bottomEnd = 15.dp))
                    .background(DARK_RED)
            )
            Box(
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
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = cardData["avatarUrl"],
                        imageLoader = gifLoader,
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = "Avatar Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            if (cardData["isTitle"] == "true") {
                Text(
                    text = cardData["title"] ?: "",
                    color = Color(
                        android.graphics.Color.parseColor(
                            cardData["profileColour"] ?: "#FFFFFF"
                        )
                    ),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .constrainAs(title) {
                            top.linkTo(parent.top, margin = 12.dp)
                            start.linkTo(coverImage.start, margin = 12.dp)
                        }
                        .clip(RoundedCornerShape(6.dp))
                        .background(BG_HALF_TRANS_BLACK)
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
                    .height(30.dp)
                    .width(cardWidthDp - 12.dp)
            ) {
                items(groupListData.size) { index ->
                    GroupListItem(
                        osuGroup = groupListData[index],
                    )
                }
            }
            val formerUsernameShowPopup = remember { MutableTransitionState(false) }
            Text(
                text = cardData["username"] ?: "",
                color = DARK_RED_TEXT_LIGHT,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
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
                    append(stringResource(id = if (cardData["isOnline"] == "true") R.string.online else R.string.offline))
                },
                inlineContent = inlineContent,
                modifier = Modifier
                    .constrainAs(online) {
                        start.linkTo(nameplateName.start)
                        top.linkTo(nameplateName.bottom)
                        bottom.linkTo(baseBackground.bottom)
                    }
                    .padding(start = 5.dp),
                color = DARK_RED_TEXT_LIGHT,
                fontSize = 18.sp
            )
            val supporterShowPopup = remember { MutableTransitionState(false) }
            if (cardData["isSupporter"] == "true") {
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
                        painter = painterResource(
                            id = when (cardData["supporterRank"]) {
                                "1" -> R.drawable.ic_support_1
                                "2" -> R.drawable.ic_support_2
                                "3" -> R.drawable.ic_support_3
                                else -> R.drawable.ic_support_1
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
                text = cardData["rank"] ?: "",
                color = DARK_RED_TEXT_LIGHT,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
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
                        append(cardData["country"] ?: "")
                    },
                    inlineContent = inlineContent,
                    color = DARK_RED_TEXT,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                )
                Text(
                    text = cardData["countryRank"] ?: "",
                    color = DARK_RED_TEXT_LIGHT,
                    fontSize = 16.sp,
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
            if (cardData["isSupporter"] == "true") {
                PopupTip(
                    "Supporter Rank  ${cardData["supporterRank"]}",
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
            if ((cardData["formerUsernames"] ?: "").isNotEmpty()) {
                PopupTip(
                    "formerly known as:\n${cardData["formerUsernames"]}",
                    DARK_RED_TEXT_LIGHT,
                    Modifier.constrainAs(formerUsernamePopup) {
                        top.linkTo(nameplateName.bottom, margin = 4.dp)
                        start.linkTo(nameplateName.start)
                    },
                    formerUsernameShowPopup,
                    Alignment.TopStart
                )
            }
            if (cardData["currentMode"] == "mania") {
                PopupTip(
                    cardData["maniaModeGlobalRank"] ?: "",
                    DARK_RED_TEXT_LIGHT,
                    Modifier.constrainAs(modeGlobalRankPopup) {
                        top.linkTo(rank.bottom, margin = 4.dp)
                        start.linkTo(rank.start)
                        end.linkTo(rank.end)
                    },
                    modeGlobalRankShowPopup,
                    Alignment.TopCenter
                )
                PopupTip(
                    cardData["maniaModeCountryRank"] ?: "",
                    DARK_RED_TEXT_LIGHT,
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
        Button(onClick = {
            // Capture content
            scope.launch {
                val bitmapAsync = captureController.captureAsync()
                try {
                    val bitmap = bitmapAsync.await().asAndroidBitmap()
                    val file = File(context.cacheDir, "osu_card.png")
                    saveBitmapToFile(bitmap, file)
                    saveImageToGallery(context, file, "osu_card")
                } catch (error: Throwable) {
                    error.printStackTrace()
                }
            }
        }) {
            Text("Capture Card")
        }
    }
}