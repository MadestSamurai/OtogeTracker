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

public val Fa.`Magnifying-glass-chart`: ImageVector
    get() {
        if (`_magnifying-glass-chart` != null) {
            return `_magnifying-glass-chart`!!
        }
        `_magnifying-glass-chart` = Builder(name = "Magnifying-glass-chart", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 272.0f)
                curveTo(480.0f, 317.9f, 465.1f, 360.3f, 440.0f, 394.7f)
                lineTo(566.6f, 521.4f)
                curveTo(579.1f, 533.9f, 579.1f, 554.2f, 566.6f, 566.7f)
                curveTo(554.1f, 579.2f, 533.8f, 579.2f, 521.3f, 566.7f)
                lineTo(394.7f, 440.0f)
                curveTo(360.3f, 465.1f, 317.9f, 480.0f, 272.0f, 480.0f)
                curveTo(157.1f, 480.0f, 64.0f, 386.9f, 64.0f, 272.0f)
                curveTo(64.0f, 157.1f, 157.1f, 64.0f, 272.0f, 64.0f)
                curveTo(386.9f, 64.0f, 480.0f, 157.1f, 480.0f, 272.0f)
                close()
                moveTo(168.0f, 280.0f)
                lineTo(168.0f, 344.0f)
                curveTo(168.0f, 357.3f, 178.7f, 368.0f, 192.0f, 368.0f)
                curveTo(205.3f, 368.0f, 216.0f, 357.3f, 216.0f, 344.0f)
                lineTo(216.0f, 280.0f)
                curveTo(216.0f, 266.7f, 205.3f, 256.0f, 192.0f, 256.0f)
                curveTo(178.7f, 256.0f, 168.0f, 266.7f, 168.0f, 280.0f)
                close()
                moveTo(248.0f, 184.0f)
                lineTo(248.0f, 344.0f)
                curveTo(248.0f, 357.3f, 258.7f, 368.0f, 272.0f, 368.0f)
                curveTo(285.3f, 368.0f, 296.0f, 357.3f, 296.0f, 344.0f)
                lineTo(296.0f, 184.0f)
                curveTo(296.0f, 170.7f, 285.3f, 160.0f, 272.0f, 160.0f)
                curveTo(258.7f, 160.0f, 248.0f, 170.7f, 248.0f, 184.0f)
                close()
                moveTo(328.0f, 248.0f)
                lineTo(328.0f, 344.0f)
                curveTo(328.0f, 357.3f, 338.7f, 368.0f, 352.0f, 368.0f)
                curveTo(365.3f, 368.0f, 376.0f, 357.3f, 376.0f, 344.0f)
                lineTo(376.0f, 248.0f)
                curveTo(376.0f, 234.7f, 365.3f, 224.0f, 352.0f, 224.0f)
                curveTo(338.7f, 224.0f, 328.0f, 234.7f, 328.0f, 248.0f)
                close()
            }
        }
        .build()
        return `_magnifying-glass-chart`!!
    }

private var `_magnifying-glass-chart`: ImageVector? = null
