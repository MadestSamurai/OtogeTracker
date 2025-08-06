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

public val Fa.`Guarani-sign`: ImageVector
    get() {
        if (`_guarani-sign` != null) {
            return `_guarani-sign`!!
        }
        `_guarani-sign` = Builder(name = "Guarani-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(306.7f, 64.0f, 296.0f, 74.7f, 296.0f, 88.0f)
                lineTo(296.0f, 129.5f)
                curveTo(201.3f, 141.3f, 128.0f, 222.1f, 128.0f, 320.0f)
                curveTo(128.0f, 417.9f, 201.3f, 498.7f, 296.0f, 510.5f)
                lineTo(296.0f, 552.0f)
                curveTo(296.0f, 565.3f, 306.7f, 576.0f, 320.0f, 576.0f)
                curveTo(333.3f, 576.0f, 344.0f, 565.3f, 344.0f, 552.0f)
                lineTo(344.0f, 510.5f)
                curveTo(438.7f, 498.7f, 512.0f, 417.9f, 512.0f, 320.0f)
                curveTo(512.0f, 302.3f, 497.7f, 288.0f, 480.0f, 288.0f)
                lineTo(344.0f, 288.0f)
                lineTo(344.0f, 194.2f)
                curveTo(369.3f, 199.0f, 391.9f, 211.2f, 409.6f, 228.5f)
                curveTo(422.2f, 240.9f, 442.5f, 240.7f, 454.9f, 228.1f)
                curveTo(467.3f, 215.5f, 467.1f, 195.2f, 454.4f, 182.8f)
                curveTo(425.2f, 154.2f, 386.8f, 134.8f, 344.0f, 129.5f)
                lineTo(344.0f, 88.0f)
                curveTo(344.0f, 74.7f, 333.3f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(296.0f, 194.2f)
                lineTo(296.0f, 445.7f)
                curveTo(236.8f, 434.5f, 192.0f, 382.5f, 192.0f, 320.0f)
                curveTo(192.0f, 257.5f, 236.8f, 205.5f, 296.0f, 194.2f)
                close()
                moveTo(344.0f, 445.7f)
                lineTo(344.0f, 351.9f)
                lineTo(444.0f, 351.9f)
                curveTo(431.7f, 399.5f, 392.8f, 436.4f, 344.0f, 445.7f)
                close()
            }
        }
        .build()
        return `_guarani-sign`!!
    }

private var `_guarani-sign`: ImageVector? = null
