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

public val Fa.`Arrows-v`: ImageVector
    get() {
        if (`_arrows-v` != null) {
            return `_arrows-v`!!
        }
        `_arrows-v` = Builder(name = "Arrows-v", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(342.6f, 41.4f)
                curveTo(330.1f, 28.9f, 309.8f, 28.9f, 297.3f, 41.4f)
                lineTo(201.3f, 137.4f)
                curveTo(188.8f, 149.9f, 188.8f, 170.2f, 201.3f, 182.7f)
                curveTo(213.8f, 195.2f, 234.1f, 195.2f, 246.6f, 182.7f)
                lineTo(288.0f, 141.3f)
                lineTo(288.0f, 498.7f)
                lineTo(246.6f, 457.4f)
                curveTo(234.1f, 444.9f, 213.8f, 444.9f, 201.3f, 457.4f)
                curveTo(188.8f, 469.9f, 188.8f, 490.2f, 201.3f, 502.7f)
                lineTo(297.3f, 598.7f)
                curveTo(303.3f, 604.7f, 311.4f, 608.1f, 319.9f, 608.1f)
                curveTo(328.4f, 608.1f, 336.5f, 604.7f, 342.5f, 598.7f)
                lineTo(438.5f, 502.7f)
                curveTo(451.0f, 490.2f, 451.0f, 469.9f, 438.5f, 457.4f)
                curveTo(426.0f, 444.9f, 405.7f, 444.9f, 393.2f, 457.4f)
                lineTo(351.8f, 498.8f)
                lineTo(351.8f, 141.3f)
                lineTo(393.2f, 182.7f)
                curveTo(405.7f, 195.2f, 426.0f, 195.2f, 438.5f, 182.7f)
                curveTo(451.0f, 170.2f, 451.0f, 149.9f, 438.5f, 137.4f)
                lineTo(342.5f, 41.4f)
                close()
            }
        }
        .build()
        return `_arrows-v`!!
    }

private var `_arrows-v`: ImageVector? = null
