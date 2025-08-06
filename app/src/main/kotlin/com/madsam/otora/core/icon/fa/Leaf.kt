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

public val Fa.Leaf: ImageVector
    get() {
        if (_leaf != null) {
            return _leaf!!
        }
        _leaf = Builder(name = "Leaf", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(535.3f, 70.7f)
                curveTo(541.7f, 64.6f, 551.0f, 62.4f, 559.6f, 65.2f)
                curveTo(569.4f, 68.5f, 576.0f, 77.7f, 576.0f, 88.0f)
                lineTo(576.0f, 274.9f)
                curveTo(576.0f, 406.1f, 467.9f, 512.0f, 337.2f, 512.0f)
                curveTo(260.2f, 512.0f, 193.8f, 462.5f, 169.7f, 393.3f)
                curveTo(134.3f, 424.1f, 112.0f, 469.4f, 112.0f, 520.0f)
                curveTo(112.0f, 533.3f, 101.3f, 544.0f, 88.0f, 544.0f)
                curveTo(74.7f, 544.0f, 64.0f, 533.3f, 64.0f, 520.0f)
                curveTo(64.0f, 445.1f, 102.2f, 379.1f, 160.1f, 340.3f)
                curveTo(195.4f, 316.7f, 237.5f, 304.0f, 280.0f, 304.0f)
                lineTo(360.0f, 304.0f)
                curveTo(373.3f, 304.0f, 384.0f, 293.3f, 384.0f, 280.0f)
                curveTo(384.0f, 266.7f, 373.3f, 256.0f, 360.0f, 256.0f)
                lineTo(280.0f, 256.0f)
                curveTo(240.3f, 256.0f, 202.7f, 264.8f, 169.0f, 280.5f)
                curveTo(192.3f, 210.5f, 258.2f, 160.0f, 336.0f, 160.0f)
                curveTo(402.4f, 160.0f, 451.8f, 137.9f, 484.7f, 116.0f)
                curveTo(503.9f, 103.2f, 520.2f, 87.9f, 535.4f, 70.7f)
                close()
            }
        }
        .build()
        return _leaf!!
    }

private var _leaf: ImageVector? = null
