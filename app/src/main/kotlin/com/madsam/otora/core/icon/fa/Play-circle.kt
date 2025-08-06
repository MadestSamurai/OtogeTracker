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

public val Fa.`Play-circle`: ImageVector
    get() {
        if (`_play-circle` != null) {
            return `_play-circle`!!
        }
        `_play-circle` = Builder(name = "Play-circle", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 178.6f, 178.6f, 64.0f, 320.0f, 64.0f)
                curveTo(461.4f, 64.0f, 576.0f, 178.6f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                close()
                moveTo(252.3f, 211.1f)
                curveTo(244.7f, 215.3f, 240.0f, 223.4f, 240.0f, 232.0f)
                lineTo(240.0f, 408.0f)
                curveTo(240.0f, 416.7f, 244.7f, 424.7f, 252.3f, 428.9f)
                curveTo(259.9f, 433.1f, 269.1f, 433.0f, 276.6f, 428.4f)
                lineTo(420.6f, 340.4f)
                curveTo(427.7f, 336.0f, 432.1f, 328.3f, 432.1f, 319.9f)
                curveTo(432.1f, 311.5f, 427.7f, 303.8f, 420.6f, 299.4f)
                lineTo(276.6f, 211.4f)
                curveTo(269.2f, 206.9f, 259.9f, 206.7f, 252.3f, 210.9f)
                close()
            }
        }
        .build()
        return `_play-circle`!!
    }

private var `_play-circle`: ImageVector? = null
