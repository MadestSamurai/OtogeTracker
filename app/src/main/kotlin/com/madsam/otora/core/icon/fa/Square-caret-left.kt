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

public val Fa.`Square-caret-left`: ImageVector
    get() {
        if (`_square-caret-left` != null) {
            return `_square-caret-left`!!
        }
        `_square-caret-left` = Builder(name = "Square-caret-left", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                close()
                moveTo(224.0f, 320.0f)
                curveTo(224.0f, 313.3f, 226.8f, 307.0f, 231.7f, 302.4f)
                lineTo(343.7f, 198.4f)
                curveTo(350.7f, 191.9f, 360.9f, 190.2f, 369.6f, 194.0f)
                curveTo(378.3f, 197.8f, 384.0f, 206.5f, 384.0f, 216.0f)
                lineTo(384.0f, 424.0f)
                curveTo(384.0f, 433.5f, 378.3f, 442.2f, 369.6f, 446.0f)
                curveTo(360.9f, 449.8f, 350.7f, 448.1f, 343.7f, 441.6f)
                lineTo(231.7f, 337.6f)
                curveTo(226.8f, 333.1f, 224.0f, 326.7f, 224.0f, 320.0f)
                close()
            }
        }
        .build()
        return `_square-caret-left`!!
    }

private var `_square-caret-left`: ImageVector? = null
