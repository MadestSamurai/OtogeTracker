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

public val Fa.`Chevron-down`: ImageVector
    get() {
        if (`_chevron-down` != null) {
            return `_chevron-down`!!
        }
        `_chevron-down` = Builder(name = "Chevron-down", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(297.4f, 470.6f)
                curveTo(309.9f, 483.1f, 330.2f, 483.1f, 342.7f, 470.6f)
                lineTo(534.7f, 278.6f)
                curveTo(547.2f, 266.1f, 547.2f, 245.8f, 534.7f, 233.3f)
                curveTo(522.2f, 220.8f, 501.9f, 220.8f, 489.4f, 233.3f)
                lineTo(320.0f, 402.7f)
                lineTo(150.6f, 233.4f)
                curveTo(138.1f, 220.9f, 117.8f, 220.9f, 105.3f, 233.4f)
                curveTo(92.8f, 245.9f, 92.8f, 266.2f, 105.3f, 278.7f)
                lineTo(297.3f, 470.7f)
                close()
            }
        }
        .build()
        return `_chevron-down`!!
    }

private var `_chevron-down`: ImageVector? = null
