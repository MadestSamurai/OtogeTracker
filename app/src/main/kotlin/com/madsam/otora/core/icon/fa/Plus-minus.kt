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

public val Fa.`Plus-minus`: ImageVector
    get() {
        if (`_plus-minus` != null) {
            return `_plus-minus`!!
        }
        `_plus-minus` = Builder(name = "Plus-minus", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 96.0f)
                curveTo(352.0f, 78.3f, 337.7f, 64.0f, 320.0f, 64.0f)
                curveTo(302.3f, 64.0f, 288.0f, 78.3f, 288.0f, 96.0f)
                lineTo(288.0f, 224.0f)
                lineTo(160.0f, 224.0f)
                curveTo(142.3f, 224.0f, 128.0f, 238.3f, 128.0f, 256.0f)
                curveTo(128.0f, 273.7f, 142.3f, 288.0f, 160.0f, 288.0f)
                lineTo(288.0f, 288.0f)
                lineTo(288.0f, 416.0f)
                curveTo(288.0f, 433.7f, 302.3f, 448.0f, 320.0f, 448.0f)
                curveTo(337.7f, 448.0f, 352.0f, 433.7f, 352.0f, 416.0f)
                lineTo(352.0f, 288.0f)
                lineTo(480.0f, 288.0f)
                curveTo(497.7f, 288.0f, 512.0f, 273.7f, 512.0f, 256.0f)
                curveTo(512.0f, 238.3f, 497.7f, 224.0f, 480.0f, 224.0f)
                lineTo(352.0f, 224.0f)
                lineTo(352.0f, 96.0f)
                close()
                moveTo(128.0f, 544.0f)
                curveTo(128.0f, 561.7f, 142.3f, 576.0f, 160.0f, 576.0f)
                lineTo(480.0f, 576.0f)
                curveTo(497.7f, 576.0f, 512.0f, 561.7f, 512.0f, 544.0f)
                curveTo(512.0f, 526.3f, 497.7f, 512.0f, 480.0f, 512.0f)
                lineTo(160.0f, 512.0f)
                curveTo(142.3f, 512.0f, 128.0f, 526.3f, 128.0f, 544.0f)
                close()
            }
        }
        .build()
        return `_plus-minus`!!
    }

private var `_plus-minus`: ImageVector? = null
