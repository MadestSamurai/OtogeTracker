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

public val Fa.`Hat-cowboy-side`: ImageVector
    get() {
        if (`_hat-cowboy-side` != null) {
            return `_hat-cowboy-side`!!
        }
        `_hat-cowboy-side` = Builder(name = "Hat-cowboy-side", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(640.0f, 452.3f)
                curveTo(640.0f, 469.2f, 632.9f, 484.5f, 621.6f, 495.4f)
                lineTo(586.6f, 472.1f)
                lineTo(293.9f, 277.0f)
                curveTo(257.8f, 252.9f, 215.3f, 240.1f, 171.9f, 240.1f)
                lineTo(168.0f, 240.1f)
                curveTo(165.3f, 240.1f, 162.6f, 240.1f, 160.0f, 240.2f)
                lineTo(182.2f, 140.2f)
                curveTo(187.9f, 114.4f, 210.8f, 96.1f, 237.2f, 96.1f)
                curveTo(249.4f, 96.1f, 261.3f, 100.1f, 271.0f, 107.4f)
                lineTo(275.7f, 110.9f)
                curveTo(302.0f, 130.6f, 338.1f, 130.6f, 364.3f, 110.9f)
                lineTo(369.0f, 107.4f)
                curveTo(378.8f, 100.1f, 390.6f, 96.1f, 402.8f, 96.1f)
                curveTo(429.2f, 96.1f, 452.1f, 114.4f, 457.8f, 140.2f)
                lineTo(490.8f, 288.7f)
                curveTo(574.5f, 296.3f, 640.0f, 366.6f, 640.0f, 452.3f)
                close()
                moveTo(171.9f, 288.0f)
                curveTo(205.8f, 288.0f, 239.0f, 298.0f, 267.3f, 316.9f)
                lineTo(560.0f, 512.0f)
                lineTo(56.0f, 512.0f)
                curveTo(25.1f, 512.0f, 0.0f, 486.9f, 0.0f, 456.0f)
                curveTo(0.0f, 363.2f, 75.2f, 288.0f, 168.0f, 288.0f)
                lineTo(171.9f, 288.0f)
                close()
            }
        }
        .build()
        return `_hat-cowboy-side`!!
    }

private var `_hat-cowboy-side`: ImageVector? = null
