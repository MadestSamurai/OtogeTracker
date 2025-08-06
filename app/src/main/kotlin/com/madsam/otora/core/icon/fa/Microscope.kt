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

public val Fa.Microscope: ImageVector
    get() {
        if (_microscope != null) {
            return _microscope!!
        }
        _microscope = Builder(name = "Microscope", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(240.0f, 64.0f)
                curveTo(213.5f, 64.0f, 192.0f, 85.5f, 192.0f, 112.0f)
                lineTo(192.0f, 320.0f)
                curveTo(192.0f, 346.5f, 213.5f, 368.0f, 240.0f, 368.0f)
                lineTo(304.0f, 368.0f)
                curveTo(330.5f, 368.0f, 352.0f, 346.5f, 352.0f, 320.0f)
                lineTo(352.0f, 256.0f)
                lineTo(384.0f, 256.0f)
                curveTo(454.7f, 256.0f, 512.0f, 313.3f, 512.0f, 384.0f)
                curveTo(512.0f, 454.7f, 454.7f, 512.0f, 384.0f, 512.0f)
                lineTo(96.0f, 512.0f)
                curveTo(78.3f, 512.0f, 64.0f, 526.3f, 64.0f, 544.0f)
                curveTo(64.0f, 561.7f, 78.3f, 576.0f, 96.0f, 576.0f)
                lineTo(544.0f, 576.0f)
                curveTo(561.7f, 576.0f, 576.0f, 561.7f, 576.0f, 544.0f)
                curveTo(576.0f, 526.3f, 561.7f, 512.0f, 544.0f, 512.0f)
                lineTo(527.1f, 512.0f)
                curveTo(557.5f, 478.0f, 576.0f, 433.2f, 576.0f, 384.0f)
                curveTo(576.0f, 278.0f, 490.0f, 192.0f, 384.0f, 192.0f)
                lineTo(352.0f, 192.0f)
                lineTo(352.0f, 112.0f)
                curveTo(352.0f, 85.5f, 330.5f, 64.0f, 304.0f, 64.0f)
                lineTo(240.0f, 64.0f)
                close()
                moveTo(184.0f, 416.0f)
                curveTo(170.7f, 416.0f, 160.0f, 426.7f, 160.0f, 440.0f)
                curveTo(160.0f, 453.3f, 170.7f, 464.0f, 184.0f, 464.0f)
                lineTo(360.0f, 464.0f)
                curveTo(373.3f, 464.0f, 384.0f, 453.3f, 384.0f, 440.0f)
                curveTo(384.0f, 426.7f, 373.3f, 416.0f, 360.0f, 416.0f)
                lineTo(184.0f, 416.0f)
                close()
            }
        }
        .build()
        return _microscope!!
    }

private var _microscope: ImageVector? = null
