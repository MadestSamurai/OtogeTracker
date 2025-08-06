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

public val Fa.`Circle-down`: ImageVector
    get() {
        if (`_circle-down` != null) {
            return `_circle-down`!!
        }
        `_circle-down` = Builder(name = "Circle-down", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                close()
                moveTo(308.7f, 451.3f)
                lineTo(204.7f, 347.3f)
                curveTo(200.1f, 342.7f, 198.8f, 335.8f, 201.2f, 329.9f)
                curveTo(203.6f, 324.0f, 209.5f, 320.0f, 216.0f, 320.0f)
                lineTo(272.0f, 320.0f)
                lineTo(272.0f, 224.0f)
                curveTo(272.0f, 206.3f, 286.3f, 192.0f, 304.0f, 192.0f)
                lineTo(336.0f, 192.0f)
                curveTo(353.7f, 192.0f, 368.0f, 206.3f, 368.0f, 224.0f)
                lineTo(368.0f, 320.0f)
                lineTo(424.0f, 320.0f)
                curveTo(430.5f, 320.0f, 436.3f, 323.9f, 438.8f, 329.9f)
                curveTo(441.3f, 335.9f, 439.9f, 342.8f, 435.3f, 347.3f)
                lineTo(331.3f, 451.3f)
                curveTo(325.1f, 457.5f, 314.9f, 457.5f, 308.7f, 451.3f)
                close()
            }
        }
        .build()
        return `_circle-down`!!
    }

private var `_circle-down`: ImageVector? = null
