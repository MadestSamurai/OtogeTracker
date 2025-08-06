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

public val Fa.Poop: ImageVector
    get() {
        if (_poop != null) {
            return _poop!!
        }
        _poop = Builder(name = "Poop", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(318.4f, 70.6f)
                curveTo(321.9f, 66.3f, 327.4f, 64.1f, 332.9f, 64.9f)
                curveTo(379.8f, 71.2f, 416.0f, 111.4f, 416.0f, 160.0f)
                curveTo(416.0f, 171.2f, 414.1f, 182.0f, 410.5f, 192.0f)
                lineTo(416.0f, 192.0f)
                curveTo(451.3f, 192.0f, 480.0f, 220.7f, 480.0f, 256.0f)
                curveTo(480.0f, 275.1f, 471.6f, 292.3f, 458.3f, 304.0f)
                lineTo(472.0f, 304.0f)
                curveTo(511.8f, 304.0f, 544.0f, 336.2f, 544.0f, 376.0f)
                curveTo(544.0f, 399.2f, 533.0f, 419.8f, 516.0f, 433.0f)
                curveTo(550.1f, 438.7f, 576.0f, 468.3f, 576.0f, 504.0f)
                curveTo(576.0f, 543.8f, 543.8f, 576.0f, 504.0f, 576.0f)
                lineTo(136.0f, 576.0f)
                curveTo(96.2f, 576.0f, 64.0f, 543.8f, 64.0f, 504.0f)
                curveTo(64.0f, 468.3f, 89.9f, 438.7f, 124.0f, 433.0f)
                curveTo(107.0f, 419.8f, 96.0f, 399.2f, 96.0f, 376.0f)
                curveTo(96.0f, 336.2f, 128.2f, 304.0f, 168.0f, 304.0f)
                lineTo(181.7f, 304.0f)
                curveTo(168.4f, 292.3f, 160.0f, 275.1f, 160.0f, 256.0f)
                curveTo(160.0f, 220.7f, 188.7f, 192.0f, 224.0f, 192.0f)
                lineTo(240.2f, 192.0f)
                curveTo(284.3f, 191.9f, 320.0f, 156.1f, 320.0f, 112.0f)
                curveTo(320.0f, 102.8f, 318.5f, 94.1f, 315.7f, 85.9f)
                curveTo(313.9f, 80.7f, 314.9f, 74.8f, 318.5f, 70.5f)
                close()
            }
        }
        .build()
        return _poop!!
    }

private var _poop: ImageVector? = null
