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

public val Fa.`Angle-right`: ImageVector
    get() {
        if (`_angle-right` != null) {
            return `_angle-right`!!
        }
        `_angle-right` = Builder(name = "Angle-right", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(439.1f, 297.4f)
                curveTo(451.6f, 309.9f, 451.6f, 330.2f, 439.1f, 342.7f)
                lineTo(279.1f, 502.7f)
                curveTo(266.6f, 515.2f, 246.3f, 515.2f, 233.8f, 502.7f)
                curveTo(221.3f, 490.2f, 221.3f, 469.9f, 233.8f, 457.4f)
                lineTo(371.2f, 320.0f)
                lineTo(233.9f, 182.6f)
                curveTo(221.4f, 170.1f, 221.4f, 149.8f, 233.9f, 137.3f)
                curveTo(246.4f, 124.8f, 266.7f, 124.8f, 279.2f, 137.3f)
                lineTo(439.2f, 297.3f)
                close()
            }
        }
        .build()
        return `_angle-right`!!
    }

private var `_angle-right`: ImageVector? = null
