package com.madsam.otora.ui.record.chunithm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.theme.BlackAlpha50
import com.madsam.otora.core.theme.Red700
import com.madsam.otora.core.theme.White1000
import com.madsam.otora.core.theme.sarasaBold
import com.madsam.otora.core.utils.BrushUtils.getRatingBrush
import com.madsam.otora.data.chunithm.ui.model.ChunithmTopRankUiModel
import com.madsam.otora.ui.components.RoundedBarChart
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale

@Composable
internal fun TopRank(
    topRankUI: MutableStateFlow<ChunithmTopRankUiModel>,
    cardWidthDp: Dp
) {
    val topRank by topRankUI.collectAsState()
    
    // 动态分配两个图表的宽度
    val idealSpacingRatio = 0.8f // 理想的柱间距与柱宽比例
    val barCount30 = 30
    val barCount20 = 20
    val totalPadding = 48.dp
    val availableWidth = cardWidthDp - totalPadding - 4.dp// 减去容器间的间距
    
    // 计算理想情况下两个图表需要的最小宽度（保持相同的柱间距比例）
    // 公式：图表宽度 = 柱数量 * 柱宽 + (柱数量-1) * 柱间距
    // 其中：柱间距 = 柱宽 * spacingRatio
    // 所以：图表宽度 = 柱宽 * (柱数量 + (柱数量-1) * spacingRatio)
    val ratio30 = barCount30 + (barCount30 - 1) * idealSpacingRatio
    val ratio20 = barCount20 + (barCount20 - 1) * idealSpacingRatio
    val totalRatio = ratio30 + ratio20
    
    // 按比例分配宽度
    val bestChartWidth = availableWidth * (ratio30 / totalRatio)
    val newChartWidth = availableWidth * (ratio20 / totalRatio)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 12.dp)
    ) {
        // Best 30 图表容器
        Box(
            modifier = Modifier
                .width(bestChartWidth + 24.dp) // 加上内部padding
                .clip(RoundedCornerShape(
                    topStart = 10.dp, topEnd = 6.dp,
                    bottomStart = 10.dp, bottomEnd = 6.dp
                ))
                .background(Red700)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 6.dp, top = 6.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(BlackAlpha50)
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "Best 30",
                    fontSize = 11.sp,
                    color = White1000
                )
                Text(
                    text = String.format(Locale.US, "%.2f", topRank.best30),
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                    style = TextStyle(
                        brush = getRatingBrush(topRank.best30.toString())
                    )
                )
            }
            if (topRank.bestList.isNotEmpty()) {
                RoundedBarChart(
                    values = topRank.bestList.map { it.rating },
                    minValue = topRank.bestList.minOfOrNull { it.rating } ?: 0.0,
                    maxValue = topRank.bestList.maxOfOrNull { it.rating } ?: 0.0,
                    height = 80.dp,
                    spacingRatio = idealSpacingRatio,
                    fillWidth = true,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 4.dp)
                        .width(bestChartWidth)
                )
            }
        }
        // New 20 图表容器
        Box(
            modifier = Modifier
                .padding(start = 4.dp)
                .width(newChartWidth + 24.dp) // 加上内部padding
                .clip(RoundedCornerShape(
                    topStart = 6.dp, topEnd = 10.dp,
                    bottomStart = 6.dp, bottomEnd = 10.dp
                ))
                .background(Red700)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 6.dp, top = 6.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(BlackAlpha50)
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "New 20",
                    fontSize = 11.sp,
                    color = White1000
                )
                Text(
                    text = String.format(Locale.US, "%.2f", topRank.new20),
                    fontSize = 14.sp,
                    fontFamily = sarasaBold,
                    style = TextStyle(
                        brush = getRatingBrush(topRank.new20.toString())
                    )
                )
            }
            if (topRank.newList.isNotEmpty()) {
                RoundedBarChart(
                    values = topRank.newList.map { it.rating },
                    minValue = topRank.newList.minOfOrNull { it.rating } ?: 0.0,
                    maxValue = topRank.newList.maxOfOrNull { it.rating } ?: 0.0,
                    height = 80.dp,
                    spacingRatio = idealSpacingRatio,
                    fillWidth = true,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 4.dp)
                        .width(newChartWidth)
                )
            }
        }
    }
}