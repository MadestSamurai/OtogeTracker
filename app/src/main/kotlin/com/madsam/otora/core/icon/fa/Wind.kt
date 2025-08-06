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

public val Fa.Wind: ImageVector
    get() {
        if (_wind != null) {
            return _wind!!
        }
        _wind = Builder(name = "Wind", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(352.0f, 96.0f)
                curveTo(352.0f, 113.7f, 366.3f, 128.0f, 384.0f, 128.0f)
                lineTo(424.0f, 128.0f)
                curveTo(437.3f, 128.0f, 448.0f, 138.7f, 448.0f, 152.0f)
                curveTo(448.0f, 165.3f, 437.3f, 176.0f, 424.0f, 176.0f)
                lineTo(96.0f, 176.0f)
                curveTo(78.3f, 176.0f, 64.0f, 190.3f, 64.0f, 208.0f)
                curveTo(64.0f, 225.7f, 78.3f, 240.0f, 96.0f, 240.0f)
                lineTo(424.0f, 240.0f)
                curveTo(472.6f, 240.0f, 512.0f, 200.6f, 512.0f, 152.0f)
                curveTo(512.0f, 103.4f, 472.6f, 64.0f, 424.0f, 64.0f)
                lineTo(384.0f, 64.0f)
                curveTo(366.3f, 64.0f, 352.0f, 78.3f, 352.0f, 96.0f)
                close()
                moveTo(416.0f, 448.0f)
                curveTo(416.0f, 465.7f, 430.3f, 480.0f, 448.0f, 480.0f)
                lineTo(480.0f, 480.0f)
                curveTo(533.0f, 480.0f, 576.0f, 437.0f, 576.0f, 384.0f)
                curveTo(576.0f, 331.0f, 533.0f, 288.0f, 480.0f, 288.0f)
                lineTo(96.0f, 288.0f)
                curveTo(78.3f, 288.0f, 64.0f, 302.3f, 64.0f, 320.0f)
                curveTo(64.0f, 337.7f, 78.3f, 352.0f, 96.0f, 352.0f)
                lineTo(480.0f, 352.0f)
                curveTo(497.7f, 352.0f, 512.0f, 366.3f, 512.0f, 384.0f)
                curveTo(512.0f, 401.7f, 497.7f, 416.0f, 480.0f, 416.0f)
                lineTo(448.0f, 416.0f)
                curveTo(430.3f, 416.0f, 416.0f, 430.3f, 416.0f, 448.0f)
                close()
                moveTo(192.0f, 576.0f)
                lineTo(232.0f, 576.0f)
                curveTo(280.6f, 576.0f, 320.0f, 536.6f, 320.0f, 488.0f)
                curveTo(320.0f, 439.4f, 280.6f, 400.0f, 232.0f, 400.0f)
                lineTo(96.0f, 400.0f)
                curveTo(78.3f, 400.0f, 64.0f, 414.3f, 64.0f, 432.0f)
                curveTo(64.0f, 449.7f, 78.3f, 464.0f, 96.0f, 464.0f)
                lineTo(232.0f, 464.0f)
                curveTo(245.3f, 464.0f, 256.0f, 474.7f, 256.0f, 488.0f)
                curveTo(256.0f, 501.3f, 245.3f, 512.0f, 232.0f, 512.0f)
                lineTo(192.0f, 512.0f)
                curveTo(174.3f, 512.0f, 160.0f, 526.3f, 160.0f, 544.0f)
                curveTo(160.0f, 561.7f, 174.3f, 576.0f, 192.0f, 576.0f)
                close()
            }
        }
        .build()
        return _wind!!
    }

private var _wind: ImageVector? = null
