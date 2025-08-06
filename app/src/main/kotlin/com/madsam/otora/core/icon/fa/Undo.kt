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

public val Fa.Undo: ImageVector
    get() {
        if (_undo != null) {
            return _undo!!
        }
        _undo = Builder(name = "Undo", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 128.0f)
                curveTo(263.2f, 128.0f, 212.1f, 152.7f, 176.9f, 192.0f)
                lineTo(224.0f, 192.0f)
                curveTo(241.7f, 192.0f, 256.0f, 206.3f, 256.0f, 224.0f)
                curveTo(256.0f, 241.7f, 241.7f, 256.0f, 224.0f, 256.0f)
                lineTo(96.0f, 256.0f)
                curveTo(78.3f, 256.0f, 64.0f, 241.7f, 64.0f, 224.0f)
                lineTo(64.0f, 96.0f)
                curveTo(64.0f, 78.3f, 78.3f, 64.0f, 96.0f, 64.0f)
                curveTo(113.7f, 64.0f, 128.0f, 78.3f, 128.0f, 96.0f)
                lineTo(128.0f, 150.7f)
                curveTo(174.9f, 97.6f, 243.5f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(233.0f, 576.0f, 156.1f, 532.6f, 109.9f, 466.3f)
                curveTo(99.8f, 451.8f, 103.3f, 431.9f, 117.8f, 421.7f)
                curveTo(132.3f, 411.5f, 152.2f, 415.1f, 162.4f, 429.6f)
                curveTo(197.2f, 479.4f, 254.8f, 511.9f, 320.0f, 511.9f)
                curveTo(426.0f, 511.9f, 512.0f, 425.9f, 512.0f, 319.9f)
                curveTo(512.0f, 213.9f, 426.0f, 128.0f, 320.0f, 128.0f)
                close()
            }
        }
        .build()
        return _undo!!
    }

private var _undo: ImageVector? = null
