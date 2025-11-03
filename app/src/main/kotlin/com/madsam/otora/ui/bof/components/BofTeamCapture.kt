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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.utils.ImageUtils
import com.madsam.otora.ui.bof.TeamRankingItem
import com.madsam.otora.ui.bof.sub.TeamRankingRow
import com.madsam.otora.ui.bof.sub.TeamTableHeader
import dev.shreyaspatil.capturable.capturable
import dev.shreyaspatil.capturable.controller.rememberCaptureController
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BofTeamCaptureDialog(
    showDialog: MutableState<Boolean>,
    context: Context,
    snackbarHostState: SnackbarHostState,
    teams: List<TeamRankingItem>,
    subtitle: String
) {
    val scope = rememberCoroutineScope()

    if (showDialog.value) {
        // 过滤掉总分小于等于0的数据
        val filteredTeams = teams.filter { it.totalScore > 0 }

        // 分批，每50个团队一组（团队数据比作品数据更复杂，所以批次更小）
        val batchSize = 50
        val batches = filteredTeams.chunked(batchSize)
        val controllers = List(batches.size) { rememberCaptureController() }

        // 计算全局最大分数
        val globalMaxScore = filteredTeams.maxOfOrNull { it.totalScore } ?: 1.0

        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "截图功能") },
            text = {
                Column {
                    Text(
                        text = "将保存团队排行榜内容到相册，分批截图后自动拼接（每批50个团队，最大高度30000像素）",
                        modifier = Modifier.padding(8.dp)
                    )

                    // 渲染所有批次（第一批可见作为预览，其他批次在屏幕外但会被渲染用于截图）
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
                                BofTeamCaptureContent(
                                    teams = batch,
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
                                val softwareBitmap =
                                    if (bmp.config == android.graphics.Bitmap.Config.HARDWARE) {
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
                                title = "BOF_Team_$timeStr",
                                description = "BOF Team Ranking Capture"
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
internal fun BofTeamCaptureContent(
    teams: List<TeamRankingItem>,
    subtitle: String,
    showTitle: Boolean = true,
    showHeader: Boolean = true,
    globalMaxScore: Double? = null
) {
    // 如果提供了全局最大值则使用，否则计算当前teams的最大值
    val maxScore = globalMaxScore ?: (teams.maxOfOrNull { it.totalScore } ?: 1.0)

    // 测量列宽（复用原有逻辑）
    val density = LocalDensity.current
    var extraWidth by remember { mutableStateOf(50.dp) }
    var medianWidth by remember { mutableStateOf(60.dp) }
    val scoreBarWidth = medianWidth + extraWidth

    Box(
        modifier = Modifier
            .width(900.dp)
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // 隐藏的测量容器（复用原有逻辑）
            Box(
                modifier = Modifier
                    .size(0.dp)
                    .requiredWidth(500.dp)
                    .requiredHeight(100.dp)
            ) {
                Text(
                    text = "0000",
                    fontFamily = sarasaRegular,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        extraWidth = with(density) {
                            coordinates.size.width.toDp() + 24.dp
                        }
                    }
                )
                Text(
                    text = "000.00",
                    fontFamily = sarasaRegular,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        medianWidth = with(density) {
                            coordinates.size.width.toDp() + 24.dp
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
                        text = "团队总分排行榜",
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

            // 表格头部 - 直接复用原有组件
            if (showHeader) {
                TeamTableHeader(
                    teamInfoMode = 0,
                    isNarrowScreen = false,  // 900dp宽屏模式
                    extraWidth = extraWidth,
                    medianWidth = medianWidth
                )
            }

            // 数据列表 - 直接复用原有组件
            Column {
                teams.forEachIndexed { index, team ->
                    TeamRankingRow(
                        team = team,
                        index = index,
                        maxScore = maxScore,
                        teamInfoMode = 0,
                        isNarrowScreen = false,  // 900dp宽屏模式
                        extraWidth = extraWidth,
                        medianWidth = medianWidth,
                        scoreBarWidth = scoreBarWidth
                    )
                }
            }
        }
    }
}


