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

public val Fa.`Scroll-torah`: ImageVector
    get() {
        if (`_scroll-torah` != null) {
            return `_scroll-torah`!!
        }
        `_scroll-torah` = Builder(name = "Scroll-torah", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 112.0f)
                curveTo(32.0f, 85.5f, 53.5f, 64.0f, 80.0f, 64.0f)
                curveTo(100.9f, 64.0f, 118.7f, 77.4f, 125.3f, 96.0f)
                lineTo(514.8f, 96.0f)
                curveTo(521.4f, 77.4f, 539.2f, 64.0f, 560.1f, 64.0f)
                curveTo(586.6f, 64.0f, 608.1f, 85.5f, 608.1f, 112.0f)
                lineTo(608.1f, 528.0f)
                curveTo(608.1f, 554.5f, 586.6f, 576.0f, 560.1f, 576.0f)
                curveTo(539.2f, 576.0f, 521.4f, 562.6f, 514.8f, 544.0f)
                lineTo(125.3f, 544.0f)
                curveTo(118.7f, 562.6f, 100.9f, 576.0f, 80.0f, 576.0f)
                curveTo(53.5f, 576.0f, 32.0f, 554.5f, 32.0f, 528.0f)
                lineTo(32.0f, 112.0f)
                close()
                moveTo(209.9f, 365.0f)
                curveTo(208.7f, 367.0f, 208.0f, 369.2f, 208.0f, 371.6f)
                curveTo(208.0f, 378.5f, 213.6f, 384.1f, 220.5f, 384.1f)
                lineTo(277.4f, 384.1f)
                lineTo(307.9f, 433.3f)
                curveTo(310.5f, 437.5f, 315.1f, 440.1f, 320.1f, 440.1f)
                curveTo(325.1f, 440.1f, 329.7f, 437.5f, 332.3f, 433.3f)
                lineTo(362.8f, 384.1f)
                lineTo(419.7f, 384.1f)
                curveTo(426.6f, 384.1f, 432.2f, 378.5f, 432.2f, 371.6f)
                curveTo(432.2f, 369.3f, 431.6f, 367.0f, 430.3f, 365.0f)
                lineTo(402.5f, 320.0f)
                lineTo(430.3f, 275.0f)
                curveTo(431.5f, 273.0f, 432.2f, 270.8f, 432.2f, 268.4f)
                curveTo(432.2f, 261.5f, 426.6f, 255.9f, 419.7f, 255.9f)
                lineTo(362.8f, 255.9f)
                lineTo(332.3f, 206.7f)
                curveTo(329.7f, 202.5f, 325.1f, 199.9f, 320.1f, 199.9f)
                curveTo(315.1f, 199.9f, 310.5f, 202.5f, 307.9f, 206.7f)
                lineTo(277.4f, 255.9f)
                lineTo(220.5f, 255.9f)
                curveTo(213.6f, 255.9f, 208.0f, 261.5f, 208.0f, 268.4f)
                curveTo(208.0f, 270.7f, 208.6f, 273.0f, 209.9f, 275.0f)
                lineTo(237.7f, 320.0f)
                lineTo(209.9f, 365.0f)
                close()
            }
        }
        .build()
        return `_scroll-torah`!!
    }

private var `_scroll-torah`: ImageVector? = null
