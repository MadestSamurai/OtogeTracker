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

public val Fa.`Road-spikes`: ImageVector
    get() {
        if (`_road-spikes` != null) {
            return `_road-spikes`!!
        }
        `_road-spikes` = Builder(name = "Road-spikes", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(64.0f, 180.8f)
                curveTo(64.0f, 165.0f, 84.5f, 158.8f, 93.3f, 171.9f)
                lineTo(192.0f, 319.9f)
                lineTo(192.0f, 180.7f)
                curveTo(192.0f, 164.9f, 212.5f, 158.7f, 221.3f, 171.8f)
                lineTo(320.0f, 319.8f)
                lineTo(320.0f, 180.6f)
                curveTo(320.0f, 164.8f, 340.5f, 158.6f, 349.3f, 171.7f)
                lineTo(448.0f, 319.7f)
                lineTo(448.0f, 180.5f)
                curveTo(448.0f, 164.7f, 468.5f, 158.5f, 477.3f, 171.6f)
                lineTo(606.8f, 366.2f)
                curveTo(621.0f, 387.5f, 605.7f, 416.0f, 580.2f, 416.0f)
                lineTo(64.0f, 416.0f)
                lineTo(64.0f, 180.8f)
                close()
                moveTo(32.0f, 448.0f)
                lineTo(608.0f, 448.0f)
                curveTo(625.7f, 448.0f, 640.0f, 462.3f, 640.0f, 480.0f)
                curveTo(640.0f, 497.7f, 625.7f, 512.0f, 608.0f, 512.0f)
                lineTo(32.0f, 512.0f)
                curveTo(14.3f, 512.0f, 0.0f, 497.7f, 0.0f, 480.0f)
                curveTo(0.0f, 462.3f, 14.3f, 448.0f, 32.0f, 448.0f)
                close()
            }
        }
        .build()
        return `_road-spikes`!!
    }

private var `_road-spikes`: ImageVector? = null
