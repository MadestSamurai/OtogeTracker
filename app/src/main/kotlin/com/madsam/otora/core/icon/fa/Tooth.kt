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

public val Fa.Tooth: ImageVector
    get() {
        if (_tooth != null) {
            return _tooth!!
        }
        _tooth = Builder(name = "Tooth", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(241.0f, 69.7f)
                lineTo(320.0f, 96.0f)
                lineTo(399.0f, 69.7f)
                curveTo(410.3f, 65.9f, 422.0f, 64.0f, 433.9f, 64.0f)
                curveTo(494.7f, 64.0f, 544.0f, 113.3f, 544.0f, 174.1f)
                lineTo(544.0f, 242.6f)
                curveTo(544.0f, 272.0f, 534.5f, 300.7f, 516.8f, 324.2f)
                lineTo(515.7f, 325.7f)
                curveTo(502.8f, 342.9f, 494.4f, 363.1f, 491.4f, 384.4f)
                lineTo(469.7f, 535.9f)
                curveTo(466.4f, 558.9f, 446.7f, 576.0f, 423.5f, 576.0f)
                curveTo(400.7f, 576.0f, 381.2f, 559.5f, 377.5f, 537.0f)
                lineTo(357.3f, 415.6f)
                curveTo(354.3f, 397.4f, 338.5f, 384.0f, 320.0f, 384.0f)
                curveTo(301.5f, 384.0f, 285.8f, 397.4f, 282.7f, 415.6f)
                lineTo(262.5f, 537.0f)
                curveTo(258.7f, 559.5f, 239.3f, 576.0f, 216.5f, 576.0f)
                curveTo(193.3f, 576.0f, 173.6f, 558.9f, 170.3f, 535.9f)
                lineTo(148.6f, 384.5f)
                curveTo(145.6f, 363.2f, 137.2f, 343.0f, 124.3f, 325.8f)
                lineTo(123.2f, 324.3f)
                curveTo(105.5f, 300.7f, 96.0f, 272.1f, 96.0f, 242.7f)
                lineTo(96.0f, 174.2f)
                curveTo(96.0f, 113.3f, 145.3f, 64.0f, 206.1f, 64.0f)
                curveTo(218.0f, 64.0f, 229.7f, 65.9f, 241.0f, 69.7f)
                close()
            }
        }
        .build()
        return _tooth!!
    }

private var _tooth: ImageVector? = null
