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

public val Fa.`Angle-double-down`: ImageVector
    get() {
        if (`_angle-double-down` != null) {
            return `_angle-double-down`!!
        }
        `_angle-double-down` = Builder(name = "Angle-double-down", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(342.6f, 534.6f)
                curveTo(330.1f, 547.1f, 309.8f, 547.1f, 297.3f, 534.6f)
                lineTo(137.3f, 374.6f)
                curveTo(124.8f, 362.1f, 124.8f, 341.8f, 137.3f, 329.3f)
                curveTo(149.8f, 316.8f, 170.1f, 316.8f, 182.6f, 329.3f)
                lineTo(320.0f, 466.7f)
                lineTo(457.4f, 329.4f)
                curveTo(469.9f, 316.9f, 490.2f, 316.9f, 502.7f, 329.4f)
                curveTo(515.2f, 341.9f, 515.2f, 362.2f, 502.7f, 374.7f)
                lineTo(342.7f, 534.7f)
                close()
                moveTo(502.6f, 182.6f)
                lineTo(342.6f, 342.6f)
                curveTo(330.1f, 355.1f, 309.8f, 355.1f, 297.3f, 342.6f)
                lineTo(137.3f, 182.6f)
                curveTo(124.8f, 170.1f, 124.8f, 149.8f, 137.3f, 137.3f)
                curveTo(149.8f, 124.8f, 170.1f, 124.8f, 182.6f, 137.3f)
                lineTo(320.0f, 274.7f)
                lineTo(457.4f, 137.4f)
                curveTo(469.9f, 124.9f, 490.2f, 124.9f, 502.7f, 137.4f)
                curveTo(515.2f, 149.9f, 515.2f, 170.2f, 502.7f, 182.7f)
                close()
            }
        }
        .build()
        return `_angle-double-down`!!
    }

private var `_angle-double-down`: ImageVector? = null
