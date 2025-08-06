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

public val Fa.Headset: ImageVector
    get() {
        if (_headset != null) {
            return _headset!!
        }
        _headset = Builder(name = "Headset", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 128.0f)
                curveTo(241.0f, 128.0f, 175.3f, 185.3f, 162.3f, 260.7f)
                curveTo(171.6f, 257.7f, 181.6f, 256.0f, 192.0f, 256.0f)
                lineTo(208.0f, 256.0f)
                curveTo(234.5f, 256.0f, 256.0f, 277.5f, 256.0f, 304.0f)
                lineTo(256.0f, 400.0f)
                curveTo(256.0f, 426.5f, 234.5f, 448.0f, 208.0f, 448.0f)
                lineTo(192.0f, 448.0f)
                curveTo(139.0f, 448.0f, 96.0f, 405.0f, 96.0f, 352.0f)
                lineTo(96.0f, 288.0f)
                curveTo(96.0f, 164.3f, 196.3f, 64.0f, 320.0f, 64.0f)
                curveTo(443.7f, 64.0f, 544.0f, 164.3f, 544.0f, 288.0f)
                lineTo(544.0f, 456.1f)
                curveTo(544.0f, 522.4f, 490.2f, 576.1f, 423.9f, 576.1f)
                lineTo(336.0f, 576.0f)
                lineTo(304.0f, 576.0f)
                curveTo(277.5f, 576.0f, 256.0f, 554.5f, 256.0f, 528.0f)
                curveTo(256.0f, 501.5f, 277.5f, 480.0f, 304.0f, 480.0f)
                lineTo(336.0f, 480.0f)
                curveTo(362.5f, 480.0f, 384.0f, 501.5f, 384.0f, 528.0f)
                lineTo(384.0f, 528.0f)
                lineTo(424.0f, 528.0f)
                curveTo(463.8f, 528.0f, 496.0f, 495.8f, 496.0f, 456.0f)
                lineTo(496.0f, 435.1f)
                curveTo(481.9f, 443.3f, 465.5f, 447.9f, 448.0f, 447.9f)
                lineTo(432.0f, 447.9f)
                curveTo(405.5f, 447.9f, 384.0f, 426.4f, 384.0f, 399.9f)
                lineTo(384.0f, 303.9f)
                curveTo(384.0f, 277.4f, 405.5f, 255.9f, 432.0f, 255.9f)
                lineTo(448.0f, 255.9f)
                curveTo(458.4f, 255.9f, 468.3f, 257.5f, 477.7f, 260.6f)
                curveTo(464.7f, 185.3f, 399.1f, 127.9f, 320.0f, 127.9f)
                close()
            }
        }
        .build()
        return _headset!!
    }

private var _headset: ImageVector? = null
