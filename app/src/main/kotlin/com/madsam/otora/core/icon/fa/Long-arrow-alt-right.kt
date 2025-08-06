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

public val Fa.`Long-arrow-alt-right`: ImageVector
    get() {
        if (`_long-arrow-alt-right` != null) {
            return `_long-arrow-alt-right`!!
        }
        `_long-arrow-alt-right` = Builder(name = "Long-arrow-alt-right", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(598.6f, 297.4f)
                curveTo(611.1f, 309.9f, 611.1f, 330.2f, 598.6f, 342.7f)
                lineTo(470.6f, 470.7f)
                curveTo(461.4f, 479.9f, 447.7f, 482.6f, 435.7f, 477.6f)
                curveTo(423.7f, 472.6f, 416.0f, 460.9f, 416.0f, 448.0f)
                lineTo(416.0f, 384.0f)
                lineTo(80.0f, 384.0f)
                curveTo(53.5f, 384.0f, 32.0f, 362.5f, 32.0f, 336.0f)
                lineTo(32.0f, 304.0f)
                curveTo(32.0f, 277.5f, 53.5f, 256.0f, 80.0f, 256.0f)
                lineTo(416.0f, 256.0f)
                lineTo(416.0f, 192.0f)
                curveTo(416.0f, 179.1f, 423.8f, 167.4f, 435.8f, 162.4f)
                curveTo(447.8f, 157.4f, 461.5f, 160.2f, 470.7f, 169.3f)
                lineTo(598.7f, 297.3f)
                close()
            }
        }
        .build()
        return `_long-arrow-alt-right`!!
    }

private var `_long-arrow-alt-right`: ImageVector? = null
