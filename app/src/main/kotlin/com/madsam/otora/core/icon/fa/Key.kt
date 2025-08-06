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

public val Fa.Key: ImageVector
    get() {
        if (_key != null) {
            return _key!!
        }
        _key = Builder(name = "Key", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(400.0f, 416.0f)
                curveTo(497.2f, 416.0f, 576.0f, 337.2f, 576.0f, 240.0f)
                curveTo(576.0f, 142.8f, 497.2f, 64.0f, 400.0f, 64.0f)
                curveTo(302.8f, 64.0f, 224.0f, 142.8f, 224.0f, 240.0f)
                curveTo(224.0f, 258.7f, 226.9f, 276.8f, 232.3f, 293.7f)
                lineTo(71.0f, 455.0f)
                curveTo(66.5f, 459.5f, 64.0f, 465.6f, 64.0f, 472.0f)
                lineTo(64.0f, 552.0f)
                curveTo(64.0f, 565.3f, 74.7f, 576.0f, 88.0f, 576.0f)
                lineTo(168.0f, 576.0f)
                curveTo(181.3f, 576.0f, 192.0f, 565.3f, 192.0f, 552.0f)
                lineTo(192.0f, 512.0f)
                lineTo(232.0f, 512.0f)
                curveTo(245.3f, 512.0f, 256.0f, 501.3f, 256.0f, 488.0f)
                lineTo(256.0f, 448.0f)
                lineTo(296.0f, 448.0f)
                curveTo(302.4f, 448.0f, 308.5f, 445.5f, 313.0f, 441.0f)
                lineTo(346.3f, 407.7f)
                curveTo(363.2f, 413.1f, 381.3f, 416.0f, 400.0f, 416.0f)
                close()
                moveTo(440.0f, 160.0f)
                curveTo(462.1f, 160.0f, 480.0f, 177.9f, 480.0f, 200.0f)
                curveTo(480.0f, 222.1f, 462.1f, 240.0f, 440.0f, 240.0f)
                curveTo(417.9f, 240.0f, 400.0f, 222.1f, 400.0f, 200.0f)
                curveTo(400.0f, 177.9f, 417.9f, 160.0f, 440.0f, 160.0f)
                close()
            }
        }
        .build()
        return _key!!
    }

private var _key: ImageVector? = null
