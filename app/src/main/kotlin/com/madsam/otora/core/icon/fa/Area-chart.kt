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

public val Fa.`Area-chart`: ImageVector
    get() {
        if (`_area-chart` != null) {
            return `_area-chart`!!
        }
        `_area-chart` = Builder(name = "Area-chart", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 96.0f)
                curveTo(113.7f, 96.0f, 128.0f, 110.3f, 128.0f, 128.0f)
                lineTo(128.0f, 464.0f)
                curveTo(128.0f, 472.8f, 135.2f, 480.0f, 144.0f, 480.0f)
                lineTo(544.0f, 480.0f)
                curveTo(561.7f, 480.0f, 576.0f, 494.3f, 576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 561.7f, 544.0f, 544.0f, 544.0f)
                lineTo(144.0f, 544.0f)
                curveTo(99.8f, 544.0f, 64.0f, 508.2f, 64.0f, 464.0f)
                lineTo(64.0f, 128.0f)
                curveTo(64.0f, 110.3f, 78.3f, 96.0f, 96.0f, 96.0f)
                close()
                moveTo(304.0f, 160.0f)
                curveTo(310.7f, 160.0f, 317.1f, 162.8f, 321.7f, 167.8f)
                lineTo(392.8f, 245.3f)
                lineTo(439.0f, 199.0f)
                curveTo(448.4f, 189.6f, 463.6f, 189.6f, 472.9f, 199.0f)
                lineTo(536.9f, 263.0f)
                curveTo(541.4f, 267.5f, 543.9f, 273.6f, 543.9f, 280.0f)
                lineTo(543.9f, 392.0f)
                curveTo(543.9f, 405.3f, 533.2f, 416.0f, 519.9f, 416.0f)
                lineTo(215.9f, 416.0f)
                curveTo(202.6f, 416.0f, 191.9f, 405.3f, 191.9f, 392.0f)
                lineTo(191.9f, 280.0f)
                curveTo(191.9f, 274.0f, 194.2f, 268.2f, 198.2f, 263.8f)
                lineTo(286.2f, 167.8f)
                curveTo(290.7f, 162.8f, 297.2f, 160.0f, 303.9f, 160.0f)
                close()
            }
        }
        .build()
        return `_area-chart`!!
    }

private var `_area-chart`: ImageVector? = null
