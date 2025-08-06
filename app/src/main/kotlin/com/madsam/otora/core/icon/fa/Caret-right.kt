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

public val Fa.`Caret-right`: ImageVector
    get() {
        if (`_caret-right` != null) {
            return `_caret-right`!!
        }
        `_caret-right` = Builder(name = "Caret-right", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(224.5f, 160.0f)
                curveTo(224.5f, 147.1f, 232.3f, 135.4f, 244.3f, 130.4f)
                curveTo(256.3f, 125.4f, 270.0f, 128.2f, 279.1f, 137.4f)
                lineTo(439.1f, 297.4f)
                curveTo(451.6f, 309.9f, 451.6f, 330.2f, 439.1f, 342.7f)
                lineTo(279.1f, 502.7f)
                curveTo(269.9f, 511.9f, 256.2f, 514.6f, 244.2f, 509.6f)
                curveTo(232.2f, 504.6f, 224.5f, 492.9f, 224.5f, 480.0f)
                lineTo(224.5f, 160.0f)
                close()
            }
        }
        .build()
        return `_caret-right`!!
    }

private var `_caret-right`: ImageVector? = null
