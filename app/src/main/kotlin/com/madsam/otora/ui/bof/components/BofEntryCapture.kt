package com.madsam.otora.ui.bof.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.ui.common.RankingItem
import com.madsam.otora.ui.common.RankingTableConfig
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BofEntryCaptureDialog(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    items: List<RankingItem>,
    config: RankingTableConfig
) {
    val scope = rememberCoroutineScope()
    
    if (showDialog.value) {
        // 过滤掉总分小于等于0的数据
        val filteredItems = items.filter { it.score.toDouble() > 0 }
        
        // 分批，每100行一组
        val batchSize = 100
        val batches = filteredItems.chunked(batchSize)
        val controllers = List(batches.size) { rememberCaptureController() }
        
        // 计算全局最大分数（所有items，不是每批单独计算）
        val globalCurrentMaxScore = filteredItems.maxOfOrNull { it.score.toDouble() } ?: 1.0
        val globalCompareMaxScore = filteredItems.mapNotNull { it.compareScore?.toDouble() }.maxOfOrNull { it } ?: 0.0
        val globalMaxScore = maxOf(globalCurrentMaxScore, globalCompareMaxScore)

        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "截图功能") },
            text = {
                Column {
                    Text(
                        text = "将保存${config.title}内容到相册，分批截图后自动拼接（每批100行，最大高度30000像素）",
                        modifier = Modifier.padding(8.dp)
                    )
                    
                    // 渲染所有批次（隐藏但会被渲染用于截图）
                    batches.forEachIndexed { index, batch ->
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .height(0.dp)
                                .requiredHeight(5000.dp)
                                .requiredWidth(900.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .capturable(controllers[index])
                                    .fillMaxWidth()
                            ) {
                                BofEntryCaptureContent(
                                    items = batch,
                                    config = config,
                                    showTitle = index == 0,   // 只有第一批显示标题
                                    showHeader = index == 0,  // 只有第一批显示表头
                                    globalMaxScore = globalMaxScore  // 传递全局最大值
                                )
                            }
                        }
                    }
                    
                    if (batches.size > 1) {
                        Text(text = "共${batches.size}批，截图时会自动拼接全部内容", fontSize = 13.sp, color = Color.Gray, modifier = Modifier.padding(top = 8.dp))
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
                                // 将硬件加速的bitmap转换为软件bitmap，避免"Software rendering doesn't support hardware bitmaps"错误
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
                            val finalBitmap = com.madsam.otora.core.utils.ImageUtils.combineBitmaps(bitmaps, maxHeight = 30000)
                            val current = LocalDateTime.now()
                            val formatter = DateTimeFormatter.ofPattern("MMddHHmm")
                            val timeStr = current.format(formatter)
                            val filePrefix = when {
                                config.title.contains("总分") -> "BOF_Total"
                                config.title.contains("平均") -> "BOF_Avg"
                                config.title.contains("中位") -> "BOF_Median"
                                config.title.contains("差值") -> "BOF_Diff"
                                config.title.contains("综合") -> "BOF_Composite"
                                else -> "BOF_Ranking"
                            }
                            com.madsam.otora.core.utils.ImageUtils.saveBitmapToGallery(
                                context = context,
                                bitmap = finalBitmap,
                                title = "${filePrefix}_$timeStr",
                                description = "BOF ${config.title} Capture"
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
internal fun BofEntryCaptureContent(
    items: List<RankingItem>,
    config: RankingTableConfig,
    showTitle: Boolean = true,
    showHeader: Boolean = true,
    globalMaxScore: Double? = null  // 全局最大分数，用于保持所有批次分数条比例一致
) {
    // 使用专门的截图版本，使用Column代替LazyColumn避免高度测量问题
    Box(
        modifier = Modifier
            .width(900.dp)
            .background(Color.Black)
    ) {
        com.madsam.otora.ui.common.RankingTableForCapture(
            items = items,
            config = config,
            showTitle = showTitle,
            showHeader = showHeader,
            globalMaxScore = globalMaxScore
        )
    }
}