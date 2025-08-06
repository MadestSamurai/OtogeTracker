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

public val Fa.Gavel: ImageVector
    get() {
        if (_gavel != null) {
            return _gavel!!
        }
        _gavel = Builder(name = "Gavel", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(201.6f, 217.4f)
                lineTo(182.9f, 198.7f)
                curveTo(170.4f, 186.2f, 170.4f, 165.9f, 182.9f, 153.4f)
                lineTo(297.6f, 38.6f)
                curveTo(310.1f, 26.1f, 330.4f, 26.1f, 342.9f, 38.6f)
                lineTo(361.6f, 57.4f)
                curveTo(374.1f, 69.9f, 374.1f, 90.2f, 361.6f, 102.7f)
                lineTo(246.9f, 217.4f)
                curveTo(234.4f, 229.9f, 214.1f, 229.9f, 201.6f, 217.4f)
                close()
                moveTo(308.0f, 275.7f)
                lineTo(276.6f, 244.3f)
                lineTo(388.6f, 132.3f)
                lineTo(508.0f, 251.7f)
                lineTo(396.0f, 363.7f)
                lineTo(364.6f, 332.3f)
                lineTo(132.6f, 564.3f)
                curveTo(117.0f, 579.9f, 91.7f, 579.9f, 76.0f, 564.3f)
                curveTo(60.3f, 548.7f, 60.4f, 523.4f, 76.0f, 507.7f)
                lineTo(308.0f, 275.7f)
                close()
                moveTo(422.9f, 438.6f)
                curveTo(410.4f, 426.1f, 410.4f, 405.8f, 422.9f, 393.3f)
                lineTo(537.6f, 278.6f)
                curveTo(550.1f, 266.1f, 570.4f, 266.1f, 582.9f, 278.6f)
                lineTo(601.6f, 297.3f)
                curveTo(614.1f, 309.8f, 614.1f, 330.1f, 601.6f, 342.6f)
                lineTo(486.9f, 457.4f)
                curveTo(474.4f, 469.9f, 454.1f, 469.9f, 441.6f, 457.4f)
                lineTo(422.9f, 438.7f)
                close()
            }
        }
        .build()
        return _gavel!!
    }

private var _gavel: ImageVector? = null
