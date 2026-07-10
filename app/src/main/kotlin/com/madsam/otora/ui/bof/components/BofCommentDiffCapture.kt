package com.madsam.otora.ui.bof.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.R
import com.madsam.otora.ui.bof.BofRankingColors
import com.madsam.otora.core.theme.plexBold
import com.madsam.otora.core.theme.plexRegular
import com.madsam.otora.core.utils.ImageUtils
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun BofCommentDiffCaptureDialog(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    commentData: List<BofCommentUI>,
    title: String,
    subtitle: String
) {
    val scope = rememberCoroutineScope()
    val captureTitle = stringResource(R.string.bof_capture_title)
    val captureMessage = stringResource(R.string.bof_capture_comment_diff_message)
    val captureAction = stringResource(R.string.bof_capture_action)
    val cancelAction = stringResource(R.string.bof_action_cancel)
    
    if (showDialog.value) {
        // 过滤掉总分小于等于0的数据
        val filteredComments = commentData.filter { it.total > 0 }
        
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
                    
                    // 渲染所有批次
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
                                BofCommentDiffCaptureContent(
                                    commentData = batch,
                                    title = title,
                                    subtitle = subtitle,
                                    showTitle = index == 0,
                                    showHeader = index == 0,
                                    globalMaxScore = globalMaxScore
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
                            val bitmaps = mutableListOf<android.graphics.Bitmap>()
                            for ((i, _) in batches.withIndex()) {
                                val bmp = controllers[i].captureAsync().await().asAndroidBitmap()
                                val softwareBitmap =
                                    if (bmp.config == android.graphics.Bitmap.Config.HARDWARE) {
                                        bmp.copy(android.graphics.Bitmap.Config.ARGB_8888, false)
                                    } else {
                                        bmp
                                    }
                                bitmaps.add(softwareBitmap)
                                if (softwareBitmap != bmp) {
                                    bmp.recycle()
                                }
                            }
                            val finalBitmap = ImageUtils.combineBitmaps(bitmaps, maxHeight = 30000)
                            val current = LocalDateTime.now()
                            val formatter = DateTimeFormatter.ofPattern("MMddHHmm")
                            val timeStr = current.format(formatter)
                            ImageUtils.saveBitmapToGallery(
                                context = context,
                                bitmap = finalBitmap,
                                title = "BOF_Comment_Diff_$timeStr",
                                description = "BOF Comment Diff Ranking Capture"
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
internal fun BofCommentDiffCaptureContent(
    commentData: List<BofCommentUI>,
    title: String,
    subtitle: String,
    showTitle: Boolean = true,
    showHeader: Boolean = true,
    globalMaxScore: Double? = null
) {
    val maxScore = globalMaxScore ?: (commentData.maxOfOrNull { it.total.toDouble() } ?: 1.0)
    val rankColumn = stringResource(R.string.bof_column_rank)
    val commentColumn = stringResource(R.string.bof_column_comment)
    val increaseColumn = stringResource(R.string.bof_column_increase)
    val decreaseColumn = stringResource(R.string.bof_column_decrease)
    val diffDecreaseTitle = stringResource(R.string.bof_comment_diff_decrease_title)
    val changeColumn = if (title == diffDecreaseTitle) decreaseColumn else increaseColumn

    Box(
        modifier = Modifier
            .width(900.dp)
            .background(BofRankingColors.Background)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
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

            if (showHeader) {
                // Diff表头 - 只有三列：排名、评价、增长/减少
                Row(
                    modifier = Modifier
                        .background(BofRankingColors.Header)
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 4.dp),
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
                        text = commentColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        modifier = Modifier.weight(0.6f)
                    )
                    
                    Text(
                        text = changeColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(0.4f)
                    )
                }
            }

            // Diff数据行
            Column {
                commentData.forEachIndexed { index, comment ->
                    CommentDiffCaptureRow(
                        comment = comment,
                        index = index,
                        maxScore = maxScore
                    )
                }
            }
        }
    }
}

@Composable
private fun CommentDiffCaptureRow(
    comment: BofCommentUI,
    index: Int,
    maxScore: Double
) {
    val backgroundColor = if (index % 2 == 0) BofRankingColors.RowAlt else BofRankingColors.Background
    val scoreRatio = if (maxScore > 0) comment.total.toDouble() / maxScore else 0.0

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 排名列 - 只显示排名，不显示变化
        Text(
            text = (index + 1).toString(),
            fontFamily = plexBold,
            fontSize = 16.sp,
            color = BofRankingColors.Text,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(50.dp)
        )

        // 评价信息列 - 显示用户信息（用户名、地区、识别码）
        Column(
            modifier = Modifier
                .weight(0.6f)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = comment.user,
                fontFamily = plexBold,
                fontSize = 14.sp,
                color = BofRankingColors.Text,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                horizontalArrangement = androidx.compose.foundation.layout.Arrangement.End,
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
                    color = BofRankingColors.TextSecondary
                )
            }
        }

        // 差值分数条 - 使用嵌套Box设计
        Box(
            modifier = Modifier
                .weight(0.4f)
                .padding(start = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .padding(horizontal = 2.dp)
            ) {
                Box {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(scoreRatio.toFloat().coerceAtMost(1f))
                            .height(20.dp)
                            .background(
                                color = BofRankingColors.Score,
                                shape = RoundedCornerShape(
                                    topEnd = 10.dp,
                                    bottomEnd = 10.dp
                                )
                            )
                    )
                    Text(
                        text = comment.total.toString(),
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.OnScore,
                        overflow = TextOverflow.Visible,
                        maxLines = 1,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 4.dp)
                    )
                }
            }
        }
    }
}
