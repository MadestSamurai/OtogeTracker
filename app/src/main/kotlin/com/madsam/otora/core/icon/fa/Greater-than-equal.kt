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

public val Fa.`Greater-than-equal`: ImageVector
    get() {
        if (`_greater-than-equal` != null) {
            return `_greater-than-equal`!!
        }
        `_greater-than-equal` = Builder(name = "Greater-than-equal", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(117.9f, 158.4f)
                curveTo(101.1f, 152.8f, 92.1f, 134.6f, 97.7f, 117.9f)
                curveTo(103.3f, 101.2f, 121.4f, 92.1f, 138.1f, 97.6f)
                lineTo(522.1f, 225.6f)
                curveTo(535.2f, 230.0f, 544.0f, 242.2f, 544.0f, 256.0f)
                curveTo(544.0f, 269.8f, 535.2f, 282.0f, 522.1f, 286.4f)
                lineTo(138.1f, 414.4f)
                curveTo(121.3f, 420.0f, 103.2f, 410.9f, 97.6f, 394.2f)
                curveTo(92.0f, 377.5f, 101.1f, 359.3f, 117.8f, 353.7f)
                lineTo(410.8f, 256.0f)
                lineTo(117.9f, 158.4f)
                close()
                moveTo(512.0f, 480.0f)
                curveTo(529.7f, 480.0f, 544.0f, 494.3f, 544.0f, 512.0f)
                curveTo(544.0f, 529.7f, 529.7f, 544.0f, 512.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(110.3f, 544.0f, 96.0f, 529.7f, 96.0f, 512.0f)
                curveTo(96.0f, 494.3f, 110.3f, 480.0f, 128.0f, 480.0f)
                lineTo(512.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_greater-than-equal`!!
    }

private var `_greater-than-equal`: ImageVector? = null
