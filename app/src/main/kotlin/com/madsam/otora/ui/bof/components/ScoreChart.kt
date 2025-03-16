package com.madsam.otora.ui.bof.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun ScoreChart(
    dataList: List<Int>,
    height: Dp,
    width: Dp,
    color: Color
) {
    val density = LocalDensity.current.density
    if (width.value <= 0 || height.value <= 0 || dataList.isEmpty()) {
        return
    }

    val imageBitmap = remember(dataList, height, width, density, color) {
        createScoreChartBitmap(dataList, height, width, density, color)
    }

    Image(
        bitmap = imageBitmap,
        contentDescription = null,
        modifier = Modifier.size(width, height)
    )
}

private fun createScoreChartBitmap(
    dataList: List<Int>,
    height: Dp,
    width: Dp,
    density: Float,
    color: Color
): ImageBitmap {
    val widthPx = (width.value * density).toInt().coerceAtLeast(1)
    val heightPx = (height.value * density).toInt().coerceAtLeast(1)
    val padding = heightPx * 0.1f

    return ImageBitmap(widthPx, heightPx).apply {
        val canvas = Canvas(this)
        val path = Path()
        val maxDataValue = 1000f
        val stepX = widthPx.toFloat() / (dataList.size - 1).coerceAtLeast(1)
        val stepY = (heightPx - padding * 2) / maxDataValue

        // Create fill path
        path.moveTo(0f, heightPx.toFloat())
        for (i in dataList.indices) {
            val x = i * stepX
            val y = heightPx - padding - (dataList[i] * stepY)
            path.lineTo(x, y)
        }
        path.lineTo(widthPx.toFloat(), heightPx.toFloat())
        path.close()

        val fillColor = color.copy(alpha = 1.0f).copy(
            red = color.red * 0.5f,
            green = color.green * 0.5f,
            blue = color.blue * 0.5f
        )

        // Draw fill
        canvas.drawPath(path, Paint().apply {
            this.color = fillColor
            this.style = PaintingStyle.Fill
        })

        // Draw lines
        val linePaint = Paint().apply {
            this.color = color
            this.style = PaintingStyle.Stroke
            this.strokeWidth = 2f * density
        }

        for (i in 0 until dataList.size - 1) {
            val startX = i * stepX
            val startY = heightPx - padding - (dataList[i] * stepY)
            val endX = (i + 1) * stepX
            val endY = heightPx - padding - (dataList[i + 1] * stepY)

            canvas.drawLine(
                p1 = Offset(startX, startY),
                p2 = Offset(endX, endY),
                paint = linePaint
            )
        }
    }
}