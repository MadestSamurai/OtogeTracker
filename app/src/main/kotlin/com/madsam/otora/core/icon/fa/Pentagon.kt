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

public val Fa.Pentagon: ImageVector
    get() {
        if (_pentagon != null) {
            return _pentagon!!
        }
        _pentagon = Builder(name = "Pentagon", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(348.4f, 60.9f)
                curveTo(331.6f, 48.7f, 308.8f, 48.7f, 292.0f, 60.9f)
                lineTo(67.3f, 224.2f)
                curveTo(50.5f, 236.4f, 43.4f, 258.1f, 49.9f, 277.9f)
                lineTo(135.7f, 542.0f)
                curveTo(142.1f, 561.8f, 160.6f, 575.2f, 181.4f, 575.2f)
                lineTo(459.1f, 575.2f)
                curveTo(479.9f, 575.2f, 498.3f, 561.8f, 504.8f, 542.0f)
                lineTo(590.6f, 277.9f)
                curveTo(597.0f, 258.1f, 590.0f, 236.5f, 573.2f, 224.2f)
                lineTo(348.4f, 60.9f)
                close()
            }
        }
        .build()
        return _pentagon!!
    }

private var _pentagon: ImageVector? = null
