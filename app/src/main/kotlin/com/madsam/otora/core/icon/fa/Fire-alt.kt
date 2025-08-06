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

public val Fa.`Fire-alt`: ImageVector
    get() {
        if (`_fire-alt` != null) {
            return `_fire-alt`!!
        }
        `_fire-alt` = Builder(name = "Fire-alt", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(281.6f, 93.9f)
                lineTo(297.6f, 72.6f)
                curveTo(301.6f, 67.2f, 308.0f, 64.0f, 314.7f, 64.0f)
                curveTo(326.4f, 64.0f, 336.0f, 73.6f, 336.0f, 85.3f)
                lineTo(336.0f, 107.4f)
                curveTo(336.0f, 120.5f, 341.4f, 133.1f, 350.9f, 142.1f)
                lineTo(435.6f, 223.0f)
                curveTo(484.4f, 269.6f, 512.0f, 334.2f, 512.0f, 401.7f)
                curveTo(512.0f, 498.0f, 434.0f, 576.0f, 337.7f, 576.0f)
                lineTo(320.0f, 576.0f)
                curveTo(214.0f, 576.0f, 128.0f, 490.0f, 128.0f, 384.0f)
                lineTo(128.0f, 380.2f)
                curveTo(128.0f, 331.4f, 147.4f, 284.6f, 181.9f, 250.1f)
                lineTo(185.4f, 246.6f)
                curveTo(189.6f, 242.4f, 195.4f, 240.0f, 201.4f, 240.0f)
                curveTo(213.9f, 240.0f, 224.0f, 250.1f, 224.0f, 262.6f)
                lineTo(224.0f, 352.0f)
                curveTo(224.0f, 387.3f, 252.7f, 416.0f, 288.0f, 416.0f)
                curveTo(323.3f, 416.0f, 352.0f, 387.3f, 352.0f, 352.0f)
                lineTo(352.0f, 348.1f)
                curveTo(352.0f, 330.1f, 344.8f, 312.8f, 332.1f, 300.1f)
                lineTo(293.5f, 261.5f)
                curveTo(269.5f, 237.5f, 256.0f, 204.8f, 256.0f, 170.8f)
                curveTo(256.0f, 143.1f, 265.0f, 116.0f, 281.6f, 93.9f)
                close()
            }
        }
        .build()
        return `_fire-alt`!!
    }

private var `_fire-alt`: ImageVector? = null
