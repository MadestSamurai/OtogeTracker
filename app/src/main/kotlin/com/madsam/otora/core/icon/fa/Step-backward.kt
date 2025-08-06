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

public val Fa.`Step-backward`: ImageVector
    get() {
        if (`_step-backward` != null) {
            return `_step-backward`!!
        }
        `_step-backward` = Builder(name = "Step-backward", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(491.0f, 100.8f)
                curveTo(478.1f, 93.8f, 462.3f, 94.5f, 450.0f, 102.6f)
                lineTo(192.0f, 272.1f)
                lineTo(192.0f, 128.0f)
                curveTo(192.0f, 110.3f, 177.7f, 96.0f, 160.0f, 96.0f)
                curveTo(142.3f, 96.0f, 128.0f, 110.3f, 128.0f, 128.0f)
                lineTo(128.0f, 512.0f)
                curveTo(128.0f, 529.7f, 142.3f, 544.0f, 160.0f, 544.0f)
                curveTo(177.7f, 544.0f, 192.0f, 529.7f, 192.0f, 512.0f)
                lineTo(192.0f, 367.9f)
                lineTo(450.0f, 537.5f)
                curveTo(462.3f, 545.6f, 478.0f, 546.3f, 491.0f, 539.3f)
                curveTo(504.0f, 532.3f, 512.0f, 518.8f, 512.0f, 504.1f)
                lineTo(512.0f, 136.1f)
                curveTo(512.0f, 121.4f, 503.9f, 107.9f, 491.0f, 100.9f)
                close()
            }
        }
        .build()
        return `_step-backward`!!
    }

private var `_step-backward`: ImageVector? = null
