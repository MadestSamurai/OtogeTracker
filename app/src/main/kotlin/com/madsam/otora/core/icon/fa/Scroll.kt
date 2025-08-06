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

public val Fa.Scroll: ImageVector
    get() {
        if (_scroll != null) {
            return _scroll!!
        }
        _scroll = Builder(name = "Scroll", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 176.0f)
                curveTo(32.0f, 134.5f, 63.6f, 100.4f, 104.0f, 96.4f)
                lineTo(104.0f, 96.0f)
                lineTo(384.0f, 96.0f)
                curveTo(437.0f, 96.0f, 480.0f, 139.0f, 480.0f, 192.0f)
                lineTo(480.0f, 368.0f)
                lineTo(304.0f, 368.0f)
                curveTo(264.2f, 368.0f, 232.0f, 400.2f, 232.0f, 440.0f)
                lineTo(232.0f, 500.0f)
                curveTo(232.0f, 524.3f, 212.3f, 544.0f, 188.0f, 544.0f)
                curveTo(163.7f, 544.0f, 144.0f, 524.3f, 144.0f, 500.0f)
                lineTo(144.0f, 272.0f)
                lineTo(80.0f, 272.0f)
                curveTo(53.5f, 272.0f, 32.0f, 250.5f, 32.0f, 224.0f)
                lineTo(32.0f, 176.0f)
                close()
                moveTo(268.8f, 544.0f)
                curveTo(275.9f, 530.9f, 280.0f, 515.9f, 280.0f, 500.0f)
                lineTo(280.0f, 440.0f)
                curveTo(280.0f, 426.7f, 290.7f, 416.0f, 304.0f, 416.0f)
                lineTo(552.0f, 416.0f)
                curveTo(565.3f, 416.0f, 576.0f, 426.7f, 576.0f, 440.0f)
                lineTo(576.0f, 464.0f)
                curveTo(576.0f, 508.2f, 540.2f, 544.0f, 496.0f, 544.0f)
                lineTo(268.8f, 544.0f)
                close()
                moveTo(112.0f, 144.0f)
                curveTo(94.3f, 144.0f, 80.0f, 158.3f, 80.0f, 176.0f)
                lineTo(80.0f, 224.0f)
                lineTo(144.0f, 224.0f)
                lineTo(144.0f, 176.0f)
                curveTo(144.0f, 158.3f, 129.7f, 144.0f, 112.0f, 144.0f)
                close()
            }
        }
        .build()
        return _scroll!!
    }

private var _scroll: ImageVector? = null
