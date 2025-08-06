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

public val Fa.Gear: ImageVector
    get() {
        if (_gear != null) {
            return _gear!!
        }
        _gear = Builder(name = "Gear", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(259.1f, 73.5f)
                curveTo(262.1f, 58.7f, 275.2f, 48.0f, 290.4f, 48.0f)
                lineTo(350.2f, 48.0f)
                curveTo(365.4f, 48.0f, 378.5f, 58.7f, 381.5f, 73.5f)
                lineTo(396.0f, 143.5f)
                curveTo(410.1f, 149.5f, 423.3f, 157.2f, 435.3f, 166.3f)
                lineTo(503.1f, 143.8f)
                curveTo(517.5f, 139.0f, 533.3f, 145.0f, 540.9f, 158.2f)
                lineTo(570.8f, 210.0f)
                curveTo(578.4f, 223.2f, 575.7f, 239.8f, 564.3f, 249.9f)
                lineTo(511.0f, 297.3f)
                curveTo(511.9f, 304.7f, 512.3f, 312.3f, 512.3f, 320.0f)
                curveTo(512.3f, 327.7f, 511.8f, 335.3f, 511.0f, 342.7f)
                lineTo(564.4f, 390.2f)
                curveTo(575.8f, 400.3f, 578.4f, 417.0f, 570.9f, 430.1f)
                lineTo(541.0f, 481.9f)
                curveTo(533.4f, 495.0f, 517.6f, 501.1f, 503.2f, 496.3f)
                lineTo(435.4f, 473.8f)
                curveTo(423.3f, 482.9f, 410.1f, 490.5f, 396.1f, 496.6f)
                lineTo(381.7f, 566.5f)
                curveTo(378.6f, 581.4f, 365.5f, 592.0f, 350.4f, 592.0f)
                lineTo(290.6f, 592.0f)
                curveTo(275.4f, 592.0f, 262.3f, 581.3f, 259.3f, 566.5f)
                lineTo(244.9f, 496.6f)
                curveTo(230.8f, 490.6f, 217.7f, 482.9f, 205.6f, 473.8f)
                lineTo(137.5f, 496.3f)
                curveTo(123.1f, 501.1f, 107.3f, 495.1f, 99.7f, 481.9f)
                lineTo(69.8f, 430.1f)
                curveTo(62.2f, 416.9f, 64.9f, 400.3f, 76.3f, 390.2f)
                lineTo(129.7f, 342.7f)
                curveTo(128.8f, 335.3f, 128.4f, 327.7f, 128.4f, 320.0f)
                curveTo(128.4f, 312.3f, 128.9f, 304.7f, 129.7f, 297.3f)
                lineTo(76.3f, 249.8f)
                curveTo(64.9f, 239.7f, 62.3f, 223.0f, 69.8f, 209.9f)
                lineTo(99.7f, 158.1f)
                curveTo(107.3f, 144.9f, 123.1f, 138.9f, 137.5f, 143.7f)
                lineTo(205.3f, 166.2f)
                curveTo(217.4f, 157.1f, 230.6f, 149.5f, 244.6f, 143.4f)
                lineTo(259.1f, 73.5f)
                close()
                moveTo(320.3f, 400.0f)
                curveTo(364.5f, 399.8f, 400.2f, 363.9f, 400.0f, 319.7f)
                curveTo(399.8f, 275.5f, 363.9f, 239.8f, 319.7f, 240.0f)
                curveTo(275.5f, 240.2f, 239.8f, 276.1f, 240.0f, 320.3f)
                curveTo(240.2f, 364.5f, 276.1f, 400.2f, 320.3f, 400.0f)
                close()
            }
        }
        .build()
        return _gear!!
    }

private var _gear: ImageVector? = null
