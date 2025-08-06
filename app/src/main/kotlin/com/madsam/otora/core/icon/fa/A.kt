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

public val Fa.A: ImageVector
    get() {
        if (_a != null) {
            return _a!!
        }
        _a = Builder(name = "A", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(349.5f, 115.7f)
                curveTo(344.6f, 103.8f, 332.9f, 96.0f, 320.0f, 96.0f)
                curveTo(307.1f, 96.0f, 295.4f, 103.8f, 290.5f, 115.7f)
                curveTo(197.2f, 339.7f, 143.8f, 467.7f, 130.5f, 499.7f)
                curveTo(123.7f, 516.0f, 131.4f, 534.7f, 147.7f, 541.5f)
                curveTo(164.0f, 548.3f, 182.7f, 540.6f, 189.5f, 524.3f)
                lineTo(221.3f, 448.0f)
                lineTo(418.6f, 448.0f)
                lineTo(450.4f, 524.3f)
                curveTo(457.2f, 540.6f, 475.9f, 548.3f, 492.2f, 541.5f)
                curveTo(508.5f, 534.7f, 516.2f, 516.0f, 509.4f, 499.7f)
                curveTo(496.1f, 467.7f, 442.7f, 339.7f, 349.4f, 115.7f)
                close()
                moveTo(392.0f, 384.0f)
                lineTo(248.0f, 384.0f)
                lineTo(320.0f, 211.2f)
                lineTo(392.0f, 384.0f)
                close()
            }
        }
        .build()
        return _a!!
    }

private var _a: ImageVector? = null
