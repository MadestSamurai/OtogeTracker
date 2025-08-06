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

public val Fa.`Pen-nib`: ImageVector
    get() {
        if (`_pen-nib` != null) {
            return `_pen-nib`!!
        }
        `_pen-nib` = Builder(name = "Pen-nib", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(432.5f, 82.3f)
                lineTo(382.4f, 132.4f)
                lineTo(507.7f, 257.7f)
                lineTo(557.8f, 207.6f)
                curveTo(579.7f, 185.7f, 579.7f, 150.3f, 557.8f, 128.4f)
                lineTo(511.7f, 82.3f)
                curveTo(489.8f, 60.4f, 454.4f, 60.4f, 432.5f, 82.3f)
                close()
                moveTo(343.3f, 161.2f)
                lineTo(342.8f, 161.3f)
                lineTo(198.7f, 204.5f)
                curveTo(178.8f, 210.5f, 163.0f, 225.7f, 156.4f, 245.5f)
                lineTo(67.8f, 509.8f)
                curveTo(64.9f, 518.5f, 65.9f, 528.0f, 70.3f, 535.8f)
                lineTo(225.7f, 380.4f)
                curveTo(224.6f, 376.4f, 224.1f, 372.3f, 224.1f, 368.0f)
                curveTo(224.1f, 341.5f, 245.6f, 320.0f, 272.1f, 320.0f)
                curveTo(298.6f, 320.0f, 320.1f, 341.5f, 320.1f, 368.0f)
                curveTo(320.1f, 394.5f, 298.6f, 416.0f, 272.1f, 416.0f)
                curveTo(267.8f, 416.0f, 263.6f, 415.4f, 259.7f, 414.4f)
                lineTo(104.3f, 569.7f)
                curveTo(112.1f, 574.1f, 121.5f, 575.1f, 130.3f, 572.2f)
                lineTo(394.6f, 483.6f)
                curveTo(414.3f, 477.0f, 429.6f, 461.2f, 435.6f, 441.3f)
                lineTo(478.8f, 297.2f)
                lineTo(478.9f, 296.7f)
                lineTo(343.4f, 161.2f)
                close()
            }
        }
        .build()
        return `_pen-nib`!!
    }

private var `_pen-nib`: ImageVector? = null
