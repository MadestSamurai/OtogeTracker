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

public val Fa.Stamp: ImageVector
    get() {
        if (_stamp != null) {
            return _stamp!!
        }
        _stamp = Builder(name = "Stamp", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(376.0f, 265.8f)
                curveTo(376.0f, 248.4f, 385.2f, 232.6f, 395.9f, 218.8f)
                curveTo(408.5f, 202.6f, 416.0f, 182.2f, 416.0f, 160.0f)
                curveTo(416.0f, 107.0f, 373.0f, 64.0f, 320.0f, 64.0f)
                curveTo(267.0f, 64.0f, 224.0f, 107.0f, 224.0f, 160.0f)
                curveTo(224.0f, 182.1f, 231.5f, 202.5f, 244.1f, 218.8f)
                curveTo(254.8f, 232.6f, 264.0f, 248.4f, 264.0f, 265.8f)
                curveTo(264.0f, 295.7f, 239.7f, 320.0f, 209.8f, 320.0f)
                lineTo(176.0f, 320.0f)
                curveTo(114.1f, 320.0f, 64.0f, 370.1f, 64.0f, 432.0f)
                curveTo(64.0f, 458.5f, 85.5f, 480.0f, 112.0f, 480.0f)
                lineTo(528.0f, 480.0f)
                curveTo(554.5f, 480.0f, 576.0f, 458.5f, 576.0f, 432.0f)
                curveTo(576.0f, 370.1f, 525.9f, 320.0f, 464.0f, 320.0f)
                lineTo(430.2f, 320.0f)
                curveTo(400.3f, 320.0f, 376.0f, 295.7f, 376.0f, 265.8f)
                close()
                moveTo(120.0f, 528.0f)
                curveTo(106.7f, 528.0f, 96.0f, 538.7f, 96.0f, 552.0f)
                curveTo(96.0f, 565.3f, 106.7f, 576.0f, 120.0f, 576.0f)
                lineTo(520.0f, 576.0f)
                curveTo(533.3f, 576.0f, 544.0f, 565.3f, 544.0f, 552.0f)
                curveTo(544.0f, 538.7f, 533.3f, 528.0f, 520.0f, 528.0f)
                lineTo(120.0f, 528.0f)
                close()
            }
        }
        .build()
        return _stamp!!
    }

private var _stamp: ImageVector? = null
