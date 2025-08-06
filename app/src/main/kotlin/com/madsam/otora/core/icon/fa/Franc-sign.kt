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

public val Fa.`Franc-sign`: ImageVector
    get() {
        if (`_franc-sign` != null) {
            return `_franc-sign`!!
        }
        `_franc-sign` = Builder(name = "Franc-sign", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(240.0f, 96.0f)
                curveTo(222.3f, 96.0f, 208.0f, 110.3f, 208.0f, 128.0f)
                lineTo(208.0f, 384.0f)
                lineTo(184.0f, 384.0f)
                curveTo(170.7f, 384.0f, 160.0f, 394.7f, 160.0f, 408.0f)
                curveTo(160.0f, 421.3f, 170.7f, 432.0f, 184.0f, 432.0f)
                lineTo(208.0f, 432.0f)
                lineTo(208.0f, 512.0f)
                curveTo(208.0f, 529.7f, 222.3f, 544.0f, 240.0f, 544.0f)
                curveTo(257.7f, 544.0f, 272.0f, 529.7f, 272.0f, 512.0f)
                lineTo(272.0f, 432.0f)
                lineTo(360.0f, 432.0f)
                curveTo(373.3f, 432.0f, 384.0f, 421.3f, 384.0f, 408.0f)
                curveTo(384.0f, 394.7f, 373.3f, 384.0f, 360.0f, 384.0f)
                lineTo(272.0f, 384.0f)
                lineTo(272.0f, 320.0f)
                lineTo(416.0f, 320.0f)
                curveTo(433.7f, 320.0f, 448.0f, 305.7f, 448.0f, 288.0f)
                curveTo(448.0f, 270.3f, 433.7f, 256.0f, 416.0f, 256.0f)
                lineTo(272.0f, 256.0f)
                lineTo(272.0f, 160.0f)
                lineTo(448.0f, 160.0f)
                curveTo(465.7f, 160.0f, 480.0f, 145.7f, 480.0f, 128.0f)
                curveTo(480.0f, 110.3f, 465.7f, 96.0f, 448.0f, 96.0f)
                lineTo(240.0f, 96.0f)
                close()
            }
        }
        .build()
        return `_franc-sign`!!
    }

private var `_franc-sign`: ImageVector? = null
