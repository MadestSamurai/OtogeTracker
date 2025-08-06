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

public val Fa.`Caret-square-up`: ImageVector
    get() {
        if (`_caret-square-up` != null) {
            return `_caret-square-up`!!
        }
        `_caret-square-up` = Builder(name = "Caret-square-up", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
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
                moveTo(320.0f, 224.0f)
                curveTo(326.7f, 224.0f, 333.0f, 226.8f, 337.6f, 231.7f)
                lineTo(441.6f, 343.7f)
                curveTo(448.1f, 350.7f, 449.8f, 360.9f, 446.0f, 369.6f)
                curveTo(442.2f, 378.3f, 433.5f, 384.0f, 424.0f, 384.0f)
                lineTo(216.0f, 384.0f)
                curveTo(206.5f, 384.0f, 197.8f, 378.3f, 194.0f, 369.6f)
                curveTo(190.2f, 360.9f, 191.9f, 350.7f, 198.4f, 343.7f)
                lineTo(302.4f, 231.7f)
                curveTo(306.9f, 226.8f, 313.3f, 224.0f, 320.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_caret-square-up`!!
    }

private var `_caret-square-up`: ImageVector? = null
