package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
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
import com.madsam.otora.core.utils.ScreenUtil
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.ui.bof.components.ScoreChart
import com.madsam.otora.ui.common.ColumnWidthType
import java.util.Locale

private fun formatScore(score: Number, widthType: ColumnWidthType): String {
    val doubleValue = score.toDouble()
    return when (widthType) {
        ColumnWidthType.THREE_DIGIT_INT -> 
            if (doubleValue > 0) {
                // 整数类型，直接显示整数
                doubleValue.toInt().toString()
            } else "---"
        ColumnWidthType.TWO_DECIMAL -> 
            if (doubleValue > 0) {
                // 对于整数，显示为一位小数；否则显示两位小数
                if (doubleValue == doubleValue.toInt().toDouble()) {
                    String.format(Locale.US, "%.1f", doubleValue)
                } else {
                    String.format(Locale.US,"%.2f", doubleValue)
                }
            } else "---"
        ColumnWidthType.ONE_DECIMAL ->
            if (doubleValue > 0) {
                // 显示一位小数
                if (doubleValue == 1000.0) {
                    doubleValue.toInt().toString()
                } else {
                    String.format(Locale.US,"%.1f", doubleValue)
                }
            } else "---"
    }
}

@Composable
internal fun BofCommentScreen(
    commentData: List<BofCommentUI>,
    title: String = "BOF comment ranking",
    subtitle: String = "Sorted by total score",
    commentDisplayMode: Int = 0,
    scrollThreshold: Float = 50f,
    setIsTabRowVisible: (Boolean) -> Unit = {},
    showCaptureDialog: Boolean = false,
    onCaptureDialogDismiss: () -> Unit = {},
    showTitle: Boolean = false
) {
    val rankColumn = stringResource(R.string.bof_column_rank)
    val totalColumn = stringResource(R.string.bof_column_total)
    val scoreDistributionColumn = stringResource(R.string.bof_column_score_distribution)
    val voteAverageColumn = stringResource(R.string.bof_column_vote_average)
    val shortAverageColumn = stringResource(R.string.bof_column_short_average)
    val longAverageColumn = stringResource(R.string.bof_column_long_average)

    // 计算屏幕宽度和内容宽度
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    val screenWidthDp = with(density) {
        windowInfo.containerSize.width.toDp()
    }
    
    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    val isNarrowScreen = screenWidthDp.value < 600
    
    // 按照RankingTable标准测量各列宽度
    var voteAvgWidth by remember { mutableStateOf(60.dp) }
    var shortAvgWidth by remember { mutableStateOf(60.dp) }
    var longAvgWidth by remember { mutableStateOf(60.dp) }
    var totalScoreWidth by remember { mutableStateOf(36.dp) }
    
    // 计算分数条宽度
    val barWidth = when {
        screenWidthDp.value >= 1000 -> 280.0
        screenWidthDp.value.toInt() in 800..999 -> 186.0 + (screenWidthDp.value - 800) / 200.0 * 94.0
        else -> 186.0
    }
    
    // 计算窄屏模式的分数条宽度 - 应该等于三个信息列的总宽度
    val narrowScoreBarWidth = voteAvgWidth + shortAvgWidth + longAvgWidth
    
    val maxScore = commentData.maxOfOrNull { it.total.toDouble() } ?: 1.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(
                WindowInsets.displayCutout.only(
                    if (useNavigationRail) {
                        // 使用 NavigationRail 时，左侧已由 Rail 处理，只处理右侧
                        WindowInsetsSides.End
                    } else {
                        // 使用 BottomNavigation 时，处理左侧和右侧
                        WindowInsetsSides.Start + WindowInsetsSides.End
                    }
                )
            )
    ) {
        // 隐藏的测量容器 - 按照RankingTable标准
        Box(modifier = Modifier
            .size(0.dp)
            .requiredWidth(500.dp)
            .requiredHeight(100.dp)
        ) {
            // 测量票选平均分宽度 - 使用TWO_DECIMAL标准
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
            // 测量短评平均分宽度 - 使用TWO_DECIMAL标准
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
            // 测量长评平均分宽度 - 使用TWO_DECIMAL标准
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
            // 测量总分宽度 - 使用THREE_DIGIT_INT标准
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
        
        // 表格标题和副标题
        if (showTitle) Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(BofRankingColors.Background)
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 主标题
            Text(
                text = title,
                fontFamily = plexBold,
                fontSize = 20.sp,
                color = BofRankingColors.Text,
                textAlign = TextAlign.Center
            )
            
            // 副标题
            Text(
                text = subtitle,
                fontFamily = plexRegular,
                fontSize = 12.sp,
                color = BofRankingColors.TextSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        // 表头
        Row(
            modifier = Modifier
                .background(BofRankingColors.Header)
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 排名列标题
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
            
            if (isNarrowScreen && commentDisplayMode == 0) {
                    Text(
                        text = totalColumn,
                        fontFamily = plexBold,
                        fontSize = 14.sp,
                        color = BofRankingColors.Text,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(narrowScoreBarWidth)
                    )
                }  else {
                    if (!isNarrowScreen) {
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
                    }
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

        // 数据列表
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(object : NestedScrollConnection {
                    private var totalScroll = 0f

                    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                        // 只在垂直滑动时处理TabRow显示/隐藏
                        totalScroll += available.y
                        if (totalScroll < -scrollThreshold) {
                            setIsTabRowVisible(false)
                            totalScroll = 0f
                        } else if (totalScroll > scrollThreshold) {
                            setIsTabRowVisible(true)
                            totalScroll = 0f
                        }
                        return Offset.Zero
                    }
                })
        ) {
            itemsIndexed(commentData) { index, comment ->
                BofCommentRow(
                    comment = comment,
                    index = index,
                    maxScore = maxScore,
                    isNarrowScreen = isNarrowScreen,
                    commentDisplayMode = commentDisplayMode,
                    barWidth = barWidth,
                    voteAvgWidth = voteAvgWidth,
                    shortAvgWidth = shortAvgWidth,
                    longAvgWidth = longAvgWidth,
                    totalScoreWidth = totalScoreWidth,
                    narrowScoreBarWidth = narrowScoreBarWidth
                )
            }
            // 底部安全区域，让用户滑动到底部时有额外的空间
            item(key = "bottom_spacer") {
                androidx.compose.foundation.layout.Spacer(
                    modifier = Modifier
                        .windowInsetsPadding(
                            if (useNavigationRail) {
                                WindowInsets.navigationBars.only(WindowInsetsSides.Bottom)
                            } else {
                                WindowInsets(0, 0, 0, 0)
                            }
                        )
                )
            }
        }
    }
    
    // 截图对话框
    val context = androidx.compose.ui.platform.LocalContext.current
    val snackbarHostState = androidx.compose.material3.SnackbarHostState()
    val showDialogState = remember { mutableStateOf(showCaptureDialog) }
    
    // 同步外部状态到内部状态
    androidx.compose.runtime.LaunchedEffect(showCaptureDialog) {
        showDialogState.value = showCaptureDialog
    }
    
    // 当对话框关闭时通知外部
    androidx.compose.runtime.LaunchedEffect(showDialogState.value) {
        if (!showDialogState.value && showCaptureDialog) {
            onCaptureDialogDismiss()
        }
    }
    
    com.madsam.otora.ui.bof.components.BofCommentCaptureDialog(
        showDialog = showDialogState,
        context = context,
        snackbarHostState = snackbarHostState,
        commentData = commentData,
        title = title,
        subtitle = subtitle
    )
}

@Composable
private fun BofCommentRow(
    comment: BofCommentUI,
    index: Int,
    maxScore: Double,
    isNarrowScreen: Boolean,
    commentDisplayMode: Int,
    barWidth: Double,
    voteAvgWidth: Dp,
    shortAvgWidth: Dp,
    longAvgWidth: Dp,
    totalScoreWidth: Dp,
    narrowScoreBarWidth: Dp
) {
    val backgroundColor = if (index % 2 == 0) BofRankingColors.RowAlt else BofRankingColors.Background
    val rankColor = BofRankingColors.Text

    // 检查是否有有效的分数分布数据 - 只要有任何一种评价数据存在且有效即可
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

        // 分数条显示逻辑 - 统一处理窄屏mode0和宽屏
        if (isNarrowScreen && commentDisplayMode == 0) {
            Box(
                modifier = Modifier
                    .width(narrowScoreBarWidth)
                    .height(34.dp)
            ) {
                ScoreBarDisplay(
                    comment = comment,
                    maxScore = maxScore,
                    hasValidChartData = hasValidChartData,
                    barWidth = narrowScoreBarWidth,
                    barHeight = 34.dp
                )
                Text(
                    text = formatScore(comment.total, ColumnWidthType.THREE_DIGIT_INT),
                    fontFamily = plexBold,
                    fontSize = 14.sp,
                    color = BofRankingColors.Text,
                    overflow = TextOverflow.Visible,
                    maxLines = 1,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 4.dp)
                )
            }
        } else {
            if (!isNarrowScreen) {
                // 宽屏模式：同时显示分数条图表和详细平均分
                Row {
                    // 分数条图表部分 - 使用统一的分数条组件
                    ScoreBarDisplay(
                        comment = comment,
                        maxScore = maxScore,
                        hasValidChartData = hasValidChartData,
                        barWidth = barWidth.dp,
                        barHeight = 34.dp
                    )
                    
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
}

// 统一的分数条显示组件 - 基于宽屏分数条逻辑
@Composable
private fun ScoreBarDisplay(
    comment: BofCommentUI,
    maxScore: Double,
    hasValidChartData: Boolean,
    barWidth: Dp,
    barHeight: Dp
) {
    Box(
        modifier = Modifier
            .width(barWidth)
            .height(barHeight)
    ) {
        if (comment.index <= 50 && hasValidChartData) {
            // 计算各评价类型相对于全局最高分的比例
            val voteRatio = if (maxScore > 0) comment.vote.toFloat() / maxScore.toFloat() else 0f
            val shortRatio = if (maxScore > 0) comment.short.toFloat() / maxScore.toFloat() else 0f
            val longRatio = if (maxScore > 0) comment.long.toFloat() / maxScore.toFloat() else 0f
            
            Row {
                // Vote 图表 - 使用比例宽度
                Box(
                    modifier = Modifier
                        .width(barWidth * voteRatio)
                        .height(barHeight)
                ) {
                    if (comment.voteChartData.isNotEmpty() && comment.voteChartData.any { it > 0 }) {
                        ScoreChart(
                            dataList = comment.voteChartData,
                            height = barHeight,
                            width = barWidth * voteRatio,
                            color = BofRankingColors.Positive
                        )
                    }
                }
                
                // Short 图表 - 使用比例宽度
                Box(
                    modifier = Modifier
                        .width(barWidth * shortRatio)
                        .height(barHeight)
                ) {
                    if (comment.shortChartData.isNotEmpty() && comment.shortChartData.any { it > 0 }) {
                        ScoreChart(
                            dataList = comment.shortChartData,
                            height = barHeight,
                            width = barWidth * shortRatio,
                            color = BofRankingColors.Blue
                        )
                    }
                }
                
                // Long 图表 - 使用比例宽度
                Box(
                    modifier = Modifier
                        .width(barWidth * longRatio)
                        .height(barHeight)
                ) {
                    if (comment.longChartData.isNotEmpty() && comment.longChartData.any { it > 0 }) {
                        ScoreChart(
                            dataList = comment.longChartData,
                            height = barHeight,
                            width = barWidth * longRatio,
                            color = BofRankingColors.Negative
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
                        .width(barWidth * voteRatio)
                        .height(barHeight)
                        .background(color = BofRankingColors.Positive)
                )
                Box(
                    modifier = Modifier
                        .width(barWidth * shortRatio)
                        .height(barHeight)
                        .background(color = BofRankingColors.Blue)
                )
                Box(
                    modifier = Modifier
                        .width(barWidth * longRatio)
                        .height(barHeight)
                        .background(color = BofRankingColors.Negative)
                )
            }
        }
    }
}

/**
 * BOF 评价差值页面组件
 * 专门用于显示差值排行，只显示总分差值，不显示副条（投票、短评、长评的分布）
 * 完全对齐 Entry Diff 的展示模式
 */
@Composable
internal fun BofCommentDiffScreen(
    commentData: List<BofCommentUI>,
    title: String,
    subtitle: String,
    isReverse: Boolean,
    scrollThreshold: Float = 50f,
    setIsTabRowVisible: (Boolean) -> Unit = {},
    showCaptureDialog: Boolean = false,
    onCaptureDialogDismiss: () -> Unit = {},
    showTitle: Boolean = false
) {
    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    val maxScore = commentData.maxOfOrNull { it.total.toDouble() } ?: 1.0
    val rankColumn = stringResource(R.string.bof_column_rank)
    val commentColumn = stringResource(R.string.bof_column_comment)
    val increaseColumn = stringResource(R.string.bof_column_increase)
    val decreaseColumn = stringResource(R.string.bof_column_decrease)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(
                WindowInsets.displayCutout.only(
                    if (useNavigationRail) {
                        WindowInsetsSides.End
                    } else {
                        WindowInsetsSides.Start + WindowInsetsSides.End
                    }
                )
            )
    ) {
        // 标题和副标题
        if (showTitle) Column(
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

        // 表格头部
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
                text = if (isReverse) decreaseColumn else increaseColumn,
                fontFamily = plexBold,
                fontSize = 14.sp,
                color = BofRankingColors.Text,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(0.4f)
            )
        }

        // 数据列表
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(object : NestedScrollConnection {
                    private var totalScroll = 0f

                    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                        totalScroll += available.y
                        if (totalScroll < -scrollThreshold) {
                            setIsTabRowVisible(false)
                            totalScroll = 0f
                        } else if (totalScroll > scrollThreshold) {
                            setIsTabRowVisible(true)
                            totalScroll = 0f
                        }
                        return Offset.Zero
                    }
                })
        ) {
            itemsIndexed(commentData) { index, comment ->
                CommentDiffRow(
                    comment = comment,
                    index = index,
                    maxScore = maxScore
                )
            }
        }
        
        // 截图对话框 - 使用 Diff 专用的截图组件
        if (showCaptureDialog) {
            val context = androidx.compose.ui.platform.LocalContext.current
            val snackbarHostState = remember { androidx.compose.material3.SnackbarHostState() }
            val showDialogState = remember { mutableStateOf(true) }
            
            com.madsam.otora.ui.bof.components.BofCommentDiffCaptureDialog(
                showDialog = showDialogState,
                context = context,
                snackbarHostState = snackbarHostState,
                commentData = commentData,
                title = title,
                subtitle = subtitle
            )
            
            // 当对话框被关闭时，通知父组件
            if (!showDialogState.value) {
                onCaptureDialogDismiss()
            }
        }
    }
}

/**
 * 评价差值行组件
 * 只显示排名、评价文本和差值分数条，不显示副条
 */
@Composable
private fun CommentDiffRow(
    comment: BofCommentUI,
    index: Int,
    maxScore: Double
) {
    val backgroundColor = if (index % 2 == 0) BofRankingColors.RowAlt else BofRankingColors.Background
    val scoreRatio = if (maxScore > 0) comment.total.toFloat() / maxScore.toFloat() else 0f

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(vertical = 8.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 排名 - 不显示变化
        Text(
            text = (index + 1).toString(),
            fontFamily = plexBold,
            fontSize = 16.sp,
            color = BofRankingColors.Text,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(50.dp)
        )

        // 用户信息列（照搬总榜的设计）
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

        // 差值分数条（完全对齐 Entry Diff 的样式，包括嵌套 Box）
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
                            .fillMaxWidth(scoreRatio.coerceAtMost(1f))
                            .height(20.dp)
                            .background(
                                color = BofRankingColors.Negative,
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
                        color = BofRankingColors.Text,
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
