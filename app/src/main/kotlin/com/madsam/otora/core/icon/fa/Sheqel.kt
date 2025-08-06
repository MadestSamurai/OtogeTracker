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

public val Fa.Sheqel: ImageVector
    get() {
        if (_sheqel != null) {
            return _sheqel!!
        }
        _sheqel = Builder(name = "Sheqel", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 96.0f)
                curveTo(110.3f, 96.0f, 96.0f, 110.3f, 96.0f, 128.0f)
                lineTo(96.0f, 512.0f)
                curveTo(96.0f, 529.7f, 110.3f, 544.0f, 128.0f, 544.0f)
                curveTo(145.7f, 544.0f, 160.0f, 529.7f, 160.0f, 512.0f)
                lineTo(160.0f, 160.0f)
                lineTo(288.0f, 160.0f)
                curveTo(323.3f, 160.0f, 352.0f, 188.7f, 352.0f, 224.0f)
                lineTo(352.0f, 384.0f)
                curveTo(352.0f, 401.7f, 366.3f, 416.0f, 384.0f, 416.0f)
                curveTo(401.7f, 416.0f, 416.0f, 401.7f, 416.0f, 384.0f)
                lineTo(416.0f, 224.0f)
                curveTo(416.0f, 153.3f, 358.7f, 96.0f, 288.0f, 96.0f)
                lineTo(128.0f, 96.0f)
                close()
                moveTo(416.0f, 544.0f)
                curveTo(486.7f, 544.0f, 544.0f, 486.7f, 544.0f, 416.0f)
                lineTo(544.0f, 128.0f)
                curveTo(544.0f, 110.3f, 529.7f, 96.0f, 512.0f, 96.0f)
                curveTo(494.3f, 96.0f, 480.0f, 110.3f, 480.0f, 128.0f)
                lineTo(480.0f, 416.0f)
                curveTo(480.0f, 451.3f, 451.3f, 480.0f, 416.0f, 480.0f)
                lineTo(288.0f, 480.0f)
                lineTo(288.0f, 256.0f)
                curveTo(288.0f, 238.3f, 273.7f, 224.0f, 256.0f, 224.0f)
                curveTo(238.3f, 224.0f, 224.0f, 238.3f, 224.0f, 256.0f)
                lineTo(224.0f, 512.0f)
                curveTo(224.0f, 529.7f, 238.3f, 544.0f, 256.0f, 544.0f)
                lineTo(416.0f, 544.0f)
                close()
            }
        }
        .build()
        return _sheqel!!
    }

private var _sheqel: ImageVector? = null
