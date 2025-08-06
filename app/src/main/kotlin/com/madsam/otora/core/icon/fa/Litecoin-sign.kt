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

public val Fa.`Litecoin-sign`: ImageVector
    get() {
        if (`_litecoin-sign` != null) {
            return `_litecoin-sign`!!
        }
        `_litecoin-sign` = Builder(name = "Litecoin-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 128.0f)
                curveTo(256.0f, 110.3f, 241.7f, 96.0f, 224.0f, 96.0f)
                curveTo(206.3f, 96.0f, 192.0f, 110.3f, 192.0f, 128.0f)
                lineTo(192.0f, 285.9f)
                lineTo(153.4f, 296.9f)
                curveTo(140.7f, 300.5f, 133.3f, 313.8f, 136.9f, 326.6f)
                curveTo(140.5f, 339.4f, 153.8f, 346.7f, 166.6f, 343.1f)
                lineTo(192.0f, 335.8f)
                lineTo(192.0f, 512.0f)
                curveTo(192.0f, 529.7f, 206.3f, 544.0f, 224.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(497.7f, 544.0f, 512.0f, 529.7f, 512.0f, 512.0f)
                curveTo(512.0f, 494.3f, 497.7f, 480.0f, 480.0f, 480.0f)
                lineTo(256.0f, 480.0f)
                lineTo(256.0f, 317.5f)
                lineTo(390.6f, 279.0f)
                curveTo(403.3f, 275.4f, 410.7f, 262.1f, 407.1f, 249.3f)
                curveTo(403.5f, 236.5f, 390.2f, 229.2f, 377.4f, 232.8f)
                lineTo(256.0f, 267.6f)
                lineTo(256.0f, 128.0f)
                close()
            }
        }
        .build()
        return `_litecoin-sign`!!
    }

private var `_litecoin-sign`: ImageVector? = null
