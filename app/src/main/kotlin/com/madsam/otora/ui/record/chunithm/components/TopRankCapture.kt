package com.madsam.otora.ui.record.chunithm.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.madsam.otora.core.theme.Beige400
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
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.Yellow1000
import com.madsam.otora.core.theme.interTight
import com.madsam.otora.core.utils.ImageUtils.saveBitmapToGallery
import com.madsam.otora.data.chunithm.ui.model.ChunithmScoreUiModel
import com.madsam.otora.data.chunithm.ui.model.ChunithmTopRankUiModel
import com.madsam.otora.ui.BASE_URL
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun TopRankCaptureDialog(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    chunithmTopRankUiModel: MutableStateFlow<ChunithmTopRankUiModel>
) {
    val scope = rememberCoroutineScope()
    
    if (showDialog.value) {
        val captureController = rememberCaptureController()
        
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "截图功能") },
            modifier = Modifier.height(300.dp),
            text = {
                Column {
                    Text(
                        text = "将保存当前Top Rating内容到相册",
                        modifier = Modifier.padding(8.dp)
                    )
                    
                    // 移动截图内容到对话框外部，使用 requiredWidth 确保尺寸
                    Box(
                        modifier = Modifier
                            .requiredWidth(1000.dp)
                            .requiredHeight(5000.dp)
                    ) {
                        Column(
                            modifier = Modifier.capturable(captureController)
                        ) {
                            TopRankCaptureContent(
                                chunithmTopRankUiModel = chunithmTopRankUiModel
                            )
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        scope.launch {
                            val bitmap = captureController.captureAsync().await().asAndroidBitmap()
                            val current = LocalDateTime.now()
                            val formatter = DateTimeFormatter.ofPattern("MMddHHmm")
                            val timeStr = current.format(formatter)
                            
                            saveBitmapToGallery(
                                context = context,
                                bitmap = bitmap,
                                title = "TopRank_$timeStr",
                                description = "Chunithm Top Rating Capture"
                            )
                            snackbarHostState.showSnackbar("图片已保存到相册")
                        }
                        showDialog.value = false
                    }
                ) {
                    Text(text = "截图")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text(text = "取消")
                }
            }
        )
    }
}

@Composable
internal fun TopRankCaptureContent(
    chunithmTopRankUiModel: MutableStateFlow<ChunithmTopRankUiModel>
) {
    val topRank by chunithmTopRankUiModel.collectAsState()
    val cardWidth = 180.dp
    val cardHeight = 54.dp
    
    Column(
        modifier = Modifier
            .width(1000.dp)
            .background(Red300)
            .padding(16.dp)
    ) {
        // 标题
        Text(
            text = "Chunithm Top Rating",
            fontFamily = interTight,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = White1000,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        
        // Best 30 - 6行，每行5个
        if (topRank.bestList.isNotEmpty()) {
            Text(
                text = "Best 30 (平均: ${String.format(Locale.US, "%.2f", topRank.best30)})",
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = White1000,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            for (row in 0 until 6) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (col in 0 until 5) {
                        val index = row * 5 + col
                        if (index < topRank.bestList.size) {
                            CaptureItemCard(
                                item = topRank.bestList[index],
                                rank = index + 1,
                                cardWidth = cardWidth,
                                cardHeight = cardHeight
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .width(cardWidth)
                                    .height(cardHeight)
                            )
                        }
                    }
                }
            }
        }
        
        // Recent 10 - 2行，每行5个
        if (topRank.recentList.isNotEmpty()) {
            Text(
                text = "Recent 10 (平均: ${String.format(Locale.US, "%.2f", topRank.recent10)})",
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = White1000,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            
            for (row in 0 until 2) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (col in 0 until 5) {
                        val index = row * 5 + col
                        if (index < topRank.recentList.size) {
                            CaptureItemCard(
                                item = topRank.recentList[index],
                                rank = index + 1,
                                cardWidth = cardWidth,
                                cardHeight = cardHeight
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .width(cardWidth)
                                    .height(cardHeight)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
internal fun CaptureItemCard(
    item: ChunithmScoreUiModel,
    rank: Int,
    cardWidth: Dp,
    cardHeight: Dp
) {
    Surface(
        modifier = Modifier
            .width(cardWidth)
            .height(cardHeight),
        shape = RoundedCornerShape(6.dp),
        color = Red700
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (
                cover,
                background,
                diff,
                rankText,
                info
            ) = createRefs()
            
            // 背景图片 - 填满整个卡片
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
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .fillMaxSize()
                    .alpha(0.3f)
            )
            
            // 封面图片 - 靠左上角
            Surface(
                modifier = Modifier
                    .constrainAs(cover) {
                        top.linkTo(parent.top, 2.dp)
                        start.linkTo(parent.start, 2.dp)
                    }
                    .size(50.dp),
                shape = RoundedCornerShape(4.dp),
                color = Color.Transparent
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
            
            // 难度标签 - 覆盖在封面左上角内部
            Text(
                text = String.format(Locale.US, "%.1f", item.levelValue),
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp,
                lineHeight = 11.sp,
                color = Color.White,
                modifier = Modifier
                    .constrainAs(diff) {
                        top.linkTo(cover.top, 2.dp)
                        start.linkTo(cover.start, 2.dp)
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
                        shape = RoundedCornerShape(2.dp)
                    )
                    .border(
                        width = if (item.diff == "ultima") 0.5.dp else 0.dp,
                        color = if (item.diff == "ultima") CHUNI_DIFF_ULTIMA_2 else Transparent,
                        shape = RoundedCornerShape(2.dp)
                    )
                    .padding(horizontal = 2.dp)
            )
            
            // 排名 - 放在左下角，减少空余
            Text(
                text = "#$rank",
                fontFamily = interTight,
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp,
                lineHeight = 10.sp,
                color = Beige400,
                modifier = Modifier
                    .constrainAs(rankText) {
                        bottom.linkTo(cover.bottom, 2.dp)
                        start.linkTo(cover.start, 2.dp)
                    }
                    .background(
                        color = Red500,
                        shape = RoundedCornerShape(2.dp)
                    )
                    .padding(horizontal = 2.dp, vertical = 1.dp)
            )
            
            // 信息栏 - 紧凑布局
            Column(
                modifier = Modifier
                    .constrainAs(info) {
                        top.linkTo(parent.top, 2.dp)
                        bottom.linkTo(parent.bottom, 2.dp)
                        start.linkTo(cover.end, 4.dp)
                        end.linkTo(parent.end, 2.dp)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    },
            ) {
                Text(
                    text = item.title,
                    fontFamily = interTight,
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp,
                    lineHeight = 10.sp,
                    color = Beige400,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.score,
                    fontFamily = interTight,
                    fontWeight = FontWeight.Bold,
                    fontSize = 9.sp,
                    lineHeight = 10.sp,
                    color = Yellow1000,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = String.format(Locale.US, "%.2f", item.rating),
                    fontFamily = interTight,
                    fontWeight = FontWeight.Bold,
                    fontSize = 8.sp,
                    lineHeight = 9.sp,
                    color = Beige400,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
