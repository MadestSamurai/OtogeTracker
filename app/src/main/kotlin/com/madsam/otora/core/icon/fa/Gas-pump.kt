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

public val Fa.`Gas-pump`: ImageVector
    get() {
        if (`_gas-pump` != null) {
            return `_gas-pump`!!
        }
        `_gas-pump` = Builder(name = "Gas-pump", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 128.0f)
                curveTo(96.0f, 92.7f, 124.7f, 64.0f, 160.0f, 64.0f)
                lineTo(320.0f, 64.0f)
                curveTo(355.3f, 64.0f, 384.0f, 92.7f, 384.0f, 128.0f)
                lineTo(384.0f, 320.0f)
                lineTo(392.0f, 320.0f)
                curveTo(440.6f, 320.0f, 480.0f, 359.4f, 480.0f, 408.0f)
                lineTo(480.0f, 440.0f)
                curveTo(480.0f, 453.3f, 490.7f, 464.0f, 504.0f, 464.0f)
                curveTo(517.3f, 464.0f, 528.0f, 453.3f, 528.0f, 440.0f)
                lineTo(528.0f, 286.0f)
                curveTo(500.4f, 278.9f, 480.0f, 253.8f, 480.0f, 224.0f)
                lineTo(480.0f, 164.5f)
                lineTo(454.2f, 136.2f)
                curveTo(445.3f, 126.4f, 446.0f, 111.2f, 455.8f, 102.3f)
                curveTo(465.6f, 93.4f, 480.8f, 94.1f, 489.7f, 103.9f)
                lineTo(561.4f, 182.7f)
                curveTo(570.8f, 193.0f, 576.0f, 206.4f, 576.0f, 220.4f)
                lineTo(576.0f, 440.0f)
                curveTo(576.0f, 479.8f, 543.8f, 512.0f, 504.0f, 512.0f)
                curveTo(464.2f, 512.0f, 432.0f, 479.8f, 432.0f, 440.0f)
                lineTo(432.0f, 408.0f)
                curveTo(432.0f, 385.9f, 414.1f, 368.0f, 392.0f, 368.0f)
                lineTo(384.0f, 368.0f)
                lineTo(384.0f, 529.4f)
                curveTo(393.3f, 532.7f, 400.0f, 541.6f, 400.0f, 552.0f)
                curveTo(400.0f, 565.3f, 389.3f, 576.0f, 376.0f, 576.0f)
                lineTo(104.0f, 576.0f)
                curveTo(90.7f, 576.0f, 80.0f, 565.3f, 80.0f, 552.0f)
                curveTo(80.0f, 541.5f, 86.7f, 532.7f, 96.0f, 529.4f)
                lineTo(96.0f, 128.0f)
                close()
                moveTo(160.0f, 144.0f)
                lineTo(160.0f, 240.0f)
                curveTo(160.0f, 248.8f, 167.2f, 256.0f, 176.0f, 256.0f)
                lineTo(304.0f, 256.0f)
                curveTo(312.8f, 256.0f, 320.0f, 248.8f, 320.0f, 240.0f)
                lineTo(320.0f, 144.0f)
                curveTo(320.0f, 135.2f, 312.8f, 128.0f, 304.0f, 128.0f)
                lineTo(176.0f, 128.0f)
                curveTo(167.2f, 128.0f, 160.0f, 135.2f, 160.0f, 144.0f)
                close()
            }
        }
        .build()
        return `_gas-pump`!!
    }

private var `_gas-pump`: ImageVector? = null
