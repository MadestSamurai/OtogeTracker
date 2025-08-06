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

public val Fa.Barcode: ImageVector
    get() {
        if (_barcode != null) {
            return _barcode!!
        }
        _barcode = Builder(name = "Barcode", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 96.0f)
                curveTo(110.3f, 96.0f, 96.0f, 110.3f, 96.0f, 128.0f)
                lineTo(96.0f, 512.0f)
                curveTo(96.0f, 529.7f, 110.3f, 544.0f, 128.0f, 544.0f)
                curveTo(145.7f, 544.0f, 160.0f, 529.7f, 160.0f, 512.0f)
                lineTo(160.0f, 128.0f)
                curveTo(160.0f, 110.3f, 145.7f, 96.0f, 128.0f, 96.0f)
                close()
                moveTo(216.0f, 96.0f)
                curveTo(202.7f, 96.0f, 192.0f, 106.7f, 192.0f, 120.0f)
                lineTo(192.0f, 520.0f)
                curveTo(192.0f, 533.3f, 202.7f, 544.0f, 216.0f, 544.0f)
                curveTo(229.3f, 544.0f, 240.0f, 533.3f, 240.0f, 520.0f)
                lineTo(240.0f, 120.0f)
                curveTo(240.0f, 106.7f, 229.3f, 96.0f, 216.0f, 96.0f)
                close()
                moveTo(288.0f, 128.0f)
                lineTo(288.0f, 512.0f)
                curveTo(288.0f, 529.7f, 302.3f, 544.0f, 320.0f, 544.0f)
                curveTo(337.7f, 544.0f, 352.0f, 529.7f, 352.0f, 512.0f)
                lineTo(352.0f, 128.0f)
                curveTo(352.0f, 110.3f, 337.7f, 96.0f, 320.0f, 96.0f)
                curveTo(302.3f, 96.0f, 288.0f, 110.3f, 288.0f, 128.0f)
                close()
                moveTo(496.0f, 120.0f)
                lineTo(496.0f, 520.0f)
                curveTo(496.0f, 533.3f, 506.7f, 544.0f, 520.0f, 544.0f)
                curveTo(533.3f, 544.0f, 544.0f, 533.3f, 544.0f, 520.0f)
                lineTo(544.0f, 120.0f)
                curveTo(544.0f, 106.7f, 533.3f, 96.0f, 520.0f, 96.0f)
                curveTo(506.7f, 96.0f, 496.0f, 106.7f, 496.0f, 120.0f)
                close()
                moveTo(400.0f, 120.0f)
                lineTo(400.0f, 520.0f)
                curveTo(400.0f, 533.3f, 410.7f, 544.0f, 424.0f, 544.0f)
                curveTo(437.3f, 544.0f, 448.0f, 533.3f, 448.0f, 520.0f)
                lineTo(448.0f, 120.0f)
                curveTo(448.0f, 106.7f, 437.3f, 96.0f, 424.0f, 96.0f)
                curveTo(410.7f, 96.0f, 400.0f, 106.7f, 400.0f, 120.0f)
                close()
            }
        }
        .build()
        return _barcode!!
    }

private var _barcode: ImageVector? = null
