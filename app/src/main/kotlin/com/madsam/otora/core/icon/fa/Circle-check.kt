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

public val Fa.`Circle-check`: ImageVector
    get() {
        if (`_circle-check` != null) {
            return `_circle-check`!!
        }
        `_circle-check` = Builder(name = "Circle-check", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(404.4f, 276.7f)
                lineTo(324.4f, 404.7f)
                curveTo(320.2f, 411.4f, 313.0f, 415.6f, 305.1f, 416.0f)
                curveTo(297.2f, 416.4f, 289.6f, 412.8f, 284.9f, 406.4f)
                lineTo(236.9f, 342.4f)
                curveTo(228.9f, 331.8f, 231.1f, 316.8f, 241.7f, 308.8f)
                curveTo(252.3f, 300.8f, 267.3f, 303.0f, 275.3f, 313.6f)
                lineTo(302.3f, 349.6f)
                lineTo(363.7f, 251.3f)
                curveTo(370.7f, 240.1f, 385.5f, 236.6f, 396.8f, 243.7f)
                curveTo(408.1f, 250.8f, 411.5f, 265.5f, 404.4f, 276.8f)
                close()
            }
        }
        .build()
        return `_circle-check`!!
    }

private var `_circle-check`: ImageVector? = null
