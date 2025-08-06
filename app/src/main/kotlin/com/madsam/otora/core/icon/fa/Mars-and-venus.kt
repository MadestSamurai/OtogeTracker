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

public val Fa.`Mars-and-venus`: ImageVector
    get() {
        if (`_mars-and-venus` != null) {
            return `_mars-and-venus`!!
        }
        `_mars-and-venus` = Builder(name = "Mars-and-venus", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(432.0f, 64.0f)
                curveTo(414.3f, 64.0f, 400.0f, 49.7f, 400.0f, 32.0f)
                curveTo(400.0f, 14.3f, 414.3f, 0.0f, 432.0f, 0.0f)
                lineTo(544.0f, 0.0f)
                curveTo(561.7f, 0.0f, 576.0f, 14.3f, 576.0f, 32.0f)
                lineTo(576.0f, 144.0f)
                curveTo(576.0f, 161.7f, 561.7f, 176.0f, 544.0f, 176.0f)
                curveTo(526.3f, 176.0f, 512.0f, 161.7f, 512.0f, 144.0f)
                lineTo(512.0f, 109.3f)
                lineTo(449.0f, 172.3f)
                curveTo(468.5f, 200.7f, 480.0f, 235.0f, 480.0f, 272.1f)
                curveTo(480.0f, 358.4f, 417.9f, 430.2f, 336.0f, 445.2f)
                lineTo(336.0f, 480.1f)
                lineTo(368.0f, 480.1f)
                curveTo(385.7f, 480.1f, 400.0f, 494.4f, 400.0f, 512.1f)
                curveTo(400.0f, 529.8f, 385.7f, 544.1f, 368.0f, 544.1f)
                lineTo(336.0f, 544.1f)
                lineTo(336.0f, 576.1f)
                curveTo(336.0f, 593.8f, 321.7f, 608.1f, 304.0f, 608.1f)
                curveTo(286.3f, 608.1f, 272.0f, 593.8f, 272.0f, 576.1f)
                lineTo(272.0f, 544.1f)
                lineTo(240.0f, 544.1f)
                curveTo(222.3f, 544.1f, 208.0f, 529.8f, 208.0f, 512.1f)
                curveTo(208.0f, 494.4f, 222.3f, 480.1f, 240.0f, 480.1f)
                lineTo(272.0f, 480.1f)
                lineTo(272.0f, 445.2f)
                curveTo(190.1f, 430.2f, 128.0f, 358.4f, 128.0f, 272.1f)
                curveTo(128.0f, 174.9f, 206.8f, 96.1f, 304.0f, 96.1f)
                curveTo(341.0f, 96.1f, 375.4f, 107.5f, 403.8f, 127.1f)
                lineTo(466.8f, 64.1f)
                lineTo(432.1f, 64.1f)
                close()
                moveTo(416.0f, 272.0f)
                curveTo(416.0f, 210.1f, 365.9f, 160.0f, 304.0f, 160.0f)
                curveTo(242.1f, 160.0f, 192.0f, 210.1f, 192.0f, 272.0f)
                curveTo(192.0f, 333.9f, 242.1f, 384.0f, 304.0f, 384.0f)
                curveTo(365.9f, 384.0f, 416.0f, 333.9f, 416.0f, 272.0f)
                close()
            }
        }
        .build()
        return `_mars-and-venus`!!
    }

private var `_mars-and-venus`: ImageVector? = null
