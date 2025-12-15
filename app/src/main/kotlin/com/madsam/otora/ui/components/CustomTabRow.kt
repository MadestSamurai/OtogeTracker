package com.madsam.otora.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFold
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastMap
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private val HorizontalTextPadding = 16.dp

@Composable
fun CustomTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = Transparent,
    contentColor: Color = Color.Unspecified,
    indicator: @Composable (tabPositions: List<CustomTabPosition>) -> Unit = @Composable { tabPositions ->
        val colorScheme = MaterialTheme.colorScheme
        if (tabPositions.isNotEmpty()) {
            val safeIndex = selectedTabIndex.coerceIn(0, tabPositions.lastIndex)
            Box(
                Modifier
                    .tabIndicatorOffset(tabPositions[safeIndex])
                    .padding(4.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .fillMaxHeight()
                    .background(colorScheme.primaryContainer)
            )
        }
    },
    divider: @Composable () -> Unit = @Composable { },
    tabs: @Composable (selectedTabIndex: Int) -> Unit
) {
    Surface(
        modifier = modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally) // 修改这里
            .selectableGroup(),
        color = containerColor,
        contentColor = contentColor,
        tonalElevation = 8.dp,
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(50.dp)
    ) {
        SubcomposeLayout(
            modifier = Modifier.wrapContentWidth(align = Alignment.CenterHorizontally)
            ) { constraints ->
            val tabRowWidth = constraints.maxWidth
            val tabMeasurables = subcompose(TabSlots.Tabs) {
                tabs(selectedTabIndex.coerceAtLeast(0))  // 确保传递给 tabs 的索引不为负
            }
            val tabCount = tabMeasurables.size

            // 计算每个tab的实际内容宽度
            val tabContentWidths = tabMeasurables.fastMap { measurable ->
                measurable.maxIntrinsicWidth(constraints.maxHeight)
            }

            val horizontalPaddingPx = HorizontalTextPadding.toPx()
            // 添加水平padding
            val totalContentWidth =
                tabContentWidths.sum() + (HorizontalTextPadding.toPx() * 2 * tabCount)

            // 计算实际tab宽度（以像素为单位）
            val tabWidths = if (totalContentWidth <= tabRowWidth) {
                tabContentWidths.map { contentWidth ->
                    (contentWidth + horizontalPaddingPx * 2).toInt()
                }
            } else {
                List(tabCount) { (tabRowWidth / tabCount) }
            }

            val tabRowHeight = tabMeasurables.fastFold(initial = 0) { max, curr ->
                maxOf(curr.maxIntrinsicHeight(0), max)
            }

            // 使用新的tabWidths测量tabs
            val tabPlaceables = tabMeasurables.mapIndexed { index, measurable ->
                measurable.measure(
                    constraints.copy(
                        minWidth = tabWidths[index],
                        maxWidth = tabWidths[index],
                        minHeight = tabRowHeight,
                        maxHeight = tabRowHeight,
                    )
                )
            }

            // 计算每个tab的位置
            var currentX = 0
            val tabPositions = tabWidths.map { width ->
                val position = CustomTabPosition(
                    left = currentX.toDp(),
                    width = width.toDp(),
                    contentWidth = (width - HorizontalTextPadding.toPx() * 2).toDp()
                )
                currentX += width
                position
            }

            layout(currentX, tabRowHeight) {
                // 放置indicator
                subcompose(TabSlots.Indicator) { indicator(tabPositions) }
                    .fastForEach {
                        it.measure(Constraints.fixed(tabRowWidth, tabRowHeight)).placeRelative(0, 0)
                    }

                // 放置tabs
                var x = 0
                tabPlaceables.forEachIndexed { index, placeable ->
                    placeable.placeRelative(x, 0)
                    x += tabWidths[index]
                }

                // 放置divider
                subcompose(TabSlots.Divider, divider).fastForEach {
                    val placeable = it.measure(constraints.copy(minHeight = 0))
                    placeable.placeRelative(0, tabRowHeight - placeable.height)
                }
            }
        }
    }
}

private enum class TabSlots {
    Tabs,
    Divider,
    Indicator
}

class CustomTabPosition internal constructor(
    val left: Dp,
    val width: Dp,
    private val contentWidth: Dp
) {

    private val right: Dp
        get() = left + width

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TabPosition) return false

        if (left != other.left) return false
        if (width != other.width) return false
        if (contentWidth != other.contentWidth) return false

        return true
    }

    override fun hashCode(): Int {
        var result = left.hashCode()
        result = 31 * result + width.hashCode()
        result = 31 * result + contentWidth.hashCode()
        return result
    }

    override fun toString(): String {
        return "TabPosition(left=$left, right=$right, width=$width, contentWidth=$contentWidth)"
    }
}

fun Modifier.tabIndicatorOffset(currentTabPosition: CustomTabPosition): Modifier =
    composed(
        inspectorInfo =
        debugInspectorInfo {
            name = "tabIndicatorOffset"
            value = currentTabPosition
        }
    ) {
        val currentTabWidth by
        animateDpAsState(
            targetValue = currentTabPosition.width,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            ),
            label = "tabIndicatorWidth"
        )
        val indicatorOffset by
        animateDpAsState(
            targetValue = currentTabPosition.left,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioNoBouncy,
                stiffness = Spring.StiffnessMedium
            ),
            label = "tabIndicatorOffset"
        )
        fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
            .offset { IntOffset(x = indicatorOffset.roundToPx(), y = 0) }
            .width(currentTabWidth)

    }

@Composable
fun CustomScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = Transparent,
    contentColor: Color = Color.Unspecified,
    containerWidthDp: Dp? = null,
    indicator: @Composable (tabPositions: List<CustomTabPosition>) -> Unit = @Composable { tabPositions ->
        val colorScheme = MaterialTheme.colorScheme
        if (tabPositions.isNotEmpty()) {
            val safeIndex = selectedTabIndex.coerceIn(0, tabPositions.lastIndex)
            Box(
                Modifier
                    .tabIndicatorOffset(tabPositions[safeIndex])
                    .padding(4.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .fillMaxHeight()
                    .background(colorScheme.primaryContainer)
            )
        }
    },
    divider: @Composable () -> Unit = @Composable { },
    tabs: @Composable (selectedTabIndex: Int) -> Unit
) {
    Surface(
        modifier = modifier.selectableGroup(),
        color = containerColor,
        contentColor = contentColor,
        tonalElevation = 8.dp,
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(50.dp)
    ) {
        val scrollState = rememberScrollState()
        val coroutineScope = rememberCoroutineScope()
        val density = LocalDensity.current
        
        // 使用状态来保存实际计算出的tab宽度
        val (actualTabWidth, setActualTabWidth) = remember { mutableIntStateOf(0) }
        
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .horizontalScroll(scrollState)
        ) {
            SubcomposeLayout { constraints ->
                val tabMeasurables = subcompose(TabSlots.Tabs) {
                    tabs(selectedTabIndex.coerceAtLeast(0))
                }

                val tabCount = tabMeasurables.size
                if (tabCount == 0) {
                    return@SubcomposeLayout layout(0, 0) {}
                }

                // 计算每个tab的最大内容宽度
                val maxContentWidth = tabMeasurables.maxOfOrNull { measurable ->
                    measurable.maxIntrinsicWidth(constraints.maxHeight)
                } ?: 0

                val horizontalPaddingPx = HorizontalTextPadding.toPx()
                
                // 所有tab使用相同的宽度：最大内容宽度 + padding
                val uniformTabWidth = (maxContentWidth + horizontalPaddingPx * 2).toInt()
                
                // 更新实际的tab宽度
                setActualTabWidth(uniformTabWidth)

                val tabRowHeight = tabMeasurables.fastFold(initial = 0) { max, curr ->
                    maxOf(curr.maxIntrinsicHeight(0), max)
                }

                // 计算总宽度
                val totalWidth = uniformTabWidth * tabCount

                // 测量tabs - 所有tab使用相同宽度
                val tabPlaceables = tabMeasurables.map { measurable ->
                    measurable.measure(
                        constraints.copy(
                            minWidth = uniformTabWidth,
                            maxWidth = uniformTabWidth,
                            minHeight = tabRowHeight,
                            maxHeight = tabRowHeight,
                        )
                    )
                }

                // 计算每个tab的位置 - 简单的等宽排列
                val tabPositions = (0 until tabCount).map { index ->
                    CustomTabPosition(
                        left = (index * uniformTabWidth).toDp(),
                        width = uniformTabWidth.toDp(),
                        contentWidth = (uniformTabWidth - horizontalPaddingPx * 2).toDp()
                    )
                }

                layout(totalWidth, tabRowHeight) {
                    // 放置indicator
                    subcompose(TabSlots.Indicator) { indicator(tabPositions) }
                        .fastForEach {
                            it.measure(Constraints.fixed(totalWidth, tabRowHeight)).placeRelative(0, 0)
                        }

                    // 放置tabs - 简单的等宽排列
                    tabPlaceables.forEachIndexed { index, placeable ->
                        placeable.placeRelative(index * uniformTabWidth, 0)
                    }

                    // 放置divider
                    subcompose(TabSlots.Divider, divider).fastForEach {
                        val placeable = it.measure(constraints.copy(minHeight = 0))
                        placeable.placeRelative(0, tabRowHeight - placeable.height)
                    }
                }
            }
        }
        
        // 精确的自动滚动逻辑 - 让选中的tab居中显示
        LaunchedEffect(selectedTabIndex, actualTabWidth, containerWidthDp) {
            if (selectedTabIndex >= 0 && actualTabWidth > 0) {
                coroutineScope.launch {
                    // 延迟确保布局完成
                    delay(50)
                    
                    if (scrollState.maxValue > 0) {
                        // 计算选中tab的中心位置
                        val tabCenterPosition = selectedTabIndex * actualTabWidth.toFloat() + actualTabWidth / 2f
                        
                        // 使用传入的容器宽度，如果没有则使用默认估算值
                        val containerWidth = containerWidthDp?.let { 
                            with(density) { it.toPx() } 
                        } ?: with(density) { 300.dp.toPx() } // 回退到默认值
                        
                        // 计算目标滚动位置：让选中tab的中心对齐到容器中心
                        val targetPosition = (tabCenterPosition - containerWidth / 2f)
                            .coerceIn(0f, scrollState.maxValue.toFloat())
                        
                        scrollState.animateScrollTo(targetPosition.toInt())
                    }
                }
            }
        }
    }
}