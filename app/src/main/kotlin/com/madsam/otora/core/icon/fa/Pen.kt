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

public val Fa.Pen: ImageVector
    get() {
        if (_pen != null) {
            return _pen!!
        }
        _pen = Builder(name = "Pen", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(416.9f, 85.2f)
                lineTo(372.0f, 130.1f)
                lineTo(509.9f, 268.0f)
                lineTo(554.8f, 223.1f)
                curveTo(568.4f, 209.6f, 576.0f, 191.2f, 576.0f, 172.0f)
                curveTo(576.0f, 152.8f, 568.4f, 134.4f, 554.8f, 120.9f)
                lineTo(519.1f, 85.2f)
                curveTo(505.6f, 71.6f, 487.2f, 64.0f, 468.0f, 64.0f)
                curveTo(448.8f, 64.0f, 430.4f, 71.6f, 416.9f, 85.2f)
                close()
                moveTo(338.1f, 164.0f)
                lineTo(122.9f, 379.1f)
                curveTo(112.2f, 389.8f, 104.4f, 403.2f, 100.3f, 417.8f)
                lineTo(64.9f, 545.6f)
                curveTo(62.6f, 553.9f, 64.9f, 562.9f, 71.1f, 569.0f)
                curveTo(77.3f, 575.1f, 86.2f, 577.5f, 94.5f, 575.2f)
                lineTo(222.3f, 539.7f)
                curveTo(236.9f, 535.6f, 250.2f, 527.9f, 261.0f, 517.1f)
                lineTo(476.0f, 301.9f)
                lineTo(338.1f, 164.0f)
                close()
            }
        }
        .build()
        return _pen!!
    }

private var _pen: ImageVector? = null
