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

public val Fa.`Basket-shopping`: ImageVector
    get() {
        if (`_basket-shopping` != null) {
            return `_basket-shopping`!!
        }
        `_basket-shopping` = Builder(name = "Basket-shopping", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(326.6f, 64.0f, 332.9f, 66.7f, 337.4f, 71.5f)
                lineTo(481.4f, 223.5f)
                lineTo(481.9f, 224.0f)
                lineTo(560.0f, 224.0f)
                curveTo(577.7f, 224.0f, 592.0f, 238.3f, 592.0f, 256.0f)
                curveTo(592.0f, 270.5f, 582.4f, 282.7f, 569.2f, 286.7f)
                lineTo(523.1f, 493.9f)
                curveTo(516.6f, 523.2f, 490.6f, 544.0f, 460.6f, 544.0f)
                lineTo(179.3f, 544.0f)
                curveTo(149.3f, 544.0f, 123.3f, 523.2f, 116.8f, 493.9f)
                lineTo(70.8f, 286.7f)
                curveTo(57.6f, 282.8f, 48.0f, 270.5f, 48.0f, 256.0f)
                curveTo(48.0f, 238.3f, 62.3f, 224.0f, 80.0f, 224.0f)
                lineTo(158.1f, 224.0f)
                lineTo(158.6f, 223.5f)
                lineTo(302.6f, 71.5f)
                curveTo(307.1f, 66.7f, 313.4f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(320.0f, 122.9f)
                lineTo(224.2f, 224.0f)
                lineTo(415.8f, 224.0f)
                lineTo(320.0f, 122.9f)
                close()
                moveTo(240.0f, 328.0f)
                curveTo(240.0f, 314.7f, 229.3f, 304.0f, 216.0f, 304.0f)
                curveTo(202.7f, 304.0f, 192.0f, 314.7f, 192.0f, 328.0f)
                lineTo(192.0f, 440.0f)
                curveTo(192.0f, 453.3f, 202.7f, 464.0f, 216.0f, 464.0f)
                curveTo(229.3f, 464.0f, 240.0f, 453.3f, 240.0f, 440.0f)
                lineTo(240.0f, 328.0f)
                close()
                moveTo(320.0f, 304.0f)
                curveTo(306.7f, 304.0f, 296.0f, 314.7f, 296.0f, 328.0f)
                lineTo(296.0f, 440.0f)
                curveTo(296.0f, 453.3f, 306.7f, 464.0f, 320.0f, 464.0f)
                curveTo(333.3f, 464.0f, 344.0f, 453.3f, 344.0f, 440.0f)
                lineTo(344.0f, 328.0f)
                curveTo(344.0f, 314.7f, 333.3f, 304.0f, 320.0f, 304.0f)
                close()
                moveTo(448.0f, 328.0f)
                curveTo(448.0f, 314.7f, 437.3f, 304.0f, 424.0f, 304.0f)
                curveTo(410.7f, 304.0f, 400.0f, 314.7f, 400.0f, 328.0f)
                lineTo(400.0f, 440.0f)
                curveTo(400.0f, 453.3f, 410.7f, 464.0f, 424.0f, 464.0f)
                curveTo(437.3f, 464.0f, 448.0f, 453.3f, 448.0f, 440.0f)
                lineTo(448.0f, 328.0f)
                close()
            }
        }
        .build()
        return `_basket-shopping`!!
    }

private var `_basket-shopping`: ImageVector? = null
