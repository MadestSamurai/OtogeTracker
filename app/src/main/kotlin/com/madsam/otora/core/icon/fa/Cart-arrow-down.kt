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

public val Fa.`Cart-arrow-down`: ImageVector
    get() {
        if (`_cart-arrow-down` != null) {
            return `_cart-arrow-down`!!
        }
        `_cart-arrow-down` = Builder(name = "Cart-arrow-down", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(0.0f, 72.0f)
                curveTo(0.0f, 58.7f, 10.7f, 48.0f, 24.0f, 48.0f)
                lineTo(69.3f, 48.0f)
                curveTo(96.4f, 48.0f, 119.6f, 67.4f, 124.4f, 94.0f)
                lineTo(124.8f, 96.0f)
                lineTo(312.0f, 96.0f)
                lineTo(312.0f, 198.1f)
                lineTo(281.0f, 167.1f)
                curveTo(271.6f, 157.7f, 256.4f, 157.7f, 247.1f, 167.1f)
                curveTo(237.8f, 176.5f, 237.7f, 191.7f, 247.1f, 201.0f)
                lineTo(319.1f, 273.0f)
                curveTo(328.5f, 282.4f, 343.7f, 282.4f, 353.0f, 273.0f)
                lineTo(425.0f, 201.0f)
                curveTo(434.4f, 191.6f, 434.4f, 176.4f, 425.0f, 167.1f)
                curveTo(415.6f, 157.8f, 400.4f, 157.7f, 391.1f, 167.1f)
                lineTo(360.1f, 198.1f)
                lineTo(360.1f, 96.0f)
                lineTo(537.5f, 96.0f)
                curveTo(557.5f, 96.0f, 572.6f, 114.2f, 568.9f, 133.9f)
                lineTo(537.8f, 299.8f)
                curveTo(532.1f, 330.1f, 505.7f, 352.0f, 474.9f, 352.0f)
                lineTo(171.3f, 352.0f)
                lineTo(176.4f, 380.3f)
                curveTo(178.5f, 391.7f, 188.4f, 400.0f, 200.0f, 400.0f)
                lineTo(456.0f, 400.0f)
                curveTo(469.3f, 400.0f, 480.0f, 410.7f, 480.0f, 424.0f)
                curveTo(480.0f, 437.3f, 469.3f, 448.0f, 456.0f, 448.0f)
                lineTo(200.1f, 448.0f)
                curveTo(165.3f, 448.0f, 135.5f, 423.1f, 129.3f, 388.9f)
                lineTo(77.2f, 102.6f)
                curveTo(76.5f, 98.8f, 73.2f, 96.0f, 69.3f, 96.0f)
                lineTo(24.0f, 96.0f)
                curveTo(10.7f, 96.0f, 0.0f, 85.3f, 0.0f, 72.0f)
                close()
                moveTo(160.0f, 528.0f)
                curveTo(160.0f, 501.5f, 181.5f, 480.0f, 208.0f, 480.0f)
                curveTo(234.5f, 480.0f, 256.0f, 501.5f, 256.0f, 528.0f)
                curveTo(256.0f, 554.5f, 234.5f, 576.0f, 208.0f, 576.0f)
                curveTo(181.5f, 576.0f, 160.0f, 554.5f, 160.0f, 528.0f)
                close()
                moveTo(384.0f, 528.0f)
                curveTo(384.0f, 501.5f, 405.5f, 480.0f, 432.0f, 480.0f)
                curveTo(458.5f, 480.0f, 480.0f, 501.5f, 480.0f, 528.0f)
                curveTo(480.0f, 554.5f, 458.5f, 576.0f, 432.0f, 576.0f)
                curveTo(405.5f, 576.0f, 384.0f, 554.5f, 384.0f, 528.0f)
                close()
            }
        }
        .build()
        return `_cart-arrow-down`!!
    }

private var `_cart-arrow-down`: ImageVector? = null
