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

public val Fa.`Microphone-slash`: ImageVector
    get() {
        if (`_microphone-slash` != null) {
            return `_microphone-slash`!!
        }
        `_microphone-slash` = Builder(name = "Microphone-slash", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(73.0f, 39.1f)
                curveTo(63.6f, 29.7f, 48.4f, 29.7f, 39.1f, 39.1f)
                curveTo(29.8f, 48.5f, 29.7f, 63.7f, 39.0f, 73.1f)
                lineTo(567.0f, 601.1f)
                curveTo(576.4f, 610.5f, 591.6f, 610.5f, 600.9f, 601.1f)
                curveTo(610.2f, 591.7f, 610.3f, 576.5f, 600.9f, 567.2f)
                lineTo(456.7f, 422.8f)
                curveTo(490.9f, 388.2f, 512.0f, 340.6f, 512.0f, 288.0f)
                lineTo(512.0f, 248.0f)
                curveTo(512.0f, 234.7f, 501.3f, 224.0f, 488.0f, 224.0f)
                curveTo(474.7f, 224.0f, 464.0f, 234.7f, 464.0f, 248.0f)
                lineTo(464.0f, 288.0f)
                curveTo(464.0f, 327.3f, 448.3f, 362.9f, 422.7f, 388.9f)
                lineTo(388.8f, 355.0f)
                curveTo(405.6f, 337.7f, 416.0f, 314.0f, 416.0f, 288.0f)
                lineTo(416.0f, 160.0f)
                curveTo(416.0f, 107.0f, 373.0f, 64.0f, 320.0f, 64.0f)
                curveTo(267.0f, 64.0f, 224.0f, 107.0f, 224.0f, 160.0f)
                lineTo(224.0f, 190.2f)
                lineTo(73.0f, 39.2f)
                close()
                moveTo(371.3f, 473.1f)
                lineTo(329.9f, 431.7f)
                curveTo(326.6f, 431.9f, 323.4f, 432.0f, 320.1f, 432.0f)
                curveTo(240.6f, 432.0f, 176.1f, 367.5f, 176.1f, 288.0f)
                lineTo(176.1f, 277.8f)
                lineTo(132.5f, 234.2f)
                curveTo(129.7f, 238.1f, 128.1f, 242.9f, 128.1f, 248.0f)
                lineTo(128.1f, 288.0f)
                curveTo(128.1f, 385.9f, 201.4f, 466.7f, 296.1f, 478.5f)
                lineTo(296.1f, 528.0f)
                lineTo(248.1f, 528.0f)
                curveTo(234.8f, 528.0f, 224.1f, 538.7f, 224.1f, 552.0f)
                curveTo(224.1f, 565.3f, 234.8f, 576.0f, 248.1f, 576.0f)
                lineTo(392.1f, 576.0f)
                curveTo(405.4f, 576.0f, 416.1f, 565.3f, 416.1f, 552.0f)
                curveTo(416.1f, 538.7f, 405.4f, 528.0f, 392.1f, 528.0f)
                lineTo(344.1f, 528.0f)
                lineTo(344.1f, 478.5f)
                curveTo(353.4f, 477.3f, 362.5f, 475.5f, 371.4f, 473.1f)
                close()
            }
        }
        .build()
        return `_microphone-slash`!!
    }

private var `_microphone-slash`: ImageVector? = null
