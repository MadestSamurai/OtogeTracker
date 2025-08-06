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

public val Fa.`Font-awesome-logo-full`: ImageVector
    get() {
        if (`_font-awesome-logo-full` != null) {
            return `_font-awesome-logo-full`!!
        }
        `_font-awesome-logo-full` = Builder(name = "Font-awesome-logo-full", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(155.7f, 160.0f)
                curveTo(170.3f, 150.8f, 180.0f, 134.5f, 180.0f, 116.0f)
                curveTo(180.0f, 87.3f, 156.7f, 64.0f, 128.0f, 64.0f)
                curveTo(99.3f, 64.0f, 76.0f, 87.3f, 76.0f, 116.0f)
                curveTo(76.0f, 132.7f, 83.8f, 147.5f, 96.0f, 157.0f)
                lineTo(96.0f, 576.0f)
                lineTo(160.0f, 576.0f)
                lineTo(160.0f, 512.0f)
                lineTo(533.6f, 512.0f)
                curveTo(548.2f, 512.0f, 560.0f, 500.2f, 560.0f, 485.6f)
                curveTo(560.0f, 481.9f, 559.2f, 478.3f, 557.7f, 474.9f)
                lineTo(496.0f, 336.0f)
                lineTo(557.7f, 197.1f)
                curveTo(559.2f, 193.7f, 560.0f, 190.1f, 560.0f, 186.4f)
                curveTo(560.0f, 171.8f, 548.2f, 160.0f, 533.6f, 160.0f)
                lineTo(155.7f, 160.0f)
                close()
            }
        }
        .build()
        return `_font-awesome-logo-full`!!
    }

private var `_font-awesome-logo-full`: ImageVector? = null
