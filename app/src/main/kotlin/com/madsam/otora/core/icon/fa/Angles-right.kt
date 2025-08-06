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

public val Fa.`Angles-right`: ImageVector
    get() {
        if (`_angles-right` != null) {
            return `_angles-right`!!
        }
        `_angles-right` = Builder(name = "Angles-right", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(535.1f, 342.6f)
                curveTo(547.6f, 330.1f, 547.6f, 309.8f, 535.1f, 297.3f)
                lineTo(375.1f, 137.3f)
                curveTo(362.6f, 124.8f, 342.3f, 124.8f, 329.8f, 137.3f)
                curveTo(317.3f, 149.8f, 317.3f, 170.1f, 329.8f, 182.6f)
                lineTo(467.2f, 320.0f)
                lineTo(329.9f, 457.4f)
                curveTo(317.4f, 469.9f, 317.4f, 490.2f, 329.9f, 502.7f)
                curveTo(342.4f, 515.2f, 362.7f, 515.2f, 375.2f, 502.7f)
                lineTo(535.2f, 342.7f)
                close()
                moveTo(183.1f, 502.6f)
                lineTo(343.1f, 342.6f)
                curveTo(355.6f, 330.1f, 355.6f, 309.8f, 343.1f, 297.3f)
                lineTo(183.1f, 137.3f)
                curveTo(170.6f, 124.8f, 150.3f, 124.8f, 137.8f, 137.3f)
                curveTo(125.3f, 149.8f, 125.3f, 170.1f, 137.8f, 182.6f)
                lineTo(275.2f, 320.0f)
                lineTo(137.9f, 457.4f)
                curveTo(125.4f, 469.9f, 125.4f, 490.2f, 137.9f, 502.7f)
                curveTo(150.4f, 515.2f, 170.7f, 515.2f, 183.2f, 502.7f)
                close()
            }
        }
        .build()
        return `_angles-right`!!
    }

private var `_angles-right`: ImageVector? = null
