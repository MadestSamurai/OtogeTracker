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

public val Fa.Hexagon: ImageVector
    get() {
        if (_hexagon != null) {
            return _hexagon!!
        }
        _hexagon = Builder(name = "Hexagon", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(65.5f, 284.3f)
                curveTo(52.8f, 306.5f, 52.8f, 333.7f, 65.5f, 355.8f)
                lineTo(161.7f, 523.9f)
                curveTo(174.5f, 546.3f, 198.4f, 560.1f, 224.2f, 560.1f)
                lineTo(415.8f, 560.1f)
                curveTo(441.6f, 560.1f, 465.5f, 546.3f, 478.3f, 523.9f)
                lineTo(574.5f, 355.8f)
                curveTo(587.2f, 333.6f, 587.2f, 306.4f, 574.5f, 284.3f)
                lineTo(478.3f, 116.2f)
                curveTo(465.5f, 93.8f, 441.6f, 80.0f, 415.8f, 80.0f)
                lineTo(224.2f, 80.0f)
                curveTo(198.4f, 80.0f, 174.5f, 93.8f, 161.7f, 116.2f)
                lineTo(65.5f, 284.3f)
                close()
            }
        }
        .build()
        return _hexagon!!
    }

private var _hexagon: ImageVector? = null
