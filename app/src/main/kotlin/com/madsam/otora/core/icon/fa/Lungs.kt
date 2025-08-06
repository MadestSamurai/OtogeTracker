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

public val Fa.Lungs: ImageVector
    get() {
        if (_lungs != null) {
            return _lungs!!
        }
        _lungs = Builder(name = "Lungs", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 237.9f)
                lineTo(256.0f, 257.1f)
                lineTo(256.0f, 140.4f)
                curveTo(256.0f, 115.9f, 236.1f, 96.0f, 211.6f, 96.0f)
                curveTo(199.1f, 96.0f, 187.2f, 101.3f, 178.8f, 110.5f)
                lineTo(152.4f, 139.5f)
                curveTo(74.9f, 224.8f, 32.0f, 335.8f, 32.0f, 451.0f)
                lineTo(32.0f, 481.5f)
                curveTo(32.0f, 533.7f, 74.3f, 576.0f, 126.5f, 576.0f)
                curveTo(148.5f, 576.0f, 170.2f, 570.9f, 189.9f, 561.0f)
                lineTo(194.9f, 558.5f)
                curveTo(232.3f, 539.8f, 255.9f, 501.6f, 255.9f, 459.7f)
                lineTo(255.9f, 331.7f)
                lineTo(319.9f, 293.3f)
                lineTo(383.9f, 331.7f)
                lineTo(383.9f, 459.7f)
                curveTo(383.9f, 501.5f, 407.5f, 539.8f, 444.9f, 558.5f)
                lineTo(449.9f, 561.0f)
                curveTo(469.6f, 570.8f, 491.3f, 576.0f, 513.3f, 576.0f)
                curveTo(565.5f, 576.0f, 607.8f, 533.7f, 607.8f, 481.5f)
                lineTo(607.8f, 475.3f)
                curveTo(607.8f, 364.2f, 571.1f, 256.3f, 503.4f, 168.3f)
                lineTo(460.9f, 112.7f)
                curveTo(452.8f, 102.1f, 440.2f, 96.0f, 426.9f, 96.0f)
                curveTo(403.2f, 96.0f, 384.0f, 115.2f, 384.0f, 138.9f)
                lineTo(384.0f, 257.1f)
                lineTo(352.0f, 237.9f)
                lineTo(352.0f, 96.0f)
                close()
            }
        }
        .build()
        return _lungs!!
    }

private var _lungs: ImageVector? = null
