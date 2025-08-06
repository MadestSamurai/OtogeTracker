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

public val Fa.`Box-tissue`: ImageVector
    get() {
        if (`_box-tissue` != null) {
            return `_box-tissue`!!
        }
        `_box-tissue` = Builder(name = "Box-tissue", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(167.9f, 96.0f)
                lineTo(328.9f, 96.0f)
                curveTo(342.7f, 96.0f, 354.9f, 104.8f, 359.3f, 117.9f)
                lineTo(376.7f, 170.1f)
                curveTo(381.1f, 183.2f, 393.3f, 192.0f, 407.1f, 192.0f)
                lineTo(467.6f, 192.0f)
                curveTo(489.4f, 192.0f, 504.9f, 213.4f, 498.0f, 234.1f)
                lineTo(448.0f, 384.0f)
                lineTo(192.0f, 384.0f)
                lineTo(136.7f, 134.9f)
                curveTo(132.2f, 115.0f, 147.4f, 96.0f, 167.9f, 96.0f)
                close()
                moveTo(112.0f, 320.0f)
                lineTo(128.6f, 320.0f)
                lineTo(145.1f, 394.4f)
                curveTo(150.0f, 416.4f, 169.5f, 432.0f, 192.0f, 432.0f)
                lineTo(448.0f, 432.0f)
                curveTo(468.7f, 432.0f, 487.0f, 418.8f, 493.5f, 399.2f)
                lineTo(519.9f, 320.0f)
                lineTo(528.0f, 320.0f)
                curveTo(554.5f, 320.0f, 576.0f, 341.5f, 576.0f, 368.0f)
                lineTo(576.0f, 496.0f)
                curveTo(576.0f, 522.5f, 554.5f, 544.0f, 528.0f, 544.0f)
                lineTo(112.0f, 544.0f)
                curveTo(85.5f, 544.0f, 64.0f, 522.5f, 64.0f, 496.0f)
                lineTo(64.0f, 368.0f)
                curveTo(64.0f, 341.5f, 85.5f, 320.0f, 112.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_box-tissue`!!
    }

private var `_box-tissue`: ImageVector? = null
