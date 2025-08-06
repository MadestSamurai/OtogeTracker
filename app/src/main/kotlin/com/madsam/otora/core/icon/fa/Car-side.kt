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

public val Fa.`Car-side`: ImageVector
    get() {
        if (`_car-side` != null) {
            return `_car-side`!!
        }
        `_car-side` = Builder(name = "Car-side", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(147.0f, 170.7f)
                lineTo(117.2f, 256.0f)
                lineTo(240.1f, 256.0f)
                lineTo(240.1f, 160.0f)
                lineTo(162.2f, 160.0f)
                curveTo(155.4f, 160.0f, 149.3f, 164.3f, 147.1f, 170.7f)
                close()
                moveTo(48.6f, 257.9f)
                lineTo(86.5f, 149.6f)
                curveTo(97.8f, 117.5f, 128.1f, 96.0f, 162.1f, 96.0f)
                lineTo(360.0f, 96.0f)
                curveTo(385.2f, 96.0f, 408.9f, 107.9f, 424.0f, 128.0f)
                lineTo(520.2f, 256.3f)
                curveTo(587.1f, 260.5f, 640.0f, 316.1f, 640.0f, 384.0f)
                lineTo(640.0f, 400.0f)
                curveTo(640.0f, 435.3f, 611.3f, 464.0f, 576.0f, 464.0f)
                lineTo(559.6f, 464.0f)
                curveTo(555.6f, 508.9f, 517.9f, 544.0f, 472.0f, 544.0f)
                curveTo(426.1f, 544.0f, 388.4f, 508.9f, 384.4f, 464.0f)
                lineTo(239.7f, 464.0f)
                curveTo(235.7f, 508.9f, 198.0f, 544.0f, 152.1f, 544.0f)
                curveTo(106.2f, 544.0f, 68.5f, 508.9f, 64.5f, 464.0f)
                lineTo(64.1f, 464.0f)
                curveTo(28.8f, 464.0f, 0.1f, 435.3f, 0.1f, 400.0f)
                lineTo(0.1f, 320.0f)
                curveTo(0.1f, 289.9f, 20.8f, 264.7f, 48.7f, 257.9f)
                close()
                moveTo(440.0f, 256.0f)
                lineTo(372.8f, 166.4f)
                curveTo(369.8f, 162.4f, 365.0f, 160.0f, 360.0f, 160.0f)
                lineTo(288.0f, 160.0f)
                lineTo(288.0f, 256.0f)
                lineTo(440.0f, 256.0f)
                close()
                moveTo(152.0f, 496.0f)
                curveTo(174.1f, 496.0f, 192.0f, 478.1f, 192.0f, 456.0f)
                curveTo(192.0f, 433.9f, 174.1f, 416.0f, 152.0f, 416.0f)
                curveTo(129.9f, 416.0f, 112.0f, 433.9f, 112.0f, 456.0f)
                curveTo(112.0f, 478.1f, 129.9f, 496.0f, 152.0f, 496.0f)
                close()
                moveTo(512.0f, 456.0f)
                curveTo(512.0f, 433.9f, 494.1f, 416.0f, 472.0f, 416.0f)
                curveTo(449.9f, 416.0f, 432.0f, 433.9f, 432.0f, 456.0f)
                curveTo(432.0f, 478.1f, 449.9f, 496.0f, 472.0f, 496.0f)
                curveTo(494.1f, 496.0f, 512.0f, 478.1f, 512.0f, 456.0f)
                close()
            }
        }
        .build()
        return `_car-side`!!
    }

private var `_car-side`: ImageVector? = null
