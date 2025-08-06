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

public val Fa.G: ImageVector
    get() {
        if (_g != null) {
            return _g!!
        }
        _g = Builder(name = "G", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp, viewportWidth =
                640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(320.0f, 160.0f)
                curveTo(231.6f, 160.0f, 160.0f, 231.6f, 160.0f, 320.0f)
                curveTo(160.0f, 408.4f, 231.6f, 480.0f, 320.0f, 480.0f)
                curveTo(397.4f, 480.0f, 462.0f, 425.0f, 476.8f, 352.0f)
                lineTo(352.0f, 352.0f)
                curveTo(334.3f, 352.0f, 320.0f, 337.7f, 320.0f, 320.0f)
                curveTo(320.0f, 302.3f, 334.3f, 288.0f, 352.0f, 288.0f)
                lineTo(496.0f, 288.0f)
                curveTo(521.8f, 288.0f, 545.6f, 309.4f, 543.2f, 338.6f)
                curveTo(533.7f, 453.6f, 437.4f, 544.0f, 320.0f, 544.0f)
                curveTo(196.3f, 544.0f, 96.0f, 443.7f, 96.0f, 320.0f)
                curveTo(96.0f, 196.3f, 196.3f, 96.0f, 320.0f, 96.0f)
                curveTo(377.4f, 96.0f, 429.7f, 117.6f, 469.3f, 153.0f)
                curveTo(482.5f, 164.8f, 483.6f, 185.0f, 471.8f, 198.2f)
                curveTo(460.0f, 211.4f, 439.8f, 212.5f, 426.6f, 200.7f)
                curveTo(398.3f, 175.4f, 361.0f, 160.0f, 320.0f, 160.0f)
                close()
            }
        }
        .build()
        return _g!!
    }

private var _g: ImageVector? = null
