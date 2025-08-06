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

public val Fa.`Arrow-trend-up`: ImageVector
    get() {
        if (`_arrow-trend-up` != null) {
            return `_arrow-trend-up`!!
        }
        `_arrow-trend-up` = Builder(name = "Arrow-trend-up", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 224.0f)
                curveTo(398.3f, 224.0f, 384.0f, 209.7f, 384.0f, 192.0f)
                curveTo(384.0f, 174.3f, 398.3f, 160.0f, 416.0f, 160.0f)
                lineTo(576.0f, 160.0f)
                curveTo(593.7f, 160.0f, 608.0f, 174.3f, 608.0f, 192.0f)
                lineTo(608.0f, 352.0f)
                curveTo(608.0f, 369.7f, 593.7f, 384.0f, 576.0f, 384.0f)
                curveTo(558.3f, 384.0f, 544.0f, 369.7f, 544.0f, 352.0f)
                lineTo(544.0f, 269.3f)
                lineTo(374.6f, 438.7f)
                curveTo(362.1f, 451.2f, 341.8f, 451.2f, 329.3f, 438.7f)
                lineTo(224.0f, 333.3f)
                lineTo(86.6f, 470.6f)
                curveTo(74.1f, 483.1f, 53.8f, 483.1f, 41.3f, 470.6f)
                curveTo(28.8f, 458.1f, 28.8f, 437.8f, 41.3f, 425.3f)
                lineTo(201.3f, 265.3f)
                curveTo(213.8f, 252.8f, 234.1f, 252.8f, 246.6f, 265.3f)
                lineTo(352.0f, 370.7f)
                lineTo(498.7f, 224.0f)
                lineTo(416.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_arrow-trend-up`!!
    }

private var `_arrow-trend-up`: ImageVector? = null
