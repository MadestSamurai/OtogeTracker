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

public val Fa.`Less-than-equal`: ImageVector
    get() {
        if (`_less-than-equal` != null) {
            return `_less-than-equal`!!
        }
        `_less-than-equal` = Builder(name = "Less-than-equal", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(522.1f, 158.4f)
                curveTo(538.9f, 152.8f, 547.9f, 134.7f, 542.3f, 117.9f)
                curveTo(536.7f, 101.1f, 518.6f, 92.1f, 501.8f, 97.7f)
                lineTo(117.8f, 225.7f)
                curveTo(104.8f, 230.0f, 96.0f, 242.2f, 96.0f, 256.0f)
                curveTo(96.0f, 269.8f, 104.8f, 282.0f, 117.9f, 286.4f)
                lineTo(501.9f, 414.4f)
                curveTo(518.7f, 420.0f, 536.8f, 410.9f, 542.4f, 394.2f)
                curveTo(548.0f, 377.5f, 538.9f, 359.3f, 522.2f, 353.7f)
                lineTo(229.2f, 256.0f)
                lineTo(522.1f, 158.4f)
                close()
                moveTo(128.0f, 480.0f)
                curveTo(110.3f, 480.0f, 96.0f, 494.3f, 96.0f, 512.0f)
                curveTo(96.0f, 529.7f, 110.3f, 544.0f, 128.0f, 544.0f)
                lineTo(512.0f, 544.0f)
                curveTo(529.7f, 544.0f, 544.0f, 529.7f, 544.0f, 512.0f)
                curveTo(544.0f, 494.3f, 529.7f, 480.0f, 512.0f, 480.0f)
                lineTo(128.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_less-than-equal`!!
    }

private var `_less-than-equal`: ImageVector? = null
