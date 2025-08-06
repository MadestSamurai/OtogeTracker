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

public val Fa.`Arrow-right`: ImageVector
    get() {
        if (`_arrow-right` != null) {
            return `_arrow-right`!!
        }
        `_arrow-right` = Builder(name = "Arrow-right", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(566.6f, 342.6f)
                curveTo(579.1f, 330.1f, 579.1f, 309.8f, 566.6f, 297.3f)
                lineTo(406.6f, 137.3f)
                curveTo(394.1f, 124.8f, 373.8f, 124.8f, 361.3f, 137.3f)
                curveTo(348.8f, 149.8f, 348.8f, 170.1f, 361.3f, 182.6f)
                lineTo(466.7f, 288.0f)
                lineTo(96.0f, 288.0f)
                curveTo(78.3f, 288.0f, 64.0f, 302.3f, 64.0f, 320.0f)
                curveTo(64.0f, 337.7f, 78.3f, 352.0f, 96.0f, 352.0f)
                lineTo(466.7f, 352.0f)
                lineTo(361.3f, 457.4f)
                curveTo(348.8f, 469.9f, 348.8f, 490.2f, 361.3f, 502.7f)
                curveTo(373.8f, 515.2f, 394.1f, 515.2f, 406.6f, 502.7f)
                lineTo(566.6f, 342.7f)
                close()
            }
        }
        .build()
        return `_arrow-right`!!
    }

private var `_arrow-right`: ImageVector? = null
