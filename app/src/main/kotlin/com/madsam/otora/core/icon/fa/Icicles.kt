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

public val Fa.Icicles: ImageVector
    get() {
        if (_icicles != null) {
            return _icicles!!
        }
        _icicles = Builder(name = "Icicles", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(139.8f, 368.8f)
                lineTo(65.0f, 99.7f)
                curveTo(64.3f, 97.2f, 64.0f, 94.7f, 64.0f, 92.2f)
                curveTo(64.0f, 76.6f, 76.6f, 64.0f, 92.2f, 64.0f)
                lineTo(546.4f, 64.0f)
                curveTo(562.7f, 64.0f, 576.0f, 77.2f, 576.0f, 93.6f)
                curveTo(576.0f, 95.2f, 575.9f, 96.9f, 575.6f, 98.5f)
                lineTo(498.6f, 560.1f)
                curveTo(497.1f, 569.3f, 489.1f, 576.0f, 479.8f, 576.0f)
                curveTo(470.6f, 576.0f, 462.7f, 569.4f, 461.1f, 560.4f)
                lineTo(400.0f, 224.0f)
                lineTo(371.2f, 367.9f)
                curveTo(369.3f, 377.2f, 361.1f, 384.0f, 351.6f, 384.0f)
                curveTo(342.4f, 384.0f, 334.4f, 377.8f, 332.2f, 368.9f)
                lineTo(304.0f, 256.0f)
                lineTo(274.6f, 432.2f)
                curveTo(273.1f, 441.3f, 265.2f, 448.0f, 256.0f, 448.0f)
                curveTo(246.8f, 448.0f, 238.9f, 441.3f, 237.4f, 432.2f)
                lineTo(208.0f, 256.0f)
                lineTo(179.9f, 368.3f)
                curveTo(177.6f, 377.5f, 169.3f, 384.0f, 159.8f, 384.0f)
                curveTo(150.5f, 384.0f, 142.3f, 377.8f, 139.8f, 368.8f)
                close()
            }
        }
        .build()
        return _icicles!!
    }

private var _icicles: ImageVector? = null
