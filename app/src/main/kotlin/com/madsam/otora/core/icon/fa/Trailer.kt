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

public val Fa.Trailer: ImageVector
    get() {
        if (_trailer != null) {
            return _trailer!!
        }
        _trailer = Builder(name = "Trailer", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 160.0f)
                curveTo(32.0f, 124.7f, 60.7f, 96.0f, 96.0f, 96.0f)
                lineTo(480.0f, 96.0f)
                curveTo(515.3f, 96.0f, 544.0f, 124.7f, 544.0f, 160.0f)
                lineTo(544.0f, 416.0f)
                lineTo(608.0f, 416.0f)
                curveTo(625.7f, 416.0f, 640.0f, 430.3f, 640.0f, 448.0f)
                curveTo(640.0f, 465.7f, 625.7f, 480.0f, 608.0f, 480.0f)
                lineTo(311.6f, 480.0f)
                curveTo(311.8f, 482.6f, 312.0f, 485.3f, 312.0f, 488.0f)
                curveTo(312.0f, 536.6f, 272.6f, 576.0f, 224.0f, 576.0f)
                curveTo(175.4f, 576.0f, 136.0f, 536.6f, 136.0f, 488.0f)
                curveTo(136.0f, 485.3f, 136.1f, 482.6f, 136.4f, 480.0f)
                lineTo(96.0f, 480.0f)
                curveTo(60.7f, 480.0f, 32.0f, 451.3f, 32.0f, 416.0f)
                lineTo(32.0f, 160.0f)
                close()
                moveTo(440.0f, 176.0f)
                curveTo(426.7f, 176.0f, 416.0f, 186.7f, 416.0f, 200.0f)
                lineTo(416.0f, 360.0f)
                curveTo(416.0f, 373.3f, 426.7f, 384.0f, 440.0f, 384.0f)
                curveTo(453.3f, 384.0f, 464.0f, 373.3f, 464.0f, 360.0f)
                lineTo(464.0f, 200.0f)
                curveTo(464.0f, 186.7f, 453.3f, 176.0f, 440.0f, 176.0f)
                close()
                moveTo(112.0f, 200.0f)
                lineTo(112.0f, 360.0f)
                curveTo(112.0f, 373.3f, 122.7f, 384.0f, 136.0f, 384.0f)
                curveTo(149.3f, 384.0f, 160.0f, 373.3f, 160.0f, 360.0f)
                lineTo(160.0f, 200.0f)
                curveTo(160.0f, 186.7f, 149.3f, 176.0f, 136.0f, 176.0f)
                curveTo(122.7f, 176.0f, 112.0f, 186.7f, 112.0f, 200.0f)
                close()
                moveTo(288.0f, 176.0f)
                curveTo(274.7f, 176.0f, 264.0f, 186.7f, 264.0f, 200.0f)
                lineTo(264.0f, 360.0f)
                curveTo(264.0f, 373.3f, 274.7f, 384.0f, 288.0f, 384.0f)
                curveTo(301.3f, 384.0f, 312.0f, 373.3f, 312.0f, 360.0f)
                lineTo(312.0f, 200.0f)
                curveTo(312.0f, 186.7f, 301.3f, 176.0f, 288.0f, 176.0f)
                close()
                moveTo(264.0f, 488.0f)
                curveTo(264.0f, 465.9f, 246.1f, 448.0f, 224.0f, 448.0f)
                curveTo(201.9f, 448.0f, 184.0f, 465.9f, 184.0f, 488.0f)
                curveTo(184.0f, 510.1f, 201.9f, 528.0f, 224.0f, 528.0f)
                curveTo(246.1f, 528.0f, 264.0f, 510.1f, 264.0f, 488.0f)
                close()
            }
        }
        .build()
        return _trailer!!
    }

private var _trailer: ImageVector? = null
