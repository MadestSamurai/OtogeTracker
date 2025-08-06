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

public val Fa.`Book-bible`: ImageVector
    get() {
        if (`_book-bible` != null) {
            return `_book-bible`!!
        }
        `_book-bible` = Builder(name = "Book-bible", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 576.0f)
                curveTo(139.0f, 576.0f, 96.0f, 533.0f, 96.0f, 480.0f)
                lineTo(96.0f, 160.0f)
                curveTo(96.0f, 107.0f, 139.0f, 64.0f, 192.0f, 64.0f)
                lineTo(496.0f, 64.0f)
                curveTo(522.5f, 64.0f, 544.0f, 85.5f, 544.0f, 112.0f)
                lineTo(544.0f, 400.0f)
                curveTo(544.0f, 420.9f, 530.6f, 438.7f, 512.0f, 445.3f)
                lineTo(512.0f, 512.0f)
                curveTo(529.7f, 512.0f, 544.0f, 526.3f, 544.0f, 544.0f)
                curveTo(544.0f, 561.7f, 529.7f, 576.0f, 512.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                close()
                moveTo(192.0f, 448.0f)
                curveTo(174.3f, 448.0f, 160.0f, 462.3f, 160.0f, 480.0f)
                curveTo(160.0f, 497.7f, 174.3f, 512.0f, 192.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                lineTo(448.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                close()
                moveTo(288.0f, 144.0f)
                lineTo(288.0f, 192.0f)
                lineTo(240.0f, 192.0f)
                curveTo(231.2f, 192.0f, 224.0f, 199.2f, 224.0f, 208.0f)
                lineTo(224.0f, 240.0f)
                curveTo(224.0f, 248.8f, 231.2f, 256.0f, 240.0f, 256.0f)
                lineTo(288.0f, 256.0f)
                lineTo(288.0f, 368.0f)
                curveTo(288.0f, 376.8f, 295.2f, 384.0f, 304.0f, 384.0f)
                lineTo(336.0f, 384.0f)
                curveTo(344.8f, 384.0f, 352.0f, 376.8f, 352.0f, 368.0f)
                lineTo(352.0f, 256.0f)
                lineTo(400.0f, 256.0f)
                curveTo(408.8f, 256.0f, 416.0f, 248.8f, 416.0f, 240.0f)
                lineTo(416.0f, 208.0f)
                curveTo(416.0f, 199.2f, 408.8f, 192.0f, 400.0f, 192.0f)
                lineTo(352.0f, 192.0f)
                lineTo(352.0f, 144.0f)
                curveTo(352.0f, 135.2f, 344.8f, 128.0f, 336.0f, 128.0f)
                lineTo(304.0f, 128.0f)
                curveTo(295.2f, 128.0f, 288.0f, 135.2f, 288.0f, 144.0f)
                close()
            }
        }
        .build()
        return `_book-bible`!!
    }

private var `_book-bible`: ImageVector? = null
