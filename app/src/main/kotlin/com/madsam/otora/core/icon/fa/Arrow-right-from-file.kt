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

public val Fa.`Arrow-right-from-file`: ImageVector
    get() {
        if (`_arrow-right-from-file` != null) {
            return `_arrow-right-from-file`!!
        }
        `_arrow-right-from-file` = Builder(name = "Arrow-right-from-file", defaultWidth = 640.0.dp,
                defaultHeight = 640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.5f, 64.0f)
                curveTo(93.2f, 64.0f, 64.5f, 92.7f, 64.5f, 128.0f)
                lineTo(64.5f, 512.0f)
                curveTo(64.5f, 547.3f, 93.2f, 576.0f, 128.5f, 576.0f)
                lineTo(384.5f, 576.0f)
                curveTo(419.8f, 576.0f, 448.5f, 547.3f, 448.5f, 512.0f)
                lineTo(448.5f, 416.0f)
                lineTo(526.6f, 416.0f)
                lineTo(495.6f, 447.0f)
                curveTo(486.2f, 456.4f, 486.2f, 471.6f, 495.6f, 480.9f)
                curveTo(505.0f, 490.2f, 520.2f, 490.3f, 529.5f, 480.9f)
                lineTo(601.5f, 408.9f)
                curveTo(610.9f, 399.5f, 610.9f, 384.3f, 601.5f, 375.0f)
                lineTo(529.5f, 303.0f)
                curveTo(520.1f, 293.6f, 504.9f, 293.6f, 495.6f, 303.0f)
                curveTo(486.3f, 312.4f, 486.2f, 327.6f, 495.6f, 336.9f)
                lineTo(526.6f, 367.9f)
                lineTo(448.5f, 367.9f)
                lineTo(448.5f, 234.4f)
                curveTo(448.5f, 217.4f, 441.8f, 201.1f, 429.8f, 189.1f)
                lineTo(323.2f, 82.7f)
                curveTo(311.2f, 70.7f, 295.0f, 64.0f, 278.0f, 64.0f)
                lineTo(128.5f, 64.0f)
                close()
                moveTo(390.0f, 240.0f)
                lineTo(296.5f, 240.0f)
                curveTo(283.2f, 240.0f, 272.5f, 229.3f, 272.5f, 216.0f)
                lineTo(272.5f, 122.5f)
                lineTo(390.0f, 240.0f)
                close()
                moveTo(256.5f, 392.0f)
                curveTo(256.5f, 378.7f, 267.2f, 368.0f, 280.5f, 368.0f)
                lineTo(384.5f, 368.0f)
                lineTo(384.5f, 416.0f)
                lineTo(280.5f, 416.0f)
                curveTo(267.2f, 416.0f, 256.5f, 405.3f, 256.5f, 392.0f)
                close()
            }
        }
        .build()
        return `_arrow-right-from-file`!!
    }

private var `_arrow-right-from-file`: ImageVector? = null
