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

public val Fa.`Ping-pong-paddle-ball`: ImageVector
    get() {
        if (`_ping-pong-paddle-ball` != null) {
            return `_ping-pong-paddle-ball`!!
        }
        `_ping-pong-paddle-ball` = Builder(name = "Ping-pong-paddle-ball", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(161.0f, 191.0f)
                lineTo(228.4f, 123.6f)
                curveTo(266.6f, 85.4f, 318.4f, 64.0f, 372.4f, 64.0f)
                curveTo(484.9f, 64.0f, 576.1f, 155.2f, 576.1f, 267.6f)
                curveTo(576.1f, 314.0f, 560.3f, 358.7f, 531.6f, 394.6f)
                curveTo(508.0f, 377.8f, 479.2f, 367.9f, 448.1f, 367.9f)
                curveTo(417.0f, 367.9f, 388.2f, 377.8f, 364.7f, 394.5f)
                lineTo(161.0f, 191.0f)
                close()
                moveTo(304.0f, 512.0f)
                curveTo(304.0f, 521.7f, 305.0f, 531.1f, 306.8f, 540.2f)
                curveTo(287.0f, 535.0f, 268.8f, 524.7f, 254.1f, 510.0f)
                curveTo(241.9f, 497.8f, 222.2f, 497.8f, 210.0f, 510.0f)
                lineTo(160.6f, 559.4f)
                curveTo(150.0f, 570.0f, 135.6f, 576.0f, 120.6f, 576.0f)
                curveTo(89.4f, 576.0f, 64.0f, 550.7f, 64.0f, 519.4f)
                curveTo(64.0f, 504.4f, 70.0f, 490.0f, 80.6f, 479.4f)
                lineTo(130.0f, 430.0f)
                curveTo(142.2f, 417.8f, 142.2f, 398.1f, 130.0f, 385.9f)
                curveTo(108.3f, 364.2f, 96.1f, 334.7f, 96.1f, 304.0f)
                curveTo(96.1f, 274.6f, 107.2f, 246.4f, 127.2f, 225.0f)
                lineTo(330.6f, 428.6f)
                curveTo(313.9f, 452.1f, 304.0f, 480.9f, 304.0f, 512.0f)
                close()
                moveTo(448.0f, 416.0f)
                curveTo(501.0f, 416.0f, 544.0f, 459.0f, 544.0f, 512.0f)
                curveTo(544.0f, 565.0f, 501.0f, 608.0f, 448.0f, 608.0f)
                curveTo(395.0f, 608.0f, 352.0f, 565.0f, 352.0f, 512.0f)
                curveTo(352.0f, 459.0f, 395.0f, 416.0f, 448.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_ping-pong-paddle-ball`!!
    }

private var `_ping-pong-paddle-ball`: ImageVector? = null
