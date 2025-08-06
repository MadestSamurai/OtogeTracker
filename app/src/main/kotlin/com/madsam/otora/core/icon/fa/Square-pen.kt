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

public val Fa.`Square-pen`: ImageVector
    get() {
        if (`_square-pen` != null) {
            return `_square-pen`!!
        }
        `_square-pen` = Builder(name = "Square-pen", defaultWidth = 640.0.dp, defaultHeight =
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
                moveTo(421.8f, 203.7f)
                lineTo(436.2f, 218.1f)
                curveTo(451.8f, 233.7f, 451.8f, 259.0f, 436.2f, 274.7f)
                lineTo(412.4f, 298.5f)
                lineTo(341.4f, 227.5f)
                lineTo(365.2f, 203.7f)
                curveTo(380.8f, 188.1f, 406.1f, 188.1f, 421.8f, 203.7f)
                close()
                moveTo(215.9f, 353.0f)
                lineTo(307.4f, 261.4f)
                lineTo(378.4f, 332.4f)
                lineTo(286.8f, 423.9f)
                curveTo(282.7f, 428.0f, 277.6f, 430.9f, 271.9f, 432.3f)
                lineTo(211.8f, 447.3f)
                curveTo(206.3f, 448.7f, 200.6f, 447.1f, 196.6f, 443.1f)
                curveTo(192.6f, 439.1f, 191.0f, 433.4f, 192.4f, 427.9f)
                lineTo(207.4f, 367.8f)
                curveTo(208.8f, 362.2f, 211.7f, 357.0f, 215.8f, 352.9f)
                close()
            }
        }
        .build()
        return `_square-pen`!!
    }

private var `_square-pen`: ImageVector? = null
