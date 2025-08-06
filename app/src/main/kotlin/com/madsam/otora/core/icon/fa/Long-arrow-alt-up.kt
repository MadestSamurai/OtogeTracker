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

public val Fa.`Long-arrow-alt-up`: ImageVector
    get() {
        if (`_long-arrow-alt-up` != null) {
            return `_long-arrow-alt-up`!!
        }
        `_long-arrow-alt-up` = Builder(name = "Long-arrow-alt-up", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 41.4f)
                curveTo(309.9f, 28.9f, 330.2f, 28.9f, 342.7f, 41.4f)
                lineTo(470.7f, 169.4f)
                curveTo(479.9f, 178.6f, 482.6f, 192.3f, 477.6f, 204.3f)
                curveTo(472.6f, 216.3f, 460.9f, 224.0f, 448.0f, 224.0f)
                lineTo(384.0f, 224.0f)
                lineTo(384.0f, 560.0f)
                curveTo(384.0f, 586.5f, 362.5f, 608.0f, 336.0f, 608.0f)
                lineTo(304.0f, 608.0f)
                curveTo(277.5f, 608.0f, 256.0f, 586.5f, 256.0f, 560.0f)
                lineTo(256.0f, 224.0f)
                lineTo(192.0f, 224.0f)
                curveTo(179.1f, 224.0f, 167.4f, 216.2f, 162.4f, 204.2f)
                curveTo(157.4f, 192.2f, 160.2f, 178.5f, 169.4f, 169.4f)
                lineTo(297.4f, 41.4f)
                close()
            }
        }
        .build()
        return `_long-arrow-alt-up`!!
    }

private var `_long-arrow-alt-up`: ImageVector? = null
