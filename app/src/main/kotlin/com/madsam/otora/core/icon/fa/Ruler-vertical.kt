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

public val Fa.`Ruler-vertical`: ImageVector
    get() {
        if (`_ruler-vertical` != null) {
            return `_ruler-vertical`!!
        }
        `_ruler-vertical` = Builder(name = "Ruler-vertical", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 80.0f)
                curveTo(192.0f, 53.5f, 213.5f, 32.0f, 240.0f, 32.0f)
                lineTo(400.0f, 32.0f)
                curveTo(426.5f, 32.0f, 448.0f, 53.5f, 448.0f, 80.0f)
                lineTo(448.0f, 104.0f)
                lineTo(344.0f, 104.0f)
                curveTo(330.7f, 104.0f, 320.0f, 114.7f, 320.0f, 128.0f)
                curveTo(320.0f, 141.3f, 330.7f, 152.0f, 344.0f, 152.0f)
                lineTo(448.0f, 152.0f)
                lineTo(448.0f, 200.0f)
                lineTo(376.0f, 200.0f)
                curveTo(362.7f, 200.0f, 352.0f, 210.7f, 352.0f, 224.0f)
                curveTo(352.0f, 237.3f, 362.7f, 248.0f, 376.0f, 248.0f)
                lineTo(448.0f, 248.0f)
                lineTo(448.0f, 296.0f)
                lineTo(344.0f, 296.0f)
                curveTo(330.7f, 296.0f, 320.0f, 306.7f, 320.0f, 320.0f)
                curveTo(320.0f, 333.3f, 330.7f, 344.0f, 344.0f, 344.0f)
                lineTo(448.0f, 344.0f)
                lineTo(448.0f, 392.0f)
                lineTo(376.0f, 392.0f)
                curveTo(362.7f, 392.0f, 352.0f, 402.7f, 352.0f, 416.0f)
                curveTo(352.0f, 429.3f, 362.7f, 440.0f, 376.0f, 440.0f)
                lineTo(448.0f, 440.0f)
                lineTo(448.0f, 488.0f)
                lineTo(344.0f, 488.0f)
                curveTo(330.7f, 488.0f, 320.0f, 498.7f, 320.0f, 512.0f)
                curveTo(320.0f, 525.3f, 330.7f, 536.0f, 344.0f, 536.0f)
                lineTo(448.0f, 536.0f)
                lineTo(448.0f, 560.0f)
                curveTo(448.0f, 586.5f, 426.5f, 608.0f, 400.0f, 608.0f)
                lineTo(240.0f, 608.0f)
                curveTo(213.5f, 608.0f, 192.0f, 586.5f, 192.0f, 560.0f)
                lineTo(192.0f, 80.0f)
                close()
            }
        }
        .build()
        return `_ruler-vertical`!!
    }

private var `_ruler-vertical`: ImageVector? = null
