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

public val Fa.`Angle-left`: ImageVector
    get() {
        if (`_angle-left` != null) {
            return `_angle-left`!!
        }
        `_angle-left` = Builder(name = "Angle-left", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(201.4f, 297.4f)
                curveTo(188.9f, 309.9f, 188.9f, 330.2f, 201.4f, 342.7f)
                lineTo(361.4f, 502.7f)
                curveTo(373.9f, 515.2f, 394.2f, 515.2f, 406.7f, 502.7f)
                curveTo(419.2f, 490.2f, 419.2f, 469.9f, 406.7f, 457.4f)
                lineTo(269.3f, 320.0f)
                lineTo(406.6f, 182.6f)
                curveTo(419.1f, 170.1f, 419.1f, 149.8f, 406.6f, 137.3f)
                curveTo(394.1f, 124.8f, 373.8f, 124.8f, 361.3f, 137.3f)
                lineTo(201.3f, 297.3f)
                close()
            }
        }
        .build()
        return `_angle-left`!!
    }

private var `_angle-left`: ImageVector? = null
