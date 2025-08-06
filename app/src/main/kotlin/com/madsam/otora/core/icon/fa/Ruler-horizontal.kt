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

public val Fa.`Ruler-horizontal`: ImageVector
    get() {
        if (`_ruler-horizontal` != null) {
            return `_ruler-horizontal`!!
        }
        `_ruler-horizontal` = Builder(name = "Ruler-horizontal", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(80.0f, 448.0f)
                curveTo(53.5f, 448.0f, 32.0f, 426.5f, 32.0f, 400.0f)
                lineTo(32.0f, 240.0f)
                curveTo(32.0f, 213.5f, 53.5f, 192.0f, 80.0f, 192.0f)
                lineTo(104.0f, 192.0f)
                lineTo(104.0f, 296.0f)
                curveTo(104.0f, 309.3f, 114.7f, 320.0f, 128.0f, 320.0f)
                curveTo(141.3f, 320.0f, 152.0f, 309.3f, 152.0f, 296.0f)
                lineTo(152.0f, 192.0f)
                lineTo(200.0f, 192.0f)
                lineTo(200.0f, 264.0f)
                curveTo(200.0f, 277.3f, 210.7f, 288.0f, 224.0f, 288.0f)
                curveTo(237.3f, 288.0f, 248.0f, 277.3f, 248.0f, 264.0f)
                lineTo(248.0f, 192.0f)
                lineTo(296.0f, 192.0f)
                lineTo(296.0f, 296.0f)
                curveTo(296.0f, 309.3f, 306.7f, 320.0f, 320.0f, 320.0f)
                curveTo(333.3f, 320.0f, 344.0f, 309.3f, 344.0f, 296.0f)
                lineTo(344.0f, 192.0f)
                lineTo(392.0f, 192.0f)
                lineTo(392.0f, 264.0f)
                curveTo(392.0f, 277.3f, 402.7f, 288.0f, 416.0f, 288.0f)
                curveTo(429.3f, 288.0f, 440.0f, 277.3f, 440.0f, 264.0f)
                lineTo(440.0f, 192.0f)
                lineTo(488.0f, 192.0f)
                lineTo(488.0f, 296.0f)
                curveTo(488.0f, 309.3f, 498.7f, 320.0f, 512.0f, 320.0f)
                curveTo(525.3f, 320.0f, 536.0f, 309.3f, 536.0f, 296.0f)
                lineTo(536.0f, 192.0f)
                lineTo(560.0f, 192.0f)
                curveTo(586.5f, 192.0f, 608.0f, 213.5f, 608.0f, 240.0f)
                lineTo(608.0f, 400.0f)
                curveTo(608.0f, 426.5f, 586.5f, 448.0f, 560.0f, 448.0f)
                lineTo(80.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_ruler-horizontal`!!
    }

private var `_ruler-horizontal`: ImageVector? = null
