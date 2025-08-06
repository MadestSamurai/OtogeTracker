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

public val Fa.`Baht-sign`: ImageVector
    get() {
        if (`_baht-sign` != null) {
            return `_baht-sign`!!
        }
        `_baht-sign` = Builder(name = "Baht-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(296.0f, 64.0f)
                curveTo(282.7f, 64.0f, 272.0f, 74.7f, 272.0f, 88.0f)
                lineTo(272.0f, 128.0f)
                lineTo(197.6f, 128.0f)
                curveTo(176.8f, 128.0f, 160.0f, 144.8f, 160.0f, 165.6f)
                lineTo(160.0f, 470.3f)
                curveTo(160.0f, 493.3f, 178.7f, 512.0f, 201.7f, 512.0f)
                lineTo(272.0f, 512.0f)
                lineTo(272.0f, 552.0f)
                curveTo(272.0f, 565.3f, 282.7f, 576.0f, 296.0f, 576.0f)
                curveTo(309.3f, 576.0f, 320.0f, 565.3f, 320.0f, 552.0f)
                lineTo(320.0f, 512.0f)
                lineTo(368.0f, 512.0f)
                curveTo(429.9f, 512.0f, 480.0f, 461.9f, 480.0f, 400.0f)
                curveTo(480.0f, 359.9f, 458.9f, 324.7f, 427.3f, 304.9f)
                curveTo(440.4f, 286.6f, 448.0f, 264.2f, 448.0f, 240.0f)
                curveTo(448.0f, 178.1f, 397.9f, 128.0f, 336.0f, 128.0f)
                lineTo(320.0f, 128.0f)
                lineTo(320.0f, 88.0f)
                curveTo(320.0f, 74.7f, 309.3f, 64.0f, 296.0f, 64.0f)
                close()
                moveTo(272.0f, 192.0f)
                lineTo(272.0f, 288.0f)
                lineTo(224.0f, 288.0f)
                lineTo(224.0f, 192.0f)
                lineTo(272.0f, 192.0f)
                close()
                moveTo(320.0f, 288.0f)
                lineTo(320.0f, 192.0f)
                lineTo(336.0f, 192.0f)
                curveTo(362.5f, 192.0f, 384.0f, 213.5f, 384.0f, 240.0f)
                curveTo(384.0f, 266.5f, 362.5f, 288.0f, 336.0f, 288.0f)
                lineTo(320.0f, 288.0f)
                close()
                moveTo(272.0f, 352.0f)
                lineTo(272.0f, 448.0f)
                lineTo(224.0f, 448.0f)
                lineTo(224.0f, 352.0f)
                lineTo(272.0f, 352.0f)
                close()
                moveTo(320.0f, 448.0f)
                lineTo(320.0f, 352.0f)
                lineTo(368.0f, 352.0f)
                curveTo(394.5f, 352.0f, 416.0f, 373.5f, 416.0f, 400.0f)
                curveTo(416.0f, 426.5f, 394.5f, 448.0f, 368.0f, 448.0f)
                lineTo(320.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_baht-sign`!!
    }

private var `_baht-sign`: ImageVector? = null
