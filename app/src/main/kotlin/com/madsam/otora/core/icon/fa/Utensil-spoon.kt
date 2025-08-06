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

public val Fa.`Utensil-spoon`: ImageVector
    get() {
        if (`_utensil-spoon` != null) {
            return `_utensil-spoon`!!
        }
        `_utensil-spoon` = Builder(name = "Utensil-spoon", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(309.8f, 284.9f)
                curveTo(295.3f, 267.3f, 288.0f, 245.7f, 288.0f, 224.1f)
                curveTo(288.0f, 143.9f, 384.0f, 63.9f, 480.0f, 63.9f)
                curveTo(533.0f, 63.9f, 576.0f, 106.9f, 576.0f, 159.9f)
                curveTo(576.0f, 255.9f, 496.0f, 351.9f, 415.8f, 351.9f)
                curveTo(394.2f, 351.9f, 372.6f, 344.6f, 355.0f, 330.1f)
                lineTo(118.6f, 566.6f)
                curveTo(106.1f, 579.1f, 85.8f, 579.1f, 73.3f, 566.6f)
                curveTo(60.8f, 554.1f, 60.8f, 533.8f, 73.3f, 521.3f)
                lineTo(309.8f, 284.9f)
                close()
            }
        }
        .build()
        return `_utensil-spoon`!!
    }

private var `_utensil-spoon`: ImageVector? = null
