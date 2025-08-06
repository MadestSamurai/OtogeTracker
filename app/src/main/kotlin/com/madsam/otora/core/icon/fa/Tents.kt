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

public val Fa.Tents: ImageVector
    get() {
        if (_tents != null) {
            return _tents!!
        }
        _tents = Builder(name = "Tents", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(571.9f, 416.0f)
                lineTo(476.3f, 416.0f)
                lineTo(467.9f, 349.9f)
                curveTo(465.0f, 326.7f, 452.0f, 306.0f, 432.5f, 293.1f)
                lineTo(284.2f, 195.5f)
                curveTo(266.2f, 183.6f, 244.5f, 179.8f, 224.1f, 184.0f)
                curveTo(226.6f, 179.7f, 230.0f, 176.1f, 234.2f, 173.3f)
                lineTo(382.6f, 75.6f)
                curveTo(393.3f, 68.6f, 407.1f, 68.6f, 417.8f, 75.6f)
                lineTo(566.2f, 173.3f)
                curveTo(574.0f, 178.4f, 579.2f, 186.7f, 580.4f, 196.0f)
                lineTo(603.7f, 380.0f)
                curveTo(606.1f, 399.1f, 591.2f, 416.0f, 572.0f, 416.0f)
                close()
                moveTo(36.8f, 540.0f)
                lineTo(60.1f, 356.0f)
                curveTo(61.3f, 346.7f, 66.4f, 338.4f, 74.3f, 333.3f)
                lineTo(222.7f, 235.6f)
                curveTo(233.4f, 228.6f, 247.2f, 228.6f, 257.9f, 235.6f)
                lineTo(406.3f, 333.3f)
                curveTo(414.1f, 338.4f, 419.3f, 346.7f, 420.5f, 356.0f)
                lineTo(443.8f, 540.0f)
                curveTo(446.2f, 559.1f, 431.3f, 576.0f, 412.1f, 576.0f)
                lineTo(362.4f, 576.0f)
                curveTo(351.2f, 576.0f, 340.9f, 570.2f, 335.1f, 560.6f)
                lineTo(258.1f, 433.9f)
                curveTo(256.4f, 431.1f, 253.3f, 429.3f, 250.0f, 429.3f)
                curveTo(244.7f, 429.3f, 240.5f, 433.6f, 240.5f, 438.8f)
                lineTo(240.5f, 544.0f)
                curveTo(240.5f, 561.7f, 226.2f, 576.0f, 208.5f, 576.0f)
                lineTo(68.5f, 576.0f)
                curveTo(49.2f, 576.0f, 34.3f, 559.1f, 36.8f, 540.0f)
                close()
            }
        }
        .build()
        return _tents!!
    }

private var _tents: ImageVector? = null
