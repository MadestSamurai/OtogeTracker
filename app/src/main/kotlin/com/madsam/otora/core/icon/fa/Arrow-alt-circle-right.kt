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

public val Fa.`Arrow-alt-circle-right`: ImageVector
    get() {
        if (`_arrow-alt-circle-right` != null) {
            return `_arrow-alt-circle-right`!!
        }
        `_arrow-alt-circle-right` = Builder(name = "Arrow-alt-circle-right", defaultWidth =
                640.0.dp, defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight =
                640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 320.0f)
                curveTo(64.0f, 461.4f, 178.6f, 576.0f, 320.0f, 576.0f)
                curveTo(461.4f, 576.0f, 576.0f, 461.4f, 576.0f, 320.0f)
                curveTo(576.0f, 178.6f, 461.4f, 64.0f, 320.0f, 64.0f)
                curveTo(178.6f, 64.0f, 64.0f, 178.6f, 64.0f, 320.0f)
                close()
                moveTo(451.3f, 331.3f)
                lineTo(347.3f, 435.3f)
                curveTo(342.7f, 439.9f, 335.8f, 441.2f, 329.9f, 438.8f)
                curveTo(324.0f, 436.4f, 320.0f, 430.5f, 320.0f, 424.0f)
                lineTo(320.0f, 368.0f)
                lineTo(224.0f, 368.0f)
                curveTo(206.3f, 368.0f, 192.0f, 353.7f, 192.0f, 336.0f)
                lineTo(192.0f, 304.0f)
                curveTo(192.0f, 286.3f, 206.3f, 272.0f, 224.0f, 272.0f)
                lineTo(320.0f, 272.0f)
                lineTo(320.0f, 216.0f)
                curveTo(320.0f, 209.5f, 323.9f, 203.7f, 329.9f, 201.2f)
                curveTo(335.9f, 198.7f, 342.8f, 200.1f, 347.3f, 204.7f)
                lineTo(451.3f, 308.7f)
                curveTo(457.5f, 314.9f, 457.5f, 325.1f, 451.3f, 331.3f)
                close()
            }
        }
        .build()
        return `_arrow-alt-circle-right`!!
    }

private var `_arrow-alt-circle-right`: ImageVector? = null
