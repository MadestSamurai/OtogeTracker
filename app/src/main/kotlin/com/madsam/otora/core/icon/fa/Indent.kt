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

public val Fa.Indent: ImageVector
    get() {
        if (_indent != null) {
            return _indent!!
        }
        _indent = Builder(name = "Indent", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(96.0f, 110.3f, 110.3f, 96.0f, 128.0f, 96.0f)
                lineTo(512.0f, 96.0f)
                curveTo(529.7f, 96.0f, 544.0f, 110.3f, 544.0f, 128.0f)
                curveTo(544.0f, 145.7f, 529.7f, 160.0f, 512.0f, 160.0f)
                lineTo(128.0f, 160.0f)
                curveTo(110.3f, 160.0f, 96.0f, 145.7f, 96.0f, 128.0f)
                close()
                moveTo(288.0f, 256.0f)
                curveTo(288.0f, 238.3f, 302.3f, 224.0f, 320.0f, 224.0f)
                lineTo(512.0f, 224.0f)
                curveTo(529.7f, 224.0f, 544.0f, 238.3f, 544.0f, 256.0f)
                curveTo(544.0f, 273.7f, 529.7f, 288.0f, 512.0f, 288.0f)
                lineTo(320.0f, 288.0f)
                curveTo(302.3f, 288.0f, 288.0f, 273.7f, 288.0f, 256.0f)
                close()
                moveTo(320.0f, 352.0f)
                lineTo(512.0f, 352.0f)
                curveTo(529.7f, 352.0f, 544.0f, 366.3f, 544.0f, 384.0f)
                curveTo(544.0f, 401.7f, 529.7f, 416.0f, 512.0f, 416.0f)
                lineTo(320.0f, 416.0f)
                curveTo(302.3f, 416.0f, 288.0f, 401.7f, 288.0f, 384.0f)
                curveTo(288.0f, 366.3f, 302.3f, 352.0f, 320.0f, 352.0f)
                close()
                moveTo(96.0f, 512.0f)
                curveTo(96.0f, 494.3f, 110.3f, 480.0f, 128.0f, 480.0f)
                lineTo(512.0f, 480.0f)
                curveTo(529.7f, 480.0f, 544.0f, 494.3f, 544.0f, 512.0f)
                curveTo(544.0f, 529.7f, 529.7f, 544.0f, 512.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(110.3f, 544.0f, 96.0f, 529.7f, 96.0f, 512.0f)
                close()
                moveTo(223.8f, 332.6f)
                lineTo(121.8f, 411.9f)
                curveTo(111.3f, 420.1f, 96.0f, 412.6f, 96.0f, 399.3f)
                lineTo(96.0f, 240.7f)
                curveTo(96.0f, 227.4f, 111.3f, 219.9f, 121.8f, 228.1f)
                lineTo(223.7f, 307.4f)
                curveTo(231.9f, 313.8f, 231.9f, 326.3f, 223.7f, 332.7f)
                close()
            }
        }
        .build()
        return _indent!!
    }

private var _indent: ImageVector? = null
