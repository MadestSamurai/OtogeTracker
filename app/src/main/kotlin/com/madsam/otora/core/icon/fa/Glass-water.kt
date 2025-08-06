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

public val Fa.`Glass-water`: ImageVector
    get() {
        if (`_glass-water` != null) {
            return `_glass-water`!!
        }
        `_glass-water` = Builder(name = "Glass-water", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 64.0f)
                curveTo(151.1f, 64.0f, 142.6f, 67.7f, 136.6f, 74.2f)
                curveTo(130.6f, 80.7f, 127.4f, 89.4f, 128.1f, 98.3f)
                lineTo(156.9f, 501.7f)
                curveTo(159.9f, 543.6f, 194.7f, 576.0f, 236.7f, 576.0f)
                lineTo(403.3f, 576.0f)
                curveTo(445.3f, 576.0f, 480.1f, 543.6f, 483.1f, 501.7f)
                lineTo(511.9f, 98.3f)
                curveTo(512.5f, 89.4f, 509.5f, 80.7f, 503.4f, 74.2f)
                curveTo(497.3f, 67.7f, 488.9f, 64.0f, 480.0f, 64.0f)
                lineTo(160.0f, 64.0f)
                close()
                moveTo(201.0f, 220.5f)
                lineTo(194.4f, 128.0f)
                lineTo(445.7f, 128.0f)
                lineTo(439.1f, 220.5f)
                lineTo(414.9f, 232.6f)
                curveTo(395.5f, 242.3f, 372.7f, 242.3f, 353.3f, 232.6f)
                curveTo(332.4f, 222.2f, 307.8f, 222.2f, 286.9f, 232.6f)
                curveTo(267.5f, 242.3f, 244.7f, 242.3f, 225.3f, 232.6f)
                lineTo(201.0f, 220.5f)
                close()
            }
        }
        .build()
        return `_glass-water`!!
    }

private var `_glass-water`: ImageVector? = null
