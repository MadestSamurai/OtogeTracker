package com.madsam.otora.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFold
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.util.fastMap
import com.madsam.otora.ui.theme.tab_background
import com.madsam.otora.ui.theme.tab_indicator_background

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.components.CustomTabRow
 * 创建者: MadSamurai
 * 创建时间: 2024/12/30
 * 描述: 自定义TabRow
 */

private val HorizontalTextPadding = 16.dp

@Composable
fun CustomTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = tab_background,
    contentColor: Color = Color.Unspecified,
    indicator: @Composable (tabPositions: List<CustomTabPosition>) -> Unit = @Composable { tabPositions ->
        Box(
            Modifier
                .tabIndicatorOffset(tabPositions[selectedTabIndex])
                .padding(4.dp)
                .clip(RoundedCornerShape(40.dp))
                .fillMaxHeight()
                .background(tab_indicator_background))
    },
    divider: @Composable () -> Unit = @Composable { HorizontalDivider() },
    tabs: @Composable (selectedTabIndex: Int) -> Unit
) {
    Surface(
        modifier = modifier.selectableGroup(),
        color = containerColor,
        contentColor = contentColor
    ) {
        SubcomposeLayout(Modifier.fillMaxWidth()) { constraints ->
            val tabRowWidth = constraints.maxWidth
            val tabMeasurables = subcompose(TabSlots.Tabs) { tabs(selectedTabIndex) }
            val tabCount = tabMeasurables.size
            var tabWidth = 0
            if (tabCount > 0) {
                tabWidth = (tabRowWidth / tabCount)
            }
            val tabRowHeight = tabMeasurables.fastFold(initial = 0) { max, curr ->
                maxOf(curr.maxIntrinsicHeight(tabWidth), max)
            }

            val tabPlaceables = tabMeasurables.fastMap {
                it.measure(
                    constraints.copy(
                        minWidth = tabWidth,
                        maxWidth = tabWidth,
                        minHeight = tabRowHeight,
                        maxHeight = tabRowHeight,
                    )
                )
            }

            val tabPositions = List(tabCount) { index ->
                var contentWidth =
                    minOf(tabMeasurables[index].maxIntrinsicWidth(tabRowHeight), tabWidth).toDp()
                contentWidth -= HorizontalTextPadding * 2
                val indicatorWidth = maxOf(contentWidth, 24.dp)
                CustomTabPosition(tabWidth.toDp() * index, tabWidth.toDp(), indicatorWidth)
            }

            layout(tabRowWidth, tabRowHeight) {
                subcompose(TabSlots.Indicator) { indicator(tabPositions) }
                    .fastForEach {
                        it.measure(Constraints.fixed(tabRowWidth, tabRowHeight)).placeRelative(0, 0)
                    }

                tabPlaceables.fastForEachIndexed { index, placeable ->
                    placeable.placeRelative(index * tabWidth, 0)
                }

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

class CustomTabPosition internal constructor(val left: Dp, val width: Dp, private val contentWidth: Dp) {

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
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
            label = ""
        )
        val indicatorOffset by
        animateDpAsState(
            targetValue = currentTabPosition.left,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
            label = ""
        )
        fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
            .offset { IntOffset(x = indicatorOffset.roundToPx(), y = 0) }
            .width(currentTabWidth)

    }