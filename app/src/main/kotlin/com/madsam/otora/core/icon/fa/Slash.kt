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

public val Fa.Slash: ImageVector
    get() {
        if (_slash != null) {
            return _slash!!
        }
        _slash = Builder(name = "Slash", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(39.0f, 39.0f)
                curveTo(48.4f, 29.6f, 63.6f, 29.6f, 72.9f, 39.0f)
                lineTo(601.0f, 567.0f)
                curveTo(610.4f, 576.4f, 610.4f, 591.6f, 601.0f, 600.9f)
                curveTo(591.6f, 610.2f, 576.4f, 610.3f, 567.1f, 600.9f)
                lineTo(39.0f, 73.0f)
                curveTo(29.7f, 63.6f, 29.7f, 48.4f, 39.0f, 39.0f)
                close()
            }
        }
        .build()
        return _slash!!
    }

private var _slash: ImageVector? = null
