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

public val Fa.`Cruzeiro-sign`: ImageVector
    get() {
        if (`_cruzeiro-sign` != null) {
            return `_cruzeiro-sign`!!
        }
        `_cruzeiro-sign` = Builder(name = "Cruzeiro-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(336.0f, 160.0f)
                curveTo(247.6f, 160.0f, 176.0f, 231.6f, 176.0f, 320.0f)
                curveTo(176.0f, 391.6f, 223.1f, 452.3f, 288.0f, 472.7f)
                lineTo(288.0f, 320.0f)
                curveTo(288.0f, 306.7f, 298.7f, 296.0f, 312.0f, 296.0f)
                curveTo(324.8f, 296.0f, 335.3f, 306.1f, 336.0f, 318.7f)
                curveTo(351.5f, 309.2f, 369.5f, 304.0f, 388.3f, 304.0f)
                lineTo(400.1f, 304.0f)
                curveTo(413.4f, 304.0f, 424.1f, 314.7f, 424.1f, 328.0f)
                curveTo(424.1f, 341.3f, 413.4f, 352.0f, 400.1f, 352.0f)
                lineTo(388.3f, 352.0f)
                curveTo(369.5f, 352.0f, 352.2f, 362.0f, 342.9f, 378.3f)
                curveTo(338.4f, 386.2f, 336.0f, 395.1f, 336.0f, 404.2f)
                lineTo(336.0f, 480.0f)
                curveTo(378.5f, 480.0f, 417.1f, 463.4f, 445.8f, 436.4f)
                curveTo(458.7f, 424.3f, 478.9f, 424.9f, 491.0f, 437.7f)
                curveTo(503.1f, 450.5f, 502.5f, 470.8f, 489.7f, 482.9f)
                curveTo(449.7f, 520.8f, 395.5f, 544.0f, 336.0f, 544.0f)
                curveTo(212.3f, 544.0f, 112.0f, 443.7f, 112.0f, 320.0f)
                curveTo(112.0f, 196.3f, 212.3f, 96.0f, 336.0f, 96.0f)
                curveTo(395.5f, 96.0f, 449.7f, 119.2f, 489.7f, 157.1f)
                curveTo(502.6f, 169.2f, 503.1f, 189.5f, 491.0f, 202.3f)
                curveTo(478.9f, 215.1f, 458.6f, 215.7f, 445.8f, 203.6f)
                curveTo(417.1f, 176.6f, 378.5f, 160.0f, 336.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_cruzeiro-sign`!!
    }

private var `_cruzeiro-sign`: ImageVector? = null
