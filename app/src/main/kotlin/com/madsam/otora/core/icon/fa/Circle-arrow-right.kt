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

public val Fa.`Circle-arrow-right`: ImageVector
    get() {
        if (`_circle-arrow-right` != null) {
            return `_circle-arrow-right`!!
        }
        `_circle-arrow-right` = Builder(name = "Circle-arrow-right", defaultWidth = 640.0.dp,
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
                moveTo(361.0f, 417.0f)
                curveTo(351.6f, 426.4f, 336.4f, 426.4f, 327.1f, 417.0f)
                curveTo(317.8f, 407.6f, 317.7f, 392.4f, 327.1f, 383.1f)
                lineTo(366.1f, 344.1f)
                lineTo(216.0f, 344.1f)
                curveTo(202.7f, 344.1f, 192.0f, 333.4f, 192.0f, 320.1f)
                curveTo(192.0f, 306.8f, 202.7f, 296.1f, 216.0f, 296.1f)
                lineTo(366.1f, 296.1f)
                lineTo(327.1f, 257.1f)
                curveTo(317.7f, 247.7f, 317.7f, 232.5f, 327.1f, 223.2f)
                curveTo(336.5f, 213.9f, 351.7f, 213.8f, 361.0f, 223.2f)
                lineTo(441.0f, 303.2f)
                curveTo(450.4f, 312.6f, 450.4f, 327.8f, 441.0f, 337.1f)
                lineTo(361.0f, 417.1f)
                close()
            }
        }
        .build()
        return `_circle-arrow-right`!!
    }

private var `_circle-arrow-right`: ImageVector? = null
