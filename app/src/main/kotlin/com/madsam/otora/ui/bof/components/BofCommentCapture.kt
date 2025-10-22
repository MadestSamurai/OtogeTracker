package com.madsam.otora.ui.bof.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.BG_DARK_GRAY
import com.madsam.otora.core.theme.RANKING_BLUE
import com.madsam.otora.core.theme.RANKING_GREEN
import com.madsam.otora.core.theme.RANKING_RED
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.utils.ImageUtils
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.ui.common.ColumnWidthType
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

private fun formatScore(score: Number, widthType: ColumnWidthType): String {
    val doubleValue = score.toDouble()
    return when (widthType) {
        ColumnWidthType.THREE_DIGIT_INT -> 
            if (doubleValue > 0) {
                doubleValue.toInt().toString()
            } else "---"
        ColumnWidthType.TWO_DECIMAL -> 
            if (doubleValue > 0) {
                if (doubleValue == doubleValue.toInt().toDouble()) {
                    String.format(Locale.US, "%.1f", doubleValue)
                } else {
                    String.format(Locale.US,"%.2f", doubleValue)
                }
            } else "---"
        ColumnWidthType.ONE_DECIMAL ->
            if (doubleValue > 0) {
                if (doubleValue == 1000.0) {
                    doubleValue.toInt().toString()
                } else {
                    String.format(Locale.US,"%.1f", doubleValue)
                }
            } else "---"
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun BofCommentCaptureDialog(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    commentData: List<BofCommentUI>,
    title: String,
    subtitle: String
) {
    val scope = rememberCoroutineScope()
    
    if (showDialog.value) {
        // 过滤掉总分小于等于0的数据
        val filteredComments = commentData.filter { it.total.toDouble() > 0 }
        
        // 分批，每100行一组
        val batchSize = 100
        val batches = filteredComments.chunked(batchSize)
        val controllers = List(batches.size) { rememberCaptureController() }
        
        // 计算全局最大分数
        val globalMaxScore = filteredComments.maxOfOrNull { it.total.toDouble() } ?: 1.0

        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "截图功能") },
            modifier = Modifier.height(300.dp),
            text = {
                Column {
                    Text(
                        text = "将保存评论排行榜内容到相册，分批截图后自动拼接（每批100行，最大高度30000像素）",
                        modifier = Modifier.padding(8.dp)
                    )
                    
                    // 渲染所有批次（隐藏但会被渲染用于截图）
                    batches.forEachIndexed { index, batch ->
                        Box(
                            modifier = Modifier
                                .height(10.dp)
                                .requiredWidth(900.dp)
                                .requiredHeight(5000.dp)
                        ) {
                            Column(
                                modifier = Modifier.capturable(controllers[index])
                            ) {
                                BofCommentCaptureContent(
                                    commentData = batch,
                                    title = title,
                                    subtitle = subtitle,
                                    showTitle = index == 0,   // 只有第一批显示标题
                                    showHeader = index == 0,  // 只有第一批显示表头
                                    globalMaxScore = globalMaxScore  // 传递全局最大值
                                )
                            }
                        }
                    }
                    
                    if (batches.size > 1) {
                        Text(
                            text = "共${batches.size}批，截图时会自动拼接全部内容",
                            fontSize = 13.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        scope.launch {
                            // 依次截图所有批次
                            val bitmaps = mutableListOf<android.graphics.Bitmap>()
                            for ((i, _) in batches.withIndex()) {
                                val bmp = controllers[i].captureAsync().await().asAndroidBitmap()
                                // 将硬件加速的bitmap转换为软件bitmap
                                val softwareBitmap = if (bmp.config == android.graphics.Bitmap.Config.HARDWARE) {
                                    bmp.copy(android.graphics.Bitmap.Config.ARGB_8888, false)
                                } else {
                                    bmp
                                }
                                bitmaps.add(softwareBitmap)
                                // 如果创建了副本，回收原始bitmap
                                if (softwareBitmap != bmp) {
                                    bmp.recycle()
                                }
                            }
                            // 拼接所有bitmap，最大高度30000
                            val finalBitmap = ImageUtils.combineBitmaps(bitmaps, maxHeight = 30000)
                            val current = LocalDateTime.now()
                            val formatter = DateTimeFormatter.ofPattern("MMddHHmm")
                            val timeStr = current.format(formatter)
                            ImageUtils.saveBitmapToGallery(
                                context = context,
                                bitmap = finalBitmap,
                                title = "BOF_Comment_$timeStr",
                                description = "BOF Comment Ranking Capture"
                            )
                            snackbarHostState.showSnackbar("图片已保存到相册（${batches.size}批，最大高度30000像素）")
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
internal fun BofCommentCaptureContent(
    commentData: List<BofCommentUI>,
    title: String,
    subtitle: String,
    showTitle: Boolean = true,
    showHeader: Boolean = true,
    globalMaxScore: Double? = null
) {
    // 如果提供了全局最大值则使用，否则计算当前commentData的最大值
    val maxScore = globalMaxScore ?: (commentData.maxOfOrNull { it.total.toDouble() } ?: 1.0)
    
    // 测量列宽
    val density = LocalDensity.current
    var voteAvgWidth by remember { mutableStateOf(60.dp) }
    var shortAvgWidth by remember { mutableStateOf(60.dp) }
    var longAvgWidth by remember { mutableStateOf(60.dp) }
    var totalScoreWidth by remember { mutableStateOf(36.dp) }
    
    // 固定宽屏分数条宽度
    val barWidth = 280.0
    
    Box(
        modifier = Modifier
            .width(900.dp)
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // 隐藏的测量容器
            Box(modifier = Modifier
                .size(0.dp)
                .requiredWidth(500.dp)
                .requiredHeight(100.dp)
            ) {
                Text(
                    text = ColumnWidthType.TWO_DECIMAL.measureText,
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        voteAvgWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
                Text(
                    text = ColumnWidthType.TWO_DECIMAL.measureText,
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        shortAvgWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
                Text(
                    text = ColumnWidthType.TWO_DECIMAL.measureText,
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        longAvgWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
                Text(
                    text = ColumnWidthType.THREE_DIGIT_INT.measureText,
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        totalScoreWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
            }
            
            // 表格标题和副标题（可选）
            if (showTitle) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontFamily = sarasaBold,
                        fontSize = 20.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    
                    Text(
                        text = subtitle,
                        fontFamily = sarasaRegular,
                        fontSize = 12.sp,
                        color = TEXT_GRAY,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            // 表头
            if (showHeader) {
                Row(
                    modifier = Modifier
                        .background(BG_DARK_GRAY)
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "排名",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(50.dp)
                    )
                    
                    Text(
                        text = "",
                        modifier = Modifier.weight(0.4f)
                    )
                    
                    Text(
                        text = "分数分布",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(barWidth.dp)
                    )
                    Text(
                        text = "总分",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(totalScoreWidth)
                    )
                    Text(
                        text = "票平均",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(voteAvgWidth)
                    )
                    Text(
                        text = "短平均",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(shortAvgWidth)
                    )
                    Text(
                        text = "长平均",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(longAvgWidth)
                    )
                }
            }

            // 数据列表 - 使用Column代替LazyColumn
            Column {
                commentData.forEachIndexed { index, comment ->
                    BofCommentCaptureRow(
                        comment = comment,
                        index = index,
                        maxScore = maxScore,
                        barWidth = barWidth,
                        voteAvgWidth = voteAvgWidth,
                        shortAvgWidth = shortAvgWidth,
                        longAvgWidth = longAvgWidth,
                        totalScoreWidth = totalScoreWidth
                    )
                }
            }
        }
    }
}

@Composable
private fun BofCommentCaptureRow(
    comment: BofCommentUI,
    index: Int,
    maxScore: Double,
    barWidth: Double,
    voteAvgWidth: Dp,
    shortAvgWidth: Dp,
    longAvgWidth: Dp,
    totalScoreWidth: Dp
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val rankColor = Color.White

    // 检查是否有有效的分数分布数据
    val hasValidChartData = (comment.voteChartData.isNotEmpty() && comment.voteChartData.any { it > 0 }) ||
                           (comment.shortChartData.isNotEmpty() && comment.shortChartData.any { it > 0 }) ||
                           (comment.longChartData.isNotEmpty() && comment.longChartData.any { it > 0 })

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp)
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 排名列
        Text(
            text = comment.index.toString(),
            fontFamily = sarasaBold,
            fontSize = 16.sp,
            color = rankColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(50.dp)
        )

        // 用户信息列
        Column(
            modifier = Modifier
                .weight(0.6f)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.End
        ) {
            // 用户名
            Text(
                text = comment.user,
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            // 国家和模式
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (comment.pattern.isNotEmpty()) {
                    Text(
                        text = "P${comment.pattern}",
                        fontFamily = sarasaRegular,
                        fontSize = 11.sp,
                        color = Color.Yellow,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
                Text(
                    text = comment.country,
                    fontFamily = sarasaRegular,
                    fontSize = 12.sp,
                    color = TEXT_GRAY,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // 宽屏模式：显示分数条图表和详细平均分
        Row {
            // 分数条图表部分
            Box(
                modifier = Modifier
                    .width(barWidth.dp)
                    .height(34.dp)
            ) {
                if (comment.index <= 50 && hasValidChartData) {
                    // 计算各评价类型相对于全局最高分的比例
                    val voteRatio = if (maxScore > 0) comment.vote.toFloat() / maxScore.toFloat() else 0f
                    val shortRatio = if (maxScore > 0) comment.short.toFloat() / maxScore.toFloat() else 0f
                    val longRatio = if (maxScore > 0) comment.long.toFloat() / maxScore.toFloat() else 0f
                    
                    Row {
                        // Vote 图表
                        Box(
                            modifier = Modifier
                                .width(barWidth.dp * voteRatio)
                                .height(34.dp)
                        ) {
                            if (comment.voteChartData.isNotEmpty() && comment.voteChartData.any { it > 0 }) {
                                ScoreChart(
                                    dataList = comment.voteChartData,
                                    height = 34.dp,
                                    width = barWidth.dp * voteRatio,
                                    color = RANKING_GREEN
                                )
                            }
                        }
                        
                        // Short 图表
                        Box(
                            modifier = Modifier
                                .width(barWidth.dp * shortRatio)
                                .height(34.dp)
                        ) {
                            if (comment.shortChartData.isNotEmpty() && comment.shortChartData.any { it > 0 }) {
                                ScoreChart(
                                    dataList = comment.shortChartData,
                                    height = 34.dp,
                                    width = barWidth.dp * shortRatio,
                                    color = RANKING_BLUE
                                )
                            }
                        }
                        
                        // Long 图表
                        Box(
                            modifier = Modifier
                                .width(barWidth.dp * longRatio)
                                .height(34.dp)
                        ) {
                            if (comment.longChartData.isNotEmpty() && comment.longChartData.any { it > 0 }) {
                                ScoreChart(
                                    dataList = comment.longChartData,
                                    height = 34.dp,
                                    width = barWidth.dp * longRatio,
                                    color = RANKING_RED
                                )
                            }
                        }
                    }
                } else {
                    // 简化版分数条（排名50以后或无有效图表数据）
                    val voteRatio = if (maxScore > 0) comment.vote.toFloat() / maxScore.toFloat() else 0f
                    val shortRatio = if (maxScore > 0) comment.short.toFloat() / maxScore.toFloat() else 0f
                    val longRatio = if (maxScore > 0) comment.long.toFloat() / maxScore.toFloat() else 0f
                    
                    Row {
                        Box(
                            modifier = Modifier
                                .width(barWidth.dp * voteRatio)
                                .height(34.dp)
                                .background(color = RANKING_GREEN)
                        )
                        Box(
                            modifier = Modifier
                                .width(barWidth.dp * shortRatio)
                                .height(34.dp)
                                .background(color = RANKING_BLUE)
                        )
                        Box(
                            modifier = Modifier
                                .width(barWidth.dp * longRatio)
                                .height(34.dp)
                                .background(color = RANKING_RED)
                        )
                    }
                }
            }
            
            // 总分文本
            Box(
                modifier = Modifier
                    .width(totalScoreWidth)
                    .height(34.dp)
                    .padding(horizontal = 2.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = formatScore(comment.total, ColumnWidthType.THREE_DIGIT_INT),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                    textAlign = TextAlign.End,
                    maxLines = 1
                )
            }
        }
        
        // 票选平均分列
        Box(
            modifier = Modifier
                .width(voteAvgWidth)
                .fillMaxHeight()
                .background(
                    if (comment.voteAve > 0)
                        Color(red = (comment.voteAve / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                    else
                        Color.Transparent
                )
                .padding(horizontal = 2.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = formatScore(comment.voteAve, ColumnWidthType.TWO_DECIMAL),
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
        
        // 短评平均分列
        Box(
            modifier = Modifier
                .width(shortAvgWidth)
                .fillMaxHeight()
                .background(
                    if (comment.shortAve > 0)
                        Color(red = (comment.shortAve / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                    else
                        Color.Transparent
                )
                .padding(horizontal = 2.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = formatScore(comment.shortAve, ColumnWidthType.TWO_DECIMAL),
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
        
        // 长评平均分列
        Box(
            modifier = Modifier
                .width(longAvgWidth)
                .fillMaxHeight()
                .background(
                    if (comment.longAve > 0)
                        Color(red = (comment.longAve / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                    else
                        Color.Transparent
                )
                .padding(horizontal = 2.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = formatScore(comment.longAve, ColumnWidthType.TWO_DECIMAL),
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
    }
}
