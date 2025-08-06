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

public val Fa.`Quote-right`: ImageVector
    get() {
        if (`_quote-right` != null) {
            return `_quote-right`!!
        }
        `_quote-right` = Builder(name = "Quote-right", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(544.0f, 360.0f)
                curveTo(544.0f, 426.3f, 490.3f, 480.0f, 424.0f, 480.0f)
                lineTo(416.0f, 480.0f)
                curveTo(398.3f, 480.0f, 384.0f, 465.7f, 384.0f, 448.0f)
                curveTo(384.0f, 430.3f, 398.3f, 416.0f, 416.0f, 416.0f)
                lineTo(424.0f, 416.0f)
                curveTo(454.9f, 416.0f, 480.0f, 390.9f, 480.0f, 360.0f)
                lineTo(480.0f, 352.0f)
                lineTo(416.0f, 352.0f)
                curveTo(380.7f, 352.0f, 352.0f, 323.3f, 352.0f, 288.0f)
                lineTo(352.0f, 224.0f)
                curveTo(352.0f, 188.7f, 380.7f, 160.0f, 416.0f, 160.0f)
                lineTo(480.0f, 160.0f)
                curveTo(515.3f, 160.0f, 544.0f, 188.7f, 544.0f, 224.0f)
                lineTo(544.0f, 360.0f)
                close()
                moveTo(288.0f, 360.0f)
                curveTo(288.0f, 426.3f, 234.3f, 480.0f, 168.0f, 480.0f)
                lineTo(160.0f, 480.0f)
                curveTo(142.3f, 480.0f, 128.0f, 465.7f, 128.0f, 448.0f)
                curveTo(128.0f, 430.3f, 142.3f, 416.0f, 160.0f, 416.0f)
                lineTo(168.0f, 416.0f)
                curveTo(198.9f, 416.0f, 224.0f, 390.9f, 224.0f, 360.0f)
                lineTo(224.0f, 352.0f)
                lineTo(160.0f, 352.0f)
                curveTo(124.7f, 352.0f, 96.0f, 323.3f, 96.0f, 288.0f)
                lineTo(96.0f, 224.0f)
                curveTo(96.0f, 188.7f, 124.7f, 160.0f, 160.0f, 160.0f)
                lineTo(224.0f, 160.0f)
                curveTo(259.3f, 160.0f, 288.0f, 188.7f, 288.0f, 224.0f)
                lineTo(288.0f, 360.0f)
                close()
            }
        }
        .build()
        return `_quote-right`!!
    }

private var `_quote-right`: ImageVector? = null
