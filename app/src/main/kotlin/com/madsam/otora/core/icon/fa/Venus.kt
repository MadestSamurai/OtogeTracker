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

public val Fa.Venus: ImageVector
    get() {
        if (_venus != null) {
            return _venus!!
        }
        _venus = Builder(name = "Venus", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.0f, 240.0f)
                curveTo(208.0f, 178.1f, 258.1f, 128.0f, 320.0f, 128.0f)
                curveTo(381.9f, 128.0f, 432.0f, 178.1f, 432.0f, 240.0f)
                curveTo(432.0f, 301.9f, 381.9f, 352.0f, 320.0f, 352.0f)
                curveTo(258.1f, 352.0f, 208.0f, 301.9f, 208.0f, 240.0f)
                close()
                moveTo(351.9f, 413.1f)
                curveTo(433.9f, 398.1f, 496.0f, 326.3f, 496.0f, 240.0f)
                curveTo(496.0f, 142.8f, 417.2f, 64.0f, 320.0f, 64.0f)
                curveTo(222.8f, 64.0f, 144.0f, 142.8f, 144.0f, 240.0f)
                curveTo(144.0f, 326.3f, 206.1f, 398.1f, 288.1f, 413.1f)
                curveTo(288.0f, 414.1f, 288.0f, 415.0f, 288.0f, 416.0f)
                lineTo(288.0f, 480.0f)
                lineTo(256.0f, 480.0f)
                curveTo(238.3f, 480.0f, 224.0f, 494.3f, 224.0f, 512.0f)
                curveTo(224.0f, 529.7f, 238.3f, 544.0f, 256.0f, 544.0f)
                lineTo(288.0f, 544.0f)
                lineTo(288.0f, 576.0f)
                curveTo(288.0f, 593.7f, 302.3f, 608.0f, 320.0f, 608.0f)
                curveTo(337.7f, 608.0f, 352.0f, 593.7f, 352.0f, 576.0f)
                lineTo(352.0f, 544.0f)
                lineTo(384.0f, 544.0f)
                curveTo(401.7f, 544.0f, 416.0f, 529.7f, 416.0f, 512.0f)
                curveTo(416.0f, 494.3f, 401.7f, 480.0f, 384.0f, 480.0f)
                lineTo(352.0f, 480.0f)
                lineTo(352.0f, 416.0f)
                curveTo(352.0f, 415.0f, 352.0f, 414.1f, 351.9f, 413.1f)
                close()
            }
        }
        .build()
        return _venus!!
    }

private var _venus: ImageVector? = null
