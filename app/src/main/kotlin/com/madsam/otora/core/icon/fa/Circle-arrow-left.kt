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

public val Fa.`Circle-arrow-left`: ImageVector
    get() {
        if (`_circle-arrow-left` != null) {
            return `_circle-arrow-left`!!
        }
        `_circle-arrow-left` = Builder(name = "Circle-arrow-left", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(199.0f, 303.0f)
                lineTo(279.0f, 223.0f)
                curveTo(288.4f, 213.6f, 303.6f, 213.6f, 312.9f, 223.0f)
                curveTo(322.2f, 232.4f, 322.3f, 247.6f, 312.9f, 256.9f)
                lineTo(273.9f, 295.9f)
                lineTo(424.0f, 295.9f)
                curveTo(437.3f, 295.9f, 448.0f, 306.6f, 448.0f, 319.9f)
                curveTo(448.0f, 333.2f, 437.3f, 343.9f, 424.0f, 343.9f)
                lineTo(273.9f, 343.9f)
                lineTo(312.9f, 382.9f)
                curveTo(322.3f, 392.3f, 322.3f, 407.5f, 312.9f, 416.8f)
                curveTo(303.5f, 426.1f, 288.3f, 426.2f, 279.0f, 416.8f)
                lineTo(199.0f, 336.8f)
                curveTo(189.6f, 327.4f, 189.6f, 312.2f, 199.0f, 302.9f)
                close()
            }
        }
        .build()
        return `_circle-arrow-left`!!
    }

private var `_circle-arrow-left`: ImageVector? = null
