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

public val Fa.Worm: ImageVector
    get() {
        if (_worm != null) {
            return _worm!!
        }
        _worm = Builder(name = "Worm", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 160.0f)
                curveTo(320.0f, 107.0f, 363.0f, 64.0f, 416.0f, 64.0f)
                lineTo(454.4f, 64.0f)
                curveTo(503.9f, 64.0f, 544.0f, 104.1f, 544.0f, 153.6f)
                lineTo(544.0f, 440.0f)
                curveTo(544.0f, 515.1f, 483.1f, 576.0f, 408.0f, 576.0f)
                curveTo(332.9f, 576.0f, 272.0f, 515.1f, 272.0f, 440.0f)
                lineTo(272.0f, 360.0f)
                curveTo(272.0f, 337.9f, 254.1f, 320.0f, 232.0f, 320.0f)
                curveTo(209.9f, 320.0f, 192.0f, 337.9f, 192.0f, 360.0f)
                lineTo(192.0f, 528.0f)
                curveTo(192.0f, 554.5f, 170.5f, 576.0f, 144.0f, 576.0f)
                curveTo(117.5f, 576.0f, 96.0f, 554.5f, 96.0f, 528.0f)
                lineTo(96.0f, 360.0f)
                curveTo(96.0f, 284.9f, 156.9f, 224.0f, 232.0f, 224.0f)
                curveTo(307.1f, 224.0f, 368.0f, 284.9f, 368.0f, 360.0f)
                lineTo(368.0f, 440.0f)
                curveTo(368.0f, 462.1f, 385.9f, 480.0f, 408.0f, 480.0f)
                curveTo(430.1f, 480.0f, 448.0f, 462.1f, 448.0f, 440.0f)
                lineTo(448.0f, 256.0f)
                lineTo(416.0f, 256.0f)
                curveTo(363.0f, 256.0f, 320.0f, 213.0f, 320.0f, 160.0f)
                close()
                moveTo(464.0f, 152.0f)
                curveTo(464.0f, 138.7f, 453.3f, 128.0f, 440.0f, 128.0f)
                curveTo(426.7f, 128.0f, 416.0f, 138.7f, 416.0f, 152.0f)
                curveTo(416.0f, 165.3f, 426.7f, 176.0f, 440.0f, 176.0f)
                curveTo(453.3f, 176.0f, 464.0f, 165.3f, 464.0f, 152.0f)
                close()
            }
        }
        .build()
        return _worm!!
    }

private var _worm: ImageVector? = null
