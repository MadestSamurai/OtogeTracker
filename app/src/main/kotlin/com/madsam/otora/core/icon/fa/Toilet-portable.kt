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

public val Fa.`Toilet-portable`: ImageVector
    get() {
        if (`_toilet-portable` != null) {
            return `_toilet-portable`!!
        }
        `_toilet-portable` = Builder(name = "Toilet-portable", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 128.0f)
                lineTo(160.0f, 144.0f)
                lineTo(480.0f, 144.0f)
                lineTo(480.0f, 128.0f)
                curveTo(480.0f, 92.7f, 451.3f, 64.0f, 416.0f, 64.0f)
                lineTo(224.0f, 64.0f)
                curveTo(188.7f, 64.0f, 160.0f, 92.7f, 160.0f, 128.0f)
                close()
                moveTo(184.0f, 192.0f)
                lineTo(160.0f, 192.0f)
                lineTo(160.0f, 552.0f)
                curveTo(160.0f, 565.3f, 170.7f, 576.0f, 184.0f, 576.0f)
                curveTo(197.3f, 576.0f, 208.0f, 565.3f, 208.0f, 552.0f)
                lineTo(208.0f, 544.0f)
                lineTo(432.0f, 544.0f)
                lineTo(432.0f, 552.0f)
                curveTo(432.0f, 565.3f, 442.7f, 576.0f, 456.0f, 576.0f)
                curveTo(469.3f, 576.0f, 480.0f, 565.3f, 480.0f, 552.0f)
                lineTo(480.0f, 192.0f)
                lineTo(184.0f, 192.0f)
                close()
                moveTo(408.0f, 288.0f)
                lineTo(432.0f, 288.0f)
                lineTo(432.0f, 384.0f)
                lineTo(408.0f, 384.0f)
                curveTo(394.7f, 384.0f, 384.0f, 373.3f, 384.0f, 360.0f)
                lineTo(384.0f, 312.0f)
                curveTo(384.0f, 298.7f, 394.7f, 288.0f, 408.0f, 288.0f)
                close()
            }
        }
        .build()
        return `_toilet-portable`!!
    }

private var `_toilet-portable`: ImageVector? = null
