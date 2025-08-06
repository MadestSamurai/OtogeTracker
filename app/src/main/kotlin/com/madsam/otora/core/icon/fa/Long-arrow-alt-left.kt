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

public val Fa.`Long-arrow-alt-left`: ImageVector
    get() {
        if (`_long-arrow-alt-left` != null) {
            return `_long-arrow-alt-left`!!
        }
        `_long-arrow-alt-left` = Builder(name = "Long-arrow-alt-left", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(41.4f, 342.6f)
                curveTo(28.9f, 330.1f, 28.9f, 309.8f, 41.4f, 297.3f)
                lineTo(169.4f, 169.3f)
                curveTo(178.6f, 160.1f, 192.3f, 157.4f, 204.3f, 162.4f)
                curveTo(216.3f, 167.4f, 224.0f, 179.1f, 224.0f, 192.0f)
                lineTo(224.0f, 256.0f)
                lineTo(560.0f, 256.0f)
                curveTo(586.5f, 256.0f, 608.0f, 277.5f, 608.0f, 304.0f)
                lineTo(608.0f, 336.0f)
                curveTo(608.0f, 362.5f, 586.5f, 384.0f, 560.0f, 384.0f)
                lineTo(224.0f, 384.0f)
                lineTo(224.0f, 448.0f)
                curveTo(224.0f, 460.9f, 216.2f, 472.6f, 204.2f, 477.6f)
                curveTo(192.2f, 482.6f, 178.5f, 479.8f, 169.3f, 470.7f)
                lineTo(41.3f, 342.7f)
                close()
            }
        }
        .build()
        return `_long-arrow-alt-left`!!
    }

private var `_long-arrow-alt-left`: ImageVector? = null
