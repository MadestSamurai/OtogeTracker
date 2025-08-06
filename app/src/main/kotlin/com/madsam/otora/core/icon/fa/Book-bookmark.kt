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

public val Fa.`Book-bookmark`: ImageVector
    get() {
        if (`_book-bookmark` != null) {
            return `_book-bookmark`!!
        }
        `_book-bookmark` = Builder(name = "Book-bookmark", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(529.7f, 576.0f, 544.0f, 561.7f, 544.0f, 544.0f)
                curveTo(544.0f, 526.3f, 529.7f, 512.0f, 512.0f, 512.0f)
                lineTo(512.0f, 445.3f)
                curveTo(530.6f, 438.7f, 544.0f, 420.9f, 544.0f, 400.0f)
                lineTo(544.0f, 112.0f)
                curveTo(544.0f, 85.5f, 522.5f, 64.0f, 496.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                lineTo(448.0f, 233.4f)
                curveTo(448.0f, 245.9f, 437.9f, 256.0f, 425.4f, 256.0f)
                curveTo(419.4f, 256.0f, 413.6f, 253.6f, 409.4f, 249.4f)
                lineTo(368.0f, 208.0f)
                lineTo(326.6f, 249.4f)
                curveTo(322.4f, 253.6f, 316.6f, 256.0f, 310.6f, 256.0f)
                curveTo(298.1f, 256.0f, 288.0f, 245.9f, 288.0f, 233.4f)
                lineTo(288.0f, 64.0f)
                lineTo(192.0f, 64.0f)
                curveTo(139.0f, 64.0f, 96.0f, 107.0f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 533.0f, 139.0f, 576.0f, 192.0f, 576.0f)
                close()
                moveTo(160.0f, 480.0f)
                curveTo(160.0f, 462.3f, 174.3f, 448.0f, 192.0f, 448.0f)
                lineTo(448.0f, 448.0f)
                lineTo(448.0f, 512.0f)
                lineTo(192.0f, 512.0f)
                curveTo(174.3f, 512.0f, 160.0f, 497.7f, 160.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_book-bookmark`!!
    }

private var `_book-bookmark`: ImageVector? = null
