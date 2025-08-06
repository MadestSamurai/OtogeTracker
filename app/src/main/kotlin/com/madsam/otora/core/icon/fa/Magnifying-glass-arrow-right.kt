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

public val Fa.`Magnifying-glass-arrow-right`: ImageVector
    get() {
        if (`_magnifying-glass-arrow-right` != null) {
            return `_magnifying-glass-arrow-right`!!
        }
        `_magnifying-glass-arrow-right` = Builder(name = "Magnifying-glass-arrow-right",
                defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f,
                viewportHeight = 640.0f).apply {
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
                moveTo(369.0f, 289.0f)
                curveTo(378.4f, 279.6f, 378.4f, 264.4f, 369.0f, 255.1f)
                lineTo(297.0f, 183.1f)
                curveTo(287.6f, 173.7f, 272.4f, 173.7f, 263.1f, 183.1f)
                curveTo(253.8f, 192.5f, 253.7f, 207.7f, 263.1f, 217.0f)
                lineTo(294.1f, 248.0f)
                lineTo(192.0f, 248.0f)
                curveTo(178.7f, 248.0f, 168.0f, 258.7f, 168.0f, 272.0f)
                curveTo(168.0f, 285.3f, 178.7f, 296.0f, 192.0f, 296.0f)
                lineTo(294.1f, 296.0f)
                lineTo(263.1f, 327.0f)
                curveTo(253.7f, 336.4f, 253.7f, 351.6f, 263.1f, 360.9f)
                curveTo(272.5f, 370.2f, 287.7f, 370.3f, 297.0f, 360.9f)
                lineTo(369.0f, 288.9f)
                close()
            }
        }
        .build()
        return `_magnifying-glass-arrow-right`!!
    }

private var `_magnifying-glass-arrow-right`: ImageVector? = null
