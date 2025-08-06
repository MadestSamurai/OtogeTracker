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

public val Fa.`Single-quote-left`: ImageVector
    get() {
        if (`_single-quote-left` != null) {
            return `_single-quote-left`!!
        }
        `_single-quote-left` = Builder(name = "Single-quote-left", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 160.0f)
                curveTo(369.7f, 160.0f, 384.0f, 174.3f, 384.0f, 192.0f)
                curveTo(384.0f, 209.7f, 369.7f, 224.0f, 352.0f, 224.0f)
                lineTo(344.0f, 224.0f)
                curveTo(313.1f, 224.0f, 288.0f, 249.1f, 288.0f, 280.0f)
                lineTo(288.0f, 288.0f)
                lineTo(352.0f, 288.0f)
                curveTo(387.3f, 288.0f, 416.0f, 316.7f, 416.0f, 352.0f)
                lineTo(416.0f, 416.0f)
                curveTo(416.0f, 451.3f, 387.3f, 480.0f, 352.0f, 480.0f)
                lineTo(288.0f, 480.0f)
                curveTo(252.7f, 480.0f, 224.0f, 451.3f, 224.0f, 416.0f)
                lineTo(224.0f, 280.0f)
                curveTo(224.0f, 213.7f, 277.7f, 160.0f, 344.0f, 160.0f)
                lineTo(352.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_single-quote-left`!!
    }

private var `_single-quote-left`: ImageVector? = null
