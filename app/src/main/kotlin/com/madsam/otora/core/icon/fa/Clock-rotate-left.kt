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

public val Fa.`Clock-rotate-left`: ImageVector
    get() {
        if (`_clock-rotate-left` != null) {
            return `_clock-rotate-left`!!
        }
        `_clock-rotate-left` = Builder(name = "Clock-rotate-left", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 128.0f)
                curveTo(426.0f, 128.0f, 512.0f, 214.0f, 512.0f, 320.0f)
                curveTo(512.0f, 426.0f, 426.0f, 512.0f, 320.0f, 512.0f)
                curveTo(254.8f, 512.0f, 197.1f, 479.5f, 162.4f, 429.7f)
                curveTo(152.3f, 415.2f, 132.3f, 411.7f, 117.8f, 421.8f)
                curveTo(103.3f, 431.9f, 99.8f, 451.9f, 109.9f, 466.4f)
                curveTo(156.1f, 532.6f, 233.0f, 576.0f, 320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(234.3f, 64.0f, 158.5f, 106.1f, 112.0f, 170.7f)
                lineTo(112.0f, 144.0f)
                curveTo(112.0f, 126.3f, 97.7f, 112.0f, 80.0f, 112.0f)
                curveTo(62.3f, 112.0f, 48.0f, 126.3f, 48.0f, 144.0f)
                lineTo(48.0f, 256.0f)
                curveTo(48.0f, 273.7f, 62.3f, 288.0f, 80.0f, 288.0f)
                lineTo(104.6f, 288.0f)
                curveTo(105.1f, 288.0f, 105.6f, 288.0f, 106.1f, 288.0f)
                lineTo(192.1f, 288.0f)
                curveTo(209.8f, 288.0f, 224.1f, 273.7f, 224.1f, 256.0f)
                curveTo(224.1f, 238.3f, 209.8f, 224.0f, 192.1f, 224.0f)
                lineTo(153.8f, 224.0f)
                curveTo(186.9f, 166.6f, 249.0f, 128.0f, 320.0f, 128.0f)
                close()
                moveTo(344.0f, 216.0f)
                curveTo(344.0f, 202.7f, 333.3f, 192.0f, 320.0f, 192.0f)
                curveTo(306.7f, 192.0f, 296.0f, 202.7f, 296.0f, 216.0f)
                lineTo(296.0f, 320.0f)
                curveTo(296.0f, 326.4f, 298.5f, 332.5f, 303.0f, 337.0f)
                lineTo(375.0f, 409.0f)
                curveTo(384.4f, 418.4f, 399.6f, 418.4f, 408.9f, 409.0f)
                curveTo(418.2f, 399.6f, 418.3f, 384.4f, 408.9f, 375.1f)
                lineTo(343.9f, 310.1f)
                lineTo(343.9f, 216.0f)
                close()
            }
        }
        .build()
        return `_clock-rotate-left`!!
    }

private var `_clock-rotate-left`: ImageVector? = null
