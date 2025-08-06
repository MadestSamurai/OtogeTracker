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

public val Fa.`Hand-lizard`: ImageVector
    get() {
        if (`_hand-lizard` != null) {
            return `_hand-lizard`!!
        }
        `_hand-lizard` = Builder(name = "Hand-lizard", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 176.0f)
                curveTo(64.0f, 149.5f, 85.5f, 128.0f, 112.0f, 128.0f)
                lineTo(350.5f, 128.0f)
                curveTo(387.3f, 128.0f, 421.7f, 146.0f, 442.6f, 176.2f)
                lineTo(556.1f, 340.2f)
                curveTo(569.1f, 358.9f, 576.0f, 381.2f, 576.0f, 404.0f)
                lineTo(576.0f, 480.0f)
                curveTo(576.0f, 497.7f, 561.7f, 512.0f, 544.0f, 512.0f)
                lineTo(448.0f, 512.0f)
                curveTo(430.3f, 512.0f, 416.0f, 497.7f, 416.0f, 480.0f)
                lineTo(416.0f, 466.2f)
                lineTo(337.9f, 416.0f)
                lineTo(176.0f, 416.0f)
                curveTo(149.5f, 416.0f, 128.0f, 394.5f, 128.0f, 368.0f)
                curveTo(128.0f, 341.5f, 149.5f, 320.0f, 176.0f, 320.0f)
                lineTo(304.0f, 320.0f)
                curveTo(330.5f, 320.0f, 352.0f, 298.5f, 352.0f, 272.0f)
                curveTo(352.0f, 245.5f, 330.5f, 224.0f, 304.0f, 224.0f)
                lineTo(112.0f, 224.0f)
                curveTo(85.5f, 224.0f, 64.0f, 202.5f, 64.0f, 176.0f)
                close()
            }
        }
        .build()
        return `_hand-lizard`!!
    }

private var `_hand-lizard`: ImageVector? = null
