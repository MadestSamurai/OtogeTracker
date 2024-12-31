package com.madsam.otora.ui.record.chunithm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import com.madsam.otora.consts.CHUNI_DIFF_ADVANCED
import com.madsam.otora.consts.CHUNI_DIFF_BASIC
import com.madsam.otora.consts.CHUNI_DIFF_EXPERT
import com.madsam.otora.consts.CHUNI_DIFF_MASTER
import com.madsam.otora.consts.CHUNI_DIFF_ULTIMA_1
import com.madsam.otora.consts.CHUNI_DIFF_ULTIMA_2
import com.madsam.otora.consts.DARK_RED_DEEP
import com.madsam.otora.consts.DARK_RED_TEXT_LIGHT
import com.madsam.otora.consts.OSU_BRIGHT_YELLOW
import com.madsam.otora.entity.ChuniSheetsEntity
import com.madsam.otora.entity.ChuniSongsEntity
import com.madsam.otora.model.chuni.net.ChuniScore
import com.madsam.otora.model.chuni.ui.ChuniScoreShow
import com.madsam.otora.service.ChuniDataRequestService
import com.madsam.otora.utils.CalcUtils
import com.madsam.otora.utils.CommonUtils
import com.madsam.otora.utils.JsonUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.ui.record.chunithm.TopRating
 * 创建者: MadSamurai
 * 创建时间: 2024/11/20
 * 描述: Chunithm顶级成绩
 */
@Composable
fun TopRating() {
    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.toFloat().dp
    val chuniDataRequestService = ChuniDataRequestService(context)

    val chuniRatingBest = MutableStateFlow(listOf<ChuniScore>())
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    val ratingBestListType = Types.newParameterizedType(List::class.java, ChuniScore::class.java)
    val ratingBestJsonAdapter = moshi.adapter<List<ChuniScore>>(ratingBestListType)
    val ratingBestJson = JsonUtil.readJsonFromFile(context, "chuniRatingDetailBest.json")
    if (ratingBestJson != null) {
        chuniRatingBest.update { ratingBestJsonAdapter.fromJson(ratingBestJson) ?: listOf() }
    }

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(chuniRatingBest.value.size) { index ->
            val songData = remember { mutableStateOf(ChuniSongsEntity()) }
            val songSheetData = remember { mutableStateOf(ChuniSheetsEntity()) }
            val topRating = remember { mutableStateOf(ChuniScoreShow()) }
            LaunchedEffect(Unit) {
                songData.value = chuniDataRequestService.getChuniSongData(chuniRatingBest.value[index].title)
                val diff = when (chuniRatingBest.value[index].diff) {
                    "0" -> "basic"
                    "1" -> "advanced"
                    "2" -> "expert"
                    "3" -> "master"
                    "4" -> "ultima"
                    else -> "master"
                }
                songSheetData.value =
                    chuniDataRequestService.getChuniSongSheetData(chuniRatingBest.value[index].title, diff)
                topRating.value = ChuniScoreShow(
                    title = songData.value.title,
                    artist = songData.value.artist,
                    noteDesigner = songSheetData.value.noteDesigner,
                    genre = songData.value.genre,
                    diff = diff,
                    level = songSheetData.value.levelCn,
                    levelValue = songSheetData.value.levelValueCn,
                    score = chuniRatingBest.value[index].highScore,
                    rank = CalcUtils.calcChuniRank(CommonUtils.bigNumberToInt(chuniRatingBest.value[index].highScore)),
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
                .background(DARK_RED_DEEP)
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
                        color = if (item.diff == "ultima") CHUNI_DIFF_ULTIMA_2 else Color.Transparent,
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
                    color = DARK_RED_TEXT_LIGHT,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(itemWidth - 144.dp)
                )
                Text(
                    text = item.artist,
                    color = DARK_RED_TEXT_LIGHT,
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
                    text = "${item.levelValue} -> ${
                        CommonUtils.formatNumber(
                            CalcUtils.calcChuniRating(
                                CommonUtils.bigNumberToInt(item.score),
                                item.levelValue
                            )
                        )}",
                    color = DARK_RED_TEXT_LIGHT,
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