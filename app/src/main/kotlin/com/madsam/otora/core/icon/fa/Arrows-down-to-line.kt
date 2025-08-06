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

public val Fa.`Arrows-down-to-line`: ImageVector
    get() {
        if (`_arrows-down-to-line` != null) {
            return `_arrows-down-to-line`!!
        }
        `_arrows-down-to-line` = Builder(name = "Arrows-down-to-line", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(278.6f, 374.6f)
                lineTo(214.6f, 438.6f)
                curveTo(202.1f, 451.1f, 181.8f, 451.1f, 169.3f, 438.6f)
                lineTo(105.3f, 374.6f)
                curveTo(92.8f, 362.1f, 92.8f, 341.8f, 105.3f, 329.3f)
                curveTo(117.8f, 316.8f, 138.1f, 316.8f, 150.6f, 329.3f)
                lineTo(160.0f, 338.7f)
                lineTo(160.0f, 96.0f)
                curveTo(160.0f, 78.3f, 174.3f, 64.0f, 192.0f, 64.0f)
                curveTo(209.7f, 64.0f, 224.0f, 78.3f, 224.0f, 96.0f)
                lineTo(224.0f, 338.7f)
                lineTo(233.4f, 329.3f)
                curveTo(245.9f, 316.8f, 266.2f, 316.8f, 278.7f, 329.3f)
                curveTo(291.2f, 341.8f, 291.2f, 362.1f, 278.7f, 374.6f)
                close()
                moveTo(534.6f, 374.6f)
                lineTo(470.6f, 438.6f)
                curveTo(458.1f, 451.1f, 437.8f, 451.1f, 425.3f, 438.6f)
                lineTo(361.3f, 374.6f)
                curveTo(348.8f, 362.1f, 348.8f, 341.8f, 361.3f, 329.3f)
                curveTo(373.8f, 316.8f, 394.1f, 316.8f, 406.6f, 329.3f)
                lineTo(416.0f, 338.7f)
                lineTo(416.0f, 96.0f)
                curveTo(416.0f, 78.3f, 430.3f, 64.0f, 448.0f, 64.0f)
                curveTo(465.7f, 64.0f, 480.0f, 78.3f, 480.0f, 96.0f)
                lineTo(480.0f, 338.7f)
                lineTo(489.4f, 329.3f)
                curveTo(501.9f, 316.8f, 522.2f, 316.8f, 534.7f, 329.3f)
                curveTo(547.2f, 341.8f, 547.2f, 362.1f, 534.7f, 374.6f)
                close()
                moveTo(96.0f, 576.0f)
                curveTo(78.3f, 576.0f, 64.0f, 561.7f, 64.0f, 544.0f)
                curveTo(64.0f, 526.3f, 78.3f, 512.0f, 96.0f, 512.0f)
                lineTo(544.0f, 512.0f)
                curveTo(561.7f, 512.0f, 576.0f, 526.3f, 576.0f, 544.0f)
                curveTo(576.0f, 561.7f, 561.7f, 576.0f, 544.0f, 576.0f)
                lineTo(96.0f, 576.0f)
                close()
            }
        }
        .build()
        return `_arrows-down-to-line`!!
    }

private var `_arrows-down-to-line`: ImageVector? = null
