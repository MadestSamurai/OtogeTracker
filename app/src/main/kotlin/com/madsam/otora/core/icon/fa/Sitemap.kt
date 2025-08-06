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

public val Fa.Sitemap: ImageVector
    get() {
        if (_sitemap != null) {
            return _sitemap!!
        }
        _sitemap = Builder(name = "Sitemap", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.0f, 128.0f)
                curveTo(256.0f, 110.3f, 270.3f, 96.0f, 288.0f, 96.0f)
                lineTo(352.0f, 96.0f)
                curveTo(369.7f, 96.0f, 384.0f, 110.3f, 384.0f, 128.0f)
                lineTo(384.0f, 192.0f)
                curveTo(384.0f, 209.7f, 369.7f, 224.0f, 352.0f, 224.0f)
                lineTo(344.0f, 224.0f)
                lineTo(344.0f, 288.0f)
                lineTo(464.0f, 288.0f)
                curveTo(503.8f, 288.0f, 536.0f, 320.2f, 536.0f, 360.0f)
                lineTo(536.0f, 416.0f)
                lineTo(544.0f, 416.0f)
                curveTo(561.7f, 416.0f, 576.0f, 430.3f, 576.0f, 448.0f)
                lineTo(576.0f, 512.0f)
                curveTo(576.0f, 529.7f, 561.7f, 544.0f, 544.0f, 544.0f)
                lineTo(480.0f, 544.0f)
                curveTo(462.3f, 544.0f, 448.0f, 529.7f, 448.0f, 512.0f)
                lineTo(448.0f, 448.0f)
                curveTo(448.0f, 430.3f, 462.3f, 416.0f, 480.0f, 416.0f)
                lineTo(488.0f, 416.0f)
                lineTo(488.0f, 360.0f)
                curveTo(488.0f, 346.7f, 477.3f, 336.0f, 464.0f, 336.0f)
                lineTo(344.0f, 336.0f)
                lineTo(344.0f, 416.0f)
                lineTo(352.0f, 416.0f)
                curveTo(369.7f, 416.0f, 384.0f, 430.3f, 384.0f, 448.0f)
                lineTo(384.0f, 512.0f)
                curveTo(384.0f, 529.7f, 369.7f, 544.0f, 352.0f, 544.0f)
                lineTo(288.0f, 544.0f)
                curveTo(270.3f, 544.0f, 256.0f, 529.7f, 256.0f, 512.0f)
                lineTo(256.0f, 448.0f)
                curveTo(256.0f, 430.3f, 270.3f, 416.0f, 288.0f, 416.0f)
                lineTo(296.0f, 416.0f)
                lineTo(296.0f, 336.0f)
                lineTo(176.0f, 336.0f)
                curveTo(162.7f, 336.0f, 152.0f, 346.7f, 152.0f, 360.0f)
                lineTo(152.0f, 416.0f)
                lineTo(160.0f, 416.0f)
                curveTo(177.7f, 416.0f, 192.0f, 430.3f, 192.0f, 448.0f)
                lineTo(192.0f, 512.0f)
                curveTo(192.0f, 529.7f, 177.7f, 544.0f, 160.0f, 544.0f)
                lineTo(96.0f, 544.0f)
                curveTo(78.3f, 544.0f, 64.0f, 529.7f, 64.0f, 512.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 430.3f, 78.3f, 416.0f, 96.0f, 416.0f)
                lineTo(104.0f, 416.0f)
                lineTo(104.0f, 360.0f)
                curveTo(104.0f, 320.2f, 136.2f, 288.0f, 176.0f, 288.0f)
                lineTo(296.0f, 288.0f)
                lineTo(296.0f, 224.0f)
                lineTo(288.0f, 224.0f)
                curveTo(270.3f, 224.0f, 256.0f, 209.7f, 256.0f, 192.0f)
                lineTo(256.0f, 128.0f)
                close()
            }
        }
        .build()
        return _sitemap!!
    }

private var _sitemap: ImageVector? = null
