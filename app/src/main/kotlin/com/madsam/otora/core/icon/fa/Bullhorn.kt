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

public val Fa.Bullhorn: ImageVector
    get() {
        if (_bullhorn != null) {
            return _bullhorn!!
        }
        _bullhorn = Builder(name = "Bullhorn", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(525.2f, 82.9f)
                curveTo(536.7f, 88.0f, 544.0f, 99.4f, 544.0f, 112.0f)
                lineTo(544.0f, 528.0f)
                curveTo(544.0f, 540.6f, 536.7f, 552.0f, 525.2f, 557.1f)
                curveTo(513.7f, 562.2f, 500.4f, 560.3f, 490.9f, 552.0f)
                lineTo(444.3f, 511.3f)
                curveTo(400.7f, 473.2f, 345.6f, 451.0f, 287.9f, 448.3f)
                lineTo(287.9f, 544.0f)
                curveTo(287.9f, 561.7f, 273.6f, 576.0f, 255.9f, 576.0f)
                lineTo(223.9f, 576.0f)
                curveTo(206.2f, 576.0f, 191.9f, 561.7f, 191.9f, 544.0f)
                lineTo(191.9f, 448.0f)
                curveTo(121.3f, 448.0f, 64.0f, 390.7f, 64.0f, 320.0f)
                curveTo(64.0f, 249.3f, 121.3f, 192.0f, 192.0f, 192.0f)
                lineTo(276.5f, 192.0f)
                curveTo(338.3f, 191.8f, 397.9f, 169.3f, 444.4f, 128.7f)
                lineTo(491.0f, 88.0f)
                curveTo(500.4f, 79.7f, 513.9f, 77.8f, 525.3f, 82.9f)
                close()
                moveTo(288.0f, 384.0f)
                lineTo(288.0f, 384.2f)
                curveTo(358.3f, 386.9f, 425.8f, 412.7f, 480.0f, 457.6f)
                lineTo(480.0f, 182.3f)
                curveTo(425.8f, 227.2f, 358.3f, 253.0f, 288.0f, 255.7f)
                lineTo(288.0f, 384.0f)
                close()
            }
        }
        .build()
        return _bullhorn!!
    }

private var _bullhorn: ImageVector? = null
