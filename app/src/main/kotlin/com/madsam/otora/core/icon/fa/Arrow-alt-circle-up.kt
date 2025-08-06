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

public val Fa.`Arrow-alt-circle-up`: ImageVector
    get() {
        if (`_arrow-alt-circle-up` != null) {
            return `_arrow-alt-circle-up`!!
        }
        `_arrow-alt-circle-up` = Builder(name = "Arrow-alt-circle-up", defaultWidth = 640.0.dp,
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
                moveTo(331.3f, 188.7f)
                lineTo(435.3f, 292.7f)
                curveTo(439.9f, 297.3f, 441.2f, 304.2f, 438.8f, 310.1f)
                curveTo(436.4f, 316.0f, 430.5f, 320.0f, 424.0f, 320.0f)
                lineTo(368.0f, 320.0f)
                lineTo(368.0f, 416.0f)
                curveTo(368.0f, 433.7f, 353.7f, 448.0f, 336.0f, 448.0f)
                lineTo(304.0f, 448.0f)
                curveTo(286.3f, 448.0f, 272.0f, 433.7f, 272.0f, 416.0f)
                lineTo(272.0f, 320.0f)
                lineTo(216.0f, 320.0f)
                curveTo(209.5f, 320.0f, 203.7f, 316.1f, 201.2f, 310.1f)
                curveTo(198.7f, 304.1f, 200.1f, 297.2f, 204.7f, 292.7f)
                lineTo(308.7f, 188.7f)
                curveTo(314.9f, 182.5f, 325.1f, 182.5f, 331.3f, 188.7f)
                close()
            }
        }
        .build()
        return `_arrow-alt-circle-up`!!
    }

private var `_arrow-alt-circle-up`: ImageVector? = null
