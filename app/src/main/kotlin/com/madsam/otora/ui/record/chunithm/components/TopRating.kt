package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Beige500
import com.madsam.otora.core.theme.Beige600
import com.madsam.otora.core.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.core.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.core.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.core.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.core.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.core.theme.Red300
import com.madsam.otora.core.theme.Red500
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.Transparent
import com.madsam.otora.core.theme.Yellow1000
import com.madsam.otora.core.theme.interTightBold
import com.madsam.otora.data.chunithm.ui.model.ChunithmScoreUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmTopRankUiModel
import com.madsam.otora.ui.BASE_URL
import com.madsam.otora.ui.components.CustomTabRow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
internal fun TopRating(
    chunithmTopRankUiModel: MutableStateFlow<ChunithmTopRankUiModel>,
    onBack: () -> Unit
) {
    val topRank by chunithmTopRankUiModel.collectAsState()
    val screenWidthDp = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }
    
    val tabTitles = listOf("Best 30", "Recent 10", "Suggest")
    val pagerState = rememberPagerState { tabTitles.size }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(Red300)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Beige400
                )
            }
            Text(
                text = "Top Rating",
                color = Beige400,
                fontSize = 20.sp,
                fontFamily = interTightBold
            )
            Box(modifier = Modifier.width(48.dp))
        }

        // 标签页
        CustomTabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = Red500,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            color = if (pagerState.currentPage == index) Beige500 else Beige600,
                            fontSize = 16.sp,
                            fontFamily = interTightBold
                        )
                    },
                    modifier = Modifier.height(40.dp)
                )
            }
        }

        // 内容页
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            val currentList = when (page) {
                0 -> topRank.bestList
                1 -> topRank.recentList
                2 -> topRank.suggestList
                else -> emptyList()
            }
            
            LazyColumn(
                modifier = Modifier.padding(8.dp)
            ) {
                items(currentList.size) { index ->
                    ChuniRatingItemCard(
                        item = currentList[index],
                        itemWidth = screenWidthDp,
                        rank = index + 1
                    )
                }
            }
        }
    }
}

@Composable
internal fun ChuniRatingItemCard(
    item: ChunithmScoreUiModel,
    itemWidth: Dp,
    rank: Int
) {
    Surface(
        Modifier
            .width(itemWidth)
            .padding(8.dp)
            .height(100.dp),
        RoundedCornerShape(6.dp),
        Color.Transparent
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Red700)
                .height(100.dp)
        ) {
            val (
                cover,
                background,
                diff,
                rankText,
                info
            ) = createRefs()
            
            // 排名显示
            Text(
                text = "#$rank",
                color = Beige400,
                fontSize = 16.sp,
                fontFamily = interTightBold,
                modifier = Modifier
                    .constrainAs(rankText) {
                        top.linkTo(parent.top, 8.dp)
                        start.linkTo(parent.start, 8.dp)
                    }
                    .background(
                        color = Red500,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
            
            Image(
                painter = rememberAsyncImagePainter(
                    model = "$BASE_URL/chuni/img/${item.jacket}",
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Cover",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(background) {
                        top.linkTo(parent.top)
                        start.linkTo(cover.start, 80.dp)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .width(itemWidth - 80.dp)
                    .height(100.dp)
                    .alpha(0.15f)
            )
            Surface(
                Modifier
                    .constrainAs(cover) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .width(100.dp)
                    .height(100.dp),
                RoundedCornerShape(6.dp),
                Color.Transparent
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = "$BASE_URL/chuni/img/${item.jacket}",
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = "Cover",
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = item.level,
                fontSize = 14.sp,
                fontFamily = interTightBold,
                color = Color.White,
                modifier = Modifier
                    .constrainAs(diff) {
                        top.linkTo(parent.top, 4.dp)
                        start.linkTo(cover.start, 4.dp)
                    }
                    .background(
                        color = when (item.diff) {
                            "basic" -> CHUNI_DIFF_BASIC
                            "advanced" -> CHUNI_DIFF_ADVANCED
                            "expert" -> CHUNI_DIFF_EXPERT
                            "master" -> CHUNI_DIFF_MASTER
                            "ultima" -> CHUNI_DIFF_ULTIMA_1
                            else -> CHUNI_DIFF_MASTER
                        },
                        shape = RoundedCornerShape(5.dp)
                    )
                    .border(
                        width = if (item.diff == "ultima") 1.dp else 0.dp,
                        color = if (item.diff == "ultima") CHUNI_DIFF_ULTIMA_2 else Transparent,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(4.dp)
            )
            Column(
                modifier = Modifier
                    .constrainAs(info) {
                        top.linkTo(parent.top, 8.dp)
                        bottom.linkTo(parent.bottom, 8.dp)
                        start.linkTo(cover.end, 8.dp)
                        end.linkTo(parent.end, 8.dp)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    },
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = item.title,
                    color = Beige400,
                    fontSize = 16.sp,
                    fontFamily = interTightBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.artist,
                    color = Beige400,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.score,
                    color = Yellow1000,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${item.levelValue} -> ${String.format(Locale.US, "%.2f", item.rating)}",
                    color = Beige400,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}