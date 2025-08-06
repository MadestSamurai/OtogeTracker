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

public val Fa.Star: ImageVector
    get() {
        if (_star != null) {
            return _star!!
        }
        _star = Builder(name = "Star", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(341.5f, 45.1f)
                curveTo(337.4f, 37.1f, 329.1f, 32.0f, 320.1f, 32.0f)
                curveTo(311.1f, 32.0f, 302.8f, 37.1f, 298.7f, 45.1f)
                lineTo(225.1f, 189.3f)
                lineTo(65.2f, 214.7f)
                curveTo(56.3f, 216.1f, 48.9f, 222.4f, 46.1f, 231.0f)
                curveTo(43.3f, 239.6f, 45.6f, 249.0f, 51.9f, 255.4f)
                lineTo(166.3f, 369.9f)
                lineTo(141.1f, 529.8f)
                curveTo(139.7f, 538.7f, 143.4f, 547.7f, 150.7f, 553.0f)
                curveTo(158.0f, 558.3f, 167.6f, 559.1f, 175.7f, 555.0f)
                lineTo(320.1f, 481.6f)
                lineTo(464.4f, 555.0f)
                curveTo(472.4f, 559.1f, 482.1f, 558.3f, 489.4f, 553.0f)
                curveTo(496.7f, 547.7f, 500.4f, 538.8f, 499.0f, 529.8f)
                lineTo(473.7f, 369.9f)
                lineTo(588.1f, 255.4f)
                curveTo(594.5f, 249.0f, 596.7f, 239.6f, 593.9f, 231.0f)
                curveTo(591.1f, 222.4f, 583.8f, 216.1f, 574.8f, 214.7f)
                lineTo(415.0f, 189.3f)
                lineTo(341.5f, 45.1f)
                close()
            }
        }
        .build()
        return _star!!
    }

private var _star: ImageVector? = null
