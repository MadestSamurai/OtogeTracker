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

public val Fa.`Arrow-turn-up`: ImageVector
    get() {
        if (`_arrow-turn-up` != null) {
            return `_arrow-turn-up`!!
        }
        `_arrow-turn-up` = Builder(name = "Arrow-turn-up", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 512.0f)
                curveTo(142.3f, 512.0f, 128.0f, 526.3f, 128.0f, 544.0f)
                curveTo(128.0f, 561.7f, 142.3f, 576.0f, 160.0f, 576.0f)
                lineTo(256.0f, 576.0f)
                curveTo(309.0f, 576.0f, 352.0f, 533.0f, 352.0f, 480.0f)
                lineTo(352.0f, 173.3f)
                lineTo(425.4f, 246.7f)
                curveTo(437.9f, 259.2f, 458.2f, 259.2f, 470.7f, 246.7f)
                curveTo(483.2f, 234.2f, 483.2f, 213.9f, 470.7f, 201.4f)
                lineTo(342.7f, 73.4f)
                curveTo(330.2f, 60.9f, 309.9f, 60.9f, 297.4f, 73.4f)
                lineTo(169.4f, 201.4f)
                curveTo(156.9f, 213.9f, 156.9f, 234.2f, 169.4f, 246.7f)
                curveTo(181.9f, 259.2f, 202.2f, 259.2f, 214.7f, 246.7f)
                lineTo(288.0f, 173.3f)
                lineTo(288.0f, 480.0f)
                curveTo(288.0f, 497.7f, 273.7f, 512.0f, 256.0f, 512.0f)
                lineTo(160.0f, 512.0f)
                close()
            }
        }
        .build()
        return `_arrow-turn-up`!!
    }

private var `_arrow-turn-up`: ImageVector? = null
