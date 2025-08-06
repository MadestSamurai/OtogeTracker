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

public val Fa.`Square-caret-right`: ImageVector
    get() {
        if (`_square-caret-right` != null) {
            return `_square-caret-right`!!
        }
        `_square-caret-right` = Builder(name = "Square-caret-right", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                close()
                moveTo(416.0f, 320.0f)
                curveTo(416.0f, 326.7f, 413.2f, 333.0f, 408.3f, 337.6f)
                lineTo(296.3f, 441.6f)
                curveTo(289.3f, 448.1f, 279.1f, 449.8f, 270.4f, 446.0f)
                curveTo(261.7f, 442.2f, 256.0f, 433.5f, 256.0f, 424.0f)
                lineTo(256.0f, 216.0f)
                curveTo(256.0f, 206.5f, 261.7f, 197.8f, 270.4f, 194.0f)
                curveTo(279.1f, 190.2f, 289.3f, 191.9f, 296.3f, 198.4f)
                lineTo(408.3f, 302.4f)
                curveTo(413.2f, 306.9f, 416.0f, 313.3f, 416.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_square-caret-right`!!
    }

private var `_square-caret-right`: ImageVector? = null
