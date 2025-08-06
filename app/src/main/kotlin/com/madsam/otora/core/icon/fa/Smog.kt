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

public val Fa.Smog: ImageVector
    get() {
        if (_smog != null) {
            return _smog!!
        }
        _smog = Builder(name = "Smog", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.0f, 352.0f)
                curveTo(128.5f, 352.0f, 64.0f, 287.5f, 64.0f, 208.0f)
                curveTo(64.0f, 128.5f, 128.5f, 64.0f, 208.0f, 64.0f)
                curveTo(235.2f, 64.0f, 260.6f, 71.5f, 282.3f, 84.6f)
                curveTo(302.4f, 71.6f, 326.3f, 64.0f, 352.0f, 64.0f)
                curveTo(399.4f, 64.0f, 440.7f, 89.7f, 462.9f, 128.0f)
                lineTo(464.0f, 128.0f)
                curveTo(525.9f, 128.0f, 576.0f, 178.1f, 576.0f, 240.0f)
                curveTo(576.0f, 300.3f, 528.4f, 349.4f, 468.8f, 351.9f)
                curveTo(446.2f, 371.9f, 416.5f, 384.0f, 384.0f, 384.0f)
                curveTo(351.5f, 384.0f, 321.9f, 371.9f, 299.3f, 352.0f)
                lineTo(208.0f, 352.0f)
                close()
                moveTo(544.0f, 456.0f)
                curveTo(544.0f, 469.3f, 533.3f, 480.0f, 520.0f, 480.0f)
                lineTo(56.0f, 480.0f)
                curveTo(42.7f, 480.0f, 32.0f, 469.3f, 32.0f, 456.0f)
                curveTo(32.0f, 442.7f, 42.7f, 432.0f, 56.0f, 432.0f)
                lineTo(520.0f, 432.0f)
                curveTo(533.3f, 432.0f, 544.0f, 442.7f, 544.0f, 456.0f)
                close()
                moveTo(120.0f, 528.0f)
                lineTo(200.0f, 528.0f)
                curveTo(213.3f, 528.0f, 224.0f, 538.7f, 224.0f, 552.0f)
                curveTo(224.0f, 565.3f, 213.3f, 576.0f, 200.0f, 576.0f)
                lineTo(120.0f, 576.0f)
                curveTo(106.7f, 576.0f, 96.0f, 565.3f, 96.0f, 552.0f)
                curveTo(96.0f, 538.7f, 106.7f, 528.0f, 120.0f, 528.0f)
                close()
                moveTo(296.0f, 528.0f)
                lineTo(584.0f, 528.0f)
                curveTo(597.3f, 528.0f, 608.0f, 538.7f, 608.0f, 552.0f)
                curveTo(608.0f, 565.3f, 597.3f, 576.0f, 584.0f, 576.0f)
                lineTo(296.0f, 576.0f)
                curveTo(282.7f, 576.0f, 272.0f, 565.3f, 272.0f, 552.0f)
                curveTo(272.0f, 538.7f, 282.7f, 528.0f, 296.0f, 528.0f)
                close()
            }
        }
        .build()
        return _smog!!
    }

private var _smog: ImageVector? = null
