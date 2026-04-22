package com.madsam.otora.ui.components

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import com.madsam.otora.core.theme.Yellow1000
import com.madsam.otora.core.theme.OSU_BRIGHT_YELLOW_HALF_TRANS
import com.patrykandpatrick.vico.compose.common.DrawingContext
import com.patrykandpatrick.vico.compose.common.component.Component

class DoubleCircleIndicator(
    outerCircleColor: Color = OSU_BRIGHT_YELLOW_HALF_TRANS,
    innerCircleColor: Color = Yellow1000
) : Component {
    private val outerCirclePaint = Paint().apply {
        color = outerCircleColor
        style = PaintingStyle.Fill
    }
    private val innerCirclePaint = Paint().apply {
        color = innerCircleColor
        style = PaintingStyle.Fill
    }

    override fun draw(
        context: DrawingContext,
        left: Float,
        top: Float,
        right: Float,
        bottom: Float
    ) {
        val radius = (right - left) / 2
        val centerX = left + radius
        val centerY = top + radius

        context.canvas.drawCircle(Offset(centerX, centerY), radius, outerCirclePaint)
        context.canvas.drawCircle(Offset(centerX, centerY), radius * 0.6f, innerCirclePaint)
    }
}