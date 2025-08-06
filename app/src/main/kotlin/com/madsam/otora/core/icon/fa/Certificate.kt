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

public val Fa.Certificate: ImageVector
    get() {
        if (_certificate != null) {
            return _certificate!!
        }
        _certificate = Builder(name = "Certificate", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(271.2f, 56.0f)
                curveTo(265.1f, 49.8f, 256.2f, 47.3f, 247.8f, 49.6f)
                curveTo(239.4f, 51.9f, 232.9f, 58.4f, 230.8f, 66.8f)
                lineTo(215.5f, 127.0f)
                curveTo(214.4f, 131.4f, 209.9f, 134.0f, 205.6f, 132.7f)
                lineTo(145.8f, 115.9f)
                curveTo(137.4f, 113.5f, 128.4f, 115.9f, 122.3f, 122.0f)
                curveTo(116.2f, 128.1f, 113.8f, 137.1f, 116.2f, 145.5f)
                lineTo(133.1f, 205.3f)
                curveTo(134.3f, 209.6f, 131.7f, 214.1f, 127.4f, 215.2f)
                lineTo(67.1f, 230.5f)
                curveTo(58.7f, 232.6f, 52.1f, 239.2f, 49.8f, 247.6f)
                curveTo(47.5f, 256.0f, 50.0f, 264.9f, 56.2f, 271.0f)
                lineTo(100.7f, 314.3f)
                curveTo(103.9f, 317.4f, 103.9f, 322.6f, 100.7f, 325.8f)
                lineTo(56.3f, 369.1f)
                curveTo(50.1f, 375.2f, 47.6f, 384.1f, 49.9f, 392.5f)
                curveTo(52.2f, 400.9f, 58.8f, 407.4f, 67.2f, 409.6f)
                lineTo(127.4f, 424.9f)
                curveTo(131.8f, 426.0f, 134.4f, 430.5f, 133.1f, 434.8f)
                lineTo(116.2f, 494.5f)
                curveTo(113.8f, 502.9f, 116.2f, 511.9f, 122.3f, 518.0f)
                curveTo(128.4f, 524.1f, 137.4f, 526.5f, 145.8f, 524.1f)
                lineTo(205.6f, 507.2f)
                curveTo(209.9f, 506.0f, 214.4f, 508.6f, 215.5f, 512.9f)
                lineTo(230.8f, 573.1f)
                curveTo(232.9f, 581.5f, 239.5f, 588.1f, 247.9f, 590.4f)
                curveTo(256.3f, 592.7f, 265.2f, 590.2f, 271.3f, 584.0f)
                lineTo(314.6f, 539.5f)
                curveTo(317.7f, 536.3f, 322.9f, 536.3f, 326.1f, 539.5f)
                lineTo(369.3f, 584.0f)
                curveTo(375.4f, 590.2f, 384.3f, 592.7f, 392.7f, 590.4f)
                curveTo(401.1f, 588.1f, 407.6f, 581.5f, 409.8f, 573.1f)
                lineTo(425.1f, 513.0f)
                curveTo(426.2f, 508.6f, 430.7f, 506.0f, 435.0f, 507.3f)
                lineTo(494.8f, 524.2f)
                curveTo(503.2f, 526.6f, 512.2f, 524.2f, 518.3f, 518.1f)
                curveTo(524.4f, 512.0f, 526.8f, 503.0f, 524.4f, 494.6f)
                lineTo(507.5f, 434.8f)
                curveTo(506.3f, 430.5f, 508.9f, 426.0f, 513.2f, 424.9f)
                lineTo(573.4f, 409.6f)
                curveTo(581.8f, 407.5f, 588.4f, 400.9f, 590.7f, 392.5f)
                curveTo(593.0f, 384.1f, 590.5f, 375.1f, 584.3f, 369.1f)
                lineTo(539.8f, 325.8f)
                curveTo(536.6f, 322.7f, 536.6f, 317.5f, 539.8f, 314.3f)
                lineTo(584.3f, 271.0f)
                curveTo(590.5f, 264.9f, 593.0f, 256.0f, 590.7f, 247.6f)
                curveTo(588.4f, 239.2f, 581.8f, 232.7f, 573.4f, 230.5f)
                lineTo(513.2f, 215.2f)
                curveTo(508.8f, 214.1f, 506.2f, 209.6f, 507.5f, 205.3f)
                lineTo(524.4f, 145.5f)
                curveTo(526.8f, 137.1f, 524.4f, 128.1f, 518.3f, 122.0f)
                curveTo(512.2f, 115.9f, 503.2f, 113.5f, 494.8f, 115.9f)
                lineTo(435.0f, 132.8f)
                curveTo(430.7f, 134.0f, 426.2f, 131.4f, 425.1f, 127.1f)
                lineTo(409.8f, 66.8f)
                curveTo(407.7f, 58.4f, 401.1f, 51.8f, 392.7f, 49.5f)
                curveTo(384.3f, 47.2f, 375.4f, 49.7f, 369.3f, 55.9f)
                lineTo(326.0f, 100.5f)
                curveTo(322.9f, 103.7f, 317.7f, 103.7f, 314.5f, 100.5f)
                lineTo(271.2f, 56.0f)
                close()
            }
        }
        .build()
        return _certificate!!
    }

private var _certificate: ImageVector? = null
