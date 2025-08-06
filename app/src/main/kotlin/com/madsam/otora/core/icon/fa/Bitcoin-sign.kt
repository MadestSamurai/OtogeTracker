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

public val Fa.`Bitcoin-sign`: ImageVector
    get() {
        if (`_bitcoin-sign` != null) {
            return `_bitcoin-sign`!!
        }
        `_bitcoin-sign` = Builder(name = "Bitcoin-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 88.0f)
                curveTo(224.0f, 74.7f, 234.7f, 64.0f, 248.0f, 64.0f)
                curveTo(261.3f, 64.0f, 272.0f, 74.7f, 272.0f, 88.0f)
                lineTo(272.0f, 128.0f)
                lineTo(304.0f, 128.0f)
                lineTo(304.0f, 88.0f)
                curveTo(304.0f, 74.7f, 314.7f, 64.0f, 328.0f, 64.0f)
                curveTo(341.3f, 64.0f, 352.0f, 74.7f, 352.0f, 88.0f)
                lineTo(352.0f, 129.1f)
                curveTo(406.3f, 136.9f, 448.0f, 183.5f, 448.0f, 240.0f)
                curveTo(448.0f, 264.2f, 440.3f, 286.6f, 427.3f, 304.9f)
                curveTo(459.0f, 324.7f, 480.0f, 359.9f, 480.0f, 400.0f)
                curveTo(480.0f, 461.9f, 429.9f, 512.0f, 368.0f, 512.0f)
                lineTo(352.0f, 512.0f)
                lineTo(352.0f, 552.0f)
                curveTo(352.0f, 565.3f, 341.3f, 576.0f, 328.0f, 576.0f)
                curveTo(314.7f, 576.0f, 304.0f, 565.3f, 304.0f, 552.0f)
                lineTo(304.0f, 512.0f)
                lineTo(272.0f, 512.0f)
                lineTo(272.0f, 552.0f)
                curveTo(272.0f, 565.3f, 261.3f, 576.0f, 248.0f, 576.0f)
                curveTo(234.7f, 576.0f, 224.0f, 565.3f, 224.0f, 552.0f)
                lineTo(224.0f, 512.0f)
                lineTo(201.7f, 512.0f)
                curveTo(178.7f, 512.0f, 160.0f, 493.3f, 160.0f, 470.3f)
                lineTo(160.0f, 165.6f)
                curveTo(160.0f, 144.8f, 176.8f, 128.0f, 197.6f, 128.0f)
                lineTo(224.0f, 128.0f)
                lineTo(224.0f, 88.0f)
                close()
                moveTo(224.0f, 288.0f)
                lineTo(336.0f, 288.0f)
                curveTo(362.5f, 288.0f, 384.0f, 266.5f, 384.0f, 240.0f)
                curveTo(384.0f, 213.5f, 362.5f, 192.0f, 336.0f, 192.0f)
                lineTo(224.0f, 192.0f)
                lineTo(224.0f, 288.0f)
                close()
                moveTo(336.0f, 352.0f)
                lineTo(224.0f, 352.0f)
                lineTo(224.0f, 448.0f)
                lineTo(368.0f, 448.0f)
                curveTo(394.5f, 448.0f, 416.0f, 426.5f, 416.0f, 400.0f)
                curveTo(416.0f, 373.5f, 394.5f, 352.0f, 368.0f, 352.0f)
                lineTo(336.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_bitcoin-sign`!!
    }

private var `_bitcoin-sign`: ImageVector? = null
