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

public val Fa.`Space-shuttle`: ImageVector
    get() {
        if (`_space-shuttle` != null) {
            return `_space-shuttle`!!
        }
        `_space-shuttle` = Builder(name = "Space-shuttle", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(32.0f, 432.0f)
                lineTo(32.0f, 496.0f)
                curveTo(32.0f, 522.5f, 53.5f, 544.0f, 80.0f, 544.0f)
                lineTo(130.0f, 544.0f)
                curveTo(170.6f, 544.0f, 210.4f, 533.0f, 245.2f, 512.1f)
                lineTo(378.7f, 432.0f)
                lineTo(285.4f, 432.0f)
                lineTo(220.5f, 470.9f)
                curveTo(206.5f, 479.3f, 191.6f, 485.6f, 176.0f, 489.9f)
                lineTo(176.0f, 423.5f)
                curveTo(185.7f, 417.9f, 193.8f, 409.8f, 199.4f, 400.1f)
                lineTo(398.2f, 400.1f)
                curveTo(465.3f, 400.1f, 526.0f, 379.5f, 568.5f, 329.5f)
                curveTo(573.1f, 324.1f, 573.1f, 316.2f, 568.5f, 310.7f)
                curveTo(526.0f, 260.6f, 465.3f, 240.1f, 398.2f, 240.1f)
                lineTo(199.4f, 240.1f)
                curveTo(193.8f, 230.4f, 185.7f, 222.3f, 176.0f, 216.7f)
                lineTo(176.0f, 150.3f)
                curveTo(191.6f, 154.5f, 206.6f, 160.9f, 220.5f, 169.3f)
                lineTo(285.4f, 208.2f)
                lineTo(378.7f, 208.2f)
                lineTo(245.2f, 128.1f)
                curveTo(210.4f, 107.0f, 170.6f, 96.0f, 130.0f, 96.0f)
                lineTo(80.0f, 96.0f)
                curveTo(53.5f, 96.0f, 32.0f, 117.5f, 32.0f, 144.0f)
                lineTo(32.0f, 432.0f)
                close()
                moveTo(128.0f, 432.0f)
                lineTo(128.0f, 496.0f)
                lineTo(80.0f, 496.0f)
                lineTo(80.0f, 432.0f)
                lineTo(128.0f, 432.0f)
                close()
                moveTo(128.0f, 144.0f)
                lineTo(128.0f, 208.0f)
                lineTo(80.0f, 208.0f)
                lineTo(80.0f, 144.0f)
                lineTo(128.0f, 144.0f)
                close()
                moveTo(448.0f, 288.0f)
                curveTo(456.8f, 288.0f, 464.0f, 295.2f, 464.0f, 304.0f)
                lineTo(464.0f, 336.0f)
                curveTo(464.0f, 344.8f, 456.8f, 352.0f, 448.0f, 352.0f)
                curveTo(439.2f, 352.0f, 432.0f, 344.8f, 432.0f, 336.0f)
                lineTo(432.0f, 304.0f)
                curveTo(432.0f, 295.2f, 439.2f, 288.0f, 448.0f, 288.0f)
                close()
            }
        }
        .build()
        return `_space-shuttle`!!
    }

private var `_space-shuttle`: ImageVector? = null
