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

public val Fa.`Arrow-right-long`: ImageVector
    get() {
        if (`_arrow-right-long` != null) {
            return `_arrow-right-long`!!
        }
        `_arrow-right-long` = Builder(name = "Arrow-right-long", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(598.6f, 342.6f)
                curveTo(611.1f, 330.1f, 611.1f, 309.8f, 598.6f, 297.3f)
                lineTo(470.6f, 169.3f)
                curveTo(458.1f, 156.8f, 437.8f, 156.8f, 425.3f, 169.3f)
                curveTo(412.8f, 181.8f, 412.8f, 202.1f, 425.3f, 214.6f)
                lineTo(498.7f, 288.0f)
                lineTo(64.0f, 288.0f)
                curveTo(46.3f, 288.0f, 32.0f, 302.3f, 32.0f, 320.0f)
                curveTo(32.0f, 337.7f, 46.3f, 352.0f, 64.0f, 352.0f)
                lineTo(498.7f, 352.0f)
                lineTo(425.3f, 425.4f)
                curveTo(412.8f, 437.9f, 412.8f, 458.2f, 425.3f, 470.7f)
                curveTo(437.8f, 483.2f, 458.1f, 483.2f, 470.6f, 470.7f)
                lineTo(598.6f, 342.7f)
                close()
            }
        }
        .build()
        return `_arrow-right-long`!!
    }

private var `_arrow-right-long`: ImageVector? = null
