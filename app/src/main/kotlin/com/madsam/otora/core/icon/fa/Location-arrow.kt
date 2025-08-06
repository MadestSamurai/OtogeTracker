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

public val Fa.`Location-arrow`: ImageVector
    get() {
        if (`_location-arrow` != null) {
            return `_location-arrow`!!
        }
        `_location-arrow` = Builder(name = "Location-arrow", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(541.9f, 139.5f)
                curveTo(546.4f, 127.7f, 543.6f, 114.3f, 534.7f, 105.4f)
                curveTo(525.8f, 96.5f, 512.4f, 93.6f, 500.6f, 98.2f)
                lineTo(84.6f, 258.2f)
                curveTo(71.9f, 263.0f, 63.7f, 275.2f, 64.0f, 288.7f)
                curveTo(64.3f, 302.2f, 73.1f, 314.1f, 85.9f, 318.3f)
                lineTo(262.7f, 377.2f)
                lineTo(321.6f, 554.0f)
                curveTo(325.9f, 566.8f, 337.7f, 575.6f, 351.2f, 575.9f)
                curveTo(364.7f, 576.2f, 376.9f, 568.0f, 381.8f, 555.4f)
                lineTo(541.8f, 139.4f)
                close()
            }
        }
        .build()
        return `_location-arrow`!!
    }

private var `_location-arrow`: ImageVector? = null
