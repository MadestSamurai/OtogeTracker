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

public val Fa.`Level-down-alt`: ImageVector
    get() {
        if (`_level-down-alt` != null) {
            return `_level-down-alt`!!
        }
        `_level-down-alt` = Builder(name = "Level-down-alt", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 566.6f)
                curveTo(309.9f, 579.1f, 330.2f, 579.1f, 342.7f, 566.6f)
                lineTo(470.7f, 438.6f)
                curveTo(479.9f, 429.4f, 482.6f, 415.7f, 477.6f, 403.7f)
                curveTo(472.6f, 391.7f, 460.9f, 384.0f, 448.0f, 384.0f)
                lineTo(384.0f, 384.0f)
                lineTo(384.0f, 224.0f)
                curveTo(384.0f, 135.6f, 312.4f, 64.0f, 224.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                curveTo(142.3f, 64.0f, 128.0f, 78.3f, 128.0f, 96.0f)
                lineTo(128.0f, 160.0f)
                curveTo(128.0f, 177.7f, 142.3f, 192.0f, 160.0f, 192.0f)
                lineTo(224.0f, 192.0f)
                curveTo(241.7f, 192.0f, 256.0f, 206.3f, 256.0f, 224.0f)
                lineTo(256.0f, 384.0f)
                lineTo(192.0f, 384.0f)
                curveTo(179.1f, 384.0f, 167.4f, 391.8f, 162.4f, 403.8f)
                curveTo(157.4f, 415.8f, 160.2f, 429.5f, 169.3f, 438.7f)
                lineTo(297.3f, 566.7f)
                close()
            }
        }
        .build()
        return `_level-down-alt`!!
    }

private var `_level-down-alt`: ImageVector? = null
