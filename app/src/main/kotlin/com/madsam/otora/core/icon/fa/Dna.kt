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

public val Fa.Dna: ImageVector
    get() {
        if (_dna != null) {
            return _dna!!
        }
        _dna = Builder(name = "Dna", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 64.0f)
                curveTo(497.7f, 64.0f, 512.0f, 78.3f, 512.0f, 96.0f)
                curveTo(512.0f, 153.8f, 487.6f, 200.8f, 454.6f, 240.5f)
                curveTo(430.5f, 269.4f, 400.8f, 295.6f, 371.0f, 320.0f)
                curveTo(400.8f, 344.5f, 430.5f, 370.6f, 454.6f, 399.5f)
                curveTo(487.6f, 439.1f, 512.0f, 486.2f, 512.0f, 544.0f)
                curveTo(512.0f, 561.7f, 497.7f, 576.0f, 480.0f, 576.0f)
                curveTo(462.3f, 576.0f, 448.0f, 561.7f, 448.0f, 544.0f)
                lineTo(192.0f, 544.0f)
                curveTo(192.0f, 561.7f, 177.7f, 576.0f, 160.0f, 576.0f)
                curveTo(142.3f, 576.0f, 128.0f, 561.7f, 128.0f, 544.0f)
                curveTo(128.0f, 486.2f, 152.4f, 439.2f, 185.4f, 399.5f)
                curveTo(209.5f, 370.6f, 239.2f, 344.5f, 269.0f, 320.0f)
                curveTo(239.2f, 295.5f, 209.5f, 269.4f, 185.4f, 240.5f)
                curveTo(152.4f, 200.8f, 128.0f, 153.8f, 128.0f, 96.0f)
                curveTo(128.0f, 78.3f, 142.3f, 64.0f, 160.0f, 64.0f)
                curveTo(177.7f, 64.0f, 192.0f, 78.3f, 192.0f, 96.0f)
                lineTo(448.0f, 96.0f)
                curveTo(448.0f, 78.3f, 462.3f, 64.0f, 480.0f, 64.0f)
                close()
                moveTo(411.5f, 448.0f)
                lineTo(228.6f, 448.0f)
                curveTo(220.4f, 458.5f, 213.5f, 469.1f, 208.0f, 480.0f)
                lineTo(432.2f, 480.0f)
                curveTo(426.6f, 469.1f, 419.7f, 458.5f, 411.6f, 448.0f)
                close()
                moveTo(366.0f, 400.0f)
                curveTo(351.7f, 387.0f, 336.2f, 374.2f, 320.0f, 361.0f)
                curveTo(303.8f, 374.1f, 288.3f, 387.0f, 274.0f, 400.0f)
                lineTo(366.0f, 400.0f)
                close()
                moveTo(228.5f, 192.0f)
                lineTo(411.4f, 192.0f)
                curveTo(419.6f, 181.5f, 426.5f, 170.9f, 432.0f, 160.0f)
                lineTo(207.9f, 160.0f)
                curveTo(213.5f, 170.9f, 220.4f, 181.5f, 228.5f, 192.0f)
                close()
                moveTo(274.0f, 240.0f)
                curveTo(288.3f, 253.0f, 303.8f, 265.8f, 320.0f, 279.0f)
                curveTo(336.2f, 265.9f, 351.7f, 253.0f, 366.0f, 240.0f)
                lineTo(274.0f, 240.0f)
                close()
            }
        }
        .build()
        return _dna!!
    }

private var _dna: ImageVector? = null
