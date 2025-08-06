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

public val Fa.Mask: ImageVector
    get() {
        if (_mask != null) {
            return _mask!!
        }
        _mask = Builder(name = "Mask", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 128.0f)
                curveTo(96.0f, 128.0f, 32.0f, 224.0f, 32.0f, 336.0f)
                curveTo(32.0f, 448.0f, 112.0f, 512.0f, 208.0f, 512.0f)
                lineTo(216.4f, 512.0f)
                curveTo(240.6f, 512.0f, 262.8f, 498.3f, 273.6f, 476.6f)
                lineTo(296.8f, 430.3f)
                curveTo(301.2f, 421.5f, 310.1f, 416.0f, 320.0f, 416.0f)
                curveTo(329.9f, 416.0f, 338.8f, 421.5f, 343.2f, 430.3f)
                lineTo(366.4f, 476.6f)
                curveTo(377.2f, 498.3f, 399.4f, 512.0f, 423.6f, 512.0f)
                lineTo(432.0f, 512.0f)
                curveTo(528.0f, 512.0f, 608.0f, 448.0f, 608.0f, 336.0f)
                curveTo(608.0f, 224.0f, 544.0f, 128.0f, 320.0f, 128.0f)
                close()
                moveTo(128.0f, 320.0f)
                curveTo(128.0f, 284.7f, 156.7f, 256.0f, 192.0f, 256.0f)
                curveTo(227.3f, 256.0f, 256.0f, 284.7f, 256.0f, 320.0f)
                curveTo(256.0f, 355.3f, 227.3f, 384.0f, 192.0f, 384.0f)
                curveTo(156.7f, 384.0f, 128.0f, 355.3f, 128.0f, 320.0f)
                close()
                moveTo(448.0f, 256.0f)
                curveTo(483.3f, 256.0f, 512.0f, 284.7f, 512.0f, 320.0f)
                curveTo(512.0f, 355.3f, 483.3f, 384.0f, 448.0f, 384.0f)
                curveTo(412.7f, 384.0f, 384.0f, 355.3f, 384.0f, 320.0f)
                curveTo(384.0f, 284.7f, 412.7f, 256.0f, 448.0f, 256.0f)
                close()
            }
        }
        .build()
        return _mask!!
    }

private var _mask: ImageVector? = null
