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

public val Fa.`Meh-rolling-eyes`: ImageVector
    get() {
        if (`_meh-rolling-eyes` != null) {
            return `_meh-rolling-eyes`!!
        }
        `_meh-rolling-eyes` = Builder(name = "Meh-rolling-eyes", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(256.0f, 416.0f)
                lineTo(384.0f, 416.0f)
                curveTo(397.3f, 416.0f, 408.0f, 426.7f, 408.0f, 440.0f)
                curveTo(408.0f, 453.3f, 397.3f, 464.0f, 384.0f, 464.0f)
                lineTo(256.0f, 464.0f)
                curveTo(242.7f, 464.0f, 232.0f, 453.3f, 232.0f, 440.0f)
                curveTo(232.0f, 426.7f, 242.7f, 416.0f, 256.0f, 416.0f)
                close()
                moveTo(288.0f, 288.0f)
                curveTo(288.0f, 323.3f, 259.3f, 352.0f, 224.0f, 352.0f)
                curveTo(188.7f, 352.0f, 160.0f, 323.3f, 160.0f, 288.0f)
                curveTo(160.0f, 262.0f, 175.5f, 239.6f, 197.8f, 229.6f)
                curveTo(194.1f, 234.8f, 192.0f, 241.2f, 192.0f, 248.0f)
                curveTo(192.0f, 265.7f, 206.3f, 280.0f, 224.0f, 280.0f)
                curveTo(241.7f, 280.0f, 256.0f, 265.7f, 256.0f, 248.0f)
                curveTo(256.0f, 241.1f, 253.8f, 234.8f, 250.2f, 229.6f)
                curveTo(272.5f, 239.6f, 288.0f, 262.0f, 288.0f, 288.0f)
                close()
                moveTo(416.0f, 352.0f)
                curveTo(380.7f, 352.0f, 352.0f, 323.3f, 352.0f, 288.0f)
                curveTo(352.0f, 262.0f, 367.5f, 239.6f, 389.8f, 229.6f)
                curveTo(386.1f, 234.8f, 384.0f, 241.2f, 384.0f, 248.0f)
                curveTo(384.0f, 265.7f, 398.3f, 280.0f, 416.0f, 280.0f)
                curveTo(433.7f, 280.0f, 448.0f, 265.7f, 448.0f, 248.0f)
                curveTo(448.0f, 241.1f, 445.8f, 234.8f, 442.2f, 229.6f)
                curveTo(464.5f, 239.6f, 480.0f, 262.0f, 480.0f, 288.0f)
                curveTo(480.0f, 323.3f, 451.3f, 352.0f, 416.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_meh-rolling-eyes`!!
    }

private var `_meh-rolling-eyes`: ImageVector? = null
