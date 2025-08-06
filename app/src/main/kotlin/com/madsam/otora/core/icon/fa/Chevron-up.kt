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

public val Fa.`Chevron-up`: ImageVector
    get() {
        if (`_chevron-up` != null) {
            return `_chevron-up`!!
        }
        `_chevron-up` = Builder(name = "Chevron-up", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 169.4f)
                curveTo(309.9f, 156.9f, 330.2f, 156.9f, 342.7f, 169.4f)
                lineTo(534.7f, 361.4f)
                curveTo(547.2f, 373.9f, 547.2f, 394.2f, 534.7f, 406.7f)
                curveTo(522.2f, 419.2f, 501.9f, 419.2f, 489.4f, 406.7f)
                lineTo(320.0f, 237.3f)
                lineTo(150.6f, 406.6f)
                curveTo(138.1f, 419.1f, 117.8f, 419.1f, 105.3f, 406.6f)
                curveTo(92.8f, 394.1f, 92.8f, 373.8f, 105.3f, 361.3f)
                lineTo(297.3f, 169.3f)
                close()
            }
        }
        .build()
        return `_chevron-up`!!
    }

private var `_chevron-up`: ImageVector? = null
