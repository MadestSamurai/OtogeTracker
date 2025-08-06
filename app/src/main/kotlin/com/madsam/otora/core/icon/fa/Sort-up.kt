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

public val Fa.`Sort-up`: ImageVector
    get() {
        if (`_sort-up` != null) {
            return `_sort-up`!!
        }
        `_sort-up` = Builder(name = "Sort-up", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 288.0f)
                curveTo(147.1f, 288.0f, 135.4f, 280.2f, 130.4f, 268.2f)
                curveTo(125.4f, 256.2f, 128.2f, 242.5f, 137.4f, 233.4f)
                lineTo(297.4f, 73.4f)
                curveTo(309.9f, 60.9f, 330.2f, 60.9f, 342.7f, 73.4f)
                lineTo(502.7f, 233.4f)
                curveTo(511.9f, 242.6f, 514.6f, 256.3f, 509.6f, 268.3f)
                curveTo(504.6f, 280.3f, 492.9f, 288.0f, 480.0f, 288.0f)
                lineTo(160.0f, 288.0f)
                close()
            }
        }
        .build()
        return `_sort-up`!!
    }

private var `_sort-up`: ImageVector? = null
