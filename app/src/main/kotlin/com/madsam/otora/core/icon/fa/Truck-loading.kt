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

public val Fa.`Truck-loading`: ImageVector
    get() {
        if (`_truck-loading` != null) {
            return `_truck-loading`!!
        }
        `_truck-loading` = Builder(name = "Truck-loading", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(432.0f, 96.0f)
                curveTo(387.8f, 96.0f, 352.0f, 131.8f, 352.0f, 176.0f)
                lineTo(352.0f, 424.2f)
                lineTo(54.8f, 513.4f)
                curveTo(37.9f, 518.4f, 28.3f, 536.3f, 33.4f, 553.2f)
                curveTo(38.5f, 570.1f, 56.3f, 579.7f, 73.2f, 574.7f)
                lineTo(388.7f, 480.1f)
                lineTo(432.4f, 480.1f)
                curveTo(432.2f, 482.7f, 432.0f, 485.4f, 432.0f, 488.1f)
                curveTo(432.0f, 536.7f, 471.4f, 576.1f, 520.0f, 576.1f)
                curveTo(568.6f, 576.1f, 608.0f, 536.7f, 608.0f, 488.1f)
                lineTo(608.0f, 96.1f)
                lineTo(432.0f, 96.1f)
                close()
                moveTo(560.0f, 488.0f)
                curveTo(560.0f, 510.1f, 542.1f, 528.0f, 520.0f, 528.0f)
                curveTo(497.9f, 528.0f, 480.0f, 510.1f, 480.0f, 488.0f)
                curveTo(480.0f, 465.9f, 497.9f, 448.0f, 520.0f, 448.0f)
                curveTo(542.1f, 448.0f, 559.9f, 465.9f, 560.0f, 487.9f)
                lineTo(560.0f, 488.0f)
                close()
                moveTo(83.9f, 213.5f)
                curveTo(50.1f, 223.8f, 31.1f, 259.6f, 41.4f, 293.4f)
                lineTo(69.5f, 385.2f)
                curveTo(79.8f, 419.0f, 115.6f, 438.0f, 149.4f, 427.7f)
                lineTo(241.2f, 399.6f)
                curveTo(275.0f, 389.3f, 294.0f, 353.5f, 283.7f, 319.7f)
                lineTo(255.6f, 227.9f)
                curveTo(245.3f, 194.1f, 209.5f, 175.1f, 175.7f, 185.4f)
                lineTo(83.9f, 213.5f)
                close()
            }
        }
        .build()
        return `_truck-loading`!!
    }

private var `_truck-loading`: ImageVector? = null
