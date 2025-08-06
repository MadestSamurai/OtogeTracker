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

public val Fa.`Chevron-right`: ImageVector
    get() {
        if (`_chevron-right` != null) {
            return `_chevron-right`!!
        }
        `_chevron-right` = Builder(name = "Chevron-right", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(471.1f, 297.4f)
                curveTo(483.6f, 309.9f, 483.6f, 330.2f, 471.1f, 342.7f)
                lineTo(279.1f, 534.7f)
                curveTo(266.6f, 547.2f, 246.3f, 547.2f, 233.8f, 534.7f)
                curveTo(221.3f, 522.2f, 221.3f, 501.9f, 233.8f, 489.4f)
                lineTo(403.2f, 320.0f)
                lineTo(233.9f, 150.6f)
                curveTo(221.4f, 138.1f, 221.4f, 117.8f, 233.9f, 105.3f)
                curveTo(246.4f, 92.8f, 266.7f, 92.8f, 279.2f, 105.3f)
                lineTo(471.2f, 297.3f)
                close()
            }
        }
        .build()
        return `_chevron-right`!!
    }

private var `_chevron-right`: ImageVector? = null
