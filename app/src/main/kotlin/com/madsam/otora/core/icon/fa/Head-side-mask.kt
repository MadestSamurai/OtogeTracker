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

public val Fa.`Head-side-mask`: ImageVector
    get() {
        if (`_head-side-mask` != null) {
            return `_head-side-mask`!!
        }
        `_head-side-mask` = Builder(name = "Head-side-mask", defaultWidth = 640.0.dp, defaultHeight
                = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(509.9f, 257.0f)
                curveTo(509.8f, 256.6f, 509.7f, 256.1f, 509.7f, 255.7f)
                curveTo(494.0f, 147.3f, 400.8f, 64.0f, 288.0f, 64.0f)
                curveTo(203.0f, 64.0f, 129.0f, 111.4f, 91.1f, 181.2f)
                lineTo(347.3f, 352.0f)
                lineTo(520.0f, 352.0f)
                lineTo(506.9f, 400.0f)
                lineTo(400.0f, 400.0f)
                curveTo(391.2f, 400.0f, 384.0f, 407.2f, 384.0f, 416.0f)
                curveTo(384.0f, 424.8f, 391.2f, 432.0f, 400.0f, 432.0f)
                lineTo(498.2f, 432.0f)
                lineTo(489.5f, 464.0f)
                lineTo(400.0f, 464.0f)
                curveTo(391.2f, 464.0f, 384.0f, 471.2f, 384.0f, 480.0f)
                curveTo(384.0f, 488.8f, 391.2f, 496.0f, 400.0f, 496.0f)
                lineTo(480.6f, 496.0f)
                curveTo(473.9f, 515.1f, 455.8f, 528.0f, 435.3f, 528.0f)
                lineTo(352.0f, 528.0f)
                curveTo(334.3f, 528.0f, 320.0f, 513.7f, 320.0f, 496.0f)
                lineTo(320.0f, 391.5f)
                lineTo(72.5f, 226.5f)
                curveTo(67.0f, 246.1f, 64.0f, 266.7f, 64.0f, 288.0f)
                curveTo(64.0f, 342.0f, 83.1f, 391.5f, 114.9f, 430.2f)
                curveTo(122.9f, 439.9f, 128.0f, 451.8f, 128.0f, 464.4f)
                lineTo(128.0f, 528.0f)
                curveTo(128.0f, 554.5f, 149.5f, 576.0f, 176.0f, 576.0f)
                lineTo(303.3f, 576.0f)
                lineTo(304.0f, 576.0f)
                lineTo(435.3f, 576.0f)
                curveTo(480.2f, 576.0f, 519.1f, 544.9f, 528.9f, 501.1f)
                lineTo(562.8f, 350.8f)
                curveTo(566.1f, 336.4f, 562.5f, 321.3f, 553.1f, 309.8f)
                lineTo(509.9f, 257.0f)
                close()
                moveTo(352.0f, 256.0f)
                curveTo(352.0f, 238.3f, 366.3f, 224.0f, 384.0f, 224.0f)
                curveTo(401.7f, 224.0f, 416.0f, 238.3f, 416.0f, 256.0f)
                curveTo(416.0f, 273.7f, 401.7f, 288.0f, 384.0f, 288.0f)
                curveTo(366.3f, 288.0f, 352.0f, 273.7f, 352.0f, 256.0f)
                close()
            }
        }
        .build()
        return `_head-side-mask`!!
    }

private var `_head-side-mask`: ImageVector? = null
