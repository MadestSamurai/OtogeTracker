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

public val Fa.`Bus-side`: ImageVector
    get() {
        if (`_bus-side` != null) {
            return `_bus-side`!!
        }
        `_bus-side` = Builder(name = "Bus-side", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 64.0f)
                curveTo(568.4f, 64.0f, 640.0f, 135.6f, 640.0f, 224.0f)
                lineTo(640.0f, 448.0f)
                curveTo(640.0f, 483.3f, 611.3f, 512.0f, 576.0f, 512.0f)
                lineTo(570.4f, 512.0f)
                curveTo(557.2f, 549.3f, 521.8f, 576.0f, 480.0f, 576.0f)
                curveTo(438.2f, 576.0f, 402.7f, 549.3f, 389.6f, 512.0f)
                lineTo(250.5f, 512.0f)
                curveTo(237.3f, 549.3f, 201.8f, 576.0f, 160.1f, 576.0f)
                curveTo(118.4f, 576.0f, 82.9f, 549.3f, 69.7f, 512.0f)
                lineTo(64.0f, 512.0f)
                curveTo(28.7f, 512.0f, 0.0f, 483.3f, 0.0f, 448.0f)
                lineTo(0.0f, 160.0f)
                curveTo(0.0f, 107.0f, 43.0f, 64.0f, 96.0f, 64.0f)
                lineTo(480.0f, 64.0f)
                close()
                moveTo(160.0f, 432.0f)
                curveTo(133.5f, 432.0f, 112.0f, 453.5f, 112.0f, 480.0f)
                curveTo(112.0f, 506.5f, 133.5f, 528.0f, 160.0f, 528.0f)
                curveTo(186.5f, 528.0f, 208.0f, 506.5f, 208.0f, 480.0f)
                curveTo(208.0f, 453.5f, 186.5f, 432.0f, 160.0f, 432.0f)
                close()
                moveTo(480.0f, 432.0f)
                curveTo(453.5f, 432.0f, 432.0f, 453.5f, 432.0f, 480.0f)
                curveTo(432.0f, 506.5f, 453.5f, 528.0f, 480.0f, 528.0f)
                curveTo(506.5f, 528.0f, 528.0f, 506.5f, 528.0f, 480.0f)
                curveTo(528.0f, 453.5f, 506.5f, 432.0f, 480.0f, 432.0f)
                close()
                moveTo(480.0f, 128.0f)
                curveTo(462.3f, 128.0f, 448.0f, 142.3f, 448.0f, 160.0f)
                lineTo(448.0f, 352.0f)
                curveTo(448.0f, 369.7f, 462.3f, 384.0f, 480.0f, 384.0f)
                lineTo(544.0f, 384.0f)
                curveTo(561.7f, 384.0f, 576.0f, 369.7f, 576.0f, 352.0f)
                lineTo(576.0f, 224.0f)
                curveTo(576.0f, 171.0f, 533.0f, 128.0f, 480.0f, 128.0f)
                close()
                moveTo(248.0f, 288.0f)
                lineTo(352.0f, 288.0f)
                curveTo(369.7f, 288.0f, 384.0f, 273.7f, 384.0f, 256.0f)
                lineTo(384.0f, 160.0f)
                curveTo(384.0f, 142.3f, 369.7f, 128.0f, 352.0f, 128.0f)
                lineTo(248.0f, 128.0f)
                lineTo(248.0f, 288.0f)
                close()
                moveTo(96.0f, 128.0f)
                curveTo(78.3f, 128.0f, 64.0f, 142.3f, 64.0f, 160.0f)
                lineTo(64.0f, 256.0f)
                curveTo(64.0f, 273.7f, 78.3f, 288.0f, 96.0f, 288.0f)
                lineTo(200.0f, 288.0f)
                lineTo(200.0f, 128.0f)
                lineTo(96.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_bus-side`!!
    }

private var `_bus-side`: ImageVector? = null
