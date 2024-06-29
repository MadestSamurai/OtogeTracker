package com.madsam.otora.ui.record.osu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import com.madsam.otora.R
import com.madsam.otora.component.BoxWithTip
import com.madsam.otora.component.GroupListItem
import com.madsam.otora.consts.Colors
import com.madsam.otora.entity.web.OsuGroup
import com.madsam.otora.component.PopupTip
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun OsuCard(
    osuCardData: MutableStateFlow<Map<String, String>>,
    osuGroupList: MutableStateFlow<List<OsuGroup>>
) {
    val cardData = osuCardData.collectAsState(initial = emptyMap()).value
    val groupListData = osuGroupList.collectAsState(initial = emptyList()).value

    Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color.Transparent,
        modifier = Modifier
            .padding(16.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Colors.DARK_RED_DEEP)
        ) {
            val (
                coverImage,
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
                onlineMark
            ) = createRefs()
            val imageLoader = ImageLoader.Builder(LocalContext.current)
                .components {
                    add(SvgDecoder.Factory())
                    add(GifDecoder.Factory())
                }
                .build()

            Box(
                modifier = Modifier
                    .constrainAs(coverImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .height(120.dp)
                    .fillMaxWidth()
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
                    .constrainAs(baseBackground) {
                        top.linkTo(coverImage.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(bottomEnd = 15.dp))
                    .background(Colors.DARK_RED)
            )

            Box(
                modifier = Modifier
                    .constrainAs(avatarImage) {
                        top.linkTo(coverImage.bottom)
                        start.linkTo(parent.start)
                    }
                    .size(130.dp)
                    .clip(RoundedCornerShape(bottomEnd = 15.dp))
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
                            start.linkTo(parent.start, margin = 12.dp)
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
                modifier = Modifier
                    .constrainAs(groupList) {
                        bottom.linkTo(coverImage.bottom, margin = 8.dp)
                        end.linkTo(coverImage.end, margin = 12.dp)
                    }
                    .height(30.dp)
            ) {
                items(groupListData.size) { index ->
                    var showPopup by remember { mutableStateOf(false) }
                    var offset by remember { mutableStateOf(IntOffset(0,0)) }

                    println(groupListData[index])
                    GroupListItem(
                        osuGroup = groupListData[index],
                        onClick = { size ->
                            showPopup = true
                            offset = size
                        }
                    )

                    PopupTip(
                        showPopup = showPopup,
                        offset = offset,
                        onDismissRequest = { showPopup = false },
                        text = groupListData[index].name,
                        color = Color(android.graphics.Color.parseColor(groupListData[index].colour))
                    )
                }
            }

            Text(
                text = cardData["username"] ?: "",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(nameplateName) {
                    top.linkTo(avatarImage.top, margin = 8.dp)
                    start.linkTo(avatarImage.end, margin = 12.dp)
                }
            )

            Image(
                painter = painterResource(id =
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

            if (cardData["isSupporter"] == "true") {
                var showPopup by remember { mutableStateOf(false) }
                var offset by remember { mutableStateOf(IntOffset(0,0)) }

                BoxWithTip(
                    onClick = { position ->
                        showPopup = true
                        offset = IntOffset(
                            x = position.x,
                            y = position.y
                        )
                    },
                    modifier = Modifier
                        .constrainAs(supporterRank) {
                            top.linkTo(nameplateName.top, margin = 8.dp)
                            bottom.linkTo(nameplateName.bottom, margin = 8.dp)
                            start.linkTo(nameplateName.end, margin = 12.dp)
                        }
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
                        }),
                        contentDescription = "Supporter Rank",
                        modifier = Modifier.height(20.dp)
                            .padding(
                                horizontal = 12.dp,
                                vertical = 4.dp
                            ),
                    )
                }

                PopupTip(
                    showPopup = showPopup,
                    offset = offset,
                    onDismissRequest = { showPopup = false },
                    text = "Supporter Rank " + cardData["supporterRank"],
                    color = Colors.OSU_BRIGHT_RED
                )
            }

            Text(
                text = cardData["rank"] ?: "",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(rank) {
                    top.linkTo(baseBackground.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(avatarImage.end, margin = 12.dp)
                }

            )

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
                    .size(20.dp)
            )

            Text(
                text = cardData["country"] ?: "",
                color = Colors.DARK_RED_TEXT,
                fontSize = 14.sp,
                modifier = Modifier.constrainAs(country) {
                    top.linkTo(countryFlag.top)
                    bottom.linkTo(countryFlag.bottom)
                    start.linkTo(countryFlag.end, margin = 5.dp)
                }
            )

            Text(
                text = cardData["countryRank"] ?: "",
                color = Colors.DARK_RED_TEXT_LIGHT,
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(countryRank) {
                    top.linkTo(countryFlag.bottom)
                    start.linkTo(rank.end, margin = 15.dp)
                }
            )
        }
    }
}