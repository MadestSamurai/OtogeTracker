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

public val Fa.Receipt: ImageVector
    get() {
        if (_receipt != null) {
            return _receipt!!
        }
        _receipt = Builder(name = "Receipt", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(142.0f, 66.2f)
                curveTo(150.5f, 62.3f, 160.5f, 63.7f, 167.6f, 69.8f)
                lineTo(208.0f, 104.4f)
                lineTo(248.4f, 69.8f)
                curveTo(257.4f, 62.1f, 270.7f, 62.1f, 279.6f, 69.8f)
                lineTo(320.0f, 104.4f)
                lineTo(360.4f, 69.8f)
                curveTo(369.4f, 62.1f, 382.6f, 62.1f, 391.6f, 69.8f)
                lineTo(432.0f, 104.4f)
                lineTo(472.4f, 69.8f)
                curveTo(479.5f, 63.7f, 489.5f, 62.3f, 498.0f, 66.2f)
                curveTo(506.5f, 70.1f, 512.0f, 78.6f, 512.0f, 88.0f)
                lineTo(512.0f, 552.0f)
                curveTo(512.0f, 561.4f, 506.5f, 569.9f, 498.0f, 573.8f)
                curveTo(489.5f, 577.7f, 479.5f, 576.3f, 472.4f, 570.2f)
                lineTo(432.0f, 535.6f)
                lineTo(391.6f, 570.2f)
                curveTo(382.6f, 577.9f, 369.4f, 577.9f, 360.4f, 570.2f)
                lineTo(320.0f, 535.6f)
                lineTo(279.6f, 570.2f)
                curveTo(270.6f, 577.9f, 257.3f, 577.9f, 248.4f, 570.2f)
                lineTo(208.0f, 535.6f)
                lineTo(167.6f, 570.2f)
                curveTo(160.5f, 576.3f, 150.5f, 577.7f, 142.0f, 573.8f)
                curveTo(133.5f, 569.9f, 128.0f, 561.4f, 128.0f, 552.0f)
                lineTo(128.0f, 88.0f)
                curveTo(128.0f, 78.6f, 133.5f, 70.1f, 142.0f, 66.2f)
                close()
                moveTo(232.0f, 200.0f)
                curveTo(218.7f, 200.0f, 208.0f, 210.7f, 208.0f, 224.0f)
                curveTo(208.0f, 237.3f, 218.7f, 248.0f, 232.0f, 248.0f)
                lineTo(408.0f, 248.0f)
                curveTo(421.3f, 248.0f, 432.0f, 237.3f, 432.0f, 224.0f)
                curveTo(432.0f, 210.7f, 421.3f, 200.0f, 408.0f, 200.0f)
                lineTo(232.0f, 200.0f)
                close()
                moveTo(208.0f, 416.0f)
                curveTo(208.0f, 429.3f, 218.7f, 440.0f, 232.0f, 440.0f)
                lineTo(408.0f, 440.0f)
                curveTo(421.3f, 440.0f, 432.0f, 429.3f, 432.0f, 416.0f)
                curveTo(432.0f, 402.7f, 421.3f, 392.0f, 408.0f, 392.0f)
                lineTo(232.0f, 392.0f)
                curveTo(218.7f, 392.0f, 208.0f, 402.7f, 208.0f, 416.0f)
                close()
                moveTo(232.0f, 296.0f)
                curveTo(218.7f, 296.0f, 208.0f, 306.7f, 208.0f, 320.0f)
                curveTo(208.0f, 333.3f, 218.7f, 344.0f, 232.0f, 344.0f)
                lineTo(408.0f, 344.0f)
                curveTo(421.3f, 344.0f, 432.0f, 333.3f, 432.0f, 320.0f)
                curveTo(432.0f, 306.7f, 421.3f, 296.0f, 408.0f, 296.0f)
                lineTo(232.0f, 296.0f)
                close()
            }
        }
        .build()
        return _receipt!!
    }

private var _receipt: ImageVector? = null
