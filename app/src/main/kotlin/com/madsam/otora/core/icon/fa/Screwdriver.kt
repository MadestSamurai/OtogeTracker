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

public val Fa.Screwdriver: ImageVector
    get() {
        if (_screwdriver != null) {
            return _screwdriver!!
        }
        _screwdriver = Builder(name = "Screwdriver", defaultWidth = 640.0.dp, defaultHeight =
                640.0.dp, viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(384.1f, 210.7f)
                lineTo(384.1f, 161.1f)
                curveTo(384.1f, 150.4f, 389.4f, 140.4f, 398.3f, 134.5f)
                lineTo(517.2f, 55.3f)
                curveTo(523.5f, 51.1f, 532.0f, 51.9f, 537.4f, 57.3f)
                lineTo(582.8f, 102.8f)
                curveTo(588.2f, 108.2f, 589.0f, 116.6f, 584.8f, 123.0f)
                lineTo(505.6f, 241.8f)
                curveTo(499.7f, 250.7f, 489.7f, 256.0f, 479.0f, 256.0f)
                lineTo(429.4f, 256.0f)
                lineTo(338.7f, 346.7f)
                curveTo(353.7f, 380.0f, 347.6f, 420.6f, 320.2f, 448.0f)
                lineTo(194.1f, 574.1f)
                curveTo(175.4f, 592.8f, 145.0f, 592.8f, 126.2f, 574.1f)
                lineTo(66.1f, 513.9f)
                curveTo(47.4f, 495.2f, 47.4f, 464.8f, 66.1f, 446.0f)
                lineTo(192.1f, 320.0f)
                curveTo(219.5f, 292.6f, 260.0f, 286.4f, 293.4f, 301.5f)
                lineTo(384.1f, 210.8f)
                close()
            }
        }
        .build()
        return _screwdriver!!
    }

private var _screwdriver: ImageVector? = null
