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

public val Fa.`Plane-departure`: ImageVector
    get() {
        if (`_plane-departure` != null) {
            return `_plane-departure`!!
        }
        `_plane-departure` = Builder(name = "Plane-departure", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(404.0f, 207.9f)
                lineTo(204.7f, 104.2f)
                curveTo(196.7f, 100.1f, 187.4f, 99.4f, 179.0f, 102.5f)
                lineTo(137.9f, 117.5f)
                curveTo(127.6f, 121.2f, 124.1f, 133.9f, 130.8f, 142.5f)
                lineTo(232.3f, 270.4f)
                lineTo(132.1f, 306.8f)
                lineTo(72.0f, 270.2f)
                curveTo(65.8f, 266.4f, 58.2f, 265.7f, 51.3f, 268.1f)
                lineTo(35.0f, 274.1f)
                curveTo(25.6f, 277.5f, 21.6f, 288.6f, 26.7f, 297.2f)
                lineTo(80.3f, 389.0f)
                curveTo(95.9f, 415.7f, 128.4f, 427.4f, 157.4f, 416.8f)
                lineTo(170.3f, 412.1f)
                lineTo(170.3f, 412.1f)
                lineTo(568.7f, 267.1f)
                curveTo(597.8f, 256.5f, 612.7f, 224.4f, 602.2f, 195.3f)
                curveTo(591.7f, 166.2f, 559.5f, 151.3f, 530.4f, 161.8f)
                lineTo(404.0f, 207.9f)
                close()
                moveTo(64.2f, 512.0f)
                curveTo(46.5f, 512.0f, 32.2f, 526.3f, 32.2f, 544.0f)
                curveTo(32.2f, 561.7f, 46.5f, 576.0f, 64.2f, 576.0f)
                lineTo(576.2f, 576.0f)
                curveTo(593.9f, 576.0f, 608.2f, 561.7f, 608.2f, 544.0f)
                curveTo(608.2f, 526.3f, 593.9f, 512.0f, 576.2f, 512.0f)
                lineTo(64.2f, 512.0f)
                close()
            }
        }
        .build()
        return `_plane-departure`!!
    }

private var `_plane-departure`: ImageVector? = null
