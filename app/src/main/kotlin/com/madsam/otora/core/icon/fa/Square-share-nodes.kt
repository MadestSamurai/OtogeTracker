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

public val Fa.`Square-share-nodes`: ImageVector
    get() {
        if (`_square-share-nodes` != null) {
            return `_square-share-nodes`!!
        }
        `_square-share-nodes` = Builder(name = "Square-share-nodes", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(464.0f, 224.0f)
                curveTo(464.0f, 259.3f, 435.3f, 288.0f, 400.0f, 288.0f)
                curveTo(384.6f, 288.0f, 370.5f, 282.6f, 359.4f, 273.5f)
                lineTo(274.1f, 320.0f)
                lineTo(359.4f, 366.5f)
                curveTo(370.4f, 357.4f, 384.6f, 352.0f, 400.0f, 352.0f)
                curveTo(435.3f, 352.0f, 464.0f, 380.7f, 464.0f, 416.0f)
                curveTo(464.0f, 451.3f, 435.3f, 480.0f, 400.0f, 480.0f)
                curveTo(364.7f, 480.0f, 336.0f, 451.3f, 336.0f, 416.0f)
                curveTo(336.0f, 413.5f, 336.1f, 411.1f, 336.4f, 408.7f)
                lineTo(254.5f, 364.0f)
                curveTo(242.8f, 376.3f, 226.3f, 384.0f, 208.0f, 384.0f)
                curveTo(172.7f, 384.0f, 144.0f, 355.3f, 144.0f, 320.0f)
                curveTo(144.0f, 284.7f, 172.7f, 256.0f, 208.0f, 256.0f)
                curveTo(226.3f, 256.0f, 242.8f, 263.7f, 254.5f, 276.0f)
                lineTo(336.4f, 231.3f)
                curveTo(336.1f, 228.9f, 336.0f, 226.4f, 336.0f, 224.0f)
                curveTo(336.0f, 188.7f, 364.7f, 160.0f, 400.0f, 160.0f)
                curveTo(435.3f, 160.0f, 464.0f, 188.7f, 464.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_square-share-nodes`!!
    }

private var `_square-share-nodes`: ImageVector? = null
