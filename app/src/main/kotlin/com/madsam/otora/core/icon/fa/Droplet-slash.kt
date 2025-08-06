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

public val Fa.`Droplet-slash`: ImageVector
    get() {
        if (`_droplet-slash` != null) {
            return `_droplet-slash`!!
        }
        `_droplet-slash` = Builder(name = "Droplet-slash", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(495.6f, 461.8f)
                curveTo(506.1f, 438.0f, 512.0f, 411.7f, 512.0f, 384.0f)
                curveTo(512.0f, 292.8f, 381.8f, 109.9f, 345.4f, 60.5f)
                curveTo(339.5f, 52.5f, 330.2f, 48.0f, 320.2f, 48.0f)
                lineTo(319.8f, 48.0f)
                curveTo(309.8f, 48.0f, 300.5f, 52.5f, 294.6f, 60.5f)
                curveTo(279.0f, 81.7f, 246.1f, 127.4f, 213.7f, 179.9f)
                lineTo(73.0f, 39.1f)
                close()
                moveTo(165.0f, 266.8f)
                curveTo(143.4f, 310.6f, 128.0f, 352.7f, 128.0f, 384.0f)
                curveTo(128.0f, 490.0f, 214.0f, 576.0f, 320.0f, 576.0f)
                curveTo(363.4f, 576.0f, 403.4f, 561.6f, 435.5f, 537.4f)
                lineTo(165.0f, 266.8f)
                close()
            }
        }
        .build()
        return `_droplet-slash`!!
    }

private var `_droplet-slash`: ImageVector? = null
