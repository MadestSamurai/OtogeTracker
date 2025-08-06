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

public val Fa.`Arrows-alt-h`: ImageVector
    get() {
        if (`_arrows-alt-h` != null) {
            return `_arrows-alt-h`!!
        }
        `_arrows-alt-h` = Builder(name = "Arrows-alt-h", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(566.6f, 470.6f)
                lineTo(470.6f, 566.6f)
                curveTo(461.4f, 575.8f, 447.7f, 578.5f, 435.7f, 573.5f)
                curveTo(423.7f, 568.5f, 416.0f, 556.9f, 416.0f, 544.0f)
                lineTo(416.0f, 480.0f)
                lineTo(96.0f, 480.0f)
                curveTo(78.3f, 480.0f, 64.0f, 465.7f, 64.0f, 448.0f)
                curveTo(64.0f, 430.3f, 78.3f, 416.0f, 96.0f, 416.0f)
                lineTo(416.0f, 416.0f)
                lineTo(416.0f, 352.0f)
                curveTo(416.0f, 339.1f, 423.8f, 327.4f, 435.8f, 322.4f)
                curveTo(447.8f, 317.4f, 461.5f, 320.2f, 470.7f, 329.3f)
                lineTo(566.7f, 425.3f)
                curveTo(579.2f, 437.8f, 579.2f, 458.1f, 566.7f, 470.6f)
                close()
                moveTo(73.4f, 214.6f)
                curveTo(60.9f, 202.1f, 60.9f, 181.8f, 73.4f, 169.3f)
                lineTo(169.4f, 73.3f)
                curveTo(178.6f, 64.1f, 192.3f, 61.4f, 204.3f, 66.4f)
                curveTo(216.3f, 71.4f, 224.0f, 83.1f, 224.0f, 96.0f)
                lineTo(224.0f, 160.0f)
                lineTo(544.0f, 160.0f)
                curveTo(561.7f, 160.0f, 576.0f, 174.3f, 576.0f, 192.0f)
                curveTo(576.0f, 209.7f, 561.7f, 224.0f, 544.0f, 224.0f)
                lineTo(224.0f, 224.0f)
                lineTo(224.0f, 288.0f)
                curveTo(224.0f, 300.9f, 216.2f, 312.6f, 204.2f, 317.6f)
                curveTo(192.2f, 322.6f, 178.5f, 319.8f, 169.3f, 310.7f)
                lineTo(73.3f, 214.7f)
                close()
            }
        }
        .build()
        return `_arrows-alt-h`!!
    }

private var `_arrows-alt-h`: ImageVector? = null
