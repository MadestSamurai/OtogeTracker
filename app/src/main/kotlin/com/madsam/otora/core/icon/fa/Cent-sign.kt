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

public val Fa.`Cent-sign`: ImageVector
    get() {
        if (`_cent-sign` != null) {
            return `_cent-sign`!!
        }
        `_cent-sign` = Builder(name = "Cent-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(336.0f, 64.0f)
                curveTo(353.7f, 64.0f, 368.0f, 78.3f, 368.0f, 96.0f)
                lineTo(368.0f, 121.4f)
                curveTo(411.6f, 126.6f, 451.0f, 145.9f, 481.3f, 174.5f)
                curveTo(494.2f, 186.6f, 494.7f, 206.9f, 482.6f, 219.7f)
                curveTo(470.5f, 232.5f, 450.2f, 233.1f, 437.4f, 221.0f)
                curveTo(413.0f, 198.0f, 380.2f, 183.9f, 344.1f, 183.9f)
                curveTo(269.0f, 183.9f, 208.1f, 244.8f, 208.1f, 319.9f)
                curveTo(208.1f, 395.0f, 269.0f, 455.9f, 344.1f, 455.9f)
                curveTo(380.3f, 455.9f, 413.1f, 441.8f, 437.4f, 418.8f)
                curveTo(450.3f, 406.7f, 470.5f, 407.3f, 482.6f, 420.1f)
                curveTo(494.7f, 432.9f, 494.1f, 453.2f, 481.3f, 465.3f)
                curveTo(451.0f, 494.1f, 411.6f, 513.4f, 368.0f, 518.6f)
                lineTo(368.0f, 544.0f)
                curveTo(368.0f, 561.7f, 353.7f, 576.0f, 336.0f, 576.0f)
                curveTo(318.3f, 576.0f, 304.0f, 561.7f, 304.0f, 544.0f)
                lineTo(304.0f, 516.0f)
                curveTo(212.7f, 497.5f, 144.0f, 416.8f, 144.0f, 320.0f)
                curveTo(144.0f, 223.2f, 212.7f, 142.5f, 304.0f, 124.0f)
                lineTo(304.0f, 96.0f)
                curveTo(304.0f, 78.3f, 318.3f, 64.0f, 336.0f, 64.0f)
                close()
            }
        }
        .build()
        return `_cent-sign`!!
    }

private var `_cent-sign`: ImageVector? = null
