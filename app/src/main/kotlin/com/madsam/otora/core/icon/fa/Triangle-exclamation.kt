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

public val Fa.`Triangle-exclamation`: ImageVector
    get() {
        if (`_triangle-exclamation` != null) {
            return `_triangle-exclamation`!!
        }
        `_triangle-exclamation` = Builder(name = "Triangle-exclamation", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(334.7f, 64.0f, 348.2f, 72.1f, 355.2f, 85.0f)
                lineTo(571.2f, 485.0f)
                curveTo(577.9f, 497.4f, 577.6f, 512.4f, 570.4f, 524.5f)
                curveTo(563.2f, 536.6f, 550.1f, 544.0f, 536.0f, 544.0f)
                lineTo(104.0f, 544.0f)
                curveTo(89.9f, 544.0f, 76.9f, 536.6f, 69.6f, 524.5f)
                curveTo(62.3f, 512.4f, 62.1f, 497.4f, 68.8f, 485.0f)
                lineTo(284.8f, 85.0f)
                curveTo(291.8f, 72.1f, 305.3f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(320.0f, 232.0f)
                curveTo(306.7f, 232.0f, 296.0f, 242.7f, 296.0f, 256.0f)
                lineTo(296.0f, 368.0f)
                curveTo(296.0f, 381.3f, 306.7f, 392.0f, 320.0f, 392.0f)
                curveTo(333.3f, 392.0f, 344.0f, 381.3f, 344.0f, 368.0f)
                lineTo(344.0f, 256.0f)
                curveTo(344.0f, 242.7f, 333.3f, 232.0f, 320.0f, 232.0f)
                close()
                moveTo(346.7f, 448.0f)
                curveTo(347.3f, 438.1f, 342.4f, 428.7f, 333.9f, 423.5f)
                curveTo(325.4f, 418.4f, 314.7f, 418.4f, 306.2f, 423.5f)
                curveTo(297.7f, 428.7f, 292.8f, 438.1f, 293.4f, 448.0f)
                curveTo(292.8f, 457.9f, 297.7f, 467.3f, 306.2f, 472.5f)
                curveTo(314.7f, 477.6f, 325.4f, 477.6f, 333.9f, 472.5f)
                curveTo(342.4f, 467.3f, 347.3f, 457.9f, 346.7f, 448.0f)
                close()
            }
        }
        .build()
        return `_triangle-exclamation`!!
    }

private var `_triangle-exclamation`: ImageVector? = null
