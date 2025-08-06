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

public val Fa.`Truck-front`: ImageVector
    get() {
        if (`_truck-front` != null) {
            return `_truck-front`!!
        }
        `_truck-front` = Builder(name = "Truck-front", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 176.0f)
                curveTo(96.0f, 131.8f, 131.8f, 96.0f, 176.0f, 96.0f)
                lineTo(464.0f, 96.0f)
                curveTo(508.2f, 96.0f, 544.0f, 131.8f, 544.0f, 176.0f)
                lineTo(544.0f, 432.0f)
                curveTo(544.0f, 458.2f, 531.4f, 481.4f, 512.0f, 496.0f)
                lineTo(512.0f, 544.0f)
                curveTo(512.0f, 561.7f, 497.7f, 576.0f, 480.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(430.3f, 576.0f, 416.0f, 561.7f, 416.0f, 544.0f)
                lineTo(416.0f, 512.0f)
                lineTo(224.0f, 512.0f)
                lineTo(224.0f, 544.0f)
                curveTo(224.0f, 561.7f, 209.7f, 576.0f, 192.0f, 576.0f)
                lineTo(160.0f, 576.0f)
                curveTo(142.3f, 576.0f, 128.0f, 561.7f, 128.0f, 544.0f)
                lineTo(128.0f, 496.0f)
                curveTo(108.6f, 481.4f, 96.0f, 458.2f, 96.0f, 432.0f)
                lineTo(96.0f, 176.0f)
                close()
                moveTo(192.0f, 256.0f)
                lineTo(192.0f, 320.0f)
                lineTo(448.0f, 320.0f)
                lineTo(448.0f, 256.0f)
                curveTo(448.0f, 238.3f, 433.7f, 224.0f, 416.0f, 224.0f)
                lineTo(224.0f, 224.0f)
                curveTo(206.3f, 224.0f, 192.0f, 238.3f, 192.0f, 256.0f)
                close()
                moveTo(224.0f, 416.0f)
                curveTo(224.0f, 398.3f, 209.7f, 384.0f, 192.0f, 384.0f)
                curveTo(174.3f, 384.0f, 160.0f, 398.3f, 160.0f, 416.0f)
                curveTo(160.0f, 433.7f, 174.3f, 448.0f, 192.0f, 448.0f)
                curveTo(209.7f, 448.0f, 224.0f, 433.7f, 224.0f, 416.0f)
                close()
                moveTo(448.0f, 448.0f)
                curveTo(465.7f, 448.0f, 480.0f, 433.7f, 480.0f, 416.0f)
                curveTo(480.0f, 398.3f, 465.7f, 384.0f, 448.0f, 384.0f)
                curveTo(430.3f, 384.0f, 416.0f, 398.3f, 416.0f, 416.0f)
                curveTo(416.0f, 433.7f, 430.3f, 448.0f, 448.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_truck-front`!!
    }

private var `_truck-front`: ImageVector? = null
