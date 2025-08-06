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

public val Fa.Code: ImageVector
    get() {
        if (_code != null) {
            return _code!!
        }
        _code = Builder(name = "Code", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(392.8f, 65.2f)
                curveTo(375.8f, 60.3f, 358.1f, 70.2f, 353.2f, 87.2f)
                lineTo(225.2f, 535.2f)
                curveTo(220.3f, 552.2f, 230.2f, 569.9f, 247.2f, 574.8f)
                curveTo(264.2f, 579.7f, 281.9f, 569.8f, 286.8f, 552.8f)
                lineTo(414.8f, 104.8f)
                curveTo(419.7f, 87.8f, 409.8f, 70.1f, 392.8f, 65.2f)
                close()
                moveTo(457.4f, 201.3f)
                curveTo(444.9f, 213.8f, 444.9f, 234.1f, 457.4f, 246.6f)
                lineTo(530.8f, 320.0f)
                lineTo(457.4f, 393.4f)
                curveTo(444.9f, 405.9f, 444.9f, 426.2f, 457.4f, 438.7f)
                curveTo(469.9f, 451.2f, 490.2f, 451.2f, 502.7f, 438.7f)
                lineTo(598.7f, 342.7f)
                curveTo(611.2f, 330.2f, 611.2f, 309.9f, 598.7f, 297.4f)
                lineTo(502.7f, 201.4f)
                curveTo(490.2f, 188.9f, 469.9f, 188.9f, 457.4f, 201.4f)
                close()
                moveTo(182.7f, 201.3f)
                curveTo(170.2f, 188.8f, 149.9f, 188.8f, 137.4f, 201.3f)
                lineTo(41.4f, 297.3f)
                curveTo(28.9f, 309.8f, 28.9f, 330.1f, 41.4f, 342.6f)
                lineTo(137.4f, 438.6f)
                curveTo(149.9f, 451.1f, 170.2f, 451.1f, 182.7f, 438.6f)
                curveTo(195.2f, 426.1f, 195.2f, 405.8f, 182.7f, 393.3f)
                lineTo(109.3f, 320.0f)
                lineTo(182.6f, 246.6f)
                curveTo(195.1f, 234.1f, 195.1f, 213.8f, 182.6f, 201.3f)
                close()
            }
        }
        .build()
        return _code!!
    }

private var _code: ImageVector? = null
