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

public val Fa.X: ImageVector
    get() {
        if (_x != null) {
            return _x!!
        }
        _x = Builder(name = "X", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(504.6f, 148.5f)
                curveTo(515.9f, 134.9f, 514.1f, 114.7f, 500.5f, 103.4f)
                curveTo(486.9f, 92.1f, 466.7f, 93.9f, 455.4f, 107.5f)
                lineTo(320.0f, 270.0f)
                lineTo(184.6f, 107.5f)
                curveTo(173.3f, 93.9f, 153.1f, 92.1f, 139.5f, 103.4f)
                curveTo(125.9f, 114.7f, 124.1f, 134.9f, 135.4f, 148.5f)
                lineTo(278.3f, 320.0f)
                lineTo(135.4f, 491.5f)
                curveTo(124.1f, 505.1f, 125.9f, 525.3f, 139.5f, 536.6f)
                curveTo(153.1f, 547.9f, 173.3f, 546.1f, 184.6f, 532.5f)
                lineTo(320.0f, 370.0f)
                lineTo(455.4f, 532.5f)
                curveTo(466.7f, 546.1f, 486.9f, 547.9f, 500.5f, 536.6f)
                curveTo(514.1f, 525.3f, 515.9f, 505.1f, 504.6f, 491.5f)
                lineTo(361.7f, 320.0f)
                lineTo(504.6f, 148.5f)
                close()
            }
        }
        .build()
        return _x!!
    }

private var _x: ImageVector? = null
