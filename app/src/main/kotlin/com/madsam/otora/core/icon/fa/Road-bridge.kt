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

public val Fa.`Road-bridge`: ImageVector
    get() {
        if (`_road-bridge` != null) {
            return `_road-bridge`!!
        }
        `_road-bridge` = Builder(name = "Road-bridge", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 96.0f)
                lineTo(272.0f, 96.0f)
                lineTo(272.0f, 160.0f)
                lineTo(248.0f, 160.0f)
                lineTo(248.0f, 224.0f)
                lineTo(272.0f, 224.0f)
                lineTo(272.0f, 353.3f)
                curveTo(226.6f, 360.9f, 192.0f, 400.4f, 192.0f, 448.0f)
                lineTo(192.0f, 512.0f)
                curveTo(192.0f, 529.7f, 177.7f, 544.0f, 160.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(110.3f, 544.0f, 96.0f, 529.7f, 96.0f, 512.0f)
                lineTo(96.0f, 418.0f)
                curveTo(96.0f, 379.2f, 69.6f, 345.4f, 32.0f, 336.0f)
                lineTo(32.0f, 224.0f)
                lineTo(72.0f, 224.0f)
                lineTo(72.0f, 160.0f)
                lineTo(64.0f, 160.0f)
                curveTo(46.3f, 160.0f, 32.0f, 145.7f, 32.0f, 128.0f)
                curveTo(32.0f, 110.3f, 46.3f, 96.0f, 64.0f, 96.0f)
                close()
                moveTo(120.0f, 160.0f)
                lineTo(120.0f, 224.0f)
                lineTo(200.0f, 224.0f)
                lineTo(200.0f, 160.0f)
                lineTo(120.0f, 160.0f)
                close()
                moveTo(368.0f, 96.0f)
                lineTo(440.0f, 96.0f)
                lineTo(440.0f, 168.0f)
                curveTo(440.0f, 181.3f, 450.7f, 192.0f, 464.0f, 192.0f)
                curveTo(477.3f, 192.0f, 488.0f, 181.3f, 488.0f, 168.0f)
                lineTo(488.0f, 96.0f)
                lineTo(560.0f, 96.0f)
                curveTo(586.5f, 96.0f, 608.0f, 117.5f, 608.0f, 144.0f)
                lineTo(608.0f, 496.0f)
                curveTo(608.0f, 522.5f, 586.5f, 544.0f, 560.0f, 544.0f)
                lineTo(488.0f, 544.0f)
                lineTo(488.0f, 472.0f)
                curveTo(488.0f, 458.7f, 477.3f, 448.0f, 464.0f, 448.0f)
                curveTo(450.7f, 448.0f, 440.0f, 458.7f, 440.0f, 472.0f)
                lineTo(440.0f, 544.0f)
                lineTo(368.0f, 544.0f)
                curveTo(341.5f, 544.0f, 320.0f, 522.5f, 320.0f, 496.0f)
                lineTo(320.0f, 144.0f)
                curveTo(320.0f, 117.5f, 341.5f, 96.0f, 368.0f, 96.0f)
                close()
                moveTo(464.0f, 256.0f)
                curveTo(450.7f, 256.0f, 440.0f, 266.7f, 440.0f, 280.0f)
                lineTo(440.0f, 360.0f)
                curveTo(440.0f, 373.3f, 450.7f, 384.0f, 464.0f, 384.0f)
                curveTo(477.3f, 384.0f, 488.0f, 373.3f, 488.0f, 360.0f)
                lineTo(488.0f, 280.0f)
                curveTo(488.0f, 266.7f, 477.3f, 256.0f, 464.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_road-bridge`!!
    }

private var `_road-bridge`: ImageVector? = null
