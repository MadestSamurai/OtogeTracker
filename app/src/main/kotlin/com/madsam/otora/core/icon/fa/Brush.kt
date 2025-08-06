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

public val Fa.Brush: ImageVector
    get() {
        if (_brush != null) {
            return _brush!!
        }
        _brush = Builder(name = "Brush", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(290.4f, 70.0f)
                curveTo(288.9f, 66.4f, 285.4f, 64.0f, 281.5f, 64.0f)
                lineTo(262.5f, 64.0f)
                curveTo(258.6f, 64.0f, 255.0f, 66.4f, 253.6f, 70.0f)
                lineTo(232.9f, 121.7f)
                curveTo(229.7f, 129.7f, 218.3f, 129.7f, 215.1f, 121.7f)
                lineTo(194.4f, 70.0f)
                curveTo(192.9f, 66.4f, 189.4f, 64.0f, 185.5f, 64.0f)
                lineTo(176.0f, 64.0f)
                curveTo(149.5f, 64.0f, 128.0f, 85.5f, 128.0f, 112.0f)
                lineTo(128.0f, 320.0f)
                lineTo(512.0f, 320.0f)
                lineTo(512.0f, 112.0f)
                curveTo(512.0f, 85.5f, 490.5f, 64.0f, 464.0f, 64.0f)
                lineTo(358.5f, 64.0f)
                curveTo(354.6f, 64.0f, 351.0f, 66.4f, 349.6f, 70.0f)
                lineTo(328.9f, 121.7f)
                curveTo(325.7f, 129.7f, 314.3f, 129.7f, 311.1f, 121.7f)
                lineTo(290.4f, 70.0f)
                close()
                moveTo(128.0f, 368.0f)
                lineTo(128.0f, 384.0f)
                curveTo(128.0f, 419.3f, 156.7f, 448.0f, 192.0f, 448.0f)
                lineTo(256.0f, 448.0f)
                lineTo(256.0f, 512.0f)
                curveTo(256.0f, 547.3f, 284.7f, 576.0f, 320.0f, 576.0f)
                curveTo(355.3f, 576.0f, 384.0f, 547.3f, 384.0f, 512.0f)
                lineTo(384.0f, 448.0f)
                lineTo(448.0f, 448.0f)
                curveTo(483.3f, 448.0f, 512.0f, 419.3f, 512.0f, 384.0f)
                lineTo(512.0f, 368.0f)
                lineTo(128.0f, 368.0f)
                close()
                moveTo(320.0f, 528.0f)
                curveTo(311.2f, 528.0f, 304.0f, 520.8f, 304.0f, 512.0f)
                curveTo(304.0f, 503.2f, 311.2f, 496.0f, 320.0f, 496.0f)
                curveTo(328.8f, 496.0f, 336.0f, 503.2f, 336.0f, 512.0f)
                curveTo(336.0f, 520.8f, 328.8f, 528.0f, 320.0f, 528.0f)
                close()
            }
        }
        .build()
        return _brush!!
    }

private var _brush: ImageVector? = null
