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

public val Fa.Cube: ImageVector
    get() {
        if (_cube != null) {
            return _cube!!
        }
        _cube = Builder(name = "Cube", defaultWidth = 640.0.dp, defaultHeight = 640.0.dp,
                viewportWidth = 640.0f, viewportHeight = 640.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(288.3f, 61.5f)
                curveTo(308.1f, 50.1f, 332.5f, 50.1f, 352.3f, 61.5f)
                lineTo(528.2f, 163.0f)
                curveTo(548.0f, 174.4f, 560.2f, 195.6f, 560.2f, 218.4f)
                lineTo(560.2f, 421.4f)
                curveTo(560.2f, 444.3f, 548.0f, 465.4f, 528.2f, 476.8f)
                lineTo(352.3f, 578.5f)
                curveTo(332.5f, 589.9f, 308.1f, 589.9f, 288.3f, 578.5f)
                lineTo(112.5f, 477.0f)
                curveTo(92.7f, 465.6f, 80.5f, 444.4f, 80.5f, 421.6f)
                lineTo(80.5f, 218.6f)
                curveTo(80.5f, 195.7f, 92.7f, 174.6f, 112.5f, 163.2f)
                lineTo(288.3f, 61.5f)
                close()
                moveTo(496.1f, 421.5f)
                lineTo(496.1f, 255.4f)
                lineTo(352.3f, 338.4f)
                lineTo(352.3f, 504.5f)
                lineTo(496.1f, 421.5f)
                close()
            }
        }
        .build()
        return _cube!!
    }

private var _cube: ImageVector? = null
