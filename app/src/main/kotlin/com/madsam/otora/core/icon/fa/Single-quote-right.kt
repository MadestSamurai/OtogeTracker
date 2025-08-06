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

public val Fa.`Single-quote-right`: ImageVector
    get() {
        if (`_single-quote-right` != null) {
            return `_single-quote-right`!!
        }
        `_single-quote-right` = Builder(name = "Single-quote-right", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 480.0f)
                curveTo(270.3f, 480.0f, 256.0f, 465.7f, 256.0f, 448.0f)
                curveTo(256.0f, 430.3f, 270.3f, 416.0f, 288.0f, 416.0f)
                lineTo(296.0f, 416.0f)
                curveTo(326.9f, 416.0f, 352.0f, 390.9f, 352.0f, 360.0f)
                lineTo(352.0f, 352.0f)
                lineTo(288.0f, 352.0f)
                curveTo(252.7f, 352.0f, 224.0f, 323.3f, 224.0f, 288.0f)
                lineTo(224.0f, 224.0f)
                curveTo(224.0f, 188.7f, 252.7f, 160.0f, 288.0f, 160.0f)
                lineTo(352.0f, 160.0f)
                curveTo(387.3f, 160.0f, 416.0f, 188.7f, 416.0f, 224.0f)
                lineTo(416.0f, 360.0f)
                curveTo(416.0f, 426.3f, 362.3f, 480.0f, 296.0f, 480.0f)
                lineTo(288.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_single-quote-right`!!
    }

private var `_single-quote-right`: ImageVector? = null
