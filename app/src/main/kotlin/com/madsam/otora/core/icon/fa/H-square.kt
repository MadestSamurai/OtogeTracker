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

public val Fa.`H-square`: ImageVector
    get() {
        if (`_h-square` != null) {
            return `_h-square`!!
        }
        `_h-square` = Builder(name = "H-square", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(416.0f, 232.0f)
                lineTo(416.0f, 408.0f)
                curveTo(416.0f, 421.3f, 405.3f, 432.0f, 392.0f, 432.0f)
                curveTo(378.7f, 432.0f, 368.0f, 421.3f, 368.0f, 408.0f)
                lineTo(368.0f, 344.0f)
                lineTo(272.0f, 344.0f)
                lineTo(272.0f, 408.0f)
                curveTo(272.0f, 421.3f, 261.3f, 432.0f, 248.0f, 432.0f)
                curveTo(234.7f, 432.0f, 224.0f, 421.3f, 224.0f, 408.0f)
                lineTo(224.0f, 232.0f)
                curveTo(224.0f, 218.7f, 234.7f, 208.0f, 248.0f, 208.0f)
                curveTo(261.3f, 208.0f, 272.0f, 218.7f, 272.0f, 232.0f)
                lineTo(272.0f, 296.0f)
                lineTo(368.0f, 296.0f)
                lineTo(368.0f, 232.0f)
                curveTo(368.0f, 218.7f, 378.7f, 208.0f, 392.0f, 208.0f)
                curveTo(405.3f, 208.0f, 416.0f, 218.7f, 416.0f, 232.0f)
                close()
            }
        }
        .build()
        return `_h-square`!!
    }

private var `_h-square`: ImageVector? = null
