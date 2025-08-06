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

public val Fa.`Square-rss`: ImageVector
    get() {
        if (`_square-rss` != null) {
            return `_square-rss`!!
        }
        `_square-rss` = Builder(name = "Square-rss", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(192.0f, 200.0f)
                curveTo(192.0f, 186.7f, 202.7f, 176.0f, 216.0f, 176.0f)
                curveTo(353.0f, 176.0f, 464.0f, 287.0f, 464.0f, 424.0f)
                curveTo(464.0f, 437.3f, 453.3f, 448.0f, 440.0f, 448.0f)
                curveTo(426.7f, 448.0f, 416.0f, 437.3f, 416.0f, 424.0f)
                curveTo(416.0f, 313.5f, 326.5f, 224.0f, 216.0f, 224.0f)
                curveTo(202.7f, 224.0f, 192.0f, 213.3f, 192.0f, 200.0f)
                close()
                moveTo(192.0f, 296.0f)
                curveTo(192.0f, 282.7f, 202.7f, 272.0f, 216.0f, 272.0f)
                curveTo(299.9f, 272.0f, 368.0f, 340.1f, 368.0f, 424.0f)
                curveTo(368.0f, 437.3f, 357.3f, 448.0f, 344.0f, 448.0f)
                curveTo(330.7f, 448.0f, 320.0f, 437.3f, 320.0f, 424.0f)
                curveTo(320.0f, 366.6f, 273.4f, 320.0f, 216.0f, 320.0f)
                curveTo(202.7f, 320.0f, 192.0f, 309.3f, 192.0f, 296.0f)
                close()
                moveTo(192.0f, 416.0f)
                curveTo(192.0f, 398.3f, 206.3f, 384.0f, 224.0f, 384.0f)
                curveTo(241.7f, 384.0f, 256.0f, 398.3f, 256.0f, 416.0f)
                curveTo(256.0f, 433.7f, 241.7f, 448.0f, 224.0f, 448.0f)
                curveTo(206.3f, 448.0f, 192.0f, 433.7f, 192.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_square-rss`!!
    }

private var `_square-rss`: ImageVector? = null
