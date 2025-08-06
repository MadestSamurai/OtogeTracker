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

public val Fa.Horse: ImageVector
    get() {
        if (_horse != null) {
            return _horse!!
        }
        _horse = Builder(name = "Horse", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 302.1f)
                lineTo(480.0f, 224.0f)
                lineTo(496.0f, 224.0f)
                lineTo(505.8f, 243.6f)
                curveTo(518.3f, 268.7f, 548.0f, 280.0f, 574.1f, 269.6f)
                curveTo(594.6f, 261.4f, 608.0f, 241.6f, 608.0f, 219.5f)
                lineTo(608.0f, 144.0f)
                curveTo(608.0f, 124.9f, 599.6f, 107.7f, 586.3f, 96.0f)
                lineTo(592.0f, 96.0f)
                curveTo(600.8f, 96.0f, 608.0f, 88.8f, 608.0f, 80.0f)
                curveTo(608.0f, 71.2f, 600.8f, 64.0f, 592.0f, 64.0f)
                lineTo(480.0f, 64.0f)
                curveTo(409.3f, 64.0f, 352.0f, 121.3f, 352.0f, 192.0f)
                lineTo(180.8f, 192.0f)
                curveTo(150.1f, 192.0f, 123.2f, 208.3f, 108.3f, 232.8f)
                curveTo(65.2f, 238.5f, 32.0f, 275.4f, 32.0f, 320.0f)
                lineTo(32.0f, 376.0f)
                curveTo(32.0f, 389.3f, 42.7f, 400.0f, 56.0f, 400.0f)
                curveTo(69.3f, 400.0f, 80.0f, 389.3f, 80.0f, 376.0f)
                lineTo(80.0f, 320.0f)
                curveTo(80.0f, 306.6f, 86.6f, 294.8f, 96.7f, 287.5f)
                curveTo(98.3f, 300.5f, 103.0f, 312.9f, 110.3f, 323.9f)
                lineTo(138.5f, 366.3f)
                curveTo(146.8f, 378.7f, 144.9f, 395.0f, 137.3f, 407.9f)
                curveTo(120.8f, 435.9f, 116.7f, 470.1f, 127.3f, 501.8f)
                lineTo(144.8f, 554.2f)
                curveTo(149.2f, 567.3f, 161.4f, 576.1f, 175.2f, 576.1f)
                lineTo(208.9f, 576.1f)
                curveTo(230.7f, 576.1f, 246.2f, 554.7f, 239.3f, 534.0f)
                lineTo(218.5f, 471.5f)
                curveTo(216.4f, 465.1f, 218.0f, 458.1f, 222.8f, 453.3f)
                lineTo(235.5f, 440.6f)
                curveTo(248.7f, 427.4f, 256.1f, 409.5f, 256.1f, 390.9f)
                curveTo(256.1f, 388.6f, 256.0f, 386.3f, 255.8f, 384.0f)
                lineTo(339.8f, 408.0f)
                curveTo(343.9f, 409.2f, 348.0f, 410.1f, 352.1f, 410.8f)
                lineTo(352.0f, 544.0f)
                curveTo(352.0f, 561.7f, 366.3f, 576.0f, 384.0f, 576.0f)
                lineTo(416.0f, 576.0f)
                curveTo(433.7f, 576.0f, 448.0f, 561.7f, 448.0f, 544.0f)
                lineTo(448.0f, 379.7f)
                curveTo(467.2f, 360.5f, 479.5f, 334.0f, 480.0f, 304.0f)
                lineTo(480.0f, 304.0f)
                lineTo(480.0f, 302.1f)
                close()
                moveTo(528.0f, 128.0f)
                curveTo(536.8f, 128.0f, 544.0f, 135.2f, 544.0f, 144.0f)
                curveTo(544.0f, 152.8f, 536.8f, 160.0f, 528.0f, 160.0f)
                curveTo(519.2f, 160.0f, 512.0f, 152.8f, 512.0f, 144.0f)
                curveTo(512.0f, 135.2f, 519.2f, 128.0f, 528.0f, 128.0f)
                close()
            }
        }
        .build()
        return _horse!!
    }

private var _horse: ImageVector? = null
