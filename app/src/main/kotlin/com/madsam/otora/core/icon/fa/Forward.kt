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

public val Fa.Forward: ImageVector
    get() {
        if (_forward != null) {
            return _forward!!
        }
        _forward = Builder(name = "Forward", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(403.7f, 107.1f)
                curveTo(392.1f, 96.0f, 375.0f, 92.9f, 360.3f, 99.2f)
                curveTo(345.6f, 105.5f, 336.0f, 120.0f, 336.0f, 136.0f)
                lineTo(336.0f, 272.3f)
                lineTo(163.7f, 107.2f)
                curveTo(152.1f, 96.0f, 135.0f, 92.9f, 120.3f, 99.2f)
                curveTo(105.6f, 105.5f, 96.0f, 120.0f, 96.0f, 136.0f)
                lineTo(96.0f, 504.0f)
                curveTo(96.0f, 520.0f, 105.6f, 534.5f, 120.3f, 540.8f)
                curveTo(135.0f, 547.1f, 152.1f, 544.0f, 163.7f, 532.9f)
                lineTo(336.0f, 367.7f)
                lineTo(336.0f, 504.0f)
                curveTo(336.0f, 520.0f, 345.6f, 534.5f, 360.3f, 540.8f)
                curveTo(375.0f, 547.1f, 392.1f, 544.0f, 403.7f, 532.9f)
                lineTo(595.7f, 348.9f)
                curveTo(603.6f, 341.4f, 608.0f, 330.9f, 608.0f, 320.0f)
                curveTo(608.0f, 309.1f, 603.5f, 298.7f, 595.7f, 291.1f)
                lineTo(403.7f, 107.1f)
                close()
            }
        }
        .build()
        return _forward!!
    }

private var _forward: ImageVector? = null
