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

public val Fa.Mitten: ImageVector
    get() {
        if (_mitten != null) {
            return _mitten!!
        }
        _mitten = Builder(name = "Mitten", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(448.0f, 448.0f)
                lineTo(160.0f, 448.0f)
                lineTo(101.4f, 242.9f)
                curveTo(97.8f, 230.4f, 96.0f, 217.4f, 96.0f, 204.3f)
                curveTo(96.0f, 126.8f, 158.8f, 64.0f, 236.3f, 64.0f)
                lineTo(239.7f, 64.0f)
                curveTo(305.7f, 64.0f, 363.2f, 108.9f, 379.2f, 172.9f)
                lineTo(410.6f, 298.7f)
                lineTo(428.2f, 278.6f)
                curveTo(440.8f, 264.2f, 458.9f, 256.0f, 478.0f, 256.0f)
                lineTo(480.8f, 256.0f)
                curveTo(515.7f, 256.0f, 544.1f, 284.3f, 544.1f, 319.3f)
                curveTo(544.1f, 335.2f, 538.1f, 350.5f, 527.3f, 362.2f)
                lineTo(448.0f, 448.0f)
                close()
                moveTo(128.0f, 528.0f)
                curveTo(128.0f, 510.3f, 142.3f, 496.0f, 160.0f, 496.0f)
                lineTo(448.0f, 496.0f)
                curveTo(465.7f, 496.0f, 480.0f, 510.3f, 480.0f, 528.0f)
                lineTo(480.0f, 544.0f)
                curveTo(480.0f, 561.7f, 465.7f, 576.0f, 448.0f, 576.0f)
                lineTo(160.0f, 576.0f)
                curveTo(142.3f, 576.0f, 128.0f, 561.7f, 128.0f, 544.0f)
                lineTo(128.0f, 528.0f)
                close()
            }
        }
        .build()
        return _mitten!!
    }

private var _mitten: ImageVector? = null
