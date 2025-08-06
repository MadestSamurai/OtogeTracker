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

public val Fa.Wallet: ImageVector
    get() {
        if (_wallet != null) {
            return _wallet!!
        }
        _wallet = Builder(name = "Wallet", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(128.0f, 96.0f)
                curveTo(92.7f, 96.0f, 64.0f, 124.7f, 64.0f, 160.0f)
                lineTo(64.0f, 448.0f)
                curveTo(64.0f, 483.3f, 92.7f, 512.0f, 128.0f, 512.0f)
                lineTo(512.0f, 512.0f)
                curveTo(547.3f, 512.0f, 576.0f, 483.3f, 576.0f, 448.0f)
                lineTo(576.0f, 256.0f)
                curveTo(576.0f, 220.7f, 547.3f, 192.0f, 512.0f, 192.0f)
                lineTo(136.0f, 192.0f)
                curveTo(122.7f, 192.0f, 112.0f, 181.3f, 112.0f, 168.0f)
                curveTo(112.0f, 154.7f, 122.7f, 144.0f, 136.0f, 144.0f)
                lineTo(520.0f, 144.0f)
                curveTo(533.3f, 144.0f, 544.0f, 133.3f, 544.0f, 120.0f)
                curveTo(544.0f, 106.7f, 533.3f, 96.0f, 520.0f, 96.0f)
                lineTo(128.0f, 96.0f)
                close()
                moveTo(480.0f, 320.0f)
                curveTo(497.7f, 320.0f, 512.0f, 334.3f, 512.0f, 352.0f)
                curveTo(512.0f, 369.7f, 497.7f, 384.0f, 480.0f, 384.0f)
                curveTo(462.3f, 384.0f, 448.0f, 369.7f, 448.0f, 352.0f)
                curveTo(448.0f, 334.3f, 462.3f, 320.0f, 480.0f, 320.0f)
                close()
            }
        }
        .build()
        return _wallet!!
    }

private var _wallet: ImageVector? = null
