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

public val Fa.Flag: ImageVector
    get() {
        if (_flag != null) {
            return _flag!!
        }
        _flag = Builder(name = "Flag", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(160.0f, 78.3f, 145.7f, 64.0f, 128.0f, 64.0f)
                curveTo(110.3f, 64.0f, 96.0f, 78.3f, 96.0f, 96.0f)
                lineTo(96.0f, 544.0f)
                curveTo(96.0f, 561.7f, 110.3f, 576.0f, 128.0f, 576.0f)
                curveTo(145.7f, 576.0f, 160.0f, 561.7f, 160.0f, 544.0f)
                lineTo(160.0f, 422.4f)
                lineTo(222.7f, 403.6f)
                curveTo(264.6f, 391.0f, 309.8f, 394.9f, 348.9f, 414.5f)
                curveTo(391.6f, 435.9f, 441.4f, 438.5f, 486.1f, 421.7f)
                lineTo(523.2f, 407.8f)
                curveTo(535.7f, 403.1f, 544.0f, 391.2f, 544.0f, 377.8f)
                lineTo(544.0f, 130.1f)
                curveTo(544.0f, 107.1f, 519.8f, 92.1f, 499.2f, 102.4f)
                lineTo(487.4f, 108.3f)
                curveTo(442.5f, 130.8f, 389.6f, 130.8f, 344.6f, 108.3f)
                curveTo(308.2f, 90.1f, 266.3f, 86.5f, 227.4f, 98.2f)
                lineTo(160.0f, 118.4f)
                lineTo(160.0f, 96.0f)
                close()
            }
        }
        .build()
        return _flag!!
    }

private var _flag: ImageVector? = null
