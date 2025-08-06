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

public val Fa.`Angle-double-up`: ImageVector
    get() {
        if (`_angle-double-up` != null) {
            return `_angle-double-up`!!
        }
        `_angle-double-up` = Builder(name = "Angle-double-up", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(342.6f, 105.4f)
                curveTo(330.1f, 92.9f, 309.8f, 92.9f, 297.3f, 105.4f)
                lineTo(137.3f, 265.4f)
                curveTo(124.8f, 277.9f, 124.8f, 298.2f, 137.3f, 310.7f)
                curveTo(149.8f, 323.2f, 170.1f, 323.2f, 182.6f, 310.7f)
                lineTo(320.0f, 173.3f)
                lineTo(457.4f, 310.6f)
                curveTo(469.9f, 323.1f, 490.2f, 323.1f, 502.7f, 310.6f)
                curveTo(515.2f, 298.1f, 515.2f, 277.8f, 502.7f, 265.3f)
                lineTo(342.7f, 105.3f)
                close()
                moveTo(502.6f, 457.4f)
                lineTo(342.6f, 297.4f)
                curveTo(330.1f, 284.9f, 309.8f, 284.9f, 297.3f, 297.4f)
                lineTo(137.3f, 457.4f)
                curveTo(124.8f, 469.9f, 124.8f, 490.2f, 137.3f, 502.7f)
                curveTo(149.8f, 515.2f, 170.1f, 515.2f, 182.6f, 502.7f)
                lineTo(320.0f, 365.3f)
                lineTo(457.4f, 502.6f)
                curveTo(469.9f, 515.1f, 490.2f, 515.1f, 502.7f, 502.6f)
                curveTo(515.2f, 490.1f, 515.2f, 469.8f, 502.7f, 457.3f)
                close()
            }
        }
        .build()
        return `_angle-double-up`!!
    }

private var `_angle-double-up`: ImageVector? = null
