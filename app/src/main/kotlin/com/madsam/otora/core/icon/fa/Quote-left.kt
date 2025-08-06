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

public val Fa.`Quote-left`: ImageVector
    get() {
        if (`_quote-left` != null) {
            return `_quote-left`!!
        }
        `_quote-left` = Builder(name = "Quote-left", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 280.0f)
                curveTo(96.0f, 213.7f, 149.7f, 160.0f, 216.0f, 160.0f)
                lineTo(224.0f, 160.0f)
                curveTo(241.7f, 160.0f, 256.0f, 174.3f, 256.0f, 192.0f)
                curveTo(256.0f, 209.7f, 241.7f, 224.0f, 224.0f, 224.0f)
                lineTo(216.0f, 224.0f)
                curveTo(185.1f, 224.0f, 160.0f, 249.1f, 160.0f, 280.0f)
                lineTo(160.0f, 288.0f)
                lineTo(224.0f, 288.0f)
                curveTo(259.3f, 288.0f, 288.0f, 316.7f, 288.0f, 352.0f)
                lineTo(288.0f, 416.0f)
                curveTo(288.0f, 451.3f, 259.3f, 480.0f, 224.0f, 480.0f)
                lineTo(160.0f, 480.0f)
                curveTo(124.7f, 480.0f, 96.0f, 451.3f, 96.0f, 416.0f)
                lineTo(96.0f, 280.0f)
                close()
                moveTo(352.0f, 280.0f)
                curveTo(352.0f, 213.7f, 405.7f, 160.0f, 472.0f, 160.0f)
                lineTo(480.0f, 160.0f)
                curveTo(497.7f, 160.0f, 512.0f, 174.3f, 512.0f, 192.0f)
                curveTo(512.0f, 209.7f, 497.7f, 224.0f, 480.0f, 224.0f)
                lineTo(472.0f, 224.0f)
                curveTo(441.1f, 224.0f, 416.0f, 249.1f, 416.0f, 280.0f)
                lineTo(416.0f, 288.0f)
                lineTo(480.0f, 288.0f)
                curveTo(515.3f, 288.0f, 544.0f, 316.7f, 544.0f, 352.0f)
                lineTo(544.0f, 416.0f)
                curveTo(544.0f, 451.3f, 515.3f, 480.0f, 480.0f, 480.0f)
                lineTo(416.0f, 480.0f)
                curveTo(380.7f, 480.0f, 352.0f, 451.3f, 352.0f, 416.0f)
                lineTo(352.0f, 280.0f)
                close()
            }
        }
        .build()
        return `_quote-left`!!
    }

private var `_quote-left`: ImageVector? = null
