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

public val Fa.Backspace: ImageVector
    get() {
        if (_backspace != null) {
            return _backspace!!
        }
        _backspace = Builder(name = "Backspace", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(205.3f, 128.0f)
                curveTo(188.3f, 128.0f, 172.0f, 134.7f, 160.0f, 146.7f)
                lineTo(9.4f, 297.4f)
                curveTo(3.4f, 303.4f, 0.0f, 311.5f, 0.0f, 320.0f)
                curveTo(0.0f, 328.5f, 3.4f, 336.6f, 9.4f, 342.6f)
                lineTo(160.0f, 493.3f)
                curveTo(172.0f, 505.3f, 188.3f, 512.0f, 205.3f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                close()
                moveTo(284.1f, 252.1f)
                curveTo(293.5f, 242.7f, 308.7f, 242.7f, 318.0f, 252.1f)
                lineTo(351.9f, 286.0f)
                lineTo(385.8f, 252.1f)
                curveTo(395.2f, 242.7f, 410.4f, 242.7f, 419.7f, 252.1f)
                curveTo(429.0f, 261.5f, 429.1f, 276.7f, 419.7f, 286.0f)
                lineTo(385.8f, 319.9f)
                lineTo(419.7f, 353.8f)
                curveTo(429.1f, 363.2f, 429.1f, 378.4f, 419.7f, 387.7f)
                curveTo(410.3f, 397.0f, 395.1f, 397.1f, 385.8f, 387.7f)
                lineTo(351.9f, 353.8f)
                lineTo(318.0f, 387.7f)
                curveTo(308.6f, 397.1f, 293.4f, 397.1f, 284.1f, 387.7f)
                curveTo(274.8f, 378.3f, 274.7f, 363.1f, 284.1f, 353.8f)
                lineTo(318.0f, 319.9f)
                lineTo(284.1f, 286.0f)
                curveTo(274.7f, 276.6f, 274.7f, 261.4f, 284.1f, 252.1f)
                close()
            }
        }
        .build()
        return _backspace!!
    }

private var _backspace: ImageVector? = null
