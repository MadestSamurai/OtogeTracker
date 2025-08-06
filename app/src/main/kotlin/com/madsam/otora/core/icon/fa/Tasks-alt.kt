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

public val Fa.`Tasks-alt`: ImageVector
    get() {
        if (`_tasks-alt` != null) {
            return `_tasks-alt`!!
        }
        `_tasks-alt` = Builder(name = "Tasks-alt", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.0f, 224.0f)
                lineTo(480.0f, 224.0f)
                lineTo(480.0f, 160.0f)
                lineTo(384.0f, 160.0f)
                lineTo(384.0f, 224.0f)
                close()
                moveTo(96.0f, 224.0f)
                lineTo(96.0f, 144.0f)
                curveTo(96.0f, 117.5f, 117.5f, 96.0f, 144.0f, 96.0f)
                lineTo(496.0f, 96.0f)
                curveTo(522.5f, 96.0f, 544.0f, 117.5f, 544.0f, 144.0f)
                lineTo(544.0f, 240.0f)
                curveTo(544.0f, 266.5f, 522.5f, 288.0f, 496.0f, 288.0f)
                lineTo(144.0f, 288.0f)
                curveTo(117.5f, 288.0f, 96.0f, 266.5f, 96.0f, 240.0f)
                lineTo(96.0f, 224.0f)
                close()
                moveTo(256.0f, 480.0f)
                lineTo(480.0f, 480.0f)
                lineTo(480.0f, 416.0f)
                lineTo(256.0f, 416.0f)
                lineTo(256.0f, 480.0f)
                close()
                moveTo(96.0f, 480.0f)
                lineTo(96.0f, 400.0f)
                curveTo(96.0f, 373.5f, 117.5f, 352.0f, 144.0f, 352.0f)
                lineTo(496.0f, 352.0f)
                curveTo(522.5f, 352.0f, 544.0f, 373.5f, 544.0f, 400.0f)
                lineTo(544.0f, 496.0f)
                curveTo(544.0f, 522.5f, 522.5f, 544.0f, 496.0f, 544.0f)
                lineTo(144.0f, 544.0f)
                curveTo(117.5f, 544.0f, 96.0f, 522.5f, 96.0f, 496.0f)
                lineTo(96.0f, 480.0f)
                close()
            }
        }
        .build()
        return `_tasks-alt`!!
    }

private var `_tasks-alt`: ImageVector? = null
