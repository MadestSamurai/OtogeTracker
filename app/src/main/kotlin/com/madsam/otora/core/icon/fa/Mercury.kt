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

public val Fa.Mercury: ImageVector
    get() {
        if (_mercury != null) {
            return _mercury!!
        }
        _mercury = Builder(name = "Mercury", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(245.0f, 60.0f)
                curveTo(234.0f, 46.2f, 213.8f, 44.0f, 200.1f, 55.0f)
                curveTo(186.4f, 66.0f, 184.1f, 86.2f, 195.1f, 100.0f)
                curveTo(202.9f, 109.7f, 211.7f, 118.5f, 221.5f, 126.1f)
                curveTo(174.7f, 157.7f, 144.0f, 211.3f, 144.0f, 272.0f)
                curveTo(144.0f, 358.3f, 206.1f, 430.1f, 288.0f, 445.1f)
                lineTo(288.0f, 480.0f)
                lineTo(256.0f, 480.0f)
                curveTo(238.3f, 480.0f, 224.0f, 494.3f, 224.0f, 512.0f)
                curveTo(224.0f, 529.7f, 238.3f, 544.0f, 256.0f, 544.0f)
                lineTo(288.0f, 544.0f)
                lineTo(288.0f, 576.0f)
                curveTo(288.0f, 593.7f, 302.3f, 608.0f, 320.0f, 608.0f)
                curveTo(337.7f, 608.0f, 352.0f, 593.7f, 352.0f, 576.0f)
                lineTo(352.0f, 544.0f)
                lineTo(384.0f, 544.0f)
                curveTo(401.7f, 544.0f, 416.0f, 529.7f, 416.0f, 512.0f)
                curveTo(416.0f, 494.3f, 401.7f, 480.0f, 384.0f, 480.0f)
                lineTo(352.0f, 480.0f)
                lineTo(352.0f, 445.1f)
                curveTo(433.9f, 430.1f, 496.0f, 358.3f, 496.0f, 272.0f)
                curveTo(496.0f, 211.3f, 465.3f, 157.7f, 418.5f, 126.1f)
                curveTo(428.3f, 118.4f, 437.2f, 109.7f, 444.9f, 100.0f)
                curveTo(456.0f, 86.2f, 453.7f, 66.1f, 439.9f, 55.0f)
                curveTo(426.1f, 43.9f, 406.0f, 46.2f, 395.0f, 60.0f)
                curveTo(377.4f, 82.0f, 350.3f, 96.0f, 320.0f, 96.0f)
                curveTo(289.7f, 96.0f, 262.7f, 82.0f, 245.0f, 60.0f)
                close()
                moveTo(320.0f, 384.0f)
                curveTo(258.1f, 384.0f, 208.0f, 333.9f, 208.0f, 272.0f)
                curveTo(208.0f, 210.1f, 258.1f, 160.0f, 320.0f, 160.0f)
                curveTo(381.9f, 160.0f, 432.0f, 210.1f, 432.0f, 272.0f)
                curveTo(432.0f, 333.8f, 381.9f, 384.0f, 320.1f, 384.0f)
                lineTo(320.0f, 384.0f)
                close()
            }
        }
        .build()
        return _mercury!!
    }

private var _mercury: ImageVector? = null
