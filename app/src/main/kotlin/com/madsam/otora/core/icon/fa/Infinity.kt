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

public val Fa.Infinity: ImageVector
    get() {
        if (_infinity != null) {
            return _infinity!!
        }
        _infinity = Builder(name = "Infinity", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 320.0f)
                curveTo(0.0f, 231.6f, 71.6f, 160.0f, 160.0f, 160.0f)
                curveTo(210.4f, 160.0f, 257.8f, 183.7f, 288.0f, 224.0f)
                lineTo(320.0f, 266.7f)
                lineTo(352.0f, 224.0f)
                curveTo(382.2f, 183.7f, 429.6f, 160.0f, 480.0f, 160.0f)
                curveTo(568.4f, 160.0f, 640.0f, 231.6f, 640.0f, 320.0f)
                curveTo(640.0f, 408.4f, 568.4f, 480.0f, 480.0f, 480.0f)
                curveTo(429.6f, 480.0f, 382.2f, 456.3f, 352.0f, 416.0f)
                lineTo(320.0f, 373.3f)
                lineTo(288.0f, 416.0f)
                curveTo(257.8f, 456.3f, 210.4f, 480.0f, 160.0f, 480.0f)
                curveTo(71.6f, 480.0f, 0.0f, 408.4f, 0.0f, 320.0f)
                close()
                moveTo(280.0f, 320.0f)
                lineTo(236.8f, 262.4f)
                curveTo(218.7f, 238.2f, 190.2f, 224.0f, 160.0f, 224.0f)
                curveTo(107.0f, 224.0f, 64.0f, 267.0f, 64.0f, 320.0f)
                curveTo(64.0f, 373.0f, 107.0f, 416.0f, 160.0f, 416.0f)
                curveTo(190.2f, 416.0f, 218.7f, 401.8f, 236.8f, 377.6f)
                lineTo(280.0f, 320.0f)
                close()
                moveTo(360.0f, 320.0f)
                lineTo(403.2f, 377.6f)
                curveTo(421.3f, 401.8f, 449.8f, 416.0f, 480.0f, 416.0f)
                curveTo(533.0f, 416.0f, 576.0f, 373.0f, 576.0f, 320.0f)
                curveTo(576.0f, 267.0f, 533.0f, 224.0f, 480.0f, 224.0f)
                curveTo(449.8f, 224.0f, 421.3f, 238.2f, 403.2f, 262.4f)
                lineTo(360.0f, 320.0f)
                close()
            }
        }
        .build()
        return _infinity!!
    }

private var _infinity: ImageVector? = null
