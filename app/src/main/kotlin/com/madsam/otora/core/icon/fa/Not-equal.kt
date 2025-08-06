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

public val Fa.`Not-equal`: ImageVector
    get() {
        if (`_not-equal` != null) {
            return `_not-equal`!!
        }
        `_not-equal` = Builder(name = "Not-equal", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(474.6f, 145.8f)
                curveTo(484.4f, 131.1f, 480.4f, 111.2f, 465.7f, 101.4f)
                curveTo(451.0f, 91.6f, 431.1f, 95.6f, 421.3f, 110.3f)
                lineTo(366.9f, 192.0f)
                lineTo(128.0f, 192.0f)
                curveTo(110.3f, 192.0f, 96.0f, 206.3f, 96.0f, 224.0f)
                curveTo(96.0f, 241.7f, 110.3f, 256.0f, 128.0f, 256.0f)
                lineTo(324.2f, 256.0f)
                lineTo(238.9f, 384.0f)
                lineTo(128.0f, 384.0f)
                curveTo(110.3f, 384.0f, 96.0f, 398.3f, 96.0f, 416.0f)
                curveTo(96.0f, 433.7f, 110.3f, 448.0f, 128.0f, 448.0f)
                lineTo(196.2f, 448.0f)
                lineTo(165.4f, 494.2f)
                curveTo(155.6f, 508.9f, 159.6f, 528.8f, 174.3f, 538.6f)
                curveTo(189.0f, 548.4f, 208.9f, 544.4f, 218.7f, 529.7f)
                lineTo(273.1f, 448.0f)
                lineTo(512.0f, 448.0f)
                curveTo(529.7f, 448.0f, 544.0f, 433.7f, 544.0f, 416.0f)
                curveTo(544.0f, 398.3f, 529.7f, 384.0f, 512.0f, 384.0f)
                lineTo(315.8f, 384.0f)
                lineTo(401.1f, 256.0f)
                lineTo(512.0f, 256.0f)
                curveTo(529.7f, 256.0f, 544.0f, 241.7f, 544.0f, 224.0f)
                curveTo(544.0f, 206.3f, 529.7f, 192.0f, 512.0f, 192.0f)
                lineTo(443.8f, 192.0f)
                lineTo(474.6f, 145.8f)
                close()
            }
        }
        .build()
        return `_not-equal`!!
    }

private var `_not-equal`: ImageVector? = null
