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

public val Fa.`Caret-down`: ImageVector
    get() {
        if (`_caret-down` != null) {
            return `_caret-down`!!
        }
        `_caret-down` = Builder(name = "Caret-down", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 224.0f)
                curveTo(492.9f, 224.0f, 504.6f, 231.8f, 509.6f, 243.8f)
                curveTo(514.6f, 255.8f, 511.8f, 269.5f, 502.7f, 278.7f)
                lineTo(342.7f, 438.7f)
                curveTo(330.2f, 451.2f, 309.9f, 451.2f, 297.4f, 438.7f)
                lineTo(137.4f, 278.7f)
                curveTo(128.2f, 269.5f, 125.5f, 255.8f, 130.5f, 243.8f)
                curveTo(135.5f, 231.8f, 147.1f, 224.0f, 160.0f, 224.0f)
                lineTo(480.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_caret-down`!!
    }

private var `_caret-down`: ImageVector? = null
