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

public val Fa.`Thumbs-up`: ImageVector
    get() {
        if (`_thumbs-up` != null) {
            return `_thumbs-up`!!
        }
        `_thumbs-up` = Builder(name = "Thumbs-up", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(144.0f, 224.0f)
                curveTo(161.7f, 224.0f, 176.0f, 238.3f, 176.0f, 256.0f)
                lineTo(176.0f, 512.0f)
                curveTo(176.0f, 529.7f, 161.7f, 544.0f, 144.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(78.3f, 544.0f, 64.0f, 529.7f, 64.0f, 512.0f)
                lineTo(64.0f, 256.0f)
                curveTo(64.0f, 238.3f, 78.3f, 224.0f, 96.0f, 224.0f)
                lineTo(144.0f, 224.0f)
                close()
                moveTo(334.6f, 80.0f)
                curveTo(361.9f, 80.0f, 384.0f, 102.1f, 384.0f, 129.4f)
                lineTo(384.0f, 133.6f)
                curveTo(384.0f, 140.4f, 382.7f, 147.2f, 380.2f, 153.5f)
                lineTo(352.0f, 224.0f)
                lineTo(512.0f, 224.0f)
                curveTo(538.5f, 224.0f, 560.0f, 245.5f, 560.0f, 272.0f)
                curveTo(560.0f, 291.7f, 548.1f, 308.6f, 531.1f, 316.0f)
                curveTo(548.1f, 323.4f, 560.0f, 340.3f, 560.0f, 360.0f)
                curveTo(560.0f, 383.4f, 543.2f, 402.9f, 521.0f, 407.1f)
                curveTo(525.4f, 414.4f, 528.0f, 422.9f, 528.0f, 432.0f)
                curveTo(528.0f, 454.2f, 513.0f, 472.8f, 492.6f, 478.3f)
                curveTo(494.8f, 483.8f, 496.0f, 489.8f, 496.0f, 496.0f)
                curveTo(496.0f, 522.5f, 474.5f, 544.0f, 448.0f, 544.0f)
                lineTo(360.1f, 544.0f)
                curveTo(323.8f, 544.0f, 288.5f, 531.6f, 260.2f, 508.9f)
                lineTo(248.0f, 499.2f)
                curveTo(232.8f, 487.1f, 224.0f, 468.7f, 224.0f, 449.2f)
                lineTo(224.0f, 262.6f)
                curveTo(224.0f, 247.7f, 227.5f, 233.0f, 234.1f, 219.7f)
                lineTo(290.3f, 107.3f)
                curveTo(298.7f, 90.6f, 315.8f, 80.0f, 334.6f, 80.0f)
                close()
            }
        }
        .build()
        return `_thumbs-up`!!
    }

private var `_thumbs-up`: ImageVector? = null
