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

public val Fa.`Ruble-sign`: ImageVector
    get() {
        if (`_ruble-sign` != null) {
            return `_ruble-sign`!!
        }
        `_ruble-sign` = Builder(name = "Ruble-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.0f, 96.0f)
                curveTo(190.3f, 96.0f, 176.0f, 110.3f, 176.0f, 128.0f)
                lineTo(176.0f, 336.0f)
                lineTo(136.0f, 336.0f)
                curveTo(122.7f, 336.0f, 112.0f, 346.7f, 112.0f, 360.0f)
                curveTo(112.0f, 373.3f, 122.7f, 384.0f, 136.0f, 384.0f)
                lineTo(176.0f, 384.0f)
                lineTo(176.0f, 432.0f)
                lineTo(136.0f, 432.0f)
                curveTo(122.7f, 432.0f, 112.0f, 442.7f, 112.0f, 456.0f)
                curveTo(112.0f, 469.3f, 122.7f, 480.0f, 136.0f, 480.0f)
                lineTo(176.0f, 480.0f)
                lineTo(176.0f, 512.0f)
                curveTo(176.0f, 529.7f, 190.3f, 544.0f, 208.0f, 544.0f)
                curveTo(225.7f, 544.0f, 240.0f, 529.7f, 240.0f, 512.0f)
                lineTo(240.0f, 480.0f)
                lineTo(392.0f, 480.0f)
                curveTo(405.3f, 480.0f, 416.0f, 469.3f, 416.0f, 456.0f)
                curveTo(416.0f, 442.7f, 405.3f, 432.0f, 392.0f, 432.0f)
                lineTo(240.0f, 432.0f)
                lineTo(240.0f, 384.0f)
                lineTo(352.0f, 384.0f)
                curveTo(431.5f, 384.0f, 496.0f, 319.5f, 496.0f, 240.0f)
                curveTo(496.0f, 160.5f, 431.5f, 96.0f, 352.0f, 96.0f)
                lineTo(208.0f, 96.0f)
                close()
                moveTo(352.0f, 320.0f)
                lineTo(240.0f, 320.0f)
                lineTo(240.0f, 160.0f)
                lineTo(352.0f, 160.0f)
                curveTo(396.2f, 160.0f, 432.0f, 195.8f, 432.0f, 240.0f)
                curveTo(432.0f, 284.2f, 396.2f, 320.0f, 352.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_ruble-sign`!!
    }

private var `_ruble-sign`: ImageVector? = null
