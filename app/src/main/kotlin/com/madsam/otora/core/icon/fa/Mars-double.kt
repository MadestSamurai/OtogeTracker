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

public val Fa.`Mars-double`: ImageVector
    get() {
        if (`_mars-double` != null) {
            return `_mars-double`!!
        }
        `_mars-double` = Builder(name = "Mars-double", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 96.0f)
                curveTo(288.0f, 78.3f, 302.3f, 64.0f, 320.0f, 64.0f)
                lineTo(448.0f, 64.0f)
                curveTo(465.7f, 64.0f, 480.0f, 78.3f, 480.0f, 96.0f)
                lineTo(480.0f, 224.0f)
                curveTo(480.0f, 241.7f, 465.7f, 256.0f, 448.0f, 256.0f)
                curveTo(430.3f, 256.0f, 416.0f, 241.7f, 416.0f, 224.0f)
                lineTo(416.0f, 173.3f)
                lineTo(321.0f, 268.3f)
                curveTo(340.5f, 296.7f, 352.0f, 331.0f, 352.0f, 368.1f)
                curveTo(352.0f, 465.3f, 273.2f, 544.1f, 176.0f, 544.1f)
                curveTo(78.8f, 544.1f, 0.0f, 465.2f, 0.0f, 368.0f)
                curveTo(0.0f, 270.8f, 78.8f, 192.0f, 176.0f, 192.0f)
                curveTo(213.0f, 192.0f, 247.4f, 203.4f, 275.8f, 223.0f)
                lineTo(370.8f, 128.0f)
                lineTo(320.1f, 128.0f)
                curveTo(302.4f, 128.0f, 288.1f, 113.7f, 288.1f, 96.0f)
                close()
                moveTo(176.0f, 480.0f)
                curveTo(237.9f, 480.0f, 288.0f, 429.9f, 288.0f, 368.0f)
                curveTo(288.0f, 306.1f, 237.9f, 256.0f, 176.0f, 256.0f)
                curveTo(114.1f, 256.0f, 64.0f, 306.1f, 64.0f, 368.0f)
                curveTo(64.0f, 429.9f, 114.1f, 480.0f, 176.0f, 480.0f)
                close()
                moveTo(336.0f, 544.0f)
                curveTo(329.2f, 544.0f, 322.6f, 543.6f, 316.0f, 542.9f)
                curveTo(339.6f, 524.0f, 359.3f, 500.4f, 373.6f, 473.5f)
                curveTo(416.9f, 458.0f, 448.0f, 416.6f, 448.0f, 368.0f)
                curveTo(448.0f, 342.8f, 439.7f, 319.5f, 425.6f, 300.8f)
                curveTo(432.7f, 302.9f, 440.2f, 304.0f, 448.0f, 304.0f)
                curveTo(465.0f, 304.0f, 480.7f, 298.7f, 493.7f, 289.7f)
                curveTo(505.4f, 313.3f, 512.0f, 339.9f, 512.0f, 368.0f)
                curveTo(512.0f, 465.2f, 433.2f, 544.0f, 336.0f, 544.0f)
                close()
                moveTo(528.0f, 221.3f)
                lineTo(528.0f, 96.0f)
                curveTo(528.0f, 84.6f, 525.6f, 73.8f, 521.3f, 64.0f)
                lineTo(608.0f, 64.0f)
                curveTo(625.7f, 64.0f, 640.0f, 78.3f, 640.0f, 96.0f)
                lineTo(640.0f, 224.0f)
                curveTo(640.0f, 241.7f, 625.7f, 256.0f, 608.0f, 256.0f)
                curveTo(590.3f, 256.0f, 576.0f, 241.7f, 576.0f, 224.0f)
                lineTo(576.0f, 173.3f)
                lineTo(528.0f, 221.3f)
                close()
            }
        }
        .build()
        return `_mars-double`!!
    }

private var `_mars-double`: ImageVector? = null
