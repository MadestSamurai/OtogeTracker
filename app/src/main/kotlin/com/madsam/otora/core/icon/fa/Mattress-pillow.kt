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

public val Fa.`Mattress-pillow`: ImageVector
    get() {
        if (`_mattress-pillow` != null) {
            return `_mattress-pillow`!!
        }
        `_mattress-pillow` = Builder(name = "Mattress-pillow", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.0f, 128.0f)
                lineTo(96.0f, 128.0f)
                curveTo(60.7f, 128.0f, 32.0f, 156.7f, 32.0f, 192.0f)
                lineTo(32.0f, 448.0f)
                curveTo(32.0f, 483.3f, 60.7f, 512.0f, 96.0f, 512.0f)
                lineTo(288.0f, 512.0f)
                lineTo(288.0f, 128.0f)
                close()
                moveTo(336.0f, 512.0f)
                lineTo(544.0f, 512.0f)
                curveTo(579.3f, 512.0f, 608.0f, 483.3f, 608.0f, 448.0f)
                lineTo(608.0f, 192.0f)
                curveTo(608.0f, 156.7f, 579.3f, 128.0f, 544.0f, 128.0f)
                lineTo(336.0f, 128.0f)
                lineTo(336.0f, 512.0f)
                close()
                moveTo(96.0f, 224.0f)
                curveTo(96.0f, 206.3f, 110.3f, 192.0f, 128.0f, 192.0f)
                lineTo(192.0f, 192.0f)
                curveTo(209.7f, 192.0f, 224.0f, 206.3f, 224.0f, 224.0f)
                lineTo(224.0f, 416.0f)
                curveTo(224.0f, 433.7f, 209.7f, 448.0f, 192.0f, 448.0f)
                lineTo(128.0f, 448.0f)
                curveTo(110.3f, 448.0f, 96.0f, 433.7f, 96.0f, 416.0f)
                lineTo(96.0f, 224.0f)
                close()
            }
        }
        .build()
        return `_mattress-pillow`!!
    }

private var `_mattress-pillow`: ImageVector? = null
