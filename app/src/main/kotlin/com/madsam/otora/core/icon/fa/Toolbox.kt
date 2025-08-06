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

public val Fa.Toolbox: ImageVector
    get() {
        if (_toolbox != null) {
            return _toolbox!!
        }
        _toolbox = Builder(name = "Toolbox", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(240.0f, 120.0f)
                lineTo(240.0f, 160.0f)
                lineTo(400.0f, 160.0f)
                lineTo(400.0f, 120.0f)
                curveTo(400.0f, 115.6f, 396.4f, 112.0f, 392.0f, 112.0f)
                lineTo(248.0f, 112.0f)
                curveTo(243.6f, 112.0f, 240.0f, 115.6f, 240.0f, 120.0f)
                close()
                moveTo(192.0f, 160.0f)
                lineTo(192.0f, 120.0f)
                curveTo(192.0f, 89.1f, 217.1f, 64.0f, 248.0f, 64.0f)
                lineTo(392.0f, 64.0f)
                curveTo(422.9f, 64.0f, 448.0f, 89.1f, 448.0f, 120.0f)
                lineTo(448.0f, 160.0f)
                lineTo(476.1f, 160.0f)
                curveTo(488.8f, 160.0f, 501.0f, 165.1f, 510.0f, 174.1f)
                lineTo(561.9f, 226.0f)
                curveTo(570.9f, 235.0f, 576.0f, 247.2f, 576.0f, 259.9f)
                lineTo(576.0f, 336.0f)
                lineTo(440.0f, 336.0f)
                lineTo(440.0f, 320.0f)
                curveTo(440.0f, 306.7f, 429.3f, 296.0f, 416.0f, 296.0f)
                curveTo(402.7f, 296.0f, 392.0f, 306.7f, 392.0f, 320.0f)
                lineTo(392.0f, 336.0f)
                lineTo(248.0f, 336.0f)
                lineTo(248.0f, 320.0f)
                curveTo(248.0f, 306.7f, 237.3f, 296.0f, 224.0f, 296.0f)
                curveTo(210.7f, 296.0f, 200.0f, 306.7f, 200.0f, 320.0f)
                lineTo(200.0f, 336.0f)
                lineTo(64.0f, 336.0f)
                lineTo(64.0f, 259.9f)
                curveTo(64.0f, 247.2f, 69.1f, 235.0f, 78.1f, 226.0f)
                lineTo(130.0f, 174.1f)
                curveTo(139.0f, 165.1f, 151.2f, 160.0f, 163.9f, 160.0f)
                lineTo(192.0f, 160.0f)
                close()
                moveTo(64.0f, 480.0f)
                lineTo(64.0f, 384.0f)
                lineTo(200.0f, 384.0f)
                lineTo(200.0f, 400.0f)
                curveTo(200.0f, 413.3f, 210.7f, 424.0f, 224.0f, 424.0f)
                curveTo(237.3f, 424.0f, 248.0f, 413.3f, 248.0f, 400.0f)
                lineTo(248.0f, 384.0f)
                lineTo(392.0f, 384.0f)
                lineTo(392.0f, 400.0f)
                curveTo(392.0f, 413.3f, 402.7f, 424.0f, 416.0f, 424.0f)
                curveTo(429.3f, 424.0f, 440.0f, 413.3f, 440.0f, 400.0f)
                lineTo(440.0f, 384.0f)
                lineTo(576.0f, 384.0f)
                lineTo(576.0f, 480.0f)
                curveTo(576.0f, 515.3f, 547.3f, 544.0f, 512.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(92.7f, 544.0f, 64.0f, 515.3f, 64.0f, 480.0f)
                close()
            }
        }
        .build()
        return _toolbox!!
    }

private var _toolbox: ImageVector? = null
