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

public val Fa.`Tenge-sign`: ImageVector
    get() {
        if (`_tenge-sign` != null) {
            return `_tenge-sign`!!
        }
        `_tenge-sign` = Builder(name = "Tenge-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 120.0f)
                curveTo(128.0f, 106.7f, 138.7f, 96.0f, 152.0f, 96.0f)
                lineTo(488.0f, 96.0f)
                curveTo(501.3f, 96.0f, 512.0f, 106.7f, 512.0f, 120.0f)
                curveTo(512.0f, 133.3f, 501.3f, 144.0f, 488.0f, 144.0f)
                lineTo(152.0f, 144.0f)
                curveTo(138.7f, 144.0f, 128.0f, 133.3f, 128.0f, 120.0f)
                close()
                moveTo(128.0f, 224.0f)
                curveTo(128.0f, 206.3f, 142.3f, 192.0f, 160.0f, 192.0f)
                lineTo(480.0f, 192.0f)
                curveTo(497.7f, 192.0f, 512.0f, 206.3f, 512.0f, 224.0f)
                curveTo(512.0f, 241.7f, 497.7f, 256.0f, 480.0f, 256.0f)
                lineTo(352.0f, 256.0f)
                lineTo(352.0f, 512.0f)
                curveTo(352.0f, 529.7f, 337.7f, 544.0f, 320.0f, 544.0f)
                curveTo(302.3f, 544.0f, 288.0f, 529.7f, 288.0f, 512.0f)
                lineTo(288.0f, 256.0f)
                lineTo(160.0f, 256.0f)
                curveTo(142.3f, 256.0f, 128.0f, 241.7f, 128.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_tenge-sign`!!
    }

private var `_tenge-sign`: ImageVector? = null
