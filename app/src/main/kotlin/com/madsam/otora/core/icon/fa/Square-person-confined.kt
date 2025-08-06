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

public val Fa.`Square-person-confined`: ImageVector
    get() {
        if (`_square-person-confined` != null) {
            return `_square-person-confined`!!
        }
        `_square-person-confined` = Builder(name = "Square-person-confined", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
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
                moveTo(256.0f, 208.0f)
                curveTo(256.0f, 181.5f, 277.5f, 160.0f, 304.0f, 160.0f)
                curveTo(330.5f, 160.0f, 352.0f, 181.5f, 352.0f, 208.0f)
                curveTo(352.0f, 234.5f, 330.5f, 256.0f, 304.0f, 256.0f)
                curveTo(277.5f, 256.0f, 256.0f, 234.5f, 256.0f, 208.0f)
                close()
                moveTo(336.0f, 312.0f)
                curveTo(336.0f, 281.1f, 361.1f, 256.0f, 392.0f, 256.0f)
                curveTo(422.9f, 256.0f, 448.0f, 281.1f, 448.0f, 312.0f)
                lineTo(448.0f, 414.1f)
                curveTo(448.0f, 450.5f, 418.5f, 480.0f, 382.1f, 480.0f)
                curveTo(364.6f, 480.0f, 347.8f, 473.1f, 335.5f, 460.7f)
                lineTo(280.8f, 406.0f)
                lineTo(252.7f, 462.3f)
                curveTo(244.8f, 478.1f, 225.6f, 484.5f, 209.8f, 476.6f)
                curveTo(194.0f, 468.7f, 187.6f, 449.5f, 195.5f, 433.7f)
                lineTo(243.5f, 337.7f)
                curveTo(248.1f, 328.5f, 256.8f, 322.1f, 267.0f, 320.4f)
                curveTo(277.2f, 318.7f, 287.5f, 322.1f, 294.8f, 329.4f)
                lineTo(336.2f, 370.8f)
                lineTo(336.2f, 312.1f)
                close()
            }
        }
        .build()
        return `_square-person-confined`!!
    }

private var `_square-person-confined`: ImageVector? = null
