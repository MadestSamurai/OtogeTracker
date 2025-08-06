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

public val Fa.`Dice-d6`: ImageVector
    get() {
        if (`_dice-d6` != null) {
            return `_dice-d6`!!
        }
        `_dice-d6` = Builder(name = "Dice-d6", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.4f, 72.3f)
                curveTo(308.0f, 61.2f, 332.0f, 61.2f, 351.6f, 72.3f)
                lineTo(527.6f, 172.0f)
                curveTo(547.6f, 183.4f, 560.0f, 204.6f, 560.0f, 227.7f)
                lineTo(560.0f, 425.1f)
                curveTo(560.0f, 448.1f, 547.6f, 469.4f, 527.6f, 480.8f)
                lineTo(351.6f, 580.5f)
                curveTo(332.0f, 591.6f, 308.0f, 591.6f, 288.5f, 580.5f)
                lineTo(112.5f, 480.8f)
                curveTo(92.4f, 469.5f, 80.0f, 448.2f, 80.0f, 425.2f)
                lineTo(80.0f, 227.8f)
                curveTo(80.0f, 204.8f, 92.4f, 183.5f, 112.4f, 172.1f)
                lineTo(288.4f, 72.4f)
                close()
                moveTo(166.6f, 219.6f)
                curveTo(157.8f, 216.5f, 147.8f, 219.9f, 142.8f, 228.2f)
                curveTo(137.8f, 236.5f, 139.6f, 246.9f, 146.4f, 253.2f)
                lineTo(149.6f, 255.6f)
                lineTo(299.8f, 345.8f)
                lineTo(299.8f, 494.5f)
                curveTo(299.8f, 505.5f, 308.8f, 514.5f, 319.8f, 514.5f)
                curveTo(330.8f, 514.5f, 339.8f, 505.5f, 339.8f, 494.5f)
                lineTo(339.8f, 345.8f)
                lineTo(490.1f, 255.6f)
                curveTo(499.6f, 249.9f, 502.7f, 237.6f, 497.0f, 228.2f)
                curveTo(491.3f, 218.8f, 479.0f, 215.7f, 469.6f, 221.3f)
                lineTo(319.9f, 311.1f)
                lineTo(170.2f, 221.3f)
                lineTo(166.5f, 219.6f)
                close()
            }
        }
        .build()
        return `_dice-d6`!!
    }

private var `_dice-d6`: ImageVector? = null
