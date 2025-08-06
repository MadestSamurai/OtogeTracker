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

public val Fa.`Plus-square`: ImageVector
    get() {
        if (`_plus-square` != null) {
            return `_plus-square`!!
        }
        `_plus-square` = Builder(name = "Plus-square", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(296.0f, 408.0f)
                lineTo(296.0f, 344.0f)
                lineTo(232.0f, 344.0f)
                curveTo(218.7f, 344.0f, 208.0f, 333.3f, 208.0f, 320.0f)
                curveTo(208.0f, 306.7f, 218.7f, 296.0f, 232.0f, 296.0f)
                lineTo(296.0f, 296.0f)
                lineTo(296.0f, 232.0f)
                curveTo(296.0f, 218.7f, 306.7f, 208.0f, 320.0f, 208.0f)
                curveTo(333.3f, 208.0f, 344.0f, 218.7f, 344.0f, 232.0f)
                lineTo(344.0f, 296.0f)
                lineTo(408.0f, 296.0f)
                curveTo(421.3f, 296.0f, 432.0f, 306.7f, 432.0f, 320.0f)
                curveTo(432.0f, 333.3f, 421.3f, 344.0f, 408.0f, 344.0f)
                lineTo(344.0f, 344.0f)
                lineTo(344.0f, 408.0f)
                curveTo(344.0f, 421.3f, 333.3f, 432.0f, 320.0f, 432.0f)
                curveTo(306.7f, 432.0f, 296.0f, 421.3f, 296.0f, 408.0f)
                close()
            }
        }
        .build()
        return `_plus-square`!!
    }

private var `_plus-square`: ImageVector? = null
