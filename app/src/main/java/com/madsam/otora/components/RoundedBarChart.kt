package com.madsam.otora.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madsam.otora.utils.CommonUtils.getRatingBrush

@Composable
fun RoundedBarChart(
    values: List<Double>,
    modifier: Modifier = Modifier,
    minValue: Double,
    maxValue: Double,
    height: Dp
) {
    val sortedValues = values.sorted()
    // 计算最小值的偏移量（比最小值小5%）
    val minValueOffset = minValue - ((maxValue - minValue) * 0.05)
    
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
            val barWidth = 10f
            val availableWidth = size.width - (barCount * barWidth)
            val spacing = availableWidth / (barCount - 1)
            val heightScale = size.height / (maxValue - minValueOffset).toFloat()

            sortedValues.forEachIndexed { index, value ->
                val normalizedValue = ((value - minValueOffset) * heightScale).toFloat()
                val x = index * (barWidth + spacing)
                val y = size.height - normalizedValue

                
                drawRoundRect(
                    brush = getRatingBrush(value.toString()),
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
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text = String.format(java.util.Locale.US, "%.2f", maxValue),
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}