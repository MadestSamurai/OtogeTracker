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

public val Fa.`Hand-rock`: ImageVector
    get() {
        if (`_hand-rock` != null) {
            return `_hand-rock`!!
        }
        `_hand-rock` = Builder(name = "Hand-rock", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(135.4f, 317.6f)
                curveTo(130.6f, 309.9f, 128.0f, 301.1f, 128.0f, 292.0f)
                lineTo(128.0f, 256.0f)
                curveTo(128.0f, 229.5f, 149.5f, 208.0f, 176.0f, 208.0f)
                lineTo(192.0f, 208.0f)
                lineTo(192.0f, 128.0f)
                curveTo(192.0f, 101.5f, 213.5f, 80.0f, 240.0f, 80.0f)
                curveTo(257.3f, 80.0f, 272.4f, 89.1f, 280.9f, 102.8f)
                curveTo(285.2f, 80.7f, 304.7f, 64.0f, 328.0f, 64.0f)
                curveTo(351.4f, 64.0f, 370.9f, 80.8f, 375.1f, 102.9f)
                curveTo(382.4f, 98.5f, 390.9f, 96.0f, 400.0f, 96.0f)
                curveTo(422.1f, 96.0f, 440.8f, 111.0f, 446.3f, 131.4f)
                curveTo(451.8f, 129.2f, 457.7f, 128.0f, 464.0f, 128.0f)
                curveTo(490.5f, 128.0f, 512.0f, 149.5f, 512.0f, 176.0f)
                lineTo(512.0f, 272.9f)
                curveTo(512.0f, 282.8f, 509.7f, 292.6f, 505.2f, 301.5f)
                lineTo(465.6f, 380.6f)
                curveTo(454.8f, 402.3f, 432.6f, 416.0f, 408.4f, 416.0f)
                lineTo(224.0f, 416.0f)
                curveTo(207.5f, 416.0f, 192.2f, 407.6f, 183.4f, 393.6f)
                lineTo(135.4f, 317.6f)
                close()
                moveTo(160.0f, 544.0f)
                lineTo(160.0f, 496.0f)
                curveTo(160.0f, 478.3f, 174.3f, 464.0f, 192.0f, 464.0f)
                lineTo(448.0f, 464.0f)
                curveTo(465.7f, 464.0f, 480.0f, 478.3f, 480.0f, 496.0f)
                lineTo(480.0f, 544.0f)
                curveTo(480.0f, 561.7f, 465.7f, 576.0f, 448.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(174.3f, 576.0f, 160.0f, 561.7f, 160.0f, 544.0f)
                close()
            }
        }
        .build()
        return `_hand-rock`!!
    }

private var `_hand-rock`: ImageVector? = null
