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

public val Fa.Bus: ImageVector
    get() {
        if (_bus != null) {
            return _bus!!
        }
        _bus = Builder(name = "Bus", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(192.0f, 64.0f)
                curveTo(139.0f, 64.0f, 96.0f, 107.0f, 96.0f, 160.0f)
                lineTo(96.0f, 448.0f)
                curveTo(96.0f, 477.8f, 116.4f, 502.9f, 144.0f, 510.0f)
                lineTo(144.0f, 544.0f)
                curveTo(144.0f, 561.7f, 158.3f, 576.0f, 176.0f, 576.0f)
                lineTo(192.0f, 576.0f)
                curveTo(209.7f, 576.0f, 224.0f, 561.7f, 224.0f, 544.0f)
                lineTo(224.0f, 512.0f)
                lineTo(416.0f, 512.0f)
                lineTo(416.0f, 544.0f)
                curveTo(416.0f, 561.7f, 430.3f, 576.0f, 448.0f, 576.0f)
                lineTo(464.0f, 576.0f)
                curveTo(481.7f, 576.0f, 496.0f, 561.7f, 496.0f, 544.0f)
                lineTo(496.0f, 510.0f)
                curveTo(523.6f, 502.9f, 544.0f, 477.8f, 544.0f, 448.0f)
                lineTo(544.0f, 160.0f)
                curveTo(544.0f, 107.0f, 501.0f, 64.0f, 448.0f, 64.0f)
                lineTo(192.0f, 64.0f)
                close()
                moveTo(160.0f, 240.0f)
                curveTo(160.0f, 222.3f, 174.3f, 208.0f, 192.0f, 208.0f)
                lineTo(296.0f, 208.0f)
                lineTo(296.0f, 320.0f)
                lineTo(192.0f, 320.0f)
                curveTo(174.3f, 320.0f, 160.0f, 305.7f, 160.0f, 288.0f)
                lineTo(160.0f, 240.0f)
                close()
                moveTo(344.0f, 320.0f)
                lineTo(344.0f, 208.0f)
                lineTo(448.0f, 208.0f)
                curveTo(465.7f, 208.0f, 480.0f, 222.3f, 480.0f, 240.0f)
                lineTo(480.0f, 288.0f)
                curveTo(480.0f, 305.7f, 465.7f, 320.0f, 448.0f, 320.0f)
                lineTo(344.0f, 320.0f)
                close()
                moveTo(192.0f, 384.0f)
                curveTo(209.7f, 384.0f, 224.0f, 398.3f, 224.0f, 416.0f)
                curveTo(224.0f, 433.7f, 209.7f, 448.0f, 192.0f, 448.0f)
                curveTo(174.3f, 448.0f, 160.0f, 433.7f, 160.0f, 416.0f)
                curveTo(160.0f, 398.3f, 174.3f, 384.0f, 192.0f, 384.0f)
                close()
                moveTo(448.0f, 384.0f)
                curveTo(465.7f, 384.0f, 480.0f, 398.3f, 480.0f, 416.0f)
                curveTo(480.0f, 433.7f, 465.7f, 448.0f, 448.0f, 448.0f)
                curveTo(430.3f, 448.0f, 416.0f, 433.7f, 416.0f, 416.0f)
                curveTo(416.0f, 398.3f, 430.3f, 384.0f, 448.0f, 384.0f)
                close()
                moveTo(248.0f, 136.0f)
                curveTo(248.0f, 122.7f, 258.7f, 112.0f, 272.0f, 112.0f)
                lineTo(368.0f, 112.0f)
                curveTo(381.3f, 112.0f, 392.0f, 122.7f, 392.0f, 136.0f)
                curveTo(392.0f, 149.3f, 381.3f, 160.0f, 368.0f, 160.0f)
                lineTo(272.0f, 160.0f)
                curveTo(258.7f, 160.0f, 248.0f, 149.3f, 248.0f, 136.0f)
                close()
            }
        }
        .build()
        return _bus!!
    }

private var _bus: ImageVector? = null
