package com.madsam.otora.ui.record.chunithm.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.Beige400
import com.madsam.otora.core.theme.Yellow1000
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.Red900
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.data.chunithm.ui.model.ChunithmSongUiModel
import com.madsam.otora.ui.BASE_URL
import com.madsam.otora.ui.record.chunithm.ChunithmViewModel

@Composable
internal fun ChunithmSongCard(
    item: ChunithmSongUiModel,
    itemWidth: Dp,
    highlightText: String = "",
    viewModel: ChunithmViewModel? = null,
    onClick: ((ChunithmSongUiModel) -> Unit)? = null
) {
    Surface(
        modifier = Modifier
            .width(itemWidth)
            .clickable { 
                Log.d("ChunithmSongCard", "Card clicked: ${item.title}")
                onClick?.invoke(item)
            },
        shape = RoundedCornerShape(6.dp),
        color = Transparent
    ) {
        Column {
            ConstraintLayout(
                modifier = Modifier
                    .background(Red700)
                    .height(80.dp)
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
                    // 使用高亮文本组件替换原来的Text
                    HighlightedText(
                        fullText = item.title,
                        highlightText = highlightText,
                        color = Beige400,
                        fontSize = 16.sp,
                        fontFamily = sarasaBold,
                        maxLines = 1,
                        lineHeight = 23.sp,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .width(itemWidth - 88.dp)
                            .padding(top = 4.dp)
                            .requiredHeight(23.dp)
                            .clip(RectangleShape)
                    )

                    // 艺术家名称也高亮显示
                    HighlightedText(
                        fullText = item.artist,
                        highlightText = highlightText,
                        color = Yellow1000,
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
                            fontFamily = sarasaBold,
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
                            fontFamily = sarasaBold,
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
                val scoresMap = remember { mutableStateOf<Map<String, SheetScoreInfo>>(emptyMap()) }
                
                LaunchedEffect(item.title) {
                    if (viewModel != null) {
                        // Directly get all scores for the song in SheetScoreInfo format
                        val songScoresMap = viewModel.getSheetScoreInfoMapForSong(item.title)
                        scoresMap.value = songScoresMap
                    } else {
                        Log.w("ChunithmSongCard", "ViewModel is null, cannot load scores")
                    }
                }
                
                ChunithmSheetList(
                    sheets = item.sheets,
                    scoresMap = scoresMap.value
                )
            }
        }
    }
}

@Composable
private fun HighlightedText(
    modifier: Modifier = Modifier,
    fullText: String,
    highlightText: String,
    color: Color,
    fontSize: TextUnit,
    fontFamily: FontFamily = sarasaRegular,
    maxLines: Int = Int.MAX_VALUE,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip
) {
    val annotatedString = buildAnnotatedString {
        if (highlightText.isNotEmpty()) {
            var startIndex = fullText.indexOf(highlightText, ignoreCase = true)
            var currentIndex = 0

            if (startIndex < 0) {
                // 如果没有匹配，直接添加整个文本
                withStyle(style = SpanStyle(color = color)) {
                    append(fullText)
                }
            } else {
                // 处理匹配内容
                while (startIndex >= 0) {
                    // 添加匹配前的文本
                    withStyle(style = SpanStyle(color = color)) {
                        append(fullText.substring(currentIndex, startIndex))
                    }

                    // 添加高亮文本
                    withStyle(style = SpanStyle(color = color, background = Color.Red.copy(alpha = 0.7f))) {
                        append(fullText.substring(startIndex, startIndex + highlightText.length))
                    }

                    currentIndex = startIndex + highlightText.length
                    startIndex = fullText.indexOf(
                        highlightText,
                        startIndex + highlightText.length,
                        ignoreCase = true
                    )
                }

                // 添加最后剩余的文本
                withStyle(style = SpanStyle(color = color)) {
                    append(fullText.substring(currentIndex))
                }
            }
        } else {
            withStyle(style = SpanStyle(color = color)) {
                append(fullText)
            }
        }
    }

    Text(
        text = annotatedString,
        fontSize = fontSize,
        fontFamily = fontFamily,
        maxLines = maxLines,
        lineHeight = lineHeight,
        overflow = overflow,
        modifier = modifier
    )
}