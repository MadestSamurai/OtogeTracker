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

public val Fa.`Torii-gate`: ImageVector
    get() {
        if (`_torii-gate` != null) {
            return `_torii-gate`!!
        }
        `_torii-gate` = Builder(name = "Torii-gate", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 160.0f)
                lineTo(96.0f, 92.5f)
                curveTo(96.0f, 85.6f, 101.6f, 80.0f, 108.5f, 80.0f)
                curveTo(110.8f, 80.0f, 113.0f, 80.6f, 115.0f, 81.8f)
                lineTo(154.0f, 105.2f)
                curveTo(178.9f, 120.1f, 207.3f, 128.0f, 236.3f, 128.0f)
                lineTo(403.7f, 128.0f)
                curveTo(432.7f, 128.0f, 461.2f, 120.1f, 486.0f, 105.2f)
                lineTo(525.0f, 81.8f)
                curveTo(526.9f, 80.6f, 529.2f, 80.0f, 531.4f, 80.0f)
                curveTo(538.3f, 80.0f, 543.9f, 85.6f, 543.9f, 92.5f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 195.3f, 515.3f, 224.0f, 480.0f, 224.0f)
                lineTo(480.0f, 288.0f)
                lineTo(496.0f, 288.0f)
                curveTo(513.7f, 288.0f, 528.0f, 302.3f, 528.0f, 320.0f)
                curveTo(528.0f, 337.7f, 513.7f, 352.0f, 496.0f, 352.0f)
                lineTo(480.0f, 352.0f)
                lineTo(480.0f, 544.0f)
                curveTo(480.0f, 561.7f, 465.7f, 576.0f, 448.0f, 576.0f)
                curveTo(430.3f, 576.0f, 416.0f, 561.7f, 416.0f, 544.0f)
                lineTo(416.0f, 352.0f)
                lineTo(224.0f, 352.0f)
                lineTo(224.0f, 544.0f)
                curveTo(224.0f, 561.7f, 209.7f, 576.0f, 192.0f, 576.0f)
                curveTo(174.3f, 576.0f, 160.0f, 561.7f, 160.0f, 544.0f)
                lineTo(160.0f, 352.0f)
                lineTo(144.0f, 352.0f)
                curveTo(126.3f, 352.0f, 112.0f, 337.7f, 112.0f, 320.0f)
                curveTo(112.0f, 302.3f, 126.3f, 288.0f, 144.0f, 288.0f)
                lineTo(160.0f, 288.0f)
                lineTo(160.0f, 224.0f)
                curveTo(124.7f, 224.0f, 96.0f, 195.3f, 96.0f, 160.0f)
                close()
                moveTo(224.0f, 288.0f)
                lineTo(288.0f, 288.0f)
                lineTo(288.0f, 224.0f)
                lineTo(224.0f, 224.0f)
                lineTo(224.0f, 288.0f)
                close()
                moveTo(352.0f, 288.0f)
                lineTo(416.0f, 288.0f)
                lineTo(416.0f, 224.0f)
                lineTo(352.0f, 224.0f)
                lineTo(352.0f, 288.0f)
                close()
            }
        }
        .build()
        return `_torii-gate`!!
    }

private var `_torii-gate`: ImageVector? = null
