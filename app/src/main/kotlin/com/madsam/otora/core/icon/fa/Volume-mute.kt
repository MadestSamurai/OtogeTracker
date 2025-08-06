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

public val Fa.`Volume-mute`: ImageVector
    get() {
        if (`_volume-mute` != null) {
            return `_volume-mute`!!
        }
        `_volume-mute` = Builder(name = "Volume-mute", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(80.0f, 416.0f)
                lineTo(128.0f, 416.0f)
                lineTo(262.1f, 535.2f)
                curveTo(268.5f, 540.9f, 276.7f, 544.0f, 285.2f, 544.0f)
                curveTo(304.4f, 544.0f, 320.0f, 528.4f, 320.0f, 509.2f)
                lineTo(320.0f, 130.8f)
                curveTo(320.0f, 111.6f, 304.4f, 96.0f, 285.2f, 96.0f)
                curveTo(276.7f, 96.0f, 268.5f, 99.1f, 262.1f, 104.8f)
                lineTo(128.0f, 224.0f)
                lineTo(80.0f, 224.0f)
                curveTo(53.5f, 224.0f, 32.0f, 245.5f, 32.0f, 272.0f)
                lineTo(32.0f, 368.0f)
                curveTo(32.0f, 394.5f, 53.5f, 416.0f, 80.0f, 416.0f)
                close()
                moveTo(399.0f, 239.0f)
                curveTo(389.6f, 248.4f, 389.6f, 263.6f, 399.0f, 272.9f)
                lineTo(446.0f, 319.9f)
                lineTo(399.0f, 366.9f)
                curveTo(389.6f, 376.3f, 389.6f, 391.5f, 399.0f, 400.8f)
                curveTo(408.4f, 410.1f, 423.6f, 410.2f, 432.9f, 400.8f)
                lineTo(479.9f, 353.8f)
                lineTo(526.9f, 400.8f)
                curveTo(536.3f, 410.2f, 551.5f, 410.2f, 560.8f, 400.8f)
                curveTo(570.1f, 391.4f, 570.2f, 376.2f, 560.8f, 366.9f)
                lineTo(513.8f, 319.9f)
                lineTo(560.8f, 272.9f)
                curveTo(570.2f, 263.5f, 570.2f, 248.3f, 560.8f, 239.0f)
                curveTo(551.4f, 229.7f, 536.2f, 229.6f, 526.9f, 239.0f)
                lineTo(479.9f, 286.0f)
                lineTo(432.9f, 239.0f)
                curveTo(423.5f, 229.6f, 408.3f, 229.6f, 399.0f, 239.0f)
                close()
            }
        }
        .build()
        return `_volume-mute`!!
    }

private var `_volume-mute`: ImageVector? = null
