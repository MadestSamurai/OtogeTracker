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

public val Fa.`Pen-clip`: ImageVector
    get() {
        if (`_pen-clip` != null) {
            return `_pen-clip`!!
        }
        `_pen-clip` = Builder(name = "Pen-clip", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(468.0f, 64.0f)
                curveTo(487.2f, 64.0f, 505.6f, 71.6f, 519.1f, 85.2f)
                lineTo(554.8f, 120.9f)
                curveTo(568.4f, 134.4f, 576.0f, 152.8f, 576.0f, 172.0f)
                curveTo(576.0f, 191.2f, 568.4f, 209.6f, 554.8f, 223.1f)
                lineTo(509.9f, 268.0f)
                lineTo(372.0f, 130.1f)
                lineTo(416.9f, 85.2f)
                curveTo(430.4f, 71.6f, 448.8f, 64.0f, 468.0f, 64.0f)
                close()
                moveTo(338.1f, 164.0f)
                lineTo(338.1f, 164.0f)
                lineTo(476.0f, 301.9f)
                lineTo(260.9f, 517.0f)
                curveTo(250.2f, 527.7f, 236.8f, 535.5f, 222.2f, 539.6f)
                lineTo(94.4f, 575.1f)
                curveTo(86.1f, 577.4f, 77.1f, 575.1f, 71.0f, 568.9f)
                curveTo(64.9f, 562.7f, 62.5f, 553.8f, 64.8f, 545.5f)
                lineTo(100.4f, 417.8f)
                curveTo(104.5f, 403.2f, 112.2f, 389.9f, 123.0f, 379.1f)
                lineTo(304.1f, 197.9f)
                lineTo(287.0f, 180.9f)
                curveTo(277.6f, 171.5f, 262.4f, 171.5f, 253.1f, 180.9f)
                lineTo(153.0f, 281.0f)
                curveTo(143.6f, 290.4f, 128.4f, 290.4f, 119.1f, 281.0f)
                curveTo(109.8f, 271.6f, 109.7f, 256.4f, 119.1f, 247.1f)
                lineTo(219.1f, 146.9f)
                curveTo(247.2f, 118.8f, 292.8f, 118.8f, 320.9f, 146.9f)
                lineTo(338.1f, 164.0f)
                close()
            }
        }
        .build()
        return `_pen-clip`!!
    }

private var `_pen-clip`: ImageVector? = null
