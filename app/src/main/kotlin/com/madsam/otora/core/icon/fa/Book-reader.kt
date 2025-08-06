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

public val Fa.`Book-reader`: ImageVector
    get() {
        if (`_book-reader` != null) {
            return `_book-reader`!!
        }
        `_book-reader` = Builder(name = "Book-reader", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 216.0f)
                curveTo(368.6f, 216.0f, 408.0f, 176.6f, 408.0f, 128.0f)
                curveTo(408.0f, 79.4f, 368.6f, 40.0f, 320.0f, 40.0f)
                curveTo(271.4f, 40.0f, 232.0f, 79.4f, 232.0f, 128.0f)
                curveTo(232.0f, 176.6f, 271.4f, 216.0f, 320.0f, 216.0f)
                close()
                moveTo(320.0f, 514.7f)
                lineTo(320.0f, 365.4f)
                curveTo(336.3f, 358.6f, 352.9f, 351.7f, 369.7f, 344.7f)
                curveTo(408.7f, 328.5f, 450.5f, 320.1f, 492.8f, 320.1f)
                lineTo(512.0f, 320.1f)
                lineTo(512.0f, 480.1f)
                lineTo(492.8f, 480.1f)
                curveTo(433.7f, 480.1f, 375.1f, 491.8f, 320.5f, 514.6f)
                lineTo(320.0f, 514.8f)
                close()
                moveTo(320.0f, 296.0f)
                lineTo(294.9f, 285.5f)
                curveTo(248.1f, 266.0f, 197.9f, 256.0f, 147.2f, 256.0f)
                lineTo(112.0f, 256.0f)
                curveTo(85.5f, 256.0f, 64.0f, 277.5f, 64.0f, 304.0f)
                lineTo(64.0f, 496.0f)
                curveTo(64.0f, 522.5f, 85.5f, 544.0f, 112.0f, 544.0f)
                lineTo(147.2f, 544.0f)
                curveTo(197.9f, 544.0f, 248.1f, 554.0f, 294.9f, 573.5f)
                lineTo(307.7f, 578.8f)
                curveTo(315.6f, 582.1f, 324.4f, 582.1f, 332.3f, 578.8f)
                lineTo(345.1f, 573.5f)
                curveTo(391.9f, 554.0f, 442.1f, 544.0f, 492.8f, 544.0f)
                lineTo(528.0f, 544.0f)
                curveTo(554.5f, 544.0f, 576.0f, 522.5f, 576.0f, 496.0f)
                lineTo(576.0f, 304.0f)
                curveTo(576.0f, 277.5f, 554.5f, 256.0f, 528.0f, 256.0f)
                lineTo(492.8f, 256.0f)
                curveTo(442.1f, 256.0f, 391.9f, 266.0f, 345.1f, 285.5f)
                lineTo(320.0f, 296.0f)
                close()
            }
        }
        .build()
        return `_book-reader`!!
    }

private var `_book-reader`: ImageVector? = null
