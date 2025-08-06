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

public val Fa.`Volume-off`: ImageVector
    get() {
        if (`_volume-off` != null) {
            return `_volume-off`!!
        }
        `_volume-off` = Builder(name = "Volume-off", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 416.0f)
                lineTo(208.0f, 416.0f)
                curveTo(181.5f, 416.0f, 160.0f, 394.5f, 160.0f, 368.0f)
                lineTo(160.0f, 272.0f)
                curveTo(160.0f, 245.5f, 181.5f, 224.0f, 208.0f, 224.0f)
                lineTo(256.0f, 224.0f)
                lineTo(390.1f, 104.8f)
                curveTo(396.5f, 99.1f, 404.7f, 96.0f, 413.2f, 96.0f)
                curveTo(432.4f, 96.0f, 448.0f, 111.6f, 448.0f, 130.8f)
                lineTo(448.0f, 509.2f)
                curveTo(448.0f, 528.4f, 432.4f, 544.0f, 413.2f, 544.0f)
                curveTo(404.7f, 544.0f, 396.5f, 540.9f, 390.1f, 535.2f)
                lineTo(256.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_volume-off`!!
    }

private var `_volume-off`: ImageVector? = null
