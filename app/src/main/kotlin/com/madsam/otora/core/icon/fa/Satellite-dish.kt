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

public val Fa.`Satellite-dish`: ImageVector
    get() {
        if (`_satellite-dish` != null) {
            return `_satellite-dish`!!
        }
        `_satellite-dish` = Builder(name = "Satellite-dish", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(296.0f, 64.0f)
                curveTo(450.6f, 64.0f, 576.0f, 189.4f, 576.0f, 344.0f)
                curveTo(576.0f, 357.3f, 565.3f, 368.0f, 552.0f, 368.0f)
                curveTo(538.7f, 368.0f, 528.0f, 357.3f, 528.0f, 344.0f)
                curveTo(528.0f, 215.9f, 424.1f, 112.0f, 296.0f, 112.0f)
                curveTo(282.7f, 112.0f, 272.0f, 101.3f, 272.0f, 88.0f)
                curveTo(272.0f, 74.7f, 282.7f, 64.0f, 296.0f, 64.0f)
                close()
                moveTo(272.0f, 184.0f)
                curveTo(272.0f, 170.7f, 282.7f, 160.0f, 296.0f, 160.0f)
                curveTo(397.6f, 160.0f, 480.0f, 242.4f, 480.0f, 344.0f)
                curveTo(480.0f, 357.3f, 469.3f, 368.0f, 456.0f, 368.0f)
                curveTo(442.7f, 368.0f, 432.0f, 357.3f, 432.0f, 344.0f)
                curveTo(432.0f, 268.9f, 371.1f, 208.0f, 296.0f, 208.0f)
                curveTo(282.7f, 208.0f, 272.0f, 197.3f, 272.0f, 184.0f)
                close()
                moveTo(90.4f, 206.7f)
                curveTo(99.2f, 188.8f, 122.8f, 186.8f, 136.9f, 200.9f)
                lineTo(265.4f, 329.4f)
                lineTo(297.4f, 297.4f)
                curveTo(309.9f, 284.9f, 330.2f, 284.9f, 342.7f, 297.4f)
                curveTo(355.2f, 309.9f, 355.2f, 330.2f, 342.7f, 342.7f)
                lineTo(310.7f, 374.7f)
                lineTo(439.2f, 503.2f)
                curveTo(453.3f, 517.3f, 451.2f, 540.8f, 433.4f, 549.7f)
                curveTo(399.2f, 566.6f, 360.8f, 576.1f, 320.1f, 576.1f)
                curveTo(178.7f, 576.1f, 64.1f, 461.5f, 64.1f, 320.1f)
                curveTo(64.1f, 279.4f, 73.6f, 240.9f, 90.5f, 206.8f)
                close()
            }
        }
        .build()
        return `_satellite-dish`!!
    }

private var `_satellite-dish`: ImageVector? = null
