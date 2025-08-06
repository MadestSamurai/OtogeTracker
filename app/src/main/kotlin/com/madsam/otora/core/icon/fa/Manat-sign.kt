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

public val Fa.`Manat-sign`: ImageVector
    get() {
        if (`_manat-sign` != null) {
            return `_manat-sign`!!
        }
        `_manat-sign` = Builder(name = "Manat-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 96.0f)
                curveTo(306.7f, 96.0f, 296.0f, 106.7f, 296.0f, 120.0f)
                lineTo(296.0f, 161.5f)
                curveTo(201.3f, 173.3f, 128.0f, 254.1f, 128.0f, 352.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 529.7f, 142.3f, 544.0f, 160.0f, 544.0f)
                curveTo(177.7f, 544.0f, 192.0f, 529.7f, 192.0f, 512.0f)
                lineTo(192.0f, 352.0f)
                curveTo(192.0f, 289.5f, 236.8f, 237.5f, 296.0f, 226.2f)
                lineTo(296.0f, 520.0f)
                curveTo(296.0f, 533.3f, 306.7f, 544.0f, 320.0f, 544.0f)
                curveTo(333.3f, 544.0f, 344.0f, 533.3f, 344.0f, 520.0f)
                lineTo(344.0f, 226.2f)
                curveTo(403.2f, 237.4f, 448.0f, 289.5f, 448.0f, 352.0f)
                lineTo(448.0f, 512.0f)
                curveTo(448.0f, 529.7f, 462.3f, 544.0f, 480.0f, 544.0f)
                curveTo(497.7f, 544.0f, 512.0f, 529.7f, 512.0f, 512.0f)
                lineTo(512.0f, 352.0f)
                curveTo(512.0f, 254.1f, 438.7f, 173.3f, 344.0f, 161.5f)
                lineTo(344.0f, 120.0f)
                curveTo(344.0f, 106.7f, 333.3f, 96.0f, 320.0f, 96.0f)
                close()
            }
        }
        .build()
        return `_manat-sign`!!
    }

private var `_manat-sign`: ImageVector? = null
