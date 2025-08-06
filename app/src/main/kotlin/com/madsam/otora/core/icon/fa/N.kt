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

public val Fa.N: ImageVector
    get() {
        if (_n != null) {
            return _n!!
        }
        _n = Builder(name = "N", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(149.1f, 97.9f)
                curveTo(161.8f, 93.3f, 176.0f, 97.2f, 184.6f, 107.5f)
                lineTo(448.0f, 423.6f)
                lineTo(448.0f, 128.0f)
                curveTo(448.0f, 110.3f, 462.3f, 96.0f, 480.0f, 96.0f)
                curveTo(497.7f, 96.0f, 512.0f, 110.3f, 512.0f, 128.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 525.5f, 503.6f, 537.5f, 490.9f, 542.1f)
                curveTo(478.2f, 546.7f, 464.0f, 542.8f, 455.4f, 532.5f)
                lineTo(192.0f, 216.4f)
                lineTo(192.0f, 512.0f)
                curveTo(192.0f, 529.7f, 177.7f, 544.0f, 160.0f, 544.0f)
                curveTo(142.3f, 544.0f, 128.0f, 529.7f, 128.0f, 512.0f)
                lineTo(128.0f, 128.0f)
                curveTo(128.0f, 114.5f, 136.4f, 102.5f, 149.1f, 97.9f)
                close()
            }
        }
        .build()
        return _n!!
    }

private var _n: ImageVector? = null
