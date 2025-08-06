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

public val Fa.`Arrows-left-right`: ImageVector
    get() {
        if (`_arrows-left-right` != null) {
            return `_arrows-left-right`!!
        }
        `_arrows-left-right` = Builder(name = "Arrows-left-right", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(502.6f, 438.6f)
                lineTo(598.6f, 342.6f)
                curveTo(611.1f, 330.1f, 611.1f, 309.8f, 598.6f, 297.3f)
                lineTo(502.6f, 201.3f)
                curveTo(490.1f, 188.8f, 469.8f, 188.8f, 457.3f, 201.3f)
                curveTo(444.8f, 213.8f, 444.8f, 234.1f, 457.3f, 246.6f)
                lineTo(498.7f, 288.0f)
                lineTo(141.2f, 288.0f)
                lineTo(182.6f, 246.6f)
                curveTo(195.1f, 234.1f, 195.1f, 213.8f, 182.6f, 201.3f)
                curveTo(170.1f, 188.8f, 149.8f, 188.8f, 137.3f, 201.3f)
                lineTo(41.3f, 297.3f)
                curveTo(35.3f, 303.3f, 31.9f, 311.4f, 31.9f, 319.9f)
                curveTo(31.9f, 328.4f, 35.3f, 336.5f, 41.3f, 342.5f)
                lineTo(137.3f, 438.5f)
                curveTo(149.8f, 451.0f, 170.1f, 451.0f, 182.6f, 438.5f)
                curveTo(195.1f, 426.0f, 195.1f, 405.7f, 182.6f, 393.2f)
                lineTo(141.2f, 351.8f)
                lineTo(498.7f, 351.8f)
                lineTo(457.3f, 393.2f)
                curveTo(444.8f, 405.7f, 444.8f, 426.0f, 457.3f, 438.5f)
                curveTo(469.8f, 451.0f, 490.1f, 451.0f, 502.6f, 438.5f)
                close()
            }
        }
        .build()
        return `_arrows-left-right`!!
    }

private var `_arrows-left-right`: ImageVector? = null
