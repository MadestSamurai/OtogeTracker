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

public val Fa.Euro: ImageVector
    get() {
        if (_euro != null) {
            return _euro!!
        }
        _euro = Builder(name = "Euro", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(169.3f, 256.0f)
                curveTo(196.8f, 163.5f, 282.5f, 96.0f, 384.0f, 96.0f)
                lineTo(448.0f, 96.0f)
                curveTo(465.7f, 96.0f, 480.0f, 110.3f, 480.0f, 128.0f)
                curveTo(480.0f, 145.7f, 465.7f, 160.0f, 448.0f, 160.0f)
                lineTo(384.0f, 160.0f)
                curveTo(318.4f, 160.0f, 262.0f, 199.5f, 237.3f, 256.0f)
                lineTo(368.0f, 256.0f)
                curveTo(381.3f, 256.0f, 392.0f, 266.7f, 392.0f, 280.0f)
                curveTo(392.0f, 293.3f, 381.3f, 304.0f, 368.0f, 304.0f)
                lineTo(224.8f, 304.0f)
                curveTo(224.3f, 309.3f, 224.0f, 314.6f, 224.0f, 320.0f)
                curveTo(224.0f, 325.4f, 224.3f, 330.7f, 224.8f, 336.0f)
                lineTo(368.0f, 336.0f)
                curveTo(381.3f, 336.0f, 392.0f, 346.7f, 392.0f, 360.0f)
                curveTo(392.0f, 373.3f, 381.3f, 384.0f, 368.0f, 384.0f)
                lineTo(237.3f, 384.0f)
                curveTo(262.0f, 440.5f, 318.4f, 480.0f, 384.0f, 480.0f)
                lineTo(448.0f, 480.0f)
                curveTo(465.7f, 480.0f, 480.0f, 494.3f, 480.0f, 512.0f)
                curveTo(480.0f, 529.7f, 465.7f, 544.0f, 448.0f, 544.0f)
                lineTo(384.0f, 544.0f)
                curveTo(282.5f, 544.0f, 196.8f, 476.5f, 169.3f, 384.0f)
                lineTo(136.0f, 384.0f)
                curveTo(122.7f, 384.0f, 112.0f, 373.3f, 112.0f, 360.0f)
                curveTo(112.0f, 346.7f, 122.7f, 336.0f, 136.0f, 336.0f)
                lineTo(160.6f, 336.0f)
                curveTo(159.9f, 325.5f, 159.9f, 314.5f, 160.6f, 304.0f)
                lineTo(136.0f, 304.0f)
                curveTo(122.7f, 304.0f, 112.0f, 293.3f, 112.0f, 280.0f)
                curveTo(112.0f, 266.7f, 122.7f, 256.0f, 136.0f, 256.0f)
                lineTo(169.3f, 256.0f)
                close()
            }
        }
        .build()
        return _euro!!
    }

private var _euro: ImageVector? = null
