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

public val Fa.Mountain: ImageVector
    get() {
        if (_mountain != null) {
            return _mountain!!
        }
        _mountain = Builder(name = "Mountain", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.5f, 64.0f)
                curveTo(335.2f, 64.0f, 348.7f, 72.1f, 355.7f, 85.0f)
                lineTo(571.7f, 485.0f)
                curveTo(578.4f, 497.4f, 578.1f, 512.4f, 570.9f, 524.5f)
                curveTo(563.7f, 536.6f, 550.6f, 544.0f, 536.6f, 544.0f)
                lineTo(104.6f, 544.0f)
                curveTo(90.5f, 544.0f, 77.5f, 536.6f, 70.3f, 524.5f)
                curveTo(63.1f, 512.4f, 62.8f, 497.4f, 69.5f, 485.0f)
                lineTo(285.5f, 85.0f)
                lineTo(288.4f, 80.4f)
                curveTo(295.7f, 70.2f, 307.6f, 64.0f, 320.5f, 64.0f)
                close()
                moveTo(234.4f, 313.9f)
                lineTo(261.2f, 340.7f)
                curveTo(267.4f, 346.9f, 277.6f, 346.9f, 283.8f, 340.7f)
                lineTo(327.1f, 297.4f)
                curveTo(333.1f, 291.4f, 341.2f, 288.0f, 349.7f, 288.0f)
                lineTo(392.5f, 288.0f)
                lineTo(320.4f, 154.5f)
                lineTo(234.3f, 313.9f)
                close()
            }
        }
        .build()
        return _mountain!!
    }

private var _mountain: ImageVector? = null
