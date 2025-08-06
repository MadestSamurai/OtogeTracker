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

public val Fa.Fan: ImageVector
    get() {
        if (_fan != null) {
            return _fan!!
        }
        _fan = Builder(name = "Fan", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 208.0f)
                curveTo(224.0f, 128.5f, 288.5f, 64.0f, 368.0f, 64.0f)
                curveTo(376.8f, 64.0f, 384.0f, 71.2f, 384.0f, 80.0f)
                lineTo(384.0f, 232.2f)
                curveTo(399.0f, 226.9f, 415.2f, 224.0f, 432.0f, 224.0f)
                curveTo(511.5f, 224.0f, 576.0f, 288.5f, 576.0f, 368.0f)
                curveTo(576.0f, 376.8f, 568.8f, 384.0f, 560.0f, 384.0f)
                lineTo(407.8f, 384.0f)
                curveTo(413.1f, 399.0f, 416.0f, 415.2f, 416.0f, 432.0f)
                curveTo(416.0f, 511.5f, 351.5f, 576.0f, 272.0f, 576.0f)
                curveTo(263.2f, 576.0f, 256.0f, 568.8f, 256.0f, 560.0f)
                lineTo(256.0f, 407.8f)
                curveTo(241.0f, 413.1f, 224.8f, 416.0f, 208.0f, 416.0f)
                curveTo(128.5f, 416.0f, 64.0f, 351.5f, 64.0f, 272.0f)
                curveTo(64.0f, 263.2f, 71.2f, 256.0f, 80.0f, 256.0f)
                lineTo(232.2f, 256.0f)
                curveTo(226.9f, 241.0f, 224.0f, 224.8f, 224.0f, 208.0f)
                close()
                moveTo(320.0f, 352.0f)
                curveTo(337.7f, 352.0f, 352.0f, 337.7f, 352.0f, 320.0f)
                curveTo(352.0f, 302.3f, 337.7f, 288.0f, 320.0f, 288.0f)
                curveTo(302.3f, 288.0f, 288.0f, 302.3f, 288.0f, 320.0f)
                curveTo(288.0f, 337.7f, 302.3f, 352.0f, 320.0f, 352.0f)
                close()
            }
        }
        .build()
        return _fan!!
    }

private var _fan: ImageVector? = null
