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

public val Fa.Drum: ImageVector
    get() {
        if (_drum != null) {
            return _drum!!
        }
        _drum = Builder(name = "Drum", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(565.2f, 140.1f)
                curveTo(576.3f, 132.8f, 579.4f, 118.0f, 572.1f, 106.9f)
                curveTo(564.8f, 95.8f, 550.0f, 92.7f, 538.9f, 100.0f)
                lineTo(434.2f, 168.5f)
                curveTo(399.8f, 162.7f, 361.0f, 160.0f, 320.0f, 160.0f)
                curveTo(178.6f, 160.0f, 64.0f, 192.0f, 64.0f, 272.0f)
                lineTo(64.0f, 432.0f)
                curveTo(64.0f, 463.3f, 91.4f, 490.8f, 136.0f, 510.7f)
                lineTo(136.0f, 408.0f)
                curveTo(136.0f, 394.7f, 146.7f, 384.0f, 160.0f, 384.0f)
                curveTo(173.3f, 384.0f, 184.0f, 394.7f, 184.0f, 408.0f)
                lineTo(184.0f, 527.4f)
                curveTo(217.0f, 536.3f, 255.1f, 541.9f, 296.0f, 543.5f)
                lineTo(296.0f, 440.0f)
                curveTo(296.0f, 426.7f, 306.7f, 416.0f, 320.0f, 416.0f)
                curveTo(333.3f, 416.0f, 344.0f, 426.7f, 344.0f, 440.0f)
                lineTo(344.0f, 543.5f)
                curveTo(384.9f, 541.9f, 423.0f, 536.3f, 456.0f, 527.4f)
                lineTo(456.0f, 408.0f)
                curveTo(456.0f, 394.7f, 466.7f, 384.0f, 480.0f, 384.0f)
                curveTo(493.3f, 384.0f, 504.0f, 394.7f, 504.0f, 408.0f)
                lineTo(504.0f, 510.7f)
                curveTo(548.6f, 490.8f, 576.0f, 463.3f, 576.0f, 432.0f)
                lineTo(576.0f, 272.0f)
                curveTo(576.0f, 230.9f, 545.8f, 202.5f, 497.2f, 184.6f)
                lineTo(565.1f, 140.1f)
                close()
                moveTo(371.4f, 209.6f)
                lineTo(306.8f, 251.9f)
                curveTo(295.7f, 259.2f, 292.6f, 274.0f, 299.9f, 285.1f)
                curveTo(307.2f, 296.2f, 322.0f, 299.3f, 333.1f, 292.0f)
                lineTo(444.2f, 219.2f)
                curveTo(458.9f, 222.4f, 472.1f, 226.2f, 483.6f, 230.7f)
                curveTo(522.4f, 245.8f, 528.0f, 261.3f, 528.0f, 272.0f)
                curveTo(528.0f, 272.8f, 525.3f, 289.2f, 482.0f, 307.9f)
                curveTo(443.1f, 324.7f, 386.0f, 336.0f, 320.0f, 336.0f)
                curveTo(254.0f, 336.0f, 196.9f, 324.7f, 158.0f, 307.9f)
                curveTo(114.7f, 289.2f, 112.0f, 272.8f, 112.0f, 272.0f)
                curveTo(112.0f, 261.4f, 117.6f, 245.8f, 156.4f, 230.7f)
                curveTo(194.7f, 215.8f, 251.8f, 208.0f, 320.0f, 208.0f)
                curveTo(338.0f, 208.0f, 355.1f, 208.5f, 371.4f, 209.6f)
                close()
            }
        }
        .build()
        return _drum!!
    }

private var _drum: ImageVector? = null
