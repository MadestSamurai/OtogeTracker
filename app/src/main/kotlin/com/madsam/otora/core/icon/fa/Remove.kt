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

public val Fa.Remove: ImageVector
    get() {
        if (_remove != null) {
            return _remove!!
        }
        _remove = Builder(name = "Remove", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(183.1f, 137.4f)
                curveTo(170.6f, 124.9f, 150.3f, 124.9f, 137.8f, 137.4f)
                curveTo(125.3f, 149.9f, 125.3f, 170.2f, 137.8f, 182.7f)
                lineTo(275.2f, 320.0f)
                lineTo(137.9f, 457.4f)
                curveTo(125.4f, 469.9f, 125.4f, 490.2f, 137.9f, 502.7f)
                curveTo(150.4f, 515.2f, 170.7f, 515.2f, 183.2f, 502.7f)
                lineTo(320.5f, 365.3f)
                lineTo(457.9f, 502.6f)
                curveTo(470.4f, 515.1f, 490.7f, 515.1f, 503.2f, 502.6f)
                curveTo(515.7f, 490.1f, 515.7f, 469.8f, 503.2f, 457.3f)
                lineTo(365.8f, 320.0f)
                lineTo(503.1f, 182.6f)
                curveTo(515.6f, 170.1f, 515.6f, 149.8f, 503.1f, 137.3f)
                curveTo(490.6f, 124.8f, 470.3f, 124.8f, 457.8f, 137.3f)
                lineTo(320.5f, 274.7f)
                lineTo(183.1f, 137.4f)
                close()
            }
        }
        .build()
        return _remove!!
    }

private var _remove: ImageVector? = null
