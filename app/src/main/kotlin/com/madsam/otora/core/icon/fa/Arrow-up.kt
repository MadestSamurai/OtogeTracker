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

public val Fa.`Arrow-up`: ImageVector
    get() {
        if (`_arrow-up` != null) {
            return `_arrow-up`!!
        }
        `_arrow-up` = Builder(name = "Arrow-up", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(342.6f, 81.4f)
                curveTo(330.1f, 68.9f, 309.8f, 68.9f, 297.3f, 81.4f)
                lineTo(137.3f, 241.4f)
                curveTo(124.8f, 253.9f, 124.8f, 274.2f, 137.3f, 286.7f)
                curveTo(149.8f, 299.2f, 170.1f, 299.2f, 182.6f, 286.7f)
                lineTo(288.0f, 181.3f)
                lineTo(288.0f, 552.0f)
                curveTo(288.0f, 569.7f, 302.3f, 584.0f, 320.0f, 584.0f)
                curveTo(337.7f, 584.0f, 352.0f, 569.7f, 352.0f, 552.0f)
                lineTo(352.0f, 181.3f)
                lineTo(457.4f, 286.7f)
                curveTo(469.9f, 299.2f, 490.2f, 299.2f, 502.7f, 286.7f)
                curveTo(515.2f, 274.2f, 515.2f, 253.9f, 502.7f, 241.4f)
                lineTo(342.7f, 81.4f)
                close()
            }
        }
        .build()
        return `_arrow-up`!!
    }

private var `_arrow-up`: ImageVector? = null
