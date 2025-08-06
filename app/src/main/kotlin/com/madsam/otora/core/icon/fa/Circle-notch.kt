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

public val Fa.`Circle-notch`: ImageVector
    get() {
        if (`_circle-notch` != null) {
            return `_circle-notch`!!
        }
        `_circle-notch` = Builder(name = "Circle-notch", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(286.7f, 96.1f)
                curveTo(291.7f, 113.0f, 282.1f, 130.9f, 265.2f, 135.9f)
                curveTo(185.9f, 159.5f, 128.1f, 233.0f, 128.1f, 320.0f)
                curveTo(128.1f, 426.0f, 214.1f, 512.0f, 320.1f, 512.0f)
                curveTo(426.1f, 512.0f, 512.1f, 426.0f, 512.1f, 320.0f)
                curveTo(512.1f, 233.1f, 454.3f, 159.6f, 375.0f, 135.9f)
                curveTo(358.1f, 130.9f, 348.4f, 113.0f, 353.5f, 96.1f)
                curveTo(358.6f, 79.2f, 376.4f, 69.5f, 393.3f, 74.6f)
                curveTo(498.9f, 106.1f, 576.0f, 204.0f, 576.0f, 320.0f)
                curveTo(576.0f, 461.4f, 461.4f, 576.0f, 320.0f, 576.0f)
                curveTo(178.6f, 576.0f, 64.0f, 461.4f, 64.0f, 320.0f)
                curveTo(64.0f, 204.0f, 141.1f, 106.1f, 246.9f, 74.6f)
                curveTo(263.8f, 69.6f, 281.7f, 79.2f, 286.7f, 96.1f)
                close()
            }
        }
        .build()
        return `_circle-notch`!!
    }

private var `_circle-notch`: ImageVector? = null
