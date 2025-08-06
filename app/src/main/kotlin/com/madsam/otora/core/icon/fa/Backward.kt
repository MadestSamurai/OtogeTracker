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

public val Fa.Backward: ImageVector
    get() {
        if (_backward != null) {
            return _backward!!
        }
        _backward = Builder(name = "Backward", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(236.3f, 107.1f)
                curveTo(247.9f, 96.0f, 265.0f, 92.9f, 279.7f, 99.2f)
                curveTo(294.4f, 105.5f, 304.0f, 120.0f, 304.0f, 136.0f)
                lineTo(304.0f, 272.3f)
                lineTo(476.3f, 107.2f)
                curveTo(487.9f, 96.0f, 505.0f, 92.9f, 519.7f, 99.2f)
                curveTo(534.4f, 105.5f, 544.0f, 120.0f, 544.0f, 136.0f)
                lineTo(544.0f, 504.0f)
                curveTo(544.0f, 520.0f, 534.4f, 534.5f, 519.7f, 540.8f)
                curveTo(505.0f, 547.1f, 487.9f, 544.0f, 476.3f, 532.9f)
                lineTo(304.0f, 367.7f)
                lineTo(304.0f, 504.0f)
                curveTo(304.0f, 520.0f, 294.4f, 534.5f, 279.7f, 540.8f)
                curveTo(265.0f, 547.1f, 247.9f, 544.0f, 236.3f, 532.9f)
                lineTo(44.3f, 348.9f)
                curveTo(36.5f, 341.3f, 32.0f, 330.9f, 32.0f, 320.0f)
                curveTo(32.0f, 309.1f, 36.5f, 298.7f, 44.3f, 291.1f)
                lineTo(236.3f, 107.1f)
                close()
            }
        }
        .build()
        return _backward!!
    }

private var _backward: ImageVector? = null
