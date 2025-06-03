package com.madsam.otora.ui.components

import android.graphics.Paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.madsam.otora.core.theme.Yellow1000
import com.madsam.otora.core.theme.OSU_BRIGHT_YELLOW_HALF_TRANS
import com.patrykandpatrick.vico.core.common.DrawingContext
import com.patrykandpatrick.vico.core.common.component.Component

class DoubleCircleIndicator(
    outerCircleColor: Color = OSU_BRIGHT_YELLOW_HALF_TRANS,
    innerCircleColor: Color = Yellow1000
) : Component {
    private val outerCirclePaint = Paint().apply {
        color = outerCircleColor.toArgb()
        style = Paint.Style.FILL
    }
    private val innerCirclePaint = Paint().apply {
        color = innerCircleColor.toArgb()
        style = Paint.Style.FILL
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

        context.canvas.drawCircle(centerX, centerY, radius, outerCirclePaint)
        context.canvas.drawCircle(centerX, centerY, radius * 0.6f, innerCirclePaint)
    }
}