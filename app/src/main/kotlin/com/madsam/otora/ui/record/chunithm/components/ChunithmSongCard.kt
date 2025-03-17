package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.OSU_BRIGHT_YELLOW
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.Red900
import com.madsam.otora.data.chunithm.ui.model.ChunithmSongUiModel
import com.madsam.otora.ui.BASE_URL

@Composable
internal fun ChunithmSongCard(
    item: ChunithmSongUiModel,
    itemWidth: Dp
) {
    Surface(
        Modifier.width(itemWidth),
        RoundedCornerShape(6.dp),
        Transparent
    ) {
        Column {
            ConstraintLayout(
                modifier = Modifier
                    .background(Red700)
            ) {
                val (
                    cover,
                    background,
                    info,
                ) = createRefs()
                Image(
                    painter = rememberAsyncImagePainter(
                        model = "$BASE_URL/chuni/img/${item.imageName}",
                        contentScale = ContentScale.Crop
                    ),
                    contentDescription = "Cover",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .constrainAs(background) {
                            top.linkTo(parent.top)
                            start.linkTo(cover.start, 70.dp)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(parent.end)
                        }
                        .background(Transparent)
                        .width(itemWidth - 70.dp)
                        .height(80.dp)
                        .alpha(0.15f)
                )
                Surface(
                    Modifier
                        .constrainAs(cover) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            bottom.linkTo(parent.bottom)
                        }
                        .width(80.dp)
                        .height(80.dp),
                    RoundedCornerShape(6.dp),
                    Transparent
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = "$BASE_URL/chuni/img/${item.imageName}",
                            contentScale = ContentScale.Crop
                        ),
                        contentDescription = "Cover",
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier
                        .constrainAs(info) {
                            top.linkTo(parent.top)
                            start.linkTo(cover.end, 8.dp)
                        }
                ) {
                    Text(
                        text = item.title,
                        color = Beige400,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        lineHeight = 23.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .width(itemWidth - 88.dp)
                            .padding(top = 4.dp)
                            .requiredHeight(23.dp)
                            .clip(RectangleShape)
                    )
                    Text(
                        text = item.artist,
                        color = OSU_BRIGHT_YELLOW,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier
                            .width(itemWidth - 88.dp)
                    )
                    Row {
                        Text(
                            text = item.version,
                            color = Beige400,
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(end = 8.dp, top = 3.dp)
                                .requiredHeight(23.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(Red900)
                                .padding(vertical = 2.dp, horizontal = 6.dp)
                        )
                        Text(
                            text = item.genre,
                            color = Beige400,
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(top = 3.dp)
                                .requiredHeight(23.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(Red900)
                                .padding(vertical = 2.dp, horizontal = 6.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .background(Red700)
                    .width(itemWidth)
            ) {
                Text(
                    text = "Test",
                    color = Beige400,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    lineHeight = 23.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 88.dp)
                        .padding(top = 4.dp)
                        .requiredHeight(23.dp)
                        .clip(RectangleShape)
                )
            }
        }
    }
}