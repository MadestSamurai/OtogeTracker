package com.madsam.otora.core.icon.fa

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.madsam.otora.core.icon.Fa

public val Fa.Brain: ImageVector
    get() {
        if (_brain != null) {
            return _brain!!
        }
        _brain = Builder(name = "Brain", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(184.0f, 120.0f)
                curveTo(184.0f, 89.1f, 209.1f, 64.0f, 240.0f, 64.0f)
                lineTo(264.0f, 64.0f)
                curveTo(281.7f, 64.0f, 296.0f, 78.3f, 296.0f, 96.0f)
                lineTo(296.0f, 544.0f)
                curveTo(296.0f, 561.7f, 281.7f, 576.0f, 264.0f, 576.0f)
                lineTo(232.0f, 576.0f)
                curveTo(202.2f, 576.0f, 177.1f, 555.6f, 170.0f, 528.0f)
                curveTo(169.3f, 528.0f, 168.7f, 528.0f, 168.0f, 528.0f)
                curveTo(123.8f, 528.0f, 88.0f, 492.2f, 88.0f, 448.0f)
                curveTo(88.0f, 430.0f, 94.0f, 413.4f, 104.0f, 400.0f)
                curveTo(84.6f, 385.4f, 72.0f, 362.2f, 72.0f, 336.0f)
                curveTo(72.0f, 305.1f, 89.6f, 278.2f, 115.2f, 264.9f)
                curveTo(108.1f, 252.9f, 104.0f, 238.9f, 104.0f, 224.0f)
                curveTo(104.0f, 179.8f, 139.8f, 144.0f, 184.0f, 144.0f)
                lineTo(184.0f, 120.0f)
                close()
                moveTo(456.0f, 120.0f)
                lineTo(456.0f, 144.0f)
                curveTo(500.2f, 144.0f, 536.0f, 179.8f, 536.0f, 224.0f)
                curveTo(536.0f, 239.0f, 531.9f, 253.0f, 524.8f, 264.9f)
                curveTo(550.5f, 278.2f, 568.0f, 305.0f, 568.0f, 336.0f)
                curveTo(568.0f, 362.2f, 555.4f, 385.4f, 536.0f, 400.0f)
                curveTo(546.0f, 413.4f, 552.0f, 430.0f, 552.0f, 448.0f)
                curveTo(552.0f, 492.2f, 516.2f, 528.0f, 472.0f, 528.0f)
                curveTo(471.3f, 528.0f, 470.7f, 528.0f, 470.0f, 528.0f)
                curveTo(462.9f, 555.6f, 437.8f, 576.0f, 408.0f, 576.0f)
                lineTo(376.0f, 576.0f)
                curveTo(358.3f, 576.0f, 344.0f, 561.7f, 344.0f, 544.0f)
                lineTo(344.0f, 96.0f)
                curveTo(344.0f, 78.3f, 358.3f, 64.0f, 376.0f, 64.0f)
                lineTo(400.0f, 64.0f)
                curveTo(430.9f, 64.0f, 456.0f, 89.1f, 456.0f, 120.0f)
                close()
            }
        }
        .build()
        return _brain!!
    }

private var _brain: ImageVector? = null
