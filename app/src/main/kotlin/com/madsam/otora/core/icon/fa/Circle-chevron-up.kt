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

public val Fa.`Circle-chevron-up`: ImageVector
    get() {
        if (`_circle-chevron-up` != null) {
            return `_circle-chevron-up`!!
        }
        `_circle-chevron-up` = Builder(name = "Circle-chevron-up", defaultWidth = 640.0.dp,
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
                moveTo(441.0f, 335.0f)
                curveTo(450.4f, 344.4f, 450.4f, 359.6f, 441.0f, 368.9f)
                curveTo(431.6f, 378.2f, 416.4f, 378.3f, 407.1f, 368.9f)
                lineTo(320.1f, 281.9f)
                lineTo(233.1f, 368.9f)
                curveTo(223.7f, 378.3f, 208.5f, 378.3f, 199.2f, 368.9f)
                curveTo(189.9f, 359.5f, 189.8f, 344.3f, 199.2f, 335.0f)
                lineTo(303.0f, 231.0f)
                curveTo(312.4f, 221.6f, 327.6f, 221.6f, 336.9f, 231.0f)
                lineTo(441.0f, 335.0f)
                close()
            }
        }
        .build()
        return `_circle-chevron-up`!!
    }

private var `_circle-chevron-up`: ImageVector? = null
