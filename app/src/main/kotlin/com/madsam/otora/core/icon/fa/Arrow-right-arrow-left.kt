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

public val Fa.`Arrow-right-arrow-left`: ImageVector
    get() {
        if (`_arrow-right-arrow-left` != null) {
            return `_arrow-right-arrow-left`!!
        }
        `_arrow-right-arrow-left` = Builder(name = "Arrow-right-arrow-left", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(566.6f, 214.6f)
                lineTo(470.6f, 310.6f)
                curveTo(458.1f, 323.1f, 437.8f, 323.1f, 425.3f, 310.6f)
                curveTo(412.8f, 298.1f, 412.8f, 277.8f, 425.3f, 265.3f)
                lineTo(466.7f, 224.0f)
                lineTo(96.0f, 224.0f)
                curveTo(78.3f, 224.0f, 64.0f, 209.7f, 64.0f, 192.0f)
                curveTo(64.0f, 174.3f, 78.3f, 160.0f, 96.0f, 160.0f)
                lineTo(466.7f, 160.0f)
                lineTo(425.3f, 118.6f)
                curveTo(412.8f, 106.1f, 412.8f, 85.8f, 425.3f, 73.3f)
                curveTo(437.8f, 60.8f, 458.1f, 60.8f, 470.6f, 73.3f)
                lineTo(566.6f, 169.3f)
                curveTo(579.1f, 181.8f, 579.1f, 202.1f, 566.6f, 214.6f)
                close()
                moveTo(169.3f, 566.6f)
                lineTo(73.3f, 470.6f)
                curveTo(60.8f, 458.1f, 60.8f, 437.8f, 73.3f, 425.3f)
                lineTo(169.3f, 329.3f)
                curveTo(181.8f, 316.8f, 202.1f, 316.8f, 214.6f, 329.3f)
                curveTo(227.1f, 341.8f, 227.1f, 362.1f, 214.6f, 374.6f)
                lineTo(173.3f, 416.0f)
                lineTo(544.0f, 416.0f)
                curveTo(561.7f, 416.0f, 576.0f, 430.3f, 576.0f, 448.0f)
                curveTo(576.0f, 465.7f, 561.7f, 480.0f, 544.0f, 480.0f)
                lineTo(173.3f, 480.0f)
                lineTo(214.7f, 521.4f)
                curveTo(227.2f, 533.9f, 227.2f, 554.2f, 214.7f, 566.7f)
                curveTo(202.2f, 579.2f, 181.9f, 579.2f, 169.4f, 566.7f)
                close()
            }
        }
        .build()
        return `_arrow-right-arrow-left`!!
    }

private var `_arrow-right-arrow-left`: ImageVector? = null
