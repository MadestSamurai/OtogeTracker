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

public val Fa.`Non-binary`: ImageVector
    get() {
        if (`_non-binary` != null) {
            return `_non-binary`!!
        }
        `_non-binary` = Builder(name = "Non-binary", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 608.0f)
                curveTo(222.8f, 608.0f, 144.0f, 529.2f, 144.0f, 432.0f)
                curveTo(144.0f, 345.7f, 206.1f, 274.0f, 288.0f, 259.0f)
                lineTo(288.0f, 211.8f)
                lineTo(238.3f, 236.6f)
                lineTo(235.3f, 237.9f)
                curveTo(220.1f, 243.6f, 202.8f, 237.1f, 195.4f, 222.2f)
                curveTo(188.0f, 207.4f, 193.2f, 189.6f, 206.9f, 180.9f)
                lineTo(209.7f, 179.3f)
                lineTo(248.5f, 159.9f)
                lineTo(209.7f, 140.5f)
                curveTo(193.9f, 132.6f, 187.5f, 113.4f, 195.4f, 97.6f)
                curveTo(202.8f, 82.8f, 220.2f, 76.2f, 235.4f, 82.0f)
                lineTo(238.4f, 83.3f)
                lineTo(288.1f, 108.1f)
                lineTo(288.1f, 63.9f)
                curveTo(288.1f, 46.2f, 302.4f, 31.9f, 320.1f, 31.9f)
                curveTo(337.8f, 31.9f, 352.1f, 46.2f, 352.1f, 63.9f)
                lineTo(352.1f, 108.1f)
                lineTo(401.8f, 83.3f)
                lineTo(404.8f, 82.0f)
                curveTo(420.0f, 76.2f, 437.3f, 82.8f, 444.7f, 97.6f)
                curveTo(452.1f, 112.4f, 446.9f, 130.3f, 433.2f, 138.9f)
                lineTo(430.4f, 140.5f)
                lineTo(391.7f, 159.9f)
                lineTo(430.4f, 179.2f)
                curveTo(446.2f, 187.1f, 452.6f, 206.3f, 444.7f, 222.1f)
                curveTo(437.3f, 236.9f, 420.0f, 243.5f, 404.8f, 237.7f)
                lineTo(401.8f, 236.4f)
                lineTo(352.1f, 211.6f)
                lineTo(352.1f, 258.8f)
                curveTo(434.0f, 273.9f, 496.1f, 345.6f, 496.1f, 431.8f)
                curveTo(496.1f, 529.0f, 417.3f, 607.8f, 320.1f, 607.8f)
                close()
                moveTo(320.0f, 544.0f)
                curveTo(381.9f, 544.0f, 432.0f, 493.9f, 432.0f, 432.0f)
                curveTo(432.0f, 370.1f, 381.9f, 320.0f, 320.0f, 320.0f)
                curveTo(258.1f, 320.0f, 208.0f, 370.1f, 208.0f, 432.0f)
                curveTo(208.0f, 493.9f, 258.1f, 544.0f, 320.0f, 544.0f)
                close()
            }
        }
        .build()
        return `_non-binary`!!
    }

private var `_non-binary`: ImageVector? = null
