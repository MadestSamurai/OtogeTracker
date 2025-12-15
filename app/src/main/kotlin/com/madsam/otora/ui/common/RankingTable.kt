package com.madsam.otora.ui.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.icon.Fa
import com.madsam.otora.core.icon.Filled
import com.madsam.otora.core.icon.fa.`Arrow-down`
import com.madsam.otora.core.icon.fa.`Arrow-right`
import com.madsam.otora.core.icon.fa.`Arrow-up`
import com.madsam.otora.core.theme.BG_DARK_GRAY
import com.madsam.otora.core.theme.RANKING_BLUE
import com.madsam.otora.core.theme.RANKING_RED
import com.madsam.otora.core.theme.TEXT_GRAY
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.theme.sarasaRegular
import com.madsam.otora.core.utils.ScreenUtil
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import java.util.Locale

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
    val maxItems: Int = 50,
    val allowNegativeScore: Boolean = false, // 是否允许显示负数分数
    val previousPageTitle: String? = null,  // 上一页标题，null表示没有上一页
    val nextPageTitle: String? = null       // 下一页标题，null表示没有下一页
)

@Composable
fun RankingTable(
    items: List<RankingItem>,
    config: RankingTableConfig,
    narrowMode: Int = 0,
    showTitle: Boolean = true,
    showHeader: Boolean = true,
    listState: androidx.compose.foundation.lazy.LazyListState = androidx.compose.foundation.lazy.rememberLazyListState(),
    searchText: String = "",
    onNavigateToPrevious: () -> Unit = {},
    onNavigateToNext: () -> Unit = {}
) {
    // 屏幕宽度检测
    val density = LocalDensity.current
    val windowInfo = LocalWindowInfo.current
    val screenWidthDp = with(density) {
        windowInfo.containerSize.width.toDp()
    }

    val useNavigationRail = ScreenUtil.shouldUseNavigationRail()
    val isNarrowScreen = screenWidthDp.value < 600
    val colorScheme = androidx.compose.material3.MaterialTheme.colorScheme
    
    // 标题区域可见性状态
    var isTitleVisible by remember { mutableStateOf(true) }
    var lastScrollIndex by remember { mutableIntStateOf(0) }
    var lastScrollOffset by remember { mutableIntStateOf(0) }
    
    // 监听滚动状态来控制标题显示/隐藏
    LaunchedEffect(listState) {
        snapshotFlow { 
            listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset 
        }
        .distinctUntilChanged()
        .filter { listState.isScrollInProgress }
        .collect { (currentIndex, currentOffset) ->
            val scrollingDown = when {
                currentIndex > lastScrollIndex -> true
                currentIndex < lastScrollIndex -> false
                else -> currentOffset > lastScrollOffset
            }
            
            // 向下滚动时隐藏标题（但需要滚动超过一定距离）
            if (scrollingDown && currentIndex > 0) {
                isTitleVisible = false
            } 
            // 向上滚动时显示标题
            else if (!scrollingDown || currentIndex == 0) {
                isTitleVisible = true
            }
            
            lastScrollIndex = currentIndex
            lastScrollOffset = currentOffset
        }
    }
    
    // 测量各列宽度
    var extraWidth by remember { mutableStateOf(50.dp) }
    var avgWidth by remember { mutableStateOf(60.dp) }
    var medianWidth by remember { mutableStateOf(60.dp) }
    
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
    
    Column(modifier = Modifier.fillMaxSize()) {
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
        
        // 表格标题和副标题（可选）- 带滚动收缩效果
        if (showTitle) {
            AnimatedVisibility(
                visible = isTitleVisible,
                enter = expandVertically(
                    animationSpec = tween(durationMillis = 200),
                    expandFrom = Alignment.Top
                ),
                exit = shrinkVertically(
                    animationSpec = tween(durationMillis = 200),
                    shrinkTowards = Alignment.Top
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .windowInsetsPadding(
                            WindowInsets.displayCutout.only(
                                WindowInsetsSides.Horizontal
                            )
                        )
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 主标题行（带左右箭头）
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                    // 左箭头（上一页）
                    if (config.previousPageTitle != null) {
                        IconButton(
                            onClick = onNavigateToPrevious,
                            modifier = Modifier.size(40.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = rememberVectorPainter(image = Filled.ChevronLeft),
                                    contentDescription = "上一页",
                                    tint = colorScheme.onSurface,
                                    modifier = Modifier.size(12.dp)
                                )
                                Text(
                                    text = config.previousPageTitle,
                                    fontFamily = sarasaRegular,
                                    fontSize = 12.sp,
                                    color = TEXT_GRAY,
                                    maxLines = 1
                                )
                            }
                        }
                    } else {
                        Spacer(modifier = Modifier.size(40.dp))
                    }
                    
                        // 中间主标题
                        Text(
                            text = config.title,
                            fontFamily = sarasaBold,
                            fontSize = 20.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                        
                        // 右箭头（下一页）
                        if (config.nextPageTitle != null) {
                            IconButton(
                                onClick = onNavigateToNext,
                                modifier = Modifier.size(40.dp)
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        painter = rememberVectorPainter(image = Filled.ChevronRight),
                                        contentDescription = "下一页",
                                        tint = colorScheme.onSurface,
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Text(
                                        text = config.nextPageTitle,
                                        fontFamily = sarasaRegular,
                                        fontSize = 12.sp,
                                        color = TEXT_GRAY,
                                        maxLines = 1
                                    )
                                }
                            }
                        } else {
                            Spacer(modifier = Modifier.size(40.dp))
                        }
                    }
                    
                    // 副标题
                    Text(
                        text = config.subtitle,
                        fontFamily = sarasaRegular,
                        fontSize = 12.sp,
                        color = TEXT_GRAY,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        // 表格头部（可选）
        if (showHeader) {
            Row(
            modifier = Modifier
                .background(BG_DARK_GRAY)
                .fillMaxWidth()
                .windowInsetsPadding(
                    WindowInsets.displayCutout.only(
                        WindowInsetsSides.Horizontal
                    )
                )
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
        }

        // 数据列表
        LazyColumn(
            state = listState,
            modifier = Modifier.clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
        ) {
            if (items.isEmpty()) {
                // 列表为空时显示提示信息
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black)
                            .windowInsetsPadding(
                                WindowInsets.displayCutout.only(
                                    WindowInsetsSides.Horizontal
                                )
                            )
                            .padding(vertical = 48.dp, horizontal = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "暂无数据",
                            fontFamily = sarasaBold,
                            fontSize = 18.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "当前筛选条件下没有符合的作品",
                            fontFamily = sarasaRegular,
                            fontSize = 14.sp,
                            color = TEXT_GRAY,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
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
                        narrowScoreBarWidth = narrowScoreBarWidth,
                        searchText = searchText
                    )
                }
                
                if (items.size > config.maxItems) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(if (config.maxItems % 2 == 0) BG_DARK_GRAY else Color.Black)
                                .windowInsetsPadding(
                                    WindowInsets.displayCutout.only(
                                        WindowInsetsSides.Horizontal
                                    )
                                )
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

            // 底部安全区域，让用户滑动到底部时有额外的空间
            item(key = "bottom_spacer") {
                Spacer(
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
}

/**
 * 创建带高亮的文本 AnnotatedString
 * @param text 完整文本
 * @param searchText 要高亮的搜索文本
 * @param highlightColor 高亮背景色
 * @return AnnotatedString 带高亮的文本
 */
private fun buildHighlightedText(
    text: String,
    searchText: String,
    highlightColor: Color = Color(0xFFCC0000)
): AnnotatedString {
    if (searchText.isEmpty()) {
        return AnnotatedString(text)
    }
    
    return buildAnnotatedString {
        var currentIndex = 0
        val lowerText = text.lowercase()
        val lowerSearch = searchText.lowercase()
        
        while (currentIndex < text.length) {
            val matchIndex = lowerText.indexOf(lowerSearch, currentIndex)
            
            if (matchIndex == -1) {
                // 没有更多匹配，添加剩余文本
                append(text.substring(currentIndex))
                break
            }
            
            // 添加匹配前的普通文本
            if (matchIndex > currentIndex) {
                append(text.substring(currentIndex, matchIndex))
            }
            
            // 添加高亮的匹配文本
            withStyle(
                style = SpanStyle(
                    background = highlightColor,
                    color = Color.White
                )
            ) {
                append(text.substring(matchIndex, matchIndex + searchText.length))
            }
            
            currentIndex = matchIndex + searchText.length
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
    narrowScoreBarWidth: Dp,
    searchText: String = ""
) {
    val backgroundColor = if (index % 2 == 0) BG_DARK_GRAY else Color.Black
    val scoreRatio = if (maxScore > 0) item.score.toDouble() / maxScore else 0.0
    val rankColor = Color.White

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .background(backgroundColor)
            .windowInsetsPadding(
                WindowInsets.displayCutout.only(
                    WindowInsetsSides.Horizontal
                )
            ),
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
                            imageVector = Fa.`Arrow-up`,
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
                            imageVector = Fa.`Arrow-down`,
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
                    change != null -> {
                        Icon(
                            imageVector = Fa.`Arrow-right`,
                            contentDescription = "Rank Same",
                            tint = Color.Gray,
                            modifier = Modifier.size(12.dp)
                        )
                        // 持平时不显示变化量
                    }
                    else -> {}
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
                text = buildHighlightedText(item.title, searchText),
                fontFamily = sarasaBold,
                fontSize = 14.sp,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = buildHighlightedText(item.artist, searchText),
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
                    .padding(top = 1.dp)
            ) {
                // 主分数条
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
                                    color = RANKING_RED,
                                    shape = RoundedCornerShape(
                                        topEnd = 10.dp,
                                        bottomEnd = 10.dp
                                    )
                                )
                        )
                        Text(
                            text = formatScore(item.score, config.scoreWidthType, config.allowNegativeScore),
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
                            .height(13.dp)
                            .padding(horizontal = 2.dp)
                    ) {
                        Box {
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth(compareRatio.toFloat().coerceAtMost(1f))
                                    .height(13.dp)
                                    .background(
                                        color = RANKING_BLUE,
                                        shape = RoundedCornerShape(
                                            topEnd = 7.dp,
                                            bottomEnd = 7.dp
                                        )
                                    )
                            )
                            Text(
                                text = formatScore(compareScore, config.scoreWidthType, config.allowNegativeScore),
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
                                text = formatScore(item.score, config.scoreWidthType, config.allowNegativeScore),
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
                                .height(13.dp)
                        ) {
                            Box {
                                Spacer(
                                    modifier = Modifier
                                        .fillMaxWidth(compareRatio.toFloat().coerceAtMost(1f))
                                        .height(13.dp)
                                        .background(
                                            color = RANKING_BLUE,
                                            shape = RoundedCornerShape(
                                                topEnd = 7.dp,
                                                bottomEnd = 7.dp
                                            )
                                        )
                                )
                                Text(
                                    text = formatScore(compareScore, config.scoreWidthType, config.allowNegativeScore),
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
                        formatScore(extraValue, config.extraWidthType, config.allowNegativeScore)
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
                    String.format(Locale.US,"%.1f", doubleValue)
                } else {
                    String.format(Locale.US,"%.2f", doubleValue)
                }
            } else "---"
        ColumnWidthType.ONE_DECIMAL ->
            if (doubleValue > 0 || (allowNegative && doubleValue != 0.0)) {
                // 显示一位小数
                if (doubleValue == 1000.0) {
                    doubleValue.toInt().toString()
                } else {
                    String.format(Locale.US,"%.1f", doubleValue)
                }
            } else "---"
    }
}

/**
 * 用于截图的RankingTable版本，使用Column代替LazyColumn，
 * 避免LazyColumn在capturable中无法正确测量高度导致的空白区域。
 */
@Composable
fun RankingTableForCapture(
    items: List<RankingItem>,
    config: RankingTableConfig,
    showTitle: Boolean = true,
    showHeader: Boolean = true,
    globalMaxScore: Double? = null  // 全局最大分数，用于多批次截图时保持分数条比例一致
) {
    // 如果提供了全局最大值则使用，否则计算当前items的最大值
    val maxScore = globalMaxScore ?: run {
        val currentMaxScore = items.maxOfOrNull { it.score.toDouble() } ?: 1.0
        val compareMaxScore = items.mapNotNull { it.compareScore?.toDouble() }.maxOfOrNull { it } ?: 0.0
        maxOf(currentMaxScore, compareMaxScore)
    }
    
    // 固定列宽（用于截图）
    val extraWidth = 60.dp
    val avgWidth = 70.dp
    val medianWidth = 70.dp
    
    Column(modifier = Modifier.fillMaxWidth()) {
        // 表格标题和副标题（可选）
        if (showTitle) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 主标题
                Text(
                    text = config.title,
                    fontFamily = sarasaBold,
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                
                // 副标题
                Text(
                    text = config.subtitle,
                    fontFamily = sarasaRegular,
                    fontSize = 12.sp,
                    color = TEXT_GRAY,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        // 表格头部（可选）
        if (showHeader) {
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

        // 数据列表 - 使用Column而不是LazyColumn
        Column(
            modifier = Modifier.clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
        ) {
            if (items.isEmpty()) {
                // 列表为空时显示提示信息
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .padding(vertical = 48.dp, horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "暂无数据",
                        fontFamily = sarasaBold,
                        fontSize = 18.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "当前筛选条件下没有符合的作品",
                        fontFamily = sarasaRegular,
                        fontSize = 14.sp,
                        color = TEXT_GRAY,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                items.take(config.maxItems).forEachIndexed { index, item ->
                    RankingTableRow(
                        item = item,
                        index = index,
                        maxScore = maxScore,
                        config = config,
                        isNarrowScreen = false,
                        narrowMode = 0,
                        extraWidth = extraWidth,
                        avgWidth = avgWidth,
                        medianWidth = medianWidth,
                        narrowScoreBarWidth = 100.dp
                    )
                }
                
                if (items.size > config.maxItems) {
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