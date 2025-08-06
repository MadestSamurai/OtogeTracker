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

public val Fa.`Glass-water-droplet`: ImageVector
    get() {
        if (`_glass-water-droplet` != null) {
            return `_glass-water-droplet`!!
        }
        `_glass-water-droplet` = Builder(name = "Glass-water-droplet", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 64.0f)
                curveTo(151.1f, 64.0f, 142.6f, 67.7f, 136.6f, 74.2f)
                curveTo(130.6f, 80.7f, 127.4f, 89.4f, 128.1f, 98.3f)
                lineTo(156.9f, 501.7f)
                curveTo(159.9f, 543.6f, 194.7f, 576.0f, 236.7f, 576.0f)
                lineTo(403.3f, 576.0f)
                curveTo(445.3f, 576.0f, 480.1f, 543.6f, 483.1f, 501.7f)
                lineTo(511.9f, 98.3f)
                curveTo(512.5f, 89.4f, 509.5f, 80.7f, 503.4f, 74.2f)
                curveTo(497.3f, 67.7f, 488.9f, 64.0f, 480.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                close()
                moveTo(211.0f, 361.5f)
                lineTo(194.4f, 128.0f)
                lineTo(445.6f, 128.0f)
                lineTo(429.0f, 361.5f)
                lineTo(416.0f, 368.0f)
                curveTo(395.9f, 378.1f, 372.1f, 378.1f, 352.0f, 368.0f)
                curveTo(331.9f, 357.9f, 308.1f, 357.9f, 288.0f, 368.0f)
                curveTo(267.9f, 378.1f, 244.1f, 378.1f, 224.0f, 368.0f)
                lineTo(211.0f, 361.5f)
                close()
                moveTo(384.0f, 260.0f)
                curveTo(384.0f, 236.0f, 350.3f, 189.9f, 331.8f, 166.5f)
                curveTo(325.7f, 158.8f, 314.3f, 158.8f, 308.2f, 166.5f)
                curveTo(289.7f, 189.9f, 256.0f, 236.0f, 256.0f, 260.0f)
                curveTo(256.0f, 293.1f, 284.7f, 320.0f, 320.0f, 320.0f)
                curveTo(355.3f, 320.0f, 384.0f, 293.1f, 384.0f, 260.0f)
                close()
            }
        }
        .build()
        return `_glass-water-droplet`!!
    }

private var `_glass-water-droplet`: ImageVector? = null
