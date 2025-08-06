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

public val Fa.`Caret-square-down`: ImageVector
    get() {
        if (`_caret-square-down` != null) {
            return `_caret-square-down`!!
        }
        `_caret-square-down` = Builder(name = "Caret-square-down", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                close()
                moveTo(320.0f, 416.0f)
                curveTo(313.3f, 416.0f, 307.0f, 413.2f, 302.4f, 408.3f)
                lineTo(198.4f, 296.3f)
                curveTo(191.9f, 289.3f, 190.2f, 279.1f, 194.0f, 270.4f)
                curveTo(197.8f, 261.7f, 206.5f, 256.0f, 216.0f, 256.0f)
                lineTo(424.0f, 256.0f)
                curveTo(433.5f, 256.0f, 442.2f, 261.7f, 446.0f, 270.4f)
                curveTo(449.8f, 279.1f, 448.1f, 289.3f, 441.6f, 296.3f)
                lineTo(337.6f, 408.3f)
                curveTo(333.1f, 413.2f, 326.7f, 416.0f, 320.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_caret-square-down`!!
    }

private var `_caret-square-down`: ImageVector? = null
