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

public val Fa.`Arrow-left`: ImageVector
    get() {
        if (`_arrow-left` != null) {
            return `_arrow-left`!!
        }
        `_arrow-left` = Builder(name = "Arrow-left", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.4f, 297.4f)
                curveTo(60.9f, 309.9f, 60.9f, 330.2f, 73.4f, 342.7f)
                lineTo(233.4f, 502.7f)
                curveTo(245.9f, 515.2f, 266.2f, 515.2f, 278.7f, 502.7f)
                curveTo(291.2f, 490.2f, 291.2f, 469.9f, 278.7f, 457.4f)
                lineTo(173.3f, 352.0f)
                lineTo(544.0f, 352.0f)
                curveTo(561.7f, 352.0f, 576.0f, 337.7f, 576.0f, 320.0f)
                curveTo(576.0f, 302.3f, 561.7f, 288.0f, 544.0f, 288.0f)
                lineTo(173.3f, 288.0f)
                lineTo(278.7f, 182.6f)
                curveTo(291.2f, 170.1f, 291.2f, 149.8f, 278.7f, 137.3f)
                curveTo(266.2f, 124.8f, 245.9f, 124.8f, 233.4f, 137.3f)
                lineTo(73.4f, 297.3f)
                close()
            }
        }
        .build()
        return `_arrow-left`!!
    }

private var `_arrow-left`: ImageVector? = null
