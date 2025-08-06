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

public val Fa.`Circle-arrow-up`: ImageVector
    get() {
        if (`_circle-arrow-up` != null) {
            return `_circle-arrow-up`!!
        }
        `_circle-arrow-up` = Builder(name = "Circle-arrow-up", defaultWidth = 640.0.dp,
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
                moveTo(337.0f, 199.0f)
                lineTo(417.0f, 279.0f)
                curveTo(426.4f, 288.4f, 426.4f, 303.6f, 417.0f, 312.9f)
                curveTo(407.6f, 322.2f, 392.4f, 322.3f, 383.1f, 312.9f)
                lineTo(344.1f, 273.9f)
                lineTo(344.1f, 424.0f)
                curveTo(344.1f, 437.3f, 333.4f, 448.0f, 320.1f, 448.0f)
                curveTo(306.8f, 448.0f, 296.1f, 437.3f, 296.1f, 424.0f)
                lineTo(296.1f, 273.9f)
                lineTo(257.1f, 312.9f)
                curveTo(247.7f, 322.3f, 232.5f, 322.3f, 223.2f, 312.9f)
                curveTo(213.9f, 303.5f, 213.8f, 288.3f, 223.2f, 279.0f)
                lineTo(303.2f, 199.0f)
                curveTo(312.6f, 189.6f, 327.8f, 189.6f, 337.1f, 199.0f)
                close()
            }
        }
        .build()
        return `_circle-arrow-up`!!
    }

private var `_circle-arrow-up`: ImageVector? = null
