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

public val Fa.Sun: ImageVector
    get() {
        if (_sun != null) {
            return _sun!!
        }
        _sun = Builder(name = "Sun", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(210.2f, 53.9f)
                curveTo(217.6f, 50.8f, 226.0f, 51.7f, 232.7f, 56.1f)
                lineTo(320.5f, 114.3f)
                lineTo(408.3f, 56.1f)
                curveTo(415.0f, 51.7f, 423.4f, 50.9f, 430.8f, 53.9f)
                curveTo(438.2f, 56.9f, 443.4f, 63.5f, 445.0f, 71.3f)
                lineTo(465.9f, 174.5f)
                lineTo(569.1f, 195.4f)
                curveTo(576.9f, 197.0f, 583.5f, 202.4f, 586.5f, 209.7f)
                curveTo(589.5f, 217.0f, 588.7f, 225.5f, 584.3f, 232.2f)
                lineTo(526.1f, 320.0f)
                lineTo(584.3f, 407.8f)
                curveTo(588.7f, 414.5f, 589.5f, 422.9f, 586.5f, 430.3f)
                curveTo(583.5f, 437.7f, 576.9f, 443.1f, 569.1f, 444.6f)
                lineTo(465.8f, 465.4f)
                lineTo(445.0f, 568.7f)
                curveTo(443.4f, 576.5f, 438.0f, 583.1f, 430.7f, 586.1f)
                curveTo(423.4f, 589.1f, 414.9f, 588.3f, 408.2f, 583.9f)
                lineTo(320.4f, 525.7f)
                lineTo(232.6f, 583.9f)
                curveTo(225.9f, 588.3f, 217.5f, 589.1f, 210.1f, 586.1f)
                curveTo(202.7f, 583.1f, 197.3f, 576.5f, 195.8f, 568.7f)
                lineTo(175.0f, 465.4f)
                lineTo(71.7f, 444.5f)
                curveTo(63.9f, 442.9f, 57.3f, 437.5f, 54.3f, 430.2f)
                curveTo(51.3f, 422.9f, 52.1f, 414.4f, 56.5f, 407.7f)
                lineTo(114.7f, 320.0f)
                lineTo(56.5f, 232.2f)
                curveTo(52.1f, 225.5f, 51.3f, 217.1f, 54.3f, 209.7f)
                curveTo(57.3f, 202.3f, 63.9f, 196.9f, 71.7f, 195.4f)
                lineTo(175.0f, 174.6f)
                lineTo(195.9f, 71.3f)
                curveTo(197.5f, 63.5f, 202.9f, 56.9f, 210.2f, 53.9f)
                close()
                moveTo(239.6f, 320.0f)
                curveTo(239.6f, 275.6f, 275.6f, 239.6f, 320.0f, 239.6f)
                curveTo(364.4f, 239.6f, 400.4f, 275.6f, 400.4f, 320.0f)
                curveTo(400.4f, 364.4f, 364.4f, 400.4f, 320.0f, 400.4f)
                curveTo(275.6f, 400.4f, 239.6f, 364.4f, 239.6f, 320.0f)
                close()
                moveTo(448.4f, 320.0f)
                curveTo(448.4f, 249.1f, 390.9f, 191.6f, 320.0f, 191.6f)
                curveTo(249.1f, 191.6f, 191.6f, 249.1f, 191.6f, 320.0f)
                curveTo(191.6f, 390.9f, 249.1f, 448.4f, 320.0f, 448.4f)
                curveTo(390.9f, 448.4f, 448.4f, 390.9f, 448.4f, 320.0f)
                close()
            }
        }
        .build()
        return _sun!!
    }

private var _sun: ImageVector? = null
