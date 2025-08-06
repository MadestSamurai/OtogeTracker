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

public val Fa.`Text-width`: ImageVector
    get() {
        if (`_text-width` != null) {
            return `_text-width`!!
        }
        `_text-width` = Builder(name = "Text-width", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(136.0f, 64.0f)
                curveTo(113.9f, 64.0f, 96.0f, 81.9f, 96.0f, 104.0f)
                lineTo(96.0f, 160.0f)
                curveTo(96.0f, 177.7f, 110.3f, 192.0f, 128.0f, 192.0f)
                curveTo(145.7f, 192.0f, 160.0f, 177.7f, 160.0f, 160.0f)
                lineTo(160.0f, 128.0f)
                lineTo(288.0f, 128.0f)
                lineTo(288.0f, 288.0f)
                lineTo(256.0f, 288.0f)
                curveTo(238.3f, 288.0f, 224.0f, 302.3f, 224.0f, 320.0f)
                curveTo(224.0f, 337.7f, 238.3f, 352.0f, 256.0f, 352.0f)
                lineTo(384.0f, 352.0f)
                curveTo(401.7f, 352.0f, 416.0f, 337.7f, 416.0f, 320.0f)
                curveTo(416.0f, 302.3f, 401.7f, 288.0f, 384.0f, 288.0f)
                lineTo(352.0f, 288.0f)
                lineTo(352.0f, 128.0f)
                lineTo(480.0f, 128.0f)
                lineTo(480.0f, 160.0f)
                curveTo(480.0f, 177.7f, 494.3f, 192.0f, 512.0f, 192.0f)
                curveTo(529.7f, 192.0f, 544.0f, 177.7f, 544.0f, 160.0f)
                lineTo(544.0f, 104.0f)
                curveTo(544.0f, 81.9f, 526.1f, 64.0f, 504.0f, 64.0f)
                lineTo(136.0f, 64.0f)
                close()
                moveTo(214.6f, 470.6f)
                curveTo(227.1f, 458.1f, 227.1f, 437.8f, 214.6f, 425.3f)
                curveTo(202.1f, 412.8f, 181.8f, 412.8f, 169.3f, 425.3f)
                lineTo(105.3f, 489.3f)
                curveTo(92.8f, 501.8f, 92.8f, 522.1f, 105.3f, 534.6f)
                lineTo(169.3f, 598.6f)
                curveTo(181.8f, 611.1f, 202.1f, 611.1f, 214.6f, 598.6f)
                curveTo(227.1f, 586.1f, 227.1f, 565.8f, 214.6f, 553.3f)
                lineTo(205.2f, 543.9f)
                lineTo(434.7f, 543.9f)
                lineTo(425.3f, 553.3f)
                curveTo(412.8f, 565.8f, 412.8f, 586.1f, 425.3f, 598.6f)
                curveTo(437.8f, 611.1f, 458.1f, 611.1f, 470.6f, 598.6f)
                lineTo(534.6f, 534.6f)
                curveTo(547.1f, 522.1f, 547.1f, 501.8f, 534.6f, 489.3f)
                lineTo(470.6f, 425.3f)
                curveTo(458.1f, 412.8f, 437.8f, 412.8f, 425.3f, 425.3f)
                curveTo(412.8f, 437.8f, 412.8f, 458.1f, 425.3f, 470.6f)
                lineTo(434.7f, 480.0f)
                lineTo(205.2f, 480.0f)
                lineTo(214.6f, 470.6f)
                close()
            }
        }
        .build()
        return `_text-width`!!
    }

private var `_text-width`: ImageVector? = null
