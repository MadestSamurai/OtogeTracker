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

public val Fa.`Helicopter-symbol`: ImageVector
    get() {
        if (`_helicopter-symbol` != null) {
            return `_helicopter-symbol`!!
        }
        `_helicopter-symbol` = Builder(name = "Helicopter-symbol", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(509.4f, 288.0f)
                lineTo(574.1f, 288.0f)
                curveTo(559.6f, 172.2f, 467.8f, 80.4f, 352.0f, 66.0f)
                lineTo(352.0f, 130.7f)
                curveTo(432.4f, 144.1f, 495.9f, 207.6f, 509.4f, 288.0f)
                close()
                moveTo(574.0f, 352.0f)
                lineTo(509.3f, 352.0f)
                curveTo(495.9f, 432.4f, 432.4f, 495.9f, 352.0f, 509.3f)
                lineTo(352.0f, 574.0f)
                curveTo(467.8f, 559.6f, 559.6f, 467.8f, 574.0f, 352.0f)
                close()
                moveTo(66.0f, 352.0f)
                curveTo(80.4f, 467.8f, 172.2f, 559.6f, 288.0f, 574.0f)
                lineTo(288.0f, 509.3f)
                curveTo(207.6f, 495.9f, 144.2f, 432.4f, 130.7f, 352.0f)
                lineTo(66.0f, 352.0f)
                close()
                moveTo(66.0f, 288.0f)
                lineTo(130.7f, 288.0f)
                curveTo(144.2f, 207.6f, 207.6f, 144.1f, 288.0f, 130.7f)
                lineTo(288.0f, 66.0f)
                curveTo(172.2f, 80.4f, 80.4f, 172.2f, 66.0f, 288.0f)
                close()
                moveTo(272.0f, 224.0f)
                curveTo(272.0f, 206.3f, 257.7f, 192.0f, 240.0f, 192.0f)
                curveTo(222.3f, 192.0f, 208.0f, 206.3f, 208.0f, 224.0f)
                lineTo(208.0f, 416.0f)
                curveTo(208.0f, 433.7f, 222.3f, 448.0f, 240.0f, 448.0f)
                curveTo(257.7f, 448.0f, 272.0f, 433.7f, 272.0f, 416.0f)
                lineTo(272.0f, 352.0f)
                lineTo(368.0f, 352.0f)
                lineTo(368.0f, 416.0f)
                curveTo(368.0f, 433.7f, 382.3f, 448.0f, 400.0f, 448.0f)
                curveTo(417.7f, 448.0f, 432.0f, 433.7f, 432.0f, 416.0f)
                lineTo(432.0f, 224.0f)
                curveTo(432.0f, 206.3f, 417.7f, 192.0f, 400.0f, 192.0f)
                curveTo(382.3f, 192.0f, 368.0f, 206.3f, 368.0f, 224.0f)
                lineTo(368.0f, 288.0f)
                lineTo(272.0f, 288.0f)
                lineTo(272.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_helicopter-symbol`!!
    }

private var `_helicopter-symbol`: ImageVector? = null
