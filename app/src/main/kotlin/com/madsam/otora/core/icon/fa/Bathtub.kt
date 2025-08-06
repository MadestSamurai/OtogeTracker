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

public val Fa.Bathtub: ImageVector
    get() {
        if (_bathtub != null) {
            return _bathtub!!
        }
        _bathtub = Builder(name = "Bathtub", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 141.3f)
                curveTo(160.0f, 134.0f, 165.9f, 128.0f, 173.3f, 128.0f)
                curveTo(176.8f, 128.0f, 180.2f, 129.4f, 182.7f, 131.9f)
                lineTo(197.6f, 146.8f)
                curveTo(194.0f, 155.9f, 192.1f, 165.7f, 192.1f, 176.0f)
                curveTo(192.1f, 195.9f, 199.3f, 214.0f, 211.3f, 228.0f)
                curveTo(206.0f, 237.2f, 207.3f, 249.1f, 215.1f, 257.0f)
                curveTo(224.5f, 266.4f, 239.7f, 266.4f, 249.0f, 257.0f)
                lineTo(353.0f, 153.0f)
                curveTo(362.4f, 143.6f, 362.4f, 128.4f, 353.0f, 119.1f)
                curveTo(345.2f, 111.2f, 333.2f, 110.0f, 324.0f, 115.3f)
                curveTo(310.0f, 103.3f, 291.9f, 96.1f, 272.0f, 96.1f)
                curveTo(261.7f, 96.1f, 251.8f, 98.1f, 242.8f, 101.6f)
                lineTo(227.9f, 86.6f)
                curveTo(213.4f, 72.1f, 193.7f, 64.0f, 173.3f, 64.0f)
                curveTo(130.6f, 64.0f, 96.0f, 98.6f, 96.0f, 141.3f)
                lineTo(96.0f, 320.0f)
                curveTo(78.3f, 320.0f, 64.0f, 334.3f, 64.0f, 352.0f)
                curveTo(64.0f, 369.7f, 78.3f, 384.0f, 96.0f, 384.0f)
                lineTo(96.0f, 432.0f)
                curveTo(96.0f, 460.4f, 108.4f, 486.0f, 128.0f, 503.6f)
                lineTo(128.0f, 544.0f)
                curveTo(128.0f, 561.7f, 142.3f, 576.0f, 160.0f, 576.0f)
                curveTo(177.7f, 576.0f, 192.0f, 561.7f, 192.0f, 544.0f)
                lineTo(192.0f, 528.0f)
                lineTo(448.0f, 528.0f)
                lineTo(448.0f, 544.0f)
                curveTo(448.0f, 561.7f, 462.3f, 576.0f, 480.0f, 576.0f)
                curveTo(497.7f, 576.0f, 512.0f, 561.7f, 512.0f, 544.0f)
                lineTo(512.0f, 503.6f)
                curveTo(531.6f, 486.0f, 544.0f, 460.5f, 544.0f, 432.0f)
                lineTo(544.0f, 384.0f)
                curveTo(561.7f, 384.0f, 576.0f, 369.7f, 576.0f, 352.0f)
                curveTo(576.0f, 334.3f, 561.7f, 320.0f, 544.0f, 320.0f)
                lineTo(160.0f, 320.0f)
                lineTo(160.0f, 141.3f)
                close()
            }
        }
        .build()
        return _bathtub!!
    }

private var _bathtub: ImageVector? = null
