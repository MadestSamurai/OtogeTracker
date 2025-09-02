package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
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
import com.madsam.otora.data.bof.ui.model.BofCommentUI
import com.madsam.otora.ui.bof.components.ScoreChart
import com.madsam.otora.ui.common.ColumnWidthType

// 按照RankingTable标准的格式化函数
private fun formatScore(score: Number, widthType: ColumnWidthType): String {
    return formatScore(score, widthType, allowNegative = false)
}

private fun formatScore(score: Number, widthType: ColumnWidthType, allowNegative: Boolean): String {
    val doubleValue = score.toDouble()
    return when (widthType) {
        ColumnWidthType.THREE_DIGIT_INT -> 
            if (doubleValue > 0 || (allowNegative && doubleValue != 0.0)) {
                // 整数类型，直接显示整数
                doubleValue.toInt().toString()
            } else "---"
        ColumnWidthType.TWO_DECIMAL -> 
            if (doubleValue > 0 || (allowNegative && doubleValue != 0.0)) {
                // 对于整数，显示为一位小数；否则显示两位小数
                if (doubleValue == doubleValue.toInt().toDouble()) {
                    String.format("%.1f", doubleValue)
                } else {
                    String.format("%.2f", doubleValue)
                }
            } else "---"
        ColumnWidthType.ONE_DECIMAL ->
            if (doubleValue > 0 || (allowNegative && doubleValue != 0.0)) {
                // 显示一位小数
                if (doubleValue == 1000.0) {
                    doubleValue.toInt().toString()
                } else {
                    String.format("%.1f", doubleValue)
                }
            } else "---"
    }
}

@Composable
internal fun BofCommentScreen(
    commentData: List<BofCommentUI>,
    title: String = "BOF 评价排行榜",
    subtitle: String = "按总分排序",
    commentDisplayMode: Int = 0
) {
    // 屏幕宽度检测
    val configuration = androidx.compose.ui.platform.LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val isNarrowScreen = screenWidthDp < 600
    
    // 按照RankingTable标准测量各列宽度
    var voteAvgWidth by remember { mutableStateOf(60.dp) }
    var shortAvgWidth by remember { mutableStateOf(60.dp) }
    var longAvgWidth by remember { mutableStateOf(60.dp) }
    var totalScoreWidth by remember { mutableStateOf(36.dp) }
    
    val density = LocalDensity.current
    
    // 计算分数条宽度
    val barWidth = when {
        screenWidthDp >= 1000 -> 280.0
        screenWidthDp in 800..999 -> 186.0 + (screenWidthDp - 800) / 200.0 * 94.0
        else -> 186.0
    }
    
    // 计算窄屏模式的分数条宽度 - 应该等于三个信息列的总宽度
    val narrowScoreBarWidth = voteAvgWidth + shortAvgWidth + longAvgWidth
    
    val maxScore = commentData.maxOfOrNull { it.total.toDouble() } ?: 1.0

    Column(modifier = Modifier.fillMaxSize()) {
        // 隐藏的测量容器 - 按照RankingTable标准
        Box(modifier = Modifier
            .size(0.dp)
            .requiredWidth(500.dp)
            .requiredHeight(100.dp)
        ) {
            // 测量票选平均分宽度 - 使用TWO_DECIMAL标准
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
            // 测量短评平均分宽度 - 使用TWO_DECIMAL标准
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
            // 测量长评平均分宽度 - 使用TWO_DECIMAL标准
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
            // 测量总分宽度 - 使用THREE_DIGIT_INT标准
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
        
        // 表格标题
        Text(
            text = title,
            fontFamily = sarasaBold,
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(vertical = 8.dp)
        )

        Text(
            text = subtitle,
            fontFamily = sarasaRegular,
            fontSize = 12.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 16.dp, vertical = 4.dp)
        )

        // 表头
        Row(
            modifier = Modifier
                .background(BG_DARK_GRAY)
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 排名列标题
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
            
            if (isNarrowScreen && commentDisplayMode == 0) {
                    Text(
                        text = "总分",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(narrowScoreBarWidth)
                    )
                }  else {
                    if (!isNarrowScreen) {
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
                    }
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

        // 数据列表
        LazyColumn(modifier = Modifier.fillMaxSize()) {
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
        }
    }
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
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val rankColor = Color.White

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

        // 分数条显示逻辑 - 统一处理窄屏mode0和宽屏
        if (isNarrowScreen && commentDisplayMode == 0) {
            Box(
                modifier = Modifier
                    .width(narrowScoreBarWidth)
                    .height(24.dp)
            ) {
                ScoreBarDisplay(
                    comment = comment,
                    maxScore = maxScore,
                    hasValidChartData = hasValidChartData,
                    barWidth = narrowScoreBarWidth,
                    barHeight = 24.dp
                )
                Text(
                    text = formatScore(comment.total, ColumnWidthType.THREE_DIGIT_INT),
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    color = Color.White,
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
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = sarasaBold,
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
                    .height(34.dp)
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
                    .height(34.dp)
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
                    .height(34.dp)
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
                            color = RANKING_GREEN
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
                            color = RANKING_BLUE
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
                        .width(barWidth * voteRatio)
                        .height(barHeight)
                        .background(color = RANKING_GREEN)
                )
                Box(
                    modifier = Modifier
                        .width(barWidth * shortRatio)
                        .height(barHeight)
                        .background(color = RANKING_BLUE)
                )
                Box(
                    modifier = Modifier
                        .width(barWidth * longRatio)
                        .height(barHeight)
                        .background(color = RANKING_RED)
                )
            }
        }
    }
}
