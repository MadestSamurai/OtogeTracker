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

public val Fa.`Toilet-paper-slash`: ImageVector
    get() {
        if (`_toilet-paper-slash` != null) {
            return `_toilet-paper-slash`!!
        }
        `_toilet-paper-slash` = Builder(name = "Toilet-paper-slash", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(506.4f, 472.7f)
                curveTo(546.6f, 449.7f, 575.9f, 375.8f, 575.9f, 288.1f)
                curveTo(575.9f, 182.1f, 532.9f, 96.1f, 479.9f, 96.1f)
                curveTo(426.9f, 96.1f, 383.9f, 182.1f, 383.9f, 288.1f)
                curveTo(383.9f, 312.2f, 386.1f, 335.3f, 390.2f, 356.5f)
                lineTo(336.0f, 302.2f)
                lineTo(336.0f, 288.0f)
                curveTo(336.0f, 229.1f, 347.8f, 173.5f, 369.2f, 130.8f)
                curveTo(375.1f, 119.1f, 382.3f, 107.1f, 391.1f, 96.0f)
                lineTo(160.0f, 96.0f)
                curveTo(151.7f, 96.0f, 143.6f, 98.1f, 135.9f, 102.1f)
                lineTo(72.9f, 39.1f)
                close()
                moveTo(64.0f, 288.0f)
                lineTo(64.0f, 552.0f)
                curveTo(64.0f, 582.9f, 89.1f, 608.0f, 120.0f, 608.0f)
                lineTo(280.0f, 608.0f)
                curveTo(310.9f, 608.0f, 336.0f, 582.9f, 336.0f, 552.0f)
                lineTo(336.0f, 437.8f)
                lineTo(80.0f, 181.8f)
                curveTo(69.9f, 212.2f, 64.0f, 248.7f, 64.0f, 288.0f)
                close()
                moveTo(480.0f, 352.0f)
                curveTo(462.3f, 352.0f, 448.0f, 323.3f, 448.0f, 288.0f)
                curveTo(448.0f, 252.7f, 462.3f, 224.0f, 480.0f, 224.0f)
                curveTo(497.7f, 224.0f, 512.0f, 252.7f, 512.0f, 288.0f)
                curveTo(512.0f, 323.3f, 497.7f, 352.0f, 480.0f, 352.0f)
                close()
            }
        }
        .build()
        return `_toilet-paper-slash`!!
    }

private var `_toilet-paper-slash`: ImageVector? = null
