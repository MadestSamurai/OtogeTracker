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

public val Fa.`Star-of-life`: ImageVector
    get() {
        if (`_star-of-life` != null) {
            return `_star-of-life`!!
        }
        `_star-of-life` = Builder(name = "Star-of-life", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(272.5f, 96.0f)
                curveTo(272.5f, 78.3f, 286.8f, 64.0f, 304.5f, 64.0f)
                lineTo(336.5f, 64.0f)
                curveTo(354.2f, 64.0f, 368.5f, 78.3f, 368.5f, 96.0f)
                lineTo(368.5f, 236.9f)
                lineTo(490.5f, 166.5f)
                curveTo(505.8f, 157.7f, 525.4f, 162.9f, 534.2f, 178.2f)
                lineTo(550.2f, 205.9f)
                curveTo(559.0f, 221.2f, 553.8f, 240.8f, 538.5f, 249.6f)
                lineTo(416.5f, 320.0f)
                lineTo(538.5f, 390.4f)
                curveTo(553.8f, 399.2f, 559.1f, 418.8f, 550.2f, 434.1f)
                lineTo(534.2f, 461.8f)
                curveTo(525.4f, 477.1f, 505.8f, 482.4f, 490.5f, 473.5f)
                lineTo(368.5f, 403.1f)
                lineTo(368.5f, 544.0f)
                curveTo(368.5f, 561.7f, 354.2f, 576.0f, 336.5f, 576.0f)
                lineTo(304.5f, 576.0f)
                curveTo(286.8f, 576.0f, 272.5f, 561.7f, 272.5f, 544.0f)
                lineTo(272.5f, 403.1f)
                lineTo(150.5f, 473.5f)
                curveTo(135.2f, 482.3f, 115.6f, 477.1f, 106.8f, 461.8f)
                lineTo(90.8f, 434.1f)
                curveTo(82.0f, 418.8f, 87.2f, 399.2f, 102.5f, 390.4f)
                lineTo(224.5f, 320.0f)
                lineTo(102.5f, 249.6f)
                curveTo(87.2f, 240.8f, 82.0f, 221.2f, 90.8f, 205.9f)
                lineTo(106.8f, 178.2f)
                curveTo(115.6f, 162.9f, 135.2f, 157.7f, 150.5f, 166.5f)
                lineTo(272.5f, 236.9f)
                lineTo(272.5f, 96.0f)
                close()
            }
        }
        .build()
        return `_star-of-life`!!
    }

private var `_star-of-life`: ImageVector? = null
