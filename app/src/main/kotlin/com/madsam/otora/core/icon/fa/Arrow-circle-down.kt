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

public val Fa.`Arrow-circle-down`: ImageVector
    get() {
        if (`_arrow-circle-down` != null) {
            return `_arrow-circle-down`!!
        }
        `_arrow-circle-down` = Builder(name = "Arrow-circle-down", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                close()
                moveTo(303.0f, 441.0f)
                lineTo(223.0f, 361.0f)
                curveTo(213.6f, 351.6f, 213.6f, 336.4f, 223.0f, 327.1f)
                curveTo(232.4f, 317.8f, 247.6f, 317.7f, 256.9f, 327.1f)
                lineTo(295.9f, 366.1f)
                lineTo(295.9f, 216.0f)
                curveTo(295.9f, 202.7f, 306.6f, 192.0f, 319.9f, 192.0f)
                curveTo(333.2f, 192.0f, 343.9f, 202.7f, 343.9f, 216.0f)
                lineTo(343.9f, 366.1f)
                lineTo(382.9f, 327.1f)
                curveTo(392.3f, 317.7f, 407.5f, 317.7f, 416.8f, 327.1f)
                curveTo(426.1f, 336.5f, 426.2f, 351.7f, 416.8f, 361.0f)
                lineTo(336.8f, 441.0f)
                curveTo(327.4f, 450.4f, 312.2f, 450.4f, 302.9f, 441.0f)
                close()
            }
        }
        .build()
        return `_arrow-circle-down`!!
    }

private var `_arrow-circle-down`: ImageVector? = null
