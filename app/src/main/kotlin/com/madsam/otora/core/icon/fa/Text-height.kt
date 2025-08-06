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

public val Fa.`Text-height`: ImageVector
    get() {
        if (`_text-height` != null) {
            return `_text-height`!!
        }
        `_text-height` = Builder(name = "Text-height", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(72.0f, 96.0f)
                curveTo(49.9f, 96.0f, 32.0f, 113.9f, 32.0f, 136.0f)
                lineTo(32.0f, 192.0f)
                curveTo(32.0f, 209.7f, 46.3f, 224.0f, 64.0f, 224.0f)
                curveTo(81.7f, 224.0f, 96.0f, 209.7f, 96.0f, 192.0f)
                lineTo(96.0f, 160.0f)
                lineTo(160.0f, 160.0f)
                lineTo(160.0f, 480.0f)
                lineTo(128.0f, 480.0f)
                curveTo(110.3f, 480.0f, 96.0f, 494.3f, 96.0f, 512.0f)
                curveTo(96.0f, 529.7f, 110.3f, 544.0f, 128.0f, 544.0f)
                lineTo(256.0f, 544.0f)
                curveTo(273.7f, 544.0f, 288.0f, 529.7f, 288.0f, 512.0f)
                curveTo(288.0f, 494.3f, 273.7f, 480.0f, 256.0f, 480.0f)
                lineTo(224.0f, 480.0f)
                lineTo(224.0f, 160.0f)
                lineTo(288.0f, 160.0f)
                lineTo(288.0f, 192.0f)
                curveTo(288.0f, 209.7f, 302.3f, 224.0f, 320.0f, 224.0f)
                curveTo(337.7f, 224.0f, 352.0f, 209.7f, 352.0f, 192.0f)
                lineTo(352.0f, 136.0f)
                curveTo(352.0f, 113.9f, 334.1f, 96.0f, 312.0f, 96.0f)
                lineTo(72.0f, 96.0f)
                close()
                moveTo(470.6f, 425.4f)
                curveTo(458.1f, 412.9f, 437.8f, 412.9f, 425.3f, 425.4f)
                curveTo(412.8f, 437.9f, 412.8f, 458.2f, 425.3f, 470.7f)
                lineTo(489.3f, 534.7f)
                curveTo(501.8f, 547.2f, 522.1f, 547.2f, 534.6f, 534.7f)
                lineTo(598.6f, 470.7f)
                curveTo(611.1f, 458.2f, 611.1f, 437.9f, 598.6f, 425.4f)
                curveTo(586.1f, 412.9f, 565.8f, 412.9f, 553.3f, 425.4f)
                lineTo(543.9f, 434.8f)
                lineTo(543.9f, 205.3f)
                lineTo(553.3f, 214.7f)
                curveTo(565.8f, 227.2f, 586.1f, 227.2f, 598.6f, 214.7f)
                curveTo(611.1f, 202.2f, 611.1f, 181.9f, 598.6f, 169.4f)
                lineTo(534.6f, 105.4f)
                curveTo(528.6f, 99.4f, 520.5f, 96.0f, 512.0f, 96.0f)
                curveTo(503.5f, 96.0f, 495.4f, 99.4f, 489.4f, 105.4f)
                lineTo(425.4f, 169.4f)
                curveTo(412.9f, 181.9f, 412.9f, 202.2f, 425.4f, 214.7f)
                curveTo(437.9f, 227.2f, 458.2f, 227.2f, 470.7f, 214.7f)
                lineTo(480.1f, 205.3f)
                lineTo(480.1f, 434.8f)
                lineTo(470.7f, 425.4f)
                close()
            }
        }
        .build()
        return `_text-height`!!
    }

private var `_text-height`: ImageVector? = null
