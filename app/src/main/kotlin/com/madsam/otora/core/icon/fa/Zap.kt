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

public val Fa.Zap: ImageVector
    get() {
        if (_zap != null) {
            return _zap!!
        }
        _zap = Builder(name = "Zap", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(434.8f, 54.1f)
                curveTo(446.7f, 62.7f, 451.1f, 78.3f, 445.7f, 91.9f)
                lineTo(367.3f, 288.0f)
                lineTo(512.0f, 288.0f)
                curveTo(525.5f, 288.0f, 537.5f, 296.4f, 542.1f, 309.1f)
                curveTo(546.7f, 321.8f, 542.8f, 336.0f, 532.5f, 344.6f)
                lineTo(244.5f, 584.6f)
                curveTo(233.2f, 594.0f, 217.1f, 594.5f, 205.2f, 585.9f)
                curveTo(193.3f, 577.3f, 188.9f, 561.7f, 194.3f, 548.1f)
                lineTo(272.7f, 352.0f)
                lineTo(128.0f, 352.0f)
                curveTo(114.5f, 352.0f, 102.5f, 343.6f, 97.9f, 330.9f)
                curveTo(93.3f, 318.2f, 97.2f, 304.0f, 107.5f, 295.4f)
                lineTo(395.5f, 55.4f)
                curveTo(406.8f, 46.0f, 422.9f, 45.5f, 434.8f, 54.1f)
                close()
            }
        }
        .build()
        return _zap!!
    }

private var _zap: ImageVector? = null
