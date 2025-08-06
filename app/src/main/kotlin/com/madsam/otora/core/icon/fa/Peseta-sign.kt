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

public val Fa.`Peseta-sign`: ImageVector
    get() {
        if (`_peseta-sign` != null) {
            return `_peseta-sign`!!
        }
        `_peseta-sign` = Builder(name = "Peseta-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.0f, 96.0f)
                curveTo(190.3f, 96.0f, 176.0f, 110.3f, 176.0f, 128.0f)
                lineTo(176.0f, 232.0f)
                lineTo(152.0f, 232.0f)
                curveTo(138.7f, 232.0f, 128.0f, 242.7f, 128.0f, 256.0f)
                curveTo(128.0f, 269.3f, 138.7f, 280.0f, 152.0f, 280.0f)
                lineTo(176.0f, 280.0f)
                lineTo(176.0f, 512.0f)
                curveTo(176.0f, 529.7f, 190.3f, 544.0f, 208.0f, 544.0f)
                curveTo(225.7f, 544.0f, 240.0f, 529.7f, 240.0f, 512.0f)
                lineTo(240.0f, 416.0f)
                lineTo(336.0f, 416.0f)
                curveTo(416.2f, 416.0f, 482.6f, 357.0f, 494.2f, 280.0f)
                lineTo(520.0f, 280.0f)
                curveTo(533.3f, 280.0f, 544.0f, 269.3f, 544.0f, 256.0f)
                curveTo(544.0f, 242.7f, 533.3f, 232.0f, 520.0f, 232.0f)
                lineTo(494.2f, 232.0f)
                curveTo(482.6f, 155.0f, 416.2f, 96.0f, 336.0f, 96.0f)
                lineTo(208.0f, 96.0f)
                close()
                moveTo(429.0f, 232.0f)
                lineTo(240.0f, 232.0f)
                lineTo(240.0f, 160.0f)
                lineTo(336.0f, 160.0f)
                curveTo(380.7f, 160.0f, 418.3f, 190.6f, 429.0f, 232.0f)
                close()
                moveTo(240.0f, 280.0f)
                lineTo(429.0f, 280.0f)
                curveTo(418.3f, 321.4f, 380.8f, 352.0f, 336.0f, 352.0f)
                lineTo(240.0f, 352.0f)
                lineTo(240.0f, 280.0f)
                close()
            }
        }
        .build()
        return `_peseta-sign`!!
    }

private var `_peseta-sign`: ImageVector? = null
