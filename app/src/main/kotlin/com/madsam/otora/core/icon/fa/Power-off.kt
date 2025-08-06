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

public val Fa.`Power-off`: ImageVector
    get() {
        if (`_power-off` != null) {
            return `_power-off`!!
        }
        `_power-off` = Builder(name = "Power-off", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 64.0f)
                curveTo(352.0f, 46.3f, 337.7f, 32.0f, 320.0f, 32.0f)
                curveTo(302.3f, 32.0f, 288.0f, 46.3f, 288.0f, 64.0f)
                lineTo(288.0f, 320.0f)
                curveTo(288.0f, 337.7f, 302.3f, 352.0f, 320.0f, 352.0f)
                curveTo(337.7f, 352.0f, 352.0f, 337.7f, 352.0f, 320.0f)
                lineTo(352.0f, 64.0f)
                close()
                moveTo(210.3f, 162.4f)
                curveTo(224.8f, 152.3f, 228.3f, 132.3f, 218.2f, 117.8f)
                curveTo(208.1f, 103.3f, 188.1f, 99.8f, 173.6f, 109.9f)
                curveTo(107.4f, 156.1f, 64.0f, 233.0f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 233.0f, 532.6f, 156.1f, 466.3f, 109.9f)
                curveTo(451.8f, 99.8f, 431.9f, 103.3f, 421.7f, 117.8f)
                curveTo(411.5f, 132.3f, 415.1f, 152.2f, 429.6f, 162.4f)
                curveTo(479.4f, 197.2f, 511.9f, 254.8f, 511.9f, 320.0f)
                curveTo(511.9f, 426.0f, 425.9f, 512.0f, 319.9f, 512.0f)
                curveTo(213.9f, 512.0f, 128.0f, 426.0f, 128.0f, 320.0f)
                curveTo(128.0f, 254.8f, 160.5f, 197.1f, 210.3f, 162.4f)
                close()
            }
        }
        .build()
        return `_power-off`!!
    }

private var `_power-off`: ImageVector? = null
