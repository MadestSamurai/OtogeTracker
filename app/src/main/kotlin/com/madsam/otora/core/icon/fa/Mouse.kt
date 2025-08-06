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

public val Fa.Mouse: ImageVector
    get() {
        if (_mouse != null) {
            return _mouse!!
        }
        _mouse = Builder(name = "Mouse", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 256.0f)
                lineTo(296.0f, 256.0f)
                lineTo(296.0f, 64.0f)
                lineTo(288.0f, 64.0f)
                curveTo(199.6f, 64.0f, 128.0f, 135.6f, 128.0f, 224.0f)
                lineTo(128.0f, 256.0f)
                close()
                moveTo(128.0f, 304.0f)
                lineTo(128.0f, 416.0f)
                curveTo(128.0f, 504.4f, 199.6f, 576.0f, 288.0f, 576.0f)
                lineTo(352.0f, 576.0f)
                curveTo(440.4f, 576.0f, 512.0f, 504.4f, 512.0f, 416.0f)
                lineTo(512.0f, 304.0f)
                lineTo(128.0f, 304.0f)
                close()
                moveTo(512.0f, 256.0f)
                lineTo(512.0f, 224.0f)
                curveTo(512.0f, 135.6f, 440.4f, 64.0f, 352.0f, 64.0f)
                lineTo(344.0f, 64.0f)
                lineTo(344.0f, 256.0f)
                lineTo(512.0f, 256.0f)
                close()
            }
        }
        .build()
        return _mouse!!
    }

private var _mouse: ImageVector? = null
