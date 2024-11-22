package com.madsam.otora.ui.record.chunithm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.consts.Colors
import com.madsam.otora.entity.chunithm.ChuniSheetsEntity
import com.madsam.otora.entity.chunithm.ChuniSongsEntity
import com.madsam.otora.model.chuni.net.ChuniScore
import com.madsam.otora.model.chuni.ui.ChuniScoreShow
import com.madsam.otora.service.ChuniDataRequestService
import com.madsam.otora.utils.CalcUtils
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.JsonUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.chunithm.TopRating
 * 创建者: MadSamurai
 * 创建时间: 2024/11/20
 * 描述: TODO
 */
@Composable
fun TopRating() {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    val chuniDataRequestService = ChuniDataRequestService(context)

    val chuniRatingBest = remember { mutableStateOf(listOf<ChuniScore>()) }
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    val ratingBestListType = Types.newParameterizedType(List::class.java, ChuniScore::class.java)
    val ratingBestJsonAdapter = moshi.adapter<List<ChuniScore>>(ratingBestListType)
    val ratingBestJson = JsonUtil.readJsonFromFile(context, "chuniRatingDetailBest.json")
    if (ratingBestJson != null) {
        chuniRatingBest.value = ratingBestJsonAdapter.fromJson(ratingBestJson) ?: listOf()
    }
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        chuniRatingBest.value.forEach { score ->
            val songData = remember { mutableStateOf(ChuniSongsEntity()) }
            val songSheetData = remember { mutableStateOf(ChuniSheetsEntity()) }
            val topRating = remember { mutableStateOf(ChuniScoreShow()) }
            LaunchedEffect(score.title) {
                songData.value = chuniDataRequestService.getChuniSongData(score.title)
                val diff = when (score.diff) {
                    "0" -> "basic"
                    "1" -> "advanced"
                    "2" -> "expert"
                    "3" -> "master"
                    "4" -> "ultima"
                    else -> "master"
                }
                songSheetData.value =
                    chuniDataRequestService.getChuniSongSheetData(score.title, diff)
                topRating.value = ChuniScoreShow(
                    title = songData.value.title,
                    artist = songData.value.artist,
                    noteDesigner = songSheetData.value.noteDesigner,
                    genre = songData.value.category,
                    diff = diff,
                    level = songSheetData.value.level,
                    levelValue = songSheetData.value.internalLevelValue,
                    score = score.highScore,
                    rank = CalcUtils.calcChuniRank(CommonUtils.bigNumberToInt(score.highScore)),
                    jacket = songData.value.imageName,
                    tap = songSheetData.value.tap,
                    hold = songSheetData.value.hold,
                    slide = songSheetData.value.slide,
                    air = songSheetData.value.air,
                    flick = songSheetData.value.flick,
                    total = songSheetData.value.total
                )
            }
            ChuniRatingItemCard(
                item = topRating.value,
                itemWidth = screenWidthDp
            )
        }
    }
}

@Composable
fun ChuniRatingItemCard(
    item: ChuniScoreShow,
    itemWidth: Dp
) {
    Surface(
        Modifier
            .width(itemWidth)
            .padding(8.dp),
        RoundedCornerShape(6.dp),
        Color.Transparent
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(Colors.DARK_RED_DEEP)
        ) {
            val (
                cover,
                background,
                diff,
                rank
            ) = createRefs()
            Image(
                painter = rememberAsyncImagePainter(
                    model = "https://dp4p6x0xfi5o9.cloudfront.net/chunithm/img/cover/${item.jacket}",
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
                        model = "https://dp4p6x0xfi5o9.cloudfront.net/chunithm/img/cover/${item.jacket}",
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
                            "basic" -> Color.Green
                            "advanced" -> Color.Yellow
                            "expert" -> Color.Red
                            "master" -> Color.Magenta
                            "ultima" -> Color.Black
                            else -> Color.Magenta
                        },
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
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 144.dp)
                )
                Text(
                    text = item.artist,
                    color = Colors.DARK_RED_TEXT_LIGHT,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 144.dp)
                )
                Text(
                    text = item.score,
                    color = Colors.OSU_BRIGHT_YELLOW,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 144.dp)
                )
                println("score: ${item.score}")
                Text(
                    text = "${item.levelValue} -> ${
                        CommonUtils.formatNumber(
                            CalcUtils.calcChuniRating(
                                CommonUtils.bigNumberToInt(item.score),
                                item.levelValue
                            )
                        )}",
                    color = Colors.DARK_RED_TEXT_LIGHT,
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