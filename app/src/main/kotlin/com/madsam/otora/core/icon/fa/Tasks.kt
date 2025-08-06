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

public val Fa.Tasks: ImageVector
    get() {
        if (_tasks != null) {
            return _tasks!!
        }
        _tasks = Builder(name = "Tasks", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(197.8f, 100.3f)
                curveTo(208.7f, 107.9f, 211.3f, 122.9f, 203.7f, 133.7f)
                lineTo(147.7f, 213.7f)
                curveTo(143.6f, 219.5f, 137.2f, 223.2f, 130.1f, 223.8f)
                curveTo(123.0f, 224.4f, 116.0f, 222.0f, 111.0f, 217.0f)
                lineTo(71.0f, 177.0f)
                curveTo(61.7f, 167.6f, 61.7f, 152.4f, 71.0f, 143.0f)
                curveTo(80.3f, 133.6f, 95.6f, 133.7f, 105.0f, 143.0f)
                lineTo(124.8f, 162.8f)
                lineTo(164.4f, 106.2f)
                curveTo(172.0f, 95.3f, 187.0f, 92.7f, 197.8f, 100.3f)
                close()
                moveTo(197.8f, 260.3f)
                curveTo(208.7f, 267.9f, 211.3f, 282.9f, 203.7f, 293.7f)
                lineTo(147.7f, 373.7f)
                curveTo(143.6f, 379.5f, 137.2f, 383.2f, 130.1f, 383.8f)
                curveTo(123.0f, 384.4f, 116.0f, 382.0f, 111.0f, 377.0f)
                lineTo(71.0f, 337.0f)
                curveTo(61.6f, 327.6f, 61.6f, 312.4f, 71.0f, 303.1f)
                curveTo(80.4f, 293.8f, 95.6f, 293.7f, 104.9f, 303.1f)
                lineTo(124.7f, 322.9f)
                lineTo(164.3f, 266.3f)
                curveTo(171.9f, 255.4f, 186.9f, 252.8f, 197.7f, 260.4f)
                close()
                moveTo(288.0f, 160.0f)
                curveTo(288.0f, 142.3f, 302.3f, 128.0f, 320.0f, 128.0f)
                lineTo(544.0f, 128.0f)
                curveTo(561.7f, 128.0f, 576.0f, 142.3f, 576.0f, 160.0f)
                curveTo(576.0f, 177.7f, 561.7f, 192.0f, 544.0f, 192.0f)
                lineTo(320.0f, 192.0f)
                curveTo(302.3f, 192.0f, 288.0f, 177.7f, 288.0f, 160.0f)
                close()
                moveTo(288.0f, 320.0f)
                curveTo(288.0f, 302.3f, 302.3f, 288.0f, 320.0f, 288.0f)
                lineTo(544.0f, 288.0f)
                curveTo(561.7f, 288.0f, 576.0f, 302.3f, 576.0f, 320.0f)
                curveTo(576.0f, 337.7f, 561.7f, 352.0f, 544.0f, 352.0f)
                lineTo(320.0f, 352.0f)
                curveTo(302.3f, 352.0f, 288.0f, 337.7f, 288.0f, 320.0f)
                close()
                moveTo(224.0f, 480.0f)
                curveTo(224.0f, 462.3f, 238.3f, 448.0f, 256.0f, 448.0f)
                lineTo(544.0f, 448.0f)
                curveTo(561.7f, 448.0f, 576.0f, 462.3f, 576.0f, 480.0f)
                curveTo(576.0f, 497.7f, 561.7f, 512.0f, 544.0f, 512.0f)
                lineTo(256.0f, 512.0f)
                curveTo(238.3f, 512.0f, 224.0f, 497.7f, 224.0f, 480.0f)
                close()
                moveTo(128.0f, 440.0f)
                curveTo(150.1f, 440.0f, 168.0f, 457.9f, 168.0f, 480.0f)
                curveTo(168.0f, 502.1f, 150.1f, 520.0f, 128.0f, 520.0f)
                curveTo(105.9f, 520.0f, 88.0f, 502.1f, 88.0f, 480.0f)
                curveTo(88.0f, 457.9f, 105.9f, 440.0f, 128.0f, 440.0f)
                close()
            }
        }
        .build()
        return _tasks!!
    }

private var _tasks: ImageVector? = null
