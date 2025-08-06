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

public val Fa.V: ImageVector
    get() {
        if (_v != null) {
            return _v!!
        }
        _v = Builder(name = "V", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(147.7f, 98.5f)
                curveTo(164.0f, 91.7f, 182.7f, 99.4f, 189.5f, 115.7f)
                lineTo(320.0f, 428.8f)
                lineTo(450.5f, 115.7f)
                curveTo(457.3f, 99.4f, 476.0f, 91.7f, 492.3f, 98.5f)
                curveTo(508.6f, 105.3f, 516.3f, 124.0f, 509.5f, 140.3f)
                lineTo(349.5f, 524.3f)
                curveTo(344.5f, 536.2f, 332.9f, 544.0f, 320.0f, 544.0f)
                curveTo(307.1f, 544.0f, 295.4f, 536.2f, 290.5f, 524.3f)
                lineTo(130.5f, 140.3f)
                curveTo(123.7f, 124.0f, 131.4f, 105.3f, 147.7f, 98.5f)
                close()
            }
        }
        .build()
        return _v!!
    }

private var _v: ImageVector? = null
