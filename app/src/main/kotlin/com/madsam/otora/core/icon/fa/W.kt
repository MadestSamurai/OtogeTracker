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

public val Fa.W: ImageVector
    get() {
        if (_w != null) {
            return _w!!
        }
        _w = Builder(name = "W", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(52.8f, 98.0f)
                curveTo(69.3f, 91.8f, 87.8f, 100.2f, 94.0f, 116.7f)
                lineTo(204.2f, 410.7f)
                lineTo(289.3f, 119.0f)
                curveTo(293.3f, 105.3f, 305.8f, 96.0f, 320.0f, 96.0f)
                curveTo(334.2f, 96.0f, 346.7f, 105.4f, 350.7f, 119.0f)
                lineTo(435.8f, 410.7f)
                lineTo(546.0f, 116.8f)
                curveTo(552.2f, 100.3f, 570.6f, 91.9f, 587.2f, 98.1f)
                curveTo(603.8f, 104.3f, 612.2f, 122.7f, 606.0f, 139.2f)
                lineTo(462.0f, 523.2f)
                curveTo(457.2f, 536.1f, 444.6f, 544.5f, 430.8f, 543.9f)
                curveTo(417.0f, 543.3f, 405.1f, 534.1f, 401.3f, 520.9f)
                lineTo(320.0f, 242.3f)
                lineTo(238.7f, 521.0f)
                curveTo(234.8f, 534.2f, 222.9f, 543.5f, 209.2f, 544.0f)
                curveTo(195.5f, 544.5f, 182.9f, 536.2f, 178.0f, 523.3f)
                lineTo(34.0f, 139.2f)
                curveTo(27.8f, 122.7f, 36.2f, 104.2f, 52.8f, 98.0f)
                close()
            }
        }
        .build()
        return _w!!
    }

private var _w: ImageVector? = null
