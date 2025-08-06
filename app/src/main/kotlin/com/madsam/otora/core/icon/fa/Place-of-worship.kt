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

public val Fa.`Place-of-worship`: ImageVector
    get() {
        if (`_place-of-worship` != null) {
            return `_place-of-worship`!!
        }
        `_place-of-worship` = Builder(name = "Place-of-worship", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 143.0f)
                lineTo(224.0f, 224.0f)
                lineTo(179.2f, 257.6f)
                curveTo(167.1f, 266.7f, 160.0f, 280.9f, 160.0f, 296.0f)
                lineTo(160.0f, 336.0f)
                lineTo(99.4f, 366.3f)
                curveTo(77.7f, 377.2f, 64.0f, 399.3f, 64.0f, 423.6f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 547.3f, 92.7f, 576.0f, 128.0f, 576.0f)
                curveTo(202.7f, 576.0f, 213.4f, 576.0f, 448.0f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(547.3f, 576.0f, 576.0f, 547.3f, 576.0f, 512.0f)
                lineTo(576.0f, 423.6f)
                curveTo(576.0f, 399.4f, 562.3f, 377.2f, 540.6f, 366.4f)
                lineTo(480.0f, 336.0f)
                lineTo(480.0f, 296.0f)
                curveTo(480.0f, 280.9f, 472.9f, 266.7f, 460.8f, 257.6f)
                lineTo(416.0f, 224.0f)
                lineTo(416.0f, 143.0f)
                curveTo(416.0f, 133.5f, 411.8f, 124.5f, 404.5f, 118.4f)
                lineTo(335.4f, 60.8f)
                curveTo(326.5f, 53.4f, 313.6f, 53.4f, 304.7f, 60.8f)
                lineTo(235.5f, 118.4f)
                curveTo(228.2f, 124.5f, 224.0f, 133.5f, 224.0f, 143.0f)
                close()
                moveTo(320.0f, 384.0f)
                curveTo(355.3f, 384.0f, 384.0f, 412.7f, 384.0f, 448.0f)
                lineTo(384.0f, 528.0f)
                lineTo(256.0f, 528.0f)
                lineTo(256.0f, 448.0f)
                curveTo(256.0f, 412.7f, 284.7f, 384.0f, 320.0f, 384.0f)
                close()
            }
        }
        .build()
        return `_place-of-worship`!!
    }

private var `_place-of-worship`: ImageVector? = null
