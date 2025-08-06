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

public val Fa.`Pen-fancy`: ImageVector
    get() {
        if (`_pen-fancy` != null) {
            return `_pen-fancy`!!
        }
        `_pen-fancy` = Builder(name = "Pen-fancy", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(437.5f, 91.1f)
                curveTo(452.5f, 73.9f, 474.2f, 64.0f, 497.1f, 64.0f)
                curveTo(540.7f, 64.0f, 576.1f, 99.4f, 576.1f, 143.0f)
                curveTo(576.1f, 165.8f, 566.2f, 187.6f, 549.0f, 202.6f)
                lineTo(347.7f, 377.8f)
                lineTo(337.0f, 367.0f)
                lineTo(273.0f, 303.0f)
                lineTo(262.2f, 292.3f)
                lineTo(437.5f, 91.1f)
                close()
                moveTo(225.1f, 323.0f)
                curveTo(226.0f, 324.0f, 252.0f, 350.0f, 303.0f, 401.0f)
                lineTo(316.9f, 414.9f)
                lineTo(299.8f, 489.1f)
                curveTo(295.9f, 506.2f, 282.9f, 519.8f, 266.0f, 524.5f)
                lineTo(96.2f, 572.0f)
                lineTo(188.5f, 479.7f)
                curveTo(189.7f, 479.8f, 190.8f, 479.9f, 192.0f, 479.9f)
                curveTo(209.7f, 479.9f, 224.0f, 465.6f, 224.0f, 447.9f)
                curveTo(224.0f, 430.2f, 209.7f, 415.9f, 192.0f, 415.9f)
                curveTo(174.3f, 415.9f, 160.0f, 430.2f, 160.0f, 447.9f)
                curveTo(160.0f, 449.1f, 160.1f, 450.3f, 160.2f, 451.4f)
                lineTo(67.9f, 543.8f)
                lineTo(115.5f, 374.0f)
                curveTo(120.2f, 357.1f, 133.8f, 344.1f, 150.9f, 340.2f)
                lineTo(225.1f, 323.0f)
                close()
            }
        }
        .build()
        return `_pen-fancy`!!
    }

private var `_pen-fancy`: ImageVector? = null
