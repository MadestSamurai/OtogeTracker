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

public val Fa.`Bowling-ball`: ImageVector
    get() {
        if (`_bowling-ball` != null) {
            return `_bowling-ball`!!
        }
        `_bowling-ball` = Builder(name = "Bowling-ball", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(304.0f, 144.0f)
                curveTo(321.7f, 144.0f, 336.0f, 158.3f, 336.0f, 176.0f)
                curveTo(336.0f, 193.7f, 321.7f, 208.0f, 304.0f, 208.0f)
                curveTo(286.3f, 208.0f, 272.0f, 193.7f, 272.0f, 176.0f)
                curveTo(272.0f, 158.3f, 286.3f, 144.0f, 304.0f, 144.0f)
                close()
                moveTo(272.0f, 272.0f)
                curveTo(272.0f, 254.3f, 286.3f, 240.0f, 304.0f, 240.0f)
                curveTo(321.7f, 240.0f, 336.0f, 254.3f, 336.0f, 272.0f)
                curveTo(336.0f, 289.7f, 321.7f, 304.0f, 304.0f, 304.0f)
                curveTo(286.3f, 304.0f, 272.0f, 289.7f, 272.0f, 272.0f)
                close()
                moveTo(208.0f, 208.0f)
                curveTo(225.7f, 208.0f, 240.0f, 222.3f, 240.0f, 240.0f)
                curveTo(240.0f, 257.7f, 225.7f, 272.0f, 208.0f, 272.0f)
                curveTo(190.3f, 272.0f, 176.0f, 257.7f, 176.0f, 240.0f)
                curveTo(176.0f, 222.3f, 190.3f, 208.0f, 208.0f, 208.0f)
                close()
            }
        }
        .build()
        return `_bowling-ball`!!
    }

private var `_bowling-ball`: ImageVector? = null
