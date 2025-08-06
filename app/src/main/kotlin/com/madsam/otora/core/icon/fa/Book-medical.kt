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

public val Fa.`Book-medical`: ImageVector
    get() {
        if (`_book-medical` != null) {
            return `_book-medical`!!
        }
        `_book-medical` = Builder(name = "Book-medical", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(288.0f, 184.0f)
                curveTo(288.0f, 175.2f, 295.2f, 168.0f, 304.0f, 168.0f)
                lineTo(336.0f, 168.0f)
                curveTo(344.8f, 168.0f, 352.0f, 175.2f, 352.0f, 184.0f)
                lineTo(352.0f, 224.0f)
                lineTo(392.0f, 224.0f)
                curveTo(400.8f, 224.0f, 408.0f, 231.2f, 408.0f, 240.0f)
                lineTo(408.0f, 272.0f)
                curveTo(408.0f, 280.8f, 400.8f, 288.0f, 392.0f, 288.0f)
                lineTo(352.0f, 288.0f)
                lineTo(352.0f, 328.0f)
                curveTo(352.0f, 336.8f, 344.8f, 344.0f, 336.0f, 344.0f)
                lineTo(304.0f, 344.0f)
                curveTo(295.2f, 344.0f, 288.0f, 336.8f, 288.0f, 328.0f)
                lineTo(288.0f, 288.0f)
                lineTo(248.0f, 288.0f)
                curveTo(239.2f, 288.0f, 232.0f, 280.8f, 232.0f, 272.0f)
                lineTo(232.0f, 240.0f)
                curveTo(232.0f, 231.2f, 239.2f, 224.0f, 248.0f, 224.0f)
                lineTo(288.0f, 224.0f)
                lineTo(288.0f, 184.0f)
                close()
            }
        }
        .build()
        return `_book-medical`!!
    }

private var `_book-medical`: ImageVector? = null
