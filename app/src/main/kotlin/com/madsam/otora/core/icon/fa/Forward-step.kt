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

public val Fa.`Forward-step`: ImageVector
    get() {
        if (`_forward-step` != null) {
            return `_forward-step`!!
        }
        `_forward-step` = Builder(name = "Forward-step", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(149.0f, 100.8f)
                curveTo(161.9f, 93.8f, 177.7f, 94.5f, 190.0f, 102.6f)
                lineTo(448.0f, 272.1f)
                lineTo(448.0f, 128.0f)
                curveTo(448.0f, 110.3f, 462.3f, 96.0f, 480.0f, 96.0f)
                curveTo(497.7f, 96.0f, 512.0f, 110.3f, 512.0f, 128.0f)
                lineTo(512.0f, 512.0f)
                curveTo(512.0f, 529.7f, 497.7f, 544.0f, 480.0f, 544.0f)
                curveTo(462.3f, 544.0f, 448.0f, 529.7f, 448.0f, 512.0f)
                lineTo(448.0f, 367.9f)
                lineTo(190.0f, 537.5f)
                curveTo(177.7f, 545.6f, 162.0f, 546.3f, 149.0f, 539.3f)
                curveTo(136.0f, 532.3f, 128.0f, 518.7f, 128.0f, 504.0f)
                lineTo(128.0f, 136.0f)
                curveTo(128.0f, 121.3f, 136.1f, 107.8f, 149.0f, 100.8f)
                close()
            }
        }
        .build()
        return `_forward-step`!!
    }

private var `_forward-step`: ImageVector? = null
