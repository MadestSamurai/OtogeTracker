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

public val Fa.Crown: ImageVector
    get() {
        if (_crown != null) {
            return _crown!!
        }
        _crown = Builder(name = "Crown", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(345.0f, 151.2f)
                curveTo(354.2f, 143.9f, 360.0f, 132.6f, 360.0f, 120.0f)
                curveTo(360.0f, 97.9f, 342.1f, 80.0f, 320.0f, 80.0f)
                curveTo(297.9f, 80.0f, 280.0f, 97.9f, 280.0f, 120.0f)
                curveTo(280.0f, 132.6f, 285.9f, 143.9f, 295.0f, 151.2f)
                lineTo(226.6f, 258.8f)
                curveTo(216.6f, 274.5f, 195.3f, 278.4f, 180.4f, 267.2f)
                lineTo(120.9f, 222.7f)
                curveTo(125.4f, 216.3f, 128.0f, 208.4f, 128.0f, 200.0f)
                curveTo(128.0f, 177.9f, 110.1f, 160.0f, 88.0f, 160.0f)
                curveTo(65.9f, 160.0f, 48.0f, 177.9f, 48.0f, 200.0f)
                curveTo(48.0f, 221.8f, 65.5f, 239.6f, 87.2f, 240.0f)
                lineTo(119.8f, 457.5f)
                curveTo(124.5f, 488.8f, 151.4f, 512.0f, 183.1f, 512.0f)
                lineTo(456.9f, 512.0f)
                curveTo(488.6f, 512.0f, 515.5f, 488.8f, 520.2f, 457.5f)
                lineTo(552.8f, 240.0f)
                curveTo(574.5f, 239.6f, 592.0f, 221.8f, 592.0f, 200.0f)
                curveTo(592.0f, 177.9f, 574.1f, 160.0f, 552.0f, 160.0f)
                curveTo(529.9f, 160.0f, 512.0f, 177.9f, 512.0f, 200.0f)
                curveTo(512.0f, 208.4f, 514.6f, 216.3f, 519.1f, 222.7f)
                lineTo(459.7f, 267.3f)
                curveTo(444.8f, 278.5f, 423.5f, 274.6f, 413.5f, 258.9f)
                lineTo(345.0f, 151.2f)
                close()
            }
        }
        .build()
        return _crown!!
    }

private var _crown: ImageVector? = null
