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

public val Fa.`Microphone-lines`: ImageVector
    get() {
        if (`_microphone-lines` != null) {
            return `_microphone-lines`!!
        }
        `_microphone-lines` = Builder(name = "Microphone-lines", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.0f, 160.0f)
                curveTo(224.0f, 107.0f, 267.0f, 64.0f, 320.0f, 64.0f)
                curveTo(370.3f, 64.0f, 411.6f, 102.7f, 415.7f, 152.0f)
                lineTo(360.0f, 152.0f)
                curveTo(346.7f, 152.0f, 336.0f, 162.7f, 336.0f, 176.0f)
                curveTo(336.0f, 189.3f, 346.7f, 200.0f, 360.0f, 200.0f)
                lineTo(416.0f, 200.0f)
                lineTo(416.0f, 248.0f)
                lineTo(360.0f, 248.0f)
                curveTo(346.7f, 248.0f, 336.0f, 258.7f, 336.0f, 272.0f)
                curveTo(336.0f, 285.3f, 346.7f, 296.0f, 360.0f, 296.0f)
                lineTo(415.7f, 296.0f)
                curveTo(411.6f, 345.3f, 370.4f, 384.0f, 320.0f, 384.0f)
                curveTo(267.0f, 384.0f, 224.0f, 341.0f, 224.0f, 288.0f)
                lineTo(224.0f, 160.0f)
                close()
                moveTo(152.0f, 224.0f)
                curveTo(165.3f, 224.0f, 176.0f, 234.7f, 176.0f, 248.0f)
                lineTo(176.0f, 288.0f)
                curveTo(176.0f, 367.5f, 240.5f, 432.0f, 320.0f, 432.0f)
                curveTo(399.5f, 432.0f, 464.0f, 367.5f, 464.0f, 288.0f)
                lineTo(464.0f, 248.0f)
                curveTo(464.0f, 234.7f, 474.7f, 224.0f, 488.0f, 224.0f)
                curveTo(501.3f, 224.0f, 512.0f, 234.7f, 512.0f, 248.0f)
                lineTo(512.0f, 288.0f)
                curveTo(512.0f, 385.9f, 438.7f, 466.7f, 344.0f, 478.5f)
                lineTo(344.0f, 528.0f)
                lineTo(392.0f, 528.0f)
                curveTo(405.3f, 528.0f, 416.0f, 538.7f, 416.0f, 552.0f)
                curveTo(416.0f, 565.3f, 405.3f, 576.0f, 392.0f, 576.0f)
                lineTo(248.0f, 576.0f)
                curveTo(234.7f, 576.0f, 224.0f, 565.3f, 224.0f, 552.0f)
                curveTo(224.0f, 538.7f, 234.7f, 528.0f, 248.0f, 528.0f)
                lineTo(296.0f, 528.0f)
                lineTo(296.0f, 478.5f)
                curveTo(201.3f, 466.7f, 128.0f, 385.9f, 128.0f, 288.0f)
                lineTo(128.0f, 248.0f)
                curveTo(128.0f, 234.7f, 138.7f, 224.0f, 152.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_microphone-lines`!!
    }

private var `_microphone-lines`: ImageVector? = null
