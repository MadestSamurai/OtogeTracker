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

public val Fa.`Mill-sign`: ImageVector
    get() {
        if (`_mill-sign` != null) {
            return `_mill-sign`!!
        }
        `_mill-sign` = Builder(name = "Mill-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(425.0f, 41.8f)
                curveTo(437.3f, 46.8f, 443.2f, 60.8f, 438.2f, 73.1f)
                lineTo(409.2f, 144.4f)
                curveTo(466.8f, 149.1f, 512.0f, 197.3f, 512.0f, 256.0f)
                lineTo(512.0f, 464.0f)
                curveTo(512.0f, 481.7f, 497.7f, 496.0f, 480.0f, 496.0f)
                curveTo(462.3f, 496.0f, 448.0f, 481.7f, 448.0f, 464.0f)
                lineTo(448.0f, 256.0f)
                curveTo(448.0f, 229.5f, 426.5f, 208.0f, 400.0f, 208.0f)
                curveTo(393.6f, 208.0f, 387.5f, 209.2f, 382.0f, 211.5f)
                lineTo(352.0f, 285.3f)
                lineTo(352.0f, 464.0f)
                curveTo(352.0f, 481.7f, 337.7f, 496.0f, 320.0f, 496.0f)
                curveTo(302.3f, 496.0f, 288.0f, 481.7f, 288.0f, 464.0f)
                lineTo(288.0f, 442.8f)
                lineTo(230.2f, 585.0f)
                curveTo(225.2f, 597.3f, 211.2f, 603.2f, 198.9f, 598.2f)
                curveTo(186.6f, 593.2f, 180.7f, 579.2f, 185.7f, 566.9f)
                lineTo(288.0f, 315.3f)
                lineTo(288.0f, 256.0f)
                curveTo(288.0f, 229.5f, 266.5f, 208.0f, 240.0f, 208.0f)
                curveTo(213.5f, 208.0f, 192.0f, 229.5f, 192.0f, 256.0f)
                lineTo(192.0f, 464.0f)
                curveTo(192.0f, 481.7f, 177.7f, 496.0f, 160.0f, 496.0f)
                curveTo(142.3f, 496.0f, 128.0f, 481.7f, 128.0f, 464.0f)
                lineTo(128.0f, 176.0f)
                curveTo(128.0f, 158.3f, 142.3f, 144.0f, 160.0f, 144.0f)
                curveTo(170.9f, 144.0f, 180.5f, 149.4f, 186.3f, 157.7f)
                curveTo(202.3f, 149.0f, 220.6f, 144.0f, 240.0f, 144.0f)
                curveTo(271.3f, 144.0f, 299.7f, 156.9f, 320.0f, 177.6f)
                curveTo(329.6f, 167.8f, 340.9f, 159.8f, 353.5f, 154.1f)
                lineTo(393.8f, 55.0f)
                curveTo(398.8f, 42.7f, 412.8f, 36.8f, 425.1f, 41.8f)
                close()
            }
        }
        .build()
        return `_mill-sign`!!
    }

private var `_mill-sign`: ImageVector? = null
