package com.madsam.otora.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.core.utils.BrushUtils.getRatingBrush

@Composable
fun RoundedBarChart(
    values: List<Double>,
    modifier: Modifier = Modifier,
    minValue: Double,
    maxValue: Double,
    height: Dp,
    barSpacing: Float? = null, // 可选的固定柱间距参数
    fillWidth: Boolean = false, // 是否充满容器宽度
    spacingRatio: Float? = null // 新增：柱间距与柱宽的比例，用于保持视觉一致性
) {
    val sortedValues = values.sorted()
    // 计算最小值的偏移量（比最小值小5%）
    val minValueOffset = minValue - ((maxValue - minValue) * 0.05)
    val isDark = isSystemInDarkTheme()
    val colorScheme = MaterialTheme.colorScheme
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(height - 20.dp)
                .align(Alignment.TopCenter)
        ) {
            val barCount = sortedValues.size
            
            val (barWidth, spacing) = when {
                spacingRatio != null && (fillWidth || barSpacing == null) -> {
                    // 使用比例来计算柱宽和柱间距，充满容器
                    // 公式：totalWidth = barCount * barWidth + (barCount - 1) * spacing
                    // 其中：spacing = barWidth * spacingRatio
                    // 所以：totalWidth = barCount * barWidth + (barCount - 1) * barWidth * spacingRatio
                    //      totalWidth = barWidth * (barCount + (barCount - 1) * spacingRatio)
                    val totalWidth = size.width
                    val calculatedBarWidth = totalWidth / (barCount + (barCount - 1) * spacingRatio)
                    val calculatedSpacing = calculatedBarWidth * spacingRatio
                    calculatedBarWidth to calculatedSpacing
                }
                fillWidth -> {
                    // 充满容器宽度时，保持固定柱宽，计算柱间距
                    val fixedBarWidth = 10f
                    val availableWidth = size.width - (barCount * fixedBarWidth)
                    val calculatedSpacing = availableWidth / (barCount - 1)
                    fixedBarWidth to calculatedSpacing
                }
                barSpacing != null -> {
                    // 使用固定柱间距
                    10f to barSpacing
                }
                else -> {
                    // 默认自适应逻辑
                    val fixedBarWidth = 10f
                    val availableWidth = size.width - (barCount * fixedBarWidth)
                    val calculatedSpacing = availableWidth / (barCount - 1)
                    fixedBarWidth to calculatedSpacing
                }
            }
            
            val heightScale = size.height / (maxValue - minValueOffset).toFloat()

            sortedValues.forEachIndexed { index, value ->
                val normalizedValue = ((value - minValueOffset) * heightScale).toFloat()
                val x = index * (barWidth + spacing)
                val y = size.height - normalizedValue

                
                drawRoundRect(
                    brush = getRatingBrush(value.toString(), isDark),
                    topLeft = androidx.compose.ui.geometry.Offset(x, y),
                    size = Size(barWidth, normalizedValue),
                    cornerRadius = CornerRadius(barWidth / 2, barWidth / 2)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .align(Alignment.BottomCenter)
        ) {
            // 显示原始的最小值（而不是偏移后的值）
            Text(
                text = String.format(java.util.Locale.US, "%.2f", minValue),
                color = colorScheme.onSurfaceVariant,
                fontSize = 12.sp,
                letterSpacing = (-1).sp,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = String.format(java.util.Locale.US, "%.2f", maxValue),
                color = colorScheme.onSurfaceVariant,
                fontSize = 12.sp,
                letterSpacing = (-1).sp,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}