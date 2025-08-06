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

public val Fa.`Angle-down`: ImageVector
    get() {
        if (`_angle-down` != null) {
            return `_angle-down`!!
        }
        `_angle-down` = Builder(name = "Angle-down", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 438.6f)
                curveTo(309.9f, 451.1f, 330.2f, 451.1f, 342.7f, 438.6f)
                lineTo(502.7f, 278.6f)
                curveTo(515.2f, 266.1f, 515.2f, 245.8f, 502.7f, 233.3f)
                curveTo(490.2f, 220.8f, 469.9f, 220.8f, 457.4f, 233.3f)
                lineTo(320.0f, 370.7f)
                lineTo(182.6f, 233.4f)
                curveTo(170.1f, 220.9f, 149.8f, 220.9f, 137.3f, 233.4f)
                curveTo(124.8f, 245.9f, 124.8f, 266.2f, 137.3f, 278.7f)
                lineTo(297.3f, 438.7f)
                close()
            }
        }
        .build()
        return `_angle-down`!!
    }

private var `_angle-down`: ImageVector? = null
