package com.madsam.otora.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.madsam.otora.core.theme.RANKING_RED
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular

// 列宽度类型枚举
enum class ColumnWidthType(val measureText: String) {
    THREE_DIGIT_INT("000"),           // 三位整数
    TWO_DECIMAL("000.00"),            // 带两位小数
    ONE_DECIMAL("000.0"),             // 带一位小数
}

// 通用排行数据接口
interface RankingItem {
    val rank: Int
    val title: String
    val artist: String
    val score: Number  // 支持Int和Double
    val extraData: Number?  // 额外数据列（如评价数）
    val avgScore: Double?   // 平均分（可选，用于背景色）
    val medianScore: Double? // 中位数（可选，用于背景色）
    // 排名变化支持
    val rankChange: Int? get() = null  // 排名变化量，正数表示上升，负数表示下降
    val compareRank: Int? get() = null // 对比时间点的排名
    val compareScore: Number? get() = null // 对比时间点的分数
}

// 排行榜表格配置
data class RankingTableConfig(
    val title: String,
    val subtitle: String,
    val scoreColumnName: String = "分数条",
    val extraColumnName: String? = null,  // 额外列名称，null表示不显示
    val avgColumnName: String? = null,     // 平均分列名称
    val medianColumnName: String? = null,  // 中位数列名称
    val scoreWidthType: ColumnWidthType = ColumnWidthType.THREE_DIGIT_INT,
    val extraWidthType: ColumnWidthType = ColumnWidthType.THREE_DIGIT_INT,
    val avgWidthType: ColumnWidthType = ColumnWidthType.TWO_DECIMAL,
    val medianWidthType: ColumnWidthType = ColumnWidthType.TWO_DECIMAL,
    val enableNarrowToggle: Boolean = false, // 是否启用窄屏切换
    val maxItems: Int = 50
)

@Composable
fun RankingTable(
    items: List<RankingItem>,
    config: RankingTableConfig,
    modifier: Modifier = Modifier,
    narrowMode: Int = 0
) {
    // 屏幕宽度检测
    val configuration = androidx.compose.ui.platform.LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val isNarrowScreen = screenWidthDp < 600
    
    // 测量各列宽度
    var extraWidth by remember { mutableStateOf(50.dp) }
    var avgWidth by remember { mutableStateOf(60.dp) }
    var medianWidth by remember { mutableStateOf(60.dp) }
    
    val density = LocalDensity.current
    
    // 计算分数条在窄屏模式下的宽度
    val narrowScoreBarWidth = when {
        config.extraColumnName != null && config.avgColumnName != null && config.medianColumnName != null -> 
            extraWidth + avgWidth + medianWidth
        config.extraColumnName != null -> extraWidth
        else -> 100.dp
    }
    
    // 计算最大分数用于分数条比例 - 考虑当前分数和对比分数
    val currentMaxScore = items.maxOfOrNull { it.score.toDouble() } ?: 1.0
    val compareMaxScore = items.mapNotNull { it.compareScore?.toDouble() }.maxOfOrNull { it } ?: 0.0
    val maxScore = maxOf(currentMaxScore, compareMaxScore)
    
    Column(modifier = modifier) {
        // 隐藏的测量容器
        Box(modifier = Modifier
            .size(0.dp)
            .requiredWidth(500.dp)
            .requiredHeight(100.dp)
        ) {
            // 测量额外列宽度
            if (config.extraColumnName != null) {
                Text(
                    text = config.extraWidthType.measureText,
                    fontFamily = sarasaRegular,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        extraWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
            }
            // 测量平均分宽度
            if (config.avgColumnName != null) {
                Text(
                    text = config.avgWidthType.measureText,
                    fontFamily = sarasaRegular,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        avgWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
            }
            // 测量中位数宽度
            if (config.medianColumnName != null) {
                Text(
                    text = config.medianWidthType.measureText,
                    fontFamily = sarasaRegular,
                    fontSize = 14.sp,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        medianWidth = with(density) {
                            coordinates.size.width.toDp() + 8.dp
                        }
                    }
                )
            }
        }
        
        // 表格标题
        Text(
            text = config.title,
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
            text = config.subtitle,
            fontFamily = sarasaRegular,
            fontSize = 12.sp,
            color = Color.White,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 16.dp, vertical = 4.dp)
        )

        // 表格头部
        Row(
            modifier = Modifier
                .background(BG_DARK_GRAY)
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 2.dp)
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
            
            if (isNarrowScreen && config.enableNarrowToggle) {
                if (narrowMode == 0) {
                    // 只显示分数条
                    Text(
                        text = config.scoreColumnName,
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(narrowScoreBarWidth)
                    )
                } else {
                    // 显示其他列
                    config.extraColumnName?.let { name ->
                        Text(
                            text = name,
                            fontFamily = sarasaBold,
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.End,
                            modifier = Modifier.width(extraWidth)
                        )
                    }
                    config.avgColumnName?.let { name ->
                        Text(
                            text = name,
                            fontFamily = sarasaBold,
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.End,
                            modifier = Modifier.width(avgWidth)
                        )
                    }
                    config.medianColumnName?.let { name ->
                        Text(
                            text = name,
                            fontFamily = sarasaBold,
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.End,
                            modifier = Modifier.width(medianWidth)
                        )
                    }
                }
            } else {
                // 正常模式，显示所有列
                Text(
                    text = config.scoreColumnName,
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(0.6f)
                )
                config.extraColumnName?.let { name ->
                    Text(
                        text = name,
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(extraWidth)
                    )
                }
                config.avgColumnName?.let { name ->
                    Text(
                        text = name,
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(avgWidth)
                    )
                }
                config.medianColumnName?.let { name ->
                    Text(
                        text = name,
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End,
                        modifier = Modifier.width(medianWidth)
                    )
                }
            }
        }

        // 数据列表
        LazyColumn(
            modifier = Modifier.clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
        ) {
            itemsIndexed(items.take(config.maxItems)) { index, item ->
                RankingTableRow(
                    item = item,
                    index = index,
                    maxScore = maxScore,
                    config = config,
                    isNarrowScreen = isNarrowScreen,
                    narrowMode = narrowMode,
                    extraWidth = extraWidth,
                    avgWidth = avgWidth,
                    medianWidth = medianWidth,
                    narrowScoreBarWidth = narrowScoreBarWidth
                )
            }
            
            if (items.size > config.maxItems) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(if (config.maxItems % 2 == 0) BG_DARK_GRAY else Color.Black)
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "还有 ${items.size - config.maxItems} 个作品..",
                            fontFamily = sarasaRegular,
                            color = TEXT_GRAY,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun RankingTableRow(
    item: RankingItem,
    index: Int,
    maxScore: Double,
    config: RankingTableConfig,
    isNarrowScreen: Boolean,
    narrowMode: Int,
    extraWidth: Dp,
    avgWidth: Dp,
    medianWidth: Dp,
    narrowScoreBarWidth: Dp
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val scoreRatio = if (maxScore > 0) item.score.toDouble() / maxScore else 0.0
    val rankColor = Color.White

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 排名列 - 包含排名变化指示器（常显）
        Column(
            modifier = Modifier
                .width(50.dp)
                .padding(vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 上方：排名变化指示器和变化量
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 排名变化指示器（常显）
                val change = item.rankChange
                when {
                    change != null && change > 0 -> {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Rank Up",
                            tint = Color.Green,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = change.toString(),
                            fontFamily = sarasaRegular,
                            fontSize = 10.sp,
                            color = Color.Green
                        )
                    }
                    change != null && change < 0 -> {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Rank Down",
                            tint = Color.Red,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            text = (-change).toString(),
                            fontFamily = sarasaRegular,
                            fontSize = 10.sp,
                            color = Color.Red
                        )
                    }
                    change != null && change == 0 -> {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Rank Same",
                            tint = Color.Gray,
                            modifier = Modifier.size(12.dp)
                        )
                        // 持平时不显示变化量
                    }
                    else -> {
                        // 没有对比数据时显示占位空间
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
            
            // 下方：当前排名
            Text(
                text = item.rank.toString(),
                fontFamily = sarasaBold,
                fontSize = 16.sp,
                color = rankColor,
                textAlign = TextAlign.Center
            )
        }

        // 作品信息列
        Column(
            modifier = Modifier
                .weight(0.6f)
                .padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = item.title,
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = item.artist,
                fontFamily = sarasaRegular,
                fontSize = 12.sp,
                color = TEXT_GRAY,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }

        if (isNarrowScreen && config.enableNarrowToggle && narrowMode == 0) {
            // 窄屏模式：只显示分数列 - 包含主分数条和对比分数条
            Column(
                modifier = Modifier
                    .width(narrowScoreBarWidth)
                    .padding(horizontal = 2.dp)
            ) {
                // 主分数条
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                ) {
                    Box {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth(scoreRatio.toFloat().coerceAtMost(1f))
                                .height(20.dp)
                                .background(
                                    color = RANKING_RED,
                                    shape = RoundedCornerShape(
                                        topEnd = 10.dp,
                                        bottomEnd = 10.dp
                                    )
                                )
                        )
                        Text(
                            text = formatScore(item.score, config.scoreWidthType),
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
                
                // 对比分数条（如果有对比数据）
                item.compareScore?.let { compareScore ->
                    val compareRatio = if (maxScore > 0) compareScore.toDouble() / maxScore else 0.0
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(14.dp)
                            .padding(top = 2.dp)
                    ) {
                        Box {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth(compareRatio.toFloat().coerceAtMost(1f))
                                    .height(14.dp)
                                    .background(
                                        color = RANKING_BLUE,
                                        shape = RoundedCornerShape(
                                            topEnd = 7.dp,
                                            bottomEnd = 7.dp
                                        )
                                    )
                            )
                            Text(
                                text = formatScore(compareScore, config.scoreWidthType),
                                fontFamily = sarasaRegular,
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.8f),
                                overflow = TextOverflow.Visible,
                                maxLines = 1,
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                                    .padding(end = 2.dp)
                            )
                        }
                    }
                }
            }
        } else {
            // 正常模式或窄屏其他列模式
            if (!isNarrowScreen || !config.enableNarrowToggle) {
                // 分数条列（非窄屏模式） - 包含主分数条和对比分数条
                Column(
                    modifier = Modifier
                        .weight(0.4f)
                        .padding(horizontal = 2.dp)
                ) {
                    // 主分数条
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .padding(top = 2.dp)
                    ) {
                        Box {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth(scoreRatio.toFloat().coerceAtMost(1f))
                                    .height(20.dp)
                                    .background(
                                        color = RANKING_RED,
                                        shape = RoundedCornerShape(
                                            topEnd = 10.dp,
                                            bottomEnd = 10.dp
                                        )
                                    )
                            )
                            Text(
                                text = formatScore(item.score, config.scoreWidthType),
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
                    
                    // 对比分数条（如果有对比数据）
                    item.compareScore?.let { compareScore ->
                        val compareRatio = if (maxScore > 0) compareScore.toDouble() / maxScore else 0.0
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(14.dp)
                        ) {
                            Box {
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth(compareRatio.toFloat().coerceAtMost(1f))
                                        .height(14.dp)
                                        .background(
                                            color = RANKING_BLUE,
                                            shape = RoundedCornerShape(
                                                topEnd = 7.dp,
                                                bottomEnd = 7.dp
                                            )
                                        )
                                )
                                Text(
                                    text = formatScore(compareScore, config.scoreWidthType),
                                    fontFamily = sarasaRegular,
                                    fontSize = 11.sp,
                                    color = Color.White.copy(alpha = 0.8f),
                                    overflow = TextOverflow.Visible,
                                    maxLines = 1,
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .padding(end = 2.dp)
                                )
                            }
                        }
                    }
                }
            }

            // 额外数据列
            if (config.extraColumnName != null) {
                val extraValue = item.extraData
                Text(
                    text = if (extraValue != null) {
                        formatScore(extraValue, config.extraWidthType)
                    } else {
                        "---"
                    },
                    fontFamily = sarasaBold,
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .width(extraWidth)
                        .padding(vertical = 4.dp, horizontal = 2.dp)
                )
            }

            // 平均分列
            if (config.avgColumnName != null) {
                val avgValue = item.avgScore
                Box(
                    modifier = Modifier
                        .width(avgWidth)
                        .fillMaxHeight()
                        .background(
                            if (avgValue != null && avgValue > 0)
                                Color(red = (avgValue / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                            else
                                Color.Transparent
                        )
                        .padding(horizontal = 2.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = if (avgValue != null) {
                            formatScore(avgValue, config.avgWidthType)
                        } else {
                            "---"
                        },
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End
                    )
                }
            }

            // 中位数列
            if (config.medianColumnName != null) {
                val medianValue = item.medianScore
                Box(
                    modifier = Modifier
                        .width(medianWidth)
                        .fillMaxHeight()
                        .background(
                            if (medianValue != null && medianValue > 0)
                                Color(red = (medianValue / 1000.0).toFloat().coerceIn(0f, 1f), green = 0f, blue = 0f)
                            else
                                Color.Transparent
                        )
                        .padding(horizontal = 2.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = if (medianValue != null) {
                            formatScore(medianValue, config.medianWidthType)
                        } else {
                            "---"
                        },
                        fontFamily = sarasaBold,
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

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
                    String.format("%.1f", doubleValue)
                } else {
                    String.format("%.2f", doubleValue)
                }
            } else "---"
        ColumnWidthType.ONE_DECIMAL ->
            if (doubleValue > 0) {
                // 显示一位小数
                if (doubleValue == 1000.0) {
                    doubleValue.toInt().toString()
                } else {
                    String.format("%.1f", doubleValue)
                }
            } else "---"
    }
}