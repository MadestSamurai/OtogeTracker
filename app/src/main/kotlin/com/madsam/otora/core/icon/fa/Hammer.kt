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

public val Fa.Hammer: ImageVector
    get() {
        if (_hammer != null) {
            return _hammer!!
        }
        _hammer = Builder(name = "Hammer", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(246.9f, 82.3f)
                lineTo(271.0f, 67.8f)
                curveTo(292.6f, 54.8f, 317.3f, 48.0f, 342.5f, 48.0f)
                curveTo(379.3f, 48.0f, 414.7f, 62.6f, 440.7f, 88.7f)
                lineTo(504.6f, 152.6f)
                curveTo(519.6f, 167.6f, 528.0f, 188.0f, 528.0f, 209.2f)
                lineTo(528.0f, 240.1f)
                lineTo(547.7f, 259.8f)
                lineTo(547.7f, 259.8f)
                curveTo(563.3f, 244.2f, 588.6f, 244.2f, 604.3f, 259.8f)
                curveTo(620.0f, 275.4f, 619.9f, 300.7f, 604.3f, 316.4f)
                lineTo(540.3f, 380.4f)
                curveTo(524.7f, 396.0f, 499.4f, 396.0f, 483.7f, 380.4f)
                curveTo(468.0f, 364.8f, 468.1f, 339.5f, 483.7f, 323.8f)
                lineTo(464.0f, 304.0f)
                lineTo(433.1f, 304.0f)
                curveTo(411.9f, 304.0f, 391.5f, 295.6f, 376.5f, 280.6f)
                lineTo(327.4f, 231.5f)
                curveTo(312.4f, 216.5f, 304.0f, 196.1f, 304.0f, 174.9f)
                lineTo(304.0f, 162.2f)
                curveTo(304.0f, 151.0f, 298.1f, 140.5f, 288.5f, 134.8f)
                lineTo(246.9f, 109.8f)
                curveTo(236.5f, 103.6f, 236.5f, 88.6f, 246.9f, 82.4f)
                close()
                moveTo(50.7f, 466.7f)
                lineTo(272.8f, 244.6f)
                lineTo(363.3f, 335.1f)
                lineTo(141.2f, 557.2f)
                curveTo(116.2f, 582.2f, 75.7f, 582.2f, 50.7f, 557.2f)
                curveTo(25.7f, 532.2f, 25.7f, 491.7f, 50.7f, 466.7f)
                close()
            }
        }
        .build()
        return _hammer!!
    }

private var _hammer: ImageVector? = null
