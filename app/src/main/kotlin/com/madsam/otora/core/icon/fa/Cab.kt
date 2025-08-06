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

public val Fa.Cab: ImageVector
    get() {
        if (_cab != null) {
            return _cab!!
        }
        _cab = Builder(name = "Cab", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 64.0f)
                curveTo(238.3f, 64.0f, 224.0f, 78.3f, 224.0f, 96.0f)
                lineTo(224.0f, 128.0f)
                lineTo(215.1f, 128.0f)
                curveTo(173.1f, 128.0f, 136.0f, 155.3f, 123.5f, 195.4f)
                lineTo(100.5f, 268.9f)
                curveTo(78.5f, 283.1f, 64.0f, 307.9f, 64.0f, 336.0f)
                lineTo(64.0f, 512.0f)
                curveTo(64.0f, 529.7f, 78.3f, 544.0f, 96.0f, 544.0f)
                lineTo(128.0f, 544.0f)
                curveTo(145.7f, 544.0f, 160.0f, 529.7f, 160.0f, 512.0f)
                lineTo(160.0f, 480.0f)
                lineTo(480.0f, 480.0f)
                lineTo(480.0f, 512.0f)
                curveTo(480.0f, 529.7f, 494.3f, 544.0f, 512.0f, 544.0f)
                lineTo(544.0f, 544.0f)
                curveTo(561.7f, 544.0f, 576.0f, 529.7f, 576.0f, 512.0f)
                lineTo(576.0f, 336.0f)
                curveTo(576.0f, 307.9f, 561.5f, 283.1f, 539.6f, 268.9f)
                lineTo(516.6f, 195.4f)
                curveTo(504.1f, 155.3f, 466.9f, 128.0f, 424.9f, 128.0f)
                lineTo(416.0f, 128.0f)
                lineTo(416.0f, 96.0f)
                curveTo(416.0f, 78.3f, 401.7f, 64.0f, 384.0f, 64.0f)
                lineTo(256.0f, 64.0f)
                close()
                moveTo(215.1f, 192.0f)
                lineTo(425.0f, 192.0f)
                curveTo(439.0f, 192.0f, 451.4f, 201.1f, 455.5f, 214.5f)
                lineTo(468.5f, 256.0f)
                lineTo(171.6f, 256.0f)
                lineTo(184.6f, 214.5f)
                curveTo(188.8f, 201.1f, 201.1f, 192.0f, 215.1f, 192.0f)
                close()
                moveTo(160.0f, 336.0f)
                curveTo(177.7f, 336.0f, 192.0f, 350.3f, 192.0f, 368.0f)
                curveTo(192.0f, 385.7f, 177.7f, 400.0f, 160.0f, 400.0f)
                curveTo(142.3f, 400.0f, 128.0f, 385.7f, 128.0f, 368.0f)
                curveTo(128.0f, 350.3f, 142.3f, 336.0f, 160.0f, 336.0f)
                close()
                moveTo(448.0f, 368.0f)
                curveTo(448.0f, 350.3f, 462.3f, 336.0f, 480.0f, 336.0f)
                curveTo(497.7f, 336.0f, 512.0f, 350.3f, 512.0f, 368.0f)
                curveTo(512.0f, 385.7f, 497.7f, 400.0f, 480.0f, 400.0f)
                curveTo(462.3f, 400.0f, 448.0f, 385.7f, 448.0f, 368.0f)
                close()
            }
        }
        .build()
        return _cab!!
    }

private var _cab: ImageVector? = null
