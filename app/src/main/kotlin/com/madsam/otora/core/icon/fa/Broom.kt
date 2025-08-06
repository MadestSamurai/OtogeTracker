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

public val Fa.Broom: ImageVector
    get() {
        if (_broom != null) {
            return _broom!!
        }
        _broom = Builder(name = "Broom", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(598.6f, 118.6f)
                curveTo(611.1f, 106.1f, 611.1f, 85.8f, 598.6f, 73.3f)
                curveTo(586.1f, 60.8f, 565.8f, 60.8f, 553.3f, 73.3f)
                lineTo(361.3f, 265.3f)
                lineTo(326.6f, 230.6f)
                curveTo(322.4f, 226.4f, 316.6f, 224.0f, 310.6f, 224.0f)
                curveTo(298.1f, 224.0f, 288.0f, 234.1f, 288.0f, 246.6f)
                lineTo(288.0f, 275.7f)
                lineTo(396.3f, 384.0f)
                lineTo(425.4f, 384.0f)
                curveTo(437.9f, 384.0f, 448.0f, 373.9f, 448.0f, 361.4f)
                curveTo(448.0f, 355.4f, 445.6f, 349.6f, 441.4f, 345.4f)
                lineTo(406.7f, 310.7f)
                lineTo(598.7f, 118.7f)
                close()
                moveTo(373.1f, 417.4f)
                lineTo(254.6f, 298.9f)
                curveTo(211.9f, 295.2f, 169.4f, 310.6f, 138.8f, 341.2f)
                lineTo(130.8f, 349.2f)
                curveTo(108.5f, 371.5f, 96.0f, 401.7f, 96.0f, 433.2f)
                curveTo(96.0f, 440.0f, 103.1f, 444.4f, 109.2f, 441.4f)
                lineTo(160.3f, 415.9f)
                curveTo(165.3f, 413.4f, 169.8f, 420.0f, 165.7f, 423.8f)
                lineTo(39.3f, 537.4f)
                curveTo(34.7f, 541.6f, 32.0f, 547.6f, 32.0f, 553.9f)
                curveTo(32.0f, 566.1f, 41.9f, 576.0f, 54.1f, 576.0f)
                lineTo(227.4f, 576.0f)
                curveTo(266.2f, 576.0f, 303.3f, 560.6f, 330.8f, 533.2f)
                curveTo(361.4f, 502.6f, 376.7f, 460.1f, 373.1f, 417.4f)
                close()
            }
        }
        .build()
        return _broom!!
    }

private var _broom: ImageVector? = null
