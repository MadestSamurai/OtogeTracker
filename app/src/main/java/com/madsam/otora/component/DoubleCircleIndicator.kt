package com.madsam.otora.component

import android.graphics.Paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.madsam.otora.consts.Colors
import com.patrykandpatrick.vico.core.common.DrawingContext
import com.patrykandpatrick.vico.core.common.component.Component

/**
 * 项目名: OtogeTracker
 * 文件名: com.madsam.otora.component.TripleCircleIndicator
 * 创建者: MadSamurai
 * 创建时间: 2024/10/17
 * 描述: 三个圆形指示器
 */

class DoubleCircleIndicator(
    outerCircleColor: Color = Colors.OSU_BRIGHT_YELLOW_HALF_TRANS,
    innerCircleColor: Color = Colors.OSU_BRIGHT_YELLOW
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