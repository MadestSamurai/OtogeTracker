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

public val Fa.Print: ImageVector
    get() {
        if (_print != null) {
            return _print!!
        }
        _print = Builder(name = "Print", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(128.0f, 92.7f, 156.7f, 64.0f, 192.0f, 64.0f)
                lineTo(405.5f, 64.0f)
                curveTo(422.5f, 64.0f, 438.8f, 70.7f, 450.8f, 82.7f)
                lineTo(493.3f, 125.2f)
                curveTo(505.3f, 137.2f, 512.0f, 153.5f, 512.0f, 170.5f)
                lineTo(512.0f, 208.0f)
                lineTo(128.0f, 208.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 284.7f, 92.7f, 256.0f, 128.0f, 256.0f)
                lineTo(512.0f, 256.0f)
                curveTo(547.3f, 256.0f, 576.0f, 284.7f, 576.0f, 320.0f)
                lineTo(576.0f, 416.0f)
                curveTo(576.0f, 433.7f, 561.7f, 448.0f, 544.0f, 448.0f)
                lineTo(512.0f, 448.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 547.3f, 483.3f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(156.7f, 576.0f, 128.0f, 547.3f, 128.0f, 512.0f)
                lineTo(128.0f, 448.0f)
                lineTo(96.0f, 448.0f)
                curveTo(78.3f, 448.0f, 64.0f, 433.7f, 64.0f, 416.0f)
                lineTo(64.0f, 320.0f)
                close()
                moveTo(192.0f, 480.0f)
                lineTo(192.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                lineTo(448.0f, 416.0f)
                lineTo(192.0f, 416.0f)
                lineTo(192.0f, 480.0f)
                close()
                moveTo(520.0f, 336.0f)
                curveTo(520.0f, 322.7f, 509.3f, 312.0f, 496.0f, 312.0f)
                curveTo(482.7f, 312.0f, 472.0f, 322.7f, 472.0f, 336.0f)
                curveTo(472.0f, 349.3f, 482.7f, 360.0f, 496.0f, 360.0f)
                curveTo(509.3f, 360.0f, 520.0f, 349.3f, 520.0f, 336.0f)
                close()
            }
        }
        .build()
        return _print!!
    }

private var _print: ImageVector? = null
