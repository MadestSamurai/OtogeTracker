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

public val Fa.`Pen-ruler`: ImageVector
    get() {
        if (`_pen-ruler` != null) {
            return `_pen-ruler`!!
        }
        `_pen-ruler` = Builder(name = "Pen-ruler", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(468.0f, 64.0f)
                curveTo(487.2f, 64.0f, 505.6f, 71.6f, 519.1f, 85.2f)
                lineTo(554.8f, 120.9f)
                curveTo(568.4f, 134.4f, 576.0f, 152.8f, 576.0f, 172.0f)
                curveTo(576.0f, 191.2f, 568.4f, 209.6f, 554.8f, 223.1f)
                lineTo(509.9f, 268.0f)
                lineTo(372.0f, 130.1f)
                lineTo(416.9f, 85.2f)
                curveTo(430.4f, 71.6f, 448.8f, 64.0f, 468.0f, 64.0f)
                close()
                moveTo(122.9f, 379.1f)
                lineTo(338.1f, 164.0f)
                lineTo(476.0f, 301.9f)
                lineTo(260.9f, 517.1f)
                curveTo(250.2f, 527.8f, 236.8f, 535.6f, 222.2f, 539.7f)
                lineTo(94.4f, 575.1f)
                curveTo(86.1f, 577.4f, 77.1f, 575.1f, 71.0f, 568.9f)
                curveTo(64.9f, 562.7f, 62.5f, 553.8f, 64.8f, 545.5f)
                lineTo(100.4f, 417.8f)
                curveTo(104.5f, 403.2f, 112.2f, 389.9f, 123.0f, 379.1f)
                close()
                moveTo(289.4f, 144.8f)
                lineTo(144.8f, 289.4f)
                lineTo(75.7f, 220.3f)
                curveTo(60.1f, 204.7f, 60.1f, 179.4f, 75.7f, 163.7f)
                lineTo(163.7f, 75.7f)
                curveTo(179.3f, 60.1f, 204.6f, 60.1f, 220.3f, 75.7f)
                lineTo(226.2f, 81.6f)
                lineTo(169.9f, 137.9f)
                curveTo(162.1f, 145.7f, 162.1f, 158.4f, 169.9f, 166.2f)
                curveTo(177.7f, 174.0f, 190.4f, 174.0f, 198.2f, 166.2f)
                lineTo(254.5f, 109.9f)
                lineTo(289.4f, 144.8f)
                close()
                moveTo(495.2f, 350.6f)
                lineTo(530.1f, 385.5f)
                lineTo(473.8f, 441.8f)
                curveTo(466.0f, 449.6f, 466.0f, 462.3f, 473.8f, 470.1f)
                curveTo(481.6f, 477.9f, 494.3f, 477.9f, 502.1f, 470.1f)
                lineTo(558.4f, 413.8f)
                lineTo(564.3f, 419.7f)
                curveTo(579.9f, 435.3f, 579.9f, 460.6f, 564.3f, 476.3f)
                lineTo(476.3f, 564.3f)
                curveTo(460.7f, 579.9f, 435.4f, 579.9f, 419.7f, 564.3f)
                lineTo(350.6f, 495.2f)
                lineTo(495.2f, 350.6f)
                close()
            }
        }
        .build()
        return `_pen-ruler`!!
    }

private var `_pen-ruler`: ImageVector? = null
