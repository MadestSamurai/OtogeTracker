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

public val Fa.`Arrow-trend-down`: ImageVector
    get() {
        if (`_arrow-trend-down` != null) {
            return `_arrow-trend-down`!!
        }
        `_arrow-trend-down` = Builder(name = "Arrow-trend-down", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.0f, 416.0f)
                curveTo(398.3f, 416.0f, 384.0f, 430.3f, 384.0f, 448.0f)
                curveTo(384.0f, 465.7f, 398.3f, 480.0f, 416.0f, 480.0f)
                lineTo(576.0f, 480.0f)
                curveTo(593.7f, 480.0f, 608.0f, 465.7f, 608.0f, 448.0f)
                lineTo(608.0f, 288.0f)
                curveTo(608.0f, 270.3f, 593.7f, 256.0f, 576.0f, 256.0f)
                curveTo(558.3f, 256.0f, 544.0f, 270.3f, 544.0f, 288.0f)
                lineTo(544.0f, 370.7f)
                lineTo(374.6f, 201.3f)
                curveTo(362.1f, 188.8f, 341.8f, 188.8f, 329.3f, 201.3f)
                lineTo(224.0f, 306.7f)
                lineTo(86.6f, 169.4f)
                curveTo(74.1f, 156.9f, 53.8f, 156.9f, 41.3f, 169.4f)
                curveTo(28.8f, 181.9f, 28.8f, 202.2f, 41.3f, 214.7f)
                lineTo(201.3f, 374.7f)
                curveTo(213.8f, 387.2f, 234.1f, 387.2f, 246.6f, 374.7f)
                lineTo(352.0f, 269.3f)
                lineTo(498.7f, 416.0f)
                lineTo(416.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_arrow-trend-down`!!
    }

private var `_arrow-trend-down`: ImageVector? = null
