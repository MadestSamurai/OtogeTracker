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

public val Fa.`Up-down`: ImageVector
    get() {
        if (`_up-down` != null) {
            return `_up-down`!!
        }
        `_up-down` = Builder(name = "Up-down", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(470.6f, 566.6f)
                lineTo(566.6f, 470.6f)
                curveTo(575.8f, 461.4f, 578.5f, 447.7f, 573.5f, 435.7f)
                curveTo(568.5f, 423.7f, 556.9f, 416.0f, 544.0f, 416.0f)
                lineTo(480.0f, 416.0f)
                lineTo(480.0f, 96.0f)
                curveTo(480.0f, 78.3f, 465.7f, 64.0f, 448.0f, 64.0f)
                curveTo(430.3f, 64.0f, 416.0f, 78.3f, 416.0f, 96.0f)
                lineTo(416.0f, 416.0f)
                lineTo(352.0f, 416.0f)
                curveTo(339.1f, 416.0f, 327.4f, 423.8f, 322.4f, 435.8f)
                curveTo(317.4f, 447.8f, 320.2f, 461.5f, 329.3f, 470.7f)
                lineTo(425.3f, 566.7f)
                curveTo(437.8f, 579.2f, 458.1f, 579.2f, 470.6f, 566.7f)
                close()
                moveTo(214.6f, 73.4f)
                curveTo(202.1f, 60.9f, 181.8f, 60.9f, 169.3f, 73.4f)
                lineTo(73.3f, 169.4f)
                curveTo(64.1f, 178.6f, 61.4f, 192.3f, 66.4f, 204.3f)
                curveTo(71.4f, 216.3f, 83.1f, 224.0f, 96.0f, 224.0f)
                lineTo(160.0f, 224.0f)
                lineTo(160.0f, 544.0f)
                curveTo(160.0f, 561.7f, 174.3f, 576.0f, 192.0f, 576.0f)
                curveTo(209.7f, 576.0f, 224.0f, 561.7f, 224.0f, 544.0f)
                lineTo(224.0f, 224.0f)
                lineTo(288.0f, 224.0f)
                curveTo(300.9f, 224.0f, 312.6f, 216.2f, 317.6f, 204.2f)
                curveTo(322.6f, 192.2f, 319.8f, 178.5f, 310.7f, 169.3f)
                lineTo(214.7f, 73.3f)
                close()
            }
        }
        .build()
        return `_up-down`!!
    }

private var `_up-down`: ImageVector? = null
