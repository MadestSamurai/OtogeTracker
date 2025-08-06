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

public val Fa.`Arrows-split-up-and-left`: ImageVector
    get() {
        if (`_arrows-split-up-and-left` != null) {
            return `_arrows-split-up-and-left`!!
        }
        `_arrows-split-up-and-left` = Builder(name = "Arrows-split-up-and-left", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(406.6f, 41.4f)
                curveTo(394.1f, 28.9f, 373.8f, 28.9f, 361.3f, 41.4f)
                lineTo(265.3f, 137.4f)
                curveTo(252.8f, 149.9f, 252.8f, 170.2f, 265.3f, 182.7f)
                curveTo(277.8f, 195.2f, 298.1f, 195.2f, 310.6f, 182.7f)
                lineTo(352.0f, 141.3f)
                lineTo(352.0f, 337.2f)
                curveTo(333.2f, 326.3f, 311.3f, 320.1f, 288.0f, 320.1f)
                lineTo(173.3f, 320.1f)
                lineTo(214.7f, 278.7f)
                curveTo(227.2f, 266.2f, 227.2f, 245.9f, 214.7f, 233.4f)
                curveTo(202.2f, 220.9f, 181.9f, 220.9f, 169.4f, 233.4f)
                lineTo(73.4f, 329.4f)
                curveTo(60.9f, 341.9f, 60.9f, 362.2f, 73.4f, 374.7f)
                lineTo(169.4f, 470.7f)
                curveTo(181.9f, 483.2f, 202.2f, 483.2f, 214.7f, 470.7f)
                curveTo(227.2f, 458.2f, 227.2f, 437.9f, 214.7f, 425.4f)
                lineTo(173.3f, 384.0f)
                lineTo(288.0f, 384.0f)
                curveTo(323.3f, 384.0f, 352.0f, 412.7f, 352.0f, 448.0f)
                curveTo(352.0f, 518.7f, 409.3f, 576.0f, 480.0f, 576.0f)
                lineTo(512.0f, 576.0f)
                curveTo(529.7f, 576.0f, 544.0f, 561.7f, 544.0f, 544.0f)
                curveTo(544.0f, 526.3f, 529.7f, 512.0f, 512.0f, 512.0f)
                lineTo(480.0f, 512.0f)
                curveTo(444.7f, 512.0f, 416.0f, 483.3f, 416.0f, 448.0f)
                lineTo(416.0f, 141.3f)
                lineTo(457.4f, 182.7f)
                curveTo(469.9f, 195.2f, 490.2f, 195.2f, 502.7f, 182.7f)
                curveTo(515.2f, 170.2f, 515.2f, 149.9f, 502.7f, 137.4f)
                lineTo(406.7f, 41.4f)
                close()
            }
        }
        .build()
        return `_arrows-split-up-and-left`!!
    }

private var `_arrows-split-up-and-left`: ImageVector? = null
