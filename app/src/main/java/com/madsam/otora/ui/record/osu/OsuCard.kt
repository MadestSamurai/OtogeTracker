package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import com.madsam.otora.R
import com.madsam.otora.component.GroupListItem
import com.madsam.otora.component.PopupTip
import com.madsam.otora.consts.Colors
import com.madsam.otora.entity.web.OsuGroup
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Composable
fun OsuCard(
    osuCardData: MutableStateFlow<Map<String, String>>,
    osuGroupList: MutableStateFlow<List<OsuGroup>>,
    osuBadgeList: MutableStateFlow<List<Map<String, String>>>
) {
    val cardData = osuCardData.collectAsState(initial = emptyMap()).value
    val groupListData = osuGroupList.collectAsState(initial = emptyList()).value
    val badgeListData = osuBadgeList.collectAsState(initial = emptyList()).value
    val configuration = LocalConfiguration.current
    val coroutineScope = rememberCoroutineScope()
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp

    ConstraintLayout {
        val refs = createRefs()
        val (
            coverImage,
            background,
            baseBackground,
            avatarImage,
            nameplateName,
            supporterRank,
            title,
            groupList,
            rank,
            countryFlag,
            country,
            countryRank,
            online,
            onlineMark,
            badgeList,
        ) = refs

        val imageLoader = ImageLoader.Builder(LocalContext.current)
            .components {
                add(SvgDecoder.Factory())
                add(GifDecoder.Factory())
            }
            .build()
        val cardWidthDp = screenWidthDp - 32.dp
        Box(
            modifier = Modifier
                .width(cardWidthDp)
                .constrainAs(coverImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = 16.dp)
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
                    imageLoader = imageLoader
                ),
                contentDescription = "Cover Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .padding(bottom = 12.dp)
                .constrainAs(background) {
                    top.linkTo(coverImage.bottom)
                    start.linkTo(coverImage.start)
                    end.linkTo(coverImage.end)
                }
                .width(cardWidthDp)
                .height(130.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .background(Colors.DARK_RED_DEEP)
        )
        Box(
            modifier = Modifier
                .constrainAs(baseBackground) {
                    top.linkTo(coverImage.bottom)
                    start.linkTo(coverImage.start)
                    end.linkTo(coverImage.end)
                }
                .width(cardWidthDp)
                .height(80.dp)
                .clip(RoundedCornerShape(bottomEnd = 15.dp))
                .background(Colors.DARK_RED)
        )
        Box(
            modifier = Modifier
                .constrainAs(avatarImage) {
                    top.linkTo(coverImage.bottom)
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
                    imageLoader = imageLoader
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
                    .background(Colors.BG_HALF_TRANS_BLACK)
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
        var formerUsernameShowPopup by remember { mutableStateOf(false) }
        Text(
            text = cardData["username"] ?: "",
            color = Colors.DARK_RED_TEXT_LIGHT,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(nameplateName) {
                    top.linkTo(avatarImage.top, margin = 8.dp)
                    start.linkTo(avatarImage.end, margin = 12.dp)
                }
                .clickable(
                    onClick = { formerUsernameShowPopup = true }
                )
        )
        Image(
            painter = painterResource(
                id =
                if (cardData["isOnline"] == "true") R.drawable.ic_osu_online else R.drawable.ic_osu_offline
            ),
            contentDescription = "Online Mark",
            modifier = Modifier
                .constrainAs(onlineMark) {
                    top.linkTo(nameplateName.bottom)
                    bottom.linkTo(baseBackground.bottom)
                    start.linkTo(nameplateName.start)
                }
                .size(20.dp)
        )
        Text(
            text = if (cardData["isOnline"] == "true") "Online" else "Offline",
            modifier = Modifier
                .constrainAs(online) {
                    top.linkTo(onlineMark.top)
                    bottom.linkTo(onlineMark.bottom)
                    start.linkTo(onlineMark.end, margin = 5.dp)
                }
                .padding(start = 5.dp),
            color = Colors.DARK_RED_TEXT_LIGHT,
            fontSize = 18.sp
        )

        var supporterShowPopup by remember { mutableStateOf(false) }
        if (cardData["isSupporter"] == "true") {
            Box(
                modifier = Modifier
                    .constrainAs(supporterRank) {
                        top.linkTo(nameplateName.top)
                        bottom.linkTo(nameplateName.bottom)
                        start.linkTo(nameplateName.end, margin = 12.dp)
                    }
                    .clickable(
                        onClick = { supporterShowPopup = true }
                    )
                    .height(20.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Colors.OSU_BRIGHT_RED)
            ) {
                Image(
                    painter = painterResource(
                        id = when (cardData["supporterRank"]) {
                            "1" -> R.drawable.supporter_rank1
                            "2" -> R.drawable.supporter_rank2
                            "3" -> R.drawable.supporter_rank3
                            else -> R.drawable.supporter_rank1
                        }
                    ),
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
        var modeGlobalRankShowPopup by remember { mutableStateOf(false) }
        Text(
            text = cardData["rank"] ?: "",
            color = Colors.DARK_RED_TEXT_LIGHT,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(rank) {
                    top.linkTo(baseBackground.bottom)
                    bottom.linkTo(avatarImage.bottom)
                    start.linkTo(avatarImage.end, margin = 12.dp)
                }
                .clickable(
                    onClick = { modeGlobalRankShowPopup = true }
                )
        )
        var modeCountryRankShowPopup by remember { mutableStateOf(false) }
        Image(
            painter = rememberAsyncImagePainter(
                model = cardData["flagUrl"],
                imageLoader = imageLoader
            ),
            contentDescription = "Country Flag",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .constrainAs(countryFlag) {
                    top.linkTo(baseBackground.bottom, margin = 6.dp)
                    start.linkTo(rank.end, margin = 15.dp)
                }
                .clickable(
                    onClick = { modeCountryRankShowPopup = true }
                )
                .size(20.dp)
        )
        Text(
            text = cardData["country"] ?: "",
            color = Colors.DARK_RED_TEXT,
            fontSize = 14.sp,
            modifier = Modifier
                .constrainAs(country) {
                    top.linkTo(countryFlag.top)
                    bottom.linkTo(countryFlag.bottom)
                    start.linkTo(countryFlag.end, margin = 5.dp)
                }
                .clickable(
                    onClick = { modeCountryRankShowPopup = true }
                )
        )
        Text(
            text = cardData["countryRank"] ?: "",
            color = Colors.DARK_RED_TEXT_LIGHT,
            fontSize = 16.sp,
            modifier = Modifier
                .constrainAs(countryRank) {
                    top.linkTo(countryFlag.bottom)
                    start.linkTo(rank.end, margin = 15.dp)
                }
                .clickable(
                    onClick = { modeCountryRankShowPopup = true }
                )
        )
        if (badgeListData.isEmpty()) {
            return@ConstraintLayout
        }
        Surface(
            Modifier
                .padding(
                    bottom = 12.dp
                )
                .width(cardWidthDp)
                .constrainAs(badgeList) {
                    top.linkTo(background.bottom)
                    start.linkTo(coverImage.start)
                    end.linkTo(coverImage.end)
                },
            RoundedCornerShape(20.dp),
            Colors.DARK_RED_DEEP
        ) {
            var listWidthDp = cardWidthDp - 16.dp - 40.dp
            val imageCount = (listWidthDp / (68.dp + 12.dp)).toInt()
            var imagePadding = (listWidthDp / imageCount) - 68.dp
            val listState = rememberLazyListState()
            if (badgeListData.size <= imageCount) {
                listWidthDp = cardWidthDp - 16.dp
                imagePadding = (listWidthDp / badgeListData.size) - 68.dp
            }
            Row {
                if (badgeListData.size > imageCount) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_chevron_left),
                        contentDescription = "Previous",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .width(20.dp)
                            .height(30.dp)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                coroutineScope.launch {
                                    val currentIndex = listState.firstVisibleItemIndex
                                    if (currentIndex > 0) {
                                        listState.animateScrollToItem(currentIndex - 1)
                                    }
                                }
                            }
                    )
                }
                println("listWidthDp: $listWidthDp imagePadding: $imagePadding")
                LazyRow(
                    state = listState,
                    modifier = Modifier
                        .padding(
                            vertical = 8.dp,
                            horizontal = if (badgeListData.size > imageCount) 0.dp else 8.dp
                        )
                        .width(listWidthDp)
                ) {
                    items(badgeListData) { badge ->
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = badge["image2xUrl"],
                            ),
                            contentScale = ContentScale.FillHeight,
                            contentDescription = badge["description"],
                            modifier = Modifier
                                .padding(vertical = 4.dp, horizontal = imagePadding / 2)
                                .clip(RoundedCornerShape(6.dp))
                                .height(32.dp)
                                .width(68.dp)
                        )
                    }
                }
                if (badgeListData.size > imageCount) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_chevron_right),
                        contentDescription = "Next",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .width(20.dp)
                            .height(30.dp)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                coroutineScope.launch {
                                    val currentIndex = listState.firstVisibleItemIndex
                                    if (currentIndex < badgeListData.size - 1) {
                                        listState.animateScrollToItem(currentIndex + 1)
                                    }
                                }
                            }
                    )
                }
            }
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
                text = "Supporter Rank  ${cardData["supporterRank"]}",
                color = Colors.OSU_BRIGHT_RED,
                modifier = Modifier.constrainAs(supporterPopup) {
                    top.linkTo(supporterRank.bottom, margin = 4.dp)
                    start.linkTo(supporterRank.start)
                    end.linkTo(supporterRank.end)
                },
                showPopup = supporterShowPopup
            )
            LaunchedEffect(supporterShowPopup) {
                delay(1500)
                supporterShowPopup = false
            }
        }
        if ((cardData["formerUsernames"] ?: "").isNotEmpty()) {
            PopupTip(
                text = "formerly known as:\n${cardData["formerUsernames"]}",
                color = Colors.DARK_RED_TEXT_LIGHT,
                modifier = Modifier.constrainAs(formerUsernamePopup) {
                    top.linkTo(nameplateName.bottom, margin = 4.dp)
                    start.linkTo(nameplateName.start)
                },
                showPopup = formerUsernameShowPopup
            )
            LaunchedEffect(formerUsernameShowPopup) {
                delay(1500)
                formerUsernameShowPopup = false
            }
        }
        if (cardData["currentMode"] == "mania") {
            PopupTip(
                text = cardData["maniaModeGlobalRank"] ?: "",
                color = Colors.DARK_RED_TEXT_LIGHT,
                modifier = Modifier.constrainAs(modeGlobalRankPopup) {
                    top.linkTo(rank.bottom, margin = 4.dp)
                    start.linkTo(rank.start)
                    end.linkTo(rank.end)
                },
                showPopup = modeGlobalRankShowPopup
            )
            LaunchedEffect(modeGlobalRankShowPopup) {
                delay(1500)
                modeGlobalRankShowPopup = false
            }
            PopupTip(
                text = cardData["maniaModeCountryRank"] ?: "",
                color = Colors.DARK_RED_TEXT_LIGHT,
                modifier = Modifier.constrainAs(modeCountryRankPopup) {
                    top.linkTo(countryRank.bottom, margin = 4.dp)
                    start.linkTo(countryRank.start)
                    end.linkTo(countryRank.end)
                },
                showPopup = modeCountryRankShowPopup
            )
            LaunchedEffect(modeCountryRankShowPopup) {
                delay(1500)
                modeCountryRankShowPopup = false
            }
        }
    }
}