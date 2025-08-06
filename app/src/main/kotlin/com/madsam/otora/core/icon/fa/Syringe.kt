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

public val Fa.Syringe: ImageVector
    get() {
        if (_syringe != null) {
            return _syringe!!
        }
        _syringe = Builder(name = "Syringe", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(529.5f, 47.0f)
                curveTo(520.1f, 37.6f, 504.9f, 37.6f, 495.6f, 47.0f)
                curveTo(486.3f, 56.4f, 486.2f, 71.6f, 495.6f, 80.9f)
                lineTo(510.6f, 95.9f)
                lineTo(464.5f, 142.0f)
                lineTo(401.5f, 79.0f)
                curveTo(392.1f, 69.6f, 376.9f, 69.6f, 367.6f, 79.0f)
                curveTo(358.3f, 88.4f, 358.2f, 103.6f, 367.6f, 112.9f)
                lineTo(374.6f, 119.9f)
                lineTo(296.5f, 198.0f)
                lineTo(337.5f, 239.0f)
                curveTo(346.9f, 248.4f, 346.9f, 263.6f, 337.5f, 272.9f)
                curveTo(328.1f, 282.2f, 312.9f, 282.3f, 303.6f, 272.9f)
                lineTo(262.6f, 231.9f)
                lineTo(216.5f, 278.0f)
                lineTo(257.5f, 319.0f)
                curveTo(266.9f, 328.4f, 266.9f, 343.6f, 257.5f, 352.9f)
                curveTo(248.1f, 362.2f, 232.9f, 362.3f, 223.6f, 352.9f)
                lineTo(182.6f, 311.9f)
                lineTo(144.9f, 349.6f)
                curveTo(134.4f, 360.1f, 128.5f, 374.3f, 128.5f, 389.2f)
                lineTo(128.5f, 478.0f)
                lineTo(71.5f, 535.0f)
                curveTo(62.1f, 544.4f, 62.1f, 559.6f, 71.5f, 568.9f)
                curveTo(80.9f, 578.2f, 96.1f, 578.3f, 105.4f, 568.9f)
                lineTo(162.4f, 511.9f)
                lineTo(251.2f, 511.9f)
                curveTo(266.1f, 511.9f, 280.3f, 506.0f, 290.8f, 495.5f)
                lineTo(520.5f, 265.8f)
                lineTo(527.5f, 272.8f)
                curveTo(536.9f, 282.2f, 552.1f, 282.2f, 561.4f, 272.8f)
                curveTo(570.7f, 263.4f, 570.8f, 248.2f, 561.4f, 238.9f)
                lineTo(498.4f, 175.9f)
                lineTo(544.5f, 129.8f)
                lineTo(559.5f, 144.8f)
                curveTo(568.9f, 154.2f, 584.1f, 154.2f, 593.4f, 144.8f)
                curveTo(602.7f, 135.4f, 602.8f, 120.2f, 593.4f, 110.9f)
                lineTo(529.4f, 46.9f)
                close()
            }
        }
        .build()
        return _syringe!!
    }

private var _syringe: ImageVector? = null
