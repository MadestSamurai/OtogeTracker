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

public val Fa.`Mars-stroke-up`: ImageVector
    get() {
        if (`_mars-stroke-up` != null) {
            return `_mars-stroke-up`!!
        }
        `_mars-stroke-up` = Builder(name = "Mars-stroke-up", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 320.0f)
                curveTo(258.1f, 320.0f, 208.0f, 370.1f, 208.0f, 432.0f)
                curveTo(208.0f, 493.9f, 258.1f, 544.0f, 320.0f, 544.0f)
                curveTo(381.9f, 544.0f, 432.0f, 493.9f, 432.0f, 432.0f)
                curveTo(432.0f, 370.1f, 381.9f, 320.0f, 320.0f, 320.0f)
                close()
                moveTo(144.0f, 432.0f)
                curveTo(144.0f, 345.7f, 206.1f, 273.9f, 288.1f, 258.9f)
                curveTo(288.0f, 258.0f, 288.0f, 257.0f, 288.0f, 256.0f)
                lineTo(288.0f, 240.0f)
                lineTo(256.0f, 240.0f)
                curveTo(238.3f, 240.0f, 224.0f, 225.7f, 224.0f, 208.0f)
                curveTo(224.0f, 190.3f, 238.3f, 176.0f, 256.0f, 176.0f)
                lineTo(288.0f, 176.0f)
                lineTo(288.0f, 114.6f)
                lineTo(260.0f, 137.0f)
                curveTo(246.2f, 148.0f, 226.1f, 145.8f, 215.0f, 132.0f)
                curveTo(203.9f, 118.2f, 206.2f, 98.1f, 220.0f, 87.0f)
                lineTo(300.0f, 23.0f)
                curveTo(311.7f, 13.7f, 328.3f, 13.7f, 340.0f, 23.0f)
                lineTo(420.0f, 87.0f)
                curveTo(433.8f, 98.0f, 436.0f, 118.2f, 425.0f, 132.0f)
                curveTo(414.0f, 145.8f, 393.8f, 148.0f, 380.0f, 137.0f)
                lineTo(352.0f, 114.6f)
                lineTo(352.0f, 176.0f)
                lineTo(384.0f, 176.0f)
                curveTo(401.7f, 176.0f, 416.0f, 190.3f, 416.0f, 208.0f)
                curveTo(416.0f, 225.7f, 401.7f, 240.0f, 384.0f, 240.0f)
                lineTo(352.0f, 240.0f)
                lineTo(352.0f, 256.0f)
                curveTo(352.0f, 257.0f, 352.0f, 257.9f, 351.9f, 258.9f)
                curveTo(433.9f, 273.9f, 496.0f, 345.7f, 496.0f, 432.0f)
                curveTo(496.0f, 529.2f, 417.2f, 608.0f, 320.0f, 608.0f)
                curveTo(222.8f, 608.0f, 144.0f, 529.2f, 144.0f, 432.0f)
                close()
            }
        }
        .build()
        return `_mars-stroke-up`!!
    }

private var `_mars-stroke-up`: ImageVector? = null
