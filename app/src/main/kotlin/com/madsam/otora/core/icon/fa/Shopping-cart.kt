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

public val Fa.`Shopping-cart`: ImageVector
    get() {
        if (`_shopping-cart` != null) {
            return `_shopping-cart`!!
        }
        `_shopping-cart` = Builder(name = "Shopping-cart", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(24.0f, 48.0f)
                curveTo(10.7f, 48.0f, 0.0f, 58.7f, 0.0f, 72.0f)
                curveTo(0.0f, 85.3f, 10.7f, 96.0f, 24.0f, 96.0f)
                lineTo(69.3f, 96.0f)
                curveTo(73.2f, 96.0f, 76.5f, 98.8f, 77.2f, 102.6f)
                lineTo(129.3f, 388.9f)
                curveTo(135.5f, 423.1f, 165.3f, 448.0f, 200.1f, 448.0f)
                lineTo(456.0f, 448.0f)
                curveTo(469.3f, 448.0f, 480.0f, 437.3f, 480.0f, 424.0f)
                curveTo(480.0f, 410.7f, 469.3f, 400.0f, 456.0f, 400.0f)
                lineTo(200.1f, 400.0f)
                curveTo(188.5f, 400.0f, 178.6f, 391.7f, 176.5f, 380.3f)
                lineTo(171.4f, 352.0f)
                lineTo(475.0f, 352.0f)
                curveTo(505.8f, 352.0f, 532.2f, 330.1f, 537.9f, 299.8f)
                lineTo(568.9f, 133.9f)
                curveTo(572.6f, 114.2f, 557.5f, 96.0f, 537.4f, 96.0f)
                lineTo(124.7f, 96.0f)
                lineTo(124.3f, 94.0f)
                curveTo(119.5f, 67.4f, 96.3f, 48.0f, 69.2f, 48.0f)
                lineTo(24.0f, 48.0f)
                close()
                moveTo(208.0f, 576.0f)
                curveTo(234.5f, 576.0f, 256.0f, 554.5f, 256.0f, 528.0f)
                curveTo(256.0f, 501.5f, 234.5f, 480.0f, 208.0f, 480.0f)
                curveTo(181.5f, 480.0f, 160.0f, 501.5f, 160.0f, 528.0f)
                curveTo(160.0f, 554.5f, 181.5f, 576.0f, 208.0f, 576.0f)
                close()
                moveTo(432.0f, 576.0f)
                curveTo(458.5f, 576.0f, 480.0f, 554.5f, 480.0f, 528.0f)
                curveTo(480.0f, 501.5f, 458.5f, 480.0f, 432.0f, 480.0f)
                curveTo(405.5f, 480.0f, 384.0f, 501.5f, 384.0f, 528.0f)
                curveTo(384.0f, 554.5f, 405.5f, 576.0f, 432.0f, 576.0f)
                close()
            }
        }
        .build()
        return `_shopping-cart`!!
    }

private var `_shopping-cart`: ImageVector? = null
