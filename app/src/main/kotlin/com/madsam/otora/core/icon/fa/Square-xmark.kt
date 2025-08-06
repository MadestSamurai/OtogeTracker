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

public val Fa.`Square-xmark`: ImageVector
    get() {
        if (`_square-xmark` != null) {
            return `_square-xmark`!!
        }
        `_square-xmark` = Builder(name = "Square-xmark", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(231.0f, 231.0f)
                curveTo(240.4f, 221.6f, 255.6f, 221.6f, 264.9f, 231.0f)
                lineTo(319.9f, 286.0f)
                lineTo(374.9f, 231.0f)
                curveTo(384.3f, 221.6f, 399.5f, 221.6f, 408.8f, 231.0f)
                curveTo(418.1f, 240.4f, 418.2f, 255.6f, 408.8f, 264.9f)
                lineTo(353.8f, 319.9f)
                lineTo(408.8f, 374.9f)
                curveTo(418.2f, 384.3f, 418.2f, 399.5f, 408.8f, 408.8f)
                curveTo(399.4f, 418.1f, 384.2f, 418.2f, 374.9f, 408.8f)
                lineTo(319.9f, 353.8f)
                lineTo(264.9f, 408.8f)
                curveTo(255.5f, 418.2f, 240.3f, 418.2f, 231.0f, 408.8f)
                curveTo(221.7f, 399.4f, 221.6f, 384.2f, 231.0f, 374.9f)
                lineTo(286.0f, 319.9f)
                lineTo(231.0f, 264.9f)
                curveTo(221.6f, 255.5f, 221.6f, 240.3f, 231.0f, 231.0f)
                close()
            }
        }
        .build()
        return `_square-xmark`!!
    }

private var `_square-xmark`: ImageVector? = null
