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

public val Fa.`Minus-circle`: ImageVector
    get() {
        if (`_minus-circle` != null) {
            return `_minus-circle`!!
        }
        `_minus-circle` = Builder(name = "Minus-circle", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(232.0f, 296.0f)
                lineTo(408.0f, 296.0f)
                curveTo(421.3f, 296.0f, 432.0f, 306.7f, 432.0f, 320.0f)
                curveTo(432.0f, 333.3f, 421.3f, 344.0f, 408.0f, 344.0f)
                lineTo(232.0f, 344.0f)
                curveTo(218.7f, 344.0f, 208.0f, 333.3f, 208.0f, 320.0f)
                curveTo(208.0f, 306.7f, 218.7f, 296.0f, 232.0f, 296.0f)
                close()
            }
        }
        .build()
        return `_minus-circle`!!
    }

private var `_minus-circle`: ImageVector? = null
