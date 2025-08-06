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

public val Fa.`Arrow-down-up-across-line`: ImageVector
    get() {
        if (`_arrow-down-up-across-line` != null) {
            return `_arrow-down-up-across-line`!!
        }
        `_arrow-down-up-across-line` = Builder(name = "Arrow-down-up-across-line", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(329.4f, 169.4f)
                lineTo(425.4f, 73.4f)
                curveTo(437.9f, 60.9f, 458.2f, 60.9f, 470.7f, 73.4f)
                lineTo(566.7f, 169.4f)
                curveTo(579.2f, 181.9f, 579.2f, 202.2f, 566.7f, 214.7f)
                curveTo(554.2f, 227.2f, 533.9f, 227.2f, 521.4f, 214.7f)
                lineTo(480.0f, 173.3f)
                lineTo(480.0f, 288.0f)
                lineTo(544.0f, 288.0f)
                curveTo(561.7f, 288.0f, 576.0f, 302.3f, 576.0f, 320.0f)
                curveTo(576.0f, 337.7f, 561.7f, 352.0f, 544.0f, 352.0f)
                lineTo(224.0f, 352.0f)
                lineTo(224.0f, 466.7f)
                lineTo(265.4f, 425.3f)
                curveTo(277.9f, 412.8f, 298.2f, 412.8f, 310.7f, 425.3f)
                curveTo(323.2f, 437.8f, 323.2f, 458.1f, 310.7f, 470.6f)
                lineTo(214.7f, 566.6f)
                curveTo(202.2f, 579.1f, 181.9f, 579.1f, 169.4f, 566.6f)
                lineTo(73.4f, 470.6f)
                curveTo(60.9f, 458.1f, 60.9f, 437.8f, 73.4f, 425.3f)
                curveTo(85.9f, 412.8f, 106.2f, 412.8f, 118.7f, 425.3f)
                lineTo(160.0f, 466.7f)
                lineTo(160.0f, 352.0f)
                lineTo(96.0f, 352.0f)
                curveTo(78.3f, 352.0f, 64.0f, 337.7f, 64.0f, 320.0f)
                curveTo(64.0f, 302.3f, 78.3f, 288.0f, 96.0f, 288.0f)
                lineTo(416.0f, 288.0f)
                lineTo(416.0f, 173.3f)
                lineTo(374.6f, 214.7f)
                curveTo(362.1f, 227.2f, 341.8f, 227.2f, 329.3f, 214.7f)
                curveTo(316.8f, 202.2f, 316.8f, 181.9f, 329.3f, 169.4f)
                close()
                moveTo(480.0f, 400.0f)
                lineTo(480.0f, 544.0f)
                curveTo(480.0f, 561.7f, 465.7f, 576.0f, 448.0f, 576.0f)
                curveTo(430.3f, 576.0f, 416.0f, 561.7f, 416.0f, 544.0f)
                lineTo(416.0f, 400.0f)
                lineTo(480.0f, 400.0f)
                close()
                moveTo(160.0f, 240.0f)
                lineTo(160.0f, 96.0f)
                curveTo(160.0f, 78.3f, 174.3f, 64.0f, 192.0f, 64.0f)
                curveTo(209.7f, 64.0f, 224.0f, 78.3f, 224.0f, 96.0f)
                lineTo(224.0f, 240.0f)
                lineTo(160.0f, 240.0f)
                close()
            }
        }
        .build()
        return `_arrow-down-up-across-line`!!
    }

private var `_arrow-down-up-across-line`: ImageVector? = null
