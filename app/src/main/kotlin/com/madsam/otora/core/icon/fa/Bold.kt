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

public val Fa.Bold: ImageVector
    get() {
        if (_bold != null) {
            return _bold!!
        }
        _bold = Builder(name = "Bold", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(142.3f, 96.0f, 128.0f, 110.3f, 128.0f, 128.0f)
                curveTo(128.0f, 145.7f, 142.3f, 160.0f, 160.0f, 160.0f)
                lineTo(192.0f, 160.0f)
                lineTo(192.0f, 480.0f)
                lineTo(160.0f, 480.0f)
                curveTo(142.3f, 480.0f, 128.0f, 494.3f, 128.0f, 512.0f)
                curveTo(128.0f, 529.7f, 142.3f, 544.0f, 160.0f, 544.0f)
                lineTo(384.0f, 544.0f)
                curveTo(454.7f, 544.0f, 512.0f, 486.7f, 512.0f, 416.0f)
                curveTo(512.0f, 369.5f, 487.2f, 328.7f, 450.0f, 306.3f)
                curveTo(468.7f, 284.0f, 480.0f, 255.3f, 480.0f, 224.0f)
                curveTo(480.0f, 153.3f, 422.7f, 96.0f, 352.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(416.0f, 224.0f)
                curveTo(416.0f, 259.3f, 387.3f, 288.0f, 352.0f, 288.0f)
                lineTo(256.0f, 288.0f)
                lineTo(256.0f, 160.0f)
                lineTo(352.0f, 160.0f)
                curveTo(387.3f, 160.0f, 416.0f, 188.7f, 416.0f, 224.0f)
                close()
                moveTo(256.0f, 480.0f)
                lineTo(256.0f, 352.0f)
                lineTo(384.0f, 352.0f)
                curveTo(419.3f, 352.0f, 448.0f, 380.7f, 448.0f, 416.0f)
                curveTo(448.0f, 451.3f, 419.3f, 480.0f, 384.0f, 480.0f)
                lineTo(256.0f, 480.0f)
                close()
            }
        }
        .build()
        return _bold!!
    }

private var _bold: ImageVector? = null
