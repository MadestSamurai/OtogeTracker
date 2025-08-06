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

public val Fa.`Angle-up`: ImageVector
    get() {
        if (`_angle-up` != null) {
            return `_angle-up`!!
        }
        `_angle-up` = Builder(name = "Angle-up", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 201.4f)
                curveTo(309.9f, 188.9f, 330.2f, 188.9f, 342.7f, 201.4f)
                lineTo(502.7f, 361.4f)
                curveTo(515.2f, 373.9f, 515.2f, 394.2f, 502.7f, 406.7f)
                curveTo(490.2f, 419.2f, 469.9f, 419.2f, 457.4f, 406.7f)
                lineTo(320.0f, 269.3f)
                lineTo(182.6f, 406.6f)
                curveTo(170.1f, 419.1f, 149.8f, 419.1f, 137.3f, 406.6f)
                curveTo(124.8f, 394.1f, 124.8f, 373.8f, 137.3f, 361.3f)
                lineTo(297.3f, 201.3f)
                close()
            }
        }
        .build()
        return `_angle-up`!!
    }

private var `_angle-up`: ImageVector? = null
