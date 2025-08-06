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

public val Fa.`Hockey-puck`: ImageVector
    get() {
        if (`_hockey-puck` != null) {
            return `_hockey-puck`!!
        }
        `_hockey-puck` = Builder(name = "Hockey-puck", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 320.0f)
                curveTo(178.6f, 320.0f, 64.0f, 277.0f, 64.0f, 224.0f)
                curveTo(64.0f, 171.0f, 178.6f, 128.0f, 320.0f, 128.0f)
                curveTo(461.4f, 128.0f, 576.0f, 171.0f, 576.0f, 224.0f)
                curveTo(576.0f, 277.0f, 461.4f, 320.0f, 320.0f, 320.0f)
                close()
                moveTo(64.0f, 416.0f)
                lineTo(64.0f, 306.7f)
                curveTo(80.9f, 319.0f, 101.0f, 328.9f, 122.1f, 336.8f)
                curveTo(175.1f, 356.7f, 245.1f, 368.0f, 320.0f, 368.0f)
                curveTo(394.9f, 368.0f, 464.9f, 356.7f, 517.9f, 336.8f)
                curveTo(539.1f, 328.9f, 559.1f, 319.0f, 576.0f, 306.7f)
                lineTo(576.0f, 416.0f)
                curveTo(576.0f, 469.0f, 461.4f, 512.0f, 320.0f, 512.0f)
                curveTo(178.6f, 512.0f, 64.0f, 469.0f, 64.0f, 416.0f)
                close()
            }
        }
        .build()
        return `_hockey-puck`!!
    }

private var `_hockey-puck`: ImageVector? = null
