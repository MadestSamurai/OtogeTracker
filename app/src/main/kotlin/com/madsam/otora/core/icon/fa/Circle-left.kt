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

public val Fa.`Circle-left`: ImageVector
    get() {
        if (`_circle-left` != null) {
            return `_circle-left`!!
        }
        `_circle-left` = Builder(name = "Circle-left", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                close()
                moveTo(188.7f, 308.7f)
                lineTo(292.7f, 204.7f)
                curveTo(297.3f, 200.1f, 304.2f, 198.8f, 310.1f, 201.2f)
                curveTo(316.0f, 203.6f, 320.0f, 209.5f, 320.0f, 216.0f)
                lineTo(320.0f, 272.0f)
                lineTo(416.0f, 272.0f)
                curveTo(433.7f, 272.0f, 448.0f, 286.3f, 448.0f, 304.0f)
                lineTo(448.0f, 336.0f)
                curveTo(448.0f, 353.7f, 433.7f, 368.0f, 416.0f, 368.0f)
                lineTo(320.0f, 368.0f)
                lineTo(320.0f, 424.0f)
                curveTo(320.0f, 430.5f, 316.1f, 436.3f, 310.1f, 438.8f)
                curveTo(304.1f, 441.3f, 297.2f, 439.9f, 292.7f, 435.3f)
                lineTo(188.7f, 331.3f)
                curveTo(182.5f, 325.1f, 182.5f, 314.9f, 188.7f, 308.7f)
                close()
            }
        }
        .build()
        return `_circle-left`!!
    }

private var `_circle-left`: ImageVector? = null
