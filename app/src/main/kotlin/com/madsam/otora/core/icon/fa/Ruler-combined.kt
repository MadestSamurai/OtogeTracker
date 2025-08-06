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

public val Fa.`Ruler-combined`: ImageVector
    get() {
        if (`_ruler-combined` != null) {
            return `_ruler-combined`!!
        }
        `_ruler-combined` = Builder(name = "Ruler-combined", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(97.0f, 505.7f)
                curveTo(101.5f, 527.5f, 120.8f, 544.0f, 144.0f, 544.0f)
                lineTo(496.0f, 544.0f)
                curveTo(522.5f, 544.0f, 544.0f, 522.5f, 544.0f, 496.0f)
                lineTo(544.0f, 400.0f)
                curveTo(544.0f, 373.5f, 522.5f, 352.0f, 496.0f, 352.0f)
                lineTo(448.0f, 352.0f)
                lineTo(448.0f, 424.0f)
                curveTo(448.0f, 437.3f, 437.3f, 448.0f, 424.0f, 448.0f)
                curveTo(410.7f, 448.0f, 400.0f, 437.3f, 400.0f, 424.0f)
                lineTo(400.0f, 352.0f)
                lineTo(336.0f, 352.0f)
                lineTo(336.0f, 424.0f)
                curveTo(336.0f, 437.3f, 325.3f, 448.0f, 312.0f, 448.0f)
                curveTo(298.7f, 448.0f, 288.0f, 437.3f, 288.0f, 424.0f)
                lineTo(288.0f, 352.0f)
                lineTo(216.0f, 352.0f)
                curveTo(202.7f, 352.0f, 192.0f, 341.3f, 192.0f, 328.0f)
                curveTo(192.0f, 314.7f, 202.7f, 304.0f, 216.0f, 304.0f)
                lineTo(288.0f, 304.0f)
                lineTo(288.0f, 240.0f)
                lineTo(216.0f, 240.0f)
                curveTo(202.7f, 240.0f, 192.0f, 229.3f, 192.0f, 216.0f)
                curveTo(192.0f, 202.7f, 202.7f, 192.0f, 216.0f, 192.0f)
                lineTo(288.0f, 192.0f)
                lineTo(288.0f, 144.0f)
                curveTo(288.0f, 117.5f, 266.5f, 96.0f, 240.0f, 96.0f)
                lineTo(144.0f, 96.0f)
                curveTo(117.5f, 96.0f, 96.0f, 117.5f, 96.0f, 144.0f)
                lineTo(96.0f, 496.0f)
                curveTo(96.0f, 499.3f, 96.3f, 502.6f, 97.0f, 505.7f)
                close()
            }
        }
        .build()
        return `_ruler-combined`!!
    }

private var `_ruler-combined`: ImageVector? = null
