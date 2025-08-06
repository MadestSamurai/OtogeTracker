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

public val Fa.`Down-long`: ImageVector
    get() {
        if (`_down-long` != null) {
            return `_down-long`!!
        }
        `_down-long` = Builder(name = "Down-long", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 598.6f)
                curveTo(309.9f, 611.1f, 330.2f, 611.1f, 342.7f, 598.6f)
                lineTo(470.7f, 470.6f)
                curveTo(479.9f, 461.4f, 482.6f, 447.7f, 477.6f, 435.7f)
                curveTo(472.6f, 423.7f, 460.9f, 416.0f, 448.0f, 416.0f)
                lineTo(384.0f, 416.0f)
                lineTo(384.0f, 80.0f)
                curveTo(384.0f, 53.5f, 362.5f, 32.0f, 336.0f, 32.0f)
                lineTo(304.0f, 32.0f)
                curveTo(277.5f, 32.0f, 256.0f, 53.5f, 256.0f, 80.0f)
                lineTo(256.0f, 416.0f)
                lineTo(192.0f, 416.0f)
                curveTo(179.1f, 416.0f, 167.4f, 423.8f, 162.4f, 435.8f)
                curveTo(157.4f, 447.8f, 160.2f, 461.5f, 169.4f, 470.6f)
                lineTo(297.4f, 598.6f)
                close()
            }
        }
        .build()
        return `_down-long`!!
    }

private var `_down-long`: ImageVector? = null
