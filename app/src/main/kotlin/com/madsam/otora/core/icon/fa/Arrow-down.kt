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

public val Fa.`Arrow-down`: ImageVector
    get() {
        if (`_arrow-down` != null) {
            return `_arrow-down`!!
        }
        `_arrow-down` = Builder(name = "Arrow-down", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 566.6f)
                curveTo(309.9f, 579.1f, 330.2f, 579.1f, 342.7f, 566.6f)
                lineTo(502.7f, 406.6f)
                curveTo(515.2f, 394.1f, 515.2f, 373.8f, 502.7f, 361.3f)
                curveTo(490.2f, 348.8f, 469.9f, 348.8f, 457.4f, 361.3f)
                lineTo(352.0f, 466.7f)
                lineTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 466.7f)
                lineTo(182.6f, 361.3f)
                curveTo(170.1f, 348.8f, 149.8f, 348.8f, 137.3f, 361.3f)
                curveTo(124.8f, 373.8f, 124.8f, 394.1f, 137.3f, 406.6f)
                lineTo(297.3f, 566.6f)
                close()
            }
        }
        .build()
        return `_arrow-down`!!
    }

private var `_arrow-down`: ImageVector? = null
