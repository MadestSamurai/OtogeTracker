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

public val Fa.`Arrows-up-to-line`: ImageVector
    get() {
        if (`_arrows-up-to-line` != null) {
            return `_arrows-up-to-line`!!
        }
        `_arrows-up-to-line` = Builder(name = "Arrows-up-to-line", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 64.0f)
                curveTo(110.3f, 64.0f, 96.0f, 78.3f, 96.0f, 96.0f)
                curveTo(96.0f, 113.7f, 110.3f, 128.0f, 128.0f, 128.0f)
                lineTo(512.0f, 128.0f)
                curveTo(529.7f, 128.0f, 544.0f, 113.7f, 544.0f, 96.0f)
                curveTo(544.0f, 78.3f, 529.7f, 64.0f, 512.0f, 64.0f)
                lineTo(128.0f, 64.0f)
                close()
                moveTo(214.6f, 201.4f)
                curveTo(202.1f, 188.9f, 181.8f, 188.9f, 169.3f, 201.4f)
                lineTo(105.3f, 265.4f)
                curveTo(92.8f, 277.9f, 92.8f, 298.2f, 105.3f, 310.7f)
                curveTo(117.8f, 323.2f, 138.1f, 323.2f, 150.6f, 310.7f)
                lineTo(160.0f, 301.3f)
                lineTo(160.0f, 544.0f)
                curveTo(160.0f, 561.7f, 174.3f, 576.0f, 192.0f, 576.0f)
                curveTo(209.7f, 576.0f, 224.0f, 561.7f, 224.0f, 544.0f)
                lineTo(224.0f, 301.3f)
                lineTo(233.4f, 310.7f)
                curveTo(245.9f, 323.2f, 266.2f, 323.2f, 278.7f, 310.7f)
                curveTo(291.2f, 298.2f, 291.2f, 277.9f, 278.7f, 265.4f)
                lineTo(214.7f, 201.4f)
                close()
                moveTo(470.6f, 201.4f)
                curveTo(458.1f, 188.9f, 437.8f, 188.9f, 425.3f, 201.4f)
                lineTo(361.3f, 265.4f)
                curveTo(348.8f, 277.9f, 348.8f, 298.2f, 361.3f, 310.7f)
                curveTo(373.8f, 323.2f, 394.1f, 323.2f, 406.6f, 310.7f)
                lineTo(416.0f, 301.3f)
                lineTo(416.0f, 544.0f)
                curveTo(416.0f, 561.7f, 430.3f, 576.0f, 448.0f, 576.0f)
                curveTo(465.7f, 576.0f, 480.0f, 561.7f, 480.0f, 544.0f)
                lineTo(480.0f, 301.3f)
                lineTo(489.4f, 310.7f)
                curveTo(501.9f, 323.2f, 522.2f, 323.2f, 534.7f, 310.7f)
                curveTo(547.2f, 298.2f, 547.2f, 277.9f, 534.7f, 265.4f)
                lineTo(470.7f, 201.4f)
                close()
            }
        }
        .build()
        return `_arrows-up-to-line`!!
    }

private var `_arrows-up-to-line`: ImageVector? = null
