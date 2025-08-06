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

public val Fa.`Map-signs`: ImageVector
    get() {
        if (`_map-signs` != null) {
            return `_map-signs`!!
        }
        `_map-signs` = Builder(name = "Map-signs", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.4f, 64.0f)
                curveTo(302.7f, 64.0f, 288.4f, 78.3f, 288.4f, 96.0f)
                lineTo(288.4f, 128.0f)
                lineTo(128.4f, 128.0f)
                curveTo(110.7f, 128.0f, 96.4f, 142.3f, 96.4f, 160.0f)
                lineTo(96.4f, 224.0f)
                curveTo(96.4f, 241.7f, 110.7f, 256.0f, 128.4f, 256.0f)
                lineTo(288.4f, 256.0f)
                lineTo(288.4f, 320.0f)
                lineTo(135.0f, 320.0f)
                curveTo(130.8f, 320.0f, 126.7f, 321.7f, 123.7f, 324.7f)
                lineTo(75.7f, 372.7f)
                curveTo(69.5f, 378.9f, 69.5f, 389.1f, 75.7f, 395.3f)
                lineTo(123.7f, 443.3f)
                curveTo(126.7f, 446.3f, 130.8f, 448.0f, 135.0f, 448.0f)
                lineTo(288.4f, 448.0f)
                lineTo(288.4f, 544.0f)
                curveTo(288.4f, 561.7f, 302.7f, 576.0f, 320.4f, 576.0f)
                curveTo(338.1f, 576.0f, 352.4f, 561.7f, 352.4f, 544.0f)
                lineTo(352.4f, 448.0f)
                lineTo(512.4f, 448.0f)
                curveTo(530.1f, 448.0f, 544.4f, 433.7f, 544.4f, 416.0f)
                lineTo(544.4f, 352.0f)
                curveTo(544.4f, 334.3f, 530.1f, 320.0f, 512.4f, 320.0f)
                lineTo(352.4f, 320.0f)
                lineTo(352.4f, 256.0f)
                lineTo(505.8f, 256.0f)
                curveTo(510.0f, 256.0f, 514.1f, 254.3f, 517.1f, 251.3f)
                lineTo(565.1f, 203.3f)
                curveTo(571.3f, 197.1f, 571.3f, 186.9f, 565.1f, 180.7f)
                lineTo(517.1f, 132.7f)
                curveTo(514.1f, 129.7f, 510.0f, 128.0f, 505.8f, 128.0f)
                lineTo(352.4f, 128.0f)
                lineTo(352.4f, 96.0f)
                curveTo(352.4f, 78.3f, 338.1f, 64.0f, 320.4f, 64.0f)
                close()
            }
        }
        .build()
        return `_map-signs`!!
    }

private var `_map-signs`: ImageVector? = null
