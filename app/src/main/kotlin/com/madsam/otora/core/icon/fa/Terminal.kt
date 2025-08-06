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

public val Fa.Terminal: ImageVector
    get() {
        if (_terminal != null) {
            return _terminal!!
        }
        _terminal = Builder(name = "Terminal", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.4f, 182.6f)
                curveTo(60.9f, 170.1f, 60.9f, 149.8f, 73.4f, 137.3f)
                curveTo(85.9f, 124.8f, 106.2f, 124.8f, 118.7f, 137.3f)
                lineTo(278.7f, 297.3f)
                curveTo(291.2f, 309.8f, 291.2f, 330.1f, 278.7f, 342.6f)
                lineTo(118.7f, 502.6f)
                curveTo(106.2f, 515.1f, 85.9f, 515.1f, 73.4f, 502.6f)
                curveTo(60.9f, 490.1f, 60.9f, 469.8f, 73.4f, 457.3f)
                lineTo(210.7f, 320.0f)
                lineTo(73.4f, 182.6f)
                close()
                moveTo(288.0f, 448.0f)
                lineTo(544.0f, 448.0f)
                curveTo(561.7f, 448.0f, 576.0f, 462.3f, 576.0f, 480.0f)
                curveTo(576.0f, 497.7f, 561.7f, 512.0f, 544.0f, 512.0f)
                lineTo(288.0f, 512.0f)
                curveTo(270.3f, 512.0f, 256.0f, 497.7f, 256.0f, 480.0f)
                curveTo(256.0f, 462.3f, 270.3f, 448.0f, 288.0f, 448.0f)
                close()
            }
        }
        .build()
        return _terminal!!
    }

private var _terminal: ImageVector? = null
