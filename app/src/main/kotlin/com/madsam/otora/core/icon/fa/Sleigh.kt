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

public val Fa.Sleigh: ImageVector
    get() {
        if (_sleigh != null) {
            return _sleigh!!
        }
        _sleigh = Builder(name = "Sleigh", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 96.0f)
                curveTo(46.3f, 96.0f, 32.0f, 110.3f, 32.0f, 128.0f)
                curveTo(32.0f, 145.7f, 46.3f, 160.0f, 64.0f, 160.0f)
                lineTo(64.0f, 320.0f)
                curveTo(64.0f, 361.8f, 90.7f, 397.4f, 128.0f, 410.5f)
                lineTo(128.0f, 480.0f)
                lineTo(56.0f, 480.0f)
                curveTo(42.7f, 480.0f, 32.0f, 490.7f, 32.0f, 504.0f)
                curveTo(32.0f, 517.3f, 42.7f, 528.0f, 56.0f, 528.0f)
                lineTo(560.0f, 528.0f)
                curveTo(604.2f, 528.0f, 640.0f, 492.2f, 640.0f, 448.0f)
                lineTo(640.0f, 440.0f)
                curveTo(640.0f, 426.7f, 629.3f, 416.0f, 616.0f, 416.0f)
                curveTo(602.7f, 416.0f, 592.0f, 426.7f, 592.0f, 440.0f)
                lineTo(592.0f, 448.0f)
                curveTo(592.0f, 465.7f, 577.7f, 480.0f, 560.0f, 480.0f)
                lineTo(480.0f, 480.0f)
                lineTo(480.0f, 416.0f)
                curveTo(533.0f, 416.0f, 576.0f, 373.0f, 576.0f, 320.0f)
                lineTo(576.0f, 224.0f)
                curveTo(593.7f, 224.0f, 608.0f, 209.7f, 608.0f, 192.0f)
                curveTo(608.0f, 174.3f, 593.7f, 160.0f, 576.0f, 160.0f)
                lineTo(544.0f, 160.0f)
                curveTo(526.3f, 160.0f, 512.0f, 174.3f, 512.0f, 192.0f)
                lineTo(512.0f, 224.0f)
                curveTo(512.0f, 259.3f, 483.3f, 288.0f, 448.0f, 288.0f)
                lineTo(399.1f, 288.0f)
                curveTo(350.6f, 288.0f, 306.3f, 260.6f, 284.6f, 217.2f)
                lineTo(259.4f, 166.7f)
                curveTo(237.7f, 123.4f, 193.4f, 96.0f, 144.9f, 96.0f)
                lineTo(64.0f, 96.0f)
                close()
                moveTo(432.0f, 480.0f)
                lineTo(176.0f, 480.0f)
                lineTo(176.0f, 416.0f)
                lineTo(432.0f, 416.0f)
                lineTo(432.0f, 480.0f)
                close()
            }
        }
        .build()
        return _sleigh!!
    }

private var _sleigh: ImageVector? = null
