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

public val Fa.`Money-bill`: ImageVector
    get() {
        if (`_money-bill` != null) {
            return `_money-bill`!!
        }
        `_money-bill` = Builder(name = "Money-bill", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 128.0f)
                curveTo(92.7f, 128.0f, 64.0f, 156.7f, 64.0f, 192.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 156.7f, 547.3f, 128.0f, 512.0f, 128.0f)
                lineTo(128.0f, 128.0f)
                close()
                moveTo(320.0f, 224.0f)
                curveTo(373.0f, 224.0f, 416.0f, 267.0f, 416.0f, 320.0f)
                curveTo(416.0f, 373.0f, 373.0f, 416.0f, 320.0f, 416.0f)
                curveTo(267.0f, 416.0f, 224.0f, 373.0f, 224.0f, 320.0f)
                curveTo(224.0f, 267.0f, 267.0f, 224.0f, 320.0f, 224.0f)
                close()
                moveTo(512.0f, 248.0f)
                curveTo(512.0f, 252.4f, 508.4f, 256.1f, 504.0f, 255.5f)
                curveTo(475.0f, 251.9f, 452.1f, 228.9f, 448.5f, 200.0f)
                curveTo(448.0f, 195.6f, 451.6f, 192.0f, 456.0f, 192.0f)
                lineTo(504.0f, 192.0f)
                curveTo(508.4f, 192.0f, 512.0f, 195.6f, 512.0f, 200.0f)
                lineTo(512.0f, 248.0f)
                close()
                moveTo(128.0f, 392.0f)
                curveTo(128.0f, 387.6f, 131.6f, 383.9f, 136.0f, 384.5f)
                curveTo(165.0f, 388.1f, 187.9f, 411.1f, 191.5f, 440.0f)
                curveTo(192.0f, 444.4f, 188.4f, 448.0f, 184.0f, 448.0f)
                lineTo(136.0f, 448.0f)
                curveTo(131.6f, 448.0f, 128.0f, 444.4f, 128.0f, 440.0f)
                lineTo(128.0f, 392.0f)
                close()
                moveTo(136.0f, 255.5f)
                curveTo(131.6f, 256.0f, 128.0f, 252.4f, 128.0f, 248.0f)
                lineTo(128.0f, 200.0f)
                curveTo(128.0f, 195.6f, 131.6f, 192.0f, 136.0f, 192.0f)
                lineTo(184.0f, 192.0f)
                curveTo(188.4f, 192.0f, 192.1f, 195.6f, 191.5f, 200.0f)
                curveTo(187.9f, 229.0f, 164.9f, 251.9f, 136.0f, 255.5f)
                close()
                moveTo(504.0f, 384.5f)
                curveTo(508.4f, 384.0f, 512.0f, 387.6f, 512.0f, 392.0f)
                lineTo(512.0f, 440.0f)
                curveTo(512.0f, 444.4f, 508.4f, 448.0f, 504.0f, 448.0f)
                lineTo(456.0f, 448.0f)
                curveTo(451.6f, 448.0f, 447.9f, 444.4f, 448.5f, 440.0f)
                curveTo(452.1f, 411.0f, 475.1f, 388.1f, 504.0f, 384.5f)
                close()
            }
        }
        .build()
        return `_money-bill`!!
    }

private var `_money-bill`: ImageVector? = null
