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

public val Fa.`Map-marked`: ImageVector
    get() {
        if (`_map-marked` != null) {
            return `_map-marked`!!
        }
        `_map-marked` = Builder(name = "Map-marked", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 112.0f)
                curveTo(576.0f, 100.9f, 570.3f, 90.6f, 560.8f, 84.8f)
                curveTo(551.3f, 79.0f, 539.6f, 78.4f, 529.7f, 83.4f)
                lineTo(413.5f, 141.5f)
                lineTo(234.1f, 81.6f)
                curveTo(226.0f, 78.9f, 217.3f, 79.5f, 209.7f, 83.3f)
                lineTo(81.7f, 147.3f)
                curveTo(70.8f, 152.8f, 64.0f, 163.9f, 64.0f, 176.0f)
                lineTo(64.0f, 528.0f)
                curveTo(64.0f, 539.1f, 69.7f, 549.4f, 79.2f, 555.2f)
                curveTo(88.7f, 561.0f, 100.4f, 561.6f, 110.3f, 556.6f)
                lineTo(226.4f, 498.5f)
                lineTo(399.7f, 556.3f)
                curveTo(395.4f, 549.9f, 391.2f, 543.2f, 387.1f, 536.4f)
                curveTo(376.1f, 518.1f, 365.2f, 497.1f, 357.1f, 474.6f)
                lineTo(255.9f, 440.9f)
                lineTo(255.9f, 156.4f)
                lineTo(383.9f, 199.1f)
                lineTo(383.9f, 298.4f)
                curveTo(414.9f, 262.6f, 460.9f, 240.0f, 511.9f, 240.0f)
                curveTo(534.5f, 240.0f, 556.1f, 244.4f, 575.9f, 252.5f)
                lineTo(576.0f, 112.0f)
                close()
                moveTo(392.0f, 405.9f)
                curveTo(392.0f, 474.8f, 456.1f, 556.3f, 490.6f, 595.2f)
                curveTo(502.2f, 608.2f, 521.9f, 608.2f, 533.5f, 595.2f)
                curveTo(568.0f, 556.3f, 632.1f, 474.8f, 632.1f, 405.9f)
                curveTo(632.1f, 340.8f, 578.4f, 288.0f, 512.1f, 288.0f)
                curveTo(445.8f, 288.0f, 392.0f, 340.8f, 392.0f, 405.9f)
                close()
            }
        }
        .build()
        return `_map-marked`!!
    }

private var `_map-marked`: ImageVector? = null
