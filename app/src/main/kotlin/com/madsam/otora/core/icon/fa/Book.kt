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

public val Fa.Book: ImageVector
    get() {
        if (_book != null) {
            return _book!!
        }
        _book = Builder(name = "Book", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 576.0f)
                lineTo(192.0f, 576.0f)
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
                lineTo(480.0f, 576.0f)
                close()
                moveTo(192.0f, 448.0f)
                curveTo(174.3f, 448.0f, 160.0f, 462.3f, 160.0f, 480.0f)
                curveTo(160.0f, 497.7f, 174.3f, 512.0f, 192.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                lineTo(448.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                close()
                moveTo(224.0f, 216.0f)
                curveTo(224.0f, 229.3f, 234.7f, 240.0f, 248.0f, 240.0f)
                lineTo(424.0f, 240.0f)
                curveTo(437.3f, 240.0f, 448.0f, 229.3f, 448.0f, 216.0f)
                curveTo(448.0f, 202.7f, 437.3f, 192.0f, 424.0f, 192.0f)
                lineTo(248.0f, 192.0f)
                curveTo(234.7f, 192.0f, 224.0f, 202.7f, 224.0f, 216.0f)
                close()
                moveTo(248.0f, 288.0f)
                curveTo(234.7f, 288.0f, 224.0f, 298.7f, 224.0f, 312.0f)
                curveTo(224.0f, 325.3f, 234.7f, 336.0f, 248.0f, 336.0f)
                lineTo(424.0f, 336.0f)
                curveTo(437.3f, 336.0f, 448.0f, 325.3f, 448.0f, 312.0f)
                curveTo(448.0f, 298.7f, 437.3f, 288.0f, 424.0f, 288.0f)
                lineTo(248.0f, 288.0f)
                close()
            }
        }
        .build()
        return _book!!
    }

private var _book: ImageVector? = null
