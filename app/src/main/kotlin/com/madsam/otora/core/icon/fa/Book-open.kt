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

public val Fa.`Book-open`: ImageVector
    get() {
        if (`_book-open` != null) {
            return `_book-open`!!
        }
        `_book-open` = Builder(name = "Book-open", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 205.3f)
                lineTo(320.0f, 514.6f)
                lineTo(320.5f, 514.4f)
                curveTo(375.1f, 491.7f, 433.7f, 480.0f, 492.8f, 480.0f)
                lineTo(512.0f, 480.0f)
                lineTo(512.0f, 160.0f)
                lineTo(492.8f, 160.0f)
                curveTo(450.6f, 160.0f, 408.7f, 168.4f, 369.7f, 184.6f)
                curveTo(352.9f, 191.6f, 336.3f, 198.5f, 320.0f, 205.3f)
                close()
                moveTo(294.9f, 125.5f)
                lineTo(320.0f, 136.0f)
                lineTo(345.1f, 125.5f)
                curveTo(391.9f, 106.0f, 442.1f, 96.0f, 492.8f, 96.0f)
                lineTo(528.0f, 96.0f)
                curveTo(554.5f, 96.0f, 576.0f, 117.5f, 576.0f, 144.0f)
                lineTo(576.0f, 496.0f)
                curveTo(576.0f, 522.5f, 554.5f, 544.0f, 528.0f, 544.0f)
                lineTo(492.8f, 544.0f)
                curveTo(442.1f, 544.0f, 391.9f, 554.0f, 345.1f, 573.5f)
                lineTo(332.3f, 578.8f)
                curveTo(324.4f, 582.1f, 315.6f, 582.1f, 307.7f, 578.8f)
                lineTo(294.9f, 573.5f)
                curveTo(248.1f, 554.0f, 197.9f, 544.0f, 147.2f, 544.0f)
                lineTo(112.0f, 544.0f)
                curveTo(85.5f, 544.0f, 64.0f, 522.5f, 64.0f, 496.0f)
                lineTo(64.0f, 144.0f)
                curveTo(64.0f, 117.5f, 85.5f, 96.0f, 112.0f, 96.0f)
                lineTo(147.2f, 96.0f)
                curveTo(197.9f, 96.0f, 248.1f, 106.0f, 294.9f, 125.5f)
                close()
            }
        }
        .build()
        return `_book-open`!!
    }

private var `_book-open`: ImageVector? = null
