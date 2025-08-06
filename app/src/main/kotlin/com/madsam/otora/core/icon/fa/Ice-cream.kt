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

public val Fa.`Ice-cream`: ImageVector
    get() {
        if (`_ice-cream` != null) {
            return `_ice-cream`!!
        }
        `_ice-cream` = Builder(name = "Ice-cream", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(463.1f, 224.0f)
                curveTo(463.7f, 218.7f, 464.0f, 213.4f, 464.0f, 208.0f)
                curveTo(464.0f, 128.5f, 399.5f, 64.0f, 320.0f, 64.0f)
                curveTo(240.5f, 64.0f, 176.0f, 128.5f, 176.0f, 208.0f)
                curveTo(176.0f, 213.4f, 176.3f, 218.7f, 176.9f, 224.0f)
                lineTo(176.0f, 224.0f)
                curveTo(149.5f, 224.0f, 128.0f, 245.5f, 128.0f, 272.0f)
                curveTo(128.0f, 298.5f, 149.5f, 320.0f, 176.0f, 320.0f)
                lineTo(464.0f, 320.0f)
                curveTo(490.5f, 320.0f, 512.0f, 298.5f, 512.0f, 272.0f)
                curveTo(512.0f, 245.5f, 490.5f, 224.0f, 464.0f, 224.0f)
                lineTo(463.1f, 224.0f)
                close()
                moveTo(192.0f, 368.0f)
                lineTo(297.2f, 593.5f)
                curveTo(301.3f, 602.3f, 310.2f, 608.0f, 320.0f, 608.0f)
                curveTo(329.8f, 608.0f, 338.6f, 602.3f, 342.8f, 593.5f)
                lineTo(448.0f, 368.0f)
                lineTo(192.0f, 368.0f)
                close()
            }
        }
        .build()
        return `_ice-cream`!!
    }

private var `_ice-cream`: ImageVector? = null
