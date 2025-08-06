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

public val Fa.Fire: ImageVector
    get() {
        if (_fire != null) {
            return _fire!!
        }
        _fire = Builder(name = "Fire", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(256.5f, 37.6f)
                curveTo(265.8f, 29.8f, 279.5f, 30.1f, 288.4f, 38.5f)
                curveTo(300.7f, 50.1f, 311.7f, 62.9f, 322.3f, 75.9f)
                curveTo(335.8f, 92.4f, 352.0f, 114.2f, 367.6f, 140.1f)
                curveTo(372.8f, 133.3f, 377.6f, 127.3f, 381.8f, 122.2f)
                curveTo(382.9f, 120.9f, 384.0f, 119.5f, 385.1f, 118.1f)
                curveTo(393.0f, 108.3f, 402.8f, 96.0f, 415.9f, 96.0f)
                curveTo(429.3f, 96.0f, 438.7f, 107.9f, 446.7f, 118.1f)
                curveTo(448.0f, 119.8f, 449.3f, 121.4f, 450.6f, 122.9f)
                curveTo(460.9f, 135.3f, 474.6f, 153.2f, 488.3f, 175.3f)
                curveTo(515.5f, 219.2f, 543.9f, 281.7f, 543.9f, 351.9f)
                curveTo(543.9f, 475.6f, 443.6f, 575.9f, 319.9f, 575.9f)
                curveTo(196.2f, 575.9f, 96.0f, 475.7f, 96.0f, 352.0f)
                curveTo(96.0f, 260.9f, 137.1f, 182.0f, 176.5f, 127.0f)
                curveTo(196.4f, 99.3f, 216.2f, 77.1f, 231.1f, 61.9f)
                curveTo(239.3f, 53.5f, 247.6f, 45.2f, 256.6f, 37.7f)
                close()
                moveTo(321.7f, 480.0f)
                curveTo(347.0f, 480.0f, 369.4f, 473.0f, 390.5f, 459.0f)
                curveTo(432.6f, 429.6f, 443.9f, 370.8f, 418.6f, 324.6f)
                curveTo(414.1f, 315.6f, 402.6f, 315.0f, 396.1f, 322.6f)
                lineTo(370.9f, 351.9f)
                curveTo(364.3f, 359.5f, 352.4f, 359.3f, 346.2f, 351.4f)
                curveTo(328.9f, 329.3f, 297.1f, 289.0f, 280.9f, 268.4f)
                curveTo(275.5f, 261.5f, 265.7f, 260.4f, 259.4f, 266.5f)
                curveTo(241.1f, 284.3f, 207.9f, 323.3f, 207.9f, 370.8f)
                curveTo(207.9f, 439.4f, 258.5f, 480.0f, 321.6f, 480.0f)
                close()
            }
        }
        .build()
        return _fire!!
    }

private var _fire: ImageVector? = null
