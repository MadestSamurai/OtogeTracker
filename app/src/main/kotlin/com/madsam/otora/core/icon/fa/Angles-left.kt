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

public val Fa.`Angles-left`: ImageVector
    get() {
        if (`_angles-left` != null) {
            return `_angles-left`!!
        }
        `_angles-left` = Builder(name = "Angles-left", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(105.4f, 297.4f)
                curveTo(92.9f, 309.9f, 92.9f, 330.2f, 105.4f, 342.7f)
                lineTo(265.4f, 502.7f)
                curveTo(277.9f, 515.2f, 298.2f, 515.2f, 310.7f, 502.7f)
                curveTo(323.2f, 490.2f, 323.2f, 469.9f, 310.7f, 457.4f)
                lineTo(173.3f, 320.0f)
                lineTo(310.6f, 182.6f)
                curveTo(323.1f, 170.1f, 323.1f, 149.8f, 310.6f, 137.3f)
                curveTo(298.1f, 124.8f, 277.8f, 124.8f, 265.3f, 137.3f)
                lineTo(105.3f, 297.3f)
                close()
                moveTo(457.4f, 137.4f)
                lineTo(297.4f, 297.4f)
                curveTo(284.9f, 309.9f, 284.9f, 330.2f, 297.4f, 342.7f)
                lineTo(457.4f, 502.7f)
                curveTo(469.9f, 515.2f, 490.2f, 515.2f, 502.7f, 502.7f)
                curveTo(515.2f, 490.2f, 515.2f, 469.9f, 502.7f, 457.4f)
                lineTo(365.3f, 320.0f)
                lineTo(502.6f, 182.6f)
                curveTo(515.1f, 170.1f, 515.1f, 149.8f, 502.6f, 137.3f)
                curveTo(490.1f, 124.8f, 469.8f, 124.8f, 457.3f, 137.3f)
                close()
            }
        }
        .build()
        return `_angles-left`!!
    }

private var `_angles-left`: ImageVector? = null
