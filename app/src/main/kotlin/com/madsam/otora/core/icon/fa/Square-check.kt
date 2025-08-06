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

public val Fa.`Square-check`: ImageVector
    get() {
        if (`_square-check` != null) {
            return `_square-check`!!
        }
        `_square-check` = Builder(name = "Square-check", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 96.0f)
                curveTo(124.7f, 96.0f, 96.0f, 124.7f, 96.0f, 160.0f)
                lineTo(96.0f, 480.0f)
                curveTo(96.0f, 515.3f, 124.7f, 544.0f, 160.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(515.3f, 544.0f, 544.0f, 515.3f, 544.0f, 480.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 124.7f, 515.3f, 96.0f, 480.0f, 96.0f)
                lineTo(160.0f, 96.0f)
                close()
                moveTo(404.4f, 276.7f)
                lineTo(324.4f, 404.7f)
                curveTo(320.2f, 411.4f, 313.0f, 415.6f, 305.1f, 416.0f)
                curveTo(297.2f, 416.4f, 289.6f, 412.8f, 284.9f, 406.4f)
                lineTo(236.9f, 342.4f)
                curveTo(228.9f, 331.8f, 231.1f, 316.8f, 241.7f, 308.8f)
                curveTo(252.3f, 300.8f, 267.3f, 303.0f, 275.3f, 313.6f)
                lineTo(302.3f, 349.6f)
                lineTo(363.7f, 251.3f)
                curveTo(370.7f, 240.1f, 385.5f, 236.6f, 396.8f, 243.7f)
                curveTo(408.1f, 250.8f, 411.5f, 265.5f, 404.4f, 276.8f)
                close()
            }
        }
        .build()
        return `_square-check`!!
    }

private var `_square-check`: ImageVector? = null
