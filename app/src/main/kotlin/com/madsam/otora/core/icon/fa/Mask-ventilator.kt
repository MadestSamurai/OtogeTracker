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

public val Fa.`Mask-ventilator`: ImageVector
    get() {
        if (`_mask-ventilator` != null) {
            return `_mask-ventilator`!!
        }
        `_mask-ventilator` = Builder(name = "Mask-ventilator", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(152.2f, 256.0f)
                curveTo(136.8f, 294.3f, 128.0f, 333.2f, 128.0f, 364.8f)
                curveTo(128.0f, 378.1f, 129.5f, 391.0f, 132.4f, 403.5f)
                lineTo(115.4f, 400.1f)
                curveTo(85.5f, 394.1f, 64.0f, 367.9f, 64.0f, 337.3f)
                lineTo(64.0f, 256.0f)
                lineTo(152.2f, 256.0f)
                close()
                moveTo(185.1f, 192.0f)
                lineTo(64.0f, 192.0f)
                curveTo(28.7f, 192.0f, 0.0f, 220.7f, 0.0f, 256.0f)
                lineTo(0.0f, 337.3f)
                curveTo(0.0f, 398.3f, 43.1f, 450.8f, 102.9f, 462.8f)
                lineTo(169.2f, 476.1f)
                curveTo(187.9f, 498.2f, 212.1f, 516.1f, 240.0f, 527.9f)
                lineTo(240.0f, 440.1f)
                curveTo(229.9f, 425.9f, 224.0f, 408.8f, 224.0f, 390.4f)
                curveTo(224.0f, 340.9f, 267.0f, 256.0f, 320.0f, 256.0f)
                curveTo(372.5f, 256.0f, 416.0f, 340.9f, 416.0f, 390.4f)
                curveTo(416.0f, 408.8f, 410.1f, 425.8f, 400.0f, 440.0f)
                lineTo(400.0f, 527.7f)
                curveTo(427.6f, 515.9f, 451.7f, 498.1f, 470.4f, 476.1f)
                lineTo(537.1f, 462.8f)
                curveTo(596.9f, 450.8f, 640.0f, 398.3f, 640.0f, 337.3f)
                lineTo(640.0f, 256.0f)
                curveTo(640.0f, 220.7f, 611.3f, 192.0f, 576.0f, 192.0f)
                lineTo(454.5f, 192.0f)
                curveTo(419.7f, 137.8f, 372.0f, 96.0f, 320.0f, 96.0f)
                curveTo(267.4f, 96.0f, 219.8f, 137.8f, 185.1f, 192.0f)
                close()
                moveTo(487.6f, 256.0f)
                lineTo(576.0f, 256.0f)
                lineTo(576.0f, 337.3f)
                curveTo(576.0f, 367.8f, 554.5f, 394.1f, 524.6f, 400.1f)
                lineTo(507.6f, 403.5f)
                curveTo(510.5f, 391.1f, 512.1f, 378.1f, 512.1f, 364.8f)
                curveTo(512.1f, 333.2f, 503.2f, 294.3f, 487.7f, 256.0f)
                close()
                moveTo(288.0f, 384.0f)
                lineTo(288.0f, 576.0f)
                lineTo(352.0f, 576.0f)
                lineTo(352.0f, 384.0f)
                curveTo(352.0f, 366.3f, 337.7f, 352.0f, 320.0f, 352.0f)
                curveTo(302.3f, 352.0f, 288.0f, 366.3f, 288.0f, 384.0f)
                close()
            }
        }
        .build()
        return `_mask-ventilator`!!
    }

private var `_mask-ventilator`: ImageVector? = null
