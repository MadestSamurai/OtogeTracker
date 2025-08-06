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

public val Fa.`Cart-flatbed`: ImageVector
    get() {
        if (`_cart-flatbed` != null) {
            return `_cart-flatbed`!!
        }
        `_cart-flatbed` = Builder(name = "Cart-flatbed", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 64.0f)
                curveTo(46.3f, 64.0f, 32.0f, 78.3f, 32.0f, 96.0f)
                curveTo(32.0f, 113.7f, 46.3f, 128.0f, 64.0f, 128.0f)
                lineTo(80.0f, 128.0f)
                curveTo(88.8f, 128.0f, 96.0f, 135.2f, 96.0f, 144.0f)
                lineTo(96.0f, 432.0f)
                curveTo(96.0f, 471.8f, 125.1f, 504.8f, 163.1f, 511.0f)
                curveTo(161.1f, 516.3f, 160.0f, 522.0f, 160.0f, 528.0f)
                curveTo(160.0f, 554.5f, 181.5f, 576.0f, 208.0f, 576.0f)
                curveTo(234.5f, 576.0f, 256.0f, 554.5f, 256.0f, 528.0f)
                curveTo(256.0f, 522.4f, 255.0f, 517.0f, 253.3f, 512.0f)
                lineTo(450.8f, 512.0f)
                curveTo(449.0f, 517.0f, 448.1f, 522.4f, 448.1f, 528.0f)
                curveTo(448.1f, 554.5f, 469.6f, 576.0f, 496.1f, 576.0f)
                curveTo(522.6f, 576.0f, 544.1f, 554.5f, 544.1f, 528.0f)
                curveTo(544.1f, 522.4f, 543.1f, 517.0f, 541.4f, 512.0f)
                lineTo(576.1f, 512.0f)
                curveTo(593.8f, 512.0f, 608.1f, 497.7f, 608.1f, 480.0f)
                curveTo(608.1f, 462.3f, 593.8f, 448.0f, 576.1f, 448.0f)
                lineTo(176.1f, 448.0f)
                curveTo(167.3f, 448.0f, 160.1f, 440.8f, 160.1f, 432.0f)
                lineTo(160.1f, 144.0f)
                curveTo(160.0f, 99.8f, 124.2f, 64.0f, 80.0f, 64.0f)
                lineTo(64.0f, 64.0f)
                close()
                moveTo(256.0f, 128.0f)
                curveTo(229.5f, 128.0f, 208.0f, 149.5f, 208.0f, 176.0f)
                lineTo(208.0f, 352.0f)
                curveTo(208.0f, 378.5f, 229.5f, 400.0f, 256.0f, 400.0f)
                lineTo(496.0f, 400.0f)
                curveTo(522.5f, 400.0f, 544.0f, 378.5f, 544.0f, 352.0f)
                lineTo(544.0f, 176.0f)
                curveTo(544.0f, 149.5f, 522.5f, 128.0f, 496.0f, 128.0f)
                lineTo(256.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_cart-flatbed`!!
    }

private var `_cart-flatbed`: ImageVector? = null
