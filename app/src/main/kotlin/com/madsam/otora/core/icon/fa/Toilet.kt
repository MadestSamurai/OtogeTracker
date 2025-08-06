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

public val Fa.Toilet: ImageVector
    get() {
        if (_toilet != null) {
            return _toilet!!
        }
        _toilet = Builder(name = "Toilet", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(120.0f, 64.0f)
                curveTo(106.7f, 64.0f, 96.0f, 74.7f, 96.0f, 88.0f)
                curveTo(96.0f, 101.3f, 106.7f, 112.0f, 120.0f, 112.0f)
                lineTo(128.0f, 112.0f)
                lineTo(128.0f, 260.9f)
                curveTo(126.1f, 262.3f, 124.2f, 263.8f, 122.4f, 265.3f)
                curveTo(106.9f, 278.5f, 96.0f, 296.9f, 96.0f, 319.9f)
                curveTo(96.0f, 366.8f, 110.3f, 404.0f, 133.0f, 432.4f)
                curveTo(147.2f, 450.1f, 164.1f, 463.7f, 181.5f, 474.2f)
                lineTo(161.6f, 533.9f)
                curveTo(158.3f, 543.7f, 160.0f, 554.4f, 166.0f, 562.7f)
                curveTo(172.0f, 571.0f, 181.7f, 576.0f, 192.0f, 576.0f)
                lineTo(448.0f, 576.0f)
                curveTo(458.3f, 576.0f, 467.9f, 571.1f, 474.0f, 562.7f)
                curveTo(480.1f, 554.3f, 481.7f, 543.6f, 478.4f, 533.9f)
                lineTo(458.6f, 474.4f)
                curveTo(476.0f, 463.9f, 492.9f, 450.3f, 507.1f, 432.6f)
                curveTo(529.8f, 404.2f, 544.1f, 367.1f, 544.1f, 320.1f)
                curveTo(544.1f, 297.0f, 533.2f, 278.6f, 517.7f, 265.5f)
                curveTo(515.9f, 264.0f, 514.0f, 262.5f, 512.1f, 261.1f)
                lineTo(512.1f, 112.2f)
                lineTo(520.1f, 112.2f)
                curveTo(533.4f, 112.2f, 544.1f, 101.5f, 544.1f, 88.2f)
                curveTo(544.1f, 74.9f, 533.3f, 64.0f, 520.0f, 64.0f)
                lineTo(120.0f, 64.0f)
                close()
                moveTo(192.0f, 144.0f)
                curveTo(192.0f, 135.2f, 199.2f, 128.0f, 208.0f, 128.0f)
                lineTo(240.0f, 128.0f)
                curveTo(248.8f, 128.0f, 256.0f, 135.2f, 256.0f, 144.0f)
                curveTo(256.0f, 152.8f, 248.8f, 160.0f, 240.0f, 160.0f)
                lineTo(208.0f, 160.0f)
                curveTo(199.2f, 160.0f, 192.0f, 152.8f, 192.0f, 144.0f)
                close()
                moveTo(320.0f, 352.0f)
                curveTo(231.6f, 352.0f, 160.0f, 337.7f, 160.0f, 320.0f)
                curveTo(160.0f, 302.3f, 231.6f, 288.0f, 320.0f, 288.0f)
                curveTo(408.4f, 288.0f, 480.0f, 302.3f, 480.0f, 320.0f)
                curveTo(480.0f, 337.7f, 408.4f, 352.0f, 320.0f, 352.0f)
                close()
            }
        }
        .build()
        return _toilet!!
    }

private var _toilet: ImageVector? = null
