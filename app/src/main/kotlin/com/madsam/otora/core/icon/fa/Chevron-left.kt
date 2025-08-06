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

public val Fa.`Chevron-left`: ImageVector
    get() {
        if (`_chevron-left` != null) {
            return `_chevron-left`!!
        }
        `_chevron-left` = Builder(name = "Chevron-left", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(169.4f, 297.4f)
                curveTo(156.9f, 309.9f, 156.9f, 330.2f, 169.4f, 342.7f)
                lineTo(361.4f, 534.7f)
                curveTo(373.9f, 547.2f, 394.2f, 547.2f, 406.7f, 534.7f)
                curveTo(419.2f, 522.2f, 419.2f, 501.9f, 406.7f, 489.4f)
                lineTo(237.3f, 320.0f)
                lineTo(406.6f, 150.6f)
                curveTo(419.1f, 138.1f, 419.1f, 117.8f, 406.6f, 105.3f)
                curveTo(394.1f, 92.8f, 373.8f, 92.8f, 361.3f, 105.3f)
                lineTo(169.3f, 297.3f)
                close()
            }
        }
        .build()
        return `_chevron-left`!!
    }

private var `_chevron-left`: ImageVector? = null
