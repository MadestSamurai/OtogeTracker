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

public val Fa.Crutch: ImageVector
    get() {
        if (_crutch != null) {
            return _crutch!!
        }
        _crutch = Builder(name = "Crutch", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(361.4f, 73.4f)
                curveTo(373.9f, 60.9f, 394.2f, 60.9f, 406.7f, 73.4f)
                lineTo(566.7f, 233.4f)
                curveTo(579.2f, 245.9f, 579.2f, 266.2f, 566.7f, 278.7f)
                curveTo(554.2f, 291.2f, 533.9f, 291.2f, 521.4f, 278.7f)
                lineTo(520.0f, 277.3f)
                lineTo(361.4f, 435.9f)
                curveTo(343.4f, 453.9f, 319.0f, 464.0f, 293.5f, 464.0f)
                lineTo(234.5f, 464.0f)
                curveTo(226.0f, 464.0f, 217.9f, 467.4f, 211.9f, 473.4f)
                curveTo(150.2f, 535.1f, 119.1f, 566.2f, 118.6f, 566.7f)
                curveTo(106.1f, 579.2f, 85.8f, 579.2f, 73.3f, 566.7f)
                curveTo(60.8f, 554.2f, 60.8f, 533.9f, 73.3f, 521.4f)
                lineTo(89.3f, 505.4f)
                lineTo(89.3f, 505.4f)
                lineTo(166.6f, 428.1f)
                curveTo(172.6f, 422.1f, 176.0f, 414.0f, 176.0f, 405.5f)
                lineTo(176.0f, 346.5f)
                curveTo(176.0f, 321.0f, 186.1f, 296.6f, 204.1f, 278.6f)
                lineTo(362.7f, 120.0f)
                lineTo(361.4f, 118.6f)
                curveTo(348.9f, 106.1f, 348.9f, 85.8f, 361.4f, 73.3f)
                close()
                moveTo(408.0f, 165.3f)
                lineTo(325.3f, 248.0f)
                lineTo(392.0f, 314.7f)
                lineTo(474.7f, 232.0f)
                lineTo(408.0f, 165.3f)
                close()
                moveTo(280.0f, 293.3f)
                lineTo(249.4f, 323.9f)
                curveTo(243.4f, 329.9f, 240.0f, 338.0f, 240.0f, 346.5f)
                lineTo(240.0f, 400.0f)
                lineTo(293.5f, 400.0f)
                curveTo(302.0f, 400.0f, 310.1f, 396.6f, 316.1f, 390.6f)
                lineTo(346.7f, 360.0f)
                lineTo(280.0f, 293.3f)
                close()
            }
        }
        .build()
        return _crutch!!
    }

private var _crutch: ImageVector? = null
