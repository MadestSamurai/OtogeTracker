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

public val Fa.`External-link`: ImageVector
    get() {
        if (`_external-link` != null) {
            return `_external-link`!!
        }
        `_external-link` = Builder(name = "External-link", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 64.0f)
                curveTo(366.3f, 64.0f, 352.0f, 78.3f, 352.0f, 96.0f)
                curveTo(352.0f, 113.7f, 366.3f, 128.0f, 384.0f, 128.0f)
                lineTo(466.7f, 128.0f)
                lineTo(265.3f, 329.4f)
                curveTo(252.8f, 341.9f, 252.8f, 362.2f, 265.3f, 374.7f)
                curveTo(277.8f, 387.2f, 298.1f, 387.2f, 310.6f, 374.7f)
                lineTo(512.0f, 173.3f)
                lineTo(512.0f, 256.0f)
                curveTo(512.0f, 273.7f, 526.3f, 288.0f, 544.0f, 288.0f)
                curveTo(561.7f, 288.0f, 576.0f, 273.7f, 576.0f, 256.0f)
                lineTo(576.0f, 96.0f)
                curveTo(576.0f, 78.3f, 561.7f, 64.0f, 544.0f, 64.0f)
                lineTo(384.0f, 64.0f)
                close()
                moveTo(144.0f, 160.0f)
                curveTo(99.8f, 160.0f, 64.0f, 195.8f, 64.0f, 240.0f)
                lineTo(64.0f, 496.0f)
                curveTo(64.0f, 540.2f, 99.8f, 576.0f, 144.0f, 576.0f)
                lineTo(400.0f, 576.0f)
                curveTo(444.2f, 576.0f, 480.0f, 540.2f, 480.0f, 496.0f)
                lineTo(480.0f, 416.0f)
                curveTo(480.0f, 398.3f, 465.7f, 384.0f, 448.0f, 384.0f)
                curveTo(430.3f, 384.0f, 416.0f, 398.3f, 416.0f, 416.0f)
                lineTo(416.0f, 496.0f)
                curveTo(416.0f, 504.8f, 408.8f, 512.0f, 400.0f, 512.0f)
                lineTo(144.0f, 512.0f)
                curveTo(135.2f, 512.0f, 128.0f, 504.8f, 128.0f, 496.0f)
                lineTo(128.0f, 240.0f)
                curveTo(128.0f, 231.2f, 135.2f, 224.0f, 144.0f, 224.0f)
                lineTo(224.0f, 224.0f)
                curveTo(241.7f, 224.0f, 256.0f, 209.7f, 256.0f, 192.0f)
                curveTo(256.0f, 174.3f, 241.7f, 160.0f, 224.0f, 160.0f)
                lineTo(144.0f, 160.0f)
                close()
            }
        }
        .build()
        return `_external-link`!!
    }

private var `_external-link`: ImageVector? = null
