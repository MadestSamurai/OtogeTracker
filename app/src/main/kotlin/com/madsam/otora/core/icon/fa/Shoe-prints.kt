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

public val Fa.`Shoe-prints`: ImageVector
    get() {
        if (`_shoe-prints` != null) {
            return `_shoe-prints`!!
        }
        `_shoe-prints` = Builder(name = "Shoe-prints", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(328.0f, 256.0f)
                curveTo(306.9f, 243.9f, 285.7f, 231.8f, 256.0f, 226.7f)
                lineTo(256.0f, 86.4f)
                curveTo(289.7f, 77.0f, 343.4f, 64.0f, 384.0f, 64.0f)
                curveTo(480.0f, 64.0f, 608.0f, 112.0f, 608.0f, 192.0f)
                curveTo(608.0f, 272.0f, 488.4f, 288.0f, 432.0f, 288.0f)
                curveTo(384.0f, 288.0f, 356.0f, 272.0f, 328.0f, 256.0f)
                close()
                moveTo(160.0f, 96.0f)
                lineTo(208.0f, 96.0f)
                lineTo(208.0f, 224.0f)
                lineTo(160.0f, 224.0f)
                curveTo(124.7f, 224.0f, 96.0f, 195.3f, 96.0f, 160.0f)
                curveTo(96.0f, 124.7f, 124.7f, 96.0f, 160.0f, 96.0f)
                close()
                moveTo(264.0f, 384.0f)
                curveTo(292.0f, 368.0f, 320.0f, 352.0f, 368.0f, 352.0f)
                curveTo(424.4f, 352.0f, 544.0f, 368.0f, 544.0f, 448.0f)
                curveTo(544.0f, 528.0f, 416.0f, 576.0f, 320.0f, 576.0f)
                curveTo(279.5f, 576.0f, 225.7f, 563.0f, 192.0f, 553.6f)
                lineTo(192.0f, 413.3f)
                curveTo(221.7f, 408.1f, 242.9f, 396.0f, 264.0f, 383.9f)
                close()
                moveTo(96.0f, 544.0f)
                curveTo(60.7f, 544.0f, 32.0f, 515.3f, 32.0f, 480.0f)
                curveTo(32.0f, 444.7f, 60.7f, 416.0f, 96.0f, 416.0f)
                lineTo(144.0f, 416.0f)
                lineTo(144.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                close()
            }
        }
        .build()
        return `_shoe-prints`!!
    }

private var `_shoe-prints`: ImageVector? = null
