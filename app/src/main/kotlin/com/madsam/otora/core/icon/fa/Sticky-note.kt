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

public val Fa.`Sticky-note`: ImageVector
    get() {
        if (`_sticky-note` != null) {
            return `_sticky-note`!!
        }
        `_sticky-note` = Builder(name = "Sticky-note", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 544.0f)
                curveTo(124.7f, 544.0f, 96.0f, 515.3f, 96.0f, 480.0f)
                lineTo(96.0f, 160.0f)
                curveTo(96.0f, 124.7f, 124.7f, 96.0f, 160.0f, 96.0f)
                lineTo(480.0f, 96.0f)
                curveTo(515.3f, 96.0f, 544.0f, 124.7f, 544.0f, 160.0f)
                lineTo(544.0f, 373.5f)
                curveTo(544.0f, 390.5f, 537.3f, 406.8f, 525.3f, 418.8f)
                lineTo(418.7f, 525.3f)
                curveTo(406.7f, 537.3f, 390.4f, 544.0f, 373.4f, 544.0f)
                lineTo(160.0f, 544.0f)
                close()
                moveTo(485.5f, 368.0f)
                lineTo(392.0f, 368.0f)
                curveTo(378.7f, 368.0f, 368.0f, 378.7f, 368.0f, 392.0f)
                lineTo(368.0f, 485.5f)
                lineTo(485.5f, 368.0f)
                close()
            }
        }
        .build()
        return `_sticky-note`!!
    }

private var `_sticky-note`: ImageVector? = null
