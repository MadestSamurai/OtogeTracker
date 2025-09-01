package com.madsam.otora.ui.bof.sub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.foundation.shape.RoundedCornerShape
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

/**
 * BofCommentScreen: 用户评价排行榜
 * 支持两种显示模式：
 * 1. 分数条模式：显示前50名的得分曲线图
 * 2. 详细分数模式：显示平均分数值
 * 三个信息列为：voteAvg, shortAvg, longAvg
 */
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
    
    // 测量各列宽度
    var voteAvgWidth by remember { mutableStateOf(60.dp) }
    var shortAvgWidth by remember { mutableStateOf(60.dp) }
    var longAvgWidth by remember { mutableStateOf(60.dp) }
    
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
        // 隐藏的测量容器
        Box(modifier = Modifier
            .size(0.dp)
            .requiredWidth(500.dp)
            .requiredHeight(100.dp)
        ) {
            // 测量票选平均分宽度
            Text(
                text = "000.00",
                fontFamily = sarasaBold,
                fontSize = 16.sp, // 增大字号
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    voteAvgWidth = with(density) {
                        coordinates.size.width.toDp() + 8.dp
                    }
                }
            )
            // 测量短评平均分宽度
            Text(
                text = "000.00",
                fontFamily = sarasaBold,
                fontSize = 16.sp, // 增大字号
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    shortAvgWidth = with(density) {
                        coordinates.size.width.toDp() + 8.dp
                    }
                }
            )
            // 测量长评平均分宽度
            Text(
                text = "000.00",
                fontFamily = sarasaBold,
                fontSize = 16.sp, // 增大字号
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    longAvgWidth = with(density) {
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
            
            // 用户列标题 - 使用空白占位，像RankingTable一样
            Text(
                text = "",
                modifier = Modifier.weight(0.4f)
            )
            
            if (isNarrowScreen) {
                // 窄屏模式：根据commentDisplayMode切换显示
                if (commentDisplayMode == 0) {
                    Text(
                        text = "总分",
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(narrowScoreBarWidth)
                    )
                } else {
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
            } else {
                // 宽屏模式：同时显示所有列
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
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(36.dp)
                )
                Text(
                    text = "票选平均",
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier.width(voteAvgWidth)
                )
                Text(
                    text = "短评平均",
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier.width(shortAvgWidth)
                )
                Text(
                    text = "长评平均",
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
    narrowScoreBarWidth: Dp
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val scoreRatio = if (maxScore > 0) comment.total.toDouble() / maxScore else 0.0
    val rankColor = Color.White

    // 检查是否有有效的分数分布数据
    val hasValidChartData = comment.voteChartData.isNotEmpty() && 
                           comment.shortChartData.isNotEmpty() && 
                           comment.longChartData.isNotEmpty() &&
                           comment.voteChartData.any { it > 0 } &&
                           comment.shortChartData.any { it > 0 } &&
                           comment.longChartData.any { it > 0 }

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
                .weight(0.6f) // 与RankingTable的作品信息列权重保持一致
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

        if (isNarrowScreen) {
            // 窄屏模式：根据切换状态显示不同内容
            if (commentDisplayMode == 0) {
                // 分数条模式 - 只有Top50且有有效图表数据才显示曲线图
                if (comment.index <= 50 && hasValidChartData) {
                    // Top50且有有效数据，显示曲线图，宽度按三个固定列的比例分配
                    Box(
                        modifier = Modifier
                            .width(narrowScoreBarWidth)
                            .height(24.dp)
                    ) {
                        Row {
                            // Vote 图表 - 使用固定列宽度
                            Box(
                                modifier = Modifier
                                    .width(voteAvgWidth)
                                    .height(24.dp)
                            ) {
                                ScoreChart(
                                    dataList = comment.voteChartData,
                                    height = 24.dp,
                                    width = voteAvgWidth,
                                    color = RANKING_GREEN
                                )
                            }
                            
                            // Short 图表 - 使用固定列宽度
                            Box(
                                modifier = Modifier
                                    .width(shortAvgWidth)
                                    .height(24.dp)
                            ) {
                                ScoreChart(
                                    dataList = comment.shortChartData,
                                    height = 24.dp,
                                    width = shortAvgWidth,
                                    color = RANKING_BLUE
                                )
                            }
                            
                            // Long 图表 - 使用固定列宽度
                            Box(
                                modifier = Modifier
                                    .width(longAvgWidth)
                                    .height(24.dp)
                            ) {
                                ScoreChart(
                                    dataList = comment.longChartData,
                                    height = 24.dp,
                                    width = longAvgWidth,
                                    color = RANKING_RED
                                )
                            }
                        }
                    }
                } else {
                    // 显示简单总分条（排名50以后或无有效图表数据）
                    Box(
                        modifier = Modifier
                            .width(narrowScoreBarWidth)
                            .height(24.dp)
                            .padding(horizontal = 2.dp)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth(scoreRatio.toFloat().coerceAtMost(1f))
                                .height(24.dp)
                                .background(
                                    color = RANKING_RED,
                                    shape = RoundedCornerShape(
                                        topEnd = 12.dp,
                                        bottomEnd = 12.dp
                                    )
                                )
                        )
                        Text(
                            text = comment.total.toString(),
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
                }
            } else {
                // 详细分数模式 - 显示平均分
                Row(
                    modifier = Modifier.width(narrowScoreBarWidth),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(voteAvgWidth)
                            .height(24.dp)
                            .background(
                                color = RANKING_GREEN,
                                shape = RoundedCornerShape(4.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = String.format("%.1f", comment.voteAve),
                            fontFamily = sarasaBold,
                            fontSize = 13.sp, // 增大字号
                            color = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(shortAvgWidth)
                            .height(24.dp)
                            .background(
                                color = RANKING_BLUE,
                                shape = RoundedCornerShape(4.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = String.format("%.1f", comment.shortAve),
                            fontFamily = sarasaBold,
                            fontSize = 13.sp, // 增大字号
                            color = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(longAvgWidth)
                            .height(24.dp)
                            .background(
                                color = RANKING_RED,
                                shape = RoundedCornerShape(4.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = String.format("%.1f", comment.longAve),
                            fontFamily = sarasaBold,
                            fontSize = 13.sp, // 增大字号
                            color = Color.White
                        )
                    }
                }
            }
        } else {
            // 宽屏模式：同时显示分数条图表和详细平均分
            Row {
                // 分数条图表部分
                Box(
                    modifier = Modifier
                        .width(barWidth.dp)
                        .height(34.dp)
                        .background(Color.Blue.copy(alpha = 0.1f)) // 调试背景
                ) {
                    if (comment.index <= 50) {
                        Row {
                            // Vote 图表
                            if (comment.voteChartData.isNotEmpty()) {
                                Box(
                                    modifier = Modifier
                                        .width(voteAvgWidth) // 使用固定列宽度
                                        .height(34.dp)
                                        .background(Color.Yellow.copy(alpha = 0.3f)) // 调试背景
                                ) {
                                    ScoreChart(
                                        dataList = comment.voteChartData,
                                        height = 34.dp,
                                        width = voteAvgWidth, // 使用固定列宽度
                                        color = RANKING_GREEN
                                    )
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .width(voteAvgWidth) // 使用固定列宽度
                                        .height(34.dp)
                                        .background(Color.Red.copy(alpha = 0.5f))
                                )
                            }
                            
                            // Short 图表
                            if (comment.shortChartData.isNotEmpty()) {
                                Box(
                                    modifier = Modifier
                                        .width(shortAvgWidth) // 使用固定列宽度
                                        .height(34.dp)
                                        .background(Color.Cyan.copy(alpha = 0.3f)) // 调试背景
                                ) {
                                    ScoreChart(
                                        dataList = comment.shortChartData,
                                        height = 34.dp,
                                        width = shortAvgWidth, // 使用固定列宽度
                                        color = RANKING_BLUE
                                    )
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .width(shortAvgWidth) // 使用固定列宽度
                                        .height(34.dp)
                                        .background(Color.Red.copy(alpha = 0.5f))
                                )
                            }
                            
                            // Long 图表
                            if (comment.longChartData.isNotEmpty()) {
                                Box(
                                    modifier = Modifier
                                        .width(longAvgWidth) // 使用固定列宽度
                                        .height(34.dp)
                                        .background(Color.Magenta.copy(alpha = 0.3f)) // 调试背景
                                ) {
                                    ScoreChart(
                                        dataList = comment.longChartData,
                                        height = 34.dp,
                                        width = longAvgWidth, // 使用固定列宽度
                                        color = RANKING_RED
                                    )
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .width(longAvgWidth) // 使用固定列宽度
                                        .height(34.dp)
                                        .background(Color.Red.copy(alpha = 0.5f))
                                )
                            }
                        }
                    } else {
                        // 简化版分数条（排名50以后）
                        Row {
                            Box(
                                modifier = Modifier
                                    .width(voteAvgWidth) // 使用固定列宽度
                                    .height(34.dp)
                                    .background(color = RANKING_GREEN)
                            )
                            Box(
                                modifier = Modifier
                                    .width(shortAvgWidth) // 使用固定列宽度
                                    .height(34.dp)
                                    .background(color = RANKING_BLUE)
                            )
                            Box(
                                modifier = Modifier
                                    .width(longAvgWidth) // 使用固定列宽度
                                    .height(34.dp)
                                    .background(color = RANKING_RED)
                            )
                        }
                    }
                }
                
                // 总分文本
                Text(
                    text = comment.total.toString(),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = sarasaBold,
                    textAlign = TextAlign.End,
                    maxLines = 1,
                    modifier = Modifier
                        .width(36.dp)
                        .padding(end = 2.dp)
                )
                
                // 票选平均分列
                Box(
                    modifier = Modifier
                        .width(voteAvgWidth)
                        .height(34.dp)
                        .background(Color.Green.copy(alpha = 0.2f))
                        .padding(horizontal = 4.dp), // 增加水平内边距
                    contentAlignment = Alignment.CenterStart // 改为左对齐
                ) {
                    Text(
                        text = if (comment.voteAve > 0) "%.2f".format(comment.voteAve) else "---",
                        fontFamily = sarasaBold,
                        fontSize = 16.sp, // 增大字号
                        color = Color.White,
                        textAlign = TextAlign.Start // 改为左对齐
                    )
                }
                
                // 短评平均分列
                Box(
                    modifier = Modifier
                        .width(shortAvgWidth)
                        .height(34.dp)
                        .background(Color.Blue.copy(alpha = 0.2f))
                        .padding(horizontal = 4.dp), // 增加水平内边距
                    contentAlignment = Alignment.CenterStart // 改为左对齐
                ) {
                    Text(
                        text = if (comment.shortAve > 0) "%.2f".format(comment.shortAve) else "---",
                        fontFamily = sarasaBold,
                        fontSize = 16.sp, // 增大字号
                        color = Color.White,
                        textAlign = TextAlign.Start // 改为左对齐
                    )
                }
                
                // 长评平均分列
                Box(
                    modifier = Modifier
                        .width(longAvgWidth)
                        .height(34.dp)
                        .background(Color.Red.copy(alpha = 0.2f))
                        .padding(horizontal = 4.dp), // 增加水平内边距
                    contentAlignment = Alignment.CenterStart // 改为左对齐
                ) {
                    Text(
                        text = if (comment.longAve > 0) "%.2f".format(comment.longAve) else "---",
                        fontFamily = sarasaBold,
                        fontSize = 16.sp, // 增大字号
                        color = Color.White,
                        textAlign = TextAlign.Start // 改为左对齐
                    )
                }
            }
        }
    }
}
