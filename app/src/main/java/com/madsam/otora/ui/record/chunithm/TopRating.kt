package com.madsam.otora.ui.record.chunithm

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.ui.theme.Beige400
import com.madsam.otora.ui.theme.CHUNI_DIFF_ADVANCED
import com.madsam.otora.ui.theme.CHUNI_DIFF_BASIC
import com.madsam.otora.ui.theme.CHUNI_DIFF_EXPERT
import com.madsam.otora.ui.theme.CHUNI_DIFF_MASTER
import com.madsam.otora.ui.theme.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.ui.theme.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.ui.theme.OSU_BRIGHT_YELLOW
import com.madsam.otora.ui.theme.Red300
import com.madsam.otora.ui.theme.Red700
import com.madsam.otora.model.chuni.ui.ChuniScoreUI
import com.madsam.otora.model.chuni.ui.ChuniTopRankUI
import com.madsam.otora.ui.theme.Transparent
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.chunithm.TopRating
 * 创建者: MadSamurai
 * 创建时间: 2024/11/20
 * 描述: Chunithm顶级成绩
 */
@Composable
fun TopRating(
    chuniTopRankUI: MutableStateFlow<ChuniTopRankUI>,
    onBack: () -> Unit
) {
    val topRank by chuniTopRankUI.collectAsState()
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp

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
                fontWeight = FontWeight.Bold
            )
            Box(modifier = Modifier.width(48.dp))
        }

        LazyColumn(
            modifier = Modifier.padding(8.dp)
        ) {
            items(topRank.bestList.size) { index ->
                ChuniRatingItemCard(
                    item = topRank.bestList[index],
                    itemWidth = screenWidthDp
                )
            }
        }
    }
}

@Composable
fun ChuniRatingItemCard(
    item: ChuniScoreUI,
    itemWidth: Dp
) {
    val url = "https://dp4p6x0xfi5o9.cloudfront.net/chunithm"
    Surface(
        Modifier
            .width(itemWidth)
            .padding(8.dp),
        RoundedCornerShape(6.dp),
        Color.Transparent
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Red700)
        ) {
            val (
                cover,
                background,
                diff,
                rank
            ) = createRefs()
            Image(
                painter = rememberAsyncImagePainter(
                    model = "$url/img/cover/${item.jacket}",
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
                        model = "$url/img/cover/${item.jacket}",
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = "Cover",
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = item.level,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
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
                    .constrainAs(rank) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(
                    text = item.title,
                    color = Beige400,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 144.dp)
                )
                Text(
                    text = item.artist,
                    color = Beige400,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 144.dp)
                )
                Text(
                    text = item.score,
                    color = OSU_BRIGHT_YELLOW,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 144.dp)
                )
                Text(
                    text = "${item.levelValue} -> ${item.rating}",
                    color = Beige400,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 144.dp)
                )
            }
        }
    }
}