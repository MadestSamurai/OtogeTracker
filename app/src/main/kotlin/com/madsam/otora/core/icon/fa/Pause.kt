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

public val Fa.Pause: ImageVector
    get() {
        if (_pause != null) {
            return _pause!!
        }
        _pause = Builder(name = "Pause", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(176.0f, 96.0f)
                curveTo(149.5f, 96.0f, 128.0f, 117.5f, 128.0f, 144.0f)
                lineTo(128.0f, 496.0f)
                curveTo(128.0f, 522.5f, 149.5f, 544.0f, 176.0f, 544.0f)
                lineTo(240.0f, 544.0f)
                curveTo(266.5f, 544.0f, 288.0f, 522.5f, 288.0f, 496.0f)
                lineTo(288.0f, 144.0f)
                curveTo(288.0f, 117.5f, 266.5f, 96.0f, 240.0f, 96.0f)
                lineTo(176.0f, 96.0f)
                close()
                moveTo(400.0f, 96.0f)
                curveTo(373.5f, 96.0f, 352.0f, 117.5f, 352.0f, 144.0f)
                lineTo(352.0f, 496.0f)
                curveTo(352.0f, 522.5f, 373.5f, 544.0f, 400.0f, 544.0f)
                lineTo(464.0f, 544.0f)
                curveTo(490.5f, 544.0f, 512.0f, 522.5f, 512.0f, 496.0f)
                lineTo(512.0f, 144.0f)
                curveTo(512.0f, 117.5f, 490.5f, 96.0f, 464.0f, 96.0f)
                lineTo(400.0f, 96.0f)
                close()
            }
        }
        .build()
        return _pause!!
    }

private var _pause: ImageVector? = null
