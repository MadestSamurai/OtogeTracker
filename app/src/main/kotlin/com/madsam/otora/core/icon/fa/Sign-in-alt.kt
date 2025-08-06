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

public val Fa.`Sign-in-alt`: ImageVector
    get() {
        if (`_sign-in-alt` != null) {
            return `_sign-in-alt`!!
        }
        `_sign-in-alt` = Builder(name = "Sign-in-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(409.0f, 337.0f)
                curveTo(418.4f, 327.6f, 418.4f, 312.4f, 409.0f, 303.1f)
                lineTo(265.0f, 159.0f)
                curveTo(258.1f, 152.1f, 247.8f, 150.1f, 238.8f, 153.8f)
                curveTo(229.8f, 157.5f, 224.0f, 166.3f, 224.0f, 176.0f)
                lineTo(224.0f, 256.0f)
                lineTo(112.0f, 256.0f)
                curveTo(85.5f, 256.0f, 64.0f, 277.5f, 64.0f, 304.0f)
                lineTo(64.0f, 336.0f)
                curveTo(64.0f, 362.5f, 85.5f, 384.0f, 112.0f, 384.0f)
                lineTo(224.0f, 384.0f)
                lineTo(224.0f, 464.0f)
                curveTo(224.0f, 473.7f, 229.8f, 482.5f, 238.8f, 486.2f)
                curveTo(247.8f, 489.9f, 258.1f, 487.9f, 265.0f, 481.0f)
                lineTo(409.0f, 337.0f)
                close()
                moveTo(416.0f, 480.0f)
                curveTo(398.3f, 480.0f, 384.0f, 494.3f, 384.0f, 512.0f)
                curveTo(384.0f, 529.7f, 398.3f, 544.0f, 416.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(533.0f, 544.0f, 576.0f, 501.0f, 576.0f, 448.0f)
                lineTo(576.0f, 192.0f)
                curveTo(576.0f, 139.0f, 533.0f, 96.0f, 480.0f, 96.0f)
                lineTo(416.0f, 96.0f)
                curveTo(398.3f, 96.0f, 384.0f, 110.3f, 384.0f, 128.0f)
                curveTo(384.0f, 145.7f, 398.3f, 160.0f, 416.0f, 160.0f)
                lineTo(480.0f, 160.0f)
                curveTo(497.7f, 160.0f, 512.0f, 174.3f, 512.0f, 192.0f)
                lineTo(512.0f, 448.0f)
                curveTo(512.0f, 465.7f, 497.7f, 480.0f, 480.0f, 480.0f)
                lineTo(416.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_sign-in-alt`!!
    }

private var `_sign-in-alt`: ImageVector? = null
