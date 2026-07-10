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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.ui.bof.BofRankingColors
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
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
    val captureTitle = stringResource(R.string.bof_capture_title)
    val captureMessage = stringResource(R.string.bof_capture_comment_message)
    val captureAction = stringResource(R.string.bof_capture_action)
    val cancelAction = stringResource(R.string.bof_action_cancel)
    
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
            title = { Text(text = captureTitle) },
            text = {
                Column {
                    Text(
                        text = captureMessage,
                        modifier = Modifier.padding(8.dp)
                    )
                    
                    // 渲染所有批次（隐藏但会被渲染用于截图）
                    batches.forEachIndexed { index, batch ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .height(0.dp)
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
                            text = stringResource(R.string.bof_capture_batches_format, batches.size),
                            fontSize = 13.sp,
                            color = BofRankingColors.Neutral,
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
                            snackbarHostState.showSnackbar(
                                context.getString(R.string.bof_capture_saved_format, batches.size)
                            )
                        }
                        showDialog.value = false
                    }
                ) {
                    Text(text = captureAction)
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text(text = cancelAction)
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
    val rankColumn = stringResource(R.string.bof_column_rank)
    val totalColumn = stringResource(R.string.bof_column_total)
    val scoreDistributionColumn = stringResource(R.string.bof_column_score_distribution)
    val voteAverageColumn = stringResource(R.string.bof_column_vote_average)
    val shortAverageColumn = stringResource(R.string.bof_column_short_average)
    val longAverageColumn = stringResource(R.string.bof_column_long_average)

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
            .background(BofRankingColors.Background)
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
                    fontFamily = plexBold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        voteAvgWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
                Text(
                    text = ColumnWidthType.TWO_DECIMAL.measureText,
                    fontFamily = plexBold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        shortAvgWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
                Text(
                    text = ColumnWidthType.TWO_DECIMAL.measureText,
                    fontFamily = plexBold,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        longAvgWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
                Text(
                    text = ColumnWidthType.THREE_DIGIT_INT.measureText,
                    fontFamily = plexBold,
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
                        .background(BofRankingColors.Background)
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontFamily = plexBold,
                        fontSize = 20.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.Center
                    )
                    
                    Text(
                        text = subtitle,
                        fontFamily = plexRegular,
                        fontSize = 12.sp,
                        color = BofRankingColors.TextSecondary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            // 表头
            if (showHeader) {
                Row(
                    modifier = Modifier
                        .background(BofRankingColors.Header)
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = rankColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(50.dp)
                    )
                    
                    Text(
                        text = "",
                        modifier = Modifier.weight(0.4f)
                    )
                    
                    Text(
                        text = scoreDistributionColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(barWidth.dp)
                    )
                    Text(
                        text = totalColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(totalScoreWidth)
                    )
                    Text(
                        text = voteAverageColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(voteAvgWidth)
                    )
                    Text(
                        text = shortAverageColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(shortAvgWidth)
                    )
                    Text(
                        text = longAverageColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
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
    val backgroundColor = if (index % 2 == 0) BofRankingColors.RowAlt else BofRankingColors.Background
    val rankColor = BofRankingColors.Text

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
            fontFamily = plexBold,
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
                fontFamily = plexBold,
                fontSize = 14.sp,
                color = BofRankingColors.Text,
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
                        fontFamily = plexRegular,
                        fontSize = 11.sp,
                        color = BofRankingColors.Accent,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
                Text(
                    text = comment.country,
                    fontFamily = plexRegular,
                    fontSize = 12.sp,
                    color = BofRankingColors.TextSecondary,
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
                                    color = BofRankingColors.Primary
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
                                    color = BofRankingColors.Blue
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
                                    color = BofRankingColors.Tertiary
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
                                .background(color = BofRankingColors.Primary)
                        )
                        Box(
                            modifier = Modifier
                                .width(barWidth.dp * shortRatio)
                                .height(34.dp)
                                .background(color = BofRankingColors.Blue)
                        )
                        Box(
                            modifier = Modifier
                                .width(barWidth.dp * longRatio)
                                .height(34.dp)
                                .background(color = BofRankingColors.Tertiary)
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
                    color = BofRankingColors.Text,
                    fontSize = 14.sp,
                    fontFamily = plexBold,
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
                .background(BofRankingColors.scoreHeat(comment.voteAve))
                .padding(horizontal = 2.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = formatScore(comment.voteAve, ColumnWidthType.TWO_DECIMAL),
                fontFamily = plexBold,
                fontSize = 14.sp,
                color = BofRankingColors.Text,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
        
        // 短评平均分列
        Box(
            modifier = Modifier
                .width(shortAvgWidth)
                .fillMaxHeight()
                .background(BofRankingColors.scoreHeat(comment.shortAve))
                .padding(horizontal = 2.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = formatScore(comment.shortAve, ColumnWidthType.TWO_DECIMAL),
                fontFamily = plexBold,
                fontSize = 14.sp,
                color = BofRankingColors.Text,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
        
        // 长评平均分列
        Box(
            modifier = Modifier
                .width(longAvgWidth)
                .fillMaxHeight()
                .background(BofRankingColors.scoreHeat(comment.longAve))
                .padding(horizontal = 2.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = formatScore(comment.longAve, ColumnWidthType.TWO_DECIMAL),
                fontFamily = plexBold,
                fontSize = 14.sp,
                color = BofRankingColors.Text,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }
    }
}
