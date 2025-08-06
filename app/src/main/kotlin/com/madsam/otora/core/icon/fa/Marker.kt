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

public val Fa.Marker: ImageVector
    get() {
        if (_marker != null) {
            return _marker!!
        }
        _marker = Builder(name = "Marker", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(472.8f, 64.0f)
                curveTo(445.4f, 64.0f, 419.2f, 74.9f, 399.8f, 94.2f)
                lineTo(382.1f, 112.0f)
                lineTo(369.0f, 98.9f)
                curveTo(340.9f, 70.8f, 295.3f, 70.8f, 267.2f, 98.9f)
                lineTo(167.0f, 199.0f)
                curveTo(157.6f, 208.4f, 157.6f, 223.6f, 167.0f, 232.9f)
                curveTo(176.4f, 242.2f, 191.6f, 242.3f, 200.9f, 232.9f)
                lineTo(301.1f, 132.9f)
                curveTo(310.5f, 123.5f, 325.7f, 123.5f, 335.0f, 132.9f)
                lineTo(348.1f, 145.9f)
                lineTo(248.0f, 246.1f)
                lineTo(393.9f, 392.0f)
                lineTo(545.8f, 240.2f)
                curveTo(565.2f, 220.8f, 576.0f, 194.6f, 576.0f, 167.2f)
                curveTo(576.0f, 110.2f, 529.8f, 64.0f, 472.8f, 64.0f)
                close()
                moveTo(166.4f, 327.7f)
                curveTo(116.5f, 377.6f, 83.1f, 441.7f, 70.9f, 511.2f)
                lineTo(64.4f, 547.8f)
                curveTo(63.0f, 555.6f, 65.5f, 563.4f, 71.0f, 569.0f)
                curveTo(76.5f, 574.6f, 84.4f, 577.0f, 92.1f, 575.7f)
                lineTo(128.8f, 569.2f)
                curveTo(198.3f, 556.9f, 262.4f, 523.6f, 312.3f, 473.7f)
                lineTo(360.0f, 425.9f)
                lineTo(214.1f, 280.0f)
                lineTo(166.4f, 327.7f)
                close()
            }
        }
        .build()
        return _marker!!
    }

private var _marker: ImageVector? = null
