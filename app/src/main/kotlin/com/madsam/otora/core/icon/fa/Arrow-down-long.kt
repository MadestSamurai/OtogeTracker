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

public val Fa.`Arrow-down-long`: ImageVector
    get() {
        if (`_arrow-down-long` != null) {
            return `_arrow-down-long`!!
        }
        `_arrow-down-long` = Builder(name = "Arrow-down-long", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 598.6f)
                curveTo(309.9f, 611.1f, 330.2f, 611.1f, 342.7f, 598.6f)
                lineTo(470.7f, 470.6f)
                curveTo(483.2f, 458.1f, 483.2f, 437.8f, 470.7f, 425.3f)
                curveTo(458.2f, 412.8f, 437.9f, 412.8f, 425.4f, 425.3f)
                lineTo(352.0f, 498.7f)
                lineTo(352.0f, 64.0f)
                curveTo(352.0f, 46.3f, 337.7f, 32.0f, 320.0f, 32.0f)
                curveTo(302.3f, 32.0f, 288.0f, 46.3f, 288.0f, 64.0f)
                lineTo(288.0f, 498.7f)
                lineTo(214.6f, 425.3f)
                curveTo(202.1f, 412.8f, 181.8f, 412.8f, 169.3f, 425.3f)
                curveTo(156.8f, 437.8f, 156.8f, 458.1f, 169.3f, 470.6f)
                lineTo(297.3f, 598.6f)
                close()
            }
        }
        .build()
        return `_arrow-down-long`!!
    }

private var `_arrow-down-long`: ImageVector? = null
