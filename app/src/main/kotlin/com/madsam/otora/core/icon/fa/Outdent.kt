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

public val Fa.Outdent: ImageVector
    get() {
        if (_outdent != null) {
            return _outdent!!
        }
        _outdent = Builder(name = "Outdent", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.4f, 128.0f)
                curveTo(96.4f, 110.3f, 110.7f, 96.0f, 128.4f, 96.0f)
                lineTo(512.4f, 96.0f)
                curveTo(530.1f, 96.0f, 544.4f, 110.3f, 544.4f, 128.0f)
                curveTo(544.4f, 145.7f, 530.1f, 160.0f, 512.4f, 160.0f)
                lineTo(128.4f, 160.0f)
                curveTo(110.8f, 160.0f, 96.4f, 145.7f, 96.4f, 128.0f)
                close()
                moveTo(288.4f, 256.0f)
                curveTo(288.4f, 238.3f, 302.7f, 224.0f, 320.4f, 224.0f)
                lineTo(512.4f, 224.0f)
                curveTo(530.1f, 224.0f, 544.4f, 238.3f, 544.4f, 256.0f)
                curveTo(544.4f, 273.7f, 530.1f, 288.0f, 512.4f, 288.0f)
                lineTo(320.4f, 288.0f)
                curveTo(302.7f, 288.0f, 288.4f, 273.7f, 288.4f, 256.0f)
                close()
                moveTo(320.4f, 352.0f)
                lineTo(512.4f, 352.0f)
                curveTo(530.1f, 352.0f, 544.4f, 366.3f, 544.4f, 384.0f)
                curveTo(544.4f, 401.7f, 530.1f, 416.0f, 512.4f, 416.0f)
                lineTo(320.4f, 416.0f)
                curveTo(302.7f, 416.0f, 288.4f, 401.7f, 288.4f, 384.0f)
                curveTo(288.4f, 366.3f, 302.7f, 352.0f, 320.4f, 352.0f)
                close()
                moveTo(96.4f, 512.0f)
                curveTo(96.4f, 494.3f, 110.7f, 480.0f, 128.4f, 480.0f)
                lineTo(512.4f, 480.0f)
                curveTo(530.1f, 480.0f, 544.4f, 494.3f, 544.4f, 512.0f)
                curveTo(544.4f, 529.7f, 530.1f, 544.0f, 512.4f, 544.0f)
                lineTo(128.4f, 544.0f)
                curveTo(110.7f, 544.0f, 96.4f, 529.7f, 96.4f, 512.0f)
                close()
                moveTo(96.7f, 332.6f)
                curveTo(88.5f, 326.2f, 88.5f, 313.7f, 96.7f, 307.3f)
                lineTo(198.6f, 228.0f)
                curveTo(209.1f, 219.8f, 224.4f, 227.3f, 224.4f, 240.6f)
                lineTo(224.4f, 399.2f)
                curveTo(224.4f, 412.5f, 209.1f, 420.0f, 198.6f, 411.8f)
                lineTo(96.7f, 332.6f)
                close()
            }
        }
        .build()
        return _outdent!!
    }

private var _outdent: ImageVector? = null
