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

public val Fa.Shop: ImageVector
    get() {
        if (_shop != null) {
            return _shop!!
        }
        _shop = Builder(name = "Shop", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(53.5f, 245.1f)
                lineTo(110.3f, 131.4f)
                curveTo(121.2f, 109.7f, 143.3f, 96.0f, 167.6f, 96.0f)
                lineTo(472.5f, 96.0f)
                curveTo(496.7f, 96.0f, 518.9f, 109.7f, 529.7f, 131.4f)
                lineTo(586.5f, 245.1f)
                curveTo(590.1f, 252.3f, 592.0f, 260.2f, 592.0f, 268.3f)
                curveTo(592.0f, 295.6f, 570.8f, 318.0f, 544.0f, 319.9f)
                lineTo(544.0f, 512.0f)
                curveTo(544.0f, 529.7f, 529.7f, 544.0f, 512.0f, 544.0f)
                curveTo(494.3f, 544.0f, 480.0f, 529.7f, 480.0f, 512.0f)
                lineTo(480.0f, 320.0f)
                lineTo(384.0f, 320.0f)
                lineTo(384.0f, 496.0f)
                curveTo(384.0f, 522.5f, 362.5f, 544.0f, 336.0f, 544.0f)
                lineTo(144.0f, 544.0f)
                curveTo(117.5f, 544.0f, 96.0f, 522.5f, 96.0f, 496.0f)
                lineTo(96.0f, 319.9f)
                curveTo(69.2f, 318.0f, 48.0f, 295.6f, 48.0f, 268.3f)
                curveTo(48.0f, 260.3f, 49.9f, 252.3f, 53.5f, 245.1f)
                close()
                moveTo(160.0f, 320.0f)
                lineTo(160.0f, 432.0f)
                curveTo(160.0f, 440.8f, 167.2f, 448.0f, 176.0f, 448.0f)
                lineTo(304.0f, 448.0f)
                curveTo(312.8f, 448.0f, 320.0f, 440.8f, 320.0f, 432.0f)
                lineTo(320.0f, 320.0f)
                lineTo(160.0f, 320.0f)
                close()
            }
        }
        .build()
        return _shop!!
    }

private var _shop: ImageVector? = null
